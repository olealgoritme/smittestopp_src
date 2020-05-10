package k.b.a;

import java.io.IOException;
import java.util.Iterator;
import k.b.j.c;

public abstract class x
  extends t
  implements c<e>
{
  public final e[] x;
  public final boolean y;
  
  public x()
  {
    x = f.d;
    y = true;
  }
  
  public x(e parame)
  {
    if (parame != null)
    {
      x = new e[] { parame };
      y = true;
      return;
    }
    throw new NullPointerException("'element' cannot be null");
  }
  
  public x(f paramf, boolean paramBoolean)
  {
    if (paramf != null)
    {
      boolean bool = false;
      if (paramBoolean)
      {
        int i = b;
        if (i >= 2)
        {
          if (i == 0)
          {
            paramf = f.d;
          }
          else
          {
            e[] arrayOfe = new e[i];
            System.arraycopy(a, 0, arrayOfe, 0, i);
            paramf = arrayOfe;
          }
          a(paramf);
          break label73;
        }
      }
      paramf = paramf.a();
      label73:
      x = paramf;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        if (paramf.length >= 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      y = paramBoolean;
      return;
    }
    throw new NullPointerException("'elementVector' cannot be null");
  }
  
  public x(boolean paramBoolean, e[] paramArrayOfe)
  {
    x = paramArrayOfe;
    if ((!paramBoolean) && (paramArrayOfe.length >= 2)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    y = paramBoolean;
  }
  
  public static x a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof x)))
    {
      if ((paramObject instanceof y)) {
        return a(((y)paramObject).c());
      }
      Object localObject;
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = a(t.a((byte[])paramObject));
          return (x)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = e.a.a.a.a.a("failed to construct set from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof x)) {
          return (x)localObject;
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("unknown object in getInstance: ")));
    }
    return (x)paramObject;
  }
  
  public static x a(b0 paramb0, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (y) {
        return a(paramb0.j());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    Object localObject = paramb0.j();
    if (y)
    {
      if ((paramb0 instanceof n0)) {
        return new l0((e)localObject);
      }
      return new t1((e)localObject);
    }
    if ((localObject instanceof x))
    {
      localObject = (x)localObject;
      if ((paramb0 instanceof n0)) {
        return (x)localObject;
      }
      return (x)((x)localObject).i();
    }
    if ((localObject instanceof u))
    {
      localObject = ((u)localObject).k();
      if ((paramb0 instanceof n0)) {
        return new l0(false, (e[])localObject);
      }
      return new t1(false, (e[])localObject);
    }
    localObject = e.a.a.a.a.a("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramb0.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static void a(e[] paramArrayOfe)
  {
    int i = paramArrayOfe.length;
    int j = 2;
    if (i < 2) {
      return;
    }
    e locale1 = paramArrayOfe[0];
    e locale2 = paramArrayOfe[1];
    Object localObject1 = a(locale1);
    byte[] arrayOfByte = a(locale2);
    int k = j;
    Object localObject2 = locale1;
    Object localObject3 = locale2;
    Object localObject4 = localObject1;
    Object localObject5 = arrayOfByte;
    if (a(arrayOfByte, (byte[])localObject1))
    {
      localObject3 = locale1;
      localObject2 = locale2;
      localObject5 = localObject1;
      localObject4 = arrayOfByte;
    }
    for (k = j; k < i; k++)
    {
      localObject1 = paramArrayOfe[k];
      arrayOfByte = a((e)localObject1);
      if (a((byte[])localObject5, arrayOfByte))
      {
        paramArrayOfe[(k - 2)] = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject1;
        localObject4 = localObject5;
        localObject5 = arrayOfByte;
      }
      else if (a((byte[])localObject4, arrayOfByte))
      {
        paramArrayOfe[(k - 2)] = localObject2;
        localObject2 = localObject1;
        localObject4 = arrayOfByte;
      }
      else
      {
        j = k - 1;
        for (;;)
        {
          j--;
          if (j <= 0) {
            break;
          }
          locale2 = paramArrayOfe[(j - 1)];
          if (a(a(locale2), arrayOfByte)) {
            break;
          }
          paramArrayOfe[j] = locale2;
        }
        paramArrayOfe[j] = localObject1;
      }
    }
    paramArrayOfe[(i - 2)] = localObject2;
    paramArrayOfe[(i - 1)] = localObject3;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = paramArrayOfByte1[0] & 0xFFFFFFDF;
    int j = paramArrayOfByte2[0] & 0xFFFFFFDF;
    if (i != j)
    {
      if (i < j) {
        bool3 = true;
      }
      return bool3;
    }
    j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length) - 1;
    for (i = 1; i < j; i++) {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        bool3 = bool1;
        if ((paramArrayOfByte1[i] & 0xFF) < (paramArrayOfByte2[i] & 0xFF)) {
          bool3 = true;
        }
        return bool3;
      }
    }
    bool3 = bool2;
    if ((paramArrayOfByte1[j] & 0xFF) <= (paramArrayOfByte2[j] & 0xFF)) {
      bool3 = true;
    }
    return bool3;
  }
  
  public static byte[] a(e parame)
  {
    try
    {
      parame = parame.c().a("DER");
      return parame;
    }
    catch (IOException parame)
    {
      throw new IllegalArgumentException("cannot encode object added to SET");
    }
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof x)) {
      return false;
    }
    Object localObject = (x)paramt;
    int i = x.length;
    if (x.length != i) {
      return false;
    }
    paramt = (f1)h();
    f1 localf1 = (f1)((x)localObject).h();
    for (int j = 0; j < i; j++)
    {
      localObject = x[j].c();
      t localt = x[j].c();
      if ((localObject != localt) && (!((t)localObject).a(localt))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public t h()
  {
    e[] arrayOfe;
    if (y)
    {
      arrayOfe = x;
    }
    else
    {
      arrayOfe = (e[])x.clone();
      a(arrayOfe);
    }
    return new f1(true, arrayOfe);
  }
  
  public int hashCode()
  {
    int i = x.length;
    int j = i + 1;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      j += x[i].c().hashCode();
    }
    return j;
  }
  
  public t i()
  {
    return new t1(y, x);
  }
  
  public Iterator<e> iterator()
  {
    return new k.b.j.a(f.a(x));
  }
  
  public String toString()
  {
    int i = x.length;
    if (i == 0) {
      return "[]";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    int j = 0;
    for (;;)
    {
      localStringBuffer.append(x[j]);
      j++;
      if (j >= i)
      {
        localStringBuffer.append(']');
        return localStringBuffer.toString();
      }
      localStringBuffer.append(", ");
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */