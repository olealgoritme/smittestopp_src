package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MetadataExtension
  implements Model
{
  public JSONObject mMetadata = new JSONObject();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (MetadataExtension.class == paramObject.getClass()))
    {
      paramObject = (MetadataExtension)paramObject;
      return mMetadata.toString().equals(mMetadata.toString());
    }
    return false;
  }
  
  public JSONObject getMetadata()
  {
    return mMetadata;
  }
  
  public int hashCode()
  {
    return mMetadata.toString().hashCode();
  }
  
  public void read(JSONObject paramJSONObject)
  {
    mMetadata = paramJSONObject;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    Iterator localIterator = mMetadata.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramJSONStringer.key(str).value(mMetadata.get(str));
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.MetadataExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */