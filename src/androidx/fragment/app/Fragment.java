package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import d.f.i;
import d.i.a.k;
import d.m.a.c.a;
import d.m.a.l0;
import d.m.a.m0;
import d.m.a.p;
import d.m.a.p.g;
import d.m.a.r;
import d.m.a.t;
import d.o.a0;
import d.o.e0;
import d.o.f0;
import d.o.g;
import d.o.g.a;
import d.o.g.b;
import d.o.q;
import d.o.x;
import d.p.a.b.a;
import d.p.a.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, d.o.l, f0, d.v.c
{
  public static final int ACTIVITY_CREATED = 2;
  public static final int ATTACHED = 0;
  public static final int CREATED = 1;
  public static final int INITIALIZING = -1;
  public static final int RESUMED = 4;
  public static final int STARTED = 3;
  public static final Object USE_DEFAULT_TRANSITION = new Object();
  public boolean mAdded;
  public Fragment.d mAnimationInfo;
  public Bundle mArguments;
  public int mBackStackNesting;
  public boolean mCalled;
  public p mChildFragmentManager = new r();
  public ViewGroup mContainer;
  public int mContainerId;
  public int mContentLayoutId;
  public a0 mDefaultFactory;
  public boolean mDeferStart;
  public boolean mDetached;
  public int mFragmentId;
  public p mFragmentManager;
  public boolean mFromLayout;
  public boolean mHasMenu;
  public boolean mHidden;
  public boolean mHiddenChanged;
  public d.m.a.m<?> mHost;
  public boolean mInLayout;
  public boolean mIsCreated;
  public boolean mIsNewlyAdded;
  public Boolean mIsPrimaryNavigationFragment = null;
  public LayoutInflater mLayoutInflater;
  public d.o.m mLifecycleRegistry;
  public g.b mMaxState = g.b.RESUMED;
  public boolean mMenuVisible = true;
  public Fragment mParentFragment;
  public boolean mPerformedCreateView;
  public float mPostponedAlpha;
  public Runnable mPostponedDurationRunnable = new Fragment.a(this);
  public boolean mRemoving;
  public boolean mRestored;
  public boolean mRetainInstance;
  public boolean mRetainInstanceChangedWhileDetached;
  public Bundle mSavedFragmentState;
  public d.v.b mSavedStateRegistryController;
  public Boolean mSavedUserVisibleHint;
  public SparseArray<Parcelable> mSavedViewState;
  public int mState = -1;
  public String mTag;
  public Fragment mTarget;
  public int mTargetRequestCode;
  public String mTargetWho = null;
  public boolean mUserVisibleHint = true;
  public View mView;
  public l0 mViewLifecycleOwner;
  public q<d.o.l> mViewLifecycleOwnerLiveData = new q();
  public String mWho = UUID.randomUUID().toString();
  
  public Fragment()
  {
    initLifecycle();
  }
  
  public Fragment(int paramInt)
  {
    this();
    mContentLayoutId = paramInt;
  }
  
  private Fragment.d ensureAnimationInfo()
  {
    if (mAnimationInfo == null) {
      mAnimationInfo = new Fragment.d();
    }
    return mAnimationInfo;
  }
  
  private void initLifecycle()
  {
    mLifecycleRegistry = new d.o.m(this);
    mSavedStateRegistryController = new d.v.b(this);
    mLifecycleRegistry.a(new Fragment.2(this));
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  @Deprecated
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      paramContext = (Fragment)d.m.a.l.d(paramContext.getClassLoader(), paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new Fragment.e(e.a.a.a.a.a("Unable to instantiate fragment ", paramString, ": calling Fragment constructor caused an exception"), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new Fragment.e(e.a.a.a.a.a("Unable to instantiate fragment ", paramString, ": could not find Fragment constructor"), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new Fragment.e(e.a.a.a.a.a("Unable to instantiate fragment ", paramString, ": make sure class name exists, is public, and has an empty constructor that is public"), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new Fragment.e(e.a.a.a.a.a("Unable to instantiate fragment ", paramString, ": make sure class name exists, is public, and has an empty constructor that is public"), paramContext);
    }
  }
  
  public void callStartTransitionListener()
  {
    Fragment.d locald = mAnimationInfo;
    Object localObject = null;
    if (locald != null)
    {
      p = false;
      localObject = q;
      q = null;
    }
    if (localObject != null)
    {
      localObject = (p.g)localObject;
      int i = c - 1;
      c = i;
      if (i == 0) {
        b.r.m();
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(mState);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(mRetainInstance);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(mUserVisibleHint);
    if (mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(mFragmentManager);
    }
    if (mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(mHost);
    }
    if (mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(mParentFragment);
    }
    if (mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(mArguments);
    }
    if (mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(mSavedFragmentState);
    }
    if (mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(mSavedViewState);
    }
    Object localObject = getTargetFragment();
    if (localObject != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(localObject);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    }
    if (mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(mContainer);
    }
    if (mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null) {
      d.p.a.a.a(this).a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    paramPrintWriter.print(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Child ");
    ((StringBuilder)localObject).append(mChildFragmentManager);
    ((StringBuilder)localObject).append(":");
    paramPrintWriter.println(((StringBuilder)localObject).toString());
    mChildFragmentManager.a(e.a.a.a.a.b(paramString, "  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(mWho)) {
      return this;
    }
    return mChildFragmentManager.c(paramString);
  }
  
  public final d.m.a.c getActivity()
  {
    Object localObject = mHost;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (d.m.a.c)x;
    }
    return (d.m.a.c)localObject;
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = m;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    Object localObject = mAnimationInfo;
    if (localObject != null)
    {
      localObject = l;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public View getAnimatingAway()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return null;
    }
    return a;
  }
  
  public Animator getAnimator()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return null;
    }
    return b;
  }
  
  public final Bundle getArguments()
  {
    return mArguments;
  }
  
  public final p getChildFragmentManager()
  {
    if (mHost != null) {
      return mChildFragmentManager;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " has not been attached yet."));
  }
  
  public Context getContext()
  {
    Object localObject = mHost;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = y;
    }
    return (Context)localObject;
  }
  
  public a0 getDefaultViewModelProviderFactory()
  {
    if (mFragmentManager != null)
    {
      if (mDefaultFactory == null) {
        mDefaultFactory = new x(requireActivity().getApplication(), this, getArguments());
      }
      return mDefaultFactory;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  public Object getEnterTransition()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return null;
    }
    return f;
  }
  
  public k getEnterTransitionCallback()
  {
    if (mAnimationInfo == null) {}
    return null;
  }
  
  public Object getExitTransition()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return null;
    }
    return h;
  }
  
  public k getExitTransitionCallback()
  {
    if (mAnimationInfo == null) {}
    return null;
  }
  
  @Deprecated
  public final p getFragmentManager()
  {
    return mFragmentManager;
  }
  
  public final Object getHost()
  {
    Object localObject = mHost;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = B;
    }
    return localObject;
  }
  
  public final int getId()
  {
    return mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    LayoutInflater localLayoutInflater1 = mLayoutInflater;
    LayoutInflater localLayoutInflater2 = localLayoutInflater1;
    if (localLayoutInflater1 == null) {
      localLayoutInflater2 = performGetLayoutInflater(null);
    }
    return localLayoutInflater2;
  }
  
  @Deprecated
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    paramBundle = mHost;
    if (paramBundle != null)
    {
      paramBundle = (c.a)paramBundle;
      paramBundle = B.getLayoutInflater().cloneInContext(B);
      paramBundle.setFactory2(mChildFragmentManager.f);
      return paramBundle;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public g getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  @Deprecated
  public d.p.a.a getLoaderManager()
  {
    return d.p.a.a.a(this);
  }
  
  public int getNextAnim()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return 0;
    }
    return d;
  }
  
  public int getNextTransition()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return 0;
    }
    return e;
  }
  
  public final Fragment getParentFragment()
  {
    return mParentFragment;
  }
  
  public final p getParentFragmentManager()
  {
    p localp = mFragmentManager;
    if (localp != null) {
      return localp;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not associated with a fragment manager."));
  }
  
  public Object getReenterTransition()
  {
    Object localObject1 = mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = i;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getExitTransition();
    }
    return localObject1;
  }
  
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  public final boolean getRetainInstance()
  {
    return mRetainInstance;
  }
  
  public Object getReturnTransition()
  {
    Object localObject1 = mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = g;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getEnterTransition();
    }
    return localObject1;
  }
  
  public final d.v.a getSavedStateRegistry()
  {
    return mSavedStateRegistryController.b;
  }
  
  public Object getSharedElementEnterTransition()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return null;
    }
    return j;
  }
  
  public Object getSharedElementReturnTransition()
  {
    Object localObject1 = mAnimationInfo;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = k;
    localObject1 = localObject2;
    if (localObject2 == USE_DEFAULT_TRANSITION) {
      localObject1 = getSharedElementEnterTransition();
    }
    return localObject1;
  }
  
  public int getStateAfterAnimating()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return 0;
    }
    return c;
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return mTag;
  }
  
  public final Fragment getTargetFragment()
  {
    Object localObject = mTarget;
    if (localObject != null) {
      return (Fragment)localObject;
    }
    p localp = mFragmentManager;
    if (localp != null)
    {
      localObject = mTargetWho;
      if (localObject != null) {
        return localp.a((String)localObject);
      }
    }
    return null;
  }
  
  public final int getTargetRequestCode()
  {
    return mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  @Deprecated
  public boolean getUserVisibleHint()
  {
    return mUserVisibleHint;
  }
  
  public View getView()
  {
    return mView;
  }
  
  public d.o.l getViewLifecycleOwner()
  {
    l0 locall0 = mViewLifecycleOwner;
    if (locall0 != null) {
      return locall0;
    }
    throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
  }
  
  public LiveData<d.o.l> getViewLifecycleOwnerLiveData()
  {
    return mViewLifecycleOwnerLiveData;
  }
  
  public e0 getViewModelStore()
  {
    Object localObject = mFragmentManager;
    if (localObject != null)
    {
      t localt = C;
      e0 locale0 = (e0)e.get(mWho);
      localObject = locale0;
      if (locale0 == null)
      {
        localObject = new e0();
        e.put(mWho, localObject);
      }
      return (e0)localObject;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  @SuppressLint({"KotlinPropertyAccess"})
  public final boolean hasOptionsMenu()
  {
    return mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public void initState()
  {
    initLifecycle();
    mWho = UUID.randomUUID().toString();
    mAdded = false;
    mRemoving = false;
    mFromLayout = false;
    mInLayout = false;
    mRestored = false;
    mBackStackNesting = 0;
    mFragmentManager = null;
    mChildFragmentManager = new r();
    mHost = null;
    mFragmentId = 0;
    mContainerId = 0;
    mTag = null;
    mHidden = false;
    mDetached = false;
  }
  
  public final boolean isAdded()
  {
    boolean bool;
    if ((mHost != null) && (mAdded)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isDetached()
  {
    return mDetached;
  }
  
  public final boolean isHidden()
  {
    return mHidden;
  }
  
  public boolean isHideReplaced()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return false;
    }
    return r;
  }
  
  public final boolean isInBackStack()
  {
    boolean bool;
    if (mBackStackNesting > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isInLayout()
  {
    return mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    return mMenuVisible;
  }
  
  public boolean isPostponed()
  {
    Fragment.d locald = mAnimationInfo;
    if (locald == null) {
      return false;
    }
    return p;
  }
  
  public final boolean isRemoving()
  {
    return mRemoving;
  }
  
  public final boolean isRemovingParent()
  {
    Fragment localFragment = getParentFragment();
    boolean bool;
    if ((localFragment != null) && ((localFragment.isRemoving()) || (localFragment.isRemovingParent()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isResumed()
  {
    boolean bool;
    if (mState >= 4) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isStateSaved()
  {
    p localp = mFragmentManager;
    if (localp == null) {
      return false;
    }
    return localp.i();
  }
  
  public final boolean isVisible()
  {
    if ((isAdded()) && (!isHidden()))
    {
      View localView = mView;
      if ((localView != null) && (localView.getWindowToken() != null) && (mView.getVisibility() == 0)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void noteStateNotSaved()
  {
    mChildFragmentManager.j();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    mCalled = true;
  }
  
  public void onAttach(Context paramContext)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = x;
    }
    if (paramContext != null)
    {
      mCalled = false;
      onAttach(paramContext);
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (mChildFragmentManager.m < 1) {
      i = 0;
    }
    if (i == 0) {
      mChildFragmentManager.b();
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    requireActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = mContentLayoutId;
    if (i != 0) {
      return paramLayoutInflater.inflate(i, paramViewGroup, false);
    }
    return null;
  }
  
  public void onDestroy()
  {
    mCalled = true;
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    mCalled = true;
  }
  
  public void onDetach()
  {
    mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    mCalled = true;
    paramContext = mHost;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = x;
    }
    if (paramContext != null)
    {
      mCalled = false;
      onInflate(paramContext, paramAttributeSet, paramBundle);
    }
  }
  
  public void onLowMemory()
  {
    mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume()
  {
    mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    mCalled = true;
  }
  
  public void onStop()
  {
    mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    mCalled = true;
  }
  
  public void performActivityCreated(Bundle paramBundle)
  {
    mChildFragmentManager.j();
    mState = 2;
    mCalled = false;
    onActivityCreated(paramBundle);
    if (mCalled)
    {
      paramBundle = mChildFragmentManager;
      u = false;
      v = false;
      paramBundle.a(2);
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onActivityCreated()"));
  }
  
  public void performAttach()
  {
    mChildFragmentManager.a(mHost, new Fragment.c(this), this);
    mState = 0;
    mCalled = false;
    onAttach(mHost.y);
    if (mCalled) {
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onAttach()"));
  }
  
  public void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    mChildFragmentManager.a(paramConfiguration);
  }
  
  public boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {
        return true;
      }
      if (mChildFragmentManager.a(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  public void performCreate(Bundle paramBundle)
  {
    mChildFragmentManager.j();
    mState = 1;
    mCalled = false;
    mSavedStateRegistryController.a(paramBundle);
    onCreate(paramBundle);
    mIsCreated = true;
    if (mCalled)
    {
      mLifecycleRegistry.a(g.a.ON_CREATE);
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onCreate()"));
  }
  
  public boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = mHidden;
    boolean bool2 = false;
    int i = 0;
    if (!bool1)
    {
      int j = i;
      if (mHasMenu)
      {
        j = i;
        if (mMenuVisible)
        {
          j = 1;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool2 = j | mChildFragmentManager.a(paramMenu, paramMenuInflater);
    }
    return bool2;
  }
  
  public void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mChildFragmentManager.j();
    int i = 1;
    mPerformedCreateView = true;
    mViewLifecycleOwner = new l0();
    paramLayoutInflater = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    mView = paramLayoutInflater;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = mViewLifecycleOwner;
      if (x == null) {
        x = new d.o.m(paramLayoutInflater);
      }
      mViewLifecycleOwnerLiveData.a(mViewLifecycleOwner);
    }
    else
    {
      if (mViewLifecycleOwner.x == null) {
        i = 0;
      }
      if (i != 0) {
        break label108;
      }
      mViewLifecycleOwner = null;
    }
    return;
    label108:
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  public void performDestroy()
  {
    mChildFragmentManager.c();
    mLifecycleRegistry.a(g.a.ON_DESTROY);
    mState = 0;
    mCalled = false;
    mIsCreated = false;
    onDestroy();
    if (mCalled) {
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onDestroy()"));
  }
  
  public void performDestroyView()
  {
    mChildFragmentManager.a(1);
    Object localObject1;
    Object localObject2;
    if (mView != null)
    {
      localObject1 = mViewLifecycleOwner;
      localObject2 = g.a.ON_DESTROY;
      x.a((g.a)localObject2);
    }
    mState = 1;
    mCalled = false;
    onDestroyView();
    if (mCalled)
    {
      localObject1 = ab;
      int i = c.b();
      for (int j = 0; j < i; j++) {
        localObject2 = c.d(j)).j;
      }
      mPerformedCreateView = false;
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onDestroyView()"));
  }
  
  public void performDetach()
  {
    mState = -1;
    mCalled = false;
    onDetach();
    mLayoutInflater = null;
    if (mCalled)
    {
      p localp = mChildFragmentManager;
      if (!w)
      {
        localp.c();
        mChildFragmentManager = new r();
      }
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onDetach()"));
  }
  
  public LayoutInflater performGetLayoutInflater(Bundle paramBundle)
  {
    paramBundle = onGetLayoutInflater(paramBundle);
    mLayoutInflater = paramBundle;
    return paramBundle;
  }
  
  public void performLowMemory()
  {
    onLowMemory();
    mChildFragmentManager.d();
  }
  
  public void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    mChildFragmentManager.a(paramBoolean);
  }
  
  public boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      if (mChildFragmentManager.b(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  public void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!mHidden)
    {
      if ((mHasMenu) && (mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      mChildFragmentManager.a(paramMenu);
    }
  }
  
  public void performPause()
  {
    mChildFragmentManager.a(3);
    if (mView != null)
    {
      l0 locall0 = mViewLifecycleOwner;
      g.a locala = g.a.ON_PAUSE;
      x.a(locala);
    }
    mLifecycleRegistry.a(g.a.ON_PAUSE);
    mState = 3;
    mCalled = false;
    onPause();
    if (mCalled) {
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onPause()"));
  }
  
  public void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    mChildFragmentManager.b(paramBoolean);
  }
  
  public boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = mHidden;
    boolean bool2 = false;
    int i = 0;
    if (!bool1)
    {
      int j = i;
      if (mHasMenu)
      {
        j = i;
        if (mMenuVisible)
        {
          j = 1;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool2 = j | mChildFragmentManager.b(paramMenu);
    }
    return bool2;
  }
  
  public void performPrimaryNavigationFragmentChanged()
  {
    boolean bool = mFragmentManager.k(this);
    Object localObject = mIsPrimaryNavigationFragment;
    if ((localObject == null) || (((Boolean)localObject).booleanValue() != bool))
    {
      mIsPrimaryNavigationFragment = Boolean.valueOf(bool);
      onPrimaryNavigationFragmentChanged(bool);
      localObject = mChildFragmentManager;
      ((p)localObject).o();
      ((p)localObject).g(q);
    }
  }
  
  public void performResume()
  {
    mChildFragmentManager.j();
    mChildFragmentManager.d(true);
    mState = 4;
    mCalled = false;
    onResume();
    if (mCalled)
    {
      mLifecycleRegistry.a(g.a.ON_RESUME);
      if (mView != null)
      {
        localObject = mViewLifecycleOwner;
        g.a locala = g.a.ON_RESUME;
        x.a(locala);
      }
      Object localObject = mChildFragmentManager;
      u = false;
      v = false;
      ((p)localObject).a(4);
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onResume()"));
  }
  
  public void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    mSavedStateRegistryController.b(paramBundle);
    Parcelable localParcelable = mChildFragmentManager.l();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  public void performStart()
  {
    mChildFragmentManager.j();
    mChildFragmentManager.d(true);
    mState = 3;
    mCalled = false;
    onStart();
    if (mCalled)
    {
      mLifecycleRegistry.a(g.a.ON_START);
      if (mView != null)
      {
        l0 locall0 = mViewLifecycleOwner;
        localObject = g.a.ON_START;
        x.a((g.a)localObject);
      }
      Object localObject = mChildFragmentManager;
      u = false;
      v = false;
      ((p)localObject).a(3);
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onStart()"));
  }
  
  public void performStop()
  {
    Object localObject = mChildFragmentManager;
    v = true;
    ((p)localObject).a(2);
    if (mView != null)
    {
      l0 locall0 = mViewLifecycleOwner;
      localObject = g.a.ON_STOP;
      x.a((g.a)localObject);
    }
    mLifecycleRegistry.a(g.a.ON_STOP);
    mState = 2;
    mCalled = false;
    onStop();
    if (mCalled) {
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onStop()"));
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfop = true;
  }
  
  public final void postponeEnterTransition(long paramLong, TimeUnit paramTimeUnit)
  {
    ensureAnimationInfop = true;
    Object localObject = mFragmentManager;
    if (localObject != null) {
      localObject = n.z;
    } else {
      localObject = new Handler(Looper.getMainLooper());
    }
    ((Handler)localObject).removeCallbacks(mPostponedDurationRunnable);
    ((Handler)localObject).postDelayed(mPostponedDurationRunnable, paramTimeUnit.toMillis(paramLong));
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    d.m.a.m localm = mHost;
    if (localm != null)
    {
      B.requestPermissionsFromFragment(this, paramArrayOfString, paramInt);
      return;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to Activity"));
  }
  
  public final d.m.a.c requireActivity()
  {
    d.m.a.c localc = getActivity();
    if (localc != null) {
      return localc;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to an activity."));
  }
  
  public final Bundle requireArguments()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      return localBundle;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " does not have any arguments."));
  }
  
  public final Context requireContext()
  {
    Context localContext = getContext();
    if (localContext != null) {
      return localContext;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to a context."));
  }
  
  @Deprecated
  public final p requireFragmentManager()
  {
    return getParentFragmentManager();
  }
  
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject != null) {
      return localObject;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to a host."));
  }
  
  public final Fragment requireParentFragment()
  {
    Object localObject = getParentFragment();
    if (localObject == null)
    {
      if (getContext() == null) {
        throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " is not attached to any Fragment or host"));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" is not a child Fragment, it is directly attached to ");
      ((StringBuilder)localObject).append(getContext());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return (Fragment)localObject;
  }
  
  public final View requireView()
  {
    View localView = getView();
    if (localView != null) {
      return localView;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
  }
  
  public void restoreChildFragmentState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        mChildFragmentManager.a(paramBundle);
        mChildFragmentManager.b();
      }
    }
  }
  
  public final void restoreViewState(Bundle paramBundle)
  {
    Object localObject = mSavedViewState;
    if (localObject != null)
    {
      mView.restoreHierarchyState((SparseArray)localObject);
      mSavedViewState = null;
    }
    mCalled = false;
    onViewStateRestored(paramBundle);
    if (mCalled)
    {
      if (mView != null)
      {
        paramBundle = mViewLifecycleOwner;
        localObject = g.a.ON_CREATE;
        x.a((g.a)localObject);
      }
      return;
    }
    throw new m0(e.a.a.a.a.a("Fragment ", this, " did not call through to super.onViewStateRestored()"));
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfom = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfol = Boolean.valueOf(paramBoolean);
  }
  
  public void setAnimatingAway(View paramView)
  {
    ensureAnimationInfoa = paramView;
  }
  
  public void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfob = paramAnimator;
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if ((mFragmentManager != null) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already added and state has been saved");
    }
    mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(k paramk)
  {
    ensureAnimationInfo();
  }
  
  public void setEnterTransition(Object paramObject)
  {
    ensureAnimationInfof = paramObject;
  }
  
  public void setExitSharedElementCallback(k paramk)
  {
    ensureAnimationInfo();
  }
  
  public void setExitTransition(Object paramObject)
  {
    ensureAnimationInfoh = paramObject;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (mHasMenu != paramBoolean)
    {
      mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        mHost).B.supportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfor = paramBoolean;
  }
  
  public void setInitialSavedState(Fragment.g paramg)
  {
    if (mFragmentManager == null)
    {
      if (paramg != null)
      {
        paramg = x;
        if (paramg != null) {}
      }
      else
      {
        paramg = null;
      }
      mSavedFragmentState = paramg;
      return;
    }
    throw new IllegalStateException("Fragment already added");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (mMenuVisible != paramBoolean)
    {
      mMenuVisible = paramBoolean;
      if ((mHasMenu) && (isAdded()) && (!isHidden())) {
        mHost).B.supportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setNextAnim(int paramInt)
  {
    if ((mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfod = paramInt;
  }
  
  public void setNextTransition(int paramInt)
  {
    if ((mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo();
    mAnimationInfo.e = paramInt;
  }
  
  public void setOnStartEnterTransitionListener(Fragment.f paramf)
  {
    ensureAnimationInfo();
    Object localObject = mAnimationInfo.q;
    if (paramf == localObject) {
      return;
    }
    if ((paramf != null) && (localObject != null))
    {
      paramf = new StringBuilder();
      paramf.append("Trying to set a replacement startPostponedEnterTransition on ");
      paramf.append(this);
      throw new IllegalStateException(paramf.toString());
    }
    localObject = mAnimationInfo;
    if (p) {
      q = paramf;
    }
    if (paramf != null)
    {
      paramf = (p.g)paramf;
      c += 1;
    }
  }
  
  public void setReenterTransition(Object paramObject)
  {
    ensureAnimationInfoi = paramObject;
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    mRetainInstance = paramBoolean;
    p localp = mFragmentManager;
    if (localp != null)
    {
      if (paramBoolean) {
        localp.b(this);
      } else {
        localp.p(this);
      }
    }
    else {
      mRetainInstanceChangedWhileDetached = true;
    }
  }
  
  public void setReturnTransition(Object paramObject)
  {
    ensureAnimationInfog = paramObject;
  }
  
  public void setSharedElementEnterTransition(Object paramObject)
  {
    ensureAnimationInfoj = paramObject;
  }
  
  public void setSharedElementReturnTransition(Object paramObject)
  {
    ensureAnimationInfok = paramObject;
  }
  
  public void setStateAfterAnimating(int paramInt)
  {
    ensureAnimationInfoc = paramInt;
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    p localp = mFragmentManager;
    if (paramFragment != null) {
      localObject = mFragmentManager;
    } else {
      localObject = null;
    }
    if ((localp != null) && (localObject != null) && (localp != localObject)) {
      throw new IllegalArgumentException(e.a.a.a.a.a("Fragment ", paramFragment, " must share the same FragmentManager to be set as a target fragment"));
    }
    Object localObject = paramFragment;
    while (localObject != null) {
      if (localObject != this)
      {
        localObject = ((Fragment)localObject).getTargetFragment();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" as the target of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" would create a target cycle");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    if (paramFragment == null)
    {
      mTargetWho = null;
      mTarget = null;
    }
    else if ((mFragmentManager != null) && (mFragmentManager != null))
    {
      mTargetWho = mWho;
      mTarget = null;
    }
    else
    {
      mTargetWho = null;
      mTarget = paramFragment;
    }
    mTargetRequestCode = paramInt;
  }
  
  @Deprecated
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!mUserVisibleHint) && (paramBoolean) && (mState < 3) && (mFragmentManager != null) && (isAdded()) && (mIsCreated)) {
      mFragmentManager.n(this);
    }
    mUserVisibleHint = paramBoolean;
    boolean bool;
    if ((mState < 3) && (!paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    mDeferStart = bool;
    if (mSavedFragmentState != null) {
      mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    d.m.a.m localm = mHost;
    if (localm != null) {
      return d.i.a.a.a(B, paramString);
    }
    return false;
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent, Bundle paramBundle)
  {
    d.m.a.m localm = mHost;
    if (localm != null)
    {
      B.startActivityFromFragment(this, paramIntent, -1, paramBundle);
      return;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to Activity"));
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    d.m.a.m localm = mHost;
    if (localm != null)
    {
      B.startActivityFromFragment(this, paramIntent, paramInt, paramBundle);
      return;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to Activity"));
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    d.m.a.m localm = mHost;
    if (localm != null)
    {
      B.startIntentSenderFromFragment(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", this, " not attached to Activity"));
  }
  
  public void startPostponedEnterTransition()
  {
    p localp = mFragmentManager;
    if ((localp != null) && (n != null))
    {
      if (Looper.myLooper() != mFragmentManager.n.z.getLooper()) {
        mFragmentManager.n.z.postAtFrontOfQueue(new Fragment.b(this));
      } else {
        callStartTransitionListener();
      }
    }
    else {
      ensureAnimationInfop = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("}");
    localStringBuilder.append(" (");
    localStringBuilder.append(mWho);
    localStringBuilder.append(")");
    if (mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(mFragmentId));
    }
    if (mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
}

/* Location:
 * Qualified Name:     base.androidx.fragment.app.Fragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */