/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Turnout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Turnout#getTurnoutState <em>Turnout State</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getTurnout()
 * @model
 * @generated
 */
public interface Turnout extends EObject
{
  /**
   * Returns the value of the '<em><b>Turnout State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Turnout State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Turnout State</em>' attribute.
   * @see #setTurnoutState(String)
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getTurnout_TurnoutState()
   * @model
   * @generated
   */
  String getTurnoutState();

  /**
   * Sets the value of the '{@link hu.bme.mit.modes3.test.testLanguage.Turnout#getTurnoutState <em>Turnout State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Turnout State</em>' attribute.
   * @see #getTurnoutState()
   * @generated
   */
  void setTurnoutState(String value);

} // Turnout
