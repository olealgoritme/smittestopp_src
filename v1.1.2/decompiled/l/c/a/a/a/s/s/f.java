package l.c.a.a.a.s.s;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import l.b.c.e.a;
import l.c.a.a.a.t.c;

public class f
  extends InputStream
{
  public DataInputStream A;
  public ByteArrayOutputStream B;
  public int C;
  public int D;
  public byte[] E;
  public final String x;
  public final l.c.a.a.a.t.b y;
  public l.c.a.a.a.s.b z;
  
  public f(l.c.a.a.a.s.b paramb, InputStream paramInputStream)
  {
    String str = f.class.getName();
    x = str;
    y = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", str);
    z = null;
    z = paramb;
    A = new DataInputStream(paramInputStream);
    B = new ByteArrayOutputStream();
    C = -1;
  }
  
  public final void a()
  {
    int i = B.size();
    int j = D;
    int k = C - j;
    if (k >= 0)
    {
      int m = 0;
      for (;;)
      {
        if (m >= k) {
          return;
        }
        try
        {
          int n = A.read(E, i + j + m, k - m);
          if (n >= 0)
          {
            z.a(n);
            m += n;
          }
          else
          {
            throw new EOFException();
          }
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          D += m;
          throw localSocketTimeoutException;
        }
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  public int available()
  {
    return A.available();
  }
  
  public u b()
  {
    for (;;)
    {
      try
      {
        if (C < 0)
        {
          B.reset();
          int i = A.readByte();
          z.a(1);
          int j = (byte)(i >>> 4 & 0xF);
          if ((j >= 1) && (j <= 14))
          {
            C = bA).a;
            B.write(i);
            B.write(u.a(C));
            E = new byte[B.size() + C];
            D = 0;
          }
          else
          {
            throw a.a(32108);
          }
        }
        if (C >= 0)
        {
          a();
          C = -1;
          localObject = B.toByteArray();
          System.arraycopy(localObject, 0, E, 0, localObject.length);
          localObject = u.a(E);
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException1)
      {
        Object localObject;
        continue;
      }
      try
      {
        y.b(x, "readMqttWireMessage", "301", new Object[] { localObject });
      }
      catch (SocketTimeoutException localSocketTimeoutException2) {}
    }
    localObject = null;
    return (u)localObject;
  }
  
  public void close()
  {
    A.close();
  }
  
  public int read()
  {
    return A.read();
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */