package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import d.a.b;
import d.b.a.r;
import d.m.a.j;
import d.o.a0;
import d.o.b0;
import d.o.d0;
import d.o.e0;
import d.s.e;
import d.s.f;
import d.s.q;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NavHostFragment
  extends Fragment
{
  public boolean A;
  public d.s.l x;
  public Boolean y = null;
  public int z;
  
  public static NavController a(Fragment paramFragment)
  {
    for (Object localObject = paramFragment; localObject != null; localObject = ((Fragment)localObject).getParentFragment())
    {
      if ((localObject instanceof NavHostFragment))
      {
        paramFragment = x;
        if (paramFragment != null) {
          return paramFragment;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
      }
      Fragment localFragment = getParentFragmentManagerq;
      if ((localFragment instanceof NavHostFragment))
      {
        paramFragment = x;
        if (paramFragment != null) {
          return paramFragment;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
      }
    }
    localObject = paramFragment.getView();
    if (localObject != null)
    {
      paramFragment = r.a((View)localObject);
      if (paramFragment != null) {
        return paramFragment;
      }
      paramFragment = new StringBuilder();
      paramFragment.append("View ");
      paramFragment.append(localObject);
      paramFragment.append(" does not have a NavController set");
      throw new IllegalStateException(paramFragment.toString());
    }
    throw new IllegalStateException(e.a.a.a.a.a("Fragment ", paramFragment, " does not have a NavController set"));
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (A)
    {
      paramContext = getParentFragmentManager();
      if (paramContext != null)
      {
        paramContext = new d.m.a.a(paramContext);
        paramContext.b(this);
        paramContext.a();
      }
      else
      {
        throw null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject1 = new d.s.l(requireContext());
    x = ((d.s.l)localObject1);
    i = this;
    getLifecycle().a(m);
    localObject1 = x;
    Object localObject2 = requireActivity().getOnBackPressedDispatcher();
    if (i != null)
    {
      n.b();
      ((OnBackPressedDispatcher)localObject2).a(i, n);
      localObject1 = x;
      localObject2 = y;
      int i = 0;
      boolean bool;
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      o = bool;
      ((NavController)localObject1).c();
      Object localObject3 = null;
      y = null;
      Object localObject4 = x;
      localObject2 = getViewModelStore();
      if (h.isEmpty())
      {
        a0 locala0 = d.s.g.d;
        localObject1 = d.s.g.class.getCanonicalName();
        if (localObject1 != null)
        {
          Object localObject5 = e.a.a.a.a.b("androidx.lifecycle.ViewModelProvider.DefaultKey:", (String)localObject1);
          localObject1 = (d.o.y)a.get(localObject5);
          if (d.s.g.class.isInstance(localObject1))
          {
            localObject2 = localObject1;
            if ((locala0 instanceof d0))
            {
              ((d0)locala0).a((d.o.y)localObject1);
              localObject2 = localObject1;
            }
          }
          else
          {
            if ((locala0 instanceof b0)) {
              localObject1 = ((b0)locala0).a((String)localObject5, d.s.g.class);
            } else {
              localObject1 = new d.s.g();
            }
            localObject5 = (d.o.y)a.put(localObject5, localObject1);
            localObject2 = localObject1;
            if (localObject5 != null)
            {
              ((d.o.y)localObject5).b();
              localObject2 = localObject1;
            }
          }
          j = ((d.s.g)localObject2);
          localObject1 = x;
          k.a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
          localObject4 = k;
          localObject2 = requireContext();
          localObject1 = getChildFragmentManager();
          int j = getId();
          if ((j == 0) || (j == -1)) {
            j = R.id.nav_host_fragment_container;
          }
          ((q)localObject4).a(new d.s.r.a((Context)localObject2, (d.m.a.p)localObject1, j));
          if (paramBundle != null)
          {
            localObject1 = paramBundle.getBundle("android-support-nav:fragment:navControllerState");
            if (paramBundle.getBoolean("android-support-nav:fragment:defaultHost", false))
            {
              A = true;
              localObject2 = getParentFragmentManager();
              if (localObject2 != null)
              {
                localObject2 = new d.m.a.a((d.m.a.p)localObject2);
                ((d.m.a.y)localObject2).b(this);
                ((d.m.a.y)localObject2).a();
              }
              else
              {
                throw null;
              }
            }
            z = paramBundle.getInt("android-support-nav:fragment:graphId");
            paramBundle = (Bundle)localObject1;
          }
          else
          {
            paramBundle = null;
          }
          if (paramBundle != null)
          {
            localObject1 = x;
            if (localObject1 != null)
            {
              paramBundle.setClassLoader(a.getClassLoader());
              e = paramBundle.getBundle("android-support-nav:controller:navigatorState");
              f = paramBundle.getParcelableArray("android-support-nav:controller:backStack");
              g = paramBundle.getBoolean("android-support-nav:controller:deepLinkHandled");
            }
            else
            {
              throw null;
            }
          }
          j = z;
          if (j != 0)
          {
            x.a(j, null);
          }
          else
          {
            localObject1 = getArguments();
            j = i;
            if (localObject1 != null) {
              j = ((Bundle)localObject1).getInt("android-support-nav:fragment:graphId");
            }
            paramBundle = (Bundle)localObject3;
            if (localObject1 != null) {
              paramBundle = ((Bundle)localObject1).getBundle("android-support-nav:fragment:startDestinationArgs");
            }
            if (j != 0) {
              x.a(j, paramBundle);
            }
          }
          return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
      }
      throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }
    throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new j(paramLayoutInflater.getContext());
    int i = getId();
    if ((i == 0) || (i == -1)) {
      i = R.id.nav_host_fragment_container;
    }
    paramLayoutInflater.setId(i);
    return paramLayoutInflater;
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramContext, paramAttributeSet, paramBundle);
    paramBundle = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NavHost);
    int i = paramBundle.getResourceId(R.styleable.NavHost_navGraph, 0);
    if (i != 0) {
      z = i;
    }
    paramBundle.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NavHostFragment);
    if (paramContext.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
      A = true;
    }
    paramContext.recycle();
  }
  
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean)
  {
    d.s.l locall = x;
    if (locall != null)
    {
      o = paramBoolean;
      locall.c();
    }
    else
    {
      y = Boolean.valueOf(paramBoolean);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    d.s.l locall = x;
    Object localObject1 = null;
    if (locall != null)
    {
      Object localObject2 = new ArrayList();
      Object localObject3 = new Bundle();
      Iterator localIterator = k.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject4 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject4).getKey();
        localObject4 = ((d.s.p)((Map.Entry)localObject4).getValue()).b();
        if (localObject4 != null)
        {
          ((ArrayList)localObject2).add(str);
          ((Bundle)localObject3).putBundle(str, (Bundle)localObject4);
        }
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject3).putStringArrayList("android-support-nav:controller:navigatorState:names", (ArrayList)localObject2);
        ((Bundle)localObject1).putBundle("android-support-nav:controller:navigatorState", (Bundle)localObject3);
      }
      localObject3 = localObject1;
      if (!h.isEmpty())
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Bundle();
        }
        localObject1 = new Parcelable[h.size()];
        i = 0;
        localObject2 = h.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i] = new f((e)((Iterator)localObject2).next());
          i++;
        }
        ((Bundle)localObject3).putParcelableArray("android-support-nav:controller:backStack", (Parcelable[])localObject1);
      }
      localObject1 = localObject3;
      if (g)
      {
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putBoolean("android-support-nav:controller:deepLinkHandled", g);
      }
      if (localObject1 != null) {
        paramBundle.putBundle("android-support-nav:fragment:navControllerState", (Bundle)localObject1);
      }
      if (A) {
        paramBundle.putBoolean("android-support-nav:fragment:defaultHost", true);
      }
      int i = z;
      if (i != 0) {
        paramBundle.putInt("android-support-nav:fragment:graphId", i);
      }
      return;
    }
    throw null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((paramView instanceof ViewGroup))
    {
      paramBundle = x;
      paramView.setTag(androidx.navigation.R.id.nav_controller_view_tag, paramBundle);
      if (paramView.getParent() != null)
      {
        paramView = (View)paramView.getParent();
        if (paramView.getId() == getId())
        {
          paramBundle = x;
          paramView.setTag(androidx.navigation.R.id.nav_controller_view_tag, paramBundle);
        }
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("created host view ");
    paramBundle.append(paramView);
    paramBundle.append(" is not a ViewGroup");
    throw new IllegalStateException(paramBundle.toString());
  }
}

/* Location:
 * Qualified Name:     base.androidx.navigation.fragment.NavHostFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */