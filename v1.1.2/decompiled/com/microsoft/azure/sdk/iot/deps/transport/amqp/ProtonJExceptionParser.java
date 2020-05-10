package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import l.a.b.a.b.n.j;
import l.a.b.a.d.g0.g;
import l.a.b.a.d.h;

public class ProtonJExceptionParser
{
  public static final String DEFAULT_ERROR_DESCRIPTION = "NoErrorDescription";
  public String error;
  public String errorDescription;
  
  public ProtonJExceptionParser(h paramh)
  {
    paramh = (g)paramh;
    getTransportExceptionFromProtonEndpoints(new l.a.b.a.d.f[] { paramh.p(), paramh.k(), paramh.T(), paramh.j(), paramh.y(), paramh.r() });
  }
  
  private j getErrorConditionFromEndpoint(l.a.b.a.d.f paramf)
  {
    if ((paramf.v() != null) && (va != null)) {
      paramf = paramf.v();
    } else {
      paramf = paramf.s();
    }
    return paramf;
  }
  
  private void getTransportExceptionFromProtonEndpoints(l.a.b.a.d.f... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        j localj = getErrorConditionFromEndpoint((l.a.b.a.d.f)localObject);
        if (localj != null)
        {
          localObject = a;
          if (localObject != null)
          {
            error = x;
            localObject = b;
            if (localObject != null) {
              errorDescription = ((String)localObject);
            } else {
              errorDescription = "NoErrorDescription";
            }
          }
        }
      }
    }
  }
  
  public String getError()
  {
    return error;
  }
  
  public String getErrorDescription()
  {
    return errorDescription;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.ProtonJExceptionParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */