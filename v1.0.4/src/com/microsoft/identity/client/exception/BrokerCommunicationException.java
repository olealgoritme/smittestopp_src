package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.exception.BaseException;

public class BrokerCommunicationException
  extends BaseException
{
  public BrokerCommunicationException(String paramString, Throwable paramThrowable)
  {
    super("io_error", paramString, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.exception.BrokerCommunicationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */