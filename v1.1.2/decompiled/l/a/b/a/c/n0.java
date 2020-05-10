package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class n0
  extends c<String>
{
  public static final r.b<String> c = new a();
  public final d a;
  public final d b;
  
  public n0(x paramx, r paramr)
  {
    a = new b(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(String.class, this);
    paramr.a(this);
  }
  
  public static int a(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; (j < i) && (paramString.charAt(j) < ''); j++) {}
    int k = i;
    if (j < i)
    {
      for (int m = i; j < i; m = k)
      {
        int n = paramString.charAt(j);
        int i1 = j;
        k = m;
        if ((0xFF80 & n) != 0)
        {
          m++;
          i1 = j;
          k = m;
          if ((0xF800 & n) != 0)
          {
            m++;
            i1 = j;
            k = m;
            if ((n & 0xD800) == 55296)
            {
              i1 = j;
              k = m;
              if (n < 56320)
              {
                i1 = j + 1;
                k = m;
              }
            }
          }
        }
        j = i1 + 1;
      }
      k = m;
    }
    return k;
  }
  
  public j0 a(Object paramObject)
  {
    String str = (String)paramObject;
    int i = a(str);
    if (i <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    ((d)paramObject).a(str, i);
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    String str = (String)paramObject;
    int i = a(str);
    if (i <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    ((d)paramObject).a(str, i);
    return (r0)paramObject;
  }
  
  public Class<String> b()
  {
    return String.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<d> k()
  {
    return Arrays.asList(new d[] { b, a });
  }
  
  public static final class a
    implements r.b<String>
  {
    /* Error */
    public Object a(r paramr, k0 paramk0)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 24	l/a/b/a/c/r:b	Ljava/nio/charset/CharsetDecoder;
      //   4: astore_1
      //   5: aload_2
      //   6: aload_1
      //   7: invokeinterface 29 2 0
      //   12: astore_2
      //   13: aload_1
      //   14: invokevirtual 35	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
      //   17: pop
      //   18: aload_2
      //   19: areturn
      //   20: astore_2
      //   21: goto +16 -> 37
      //   24: astore_2
      //   25: new 37	java/lang/IllegalArgumentException
      //   28: astore_2
      //   29: aload_2
      //   30: ldc 39
      //   32: invokespecial 42	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   35: aload_2
      //   36: athrow
      //   37: aload_1
      //   38: invokevirtual 35	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
      //   41: pop
      //   42: aload_2
      //   43: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	44	0	this	a
      //   0	44	1	paramr	r
      //   0	44	2	paramk0	k0
      // Exception table:
      //   from	to	target	type
      //   5	13	20	finally
      //   25	37	20	finally
      //   5	13	24	java/nio/charset/CharacterCodingException
    }
  }
  
  public class b
    extends d0<String>
    implements n0.d
  {
    public String c;
    public int d;
    
    public b(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(String paramString, int paramInt)
    {
      c = paramString;
      d = paramInt;
    }
    
    public boolean a(r0<String> paramr0)
    {
      boolean bool;
      if (n0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      paramObject = (String)paramObject;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = n0.a((String)paramObject);
      }
      return i;
    }
    
    public void d(Object paramObject)
    {
      paramObject = (String)paramObject;
      y0 localy0 = a.a;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = n0.a((String)paramObject);
      }
      localy0.b(i);
      a.a.a((String)paramObject);
    }
    
    public byte f()
    {
      return -79;
    }
    
    public a getType()
    {
      return n0.this;
    }
    
    public i0 getType()
    {
      return n0.this;
    }
    
    public Object i()
    {
      Object localObject = b;
      int i = ((r)localObject).f();
      if (i == 0) {
        localObject = "";
      } else {
        localObject = (String)((r)localObject).a(n0.c, i);
      }
      return localObject;
    }
  }
  
  public class c
    extends m0<String>
    implements n0.d
  {
    public String c;
    public int d;
    
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(String paramString, int paramInt)
    {
      c = paramString;
      d = paramInt;
    }
    
    public boolean a(r0<String> paramr0)
    {
      boolean bool;
      if (paramr0 == this) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      paramObject = (String)paramObject;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = n0.a((String)paramObject);
      }
      return i;
    }
    
    public void d(Object paramObject)
    {
      String str = (String)paramObject;
      paramObject = a.a;
      int i;
      if (str == c) {
        i = d;
      } else {
        i = n0.a(str);
      }
      ((y0)paramObject).b(i);
      a.a.a(str);
    }
    
    public byte f()
    {
      return -95;
    }
    
    public a getType()
    {
      return n0.this;
    }
    
    public i0 getType()
    {
      return n0.this;
    }
    
    public Object i()
    {
      Object localObject = b;
      int i = ((r)localObject).e() & 0xFF;
      if (i == 0) {
        localObject = "";
      } else {
        localObject = (String)((r)localObject).a(n0.c, i);
      }
      return localObject;
    }
  }
  
  public static abstract interface d
    extends j0<String>
  {
    public abstract void a(String paramString, int paramInt);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.n0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */