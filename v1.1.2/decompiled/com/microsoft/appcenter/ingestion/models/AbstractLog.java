package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractLog
  implements Log
{
  public static final String DEVICE = "device";
  public static final String DISTRIBUTION_GROUP_ID = "distributionGroupId";
  public static final String SID = "sid";
  public static final String TIMESTAMP = "timestamp";
  public static final String USER_ID = "userId";
  public Device device;
  public String distributionGroupId;
  public UUID sid;
  public Object tag;
  public Date timestamp;
  public final Set<String> transmissionTargetTokens = new LinkedHashSet();
  public String userId;
  
  public void addTransmissionTarget(String paramString)
  {
    try
    {
      transmissionTargetTokens.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (AbstractLog)paramObject;
      if (!transmissionTargetTokens.equals(transmissionTargetTokens)) {
        return false;
      }
      Object localObject = timestamp;
      if (localObject != null ? !((Date)localObject).equals(timestamp) : timestamp != null) {
        return false;
      }
      localObject = sid;
      if (localObject != null ? !((UUID)localObject).equals(sid) : sid != null) {
        return false;
      }
      localObject = distributionGroupId;
      if (localObject != null ? !((String)localObject).equals(distributionGroupId) : distributionGroupId != null) {
        return false;
      }
      localObject = userId;
      if (localObject != null ? !((String)localObject).equals(userId) : userId != null) {
        return false;
      }
      localObject = device;
      if (localObject != null ? !((Device)localObject).equals(device) : device != null) {
        return false;
      }
      localObject = tag;
      paramObject = tag;
      if (localObject != null) {
        bool = localObject.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Device getDevice()
  {
    return device;
  }
  
  public String getDistributionGroupId()
  {
    return distributionGroupId;
  }
  
  public UUID getSid()
  {
    return sid;
  }
  
  public Object getTag()
  {
    return tag;
  }
  
  public Date getTimestamp()
  {
    return timestamp;
  }
  
  public Set<String> getTransmissionTargetTokens()
  {
    try
    {
      Set localSet = Collections.unmodifiableSet(transmissionTargetTokens);
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public int hashCode()
  {
    int i = transmissionTargetTokens.hashCode();
    Object localObject = timestamp;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((Date)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = sid;
    int m;
    if (localObject != null) {
      m = ((UUID)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = distributionGroupId;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = userId;
    int i1;
    if (localObject != null) {
      i1 = ((String)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = device;
    int i2;
    if (localObject != null) {
      i2 = ((Device)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = tag;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getString("type").equals(getType()))
    {
      setTimestamp(JSONDateUtils.toDate(paramJSONObject.getString("timestamp")));
      if (paramJSONObject.has("sid")) {
        setSid(UUID.fromString(paramJSONObject.getString("sid")));
      }
      setDistributionGroupId(paramJSONObject.optString("distributionGroupId", null));
      setUserId(paramJSONObject.optString("userId", null));
      if (paramJSONObject.has("device"))
      {
        Device localDevice = new Device();
        localDevice.read(paramJSONObject.getJSONObject("device"));
        setDevice(localDevice);
      }
      return;
    }
    throw new JSONException("Invalid type");
  }
  
  public void setDevice(Device paramDevice)
  {
    device = paramDevice;
  }
  
  public void setDistributionGroupId(String paramString)
  {
    distributionGroupId = paramString;
  }
  
  public void setSid(UUID paramUUID)
  {
    sid = paramUUID;
  }
  
  public void setTag(Object paramObject)
  {
    tag = paramObject;
  }
  
  public void setTimestamp(Date paramDate)
  {
    timestamp = paramDate;
  }
  
  public void setUserId(String paramString)
  {
    userId = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "type", getType());
    paramJSONStringer.key("timestamp").value(JSONDateUtils.toString(getTimestamp()));
    JSONUtils.write(paramJSONStringer, "sid", getSid());
    JSONUtils.write(paramJSONStringer, "distributionGroupId", getDistributionGroupId());
    JSONUtils.write(paramJSONStringer, "userId", getUserId());
    if (getDevice() != null)
    {
      paramJSONStringer.key("device").object();
      getDevice().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.AbstractLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */