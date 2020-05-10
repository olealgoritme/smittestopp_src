package k.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

public class r
{
  public OutputStream a;
  
  public r(OutputStream paramOutputStream)
  {
    a = paramOutputStream;
  }
  
  public static r a(OutputStream paramOutputStream, String paramString)
  {
    if (paramString.equals("DER")) {
      return new c1(paramOutputStream);
    }
    if (paramString.equals("DL")) {
      return new q1(paramOutputStream);
    }
    return new r(paramOutputStream);
  }
  
  public c1 a()
  {
    return new c1(a);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > 127)
    {
      int i = paramInt;
      for (int j = 1;; j++)
      {
        i >>>= 8;
        if (i == 0) {
          break;
        }
      }
      i = (byte)(j | 0x80);
      a.write(i);
      for (j = (j - 1) * 8; j >= 0; j -= 8)
      {
        i = (byte)(paramInt >> j);
        a.write(i);
      }
    }
    paramInt = (byte)paramInt;
    a.write(paramInt);
  }
  
  public final void a(Enumeration paramEnumeration)
  {
    while (paramEnumeration.hasMoreElements()) {
      a(((e)paramEnumeration.nextElement()).c(), true);
    }
  }
  
  public void a(e parame)
  {
    if (parame != null)
    {
      a(parame.c(), true);
      return;
    }
    throw new IOException("null object detected");
  }
  
  public void a(t paramt, boolean paramBoolean)
  {
    paramt.a(this, paramBoolean);
  }
  
  public final void a(boolean paramBoolean, int paramInt, byte paramByte, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      a.write(paramInt);
    }
    a(paramArrayOfByte.length + 1);
    a.write(paramByte);
    paramInt = paramArrayOfByte.length;
    a.write(paramArrayOfByte, 0, paramInt);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramInt2 < 31)
    {
      a.write(paramInt1 | paramInt2);
    }
    else
    {
      a.write(0x1F | paramInt1);
      if (paramInt2 < 128)
      {
        a.write(paramInt2);
      }
      else
      {
        byte[] arrayOfByte = new byte[5];
        paramInt1 = 4;
        arrayOfByte[4] = ((byte)(byte)(paramInt2 & 0x7F));
        int i;
        int j;
        do
        {
          i = paramInt2 >> 7;
          j = paramInt1 - 1;
          arrayOfByte[j] = ((byte)(byte)(i & 0x7F | 0x80));
          paramInt1 = j;
          paramInt2 = i;
        } while (i > 127);
        a.write(arrayOfByte, j, 5 - j);
      }
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    a(paramBoolean, paramInt1, paramInt2);
    a(paramArrayOfByte.length);
    paramInt1 = paramArrayOfByte.length;
    a.write(paramArrayOfByte, 0, paramInt1);
  }
  
  public final void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      a.write(paramInt);
    }
    a(paramArrayOfByte.length);
    paramInt = paramArrayOfByte.length;
    a.write(paramArrayOfByte, 0, paramInt);
  }
  
  public final void a(boolean paramBoolean, int paramInt, e[] paramArrayOfe)
  {
    if (paramBoolean) {
      a.write(paramInt);
    }
    a.write(128);
    int i = paramArrayOfe.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      a(paramArrayOfe[paramInt].c(), true);
    }
    a.write(0);
    a.write(0);
  }
  
  public r b()
  {
    return new q1(a);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */