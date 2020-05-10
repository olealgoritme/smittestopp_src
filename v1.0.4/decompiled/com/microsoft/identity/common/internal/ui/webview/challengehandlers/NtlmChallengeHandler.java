package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.microsoft.identity.common.R.id;
import com.microsoft.identity.common.R.layout;
import com.microsoft.identity.common.R.string;
import com.microsoft.identity.common.internal.logging.Logger;

public final class NtlmChallengeHandler
  implements IChallengeHandler<NtlmChallenge, Void>
{
  public static final String TAG = "NtlmChallengeHandler";
  public Activity mActivity;
  public IAuthorizationCompletionCallback mChallengeCallback;
  
  public NtlmChallengeHandler(Activity paramActivity, IAuthorizationCompletionCallback paramIAuthorizationCompletionCallback)
  {
    mActivity = paramActivity;
    mChallengeCallback = paramIAuthorizationCompletionCallback;
  }
  
  private void cancelRequest()
  {
    Logger.info(TAG, "Sending intent to cancel authentication activity");
    mChallengeCallback.onChallengeResponseReceived(2001, new Intent());
  }
  
  private void showHttpAuthDialog(NtlmChallenge paramNtlmChallenge)
  {
    View localView = LayoutInflater.from(mActivity).inflate(mActivity.getResources().getLayout(R.layout.http_auth_dialog), null);
    EditText localEditText1 = (EditText)localView.findViewById(R.id.editUserName);
    EditText localEditText2 = (EditText)localView.findViewById(R.id.editPassword);
    String str = mActivity.getText(R.string.http_auth_dialog_title).toString();
    new AlertDialog.Builder(mActivity).setTitle(str).setView(localView).setPositiveButton(R.string.http_auth_dialog_login, new NtlmChallengeHandler.3(this, paramNtlmChallenge, localEditText1, localEditText2)).setNegativeButton(R.string.http_auth_dialog_cancel, new NtlmChallengeHandler.2(this, paramNtlmChallenge)).setOnCancelListener(new NtlmChallengeHandler.1(this, paramNtlmChallenge)).create().show();
  }
  
  public Void processChallenge(NtlmChallenge paramNtlmChallenge)
  {
    showHttpAuthDialog(paramNtlmChallenge);
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */