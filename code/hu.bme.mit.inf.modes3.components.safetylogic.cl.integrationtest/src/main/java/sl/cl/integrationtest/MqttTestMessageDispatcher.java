package sl.cl.integrationtest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message;

public class MqttTestMessageDispatcher extends ProtobufMessageDispatcher {

	private Logger logger;
	
	private Map<Integer, String> turnoutStateMap = new HashMap<Integer, String>();
	private Map<Integer, String> sectionOccupancyMap = new HashMap<Integer, String>();
	private Map<Integer, String> sectionStateMap = new HashMap<Integer, String>();

	public MqttTestMessageDispatcher(ILoggerFactory factory) {
		super(factory);	
		this.logger = factory.getLogger(this.getClass().getName());
	}
		
	@Override
	public void dispatchMessage(byte[] rawMessage) {
		
		try {
			Message message = Message.parseFrom(rawMessage);
			
			switch (message.getType()) {	
			
				case TURNOUT_STATE:
					int turnoutID = message.getTurnoutState().getTurnoutID();
					String turnoutState = message.getTurnoutState().getState().toString();
					turnoutStateMap.put(turnoutID, turnoutState);
					System.out.println("Turnout state: " + turnoutState + ", turnoutID = " + turnoutID);
					break; 
				case SEGMENT_OCCUPANCY:
					int segmentOccID = message.getSegmentOccupancy().getSegmentID();
					String segmentOccupancy = message.getSegmentOccupancy().getState().toString();
					sectionOccupancyMap.put(segmentOccID, segmentOccupancy);
					System.out.println("Segment occupancy: " + segmentOccupancy + ", segmentID = " + segmentOccID);
					break;
				case SEGMENT_STATE:	
					int segmentStateID = message.getSegmentState().getSegmentID();
					String segmentState = message.getSegmentState().getState().toString();	
					sectionStateMap.put(segmentStateID, segmentState);
					System.out.println("Segment state: " + segmentState +", segmentID = " + segmentStateID);
					break;		
									
				case SEGMENT_COMMAND:
					int segmentID = message.getSegmentCommand().getSegmentID();					
					String segmentCommand = message.getSegmentCommand().getState().toString();
					sectionStateMap.put(segmentID, segmentCommand);
					System.out.println("Segment command: "+ segmentCommand + " ID: " + segmentID);
					break;
				default:
					return;
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}		
	}

	public Map<Integer, String> getTurnoutStateMap() {
		return turnoutStateMap;
	}

	public Map<Integer, String> getSectionOccupancyMap() {
		return sectionOccupancyMap;
	}

	public Map<Integer, String> getSectionStateMap() {
		return sectionStateMap;
	}
	
}
