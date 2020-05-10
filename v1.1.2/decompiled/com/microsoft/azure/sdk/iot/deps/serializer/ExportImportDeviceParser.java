package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.deps.twin.TwinCollection;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class ExportImportDeviceParser
{
  public static final String AUTHENTICATION_NAME = "authentication";
  public static final String E_TAG_NAME = "eTag";
  public static final String ID_NAME = "id";
  public static final String IMPORT_MODE_NAME = "importMode";
  public static final String STATUS_NAME = "status";
  public static final String STATUS_REASON_NAME = "statusReason";
  public static final String TAGS_NAME = "tags";
  public static transient Gson gson = new Gson();
  @a(deserialize=true, serialize=true)
  @c("authentication")
  public AuthenticationParser authentication;
  @a(deserialize=true, serialize=true)
  @c("eTag")
  public String eTag;
  @a(deserialize=true, serialize=true)
  @c("id")
  public String id;
  @a(deserialize=true, serialize=true)
  @c("importMode")
  public String importMode;
  @a(deserialize=true, serialize=true)
  @c("status")
  public String status;
  @a(deserialize=true, serialize=true)
  @c("statusReason")
  public String statusReason;
  @a(deserialize=true, serialize=true)
  @c("tags")
  public TwinCollection tags;
  
  public ExportImportDeviceParser() {}
  
  public ExportImportDeviceParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, ExportImportDeviceParser.class);
        paramString = (ExportImportDeviceParser)t.a(ExportImportDeviceParser.class).cast(paramString);
        if (paramString.getIdFinal() != null)
        {
          if (paramString.getAuthenticationFinal() != null)
          {
            authentication = authentication;
            id = id;
            importMode = importMode;
            eTag = eTag;
            statusReason = statusReason;
            status = status;
            tags = tags;
            return;
          }
          throw new IllegalArgumentException("The authentication field must be present in the provided json");
        }
        throw new IllegalArgumentException("The id field must be present in the provided json");
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  @Deprecated
  public AuthenticationParser getAuthentication()
  {
    return authentication;
  }
  
  public final AuthenticationParser getAuthenticationFinal()
  {
    return authentication;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  @Deprecated
  public String getId()
  {
    return id;
  }
  
  public final String getIdFinal()
  {
    return id;
  }
  
  public String getImportMode()
  {
    return importMode;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getStatusReason()
  {
    return statusReason;
  }
  
  public TwinCollection getTags()
  {
    return tags;
  }
  
  public void setAuthentication(AuthenticationParser paramAuthenticationParser)
  {
    if (paramAuthenticationParser != null)
    {
      authentication = paramAuthenticationParser;
      return;
    }
    throw new IllegalArgumentException("Authentication cannot be null");
  }
  
  public void setETag(String paramString)
  {
    eTag = paramString;
  }
  
  public void setId(String paramString)
  {
    if (paramString != null)
    {
      id = paramString;
      return;
    }
    throw new IllegalArgumentException("Argument 'id' cannot be null");
  }
  
  public void setImportMode(String paramString)
  {
    importMode = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setStatusReason(String paramString)
  {
    statusReason = paramString;
  }
  
  public void setTags(TwinCollection paramTwinCollection)
  {
    tags = paramTwinCollection;
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.ExportImportDeviceParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */