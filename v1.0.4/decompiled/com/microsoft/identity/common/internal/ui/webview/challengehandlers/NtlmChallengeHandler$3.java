package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.HttpAuthHandler;
import android.widget.EditText;
import com.microsoft.identity.common.internal.logging.Logger;

public class NtlmChallengeHandler$3
  implements DialogInterface.OnClickListener
{
  public NtlmChallengeHandler$3(NtlmChallengeHandler paramNtlmChallengeHandler, NtlmChallenge paramNtlmChallenge, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Logger.info(NtlmChallengeHandler.access$100(), "Proceeding with user supplied username and password.");
    val$ntlmChallenge.getHandler().proceed(val$usernameView.getText().toString(), val$passwordView.getText().toString());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */