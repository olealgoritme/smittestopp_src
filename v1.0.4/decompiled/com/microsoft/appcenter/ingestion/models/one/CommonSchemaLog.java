package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class CommonSchemaLog
  extends AbstractLog
{
  public static final String CV = "cV";
  public static final String DATA = "data";
  public static final String EXT = "ext";
  public static final String FLAGS = "flags";
  public static final String IKEY = "iKey";
  public static final String NAME = "name";
  public static final String POP_SAMPLE = "popSample";
  public static final String TIME = "time";
  public static final String VER = "ver";
  public String cV;
  public Data data;
  public Extensions ext;
  public Long flags;
  public String iKey;
  public String name;
  public Double popSample;
  public String ver;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (CommonSchemaLog)paramObject;
      Object localObject = ver;
      if (localObject != null ? !((String)localObject).equals(ver) : ver != null) {
        return false;
      }
      localObject = name;
      if (localObject != null ? !((String)localObject).equals(name) : name != null) {
        return false;
      }
      localObject = popSample;
      if (localObject != null ? !((Double)localObject).equals(popSample) : popSample != null) {
        return false;
      }
      localObject = iKey;
      if (localObject != null ? !((String)localObject).equals(iKey) : iKey != null) {
        return false;
      }
      localObject = flags;
      if (localObject != null ? !((Long)localObject).equals(flags) : flags != null) {
        return false;
      }
      localObject = cV;
      if (localObject != null ? !((String)localObject).equals(cV) : cV != null) {
        return false;
      }
      localObject = ext;
      if (localObject != null ? !((Extensions)localObject).equals(ext) : ext != null) {
        return false;
      }
      localObject = data;
      paramObject = data;
      if (localObject != null) {
        bool = ((Data)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getCV()
  {
    return cV;
  }
  
  public Data getData()
  {
    return data;
  }
  
  public Extensions getExt()
  {
    return ext;
  }
  
  public Long getFlags()
  {
    return flags;
  }
  
  public String getIKey()
  {
    return iKey;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Double getPopSample()
  {
    return popSample;
  }
  
  public String getVer()
  {
    return ver;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = ver;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = name;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = popSample;
    int n;
    if (localObject != null) {
      n = ((Double)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = iKey;
    int i1;
    if (localObject != null) {
      i1 = ((String)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = flags;
    int i2;
    if (localObject != null) {
      i2 = ((Long)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = cV;
    int i3;
    if (localObject != null) {
      i3 = ((String)localObject).hashCode();
    } else {
      i3 = 0;
    }
    localObject = ext;
    int i4;
    if (localObject != null) {
      i4 = ((Extensions)localObject).hashCode();
    } else {
      i4 = 0;
    }
    localObject = data;
    if (localObject != null) {
      j = ((Data)localObject).hashCode();
    }
    return (((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setVer(paramJSONObject.getString("ver"));
    setName(paramJSONObject.getString("name"));
    setTimestamp(JSONDateUtils.toDate(paramJSONObject.getString("time")));
    if (paramJSONObject.has("popSample")) {
      setPopSample(Double.valueOf(paramJSONObject.getDouble("popSample")));
    }
    setIKey(paramJSONObject.optString("iKey", null));
    setFlags(JSONUtils.readLong(paramJSONObject, "flags"));
    setCV(paramJSONObject.optString("cV", null));
    Object localObject;
    if (paramJSONObject.has("ext"))
    {
      localObject = new Extensions();
      ((Extensions)localObject).read(paramJSONObject.getJSONObject("ext"));
      setExt((Extensions)localObject);
    }
    if (paramJSONObject.has("data"))
    {
      localObject = new Data();
      ((Data)localObject).read(paramJSONObject.getJSONObject("data"));
      setData((Data)localObject);
    }
  }
  
  public void setCV(String paramString)
  {
    cV = paramString;
  }
  
  public void setData(Data paramData)
  {
    data = paramData;
  }
  
  public void setExt(Extensions paramExtensions)
  {
    ext = paramExtensions;
  }
  
  public void setFlags(Long paramLong)
  {
    flags = paramLong;
  }
  
  public void setIKey(String paramString)
  {
    iKey = paramString;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setPopSample(Double paramDouble)
  {
    popSample = paramDouble;
  }
  
  public void setVer(String paramString)
  {
    ver = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    paramJSONStringer.key("ver").value(getVer());
    paramJSONStringer.key("name").value(getName());
    paramJSONStringer.key("time").value(JSONDateUtils.toString(getTimestamp()));
    JSONUtils.write(paramJSONStringer, "popSample", getPopSample());
    JSONUtils.write(paramJSONStringer, "iKey", getIKey());
    JSONUtils.write(paramJSONStringer, "flags", getFlags());
    JSONUtils.write(paramJSONStringer, "cV", getCV());
    if (getExt() != null)
    {
      paramJSONStringer.key("ext").object();
      getExt().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    if (getData() != null)
    {
      paramJSONStringer.key("data").object();
      getData().write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */