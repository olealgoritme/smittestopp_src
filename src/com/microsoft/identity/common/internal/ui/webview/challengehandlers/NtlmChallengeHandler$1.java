package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.HttpAuthHandler;

public class NtlmChallengeHandler$1
  implements DialogInterface.OnCancelListener
{
  public NtlmChallengeHandler$1(NtlmChallengeHandler paramNtlmChallengeHandler, NtlmChallenge paramNtlmChallenge) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    val$ntlmChallenge.getHandler().cancel();
    NtlmChallengeHandler.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */