package com.microsoft.identity.common.internal.authorities;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import e.a.a.a.a;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.m;
import java.lang.reflect.Type;

public class AuthorityDeserializer
  implements i<Authority>
{
  public static final String TAG = "AuthorityDeserializer";
  
  public Authority deserialize(j paramj, Type paramType, h paramh)
  {
    paramj = paramj.c();
    paramType = paramj.a("type");
    if (paramType != null)
    {
      paramType = paramType.f();
      int i = -1;
      int j = paramType.hashCode();
      if (j != 64548)
      {
        if (j != 65043)
        {
          if ((j == 2004016) && (paramType.equals("ADFS"))) {
            i = 2;
          }
        }
        else if (paramType.equals("B2C")) {
          i = 1;
        }
      }
      else if (paramType.equals("AAD")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            a.b(new StringBuilder(), TAG, ":deserialize", "Type: Unknown");
            return (Authority)((TreeTypeAdapter.b)paramh).a(paramj, UnknownAuthority.class);
          }
          a.b(new StringBuilder(), TAG, ":deserialize", "Type: ADFS");
          return (Authority)((TreeTypeAdapter.b)paramh).a(paramj, ActiveDirectoryFederationServicesAuthority.class);
        }
        a.b(new StringBuilder(), TAG, ":deserialize", "Type: B2C");
        return (Authority)((TreeTypeAdapter.b)paramh).a(paramj, AzureActiveDirectoryB2CAuthority.class);
      }
      a.b(new StringBuilder(), TAG, ":deserialize", "Type: AAD");
      paramType = (AzureActiveDirectoryAuthority)((TreeTypeAdapter.b)paramh).a(paramj, AzureActiveDirectoryAuthority.class);
      if (paramType != null)
      {
        paramj = mAudience;
        if (paramj != null) {
          paramj.setCloudUrl(mAuthorityUrl);
        }
      }
      return paramType;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authorities.AuthorityDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */