/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage.impl;

import hu.bme.mit.modes3.test.testLanguage.StraightSection;
import hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Straight Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.StraightSectionImpl#getStraightSectionState <em>Straight Section State</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.StraightSectionImpl#getStrID <em>Str ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StraightSectionImpl extends MinimalEObjectImpl.Container implements StraightSection
{
  /**
   * The default value of the '{@link #getStraightSectionState() <em>Straight Section State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStraightSectionState()
   * @generated
   * @ordered
   */
  protected static final String STRAIGHT_SECTION_STATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStraightSectionState() <em>Straight Section State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStraightSectionState()
   * @generated
   * @ordered
   */
  protected String straightSectionState = STRAIGHT_SECTION_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getStrID() <em>Str ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrID()
   * @generated
   * @ordered
   */
  protected static final int STR_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getStrID() <em>Str ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrID()
   * @generated
   * @ordered
   */
  protected int strID = STR_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StraightSectionImpl()
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
    return TestLanguagePackage.Literals.STRAIGHT_SECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStraightSectionState()
  {
    return straightSectionState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStraightSectionState(String newStraightSectionState)
  {
    String oldStraightSectionState = straightSectionState;
    straightSectionState = newStraightSectionState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STRAIGHT_SECTION__STRAIGHT_SECTION_STATE, oldStraightSectionState, straightSectionState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getStrID()
  {
    return strID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrID(int newStrID)
  {
    int oldStrID = strID;
    strID = newStrID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STRAIGHT_SECTION__STR_ID, oldStrID, strID));
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
      case TestLanguagePackage.STRAIGHT_SECTION__STRAIGHT_SECTION_STATE:
        return getStraightSectionState();
      case TestLanguagePackage.STRAIGHT_SECTION__STR_ID:
        return getStrID();
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
      case TestLanguagePackage.STRAIGHT_SECTION__STRAIGHT_SECTION_STATE:
        setStraightSectionState((String)newValue);
        return;
      case TestLanguagePackage.STRAIGHT_SECTION__STR_ID:
        setStrID((Integer)newValue);
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
      case TestLanguagePackage.STRAIGHT_SECTION__STRAIGHT_SECTION_STATE:
        setStraightSectionState(STRAIGHT_SECTION_STATE_EDEFAULT);
        return;
      case TestLanguagePackage.STRAIGHT_SECTION__STR_ID:
        setStrID(STR_ID_EDEFAULT);
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
      case TestLanguagePackage.STRAIGHT_SECTION__STRAIGHT_SECTION_STATE:
        return STRAIGHT_SECTION_STATE_EDEFAULT == null ? straightSectionState != null : !STRAIGHT_SECTION_STATE_EDEFAULT.equals(straightSectionState);
      case TestLanguagePackage.STRAIGHT_SECTION__STR_ID:
        return strID != STR_ID_EDEFAULT;
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
    result.append(" (straightSectionState: ");
    result.append(straightSectionState);
    result.append(", strID: ");
    result.append(strID);
    result.append(')');
    return result.toString();
  }

} //StraightSectionImpl
