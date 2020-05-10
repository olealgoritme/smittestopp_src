package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.exceptions.BadFormatException;
import com.microsoft.azure.sdk.iot.device.exceptions.HubOrDeviceIdNotFoundException;
import com.microsoft.azure.sdk.iot.device.exceptions.InternalServerErrorException;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubServiceException;
import com.microsoft.azure.sdk.iot.device.exceptions.PreconditionFailedException;
import com.microsoft.azure.sdk.iot.device.exceptions.RequestEntityTooLargeException;
import com.microsoft.azure.sdk.iot.device.exceptions.ServerBusyException;
import com.microsoft.azure.sdk.iot.device.exceptions.ServiceUnknownException;
import com.microsoft.azure.sdk.iot.device.exceptions.ThrottledException;
import com.microsoft.azure.sdk.iot.device.exceptions.TooManyDevicesException;
import com.microsoft.azure.sdk.iot.device.exceptions.UnauthorizedException;

public enum IotHubStatusCode
{
  static
  {
    BAD_FORMAT = new IotHubStatusCode("BAD_FORMAT", 2);
    UNAUTHORIZED = new IotHubStatusCode("UNAUTHORIZED", 3);
    TOO_MANY_DEVICES = new IotHubStatusCode("TOO_MANY_DEVICES", 4);
    HUB_OR_DEVICE_ID_NOT_FOUND = new IotHubStatusCode("HUB_OR_DEVICE_ID_NOT_FOUND", 5);
    PRECONDITION_FAILED = new IotHubStatusCode("PRECONDITION_FAILED", 6);
    REQUEST_ENTITY_TOO_LARGE = new IotHubStatusCode("REQUEST_ENTITY_TOO_LARGE", 7);
    THROTTLED = new IotHubStatusCode("THROTTLED", 8);
    INTERNAL_SERVER_ERROR = new IotHubStatusCode("INTERNAL_SERVER_ERROR", 9);
    SERVER_BUSY = new IotHubStatusCode("SERVER_BUSY", 10);
    ERROR = new IotHubStatusCode("ERROR", 11);
    MESSAGE_EXPIRED = new IotHubStatusCode("MESSAGE_EXPIRED", 12);
    IotHubStatusCode localIotHubStatusCode = new IotHubStatusCode("MESSAGE_CANCELLED_ONCLOSE", 13);
    MESSAGE_CANCELLED_ONCLOSE = localIotHubStatusCode;
    $VALUES = new IotHubStatusCode[] { OK, OK_EMPTY, BAD_FORMAT, UNAUTHORIZED, TOO_MANY_DEVICES, HUB_OR_DEVICE_ID_NOT_FOUND, PRECONDITION_FAILED, REQUEST_ENTITY_TOO_LARGE, THROTTLED, INTERNAL_SERVER_ERROR, SERVER_BUSY, ERROR, MESSAGE_EXPIRED, localIotHubStatusCode };
  }
  
  public IotHubStatusCode() {}
  
  public static IotHubServiceException getConnectionStatusException(IotHubStatusCode paramIotHubStatusCode, String paramString)
  {
    switch (paramIotHubStatusCode.ordinal())
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("Service gave unknown status code: ");
      paramString.append(paramIotHubStatusCode);
      paramIotHubStatusCode = new IotHubServiceException(paramString.toString());
      break;
    case 11: 
      paramString = new StringBuilder();
      paramString.append("Service gave unknown status code: ");
      paramString.append(paramIotHubStatusCode);
      paramIotHubStatusCode = new ServiceUnknownException(paramString.toString());
      break;
    case 10: 
      paramIotHubStatusCode = new ServerBusyException(paramString);
      break;
    case 9: 
      paramIotHubStatusCode = new InternalServerErrorException(paramString);
      break;
    case 8: 
      paramIotHubStatusCode = new ThrottledException(paramString);
      break;
    case 7: 
      paramIotHubStatusCode = new RequestEntityTooLargeException(paramString);
      break;
    case 6: 
      paramIotHubStatusCode = new PreconditionFailedException(paramString);
      break;
    case 5: 
      paramIotHubStatusCode = new HubOrDeviceIdNotFoundException(paramString);
      break;
    case 4: 
      paramIotHubStatusCode = new TooManyDevicesException(paramString);
      break;
    case 3: 
      paramIotHubStatusCode = new UnauthorizedException(paramString);
      break;
    case 2: 
      paramIotHubStatusCode = new BadFormatException(paramString);
      break;
    }
    paramIotHubStatusCode = null;
    return paramIotHubStatusCode;
  }
  
  public static IotHubStatusCode getIotHubStatusCode(int paramInt)
  {
    IotHubStatusCode localIotHubStatusCode;
    if (paramInt != 200)
    {
      if (paramInt != 204)
      {
        if (paramInt != 429)
        {
          if (paramInt != 500)
          {
            if (paramInt != 503)
            {
              if (paramInt != 400)
              {
                if (paramInt != 401)
                {
                  if (paramInt != 403)
                  {
                    if (paramInt != 404)
                    {
                      if (paramInt != 412)
                      {
                        if (paramInt != 413) {
                          localIotHubStatusCode = ERROR;
                        } else {
                          localIotHubStatusCode = REQUEST_ENTITY_TOO_LARGE;
                        }
                      }
                      else {
                        localIotHubStatusCode = PRECONDITION_FAILED;
                      }
                    }
                    else {
                      localIotHubStatusCode = HUB_OR_DEVICE_ID_NOT_FOUND;
                    }
                  }
                  else {
                    localIotHubStatusCode = TOO_MANY_DEVICES;
                  }
                }
                else {
                  localIotHubStatusCode = UNAUTHORIZED;
                }
              }
              else {
                localIotHubStatusCode = BAD_FORMAT;
              }
            }
            else {
              localIotHubStatusCode = SERVER_BUSY;
            }
          }
          else {
            localIotHubStatusCode = INTERNAL_SERVER_ERROR;
          }
        }
        else {
          localIotHubStatusCode = THROTTLED;
        }
      }
      else {
        localIotHubStatusCode = OK_EMPTY;
      }
    }
    else {
      localIotHubStatusCode = OK;
    }
    return localIotHubStatusCode;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubStatusCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */