package com.microsoft.azure.sdk.iot.device;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import l.f.b;
import l.f.c;

public final class MessageProperty
{
  public static final String CONNECTION_DEVICE_ID = "iothub-connection-device-id";
  public static final String CONNECTION_MODULE_ID = "iothub-connection-module-id";
  public static final String IOTHUB_CONTENT_ENCODING = "iothub-contentencoding";
  public static final String IOTHUB_CONTENT_TYPE = "iothub-contenttype";
  public static final String IOTHUB_CREATION_TIME_UTC = "iothub-creation-time-utc";
  public static final String IOTHUB_SECURITY_INTERFACE_ID = "iothub-interface-id";
  public static final String IOTHUB_SECURITY_INTERFACE_ID_VALUE = "urn:azureiot:Security:SecurityAgent:1";
  public static final String OUTPUT_NAME_PROPERTY = "iothub-outputname";
  public static final Set<String> RESERVED_PROPERTY_NAMES;
  public static final b log = c.a(MessageProperty.class);
  public String name;
  public String value;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("iothub-enqueuedtime");
    localHashSet.add("iothub-messagelocktoken");
    localHashSet.add("iothub-sequencenumber");
    localHashSet.add("iothub-operation");
    localHashSet.add("iothub-partition-key");
    localHashSet.add("iothub-ack");
    localHashSet.add("iothub-connection-device-id");
    localHashSet.add("iothub-connection-auth-method");
    localHashSet.add("iothub-connection-auth-generation-id");
    localHashSet.add("iothub-messageid");
    localHashSet.add("iothub-correlationid");
    localHashSet.add("iothub-userid");
    localHashSet.add("iothub-to");
    localHashSet.add("iothub-content-type");
    localHashSet.add("iothub-contenttype");
    localHashSet.add("iothub-content-encoding");
    localHashSet.add("iothub-contentencoding");
    localHashSet.add("iothub-absolute-expiry-time");
    localHashSet.add("IoThub-methodname");
    localHashSet.add("connectionDeviceId");
    localHashSet.add("connectionModuleId");
    localHashSet.add("iothub-outputname");
    localHashSet.add("iothub-inputname");
    localHashSet.add("iothub-connection-device-id");
    localHashSet.add("iothub-connection-module-id");
    RESERVED_PROPERTY_NAMES = Collections.unmodifiableSet(localHashSet);
  }
  
  public MessageProperty()
  {
    name = null;
    value = null;
  }
  
  public MessageProperty(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        if (usesValidChars(paramString1))
        {
          if (!RESERVED_PROPERTY_NAMES.contains(paramString1))
          {
            if (usesValidChars(paramString2))
            {
              name = paramString1;
              value = paramString2;
              return;
            }
            throw new IllegalArgumentException(String.format("%s is not a valid IoT Hub message property value.%n", new Object[] { paramString2 }));
          }
          throw new IllegalArgumentException(String.format("%s is a reserved IoT Hub message property name.%n", new Object[] { paramString1 }));
        }
        throw new IllegalArgumentException(String.format("%s is not a valid IoT Hub message property name. %n", new Object[] { paramString1 }));
      }
      throw new IllegalArgumentException("Property argument 'value' cannot be null.");
    }
    throw new IllegalArgumentException("Property argument 'name' cannot be null.");
  }
  
  public static boolean isValidAppProperty(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!RESERVED_PROPERTY_NAMES.contains(paramString1)) && (usesValidChars(paramString1)) && (usesValidChars(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isValidSystemProperty(String paramString1, String paramString2)
  {
    boolean bool;
    if ((RESERVED_PROPERTY_NAMES.contains(paramString1)) && (usesValidChars(paramString1)) && (usesValidChars(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean usesValidChars(String paramString)
  {
    return paramString.matches("\\p{ASCII}*");
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public boolean hasSameName(String paramString)
  {
    return getName().equalsIgnoreCase(paramString);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.MessageProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */