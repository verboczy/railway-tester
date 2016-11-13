package sl.cl.integrationtest;

import org.slf4j.ILoggerFactory;

import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;


public class DemonstratorComponent extends AbstractCommunicationComponent {

	private ILoggerFactory loggerFactory;
	private TrackCommunicationServiceLocator trackCommunication;
	
	public DemonstratorComponent(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory);
		this.loggerFactory = factory;
	}
	
	public void createAndInitializeDemonstrator() {
		trackCommunication = new TrackCommunicationServiceLocator(super.communication, loggerFactory);	
	}
	
	public void changeTurnout(int id, TurnoutState state) {
		trackCommunication.getTrackElementStateSender().sendTurnoutState(id, state);
	}
	
	public void changeOccupancy (int id, SegmentOccupancy occupancy) {
		trackCommunication.getTrackElementStateSender().sendSegmentOccupation(id, occupancy);
	}
	
	public void changeSection(int id, SegmentState state) {
		trackCommunication.getTrackElementStateSender().sendSegmentState(id, state);
	}

	@Override
	public void run() {
		super.communication.start();
	}

}
