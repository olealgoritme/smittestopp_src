package com.microsoft.identity.common.internal.ui;

public enum AuthorizationAgent
{
  static
  {
    AuthorizationAgent localAuthorizationAgent = new AuthorizationAgent("BROWSER", 2);
    BROWSER = localAuthorizationAgent;
    $VALUES = new AuthorizationAgent[] { DEFAULT, WEBVIEW, localAuthorizationAgent };
  }
  
  public AuthorizationAgent() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.AuthorizationAgent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */