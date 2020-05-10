package l.a.b.a.c;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class e
  implements i0<Object[]>
{
  public final x a;
  public final h b;
  public final j c;
  public final l0 d;
  public final c0 e;
  public final f0 f;
  public final a0 g;
  public final t h;
  public final k i;
  public final b j;
  public final b k;
  
  public e(x paramx, r paramr, h paramh, j paramj, l0 paraml0, c0 paramc0, f0 paramf0, a0 parama0, t paramt, k paramk)
  {
    a = paramx;
    b = paramh;
    c = paramj;
    d = paraml0;
    e = paramc0;
    f = paramf0;
    g = parama0;
    h = paramt;
    i = paramk;
    k = new a(paramx, paramr);
    j = new c(paramx, paramr);
    c.put(Object[].class, this);
    paramr.a(this);
  }
  
  public static int a(Object[] paramArrayOfObject, r0 paramr0)
  {
    int m = paramr0.d();
    int n;
    if (paramr0.e())
    {
      n = paramArrayOfObject.length;
      n = paramr0.a(null) * n + m;
    }
    else
    {
      int i1 = paramArrayOfObject.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        Object localObject1 = paramArrayOfObject[i2];
        if ((localObject1.getClass().isArray()) && (localObject1.getClass().getComponentType().isPrimitive()))
        {
          b localb = (b)paramr0;
          Object localObject2 = (e)localb.getType();
          Object localObject3 = localObject1.getClass().getComponentType();
          int i3 = localb.g();
          if (localObject3 == Boolean.TYPE)
          {
            localObject3 = (boolean[])localObject1;
            localObject2 = ((e)localObject2).b((boolean[])localObject3);
            n = localObject3.length;
          }
          else if (localObject3 == Byte.TYPE)
          {
            localObject3 = (byte[])localObject1;
            localObject2 = c.a;
            n = localObject3.length;
          }
          else if (localObject3 == Short.TYPE)
          {
            localObject3 = (short[])localObject1;
            localObject2 = d.a;
            n = localObject3.length;
          }
          else if (localObject3 == Integer.TYPE)
          {
            localObject3 = (int[])localObject1;
            localObject2 = ((e)localObject2).c((int[])localObject3);
            n = localObject3.length;
          }
          else if (localObject3 == Long.TYPE)
          {
            localObject3 = (long[])localObject1;
            localObject2 = ((e)localObject2).c((long[])localObject3);
            n = localObject3.length;
          }
          else if (localObject3 == Float.TYPE)
          {
            localObject3 = (float[])localObject1;
            localObject2 = g.a;
            n = localObject3.length;
          }
          else if (localObject3 == Double.TYPE)
          {
            localObject3 = (double[])localObject1;
            localObject2 = h.a;
            n = localObject3.length;
          }
          else
          {
            if (localObject3 != Character.TYPE) {
              break label399;
            }
            localObject3 = (char[])localObject1;
            localObject2 = i.a;
            n = localObject3.length;
          }
          int i4 = ((r0)localObject2).d();
          m = ((r0)localObject2).a(null) * n + i4 + (i3 * 2 + m);
          continue;
          label399:
          paramArrayOfObject = e.a.a.a.a.a("Cannot encode arrays of type ");
          paramArrayOfObject.append(((Class)localObject3).getName());
          throw new IllegalArgumentException(paramArrayOfObject.toString());
        }
        else
        {
          m = paramr0.a(localObject1) + m;
        }
      }
      n = m;
    }
    return n;
  }
  
  public static Object[] a(r paramr, q0 paramq0, int paramInt)
  {
    if (paramInt <= paramr.a())
    {
      boolean bool = paramq0 instanceof b;
      int m = 0;
      int n = 0;
      if (bool)
      {
        paramr = (b)paramq0;
        paramq0 = new Object[paramInt];
        while (n < paramInt)
        {
          paramq0[n] = paramr.h();
          n++;
        }
        return paramq0;
      }
      paramr = (Object[])Array.newInstance(paramq0.b(), paramInt);
      for (n = m; n < paramInt; n++) {
        paramr[n] = paramq0.i();
      }
      return paramr;
    }
    paramq0 = e.a.a.a.a.a("Array element count ", paramInt, " is specified to be greater than the amount of data available (");
    paramq0.append(paramr.a());
    paramq0.append(")");
    throw new IllegalArgumentException(paramq0.toString());
  }
  
  public static r0<?> b(Object[] paramArrayOfObject, x paramx)
  {
    if (paramArrayOfObject.length == 0) {
      return paramx.a(paramArrayOfObject.getClass().getComponentType()).e();
    }
    a locala = paramx.a(paramArrayOfObject.getClass().getComponentType());
    int m = 0;
    if ((paramArrayOfObject[0].getClass().isArray()) && (paramArrayOfObject[0].getClass().getComponentType().isPrimitive()))
    {
      paramx = paramArrayOfObject[0].getClass().getComponentType();
      if (paramx == Boolean.TYPE) {
        return ((e)locala).a((boolean[])paramArrayOfObject[0]);
      }
      if (paramx == Byte.TYPE)
      {
        paramx = (e)locala;
        paramArrayOfObject = (byte[])paramArrayOfObject[0];
        if (paramx != null)
        {
          if (paramArrayOfObject.length < 254) {
            paramArrayOfObject = j;
          } else {
            paramArrayOfObject = k;
          }
          return paramArrayOfObject;
        }
        throw null;
      }
      if (paramx == Short.TYPE)
      {
        paramx = (e)locala;
        paramArrayOfObject = (short[])paramArrayOfObject[0];
        if (paramx != null)
        {
          if (paramArrayOfObject.length < 127) {
            paramArrayOfObject = j;
          } else {
            paramArrayOfObject = k;
          }
          return paramArrayOfObject;
        }
        throw null;
      }
      if (paramx == Integer.TYPE) {
        return ((e)locala).b((int[])paramArrayOfObject[0]);
      }
      if (paramx == Long.TYPE) {
        return ((e)locala).b((long[])paramArrayOfObject[0]);
      }
      if (paramx == Float.TYPE)
      {
        paramx = (e)locala;
        paramArrayOfObject = (float[])paramArrayOfObject[0];
        if (paramx != null)
        {
          if (paramArrayOfObject.length < 63) {
            paramArrayOfObject = j;
          } else {
            paramArrayOfObject = k;
          }
          return paramArrayOfObject;
        }
        throw null;
      }
      if (paramx == Double.TYPE)
      {
        paramx = (e)locala;
        paramArrayOfObject = (double[])paramArrayOfObject[0];
        if (paramx != null)
        {
          if (paramArrayOfObject.length < 31) {
            paramArrayOfObject = j;
          } else {
            paramArrayOfObject = k;
          }
          return paramArrayOfObject;
        }
        throw null;
      }
      if (paramx == Character.TYPE)
      {
        paramx = (e)locala;
        paramArrayOfObject = (char[])paramArrayOfObject[0];
        if (paramx != null)
        {
          if (paramArrayOfObject.length < 63) {
            paramArrayOfObject = j;
          } else {
            paramArrayOfObject = k;
          }
          return paramArrayOfObject;
        }
        throw null;
      }
      paramArrayOfObject = e.a.a.a.a.a("Cannot encode arrays of type ");
      paramArrayOfObject.append(paramx.getName());
      throw new IllegalArgumentException(paramArrayOfObject.toString());
    }
    int n;
    if (locala == null)
    {
      locala = paramx.a(paramArrayOfObject[0]);
      n = 1;
    }
    else
    {
      n = 0;
    }
    Object localObject1 = locala.a(paramArrayOfObject[0]);
    r0 localr01 = locala.e();
    while ((m < paramArrayOfObject.length) && ((n != 0) || (localObject1 != localr01)))
    {
      if ((n != 0) && (paramx.a(paramArrayOfObject[m]) != locala))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Non matching types ");
        ((StringBuilder)localObject2).append(locala);
        ((StringBuilder)localObject2).append(" and ");
        ((StringBuilder)localObject2).append(paramx.a(paramArrayOfObject[m]));
        ((StringBuilder)localObject2).append(" in array");
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      }
      r0 localr02 = locala.a(paramArrayOfObject[m]);
      Object localObject2 = localObject1;
      if (localr02 != localObject1)
      {
        localObject2 = localObject1;
        if (!((r0)localObject1).a(localr02)) {
          if (localr02.a((r0)localObject1)) {
            localObject2 = localr02;
          } else {
            localObject2 = localr01;
          }
        }
      }
      m++;
      localObject1 = localObject2;
    }
    return (r0<?>)localObject1;
  }
  
  public b a(Object[] paramArrayOfObject)
  {
    r0 localr0 = b(paramArrayOfObject, a);
    int m = a(paramArrayOfObject, localr0);
    b localb;
    if ((paramArrayOfObject.length <= 255) && (m <= 254)) {
      localb = j;
    } else {
      localb = k;
    }
    localb.a(paramArrayOfObject, localr0, m);
    return localb;
  }
  
  public final b a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean.length >= 254) {
      if (paramArrayOfBoolean.length <= 255)
      {
        int m = 0;
        int n = paramArrayOfBoolean[0];
        for (int i1 = 1; i1 < paramArrayOfBoolean.length; i1++) {
          if (n != paramArrayOfBoolean[i1])
          {
            i1 = m;
            break label55;
          }
        }
        i1 = 1;
        label55:
        if (i1 != 0) {}
      }
      else
      {
        return k;
      }
    }
    paramArrayOfBoolean = j;
    return paramArrayOfBoolean;
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    int m = 0;
    while (m < paramArrayOfInt.length) {
      if ((paramArrayOfInt[m] >= -128) && (paramArrayOfInt[m] <= 127)) {
        m++;
      } else {
        return false;
      }
    }
    return true;
  }
  
  public final boolean a(long[] paramArrayOfLong)
  {
    int m = 0;
    while (m < paramArrayOfLong.length) {
      if ((paramArrayOfLong[m] >= -128L) && (paramArrayOfLong[m] <= 127L)) {
        m++;
      } else {
        return false;
      }
    }
    return true;
  }
  
  public Class<Object[]> b()
  {
    return Object[].class;
  }
  
  public final b b(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt.length >= 63) && ((paramArrayOfInt.length >= 254) || (!a(paramArrayOfInt)))) {
      paramArrayOfInt = k;
    } else {
      paramArrayOfInt = j;
    }
    return paramArrayOfInt;
  }
  
  public final b b(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong.length >= 31) && ((paramArrayOfLong.length >= 254) || (!a(paramArrayOfLong)))) {
      paramArrayOfLong = k;
    } else {
      paramArrayOfLong = j;
    }
    return paramArrayOfLong;
  }
  
  public final h.b b(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean.length == 0) {
      return b.c;
    }
    int m = paramArrayOfBoolean[0];
    for (int n = 1; n < paramArrayOfBoolean.length; n++) {
      if (m != paramArrayOfBoolean[n]) {
        return b.c;
      }
    }
    paramArrayOfBoolean = b;
    if (m != 0) {
      paramArrayOfBoolean = a;
    } else {
      paramArrayOfBoolean = b;
    }
    return paramArrayOfBoolean;
  }
  
  public final c0.b c(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt.length != 0) && (a(paramArrayOfInt)))
    {
      c0 localc0 = e;
      int m = paramArrayOfInt[0];
      if ((m >= -128) && (m <= 127)) {
        paramArrayOfInt = b;
      } else {
        paramArrayOfInt = a;
      }
      return paramArrayOfInt;
    }
    return e.a;
  }
  
  public final f0.b c(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong.length != 0) && (a(paramArrayOfLong)))
    {
      f0 localf0 = f;
      long l = paramArrayOfLong[0];
      if ((l >= -128L) && (l <= 127L)) {
        paramArrayOfLong = b;
      } else {
        paramArrayOfLong = a;
      }
      return paramArrayOfLong;
    }
    return f.a;
  }
  
  public void c(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    b localb = a((Object[])paramObject);
    localb.c();
    localb.b(paramObject);
  }
  
  public r0 e()
  {
    return k;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { j, k });
  }
  
  public class a
    extends d0<Object[]>
    implements e.b
  {
    public Object[] c;
    public r0 d;
    public int e;
    
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public int a(Object[] paramArrayOfObject)
    {
      if (c != paramArrayOfObject)
      {
        c = paramArrayOfObject;
        r0 localr0 = e.a(paramArrayOfObject, a);
        d = localr0;
        e = e.a(paramArrayOfObject, localr0);
      }
      return e + 4;
    }
    
    public void a(byte[] paramArrayOfByte)
    {
      j.a locala = c.a;
      if (locala != null)
      {
        int i = paramArrayOfByte.length * 1 + 5;
        a.a.b(i);
        a.a.c(i);
        x localx = a;
        i = paramArrayOfByte.length;
        a.c(i);
        locala.c();
        int j = paramArrayOfByte.length;
        for (i = 0; i < j; i++)
        {
          byte b = paramArrayOfByte[i];
          a.a.a(b);
        }
        return;
      }
      throw null;
    }
    
    public void a(char[] paramArrayOfChar)
    {
      k.a locala = ia;
      if (locala != null)
      {
        int i = paramArrayOfChar.length * 4 + 5;
        a.a.b(i);
        a.a.c(i);
        x localx = a;
        i = paramArrayOfChar.length;
        a.c(i);
        locala.c();
        int j = paramArrayOfChar.length;
        for (i = 0; i < j; i++)
        {
          int k = paramArrayOfChar[i];
          a.a.c(k & 0xFFFF);
        }
        return;
      }
      throw null;
    }
    
    public void a(double[] paramArrayOfDouble)
    {
      t.a locala = h.a;
      if (locala != null)
      {
        int i = paramArrayOfDouble.length * 8 + 5;
        a.a.b(i);
        a.a.c(i);
        x localx = a;
        i = paramArrayOfDouble.length;
        a.c(i);
        locala.c();
        int j = paramArrayOfDouble.length;
        for (i = 0; i < j; i++)
        {
          double d1 = paramArrayOfDouble[i];
          a.a.a(d1);
        }
        return;
      }
      throw null;
    }
    
    public void a(float[] paramArrayOfFloat)
    {
      a0.a locala = g.a;
      if (locala != null)
      {
        int i = paramArrayOfFloat.length * 4 + 5;
        a.a.b(i);
        a.a.c(i);
        x localx = a;
        i = paramArrayOfFloat.length;
        a.c(i);
        locala.c();
        int j = paramArrayOfFloat.length;
        for (i = 0; i < j; i++)
        {
          float f1 = paramArrayOfFloat[i];
          a.a.a(f1);
        }
        return;
      }
      throw null;
    }
    
    public void a(int[] paramArrayOfInt)
    {
      c0.b localb = c(paramArrayOfInt);
      int i = localb.d();
      int j = paramArrayOfInt.length;
      i = localb.a(null) * j + (i + 4);
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfInt.length;
      a.c(i);
      localb.c();
      j = paramArrayOfInt.length;
      for (i = 0; i < j; i++) {
        localb.a(paramArrayOfInt[i]);
      }
    }
    
    public void a(long[] paramArrayOfLong)
    {
      f0.b localb = c(paramArrayOfLong);
      int i = localb.d();
      int j = paramArrayOfLong.length;
      i = localb.a(null) * j + (i + 4);
      a.a.b(i);
      a.a.c(i);
      x localx = a;
      i = paramArrayOfLong.length;
      a.c(i);
      localb.c();
      j = paramArrayOfLong.length;
      for (i = 0; i < j; i++) {
        localb.a(paramArrayOfLong[i]);
      }
    }
    
    public void a(Object[] paramArrayOfObject, r0 paramr0, int paramInt)
    {
      c = paramArrayOfObject;
      d = paramr0;
      e = paramInt;
    }
    
    public void a(short[] paramArrayOfShort)
    {
      l0.a locala = d.a;
      if (locala != null)
      {
        int i = paramArrayOfShort.length * 2 + 5;
        a.a.b(i);
        a.a.c(i);
        x localx = a;
        i = paramArrayOfShort.length;
        a.c(i);
        locala.c();
        int j = paramArrayOfShort.length;
        for (i = 0; i < j; i++)
        {
          short s = paramArrayOfShort[i];
          a.a.a(s);
        }
        return;
      }
      throw null;
    }
    
    public void a(boolean[] paramArrayOfBoolean)
    {
      h.b localb = b(paramArrayOfBoolean);
      int i = localb.d();
      int j = paramArrayOfBoolean.length;
      j = localb.a(null) * j + (i + 4);
      a.a.b(j);
      a.a.c(j);
      x localx = a;
      j = paramArrayOfBoolean.length;
      a.c(j);
      localb.c();
      i = paramArrayOfBoolean.length;
      for (j = 0; j < i; j++) {
        localb.a(paramArrayOfBoolean[j]);
      }
    }
    
    public boolean a(r0<Object[]> paramr0)
    {
      boolean bool;
      if (e.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void d(Object paramObject)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (c != arrayOfObject)
      {
        c = arrayOfObject;
        paramObject = e.b(arrayOfObject, a);
        d = ((r0)paramObject);
        e = e.a(arrayOfObject, (r0)paramObject);
      }
      else
      {
        paramObject = d;
      }
      x localx = a;
      int i = arrayOfObject.length;
      a.c(i);
      ((r0)paramObject).c();
      int j = arrayOfObject.length;
      for (i = 0; i < j; i++) {
        ((r0)paramObject).b(arrayOfObject[i]);
      }
    }
    
    public void e(Object paramObject)
    {
      int i = a((Object[])paramObject);
      a.a.b(i);
      a.a.c(i);
    }
    
    public byte f()
    {
      return -16;
    }
    
    public a getType()
    {
      return e.this;
    }
    
    public i0 getType()
    {
      return e.this;
    }
    
    public Object h()
    {
      r localr = b;
      localr.f();
      return e.a(localr, localr.f());
    }
    
    public Object i()
    {
      r localr = b;
      localr.f();
      int i = localr.f();
      return e.a(localr, localr.b(true), i);
    }
  }
  
  public static abstract interface b
    extends j0<Object[]>
  {
    public abstract void a(byte[] paramArrayOfByte);
    
    public abstract void a(char[] paramArrayOfChar);
    
    public abstract void a(double[] paramArrayOfDouble);
    
    public abstract void a(float[] paramArrayOfFloat);
    
    public abstract void a(int[] paramArrayOfInt);
    
    public abstract void a(long[] paramArrayOfLong);
    
    public abstract void a(Object[] paramArrayOfObject, r0<?> paramr0, int paramInt);
    
    public abstract void a(short[] paramArrayOfShort);
    
    public abstract void a(boolean[] paramArrayOfBoolean);
    
    public abstract int g();
    
    public abstract Object h();
  }
  
  public class c
    extends m0<Object[]>
    implements e.b
  {
    public Object[] c;
    public r0 d;
    public int e;
    
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public int a(Object[] paramArrayOfObject)
    {
      if (c != paramArrayOfObject)
      {
        c = paramArrayOfObject;
        r0 localr0 = e.a(paramArrayOfObject, a);
        d = localr0;
        e = e.a(paramArrayOfObject, localr0);
      }
      return e + 1;
    }
    
    public void a(byte[] paramArrayOfByte)
    {
      j.a locala = c.a;
      if (locala != null)
      {
        int i = paramArrayOfByte.length * 1 + 2;
        a.a.b(i);
        x localx = a;
        byte b = (byte)i;
        a.a(b);
        localx = a;
        b = (byte)paramArrayOfByte.length;
        a.a(b);
        locala.c();
        int j = paramArrayOfByte.length;
        for (i = 0; i < j; i++)
        {
          b = paramArrayOfByte[i];
          a.a.a(b);
        }
        return;
      }
      throw null;
    }
    
    public void a(char[] paramArrayOfChar)
    {
      k.a locala = ia;
      if (locala != null)
      {
        int i = paramArrayOfChar.length * 4 + 2;
        a.a.b(i);
        x localx = a;
        byte b = (byte)i;
        a.a(b);
        localx = a;
        b = (byte)paramArrayOfChar.length;
        a.a(b);
        locala.c();
        int j = paramArrayOfChar.length;
        for (i = 0; i < j; i++)
        {
          int k = paramArrayOfChar[i];
          a.a.c(k & 0xFFFF);
        }
        return;
      }
      throw null;
    }
    
    public void a(double[] paramArrayOfDouble)
    {
      t.a locala = h.a;
      if (locala != null)
      {
        int i = paramArrayOfDouble.length * 8 + 2;
        a.a.b(i);
        x localx = a;
        byte b = (byte)i;
        a.a(b);
        localx = a;
        b = (byte)paramArrayOfDouble.length;
        a.a(b);
        locala.c();
        int j = paramArrayOfDouble.length;
        for (i = 0; i < j; i++)
        {
          double d1 = paramArrayOfDouble[i];
          a.a.a(d1);
        }
        return;
      }
      throw null;
    }
    
    public void a(float[] paramArrayOfFloat)
    {
      a0.a locala = g.a;
      if (locala != null)
      {
        int i = paramArrayOfFloat.length * 4 + 2;
        a.a.b(i);
        x localx = a;
        byte b = (byte)i;
        a.a(b);
        localx = a;
        b = (byte)paramArrayOfFloat.length;
        a.a(b);
        locala.c();
        int j = paramArrayOfFloat.length;
        for (i = 0; i < j; i++)
        {
          float f1 = paramArrayOfFloat[i];
          a.a.a(f1);
        }
        return;
      }
      throw null;
    }
    
    public void a(int[] paramArrayOfInt)
    {
      c0.b localb = c(paramArrayOfInt);
      int i = localb.d();
      int j = paramArrayOfInt.length;
      j = localb.a(null) * j + (i + 1);
      a.a.b(j);
      x localx = a;
      byte b = (byte)j;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfInt.length;
      a.a(b);
      localb.c();
      i = paramArrayOfInt.length;
      for (j = 0; j < i; j++) {
        localb.a(paramArrayOfInt[j]);
      }
    }
    
    public void a(long[] paramArrayOfLong)
    {
      f0.b localb = c(paramArrayOfLong);
      int i = localb.d();
      int j = paramArrayOfLong.length;
      i = localb.a(null) * j + (i + 1);
      a.a.b(i);
      x localx = a;
      byte b = (byte)i;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfLong.length;
      a.a(b);
      localb.c();
      j = paramArrayOfLong.length;
      for (i = 0; i < j; i++) {
        localb.a(paramArrayOfLong[i]);
      }
    }
    
    public void a(Object[] paramArrayOfObject, r0 paramr0, int paramInt)
    {
      c = paramArrayOfObject;
      d = paramr0;
      e = paramInt;
    }
    
    public void a(short[] paramArrayOfShort)
    {
      l0.a locala = d.a;
      if (locala != null)
      {
        int i = paramArrayOfShort.length * 2 + 2;
        a.a.b(i);
        x localx = a;
        byte b = (byte)i;
        a.a(b);
        localx = a;
        b = (byte)paramArrayOfShort.length;
        a.a(b);
        locala.c();
        int j = paramArrayOfShort.length;
        for (i = 0; i < j; i++)
        {
          short s = paramArrayOfShort[i];
          a.a.a(s);
        }
        return;
      }
      throw null;
    }
    
    public void a(boolean[] paramArrayOfBoolean)
    {
      h.b localb = b(paramArrayOfBoolean);
      int i = localb.d();
      int j = paramArrayOfBoolean.length;
      j = localb.a(null) * j + (i + 1);
      a.a.b(j);
      x localx = a;
      byte b = (byte)j;
      a.a(b);
      localx = a;
      b = (byte)paramArrayOfBoolean.length;
      a.a(b);
      localb.c();
      i = paramArrayOfBoolean.length;
      for (j = 0; j < i; j++) {
        localb.a(paramArrayOfBoolean[j]);
      }
    }
    
    public boolean a(r0<Object[]> paramr0)
    {
      boolean bool;
      if (e.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void d(Object paramObject)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (c != arrayOfObject)
      {
        c = arrayOfObject;
        paramObject = e.b(arrayOfObject, a);
        d = ((r0)paramObject);
        e = e.a(arrayOfObject, (r0)paramObject);
      }
      else
      {
        paramObject = d;
      }
      Object localObject1 = a;
      byte b = (byte)arrayOfObject.length;
      a.a(b);
      ((r0)paramObject).c();
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
      {
        localObject1 = arrayOfObject[j];
        if ((localObject1.getClass().isArray()) && (localObject1.getClass().getComponentType().isPrimitive()))
        {
          e.b localb = (e.b)paramObject;
          Object localObject2 = (e)localb.getType();
          localObject2 = localObject1.getClass().getComponentType();
          if (localObject2 == Boolean.TYPE)
          {
            localb.a((boolean[])localObject1);
          }
          else if (localObject2 == Byte.TYPE)
          {
            localb.a((byte[])localObject1);
          }
          else if (localObject2 == Short.TYPE)
          {
            localb.a((short[])localObject1);
          }
          else if (localObject2 == Integer.TYPE)
          {
            localb.a((int[])localObject1);
          }
          else if (localObject2 == Long.TYPE)
          {
            localb.a((long[])localObject1);
          }
          else if (localObject2 == Float.TYPE)
          {
            localb.a((float[])localObject1);
          }
          else if (localObject2 == Double.TYPE)
          {
            localb.a((double[])localObject1);
          }
          else if (localObject2 == Character.TYPE)
          {
            localb.a((char[])localObject1);
          }
          else
          {
            paramObject = e.a.a.a.a.a("Cannot encode arrays of type ");
            ((StringBuilder)paramObject).append(((Class)localObject2).getName());
            throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
          }
        }
        else
        {
          ((r0)paramObject).b(localObject1);
        }
      }
    }
    
    public void e(Object paramObject)
    {
      int i = a((Object[])paramObject);
      a.a.b(i);
      paramObject = a;
      byte b = (byte)i;
      a.a(b);
    }
    
    public byte f()
    {
      return -32;
    }
    
    public a getType()
    {
      return e.this;
    }
    
    public i0 getType()
    {
      return e.this;
    }
    
    public Object h()
    {
      r localr = b;
      localr.e();
      return e.a(localr, localr.e() & 0xFF);
    }
    
    public Object i()
    {
      r localr = b;
      localr.e();
      int i = localr.e();
      return e.a(localr, localr.b(true), i & 0xFF);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */