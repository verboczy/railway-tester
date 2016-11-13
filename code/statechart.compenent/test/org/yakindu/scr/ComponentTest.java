package org.yakindu.scr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.yakindu.scr.InstanceContainer;
import org.yakindu.scr.section2.Section2Statemachine.State;

/**
 * This test was created by hand. In order to test the connection of the state machines. 
 * @author vkristof
 *
 */
public class ComponentTest {

	// The component, which contains 6 sections, and 1 turnout.
	private static InstanceContainer elements;
	

	@BeforeClass
	// Initialization at the beginning.
	public static void init() {
		elements = new InstanceContainer();
	}
			
		
	@Before
	// Resets the state machines before each test.
	public void reset() {
		elements = new InstanceContainer();
	}

	
	@Test
	// Turnout is straight, top is occupied, so top should be occupied.
	public void testTopOccupied() {
		elements.raiseStraight();
		elements.raiseOccupyTop();
		
		elements.runFullCycle();
		
		boolean boo = elements.getSectionTop().isStateActive(State.main_Occupied);
		assertEquals(true, boo);
	}
	
	@Test
	// Turnout is divergent, divergent is occupied, so divergent should be occupied.
	public void testDivOccupied() {
		elements.raiseDivergent();
		elements.raiseOccupyDiv();
		
		elements.runFullCycle();
		
		boolean boo = elements.getSectionDiv().isStateActive(State.main_Occupied);
		assertEquals(true, boo);
	}
	
	@Test
	// Turnout is straight, straight is occupied, so straight should be occupied.
	public void testStrOccupied() {
		elements.raiseStraight();
		elements.raiseOccupyStr();
		
		elements.runFullCycle();
		
		boolean result = elements.getSectionStr().isStateActive(State.main_Occupied);
		assertEquals(true, result);
	}
	
	@Test
	// Turnout is divergent, top is occupied, so top should be occupied.
	public void testTopOccupiedTurnoutDiv() {
		elements.raiseDivergent();
		elements.raiseOccupyTop();
		
		elements.runFullCycle();
		
		boolean result = elements.getSectionTop().isStateActive(State.main_Occupied);
		assertEquals(true, result);
	}
	
	@Test
	// Turnout is straight, divergent is occupied, so divergent should be stopped.
	public void testDivStopped() {
		elements.raiseStraight();
		elements.raiseOccupyDiv();
		
		elements.runFullCycle();
		
		boolean result = elements.getSectionDiv().isStateActive(State.main_Stop);
		assertEquals(true, result);
	}
	
	@Test
	// Turnout is divergent, straight is occupied, so straight should be stopped.
	public void testStrStopped() {
		elements.raiseDivergent();
		elements.raiseOccupyStr();
		
		elements.runFullCycle();
		
		boolean result = elements.getSectionStr().isStateActive(State.main_Stop);
		assertEquals(true, result);
	}
}
