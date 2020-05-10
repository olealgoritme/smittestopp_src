package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.t;
import java.io.IOException;

public class JobQueryResponseError
{
  public static final String CODE_TAG = "code";
  public static final String DESCRIPTION_TAG = "description";
  @c("code")
  public String code;
  @c("description")
  public String description;
  
  public JobQueryResponseError fromJson(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = new e();
      l = false;
      localObject = ((e)localObject).a();
      try
      {
        paramString = ((Gson)localObject).a(paramString, JobQueryResponseError.class);
        paramString = (JobQueryResponseError)t.a(JobQueryResponseError.class).cast(paramString);
        localObject = code;
        if ((localObject != null) && (!((String)localObject).isEmpty()))
        {
          if (description != null) {
            return paramString;
          }
          throw new IllegalArgumentException("Json does not contains description");
        }
        throw new IllegalArgumentException("Json does not contains code");
      }
      catch (s paramString)
      {
        throw new IOException("Not a valid json");
      }
    }
    throw new IllegalArgumentException("Json is null or empty");
  }
  
  public String getCode()
  {
    return code;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String toJson()
  {
    e locale = new e();
    g = true;
    return locale.a().a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.JobQueryResponseError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */