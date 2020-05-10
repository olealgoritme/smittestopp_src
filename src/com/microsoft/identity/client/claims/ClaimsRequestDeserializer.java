package com.microsoft.identity.client.claims;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.w.r;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClaimsRequestDeserializer
  implements i<ClaimsRequest>
{
  private void addProperties(List<RequestedClaim> paramList, m paramm, h paramh)
  {
    if (paramm == null) {
      return;
    }
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      RequestedClaim localRequestedClaim = new RequestedClaim();
      localRequestedClaim.setName((String)localObject);
      if (!(paramm.a((String)localObject) instanceof l))
      {
        localObject = paramm.b((String)localObject);
        localRequestedClaim.setAdditionalInformation((RequestedClaimAdditionalInformation)((TreeTypeAdapter.b)paramh).a((j)localObject, RequestedClaimAdditionalInformation.class));
      }
      paramList.add(localRequestedClaim);
    }
  }
  
  public ClaimsRequest deserialize(j paramj, Type paramType, h paramh)
  {
    paramType = new ClaimsRequest();
    addProperties(paramType.getAccessTokenClaimsRequested(), paramj.c().b("access_token"), paramh);
    addProperties(paramType.getIdTokenClaimsRequested(), paramj.c().b("id_token"), paramh);
    addProperties(paramType.getUserInfoClaimsRequested(), paramj.c().b("userinfo"), paramh);
    return paramType;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.ClaimsRequestDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */