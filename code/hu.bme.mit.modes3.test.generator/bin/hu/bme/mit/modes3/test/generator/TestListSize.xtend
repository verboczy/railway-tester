package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

class TestListSize implements ITestGenerator {

	override String generate(Model model) {
		var init = model.initialState
		var testcases = model.caseDescription
		
		return '''
			«FOR test : testcases»
			«test.steps.section.size»
			«test.steps.section.get(0).straightSection.straightSectionState»
			«test.steps.section.get(0).divergentSection.divergentSectionState»
			«test.steps.section.get(0).topSection.topSectionState»
			«ENDFOR»
		'''
		}
}