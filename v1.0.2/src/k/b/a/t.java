package k.b.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class t
  extends n
{
  public static t a(byte[] paramArrayOfByte)
  {
    k localk = new k(paramArrayOfByte);
    try
    {
      paramArrayOfByte = localk.readObject();
      if (localk.available() == 0) {
        return paramArrayOfByte;
      }
      paramArrayOfByte = new java/io/IOException;
      paramArrayOfByte.<init>("Extra data detected in stream");
      throw paramArrayOfByte;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      throw new IOException("cannot recognise object in stream");
    }
  }
  
  public void a(OutputStream paramOutputStream)
  {
    a(new r(paramOutputStream), true);
  }
  
  public void a(OutputStream paramOutputStream, String paramString)
  {
    r.a(paramOutputStream, paramString).a(this, true);
  }
  
  public abstract void a(r paramr, boolean paramBoolean);
  
  public abstract boolean a(t paramt);
  
  public final boolean b(t paramt)
  {
    boolean bool;
    if ((this != paramt) && (!a(paramt))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final t c()
  {
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((!(paramObject instanceof e)) || (!a(((e)paramObject).c()))) {
      bool = false;
    }
    return bool;
  }
  
  public abstract int f();
  
  public abstract boolean g();
  
  public t h()
  {
    return this;
  }
  
  public t i()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */