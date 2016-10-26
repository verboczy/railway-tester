package hu.bme.mit.modes3.test.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

import hu.bme.mit.modes3.test.TestLanguageStandaloneSetup;
import hu.bme.mit.modes3.test.testLanguage.Model;
import hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage;


public class TestGeneratorHelper {

    private static TestGeneratorHelper instance;

    @Inject
    private XtextResourceSet resourceSet;

    private TestGeneratorHelper() {
        final TestLanguageStandaloneSetup setup = new TestLanguageStandaloneSetup();
        final Injector injector = setup.createInjectorAndDoEMFRegistration();
        TestLanguagePackage.eINSTANCE.eClass();
        injector.injectMembers(this);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
    }

    public static TestGeneratorHelper getInstance() {
        if (instance == null) {
            instance = new TestGeneratorHelper();
        }
        return instance;
    }

    public Model load(String filePath) {
        final URI uri = URI.createURI("platform:/resource" + filePath);
        final Resource resource = resourceSet.getResource(uri, true);
        final EObject object = resource.getContents().get(0);
        final Model model = (Model) object;
        return model;
    }

    public void save(Model model, String fileName) throws IOException {
        final URI uri = URI.createFileURI(fileName);
        final Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(model);
          resource.save(Collections.EMPTY_MAP);
   }
    
    /**
     * Writes the generated code into a (.java) file.
     * @param code		- the generated code.
     * @param filePath	- the path of the file.
     */
    public void saveCode(String code, String filePath) {
    	
    	Path path = Paths.get(filePath);
    	
    	try {
			Files.write(path, code.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}