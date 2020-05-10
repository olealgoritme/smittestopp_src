package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

public enum PKeyAuthChallengeHandler$RequestField
{
  static
  {
    CertAuthorities = new RequestField("CertAuthorities", 1);
    Version = new RequestField("Version", 2);
    SubmitUrl = new RequestField("SubmitUrl", 3);
    Context = new RequestField("Context", 4);
    RequestField localRequestField = new RequestField("CertThumbprint", 5);
    CertThumbprint = localRequestField;
    $VALUES = new RequestField[] { Nonce, CertAuthorities, Version, SubmitUrl, Context, localRequestField };
  }
  
  public PKeyAuthChallengeHandler$RequestField() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler.RequestField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */