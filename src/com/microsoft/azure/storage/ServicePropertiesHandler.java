package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class ServicePropertiesHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public final ServiceProperties props = new ServiceProperties();
  public int retentionPolicyDays;
  public boolean retentionPolicyEnabled;
  public CorsRule rule = new CorsRule();
  
  public static ServiceProperties readServicePropertiesFromStream(InputStream paramInputStream)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    ServicePropertiesHandler localServicePropertiesHandler = new ServicePropertiesHandler();
    props.setLogging(null);
    props.setHourMetrics(null);
    props.setMinuteMetrics(null);
    props.setCors(null);
    props.setDeleteRetentionPolicy(null);
    props.setStaticWebsiteProperties(null);
    localSAXParser.parse(paramInputStream, localServicePropertiesHandler);
    return props;
  }
  
  public static EnumSet<CorsHttpMethods> splitToEnumSet(String paramString1, String paramString2)
  {
    EnumSet localEnumSet = EnumSet.noneOf(CorsHttpMethods.class);
    paramString1 = new StringTokenizer(paramString1, paramString2);
    while (paramString1.hasMoreElements()) {
      localEnumSet.add(CorsHttpMethods.valueOf(paramString1.nextToken()));
    }
    return localEnumSet;
  }
  
  public static List<String> splitToList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = new StringTokenizer(paramString1, paramString2);
    while (paramString1.hasMoreElements()) {
      localArrayList.add(paramString1.nextToken());
    }
    return localArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    bld.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (String)elementStack.pop();
    if (paramString2.equals(localObject))
    {
      boolean bool = elementStack.isEmpty();
      paramString2 = null;
      if (!bool) {
        paramString1 = (String)elementStack.peek();
      } else {
        paramString1 = null;
      }
      paramString3 = bld.toString();
      if (!paramString3.isEmpty()) {
        paramString2 = paramString3;
      }
      if ((retentionPolicyEnabled) && ("RetentionPolicy".equals(localObject)))
      {
        if ("Logging".equals(paramString1)) {
          props.getLogging().setRetentionIntervalInDays(Integer.valueOf(retentionPolicyDays));
        } else if ("HourMetrics".equals(paramString1)) {
          props.getHourMetrics().setRetentionIntervalInDays(Integer.valueOf(retentionPolicyDays));
        } else if ("MinuteMetrics".equals(paramString1)) {
          props.getMinuteMetrics().setRetentionIntervalInDays(Integer.valueOf(retentionPolicyDays));
        }
      }
      else if ("CorsRule".equals(localObject))
      {
        props.getCors().getCorsRules().add(rule);
      }
      else if ("RetentionPolicy".equals(paramString1))
      {
        if ("Days".equals(localObject)) {
          retentionPolicyDays = Integer.parseInt(paramString2);
        } else if ("Enabled".equals(localObject)) {
          retentionPolicyEnabled = Boolean.parseBoolean(paramString2);
        }
      }
      else if ("Logging".equals(paramString1))
      {
        if ("Version".equals(localObject)) {
          props.getLogging().setVersion(paramString2);
        } else if ("Delete".equals(localObject))
        {
          if (Boolean.parseBoolean(paramString2)) {
            props.getLogging().getLogOperationTypes().add(LoggingOperations.DELETE);
          }
        }
        else if ("Read".equals(localObject))
        {
          if (Boolean.parseBoolean(paramString2)) {
            props.getLogging().getLogOperationTypes().add(LoggingOperations.READ);
          }
        }
        else if (("Write".equals(localObject)) && (Boolean.parseBoolean(paramString2))) {
          props.getLogging().getLogOperationTypes().add(LoggingOperations.WRITE);
        }
      }
      else if ("HourMetrics".equals(paramString1))
      {
        paramString3 = props.getHourMetrics();
        if ("Version".equals(localObject)) {
          paramString3.setVersion(paramString2);
        } else if ("Enabled".equals(localObject))
        {
          if (Boolean.parseBoolean(paramString2))
          {
            localObject = paramString3.getMetricsLevel();
            paramString2 = MetricsLevel.SERVICE_AND_API;
            paramString1 = paramString2;
            if (localObject != paramString2) {
              paramString1 = MetricsLevel.SERVICE;
            }
            paramString3.setMetricsLevel(paramString1);
          }
        }
        else if (("IncludeAPIs".equals(localObject)) && (Boolean.parseBoolean(paramString2)) && (paramString3.getMetricsLevel() != MetricsLevel.DISABLED)) {
          paramString3.setMetricsLevel(MetricsLevel.SERVICE_AND_API);
        }
      }
      else if ("MinuteMetrics".equals(paramString1))
      {
        paramString3 = props.getMinuteMetrics();
        if ("Version".equals(localObject)) {
          paramString3.setVersion(paramString2);
        } else if ("Enabled".equals(localObject))
        {
          if (Boolean.parseBoolean(paramString2))
          {
            localObject = paramString3.getMetricsLevel();
            paramString2 = MetricsLevel.SERVICE_AND_API;
            paramString1 = paramString2;
            if (localObject != paramString2) {
              paramString1 = MetricsLevel.SERVICE;
            }
            paramString3.setMetricsLevel(paramString1);
          }
        }
        else if (("IncludeAPIs".equals(localObject)) && (Boolean.parseBoolean(paramString2)) && (paramString3.getMetricsLevel() != MetricsLevel.DISABLED)) {
          paramString3.setMetricsLevel(MetricsLevel.SERVICE_AND_API);
        }
      }
      else if ("DefaultServiceVersion".equals(localObject))
      {
        props.setDefaultServiceVersion(paramString2);
      }
      else if ("CorsRule".equals(paramString1))
      {
        if ("AllowedOrigins".equals(localObject))
        {
          if (paramString2 != null) {
            rule.setAllowedOrigins(splitToList(paramString2, ","));
          }
        }
        else if ("AllowedMethods".equals(localObject))
        {
          if (paramString2 != null) {
            rule.setAllowedMethods(splitToEnumSet(paramString2, ","));
          }
        }
        else if ("ExposedHeaders".equals(localObject))
        {
          if (paramString2 != null) {
            rule.setExposedHeaders(splitToList(paramString2, ","));
          }
        }
        else if ("AllowedHeaders".equals(localObject))
        {
          if (paramString2 != null) {
            rule.setAllowedHeaders(splitToList(paramString2, ","));
          }
        }
        else if ("MaxAgeInSeconds".equals(localObject)) {
          rule.setMaxAgeInSeconds(Integer.parseInt(paramString2));
        }
      }
      else if ("DeleteRetentionPolicy".equals(paramString1))
      {
        if ("Enabled".equals(localObject))
        {
          if (paramString2 != null) {
            if (Boolean.parseBoolean(paramString2)) {
              props.getDeleteRetentionPolicy().setEnabled(true);
            } else {
              props.getDeleteRetentionPolicy().setEnabled(false);
            }
          }
        }
        else if (("Days".equals(localObject)) && (paramString2 != null)) {
          props.getDeleteRetentionPolicy().setRetentionIntervalInDays(Integer.valueOf(Integer.parseInt(paramString2)));
        }
      }
      else if ("StaticWebsite".equals(paramString1))
      {
        if ("Enabled".equals(localObject))
        {
          if (paramString2 != null) {
            props.getStaticWebsiteProperties().setEnabled(Boolean.parseBoolean(paramString2));
          }
        }
        else if ("IndexDocument".equals(localObject))
        {
          if (paramString2 != null) {
            props.getStaticWebsiteProperties().setIndexDocument(paramString2);
          }
        }
        else if (("ErrorDocument404Path".equals(localObject)) && (paramString2 != null)) {
          props.getStaticWebsiteProperties().setErrorDocument404Path(paramString2);
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
    if ("CorsRule".equals(paramString2)) {
      rule = new CorsRule();
    } else if ("Logging".equals(paramString2)) {
      props.setLogging(new LoggingProperties());
    } else if ("HourMetrics".equals(paramString2)) {
      props.setHourMetrics(new MetricsProperties());
    } else if ("MinuteMetrics".equals(paramString2)) {
      props.setMinuteMetrics(new MetricsProperties());
    } else if ("Cors".equals(paramString2)) {
      props.setCors(new CorsProperties());
    } else if ("DeleteRetentionPolicy".equals(paramString2)) {
      props.setDeleteRetentionPolicy(new DeleteRetentionPolicy());
    } else if ("StaticWebsite".equals(paramString2)) {
      props.setStaticWebsiteProperties(new StaticWebsiteProperties());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServicePropertiesHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */