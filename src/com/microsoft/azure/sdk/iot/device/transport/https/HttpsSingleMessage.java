package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class HttpsSingleMessage
  implements HttpsMessage
{
  public static final String CONTENT_ENCODING_KEY = "iothub-contentencoding";
  public static final String CONTENT_TYPE_KEY = "iothub-contenttype";
  public static final String CORRELATION_ID_KEY = "iothub-correlationid";
  public static final String HTTPS_SINGLE_JSON_MESSAGE_CONTENT_TYPE = "application/json;charset=utf-8";
  public static final String HTTPS_SINGLE_MESSAGE_CONTENT_TYPE = "binary/octet-stream";
  public static final String MESSAGE_ID_KEY = "iothub-messageid";
  public static final String TO_KEY = "iothub-to";
  public static final String USER_ID_KEY = "iothub-userid";
  public boolean base64Encoded;
  public byte[] body;
  public String contentType;
  public MessageProperty[] properties;
  public Map<String, String> systemProperties;
  
  public static String httpsAppPropertyToAppProperty(String paramString)
  {
    String str = paramString.toLowerCase();
    paramString = str;
    if (str.startsWith("iothub-app-")) {
      paramString = str.substring(11);
    }
    return paramString;
  }
  
  public static boolean isValidHttpsAppProperty(String paramString1, String paramString2)
  {
    String str = paramString1.toLowerCase();
    boolean bool;
    if ((MessageProperty.isValidAppProperty(paramString1.toLowerCase(), paramString2)) && (str.startsWith("iothub-app-"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isValidHttpsSystemProperty(String paramString1, String paramString2)
  {
    String str = paramString1.toLowerCase();
    boolean bool;
    if ((MessageProperty.isValidSystemProperty(paramString1.toLowerCase(), paramString2)) && (str.startsWith("iothub-")) && (!str.startsWith("iothub-app-"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static HttpsSingleMessage parseHttpsJsonMessage(Message paramMessage)
  {
    HttpsSingleMessage localHttpsSingleMessage = new HttpsSingleMessage();
    contentType = "application/json;charset=utf-8";
    parser(localHttpsSingleMessage, paramMessage);
    return localHttpsSingleMessage;
  }
  
  public static HttpsSingleMessage parseHttpsMessage(Message paramMessage)
  {
    HttpsSingleMessage localHttpsSingleMessage = new HttpsSingleMessage();
    contentType = "binary/octet-stream";
    parser(localHttpsSingleMessage, paramMessage);
    return localHttpsSingleMessage;
  }
  
  public static HttpsSingleMessage parseHttpsMessage(HttpsResponse paramHttpsResponse)
  {
    HttpsSingleMessage localHttpsSingleMessage = new HttpsSingleMessage();
    Object localObject1 = paramHttpsResponse.getBody();
    body = Arrays.copyOf((byte[])localObject1, localObject1.length);
    ArrayList localArrayList = new ArrayList();
    localObject1 = new HashMap();
    paramHttpsResponse = paramHttpsResponse.getHeaderFields().entrySet().iterator();
    while (paramHttpsResponse.hasNext())
    {
      Object localObject2 = (Map.Entry)paramHttpsResponse.next();
      Object localObject3 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (isValidHttpsAppProperty((String)localObject3, (String)localObject2))
      {
        localArrayList.add(new MessageProperty((String)localObject3, (String)localObject2));
      }
      else if (isValidHttpsSystemProperty((String)localObject3, (String)localObject2))
      {
        String str = ((String)localObject3).substring(7);
        localObject3 = a.a("iothub-");
        ((StringBuilder)localObject3).append(str.toLowerCase());
        ((HashMap)localObject1).put(((StringBuilder)localObject3).toString(), localObject2);
      }
    }
    paramHttpsResponse = new MessageProperty[localArrayList.size()];
    properties = paramHttpsResponse;
    properties = ((MessageProperty[])localArrayList.toArray(paramHttpsResponse));
    systemProperties = ((Map)localObject1);
    return localHttpsSingleMessage;
  }
  
  public static void parser(HttpsSingleMessage paramHttpsSingleMessage, Message paramMessage)
  {
    Object localObject1 = paramMessage.getBytes();
    body = Arrays.copyOf((byte[])localObject1, localObject1.length);
    localObject1 = paramMessage.getProperties();
    properties = new MessageProperty[localObject1.length];
    for (int i = 0; i < localObject1.length; i++)
    {
      Object localObject2 = localObject1[i];
      MessageProperty[] arrayOfMessageProperty = properties;
      StringBuilder localStringBuilder = a.a("iothub-app-");
      localStringBuilder.append(((MessageProperty)localObject2).getName());
      arrayOfMessageProperty[i] = new MessageProperty(localStringBuilder.toString(), ((MessageProperty)localObject2).getValue());
    }
    localObject1 = new HashMap();
    if (paramMessage.getUserId() != null) {
      ((HashMap)localObject1).put("iothub-userid", paramMessage.getUserId());
    }
    if (paramMessage.getMessageId() != null) {
      ((HashMap)localObject1).put("iothub-messageid", paramMessage.getMessageId());
    }
    if (paramMessage.getCorrelationId() != null) {
      ((HashMap)localObject1).put("iothub-correlationid", paramMessage.getCorrelationId());
    }
    if (paramMessage.getTo() != null) {
      ((HashMap)localObject1).put("iothub-to", paramMessage.getTo());
    }
    if (paramMessage.getContentEncoding() != null) {
      ((HashMap)localObject1).put("iothub-contentencoding", paramMessage.getContentEncoding());
    }
    if (paramMessage.getContentType() != null) {
      ((HashMap)localObject1).put("iothub-contenttype", paramMessage.getContentType());
    }
    systemProperties = new HashMap((Map)localObject1);
  }
  
  public byte[] getBody()
  {
    byte[] arrayOfByte = body;
    return Arrays.copyOf(arrayOfByte, arrayOfByte.length);
  }
  
  public String getBodyAsString()
  {
    return new String(body, Message.DEFAULT_IOTHUB_MESSAGE_CHARSET);
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public MessageProperty[] getProperties()
  {
    int i = properties.length;
    MessageProperty[] arrayOfMessageProperty = new MessageProperty[i];
    for (int j = 0; j < i; j++)
    {
      MessageProperty localMessageProperty = properties[j];
      arrayOfMessageProperty[j] = new MessageProperty(localMessageProperty.getName(), localMessageProperty.getValue());
    }
    return arrayOfMessageProperty;
  }
  
  public Map<String, String> getSystemProperties()
  {
    return new HashMap(systemProperties);
  }
  
  public boolean isBase64Encoded()
  {
    return base64Encoded;
  }
  
  public Message toMessage()
  {
    Message localMessage = new Message(getBody());
    for (MessageProperty localMessageProperty : properties) {
      localMessage.setProperty(httpsAppPropertyToAppProperty(localMessageProperty.getName()), localMessageProperty.getValue());
    }
    if (systemProperties.containsKey("iothub-messageid")) {
      localMessage.setMessageId((String)systemProperties.get("iothub-messageid"));
    }
    if (systemProperties.containsKey("iothub-userid")) {
      localMessage.setProperty("iothub-app-iothub-userid", (String)systemProperties.get("iothub-userid"));
    }
    if (systemProperties.containsKey("iothub-correlationid")) {
      localMessage.setCorrelationId((String)systemProperties.get("iothub-correlationid"));
    }
    if (systemProperties.containsKey("iothub-contenttype")) {
      localMessage.setContentType((String)systemProperties.get("iothub-contenttype"));
    }
    if (systemProperties.containsKey("iothub-contentencoding")) {
      localMessage.setContentEncoding((String)systemProperties.get("iothub-contentencoding"));
    }
    if (systemProperties.containsKey("iothub-to")) {
      localMessage.setProperty("iothub-app-iothub-to", (String)systemProperties.get("iothub-to"));
    }
    return localMessage;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.https.HttpsSingleMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */