package com.microsoft.appcenter.ingestion.models;

import org.json.JSONObject;
import org.json.JSONStringer;

public abstract interface Model
{
  public abstract void read(JSONObject paramJSONObject);
  
  public abstract void write(JSONStringer paramJSONStringer);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.Model
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */