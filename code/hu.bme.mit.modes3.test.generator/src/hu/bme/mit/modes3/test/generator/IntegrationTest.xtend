package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class IntegrationTest implements ITestGenerator {
	
	override generate(Model model) {
		var caseDescription = model.caseDescription
		val initializerMQTT = "InitializerMQTT"
		val demonstratorComponent = "DemonstratorComponent"
		val mqttTestCommunicationStack = "MqttTestCommunicationStack"
		val turnoutStates = "turnoutStates"
		val sectionOccupancies = "sectionOccupancies"
		val sectionStates = "sectionStates"
		val turnoutIdList = "turnoutIdList"
		val sectionIdList = "sectionIdList"
		val sut = "sut"
		val component = "component"
		val stack = "stack" 
		val hashMap = "HashMap<Integer, String>"
		val arrayList = "ArrayList<Integer>"
		val changeTurnout = "changeTurnout"
		val changeOccupancy = "changeOccupancy"
		//val changeSection = "changeSection"
		val tState = "TurnoutState"
		val segmentOccupany = "SegmentOccupancy"
		val segmentState = "SegmentState"
		val straight = "STRAIGHT"
		//val divergent = "DIVERGENT"
		//val top = "TOP"
		//val free = "FREE"
		val occupied = "OCCUPIED"
		//val enabled = "ENABLED"
		val disabled = "DISABLED"
		
		
		return '''
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
			private static «initializerMQTT» «sut»;
			private static «demonstratorComponent» «component»;
			private static «mqttTestCommunicationStack» «stack»;
				
			private static Map<Integer, String> «turnoutStates»;
			private static Map<Integer, String> «sectionOccupancies»;
			private static Map<Integer, String> «sectionStates»;
				
			private static List<Integer> «turnoutIdList»;
			private static List<Integer> «sectionIdList»;
			
			@BeforeClass
			public static void init() {
				«sut» = new «initializerMQTT»();
				«component» = «sut».getComponent();
				«stack» = «sut».getStack();
				
				«turnoutStates» = new «hashMap»();
				«sectionOccupancies» = new «hashMap»();
				«sectionStates» = new «hashMap»();
				
				«turnoutIdList» = new «arrayList»();
				«sectionIdList» = new «arrayList»();
				
				for(int i = 1; i <= 6; i++) {
					«turnoutIdList».add(i);
				}
				
				«sectionIdList».add(1);
				«sectionIdList».add(2);
				«sectionIdList».add(4);
				«sectionIdList».add(5);
				«sectionIdList».add(6);
				«sectionIdList».add(7);
				«sectionIdList».add(8);
				«sectionIdList».add(10);
				«sectionIdList».add(11);
				«sectionIdList».add(12);
				«sectionIdList».add(13);
				«sectionIdList».add(15);
				«sectionIdList».add(17);
				«sectionIdList».add(18);
				«sectionIdList».add(19);
				«sectionIdList».add(20);
				«sectionIdList».add(22);
				«sectionIdList».add(23);
				«sectionIdList».add(24);
				«sectionIdList».add(26);
				«sectionIdList».add(27);
				«sectionIdList».add(29);
				«sectionIdList».add(30);
				«sectionIdList».add(31);
				
				«sut».initialize();
			}
			
			@Before
			public void reset() {
				«turnoutStates».clear();
				«sectionOccupancies».clear();
				«sectionStates».clear();
				
				for (Integer turnoutId : «turnoutIdList») {
					«component».«changeTurnout»(turnoutId, «tState».«straight»);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			«FOR test : caseDescription»
			@Test
			// «test.comment.comment»
			public void «test.caseName.name»() {
				«FOR comp : test.components» 
				«component».«changeTurnout»(«comp.turnout.turnoutID», «tState».«comp.turnout.turnoutState»);
				«IF comp.section.straightSection.straightSectionState == occupied»
				«component».«changeOccupancy»(«comp.section.straightSection.strID», «segmentOccupany».«occupied»);
				«sectionOccupancies».replace(«comp.section.straightSection.strID», «segmentOccupany».«occupied».toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				«ENDIF»
				«IF comp.section.divergentSection.divergentSectionState == occupied»
				«component».«changeOccupancy»(«comp.section.divergentSection.divID», «segmentOccupany».«occupied»);
				«sectionOccupancies».replace(«comp.section.divergentSection.divID», «segmentOccupany».«occupied».toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				«ENDIF»
				«IF comp.section.topSection.topSectionState == occupied»
				«component».«changeOccupancy»(«comp.section.topSection.topID», «segmentOccupany».«occupied»);
				«sectionOccupancies».replace(«comp.section.topSection.topID», «segmentOccupany».«occupied».toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				«ENDIF»
				«ENDFOR»
				«FOR expect : test.expect»
				«IF expect.straightExpectation.straightExpectedState == disabled»
				«sectionStates».put(«expect.straightExpectation.strID», «segmentState».«disabled».toString());
				«ENDIF»
				«IF expect.divergentExpectation.divergentExpectedState == disabled»
				«sectionStates».put(«expect.divergentExpectation.divID», «segmentState».«disabled».toString());
				«ENDIF»
				«IF expect.topExpectation.topExpectedState == disabled»
				«sectionStates».put(«expect.topExpectation.topID», «segmentState».«disabled».toString());
				«ENDIF»
				«ENDFOR »
				for (Integer id : «sectionIdList») {
					if («sectionStates».containsKey(id)) {
						assertEquals(«sectionStates».get(id), «stack».getDispatcher().getSectionStateMap().get(id));
					}
				}
			}
			«ENDFOR»
			
		}
		'''
	}
	
}