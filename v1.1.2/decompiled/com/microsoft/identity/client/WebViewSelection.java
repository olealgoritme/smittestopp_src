package com.microsoft.identity.client;

public enum WebViewSelection
{
  public int mId;
  
  static
  {
    WebViewSelection localWebViewSelection = new WebViewSelection("SYSTEM_BROWSER", 1, 2);
    SYSTEM_BROWSER = localWebViewSelection;
    $VALUES = new WebViewSelection[] { EMBEDDED_WEBVIEW, localWebViewSelection };
  }
  
  public WebViewSelection(int paramInt)
  {
    mId = paramInt;
  }
  
  public int getId()
  {
    return mId;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.WebViewSelection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */