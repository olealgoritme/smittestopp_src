package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import d.m.a.a;
import d.m.a.p;
import d.m.a.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

public abstract class AuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest>
{
  public WeakReference<Activity> mReferencedActivity;
  public WeakReference<Context> mReferencedApplicationContext;
  public WeakReference<Fragment> mReferencedFragment;
  
  public AuthorizationStrategy(Context paramContext, Activity paramActivity, Fragment paramFragment)
  {
    mReferencedApplicationContext = new WeakReference(paramContext);
    mReferencedActivity = new WeakReference(paramActivity);
    mReferencedFragment = new WeakReference(paramFragment);
  }
  
  public abstract void completeAuthorization(int paramInt1, int paramInt2, Intent paramIntent);
  
  public Context getApplicationContext()
  {
    return (Context)mReferencedApplicationContext.get();
  }
  
  public void launchIntent(Intent paramIntent)
  {
    Fragment localFragment = (Fragment)mReferencedFragment.get();
    if (localFragment != null)
    {
      paramIntent = AuthorizationActivity.getAuthorizationFragmentFromStartIntent(paramIntent);
      Object localObject = localFragment.getFragmentManager();
      if (localObject != null)
      {
        localObject = new a((p)localObject);
        ((x)localObject).a(localFragment.getId(), paramIntent, AuthorizationFragment.class.getName(), 1);
        ((x)localObject).a();
        return;
      }
      throw null;
    }
    ((Activity)mReferencedActivity.get()).startActivity(paramIntent);
  }
  
  public abstract Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericOAuth2Strategy paramGenericOAuth2Strategy);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */