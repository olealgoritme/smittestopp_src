package l.b.a;

import e.a.a.a.a;
import java.io.IOException;
import java.io.OutputStream;

public class c
  extends t
{
  public static final c y = new c((byte)0);
  public static final c z = new c((byte)-1);
  public final byte x;
  
  public c(byte paramByte)
  {
    x = ((byte)paramByte);
  }
  
  public static c a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof c)))
    {
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (c)t.a((byte[])paramObject);
          return (c)paramObject;
        }
        catch (IOException paramObject)
        {
          StringBuilder localStringBuilder = a.a("failed to construct boolean from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      throw new IllegalArgumentException(a.a(paramObject, a.a("illegal object in getInstance: ")));
    }
    return (c)paramObject;
  }
  
  public static c a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = paramb0.j();
    if ((!paramBoolean) && (!(paramb0 instanceof c))) {
      return b(p.a(paramb0).j());
    }
    return a(paramb0);
  }
  
  public static c b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 1)
    {
      byte b = paramArrayOfByte[0];
      if (b != -1)
      {
        if (b != 0) {
          return new c(b);
        }
        return y;
      }
      return z;
    }
    throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    int i = x;
    if (paramBoolean) {
      a.write(1);
    }
    paramr.a(1);
    a.write(i);
  }
  
  public boolean a(t paramt)
  {
    boolean bool1 = paramt instanceof c;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramt = (c)paramt;
    if (j() == paramt.j()) {
      bool2 = true;
    }
    return bool2;
  }
  
  public int f()
  {
    return 3;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public t h()
  {
    c localc;
    if (j()) {
      localc = z;
    } else {
      localc = y;
    }
    return localc;
  }
  
  public int hashCode()
  {
    return j();
  }
  
  public boolean j()
  {
    boolean bool;
    if (x != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    String str;
    if (j()) {
      str = "TRUE";
    } else {
      str = "FALSE";
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     l.b.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */