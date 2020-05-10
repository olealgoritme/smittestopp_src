package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import k.a.b.a.b.n.j;
import k.a.b.a.d.g0.g;
import k.a.b.a.d.h;

public class ProtonJExceptionParser
{
  public static final String DEFAULT_ERROR_DESCRIPTION = "NoErrorDescription";
  public String error;
  public String errorDescription;
  
  public ProtonJExceptionParser(h paramh)
  {
    paramh = (g)paramh;
    getTransportExceptionFromProtonEndpoints(new k.a.b.a.d.f[] { paramh.o(), paramh.i(), paramh.U(), paramh.l(), paramh.T(), paramh.G() });
  }
  
  private j getErrorConditionFromEndpoint(k.a.b.a.d.f paramf)
  {
    if ((paramf.L() != null) && (La != null)) {
      paramf = paramf.L();
    } else {
      paramf = paramf.H();
    }
    return paramf;
  }
  
  private void getTransportExceptionFromProtonEndpoints(k.a.b.a.d.f... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        localObject = getErrorConditionFromEndpoint((k.a.b.a.d.f)localObject);
        if (localObject != null)
        {
          k.a.b.a.b.f localf = a;
          if (localf != null)
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.ProtonJExceptionParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */