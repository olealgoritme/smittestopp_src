package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.a.a.a.a;
import e.c.c.e;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.t;

public class ErrorMessageParser
{
  public static String bestErrorMessage(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Gson localGson = new e().a();
      String str1 = null;
      Object localObject2;
      ErrorMessage localErrorMessage;
      try
      {
        Object localObject1 = localGson.a(paramString, ErrorMessage.class);
        localObject1 = (ErrorMessage)t.a(ErrorMessage.class).cast(localObject1);
        localObject2 = paramString;
      }
      catch (s locals)
      {
        localErrorMessage = new ErrorMessage();
        localObject2 = paramString;
      }
      String str2;
      for (;;)
      {
        str2 = str1;
        paramString = (String)localObject2;
        if (localErrorMessage != null)
        {
          String str3 = message;
          str2 = str1;
          paramString = (String)localObject2;
          if (str3 != null)
          {
            paramString = exception;
            if (paramString != null) {
              str1 = paramString;
            }
            try
            {
              localErrorMessage = (ErrorMessage)localGson.a(str3.substring(str3.indexOf('{')), ErrorMessage.class);
              localObject2 = str3;
            }
            catch (StringIndexOutOfBoundsException|s paramString)
            {
              paramString = str3;
              str2 = str1;
            }
          }
        }
      }
      str1 = paramString;
      if (str2 != null) {
        str1 = a.a(paramString, " ", str2);
      }
      return str1;
    }
    return "";
  }
  
  public static class ErrorMessage
  {
    @c("ExceptionMessage")
    public String exception;
    @c("Message")
    public String message;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.ErrorMessageParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */