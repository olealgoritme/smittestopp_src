package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.t;

public class X509ThumbprintParser
{
  public static final String PRIMARY_THUMBPRINT_SERIALIZED_NAME = "primaryThumbprint";
  public static final String SECONDARY_THUMBPRINT_SERIALIZED_NAME = "secondaryThumbprint";
  public transient Gson gson = new Gson();
  @c("primaryThumbprint")
  public String primaryThumbprint;
  @c("secondaryThumbprint")
  public String secondaryThumbprint;
  
  public X509ThumbprintParser() {}
  
  public X509ThumbprintParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, X509ThumbprintParser.class);
        paramString = (X509ThumbprintParser)t.a(X509ThumbprintParser.class).cast(paramString);
        primaryThumbprint = paramString.getPrimaryThumbprintFinal();
        secondaryThumbprint = paramString.getSecondaryThumbprintFinal();
        return;
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided Json must not be null or empty");
  }
  
  public X509ThumbprintParser(String paramString1, String paramString2)
  {
    primaryThumbprint = paramString1;
    secondaryThumbprint = paramString2;
  }
  
  @Deprecated
  public String getPrimaryThumbprint()
  {
    return primaryThumbprint;
  }
  
  public final String getPrimaryThumbprintFinal()
  {
    return primaryThumbprint;
  }
  
  @Deprecated
  public String getSecondaryThumbprint()
  {
    return secondaryThumbprint;
  }
  
  public final String getSecondaryThumbprintFinal()
  {
    return secondaryThumbprint;
  }
  
  public void setPrimaryThumbprint(String paramString)
  {
    if (paramString != null)
    {
      primaryThumbprint = paramString;
      return;
    }
    throw new IllegalArgumentException("Primary thumbprint cannot be null or empty");
  }
  
  public void setSecondaryThumbprint(String paramString)
  {
    if (paramString != null)
    {
      secondaryThumbprint = paramString;
      return;
    }
    throw new IllegalArgumentException("Secondary thumbprint cannot be null or empty");
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.X509ThumbprintParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */