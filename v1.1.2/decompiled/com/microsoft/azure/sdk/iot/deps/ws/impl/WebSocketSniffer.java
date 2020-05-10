package com.microsoft.azure.sdk.iot.deps.ws.impl;

import l.a.b.a.d.g0.l;
import l.a.b.a.d.g0.l0;

public class WebSocketSniffer
  extends l<l0, l0>
{
  public WebSocketSniffer(l0 paraml01, l0 paraml02)
  {
    super(paraml01, paraml02);
  }
  
  public int bufferSize()
  {
    return 6;
  }
  
  public l0 getSelectedTransportWrapper()
  {
    return _selectedTransportWrapper;
  }
  
  public void makeDetermination(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= bufferSize())
    {
      if (paramArrayOfByte[0] != -126)
      {
        _selectedTransportWrapper = _wrapper2;
        return;
      }
      _selectedTransportWrapper = _wrapper1;
      return;
    }
    throw new IllegalArgumentException("insufficient bytes");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketSniffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */