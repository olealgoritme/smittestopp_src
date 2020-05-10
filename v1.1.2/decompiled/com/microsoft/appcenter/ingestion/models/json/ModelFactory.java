package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.List;

public abstract interface ModelFactory<M extends Model>
{
  public abstract M create();
  
  public abstract List<M> createList(int paramInt);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.ModelFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */