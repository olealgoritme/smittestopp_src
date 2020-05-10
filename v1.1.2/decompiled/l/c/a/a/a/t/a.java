package l.c.a.a.a.t;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class a
  implements b
{
  public Logger a = null;
  public ResourceBundle b = null;
  public ResourceBundle c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    Level localLevel = b(paramInt);
    if (a.isLoggable(localLevel)) {
      a(localLevel, paramString1, paramString2, b, paramString3, paramArrayOfObject, paramThrowable);
    }
  }
  
  public void a(String paramString)
  {
    e = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    b(6, paramString1, paramString2, paramString3, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    a(1, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    b(5, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
  
  public void a(ResourceBundle paramResourceBundle, String paramString1, String paramString2)
  {
    c = b;
    e = paramString2;
    f = paramString1;
    a = Logger.getLogger(paramString1);
    b = paramResourceBundle;
    c = paramResourceBundle;
    d = paramResourceBundle.getString("0");
  }
  
  public final void a(Level paramLevel, String paramString1, String paramString2, ResourceBundle paramResourceBundle, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    String str = paramString3;
    if (!paramString3.contains("=====")) {}
    try
    {
      paramResourceBundle = paramResourceBundle.getString(paramString3);
      paramString3 = paramResourceBundle;
    }
    catch (MissingResourceException paramResourceBundle)
    {
      for (;;) {}
    }
    str = MessageFormat.format(paramString3, paramArrayOfObject);
    paramLevel = new LogRecord(paramLevel, e.a.a.a.a.a(new StringBuilder(String.valueOf(e)), ": ", str));
    paramLevel.setSourceClassName(paramString1);
    paramLevel.setSourceMethodName(paramString2);
    paramLevel.setLoggerName(f);
    if (paramThrowable != null) {
      paramLevel.setThrown(paramThrowable);
    }
    a.log(paramLevel);
  }
  
  public boolean a(int paramInt)
  {
    return a.isLoggable(b(paramInt));
  }
  
  public final Level b(int paramInt)
  {
    Level localLevel;
    switch (paramInt)
    {
    default: 
      localLevel = null;
      break;
    case 7: 
      localLevel = Level.FINEST;
      break;
    case 6: 
      localLevel = Level.FINER;
      break;
    case 5: 
      localLevel = Level.FINE;
      break;
    case 4: 
      localLevel = Level.CONFIG;
      break;
    case 3: 
      localLevel = Level.INFO;
      break;
    case 2: 
      localLevel = Level.WARNING;
      break;
    case 1: 
      localLevel = Level.SEVERE;
    }
    return localLevel;
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    Level localLevel = b(paramInt);
    if (a.isLoggable(localLevel)) {
      a(localLevel, paramString1, paramString2, c, paramString3, paramArrayOfObject, paramThrowable);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    b(5, paramString1, paramString2, paramString3, null, null);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    b(5, paramString1, paramString2, paramString3, paramArrayOfObject, null);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramString3, paramArrayOfObject, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.t.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */