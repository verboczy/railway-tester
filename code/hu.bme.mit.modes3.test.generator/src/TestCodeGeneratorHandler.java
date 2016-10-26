import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
//import org.xtext.example.mydsl.myDsl.Model;


import hu.bme.mit.modes3.test.generator.TestGeneratorMQTT;
import hu.bme.mit.modes3.test.generator.TestGeneratorYakindu;
import hu.bme.mit.modes3.test.generator.TestListSize;
import hu.bme.mit.modes3.test.testLanguage.Model;
import hu.bme.mit.modes3.test.generator.SafetyLogicTestYakindu;
import hu.bme.mit.modes3.test.generator.TestGeneratorHelper;

public class TestCodeGeneratorHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		TestGeneratorHelper helper = TestGeneratorHelper.getInstance();
		
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		
		if(currentSelection instanceof TreeSelection){
			Object element = ((TreeSelection) currentSelection).getFirstElement();
			if(element instanceof IFile){
				IPath path = ((IFile) element).getFullPath();
				System.out.println(path); 	// /mylanguage/src/example.mydsl
				Model model = helper.load(path.toString());
				
				// TODO pass the model to the generator
				//TestGeneratorMQTT generator = new TestGeneratorMQTT();
				//TestGeneratorYakindu generatorYakindu = new TestGeneratorYakindu();
				
				
				//generator.setPath("C:\\Users\\Marosi\\Desktop\\itworks.java");
				//String fileContent = generator.generate(model);
				//helper.saveCode(fileContent, "C:\\Users\\Marosi\\Desktop\\itworks.java");
				//generator.setPath(path.toString());
				// DONE?
				
				//String fileContent2 = generatorYakindu.generate(model);
				//helper.saveCode(fileContent2, "C:\\Users\\Marosi\\Desktop\\yakinduGeneratedCode.java");
				
				
				SafetyLogicTestYakindu generator = new SafetyLogicTestYakindu();
				//TestListSize generator = new TestListSize();
				String fileContent = generator.generate(model);
				helper.saveCode(fileContent, "C:\\Users\\Marosi\\Desktop\\yakinduGeneratedCode.java");
			}
		}
		
		return null;
		
	}


}
