package com.microsoft.identity.client;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import java.util.List;

public class AcquireTokenParameters
  extends TokenParameters
{
  public Activity mActivity;
  public AuthenticationCallback mCallback;
  public List<Pair<String, String>> mExtraQueryStringParameters;
  public List<String> mExtraScopesToConsent;
  public Fragment mFragment;
  public String mLoginHint;
  public Prompt mPrompt;
  
  public AcquireTokenParameters(AcquireTokenParameters.Builder paramBuilder)
  {
    super(paramBuilder);
    mActivity = AcquireTokenParameters.Builder.access$000(paramBuilder);
    mFragment = AcquireTokenParameters.Builder.access$100(paramBuilder);
    mLoginHint = AcquireTokenParameters.Builder.access$200(paramBuilder);
    mPrompt = AcquireTokenParameters.Builder.access$300(paramBuilder);
    mExtraScopesToConsent = AcquireTokenParameters.Builder.access$400(paramBuilder);
    mExtraQueryStringParameters = AcquireTokenParameters.Builder.access$500(paramBuilder);
    mCallback = AcquireTokenParameters.Builder.access$600(paramBuilder);
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public AuthenticationCallback getCallback()
  {
    return mCallback;
  }
  
  public List<Pair<String, String>> getExtraQueryStringParameters()
  {
    return mExtraQueryStringParameters;
  }
  
  public List<String> getExtraScopesToConsent()
  {
    return mExtraScopesToConsent;
  }
  
  public Fragment getFragment()
  {
    return mFragment;
  }
  
  public String getLoginHint()
  {
    return mLoginHint;
  }
  
  public Prompt getPrompt()
  {
    return mPrompt;
  }
  
  public void setLoginHint(String paramString)
  {
    mLoginHint = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AcquireTokenParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */