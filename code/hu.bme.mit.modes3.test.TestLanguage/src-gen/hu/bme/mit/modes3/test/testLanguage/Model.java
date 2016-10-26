/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Model#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Model#getCaseDescription <em>Case Description</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Initial State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial State</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial State</em>' containment reference.
   * @see #setInitialState(InitialState)
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getModel_InitialState()
   * @model containment="true"
   * @generated
   */
  InitialState getInitialState();

  /**
   * Sets the value of the '{@link hu.bme.mit.modes3.test.testLanguage.Model#getInitialState <em>Initial State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial State</em>' containment reference.
   * @see #getInitialState()
   * @generated
   */
  void setInitialState(InitialState value);

  /**
   * Returns the value of the '<em><b>Case Description</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.modes3.test.testLanguage.CaseDescription}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case Description</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Description</em>' containment reference list.
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getModel_CaseDescription()
   * @model containment="true"
   * @generated
   */
  EList<CaseDescription> getCaseDescription();

} // Model