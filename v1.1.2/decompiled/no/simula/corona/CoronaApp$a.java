package no.simula.corona;

import com.microsoft.appcenter.crashes.Crashes;
import i.k.b.g;
import m.a.a.b;

public final class CoronaApp$a
  extends a.b
{
  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((paramString2 == null) || ((paramInt != 2) && (paramInt != 3))) {}
    try
    {
      Crashes.trackError(paramThrowable);
      return;
      g.a("message");
      throw null;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.CoronaApp.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */