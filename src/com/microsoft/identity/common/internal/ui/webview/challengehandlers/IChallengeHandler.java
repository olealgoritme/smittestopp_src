package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

public abstract interface IChallengeHandler<GenericChallenge, GenericResponse>
{
  public abstract GenericResponse processChallenge(GenericChallenge paramGenericChallenge);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */