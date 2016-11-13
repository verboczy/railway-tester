package sl.cl.integrationtest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;

public class MqttIntegrationTest {

	private static InitializerMQTT sut;
	private static DemonstratorComponent component;
	private static MqttTestCommunicationStack stack;
	
	private static Map<Integer, String> turnoutStates;
	private static Map<Integer, String> sectionOccupancies;
	private static Map<Integer, String> sectionStates;
	
	private static List<Integer> turnoutIdList;
	private static List<Integer> sectionIdList;
	
	@BeforeClass
	public static void init() {
		sut = new InitializerMQTT();
		component = sut.getComponent();
		stack = sut.getStack();
		
		turnoutStates = new HashMap<Integer, String>();
		sectionOccupancies = new HashMap<Integer, String>();
		sectionStates = new HashMap<Integer, String>();
		
		turnoutIdList = new ArrayList<Integer>();
		sectionIdList = new ArrayList<Integer>();
		
		for (int i = 1; i <= 6; i++) {
			turnoutIdList.add(i);
		}
		
		sectionIdList.add(1);
		sectionIdList.add(2);
		sectionIdList.add(4);
		sectionIdList.add(5);
		sectionIdList.add(6);
		sectionIdList.add(7);
		sectionIdList.add(8);
		sectionIdList.add(10);
		sectionIdList.add(11);
		sectionIdList.add(12);
		sectionIdList.add(13);
		sectionIdList.add(15);
		sectionIdList.add(17);
		sectionIdList.add(18);
		sectionIdList.add(19);
		sectionIdList.add(20);
		sectionIdList.add(22);
		sectionIdList.add(23);
		sectionIdList.add(24);
		sectionIdList.add(26);
		sectionIdList.add(27);
		sectionIdList.add(29);
		sectionIdList.add(30);
		sectionIdList.add(31);		
		
		sut.initialize();
	}
	
	@Before
	// In the initial state the turnouts are straight, the sections are free and enabled.
	public void reset() {
		turnoutStates.clear();
		sectionOccupancies.clear();
		sectionStates.clear();
		
		
		for (Integer turnoutId : turnoutIdList) {
			component.changeTurnout(turnoutId, TurnoutState.STRAIGHT);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*
		for (Integer sectionId : sectionIdList) {
			component.changeOccupancy(sectionId, SegmentOccupancy.FREE);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (Integer sectionId : sectionIdList) {
			component.changeSection(sectionId, SegmentState.ENABLED);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Get the initial state maps.
		turnoutStates = stack.getDispatcher().getTurnoutStateMap();
		sectionOccupancies = stack.getDispatcher().getSectionOccupancyMap();
		sectionStates = stack.getDispatcher().getSectionStateMap();
		*/
	}
	
	
	@Test
	public void test1() {
		
		component.changeOccupancy(12, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(12, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		component.changeOccupancy(15, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(15, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sectionStates.clear();
		sectionStates.put(12, SegmentState.DISABLED.toString());
		sectionStates.put(15, SegmentState.DISABLED.toString());
		
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));				
			}
		}	
	}
}
