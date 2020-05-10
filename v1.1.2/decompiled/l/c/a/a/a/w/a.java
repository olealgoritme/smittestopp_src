package l.c.a.a.a.w;

import java.util.Enumeration;
import java.util.Properties;

public class a
{
  public static final String a = System.getProperty("line.separator", "\n");
  
  public static String a(Properties paramProperties, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Enumeration localEnumeration = paramProperties.propertyNames();
    Object localObject = new StringBuilder(String.valueOf(a));
    ((StringBuilder)localObject).append("==============");
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append("==============");
    ((StringBuilder)localObject).append(a);
    localStringBuffer.append(((StringBuilder)localObject).toString());
    if (!localEnumeration.hasMoreElements())
    {
      paramProperties = new StringBuilder("==========================================");
      paramProperties.append(a);
      localStringBuffer.append(paramProperties.toString());
      return localStringBuffer.toString();
    }
    localObject = (String)localEnumeration.nextElement();
    int i;
    if (((String)localObject).length() >= 28)
    {
      paramString = (String)localObject;
    }
    else
    {
      paramString = new StringBuffer(28);
      paramString.append((String)localObject);
      i = 28 - ((String)localObject).length();
    }
    for (;;)
    {
      i--;
      if (i < 0)
      {
        paramString = paramString.toString();
        paramString = new StringBuilder(String.valueOf(paramString));
        paramString.append(":  ");
        paramString.append(paramProperties.get(localObject));
        paramString.append(a);
        localStringBuffer.append(paramString.toString());
        break;
      }
      paramString.append(' ');
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */