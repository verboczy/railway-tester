/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.modes3.test.testLanguage.impl;

import hu.bme.mit.modes3.test.testLanguage.Comment;
import hu.bme.mit.modes3.test.testLanguage.Section;
import hu.bme.mit.modes3.test.testLanguage.Steps;
import hu.bme.mit.modes3.test.testLanguage.TestLanguagePackage;
import hu.bme.mit.modes3.test.testLanguage.Turnout;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steps</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.StepsImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.StepsImpl#getChangedTurnout <em>Changed Turnout</em>}</li>
 *   <li>{@link hu.bme.mit.modes3.test.testLanguage.impl.StepsImpl#getSection <em>Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StepsImpl extends MinimalEObjectImpl.Container implements Steps
{
  /**
   * The cached value of the '{@link #getComment() <em>Comment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment()
   * @generated
   * @ordered
   */
  protected Comment comment;

  /**
   * The cached value of the '{@link #getChangedTurnout() <em>Changed Turnout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangedTurnout()
   * @generated
   * @ordered
   */
  protected Turnout changedTurnout;

  /**
   * The cached value of the '{@link #getSection() <em>Section</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSection()
   * @generated
   * @ordered
   */
  protected EList<Section> section;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StepsImpl()
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
    return TestLanguagePackage.Literals.STEPS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comment getComment()
  {
    return comment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComment(Comment newComment, NotificationChain msgs)
  {
    Comment oldComment = comment;
    comment = newComment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STEPS__COMMENT, oldComment, newComment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComment(Comment newComment)
  {
    if (newComment != comment)
    {
      NotificationChain msgs = null;
      if (comment != null)
        msgs = ((InternalEObject)comment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.STEPS__COMMENT, null, msgs);
      if (newComment != null)
        msgs = ((InternalEObject)newComment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.STEPS__COMMENT, null, msgs);
      msgs = basicSetComment(newComment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STEPS__COMMENT, newComment, newComment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Turnout getChangedTurnout()
  {
    return changedTurnout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChangedTurnout(Turnout newChangedTurnout, NotificationChain msgs)
  {
    Turnout oldChangedTurnout = changedTurnout;
    changedTurnout = newChangedTurnout;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STEPS__CHANGED_TURNOUT, oldChangedTurnout, newChangedTurnout);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangedTurnout(Turnout newChangedTurnout)
  {
    if (newChangedTurnout != changedTurnout)
    {
      NotificationChain msgs = null;
      if (changedTurnout != null)
        msgs = ((InternalEObject)changedTurnout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.STEPS__CHANGED_TURNOUT, null, msgs);
      if (newChangedTurnout != null)
        msgs = ((InternalEObject)newChangedTurnout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLanguagePackage.STEPS__CHANGED_TURNOUT, null, msgs);
      msgs = basicSetChangedTurnout(newChangedTurnout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLanguagePackage.STEPS__CHANGED_TURNOUT, newChangedTurnout, newChangedTurnout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Section> getSection()
  {
    if (section == null)
    {
      section = new EObjectContainmentEList<Section>(Section.class, this, TestLanguagePackage.STEPS__SECTION);
    }
    return section;
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
      case TestLanguagePackage.STEPS__COMMENT:
        return basicSetComment(null, msgs);
      case TestLanguagePackage.STEPS__CHANGED_TURNOUT:
        return basicSetChangedTurnout(null, msgs);
      case TestLanguagePackage.STEPS__SECTION:
        return ((InternalEList<?>)getSection()).basicRemove(otherEnd, msgs);
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
      case TestLanguagePackage.STEPS__COMMENT:
        return getComment();
      case TestLanguagePackage.STEPS__CHANGED_TURNOUT:
        return getChangedTurnout();
      case TestLanguagePackage.STEPS__SECTION:
        return getSection();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLanguagePackage.STEPS__COMMENT:
        setComment((Comment)newValue);
        return;
      case TestLanguagePackage.STEPS__CHANGED_TURNOUT:
        setChangedTurnout((Turnout)newValue);
        return;
      case TestLanguagePackage.STEPS__SECTION:
        getSection().clear();
        getSection().addAll((Collection<? extends Section>)newValue);
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
      case TestLanguagePackage.STEPS__COMMENT:
        setComment((Comment)null);
        return;
      case TestLanguagePackage.STEPS__CHANGED_TURNOUT:
        setChangedTurnout((Turnout)null);
        return;
      case TestLanguagePackage.STEPS__SECTION:
        getSection().clear();
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
      case TestLanguagePackage.STEPS__COMMENT:
        return comment != null;
      case TestLanguagePackage.STEPS__CHANGED_TURNOUT:
        return changedTurnout != null;
      case TestLanguagePackage.STEPS__SECTION:
        return section != null && !section.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StepsImpl