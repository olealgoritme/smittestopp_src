package k.c.a.a.a;

import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import k.c.a.a.a.w.a;

public class i
{
  public int a = 60;
  public int b = 10;
  public String c = null;
  public l d = null;
  public String e;
  public char[] f;
  public SocketFactory g;
  public Properties h = null;
  public boolean i = true;
  public HostnameVerifier j = null;
  public boolean k = true;
  public int l = 30;
  public String[] m = null;
  public int n = 0;
  public boolean o = false;
  public int p = 128000;
  public Properties q = null;
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 4))
    {
      StringBuilder localStringBuilder = new StringBuilder("An incorrect version was used \"");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("\". Acceptable version options are ");
      localStringBuilder.append(0);
      localStringBuilder.append(", ");
      localStringBuilder.append(3);
      localStringBuilder.append(" and ");
      localStringBuilder.append(4);
      localStringBuilder.append(".");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    n = paramInt;
  }
  
  public String toString()
  {
    Properties localProperties = new Properties();
    localProperties.put("MqttVersion", Integer.valueOf(n));
    localProperties.put("CleanSession", Boolean.valueOf(k));
    localProperties.put("ConTimeout", Integer.valueOf(l));
    localProperties.put("KeepAliveInterval", Integer.valueOf(a));
    String str = e;
    Object localObject = str;
    if (str == null) {
      localObject = "null";
    }
    localProperties.put("UserName", localObject);
    str = c;
    localObject = str;
    if (str == null) {
      localObject = "null";
    }
    localProperties.put("WillDestination", localObject);
    localObject = g;
    if (localObject == null) {
      localProperties.put("SocketFactory", "null");
    } else {
      localProperties.put("SocketFactory", localObject);
    }
    localObject = h;
    if (localObject == null) {
      localProperties.put("SSLProperties", "null");
    } else {
      localProperties.put("SSLProperties", localObject);
    }
    return a.a(localProperties, "Connection options");
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */