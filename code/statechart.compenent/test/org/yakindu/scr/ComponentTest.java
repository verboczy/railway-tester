package org.yakindu.scr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.yakindu.scr.InstanceContainer;
import org.yakindu.scr.section2.Section2Statemachine.State;

public class ComponentTest {
	private static InstanceContainer elements;
	
	@BeforeClass
	public static void init() {
		elements = new InstanceContainer();
	}
	
	@Before
	public void reset() {
		elements = new InstanceContainer();
	}
				
	@Test			
	// STR occupied, turnout is STR, STR can go
	public void test1() {
		elements.raiseStraight();
		elements.raiseOccupyStr();
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR occupied, turnout is DIV, STR cannot go
	public void test2() {
		elements.raiseDivergent();
		elements.raiseOccupyStr();
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// DIV occupied, turnout is STR, DIV cannot go
	public void test3() {
		elements.raiseStraight();
		elements.raiseOccupyDiv();
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// DIV occupied, turnout is DIV, DIV can go
	public void test4() {
		elements.raiseDivergent();
		elements.raiseOccupyDiv();
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// TOP is occupied, turnout is STR,TOP can go
	public void test5() {
		elements.raiseStraight();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// TOP is occupied, turnout is DIV,TOP can go
	public void test6() {
		elements.raiseDivergent();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and DIV are occupied, turnout is STR, STR can go, but DIV cannot
	public void test7() {
		elements.raiseStraight();
		elements.raiseOccupyStr();
		elements.raiseOccupyDiv();
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and DIV are occupied, turnout is DIV, DIV can go, but STR cannot
	public void test8() {
		elements.raiseDivergent();
		elements.raiseOccupyStr();
		elements.raiseOccupyDiv();
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and TOP are occupied, turnout is STR, STR and TOP cannot go
	public void test9() {
		elements.raiseStraight();
		elements.raiseOccupyStr();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and TOP are occupied, turnout is DIV, TOP can go, but STR cannot
	public void test10() {
		elements.raiseDivergent();
		elements.raiseOccupyStr();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// DIV and TOP are occupied, turnout is STR, TOP can go, but DIV cannot
	public void test11() {
		elements.raiseStraight();
		elements.raiseOccupyDiv();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(false, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// DIV and TOP are occupied, turnout is DIV, DIV and TOP cannot go
	public void test12() {
		elements.raiseDivergent();
		elements.raiseOccupyDiv();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(false, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and DIV and TOP are occupied, turnout is STR, everything is DISABLED
	public void test13() {
		elements.raiseStraight();
		elements.raiseOccupyStr();
		elements.raiseOccupyDiv();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
	@Test			
	// STR and DIV and TOP are occupied, turnout is DIV, everything is DISABLED
	public void test14() {
		elements.raiseDivergent();
		elements.raiseOccupyStr();
		elements.raiseOccupyDiv();
		elements.raiseOccupyTop(); 
		elements.runFullCycle();
		assertEquals(true, elements.getSectionStr().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionDiv().isStateActive(State.main_Stop));
		assertEquals(true, elements.getSectionTop().isStateActive(State.main_Stop));
	}
	
}
