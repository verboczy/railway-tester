package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class SafetyLogicTestYakindu implements ITestGenerator {
	
	override String generate(Model model) {
		var init = model.initialState
		var testcases = model.caseDescription
		
		return '''
		package org.yakindu.scr.turnout;	
	
		import static org.junit.Assert.assertEquals;
				
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Test;
		
		public class YakinduTestCode {
			public static TurnoutStatemachine turnout;
			
			@BeforeClass
			public static void initialize() {
				turnout = new TurnoutStatemachine();
				turnout.init();
				turnout.enter();
				//turnout.setId(«init.turnoutID»);
			}
			
			@Before
			public void reset() {
				turnout.init();
				turnout.enter();
				
				«IF init.turnout.turnoutState == "DIVERGENT"»
				turnout.sCITurnout.raiseTurnoutDivergent();
				turnout.runCycle();
				«ENDIF»
			}
			
			«FOR test : testcases»
			// «test.steps.comment.comment»
			@Test
			public void «test.caseName.name»() {
				«IF test.steps.changedTurnout == null»
					«IF init.turnout.turnoutState == "STRAIGHT"»
						// Turnout is straight
						// Divergent must be disabled
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
						«ENDIF»								
						// ha mindketto foglalt, akkor mindketto disabled kell legyen
						«IF test.steps.section.get(0).straightSection.straightSectionState == "OCCUPIED" && 
							test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
							«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());														
							«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»							
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
								
							«ENDIF»
							
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());							
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»							
						
						
						// Ha csak a straight foglalt
						«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "OCCUPIED" && 
							test.steps.section.get(0).topSection.topSectionState == "FREE"»
							«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
						
						// ha csak a top foglalt	
						«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "FREE" && 
								test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							
						// ha egyik se foglalt	
						«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "FREE" && 
								test.steps.section.get(0).topSection.topSectionState == "FREE"»	
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»						
						«ENDIF»		
						
					«ELSEIF init.turnout.turnoutState == "DIVERGENT"»				
						// Turnout is divergent
						// Straight must be disabled
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
						«ENDIF»								
						// ha mindketto foglalt, akkor mindketto disabled kell legyen
						«IF test.steps.section.get(0).divergentSection.divergentSectionState == "OCCUPIED" && 
							test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
							«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());														
							«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»							
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
								
							«ENDIF»
							
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());							
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»							
						
						
						// Ha csak a divergent foglalt
						«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "OCCUPIED" && 
							test.steps.section.get(0).topSection.topSectionState == "FREE"»
							«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
						
						// ha csak a top foglalt	
						«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "FREE" && 
								test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							
						// ha egyik se foglalt	
						«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "FREE" && 
								test.steps.section.get(0).topSection.topSectionState == "FREE"»	
							«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
							«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»
							«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
							«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
							turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
							turnout.runCycle();
							turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
							turnout.runCycle();
							assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
							«ENDIF»	
						«ENDIF»	
					«ENDIF»																
				«ELSEIF test.steps.changedTurnout.turnoutState == "STRAIGHT"»
					«IF init.turnout.turnoutState == "DIVERGENT"»
					turnout.sCITurnout.raiseTurnoutStraight();
					turnout.runCycle();
					
					«ENDIF»
					// Turnout is straight
					// Divergent must be disabled
					turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
					turnout.runCycle();
					«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
					assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
					«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
					assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
					«ENDIF»								
					// ha mindketto foglalt, akkor mindketto disabled kell legyen
					«IF test.steps.section.get(0).straightSection.straightSectionState == "OCCUPIED" && 
						test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
						«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());														
						«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»							
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
							
						«ENDIF»
						
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());							
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»							
					
					
					// Ha csak a straight foglalt
					«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "OCCUPIED" && 
						test.steps.section.get(0).topSection.topSectionState == "FREE"»
						«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
					
					// ha csak a top foglalt	
					«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "FREE" && 
							test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						
					// ha egyik se foglalt	
					«ELSEIF test.steps.section.get(0).straightSection.straightSectionState == "FREE" && 
							test.steps.section.get(0).topSection.topSectionState == "FREE"»	
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»	
					«ENDIF»
				«ELSEIF test.steps.changedTurnout.turnoutState == "DIVERGENT"»
					«IF init.turnout.turnoutState == "STRAIGHT"»
					turnout.sCITurnout.raiseTurnoutDivergent();
					turnout.runCycle();
					
					«ENDIF»
					// Turnout is divergent
					// Straight must be disabled
					turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());
					turnout.runCycle();
					«IF test.expect.straightExpectation.straightExpectedState == "DISABLED"»
					assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
					«ELSEIF test.expect.straightExpectation.straightExpectedState == "ENABLED"»
					assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());
					«ENDIF»								
					// ha mindketto foglalt, akkor mindketto disabled kell legyen
					«IF test.steps.section.get(0).divergentSection.divergentSectionState == "OCCUPIED" && 
						test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
						«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());														
						«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»							
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
							
						«ENDIF»
						
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());							
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»							
					
					
					// Ha csak a divergent foglalt
					«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "OCCUPIED" && 
						test.steps.section.get(0).topSection.topSectionState == "FREE"»
						«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
					
					// ha csak a top foglalt	
					«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "FREE" && 
							test.steps.section.get(0).topSection.topSectionState == "OCCUPIED"»
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						
					// ha egyik se foglalt	
					«ELSEIF test.steps.section.get(0).divergentSection.divergentSectionState == "FREE" && 
							test.steps.section.get(0).topSection.topSectionState == "FREE"»	
						«IF test.expect.topExpectation.topExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());	
						«ELSEIF test.expect.topExpectation.topExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»
						«IF test.expect.divergentExpectation.divergentExpectedState == "DISABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());
						«ELSEIF test.expect.divergentExpectation.divergentExpectedState == "ENABLED"»
						turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());
						turnout.runCycle();
						turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());
						turnout.runCycle();
						assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());
						«ENDIF»	
					«ENDIF»															
			«ENDIF»
			}
			«ENDFOR»		
		}
		'''
	}
	
}