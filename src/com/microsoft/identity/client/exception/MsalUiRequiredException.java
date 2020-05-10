package com.microsoft.identity.client.exception;

public final class MsalUiRequiredException
  extends MsalException
{
  public static final String INVALID_GRANT = "invalid_grant";
  public static final String NO_ACCOUNT_FOUND = "no_account_found";
  public static final String NO_TOKENS_FOUND = "no_tokens_found";
  
  public MsalUiRequiredException(String paramString)
  {
    super(paramString);
  }
  
  public MsalUiRequiredException(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public MsalUiRequiredException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.exception.MsalUiRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */