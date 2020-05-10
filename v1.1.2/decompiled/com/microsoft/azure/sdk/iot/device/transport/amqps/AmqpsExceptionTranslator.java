package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionForcedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionFramingErrorException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionRedirectException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionThrottledException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpDecodeErrorException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpFrameSizeTooSmallException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpIllegalStateException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpInternalErrorException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpInvalidFieldException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkDetachForcedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkMessageSizeExceededException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkRedirectException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkStolenException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkTransferLimitExceededException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotAllowedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotFoundException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotImplementedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpPreconditionFailedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceDeletedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceLimitExceededException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceLockedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionErrantLinkException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionHandleInUseException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionUnattachedHandleException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionWindowViolationException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpUnauthorizedAccessException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.ProtonIOException;

public class AmqpsExceptionTranslator
{
  public static TransportException convertToAmqpException(String paramString1, String paramString2)
  {
    switch (paramString1.hashCode())
    {
    default: 
      break;
    case 1997396401: 
      if (paramString1.equals("amqp:frame-size-too-small")) {
        i = 5;
      }
      break;
    case 1909122192: 
      if (paramString1.equals("com.microsoft:device-container-throttled")) {
        i = 25;
      }
      break;
    case 1866947320: 
      if (paramString1.equals("amqp:link:stolen")) {
        i = 12;
      }
      break;
    case 1757170094: 
      if (paramString1.equals("amqp:unauthorized-access")) {
        i = 23;
      }
      break;
    case 1729493304: 
      if (paramString1.equals("amqp:decode-error")) {
        i = 2;
      }
      break;
    case 1715227378: 
      if (paramString1.equals("amqp:session:errant-link")) {
        i = 4;
      }
      break;
    case 1498308533: 
      if (paramString1.equals("amqp:invalid-field")) {
        i = 10;
      }
      break;
    case 1454115665: 
      if (paramString1.equals("amqp:session:handle-in-use")) {
        i = 7;
      }
      break;
    case 1409597282: 
      if (paramString1.equals("amqp:link:detach-forced")) {
        i = 3;
      }
      break;
    case 1297013626: 
      if (paramString1.equals("amqp:resource-locked")) {
        i = 20;
      }
      break;
    case 647239021: 
      if (paramString1.equals("amqp:link:redirect")) {
        i = 11;
      }
      break;
    case 524967687: 
      if (paramString1.equals("amqp:internal-error")) {
        i = 9;
      }
      break;
    case 460572806: 
      if (paramString1.equals("amqp:connection:forced")) {
        i = 0;
      }
      break;
    case 339991958: 
      if (paramString1.equals("amqp:link:transfer-limit-exceeded")) {
        i = 21;
      }
      break;
    case 266840729: 
      if (paramString1.equals("amqp:not-found")) {
        i = 15;
      }
      break;
    case -252086493: 
      if (paramString1.equals("amqp:precondition-failed")) {
        i = 17;
      }
      break;
    case -582630695: 
      if (paramString1.equals("amqp:not-implemented")) {
        i = 16;
      }
      break;
    case -599032422: 
      if (paramString1.equals("proton:io")) {
        i = 26;
      }
      break;
    case -844084853: 
      if (paramString1.equals("amqp:illegal-state")) {
        i = 8;
      }
      break;
    case -879196315: 
      if (paramString1.equals("amqp:session:unattached-handle")) {
        i = 22;
      }
      break;
    case -889166443: 
      if (paramString1.equals("amqp:resource-limit-exceeded")) {
        i = 19;
      }
      break;
    case -945297093: 
      if (paramString1.equals("amqp:session:window-violation")) {
        i = 24;
      }
      break;
    case -1012255159: 
      if (paramString1.equals("amqp:connection:redirect")) {
        i = 1;
      }
      break;
    case -1310037224: 
      if (paramString1.equals("amqp:connection:framing-error")) {
        i = 6;
      }
      break;
    case -1500796161: 
      if (paramString1.equals("amqp:not-allowed")) {
        i = 14;
      }
      break;
    case -1530489431: 
      if (paramString1.equals("amqp:resource-deleted")) {
        i = 18;
      }
      break;
    case -1563519384: 
      if (paramString1.equals("amqp:link:message-size-exceeded")) {
        i = 13;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return new ProtocolException(paramString2);
    case 26: 
      return new ProtonIOException(paramString2);
    case 25: 
      return new AmqpConnectionThrottledException(paramString2);
    case 24: 
      return new AmqpSessionWindowViolationException(paramString2);
    case 23: 
      return new AmqpUnauthorizedAccessException(paramString2);
    case 22: 
      return new AmqpSessionUnattachedHandleException(paramString2);
    case 21: 
      return new AmqpLinkTransferLimitExceededException(paramString2);
    case 20: 
      return new AmqpResourceLockedException(paramString2);
    case 19: 
      return new AmqpResourceLimitExceededException(paramString2);
    case 18: 
      return new AmqpResourceDeletedException(paramString2);
    case 17: 
      return new AmqpPreconditionFailedException(paramString2);
    case 16: 
      return new AmqpNotImplementedException(paramString2);
    case 15: 
      return new AmqpNotFoundException(paramString2);
    case 14: 
      return new AmqpNotAllowedException(paramString2);
    case 13: 
      return new AmqpLinkMessageSizeExceededException(paramString2);
    case 12: 
      return new AmqpLinkStolenException(paramString2);
    case 11: 
      return new AmqpLinkRedirectException(paramString2);
    case 10: 
      return new AmqpInvalidFieldException(paramString2);
    case 9: 
      return new AmqpInternalErrorException(paramString2);
    case 8: 
      return new AmqpIllegalStateException(paramString2);
    case 7: 
      return new AmqpSessionHandleInUseException(paramString2);
    case 6: 
      return new AmqpConnectionFramingErrorException(paramString2);
    case 5: 
      return new AmqpFrameSizeTooSmallException(paramString2);
    case 4: 
      return new AmqpSessionErrantLinkException(paramString2);
    case 3: 
      return new AmqpLinkDetachForcedException(paramString2);
    case 2: 
      return new AmqpDecodeErrorException(paramString2);
    case 1: 
      return new AmqpConnectionRedirectException(paramString2);
    }
    return new AmqpConnectionForcedException(paramString2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsExceptionTranslator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */