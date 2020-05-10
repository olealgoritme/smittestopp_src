package l.d.b.i;

import l.d.b.f;

public class d
{
  static
  {
    "0123456789ABCDEF".toCharArray();
  }
  
  public static String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    paramString1 = new StringBuilder(paramString1);
    paramString1.append('"');
    paramString1.append(paramString2);
    paramString1.append('"');
    paramString1.append(" (");
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      paramString1.append('"');
      paramString1.append(paramArrayOfString[j]);
      paramString1.append('"');
      if (j < i - 1) {
        paramString1.append(',');
      }
    }
    paramString1.append(") VALUES (");
    a(paramString1, paramArrayOfString.length);
    paramString1.append(')');
    return paramString1.toString();
  }
  
  public static String a(String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 != null) && (paramString2.length() >= 0))
    {
      if (paramBoolean) {
        localObject = "SELECT DISTINCT ";
      } else {
        localObject = "SELECT ";
      }
      Object localObject = new StringBuilder((String)localObject);
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(".\"");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append('"');
        if (j < i - 1) {
          ((StringBuilder)localObject).append(',');
        }
      }
      ((StringBuilder)localObject).append(" FROM ");
      ((StringBuilder)localObject).append('"');
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append('"');
      ((StringBuilder)localObject).append(' ');
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(' ');
      return ((StringBuilder)localObject).toString();
    }
    throw new l.d.b.d("Table alias required");
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('"');
    localObject = ((StringBuilder)localObject).toString();
    paramString = new StringBuilder("DELETE FROM ");
    paramString.append((String)localObject);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramString.append(" WHERE ");
      a(paramString, (String)localObject, paramArrayOfString);
    }
    return paramString.toString();
  }
  
  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('"');
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" SET ");
    for (int i = 0; i < paramArrayOfString1.length; i++)
    {
      paramString = paramArrayOfString1[i];
      localStringBuilder.append('"');
      localStringBuilder.append(paramString);
      localStringBuilder.append('"');
      localStringBuilder.append("=?");
      if (i < paramArrayOfString1.length - 1) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(" WHERE ");
    a(localStringBuilder, (String)localObject, paramArrayOfString2);
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (i < paramInt - 1) {
        paramStringBuilder.append("?,");
      } else {
        paramStringBuilder.append('?');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, f paramf)
  {
    if (paramString != null)
    {
      paramStringBuilder.append(paramString);
      paramStringBuilder.append('.');
    }
    paramStringBuilder.append('"');
    paramStringBuilder.append(e);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      String str = paramArrayOfString[i];
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(".\"");
      paramStringBuilder.append(str);
      paramStringBuilder.append('"');
      paramStringBuilder.append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
    }
    return paramStringBuilder;
  }
}

/* Location:
 * Qualified Name:     l.d.b.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */