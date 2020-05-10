package h.c.m;

import h.c.c;
import h.c.i;
import h.c.j;

public class d
  extends h.c.f
{
  public final String a;
  public final Throwable b;
  
  public d(String paramString, Throwable paramThrowable)
  {
    a = paramString;
    b = paramThrowable;
  }
  
  public int a()
  {
    c();
    throw null;
  }
  
  public i a(c paramc)
  {
    c();
    throw null;
  }
  
  public i a(j paramj)
  {
    c();
    throw null;
  }
  
  public f b()
  {
    c();
    throw null;
  }
  
  public final UnsatisfiedLinkError c()
  {
    UnsatisfiedLinkError localUnsatisfiedLinkError = new UnsatisfiedLinkError(a);
    localUnsatisfiedLinkError.initCause(b);
    throw localUnsatisfiedLinkError;
  }
}

/* Location:
 * Qualified Name:     h.c.m.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */