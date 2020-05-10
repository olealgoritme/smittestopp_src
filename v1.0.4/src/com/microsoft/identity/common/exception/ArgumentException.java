package com.microsoft.identity.common.exception;

public class ArgumentException
  extends BaseException
{
  public static final String ACQUIRE_TOKEN_OPERATION_NAME = "acquireToken";
  public static final String ACQUIRE_TOKEN_SILENT_OPERATION_NAME = "acquireTokenSilent";
  public static final String AUTHENTICATION_SCHEME_ARGUMENT_NAME = "authentication_scheme";
  public static final String AUTHORITY_ARGUMENT_NAME = "authority";
  public static final String BROKER_TOKEN_REQUEST_OPERATION_NAME = "brokerTokenRequest";
  public static final String IACCOUNT_ARGUMENT_NAME = "account";
  public static final String ILLEGAL_ARGUMENT_ERROR_CODE = "illegal_argument_exception";
  public static final String SCOPE_ARGUMENT_NAME = "scopes";
  public static final String sName = ArgumentException.class.getName();
  public String mArgumentName;
  public String mOperationName;
  
  public ArgumentException(String paramString1, String paramString2, String paramString3)
  {
    super("illegal_argument_exception", paramString3);
    mOperationName = paramString1;
    mArgumentName = paramString2;
  }
  
  public ArgumentException(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    super("illegal_argument_exception", paramString3, paramThrowable);
    mOperationName = paramString1;
    mArgumentName = paramString2;
  }
  
  public String getArgumentName()
  {
    return mArgumentName;
  }
  
  public String getExceptionName()
  {
    return sName;
  }
  
  public String getOperationName()
  {
    return mOperationName;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.exception.ArgumentException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */