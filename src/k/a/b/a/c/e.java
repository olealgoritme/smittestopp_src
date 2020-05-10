package k.a.b.a.c;

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
  public final e.b j;
  public final e.b k;
  
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
    k = new e.a(this, paramx, paramr);
    j = new e.c(this, paramx, paramr);
    c.put(Object[].class, this);
    paramr.a(this);
  }
  
  public static int a(Object[] paramArrayOfObject, r0 paramr0)
  {
    int m = paramr0.d();
    int n;
    if (paramr0.f())
    {
      n = paramArrayOfObject.length;
      n = paramr0.b(null) * n + m;
    }
    else
    {
      int i1 = paramArrayOfObject.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        Object localObject1 = paramArrayOfObject[i2];
        if ((localObject1.getClass().isArray()) && (localObject1.getClass().getComponentType().isPrimitive()))
        {
          e.b localb = (e.b)paramr0;
          Object localObject2 = (e)localb.getType();
          Object localObject3 = localObject1.getClass().getComponentType();
          int i3 = localb.h();
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
          m = ((r0)localObject2).b(null) * n + i4 + (i3 * 2 + m);
          continue;
          label399:
          paramArrayOfObject = e.a.a.a.a.a("Cannot encode arrays of type ");
          paramArrayOfObject.append(((Class)localObject3).getName());
          throw new IllegalArgumentException(paramArrayOfObject.toString());
        }
        else
        {
          m = paramr0.b(localObject1) + m;
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
      boolean bool = paramq0 instanceof e.b;
      int m = 0;
      int n = 0;
      if (bool)
      {
        paramr = (e.b)paramq0;
        paramq0 = new Object[paramInt];
        while (n < paramInt)
        {
          paramq0[n] = paramr.j();
          n++;
        }
        return paramq0;
      }
      paramr = (Object[])Array.newInstance(paramq0.a(), paramInt);
      for (n = m; n < paramInt; n++) {
        paramr[n] = paramq0.k();
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
      return paramx.a(paramArrayOfObject.getClass().getComponentType()).f();
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
    r0 localr01 = locala.f();
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
  
  public Class<Object[]> a()
  {
    return Object[].class;
  }
  
  public e.b a(Object[] paramArrayOfObject)
  {
    r0 localr0 = b(paramArrayOfObject, a);
    int m = a(paramArrayOfObject, localr0);
    e.b localb;
    if ((paramArrayOfObject.length <= 255) && (m <= 254)) {
      localb = j;
    } else {
      localb = k;
    }
    localb.a(paramArrayOfObject, localr0, m);
    return localb;
  }
  
  public final e.b a(boolean[] paramArrayOfBoolean)
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
  
  public final e.b b(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt.length >= 63) && ((paramArrayOfInt.length >= 254) || (!a(paramArrayOfInt)))) {
      paramArrayOfInt = k;
    } else {
      paramArrayOfInt = j;
    }
    return paramArrayOfInt;
  }
  
  public final e.b b(long[] paramArrayOfLong)
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
    Object[] arrayOfObject = (Object[])paramObject;
    paramObject = a(arrayOfObject);
    ((j0)paramObject).c();
    ((r0)paramObject).a(arrayOfObject);
  }
  
  public r0 f()
  {
    return k;
  }
  
  public Collection<e.b> i()
  {
    return Arrays.asList(new e.b[] { j, k });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */