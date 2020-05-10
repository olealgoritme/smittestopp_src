package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

public class h0
  extends p
{
  public final int y;
  public final p[] z;
  
  public h0(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    z = null;
    y = 1000;
  }
  
  public h0(p[] paramArrayOfp)
  {
    super(localStringBuilder.toByteArray());
    z = paramArrayOfp;
    y = 1000;
  }
  
  public static h0 a(u paramu)
  {
    int i = paramu.size();
    p[] arrayOfp = new p[i];
    for (int j = 0; j < i; j++) {
      arrayOfp[j] = p.a(paramu.a(j));
    }
    return new h0(arrayOfp);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    Enumeration localEnumeration = k();
    if (paramBoolean) {
      a.write(36);
    }
    a.write(128);
    paramr.a(localEnumeration);
    a.write(0);
    a.write(0);
  }
  
  public int f()
  {
    Enumeration localEnumeration = k();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((e)localEnumeration.nextElement()).b().f();
    }
    return i + 2 + 2;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public byte[] j()
  {
    return x;
  }
  
  public Enumeration k()
  {
    if (z == null)
    {
      Vector localVector = new Vector();
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = x;
        if (i >= arrayOfByte.length) {
          break;
        }
        int j = y + i;
        int k = j;
        if (j > arrayOfByte.length) {
          k = arrayOfByte.length;
        }
        k -= i;
        arrayOfByte = new byte[k];
        System.arraycopy(x, i, arrayOfByte, 0, k);
        localVector.addElement(new a1(arrayOfByte));
        i += y;
      }
      return localVector.elements();
    }
    return new a();
  }
  
  public class a
    implements Enumeration
  {
    public int a = 0;
    
    public a() {}
    
    public boolean hasMoreElements()
    {
      boolean bool;
      if (a < z.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Object nextElement()
    {
      p[] arrayOfp = z;
      int i = a;
      a = (i + 1);
      return arrayOfp[i];
    }
  }
}

/* Location:
 * Qualified Name:     l.b.a.h0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */