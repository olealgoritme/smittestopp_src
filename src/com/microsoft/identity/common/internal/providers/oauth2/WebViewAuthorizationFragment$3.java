package com.microsoft.identity.common.internal.providers.oauth2;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class WebViewAuthorizationFragment$3
  implements View.OnTouchListener
{
  public WebViewAuthorizationFragment$3(WebViewAuthorizationFragment paramWebViewAuthorizationFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (((i == 0) || (i == 1)) && (!paramView.hasFocus())) {
      paramView.requestFocus();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */