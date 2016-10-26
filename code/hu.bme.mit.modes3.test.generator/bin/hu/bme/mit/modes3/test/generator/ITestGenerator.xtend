package hu.bme.mit.modes3.test.generator

import hu.bme.mit.modes3.test.testLanguage.Model

interface ITestGenerator {
	
	def String generate(Model model)
	
}