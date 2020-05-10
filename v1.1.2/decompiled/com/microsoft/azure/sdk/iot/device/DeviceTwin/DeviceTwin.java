package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.deps.twin.TwinCollection;
import com.microsoft.azure.sdk.iot.deps.twin.TwinMetadata;
import com.microsoft.azure.sdk.iot.deps.twin.TwinState;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceIO;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import e.c.c.j;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import l.f.b;
import l.f.c;

public class DeviceTwin
{
  public static final b log = c.a(DeviceTwin.class);
  public final Object DEVICE_TWIN_LOCK = new Object();
  public DeviceClientConfig config = null;
  public DeviceIO deviceIO = null;
  public PropertyCallBack<String, Object> deviceTwinGenericPropertyChangeCallback;
  public Object deviceTwinGenericPropertyChangeCallbackContext;
  public TwinPropertyCallBack deviceTwinGenericTwinPropertyChangeCallback;
  public IotHubEventCallback deviceTwinStatusCallback;
  public Object deviceTwinStatusCallbackContext;
  public boolean isSubscribed = false;
  public ConcurrentSkipListMap<String, Pair<PropertyCallBack<String, Object>, Object>> onDesiredPropertyChangeMap;
  public ConcurrentSkipListMap<String, Pair<TwinPropertyCallBack, Object>> onDesiredTwinPropertyChangeMap;
  public int requestId;
  
  public DeviceTwin(DeviceIO paramDeviceIO, DeviceClientConfig paramDeviceClientConfig, IotHubEventCallback paramIotHubEventCallback, Object paramObject1, PropertyCallBack paramPropertyCallBack, Object paramObject2)
  {
    deviceTwinInternal(paramDeviceIO, paramDeviceClientConfig, paramIotHubEventCallback, paramObject1, paramObject2);
    deviceTwinGenericPropertyChangeCallback = paramPropertyCallBack;
    deviceTwinGenericTwinPropertyChangeCallback = null;
  }
  
  public DeviceTwin(DeviceIO paramDeviceIO, DeviceClientConfig paramDeviceClientConfig, IotHubEventCallback paramIotHubEventCallback, Object paramObject1, TwinPropertyCallBack paramTwinPropertyCallBack, Object paramObject2)
  {
    deviceTwinInternal(paramDeviceIO, paramDeviceClientConfig, paramIotHubEventCallback, paramObject1, paramObject2);
    deviceTwinGenericTwinPropertyChangeCallback = paramTwinPropertyCallBack;
    deviceTwinGenericPropertyChangeCallback = null;
  }
  
