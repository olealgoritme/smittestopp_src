package com.microsoft.identity.client.exception;

public class MsalArgumentException
  extends MsalException
{
  public static final String ACQUIRE_TOKEN_OPERATION_NAME = "acquireToken";
  public static final String ACQUIRE_TOKEN_SILENT_OPERATION_NAME = "acquireTokenSilent";
  public static final String AUTHORITY_REQUIRED_FOR_SILENT = "Authority must be specified for acquireTokenSilent";
  public static final String IACCOUNT_ARGUMENT_NAME = "account";
  public static final String ILLEGAL_ARGUMENT_ERROR_CODE = "illegal_argument_exception";
  public static final String SCOPE_ARGUMENT_NAME = "scopes";
  public String mArgumentName;
  public String mOperationName;
  
  public MsalArgumentException(String paramString1, String paramString2)
  {
    super("illegal_argument_exception", paramString2);
    mArgumentName = paramString1;
  }
  
  public MsalArgumentException(String paramString1, String paramString2, String paramString3)
  {
    super("illegal_argument_exception", paramString3);
    mOperationName = paramString1;
    mArgumentName = paramString2;
  }
  
  public MsalArgumentException(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    super("illegal_argument_exception", paramString3, paramThrowable);
    mOperationName = paramString1;
    mArgumentName = paramString2;
  }
  
  public String getArgumentName()
  {
    return mArgumentName;
  }
  
  public String getOperationName()
  {
    return mOperationName;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.exception.MsalArgumentException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */