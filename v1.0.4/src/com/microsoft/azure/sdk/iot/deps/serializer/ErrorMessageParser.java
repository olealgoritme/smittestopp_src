package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.a.a.a.a;
import e.c.c.e;
import e.c.c.s;
import e.c.c.w.t;

public class ErrorMessageParser
{
  public static String bestErrorMessage(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Gson localGson = new e().a();
      String str1 = null;
      ErrorMessageParser.ErrorMessage localErrorMessage;
      try
      {
        Object localObject1 = localGson.a(paramString, ErrorMessageParser.ErrorMessage.class);
        localObject1 = (ErrorMessageParser.ErrorMessage)t.a(ErrorMessageParser.ErrorMessage.class).cast(localObject1);
      }
      catch (s locals)
      {
        localErrorMessage = new ErrorMessageParser.ErrorMessage();
      }
      String str2;
      Object localObject2;
      for (;;)
      {
        str2 = str1;
        localObject2 = paramString;
        if (localErrorMessage != null)
        {
          String str3 = message;
          str2 = str1;
          localObject2 = paramString;
          if (str3 != null)
          {
            paramString = exception;
            if (paramString != null) {
              str1 = paramString;
            }
            try
            {
              localErrorMessage = (ErrorMessageParser.ErrorMessage)localGson.a(str3.substring(str3.indexOf('{')), ErrorMessageParser.ErrorMessage.class);
              paramString = str3;
            }
            catch (StringIndexOutOfBoundsException|s paramString)
            {
              localObject2 = str3;
              str2 = str1;
            }
          }
        }
      }
      paramString = (String)localObject2;
      if (str2 != null) {
        paramString = a.a((String)localObject2, " ", str2);
      }
      return paramString;
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.ErrorMessageParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */