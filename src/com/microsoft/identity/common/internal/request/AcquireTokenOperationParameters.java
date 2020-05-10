package com.microsoft.identity.common.internal.request;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import com.microsoft.identity.common.internal.ui.browser.BrowserDescriptor;
import e.c.c.v.a;
import java.util.HashMap;
import java.util.List;

public class AcquireTokenOperationParameters
  extends OperationParameters
{
  public transient Activity mActivity;
  @a
  public AuthorizationAgent mAuthorizationAgent;
  public boolean mBrokerBrowserSupportEnabled;
  @a
  public List<Pair<String, String>> mExtraQueryStringParameters;
  @a
  public List<String> mExtraScopesToConsent;
  public transient Fragment mFragment;
  public String mLoginHint;
  @a
  public OpenIdConnectPromptParameter mOpenIdConnectPromptParameter;
  public transient HashMap<String, String> mRequestHeaders;
  @a
  public boolean webViewZoomControlsEnabled;
  @a
  public boolean webViewZoomEnabled;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AcquireTokenOperationParameters)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (AcquireTokenOperationParameters)paramObject;
    Object localObject = mLoginHint;
    if (localObject != null ? !((String)localObject).equals(mLoginHint) : mLoginHint != null) {
      return false;
    }
    localObject = mExtraQueryStringParameters;
    if (localObject != null ? !((List)localObject).equals(mExtraQueryStringParameters) : mExtraQueryStringParameters != null) {
      return false;
    }
    localObject = mExtraScopesToConsent;
    if (localObject != null ? !((List)localObject).equals(mExtraScopesToConsent) : mExtraScopesToConsent != null) {
      return false;
    }
    if (mOpenIdConnectPromptParameter != mOpenIdConnectPromptParameter) {
      bool = false;
    }
    return bool;
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public AuthorizationAgent getAuthorizationAgent()
  {
    return mAuthorizationAgent;
  }
  
  public List<BrowserDescriptor> getBrowserSafeList()
  {
    return mBrowserSafeList;
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
  
  public OpenIdConnectPromptParameter getOpenIdConnectPromptParameter()
  {
    return mOpenIdConnectPromptParameter;
  }
  
  public HashMap<String, String> getRequestHeaders()
  {
    return mRequestHeaders;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = mLoginHint;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = mExtraQueryStringParameters;
    int m;
    if (localObject != null) {
      m = ((List)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = mExtraScopesToConsent;
    int n;
    if (localObject != null) {
      n = ((List)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = mOpenIdConnectPromptParameter;
    if (localObject != null) {
      j = ((Enum)localObject).hashCode();
    }
    return (((i * 31 + k) * 31 + m) * 31 + n) * 31 + j;
  }
  
  public boolean isBrokerBrowserSupportEnabled()
  {
    return mBrokerBrowserSupportEnabled;
  }
  
  public boolean isWebViewZoomControlsEnabled()
  {
    return webViewZoomControlsEnabled;
  }
  
  public boolean isWebViewZoomEnabled()
  {
    return webViewZoomEnabled;
  }
  
  public void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
  }
  
  public void setAuthorizationAgent(AuthorizationAgent paramAuthorizationAgent)
  {
    mAuthorizationAgent = paramAuthorizationAgent;
  }
  
  public void setBrokerBrowserSupportEnabled(boolean paramBoolean)
  {
    mBrokerBrowserSupportEnabled = paramBoolean;
  }
  
  public void setBrowserSafeList(List<BrowserDescriptor> paramList)
  {
    mBrowserSafeList = paramList;
  }
  
  public void setExtraQueryStringParameters(List<Pair<String, String>> paramList)
  {
    mExtraQueryStringParameters = paramList;
  }
  
  public void setExtraScopesToConsent(List<String> paramList)
  {
    mExtraScopesToConsent = paramList;
  }
  
  public void setFragment(Fragment paramFragment)
  {
    mFragment = paramFragment;
  }
  
  public void setLoginHint(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    mLoginHint = str;
  }
  
  public void setOpenIdConnectPromptParameter(OpenIdConnectPromptParameter paramOpenIdConnectPromptParameter)
  {
    mOpenIdConnectPromptParameter = paramOpenIdConnectPromptParameter;
  }
  
  public void setRequestHeaders(HashMap<String, String> paramHashMap)
  {
    mRequestHeaders = paramHashMap;
  }
  
  public void setWebViewZoomControlsEnabled(boolean paramBoolean)
  {
    webViewZoomControlsEnabled = paramBoolean;
  }
  
  public void setWebViewZoomEnabled(boolean paramBoolean)
  {
    webViewZoomEnabled = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */