package com.microsoft.identity.common.adal.internal.tokensharing;

import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.m;
import e.c.c.n;
import e.c.c.p;
import e.c.c.q;
import java.lang.reflect.Type;

public final class TokenCacheItemSerializationAdapater
  implements i<ADALTokenCacheItem>, e.c.c.r<ADALTokenCacheItem>
{
  public static final String TAG = "TokenCacheItemSerializationAdapater";
  
  private void throwIfParameterMissing(m paramm, String paramString)
  {
    int i;
    if (a.a(paramString) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramm = new StringBuilder();
    paramm.append(TAG);
    paramm.append("Attribute ");
    paramm.append(paramString);
    paramm.append(" is missing for deserialization.");
    throw new n(paramm.toString());
  }
  
  public ADALTokenCacheItem deserialize(j paramj, Type paramType, h paramh)
  {
    paramType = paramj.c();
    throwIfParameterMissing(paramType, "authority");
    throwIfParameterMissing(paramType, "id_token");
    throwIfParameterMissing(paramType, "foci");
    throwIfParameterMissing(paramType, "refresh_token");
    paramj = paramType.a("id_token").f();
    paramh = new ADALTokenCacheItem();
    paramh.setAuthority(paramType.a("authority").f());
    paramh.setRawIdToken(paramj);
    paramh.setFamilyClientId(paramType.a("foci").f());
    paramh.setRefreshToken(paramType.a("refresh_token").f());
    return paramh;
  }
  
  public j serialize(ADALTokenCacheItem paramADALTokenCacheItem, Type paramType, q paramq)
  {
    paramType = new m();
    paramType.a("authority", new p(paramADALTokenCacheItem.getAuthority()));
    paramType.a("refresh_token", new p(paramADALTokenCacheItem.getRefreshToken()));
    paramType.a("id_token", new p(paramADALTokenCacheItem.getRawIdToken()));
    paramType.a("foci", new p(paramADALTokenCacheItem.getFamilyClientId()));
    return paramType;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.tokensharing.TokenCacheItemSerializationAdapater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */