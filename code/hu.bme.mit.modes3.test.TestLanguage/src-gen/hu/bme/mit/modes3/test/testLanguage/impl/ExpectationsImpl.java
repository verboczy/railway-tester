/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage.impl;

import hu.bme.mit.modes3.test.testLanguage.DivergentExpectation;
import hu.bme.mit.modes3.test.testLanguage.Expectations;
import hu.bme.mit.modes3.test.testLanguage.StraightExpectation;
import hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage;
import hu.bme.mit.modes3.test.testLanguage.TopExpectation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expectations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.ExpectationsImpl#getExpectedTurnoutID <em>Expected Turnout ID</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.ExpectationsImpl#getStraightExpectation <em>Straight Expectation</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.ExpectationsImpl#getDivergentExpectation <em>Divergent Expectation</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.ExpectationsImpl#getTopExpectation <em>Top Expectation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpectationsImpl extends MinimalEObjectImpl.Container implements Expectations
{
  /**
   * The default value of the '{@link #getExpectedTurnoutID() <em>Expected Turnout ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpectedTurnoutID()
   * @generated
   * @ordered
   */
  protected static final int EXPECTED_TURNOUT_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getExpectedTurnoutID() <em>Expected Turnout ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpectedTurnoutID()
   * @generated
   * @ordered
   */
  protected int expectedTurnoutID = EXPECTED_TURNOUT_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getStraightExpectation() <em>Straight Expectation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStraightExpectation()
   * @generated
   * @ordered
   */
  protected StraightExpectation straightExpectation;

  /**
   * The cached value of the '{@link #getDivergentExpectation() <em>Divergent Expectation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDivergentExpectation()
   * @generated
   * @ordered
   */
  protected DivergentExpectation divergentExpectation;

  /**
   * The cached value of the '{@link #getTopExpectation() <em>Top Expectation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTopExpectation()
   * @generated
   * @ordered
   */
  protected TopExpectation topExpectation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpectationsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TestLanguagePackage.Literals.EXPECTATIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getExpectedTurnoutID()
  {
    return expectedTurnoutID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpectedTurnoutID(int newExpectedTurnoutID)
  {
    int oldExpectedTurnoutID = expectedTurnoutID;
    expectedTurnoutID = newExpectedTurnoutID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__EXPECTED_TURNOUT_ID, oldExpectedTurnoutID, expectedTurnoutID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StraightExpectation getStraightExpectation()
  {
    return straightExpectation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStraightExpectation(StraightExpectation newStraightExpectation, NotificationChain msgs)
  {
    StraightExpectation oldStraightExpectation = straightExpectation;
    straightExpectation = newStraightExpectation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION, oldStraightExpectation, newStraightExpectation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStraightExpectation(StraightExpectation newStraightExpectation)
  {
    if (newStraightExpectation != straightExpectation)
    {
      NotificationChain msgs = null;
      if (straightExpectation != null)
        msgs = ((InternalEObject)straightExpectation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION, null, msgs);
      if (newStraightExpectation != null)
        msgs = ((InternalEObject)newStraightExpectation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION, null, msgs);
      msgs = basicSetStraightExpectation(newStraightExpectation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION, newStraightExpectation, newStraightExpectation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DivergentExpectation getDivergentExpectation()
  {
    return divergentExpectation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDivergentExpectation(DivergentExpectation newDivergentExpectation, NotificationChain msgs)
  {
    DivergentExpectation oldDivergentExpectation = divergentExpectation;
    divergentExpectation = newDivergentExpectation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION, oldDivergentExpectation, newDivergentExpectation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDivergentExpectation(DivergentExpectation newDivergentExpectation)
  {
    if (newDivergentExpectation != divergentExpectation)
    {
      NotificationChain msgs = null;
      if (divergentExpectation != null)
        msgs = ((InternalEObject)divergentExpectation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION, null, msgs);
      if (newDivergentExpectation != null)
        msgs = ((InternalEObject)newDivergentExpectation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION, null, msgs);
      msgs = basicSetDivergentExpectation(newDivergentExpectation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION, newDivergentExpectation, newDivergentExpectation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TopExpectation getTopExpectation()
  {
    return topExpectation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTopExpectation(TopExpectation newTopExpectation, NotificationChain msgs)
  {
    TopExpectation oldTopExpectation = topExpectation;
    topExpectation = newTopExpectation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION, oldTopExpectation, newTopExpectation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTopExpectation(TopExpectation newTopExpectation)
  {
    if (newTopExpectation != topExpectation)
    {
      NotificationChain msgs = null;
      if (topExpectation != null)
        msgs = ((InternalEObject)topExpectation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION, null, msgs);
      if (newTopExpectation != null)
        msgs = ((InternalEObject)newTopExpectation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION, null, msgs);
      msgs = basicSetTopExpectation(newTopExpectation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION, newTopExpectation, newTopExpectation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION:
        return basicSetStraightExpectation(null, msgs);
      case TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION:
        return basicSetDivergentExpectation(null, msgs);
      case TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION:
        return basicSetTopExpectation(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TestLanguagePackage.EXPECTATIONS__EXPECTED_TURNOUT_ID:
        return getExpectedTurnoutID();
      case TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION:
        return getStraightExpectation();
      case TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION:
        return getDivergentExpectation();
      case TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION:
        return getTopExpectation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLanguagePackage.EXPECTATIONS__EXPECTED_TURNOUT_ID:
        setExpectedTurnoutID((Integer)newValue);
        return;
      case TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION:
        setStraightExpectation((StraightExpectation)newValue);
        return;
      case TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION:
        setDivergentExpectation((DivergentExpectation)newValue);
        return;
      case TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION:
        setTopExpectation((TopExpectation)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TestLanguagePackage.EXPECTATIONS__EXPECTED_TURNOUT_ID:
        setExpectedTurnoutID(EXPECTED_TURNOUT_ID_EDEFAULT);
        return;
      case TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION:
        setStraightExpectation((StraightExpectation)null);
        return;
      case TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION:
        setDivergentExpectation((DivergentExpectation)null);
        return;
      case TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION:
        setTopExpectation((TopExpectation)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TestLanguagePackage.EXPECTATIONS__EXPECTED_TURNOUT_ID:
        return expectedTurnoutID != EXPECTED_TURNOUT_ID_EDEFAULT;
      case TestLanguagePackage.EXPECTATIONS__STRAIGHT_EXPECTATION:
        return straightExpectation != null;
      case TestLanguagePackage.EXPECTATIONS__DIVERGENT_EXPECTATION:
        return divergentExpectation != null;
      case TestLanguagePackage.EXPECTATIONS__TOP_EXPECTATION:
        return topExpectation != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (expectedTurnoutID: ");
    result.append(expectedTurnoutID);
    result.append(')');
    return result.toString();
  }

} //ExpectationsImpl
