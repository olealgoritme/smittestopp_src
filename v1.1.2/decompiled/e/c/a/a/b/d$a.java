package e.c.a.a.b;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import e.c.a.a.d.a.c;

@SuppressLint({"HandlerLeak"})
public final class d$a
  extends c
{
  public final Context a;
  
  public d$a(d paramd, Context paramContext)
  {
    super(paramd);
    a = paramContext.getApplicationContext();
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 1)
    {
      paramMessage = new StringBuilder(50);
      paramMessage.append("Don't know how to handle this message: ");
      paramMessage.append(i);
      Log.w("GoogleApiAvailability", paramMessage.toString());
    }
    else
    {
      i = b.a(a, e.a);
      d locald = b;
      paramMessage = null;
      if (locald == null) {
        break label129;
      }
      if (g.b(i))
      {
        locald = b;
        Context localContext = a;
        Intent localIntent = locald.a(localContext, i, "n");
        if (localIntent != null) {
          paramMessage = PendingIntent.getActivity(localContext, 0, localIntent, 134217728);
        }
        locald.a(localContext, i, paramMessage);
      }
    }
    return;
    label129:
    throw null;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */