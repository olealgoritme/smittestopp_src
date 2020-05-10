package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class ServiceStatsHandler
  extends DefaultHandler
{
  public static final String GEO_REPLICATION_NAME = "GeoReplication";
  public static final String LAST_SYNC_TIME_NAME = "LastSyncTime";
  public static final String STATUS_NAME = "Status";
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public final GeoReplicationStats geoReplicationStats = new GeoReplicationStats();
  public final ServiceStats stats = new ServiceStats();
  
  public static ServiceStats readServiceStatsFromStream(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    ServiceStatsHandler localServiceStatsHandler = new ServiceStatsHandler();
    localSAXParser.parse(paramInputStream, localServiceStatsHandler);
    return stats;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    bld.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = (String)elementStack.pop();
    if (paramString2.equals(paramString3))
    {
      paramString1 = bld.toString();
      boolean bool = paramString1.isEmpty();
      paramString2 = null;
      if (bool) {
        paramString1 = null;
      }
      if ("GeoReplication".equals(paramString3)) {
        stats.setGeoReplication(geoReplicationStats);
      } else if ("Status".equals(paramString3)) {
        geoReplicationStats.setStatus(GeoReplicationStatus.parse(paramString1));
      } else if ("LastSyncTime".equals(paramString3)) {
        try
        {
          paramString3 = geoReplicationStats;
          if (Utility.isNullOrEmpty(paramString1)) {
            paramString1 = paramString2;
          } else {
            paramString1 = Utility.parseRFC1123DateFromStringInGMT(paramString1);
          }
          paramString3.setLastSyncTime(paramString1);
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServiceStatsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */