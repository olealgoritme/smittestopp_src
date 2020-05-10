package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaDataUtils;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class EventLogFactory
  extends AbstractLogFactory
{
  public EventLog create()
  {
    return new EventLog();
  }
  
  public Collection<CommonSchemaLog> toCommonSchemaLogs(Log paramLog)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLog.getTransmissionTargetTokens().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      CommonSchemaEventLog localCommonSchemaEventLog = new CommonSchemaEventLog();
      EventLog localEventLog = (EventLog)paramLog;
      PartAUtils.setName(localCommonSchemaEventLog, localEventLog.getName());
      PartAUtils.addPartAFromLog(paramLog, localCommonSchemaEventLog, str);
      CommonSchemaDataUtils.addCommonSchemaData(localEventLog.getTypedProperties(), localCommonSchemaEventLog);
      localLinkedList.add(localCommonSchemaEventLog);
      localCommonSchemaEventLog.setTag(paramLog.getTag());
    }
    return localLinkedList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.ingestion.models.json.EventLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */