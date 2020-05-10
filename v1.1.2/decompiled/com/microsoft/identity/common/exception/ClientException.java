package com.microsoft.identity.common.exception;

public class ClientException
  extends BaseException
{
  public static final String ADFS_AUTHORITY_VALIDATION_FAILED = "adfs_authority_validation_failed";
  public static final String ANDROID_KEYSTORE_UNAVAILABLE = "android_keystore_unavailable";
  public static final String AUTHORITY_VALIDATION_NOT_SUPPORTED = "authority_validation_not_supported";
  public static final String AUTH_SCHEME_MISMATCH = "auth_scheme_mismatch";
  public static final String BAD_KEY_SIZE = "keystore_produced_invalid_cert";
  public static final String BRT_TENANT_MISMATCH = "brt_tenant_mismatch";
  public static final String CHROME_NOT_INSTALLED = "chrome_not_installed";
  public static final String DEVICE_NETWORK_NOT_AVAILABLE = "device_network_not_available";
  public static final String DUPLICATE_COMMAND = "duplicate_command";
  public static final String DUPLICATE_QUERY_PARAMETER = "duplicate_query_parameter";
  public static final String INTERRUPTED_OPERATION = "operation_interrupted";
  public static final String INVALID_ALG = "keystore_initialization_failed";
  public static final String INVALID_JWT = "invalid_jwt";
  public static final String INVALID_PROTECTION_PARAMS = "protection_params_invalid";
  public static final String IO_ERROR = "io_error";
  public static final String JSON_CONSTRUCTION_FAILED = "json_construction_failed";
  public static final String JSON_PARSE_FAILURE = "json_parse_failure";
  public static final String JWT_SIGNING_FAILURE = "failed_to_sign_jwt";
  public static final String KEYSTORE_NOT_INITIALIZED = "keystore_not_initialized";
  public static final String MALFORMED_URL = "malformed_url";
  public static final String MULTIPLE_MATCHING_TOKENS_DETECTED = "multiple_matching_tokens_detected";
  public static final String NO_SUCH_ALGORITHM = "no_such_algorithm";
  public static final String SCOPE_EMPTY_OR_NULL = "scope_empty_or_null";
  public static final String STATE_MISMATCH = "state_mismatch";
  public static final String THUMBPRINT_COMPUTATION_FAILURE = "failed_to_compute_thumbprint_with_sha256";
  public static final String TOKEN_CACHE_ITEM_NOT_FOUND = "token_cache_item_not_found";
  public static final String TOKEN_SHARING_DESERIALIZATION_ERROR = "token_sharing_deserialization_error";
  public static final String TOKEN_SHARING_MSA_PERSISTENCE_ERROR = "failed_to_persist_msa_credential";
  public static final String UNKNOWN_AUTHORITY = "unknown_authority";
  public static final String UNKNOWN_ERROR = "unknown_error";
  public static final String UNSUPPORTED_ENCODING = "unsupported_encoding";
  public static final String UNSUPPORTED_URL = "unsupported_url";
  public static final String USER_MISMATCH = "user_mismatch";
  public static final String sName = ClientException.class.getName();
  
  public ClientException(String paramString)
  {
    super(paramString);
  }
  
  public ClientException(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public ClientException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramString2, paramThrowable);
  }
  
  public String getExceptionName()
  {
    return sName;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.exception.ClientException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */