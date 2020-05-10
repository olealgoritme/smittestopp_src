package com.microsoft.identity.common.internal.authorities;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import e.a.a.a.a;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.m;
import java.lang.reflect.Type;

public class AzureActiveDirectoryAudienceDeserializer
  implements i<AzureActiveDirectoryAudience>
{
  public static final String TAG = "AzureActiveDirectoryAudienceDeserializer";
  
  public AzureActiveDirectoryAudience deserialize(j paramj, Type paramType, h paramh)
  {
    paramj = paramj.c();
    paramType = paramj.a("type");
    if (paramType != null)
    {
      paramType = paramType.f();
      int i = -1;
      switch (paramType.hashCode())
      {
      default: 
        break;
      case 2081443492: 
        if (paramType.equals("AzureADandPersonalMicrosoftAccount")) {
          i = 2;
        }
        break;
      case 2012013030: 
        if (paramType.equals("AzureADMyOrg")) {
          i = 0;
        }
        break;
      case 1997980721: 
        if (paramType.equals("AzureADMultipleOrgs")) {
          i = 1;
        }
        break;
      case -1852590113: 
        if (paramType.equals("PersonalMicrosoftAccount")) {
          i = 3;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              a.b(new StringBuilder(), TAG, ":deserialize", "Type: Unknown");
              return (AzureActiveDirectoryAudience)((TreeTypeAdapter.b)paramh).a(paramj, UnknownAudience.class);
            }
            a.b(new StringBuilder(), TAG, ":deserialize", "Type: PersonalMicrosoftAccount");
            return (AzureActiveDirectoryAudience)((TreeTypeAdapter.b)paramh).a(paramj, AnyPersonalAccount.class);
          }
          a.b(new StringBuilder(), TAG, ":deserialize", "Type: AzureADandPersonalMicrosoftAccount");
          return (AzureActiveDirectoryAudience)((TreeTypeAdapter.b)paramh).a(paramj, AllAccounts.class);
        }
        a.b(new StringBuilder(), TAG, ":deserialize", "Type: AzureADMultipleOrgs");
        return (AzureActiveDirectoryAudience)((TreeTypeAdapter.b)paramh).a(paramj, AnyOrganizationalAccount.class);
      }
      a.b(new StringBuilder(), TAG, ":deserialize", "Type: AzureADMyOrg");
      return (AzureActiveDirectoryAudience)((TreeTypeAdapter.b)paramh).a(paramj, AccountsInOneOrganization.class);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudienceDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */