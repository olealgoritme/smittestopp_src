package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Thread
  implements Model
{
  public List<StackFrame> frames;
  public long id;
  public String name;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Thread.class == paramObject.getClass()))
    {
      Object localObject = (Thread)paramObject;
      if (id != id) {
        return false;
      }
      paramObject = name;
      if (paramObject != null ? !((String)paramObject).equals(name) : name != null) {
        return false;
      }
      paramObject = frames;
      localObject = frames;
      if (paramObject != null) {
        bool = ((List)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public List<StackFrame> getFrames()
  {
    return frames;
  }
  
  public long getId()
  {
    return id;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int hashCode()
  {
    long l = id;
    int i = (int)(l ^ l >>> 32);
    Object localObject = name;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = frames;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setId(paramJSONObject.getLong("id"));
    setName(paramJSONObject.optString("name", null));
    setFrames(JSONUtils.readArray(paramJSONObject, "frames", StackFrameFactory.getInstance()));
  }
  
  public void setFrames(List<StackFrame> paramList)
  {
    frames = paramList;
  }
  
  public void setId(long paramLong)
  {
    id = paramLong;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "id", Long.valueOf(getId()));
    JSONUtils.write(paramJSONStringer, "name", getName());
    JSONUtils.writeArray(paramJSONStringer, "frames", getFrames());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.Thread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */