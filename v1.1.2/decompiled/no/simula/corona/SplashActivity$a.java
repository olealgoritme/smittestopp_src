package no.simula.corona;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import i.k.b.g;

@SuppressLint({"HandlerLeak"})
public final class SplashActivity$a
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      super.handleMessage(paramMessage);
      if (!a.isFinishing()) {
        SplashActivity.b(a);
      }
      return;
    }
    g.a("msg");
    throw null;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.SplashActivity.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */