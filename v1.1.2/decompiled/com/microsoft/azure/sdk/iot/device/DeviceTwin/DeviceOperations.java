package com.microsoft.azure.sdk.iot.device.DeviceTwin;

public enum DeviceOperations
{
  static
  {
    DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST = new DeviceOperations("DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST", 4);
    DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE = new DeviceOperations("DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE", 5);
    DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST = new DeviceOperations("DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST", 6);
    DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_RESPONSE = new DeviceOperations("DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_RESPONSE", 7);
    DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST = new DeviceOperations("DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST", 8);
    DEVICE_OPERATION_METHOD_SUBSCRIBE_RESPONSE = new DeviceOperations("DEVICE_OPERATION_METHOD_SUBSCRIBE_RESPONSE", 9);
    DEVICE_OPERATION_METHOD_RECEIVE_REQUEST = new DeviceOperations("DEVICE_OPERATION_METHOD_RECEIVE_REQUEST", 10);
    DEVICE_OPERATION_METHOD_SEND_RESPONSE = new DeviceOperations("DEVICE_OPERATION_METHOD_SEND_RESPONSE", 11);
    DeviceOperations localDeviceOperations = new DeviceOperations("DEVICE_OPERATION_UNKNOWN", 12);
    DEVICE_OPERATION_UNKNOWN = localDeviceOperations;
    $VALUES = new DeviceOperations[] { DEVICE_OPERATION_TWIN_GET_REQUEST, DEVICE_OPERATION_TWIN_GET_RESPONSE, DEVICE_OPERATION_TWIN_UPDATE_REPORTED_PROPERTIES_REQUEST, DEVICE_OPERATION_TWIN_UPDATE_REPORTED_PROPERTIES_RESPONSE, DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST, DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_RESPONSE, DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST, DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_RESPONSE, DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST, DEVICE_OPERATION_METHOD_SUBSCRIBE_RESPONSE, DEVICE_OPERATION_METHOD_RECEIVE_REQUEST, DEVICE_OPERATION_METHOD_SEND_RESPONSE, localDeviceOperations };
  }
  
  public DeviceOperations() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */