package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.t;

public class SymmetricKeyParser
{
  public static final String PRIMARY_KEY_SERIALIZED_NAME = "primaryKey";
  public static final String SECONDARY_KEY_SERIALIZED_NAME = "secondaryKey";
  public transient Gson gson = new Gson();
  @c("primaryKey")
  public String primaryKey;
  @c("secondaryKey")
  public String secondaryKey;
  
  public SymmetricKeyParser() {}
  
  public SymmetricKeyParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, SymmetricKeyParser.class);
        paramString = (SymmetricKeyParser)t.a(SymmetricKeyParser.class).cast(paramString);
        if ((paramString.getPrimaryKeyFinal() != null) && (!paramString.getPrimaryKeyFinal().isEmpty()) && (paramString.getSecondaryKeyFinal() != null) && (!paramString.getSecondaryKeyFinal().isEmpty()))
        {
          primaryKey = primaryKey;
          secondaryKey = secondaryKey;
          return;
        }
        throw new IllegalArgumentException("Both the primary key and secondary key must be present and have a value in the provided json.");
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public SymmetricKeyParser(String paramString1, String paramString2)
  {
    primaryKey = paramString1;
    secondaryKey = paramString2;
  }
  
  @Deprecated
  public String getPrimaryKey()
  {
    return primaryKey;
  }
  
  public final String getPrimaryKeyFinal()
  {
    return primaryKey;
  }
  
  @Deprecated
  public String getSecondaryKey()
  {
    return secondaryKey;
  }
  
  public final String getSecondaryKeyFinal()
  {
    return secondaryKey;
  }
  
  public void setPrimaryKey(String paramString)
  {
    if (paramString != null)
    {
      primaryKey = paramString;
      return;
    }
    throw new IllegalArgumentException("primaryKey cannot be null.");
  }
  
  public void setSecondaryKey(String paramString)
  {
    if (paramString != null)
    {
      secondaryKey = paramString;
      return;
    }
    throw new IllegalArgumentException("secondaryKey cannot be null.");
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.SymmetricKeyParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */