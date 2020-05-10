package e.b.a.a.p;

import e.b.a.a.c;
import e.b.a.a.s.a;

public class b
{
  public final Object a;
  public c b;
  public final boolean c;
  public final a d;
  public byte[] e;
  public byte[] f;
  public char[] g;
  public char[] h;
  public char[] i;
  
  public b(a parama, Object paramObject, boolean paramBoolean)
  {
    d = parama;
    a = paramObject;
    c = paramBoolean;
  }
  
  public final void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    throw new IllegalStateException("Trying to call same allocXxx() method second time");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = e;
      if ((paramArrayOfByte != arrayOfByte) && (paramArrayOfByte.length < arrayOfByte.length)) {
        throw new IllegalArgumentException("Trying to release buffer smaller than original");
      }
      e = null;
      d.a[0] = paramArrayOfByte;
    }
  }
  
  public final void a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if ((paramArrayOfChar1 != paramArrayOfChar2) && (paramArrayOfChar1.length < paramArrayOfChar2.length)) {
      throw new IllegalArgumentException("Trying to release buffer smaller than original");
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = f;
      if ((paramArrayOfByte != arrayOfByte) && (paramArrayOfByte.length < arrayOfByte.length)) {
        throw new IllegalArgumentException("Trying to release buffer smaller than original");
      }
      f = null;
      d.a[1] = paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.p.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */