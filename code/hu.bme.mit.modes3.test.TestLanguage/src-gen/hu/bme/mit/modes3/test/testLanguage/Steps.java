/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Steps</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Steps#getComment <em>Comment</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Steps#getChangedTurnout <em>Changed Turnout</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.Steps#getSection <em>Section</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getSteps()
 * @model
 * @generated
 */
public interface Steps extends EObject
{
  /**
   * Returns the value of the '<em><b>Comment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' containment reference.
   * @see #setComment(Comment)
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getSteps_Comment()
   * @model containment="true"
   * @generated
   */
  Comment getComment();

  /**
   * Sets the value of the '{@link hu.bme.mit.modes3.test.testLanguage.Steps#getComment <em>Comment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' containment reference.
   * @see #getComment()
   * @generated
   */
  void setComment(Comment value);

  /**
   * Returns the value of the '<em><b>Changed Turnout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Changed Turnout</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changed Turnout</em>' containment reference.
   * @see #setChangedTurnout(Turnout)
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getSteps_ChangedTurnout()
   * @model containment="true"
   * @generated
   */
  Turnout getChangedTurnout();

  /**
   * Sets the value of the '{@link hu.bme.mit.modes3.test.testLanguage.Steps#getChangedTurnout <em>Changed Turnout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Changed Turnout</em>' containment reference.
   * @see #getChangedTurnout()
   * @generated
   */
  void setChangedTurnout(Turnout value);

  /**
   * Returns the value of the '<em><b>Section</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.modes3.test.testLanguage.Section}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Section</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Section</em>' containment reference list.
   * @see hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage#getSteps_Section()
   * @model containment="true"
   * @generated
   */
  EList<Section> getSection();

} // Steps