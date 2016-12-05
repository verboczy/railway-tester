package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class ComponentTestTwoTurnouts implements ITestGenerator {
	
	override generate(Model model) {
		var caseDescription = model.caseDescription
		val elements = "elements"
		val instanceContainer = "InstanceContainer"
		val straight = "STRAIGHT"
		val occupied = "OCCUPIED"
		val disabled = "DISABLED"
		val raise = "raise"
		val occupy = "Occupy"
		val turnout = "Turnout"
		val str = "Straight"
		val div = "Divergent"				
		val getSection = "getSection"		
		val runFullCycle = "runFullCycle"
		val assertEquals = "assertEquals"		
		val isStateActive = "isStateActive"
		val stateStop = "State.main_Stop"
		
		return '''
		package org.yakindu.scr2;
		
		import static org.junit.Assert.assertEquals;
		
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Test;
		import org.yakindu.scr.section2.Section2Statemachine.State;
		
		public class ComponentTestTwoTurnouts {
			private static «instanceContainer» «elements»;
			
			@BeforeClass
			public static void init() {
				«elements» = new «instanceContainer»();
			}
			
			@Before
			public void reset() {
				«elements» = new «instanceContainer»();
			}
			
			«FOR testcase : caseDescription»
			@Test
			// «testcase.comment.comment»
			public void «testcase.caseName.name»() {
				«FOR component : testcase.components»
				«IF component.turnout.turnoutState == straight»
				«elements».«raise»«turnout»«component.turnout.turnoutID»«str»();
				«ELSE»
				«elements».«raise»«turnout»«component.turnout.turnoutID»«div»();
				«ENDIF»
				«IF component.section.straightSection.straightSectionState == occupied»
				«elements».«raise»«turnout»«component.turnout.turnoutID»«occupy»Str();
				«ENDIF»
				«IF component.section.divergentSection.divergentSectionState == occupied»
				«elements».«raise»«turnout»«component.turnout.turnoutID»«occupy»Div();
				«ENDIF»
				«IF component.section.topSection.topSectionState == occupied»
				«elements».«raise»«turnout»«component.turnout.turnoutID»«occupy»Top();
				«ENDIF»
				«ENDFOR»
				«elements».«runFullCycle»();
				
				«FOR expected : testcase.expect»
				«IF expected.straightExpectation.straightExpectedState == disabled»
				«assertEquals»(true, «elements».«getSection»«expected.expectedTurnoutID»Str().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSection»«expected.expectedTurnoutID»Str().«isStateActive»(«stateStop»));
				«ENDIF»
				«IF expected.divergentExpectation.divergentExpectedState == disabled»
				«assertEquals»(true, «elements».«getSection»«expected.expectedTurnoutID»Div().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSection»«expected.expectedTurnoutID»Div().«isStateActive»(«stateStop»));
				«ENDIF»
				«IF expected.topExpectation.topExpectedState == disabled»
				«assertEquals»(true, «elements».«getSection»«expected.expectedTurnoutID»Top().«isStateActive»(«stateStop»));
				«ELSE»
				«assertEquals»(false, «elements».«getSection»«expected.expectedTurnoutID»Top().«isStateActive»(«stateStop»));
				«ENDIF»
				«ENDFOR»
			}
			
			«ENDFOR»
		}
		'''
	}
	
}