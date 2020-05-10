package l.c.a.a.a.s.s;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import l.c.a.a.a.t.c;

public class g
  extends OutputStream
{
  public static final String A = g.class.getName();
  public l.c.a.a.a.t.b x = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", A);
  public l.c.a.a.a.s.b y = null;
  public BufferedOutputStream z;
  
  public g(l.c.a.a.a.s.b paramb, OutputStream paramOutputStream)
  {
    y = paramb;
    z = new BufferedOutputStream(paramOutputStream);
  }
  
  public void a(u paramu)
  {
    byte[] arrayOfByte1 = paramu.h();
    byte[] arrayOfByte2 = paramu.k();
    z.write(arrayOfByte1, 0, arrayOfByte1.length);
    y.b(arrayOfByte1.length);
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfByte2.length)
      {
        x.b(A, "write", "529", new Object[] { paramu });
        return;
      }
      int j = Math.min(1024, arrayOfByte2.length - i);
      z.write(arrayOfByte2, i, j);
      i += 1024;
      y.b(j);
    }
  }
  
  public void close()
  {
    z.close();
  }
  
  public void flush()
  {
    z.flush();
  }
  
  public void write(int paramInt)
  {
    z.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    z.write(paramArrayOfByte);
    y.b(paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    z.write(paramArrayOfByte, paramInt1, paramInt2);
    y.b(paramInt2);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */