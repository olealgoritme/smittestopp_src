package k.c.a.a.a.s.r;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.SocketTimeoutException;
import k.c.a.a.a.t.b;
import k.c.a.a.a.t.c;

public class h
  implements Runnable
{
  public static final String E = h.class.getName();
  public final Object A = new Object();
  public InputStream B;
  public Thread C = null;
  public PipedOutputStream D;
  public b x = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", E);
  public boolean y = false;
  public boolean z = false;
  
  public h(InputStream paramInputStream, PipedInputStream paramPipedInputStream)
  {
    B = paramInputStream;
    paramInputStream = new PipedOutputStream();
    D = paramInputStream;
    paramPipedInputStream.connect(paramInputStream);
  }
  
  public void a()
  {
    int i = 1;
    z = true;
    synchronized (A)
    {
      x.b(E, "stop", "850");
      if (y) {
        y = false;
      }
      try
      {
        D.close();
      }
      catch (IOException localIOException)
      {
        try
        {
          ((Thread)???).join();
          C = null;
          x.b(E, "stop", "851");
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
          localIOException = localIOException;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
      i = 0;
      if ((i != 0) && (!Thread.currentThread().equals(C)))
      {
        ??? = C;
        if (??? == null) {}
      }
    }
  }
  
  public void a(String paramString)
  {
    x.b(E, "start", "855");
    synchronized (A)
    {
      if (!y)
      {
        y = true;
        Thread localThread = new java/lang/Thread;
        localThread.<init>(this, paramString);
        C = localThread;
        localThread.start();
      }
      return;
    }
  }
  
  public void run()
  {
    while ((y) && (B != null)) {
      try
      {
        x.b(E, "run", "852");
        B.available();
        InputStream localInputStream = B;
        int i = (byte)((byte)localInputStream.read() & 0xF);
        int j = 2;
        Object localObject1 = null;
        Object localObject2 = null;
        int k = 1;
        int m = 1;
        int n = 0;
        if (i == 2)
        {
          k = (byte)localInputStream.read();
          if ((k & 0x80) == 0) {
            m = 0;
          }
          k = (byte)(k & 0x7F);
          if (k == 127) {
            j = 8;
          } else if (k != 126) {
            j = 0;
          }
          i = j;
          if (j > 0)
          {
            k = 0;
            i = j;
          }
          for (;;)
          {
            i--;
            if (i < 0)
            {
              if (m != 0)
              {
                localObject2 = new byte[4];
                localInputStream.read((byte[])localObject2, 0, 4);
              }
              localObject1 = new byte[k];
              j = k;
              i = 0;
              for (;;)
              {
                if (i == k)
                {
                  if (m != 0) {
                    for (j = 0; j < k; j++) {
                      localObject1[j] = ((byte)(byte)(localObject1[j] ^ localObject2[(j % 4)]));
                    }
                  }
                  localObject2 = localObject1;
                  k = 0;
                  break;
                }
                int i1 = localInputStream.read((byte[])localObject1, i, j);
                i += i1;
                j -= i1;
              }
            }
            k |= ((byte)localInputStream.read() & 0xFF) << i * 8;
          }
        }
        if (i == 8)
        {
          localObject2 = localObject1;
          if (k == 0) {
            for (k = n;; k++)
            {
              if (k >= localObject2.length)
              {
                D.flush();
                break;
              }
              D.write(localObject2[k]);
            }
          }
          if (!z)
          {
            localObject2 = new java/io/IOException;
            ((IOException)localObject2).<init>("Server sent a WebSocket Frame with the Stop OpCode");
            throw ((Throwable)localObject2);
          }
        }
        else
        {
          localObject2 = new java/io/IOException;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("Invalid Frame: Opcode: ");
          ((StringBuilder)localObject1).append(i);
          ((IOException)localObject2).<init>(((StringBuilder)localObject1).toString());
          throw ((Throwable)localObject2);
        }
      }
      catch (IOException localIOException)
      {
        a();
      }
      catch (SocketTimeoutException localSocketTimeoutException) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.r.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */