package d.m.a;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.Fragment;
import e.a.a.a.a;

public class v
{
  public final o a;
  public final Fragment b;
  public int c = -1;
  
  public v(o paramo, Fragment paramFragment)
  {
    a = paramo;
    b = paramFragment;
  }
  
  public v(o paramo, Fragment paramFragment, u paramu)
  {
    a = paramo;
    b = paramFragment;
    mSavedViewState = null;
    mBackStackNesting = 0;
    mInLayout = false;
    mAdded = false;
    paramo = mTarget;
    if (paramo != null) {
      paramo = mWho;
    } else {
      paramo = null;
    }
    mTargetWho = paramo;
    paramo = b;
    mTarget = null;
    paramFragment = J;
    if (paramFragment != null) {
      mSavedFragmentState = paramFragment;
    } else {
      mSavedFragmentState = new Bundle();
    }
  }
  
  public v(o paramo, ClassLoader paramClassLoader, l paraml, u paramu)
  {
    a = paramo;
    b = paraml.a(paramClassLoader, x);
    paramo = G;
    if (paramo != null) {
      paramo.setClassLoader(paramClassLoader);
    }
    b.setArguments(G);
    paramo = b;
    mWho = y;
    mFromLayout = z;
    mRestored = true;
    mFragmentId = A;
    mContainerId = B;
    mTag = C;
    mRetainInstance = D;
    mRemoving = E;
    mDetached = F;
    mHidden = H;
    mMaxState = d.o.g.b.values()[I];
    paramo = J;
    if (paramo != null) {
      b.mSavedFragmentState = paramo;
    } else {
      b.mSavedFragmentState = new Bundle();
    }
    if (p.c(2))
    {
      paramo = a.a("Instantiated fragment ");
      paramo.append(b);
      Log.v("FragmentManager", paramo.toString());
    }
  }
  
  public final Bundle a()
  {
    Object localObject1 = new Bundle();
    b.performSaveInstanceState((Bundle)localObject1);
    a.d(b, (Bundle)localObject1, false);
    Object localObject2 = localObject1;
    if (((Bundle)localObject1).isEmpty()) {
      localObject2 = null;
    }
    if (b.mView != null) {
      b();
    }
    localObject1 = localObject2;
    if (b.mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", b.mSavedViewState);
    }
    localObject2 = localObject1;
    if (!b.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", b.mUserVisibleHint);
    }
    return (Bundle)localObject2;
  }
  
  public void a(ClassLoader paramClassLoader)
  {
    Object localObject = b.mSavedFragmentState;
    if (localObject == null) {
      return;
    }
    ((Bundle)localObject).setClassLoader(paramClassLoader);
    paramClassLoader = b;
    mSavedViewState = mSavedFragmentState.getSparseParcelableArray("android:view_state");
    paramClassLoader = b;
    mTargetWho = mSavedFragmentState.getString("android:target_state");
    paramClassLoader = b;
    if (mTargetWho != null) {
      mTargetRequestCode = mSavedFragmentState.getInt("android:target_req_state", 0);
    }
    paramClassLoader = b;
    localObject = mSavedUserVisibleHint;
    if (localObject != null)
    {
      mUserVisibleHint = ((Boolean)localObject).booleanValue();
      b.mSavedUserVisibleHint = null;
    }
    else
    {
      mUserVisibleHint = mSavedFragmentState.getBoolean("android:user_visible_hint", true);
    }
    paramClassLoader = b;
    if (!mUserVisibleHint) {
      mDeferStart = true;
    }
  }
  
  public void b()
  {
    if (b.mView == null) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    b.mView.saveHierarchyState(localSparseArray);
    if (localSparseArray.size() > 0) {
      b.mSavedViewState = localSparseArray;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */