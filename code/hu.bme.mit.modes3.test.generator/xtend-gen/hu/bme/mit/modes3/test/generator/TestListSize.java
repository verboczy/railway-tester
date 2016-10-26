package hu.bme.mit.modes3.test.generator;

import hu.bme.mit.modes3.test.generator.ITestGenerator;
import hu.bme.mit.modes3.test.testLanguage.CaseDescription;
import hu.bme.mit.modes3.test.testLanguage.DivergentSection;
import hu.bme.mit.modes3.test.testLanguage.InitialState;
import hu.bme.mit.modes3.test.testLanguage.Model;
import hu.bme.mit.modes3.test.testLanguage.Section;
import hu.bme.mit.modes3.test.testLanguage.Steps;
import hu.bme.mit.modes3.test.testLanguage.StraightSection;
import hu.bme.mit.modes3.test.testLanguage.TopSection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class TestListSize implements ITestGenerator {
  @Override
  public String generate(final Model model) {
    InitialState init = model.getInitialState();
    EList<CaseDescription> testcases = model.getCaseDescription();
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final CaseDescription test : testcases) {
        Steps _steps = test.getSteps();
        EList<Section> _section = _steps.getSection();
        int _size = _section.size();
        _builder.append(_size, "");
        _builder.newLineIfNotEmpty();
        Steps _steps_1 = test.getSteps();
        EList<Section> _section_1 = _steps_1.getSection();
        Section _get = _section_1.get(0);
        StraightSection _straightSection = _get.getStraightSection();
        String _straightSectionState = _straightSection.getStraightSectionState();
        _builder.append(_straightSectionState, "");
        _builder.newLineIfNotEmpty();
        Steps _steps_2 = test.getSteps();
        EList<Section> _section_2 = _steps_2.getSection();
        Section _get_1 = _section_2.get(0);
        DivergentSection _divergentSection = _get_1.getDivergentSection();
        String _divergentSectionState = _divergentSection.getDivergentSectionState();
        _builder.append(_divergentSectionState, "");
        _builder.newLineIfNotEmpty();
        Steps _steps_3 = test.getSteps();
        EList<Section> _section_3 = _steps_3.getSection();
        Section _get_2 = _section_3.get(0);
        TopSection _topSection = _get_2.getTopSection();
        String _topSectionState = _topSection.getTopSectionState();
        _builder.append(_topSectionState, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
}
