package com.microsoft.appcenter.crashes.ingestion.models;

import android.util.Base64;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ErrorAttachmentLog
  extends AbstractLog
{
  public static final Charset CHARSET = Charset.forName("UTF-8");
  public static final String CONTENT_TYPE = "contentType";
  public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
  public static final String DATA = "data";
  public static final String ERROR_ID = "errorId";
  public static final String FILE_NAME = "fileName";
  public static final String TYPE = "errorAttachment";
  public String contentType;
  public byte[] data;
  public UUID errorId;
  public String fileName;
  public UUID id;
  
  public static ErrorAttachmentLog attachmentWithBinary(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    ErrorAttachmentLog localErrorAttachmentLog = new ErrorAttachmentLog();
    localErrorAttachmentLog.setData(paramArrayOfByte);
    localErrorAttachmentLog.setFileName(paramString1);
    localErrorAttachmentLog.setContentType(paramString2);
    return localErrorAttachmentLog;
  }
  
  public static ErrorAttachmentLog attachmentWithText(String paramString1, String paramString2)
  {
    return attachmentWithBinary(paramString1.getBytes(CHARSET), paramString2, "text/plain");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ErrorAttachmentLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (ErrorAttachmentLog)paramObject;
      Object localObject = id;
      if (localObject != null ? !((UUID)localObject).equals(id) : id != null) {
        return false;
      }
      localObject = errorId;
      if (localObject != null ? !((UUID)localObject).equals(errorId) : errorId != null) {
        return false;
      }
      localObject = contentType;
      if (localObject != null ? !((String)localObject).equals(contentType) : contentType != null) {
        return false;
      }
      localObject = fileName;
      if (localObject != null ? !((String)localObject).equals(fileName) : fileName != null) {
        return false;
      }
      return Arrays.equals(data, data);
    }
    return false;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public byte[] getData()
  {
    return data;
  }
  
  public UUID getErrorId()
  {
    return errorId;
  }
  
  public String getFileName()
  {
    return fileName;
  }
  
  public UUID getId()
  {
    return id;
  }
  
  public String getType()
  {
    return "errorAttachment";
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = id;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((UUID)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = errorId;
    int m;
    if (localObject != null) {
      m = ((UUID)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = contentType;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = fileName;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    }
    return Arrays.hashCode(data) + ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + j) * 31;
  }
  
  public boolean isValid()
  {
    boolean bool;
    if ((getId() != null) && (getErrorId() != null) && (getContentType() != null) && (getData() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setId(UUID.fromString(paramJSONObject.getString("id")));
    setErrorId(UUID.fromString(paramJSONObject.getString("errorId")));
    setContentType(paramJSONObject.getString("contentType"));
    setFileName(paramJSONObject.optString("fileName", null));
    try
    {
      setData(Base64.decode(paramJSONObject.getString("data"), 0));
      return;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      throw new JSONException(paramJSONObject.getMessage());
    }
  }
  
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    data = paramArrayOfByte;
  }
  
  public void setErrorId(UUID paramUUID)
  {
    errorId = paramUUID;
  }
  
  public void setFileName(String paramString)
  {
    fileName = paramString;
  }
  
  public void setId(UUID paramUUID)
  {
    id = paramUUID;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    JSONUtils.write(paramJSONStringer, "id", getId());
    JSONUtils.write(paramJSONStringer, "errorId", getErrorId());
    JSONUtils.write(paramJSONStringer, "contentType", getContentType());
    JSONUtils.write(paramJSONStringer, "fileName", getFileName());
    JSONUtils.write(paramJSONStringer, "data", Base64.encodeToString(getData(), 2));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */