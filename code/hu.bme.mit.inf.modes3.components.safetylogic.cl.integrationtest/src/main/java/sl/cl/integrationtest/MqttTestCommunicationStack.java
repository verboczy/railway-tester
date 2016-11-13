package sl.cl.integrationtest;

import org.slf4j.helpers.NOPLoggerFactory;

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.transports.common.Transport;

/**
 * MqttTestCommunicationStack extends CommunicationStack. It has only a constructor, which has 
 * 2 parameters. The first one is MessagingService parameter, the second is a Transport parameter.
 * It calls the constructor of the CommunicationStack. It is needed, because the other stacks 
 * (e.g. YakinduCommunicationStack) are not convenient for the test. 
 * @author vkristof
 *
 */
public class MqttTestCommunicationStack extends CommunicationStack {
	
	private static MqttTestMessageDispatcher dispatcher = new MqttTestMessageDispatcher(new NOPLoggerFactory());
	
	protected MqttTestCommunicationStack(MessagingService mms, Transport transport) {		
		super(mms, transport, dispatcher);
	}
	
	public MqttTestMessageDispatcher getDispatcher() {
		return dispatcher;
	}
	
}
