/*
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("hu/bme/mit/modes3/test/parser/antlr/internal/InternalTestLanguage.tokens");
	}
}
