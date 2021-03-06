/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage.impl;

import hu.bme.mit.modes3.test.testLanguage.CaseDescription;
import hu.bme.mit.modes3.test.testLanguage.CaseName;
import hu.bme.mit.modes3.test.testLanguage.Comment;
import hu.bme.mit.modes3.test.testLanguage.Component;
import hu.bme.mit.modes3.test.testLanguage.DivergentExpectation;
import hu.bme.mit.modes3.test.testLanguage.DivergentSection;
import hu.bme.mit.modes3.test.testLanguage.Expectations;
import hu.bme.mit.modes3.test.testLanguage.Model;
import hu.bme.mit.modes3.test.testLanguage.Section;
import hu.bme.mit.modes3.test.testLanguage.StraightExpectation;
import hu.bme.mit.modes3.test.testLanguage.StraightSection;
import hu.bme.mit.modes3.test.testLanguage.TestLanguageFactory;
import hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage;
import hu.bme.mit.modes3.test.testLanguage.TopExpectation;
import hu.bme.mit.modes3.test.testLanguage.TopSection;
import hu.bme.mit.modes3.test.testLanguage.Turnout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLanguagePackageImpl extends EPackageImpl implements TestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass turnoutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass straightSectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass divergentSectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass topSectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expectationsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass straightExpectationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass divergentExpectationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass topExpectationEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TestLanguagePackageImpl()
  {
    super(eNS_URI, TestLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TestLanguagePackage init()
  {
    if (isInited) return (TestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(TestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    TestLanguagePackageImpl theTestLanguagePackage = (TestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestLanguagePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TestLanguagePackage.eNS_URI, theTestLanguagePackage);
    return theTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_CaseDescription()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCaseDescription()
  {
    return caseDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseDescription_CaseName()
  {
    return (EReference)caseDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseDescription_Comment()
  {
    return (EReference)caseDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseDescription_Components()
  {
    return (EReference)caseDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseDescription_Expect()
  {
    return (EReference)caseDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCaseName()
  {
    return caseNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCaseName_Name()
  {
    return (EAttribute)caseNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComment()
  {
    return commentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComment_Comment()
  {
    return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponent()
  {
    return componentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponent_Turnout()
  {
    return (EReference)componentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponent_Section()
  {
    return (EReference)componentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTurnout()
  {
    return turnoutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTurnout_TurnoutID()
  {
    return (EAttribute)turnoutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTurnout_TurnoutState()
  {
    return (EAttribute)turnoutEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSection()
  {
    return sectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSection_StraightSection()
  {
    return (EReference)sectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSection_DivergentSection()
  {
    return (EReference)sectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSection_TopSection()
  {
    return (EReference)sectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStraightSection()
  {
    return straightSectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStraightSection_StraightSectionState()
  {
    return (EAttribute)straightSectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStraightSection_StrID()
  {
    return (EAttribute)straightSectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDivergentSection()
  {
    return divergentSectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDivergentSection_DivergentSectionState()
  {
    return (EAttribute)divergentSectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDivergentSection_DivID()
  {
    return (EAttribute)divergentSectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTopSection()
  {
    return topSectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopSection_TopSectionState()
  {
    return (EAttribute)topSectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopSection_TopID()
  {
    return (EAttribute)topSectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpectations()
  {
    return expectationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpectations_ExpectedTurnoutID()
  {
    return (EAttribute)expectationsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpectations_StraightExpectation()
  {
    return (EReference)expectationsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpectations_DivergentExpectation()
  {
    return (EReference)expectationsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpectations_TopExpectation()
  {
    return (EReference)expectationsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStraightExpectation()
  {
    return straightExpectationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStraightExpectation_StraightExpectedState()
  {
    return (EAttribute)straightExpectationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStraightExpectation_StrID()
  {
    return (EAttribute)straightExpectationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDivergentExpectation()
  {
    return divergentExpectationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDivergentExpectation_DivergentExpectedState()
  {
    return (EAttribute)divergentExpectationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDivergentExpectation_DivID()
  {
    return (EAttribute)divergentExpectationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTopExpectation()
  {
    return topExpectationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopExpectation_TopExpectedState()
  {
    return (EAttribute)topExpectationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopExpectation_TopID()
  {
    return (EAttribute)topExpectationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLanguageFactory getTestLanguageFactory()
  {
    return (TestLanguageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__CASE_DESCRIPTION);

    caseDescriptionEClass = createEClass(CASE_DESCRIPTION);
    createEReference(caseDescriptionEClass, CASE_DESCRIPTION__CASE_NAME);
    createEReference(caseDescriptionEClass, CASE_DESCRIPTION__COMMENT);
    createEReference(caseDescriptionEClass, CASE_DESCRIPTION__COMPONENTS);
    createEReference(caseDescriptionEClass, CASE_DESCRIPTION__EXPECT);

    caseNameEClass = createEClass(CASE_NAME);
    createEAttribute(caseNameEClass, CASE_NAME__NAME);

    commentEClass = createEClass(COMMENT);
    createEAttribute(commentEClass, COMMENT__COMMENT);

    componentEClass = createEClass(COMPONENT);
    createEReference(componentEClass, COMPONENT__TURNOUT);
    createEReference(componentEClass, COMPONENT__SECTION);

    turnoutEClass = createEClass(TURNOUT);
    createEAttribute(turnoutEClass, TURNOUT__TURNOUT_ID);
    createEAttribute(turnoutEClass, TURNOUT__TURNOUT_STATE);

    sectionEClass = createEClass(SECTION);
    createEReference(sectionEClass, SECTION__STRAIGHT_SECTION);
    createEReference(sectionEClass, SECTION__DIVERGENT_SECTION);
    createEReference(sectionEClass, SECTION__TOP_SECTION);

    straightSectionEClass = createEClass(STRAIGHT_SECTION);
    createEAttribute(straightSectionEClass, STRAIGHT_SECTION__STRAIGHT_SECTION_STATE);
    createEAttribute(straightSectionEClass, STRAIGHT_SECTION__STR_ID);

    divergentSectionEClass = createEClass(DIVERGENT_SECTION);
    createEAttribute(divergentSectionEClass, DIVERGENT_SECTION__DIVERGENT_SECTION_STATE);
    createEAttribute(divergentSectionEClass, DIVERGENT_SECTION__DIV_ID);

    topSectionEClass = createEClass(TOP_SECTION);
    createEAttribute(topSectionEClass, TOP_SECTION__TOP_SECTION_STATE);
    createEAttribute(topSectionEClass, TOP_SECTION__TOP_ID);

    expectationsEClass = createEClass(EXPECTATIONS);
    createEAttribute(expectationsEClass, EXPECTATIONS__EXPECTED_TURNOUT_ID);
    createEReference(expectationsEClass, EXPECTATIONS__STRAIGHT_EXPECTATION);
    createEReference(expectationsEClass, EXPECTATIONS__DIVERGENT_EXPECTATION);
    createEReference(expectationsEClass, EXPECTATIONS__TOP_EXPECTATION);

    straightExpectationEClass = createEClass(STRAIGHT_EXPECTATION);
    createEAttribute(straightExpectationEClass, STRAIGHT_EXPECTATION__STRAIGHT_EXPECTED_STATE);
    createEAttribute(straightExpectationEClass, STRAIGHT_EXPECTATION__STR_ID);

    divergentExpectationEClass = createEClass(DIVERGENT_EXPECTATION);
    createEAttribute(divergentExpectationEClass, DIVERGENT_EXPECTATION__DIVERGENT_EXPECTED_STATE);
    createEAttribute(divergentExpectationEClass, DIVERGENT_EXPECTATION__DIV_ID);

    topExpectationEClass = createEClass(TOP_EXPECTATION);
    createEAttribute(topExpectationEClass, TOP_EXPECTATION__TOP_EXPECTED_STATE);
    createEAttribute(topExpectationEClass, TOP_EXPECTATION__TOP_ID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_CaseDescription(), this.getCaseDescription(), null, "caseDescription", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(caseDescriptionEClass, CaseDescription.class, "CaseDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCaseDescription_CaseName(), this.getCaseName(), null, "caseName", null, 0, 1, CaseDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseDescription_Comment(), this.getComment(), null, "comment", null, 0, 1, CaseDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseDescription_Components(), this.getComponent(), null, "components", null, 0, -1, CaseDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseDescription_Expect(), this.getExpectations(), null, "expect", null, 0, -1, CaseDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(caseNameEClass, CaseName.class, "CaseName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCaseName_Name(), ecorePackage.getEString(), "name", null, 0, 1, CaseName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComment_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponent_Turnout(), this.getTurnout(), null, "turnout", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponent_Section(), this.getSection(), null, "section", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(turnoutEClass, Turnout.class, "Turnout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTurnout_TurnoutID(), ecorePackage.getEInt(), "turnoutID", null, 0, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTurnout_TurnoutState(), ecorePackage.getEString(), "turnoutState", null, 0, 1, Turnout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSection_StraightSection(), this.getStraightSection(), null, "straightSection", null, 0, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSection_DivergentSection(), this.getDivergentSection(), null, "divergentSection", null, 0, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSection_TopSection(), this.getTopSection(), null, "topSection", null, 0, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(straightSectionEClass, StraightSection.class, "StraightSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStraightSection_StraightSectionState(), ecorePackage.getEString(), "straightSectionState", null, 0, 1, StraightSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStraightSection_StrID(), ecorePackage.getEInt(), "strID", null, 0, 1, StraightSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(divergentSectionEClass, DivergentSection.class, "DivergentSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDivergentSection_DivergentSectionState(), ecorePackage.getEString(), "divergentSectionState", null, 0, 1, DivergentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDivergentSection_DivID(), ecorePackage.getEInt(), "divID", null, 0, 1, DivergentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topSectionEClass, TopSection.class, "TopSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTopSection_TopSectionState(), ecorePackage.getEString(), "topSectionState", null, 0, 1, TopSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopSection_TopID(), ecorePackage.getEInt(), "topID", null, 0, 1, TopSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expectationsEClass, Expectations.class, "Expectations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpectations_ExpectedTurnoutID(), ecorePackage.getEInt(), "expectedTurnoutID", null, 0, 1, Expectations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpectations_StraightExpectation(), this.getStraightExpectation(), null, "straightExpectation", null, 0, 1, Expectations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpectations_DivergentExpectation(), this.getDivergentExpectation(), null, "divergentExpectation", null, 0, 1, Expectations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpectations_TopExpectation(), this.getTopExpectation(), null, "topExpectation", null, 0, 1, Expectations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(straightExpectationEClass, StraightExpectation.class, "StraightExpectation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStraightExpectation_StraightExpectedState(), ecorePackage.getEString(), "straightExpectedState", null, 0, 1, StraightExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStraightExpectation_StrID(), ecorePackage.getEInt(), "strID", null, 0, 1, StraightExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(divergentExpectationEClass, DivergentExpectation.class, "DivergentExpectation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDivergentExpectation_DivergentExpectedState(), ecorePackage.getEString(), "divergentExpectedState", null, 0, 1, DivergentExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDivergentExpectation_DivID(), ecorePackage.getEInt(), "divID", null, 0, 1, DivergentExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topExpectationEClass, TopExpectation.class, "TopExpectation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTopExpectation_TopExpectedState(), ecorePackage.getEString(), "topExpectedState", null, 0, 1, TopExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopExpectation_TopID(), ecorePackage.getEInt(), "topID", null, 0, 1, TopExpectation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TestLanguagePackageImpl
