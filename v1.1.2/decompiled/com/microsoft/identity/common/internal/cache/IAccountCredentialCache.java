package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import java.util.List;

public abstract interface IAccountCredentialCache
{
  public abstract void clearAll();
  
  public abstract AccountRecord getAccount(String paramString);
  
  public abstract List<AccountRecord> getAccounts();
  
  public abstract List<AccountRecord> getAccountsFilteredBy(String paramString1, String paramString2, String paramString3);
  
  public abstract Credential getCredential(String paramString);
  
  public abstract List<Credential> getCredentials();
  
  public abstract List<Credential> getCredentialsFilteredBy(String paramString1, String paramString2, CredentialType paramCredentialType, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract boolean removeAccount(AccountRecord paramAccountRecord);
  
  public abstract boolean removeCredential(Credential paramCredential);
  
  public abstract void saveAccount(AccountRecord paramAccountRecord);
  
  public abstract void saveCredential(Credential paramCredential);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.IAccountCredentialCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */