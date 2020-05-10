package com.android.volley;

import android.content.Intent;

public class AuthFailureError
  extends VolleyError
{
  public Intent mResolutionIntent;
  
  public AuthFailureError() {}
  
  public AuthFailureError(Intent paramIntent)
  {
    mResolutionIntent = paramIntent;
  }
  
  public AuthFailureError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public AuthFailureError(String paramString)
  {
    super(paramString);
  }
  
  public AuthFailureError(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }
  
  public String getMessage()
  {
    if (mResolutionIntent != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
  
  public Intent getResolutionIntent()
  {
    return mResolutionIntent;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.AuthFailureError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */