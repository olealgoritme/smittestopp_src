package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

public class SdkExtension
  implements Model
{
  public static final String EPOCH = "epoch";
  public static final String INSTALL_ID = "installId";
  public static final String LIB_VER = "libVer";
  public static final String SEQ = "seq";
  public String epoch;
  public UUID installId;
  public String libVer;
  public Long seq;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (SdkExtension.class == paramObject.getClass()))
    {
      paramObject = (SdkExtension)paramObject;
      Object localObject = libVer;
      if (localObject != null ? !((String)localObject).equals(libVer) : libVer != null) {
        return false;
      }
      localObject = epoch;
      if (localObject != null ? !((String)localObject).equals(epoch) : epoch != null) {
        return false;
      }
      localObject = seq;
      if (localObject != null ? !((Long)localObject).equals(seq) : seq != null) {
        return false;
      }
      localObject = installId;
      paramObject = installId;
      if (localObject != null) {
        bool = ((UUID)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getEpoch()
  {
    return epoch;
  }
  
  public UUID getInstallId()
  {
    return installId;
  }
  
  public String getLibVer()
  {
    return libVer;
  }
  
  public Long getSeq()
  {
    return seq;
  }
  
  public int hashCode()
  {
    Object localObject = libVer;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = epoch;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = seq;
    int m;
    if (localObject != null) {
      m = ((Long)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = installId;
    if (localObject != null) {
      i = ((UUID)localObject).hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setLibVer(paramJSONObject.optString("libVer", null));
    setEpoch(paramJSONObject.optString("epoch", null));
    setSeq(JSONUtils.readLong(paramJSONObject, "seq"));
    if (paramJSONObject.has("installId")) {
      setInstallId(UUID.fromString(paramJSONObject.getString("installId")));
    }
  }
  
  public void setEpoch(String paramString)
  {
    epoch = paramString;
  }
  
  public void setInstallId(UUID paramUUID)
  {
    installId = paramUUID;
  }
  
  public void setLibVer(String paramString)
  {
    libVer = paramString;
  }
  
  public void setSeq(Long paramLong)
  {
    seq = paramLong;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "libVer", getLibVer());
    JSONUtils.write(paramJSONStringer, "epoch", getEpoch());
    JSONUtils.write(paramJSONStringer, "seq", getSeq());
    JSONUtils.write(paramJSONStringer, "installId", getInstallId());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.SdkExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */