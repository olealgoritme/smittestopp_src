package d.m.a;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.R.id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.f;
import d.b.a.r;
import d.o.a0;
import d.o.b0;
import d.o.d0;
import d.o.e0;
import d.o.g.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class p
{
  public ArrayList<Fragment> A;
  public ArrayList<p.g> B;
  public t C;
  public Runnable D = new p.d(this);
  public final ArrayList<p.e> a = new ArrayList();
  public boolean b;
  public final x c = new x();
  public ArrayList<a> d;
  public ArrayList<Fragment> e;
  public final n f = new n(this);
  public OnBackPressedDispatcher g;
  public final d.a.b h = new p.a(this, false);
  public final AtomicInteger i = new AtomicInteger();
  public ConcurrentHashMap<Fragment, HashSet<d.i.e.a>> j = new ConcurrentHashMap();
  public final f0.a k = new p.b(this);
  public final o l = new o(this);
  public int m = -1;
  public m<?> n;
  public i o;
  public Fragment p;
  public Fragment q;
  public l r = null;
  public l s = new p.c(this);
  public boolean t;
  public boolean u;
  public boolean v;
  public boolean w;
  public boolean x;
  public ArrayList<a> y;
  public ArrayList<Boolean> z;
  
  public static boolean c(int paramInt)
  {
    boolean bool;
    if (Log.isLoggable("FragmentManager", paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Fragment a(String paramString)
  {
    return c.b(paramString);
  }
  
  public final void a()
  {
    b = false;
    z.clear();
    y.clear();
  }
  
  public final void a(int paramInt)
  {
    try
    {
      b = true;
      c.a(paramInt);
      a(paramInt, false);
      b = false;
      d(true);
      return;
    }
    finally
    {
      b = false;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((n == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == m)) {
      return;
    }
    m = paramInt;
    Object localObject = c.c().iterator();
    while (((Iterator)localObject).hasNext()) {
      m((Fragment)((Iterator)localObject).next());
    }
    Iterator localIterator = ((ArrayList)c.b()).iterator();
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      if ((localObject != null) && (!mIsNewlyAdded)) {
        m((Fragment)localObject);
      }
    }
    n();
    if (t)
    {
      localObject = n;
      if ((localObject != null) && (m == 4))
      {
        B.supportInvalidateOptionsMenu();
        t = false;
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return;
    }
    s locals = (s)paramParcelable;
    if (x == null) {
      return;
    }
    c.b.clear();
    Object localObject1 = x.iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      paramParcelable = (u)((Iterator)localObject1).next();
      if (paramParcelable != null)
      {
        localObject2 = C;
        localObject3 = y;
        localObject2 = (Fragment)c.get(localObject3);
        if (localObject2 != null)
        {
          if (c(2))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("restoreSaveState: re-attaching retained ");
            ((StringBuilder)localObject3).append(localObject2);
            Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
          }
          paramParcelable = new v(l, (Fragment)localObject2, paramParcelable);
        }
        else
        {
          paramParcelable = new v(l, n.y.getClassLoader(), h(), paramParcelable);
        }
        localObject2 = b;
        mFragmentManager = this;
        if (c(2))
        {
          localObject3 = e.a.a.a.a.a("restoreSaveState: active (");
          ((StringBuilder)localObject3).append(mWho);
          ((StringBuilder)localObject3).append("): ");
          ((StringBuilder)localObject3).append(localObject2);
          Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
        }
        paramParcelable.a(n.y.getClassLoader());
        c.b.put(b.mWho, paramParcelable);
        c = m;
      }
    }
    localObject1 = C.c.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramParcelable = (Fragment)((Iterator)localObject1).next();
      if (!c.a(mWho))
      {
        if (c(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Discarding retained Fragment ");
          ((StringBuilder)localObject2).append(paramParcelable);
          ((StringBuilder)localObject2).append(" that was not found in the set of active Fragments ");
          ((StringBuilder)localObject2).append(x);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        a(paramParcelable, 1);
        mRemoving = true;
        a(paramParcelable, -1);
      }
    }
    paramParcelable = c;
    localObject1 = y;
    a.clear();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        localObject3 = paramParcelable.b((String)localObject2);
        if (localObject3 != null)
        {
          if (c(2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("restoreSaveState: added (");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("): ");
            ((StringBuilder)localObject1).append(localObject3);
            Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          }
          paramParcelable.a((Fragment)localObject3);
        }
        else
        {
          throw new IllegalStateException(e.a.a.a.a.a("No instantiated fragment for (", (String)localObject2, ")"));
        }
      }
    }
    if (z != null)
    {
      d = new ArrayList(z.length);
      for (int i1 = 0;; i1++)
      {
        paramParcelable = z;
        if (i1 >= paramParcelable.length) {
          break label1139;
        }
        localObject1 = paramParcelable[i1];
        if (localObject1 == null) {
          break;
        }
        paramParcelable = new a(this);
        int i2 = 0;
        int i3 = 0;
        while (i2 < x.length)
        {
          localObject2 = new y.a();
          localObject3 = x;
          int i4 = i2 + 1;
          a = localObject3[i2];
          if (c(2))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Instantiate ");
            ((StringBuilder)localObject3).append(paramParcelable);
            ((StringBuilder)localObject3).append(" op #");
            ((StringBuilder)localObject3).append(i3);
            ((StringBuilder)localObject3).append(" base fragment #");
            ((StringBuilder)localObject3).append(x[i4]);
            Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
          }
          localObject3 = (String)y.get(i3);
          if (localObject3 != null) {
            b = c.b((String)localObject3);
          } else {
            b = null;
          }
          g = g.b.values()[z[i3]];
          h = g.b.values()[A[i3]];
          localObject3 = x;
          i2 = i4 + 1;
          i4 = localObject3[i4];
          c = i4;
          int i5 = i2 + 1;
          int i6 = localObject3[i2];
          d = i6;
          i2 = i5 + 1;
          i5 = localObject3[i5];
          e = i5;
          int i7 = localObject3[i2];
          f = i7;
          b = i4;
          c = i6;
          d = i5;
          e = i7;
          paramParcelable.a((y.a)localObject2);
          i3++;
          i2++;
        }
        f = B;
        i = C;
        t = D;
        g = true;
        j = E;
        k = F;
        l = G;
        m = H;
        n = I;
        o = J;
        p = K;
        paramParcelable.a(1);
        if (c(2))
        {
          localObject1 = e.a.a.a.a.a("restoreAllState: back stack #", i1, " (index ");
          ((StringBuilder)localObject1).append(t);
          ((StringBuilder)localObject1).append("): ");
          ((StringBuilder)localObject1).append(paramParcelable);
          Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          localObject1 = new PrintWriter(new d.i.h.a("FragmentManager"));
          paramParcelable.a("  ", (PrintWriter)localObject1, false);
          ((PrintWriter)localObject1).close();
        }
        d.add(paramParcelable);
      }
      throw null;
    }
    d = null;
    label1139:
    i.set(A);
    paramParcelable = B;
    if (paramParcelable != null)
    {
      paramParcelable = c.b(paramParcelable);
      q = paramParcelable;
      g(paramParcelable);
    }
  }
  
  public void a(Menu paramMenu)
  {
    if (m < 1) {
      return;
    }
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  public void a(Fragment paramFragment)
  {
    if (c(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    l(paramFragment);
    if (!mDetached)
    {
      c.a(paramFragment);
      mRemoving = false;
      if (mView == null) {
        mHiddenChanged = false;
      }
      if (j(paramFragment)) {
        t = true;
      }
    }
  }
  
  public void a(Fragment paramFragment, int paramInt)
  {
    Object localObject1 = c;
    Object localObject2 = mWho;
    localObject2 = (v)b.get(localObject2);
    int i1 = 1;
    boolean bool = true;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new v(l, paramFragment);
      c = 1;
    }
    int i2 = c;
    localObject2 = b;
    int i3 = i2;
    if (mFromLayout) {
      if (mInLayout) {
        i3 = Math.max(i2, 1);
      } else if (i2 < 2) {
        i3 = Math.min(i2, mState);
      } else {
        i3 = Math.min(i2, 1);
      }
    }
    i2 = i3;
    if (!b.mAdded) {
      i2 = Math.min(i3, 1);
    }
    localObject2 = b;
    i3 = i2;
    if (mRemoving) {
      if (((Fragment)localObject2).isInBackStack()) {
        i3 = Math.min(i2, 1);
      } else {
        i3 = Math.min(i2, -1);
      }
    }
    localObject2 = b;
    i2 = i3;
    if (mDeferStart)
    {
      i2 = i3;
      if (mState < 3) {
        i2 = Math.min(i3, 2);
      }
    }
    int i4 = b.mMaxState.ordinal();
    if (i4 != 2)
    {
      if (i4 != 3)
      {
        i3 = i2;
        if (i4 != 4) {
          i3 = Math.min(i2, -1);
        }
      }
      else
      {
        i3 = Math.min(i2, 3);
      }
    }
    else {
      i3 = Math.min(i2, 1);
    }
    i2 = Math.min(paramInt, i3);
    i3 = mState;
    Object localObject3 = null;
    Object localObject4;
    if (i3 <= i2)
    {
      if ((i3 < i2) && (!j.isEmpty())) {
        d(paramFragment);
      }
      paramInt = mState;
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt == 1) {
            break label900;
          }
          if (paramInt == 2) {
            break label1695;
          }
          if (paramInt == 3) {
            break label1742;
          }
          paramInt = i2;
          break label3260;
        }
      }
      else if (i2 > -1)
      {
        if (c(3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("moveto ATTACHED: ");
          ((StringBuilder)localObject2).append(paramFragment);
          Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        localObject2 = mTarget;
        if (localObject2 != null) {
          if (((Fragment)localObject2).equals(a(mWho)))
          {
            localObject2 = mTarget;
            if (mState < 1) {
              a((Fragment)localObject2, 1);
            }
            mTargetWho = mTarget.mWho;
            mTarget = null;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Fragment ");
            ((StringBuilder)localObject2).append(paramFragment);
            ((StringBuilder)localObject2).append(" declared target fragment ");
            ((StringBuilder)localObject2).append(mTarget);
            ((StringBuilder)localObject2).append(" that does not belong to this FragmentManager!");
            throw new IllegalStateException(((StringBuilder)localObject2).toString());
          }
        }
        localObject2 = mTargetWho;
        if (localObject2 != null)
        {
          localObject2 = c.b((String)localObject2);
          if (localObject2 != null)
          {
            if (mState < 1) {
              a((Fragment)localObject2, 1);
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Fragment ");
            ((StringBuilder)localObject2).append(paramFragment);
            ((StringBuilder)localObject2).append(" declared target fragment ");
            throw new IllegalStateException(e.a.a.a.a.a((StringBuilder)localObject2, mTargetWho, " that does not belong to this FragmentManager!"));
          }
        }
        localObject2 = n;
        localObject4 = p;
        localObject3 = b;
        mHost = ((m)localObject2);
        mParentFragment = ((Fragment)localObject4);
        mFragmentManager = this;
        a.b((Fragment)localObject3, y, false);
        b.performAttach();
        localObject3 = b;
        localObject4 = mParentFragment;
        if (localObject4 == null) {
          B.onAttachFragment((Fragment)localObject3);
        } else {
          ((Fragment)localObject4).onAttachFragment((Fragment)localObject3);
        }
        a.a(b, y, false);
      }
      if (i2 > 0)
      {
        if (c(3)) {
          e.a.a.a.a.a(e.a.a.a.a.a("moveto CREATED: "), b, "FragmentManager");
        }
        localObject2 = b;
        if (!mIsCreated)
        {
          a.c((Fragment)localObject2, mSavedFragmentState, false);
          localObject2 = b;
          ((Fragment)localObject2).performCreate(mSavedFragmentState);
          localObject3 = a;
          localObject2 = b;
          ((o)localObject3).b((Fragment)localObject2, mSavedFragmentState, false);
        }
        else
        {
          ((Fragment)localObject2).restoreChildFragmentState(mSavedFragmentState);
          b.mState = 1;
        }
      }
      label900:
      if (i2 > -1)
      {
        localObject2 = b;
        if ((mFromLayout) && (mInLayout) && (!mPerformedCreateView))
        {
          if (c(3)) {
            e.a.a.a.a.a(e.a.a.a.a.a("moveto CREATE_VIEW: "), b, "FragmentManager");
          }
          localObject2 = b;
          ((Fragment)localObject2).performCreateView(((Fragment)localObject2).performGetLayoutInflater(mSavedFragmentState), null, b.mSavedFragmentState);
          localObject2 = b.mView;
          if (localObject2 != null)
          {
            ((View)localObject2).setSaveFromParentEnabled(false);
            localObject2 = b;
            mView.setTag(R.id.fragment_container_view_tag, localObject2);
            localObject2 = b;
            if (mHidden) {
              mView.setVisibility(8);
            }
            localObject2 = b;
            ((Fragment)localObject2).onViewCreated(mView, mSavedFragmentState);
            localObject2 = a;
            localObject3 = b;
            ((o)localObject2).a((Fragment)localObject3, mView, mSavedFragmentState, false);
          }
        }
      }
      if (i2 > 1)
      {
        localObject4 = o;
        if (!b.mFromLayout)
        {
          if (c(3)) {
            e.a.a.a.a.a(e.a.a.a.a.a("moveto CREATE_VIEW: "), b, "FragmentManager");
          }
          localObject3 = b;
          localObject2 = mContainer;
          if (localObject2 == null)
          {
            paramInt = mContainerId;
            if (paramInt != 0)
            {
              if (paramInt != -1)
              {
                localObject3 = (ViewGroup)((i)localObject4).a(paramInt);
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = b;
                  if (mRestored)
                  {
                    localObject2 = localObject3;
                  }
                  else
                  {
                    try
                    {
                      paramFragment = ((Fragment)localObject2).getResources().getResourceName(b.mContainerId);
                    }
                    catch (Resources.NotFoundException paramFragment)
                    {
                      paramFragment = "unknown";
                    }
                    localObject2 = e.a.a.a.a.a("No view found for id 0x");
                    ((StringBuilder)localObject2).append(Integer.toHexString(b.mContainerId));
                    ((StringBuilder)localObject2).append(" (");
                    ((StringBuilder)localObject2).append(paramFragment);
                    ((StringBuilder)localObject2).append(") for fragment ");
                    ((StringBuilder)localObject2).append(b);
                    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
                  }
                }
              }
              else
              {
                paramFragment = e.a.a.a.a.a("Cannot create fragment ");
                paramFragment.append(b);
                paramFragment.append(" for a container view with no id");
                throw new IllegalArgumentException(paramFragment.toString());
              }
            }
            else {
              localObject2 = null;
            }
          }
          localObject3 = b;
          mContainer = ((ViewGroup)localObject2);
          ((Fragment)localObject3).performCreateView(((Fragment)localObject3).performGetLayoutInflater(mSavedFragmentState), (ViewGroup)localObject2, b.mSavedFragmentState);
          localObject3 = b.mView;
          if (localObject3 != null)
          {
            ((View)localObject3).setSaveFromParentEnabled(false);
            localObject3 = b;
            mView.setTag(R.id.fragment_container_view_tag, localObject3);
            if (localObject2 != null) {
              ((ViewGroup)localObject2).addView(b.mView);
            }
            localObject2 = b;
            if (mHidden) {
              mView.setVisibility(8);
            }
            d.i.i.n.y(b.mView);
            localObject2 = b;
            ((Fragment)localObject2).onViewCreated(mView, mSavedFragmentState);
            localObject2 = a;
            localObject3 = b;
            ((o)localObject2).a((Fragment)localObject3, mView, mSavedFragmentState, false);
            localObject2 = b;
            if ((mView.getVisibility() != 0) || (b.mContainer == null)) {
              bool = false;
            }
            mIsNewlyAdded = bool;
          }
        }
        if (c(3)) {
          e.a.a.a.a.a(e.a.a.a.a.a("moveto ACTIVITY_CREATED: "), b, "FragmentManager");
        }
        localObject2 = b;
        ((Fragment)localObject2).performActivityCreated(mSavedFragmentState);
        localObject2 = a;
        localObject3 = b;
        ((o)localObject2).a((Fragment)localObject3, mSavedFragmentState, false);
        if (c(3)) {
          e.a.a.a.a.a(e.a.a.a.a.a("moveto RESTORE_VIEW_STATE: "), b, "FragmentManager");
        }
        localObject2 = b;
        if (mView != null) {
          ((Fragment)localObject2).restoreViewState(mSavedFragmentState);
        }
        b.mSavedFragmentState = null;
      }
      label1695:
      if (i2 > 2)
      {
        if (c(3)) {
          e.a.a.a.a.a(e.a.a.a.a.a("moveto STARTED: "), b, "FragmentManager");
        }
        b.performStart();
        a.e(b, false);
      }
      label1742:
      paramInt = i2;
      if (i2 > 3)
      {
        if (c(3)) {
          e.a.a.a.a.a(e.a.a.a.a.a("moveto RESUMED: "), b, "FragmentManager");
        }
        b.performResume();
        a.d(b, false);
        localObject2 = b;
        mSavedFragmentState = null;
        mSavedViewState = null;
        paramInt = i2;
      }
    }
    else
    {
      paramInt = i2;
      if (i3 > i2)
      {
        if (i3 != 0)
        {
          Object localObject5;
          Object localObject6;
          if (i3 != 1)
          {
            if (i3 != 2)
            {
              if (i3 != 3)
              {
                if (i3 != 4)
                {
                  paramInt = i2;
                  break label3260;
                }
                if (i2 < 4)
                {
                  if (c(3)) {
                    e.a.a.a.a.a(e.a.a.a.a.a("movefrom RESUMED: "), b, "FragmentManager");
                  }
                  b.performPause();
                  a.c(b, false);
                }
              }
              if (i2 < 3)
              {
                if (c(3)) {
                  e.a.a.a.a.a(e.a.a.a.a.a("movefrom STARTED: "), b, "FragmentManager");
                }
                b.performStop();
                a.f(b, false);
              }
            }
            if (i2 < 2)
            {
              if (c(3))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("movefrom ACTIVITY_CREATED: ");
                ((StringBuilder)localObject2).append(paramFragment);
                Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
              }
              if ((mView != null) && ((n).B.isFinishing() ^ true)) && (mSavedViewState == null)) {
                ((v)localObject1).b();
              }
              localObject2 = mView;
              if (localObject2 != null)
              {
                localObject4 = mContainer;
                if (localObject4 != null)
                {
                  ((ViewGroup)localObject4).endViewTransition((View)localObject2);
                  mView.clearAnimation();
                  if (!paramFragment.isRemovingParent())
                  {
                    localObject2 = localObject3;
                    if (m > -1)
                    {
                      localObject2 = localObject3;
                      if (!w)
                      {
                        localObject2 = localObject3;
                        if (mView.getVisibility() == 0)
                        {
                          localObject2 = localObject3;
                          if (mPostponedAlpha >= 0.0F) {
                            localObject2 = r.a(n.y, o, paramFragment, false);
                          }
                        }
                      }
                    }
                    mPostponedAlpha = 0.0F;
                    localObject5 = mContainer;
                    localObject6 = mView;
                    if (localObject2 != null)
                    {
                      paramFragment.setStateAfterAnimating(i2);
                      Object localObject7 = k;
                      View localView = mView;
                      localObject4 = mContainer;
                      ((ViewGroup)localObject4).startViewTransition(localView);
                      localObject3 = new d.i.e.a();
                      ((d.i.e.a)localObject3).a(new d(paramFragment));
                      localObject7 = (p.b)localObject7;
                      ((p.b)localObject7).b(paramFragment, (d.i.e.a)localObject3);
                      if (a != null)
                      {
                        localObject2 = new h(a, (ViewGroup)localObject4, localView);
                        paramFragment.setAnimatingAway(mView);
                        ((Animation)localObject2).setAnimationListener(new e((ViewGroup)localObject4, paramFragment, (f0.a)localObject7, (d.i.e.a)localObject3));
                        mView.startAnimation((Animation)localObject2);
                      }
                      else
                      {
                        localObject2 = b;
                        paramFragment.setAnimator((Animator)localObject2);
                        ((Animator)localObject2).addListener(new f((ViewGroup)localObject4, localView, paramFragment, (f0.a)localObject7, (d.i.e.a)localObject3));
                        ((Animator)localObject2).setTarget(mView);
                        ((Animator)localObject2).start();
                      }
                    }
                    ((ViewGroup)localObject5).removeView((View)localObject6);
                    if (localObject5 != mContainer) {
                      return;
                    }
                  }
                }
              }
              if (j.get(paramFragment) == null) {
                e(paramFragment);
              } else {
                paramFragment.setStateAfterAnimating(i2);
              }
              paramInt = 0;
              break label2406;
            }
          }
          paramInt = 0;
          label2406:
          i4 = paramInt;
          i3 = i2;
          if (i2 < 1)
          {
            if ((mRemoving) && (!paramFragment.isInBackStack())) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            if ((i3 == 0) && (!C.a(paramFragment)))
            {
              localObject2 = mTargetWho;
              if (localObject2 != null)
              {
                localObject2 = c.b((String)localObject2);
                if ((localObject2 != null) && (((Fragment)localObject2).getRetainInstance())) {
                  mTarget = ((Fragment)localObject2);
                }
              }
            }
            else
            {
              localObject2 = b;
              if (c.a(mWho))
              {
                if (c(2))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("Removed fragment from active set ");
                  ((StringBuilder)localObject3).append(localObject2);
                  Log.v("FragmentManager", ((StringBuilder)localObject3).toString());
                }
                localObject3 = c;
                if (localObject3 == null) {
                  break label3090;
                }
                localObject4 = b;
                localObject6 = b.values().iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject5 = (v)((Iterator)localObject6).next();
                  if (localObject5 != null)
                  {
                    localObject5 = b;
                    if (mWho.equals(mTargetWho))
                    {
                      mTarget = ((Fragment)localObject4);
                      mTargetWho = null;
                    }
                  }
                }
                b.put(mWho, null);
                localObject6 = mTargetWho;
                if (localObject6 != null) {
                  mTarget = ((x)localObject3).b((String)localObject6);
                }
                p((Fragment)localObject2);
              }
            }
            if (j.get(paramFragment) != null)
            {
              paramFragment.setStateAfterAnimating(i2);
              i3 = 1;
              i4 = paramInt;
            }
            else
            {
              localObject3 = n;
              localObject2 = C;
              if (c(3)) {
                e.a.a.a.a.a(e.a.a.a.a.a("movefrom CREATED: "), b, "FragmentManager");
              }
              localObject4 = b;
              if ((mRemoving) && (!((Fragment)localObject4).isInBackStack())) {
                i3 = 1;
              } else {
                i3 = 0;
              }
              if ((i3 == 0) && (!((t)localObject2).a(b))) {
                i4 = 0;
              } else {
                i4 = 1;
              }
              if (i4 != 0)
              {
                if ((localObject3 instanceof d.o.f0))
                {
                  bool = g;
                }
                else
                {
                  localObject3 = y;
                  if ((localObject3 instanceof Activity)) {
                    bool = ((Activity)localObject3).isChangingConfigurations() ^ true;
                  } else {
                    bool = true;
                  }
                }
                if ((i3 != 0) || (bool))
                {
                  localObject3 = b;
                  if (localObject2 == null) {
                    break label3070;
                  }
                  if (c(3))
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("Clearing non-config state for ");
                    ((StringBuilder)localObject4).append(localObject3);
                    Log.d("FragmentManager", ((StringBuilder)localObject4).toString());
                  }
                  localObject4 = (t)d.get(mWho);
                  if (localObject4 != null)
                  {
                    ((t)localObject4).b();
                    d.remove(mWho);
                  }
                  localObject4 = (e0)e.get(mWho);
                  if (localObject4 != null)
                  {
                    ((e0)localObject4).a();
                    e.remove(mWho);
                  }
                }
                b.performDestroy();
                a.a(b, paramInt);
                i4 = paramInt;
                i3 = i2;
                break label3099;
                label3070:
                throw null;
              }
              else
              {
                b.mState = paramInt;
                i4 = paramInt;
                i3 = i2;
                break label3099;
                label3090:
                throw null;
              }
            }
          }
        }
        else
        {
          i4 = 0;
          i3 = i2;
        }
        label3099:
        paramInt = i3;
        if (i3 < 0)
        {
          localObject2 = C;
          if (c(3)) {
            e.a.a.a.a.a(e.a.a.a.a.a("movefrom ATTACHED: "), b, "FragmentManager");
          }
          b.performDetach();
          a.b(b, i4);
          localObject3 = b;
          mState = -1;
          mHost = null;
          mParentFragment = null;
          mFragmentManager = null;
          if ((mRemoving) && (!((Fragment)localObject3).isInBackStack())) {
            paramInt = i1;
          } else {
            paramInt = 0;
          }
          if (paramInt == 0)
          {
            paramInt = i3;
            if (!((t)localObject2).a(b)) {}
          }
          else
          {
            if (c(3)) {
              e.a.a.a.a.a(e.a.a.a.a.a("initState called for fragment: "), b, "FragmentManager");
            }
            b.initState();
            paramInt = i3;
          }
        }
      }
    }
    label3260:
    if (mState != paramInt)
    {
      if (c(3))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("moveToState: Fragment state for ");
        ((StringBuilder)localObject2).append(paramFragment);
        ((StringBuilder)localObject2).append(" not updated inline; expected state ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" found ");
        ((StringBuilder)localObject2).append(mState);
        Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
      }
      mState = paramInt;
    }
  }
  
  public void a(Fragment paramFragment, g.b paramb)
  {
    if ((paramFragment.equals(a(mWho))) && ((mHost == null) || (mFragmentManager == this)))
    {
      mMaxState = paramb;
      return;
    }
    paramb = new StringBuilder();
    paramb.append("Fragment ");
    paramb.append(paramFragment);
    paramb.append(" is not an active fragment of FragmentManager ");
    paramb.append(this);
    throw new IllegalArgumentException(paramb.toString());
  }
  
  public void a(Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = h(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof j))) {
      ((j)paramFragment).setDrawDisappearingViewsLast(paramBoolean ^ true);
    }
  }
  
  public final void a(d.f.c<Fragment> paramc)
  {
    int i1 = m;
    if (i1 < 1) {
      return;
    }
    i1 = Math.min(i1, 3);
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (mState < i1)
      {
        a(localFragment, i1);
        if ((mView != null) && (!mHidden) && (mIsNewlyAdded)) {
          paramc.add(localFragment);
        }
      }
    }
  }
  
  public void a(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      parama.b(paramBoolean3);
    } else {
      parama.c();
    }
    Object localObject1 = new ArrayList(1);
    Object localObject2 = new ArrayList(1);
    ((ArrayList)localObject1).add(parama);
    ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2) {
      f0.a(this, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true, k);
    }
    if (paramBoolean3) {
      a(m, true);
    }
    localObject1 = ((ArrayList)c.b()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (mView != null) && (mIsNewlyAdded) && (parama.b(mContainerId)))
      {
        float f1 = mPostponedAlpha;
        if (f1 > 0.0F) {
          mView.setAlpha(f1);
        }
        if (paramBoolean3)
        {
          mPostponedAlpha = 0.0F;
        }
        else
        {
          mPostponedAlpha = -1.0F;
          mIsNewlyAdded = false;
        }
      }
    }
  }
  
  public void a(m<?> paramm, i parami, Fragment paramFragment)
  {
    if (n == null)
    {
      n = paramm;
      o = parami;
      p = paramFragment;
      if (paramFragment != null) {
        o();
      }
      if ((paramm instanceof d.a.c))
      {
        parami = (d.a.c)paramm;
        g = parami.getOnBackPressedDispatcher();
        if (paramFragment != null) {
          parami = paramFragment;
        }
        g.a(parami, h);
      }
      Object localObject;
      if (paramFragment != null)
      {
        localObject = mFragmentManager.C;
        parami = (t)d.get(mWho);
        paramm = parami;
        if (parami == null)
        {
          paramm = new t(f);
          d.put(mWho, paramm);
        }
        C = paramm;
      }
      else if ((paramm instanceof d.o.f0))
      {
        paramFragment = ((d.o.f0)paramm).getViewModelStore();
        a0 locala0 = t.i;
        paramm = t.class.getCanonicalName();
        if (paramm != null)
        {
          localObject = e.a.a.a.a.b("androidx.lifecycle.ViewModelProvider.DefaultKey:", paramm);
          parami = (d.o.y)a.get(localObject);
          if (t.class.isInstance(parami))
          {
            paramm = parami;
            if ((locala0 instanceof d0))
            {
              ((d0)locala0).a(parami);
              paramm = parami;
            }
          }
          else
          {
            if ((locala0 instanceof b0)) {
              paramm = ((b0)locala0).a((String)localObject, t.class);
            } else {
              paramm = locala0.a(t.class);
            }
            parami = paramm;
            paramFragment = (d.o.y)a.put(localObject, parami);
            paramm = parami;
            if (paramFragment != null)
            {
              paramFragment.b();
              paramm = parami;
            }
          }
          C = ((t)paramm);
        }
        else
        {
          throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
      }
      else
      {
        C = new t(false);
      }
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  public void a(p.e parame, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (n == null)
      {
        if (w) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      if (i()) {
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
      }
    }
    synchronized (a)
    {
      if (n == null)
      {
        if (paramBoolean) {
          return;
        }
        parame = new java/lang/IllegalStateException;
        parame.<init>("Activity has been destroyed");
        throw parame;
      }
      a.add(parame);
      m();
      return;
    }
  }
  
  public final void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new d.i.h.a("FragmentManager"));
    m localm = n;
    if (localm != null) {
      try
      {
        B.dump("  ", null, localPrintWriter, new String[0]);
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
      }
    } else {
      try
      {
        a("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
    throw paramRuntimeException;
  }
  
  public void a(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str1 = e.a.a.a.a.b(paramString, "    ");
    x localx = c;
    if (localx != null)
    {
      String str2 = e.a.a.a.a.b(paramString, "    ");
      if (!b.isEmpty())
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments:");
        Iterator localIterator = b.values().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (v)localIterator.next();
          paramPrintWriter.print(paramString);
          if (localObject != null)
          {
            localObject = b;
            paramPrintWriter.println(localObject);
            ((Fragment)localObject).dump(str2, ???, paramPrintWriter, paramArrayOfString);
          }
          else
          {
            paramPrintWriter.println("null");
          }
        }
      }
      int i1 = a.size();
      int i2 = 0;
      int i3;
      if (i1 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (i3 = 0; i3 < i1; i3++)
        {
          ??? = (Fragment)a.get(i3);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i3);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
        }
      }
      ??? = e;
      if (??? != null)
      {
        i1 = ???.size();
        if (i1 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Fragments Created Menus:");
          for (i3 = 0; i3 < i1; i3++)
          {
            ??? = (Fragment)e.get(i3);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i3);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(???.toString());
          }
        }
      }
      ??? = d;
      if (??? != null)
      {
        i1 = ???.size();
        if (i1 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack:");
          for (i3 = 0; i3 < i1; i3++)
          {
            ??? = (a)d.get(i3);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i3);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(???.toString());
            ???.a(str1, paramPrintWriter, true);
          }
        }
      }
      paramPrintWriter.print(paramString);
      ??? = new StringBuilder();
      ???.append("Back Stack Index: ");
      ???.append(i.get());
      paramPrintWriter.println(???.toString());
      synchronized (a)
      {
        i1 = a.size();
        if (i1 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          for (i3 = i2; i3 < i1; i3++)
          {
            paramArrayOfString = (p.e)a.get(i3);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i3);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramArrayOfString);
          }
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("FragmentManager misc state:");
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mHost=");
        paramPrintWriter.println(n);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mContainer=");
        paramPrintWriter.println(o);
        if (p != null)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mParent=");
          paramPrintWriter.println(p);
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mCurState=");
        paramPrintWriter.print(m);
        paramPrintWriter.print(" mStateSaved=");
        paramPrintWriter.print(u);
        paramPrintWriter.print(" mStopped=");
        paramPrintWriter.print(v);
        paramPrintWriter.print(" mDestroyed=");
        paramPrintWriter.println(w);
        if (t)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mNeedMenuInvalidate=");
          paramPrintWriter.println(t);
        }
        return;
      }
    }
    throw null;
  }
  
  public final void a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    Object localObject = B;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((ArrayList)localObject).size();
    }
    int i2 = 0;
    for (int i3 = i1; i2 < i3; i3 = i1)
    {
      localObject = (p.g)B.get(i2);
      int i4;
      a locala;
      if ((paramArrayList != null) && (!a))
      {
        i1 = paramArrayList.indexOf(b);
        if ((i1 != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i1)).booleanValue()))
        {
          B.remove(i2);
          i4 = i2 - 1;
          i1 = i3 - 1;
          locala = b;
          r.a(locala, a, false, false);
          break label295;
        }
      }
      if (c == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        i1 = i3;
        i4 = i2;
        if (paramArrayList != null)
        {
          i1 = i3;
          i4 = i2;
          if (!b.a(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        B.remove(i2);
        i4 = i2 - 1;
        i1 = i3 - 1;
        if ((paramArrayList != null) && (!a))
        {
          i2 = paramArrayList.indexOf(b);
          if ((i2 != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i2)).booleanValue()))
          {
            locala = b;
            r.a(locala, a, false, false);
            break label295;
          }
        }
        ((p.g)localObject).a();
      }
      label295:
      i2 = i4 + 1;
    }
  }
  
  public final void a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool1 = getp;
    Object localObject1 = A;
    if (localObject1 == null) {
      A = new ArrayList();
    } else {
      ((ArrayList)localObject1).clear();
    }
    A.addAll(c.c());
    localObject1 = q;
    int i1 = paramInt1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (int i2 = 0; i1 < paramInt2; i2 = i3)
    {
      localObject2 = (a)paramArrayList.get(i1);
      if (!((Boolean)paramArrayList1.get(i1)).booleanValue())
      {
        localObject3 = A;
        label541:
        label552:
        for (i3 = 0; i3 < a.size(); i3++)
        {
          localObject4 = (y.a)a.get(i3);
          i4 = a;
          if (i4 != 1)
          {
            Fragment localFragment1;
            if (i4 != 2) {
              if ((i4 != 3) && (i4 != 6))
              {
                if (i4 == 7) {
                  break label541;
                }
                if (i4 != 8)
                {
                  localObject4 = localObject1;
                  i4 = i3;
                }
                else
                {
                  a.add(i3, new y.a(9, (Fragment)localObject1));
                  i4 = i3 + 1;
                  localObject4 = b;
                }
              }
              else
              {
                ((ArrayList)localObject3).remove(b);
                localFragment1 = b;
                localObject4 = localObject1;
                i4 = i3;
                if (localFragment1 == localObject1)
                {
                  a.add(i3, new y.a(9, localFragment1));
                  i4 = i3 + 1;
                }
              }
            }
            for (localObject4 = null;; localObject4 = localObject1)
            {
              localObject1 = localObject4;
              i3 = i4;
              break label552;
              localFragment1 = b;
              i4 = mContainerId;
              int i5 = ((ArrayList)localObject3).size() - 1;
              int i6 = 0;
              while (i5 >= 0)
              {
                Fragment localFragment2 = (Fragment)((ArrayList)localObject3).get(i5);
                if (mContainerId == i4) {
                  if (localFragment2 == localFragment1)
                  {
                    i6 = 1;
                  }
                  else
                  {
                    if (localFragment2 == localObject1)
                    {
                      a.add(i3, new y.a(9, localFragment2));
                      i3++;
                      localObject1 = null;
                    }
                    y.a locala = new y.a(3, localFragment2);
                    c = c;
                    e = e;
                    d = d;
                    f = f;
                    a.add(i3, locala);
                    ((ArrayList)localObject3).remove(localFragment2);
                    i3++;
                  }
                }
                i5--;
              }
              if (i6 == 0) {
                break;
              }
              a.remove(i3);
              i4 = i3 - 1;
            }
            a = 1;
            ((ArrayList)localObject3).add(localFragment1);
            continue;
          }
          ((ArrayList)localObject3).add(b);
        }
        localObject4 = localObject1;
      }
      else
      {
        localObject3 = A;
        for (i3 = a.size() - 1;; i3--)
        {
          localObject4 = localObject1;
          if (i3 < 0) {
            break;
          }
          localObject4 = (y.a)a.get(i3);
          i4 = a;
          if (i4 != 1)
          {
            if (i4 != 3) {}
            switch (i4)
            {
            default: 
              break;
            case 10: 
              h = g;
              break;
            case 9: 
              localObject1 = b;
              break;
            case 8: 
              localObject1 = null;
              break;
            case 6: 
              ((ArrayList)localObject3).add(b);
              break;
            }
          }
          else
          {
            ((ArrayList)localObject3).remove(b);
          }
        }
      }
      if ((i2 == 0) && (!g)) {
        i3 = 0;
      } else {
        i3 = 1;
      }
      i1++;
      localObject1 = localObject4;
    }
    A.clear();
    if (!bool1) {
      f0.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false, k);
    }
    boolean bool2;
    for (int i3 = paramInt1; i3 < paramInt2; i3++)
    {
      localObject1 = (a)paramArrayList.get(i3);
      if (((Boolean)paramArrayList1.get(i3)).booleanValue())
      {
        ((a)localObject1).a(-1);
        if (i3 == paramInt2 - 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        ((a)localObject1).b(bool2);
      }
      else
      {
        ((a)localObject1).a(1);
        ((a)localObject1).c();
      }
    }
    if (bool1)
    {
      localObject1 = new d.f.c();
      a((d.f.c)localObject1);
      i4 = paramInt2 - 1;
      i3 = paramInt2;
      while (i4 >= paramInt1)
      {
        localObject2 = (a)paramArrayList.get(i4);
        bool2 = ((Boolean)paramArrayList1.get(i4)).booleanValue();
        for (i1 = 0; i1 < a.size(); i1++) {
          if (a.b((y.a)a.get(i1)))
          {
            i1 = 1;
            break label990;
          }
        }
        i1 = 0;
        label990:
        if ((i1 != 0) && (!((a)localObject2).a(paramArrayList, i4 + 1, paramInt2))) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          if (B == null) {
            B = new ArrayList();
          }
          localObject4 = new p.g((a)localObject2, bool2);
          B.add(localObject4);
          for (i1 = 0; i1 < a.size(); i1++)
          {
            localObject3 = (y.a)a.get(i1);
            if (a.b((y.a)localObject3)) {
              b.setOnStartEnterTransitionListener((Fragment.f)localObject4);
            }
          }
          if (bool2) {
            ((a)localObject2).c();
          } else {
            ((a)localObject2).b(false);
          }
          i3--;
          if (i4 != i3)
          {
            paramArrayList.remove(i4);
            paramArrayList.add(i3, localObject2);
          }
          a((d.f.c)localObject1);
        }
        i4--;
      }
      i1 = z;
      for (i4 = 0; i4 < i1; i4++)
      {
        localObject2 = (Fragment)y[i4];
        if (!mAdded)
        {
          localObject4 = ((Fragment)localObject2).requireView();
          mPostponedAlpha = ((View)localObject4).getAlpha();
          ((View)localObject4).setAlpha(0.0F);
        }
      }
      i1 = i3;
    }
    else
    {
      i1 = paramInt2;
    }
    int i4 = paramInt1;
    i3 = i4;
    if (i1 != i4)
    {
      i3 = i4;
      if (bool1)
      {
        f0.a(this, paramArrayList, paramArrayList1, paramInt1, i1, true, k);
        a(m, true);
      }
    }
    for (i3 = i4; i3 < paramInt2; i3++)
    {
      localObject1 = (a)paramArrayList.get(i3);
      if ((((Boolean)paramArrayList1.get(i3)).booleanValue()) && (t >= 0)) {
        t = -1;
      }
      if (q != null)
      {
        for (paramInt1 = 0; paramInt1 < q.size(); paramInt1++) {
          ((Runnable)q.get(paramInt1)).run();
        }
        q = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
    }
  }
  
  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i1 = m;
    int i2 = 0;
    if (i1 < 1) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = c.c().iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool = true;
        localObject1 = localObject2;
      }
    }
    if (e != null) {
      while (i2 < e.size())
      {
        paramMenu = (Fragment)e.get(i2);
        if ((localObject1 == null) || (!((ArrayList)localObject1).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i2++;
      }
    }
    e = ((ArrayList)localObject1);
    return bool;
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    if (m < 1) {
      return false;
    }
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = d;
    if (localObject == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = ((ArrayList)localObject).size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(d.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    }
    else
    {
      int i1 = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        for (i1 = d.size() - 1; i1 >= 0; i1--)
        {
          localObject = (a)d.get(i1);
          if (((paramString != null) && (paramString.equals(i))) || ((paramInt1 >= 0) && (paramInt1 == t))) {
            break;
          }
        }
        if (i1 < 0) {
          return false;
        }
        int i2 = i1;
        if ((paramInt2 & 0x1) != 0) {
          for (;;)
          {
            paramInt2 = i1 - 1;
            i2 = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            localObject = (a)d.get(paramInt2);
            if (paramString != null)
            {
              i1 = paramInt2;
              if (paramString.equals(i)) {}
            }
            else
            {
              i2 = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i2 = paramInt2;
              if (paramInt1 != t) {
                break;
              }
              i1 = paramInt2;
            }
          }
        }
        i1 = i2;
      }
      if (i1 == d.size() - 1) {
        return false;
      }
      for (paramInt1 = d.size() - 1; paramInt1 > i1; paramInt1--)
      {
        paramArrayList.add(d.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
      }
    }
    return true;
  }
  
  public Fragment b(int paramInt)
  {
    Object localObject1 = c;
    int i1 = a.size();
    do
    {
      int i2;
      do
      {
        i2 = i1 - 1;
        if (i2 < 0) {
          break;
        }
        localObject2 = (Fragment)a.get(i2);
        i1 = i2;
      } while (localObject2 == null);
      i1 = i2;
    } while (mFragmentId != paramInt);
    break label120;
    localObject1 = b.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (v)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = b;
        if (mFragmentId == paramInt) {
          break label120;
        }
      }
    }
    Object localObject2 = null;
    label120:
    return (Fragment)localObject2;
  }
  
  public Fragment b(String paramString)
  {
    Object localObject1 = c;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      Object localObject3;
      if (paramString != null)
      {
        int i1 = a.size();
        do
        {
          int i2;
          do
          {
            i2 = i1 - 1;
            if (i2 < 0) {
              break;
            }
            localObject3 = (Fragment)a.get(i2);
            i1 = i2;
          } while (localObject3 == null);
          i1 = i2;
        } while (!paramString.equals(mTag));
      }
      else
      {
        localObject3 = localObject2;
        if (paramString != null)
        {
          localObject1 = b.values().iterator();
          do
          {
            do
            {
              localObject3 = localObject2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject3 = (v)((Iterator)localObject1).next();
            } while (localObject3 == null);
            localObject3 = b;
          } while (!paramString.equals(mTag));
        }
      }
      return (Fragment)localObject3;
    }
    throw null;
  }
  
  public void b()
  {
    u = false;
    v = false;
    a(1);
  }
  
  public void b(Fragment paramFragment)
  {
    if (i())
    {
      if (c(2)) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
      return;
    }
    Object localObject = C;
    int i1;
    if (c.containsKey(mWho))
    {
      i1 = 0;
    }
    else
    {
      c.put(mWho, paramFragment);
      i1 = 1;
    }
    if ((i1 != 0) && (c(2)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Updating retained Fragments: Added ");
      ((StringBuilder)localObject).append(paramFragment);
      Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
    }
  }
  
  public boolean b(Menu paramMenu)
  {
    int i1 = m;
    boolean bool = false;
    if (i1 < 1) {
      return false;
    }
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public boolean b(MenuItem paramMenuItem)
  {
    if (m < 1) {
      return false;
    }
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean b(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    synchronized (a)
    {
      boolean bool = a.isEmpty();
      int i1 = 0;
      if (bool) {
        return false;
      }
      int i2 = a.size();
      bool = false;
      while (i1 < i2)
      {
        bool |= ((p.e)a.get(i1)).a(paramArrayList, paramArrayList1);
        i1++;
      }
      a.clear();
      n.z.removeCallbacks(D);
      return bool;
    }
  }
  
  public Fragment c(String paramString)
  {
    Iterator localIterator = c.b.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (v)localIterator.next();
      if (localObject != null)
      {
        localObject = b.findFragmentByWho(paramString);
        if (localObject != null) {
          return (String)localObject;
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public void c()
  {
    w = true;
    d(true);
    f();
    a(-1);
    n = null;
    o = null;
    p = null;
    if (g != null)
    {
      h.b();
      g = null;
    }
  }
  
  public void c(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (c(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (mDetached)
    {
      mDetached = false;
      if (!mAdded)
      {
        c.a(paramFragment);
        if (c(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("add from attach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        if (j(paramFragment)) {
          t = true;
        }
      }
    }
  }
  
  public final void c(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    if (paramArrayList.size() == paramArrayList1.size())
    {
      a(paramArrayList, paramArrayList1);
      int i1 = paramArrayList.size();
      int i2 = 0;
      int i5;
      for (int i3 = 0; i2 < i1; i3 = i5)
      {
        int i4 = i2;
        i5 = i3;
        if (!getp)
        {
          if (i3 != i2) {
            a(paramArrayList, paramArrayList1, i3, i2);
          }
          i3 = i2 + 1;
          i5 = i3;
          if (((Boolean)paramArrayList1.get(i2)).booleanValue()) {
            for (;;)
            {
              i5 = i3;
              if (i3 >= i1) {
                break;
              }
              i5 = i3;
              if (!((Boolean)paramArrayList1.get(i3)).booleanValue()) {
                break;
              }
              i5 = i3;
              if (getp) {
                break;
              }
              i3++;
            }
          }
          a(paramArrayList, paramArrayList1, i2, i5);
          i4 = i5 - 1;
        }
        i2 = i4 + 1;
      }
      if (i3 != i1) {
        a(paramArrayList, paramArrayList1, i3, i1);
      }
      return;
    }
    throw new IllegalStateException("Internal error with the back stack records");
  }
  
  public final void c(boolean paramBoolean)
  {
    if (!b)
    {
      if (n == null)
      {
        if (w) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      if (Looper.myLooper() == n.z.getLooper())
      {
        if ((!paramBoolean) && (i())) {
          throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (y == null)
        {
          y = new ArrayList();
          z = new ArrayList();
        }
        b = true;
        try
        {
          a(null, null);
          return;
        }
        finally
        {
          b = false;
        }
      }
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  public void d()
  {
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  public final void d(Fragment paramFragment)
  {
    HashSet localHashSet = (HashSet)j.get(paramFragment);
    if (localHashSet != null)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        ((d.i.e.a)localIterator.next()).a();
      }
      localHashSet.clear();
      e(paramFragment);
      j.remove(paramFragment);
    }
  }
  
  /* Error */
  public boolean d(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 1324	d/m/a/p:c	(Z)V
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 148	d/m/a/p:y	Ljava/util/ArrayList;
    //   12: aload_0
    //   13: getfield 143	d/m/a/p:z	Ljava/util/ArrayList;
    //   16: invokevirtual 1326	d/m/a/p:b	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   19: ifeq +36 -> 55
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 141	d/m/a/p:b	Z
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 148	d/m/a/p:y	Ljava/util/ArrayList;
    //   32: aload_0
    //   33: getfield 143	d/m/a/p:z	Ljava/util/ArrayList;
    //   36: invokevirtual 1328	d/m/a/p:c	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   39: aload_0
    //   40: invokevirtual 1329	d/m/a/p:a	()V
    //   43: iconst_1
    //   44: istore_1
    //   45: goto -38 -> 7
    //   48: astore_2
    //   49: aload_0
    //   50: invokevirtual 1329	d/m/a/p:a	()V
    //   53: aload_2
    //   54: athrow
    //   55: aload_0
    //   56: invokevirtual 983	d/m/a/p:o	()V
    //   59: aload_0
    //   60: invokevirtual 1331	d/m/a/p:e	()V
    //   63: aload_0
    //   64: getfield 86	d/m/a/p:c	Ld/m/a/x;
    //   67: invokevirtual 1332	d/m/a/x:a	()V
    //   70: iload_1
    //   71: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	p
    //   0	72	1	paramBoolean	boolean
    //   48	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	39	48	finally
  }
  
  public final void e()
  {
    if (x)
    {
      x = false;
      n();
    }
  }
  
  public final void e(Fragment paramFragment)
  {
    paramFragment.performDestroyView();
    l.g(paramFragment, false);
    mContainer = null;
    mView = null;
    mViewLifecycleOwner = null;
    mViewLifecycleOwnerLiveData.a(null);
    mInLayout = false;
  }
  
  public final void f()
  {
    if (!j.isEmpty())
    {
      Iterator localIterator = j.keySet().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        d(localFragment);
        a(localFragment, localFragment.getStateAfterAnimating());
      }
    }
  }
  
  public void f(Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (c(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!mDetached)
    {
      mDetached = true;
      if (mAdded)
      {
        if (c(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove from detach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        c.b(paramFragment);
        if (j(paramFragment)) {
          t = true;
        }
        r(paramFragment);
      }
    }
  }
  
  public final void g()
  {
    if (B != null) {
      while (!B.isEmpty()) {
        ((p.g)B.remove(0)).a();
      }
    }
  }
  
  public final void g(Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.equals(a(mWho)))) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  public final ViewGroup h(Fragment paramFragment)
  {
    if (mContainerId <= 0) {
      return null;
    }
    if (o.a())
    {
      paramFragment = o.a(mContainerId);
      if ((paramFragment instanceof ViewGroup)) {
        return (ViewGroup)paramFragment;
      }
    }
    return null;
  }
  
  public l h()
  {
    Object localObject = r;
    if (localObject != null) {
      return (l)localObject;
    }
    localObject = p;
    if (localObject != null) {
      return mFragmentManager.h();
    }
    return s;
  }
  
  public void i(Fragment paramFragment)
  {
    if (c(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!mHidden)
    {
      mHidden = true;
      mHiddenChanged = (true ^ mHiddenChanged);
      r(paramFragment);
    }
  }
  
  public boolean i()
  {
    boolean bool;
    if ((!u) && (!v)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void j()
  {
    if (n == null) {
      return;
    }
    u = false;
    v = false;
    Iterator localIterator = c.c().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
    }
  }
  
  public final boolean j(Fragment paramFragment)
  {
    boolean bool1 = mHasMenu;
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (mMenuVisible) {}
    }
    else
    {
      p localp = mChildFragmentManager;
      paramFragment = ((ArrayList)c.b()).iterator();
      bool1 = false;
      while (paramFragment.hasNext())
      {
        Fragment localFragment = (Fragment)paramFragment.next();
        boolean bool3 = bool1;
        if (localFragment != null) {
          bool3 = localp.j(localFragment);
        }
        bool1 = bool3;
        if (bool3)
        {
          i1 = 1;
          break label97;
        }
      }
      int i1 = 0;
      label97:
      if (i1 != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  public boolean k()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokevirtual 157	d/m/a/p:d	(Z)Z
    //   5: pop
    //   6: iconst_1
    //   7: istore_1
    //   8: aload_0
    //   9: iconst_1
    //   10: invokevirtual 1324	d/m/a/p:c	(Z)V
    //   13: aload_0
    //   14: getfield 494	d/m/a/p:q	Landroidx/fragment/app/Fragment;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +16 -> 35
    //   22: aload_2
    //   23: invokevirtual 1392	androidx/fragment/app/Fragment:getChildFragmentManager	()Ld/m/a/p;
    //   26: invokevirtual 1394	d/m/a/p:k	()Z
    //   29: ifeq +6 -> 35
    //   32: goto +69 -> 101
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 148	d/m/a/p:y	Ljava/util/ArrayList;
    //   40: aload_0
    //   41: getfield 143	d/m/a/p:z	Ljava/util/ArrayList;
    //   44: aconst_null
    //   45: iconst_m1
    //   46: iconst_0
    //   47: invokevirtual 1396	d/m/a/p:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;II)Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq +34 -> 86
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 141	d/m/a/p:b	Z
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 148	d/m/a/p:y	Ljava/util/ArrayList;
    //   65: aload_0
    //   66: getfield 143	d/m/a/p:z	Ljava/util/ArrayList;
    //   69: invokevirtual 1328	d/m/a/p:c	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   72: aload_0
    //   73: invokevirtual 1329	d/m/a/p:a	()V
    //   76: goto +10 -> 86
    //   79: astore_2
    //   80: aload_0
    //   81: invokevirtual 1329	d/m/a/p:a	()V
    //   84: aload_2
    //   85: athrow
    //   86: aload_0
    //   87: invokevirtual 983	d/m/a/p:o	()V
    //   90: aload_0
    //   91: invokevirtual 1331	d/m/a/p:e	()V
    //   94: aload_0
    //   95: getfield 86	d/m/a/p:c	Ld/m/a/x;
    //   98: invokevirtual 1332	d/m/a/x:a	()V
    //   101: iload_1
    //   102: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	p
    //   7	95	1	bool	boolean
    //   17	6	2	localFragment	Fragment
    //   79	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	72	79	finally
  }
  
  public boolean k(Fragment paramFragment)
  {
    boolean bool = true;
    if (paramFragment == null) {
      return true;
    }
    p localp = mFragmentManager;
    if ((!paramFragment.equals(q)) || (!k(p))) {
      bool = false;
    }
    return bool;
  }
  
  public Parcelable l()
  {
    g();
    f();
    d(true);
    u = true;
    Object localObject1 = c;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      ArrayList localArrayList = new ArrayList(b.size());
      Object localObject3 = b.values().iterator();
      int i1;
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (v)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject1 = b;
          localObject5 = new u(b);
          if ((b.mState > -1) && (J == null))
          {
            Bundle localBundle = ((v)localObject4).a();
            J = localBundle;
            if (b.mTargetWho != null)
            {
              if (localBundle == null) {
                J = new Bundle();
              }
              J.putString("android:target_state", b.mTargetWho);
              i1 = b.mTargetRequestCode;
              if (i1 != 0) {
                J.putInt("android:target_req_state", i1);
              }
            }
          }
          else
          {
            J = b.mSavedFragmentState;
          }
          localArrayList.add(localObject5);
          if (c(2))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Saved state of ");
            ((StringBuilder)localObject4).append(localObject1);
            ((StringBuilder)localObject4).append(": ");
            ((StringBuilder)localObject4).append(J);
            Log.v("FragmentManager", ((StringBuilder)localObject4).toString());
          }
        }
      }
      if (localArrayList.isEmpty())
      {
        if (c(2)) {
          Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return null;
      }
      Object localObject5 = c.d();
      localObject3 = d;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        int i2 = ((ArrayList)localObject3).size();
        localObject1 = localObject2;
        if (i2 > 0)
        {
          localObject2 = new b[i2];
          for (i1 = 0;; i1++)
          {
            localObject1 = localObject2;
            if (i1 >= i2) {
              break;
            }
            localObject2[i1] = new b((a)d.get(i1));
            if (c(2))
            {
              localObject1 = e.a.a.a.a.a("saveAllState: adding back stack #", i1, ": ");
              ((StringBuilder)localObject1).append(d.get(i1));
              Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
            }
          }
        }
      }
      localObject2 = new s();
      x = localArrayList;
      y = ((ArrayList)localObject5);
      z = ((b[])localObject1);
      A = i.get();
      localObject1 = q;
      if (localObject1 != null) {
        B = mWho;
      }
      return (Parcelable)localObject2;
    }
    throw null;
  }
  
  public void l(Fragment paramFragment)
  {
    if (c.a(mWho)) {
      return;
    }
    Object localObject = new v(l, paramFragment);
    ((v)localObject).a(n.y.getClassLoader());
    c.b.put(b.mWho, localObject);
    if (mRetainInstanceChangedWhileDetached)
    {
      if (mRetainInstance) {
        b(paramFragment);
      } else {
        p(paramFragment);
      }
      mRetainInstanceChangedWhileDetached = false;
    }
    c = m;
    if (c(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Added fragment to active set ");
      ((StringBuilder)localObject).append(paramFragment);
      Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void m()
  {
    synchronized (a)
    {
      ArrayList localArrayList2 = B;
      int i1 = 0;
      int i2;
      if ((localArrayList2 != null) && (!B.isEmpty())) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (a.size() == 1) {
        i1 = 1;
      }
      if ((i2 != 0) || (i1 != 0))
      {
        n.z.removeCallbacks(D);
        n.z.post(D);
        o();
      }
      return;
    }
  }
  
  public void m(Fragment paramFragment)
  {
    Object localObject1;
    if (!c.a(mWho))
    {
      if (c(3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Ignoring moving ");
        ((StringBuilder)localObject1).append(paramFragment);
        ((StringBuilder)localObject1).append(" to state ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("since it is not added to ");
        ((StringBuilder)localObject1).append(this);
        Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
      }
      return;
    }
    a(paramFragment, m);
    View localView = mView;
    Object localObject2;
    Object localObject3;
    int i1;
    if (localView != null)
    {
      x localx = c;
      localObject2 = null;
      if (localx != null)
      {
        localObject3 = mContainer;
        localObject1 = localObject2;
        int i2;
        if (localObject3 != null) {
          if (localView == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            i1 = a.indexOf(paramFragment);
            do
            {
              do
              {
                i2 = i1 - 1;
                localObject1 = localObject2;
                if (i2 < 0) {
                  break;
                }
                localObject1 = (Fragment)a.get(i2);
                i1 = i2;
              } while (mContainer != localObject3);
              i1 = i2;
            } while (mView == null);
          }
        }
        if (localObject1 != null)
        {
          localObject2 = mView;
          localObject1 = mContainer;
          i1 = ((ViewGroup)localObject1).indexOfChild((View)localObject2);
          i2 = ((ViewGroup)localObject1).indexOfChild(mView);
          if (i2 < i1)
          {
            ((ViewGroup)localObject1).removeViewAt(i2);
            ((ViewGroup)localObject1).addView(mView, i1);
          }
        }
        if ((mIsNewlyAdded) && (mContainer != null))
        {
          float f1 = mPostponedAlpha;
          if (f1 > 0.0F) {
            mView.setAlpha(f1);
          }
          mPostponedAlpha = 0.0F;
          mIsNewlyAdded = false;
          localObject2 = r.a(n.y, o, paramFragment, true);
          if (localObject2 != null)
          {
            localObject1 = a;
            if (localObject1 != null)
            {
              mView.startAnimation((Animation)localObject1);
            }
            else
            {
              b.setTarget(mView);
              b.start();
            }
          }
        }
      }
      else
      {
        throw null;
      }
    }
    if (mHiddenChanged)
    {
      if (mView != null)
      {
        localObject1 = r.a(n.y, o, paramFragment, mHidden ^ true);
        if (localObject1 != null)
        {
          localObject2 = b;
          if (localObject2 != null)
          {
            ((Animator)localObject2).setTarget(mView);
            if (mHidden)
            {
              if (paramFragment.isHideReplaced())
              {
                paramFragment.setHideReplaced(false);
              }
              else
              {
                localObject2 = mContainer;
                localObject3 = mView;
                ((ViewGroup)localObject2).startViewTransition((View)localObject3);
                b.addListener(new q(this, (ViewGroup)localObject2, (View)localObject3, paramFragment));
              }
            }
            else {
              mView.setVisibility(0);
            }
            b.start();
            break label584;
          }
        }
        if (localObject1 != null)
        {
          mView.startAnimation(a);
          a.start();
        }
        if ((mHidden) && (!paramFragment.isHideReplaced())) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        mView.setVisibility(i1);
        if (paramFragment.isHideReplaced()) {
          paramFragment.setHideReplaced(false);
        }
      }
      label584:
      if ((mAdded) && (j(paramFragment))) {
        t = true;
      }
      mHiddenChanged = false;
      paramFragment.onHiddenChanged(mHidden);
    }
  }
  
  public final void n()
  {
    Iterator localIterator = ((ArrayList)c.b()).iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        n(localFragment);
      }
    }
  }
  
  public void n(Fragment paramFragment)
  {
    if (mDeferStart)
    {
      if (b)
      {
        x = true;
        return;
      }
      mDeferStart = false;
      a(paramFragment, m);
    }
  }
  
  public final void o()
  {
    synchronized (a)
    {
      boolean bool1 = a.isEmpty();
      boolean bool2 = true;
      if (!bool1)
      {
        h.a = true;
        return;
      }
      ??? = h;
      ArrayList localArrayList = d;
      int i1;
      if (localArrayList != null) {
        i1 = localArrayList.size();
      } else {
        i1 = 0;
      }
      if ((i1 <= 0) || (!k(p))) {
        bool2 = false;
      }
      a = bool2;
      return;
    }
  }
  
  public void o(Fragment paramFragment)
  {
    if (c(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove: ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" nesting=");
      localStringBuilder.append(mBackStackNesting);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    boolean bool = paramFragment.isInBackStack();
    if ((!mDetached) || ((bool ^ true)))
    {
      c.b(paramFragment);
      if (j(paramFragment)) {
        t = true;
      }
      mRemoving = true;
      r(paramFragment);
    }
  }
  
  public void p(Fragment paramFragment)
  {
    if (i())
    {
      if (c(2)) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
      return;
    }
    int i1;
    if (C.c.remove(mWho) != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (c(2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Updating retained Fragments: Removed ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  public void q(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(a(mWho))) || ((mHost != null) && (mFragmentManager != this))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" is not an active fragment of FragmentManager ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = q;
    q = paramFragment;
    g((Fragment)localObject);
    g(q);
  }
  
  public final void r(Fragment paramFragment)
  {
    ViewGroup localViewGroup = h(paramFragment);
    if (localViewGroup != null)
    {
      if (localViewGroup.getTag(R.id.visible_removing_fragment_view_tag) == null) {
        localViewGroup.setTag(R.id.visible_removing_fragment_view_tag, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(R.id.visible_removing_fragment_view_tag)).setNextAnim(paramFragment.getNextAnim());
    }
  }
  
  public void s(Fragment paramFragment)
  {
    if (c(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (mHidden)
    {
      mHidden = false;
      mHiddenChanged ^= true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Object localObject = p;
    if (localObject != null)
    {
      localStringBuilder.append(localObject.getClass().getSimpleName());
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(p)));
      localStringBuilder.append("}");
    }
    else
    {
      localObject = n;
      if (localObject != null)
      {
        localStringBuilder.append(localObject.getClass().getSimpleName());
        localStringBuilder.append("{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(n)));
        localStringBuilder.append("}");
      }
      else
      {
        localStringBuilder.append("null");
      }
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */