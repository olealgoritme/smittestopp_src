package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.WebView;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.Map;

public class PKeyAuthChallengeHandler$1
  implements Runnable
{
  public PKeyAuthChallengeHandler$1(PKeyAuthChallengeHandler paramPKeyAuthChallengeHandler, PKeyAuthChallenge paramPKeyAuthChallenge, Map paramMap) {}
  
  public void run()
  {
    String str1 = val$pKeyAuthChallenge.getSubmitUrl();
    Logger.info(PKeyAuthChallengeHandler.access$000(), "Respond to pkeyAuth challenge");
    String str2 = PKeyAuthChallengeHandler.access$000();
    StringBuilder localStringBuilder = a.a("Challenge submit url:");
    localStringBuilder.append(val$pKeyAuthChallenge.getSubmitUrl());
    Logger.infoPII(str2, localStringBuilder.toString());
    PKeyAuthChallengeHandler.access$100(this$0).loadUrl(str1, val$header);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */