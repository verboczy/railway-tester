/*
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractTestLanguageValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
