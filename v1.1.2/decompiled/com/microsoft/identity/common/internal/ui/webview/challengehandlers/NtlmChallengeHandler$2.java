package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.HttpAuthHandler;

public class NtlmChallengeHandler$2
  implements DialogInterface.OnClickListener
{
  public NtlmChallengeHandler$2(NtlmChallengeHandler paramNtlmChallengeHandler, NtlmChallenge paramNtlmChallenge) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    val$ntlmChallenge.getHandler().cancel();
    NtlmChallengeHandler.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */