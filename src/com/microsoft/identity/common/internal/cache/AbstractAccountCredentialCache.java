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
    paramString2 = new HashSet();
    HashSet localHashSet = new HashSet();
    int i = paramString1.length;
    int j = 0;
    for (int k = 0; k < i; k++) {
      paramString2.add(paramString1[k].toLowerCase());
    }
    i = arrayOfString.length;
    for (k = j; k < i; k++) {
      localHashSet.add(arrayOfString[k].toLowerCase());
    }
    if (paramBoolean)
    {
      paramString2.removeAll(BaseController.DEFAULT_SCOPES);
      localHashSet.removeAll(BaseController.DEFAULT_SCOPES);
    }
    return localHashSet.containsAll(paramString2);
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
    paramString1 = TAG;
    paramString2 = a.a("Found [");
    paramString2.append(((ArrayList)localObject1).size());
    paramString2.append("] matching accounts");
    Logger.verbose(paramString1, paramString2.toString());
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
    localObject2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = paramString4;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Credential)localIterator.next();
      if (bool2) {
        bool8 = paramString1.equalsIgnoreCase(((Credential)localObject1).getHomeAccountId());
      } else {
        bool8 = true;
      }
      if ((bool1 ^ true)) {
        if ((bool8) && (paramString2.equalsIgnoreCase(((Credential)localObject1).getEnvironment()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
      }
      boolean bool9 = bool8;
      if (bool6)
      {
        if ((bool8) && (paramCredentialType.name().equalsIgnoreCase(((Credential)localObject1).getCredentialType()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
        bool9 = bool8;
      }
      boolean bool8 = bool9;
      if (bool5) {
        if ((bool9) && (paramString3.equalsIgnoreCase(((Credential)localObject1).getClientId()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
      }
      boolean bool10 = bool8;
      Object localObject3;
      if (bool3)
      {
        bool10 = bool8;
        if ((localObject1 instanceof AccessTokenRecord))
        {
          localObject3 = (AccessTokenRecord)localObject1;
          if ((bool8) && (paramList.equalsIgnoreCase(((AccessTokenRecord)localObject3).getRealm()))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
          bool10 = bool8;
        }
      }
      bool9 = bool10;
      if (bool3)
      {
        bool9 = bool10;
        if ((localObject1 instanceof IdTokenRecord))
        {
          localObject3 = (IdTokenRecord)localObject1;
          if ((bool10) && (paramList.equalsIgnoreCase(((IdTokenRecord)localObject3).getRealm()))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
          bool9 = bool8;
        }
      }
      bool8 = bool9;
      if (bool4) {
        if ((localObject1 instanceof AccessTokenRecord))
        {
          paramList = (AccessTokenRecord)localObject1;
          if ((bool9) && (targetsIntersect(paramString5, paramList.getTarget(), true))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
        }
        else if ((localObject1 instanceof RefreshTokenRecord))
        {
          paramList = (RefreshTokenRecord)localObject1;
          if ((bool9) && (targetsIntersect(paramString5, paramList.getTarget(), true))) {
            bool8 = true;
          } else {
            bool8 = false;
          }
        }
        else
        {
          Logger.warn(TAG, "Query specified target-match, but no target to match.");
          bool8 = bool9;
        }
      }
      if ((bool7) && ((localObject1 instanceof AccessTokenRecord)))
      {
        paramList = (AccessTokenRecord)localObject1;
        if ((bool8) && (paramString6.equalsIgnoreCase(paramList.getAccessTokenType()))) {
          bool8 = true;
        } else {
          bool8 = false;
        }
      }
      if (bool8) {
        ((ArrayList)localObject2).add(localObject1);
      }
    }
    return (List<Credential>)localObject2;
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
              paramCredentialType = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Sought key was: [");
              localStringBuilder.append(paramString);
              localStringBuilder.append("]");
              Logger.warnPII(paramCredentialType, localStringBuilder.toString());
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
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.AbstractAccountCredentialCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */