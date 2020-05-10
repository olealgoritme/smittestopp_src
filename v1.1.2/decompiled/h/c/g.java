package h.c;

import java.nio.charset.Charset;

public abstract class g
{
  public static final Charset b = Charset.forName("UTF-8");
  public final c a;
  
  static
  {
    Charset.forName("ASCII");
  }
  
  public g(f paramf)
  {
    a = new c(paramf);
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: new 78	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 83	java/lang/Object:getClass	()Ljava/lang/Class;
    //   12: invokevirtual 89	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   15: astore_2
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 83	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: invokevirtual 92	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   24: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 98
    //   31: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: arraylength
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: iload_3
    //   44: if_icmpge +72 -> 116
    //   47: aload_2
    //   48: iload 4
    //   50: aaload
    //   51: astore 5
    //   53: aload_1
    //   54: ldc 100
    //   56: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: aload 5
    //   63: invokevirtual 105	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   66: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: ldc 107
    //   73: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: aload 5
    //   80: aload_0
    //   81: invokevirtual 111	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokevirtual 113	java/lang/Object:toString	()Ljava/lang/String;
    //   87: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: ldc 115
    //   94: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: iinc 4 1
    //   101: goto -60 -> 41
    //   104: astore 5
    //   106: new 117	java/lang/RuntimeException
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: aload_1
    //   117: ldc 122
    //   119: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	g
    //   7	117	1	localStringBuilder	StringBuilder
    //   15	33	2	arrayOfField	java.lang.reflect.Field[]
    //   37	8	3	i	int
    //   39	60	4	j	int
    //   51	28	5	localField	java.lang.reflect.Field
    //   104	7	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	98	104	finally
  }
  
  public abstract class a
    extends g.e
  {
    public final int a;
    
    public a(int paramInt1, int paramInt2)
    {
      super();
      a = a.a(paramInt1, paramInt2);
    }
    
    public final void a()
    {
      a.a(16);
    }
    
    public final long b()
    {
      int i = a;
      return a.a() + i;
    }
  }
  
  public static final class b
    extends Number
  {
    public final int x;
    
    public b(int paramInt)
    {
      x = paramInt;
    }
    
    public double doubleValue()
    {
      return x;
    }
    
    public float floatValue()
    {
      return x;
    }
    
    public int intValue()
    {
      return x;
    }
    
    public long longValue()
    {
      return x;
    }
  }
  
  public static final class c
  {
    public final f a;
    public e b = null;
    public g c = null;
    public int d = 0;
    public int e = 0;
    public int f = 1;
    public boolean g = false;
    public g.b h = new g.b(0);
    
    public c(f paramf)
    {
      a = paramf;
    }
    
    public final int a()
    {
      g localg = c;
      int i;
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        i = d;
        i = a.a() + i;
      }
      return i;
    }
    
    public final int a(int paramInt1, int paramInt2)
    {
      int i = h.x;
      int j = paramInt2 >> 3;
      paramInt2 = j;
      if (i > 0) {
        paramInt2 = Math.min(i, j);
      }
      if (g) {
        j = 0;
      } else {
        j = e + paramInt2 - 1 & paramInt2 - 1;
      }
      e = Math.max(e, (paramInt1 >> 3) + j);
      f = Math.max(f, paramInt2);
      return j;
    }
    
    public final void a(int paramInt)
    {
      g localg = c;
      if (localg != null)
      {
        a.a(paramInt);
      }
      else
      {
        if ((paramInt & 0x20) != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0) {
          a.b().a(b(), true);
        } else {
          a.b().a(b());
        }
        b = null;
      }
    }
    
    public final int b()
    {
      int i;
      if (h.x > 0)
      {
        i = e;
        i += (-i & f - 1);
      }
      else
      {
        i = e;
      }
      return i;
    }
  }
  
  public abstract class d
    extends g.f
  {
    public d(j paramj)
    {
      super(paramj);
    }
    
    public void a(Number paramNumber)
    {
      a();
      c();
      paramNumber.longValue();
      throw null;
    }
    
    public int b()
    {
      a();
      c();
      throw null;
    }
    
    public final String toString()
    {
      a();
      c();
      throw null;
    }
  }
  
  public abstract class e
  {
    public e() {}
  }
  
  public abstract class f
    extends g.e
  {
    public final int a;
    public final i b;
    
    public f(c paramc)
    {
      super();
      paramc = a.a.a(paramc);
      b = paramc;
      this$1 = a;
      paramc = (h)paramc;
      a = a(f * 8, e * 8);
    }
    
    public f(j paramj)
    {
      super();
      paramj = a.a.a(paramj);
      b = paramj;
      this$1 = a;
      paramj = (h)paramj;
      a = a(f * 8, e * 8);
    }
    
    public final void a()
    {
      a.a(16);
    }
    
    public abstract void a(Number paramNumber);
    
    public abstract int b();
    
    public final long c()
    {
      int i = a;
      return a.a() + i;
    }
    
    public String toString()
    {
      return Integer.toString(b(), 10);
    }
  }
  
  public class g
    extends g.f
  {
    public g()
    {
      super(c.SLONG);
    }
    
    public final void a(long paramLong)
    {
      a();
      c();
      throw null;
    }
    
    public void a(Number paramNumber)
    {
      a();
      c();
      paramNumber.longValue();
      throw null;
    }
    
    public final int b()
    {
      a();
      c();
      throw null;
    }
    
    public final String toString()
    {
      a();
      c();
      throw null;
    }
  }
  
  public abstract class h
    extends g.a
  {
    public final Charset c;
    public final int d;
    
    public h(int paramInt1, int paramInt2, int paramInt3, Charset paramCharset)
    {
      super(paramInt1, paramInt2);
      d = paramInt3;
      c = paramCharset;
    }
    
    public abstract String c();
    
    public final String toString()
    {
      c();
      throw null;
    }
  }
  
  public class i
    extends g.j
  {
    public i(int paramInt)
    {
      super(paramInt, g.b);
    }
  }
  
  public class j
    extends g.h
  {
    public j(int paramInt, Charset paramCharset)
    {
      super(paramInt * 8, 8, paramInt, paramCharset);
    }
    
    public final String c()
    {
      a();
      b();
      throw null;
    }
  }
  
  public class k
    extends g.f
  {
    public k()
    {
      super(c.USHORT);
    }
    
    public void a(Number paramNumber)
    {
      a();
      c();
      paramNumber.shortValue();
      throw null;
    }
    
    public final int b()
    {
      a();
      c();
      throw null;
    }
  }
  
  public class l
    extends g.f
  {
    public l()
    {
      super(c.UCHAR);
    }
    
    public void a(Number paramNumber)
    {
      a();
      c();
      paramNumber.byteValue();
      throw null;
    }
    
    public final int b()
    {
      a();
      c();
      throw null;
    }
  }
  
  public final class m
    extends g.d
  {
    public m()
    {
      super(j.gid_t);
    }
  }
  
  public final class n
    extends g.d
  {
    public n()
    {
      super(j.pid_t);
    }
  }
  
  public final class o
    extends g.d
  {
    public o()
    {
      super(j.uid_t);
    }
  }
}

/* Location:
 * Qualified Name:     h.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */