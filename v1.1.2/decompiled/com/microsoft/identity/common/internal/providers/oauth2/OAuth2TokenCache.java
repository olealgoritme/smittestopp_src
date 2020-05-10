package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.cache.AccountDeletionRecord;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import java.util.List;
import java.util.Set;

public abstract class OAuth2TokenCache<T extends OAuth2Strategy, U extends AuthorizationRequest, V extends TokenResponse>
{
  public final Context mContext;
  
  public OAuth2TokenCache(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  public abstract void clearAll();
  
  public abstract AccountRecord getAccount(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract AccountRecord getAccountByHomeAccountId(String paramString1, String paramString2, String paramString3);
  
  public abstract AccountRecord getAccountByLocalAccountId(String paramString1, String paramString2, String paramString3);
  
  public abstract ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String paramString1, String paramString2, String paramString3);
  
  public abstract List<AccountRecord> getAccounts(String paramString1, String paramString2);
  
  public abstract List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2);
  
  public abstract List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2, String paramString3);
  
  public abstract Set<String> getAllClientIds();
  
  public abstract List<AccountRecord> getAllTenantAccountsForAccountByClientId(String paramString, AccountRecord paramAccountRecord);
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public abstract List<IdTokenRecord> getIdTokensForAccountRecord(String paramString, AccountRecord paramAccountRecord);
  
  public abstract ICacheRecord load(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme);
  
  public abstract List<ICacheRecord> loadWithAggregatedAccountData(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme);
  
  public abstract AccountDeletionRecord removeAccount(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean removeCredential(Credential paramCredential);
  
  public abstract ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord);
  
  public abstract ICacheRecord save(T paramT, U paramU, V paramV);
  
  public abstract List<ICacheRecord> saveAndLoadAggregatedAccountData(T paramT, U paramU, V paramV);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */