package k.c.a.a.a.s.r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.prefs.AbstractPreferences;

public class e
{
  public InputStream a;
  public OutputStream b;
  public String c;
  public String d;
  public int e;
  public Properties f;
  
  public e(InputStream paramInputStream, OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt, Properties paramProperties)
  {
    a = paramInputStream;
    b = paramOutputStream;
    c = paramString1;
    d = paramString2;
    e = paramInt;
    f = paramProperties;
  }
  
  public void a()
  {
    Object localObject1 = new byte[16];
    System.arraycopy(UUID.randomUUID().toString().getBytes(), 0, localObject1, 0, 16);
    a.b.putByteArray("aKey", (byte[])localObject1);
    String str2 = ba;
    Object localObject2 = "/mqtt";
    try
    {
      Object localObject3 = new java/net/URI;
      ((URI)localObject3).<init>(c);
      localObject1 = localObject2;
      if (((URI)localObject3).getRawPath() != null)
      {
        localObject1 = localObject2;
        if (!((URI)localObject3).getRawPath().isEmpty())
        {
          localObject2 = ((URI)localObject3).getRawPath();
          localObject1 = localObject2;
          if (((URI)localObject3).getRawQuery() != null)
          {
            localObject1 = localObject2;
            if (!((URI)localObject3).getRawQuery().isEmpty())
            {
              localObject1 = new java/lang/StringBuilder;
              ((StringBuilder)localObject1).<init>(String.valueOf(localObject2));
              ((StringBuilder)localObject1).append("?");
              ((StringBuilder)localObject1).append(((URI)localObject3).getRawQuery());
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
      }
      localObject2 = new java/io/PrintWriter;
      ((PrintWriter)localObject2).<init>(b);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("GET ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" HTTP/1.1");
      localStringBuilder.append("\r\n");
      ((PrintWriter)localObject2).print(localStringBuilder.toString());
      int i = e;
      if (i != 80)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Host: ");
        ((StringBuilder)localObject1).append(d);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(e);
        ((StringBuilder)localObject1).append("\r\n");
        ((PrintWriter)localObject2).print(((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Host: ");
        ((StringBuilder)localObject1).append(d);
        ((StringBuilder)localObject1).append("\r\n");
        ((PrintWriter)localObject2).print(((StringBuilder)localObject1).toString());
      }
      ((PrintWriter)localObject2).print("Upgrade: websocket\r\n");
      ((PrintWriter)localObject2).print("Connection: Upgrade\r\n");
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("Sec-WebSocket-Key: ");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("\r\n");
      ((PrintWriter)localObject2).print(((StringBuilder)localObject1).toString());
      ((PrintWriter)localObject2).print("Sec-WebSocket-Protocol: mqtt\r\n");
      ((PrintWriter)localObject2).print("Sec-WebSocket-Version: 13\r\n");
      if (f != null)
      {
        Iterator localIterator = f.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localObject1 = f.getProperty(str3);
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(String.valueOf(str3));
          localStringBuilder.append(": ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("\r\n");
          ((PrintWriter)localObject2).print(localStringBuilder.toString());
        }
      }
      localObject1 = ((URI)localObject3).getUserInfo();
      if (localObject1 != null)
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("Authorization: Basic ");
        a.b.putByteArray("akey", ((String)localObject1).getBytes());
        ((StringBuilder)localObject3).append(ba);
        ((StringBuilder)localObject3).append("\r\n");
        ((PrintWriter)localObject2).print(((StringBuilder)localObject3).toString());
      }
      ((PrintWriter)localObject2).print("\r\n");
      ((PrintWriter)localObject2).flush();
      localObject3 = new BufferedReader(new InputStreamReader(a));
      localObject2 = new ArrayList();
      localObject1 = ((BufferedReader)localObject3).readLine();
      if (localObject1 != null) {
        for (;;)
        {
          if (((String)localObject1).equals(""))
          {
            localObject1 = new HashMap();
            for (i = 1;; i++)
            {
              if (i >= ((ArrayList)localObject2).size())
              {
                localObject2 = (String)((HashMap)localObject1).get("connection");
                if ((localObject2 != null) && (!((String)localObject2).equalsIgnoreCase("upgrade")))
                {
                  localObject2 = (String)((HashMap)localObject1).get("upgrade");
                  if ((localObject2 != null) && (((String)localObject2).toLowerCase().contains("websocket")))
                  {
                    if ((String)((HashMap)localObject1).get("sec-websocket-protocol") != null)
                    {
                      if (((HashMap)localObject1).containsKey("sec-websocket-accept")) {
                        try
                        {
                          a(str2, (String)((HashMap)localObject1).get("sec-websocket-accept"));
                          return;
                        }
                        catch (c localc)
                        {
                          throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                        }
                        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
                        {
                          throw new IOException(localNoSuchAlgorithmException.getMessage());
                        }
                      }
                      throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
                    }
                    throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
                  }
                  throw new IOException("WebSocket Response header: Incorrect upgrade.");
                }
                throw new IOException("WebSocket Response header: Incorrect connection header");
              }
              localObject3 = ((String)((ArrayList)localObject2).get(i)).split(":");
              localNoSuchAlgorithmException.put(localObject3[0].toLowerCase(), localObject3[1]);
            }
          }
          ((ArrayList)localObject2).add(localNoSuchAlgorithmException);
          String str1 = ((BufferedReader)localObject3).readLine();
        }
      }
      throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalStateException(localURISyntaxException.getMessage());
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(String.valueOf(paramString1));
    paramString1.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    paramString1 = paramString1.toString();
    paramString1 = MessageDigest.getInstance("SHA1").digest(paramString1.getBytes());
    a.b.putByteArray("aKey", paramString1);
    if (ba.trim().equals(paramString2.trim())) {
      return;
    }
    throw new c();
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.r.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */