package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractAccountCredentialCache
  implements IAccountCredentialCache
{
  public static final String NEW_LINE = "\n";
  public static final String TAG = "AbstractAccountCredentialCache";
  
  public static boolean targetsIntersect(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = paramString1.split("\\s+");
    String[] arrayOfString = paramString2.split("\\s+");
    HashSet localHashSet = new HashSet();
    paramString2 = new HashSet();
    int i = paramString1.length;
    int j = 0;
    for (int k = 0; k < i; k++) {
      localHashSet.add(paramString1[k].toLowerCase());
    }
    i = arrayOfString.length;
    for (k = j; k < i; k++) {
      paramString2.add(arrayOfString[k].toLowerCase());
    }
    if (paramBoolean)
    {
      localHashSet.removeAll(BaseController.DEFAULT_SCOPES);
      paramString2.removeAll(BaseController.DEFAULT_SCOPES);
    }
    return paramString2.containsAll(localHashSet);
  }
  
  public List<AccountRecord> getAccountsFilteredByInternal(String paramString1, String paramString2, String paramString3, List<AccountRecord> paramList)
  {
    boolean bool1 = StringExtensions.isNullOrBlank(paramString1) ^ true;
    boolean bool2 = StringExtensions.isNullOrBlank(paramString2);
    boolean bool3 = StringExtensions.isNullOrBlank(paramString3) ^ true;
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Account lookup filtered by home_account_id? [");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Account lookup filtered by realm? [");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append("]");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new ArrayList();
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (AccountRecord)((Iterator)localObject2).next();
      if (bool1) {
        bool4 = paramString1.equalsIgnoreCase(paramList.getHomeAccountId());
      } else {
        bool4 = true;
      }
      boolean bool5 = false;
      boolean bool6 = bool4;
      if ((bool2 ^ true)) {
        if ((bool4) && (paramString2.equalsIgnoreCase(paramList.getEnvironment()))) {
          bool6 = true;
        } else {
          bool6 = false;
        }
      }
      boolean bool4 = bool6;
      if (bool3)
      {
        bool4 = bool5;
        if (bool6)
        {
          bool4 = bool5;
          if (paramString3.equalsIgnoreCase(paramList.getRealm())) {
            bool4 = true;
          }
        }
      }
      if (bool4) {
        ((ArrayList)localObject1).add(paramList);
      }
    }
    paramString2 = TAG;
    paramString1 = a.a("Found [");
    paramString1.append(((ArrayList)localObject1).size());
    paramString1.append("] matching accounts");
    Logger.verbose(paramString2, paramString1.toString());
    return (List<AccountRecord>)localObject1;
  }
  
  public List<Credential> getCredentialsFilteredByInternal(String paramString1, String paramString2, CredentialType paramCredentialType, String paramString3, String paramString4, String paramString5, String paramString6, List<Credential> paramList)
  {
    boolean bool1 = StringExtensions.isNullOrBlank(paramString2);
    boolean bool2 = StringExtensions.isNullOrBlank(paramString1) ^ true;
    boolean bool3 = StringExtensions.isNullOrBlank(paramString4) ^ true;
    boolean bool4 = StringExtensions.isNullOrBlank(paramString5) ^ true;
    boolean bool5 = StringExtensions.isNullOrBlank(paramString3) ^ true;
    boolean bool6;
    if (paramCredentialType != null) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool7;
    if ((bool6) && (!StringExtensions.isNullOrBlank(paramString6)) && (paramCredentialType == CredentialType.AccessToken_With_AuthScheme)) {
      bool7 = true;
    } else {
      bool7 = false;
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Credential lookup filtered by home_account_id? [");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Credential lookup filtered by realm? [");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Credential lookup filtered by target? [");
    ((StringBuilder)localObject2).append(bool4);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Credential lookup filtered by clientId? [");
    ((StringBuilder)localObject2).append(bool5);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Credential lookup filtered by credential type? [");
    ((StringBuilder)localObject2).append(bool6);
    ((StringBuilder)localObject2).append("]");
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append("Credential lookup filtered by auth scheme? [");
    ((StringBuilder)localObject2).append(bool7);
    ((StringBuilder)localObject2).append("]");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = paramString4;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = (Credential)localIterator.next();
      if (bool2) {
        bool8 = paramString1.equalsIgnoreCase(((Credential)localObject2).getHomeAccountId());
      } else {
        bool8 = true;
      }
      if ((bool1 ^ true)) {
        if ((bool8) && (paramString2.equalsIgnoreCase(((Credential)localObject2).getEnvironment()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
      }
      boolean bool9 = bool8;
      if (bool6)
      {
        if ((bool8) && (paramCredentialType.name().equalsIgnoreCase(((Credential)localObject2).getCredentialType()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
        bool9 = bool8;
      }
      boolean bool10 = bool9;
      if (bool5)
      {
        if ((bool9) && (paramString3.equalsIgnoreCase(((Credential)localObject2).getClientId()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
        bool10 = bool8;
      }
      boolean bool8 = bool10;
      Object localObject3;
      if (bool3)
      {
        bool8 = bool10;
        if ((localObject2 instanceof AccessTokenRecord))
        {
          localObject3 = (AccessTokenRecord)localObject2;
          if ((bool10) && (paramList.equalsIgnoreCase(((AccessTokenRecord)localObject3).getRealm()))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
        }
      }
      bool10 = bool8;
      if (bool3)
      {
        bool10 = bool8;
        if ((localObject2 instanceof IdTokenRecord))
        {
          localObject3 = (IdTokenRecord)localObject2;
          if ((bool8) && (paramList.equalsIgnoreCase(((IdTokenRecord)localObject3).getRealm()))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
          bool10 = bool8;
        }
      }
      bool8 = bool10;
      if (bool4) {
        if ((localObject2 instanceof AccessTokenRecord))
        {
          paramList = (AccessTokenRecord)localObject2;
          if ((bool10) && (targetsIntersect(paramString5, paramList.getTarget(), true))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
        }
        else if ((localObject2 instanceof RefreshTokenRecord))
        {
          paramList = (RefreshTokenRecord)localObject2;
          if ((bool10) && (targetsIntersect(paramString5, paramList.getTarget(), true))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
        }
        else
        {
          Logger.warn(TAG, "Query specified target-match, but no target to match.");
          bool8 = bool10;
        }
      }
      if ((bool7) && ((localObject2 instanceof AccessTokenRecord)))
      {
        paramList = (AccessTokenRecord)localObject2;
        if ((bool8) && (paramString6.equalsIgnoreCase(paramList.getAccessTokenType()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
      }
      if (bool8) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    return (List<Credential>)localObject1;
  }
  
  public Class<? extends Credential> getTargetClassForCredentialType(String paramString, CredentialType paramCredentialType)
  {
    int i = paramCredentialType.ordinal();
    if (i != 0)
    {
      if (i != 1) {
        if ((i != 2) && (i != 3))
        {
          if (i != 7)
          {
            Logger.warn(TAG, "Could not match CredentialType to class. Did you forget to update this method with a new type?");
            if (paramString != null)
            {
              String str = TAG;
              paramCredentialType = new StringBuilder();
              paramCredentialType.append("Sought key was: [");
              paramCredentialType.append(paramString);
              paramCredentialType.append("]");
              Logger.warnPII(str, paramCredentialType.toString());
            }
            return null;
          }
        }
        else {
          return IdTokenRecord.class;
        }
      }
      paramString = AccessTokenRecord.class;
    }
    else
    {
      paramString = RefreshTokenRecord.class;
    }
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.AbstractAccountCredentialCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */