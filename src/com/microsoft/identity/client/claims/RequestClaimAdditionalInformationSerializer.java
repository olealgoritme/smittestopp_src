package com.microsoft.identity.client.claims;

import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import e.c.c.q;
import e.c.c.r;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class RequestClaimAdditionalInformationSerializer
  implements r<RequestedClaimAdditionalInformation>
{
  public j serialize(RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation, Type paramType, q paramq)
  {
    paramType = new m();
    paramType.a("essential", paramType.a(paramRequestedClaimAdditionalInformation.getEssential()));
    if (paramRequestedClaimAdditionalInformation.getValue() != null) {
      paramType.a("value", paramType.a(paramRequestedClaimAdditionalInformation.getValue().toString()));
    }
    if (paramRequestedClaimAdditionalInformation.getValues().size() > 0)
    {
      paramq = new g();
      Iterator localIterator = paramRequestedClaimAdditionalInformation.getValues().iterator();
      while (localIterator.hasNext())
      {
        paramRequestedClaimAdditionalInformation = localIterator.next().toString();
        List localList = x;
        if (paramRequestedClaimAdditionalInformation == null) {
          paramRequestedClaimAdditionalInformation = l.a;
        } else {
          paramRequestedClaimAdditionalInformation = new p(paramRequestedClaimAdditionalInformation);
        }
        localList.add(paramRequestedClaimAdditionalInformation);
      }
      paramType.a("values", paramq);
    }
    return paramType;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.RequestClaimAdditionalInformationSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */