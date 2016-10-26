package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class TestGeneratorYakindu implements ITestGenerator {
	
	override String generate(Model model) {
		var init = model.initialState
		var testcases = model.caseDescription		
		
		return '''
		package src.turnout;
		
		import static org.junit.Assert.assertEquals;
		
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Test;
		
		public class YakinduGeneratedCode {
			public static TurnoutStatemachine turnout;
			public static long sstraight;
			public static long sdivergent;
			public static long stop;
			
			@BeforeClass
			public static void initialize() {
				turnout = new TurnoutStatemachine();
				turnout.init();
				turnout.enter();
				
				sstraight = turnout.sCISections.getSTRAIGHT();
				sdivergent = turnout.sCISections.getDIVERGENT();
				stop = turnout.sCISections.getTOP();
			}
			
			@Before
			public void reset() {
				turnout.init();
				turnout.enter();
				
				turnout.sCITurnout.setId(«init.turnoutID»);
				turnout.sCITurnout.setIsOccupied(true);
				turnout.sCITurnout.setTopExists(true);
				turnout.sCITurnout.setDivergentExists(true);
				turnout.sCITurnout.setStraightExists(true);
				
				«IF init.turnout.turnoutState == "divergent"»
				turnout.sCITurnout.raiseTurnoutDivergent();		
				turnout.runCycle();
				«ENDIF»
			}
			
			public long directionHelper(String dir) {
				switch(dir) {
				case "straight": 
					return turnout.sCISections.getSTRAIGHT();
				case "divergent":
					return turnout.sCISections.getDIVERGENT();
				case "top":
					return turnout.sCISections.getTOP();
				default:
					return 0;
				}
			}
				
			«FOR test : testcases»			
			@Test
			public void «test.caseName.name»() {
				«IF test.steps.section.size > 2 && test.steps.section.get(0).sectionState == "occupied" && 
				test.steps.section.get(1).sectionState == "occupied" && test.steps.section.get(2).sectionState == "occupied"»
				// Ha mindegyik foglalt, akkor nyilván disabled kell, hogy legyen
				turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
				// Needed to avoid IllegalStateException
				turnout.sCITurnout.raiseRemSectionLockFrom(stop);
				turnout.runCycle();
				turnout.sCITurnout.raiseRemSectionLockFrom(stop);
				turnout.sCITurnout.raiseSectionLockFrom(stop);
				turnout.sCITurnout.raisePassingAllowedFrom(sstraight);
				turnout.sCITurnout.raisePassingDeniedFrom(stop);
				turnout.runCycle();	
					«IF test.expect.expectedState == "disabled"»
					assertEquals(directionHelper("divergent"), turnout.sCITurnout.getSectionLockedToValue());
					«ELSE»
					assertEquals(directionHelper("straight"), turnout.sCITurnout.getSectionLockedToValue());
					«ENDIF»				
				«ELSEIF test.steps.lockMessage.size == 0»
				// No lock					
					«IF (init.turnout.turnoutState == "divergent" && test.steps.changedTurnout == null) || 
					(test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "divergent")»
						«IF test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "divergent"»
						turnout.sCITurnout.raiseTurnoutDivergent();
						turnout.runCycle();
						«ENDIF»				
						«IF test.expect.expectedPosition == "straight"»
							«IF test.expect.expectedState == "disabled"»
							assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
							«ELSE»
							assertEquals(sdivergent, turnout.sCITurnout.getSectionLockedToValue());
							«ENDIF»
						«ELSEIF test.expect.expectedPosition == "divergent"»
							«IF test.steps.section.size == 1»
							turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.runCycle();
							turnout.sCITurnout.raisePassingAllowedFrom(stop);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sstraight);
							turnout.runCycle();
							turnout.sCITurnout.raiseRemPassageAllowedFrom(sdivergent);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sstraight);
							turnout.runCycle();
								«IF test.expect.expectedState == "enabled"»
								assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionAllowedToValue());
								«ELSEIF test.expect.expectedState == "disabled"»
								assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
								«ENDIF»
							«ELSEIF test.steps.section.size == 2»
								«IF (test.steps.section.get(0).position == "divergent" || test.steps.section.get(1).position == "divergent") && 
								(test.steps.section.get(0).position == "top"  || test.steps.section.get(1).position == "top") »
								turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
								turnout.sCITurnout.raisePassingAllowedFrom(sstraight);
								turnout.sCITurnout.raisePassingDeniedFrom(stop);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.sCITurnout.raiseSectionLockFrom(sstraight);
								turnout.runCycle();
									«IF test.expect.expectedState == "disabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
									«ELSE»
									assertEquals(sstraight, turnout.sCITurnout.getSectionLockedToValue());
									«ENDIF»
								«ENDIF»
							«ENDIF»
						«ELSEIF test.expect.expectedPosition == "top"»
							«IF test.steps.section.size == 1»
							turnout.sCITurnout.raiseSectionLockFrom(stop);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.runCycle();
							turnout.sCITurnout.raisePassingAllowedFrom(sdivergent);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sstraight);
							turnout.runCycle();
							turnout.sCITurnout.raiseRemPassageAllowedFrom(stop);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sstraight);
							turnout.runCycle();
								«IF test.expect.expectedState == "enabled"»
								assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionAllowedToValue());
								«ELSEIF test.expect.expectedState == "disabled"»
								assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
								«ENDIF»
							«ELSEIF test.steps.section.size == 2»
								«IF (test.steps.section.get(0).position == "divergent" || test.steps.section.get(1).position == "divergent") && 
								(test.steps.section.get(0).position == "top"  || test.steps.section.get(1).position == "top") »
								turnout.sCITurnout.raiseSectionLockFrom(stop);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
								turnout.sCITurnout.raisePassingAllowedFrom(sstraight);
								turnout.sCITurnout.raisePassingDeniedFrom(sdivergent);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.sCITurnout.raiseSectionLockFrom(sstraight);
								turnout.runCycle();
									«IF test.expect.expectedState == "disabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
									«ELSE»
									assertEquals(sstraight, turnout.sCITurnout.getSectionLockedToValue());
									«ENDIF»
								«ENDIF»
							«ENDIF»
						«ENDIF»
					«ELSEIF (init.turnout.turnoutState == "straight" && test.steps.changedTurnout == null) || 
					(test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "straight")»
						«IF test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "straight"»
						turnout.sCITurnout.raiseTurnoutStraight();
						turnout.runCycle();
						«ENDIF»						
						«IF test.expect.expectedPosition == "divergent"»
							«IF test.expect.expectedState == "disabled"»
							assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
							«ELSE»
							assertEquals(sstraight, turnout.sCITurnout.getSectionLockedToValue());
							«ENDIF»
						«ELSEIF test.expect.expectedPosition == "straight"»
							«IF init.turnoutID == 129»
								«IF test.steps.section.size == 1»
								turnout.sCITurnout.raiseSectionLockFrom(sstraight);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
								turnout.sCITurnout.raiseRemPassageAllowedFrom(stop);
								turnout.sCITurnout.raiseRemPassageDeniedFrom(sdivergent);
								turnout.sCITurnout.raiseSectionLockFrom(sstraight);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
									«IF test.expect.expectedState == "enabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionAllowedToValue());
									«ELSEIF test.expect.expectedState == "disabled"»
									assertEquals(sdivergent, turnout.sCITurnout.getSectionAllowedToValue());
									«ENDIF»
								«ELSEIF test.steps.section.size == 2»
									«IF (test.steps.section.get(0).position == "straight" || test.steps.section.get(1).position == "straight") && 
									(test.steps.section.get(0).position == "top"  || test.steps.section.get(1).position == "top") »
									turnout.sCITurnout.raiseSectionLockFrom(sstraight);
									turnout.sCITurnout.raiseRemSectionLockFrom(stop);
									turnout.runCycle();
									turnout.sCITurnout.raiseRemPassageDeniedFrom(stop);
									turnout.sCITurnout.raiseSectionLockFrom(sstraight);
									turnout.sCITurnout.raiseRemSectionLockFrom(stop);
									turnout.runCycle();
									«IF test.expect.expectedState == "disabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
									«ELSE»
									assertEquals(sdivergent, turnout.sCITurnout.getSectionLockedToValue());
									«ENDIF»
									«ENDIF»
								«ENDIF»
							«ELSE»
								«IF test.steps.section.size == 1»								
								turnout.sCITurnout.raiseSectionLockFrom(sstraight);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
								turnout.sCITurnout.raisePassingAllowedFrom(stop);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
								turnout.runCycle();
								turnout.sCITurnout.raiseRemPassageAllowedFrom(sstraight);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
								turnout.runCycle();
									«IF test.expect.expectedState == "enabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionAllowedToValue());
									«ELSEIF test.expect.expectedState == "disabled"»
									assertEquals(sdivergent, turnout.sCITurnout.getSectionAllowedToValue());
									«ENDIF»
								«ELSEIF test.steps.section.size == 2»
									«IF (test.steps.section.get(0).position == "straight" || test.steps.section.get(1).position == "straight") && 
									(test.steps.section.get(0).position == "top"  || test.steps.section.get(1).position == "top") »
									turnout.sCITurnout.raiseSectionLockFrom(sstraight);
									turnout.sCITurnout.raiseRemSectionLockFrom(stop);
									turnout.runCycle();
									turnout.sCITurnout.raisePassingDeniedFrom(stop);
									turnout.sCITurnout.raiseRemSectionLockFrom(stop);
									turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
									turnout.runCycle();
										«IF test.expect.expectedState == "disabled"»
										assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
										«ELSE»
										assertEquals(sdivergent, turnout.sCITurnout.getSectionLockedToValue());
										«ENDIF»
									«ENDIF»
								«ENDIF»
							«ENDIF»
							
						«ELSEIF test.expect.expectedPosition == "top"»					
							«IF test.steps.section.size == 1»
							turnout.sCITurnout.raiseSectionLockFrom(stop);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.runCycle();
							turnout.sCITurnout.raisePassingAllowedFrom(sstraight);
							turnout.sCITurnout.raisePassingDeniedFrom(sdivergent);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
							turnout.runCycle();
							turnout.sCITurnout.raiseRemPassageAllowedFrom(stop);
							turnout.sCITurnout.raiseRemSectionLockFrom(stop);
							turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
							turnout.runCycle();
								«IF test.expect.expectedState == "enabled"»
								assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionAllowedToValue());
								«ELSEIF test.expect.expectedState == "disabled"»
								assertEquals(sdivergent, turnout.sCITurnout.getSectionAllowedToValue());
								«ENDIF»
							«ELSEIF test.steps.section.size == 2»
								«IF (test.steps.section.get(0).position == "straight" || test.steps.section.get(1).position == "straight") && 
								(test.steps.section.get(0).position == "top"  || test.steps.section.get(1).position == "top") »
								turnout.sCITurnout.raiseSectionLockFrom(stop);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.runCycle();
								turnout.sCITurnout.raisePassingDeniedFrom(sstraight);
								turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
								turnout.runCycle();
									«IF test.expect.expectedState == "disabled"»
									assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
									«ELSE»
									assertEquals(sdivergent, turnout.sCITurnout.getSectionLockedToValue());
									«ENDIF»
								«ENDIF»
							«ENDIF»								
						«ENDIF»				
					«ENDIF»				
				«ELSE»
				// Has lock

					«IF (init.turnout.turnoutState == "divergent" && test.steps.changedTurnout == null) || 
					(test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "divergent")»
						«IF test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "divergent"»
						turnout.sCITurnout.raiseTurnoutDivergent();
						turnout.runCycle();
						«ENDIF»		
						«IF test.expect.expectedPosition == "straight"»
							«IF test.expect.expectedState == "disabled"»
							assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
							«ELSE»
							assertEquals(directionHelper("divergent"), turnout.sCITurnout.getSectionLockedToValue());
							«ENDIF»
						«ELSEIF test.expect.expectedPosition == "divergent"»						
							«FOR lock : test.steps.lockMessage»
								«FOR section : test.steps.section»
								 	«IF lock.direction == "top" && section.position == "divergent" && section.sectionState == "occupied"»
									 	«IF test.expect.expectedState == "disabled"»									 	
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sstraight);								 		
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(sstraight, turnout.sCITurnout.getRemPassageDeniedToValue());							
		 								«ENDIF»
								 	«ELSEIF lock.direction == "divergent" && section.position == "divergent" && section.sectionState == "occupied"»
								 		«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(sdivergent);
								 		turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(«test.expect.expectedPosition», turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(sdivergent);
										turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(sstraight, turnout.sCITurnout.getRemPassageDeniedToValue());
								 		«ENDIF»
								 	«ENDIF»								 	
							 	«ENDFOR»
							«ENDFOR»					
						«ELSEIF test.expect.expectedPosition == "top"»
							«FOR lock : test.steps.lockMessage»
								«FOR section : test.steps.section»
									«IF lock.direction == "divergent" && section.position == "top" && section.sectionState == "occupied"»
									 	«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(sstraight, turnout.sCITurnout.getRemPassageDeniedToValue());							
		 								«ENDIF»
								 	«ELSEIF lock.direction == "top" && section.position == "top" && section.sectionState == "occupied"»
								 		«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.sCITurnout.raiseSectionLockFrom(sstraight);
										turnout.runCycle();
										assertEquals(sstraight, turnout.sCITurnout.getRemPassageDeniedToValue());
								 		«ENDIF»
								 	«ENDIF»	
								«ENDFOR»
							«ENDFOR»
						«ENDIF»
					«ELSEIF (init.turnout.turnoutState == "straight" && test.steps.changedTurnout == null) || 
					(test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "straight")»
						«IF test.steps.changedTurnout != null && test.steps.changedTurnout.turnoutState == "straight"»
						turnout.sCITurnout.raiseTurnoutStraight();
						turnout.runCycle();
						«ENDIF»	
						«IF test.expect.expectedPosition == "divergent"»
							«IF test.expect.expectedState == "disabled"»
							assertEquals(directionHelper("«test.expect.expectedPosition»"), turnout.sCITurnout.getSectionLockedToValue());
							«ELSE»
							assertEquals(directionHelper("divergent"), turnout.sCITurnout.getSectionLockedToValue());
							«ENDIF»
						«ELSEIF test.expect.expectedPosition == "straight"»
							«FOR lock : test.steps.lockMessage»
								«FOR section : test.steps.section»
									«IF lock.direction == "straight" && section.position == "top" && section.sectionState == "occupied"»
									 	«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(sdivergent, turnout.sCITurnout.getRemPassageDeniedToValue());							
		 								«ENDIF»
								 	«ELSEIF lock.direction == "top" && section.position == "top" && section.sectionState == "occupied"»
								 		«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(sstraight);
								 		turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(sstraight, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(sstraight);
										turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(sdivergent, turnout.sCITurnout.getRemPassageDeniedToValue());
								 		«ENDIF»
								 	«ENDIF»	
								«ENDFOR»
							«ENDFOR»
						«ELSEIF test.expect.expectedPosition == "top"»
							«FOR lock : test.steps.lockMessage»
								«FOR section : test.steps.section»
									«IF lock.direction == "straight" && section.position == "top" && section.sectionState == "occupied"»
									 	«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(sdivergent, turnout.sCITurnout.getRemPassageDeniedToValue());							
		 								«ENDIF»
								 	«ELSEIF lock.direction == "top" && section.position == "top" && section.sectionState == "occupied"»
								 		«IF test.expect.expectedState == "disabled"»
								 		turnout.sCITurnout.raiseRemSectionLockFrom(stop);
								 		turnout.sCITurnout.raiseSectionLockFrom(sdivergent);
										turnout.runCycle();
										assertEquals(stop, turnout.sCITurnout.getRemPassageDeniedToValue());
										«ELSE»
										turnout.sCITurnout.raiseRemSectionLockFrom(stop);
										turnout.runCycle();
										assertEquals(sdivergent, turnout.sCITurnout.getRemPassageDeniedToValue());
								 		«ENDIF»
								 	«ENDIF»	
								«ENDFOR»
							«ENDFOR»
						«ENDIF»											
					«ENDIF»
				«ENDIF»
			}	
					
			«ENDFOR»
		}		
		'''
	}
	
}