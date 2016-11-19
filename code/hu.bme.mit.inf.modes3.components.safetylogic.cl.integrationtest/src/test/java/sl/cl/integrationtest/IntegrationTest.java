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

public class IntegrationTest {
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
		
		for(int i = 1; i <= 6; i++) {
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
	}
	
	@Test
	// STR occupied, turnout is STR, STR can go
	public void test1() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR occupied, turnout is DIV, STR cannot go
	public void test2() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// DIV occupied, turnout is STR, DIV cannot go
	public void test3() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(10, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// DIV occupied, turnout is DIV, DIV can go
	public void test4() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// TOP is occupied, turnout is STR,TOP can go
	public void test5() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// TOP is occupied, turnout is DIV,TOP can go
	public void test6() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and DIV are occupied, turnout is STR, STR can go, but DIV cannot
	public void test7() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(10, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and DIV are occupied, turnout is DIV, DIV can go, but STR cannot
	public void test8() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and TOP are occupied, turnout is STR, STR and TOP cannot go
	public void test9() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		sectionStates.put(8, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and TOP are occupied, turnout is DIV, TOP can go, but STR cannot
	public void test10() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// DIV and TOP are occupied, turnout is STR, TOP can go, but DIV cannot
	public void test11() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(10, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// DIV and TOP are occupied, turnout is DIV, DIV and TOP cannot go
	public void test12() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(10, SegmentState.DISABLED.toString());
		sectionStates.put(8, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and DIV and TOP are occupied, turnout is STR, everything is DISABLED
	public void test13() {
		component.changeTurnout(5, TurnoutState.STRAIGHT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		sectionStates.put(10, SegmentState.DISABLED.toString());
		sectionStates.put(8, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	@Test
	// STR and DIV and TOP are occupied, turnout is DIV, everything is DISABLED
	public void test14() {
		component.changeTurnout(5, TurnoutState.DIVERGENT);
		component.changeOccupancy(11, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(11, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(10, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(10, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		component.changeOccupancy(8, SegmentOccupancy.OCCUPIED);
		sectionOccupancies.replace(8, SegmentOccupancy.OCCUPIED.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		sectionStates.put(11, SegmentState.DISABLED.toString());
		sectionStates.put(10, SegmentState.DISABLED.toString());
		sectionStates.put(8, SegmentState.DISABLED.toString());
		for (Integer id : sectionIdList) {
			if (sectionStates.containsKey(id)) {
				assertEquals(sectionStates.get(id), stack.getDispatcher().getSectionStateMap().get(id));
			}
		}
	}
	
}
