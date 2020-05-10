package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MicrosoftFamilyOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken>
  extends MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken>
{
  public static final String TAG = "MicrosoftFamilyOAuth2TokenCache";
  
  public MicrosoftFamilyOAuth2TokenCache(Context paramContext, IAccountCredentialCache paramIAccountCredentialCache, IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> paramIAccountCredentialAdapter)
  {
    super(paramContext, paramIAccountCredentialCache, paramIAccountCredentialAdapter);
  }
  
  public ICacheRecord loadByFamilyId(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    Object localObject1 = a.a(new StringBuilder(), TAG, ":loadByFamilyId");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ClientId[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append("1");
    ((StringBuilder)localObject2).append("]");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    Object localObject3 = getAccountCredentialCache().getCredentials();
    localObject2 = ((List)localObject3).iterator();
    Object localObject4;
    do
    {
      do
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        localObject4 = null;
        if (!bool) {
          break;
        }
        localObject1 = (Credential)((Iterator)localObject2).next();
      } while (!(localObject1 instanceof RefreshTokenRecord));
      localObject1 = (RefreshTokenRecord)localObject1;
    } while ((!"1".equals(((RefreshTokenRecord)localObject1).getFamilyId())) || (!paramAccountRecord.getEnvironment().equals(((Credential)localObject1).getEnvironment())) || (!paramAccountRecord.getHomeAccountId().equals(((Credential)localObject1).getHomeAccountId())));
    break label188;
    localObject1 = null;
    label188:
    Object localObject5 = ((List)localObject3).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (Credential)((Iterator)localObject5).next();
      if ((localObject2 instanceof IdTokenRecord))
      {
        localObject2 = (IdTokenRecord)localObject2;
        if ((paramString1 != null) && (paramString1.equals(((Credential)localObject2).getClientId())) && (paramAccountRecord.getEnvironment().equals(((Credential)localObject2).getEnvironment())) && (paramAccountRecord.getHomeAccountId().equals(((Credential)localObject2).getHomeAccountId())) && (paramAccountRecord.getRealm().equals(((IdTokenRecord)localObject2).getRealm()))) {
          break label301;
        }
      }
    }
    localObject2 = null;
    label301:
    localObject5 = localObject4;
    if (paramString2 != null)
    {
      localObject5 = localObject4;
      if (paramAbstractAuthenticationScheme != null)
      {
        localObject3 = ((List)localObject3).iterator();
        do
        {
          do
          {
            do
            {
              localObject5 = localObject4;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject5 = (Credential)((Iterator)localObject3).next();
            } while (!(localObject5 instanceof AccessTokenRecord));
            localObject5 = (AccessTokenRecord)localObject5;
          } while ((paramString1 == null) || (!paramString1.equals(((Credential)localObject5).getClientId())) || (!paramAccountRecord.getEnvironment().equals(((Credential)localObject5).getEnvironment())) || (!paramAccountRecord.getHomeAccountId().equals(((Credential)localObject5).getHomeAccountId())) || (!paramAccountRecord.getRealm().equals(((AccessTokenRecord)localObject5).getRealm())) || (!AbstractAccountCredentialCache.targetsIntersect(paramString2, ((AccessTokenRecord)localObject5).getTarget(), true)));
          CredentialType localCredentialType = CredentialType.AccessToken;
          if (("AccessToken".equalsIgnoreCase(((Credential)localObject5).getCredentialType())) && ("Bearer".equalsIgnoreCase(paramAbstractAuthenticationScheme.getName()))) {
            break;
          }
          localCredentialType = CredentialType.AccessToken_With_AuthScheme;
        } while ((!"AccessToken_With_AuthScheme".equalsIgnoreCase(((Credential)localObject5).getCredentialType())) || (!"PoP".equalsIgnoreCase(paramAbstractAuthenticationScheme.getName())));
      }
    }
    paramString1 = new CacheRecord();
    paramString1.setAccount(paramAccountRecord);
    paramString1.setRefreshToken((RefreshTokenRecord)localObject1);
    paramString1.setAccessToken((AccessTokenRecord)localObject5);
    if (localObject2 != null)
    {
      paramString2 = CredentialType.V1IdToken;
      if ("V1IdToken".equalsIgnoreCase(((Credential)localObject2).getCredentialType())) {
        paramString1.setV1IdToken((IdTokenRecord)localObject2);
      } else {
        paramString1.setIdToken((IdTokenRecord)localObject2);
      }
    }
    return paramString1;
  }
  
  public List<ICacheRecord> loadByFamilyIdWithAggregatedAccountData(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(loadByFamilyId(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme));
    paramAbstractAuthenticationScheme = new ArrayList(getAllTenantAccountsForAccountByClientId(paramString1, paramAccountRecord));
    paramAccountRecord = a.a(new StringBuilder(), TAG, ":loadByFamilyIdWithAggregatedAccountData");
    paramString2 = a.a("Found ");
    paramString2.append(paramAbstractAuthenticationScheme.size() - 1);
    paramString2.append(" profiles for this account");
    Logger.info(paramAccountRecord, paramString2.toString());
    paramAbstractAuthenticationScheme.remove(0);
    if (!paramAbstractAuthenticationScheme.isEmpty())
    {
      paramString2 = paramAbstractAuthenticationScheme.iterator();
      while (paramString2.hasNext())
      {
        paramAbstractAuthenticationScheme = (AccountRecord)paramString2.next();
        paramAccountRecord = new CacheRecord();
        paramAccountRecord.setAccount(paramAbstractAuthenticationScheme);
        paramAccountRecord.setRefreshToken(((ICacheRecord)localArrayList.get(0)).getRefreshToken());
        Iterator localIterator = getIdTokensForAccountRecord(paramString1, paramAbstractAuthenticationScheme).iterator();
        while (localIterator.hasNext())
        {
          IdTokenRecord localIdTokenRecord = (IdTokenRecord)localIterator.next();
          paramAbstractAuthenticationScheme = CredentialType.V1IdToken;
          if ("V1IdToken".equalsIgnoreCase(localIdTokenRecord.getCredentialType())) {
            paramAccountRecord.setV1IdToken(localIdTokenRecord);
          } else {
            paramAccountRecord.setIdToken(localIdTokenRecord);
          }
        }
        localArrayList.add(paramAccountRecord);
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.MicrosoftFamilyOAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */