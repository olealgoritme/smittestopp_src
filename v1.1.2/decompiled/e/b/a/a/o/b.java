package e.b.a.a.o;

import e.b.a.a.i;
import e.b.a.a.i.a;
import e.b.a.a.k;
import e.b.a.a.l;
import e.b.a.a.q.d;
import java.util.Arrays;

public abstract class b
  extends c
{
  public final e.b.a.a.p.b E;
  public boolean F;
  public int G;
  public int H;
  public long I;
  public int J = 1;
  public int K;
  public int L = 1;
  public int M;
  public d N;
  public l O;
  public final e.b.a.a.s.g P;
  public char[] Q;
  public e.b.a.a.s.c R;
  public byte[] S;
  
  public b(e.b.a.a.p.b paramb, int paramInt)
  {
    super(paramInt);
    E = paramb;
    P = new e.b.a.a.s.g(d);
    if (i.a.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {
      paramb = new e.b.a.a.q.b(this);
    } else {
      paramb = null;
    }
    N = new d(null, paramb, 0, 1, 0);
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    return Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length + paramInt);
  }
  
  public final int a(e.b.a.a.a parama, char paramChar, int paramInt)
  {
    if (paramChar == '\\')
    {
      char c = k();
      if ((c <= ' ') && (paramInt == 0)) {
        return -1;
      }
      paramChar = parama.a(c);
      if (paramChar >= 0) {
        return paramChar;
      }
      throw a(parama, c, paramInt, null);
    }
    throw a(parama, paramChar, paramInt, null);
  }
  
  public final int a(e.b.a.a.a parama, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 92)
    {
      paramInt1 = k();
      if ((paramInt1 <= 32) && (paramInt2 == 0)) {
        return -1;
      }
      int i = parama.a(paramInt1);
      if (i >= 0) {
        return i;
      }
      throw a(parama, paramInt1, paramInt2, null);
    }
    throw a(parama, paramInt1, paramInt2, null);
  }
  
  public final l a(String paramString, double paramDouble)
  {
    e.b.a.a.s.g localg = P;
    b = null;
    c = -1;
    d = 0;
    j = paramString;
    k = null;
    if (f) {
      localg.a();
    }
    i = 0;
    return l.VALUE_NUMBER_FLOAT;
  }
  
  public IllegalArgumentException a(e.b.a.a.a parama, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    if (paramInt1 <= 32)
    {
      parama = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", new Object[] { Integer.toHexString(paramInt1), Integer.valueOf(paramInt2 + 1) });
    }
    else
    {
      if (paramInt1 == C) {
        i = 1;
      }
      if (i != 0)
      {
        localObject = e.a.a.a.a.a("Unexpected padding character ('");
        ((StringBuilder)localObject).append(C);
        ((StringBuilder)localObject).append("') as character #");
        ((StringBuilder)localObject).append(paramInt2 + 1);
        ((StringBuilder)localObject).append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
        parama = ((StringBuilder)localObject).toString();
      }
      else if ((Character.isDefined(paramInt1)) && (!Character.isISOControl(paramInt1)))
      {
        parama = e.a.a.a.a.a("Illegal character '");
        parama.append((char)paramInt1);
        parama.append("' (code 0x");
        parama.append(Integer.toHexString(paramInt1));
        parama.append(") in base64 content");
        parama = parama.toString();
      }
      else
      {
        parama = e.a.a.a.a.a("Illegal character (code 0x");
        parama.append(Integer.toHexString(paramInt1));
        parama.append(") in base64 content");
        parama = parama.toString();
      }
    }
    Object localObject = parama;
    if (paramString != null) {
      localObject = e.a.a.a.a.a(parama, ": ", paramString);
    }
    return new IllegalArgumentException((String)localObject);
  }
  
  public void a(int paramInt, char paramChar)
  {
    d locald = N;
    throw a(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", new Object[] { Character.valueOf((char)paramInt), Character.valueOf(paramChar), locald.e(), new e.b.a.a.g(n(), -1L, g, h) }));
  }
  
  public String c()
  {
    Object localObject = y;
    if ((localObject == l.START_OBJECT) || (localObject == l.START_ARRAY))
    {
      localObject = N.c;
      if (localObject != null) {
        return f;
      }
    }
    return N.f;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 251	e/b/a/a/o/b:F	Z
    //   4: ifne +41 -> 45
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 253	e/b/a/a/o/b:G	I
    //   12: aload_0
    //   13: getfield 255	e/b/a/a/o/b:H	I
    //   16: invokestatic 261	java/lang/Math:max	(II)I
    //   19: putfield 253	e/b/a/a/o/b:G	I
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 251	e/b/a/a/o/b:F	Z
    //   27: aload_0
    //   28: invokevirtual 263	e/b/a/a/o/b:j	()V
    //   31: aload_0
    //   32: invokevirtual 266	e/b/a/a/o/b:o	()V
    //   35: goto +10 -> 45
    //   38: astore_1
    //   39: aload_0
    //   40: invokevirtual 266	e/b/a/a/o/b:o	()V
    //   43: aload_1
    //   44: athrow
    //   45: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	b
    //   38	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	38	finally
  }
  
  public abstract void j();
  
  public abstract char k();
  
  public final int l()
  {
    if (!N.d())
    {
      String str;
      if (N.b()) {
        str = "Array";
      } else {
        str = "Object";
      }
      d locald = N;
      Object localObject = n();
      if (locald != null)
      {
        a(String.format(": expected close marker for %s (start marker at %s)", new Object[] { str, new e.b.a.a.g(localObject, -1L, g, h) }), null);
        throw null;
      }
      throw null;
    }
    return -1;
  }
  
  public e.b.a.a.s.c m()
  {
    e.b.a.a.s.c localc = R;
    if (localc == null) {
      R = new e.b.a.a.s.c(null);
    } else {
      localc.b();
    }
    return R;
  }
  
  public Object n()
  {
    if (i.a.INCLUDE_SOURCE_IN_LOCATION.enabledIn(x)) {
      return E.a;
    }
    return null;
  }
  
  public void o()
  {
    Object localObject1 = P;
    Object localObject2;
    if (a == null)
    {
      ((e.b.a.a.s.g)localObject1).i();
    }
    else if (h != null)
    {
      ((e.b.a.a.s.g)localObject1).i();
      localObject2 = h;
      h = null;
      a.b[2] = localObject2;
    }
    localObject1 = Q;
    if (localObject1 != null)
    {
      Q = null;
      localObject2 = E;
      if (localObject2 != null)
      {
        ((e.b.a.a.p.b)localObject2).a((char[])localObject1, i);
        i = null;
        d.b[3] = localObject1;
      }
      else
      {
        throw null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.o.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */