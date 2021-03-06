/*
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.parser.antlr;

import com.google.inject.Inject;
import hu.bme.mit.modes3.test.parser.antlr.internal.InternalTestLanguageParser;
import hu.bme.mit.modes3.test.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class TestLanguageParser extends AbstractAntlrParser {

	@Inject
	private TestLanguageGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalTestLanguageParser createParser(XtextTokenStream stream) {
		return new InternalTestLanguageParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