  private void OnDesiredPropertyChanged(TwinCollection paramTwinCollection)
  {
    Object localObject = DEVICE_TWIN_LOCK;
    if (paramTwinCollection != null) {}
    try
    {
      Iterator localIterator = paramTwinCollection.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Property localProperty = getProperty(paramTwinCollection, (String)((Map.Entry)localIterator.next()).getKey(), false);
        if (!reportPropertyCallback(localProperty)) {
          reportDeviceTwinGenericPropertyCallback(localProperty);
        }
        localIterator.remove();
      }
      return;
    }
    finally {}
  }
  
  private void OnReportedPropertyChanged(TwinCollection paramTwinCollection)
  {
    Object localObject = DEVICE_TWIN_LOCK;
    if (paramTwinCollection != null) {}
    try
    {
      Iterator localIterator = paramTwinCollection.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Property localProperty = getProperty(paramTwinCollection, (String)((Map.Entry)localIterator.next()).getKey(), true);
        if (deviceTwinGenericTwinPropertyChangeCallback != null) {
          deviceTwinGenericTwinPropertyChangeCallback.TwinPropertyCallBack(localProperty, deviceTwinGenericPropertyChangeCallbackContext);
        }
        localIterator.remove();
      }
      return;
    }
    finally {}
  }
  
  private void checkSubscription()
  {
    if (!isSubscribed)
    {
      Object localObject = MessageType.DEVICE_TWIN;
      localObject = new IotHubTransportMessage(new byte[0], (MessageType)localObject);
      ((IotHubTransportMessage)localObject).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST);
      deviceIO.sendEventAsync((Message)localObject, new deviceTwinRequestMessageCallback(null), null, config.getDeviceId());
    }
  }
  
  private void deviceTwinInternal(DeviceIO paramDeviceIO, DeviceClientConfig paramDeviceClientConfig, IotHubEventCallback paramIotHubEventCallback, Object paramObject1, Object paramObject2)
  {
    if ((paramDeviceIO != null) && (paramDeviceClientConfig != null))
    {
      deviceIO = paramDeviceIO;
      config = paramDeviceClientConfig;
      paramDeviceClientConfig.setDeviceTwinMessageCallback(new deviceTwinResponseMessageCallback(null), null);
      requestId = 0;
      deviceTwinStatusCallback = paramIotHubEventCallback;
      deviceTwinStatusCallbackContext = paramObject1;
      deviceTwinGenericPropertyChangeCallbackContext = paramObject2;
      return;
    }
    throw new IllegalArgumentException("Client or config cannot be null");
  }
  
  private Property getProperty(TwinCollection paramTwinCollection, String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramTwinCollection.get(paramString);
    Integer localInteger = paramTwinCollection.getVersionFinal();
    Object localObject2 = paramTwinCollection.getTwinMetadataFinal(paramString);
    if (localObject2 != null)
    {
      paramTwinCollection = ((TwinMetadata)localObject2).getLastUpdated();
      localObject2 = ((TwinMetadata)localObject2).getLastUpdatedVersion();
    }
    else
    {
      paramTwinCollection = null;
      localObject2 = paramTwinCollection;
    }
    return new Property(paramString, localObject1, localInteger, paramBoolean, paramTwinCollection, (Integer)localObject2);
  }
  
  private boolean reportDeviceTwinGenericPropertyCallback(Property paramProperty)
  {
    Object localObject = deviceTwinGenericPropertyChangeCallback;
    if (localObject != null)
    {
      ((PropertyCallBack)localObject).PropertyCall(paramProperty.getKey(), paramProperty.getValue(), deviceTwinGenericPropertyChangeCallbackContext);
      return true;
    }
    localObject = deviceTwinGenericTwinPropertyChangeCallback;
    if (localObject != null)
    {
      ((TwinPropertyCallBack)localObject).TwinPropertyCallBack(paramProperty, deviceTwinGenericPropertyChangeCallbackContext);
      return true;
    }
    return false;
  }
  
  private boolean reportPropertyCallback(Property paramProperty)
  {
    Object localObject = onDesiredPropertyChangeMap;
    boolean bool1 = true;
    if ((localObject != null) && (((ConcurrentSkipListMap)localObject).containsKey(paramProperty.getKey())))
    {
      localObject = (Pair)onDesiredPropertyChangeMap.get(paramProperty.getKey());
      if ((localObject != null) && (((Pair)localObject).getKey() != null))
      {
        ((PropertyCallBack)((Pair)localObject).getKey()).PropertyCall(paramProperty.getKey(), paramProperty.getValue(), ((Pair)localObject).getValue());
        bool2 = true;
        break label81;
      }
    }
    boolean bool2 = false;
    label81:
    localObject = onDesiredTwinPropertyChangeMap;
    if ((localObject != null) && (((ConcurrentSkipListMap)localObject).containsKey(paramProperty.getKey())))
    {
      localObject = (Pair)onDesiredTwinPropertyChangeMap.get(paramProperty.getKey());
      if ((localObject != null) && (((Pair)localObject).getKey() != null))
      {
        ((TwinPropertyCallBack)((Pair)localObject).getKey()).TwinPropertyCallBack(paramProperty, ((Pair)localObject).getValue());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void getDeviceTwin()
  {
    checkSubscription();
    Object localObject = MessageType.DEVICE_TWIN;
    localObject = new IotHubTransportMessage(new byte[0], (MessageType)localObject);
    int i = requestId;
    requestId = (i + 1);
    ((IotHubTransportMessage)localObject).setRequestId(String.valueOf(i));
    ((IotHubTransportMessage)localObject).setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_GET_REQUEST);
    deviceIO.sendEventAsync((Message)localObject, new deviceTwinRequestMessageCallback(null), null, config.getDeviceId());
  }
  
  public void subscribeDesiredPropertiesNotification(Map<Property, Pair<PropertyCallBack<String, Object>, Object>> paramMap)
  {
    if (onDesiredPropertyChangeMap == null) {
      onDesiredPropertyChangeMap = new ConcurrentSkipListMap();
    }
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        onDesiredPropertyChangeMap.put(((Property)paramMap.getKey()).getKey(), paramMap.getValue());
      }
    }
    checkSubscription();
  }
  
  public void subscribeDesiredPropertiesTwinPropertyNotification(Map<Property, Pair<TwinPropertyCallBack, Object>> paramMap)
  {
    if (onDesiredTwinPropertyChangeMap == null) {
      onDesiredTwinPropertyChangeMap = new ConcurrentSkipListMap();
    }
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        onDesiredTwinPropertyChangeMap.put(((Property)paramMap.getKey()).getKey(), paramMap.getValue());
      }
    }
    checkSubscription();
  }
  
  public void updateReportedProperties(Set<Property> paramSet)
  {
    try
    {
      updateReportedProperties(paramSet, null);
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public void updateReportedProperties(Set<Property> paramSet, Integer paramInteger)
  {
    if (paramSet != null) {
      try
      {
        Object localObject = new com/microsoft/azure/sdk/iot/deps/twin/TwinCollection;
        ((TwinCollection)localObject).<init>();
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          paramSet = (Property)localIterator.next();
          if (!((HashMap)localObject).containsKey(paramSet.getKey()))
          {
            ((TwinCollection)localObject).putFinal(paramSet.getKey(), paramSet.getValue());
          }
          else
          {
            localObject = new java/io/IOException;
            paramInteger = new java/lang/StringBuilder;
            paramInteger.<init>();
            paramInteger.append("Duplicate keys found in reported properties: ");
            paramInteger.append(paramSet.getKey());
            ((IOException)localObject).<init>(paramInteger.toString());
            throw ((Throwable)localObject);
          }
        }
        localObject = ((TwinCollection)localObject).toJsonElement().toString();
        if (localObject == null) {
          return;
        }
        paramSet = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
        paramSet.<init>(((String)localObject).getBytes(), MessageType.DEVICE_TWIN);
        paramSet.setConnectionDeviceId(config.getDeviceId());
        int i = requestId;
        requestId = (i + 1);
        paramSet.setRequestId(String.valueOf(i));
        if (paramInteger != null) {
          paramSet.setVersion(Integer.toString(paramInteger.intValue()));
        }
        paramSet.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_TWIN_UPDATE_REPORTED_PROPERTIES_REQUEST);
        localObject = deviceIO;
        paramInteger = new com/microsoft/azure/sdk/iot/device/DeviceTwin/DeviceTwin$deviceTwinRequestMessageCallback;
        paramInteger.<init>(this, null);
        ((DeviceIO)localObject).sendEventAsync(paramSet, paramInteger, null, config.getDeviceId());
        return;
      }
      finally
      {
        break label244;
      }
    }
    paramSet = new java/lang/IllegalArgumentException;
    paramSet.<init>("Reported properties cannot be null");
    throw paramSet;
    label244:
    throw paramSet;
  }
  
  public final class deviceTwinRequestMessageCallback
    implements IotHubEventCallback
  {
    public deviceTwinRequestMessageCallback() {}
    
    public void execute(IotHubStatusCode paramIotHubStatusCode, Object arg2)
    {
      synchronized (DeviceTwin.access$000(DeviceTwin.this))
      {
        if ((paramIotHubStatusCode != IotHubStatusCode.OK) && (paramIotHubStatusCode != IotHubStatusCode.OK_EMPTY)) {
          DeviceTwin.access$200(DeviceTwin.this).execute(paramIotHubStatusCode, DeviceTwin.access$100(DeviceTwin.this));
        }
        return;
      }
    }
  }
  
  public final class deviceTwinResponseMessageCallback
    implements MessageCallback
  {
    public deviceTwinResponseMessageCallback() {}
    
    public IotHubMessageResult execute(Message paramMessage, Object paramObject)
    {
      synchronized (DeviceTwin.access$000(DeviceTwin.this))
      {
        paramObject = IotHubStatusCode.ERROR;
        if (paramMessage.getMessageType() != MessageType.DEVICE_TWIN)
        {
          System.out.print("Unexpected message type received");
          DeviceTwin.access$200(DeviceTwin.this).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(DeviceTwin.this));
          paramMessage = IotHubMessageResult.ABANDON;
          return paramMessage;
        }
        paramMessage = (IotHubTransportMessage)paramMessage;
        Object localObject2 = paramMessage.getStatus();
        int i = paramMessage.getDeviceOperationType().ordinal();
        if (i != 1)
        {
          if (i != 3)
          {
            if (i == 5)
            {
              DeviceTwin.access$602(DeviceTwin.this, true);
              paramObject = new java/lang/String;
              ((String)paramObject).<init>(paramMessage.getBytes(), Message.DEFAULT_IOTHUB_MESSAGE_CHARSET);
              paramMessage = TwinState.createFromDesiredPropertyJson((String)paramObject);
              if (paramMessage.getDesiredProperty() != null) {
                DeviceTwin.access$400(DeviceTwin.this, paramMessage.getDesiredProperty());
              }
            }
          }
          else
          {
            if (localObject2 != null) {
              paramObject = IotHubStatusCode.getIotHubStatusCode(Integer.parseInt((String)localObject2));
            }
            localObject2 = DeviceTwin.access$300();
            paramMessage = new java/lang/StringBuilder;
            paramMessage.<init>();
            paramMessage.append("Executing twin status callback for device operation twin update reported properties response with status ");
            paramMessage.append(paramObject);
            ((b)localObject2).d(paramMessage.toString());
            DeviceTwin.access$200(DeviceTwin.this).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(DeviceTwin.this));
          }
        }
        else
        {
          if (localObject2 != null) {
            paramObject = IotHubStatusCode.getIotHubStatusCode(Integer.parseInt((String)localObject2));
          }
          DeviceTwin.access$300().d("Executing twin callback for message {}", paramMessage);
          DeviceTwin.access$200(DeviceTwin.this).execute((IotHubStatusCode)paramObject, DeviceTwin.access$100(DeviceTwin.this));
          DeviceTwin.access$300().d("Twin callback returned for message {}", paramMessage);
          if (paramObject == IotHubStatusCode.OK)
          {
            paramObject = new java/lang/String;
            ((String)paramObject).<init>(paramMessage.getBytes(), Message.DEFAULT_IOTHUB_MESSAGE_CHARSET);
            paramMessage = TwinState.createFromPropertiesJson((String)paramObject);
            if (paramMessage.getDesiredProperty() != null) {
              DeviceTwin.access$400(DeviceTwin.this, paramMessage.getDesiredProperty());
            }
            if (paramMessage.getReportedProperty() != null) {
              DeviceTwin.access$500(DeviceTwin.this, paramMessage.getReportedProperty());
            }
          }
        }
        paramMessage = IotHubMessageResult.COMPLETE;
        return paramMessage;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceTwin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */