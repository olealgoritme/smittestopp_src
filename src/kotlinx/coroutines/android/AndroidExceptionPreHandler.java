package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import androidx.annotation.Keep;
import h.b;
import h.k.b.g;
import h.k.b.i;
import h.k.b.l;
import h.m.e;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Keep
public final class AndroidExceptionPreHandler
  extends h.j.a
  implements CoroutineExceptionHandler, h.k.a.a<Method>
{
  public final b preHandler$delegate = new h.d(this, null, 2);
  
  static
  {
    if (l.a != null)
    {
      i locali = new i(new h.k.b.d(AndroidExceptionPreHandler.class), "preHandler", "getPreHandler()Ljava/lang/reflect/Method;");
      if (l.a != null)
      {
        $$delegatedProperties = new e[] { locali };
        return;
      }
      throw null;
    }
    throw null;
  }
  
  public AndroidExceptionPreHandler()
  {
    super(CoroutineExceptionHandler.d);
  }
  
  private final Method getPreHandler()
  {
    b localb = preHandler$delegate;
    e locale = $$delegatedProperties[0];
    return (Method)localb.getValue();
  }
  
  public void handleException(h.j.d paramd, Throwable paramThrowable)
  {
    Object localObject = null;
    if (paramd != null)
    {
      if (paramThrowable != null)
      {
        Thread localThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28)
        {
          g.a(localThread, "thread");
          localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
        }
        else
        {
          paramd = getPreHandler();
          if (paramd != null) {
            paramd = paramd.invoke(null, new Object[0]);
          } else {
            paramd = null;
          }
          if (!(paramd instanceof Thread.UncaughtExceptionHandler)) {
            paramd = (h.j.d)localObject;
          }
          paramd = (Thread.UncaughtExceptionHandler)paramd;
          if (paramd != null) {
            paramd.uncaughtException(localThread, paramThrowable);
          }
        }
        return;
      }
      g.a("exception");
      throw null;
    }
    g.a("context");
    throw null;
  }
  
  public Method invoke()
  {
    Object localObject1 = null;
    int i = 0;
    try
    {
      Method localMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
      g.a(localMethod, "it");
      int j = i;
      if (Modifier.isPublic(localMethod.getModifiers()))
      {
        boolean bool = Modifier.isStatic(localMethod.getModifiers());
        j = i;
        if (bool) {
          j = 1;
        }
      }
      if (j != 0) {
        localObject1 = localMethod;
      }
    }
    finally
    {
      for (;;) {}
    }
    return (Method)localObject1;
  }
}

/* Location:
 * Qualified Name:     base.kotlinx.coroutines.android.AndroidExceptionPreHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */