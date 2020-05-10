package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractLogFactory
  implements LogFactory
{
  public Collection<CommonSchemaLog> toCommonSchemaLogs(Log paramLog)
  {
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */