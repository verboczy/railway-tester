package sl.cl.integrationtest;

import org.slf4j.impl.SimpleLoggerFactory;

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport;
import hu.bme.mit.inf.modes3.transports.mqtt.conf.MQTTTransportConfigurationFactory;



public class InitializerMQTT  {
	
	private SimpleLoggerFactory loggerFactory;
	private MessagingService messagingService;
	private MQTTTransport mqttTransport;
	private MqttTestCommunicationStack stack;
	private DemonstratorComponent component;
	
	public InitializerMQTT() {	
		loggerFactory = new SimpleLoggerFactory(); 		
		messagingService = new MessagingService(loggerFactory);
		mqttTransport = new MQTTTransport(MQTTTransportConfigurationFactory.createLocalTransportConfig(), loggerFactory);
		stack = new MqttTestCommunicationStack(messagingService,  mqttTransport);
		component = new DemonstratorComponent(stack, loggerFactory);
	}

	public DemonstratorComponent getComponent() {
		return this.component;
	}
	
	public MqttTestCommunicationStack getStack() {
		return this.stack;
	}
	
	public void initialize() {	
		component.createAndInitializeDemonstrator();		
	}
}
