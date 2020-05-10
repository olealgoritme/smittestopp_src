package com.microsoft.identity.client.claims;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import e.c.c.j;
import e.c.c.m;
import e.c.c.q;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class ClaimsRequestSerializer
  implements e.c.c.r<ClaimsRequest>
{
  public void addPropertiesToObject(List<RequestedClaim> paramList, m paramm, q paramq)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (RequestedClaim)paramList.next();
      String str = ((RequestedClaim)localObject).getName();
      localObject = ((RequestedClaim)localObject).getAdditionalInformation();
      paramm.a(str, ((TreeTypeAdapter.b)paramq).a(localObject, RequestedClaimAdditionalInformation.class));
    }
  }
  
  public j serialize(ClaimsRequest paramClaimsRequest, Type paramType, q paramq)
  {
    paramType = new m();
    m localm1 = new m();
    m localm2 = new m();
    m localm3 = new m();
    addPropertiesToObject(paramClaimsRequest.getAccessTokenClaimsRequested(), localm2, paramq);
    addPropertiesToObject(paramClaimsRequest.getIdTokenClaimsRequested(), localm3, paramq);
    addPropertiesToObject(paramClaimsRequest.getUserInfoClaimsRequested(), localm1, paramq);
    if (a.z != 0) {
      paramType.a("userinfo", localm1);
    }
    if (a.z != 0) {
      paramType.a("id_token", localm3);
    }
    if (a.z != 0) {
      paramType.a("access_token", localm2);
    }
    return paramType;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.ClaimsRequestSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */