package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;
import e.a.a.a.a;

@SuppressLint({"MissingPermission"})
public class AndroidAuthenticator
  implements Authenticator
{
  public final Account mAccount;
  public final AccountManager mAccountManager;
  public final String mAuthTokenType;
  public final boolean mNotifyAuthFailure;
  
  public AndroidAuthenticator(AccountManager paramAccountManager, Account paramAccount, String paramString, boolean paramBoolean)
  {
    mAccountManager = paramAccountManager;
    mAccount = paramAccount;
    mAuthTokenType = paramString;
    mNotifyAuthFailure = paramBoolean;
  }
  
  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, false);
  }
  
  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this(AccountManager.get(paramContext), paramAccount, paramString, paramBoolean);
  }
  
  public Account getAccount()
  {
    return mAccount;
  }
  
  public String getAuthToken()
  {
    AccountManagerFuture localAccountManagerFuture = mAccountManager.getAuthToken(mAccount, mAuthTokenType, mNotifyAuthFailure, null, null);
    try
    {
      Bundle localBundle = (Bundle)localAccountManagerFuture.getResult();
      Object localObject1 = null;
      Object localObject2 = localObject1;
      if (localAccountManagerFuture.isDone())
      {
        localObject2 = localObject1;
        if (!localAccountManagerFuture.isCancelled()) {
          if (!localBundle.containsKey("intent")) {
            localObject2 = localBundle.getString("authtoken");
          } else {
            throw new AuthFailureError((Intent)localBundle.getParcelable("intent"));
          }
        }
      }
      if (localObject2 != null) {
        return (String)localObject2;
      }
      localObject2 = a.a("Got null auth token for type: ");
      ((StringBuilder)localObject2).append(mAuthTokenType);
      throw new AuthFailureError(((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      throw new AuthFailureError("Error while retrieving auth token", localException);
    }
  }
  
  public String getAuthTokenType()
  {
    return mAuthTokenType;
  }
  
  public void invalidateAuthToken(String paramString)
  {
    mAccountManager.invalidateAuthToken(mAccount.type, paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.AndroidAuthenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */