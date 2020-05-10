package l.b.a;

import e.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;

public class p0
  extends InputStream
{
  public final z x;
  public boolean y = true;
  public InputStream z;
  
  public p0(z paramz)
  {
    x = paramz;
  }
  
  public int read()
  {
    Object localObject1 = z;
    Object localObject2 = "unknown object encountered: ";
    int i = -1;
    Object localObject3;
    if (localObject1 == null)
    {
      if (!y) {
        return -1;
      }
      localObject2 = x.a();
      if (localObject2 == null) {
        return -1;
      }
      if ((localObject2 instanceof q))
      {
        localObject3 = (q)localObject2;
        y = false;
        i = -1;
        localObject2 = "unknown object encountered: ";
        localObject1 = this;
      }
      else
      {
        localObject1 = a.a("unknown object encountered: ");
        ((StringBuilder)localObject1).append(localObject2.getClass());
        throw new IOException(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject1 = this;
    }
    for (;;)
    {
      int j = z.read();
      if (j >= 0) {
        return j;
      }
      localObject3 = x.a();
      if (localObject3 == null)
      {
        z = null;
        return i;
      }
      if (!(localObject3 instanceof q)) {
        break;
      }
      localObject3 = (q)localObject3;
      z = ((q)localObject3).a();
    }
    localObject2 = a.a((String)localObject2);
    ((StringBuilder)localObject2).append(localObject3.getClass());
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject1 = z;
    Object localObject2 = "unknown object encountered: ";
    int i = 0;
    int j = -1;
    Object localObject3;
    if (localObject1 == null)
    {
      if (!y) {
        return -1;
      }
      localObject2 = x.a();
      if (localObject2 == null) {
        return -1;
      }
      if ((localObject2 instanceof q))
      {
        localObject3 = (q)localObject2;
        y = false;
        j = 0;
        i = -1;
        localObject2 = "unknown object encountered: ";
        localObject1 = this;
      }
      else
      {
        paramArrayOfByte = a.a("unknown object encountered: ");
        paramArrayOfByte.append(localObject2.getClass());
        throw new IOException(paramArrayOfByte.toString());
      }
    }
    else
    {
      localObject1 = this;
    }
    for (;;)
    {
      int k = z.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (k >= 0)
      {
        k = i + k;
        i = k;
        if (k == paramInt2) {
          return k;
        }
      }
      else
      {
        localObject3 = x.a();
        if (localObject3 == null)
        {
          z = null;
          paramInt1 = i;
          if (i < 1) {
            paramInt1 = j;
          }
          return paramInt1;
        }
        if (!(localObject3 instanceof q)) {
          break;
        }
        localObject3 = (q)localObject3;
        k = j;
        j = i;
        i = k;
        z = ((q)localObject3).a();
        k = j;
        j = i;
        i = k;
      }
    }
    paramArrayOfByte = a.a((String)localObject2);
    paramArrayOfByte.append(localObject3.getClass());
    throw new IOException(paramArrayOfByte.toString());
  }
}

/* Location:
 * Qualified Name:     l.b.a.p0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */