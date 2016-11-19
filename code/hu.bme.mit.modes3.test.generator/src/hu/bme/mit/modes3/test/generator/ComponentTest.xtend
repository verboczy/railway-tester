package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class ComponentTest implements ITestGenerator {
	
	override generate(Model model) {
		var caseDescription = model.caseDescription
		val elements = "elements"
		val instanceContainer = "InstanceContainer" // val -> final
		val straight = "STRAIGHT"
		//val divergent = "DIVERGENT"
		//val top = "TOP"
		//val free = "FREE"
		val occupied = "OCCUPIED"
		//val enabled = "ENABLED"
		val disabled = "DISABLED"
		val raiseStraight = "raiseStraight"
		val raiseDivergent = "raiseDivergent"
		val raiseOccupyStr = "raiseOccupyStr"
		val raiseOccupyDiv = "raiseOccupyDiv"
		val raiseOccupyTop = "raiseOccupyTop"
		val runFullCycle = "runFullCycle"
		val assertEquals = "assertEquals"
		val getSectionStr = "getSectionStr"
		val getSectionDiv = "getSectionDiv"
		val getSectionTop = "getSectionTop"
		val isStateActive = "isStateActive"
		val stateStop = "State.main_Stop"
		
		return '''
		package org.yakindu.scr;
		
		import static org.junit.Assert.assertEquals;
		
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Test;
		import org.yakindu.scr.«instanceContainer»;
		import org.yakindu.scr.section2.Section2Statemachine.State;
		
		public class ComponentTest {
			private static «instanceContainer» «elements»;
			
			@BeforeClass
			public static void init() {
				«elements» = new «instanceContainer»();
			}
			
			@Before
			public void reset() {
				«elements» = new «instanceContainer»();
			}
						
			«FOR test : caseDescription»
			@Test			
			// «test.comment.comment»
			public void «test.caseName.name»() {
				«FOR component : test.components»
				«IF component.turnout.turnoutState == straight»
				«elements».«raiseStraight»();
				«ELSE»
				«elements».«raiseDivergent»();
				«ENDIF»
				«IF component.section.straightSection.straightSectionState == occupied»
				«elements».«raiseOccupyStr»();
				«ENDIF»
				«IF component.section.divergentSection.divergentSectionState == occupied»
				«elements».«raiseOccupyDiv»();
				«ENDIF»
				«IF component.section.topSection.topSectionState == occupied»
				«elements».«raiseOccupyTop»(); 
				«ENDIF»
				«ENDFOR»
				«elements».«runFullCycle»();
				«FOR expected : test.expect»
				«IF expected.straightExpectation.straightExpectedState == disabled»
				«assertEquals»(true, «elements».«getSectionStr»().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSectionStr»().«isStateActive»(«stateStop»));
				«ENDIF»
				«IF expected.divergentExpectation.divergentExpectedState == disabled»
				«assertEquals»(true, «elements».«getSectionDiv»().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSectionDiv»().«isStateActive»(«stateStop»));
				«ENDIF»
				«IF expected.topExpectation.topExpectedState == disabled»
				«assertEquals»(true, «elements».«getSectionTop»().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSectionTop»().«isStateActive»(«stateStop»));
				«ENDIF»
				«ENDFOR»				
			}
			
			«ENDFOR»
		}
		'''
	}
	
}