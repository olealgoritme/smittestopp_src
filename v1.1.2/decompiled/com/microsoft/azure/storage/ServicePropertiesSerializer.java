package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLStreamWriter;

public final class ServicePropertiesSerializer
{
  public static String joinToString(Iterable<?> paramIterable, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localStringBuilder.append(paramIterable.next());
      if (paramIterable.hasNext()) {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] serializeToByteArray(ServiceProperties paramServiceProperties)
  {
    StringWriter localStringWriter = new StringWriter();
    XMLStreamWriter localXMLStreamWriter = Utility.createXMLStreamWriter(localStringWriter);
    localXMLStreamWriter.writeStartDocument();
    localXMLStreamWriter.writeStartElement("StorageServiceProperties");
    if (paramServiceProperties.getLogging() != null) {
      writeLoggingProperties(localXMLStreamWriter, paramServiceProperties.getLogging());
    }
    if (paramServiceProperties.getHourMetrics() != null) {
      writeMetricsProperties(localXMLStreamWriter, paramServiceProperties.getHourMetrics(), "HourMetrics");
    }
    if (paramServiceProperties.getMinuteMetrics() != null) {
      writeMetricsProperties(localXMLStreamWriter, paramServiceProperties.getMinuteMetrics(), "MinuteMetrics");
    }
    if (paramServiceProperties.getCors() != null) {
      writeCorsProperties(localXMLStreamWriter, paramServiceProperties.getCors());
    }
    if (paramServiceProperties.getDefaultServiceVersion() != null)
    {
      localXMLStreamWriter.writeStartElement("DefaultServiceVersion");
      localXMLStreamWriter.writeCharacters(paramServiceProperties.getDefaultServiceVersion());
      localXMLStreamWriter.writeEndElement();
    }
    if (paramServiceProperties.getDeleteRetentionPolicy() != null) {
      writeDeleteRetentionPolicy(localXMLStreamWriter, paramServiceProperties.getDeleteRetentionPolicy());
    }
    if (paramServiceProperties.getStaticWebsiteProperties() != null) {
      writeStaticWebsiteProperties(localXMLStreamWriter, paramServiceProperties.getStaticWebsiteProperties());
    }
    localXMLStreamWriter.writeEndElement();
    localXMLStreamWriter.writeEndDocument();
    try
    {
      paramServiceProperties = localStringWriter.toString().getBytes("UTF-8");
      return paramServiceProperties;
    }
    catch (UnsupportedEncodingException paramServiceProperties)
    {
      throw Utility.generateNewUnexpectedStorageException(paramServiceProperties);
    }
  }
  
  public static void writeCorsProperties(XMLStreamWriter paramXMLStreamWriter, CorsProperties paramCorsProperties)
  {
    Utility.assertNotNull("CorsRules", paramCorsProperties.getCorsRules());
    paramXMLStreamWriter.writeStartElement("Cors");
    Iterator localIterator = paramCorsProperties.getCorsRules().iterator();
    while (localIterator.hasNext())
    {
      paramCorsProperties = (CorsRule)localIterator.next();
      if ((!paramCorsProperties.getAllowedOrigins().isEmpty()) && (!paramCorsProperties.getAllowedMethods().isEmpty()) && (paramCorsProperties.getMaxAgeInSeconds() >= 0))
      {
        paramXMLStreamWriter.writeStartElement("CorsRule");
        paramXMLStreamWriter.writeStartElement("AllowedOrigins");
        paramXMLStreamWriter.writeCharacters(joinToString(paramCorsProperties.getAllowedOrigins(), ","));
        paramXMLStreamWriter.writeEndElement();
        paramXMLStreamWriter.writeStartElement("AllowedMethods");
        paramXMLStreamWriter.writeCharacters(joinToString(paramCorsProperties.getAllowedMethods(), ","));
        paramXMLStreamWriter.writeEndElement();
        paramXMLStreamWriter.writeStartElement("ExposedHeaders");
        paramXMLStreamWriter.writeCharacters(joinToString(paramCorsProperties.getExposedHeaders(), ","));
        paramXMLStreamWriter.writeEndElement();
        paramXMLStreamWriter.writeStartElement("AllowedHeaders");
        paramXMLStreamWriter.writeCharacters(joinToString(paramCorsProperties.getAllowedHeaders(), ","));
        paramXMLStreamWriter.writeEndElement();
        paramXMLStreamWriter.writeStartElement("MaxAgeInSeconds");
        paramXMLStreamWriter.writeCharacters(Integer.toString(paramCorsProperties.getMaxAgeInSeconds()));
        paramXMLStreamWriter.writeEndElement();
        paramXMLStreamWriter.writeEndElement();
      }
      else
      {
        throw new IllegalArgumentException("A CORS rule must contain at least one allowed origin and allowed method, and MaxAgeInSeconds cannot have a value less than zero.");
      }
    }
    paramXMLStreamWriter.writeEndElement();
  }
  
  public static void writeDeleteRetentionPolicy(XMLStreamWriter paramXMLStreamWriter, DeleteRetentionPolicy paramDeleteRetentionPolicy)
  {
    paramXMLStreamWriter.writeStartElement("DeleteRetentionPolicy");
    paramXMLStreamWriter.writeStartElement("Enabled");
    String str;
    if (paramDeleteRetentionPolicy.getEnabled()) {
      str = "true";
    } else {
      str = "false";
    }
    paramXMLStreamWriter.writeCharacters(str);
    paramXMLStreamWriter.writeEndElement();
    if (paramDeleteRetentionPolicy.getEnabled())
    {
      paramXMLStreamWriter.writeStartElement("Days");
      paramXMLStreamWriter.writeCharacters(paramDeleteRetentionPolicy.getRetentionIntervalInDays().toString());
      paramXMLStreamWriter.writeEndElement();
    }
    paramXMLStreamWriter.writeEndElement();
  }
  
  public static void writeLoggingProperties(XMLStreamWriter paramXMLStreamWriter, LoggingProperties paramLoggingProperties)
  {
    Utility.assertNotNull("logging.LogOperationTypes", paramLoggingProperties.getLogOperationTypes());
    paramXMLStreamWriter.writeStartElement("Logging");
    paramXMLStreamWriter.writeStartElement("Version");
    paramXMLStreamWriter.writeCharacters(paramLoggingProperties.getVersion());
    paramXMLStreamWriter.writeEndElement();
    paramXMLStreamWriter.writeStartElement("Delete");
    boolean bool = paramLoggingProperties.getLogOperationTypes().contains(LoggingOperations.DELETE);
    String str1 = "true";
    String str2;
    if (bool) {
      str2 = "true";
    } else {
      str2 = "false";
    }
    paramXMLStreamWriter.writeCharacters(str2);
    paramXMLStreamWriter.writeEndElement();
    paramXMLStreamWriter.writeStartElement("Read");
    if (paramLoggingProperties.getLogOperationTypes().contains(LoggingOperations.READ)) {
      str2 = "true";
    } else {
      str2 = "false";
    }
    paramXMLStreamWriter.writeCharacters(str2);
    paramXMLStreamWriter.writeEndElement();
    paramXMLStreamWriter.writeStartElement("Write");
    if (paramLoggingProperties.getLogOperationTypes().contains(LoggingOperations.WRITE)) {
      str2 = str1;
    } else {
      str2 = "false";
    }
    paramXMLStreamWriter.writeCharacters(str2);
    paramXMLStreamWriter.writeEndElement();
    writeRetentionPolicy(paramXMLStreamWriter, paramLoggingProperties.getRetentionIntervalInDays());
    paramXMLStreamWriter.writeEndElement();
  }
  
  public static void writeMetricsProperties(XMLStreamWriter paramXMLStreamWriter, MetricsProperties paramMetricsProperties, String paramString)
  {
    Utility.assertNotNull("metrics.Configuration", paramMetricsProperties.getMetricsLevel());
    paramXMLStreamWriter.writeStartElement(paramString);
    paramXMLStreamWriter.writeStartElement("Version");
    paramXMLStreamWriter.writeCharacters(paramMetricsProperties.getVersion());
    paramXMLStreamWriter.writeEndElement();
    paramXMLStreamWriter.writeStartElement("Enabled");
    MetricsLevel localMetricsLevel = paramMetricsProperties.getMetricsLevel();
    paramString = MetricsLevel.DISABLED;
    String str = "true";
    if (localMetricsLevel != paramString) {
      paramString = "true";
    } else {
      paramString = "false";
    }
    paramXMLStreamWriter.writeCharacters(paramString);
    paramXMLStreamWriter.writeEndElement();
    if (paramMetricsProperties.getMetricsLevel() != MetricsLevel.DISABLED)
    {
      paramXMLStreamWriter.writeStartElement("IncludeAPIs");
      if (paramMetricsProperties.getMetricsLevel() == MetricsLevel.SERVICE_AND_API) {
        paramString = str;
      } else {
        paramString = "false";
      }
      paramXMLStreamWriter.writeCharacters(paramString);
      paramXMLStreamWriter.writeEndElement();
    }
    writeRetentionPolicy(paramXMLStreamWriter, paramMetricsProperties.getRetentionIntervalInDays());
    paramXMLStreamWriter.writeEndElement();
  }
  
  public static void writeRetentionPolicy(XMLStreamWriter paramXMLStreamWriter, Integer paramInteger)
  {
    paramXMLStreamWriter.writeStartElement("RetentionPolicy");
    paramXMLStreamWriter.writeStartElement("Enabled");
    String str;
    if (paramInteger != null) {
      str = "true";
    } else {
      str = "false";
    }
    paramXMLStreamWriter.writeCharacters(str);
    paramXMLStreamWriter.writeEndElement();
    if (paramInteger != null)
    {
      paramXMLStreamWriter.writeStartElement("Days");
      paramXMLStreamWriter.writeCharacters(paramInteger.toString());
      paramXMLStreamWriter.writeEndElement();
    }
    paramXMLStreamWriter.writeEndElement();
  }
  
  public static void writeStaticWebsiteProperties(XMLStreamWriter paramXMLStreamWriter, StaticWebsiteProperties paramStaticWebsiteProperties)
  {
    paramXMLStreamWriter.writeStartElement("StaticWebsite");
    paramXMLStreamWriter.writeStartElement("Enabled");
    String str;
    if (paramStaticWebsiteProperties.getEnabled()) {
      str = "true";
    } else {
      str = "false";
    }
    paramXMLStreamWriter.writeCharacters(str);
    paramXMLStreamWriter.writeEndElement();
    if (paramStaticWebsiteProperties.getEnabled())
    {
      paramXMLStreamWriter.writeStartElement("IndexDocument");
      paramXMLStreamWriter.writeCharacters(paramStaticWebsiteProperties.getIndexDocument());
      paramXMLStreamWriter.writeEndElement();
      paramXMLStreamWriter.writeStartElement("ErrorDocument404Path");
      paramXMLStreamWriter.writeCharacters(paramStaticWebsiteProperties.getErrorDocument404Path());
      paramXMLStreamWriter.writeEndElement();
    }
    paramXMLStreamWriter.writeEndElement();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.ServicePropertiesSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */