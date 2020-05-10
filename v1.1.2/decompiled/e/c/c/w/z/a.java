package e.c.c.w.z;

import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import e.c.c.y.b;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends e.c.c.y.a
{
  public static final Reader R = new a();
  public static final Object S = new Object();
  public Object[] N = new Object[32];
  public int O = 0;
  public String[] P = new String[32];
  public int[] Q = new int[32];
  
  public a(j paramj)
  {
    super(R);
    a(paramj);
  }
  
  private String i()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a(" at path ");
    localStringBuilder.append(g());
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    a(b.BEGIN_ARRAY);
    a(((g)v()).iterator());
    Q[(O - 1)] = 0;
  }
  
  public final void a(b paramb)
  {
    if (r() == paramb) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ");
    localStringBuilder.append(paramb);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(r());
    localStringBuilder.append(i());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final void a(Object paramObject)
  {
    int i = O;
    Object[] arrayOfObject1 = N;
    if (i == arrayOfObject1.length)
    {
      arrayOfObject2 = new Object[i * 2];
      int[] arrayOfInt = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      System.arraycopy(Q, 0, arrayOfInt, 0, O);
      System.arraycopy(P, 0, arrayOfString, 0, O);
      N = arrayOfObject2;
      Q = arrayOfInt;
      P = arrayOfString;
    }
    Object[] arrayOfObject2 = N;
    i = O;
    O = (i + 1);
    arrayOfObject2[i] = paramObject;
  }
  
  public void b()
  {
    a(b.BEGIN_OBJECT);
    a(((m)v()).g().iterator());
  }
  
  public void close()
  {
    N = new Object[] { S };
    O = 1;
  }
  
  public void e()
  {
    a(b.END_ARRAY);
    w();
    w();
    int i = O;
    if (i > 0)
    {
      int[] arrayOfInt = Q;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public void f()
  {
    a(b.END_OBJECT);
    w();
    w();
    int i = O;
    if (i > 0)
    {
      int[] arrayOfInt = Q;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int j;
    for (int i = 0; i < O; i = j + 1)
    {
      Object localObject = N;
      if ((localObject[i] instanceof g))
      {
        i++;
        j = i;
        if ((localObject[i] instanceof Iterator))
        {
          localStringBuilder.append('[');
          localStringBuilder.append(Q[i]);
          localStringBuilder.append(']');
          j = i;
        }
      }
      else
      {
        j = i;
        if ((localObject[i] instanceof m))
        {
          i++;
          j = i;
          if ((localObject[i] instanceof Iterator))
          {
            localStringBuilder.append('.');
            localObject = P;
            j = i;
            if (localObject[i] != null)
            {
              localStringBuilder.append(localObject[i]);
              j = i;
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean h()
  {
    b localb = r();
    boolean bool;
    if ((localb != b.END_OBJECT) && (localb != b.END_ARRAY)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean j()
  {
    a(b.BOOLEAN);
    boolean bool = ((p)w()).g();
    int i = O;
    if (i > 0)
    {
      int[] arrayOfInt = Q;
      i--;
      arrayOfInt[i] += 1;
    }
    return bool;
  }
  
  public double k()
  {
    Object localObject = r();
    if ((localObject != b.NUMBER) && (localObject != b.STRING))
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("Expected ");
      localStringBuilder.append(b.NUMBER);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(i());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    localObject = (p)v();
    double d;
    if ((a instanceof Number)) {
      d = ((p)localObject).h().doubleValue();
    } else {
      d = Double.parseDouble(((p)localObject).f());
    }
    if ((!y) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d);
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    w();
    int i = O;
    if (i > 0)
    {
      localObject = Q;
      i--;
      localObject[i] += 1;
    }
    return d;
  }
  
  public int l()
  {
    Object localObject = r();
    if ((localObject != b.NUMBER) && (localObject != b.STRING))
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("Expected ");
      localStringBuilder.append(b.NUMBER);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(i());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    int i = ((p)v()).a();
    w();
    int j = O;
    if (j > 0)
    {
      localObject = Q;
      j--;
      localObject[j] += 1;
    }
    return i;
  }
  
  public long m()
  {
    b localb = r();
    Object localObject;
    if ((localb != b.NUMBER) && (localb != b.STRING))
    {
      localObject = e.a.a.a.a.a("Expected ");
      ((StringBuilder)localObject).append(b.NUMBER);
      ((StringBuilder)localObject).append(" but was ");
      ((StringBuilder)localObject).append(localb);
      ((StringBuilder)localObject).append(i());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    long l = ((p)v()).e();
    w();
    int i = O;
    if (i > 0)
    {
      localObject = Q;
      i--;
      localObject[i] += 1;
    }
    return l;
  }
  
  public String n()
  {
    a(b.NAME);
    Map.Entry localEntry = (Map.Entry)((Iterator)v()).next();
    String str = (String)localEntry.getKey();
    P[(O - 1)] = str;
    a(localEntry.getValue());
    return str;
  }
  
  public void o()
  {
    a(b.NULL);
    w();
    int i = O;
    if (i > 0)
    {
      int[] arrayOfInt = Q;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public String p()
  {
    Object localObject1 = r();
    if ((localObject1 != b.STRING) && (localObject1 != b.NUMBER))
    {
      localObject2 = e.a.a.a.a.a("Expected ");
      ((StringBuilder)localObject2).append(b.STRING);
      ((StringBuilder)localObject2).append(" but was ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(i());
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = ((p)w()).f();
    int i = O;
    if (i > 0)
    {
      localObject1 = Q;
      i--;
      localObject1[i] += 1;
    }
    return (String)localObject2;
  }
  
  public b r()
  {
    if (O == 0) {
      return b.END_DOCUMENT;
    }
    Object localObject = v();
    if ((localObject instanceof Iterator))
    {
      boolean bool = N[(O - 2)] instanceof m;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return b.NAME;
        }
        a(((Iterator)localObject).next());
        return r();
      }
      if (bool) {
        localObject = b.END_OBJECT;
      } else {
        localObject = b.END_ARRAY;
      }
      return (b)localObject;
    }
    if ((localObject instanceof m)) {
      return b.BEGIN_OBJECT;
    }
    if ((localObject instanceof g)) {
      return b.BEGIN_ARRAY;
    }
    if ((localObject instanceof p))
    {
      localObject = a;
      if ((localObject instanceof String)) {
        return b.STRING;
      }
      if ((localObject instanceof Boolean)) {
        return b.BOOLEAN;
      }
      if ((localObject instanceof Number)) {
        return b.NUMBER;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof l)) {
      return b.NULL;
    }
    if (localObject == S) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public String toString()
  {
    return a.class.getSimpleName();
  }
  
  public void u()
  {
    if (r() == b.NAME)
    {
      n();
      P[(O - 2)] = "null";
    }
    else
    {
      w();
      i = O;
      if (i > 0) {
        P[(i - 1)] = "null";
      }
    }
    int i = O;
    if (i > 0)
    {
      int[] arrayOfInt = Q;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public final Object v()
  {
    return N[(O - 1)];
  }
  
  public final Object w()
  {
    Object[] arrayOfObject = N;
    int i = O - 1;
    O = i;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    return localObject;
  }
  
  public static final class a
    extends Reader
  {
    public void close()
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      throw new AssertionError();
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.z.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */