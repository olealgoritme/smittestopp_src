package com.microsoft.identity.common.adal.internal.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class ExceptionExtensions
{
  public static String getExceptionMessage(Exception paramException)
  {
    Object localObject;
    if (paramException != null)
    {
      String str = paramException.getMessage();
      localObject = str;
      if (str == null)
      {
        localObject = new StringWriter();
        paramException.printStackTrace(new PrintWriter((Writer)localObject));
        localObject = ((StringWriter)localObject).toString();
      }
    }
    else
    {
      localObject = null;
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.util.ExceptionExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */