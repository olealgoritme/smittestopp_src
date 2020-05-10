package l.c.a.a.a;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import l.c.a.a.a.s.h;

public class k
  extends Exception
{
  public int x;
  public Throwable y;
  
  public k(int paramInt)
  {
    x = paramInt;
  }
  
  public k(int paramInt, Throwable paramThrowable)
  {
    x = paramInt;
    y = paramThrowable;
  }
  
  public k(Throwable paramThrowable)
  {
    x = 0;
    y = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return y;
  }
  
  public String getMessage()
  {
    int i = x;
    h localh = h.a;
    Object localObject = "";
    int j;
    int k;
    if (localh == null)
    {
      j = 1;
      try
      {
        Class.forName("java.util.ResourceBundle");
        k = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        k = 0;
      }
      if (k == 0) {}
    }
    try
    {
      h.a = (h)Class.forName("l.c.a.a.a.s.k").newInstance();
      break label93;
      try
      {
        Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog");
        k = j;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        k = 0;
      }
      if (k != 0) {
        h.a = (h)Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
      }
      label93:
      localObject = (l.c.a.a.a.s.k)h.a;
      if (localObject == null) {
        break label125;
      }
      try
      {
        localObject = b.getString(Integer.toString(i));
      }
      catch (MissingResourceException localMissingResourceException)
      {
        str = "MqttException";
      }
    }
    catch (Exception localException)
    {
      String str;
      label125:
      for (;;) {}
    }
    return str;
    throw null;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder(String.valueOf(getMessage()));
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(x);
    ((StringBuilder)localObject).append(")");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (y != null)
    {
      localObject = new StringBuilder(String.valueOf(str));
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(y.toString());
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */