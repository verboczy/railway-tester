package hu.bme.mit.modes3.test.generator;

import com.google.common.base.Objects;
import hu.bme.mit.modes3.test.generator.ITestGenerator;
import hu.bme.mit.modes3.test.testLanguage.CaseDescription;
import hu.bme.mit.modes3.test.testLanguage.CaseName;
import hu.bme.mit.modes3.test.testLanguage.Comment;
import hu.bme.mit.modes3.test.testLanguage.DivergentExpectation;
import hu.bme.mit.modes3.test.testLanguage.DivergentSection;
import hu.bme.mit.modes3.test.testLanguage.Expectations;
import hu.bme.mit.modes3.test.testLanguage.InitialState;
import hu.bme.mit.modes3.test.testLanguage.Model;
import hu.bme.mit.modes3.test.testLanguage.Section;
import hu.bme.mit.modes3.test.testLanguage.Steps;
import hu.bme.mit.modes3.test.testLanguage.StraightExpectation;
import hu.bme.mit.modes3.test.testLanguage.StraightSection;
import hu.bme.mit.modes3.test.testLanguage.TopExpectation;
import hu.bme.mit.modes3.test.testLanguage.TopSection;
import hu.bme.mit.modes3.test.testLanguage.Turnout;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class SafetyLogicTestYakindu implements ITestGenerator {
  @Override
  public String generate(final Model model) {
    InitialState init = model.getInitialState();
    EList<CaseDescription> testcases = model.getCaseDescription();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("package org.yakindu.scr.turnout;\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import static org.junit.Assert.assertEquals;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.junit.Before;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.junit.BeforeClass;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.junit.Test;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class YakinduTestCode {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static TurnoutStatemachine turnout;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@BeforeClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static void initialize() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("turnout = new TurnoutStatemachine();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("turnout.init();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("turnout.enter();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//turnout.setId(");
    int _turnoutID = init.getTurnoutID();
    _builder.append(_turnoutID, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Before");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void reset() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("turnout.init();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("turnout.enter();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Turnout _turnout = init.getTurnout();
      String _turnoutState = _turnout.getTurnoutState();
      boolean _equals = Objects.equal(_turnoutState, "DIVERGENT");
      if (_equals) {
        _builder.append("\t\t\t");
        _builder.append("turnout.sCITurnout.raiseTurnoutDivergent();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("turnout.runCycle();");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      for(final CaseDescription test : testcases) {
        _builder.append("\t\t");
        _builder.append("// ");
        Steps _steps = test.getSteps();
        Comment _comment = _steps.getComment();
        String _comment_1 = _comment.getComment();
        _builder.append(_comment_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("@Test");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public void ");
        CaseName _caseName = test.getCaseName();
        String _name = _caseName.getName();
        _builder.append(_name, "\t\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        {
          Steps _steps_1 = test.getSteps();
          Turnout _changedTurnout = _steps_1.getChangedTurnout();
          boolean _equals_1 = Objects.equal(_changedTurnout, null);
          if (_equals_1) {
            {
              Turnout _turnout_1 = init.getTurnout();
              String _turnoutState_1 = _turnout_1.getTurnoutState();
              boolean _equals_2 = Objects.equal(_turnoutState_1, "STRAIGHT");
              if (_equals_2) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// Turnout is straight");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// Divergent must be disabled");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("turnout.runCycle();");
                _builder.newLine();
                {
                  Expectations _expect = test.getExpect();
                  DivergentExpectation _divergentExpectation = _expect.getDivergentExpectation();
                  String _divergentExpectedState = _divergentExpectation.getDivergentExpectedState();
                  boolean _equals_3 = Objects.equal(_divergentExpectedState, "DISABLED");
                  if (_equals_3) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                    _builder.newLine();
                  } else {
                    Expectations _expect_1 = test.getExpect();
                    DivergentExpectation _divergentExpectation_1 = _expect_1.getDivergentExpectation();
                    String _divergentExpectedState_1 = _divergentExpectation_1.getDivergentExpectedState();
                    boolean _equals_4 = Objects.equal(_divergentExpectedState_1, "ENABLED");
                    if (_equals_4) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                      _builder.newLine();
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// ha mindketto foglalt, akkor mindketto disabled kell legyen");
                _builder.newLine();
                {
                  boolean _and = false;
                  Steps _steps_2 = test.getSteps();
                  EList<Section> _section = _steps_2.getSection();
                  Section _get = _section.get(0);
                  StraightSection _straightSection = _get.getStraightSection();
                  String _straightSectionState = _straightSection.getStraightSectionState();
                  boolean _equals_5 = Objects.equal(_straightSectionState, "OCCUPIED");
                  if (!_equals_5) {
                    _and = false;
                  } else {
                    Steps _steps_3 = test.getSteps();
                    EList<Section> _section_1 = _steps_3.getSection();
                    Section _get_1 = _section_1.get(0);
                    TopSection _topSection = _get_1.getTopSection();
                    String _topSectionState = _topSection.getTopSectionState();
                    boolean _equals_6 = Objects.equal(_topSectionState, "OCCUPIED");
                    _and = _equals_6;
                  }
                  if (_and) {
                    {
                      Expectations _expect_2 = test.getExpect();
                      StraightExpectation _straightExpectation = _expect_2.getStraightExpectation();
                      String _straightExpectedState = _straightExpectation.getStraightExpectedState();
                      boolean _equals_7 = Objects.equal(_straightExpectedState, "DISABLED");
                      if (_equals_7) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        _builder.newLine();
                      } else {
                        Expectations _expect_3 = test.getExpect();
                        StraightExpectation _straightExpectation_1 = _expect_3.getStraightExpectation();
                        String _straightExpectedState_1 = _straightExpectation_1.getStraightExpectedState();
                        boolean _equals_8 = Objects.equal(_straightExpectedState_1, "ENABLED");
                        if (_equals_8) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.newLine();
                    {
                      Expectations _expect_4 = test.getExpect();
                      TopExpectation _topExpectation = _expect_4.getTopExpectation();
                      String _topExpectedState = _topExpectation.getTopExpectedState();
                      boolean _equals_9 = Objects.equal(_topExpectedState, "DISABLED");
                      if (_equals_9) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t");
                        _builder.newLine();
                      } else {
                        Expectations _expect_5 = test.getExpect();
                        TopExpectation _topExpectation_1 = _expect_5.getTopExpectation();
                        String _topExpectedState_1 = _topExpectation_1.getTopExpectedState();
                        boolean _equals_10 = Objects.equal(_topExpectedState_1, "ENABLED");
                        if (_equals_10) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("// Ha csak a straight foglalt");
                    _builder.newLine();
                  } else {
                    boolean _and_1 = false;
                    Steps _steps_4 = test.getSteps();
                    EList<Section> _section_2 = _steps_4.getSection();
                    Section _get_2 = _section_2.get(0);
                    StraightSection _straightSection_1 = _get_2.getStraightSection();
                    String _straightSectionState_1 = _straightSection_1.getStraightSectionState();
                    boolean _equals_11 = Objects.equal(_straightSectionState_1, "OCCUPIED");
                    if (!_equals_11) {
                      _and_1 = false;
                    } else {
                      Steps _steps_5 = test.getSteps();
                      EList<Section> _section_3 = _steps_5.getSection();
                      Section _get_3 = _section_3.get(0);
                      TopSection _topSection_1 = _get_3.getTopSection();
                      String _topSectionState_1 = _topSection_1.getTopSectionState();
                      boolean _equals_12 = Objects.equal(_topSectionState_1, "FREE");
                      _and_1 = _equals_12;
                    }
                    if (_and_1) {
                      {
                        Expectations _expect_6 = test.getExpect();
                        StraightExpectation _straightExpectation_2 = _expect_6.getStraightExpectation();
                        String _straightExpectedState_2 = _straightExpectation_2.getStraightExpectedState();
                        boolean _equals_13 = Objects.equal(_straightExpectedState_2, "DISABLED");
                        if (_equals_13) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                          _builder.newLine();
                        } else {
                          Expectations _expect_7 = test.getExpect();
                          StraightExpectation _straightExpectation_3 = _expect_7.getStraightExpectation();
                          String _straightExpectedState_3 = _straightExpectation_3.getStraightExpectedState();
                          boolean _equals_14 = Objects.equal(_straightExpectedState_3, "ENABLED");
                          if (_equals_14) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      {
                        Expectations _expect_8 = test.getExpect();
                        TopExpectation _topExpectation_2 = _expect_8.getTopExpectation();
                        String _topExpectedState_2 = _topExpectation_2.getTopExpectedState();
                        boolean _equals_15 = Objects.equal(_topExpectedState_2, "DISABLED");
                        if (_equals_15) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                          _builder.newLine();
                        } else {
                          Expectations _expect_9 = test.getExpect();
                          TopExpectation _topExpectation_3 = _expect_9.getTopExpectation();
                          String _topExpectedState_3 = _topExpectation_3.getTopExpectedState();
                          boolean _equals_16 = Objects.equal(_topExpectedState_3, "ENABLED");
                          if (_equals_16) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("// ha csak a top foglalt\t");
                      _builder.newLine();
                    } else {
                      boolean _and_2 = false;
                      Steps _steps_6 = test.getSteps();
                      EList<Section> _section_4 = _steps_6.getSection();
                      Section _get_4 = _section_4.get(0);
                      StraightSection _straightSection_2 = _get_4.getStraightSection();
                      String _straightSectionState_2 = _straightSection_2.getStraightSectionState();
                      boolean _equals_17 = Objects.equal(_straightSectionState_2, "FREE");
                      if (!_equals_17) {
                        _and_2 = false;
                      } else {
                        Steps _steps_7 = test.getSteps();
                        EList<Section> _section_5 = _steps_7.getSection();
                        Section _get_5 = _section_5.get(0);
                        TopSection _topSection_2 = _get_5.getTopSection();
                        String _topSectionState_2 = _topSection_2.getTopSectionState();
                        boolean _equals_18 = Objects.equal(_topSectionState_2, "OCCUPIED");
                        _and_2 = _equals_18;
                      }
                      if (_and_2) {
                        {
                          Expectations _expect_10 = test.getExpect();
                          TopExpectation _topExpectation_4 = _expect_10.getTopExpectation();
                          String _topExpectedState_4 = _topExpectation_4.getTopExpectedState();
                          boolean _equals_19 = Objects.equal(_topExpectedState_4, "DISABLED");
                          if (_equals_19) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                            _builder.newLine();
                          } else {
                            Expectations _expect_11 = test.getExpect();
                            TopExpectation _topExpectation_5 = _expect_11.getTopExpectation();
                            String _topExpectedState_5 = _topExpectation_5.getTopExpectedState();
                            boolean _equals_20 = Objects.equal(_topExpectedState_5, "ENABLED");
                            if (_equals_20) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        {
                          Expectations _expect_12 = test.getExpect();
                          StraightExpectation _straightExpectation_4 = _expect_12.getStraightExpectation();
                          String _straightExpectedState_4 = _straightExpectation_4.getStraightExpectedState();
                          boolean _equals_21 = Objects.equal(_straightExpectedState_4, "DISABLED");
                          if (_equals_21) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                            _builder.newLine();
                          } else {
                            Expectations _expect_13 = test.getExpect();
                            StraightExpectation _straightExpectation_5 = _expect_13.getStraightExpectation();
                            String _straightExpectedState_5 = _straightExpectation_5.getStraightExpectedState();
                            boolean _equals_22 = Objects.equal(_straightExpectedState_5, "ENABLED");
                            if (_equals_22) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("// ha egyik se foglalt\t");
                        _builder.newLine();
                      } else {
                        boolean _and_3 = false;
                        Steps _steps_8 = test.getSteps();
                        EList<Section> _section_6 = _steps_8.getSection();
                        Section _get_6 = _section_6.get(0);
                        StraightSection _straightSection_3 = _get_6.getStraightSection();
                        String _straightSectionState_3 = _straightSection_3.getStraightSectionState();
                        boolean _equals_23 = Objects.equal(_straightSectionState_3, "FREE");
                        if (!_equals_23) {
                          _and_3 = false;
                        } else {
                          Steps _steps_9 = test.getSteps();
                          EList<Section> _section_7 = _steps_9.getSection();
                          Section _get_7 = _section_7.get(0);
                          TopSection _topSection_3 = _get_7.getTopSection();
                          String _topSectionState_3 = _topSection_3.getTopSectionState();
                          boolean _equals_24 = Objects.equal(_topSectionState_3, "FREE");
                          _and_3 = _equals_24;
                        }
                        if (_and_3) {
                          {
                            Expectations _expect_14 = test.getExpect();
                            TopExpectation _topExpectation_6 = _expect_14.getTopExpectation();
                            String _topExpectedState_6 = _topExpectation_6.getTopExpectedState();
                            boolean _equals_25 = Objects.equal(_topExpectedState_6, "DISABLED");
                            if (_equals_25) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                              _builder.newLine();
                            } else {
                              Expectations _expect_15 = test.getExpect();
                              TopExpectation _topExpectation_7 = _expect_15.getTopExpectation();
                              String _topExpectedState_7 = _topExpectation_7.getTopExpectedState();
                              boolean _equals_26 = Objects.equal(_topExpectedState_7, "ENABLED");
                              if (_equals_26) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                          {
                            Expectations _expect_16 = test.getExpect();
                            StraightExpectation _straightExpectation_6 = _expect_16.getStraightExpectation();
                            String _straightExpectedState_6 = _straightExpectation_6.getStraightExpectedState();
                            boolean _equals_27 = Objects.equal(_straightExpectedState_6, "DISABLED");
                            if (_equals_27) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                              _builder.newLine();
                            } else {
                              Expectations _expect_17 = test.getExpect();
                              StraightExpectation _straightExpectation_7 = _expect_17.getStraightExpectation();
                              String _straightExpectedState_7 = _straightExpectation_7.getStraightExpectedState();
                              boolean _equals_28 = Objects.equal(_straightExpectedState_7, "ENABLED");
                              if (_equals_28) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.newLine();
              } else {
                Turnout _turnout_2 = init.getTurnout();
                String _turnoutState_2 = _turnout_2.getTurnoutState();
                boolean _equals_29 = Objects.equal(_turnoutState_2, "DIVERGENT");
                if (_equals_29) {
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("// Turnout is divergent");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("// Straight must be disabled");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("turnout.runCycle();");
                  _builder.newLine();
                  {
                    Expectations _expect_18 = test.getExpect();
                    StraightExpectation _straightExpectation_8 = _expect_18.getStraightExpectation();
                    String _straightExpectedState_8 = _straightExpectation_8.getStraightExpectedState();
                    boolean _equals_30 = Objects.equal(_straightExpectedState_8, "DISABLED");
                    if (_equals_30) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                      _builder.newLine();
                    } else {
                      Expectations _expect_19 = test.getExpect();
                      StraightExpectation _straightExpectation_9 = _expect_19.getStraightExpectation();
                      String _straightExpectedState_9 = _straightExpectation_9.getStraightExpectedState();
                      boolean _equals_31 = Objects.equal(_straightExpectedState_9, "ENABLED");
                      if (_equals_31) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                        _builder.newLine();
                      }
                    }
                  }
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("// ha mindketto foglalt, akkor mindketto disabled kell legyen");
                  _builder.newLine();
                  {
                    boolean _and_4 = false;
                    Steps _steps_10 = test.getSteps();
                    EList<Section> _section_8 = _steps_10.getSection();
                    Section _get_8 = _section_8.get(0);
                    DivergentSection _divergentSection = _get_8.getDivergentSection();
                    String _divergentSectionState = _divergentSection.getDivergentSectionState();
                    boolean _equals_32 = Objects.equal(_divergentSectionState, "OCCUPIED");
                    if (!_equals_32) {
                      _and_4 = false;
                    } else {
                      Steps _steps_11 = test.getSteps();
                      EList<Section> _section_9 = _steps_11.getSection();
                      Section _get_9 = _section_9.get(0);
                      TopSection _topSection_4 = _get_9.getTopSection();
                      String _topSectionState_4 = _topSection_4.getTopSectionState();
                      boolean _equals_33 = Objects.equal(_topSectionState_4, "OCCUPIED");
                      _and_4 = _equals_33;
                    }
                    if (_and_4) {
                      {
                        Expectations _expect_20 = test.getExpect();
                        DivergentExpectation _divergentExpectation_2 = _expect_20.getDivergentExpectation();
                        String _divergentExpectedState_2 = _divergentExpectation_2.getDivergentExpectedState();
                        boolean _equals_34 = Objects.equal(_divergentExpectedState_2, "DISABLED");
                        if (_equals_34) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                          _builder.newLine();
                        } else {
                          Expectations _expect_21 = test.getExpect();
                          DivergentExpectation _divergentExpectation_3 = _expect_21.getDivergentExpectation();
                          String _divergentExpectedState_3 = _divergentExpectation_3.getDivergentExpectedState();
                          boolean _equals_35 = Objects.equal(_divergentExpectedState_3, "ENABLED");
                          if (_equals_35) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.newLine();
                          }
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.newLine();
                      {
                        Expectations _expect_22 = test.getExpect();
                        TopExpectation _topExpectation_8 = _expect_22.getTopExpectation();
                        String _topExpectedState_8 = _topExpectation_8.getTopExpectedState();
                        boolean _equals_36 = Objects.equal(_topExpectedState_8, "DISABLED");
                        if (_equals_36) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t");
                          _builder.newLine();
                        } else {
                          Expectations _expect_23 = test.getExpect();
                          TopExpectation _topExpectation_9 = _expect_23.getTopExpectation();
                          String _topExpectedState_9 = _topExpectation_9.getTopExpectedState();
                          boolean _equals_37 = Objects.equal(_topExpectedState_9, "ENABLED");
                          if (_equals_37) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("// Ha csak a divergent foglalt");
                      _builder.newLine();
                    } else {
                      boolean _and_5 = false;
                      Steps _steps_12 = test.getSteps();
                      EList<Section> _section_10 = _steps_12.getSection();
                      Section _get_10 = _section_10.get(0);
                      DivergentSection _divergentSection_1 = _get_10.getDivergentSection();
                      String _divergentSectionState_1 = _divergentSection_1.getDivergentSectionState();
                      boolean _equals_38 = Objects.equal(_divergentSectionState_1, "OCCUPIED");
                      if (!_equals_38) {
                        _and_5 = false;
                      } else {
                        Steps _steps_13 = test.getSteps();
                        EList<Section> _section_11 = _steps_13.getSection();
                        Section _get_11 = _section_11.get(0);
                        TopSection _topSection_5 = _get_11.getTopSection();
                        String _topSectionState_5 = _topSection_5.getTopSectionState();
                        boolean _equals_39 = Objects.equal(_topSectionState_5, "FREE");
                        _and_5 = _equals_39;
                      }
                      if (_and_5) {
                        {
                          Expectations _expect_24 = test.getExpect();
                          DivergentExpectation _divergentExpectation_4 = _expect_24.getDivergentExpectation();
                          String _divergentExpectedState_4 = _divergentExpectation_4.getDivergentExpectedState();
                          boolean _equals_40 = Objects.equal(_divergentExpectedState_4, "DISABLED");
                          if (_equals_40) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                            _builder.newLine();
                          } else {
                            Expectations _expect_25 = test.getExpect();
                            DivergentExpectation _divergentExpectation_5 = _expect_25.getDivergentExpectation();
                            String _divergentExpectedState_5 = _divergentExpectation_5.getDivergentExpectedState();
                            boolean _equals_41 = Objects.equal(_divergentExpectedState_5, "ENABLED");
                            if (_equals_41) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        {
                          Expectations _expect_26 = test.getExpect();
                          TopExpectation _topExpectation_10 = _expect_26.getTopExpectation();
                          String _topExpectedState_10 = _topExpectation_10.getTopExpectedState();
                          boolean _equals_42 = Objects.equal(_topExpectedState_10, "DISABLED");
                          if (_equals_42) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                            _builder.newLine();
                          } else {
                            Expectations _expect_27 = test.getExpect();
                            TopExpectation _topExpectation_11 = _expect_27.getTopExpectation();
                            String _topExpectedState_11 = _topExpectation_11.getTopExpectedState();
                            boolean _equals_43 = Objects.equal(_topExpectedState_11, "ENABLED");
                            if (_equals_43) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("// ha csak a top foglalt\t");
                        _builder.newLine();
                      } else {
                        boolean _and_6 = false;
                        Steps _steps_14 = test.getSteps();
                        EList<Section> _section_12 = _steps_14.getSection();
                        Section _get_12 = _section_12.get(0);
                        DivergentSection _divergentSection_2 = _get_12.getDivergentSection();
                        String _divergentSectionState_2 = _divergentSection_2.getDivergentSectionState();
                        boolean _equals_44 = Objects.equal(_divergentSectionState_2, "FREE");
                        if (!_equals_44) {
                          _and_6 = false;
                        } else {
                          Steps _steps_15 = test.getSteps();
                          EList<Section> _section_13 = _steps_15.getSection();
                          Section _get_13 = _section_13.get(0);
                          TopSection _topSection_6 = _get_13.getTopSection();
                          String _topSectionState_6 = _topSection_6.getTopSectionState();
                          boolean _equals_45 = Objects.equal(_topSectionState_6, "OCCUPIED");
                          _and_6 = _equals_45;
                        }
                        if (_and_6) {
                          {
                            Expectations _expect_28 = test.getExpect();
                            TopExpectation _topExpectation_12 = _expect_28.getTopExpectation();
                            String _topExpectedState_12 = _topExpectation_12.getTopExpectedState();
                            boolean _equals_46 = Objects.equal(_topExpectedState_12, "DISABLED");
                            if (_equals_46) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                              _builder.newLine();
                            } else {
                              Expectations _expect_29 = test.getExpect();
                              TopExpectation _topExpectation_13 = _expect_29.getTopExpectation();
                              String _topExpectedState_13 = _topExpectation_13.getTopExpectedState();
                              boolean _equals_47 = Objects.equal(_topExpectedState_13, "ENABLED");
                              if (_equals_47) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                          {
                            Expectations _expect_30 = test.getExpect();
                            DivergentExpectation _divergentExpectation_6 = _expect_30.getDivergentExpectation();
                            String _divergentExpectedState_6 = _divergentExpectation_6.getDivergentExpectedState();
                            boolean _equals_48 = Objects.equal(_divergentExpectedState_6, "DISABLED");
                            if (_equals_48) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                              _builder.newLine();
                            } else {
                              Expectations _expect_31 = test.getExpect();
                              DivergentExpectation _divergentExpectation_7 = _expect_31.getDivergentExpectation();
                              String _divergentExpectedState_7 = _divergentExpectation_7.getDivergentExpectedState();
                              boolean _equals_49 = Objects.equal(_divergentExpectedState_7, "ENABLED");
                              if (_equals_49) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("// ha egyik se foglalt\t");
                          _builder.newLine();
                        } else {
                          boolean _and_7 = false;
                          Steps _steps_16 = test.getSteps();
                          EList<Section> _section_14 = _steps_16.getSection();
                          Section _get_14 = _section_14.get(0);
                          DivergentSection _divergentSection_3 = _get_14.getDivergentSection();
                          String _divergentSectionState_3 = _divergentSection_3.getDivergentSectionState();
                          boolean _equals_50 = Objects.equal(_divergentSectionState_3, "FREE");
                          if (!_equals_50) {
                            _and_7 = false;
                          } else {
                            Steps _steps_17 = test.getSteps();
                            EList<Section> _section_15 = _steps_17.getSection();
                            Section _get_15 = _section_15.get(0);
                            TopSection _topSection_7 = _get_15.getTopSection();
                            String _topSectionState_7 = _topSection_7.getTopSectionState();
                            boolean _equals_51 = Objects.equal(_topSectionState_7, "FREE");
                            _and_7 = _equals_51;
                          }
                          if (_and_7) {
                            {
                              Expectations _expect_32 = test.getExpect();
                              TopExpectation _topExpectation_14 = _expect_32.getTopExpectation();
                              String _topExpectedState_14 = _topExpectation_14.getTopExpectedState();
                              boolean _equals_52 = Objects.equal(_topExpectedState_14, "DISABLED");
                              if (_equals_52) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                                _builder.newLine();
                              } else {
                                Expectations _expect_33 = test.getExpect();
                                TopExpectation _topExpectation_15 = _expect_33.getTopExpectation();
                                String _topExpectedState_15 = _topExpectation_15.getTopExpectedState();
                                boolean _equals_53 = Objects.equal(_topExpectedState_15, "ENABLED");
                                if (_equals_53) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.runCycle();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.runCycle();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                                  _builder.newLine();
                                }
                              }
                            }
                            {
                              Expectations _expect_34 = test.getExpect();
                              DivergentExpectation _divergentExpectation_8 = _expect_34.getDivergentExpectation();
                              String _divergentExpectedState_8 = _divergentExpectation_8.getDivergentExpectedState();
                              boolean _equals_54 = Objects.equal(_divergentExpectedState_8, "DISABLED");
                              if (_equals_54) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                                _builder.newLine();
                              } else {
                                Expectations _expect_35 = test.getExpect();
                                DivergentExpectation _divergentExpectation_9 = _expect_35.getDivergentExpectation();
                                String _divergentExpectedState_9 = _divergentExpectation_9.getDivergentExpectedState();
                                boolean _equals_55 = Objects.equal(_divergentExpectedState_9, "ENABLED");
                                if (_equals_55) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.runCycle();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("turnout.runCycle();");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                                  _builder.newLine();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          } else {
            Steps _steps_18 = test.getSteps();
            Turnout _changedTurnout_1 = _steps_18.getChangedTurnout();
            String _turnoutState_3 = _changedTurnout_1.getTurnoutState();
            boolean _equals_56 = Objects.equal(_turnoutState_3, "STRAIGHT");
            if (_equals_56) {
              {
                Turnout _turnout_3 = init.getTurnout();
                String _turnoutState_4 = _turnout_3.getTurnoutState();
                boolean _equals_57 = Objects.equal(_turnoutState_4, "DIVERGENT");
                if (_equals_57) {
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("turnout.sCITurnout.raiseTurnoutStraight();");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("turnout.runCycle();");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.newLine();
                }
              }
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("// Turnout is straight");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("// Divergent must be disabled");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("turnout.runCycle();");
              _builder.newLine();
              {
                Expectations _expect_36 = test.getExpect();
                DivergentExpectation _divergentExpectation_10 = _expect_36.getDivergentExpectation();
                String _divergentExpectedState_10 = _divergentExpectation_10.getDivergentExpectedState();
                boolean _equals_58 = Objects.equal(_divergentExpectedState_10, "DISABLED");
                if (_equals_58) {
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                  _builder.newLine();
                } else {
                  Expectations _expect_37 = test.getExpect();
                  DivergentExpectation _divergentExpectation_11 = _expect_37.getDivergentExpectation();
                  String _divergentExpectedState_11 = _divergentExpectation_11.getDivergentExpectedState();
                  boolean _equals_59 = Objects.equal(_divergentExpectedState_11, "ENABLED");
                  if (_equals_59) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                    _builder.newLine();
                  }
                }
              }
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("// ha mindketto foglalt, akkor mindketto disabled kell legyen");
              _builder.newLine();
              {
                boolean _and_8 = false;
                Steps _steps_19 = test.getSteps();
                EList<Section> _section_16 = _steps_19.getSection();
                Section _get_16 = _section_16.get(0);
                StraightSection _straightSection_4 = _get_16.getStraightSection();
                String _straightSectionState_4 = _straightSection_4.getStraightSectionState();
                boolean _equals_60 = Objects.equal(_straightSectionState_4, "OCCUPIED");
                if (!_equals_60) {
                  _and_8 = false;
                } else {
                  Steps _steps_20 = test.getSteps();
                  EList<Section> _section_17 = _steps_20.getSection();
                  Section _get_17 = _section_17.get(0);
                  TopSection _topSection_8 = _get_17.getTopSection();
                  String _topSectionState_8 = _topSection_8.getTopSectionState();
                  boolean _equals_61 = Objects.equal(_topSectionState_8, "OCCUPIED");
                  _and_8 = _equals_61;
                }
                if (_and_8) {
                  {
                    Expectations _expect_38 = test.getExpect();
                    StraightExpectation _straightExpectation_10 = _expect_38.getStraightExpectation();
                    String _straightExpectedState_10 = _straightExpectation_10.getStraightExpectedState();
                    boolean _equals_62 = Objects.equal(_straightExpectedState_10, "DISABLED");
                    if (_equals_62) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.runCycle();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.runCycle();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                      _builder.newLine();
                    } else {
                      Expectations _expect_39 = test.getExpect();
                      StraightExpectation _straightExpectation_11 = _expect_39.getStraightExpectation();
                      String _straightExpectedState_11 = _straightExpectation_11.getStraightExpectedState();
                      boolean _equals_63 = Objects.equal(_straightExpectedState_11, "ENABLED");
                      if (_equals_63) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.newLine();
                      }
                    }
                  }
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.newLine();
                  {
                    Expectations _expect_40 = test.getExpect();
                    TopExpectation _topExpectation_16 = _expect_40.getTopExpectation();
                    String _topExpectedState_16 = _topExpectation_16.getTopExpectedState();
                    boolean _equals_64 = Objects.equal(_topExpectedState_16, "DISABLED");
                    if (_equals_64) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.runCycle();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("turnout.runCycle();");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t");
                      _builder.newLine();
                    } else {
                      Expectations _expect_41 = test.getExpect();
                      TopExpectation _topExpectation_17 = _expect_41.getTopExpectation();
                      String _topExpectedState_17 = _topExpectation_17.getTopExpectedState();
                      boolean _equals_65 = Objects.equal(_topExpectedState_17, "ENABLED");
                      if (_equals_65) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                        _builder.newLine();
                      }
                    }
                  }
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.newLine();
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("// Ha csak a straight foglalt");
                  _builder.newLine();
                } else {
                  boolean _and_9 = false;
                  Steps _steps_21 = test.getSteps();
                  EList<Section> _section_18 = _steps_21.getSection();
                  Section _get_18 = _section_18.get(0);
                  StraightSection _straightSection_5 = _get_18.getStraightSection();
                  String _straightSectionState_5 = _straightSection_5.getStraightSectionState();
                  boolean _equals_66 = Objects.equal(_straightSectionState_5, "OCCUPIED");
                  if (!_equals_66) {
                    _and_9 = false;
                  } else {
                    Steps _steps_22 = test.getSteps();
                    EList<Section> _section_19 = _steps_22.getSection();
                    Section _get_19 = _section_19.get(0);
                    TopSection _topSection_9 = _get_19.getTopSection();
                    String _topSectionState_9 = _topSection_9.getTopSectionState();
                    boolean _equals_67 = Objects.equal(_topSectionState_9, "FREE");
                    _and_9 = _equals_67;
                  }
                  if (_and_9) {
                    {
                      Expectations _expect_42 = test.getExpect();
                      StraightExpectation _straightExpectation_12 = _expect_42.getStraightExpectation();
                      String _straightExpectedState_12 = _straightExpectation_12.getStraightExpectedState();
                      boolean _equals_68 = Objects.equal(_straightExpectedState_12, "DISABLED");
                      if (_equals_68) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                        _builder.newLine();
                      } else {
                        Expectations _expect_43 = test.getExpect();
                        StraightExpectation _straightExpectation_13 = _expect_43.getStraightExpectation();
                        String _straightExpectedState_13 = _straightExpectation_13.getStraightExpectedState();
                        boolean _equals_69 = Objects.equal(_straightExpectedState_13, "ENABLED");
                        if (_equals_69) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                        }
                      }
                    }
                    {
                      Expectations _expect_44 = test.getExpect();
                      TopExpectation _topExpectation_18 = _expect_44.getTopExpectation();
                      String _topExpectedState_18 = _topExpectation_18.getTopExpectedState();
                      boolean _equals_70 = Objects.equal(_topExpectedState_18, "DISABLED");
                      if (_equals_70) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                        _builder.newLine();
                      } else {
                        Expectations _expect_45 = test.getExpect();
                        TopExpectation _topExpectation_19 = _expect_45.getTopExpectation();
                        String _topExpectedState_19 = _topExpectation_19.getTopExpectedState();
                        boolean _equals_71 = Objects.equal(_topExpectedState_19, "ENABLED");
                        if (_equals_71) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("// ha csak a top foglalt\t");
                    _builder.newLine();
                  } else {
                    boolean _and_10 = false;
                    Steps _steps_23 = test.getSteps();
                    EList<Section> _section_20 = _steps_23.getSection();
                    Section _get_20 = _section_20.get(0);
                    StraightSection _straightSection_6 = _get_20.getStraightSection();
                    String _straightSectionState_6 = _straightSection_6.getStraightSectionState();
                    boolean _equals_72 = Objects.equal(_straightSectionState_6, "FREE");
                    if (!_equals_72) {
                      _and_10 = false;
                    } else {
                      Steps _steps_24 = test.getSteps();
                      EList<Section> _section_21 = _steps_24.getSection();
                      Section _get_21 = _section_21.get(0);
                      TopSection _topSection_10 = _get_21.getTopSection();
                      String _topSectionState_10 = _topSection_10.getTopSectionState();
                      boolean _equals_73 = Objects.equal(_topSectionState_10, "OCCUPIED");
                      _and_10 = _equals_73;
                    }
                    if (_and_10) {
                      {
                        Expectations _expect_46 = test.getExpect();
                        TopExpectation _topExpectation_20 = _expect_46.getTopExpectation();
                        String _topExpectedState_20 = _topExpectation_20.getTopExpectedState();
                        boolean _equals_74 = Objects.equal(_topExpectedState_20, "DISABLED");
                        if (_equals_74) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                          _builder.newLine();
                        } else {
                          Expectations _expect_47 = test.getExpect();
                          TopExpectation _topExpectation_21 = _expect_47.getTopExpectation();
                          String _topExpectedState_21 = _topExpectation_21.getTopExpectedState();
                          boolean _equals_75 = Objects.equal(_topExpectedState_21, "ENABLED");
                          if (_equals_75) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      {
                        Expectations _expect_48 = test.getExpect();
                        StraightExpectation _straightExpectation_14 = _expect_48.getStraightExpectation();
                        String _straightExpectedState_14 = _straightExpectation_14.getStraightExpectedState();
                        boolean _equals_76 = Objects.equal(_straightExpectedState_14, "DISABLED");
                        if (_equals_76) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                          _builder.newLine();
                        } else {
                          Expectations _expect_49 = test.getExpect();
                          StraightExpectation _straightExpectation_15 = _expect_49.getStraightExpectation();
                          String _straightExpectedState_15 = _straightExpectation_15.getStraightExpectedState();
                          boolean _equals_77 = Objects.equal(_straightExpectedState_15, "ENABLED");
                          if (_equals_77) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("// ha egyik se foglalt\t");
                      _builder.newLine();
                    } else {
                      boolean _and_11 = false;
                      Steps _steps_25 = test.getSteps();
                      EList<Section> _section_22 = _steps_25.getSection();
                      Section _get_22 = _section_22.get(0);
                      StraightSection _straightSection_7 = _get_22.getStraightSection();
                      String _straightSectionState_7 = _straightSection_7.getStraightSectionState();
                      boolean _equals_78 = Objects.equal(_straightSectionState_7, "FREE");
                      if (!_equals_78) {
                        _and_11 = false;
                      } else {
                        Steps _steps_26 = test.getSteps();
                        EList<Section> _section_23 = _steps_26.getSection();
                        Section _get_23 = _section_23.get(0);
                        TopSection _topSection_11 = _get_23.getTopSection();
                        String _topSectionState_11 = _topSection_11.getTopSectionState();
                        boolean _equals_79 = Objects.equal(_topSectionState_11, "FREE");
                        _and_11 = _equals_79;
                      }
                      if (_and_11) {
                        {
                          Expectations _expect_50 = test.getExpect();
                          TopExpectation _topExpectation_22 = _expect_50.getTopExpectation();
                          String _topExpectedState_22 = _topExpectation_22.getTopExpectedState();
                          boolean _equals_80 = Objects.equal(_topExpectedState_22, "DISABLED");
                          if (_equals_80) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                            _builder.newLine();
                          } else {
                            Expectations _expect_51 = test.getExpect();
                            TopExpectation _topExpectation_23 = _expect_51.getTopExpectation();
                            String _topExpectedState_23 = _topExpectation_23.getTopExpectedState();
                            boolean _equals_81 = Objects.equal(_topExpectedState_23, "ENABLED");
                            if (_equals_81) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        {
                          Expectations _expect_52 = test.getExpect();
                          StraightExpectation _straightExpectation_16 = _expect_52.getStraightExpectation();
                          String _straightExpectedState_16 = _straightExpectation_16.getStraightExpectedState();
                          boolean _equals_82 = Objects.equal(_straightExpectedState_16, "DISABLED");
                          if (_equals_82) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                            _builder.newLine();
                          } else {
                            Expectations _expect_53 = test.getExpect();
                            StraightExpectation _straightExpectation_17 = _expect_53.getStraightExpectation();
                            String _straightExpectedState_17 = _straightExpectation_17.getStraightExpectedState();
                            boolean _equals_83 = Objects.equal(_straightExpectedState_17, "ENABLED");
                            if (_equals_83) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            } else {
              Steps _steps_27 = test.getSteps();
              Turnout _changedTurnout_2 = _steps_27.getChangedTurnout();
              String _turnoutState_5 = _changedTurnout_2.getTurnoutState();
              boolean _equals_84 = Objects.equal(_turnoutState_5, "DIVERGENT");
              if (_equals_84) {
                {
                  Turnout _turnout_4 = init.getTurnout();
                  String _turnoutState_6 = _turnout_4.getTurnoutState();
                  boolean _equals_85 = Objects.equal(_turnoutState_6, "STRAIGHT");
                  if (_equals_85) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("turnout.sCITurnout.raiseTurnoutDivergent();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("turnout.runCycle();");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// Turnout is divergent");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// Straight must be disabled");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getSTRAIGHT());");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("turnout.runCycle();");
                _builder.newLine();
                {
                  Expectations _expect_54 = test.getExpect();
                  StraightExpectation _straightExpectation_18 = _expect_54.getStraightExpectation();
                  String _straightExpectedState_18 = _straightExpectation_18.getStraightExpectedState();
                  boolean _equals_86 = Objects.equal(_straightExpectedState_18, "DISABLED");
                  if (_equals_86) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                    _builder.newLine();
                  } else {
                    Expectations _expect_55 = test.getExpect();
                    StraightExpectation _straightExpectation_19 = _expect_55.getStraightExpectation();
                    String _straightExpectedState_19 = _straightExpectation_19.getStraightExpectedState();
                    boolean _equals_87 = Objects.equal(_straightExpectedState_19, "ENABLED");
                    if (_equals_87) {
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());");
                      _builder.newLine();
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("// ha mindketto foglalt, akkor mindketto disabled kell legyen");
                _builder.newLine();
                {
                  boolean _and_12 = false;
                  Steps _steps_28 = test.getSteps();
                  EList<Section> _section_24 = _steps_28.getSection();
                  Section _get_24 = _section_24.get(0);
                  DivergentSection _divergentSection_4 = _get_24.getDivergentSection();
                  String _divergentSectionState_4 = _divergentSection_4.getDivergentSectionState();
                  boolean _equals_88 = Objects.equal(_divergentSectionState_4, "OCCUPIED");
                  if (!_equals_88) {
                    _and_12 = false;
                  } else {
                    Steps _steps_29 = test.getSteps();
                    EList<Section> _section_25 = _steps_29.getSection();
                    Section _get_25 = _section_25.get(0);
                    TopSection _topSection_12 = _get_25.getTopSection();
                    String _topSectionState_12 = _topSection_12.getTopSectionState();
                    boolean _equals_89 = Objects.equal(_topSectionState_12, "OCCUPIED");
                    _and_12 = _equals_89;
                  }
                  if (_and_12) {
                    {
                      Expectations _expect_56 = test.getExpect();
                      DivergentExpectation _divergentExpectation_12 = _expect_56.getDivergentExpectation();
                      String _divergentExpectedState_12 = _divergentExpectation_12.getDivergentExpectedState();
                      boolean _equals_90 = Objects.equal(_divergentExpectedState_12, "DISABLED");
                      if (_equals_90) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        _builder.newLine();
                      } else {
                        Expectations _expect_57 = test.getExpect();
                        DivergentExpectation _divergentExpectation_13 = _expect_57.getDivergentExpectation();
                        String _divergentExpectedState_13 = _divergentExpectation_13.getDivergentExpectedState();
                        boolean _equals_91 = Objects.equal(_divergentExpectedState_13, "ENABLED");
                        if (_equals_91) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.newLine();
                    {
                      Expectations _expect_58 = test.getExpect();
                      TopExpectation _topExpectation_24 = _expect_58.getTopExpectation();
                      String _topExpectedState_24 = _topExpectation_24.getTopExpectedState();
                      boolean _equals_92 = Objects.equal(_topExpectedState_24, "DISABLED");
                      if (_equals_92) {
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("turnout.runCycle();");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCannotGoToValue());\t\t\t\t\t\t\t");
                        _builder.newLine();
                      } else {
                        Expectations _expect_59 = test.getExpect();
                        TopExpectation _topExpectation_25 = _expect_59.getTopExpectation();
                        String _topExpectedState_25 = _topExpectation_25.getTopExpectedState();
                        boolean _equals_93 = Objects.equal(_topExpectedState_25, "ENABLED");
                        if (_equals_93) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCanGoToValue());");
                          _builder.newLine();
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("// Ha csak a divergent foglalt");
                    _builder.newLine();
                  } else {
                    boolean _and_13 = false;
                    Steps _steps_30 = test.getSteps();
                    EList<Section> _section_26 = _steps_30.getSection();
                    Section _get_26 = _section_26.get(0);
                    DivergentSection _divergentSection_5 = _get_26.getDivergentSection();
                    String _divergentSectionState_5 = _divergentSection_5.getDivergentSectionState();
                    boolean _equals_94 = Objects.equal(_divergentSectionState_5, "OCCUPIED");
                    if (!_equals_94) {
                      _and_13 = false;
                    } else {
                      Steps _steps_31 = test.getSteps();
                      EList<Section> _section_27 = _steps_31.getSection();
                      Section _get_27 = _section_27.get(0);
                      TopSection _topSection_13 = _get_27.getTopSection();
                      String _topSectionState_13 = _topSection_13.getTopSectionState();
                      boolean _equals_95 = Objects.equal(_topSectionState_13, "FREE");
                      _and_13 = _equals_95;
                    }
                    if (_and_13) {
                      {
                        Expectations _expect_60 = test.getExpect();
                        DivergentExpectation _divergentExpectation_14 = _expect_60.getDivergentExpectation();
                        String _divergentExpectedState_14 = _divergentExpectation_14.getDivergentExpectedState();
                        boolean _equals_96 = Objects.equal(_divergentExpectedState_14, "DISABLED");
                        if (_equals_96) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                          _builder.newLine();
                        } else {
                          Expectations _expect_61 = test.getExpect();
                          DivergentExpectation _divergentExpectation_15 = _expect_61.getDivergentExpectation();
                          String _divergentExpectedState_15 = _divergentExpectation_15.getDivergentExpectedState();
                          boolean _equals_97 = Objects.equal(_divergentExpectedState_15, "ENABLED");
                          if (_equals_97) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      {
                        Expectations _expect_62 = test.getExpect();
                        TopExpectation _topExpectation_26 = _expect_62.getTopExpectation();
                        String _topExpectedState_26 = _topExpectation_26.getTopExpectedState();
                        boolean _equals_98 = Objects.equal(_topExpectedState_26, "DISABLED");
                        if (_equals_98) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("turnout.runCycle();");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                          _builder.newLine();
                        } else {
                          Expectations _expect_63 = test.getExpect();
                          TopExpectation _topExpectation_27 = _expect_63.getTopExpectation();
                          String _topExpectedState_27 = _topExpectation_27.getTopExpectedState();
                          boolean _equals_99 = Objects.equal(_topExpectedState_27, "ENABLED");
                          if (_equals_99) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                            _builder.newLine();
                          }
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("// ha csak a top foglalt\t");
                      _builder.newLine();
                    } else {
                      boolean _and_14 = false;
                      Steps _steps_32 = test.getSteps();
                      EList<Section> _section_28 = _steps_32.getSection();
                      Section _get_28 = _section_28.get(0);
                      DivergentSection _divergentSection_6 = _get_28.getDivergentSection();
                      String _divergentSectionState_6 = _divergentSection_6.getDivergentSectionState();
                      boolean _equals_100 = Objects.equal(_divergentSectionState_6, "FREE");
                      if (!_equals_100) {
                        _and_14 = false;
                      } else {
                        Steps _steps_33 = test.getSteps();
                        EList<Section> _section_29 = _steps_33.getSection();
                        Section _get_29 = _section_29.get(0);
                        TopSection _topSection_14 = _get_29.getTopSection();
                        String _topSectionState_14 = _topSection_14.getTopSectionState();
                        boolean _equals_101 = Objects.equal(_topSectionState_14, "OCCUPIED");
                        _and_14 = _equals_101;
                      }
                      if (_and_14) {
                        {
                          Expectations _expect_64 = test.getExpect();
                          TopExpectation _topExpectation_28 = _expect_64.getTopExpectation();
                          String _topExpectedState_28 = _topExpectation_28.getTopExpectedState();
                          boolean _equals_102 = Objects.equal(_topExpectedState_28, "DISABLED");
                          if (_equals_102) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                            _builder.newLine();
                          } else {
                            Expectations _expect_65 = test.getExpect();
                            TopExpectation _topExpectation_29 = _expect_65.getTopExpectation();
                            String _topExpectedState_29 = _topExpectation_29.getTopExpectedState();
                            boolean _equals_103 = Objects.equal(_topExpectedState_29, "ENABLED");
                            if (_equals_103) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        {
                          Expectations _expect_66 = test.getExpect();
                          DivergentExpectation _divergentExpectation_16 = _expect_66.getDivergentExpectation();
                          String _divergentExpectedState_16 = _divergentExpectation_16.getDivergentExpectedState();
                          boolean _equals_104 = Objects.equal(_divergentExpectedState_16, "DISABLED");
                          if (_equals_104) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("turnout.runCycle();");
                            _builder.newLine();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                            _builder.newLine();
                          } else {
                            Expectations _expect_67 = test.getExpect();
                            DivergentExpectation _divergentExpectation_17 = _expect_67.getDivergentExpectation();
                            String _divergentExpectedState_17 = _divergentExpectation_17.getDivergentExpectedState();
                            boolean _equals_105 = Objects.equal(_divergentExpectedState_17, "ENABLED");
                            if (_equals_105) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                              _builder.newLine();
                            }
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("// ha egyik se foglalt\t");
                        _builder.newLine();
                      } else {
                        boolean _and_15 = false;
                        Steps _steps_34 = test.getSteps();
                        EList<Section> _section_30 = _steps_34.getSection();
                        Section _get_30 = _section_30.get(0);
                        DivergentSection _divergentSection_7 = _get_30.getDivergentSection();
                        String _divergentSectionState_7 = _divergentSection_7.getDivergentSectionState();
                        boolean _equals_106 = Objects.equal(_divergentSectionState_7, "FREE");
                        if (!_equals_106) {
                          _and_15 = false;
                        } else {
                          Steps _steps_35 = test.getSteps();
                          EList<Section> _section_31 = _steps_35.getSection();
                          Section _get_31 = _section_31.get(0);
                          TopSection _topSection_15 = _get_31.getTopSection();
                          String _topSectionState_15 = _topSection_15.getTopSectionState();
                          boolean _equals_107 = Objects.equal(_topSectionState_15, "FREE");
                          _and_15 = _equals_107;
                        }
                        if (_and_15) {
                          {
                            Expectations _expect_68 = test.getExpect();
                            TopExpectation _topExpectation_30 = _expect_68.getTopExpectation();
                            String _topExpectedState_30 = _topExpectation_30.getTopExpectedState();
                            boolean _equals_108 = Objects.equal(_topExpectedState_30, "DISABLED");
                            if (_equals_108) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());\t");
                              _builder.newLine();
                            } else {
                              Expectations _expect_69 = test.getExpect();
                              TopExpectation _topExpectation_31 = _expect_69.getTopExpectation();
                              String _topExpectedState_31 = _topExpectation_31.getTopExpectedState();
                              boolean _equals_109 = Objects.equal(_topExpectedState_31, "ENABLED");
                              if (_equals_109) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getTOP(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                          {
                            Expectations _expect_70 = test.getExpect();
                            DivergentExpectation _divergentExpectation_18 = _expect_70.getDivergentExpectation();
                            String _divergentExpectedState_18 = _divergentExpectation_18.getDivergentExpectedState();
                            boolean _equals_110 = Objects.equal(_divergentExpectedState_18, "DISABLED");
                            if (_equals_110) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.sCIProtocol.raiseCannotGoFrom(turnout.sCIDirection.getTOP());");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("turnout.runCycle();");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("assertEquals(turnout.sCIDirection.getSTRAIGHT(), turnout.sCIProtocol.getCannotGoToValue());");
                              _builder.newLine();
                            } else {
                              Expectations _expect_71 = test.getExpect();
                              DivergentExpectation _divergentExpectation_19 = _expect_71.getDivergentExpectation();
                              String _divergentExpectedState_19 = _divergentExpectation_19.getDivergentExpectedState();
                              boolean _equals_111 = Objects.equal(_divergentExpectedState_19, "ENABLED");
                              if (_equals_111) {
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseReserveFrom(turnout.sCIDirection.getDIVERGENT());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.sCIProtocol.raiseCanGoFrom(turnout.sCIDirection.getTOP());");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("turnout.runCycle();");
                                _builder.newLine();
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("assertEquals(turnout.sCIDirection.getDIVERGENT(), turnout.sCIProtocol.getCanGoToValue());");
                                _builder.newLine();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
