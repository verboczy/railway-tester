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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'[TestCase]'", "'Name of the test case is '", "'Short description'", "':'", "'[Component]'", "'Turnout '", "' is '", "'STRAIGHT'", "'DIVERGENT'", "'Section connecting from STRAIGHT is '", "'FREE'", "'OCCUPIED'", "'Straight id'", "'Section connecting from DIVERGENT is '", "'Divergent id'", "'Section connecting from TOP is '", "'Top id'", "'[ExpectedComponents]'", "'Section connecting from STRAIGHT is expected to be '", "'ENABLED'", "'DISABLED'", "'Section connecting from DIVERGENT is expected to be '", "'Section connecting from TOP is expected to be '"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
    // InternalTestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( (lv_caseDescription_0_0= ruleCaseDescription ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_caseDescription_0_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:77:2: ( ( (lv_caseDescription_0_0= ruleCaseDescription ) )* )
            // InternalTestLanguage.g:78:2: ( (lv_caseDescription_0_0= ruleCaseDescription ) )*
            {
            // InternalTestLanguage.g:78:2: ( (lv_caseDescription_0_0= ruleCaseDescription ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:79:3: (lv_caseDescription_0_0= ruleCaseDescription )
            	    {
            	    // InternalTestLanguage.g:79:3: (lv_caseDescription_0_0= ruleCaseDescription )
            	    // InternalTestLanguage.g:80:4: lv_caseDescription_0_0= ruleCaseDescription
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getCaseDescriptionCaseDescriptionParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_caseDescription_0_0=ruleCaseDescription();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"caseDescription",
            	    					lv_caseDescription_0_0,
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


    // $ANTLR start "entryRuleCaseDescription"
    // InternalTestLanguage.g:100:1: entryRuleCaseDescription returns [EObject current=null] : iv_ruleCaseDescription= ruleCaseDescription EOF ;
    public final EObject entryRuleCaseDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseDescription = null;


        try {
            // InternalTestLanguage.g:100:56: (iv_ruleCaseDescription= ruleCaseDescription EOF )
            // InternalTestLanguage.g:101:2: iv_ruleCaseDescription= ruleCaseDescription EOF
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
    // InternalTestLanguage.g:107:1: ruleCaseDescription returns [EObject current=null] : (otherlv_0= '[TestCase]' ( (lv_caseName_1_0= ruleCaseName ) ) ( (lv_comment_2_0= ruleComment ) )? ( (lv_components_3_0= ruleComponent ) )+ ( (lv_expect_4_0= ruleExpectations ) )+ ) ;
    public final EObject ruleCaseDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_caseName_1_0 = null;

        EObject lv_comment_2_0 = null;

        EObject lv_components_3_0 = null;

        EObject lv_expect_4_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:113:2: ( (otherlv_0= '[TestCase]' ( (lv_caseName_1_0= ruleCaseName ) ) ( (lv_comment_2_0= ruleComment ) )? ( (lv_components_3_0= ruleComponent ) )+ ( (lv_expect_4_0= ruleExpectations ) )+ ) )
            // InternalTestLanguage.g:114:2: (otherlv_0= '[TestCase]' ( (lv_caseName_1_0= ruleCaseName ) ) ( (lv_comment_2_0= ruleComment ) )? ( (lv_components_3_0= ruleComponent ) )+ ( (lv_expect_4_0= ruleExpectations ) )+ )
            {
            // InternalTestLanguage.g:114:2: (otherlv_0= '[TestCase]' ( (lv_caseName_1_0= ruleCaseName ) ) ( (lv_comment_2_0= ruleComment ) )? ( (lv_components_3_0= ruleComponent ) )+ ( (lv_expect_4_0= ruleExpectations ) )+ )
            // InternalTestLanguage.g:115:3: otherlv_0= '[TestCase]' ( (lv_caseName_1_0= ruleCaseName ) ) ( (lv_comment_2_0= ruleComment ) )? ( (lv_components_3_0= ruleComponent ) )+ ( (lv_expect_4_0= ruleExpectations ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseDescriptionAccess().getTestCaseKeyword_0());
            		
            // InternalTestLanguage.g:119:3: ( (lv_caseName_1_0= ruleCaseName ) )
            // InternalTestLanguage.g:120:4: (lv_caseName_1_0= ruleCaseName )
            {
            // InternalTestLanguage.g:120:4: (lv_caseName_1_0= ruleCaseName )
            // InternalTestLanguage.g:121:5: lv_caseName_1_0= ruleCaseName
            {

            					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getCaseNameCaseNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_caseName_1_0=ruleCaseName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            					}
            					set(
            						current,
            						"caseName",
            						lv_caseName_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.CaseName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:138:3: ( (lv_comment_2_0= ruleComment ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:139:4: (lv_comment_2_0= ruleComment )
                    {
                    // InternalTestLanguage.g:139:4: (lv_comment_2_0= ruleComment )
                    // InternalTestLanguage.g:140:5: lv_comment_2_0= ruleComment
                    {

                    					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getCommentCommentParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_comment_2_0=ruleComment();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
                    					}
                    					set(
                    						current,
                    						"comment",
                    						lv_comment_2_0,
                    						"hu.bme.mit.modes3.test.TestLanguage.Comment");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTestLanguage.g:157:3: ( (lv_components_3_0= ruleComponent ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTestLanguage.g:158:4: (lv_components_3_0= ruleComponent )
            	    {
            	    // InternalTestLanguage.g:158:4: (lv_components_3_0= ruleComponent )
            	    // InternalTestLanguage.g:159:5: lv_components_3_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getComponentsComponentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_components_3_0=ruleComponent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_3_0,
            	    						"hu.bme.mit.modes3.test.TestLanguage.Component");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // InternalTestLanguage.g:176:3: ( (lv_expect_4_0= ruleExpectations ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==28) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTestLanguage.g:177:4: (lv_expect_4_0= ruleExpectations )
            	    {
            	    // InternalTestLanguage.g:177:4: (lv_expect_4_0= ruleExpectations )
            	    // InternalTestLanguage.g:178:5: lv_expect_4_0= ruleExpectations
            	    {

            	    					newCompositeNode(grammarAccess.getCaseDescriptionAccess().getExpectExpectationsParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_expect_4_0=ruleExpectations();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCaseDescriptionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"expect",
            	    						lv_expect_4_0,
            	    						"hu.bme.mit.modes3.test.TestLanguage.Expectations");
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
    // $ANTLR end "ruleCaseDescription"


    // $ANTLR start "entryRuleCaseName"
    // InternalTestLanguage.g:199:1: entryRuleCaseName returns [EObject current=null] : iv_ruleCaseName= ruleCaseName EOF ;
    public final EObject entryRuleCaseName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseName = null;


        try {
            // InternalTestLanguage.g:199:49: (iv_ruleCaseName= ruleCaseName EOF )
            // InternalTestLanguage.g:200:2: iv_ruleCaseName= ruleCaseName EOF
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
    // InternalTestLanguage.g:206:1: ruleCaseName returns [EObject current=null] : (otherlv_0= 'Name of the test case is ' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCaseName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:212:2: ( (otherlv_0= 'Name of the test case is ' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTestLanguage.g:213:2: (otherlv_0= 'Name of the test case is ' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTestLanguage.g:213:2: (otherlv_0= 'Name of the test case is ' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTestLanguage.g:214:3: otherlv_0= 'Name of the test case is ' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseNameAccess().getNameOfTheTestCaseIsKeyword_0());
            		
            // InternalTestLanguage.g:218:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTestLanguage.g:219:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTestLanguage.g:219:4: (lv_name_1_0= RULE_ID )
            // InternalTestLanguage.g:220:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCaseNameAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCaseNameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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


    // $ANTLR start "entryRuleComment"
    // InternalTestLanguage.g:240:1: entryRuleComment returns [EObject current=null] : iv_ruleComment= ruleComment EOF ;
    public final EObject entryRuleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComment = null;


        try {
            // InternalTestLanguage.g:240:48: (iv_ruleComment= ruleComment EOF )
            // InternalTestLanguage.g:241:2: iv_ruleComment= ruleComment EOF
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
    // InternalTestLanguage.g:247:1: ruleComment returns [EObject current=null] : (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_comment_2_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:253:2: ( (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) )
            // InternalTestLanguage.g:254:2: (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
            {
            // InternalTestLanguage.g:254:2: (otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
            // InternalTestLanguage.g:255:3: otherlv_0= 'Short description' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getCommentAccess().getShortDescriptionKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCommentAccess().getColonKeyword_1());
            		
            // InternalTestLanguage.g:263:3: ( (lv_comment_2_0= RULE_STRING ) )
            // InternalTestLanguage.g:264:4: (lv_comment_2_0= RULE_STRING )
            {
            // InternalTestLanguage.g:264:4: (lv_comment_2_0= RULE_STRING )
            // InternalTestLanguage.g:265:5: lv_comment_2_0= RULE_STRING
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


    // $ANTLR start "entryRuleComponent"
    // InternalTestLanguage.g:285:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalTestLanguage.g:285:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalTestLanguage.g:286:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
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
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalTestLanguage.g:292:1: ruleComponent returns [EObject current=null] : (otherlv_0= '[Component]' ( (lv_turnout_1_0= ruleTurnout ) ) ( (lv_section_2_0= ruleSection ) ) ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_turnout_1_0 = null;

        EObject lv_section_2_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:298:2: ( (otherlv_0= '[Component]' ( (lv_turnout_1_0= ruleTurnout ) ) ( (lv_section_2_0= ruleSection ) ) ) )
            // InternalTestLanguage.g:299:2: (otherlv_0= '[Component]' ( (lv_turnout_1_0= ruleTurnout ) ) ( (lv_section_2_0= ruleSection ) ) )
            {
            // InternalTestLanguage.g:299:2: (otherlv_0= '[Component]' ( (lv_turnout_1_0= ruleTurnout ) ) ( (lv_section_2_0= ruleSection ) ) )
            // InternalTestLanguage.g:300:3: otherlv_0= '[Component]' ( (lv_turnout_1_0= ruleTurnout ) ) ( (lv_section_2_0= ruleSection ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
            		
            // InternalTestLanguage.g:304:3: ( (lv_turnout_1_0= ruleTurnout ) )
            // InternalTestLanguage.g:305:4: (lv_turnout_1_0= ruleTurnout )
            {
            // InternalTestLanguage.g:305:4: (lv_turnout_1_0= ruleTurnout )
            // InternalTestLanguage.g:306:5: lv_turnout_1_0= ruleTurnout
            {

            					newCompositeNode(grammarAccess.getComponentAccess().getTurnoutTurnoutParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_turnout_1_0=ruleTurnout();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRule());
            					}
            					set(
            						current,
            						"turnout",
            						lv_turnout_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.Turnout");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:323:3: ( (lv_section_2_0= ruleSection ) )
            // InternalTestLanguage.g:324:4: (lv_section_2_0= ruleSection )
            {
            // InternalTestLanguage.g:324:4: (lv_section_2_0= ruleSection )
            // InternalTestLanguage.g:325:5: lv_section_2_0= ruleSection
            {

            					newCompositeNode(grammarAccess.getComponentAccess().getSectionSectionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_section_2_0=ruleSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRule());
            					}
            					set(
            						current,
            						"section",
            						lv_section_2_0,
            						"hu.bme.mit.modes3.test.TestLanguage.Section");
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
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleTurnout"
    // InternalTestLanguage.g:346:1: entryRuleTurnout returns [EObject current=null] : iv_ruleTurnout= ruleTurnout EOF ;
    public final EObject entryRuleTurnout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTurnout = null;


        try {
            // InternalTestLanguage.g:346:48: (iv_ruleTurnout= ruleTurnout EOF )
            // InternalTestLanguage.g:347:2: iv_ruleTurnout= ruleTurnout EOF
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
    // InternalTestLanguage.g:353:1: ruleTurnout returns [EObject current=null] : (otherlv_0= 'Turnout ' ( (lv_turnoutID_1_0= RULE_INT ) ) otherlv_2= ' is ' ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) ) ) ;
    public final EObject ruleTurnout() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_turnoutID_1_0=null;
        Token otherlv_2=null;
        Token lv_turnoutState_3_1=null;
        Token lv_turnoutState_3_2=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:359:2: ( (otherlv_0= 'Turnout ' ( (lv_turnoutID_1_0= RULE_INT ) ) otherlv_2= ' is ' ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) ) ) )
            // InternalTestLanguage.g:360:2: (otherlv_0= 'Turnout ' ( (lv_turnoutID_1_0= RULE_INT ) ) otherlv_2= ' is ' ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) ) )
            {
            // InternalTestLanguage.g:360:2: (otherlv_0= 'Turnout ' ( (lv_turnoutID_1_0= RULE_INT ) ) otherlv_2= ' is ' ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) ) )
            // InternalTestLanguage.g:361:3: otherlv_0= 'Turnout ' ( (lv_turnoutID_1_0= RULE_INT ) ) otherlv_2= ' is ' ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getTurnoutAccess().getTurnoutKeyword_0());
            		
            // InternalTestLanguage.g:365:3: ( (lv_turnoutID_1_0= RULE_INT ) )
            // InternalTestLanguage.g:366:4: (lv_turnoutID_1_0= RULE_INT )
            {
            // InternalTestLanguage.g:366:4: (lv_turnoutID_1_0= RULE_INT )
            // InternalTestLanguage.g:367:5: lv_turnoutID_1_0= RULE_INT
            {
            lv_turnoutID_1_0=(Token)match(input,RULE_INT,FOLLOW_14); 

            					newLeafNode(lv_turnoutID_1_0, grammarAccess.getTurnoutAccess().getTurnoutIDINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTurnoutRule());
            					}
            					setWithLastConsumed(
            						current,
            						"turnoutID",
            						lv_turnoutID_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getTurnoutAccess().getIsKeyword_2());
            		
            // InternalTestLanguage.g:387:3: ( ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) ) )
            // InternalTestLanguage.g:388:4: ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) )
            {
            // InternalTestLanguage.g:388:4: ( (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' ) )
            // InternalTestLanguage.g:389:5: (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' )
            {
            // InternalTestLanguage.g:389:5: (lv_turnoutState_3_1= 'STRAIGHT' | lv_turnoutState_3_2= 'DIVERGENT' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:390:6: lv_turnoutState_3_1= 'STRAIGHT'
                    {
                    lv_turnoutState_3_1=(Token)match(input,18,FOLLOW_2); 

                    						newLeafNode(lv_turnoutState_3_1, grammarAccess.getTurnoutAccess().getTurnoutStateSTRAIGHTKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTurnoutRule());
                    						}
                    						setWithLastConsumed(current, "turnoutState", lv_turnoutState_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:401:6: lv_turnoutState_3_2= 'DIVERGENT'
                    {
                    lv_turnoutState_3_2=(Token)match(input,19,FOLLOW_2); 

                    						newLeafNode(lv_turnoutState_3_2, grammarAccess.getTurnoutAccess().getTurnoutStateDIVERGENTKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTurnoutRule());
                    						}
                    						setWithLastConsumed(current, "turnoutState", lv_turnoutState_3_2, null);
                    					

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
    // InternalTestLanguage.g:418:1: entryRuleSection returns [EObject current=null] : iv_ruleSection= ruleSection EOF ;
    public final EObject entryRuleSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSection = null;


        try {
            // InternalTestLanguage.g:418:48: (iv_ruleSection= ruleSection EOF )
            // InternalTestLanguage.g:419:2: iv_ruleSection= ruleSection EOF
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
    // InternalTestLanguage.g:425:1: ruleSection returns [EObject current=null] : ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_divergentSection_1_0= ruleDivergentSection ) ) ( (lv_topSection_2_0= ruleTopSection ) ) ) ;
    public final EObject ruleSection() throws RecognitionException {
        EObject current = null;

        EObject lv_straightSection_0_0 = null;

        EObject lv_divergentSection_1_0 = null;

        EObject lv_topSection_2_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:431:2: ( ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_divergentSection_1_0= ruleDivergentSection ) ) ( (lv_topSection_2_0= ruleTopSection ) ) ) )
            // InternalTestLanguage.g:432:2: ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_divergentSection_1_0= ruleDivergentSection ) ) ( (lv_topSection_2_0= ruleTopSection ) ) )
            {
            // InternalTestLanguage.g:432:2: ( ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_divergentSection_1_0= ruleDivergentSection ) ) ( (lv_topSection_2_0= ruleTopSection ) ) )
            // InternalTestLanguage.g:433:3: ( (lv_straightSection_0_0= ruleStraightSection ) ) ( (lv_divergentSection_1_0= ruleDivergentSection ) ) ( (lv_topSection_2_0= ruleTopSection ) )
            {
            // InternalTestLanguage.g:433:3: ( (lv_straightSection_0_0= ruleStraightSection ) )
            // InternalTestLanguage.g:434:4: (lv_straightSection_0_0= ruleStraightSection )
            {
            // InternalTestLanguage.g:434:4: (lv_straightSection_0_0= ruleStraightSection )
            // InternalTestLanguage.g:435:5: lv_straightSection_0_0= ruleStraightSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getStraightSectionStraightSectionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
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

            // InternalTestLanguage.g:452:3: ( (lv_divergentSection_1_0= ruleDivergentSection ) )
            // InternalTestLanguage.g:453:4: (lv_divergentSection_1_0= ruleDivergentSection )
            {
            // InternalTestLanguage.g:453:4: (lv_divergentSection_1_0= ruleDivergentSection )
            // InternalTestLanguage.g:454:5: lv_divergentSection_1_0= ruleDivergentSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getDivergentSectionDivergentSectionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
            lv_divergentSection_1_0=ruleDivergentSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSectionRule());
            					}
            					set(
            						current,
            						"divergentSection",
            						lv_divergentSection_1_0,
            						"hu.bme.mit.modes3.test.TestLanguage.DivergentSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:471:3: ( (lv_topSection_2_0= ruleTopSection ) )
            // InternalTestLanguage.g:472:4: (lv_topSection_2_0= ruleTopSection )
            {
            // InternalTestLanguage.g:472:4: (lv_topSection_2_0= ruleTopSection )
            // InternalTestLanguage.g:473:5: lv_topSection_2_0= ruleTopSection
            {

            					newCompositeNode(grammarAccess.getSectionAccess().getTopSectionTopSectionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_topSection_2_0=ruleTopSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSectionRule());
            					}
            					set(
            						current,
            						"topSection",
            						lv_topSection_2_0,
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
    // InternalTestLanguage.g:494:1: entryRuleStraightSection returns [EObject current=null] : iv_ruleStraightSection= ruleStraightSection EOF ;
    public final EObject entryRuleStraightSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStraightSection = null;


        try {
            // InternalTestLanguage.g:494:56: (iv_ruleStraightSection= ruleStraightSection EOF )
            // InternalTestLanguage.g:495:2: iv_ruleStraightSection= ruleStraightSection EOF
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
    // InternalTestLanguage.g:501:1: ruleStraightSection returns [EObject current=null] : (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleStraightSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_straightSectionState_1_1=null;
        Token lv_straightSectionState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_strID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:507:2: ( (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:508:2: (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:508:2: (otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:509:3: otherlv_0= 'Section connecting from STRAIGHT is ' ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getStraightSectionAccess().getSectionConnectingFromSTRAIGHTIsKeyword_0());
            		
            // InternalTestLanguage.g:513:3: ( ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:514:4: ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:514:4: ( (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:515:5: (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:515:5: (lv_straightSectionState_1_1= 'FREE' | lv_straightSectionState_1_2= 'OCCUPIED' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTestLanguage.g:516:6: lv_straightSectionState_1_1= 'FREE'
                    {
                    lv_straightSectionState_1_1=(Token)match(input,21,FOLLOW_19); 

                    						newLeafNode(lv_straightSectionState_1_1, grammarAccess.getStraightSectionAccess().getStraightSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightSectionRule());
                    						}
                    						setWithLastConsumed(current, "straightSectionState", lv_straightSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:527:6: lv_straightSectionState_1_2= 'OCCUPIED'
                    {
                    lv_straightSectionState_1_2=(Token)match(input,22,FOLLOW_19); 

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

            otherlv_2=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getStraightSectionAccess().getStraightIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getStraightSectionAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:548:3: ( (lv_strID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:549:4: (lv_strID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:549:4: (lv_strID_4_0= RULE_INT )
            // InternalTestLanguage.g:550:5: lv_strID_4_0= RULE_INT
            {
            lv_strID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_strID_4_0, grammarAccess.getStraightSectionAccess().getStrIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStraightSectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"strID",
            						lv_strID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // InternalTestLanguage.g:570:1: entryRuleDivergentSection returns [EObject current=null] : iv_ruleDivergentSection= ruleDivergentSection EOF ;
    public final EObject entryRuleDivergentSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivergentSection = null;


        try {
            // InternalTestLanguage.g:570:57: (iv_ruleDivergentSection= ruleDivergentSection EOF )
            // InternalTestLanguage.g:571:2: iv_ruleDivergentSection= ruleDivergentSection EOF
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
    // InternalTestLanguage.g:577:1: ruleDivergentSection returns [EObject current=null] : (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleDivergentSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_divergentSectionState_1_1=null;
        Token lv_divergentSectionState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_divID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:583:2: ( (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:584:2: (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:584:2: (otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:585:3: otherlv_0= 'Section connecting from DIVERGENT is ' ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getDivergentSectionAccess().getSectionConnectingFromDIVERGENTIsKeyword_0());
            		
            // InternalTestLanguage.g:589:3: ( ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:590:4: ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:590:4: ( (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:591:5: (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:591:5: (lv_divergentSectionState_1_1= 'FREE' | lv_divergentSectionState_1_2= 'OCCUPIED' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTestLanguage.g:592:6: lv_divergentSectionState_1_1= 'FREE'
                    {
                    lv_divergentSectionState_1_1=(Token)match(input,21,FOLLOW_20); 

                    						newLeafNode(lv_divergentSectionState_1_1, grammarAccess.getDivergentSectionAccess().getDivergentSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentSectionRule());
                    						}
                    						setWithLastConsumed(current, "divergentSectionState", lv_divergentSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:603:6: lv_divergentSectionState_1_2= 'OCCUPIED'
                    {
                    lv_divergentSectionState_1_2=(Token)match(input,22,FOLLOW_20); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getDivergentSectionAccess().getDivergentIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getDivergentSectionAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:624:3: ( (lv_divID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:625:4: (lv_divID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:625:4: (lv_divID_4_0= RULE_INT )
            // InternalTestLanguage.g:626:5: lv_divID_4_0= RULE_INT
            {
            lv_divID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_divID_4_0, grammarAccess.getDivergentSectionAccess().getDivIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDivergentSectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"divID",
            						lv_divID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // InternalTestLanguage.g:646:1: entryRuleTopSection returns [EObject current=null] : iv_ruleTopSection= ruleTopSection EOF ;
    public final EObject entryRuleTopSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopSection = null;


        try {
            // InternalTestLanguage.g:646:51: (iv_ruleTopSection= ruleTopSection EOF )
            // InternalTestLanguage.g:647:2: iv_ruleTopSection= ruleTopSection EOF
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
    // InternalTestLanguage.g:653:1: ruleTopSection returns [EObject current=null] : (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleTopSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_topSectionState_1_1=null;
        Token lv_topSectionState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_topID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:659:2: ( (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:660:2: (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:660:2: (otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:661:3: otherlv_0= 'Section connecting from TOP is ' ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getTopSectionAccess().getSectionConnectingFromTOPIsKeyword_0());
            		
            // InternalTestLanguage.g:665:3: ( ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) ) )
            // InternalTestLanguage.g:666:4: ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) )
            {
            // InternalTestLanguage.g:666:4: ( (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' ) )
            // InternalTestLanguage.g:667:5: (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' )
            {
            // InternalTestLanguage.g:667:5: (lv_topSectionState_1_1= 'FREE' | lv_topSectionState_1_2= 'OCCUPIED' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestLanguage.g:668:6: lv_topSectionState_1_1= 'FREE'
                    {
                    lv_topSectionState_1_1=(Token)match(input,21,FOLLOW_21); 

                    						newLeafNode(lv_topSectionState_1_1, grammarAccess.getTopSectionAccess().getTopSectionStateFREEKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopSectionRule());
                    						}
                    						setWithLastConsumed(current, "topSectionState", lv_topSectionState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:679:6: lv_topSectionState_1_2= 'OCCUPIED'
                    {
                    lv_topSectionState_1_2=(Token)match(input,22,FOLLOW_21); 

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

            otherlv_2=(Token)match(input,27,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTopSectionAccess().getTopIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTopSectionAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:700:3: ( (lv_topID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:701:4: (lv_topID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:701:4: (lv_topID_4_0= RULE_INT )
            // InternalTestLanguage.g:702:5: lv_topID_4_0= RULE_INT
            {
            lv_topID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_topID_4_0, grammarAccess.getTopSectionAccess().getTopIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTopSectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"topID",
            						lv_topID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // InternalTestLanguage.g:722:1: entryRuleExpectations returns [EObject current=null] : iv_ruleExpectations= ruleExpectations EOF ;
    public final EObject entryRuleExpectations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpectations = null;


        try {
            // InternalTestLanguage.g:722:53: (iv_ruleExpectations= ruleExpectations EOF )
            // InternalTestLanguage.g:723:2: iv_ruleExpectations= ruleExpectations EOF
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
    // InternalTestLanguage.g:729:1: ruleExpectations returns [EObject current=null] : (otherlv_0= '[ExpectedComponents]' otherlv_1= 'Turnout ' ( (lv_expectedTurnoutID_2_0= RULE_INT ) ) ( (lv_straightExpectation_3_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_5_0= ruleTopExpectation ) ) ) ;
    public final EObject ruleExpectations() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_expectedTurnoutID_2_0=null;
        EObject lv_straightExpectation_3_0 = null;

        EObject lv_divergentExpectation_4_0 = null;

        EObject lv_topExpectation_5_0 = null;



        	enterRule();

        try {
            // InternalTestLanguage.g:735:2: ( (otherlv_0= '[ExpectedComponents]' otherlv_1= 'Turnout ' ( (lv_expectedTurnoutID_2_0= RULE_INT ) ) ( (lv_straightExpectation_3_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_5_0= ruleTopExpectation ) ) ) )
            // InternalTestLanguage.g:736:2: (otherlv_0= '[ExpectedComponents]' otherlv_1= 'Turnout ' ( (lv_expectedTurnoutID_2_0= RULE_INT ) ) ( (lv_straightExpectation_3_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_5_0= ruleTopExpectation ) ) )
            {
            // InternalTestLanguage.g:736:2: (otherlv_0= '[ExpectedComponents]' otherlv_1= 'Turnout ' ( (lv_expectedTurnoutID_2_0= RULE_INT ) ) ( (lv_straightExpectation_3_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_5_0= ruleTopExpectation ) ) )
            // InternalTestLanguage.g:737:3: otherlv_0= '[ExpectedComponents]' otherlv_1= 'Turnout ' ( (lv_expectedTurnoutID_2_0= RULE_INT ) ) ( (lv_straightExpectation_3_0= ruleStraightExpectation ) ) ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) ) ( (lv_topExpectation_5_0= ruleTopExpectation ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getExpectationsAccess().getExpectedComponentsKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getExpectationsAccess().getTurnoutKeyword_1());
            		
            // InternalTestLanguage.g:745:3: ( (lv_expectedTurnoutID_2_0= RULE_INT ) )
            // InternalTestLanguage.g:746:4: (lv_expectedTurnoutID_2_0= RULE_INT )
            {
            // InternalTestLanguage.g:746:4: (lv_expectedTurnoutID_2_0= RULE_INT )
            // InternalTestLanguage.g:747:5: lv_expectedTurnoutID_2_0= RULE_INT
            {
            lv_expectedTurnoutID_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_expectedTurnoutID_2_0, grammarAccess.getExpectationsAccess().getExpectedTurnoutIDINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExpectationsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"expectedTurnoutID",
            						lv_expectedTurnoutID_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalTestLanguage.g:763:3: ( (lv_straightExpectation_3_0= ruleStraightExpectation ) )
            // InternalTestLanguage.g:764:4: (lv_straightExpectation_3_0= ruleStraightExpectation )
            {
            // InternalTestLanguage.g:764:4: (lv_straightExpectation_3_0= ruleStraightExpectation )
            // InternalTestLanguage.g:765:5: lv_straightExpectation_3_0= ruleStraightExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getStraightExpectationStraightExpectationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_23);
            lv_straightExpectation_3_0=ruleStraightExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"straightExpectation",
            						lv_straightExpectation_3_0,
            						"hu.bme.mit.modes3.test.TestLanguage.StraightExpectation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:782:3: ( (lv_divergentExpectation_4_0= ruleDivergentExpectation ) )
            // InternalTestLanguage.g:783:4: (lv_divergentExpectation_4_0= ruleDivergentExpectation )
            {
            // InternalTestLanguage.g:783:4: (lv_divergentExpectation_4_0= ruleDivergentExpectation )
            // InternalTestLanguage.g:784:5: lv_divergentExpectation_4_0= ruleDivergentExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getDivergentExpectationDivergentExpectationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_24);
            lv_divergentExpectation_4_0=ruleDivergentExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"divergentExpectation",
            						lv_divergentExpectation_4_0,
            						"hu.bme.mit.modes3.test.TestLanguage.DivergentExpectation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTestLanguage.g:801:3: ( (lv_topExpectation_5_0= ruleTopExpectation ) )
            // InternalTestLanguage.g:802:4: (lv_topExpectation_5_0= ruleTopExpectation )
            {
            // InternalTestLanguage.g:802:4: (lv_topExpectation_5_0= ruleTopExpectation )
            // InternalTestLanguage.g:803:5: lv_topExpectation_5_0= ruleTopExpectation
            {

            					newCompositeNode(grammarAccess.getExpectationsAccess().getTopExpectationTopExpectationParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_topExpectation_5_0=ruleTopExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpectationsRule());
            					}
            					set(
            						current,
            						"topExpectation",
            						lv_topExpectation_5_0,
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
    // InternalTestLanguage.g:824:1: entryRuleStraightExpectation returns [EObject current=null] : iv_ruleStraightExpectation= ruleStraightExpectation EOF ;
    public final EObject entryRuleStraightExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStraightExpectation = null;


        try {
            // InternalTestLanguage.g:824:60: (iv_ruleStraightExpectation= ruleStraightExpectation EOF )
            // InternalTestLanguage.g:825:2: iv_ruleStraightExpectation= ruleStraightExpectation EOF
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
    // InternalTestLanguage.g:831:1: ruleStraightExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleStraightExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_straightExpectedState_1_1=null;
        Token lv_straightExpectedState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_strID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:837:2: ( (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:838:2: (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:838:2: (otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:839:3: otherlv_0= 'Section connecting from STRAIGHT is expected to be ' ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Straight id' otherlv_3= ':' ( (lv_strID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getStraightExpectationAccess().getSectionConnectingFromSTRAIGHTIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:843:3: ( ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:844:4: ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:844:4: ( (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:845:5: (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:845:5: (lv_straightExpectedState_1_1= 'ENABLED' | lv_straightExpectedState_1_2= 'DISABLED' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            else if ( (LA9_0==31) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestLanguage.g:846:6: lv_straightExpectedState_1_1= 'ENABLED'
                    {
                    lv_straightExpectedState_1_1=(Token)match(input,30,FOLLOW_19); 

                    						newLeafNode(lv_straightExpectedState_1_1, grammarAccess.getStraightExpectationAccess().getStraightExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStraightExpectationRule());
                    						}
                    						setWithLastConsumed(current, "straightExpectedState", lv_straightExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:857:6: lv_straightExpectedState_1_2= 'DISABLED'
                    {
                    lv_straightExpectedState_1_2=(Token)match(input,31,FOLLOW_19); 

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

            otherlv_2=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getStraightExpectationAccess().getStraightIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getStraightExpectationAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:878:3: ( (lv_strID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:879:4: (lv_strID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:879:4: (lv_strID_4_0= RULE_INT )
            // InternalTestLanguage.g:880:5: lv_strID_4_0= RULE_INT
            {
            lv_strID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_strID_4_0, grammarAccess.getStraightExpectationAccess().getStrIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStraightExpectationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"strID",
            						lv_strID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // InternalTestLanguage.g:900:1: entryRuleDivergentExpectation returns [EObject current=null] : iv_ruleDivergentExpectation= ruleDivergentExpectation EOF ;
    public final EObject entryRuleDivergentExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivergentExpectation = null;


        try {
            // InternalTestLanguage.g:900:61: (iv_ruleDivergentExpectation= ruleDivergentExpectation EOF )
            // InternalTestLanguage.g:901:2: iv_ruleDivergentExpectation= ruleDivergentExpectation EOF
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
    // InternalTestLanguage.g:907:1: ruleDivergentExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleDivergentExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_divergentExpectedState_1_1=null;
        Token lv_divergentExpectedState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_divID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:913:2: ( (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:914:2: (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:914:2: (otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:915:3: otherlv_0= 'Section connecting from DIVERGENT is expected to be ' ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Divergent id' otherlv_3= ':' ( (lv_divID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getDivergentExpectationAccess().getSectionConnectingFromDIVERGENTIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:919:3: ( ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:920:4: ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:920:4: ( (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:921:5: (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:921:5: (lv_divergentExpectedState_1_1= 'ENABLED' | lv_divergentExpectedState_1_2= 'DISABLED' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==30) ) {
                alt10=1;
            }
            else if ( (LA10_0==31) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:922:6: lv_divergentExpectedState_1_1= 'ENABLED'
                    {
                    lv_divergentExpectedState_1_1=(Token)match(input,30,FOLLOW_20); 

                    						newLeafNode(lv_divergentExpectedState_1_1, grammarAccess.getDivergentExpectationAccess().getDivergentExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDivergentExpectationRule());
                    						}
                    						setWithLastConsumed(current, "divergentExpectedState", lv_divergentExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:933:6: lv_divergentExpectedState_1_2= 'DISABLED'
                    {
                    lv_divergentExpectedState_1_2=(Token)match(input,31,FOLLOW_20); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getDivergentExpectationAccess().getDivergentIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getDivergentExpectationAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:954:3: ( (lv_divID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:955:4: (lv_divID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:955:4: (lv_divID_4_0= RULE_INT )
            // InternalTestLanguage.g:956:5: lv_divID_4_0= RULE_INT
            {
            lv_divID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_divID_4_0, grammarAccess.getDivergentExpectationAccess().getDivIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDivergentExpectationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"divID",
            						lv_divID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // InternalTestLanguage.g:976:1: entryRuleTopExpectation returns [EObject current=null] : iv_ruleTopExpectation= ruleTopExpectation EOF ;
    public final EObject entryRuleTopExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopExpectation = null;


        try {
            // InternalTestLanguage.g:976:55: (iv_ruleTopExpectation= ruleTopExpectation EOF )
            // InternalTestLanguage.g:977:2: iv_ruleTopExpectation= ruleTopExpectation EOF
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
    // InternalTestLanguage.g:983:1: ruleTopExpectation returns [EObject current=null] : (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) ) ;
    public final EObject ruleTopExpectation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_topExpectedState_1_1=null;
        Token lv_topExpectedState_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_topID_4_0=null;


        	enterRule();

        try {
            // InternalTestLanguage.g:989:2: ( (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) ) )
            // InternalTestLanguage.g:990:2: (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) )
            {
            // InternalTestLanguage.g:990:2: (otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) ) )
            // InternalTestLanguage.g:991:3: otherlv_0= 'Section connecting from TOP is expected to be ' ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) ) otherlv_2= 'Top id' otherlv_3= ':' ( (lv_topID_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTopExpectationAccess().getSectionConnectingFromTOPIsExpectedToBeKeyword_0());
            		
            // InternalTestLanguage.g:995:3: ( ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) ) )
            // InternalTestLanguage.g:996:4: ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) )
            {
            // InternalTestLanguage.g:996:4: ( (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' ) )
            // InternalTestLanguage.g:997:5: (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' )
            {
            // InternalTestLanguage.g:997:5: (lv_topExpectedState_1_1= 'ENABLED' | lv_topExpectedState_1_2= 'DISABLED' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            else if ( (LA11_0==31) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalTestLanguage.g:998:6: lv_topExpectedState_1_1= 'ENABLED'
                    {
                    lv_topExpectedState_1_1=(Token)match(input,30,FOLLOW_21); 

                    						newLeafNode(lv_topExpectedState_1_1, grammarAccess.getTopExpectationAccess().getTopExpectedStateENABLEDKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopExpectationRule());
                    						}
                    						setWithLastConsumed(current, "topExpectedState", lv_topExpectedState_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:1009:6: lv_topExpectedState_1_2= 'DISABLED'
                    {
                    lv_topExpectedState_1_2=(Token)match(input,31,FOLLOW_21); 

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

            otherlv_2=(Token)match(input,27,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTopExpectationAccess().getTopIdKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTopExpectationAccess().getColonKeyword_3());
            		
            // InternalTestLanguage.g:1030:3: ( (lv_topID_4_0= RULE_INT ) )
            // InternalTestLanguage.g:1031:4: (lv_topID_4_0= RULE_INT )
            {
            // InternalTestLanguage.g:1031:4: (lv_topID_4_0= RULE_INT )
            // InternalTestLanguage.g:1032:5: lv_topID_4_0= RULE_INT
            {
            lv_topID_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_topID_4_0, grammarAccess.getTopExpectationAccess().getTopIDINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTopExpectationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"topID",
            						lv_topID_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000001000A000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000C0000000L});

}