package hu.bme.mit.modes3.test.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.modes3.test.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'[InitialState]'", "'turnoutId'", "'='", "'Name of the test case'", "':'", "'[Step]'", "'Short description'", "'Turnout state is '", "'STRAIGHT'", "'DIVERGENT'", "'Section connecting from STRAIGHT is '", "'FREE'", "'OCCUPIED'", "'Section connecting from DIVERGENT is '", "'Section connecting from TOP is '", "'[Expected]'", "'Section connecting from STRAIGHT is expected to be '", "'ENABLED'", "'DISABLED'", "'Section connecting from DIVERGENT is expected to be '", "'Section connecting from TOP is expected to be '"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;

        public InternalTestLanguageParser(TokenStream input, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalTestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalTestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalTestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalTestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_initialState_0_0= ruleInitialState ) ) ( (lv_caseDescription_1_0= ruleCaseDescription ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_initialState_0_0 = null;

        EObject lv_caseDescription_1_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:77:2: ( ( ( (lv_initialState_0_0= ruleInitialState ) ) ( (lv_caseDescription_1_0= ruleCaseDescription ) )* ) )
            // InternalTestLanguage.g:78:2: ( ( (lv_initialState_0_0= ruleInitialState ) ) ( (lv_caseDescription_1_0= ruleCaseDescription ) )* )
            {
            // InternalTestLanguage.g:78:2: ( ( (lv_initialState_0_0= ruleInitialState ) ) ( (lv_caseDescription_1_0= ruleCaseDescription ) )* )
            // InternalTestLanguage.g:79:3: ( (lv_initialState_0_0= ruleInitialState ) ) ( (lv_caseDescription_1_0= ruleCaseDescription ) )*
            {
            // InternalTestLanguage.g:79:3: ( (lv_initialState_0_0= ruleInitialState ) )
            // InternalTestLanguage.g:80:4: (lv_initialState_0_0= ruleInitialState )
            {
            // InternalTestLanguage.g:80:4: (lv_initialState_0_0= ruleInitialState )
            // InternalTestLanguage.g:81:5: lv_initialState_0_0= ruleInitialState
            {

            					newCompositeNode(grammarAccess.getModelAccess().getInitialStateInitialStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_initialState_0_0=ruleInitialState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"initialState",
            						lv_initialState_0_0,
            						"hu.bme.mit.modes3.test.TestLanguage.InitialState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:98:3: ( (lv_caseDescription_1_0= ruleCaseDescription ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:99:4: (lv_caseDescription_1_0= ruleCaseDescription )
            	    {
            	    // InternalTestLanguage.g:99:4: (lv_caseDescription_1_0= ruleCaseDescription )
            	    // InternalTestLanguage.g:100:5: lv_caseDescription_1_0= ruleCaseDescription
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getCaseDescriptionCaseDescriptionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_caseDescription_1_0=ruleCaseDescription();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"caseDescription",
            	    						lv_caseDescription_1_0,
            	    						"hu.bme.mit.modes3.test.TestLanguage.CaseDescription");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInitialState"
    // InternalTestLanguage.g:121:1: entryRuleInitialState returns [EObject current=null] : iv_ruleInitialState= ruleInitialState EOF ;
    public final EObject entryRuleInitialState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialState = null;


        try {
            // InternalTestLanguage.g:121:53: (iv_ruleInitialState= ruleInitialState EOF )
            // InternalTestLanguage.g:122:2: iv_ruleInitialState= ruleInitialState EOF
            {
             newCompositeNode(grammarAccess.getInitialStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitialState=ruleInitialState();

            state._fsp--;

             current =iv_ruleInitialState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitialState"


    // $ANTLR start "ruleInitialState"
    // InternalTestLanguage.g:128:1: ruleInitialState returns [EObject current=null] : (otherlv_0= '[InitialState]' otherlv_1= 'turnoutId' otherlv_2= '=' ( (lv_turnoutID_3_0= RULE_INT ) ) ( (lv_turnout_4_0= ruleTurnout ) )? ) ;
    public final EObject ruleInitialState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_turnoutID_3_0=null;
        EObject lv_turnout_4_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:134:2: ( (otherlv_0= '[InitialState]' otherlv_1= 'turnoutId' otherlv_2= '=' ( (lv_turnoutID_3_0= RULE_INT ) ) ( (lv_turnout_4_0= ruleTurnout ) )? ) )
            // InternalTestLanguage.g:135:2: (otherlv_0= '[InitialState]' otherlv_1= 'turnoutId' otherlv_2= '=' ( (lv_turnoutID_3_0= RULE_INT ) ) ( (lv_turnout_4_0= ruleTurnout ) )? )
            {
            // InternalTestLanguage.g:135:2: (otherlv_0= '[InitialState]' otherlv_1= 'turnoutId' otherlv_2= '=' ( (lv_turnoutID_3_0= RULE_INT ) ) ( (lv_turnout_4_0= ruleTurnout ) )? )
            // InternalTestLanguage.g:136:3: otherlv_0= '[InitialState]' otherlv_1= 'turnoutId' otherlv_2= '=' ( (lv_turnoutID_3_0= RULE_INT ) ) ( (lv_turnout_4_0= ruleTurnout ) )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInitialStateAccess().getInitialStateKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getInitialStateAccess().getTurnoutIdKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getInitialStateAccess().getEqualsSignKeyword_2());
            		
            // InternalTestLanguage.g:148:3: ( (lv_turnoutID_3_0= RULE_INT ) )
            // InternalTestLanguage.g:149:4: (lv_turnoutID_3_0= RULE_INT )
            {
            // InternalTestLanguage.g:149:4: (lv_turnoutID_3_0= RULE_INT )
            // InternalTestLanguage.g:150:5: lv_turnoutID_3_0= RULE_INT
            {
            lv_turnoutID_3_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_turnoutID_3_0, grammarAccess.getInitialStateAccess().getTurnoutIDINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitialStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"turnoutID",
            						lv_turnoutID_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalTestLanguage.g:166:3: ( (lv_turnout_4_0= ruleTurnout ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:167:4: (lv_turnout_4_0= ruleTurnout )
                    {
                    // InternalTestLanguage.g:167:4: (lv_turnout_4_0= ruleTurnout )
                    // InternalTestLanguage.g:168:5: lv_turnout_4_0= ruleTurnout
                    {

                    					newCompositeNode(grammarAccess.getInitialStateAccess().getTurnoutTurnoutParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_turnout_4_0=ruleTurnout();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInitialStateRule());
                    					}
                    					set(
                    						current,
                    						"turnout",
                    						lv_turnout_4_0,
                    						"hu.bme.mit.modes3.test.TestLanguage.Turnout");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitialState"


    // $ANTLR start "entryRuleCaseDescription"
    // InternalTestLanguage.g:189:1: entryRuleCaseDescription returns [EObject current=null] : iv_ruleCaseDescription= ruleCaseDescription EOF ;
    public final EObject entryRuleCaseDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseDescription = null;


        try {
            // InternalTestLanguage.g:189:56: (iv_ruleCaseDescription= ruleCaseDescription EOF )
            // InternalTestLanguage.g:190:2: iv_ruleCaseDescription= ruleCaseDescription EOF
            {
             newCompositeNode(grammarAccess.getCaseDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseDescription=ruleCaseDescription();

            state._fsp--;

             current =iv_ruleCaseDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseDescription"


    // $ANTLR start "ruleCaseDescription"
    // InternalTestLanguage.g:196:1: ruleCaseDescription returns [EObject current=null] : ( ( (lv_caseName_0_0= ruleCaseName ) ) ( (lv_steps_1_0= ruleSteps ) ) ( (lv_expect_2_0= ruleExpectations ) ) ) ;
    public final EObject ruleCaseDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_caseName_0_0 = null;

        EObject lv_steps_1_0 = null;

        EObject lv_expect_2_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:202:2: ( ( ( (lv_caseName_0_0= ruleCaseName ) ) ( (lv_steps_1_0= ruleSteps ) ) ( (lv_expect_2_0= ruleExpectations ) ) ) )
            // InternalTestLanguage.g:203:2: ( ( (lv_caseName_0_0= ruleCaseName ) ) ( (lv_steps_1_0= ruleSteps ) ) ( (lv_expect_2_0= ruleExpectations ) ) )
            {
            // InternalTestLanguage.g:203:2: ( ( (lv_caseName_0_0= ruleCaseName ) ) ( (lv_steps_1_0= ruleSteps ) ) ( (lv_expect_2_0= ruleExpectations ) ) )
            // InternalTestLanguage.g:204:3: ( (lv_caseName_0_0= ruleCaseName ) ) ( (lv_steps_1_0= ruleSteps ) ) ( (lv_expect_2_0= ruleExpectations ) )
            {
            // InternalTestLanguage.g:204:3: ( (lv_caseName_0_0= ruleCaseName ) )
            // InternalTestLanguage.g:205:4: (lv_caseName_0_0= ruleCaseName )
            {
            // InternalTestLanguage.g:205:4: (lv_caseName_0_0= ruleCaseName )
            // InternalTestLanguage.g:206:5: lv_caseName_0_0= ruleCaseName
            {

            					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getCaseNameCaseNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_caseName_0_0=ruleCaseName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            					}
            					set(
            						current,
            						"caseName",
            						lv_caseName_0_0,
            						"hu.bme.mit.modes3.test.TestLanguage.CaseName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:223:3: ( (lv_steps_1_0= ruleSteps ) )
            // InternalTestLanguage.g:224:4: (lv_steps_1_0= ruleSteps )
            {
            // InternalTestLanguage.g:224:4: (lv_steps_1_0= ruleSteps )
            // InternalTestLanguage.g:225:5: lv_steps_1_0= ruleSteps
            {

            					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getStepsStepsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_steps_1_0=ruleSteps();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            					}
            					set(
            						current,
            						"steps",
            						lv_steps_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.Steps");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:242:3: ( (lv_expect_2_0= ruleExpectations ) )
            // InternalTestLanguage.g:243:4: (lv_expect_2_0= ruleExpectations )
            {
            // InternalTestLanguage.g:243:4: (lv_expect_2_0= ruleExpectations )
            // InternalTestLanguage.g:244:5: lv_expect_2_0= ruleExpectations
            {

            					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getExpectExpectationsParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_expect_2_0=ruleExpectations();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            					}
            					set(
            						current,
            						"expect",
            						lv_expect_2_0,
            						"hu.bme.mit.modes3.test.TestLanguage.Expectations");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseDescription"


    // $ANTLR start "entryRuleCaseName"
    // InternalTestLanguage.g:265:1: entryRuleCaseName returns [EObject current=null] : iv_ruleCaseName= ruleCaseName EOF ;
    public final EObject entryRuleCaseName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseName = null;


        try {
            // InternalTestLanguage.g:265:49: (iv_ruleCaseName= ruleCaseName EOF )
            // InternalTestLanguage.g:266:2: iv_ruleCaseName= ruleCaseName EOF
            {
             newCompositeNode(grammarAccess.getCaseNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseName=ruleCaseName();

            state._fsp--;

             current =iv_ruleCaseName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseName"


    // $ANTLR start "ruleCaseName"
    // InternalTestLanguage.g:272:1: ruleCaseName returns [EObject current=null] : (otherlv_0= 'Name of the test case' otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleCaseName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:278:2: ( (otherlv_0= 'Name of the test case' otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:279:2: (otherlv_0= 'Name of the test case' otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:279:2: (otherlv_0= 'Name of the test case' otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalTestLanguage.g:280:3: otherlv_0= 'Name of the test case' otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseNameAccess().getNameOfTheTestCaseKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getCaseNameAccess().getColonKeyword_1());
            		
            // InternalTestLanguage.g:288:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalTestLanguage.g:289:4: (lv_name_2_0= RULE_ID )
            {
            // InternalTestLanguage.g:289:4: (lv_name_2_0= RULE_ID )
            // InternalTestLanguage.g:290:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getCaseNameAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCaseNameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseName"


    // $ANTLR start "entryRuleSteps"
    // InternalTestLanguage.g:310:1: entryRuleSteps returns [EObject current=null] : iv_ruleSteps= ruleSteps EOF ;
    public final EObject entryRuleSteps() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSteps = null;


        try {
            // InternalTestLanguage.g:310:46: (iv_ruleSteps= ruleSteps EOF )
            // InternalTestLanguage.g:311:2: iv_ruleSteps= ruleSteps EOF
            {
             newCompositeNode(grammarAccess.getStepsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSteps=ruleSteps();

            state._fsp--;

             current =iv_ruleSteps; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSteps"


    // $ANTLR start "ruleSteps"
    // InternalTestLanguage.g:317:1: ruleSteps returns [EObject current=null] : (otherlv_0= '[Step]' ( (lv_comment_1_0= ruleComment ) ) ( (lv_changedTurnout_2_0= ruleTurnout ) )? ( (lv_section_3_0= ruleSection ) )+ ) ;
    public final EObject ruleSteps() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_comment_1_0 = null;

        EObject lv_changedTurnout_2_0 = null;

        EObject lv_section_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:323:2: ( (otherlv_0= '[Step]' ( (lv_comment_1_0= ruleComment ) ) ( (lv_changedTurnout_2_0= ruleTurnout ) )? ( (lv_section_3_0= ruleSection ) )+ ) )
            // InternalTestLanguage.g:324:2: (otherlv_0= '[Step]' ( (lv_comment_1_0= ruleComment ) ) ( (lv_changedTurnout_2_0= ruleTurnout ) )? ( (lv_section_3_0= ruleSection ) )+ )
            {
            // InternalTestLanguage.g:324:2: (otherlv_0= '[Step]' ( (lv_comment_1_0= ruleComment ) ) ( (lv_changedTurnout_2_0= ruleTurnout ) )? ( (lv_section_3_0= ruleSection ) )+ )
            // InternalTestLanguage.g:325:3: otherlv_0= '[Step]' ( (lv_comment_1_0= ruleComment ) ) ( (lv_changedTurnout_2_0= ruleTurnout ) )? ( (lv_section_3_0= ruleSection ) )+
            {
            otherlv_0=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getStepsAccess().getStepKeyword_0());
            		
            // InternalTestLanguage.g:329:3: ( (lv_comment_1_0= ruleComment ) )
            // InternalTestLanguage.g:330:4: (lv_comment_1_0= ruleComment )
            {
            // InternalTestLanguage.g:330:4: (lv_comment_1_0= ruleComment )
            // InternalTestLanguage.g:331:5: lv_comment_1_0= ruleComment
            {

            					newCompositeNode(grammarAccess.getStepsAccess().getCommentCommentParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_comment_1_0=ruleComment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepsRule());
            					}
            					set(
            						current,
            						"comment",
            						lv_comment_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.Comment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:348:3: ( (lv_changedTurnout_2_0= ruleTurnout ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:349:4: (lv_changedTurnout_2_0= ruleTurnout )
                    {
                    // InternalTestLanguage.g:349:4: (lv_changedTurnout_2_0= ruleTurnout )
                    // InternalTestLanguage.g:350:5: lv_changedTurnout_2_0= ruleTurnout
                    {

                    					newCompositeNode(grammarAccess.getStepsAccess().getChangedTurnoutTurnoutParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_13);
                    lv_changedTurnout_2_0=ruleTurnout();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStepsRule());
                    					}
                    					set(
                    						current,
                    						"changedTurnout",
                    						lv_changedTurnout_2_0,
                    						"hu.bme.mit.modes3.test.TestLanguage.Turnout");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTestLanguage.g:367:3: ( (lv_section_3_0= ruleSection ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTestLanguage.g:368:4: (lv_section_3_0= ruleSection )
            	    {
            	    // InternalTestLanguage.g:368:4: (lv_section_3_0= ruleSection )
            	    // InternalTestLanguage.g:369:5: lv_section_3_0= ruleSection
            	    {

            	    					newCompositeNode(grammarAccess.getStepsAccess().getSectionSectionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_section_3_0=ruleSection();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStepsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"section",
            	    						lv_section_3_0,
            	    						"hu.bme.mit.modes3.test.TestLanguage.Section");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSteps"


    // $ANTLR start "entryRuleComment"
    // InternalTestLanguage.g:390:1: entryRuleComment returns [EObject current=null] : iv_ruleComment= ruleComment EOF ;
    public final EObject entryRuleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComment = null;


        try {
            // InternalTestLanguage.g:390:48: (iv_ruleComment= ruleComment EOF )
            // InternalTestLanguage.g:391:2: iv_ruleComment= ruleComment EOF
            {
             newCompositeNode(grammarAccess.getCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComment=ruleComment();

            state._fsp--;

             current =iv_ruleComment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComment"


    // $ANTLR start "ruleComment"
    // InternalTestLanguage.g:397:1: ruleComment returns [EObject current=null] : (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_comment_2_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:403:2: ( (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) )
            // InternalTestLanguage.g:404:2: (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
            {
            // InternalTestLanguage.g:404:2: (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
            // InternalTestLanguage.g:405:3: otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getCommentAccess().getShortDescriptionKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getCommentAccess().getColonKeyword_1());
            		
            // InternalTestLanguage.g:413:3: ( (lv_comment_2_0= RULE_STRING ) )
            // InternalTestLanguage.g:414:4: (lv_comment_2_0= RULE_STRING )
            {
            // InternalTestLanguage.g:414:4: (lv_comment_2_0= RULE_STRING )
            // InternalTestLanguage.g:415:5: lv_comment_2_0= RULE_STRING
            {
            lv_comment_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_comment_2_0, grammarAccess.getCommentAccess().getCommentSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"comment",
            						lv_comment_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComment"


    // $ANTLR start "entryRuleTurnout"
    // InternalTestLanguage.g:435:1: entryRuleTurnout returns [EObject current=null] : iv_ruleTurnout= ruleTurnout EOF ;
    public final EObject entryRuleTurnout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTurnout = null;


        try {
            // InternalTestLanguage.g:435:48: (iv_ruleTurnout= ruleTurnout EOF )
            // InternalTestLanguage.g:436:2: iv_ruleTurnout= ruleTurnout EOF
            {
             newCompositeNode(grammarAccess.getTurnoutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTurnout=ruleTurnout();

            state._fsp--;

             current =iv_ruleTurnout; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTurnout"


    // $ANTLR start "ruleTurnout"
    // InternalTestLanguage.g:442:1: ruleTurnout returns [EObject current=null] : (otherlv_0= 'Turnout state is ' ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) ) ) ;
    public final EObject ruleTurnout() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_turnoutState_1_1=null;
        Token lv_turnoutState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:448:2: ( (otherlv_0= 'Turnout state is ' ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) ) ) )
            // InternalTestLanguage.g:449:2: (otherlv_0= 'Turnout state is ' ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) ) )
            {
            // InternalTestLanguage.g:449:2: (otherlv_0= 'Turnout state is ' ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) ) )
            // InternalTestLanguage.g:450:3: otherlv_0= 'Turnout state is ' ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getTurnoutAccess().getTurnoutStateIsKeyword_0());
            		
            // InternalTestLanguage.g:454:3: ( ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) ) )
            // InternalTestLanguage.g:455:4: ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) )
            {
            // InternalTestLanguage.g:455:4: ( (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' ) )
            // InternalTestLanguage.g:456:5: (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' )
            {
            // InternalTestLanguage.g:456:5: (lv_turnoutState_1_1= 'STRAIGHT' | lv_turnoutState_1_2= 'DIVERGENT' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:457:6: lv_turnoutState_1_1= 'STRAIGHT'
                    {
                    lv_turnoutState_1_1=(Token)match(input,19,FOLLOW_2); 

                    						newLeafNode(lv_turnoutState_1_1, grammarAccess.getTurnoutAccess().getTurnoutStateSTRAIGHTKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTurnoutRule());
                    						}
                    						setWithLastConsumed(current, "turnoutState", lv_turnoutState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:468:6: lv_turnoutState_1_2= 'DIVERGENT'
                    {
                    lv_turnoutState_1_2=(Token)match(input,20,FOLLOW_2); 

                    						newLeafNode(lv_turnoutState_1_2, grammarAccess.getTurnoutAccess().getTurnoutStateDIVERGENTKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTurnoutRule());
                    						}
                    						setWithLastConsumed(current, "turnoutState", lv_turnoutState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTurnout"


    // $ANTLR start "entryRuleSection"
    // InternalTestLanguage.g:485:1: entryRuleSection returns [EObject current=null] : iv_ruleSection= ruleSection EOF ;
    public final EObject entryRuleSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSection = null;


        try {
            // InternalTestLanguage.g:485:48: (iv_ruleSection= ruleSection EOF )
            // InternalTestLanguage.g:486:2: iv_ruleSection= ruleSection EOF
            {
             newCompositeNode(grammarAccess.getSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSection=ruleSection();

            state._fsp--;

             current =iv_ruleSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSection"


    // $ANTLR start "ruleSection"
    // InternalTestLanguage.g:492:1: ruleSection returns [EObject current=null] : ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_DivergentSection_1_0= ruleDivergentSection ) ) ( (lv_TopSection_2_0= ruleTopSection ) ) ) ;
    public final EObject ruleSection() throws RecognitionException {
        EObject current = null;

        EObject lv_straightSection_0_0 = null;

        EObject lv_DivergentSection_1_0 = null;

        EObject lv_TopSection_2_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:498:2: ( ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_DivergentSection_1_0= ruleDivergentSection ) ) ( (lv_TopSection_2_0= ruleTopSection ) ) ) )
            // InternalTestLanguage.g:499:2: ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_DivergentSection_1_0= ruleDivergentSection ) ) ( (lv_TopSection_2_0= ruleTopSection ) ) )
            {
            // InternalTestLanguage.g:499:2: ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_DivergentSection_1_0= ruleDivergentSection ) ) ( (lv_TopSection_2_0= ruleTopSection ) ) )
            // InternalTestLanguage.g:500:3: ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_DivergentSection_1_0= ruleDivergentSection ) ) ( (lv_TopSection_2_0= ruleTopSection ) )
            {
            // InternalTestLanguage.g:500:3: ( (lv_straightSection_0_0= ruleStraightSection ) )
            // InternalTestLanguage.g:501:4: (lv_straightSection_0_0= ruleStraightSection )
            {
            // InternalTestLanguage.g:501:4: (lv_straightSection_0_0= ruleStraightSection )
            // InternalTestLanguage.g:502:5: lv_straightSection_0_0= ruleStraightSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getStraightSectionStraightSectionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_straightSection_0_0=ruleStraightSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSectionRule());
            					}
            					set(
            						current,
            						"straightSection",
            						lv_straightSection_0_0,
            						"hu.bme.mit.modes3.test.TestLanguage.StraightSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:519:3: ( (lv_DivergentSection_1_0= ruleDivergentSection ) )
            // InternalTestLanguage.g:520:4: (lv_DivergentSection_1_0= ruleDivergentSection )
            {
            // InternalTestLanguage.g:520:4: (lv_DivergentSection_1_0= ruleDivergentSection )
            // InternalTestLanguage.g:521:5: lv_DivergentSection_1_0= ruleDivergentSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getDivergentSectionDivergentSectionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_DivergentSection_1_0=ruleDivergentSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSectionRule());
            					}
            					set(
            						current,
            						"DivergentSection",
            						lv_DivergentSection_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.DivergentSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:538:3: ( (lv_TopSection_2_0= ruleTopSection ) )
            // InternalTestLanguage.g:539:4: (lv_TopSection_2_0= ruleTopSection )
            {
            // InternalTestLanguage.g:539:4: (lv_TopSection_2_0= ruleTopSection )
            // InternalTestLanguage.g:540:5: lv_TopSection_2_0= ruleTopSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getTopSectionTopSectionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_TopSection_2_0=ruleTopSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSectionRule());
            					}
            					set(
            						current,
            						"TopSection",
            						lv_TopSection_2_0,
            						"hu.bme.mit.modes3.test.TestLanguage.TopSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSection"


    // $ANTLR start "entryRuleStraightSection"
    // InternalTestLanguage.g:561:1: entryRuleStraightSection returns [EObject current=null] : iv_ruleStraightSection= ruleStraightSection EOF ;
    public final EObject entryRuleStraightSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStraightSection = null;


        try {
            // InternalTestLanguage.g:561:56: (iv_ruleStraightSection= ruleStraightSection EOF )
            // InternalTestLanguage.g:562:2: iv_ruleStraightSection= ruleStraightSection EOF
            {
             newCompositeNode(grammarAccess.getStraightSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStraightSection=ruleStraightSection();

            state._fsp--;

             current =iv_ruleStraightSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStraightSection"


    // $ANTLR start "ruleStraightSection"
    // InternalTestLanguage.g:568:1: ruleStraightSection returns [EObject current=null] : (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) ) ;
    public final EObject ruleStraightSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_straightSectionState_1_1=null;
        Token lv_straightSectionState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:574:2: ( (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) ) )
            // InternalTestLanguage.g:575:2: (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) )
            {
            // InternalTestLanguage.g:575:2: (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) )
            // InternalTestLanguage.g:576:3: otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStraightSectionAccess().getSectionConnectingFromSTRAIGHTIsKeyword_0());
            		
            // InternalTestLanguage.g:580:3: ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:581:4: ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:581:4: ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:582:5: (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:582:5: (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==23) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTestLanguage.g:583:6: lv_straightSectionState_1_1= 'FREE'
                    {
                    lv_straightSectionState_1_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_straightSectionState_1_1, grammarAccess.getStraightSectionAccess().getStraightSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightSectionRule());
                    						}
                    						setWithLastConsumed(current, "straightSectionState", lv_straightSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:594:6: lv_straightSectionState_1_2= 'OCCUPIED'
                    {
                    lv_straightSectionState_1_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_straightSectionState_1_2, grammarAccess.getStraightSectionAccess().getStraightSectionStateOCCUPIEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightSectionRule());
                    						}
                    						setWithLastConsumed(current, "straightSectionState", lv_straightSectionState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStraightSection"


    // $ANTLR start "entryRuleDivergentSection"
    // InternalTestLanguage.g:611:1: entryRuleDivergentSection returns [EObject current=null] : iv_ruleDivergentSection= ruleDivergentSection EOF ;
    public final EObject entryRuleDivergentSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivergentSection = null;


        try {
            // InternalTestLanguage.g:611:57: (iv_ruleDivergentSection= ruleDivergentSection EOF )
            // InternalTestLanguage.g:612:2: iv_ruleDivergentSection= ruleDivergentSection EOF
            {
             newCompositeNode(grammarAccess.getDivergentSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDivergentSection=ruleDivergentSection();

            state._fsp--;

             current =iv_ruleDivergentSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivergentSection"


    // $ANTLR start "ruleDivergentSection"
    // InternalTestLanguage.g:618:1: ruleDivergentSection returns [EObject current=null] : (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) ) ;
    public final EObject ruleDivergentSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_divergentSectionState_1_1=null;
        Token lv_divergentSectionState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:624:2: ( (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) ) )
            // InternalTestLanguage.g:625:2: (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) )
            {
            // InternalTestLanguage.g:625:2: (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) )
            // InternalTestLanguage.g:626:3: otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getDivergentSectionAccess().getSectionConnectingFromDIVERGENTIsKeyword_0());
            		
            // InternalTestLanguage.g:630:3: ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:631:4: ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:631:4: ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:632:5: (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:632:5: (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            else if ( (LA7_0==23) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTestLanguage.g:633:6: lv_divergentSectionState_1_1= 'FREE'
                    {
                    lv_divergentSectionState_1_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_divergentSectionState_1_1, grammarAccess.getDivergentSectionAccess().getDivergentSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentSectionRule());
                    						}
                    						setWithLastConsumed(current, "divergentSectionState", lv_divergentSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:644:6: lv_divergentSectionState_1_2= 'OCCUPIED'
                    {
                    lv_divergentSectionState_1_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_divergentSectionState_1_2, grammarAccess.getDivergentSectionAccess().getDivergentSectionStateOCCUPIEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentSectionRule());
                    						}
                    						setWithLastConsumed(current, "divergentSectionState", lv_divergentSectionState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivergentSection"


    // $ANTLR start "entryRuleTopSection"
    // InternalTestLanguage.g:661:1: entryRuleTopSection returns [EObject current=null] : iv_ruleTopSection= ruleTopSection EOF ;
    public final EObject entryRuleTopSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopSection = null;


        try {
            // InternalTestLanguage.g:661:51: (iv_ruleTopSection= ruleTopSection EOF )
            // InternalTestLanguage.g:662:2: iv_ruleTopSection= ruleTopSection EOF
            {
             newCompositeNode(grammarAccess.getTopSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopSection=ruleTopSection();

            state._fsp--;

             current =iv_ruleTopSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopSection"


    // $ANTLR start "ruleTopSection"
    // InternalTestLanguage.g:668:1: ruleTopSection returns [EObject current=null] : (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) ) ;
    public final EObject ruleTopSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_topSectionState_1_1=null;
        Token lv_topSectionState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:674:2: ( (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) ) )
            // InternalTestLanguage.g:675:2: (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) )
            {
            // InternalTestLanguage.g:675:2: (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) )
            // InternalTestLanguage.g:676:3: otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getTopSectionAccess().getSectionConnectingFromTOPIsKeyword_0());
            		
            // InternalTestLanguage.g:680:3: ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:681:4: ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:681:4: ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:682:5: (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:682:5: (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestLanguage.g:683:6: lv_topSectionState_1_1= 'FREE'
                    {
                    lv_topSectionState_1_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_topSectionState_1_1, grammarAccess.getTopSectionAccess().getTopSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopSectionRule());
                    						}
                    						setWithLastConsumed(current, "topSectionState", lv_topSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:694:6: lv_topSectionState_1_2= 'OCCUPIED'
                    {
                    lv_topSectionState_1_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_topSectionState_1_2, grammarAccess.getTopSectionAccess().getTopSectionStateOCCUPIEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopSectionRule());
                    						}
                    						setWithLastConsumed(current, "topSectionState", lv_topSectionState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopSection"


    // $ANTLR start "entryRuleExpectations"
    // InternalTestLanguage.g:711:1: entryRuleExpectations returns [EObject current=null] : iv_ruleExpectations= ruleExpectations EOF ;
    public final EObject entryRuleExpectations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpectations = null;


        try {
            // InternalTestLanguage.g:711:53: (iv_ruleExpectations= ruleExpectations EOF )
            // InternalTestLanguage.g:712:2: iv_ruleExpectations= ruleExpectations EOF
            {
             newCompositeNode(grammarAccess.getExpectationsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpectations=ruleExpectations();

            state._fsp--;

             current =iv_ruleExpectations; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpectations"


    // $ANTLR start "ruleExpectations"
    // InternalTestLanguage.g:718:1: ruleExpectations returns [EObject current=null] : (otherlv_0= '[Expected]' ( (lv_straightExpectation_1_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_3_0= ruleTopExpectation ) ) ) ;
    public final EObject ruleExpectations() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_straightExpectation_1_0 = null;

        EObject lv_divergentExpectation_2_0 = null;

        EObject lv_topExpectation_3_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:724:2: ( (otherlv_0= '[Expected]' ( (lv_straightExpectation_1_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_3_0= ruleTopExpectation ) ) ) )
            // InternalTestLanguage.g:725:2: (otherlv_0= '[Expected]' ( (lv_straightExpectation_1_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_3_0= ruleTopExpectation ) ) )
            {
            // InternalTestLanguage.g:725:2: (otherlv_0= '[Expected]' ( (lv_straightExpectation_1_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_3_0= ruleTopExpectation ) ) )
            // InternalTestLanguage.g:726:3: otherlv_0= '[Expected]' ( (lv_straightExpectation_1_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_3_0= ruleTopExpectation ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getExpectationsAccess().getExpectedKeyword_0());
            		
            // InternalTestLanguage.g:730:3: ( (lv_straightExpectation_1_0= ruleStraightExpectation ) )
            // InternalTestLanguage.g:731:4: (lv_straightExpectation_1_0= ruleStraightExpectation )
            {
            // InternalTestLanguage.g:731:4: (lv_straightExpectation_1_0= ruleStraightExpectation )
            // InternalTestLanguage.g:732:5: lv_straightExpectation_1_0= ruleStraightExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getStraightExpectationStraightExpectationParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_21);
            lv_straightExpectation_1_0=ruleStraightExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"straightExpectation",
            						lv_straightExpectation_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.StraightExpectation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:749:3: ( (lv_divergentExpectation_2_0= ruleDivergentExpectation ) )
            // InternalTestLanguage.g:750:4: (lv_divergentExpectation_2_0= ruleDivergentExpectation )
            {
            // InternalTestLanguage.g:750:4: (lv_divergentExpectation_2_0= ruleDivergentExpectation )
            // InternalTestLanguage.g:751:5: lv_divergentExpectation_2_0= ruleDivergentExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getDivergentExpectationDivergentExpectationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_22);
            lv_divergentExpectation_2_0=ruleDivergentExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"divergentExpectation",
            						lv_divergentExpectation_2_0,
            						"hu.bme.mit.modes3.test.TestLanguage.DivergentExpectation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:768:3: ( (lv_topExpectation_3_0= ruleTopExpectation ) )
            // InternalTestLanguage.g:769:4: (lv_topExpectation_3_0= ruleTopExpectation )
            {
            // InternalTestLanguage.g:769:4: (lv_topExpectation_3_0= ruleTopExpectation )
            // InternalTestLanguage.g:770:5: lv_topExpectation_3_0= ruleTopExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getTopExpectationTopExpectationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_topExpectation_3_0=ruleTopExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"topExpectation",
            						lv_topExpectation_3_0,
            						"hu.bme.mit.modes3.test.TestLanguage.TopExpectation");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpectations"


    // $ANTLR start "entryRuleStraightExpectation"
    // InternalTestLanguage.g:791:1: entryRuleStraightExpectation returns [EObject current=null] : iv_ruleStraightExpectation= ruleStraightExpectation EOF ;
    public final EObject entryRuleStraightExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStraightExpectation = null;


        try {
            // InternalTestLanguage.g:791:60: (iv_ruleStraightExpectation= ruleStraightExpectation EOF )
            // InternalTestLanguage.g:792:2: iv_ruleStraightExpectation= ruleStraightExpectation EOF
            {
             newCompositeNode(grammarAccess.getStraightExpectationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStraightExpectation=ruleStraightExpectation();

            state._fsp--;

             current =iv_ruleStraightExpectation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStraightExpectation"


    // $ANTLR start "ruleStraightExpectation"
    // InternalTestLanguage.g:798:1: ruleStraightExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) ) ;
    public final EObject ruleStraightExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_straightExpectedState_1_1=null;
        Token lv_straightExpectedState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:804:2: ( (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) ) )
            // InternalTestLanguage.g:805:2: (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) )
            {
            // InternalTestLanguage.g:805:2: (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) )
            // InternalTestLanguage.g:806:3: otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStraightExpectationAccess().getSectionConnectingFromSTRAIGHTIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:810:3: ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:811:4: ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:811:4: ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:812:5: (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:812:5: (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            else if ( (LA9_0==29) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestLanguage.g:813:6: lv_straightExpectedState_1_1= 'ENABLED'
                    {
                    lv_straightExpectedState_1_1=(Token)match(input,28,FOLLOW_2); 

                    						newLeafNode(lv_straightExpectedState_1_1, grammarAccess.getStraightExpectationAccess().getStraightExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightExpectationRule());
                    						}
                    						setWithLastConsumed(current, "straightExpectedState", lv_straightExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:824:6: lv_straightExpectedState_1_2= 'DISABLED'
                    {
                    lv_straightExpectedState_1_2=(Token)match(input,29,FOLLOW_2); 

                    						newLeafNode(lv_straightExpectedState_1_2, grammarAccess.getStraightExpectationAccess().getStraightExpectedStateDISABLEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightExpectationRule());
                    						}
                    						setWithLastConsumed(current, "straightExpectedState", lv_straightExpectedState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStraightExpectation"


    // $ANTLR start "entryRuleDivergentExpectation"
    // InternalTestLanguage.g:841:1: entryRuleDivergentExpectation returns [EObject current=null] : iv_ruleDivergentExpectation= ruleDivergentExpectation EOF ;
    public final EObject entryRuleDivergentExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivergentExpectation = null;


        try {
            // InternalTestLanguage.g:841:61: (iv_ruleDivergentExpectation= ruleDivergentExpectation EOF )
            // InternalTestLanguage.g:842:2: iv_ruleDivergentExpectation= ruleDivergentExpectation EOF
            {
             newCompositeNode(grammarAccess.getDivergentExpectationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDivergentExpectation=ruleDivergentExpectation();

            state._fsp--;

             current =iv_ruleDivergentExpectation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivergentExpectation"


    // $ANTLR start "ruleDivergentExpectation"
    // InternalTestLanguage.g:848:1: ruleDivergentExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) ) ;
    public final EObject ruleDivergentExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_divergentExpectedState_1_1=null;
        Token lv_divergentExpectedState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:854:2: ( (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) ) )
            // InternalTestLanguage.g:855:2: (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) )
            {
            // InternalTestLanguage.g:855:2: (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) )
            // InternalTestLanguage.g:856:3: otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getDivergentExpectationAccess().getSectionConnectingFromDIVERGENTIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:860:3: ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:861:4: ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:861:4: ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:862:5: (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:862:5: (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            else if ( (LA10_0==29) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:863:6: lv_divergentExpectedState_1_1= 'ENABLED'
                    {
                    lv_divergentExpectedState_1_1=(Token)match(input,28,FOLLOW_2); 

                    						newLeafNode(lv_divergentExpectedState_1_1, grammarAccess.getDivergentExpectationAccess().getDivergentExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentExpectationRule());
                    						}
                    						setWithLastConsumed(current, "divergentExpectedState", lv_divergentExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:874:6: lv_divergentExpectedState_1_2= 'DISABLED'
                    {
                    lv_divergentExpectedState_1_2=(Token)match(input,29,FOLLOW_2); 

                    						newLeafNode(lv_divergentExpectedState_1_2, grammarAccess.getDivergentExpectationAccess().getDivergentExpectedStateDISABLEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentExpectationRule());
                    						}
                    						setWithLastConsumed(current, "divergentExpectedState", lv_divergentExpectedState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivergentExpectation"


    // $ANTLR start "entryRuleTopExpectation"
    // InternalTestLanguage.g:891:1: entryRuleTopExpectation returns [EObject current=null] : iv_ruleTopExpectation= ruleTopExpectation EOF ;
    public final EObject entryRuleTopExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopExpectation = null;


        try {
            // InternalTestLanguage.g:891:55: (iv_ruleTopExpectation= ruleTopExpectation EOF )
            // InternalTestLanguage.g:892:2: iv_ruleTopExpectation= ruleTopExpectation EOF
            {
             newCompositeNode(grammarAccess.getTopExpectationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopExpectation=ruleTopExpectation();

            state._fsp--;

             current =iv_ruleTopExpectation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopExpectation"


    // $ANTLR start "ruleTopExpectation"
    // InternalTestLanguage.g:898:1: ruleTopExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) ) ;
    public final EObject ruleTopExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_topExpectedState_1_1=null;
        Token lv_topExpectedState_1_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:904:2: ( (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) ) )
            // InternalTestLanguage.g:905:2: (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) )
            {
            // InternalTestLanguage.g:905:2: (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) )
            // InternalTestLanguage.g:906:3: otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTopExpectationAccess().getSectionConnectingFromTOPIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:910:3: ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:911:4: ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:911:4: ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:912:5: (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:912:5: (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalTestLanguage.g:913:6: lv_topExpectedState_1_1= 'ENABLED'
                    {
                    lv_topExpectedState_1_1=(Token)match(input,28,FOLLOW_2); 

                    						newLeafNode(lv_topExpectedState_1_1, grammarAccess.getTopExpectationAccess().getTopExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopExpectationRule());
                    						}
                    						setWithLastConsumed(current, "topExpectedState", lv_topExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:924:6: lv_topExpectedState_1_2= 'DISABLED'
                    {
                    lv_topExpectedState_1_2=(Token)match(input,29,FOLLOW_2); 

                    						newLeafNode(lv_topExpectedState_1_2, grammarAccess.getTopExpectationAccess().getTopExpectedStateDISABLEDKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopExpectationRule());
                    						}
                    						setWithLastConsumed(current, "topExpectedState", lv_topExpectedState_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopExpectation"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000030000000L});

}