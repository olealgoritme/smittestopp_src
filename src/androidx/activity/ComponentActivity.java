package androidx.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import d.i.a.d;
import d.o.a0;
import d.o.e0;
import d.o.f0;
import d.o.g;
import d.o.g.b;
import d.o.l;
import d.o.m;
import d.o.v;
import d.o.x;
import d.v.a;
import d.v.b;

public class ComponentActivity
  extends d
  implements l, f0, d.v.c, d.a.c
{
  public int mContentLayoutId;
  public a0 mDefaultFactory;
  public final m mLifecycleRegistry = new m(this);
  public final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity.a(this));
  public final b mSavedStateRegistryController = new b(this);
  public e0 mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() != null)
    {
      getLifecycle().a(new ComponentActivity.2(this));
      getLifecycle().a(new ComponentActivity.3(this));
      if (Build.VERSION.SDK_INT <= 23) {
        getLifecycle().a(new ImmLeaksCleaner(this));
      }
      return;
    }
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  public ComponentActivity(int paramInt)
  {
    this();
    mContentLayoutId = paramInt;
  }
  
  public a0 getDefaultViewModelProviderFactory()
  {
    if (getApplication() != null)
    {
      if (mDefaultFactory == null)
      {
        Application localApplication = getApplication();
        Bundle localBundle;
        if (getIntent() != null) {
          localBundle = getIntent().getExtras();
        } else {
          localBundle = null;
        }
        mDefaultFactory = new x(localApplication, this, localBundle);
      }
      return mDefaultFactory;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  public Object getLastCustomNonConfigurationInstance()
  {
    Object localObject = (ComponentActivity.b)getLastNonConfigurationInstance();
    if (localObject != null) {
      localObject = a;
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  public g getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return mOnBackPressedDispatcher;
  }
  
  public final a getSavedStateRegistry()
  {
    return mSavedStateRegistryController.b;
  }
  
  public e0 getViewModelStore()
  {
    if (getApplication() != null)
    {
      if (mViewModelStore == null)
      {
        ComponentActivity.b localb = (ComponentActivity.b)getLastNonConfigurationInstance();
        if (localb != null) {
          mViewModelStore = b;
        }
        if (mViewModelStore == null) {
          mViewModelStore = new e0();
        }
      }
      return mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onBackPressed()
  {
    mOnBackPressedDispatcher.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mSavedStateRegistryController.a(paramBundle);
    v.b(this);
    int i = mContentLayoutId;
    if (i != 0) {
      setContentView(i);
    }
  }
  
  @Deprecated
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject1 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = mViewModelStore;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      ComponentActivity.b localb = (ComponentActivity.b)getLastNonConfigurationInstance();
      localObject3 = localObject2;
      if (localb != null) {
        localObject3 = b;
      }
    }
    if ((localObject3 == null) && (localObject1 == null)) {
      return null;
    }
    localObject2 = new ComponentActivity.b();
    a = localObject1;
    b = ((e0)localObject3);
    return localObject2;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    g localg = getLifecycle();
    if ((localg instanceof m)) {
      ((m)localg).a(g.b.CREATED);
    }
    super.onSaveInstanceState(paramBundle);
    mSavedStateRegistryController.b(paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.androidx.activity.ComponentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */