package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model


class TestGeneratorMQTT implements ITestGenerator {
	
	override String generate(Model model) {
		var init = model.initialState
		var testcases = model.caseDescription
				
		return '''
		package hu.bme.mit.modes3.statecharts.tests;
		
		import static org.junit.Assert.assertEquals;
		
		import java.io.IOException;
		import java.io.InputStream;
		import java.io.InputStreamReader;
		import java.nio.file.Files;
		import java.nio.file.Path;
		import java.nio.file.Paths;
		import java.util.Map;
		import java.util.concurrent.ConcurrentHashMap;
		
		import org.junit.Before;
		import org.junit.BeforeClass;
		import org.junit.Test;
		
		import com.google.gson.Gson;
		import com.google.gson.JsonObject;
		import com.google.gson.stream.JsonReader;
		
		import hu.bme.mit.modes3.statecharts.tests.enums.SectionOccupancyDescription;
		import hu.bme.mit.modes3.statecharts.tests.enums.SectionStatusDescription;
		import hu.bme.mit.modes3.statecharts.tests.enums.TurnoutStatusDescription;
		import hu.bme.mit.modes3.statecharts.tests.mqtt.Allowance;
		import hu.bme.mit.modes3.statecharts.tests.mqtt.EnvironmentMessageSender;
		import hu.bme.mit.modes3.statecharts.tests.mqtt.InitializerMQTT;
		
		public class itworks {
				private static InitializerMQTT railwayElement;
				
				private static int firstTurnoutID = 129;
				private static int lastTurnoutID = 135;
				
				private static int firstSectionID = 1;
				private static int lastSectionID = 23;
				
				private static Map<Integer, SectionStatusDescription> sectionStatuses;
				private static Map<Integer, TurnoutStatusDescription> turnoutStatuses;
				
				@BeforeClass
				public static void initialize() throws IOException {
					railwayElement = new InitializerMQTT();
					railwayElement.initialize(new String[0]);
					sectionStatuses = new ConcurrentHashMap<>();
					turnoutStatuses = new ConcurrentHashMap<>();
				}
				
				@Before
				public void reset() {
					railwayElement.occupancyController.reset();
					railwayElement.sectionController.reset();
					railwayElement.turnoutController.reset();
					
					for (int i = firstTurnoutID; i <= lastTurnoutID; i++) {
						turnoutStatuses.put(i, TurnoutStatusDescription.STRAIGHT);
					}
					
					turnoutStatuses.put(«init.turnoutID», 
					«IF init.turnout.turnoutState == "straight"» TurnoutStatusDescription.STRAIGHT 
					«ELSE» TurnoutStatusDescription.DIVERGENT
					«ENDIF»
					);
					
					for (int i = firstSectionID; i <= lastSectionID; i++) {
						sectionStatuses.put(i, SectionStatusDescription.ENABLED);
					}	
				}
				
				public int jsonReader(Integer id, String dir) {
					Gson gson = new Gson();
					
					Path filePath = Paths.get("C:\\Users\\Marosi\\Desktop\\normalturnouts.json");	
					InputStream in;
					try {
						in = Files.newInputStream(filePath);
					 	
				        JsonReader reader = new JsonReader(new InputStreamReader(in));
				        
				        JsonObject jsonFile = gson.fromJson(reader, JsonObject.class);
				        JsonObject neighbours = jsonFile.get(id.toString()).getAsJsonObject();
				
				        reader.close();	
				        in.close();	
				        
				        switch(dir) {
				        case "straight":
				        	return neighbours.get("STRAIGHT").getAsInt();
				        	
				        case "divergent":
				        	return neighbours.get("DIVERGENT").getAsInt();
				        	
				        case "top":
				        	return neighbours.get("TOP").getAsInt();
				        	
				        default:
				        	return 0;	        	
				        }	        
					}
			        catch (IOException e) {
						e.printStackTrace();
					}
					return 0;	
				}
				
				public TurnoutStatusDescription turnoutHelper(String direction) {
					switch(direction) {
					case "divergent":
						return TurnoutStatusDescription.DIVERGENT;
						
					case "straight":
						return TurnoutStatusDescription.STRAIGHT;
						
					default:
						return null;
					}
				}
					
				public SectionOccupancyDescription occupancyHelper(String occupancy) {
					switch(occupancy) {
					case "free":
						return SectionOccupancyDescription.FREE;
					case "occupied":
						return SectionOccupancyDescription.OCCUPIED;
						
					default:
						return null;
					}
				}
				
				public SectionStatusDescription sectionHelper(String status) {
					switch(status) {
					case "enabled":
						return SectionStatusDescription.ENABLED;
						
					case "disabled":
						return SectionStatusDescription.DISABLED;
					
					default:
						return null;
					}
				}
				
				«FOR test : testcases»
				@Test
				public void «test.caseName.name»() {										
					«IF test.steps.changedTurnout != null»
					railwayElement.turnoutController.setTurnoutStatus(«init.turnoutID», turnoutHelper("«test.steps.changedTurnout.turnoutState»"));
					«ENDIF»			
							
					«FOR section : test.steps.section»
					railwayElement.occupancyController.setOccupancy(jsonReader(«init.turnoutID», "«section.position»"), occupancyHelper("«section.sectionState»"));
					«ENDFOR»
					
					«IF test.steps.lockMessage != null»
					«FOR lock : test.steps.lockMessage»
					«IF lock.direction == "top"»
					railwayElement.enviromentSender.sendMessage(Allowance.DENIED, «init.turnoutID», "PASSAGE_RESPONSE_TOP");
					«ELSEIF lock.direction == "straight"»
					railwayElement.enviromentSender.sendMessage(Allowance.DENIED, «init.turnoutID», "PASSAGE_RESPONSE_STRAIGHT");
					«ELSE»
					railwayElement.enviromentSender.sendMessage(Allowance.DENIED, «init.turnoutID», "PASSAGE_RESPONSE_DIVERGENT");
					«ENDIF»
					«ENDFOR»
					«ENDIF»			
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
					
					assertEquals(sectionHelper("«test.expect.expectedState»"), railwayElement.sectionController.getGeneralSectionStatus(jsonReader(«init.turnoutID», "«test.expect.expectedPosition»")));
				}
				
				«ENDFOR»
		}
		'''
	}		
}