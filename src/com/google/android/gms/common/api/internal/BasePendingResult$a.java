package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import e.c.a.a.b.i.h;
import e.c.a.a.b.i.i;
import e.c.a.a.d.a.c;

public class BasePendingResult$a<R extends h>
  extends c
{
  public BasePendingResult$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 1)
    {
      if (i != 2)
      {
        paramMessage = new StringBuilder(45);
        paramMessage.append("Don't know how to handle message: ");
        paramMessage.append(i);
        Log.wtf("BasePendingResult", paramMessage.toString(), new Exception());
        return;
      }
      ((BasePendingResult)obj).b(Status.C);
      return;
    }
    paramMessage = (Pair)obj;
    i locali = (i)first;
    paramMessage = (h)second;
    try
    {
      locali.a(paramMessage);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      BasePendingResult.c(paramMessage);
      throw localRuntimeException;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.internal.BasePendingResult.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */