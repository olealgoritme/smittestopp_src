package com.microsoft.identity.client;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import java.util.List;

public class AcquireTokenParameters$Builder
  extends TokenParameters.Builder<Builder>
{
  public Activity mActivity;
  public AuthenticationCallback mCallback;
  public List<Pair<String, String>> mExtraQueryStringParameters;
  public List<String> mExtraScopesToConsent;
  public Fragment mFragment;
  public String mLoginHint;
  public Prompt mPrompt;
  
  public AcquireTokenParameters build()
  {
    return new AcquireTokenParameters(this);
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder startAuthorizationFromActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
    return self();
  }
  
  public Builder withAuthorizationQueryStringParameters(List<Pair<String, String>> paramList)
  {
    mExtraQueryStringParameters = paramList;
    return self();
  }
  
  public Builder withCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    mCallback = paramAuthenticationCallback;
    return self();
  }
  
  public Builder withFragment(Fragment paramFragment)
  {
    mFragment = paramFragment;
    return self();
  }
  
  public Builder withLoginHint(String paramString)
  {
    mLoginHint = paramString;
    return self();
  }
  
  public Builder withOtherScopesToAuthorize(List<String> paramList)
  {
    mExtraScopesToConsent = paramList;
    return self();
  }
  
  public Builder withPrompt(Prompt paramPrompt)
  {
    mPrompt = paramPrompt;
    return self();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AcquireTokenParameters.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */