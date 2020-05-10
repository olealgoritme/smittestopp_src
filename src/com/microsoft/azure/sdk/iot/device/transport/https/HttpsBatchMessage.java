package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.deps.util.Base64;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubSizeExceededException;
import e.a.a.a.a;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class HttpsBatchMessage
  implements HttpsMessage
{
  public static final Charset BATCH_CHARSET = StandardCharsets.UTF_8;
  public static final String HTTPS_BATCH_CONTENT_TYPE = "application/vnd.microsoft.iothub.json";
  public static final int SERVICEBOUND_MESSAGE_MAX_SIZE_BYTES = 261119;
  public String batchBody = "[]";
  public int numMsgs = 0;
  
  public static String addJsonObjToArray(String paramString1, String paramString2)
  {
    if (paramString2.equals("[]")) {
      return a.a("[", paramString1, "]");
    }
    String str = paramString2.substring(0, paramString2.length() - 1);
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(",");
    paramString2.append(paramString1);
    paramString2.append("]");
    return paramString2.toString();
  }
  
  public static String msgToJson(HttpsSingleMessage paramHttpsSingleMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("\"body\":");
    localStringBuilder.append("\"");
    localStringBuilder.append(Base64.encodeBase64StringLocal(paramHttpsSingleMessage.getBody()));
    localStringBuilder.append("\",");
    localStringBuilder.append("\"base64Encoded\":");
    localStringBuilder.append(true);
    Object localObject = paramHttpsSingleMessage.getProperties();
    paramHttpsSingleMessage = new HashMap(paramHttpsSingleMessage.getSystemProperties());
    int i = localObject.length;
    Iterator localIterator;
    for (int j = 0; j < i; j++)
    {
      localIterator = localObject[j];
      paramHttpsSingleMessage.put(localIterator.getName(), localIterator.getValue());
    }
    if (paramHttpsSingleMessage.size() > 0)
    {
      localStringBuilder.append(",");
      localStringBuilder.append("\"properties\":");
      localStringBuilder.append("{");
      localIterator = paramHttpsSingleMessage.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("\":");
        localStringBuilder.append("\"");
        localStringBuilder.append((String)paramHttpsSingleMessage.get(localObject));
        localStringBuilder.append("\",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append("}");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void addMessage(HttpsSingleMessage paramHttpsSingleMessage)
  {
    String str = addJsonObjToArray(msgToJson(paramHttpsSingleMessage), batchBody);
    paramHttpsSingleMessage = str.getBytes(BATCH_CHARSET);
    if (paramHttpsSingleMessage.length <= 261119)
    {
      batchBody = str;
      numMsgs += 1;
      return;
    }
    throw new IotHubSizeExceededException(String.format("Service-bound message size (%d bytes) cannot exceed %d bytes.", new Object[] { Integer.valueOf(paramHttpsSingleMessage.length), Integer.valueOf(261119) }));
  }
  
  public byte[] getBody()
  {
    return batchBody.getBytes(BATCH_CHARSET);
  }
  
  public String getContentType()
  {
    return "application/vnd.microsoft.iothub.json";
  }
  
  public MessageProperty[] getProperties()
  {
    return new MessageProperty[0];
  }
  
  public Map<String, String> getSystemProperties()
  {
    return new HashMap();
  }
  
  public int numMessages()
  {
    return numMsgs;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.https.HttpsBatchMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */