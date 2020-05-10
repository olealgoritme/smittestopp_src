package com.microsoft.identity.common.exception;

public final class ErrorStrings
{
  public static final String ACCESS_DENIED = "access_denied";
  public static final String ACCOUNT_IS_SCHEMA_NONCOMPLIANT = "Account is missing schema-required fields.";
  public static final String ADFS_AUTHORITY_VALIDATION_FAILED = "adfs_authority_validation_failed";
  public static final String ANDROIDKEYSTORE_FAILED = "android_keystore_failed";
  public static final String ANDROID_CONTEXT_IS_NULL = "Android Context is null.";
  public static final String APP_PACKAGE_NAME_NOT_FOUND = "App package name is not found in the package manager";
  public static final String AUTHORITY_URL_NOT_VALID = "authority_url_not_valid";
  public static final String AUTHORITY_VALIDATION_NOT_SUPPORTED = "authority_validation_not_supported";
  public static final String AUTHORIZATION_INTENT_IS_NULL = "Authorization intent is null.";
  public static final String AUTH_REFRESH_FAILED = "Refresh token request failed";
  public static final String BROKER_APP_NOT_RESPONDING = "Broker application is not responding";
  public static final String BROKER_APP_VERIFICATION_FAILED = "Calling app could not be verified";
  public static final String BROKER_BIND_SERVICE_FAILED = "Failed to bind the service in broker app";
  public static final String BROKER_PRT_REFRESH_FAILED = "Failed to refresh PRT";
  public static final String BROKER_REQUEST_CANCELLED = "Broker request cancelled";
  public static final String BROKER_VERIFICATION_FAILED = "Signature could not be verified";
  public static final String CERTIFICATE_ENCODING_ERROR = "Certificate encoding is not generated";
  public static final String CHROME_NOT_INSTALLED = "chrome_not_installed";
  public static final String CREDENTIAL_IS_SCHEMA_NONCOMPLIANT = "Credential is missing schema-required fields.";
  public static final String DECLINED_SCOPE_ERROR_CODE = "declined_scope_error";
  public static final String DECLINED_SCOPE_ERROR_MESSAGE = "Some or all requested scopes have been declined by the Server";
  public static final String DECRYPTION_ERROR = "decryption_error";
  public static final String DECRYPTION_FAILED = "decryption_failed";
  public static final String DEVELOPER_REDIRECTURI_INVALID = "The redirectUri for broker is invalid";
  public static final String DEVICE_CERTIFICATE_API_EXCEPTION = "Device certificate API has exception";
  public static final String DEVICE_CERTIFICATE_REQUEST_INVALID = "Device certificate request is invalid";
  public static final String DEVICE_NETWORK_NOT_AVAILABLE = "device_network_not_available";
  public static final String DEVICE_REGISTRATION_FAILED = "Device registration failed";
  public static final String DUPLICATE_QUERY_PARAMETER = "duplicate_query_parameter";
  public static final String ENCRYPTION_ERROR = "encryption_error";
  public static final String ERROR_RETRIEVING_DEVICE_STATE = "Error retrieving device state";
  public static final String FAILED_TO_GET_CAPABILITIES = "Could not get the capabilities";
  public static final String INVALID_BROKER_REFRESH_TOKEN = "Broker refresh token is invalid";
  public static final String INVALID_INSTANCE = "invalid_instance";
  public static final String INVALID_JWT = "invalid_jwt";
  public static final String INVALID_REQUEST = "invalid_request";
  public static final String INVALID_SCOPE = "invalid_scope";
  public static final String IO_ERROR = "io_error";
  public static final String JSON_PARSE_FAILURE = "json_parse_failure";
  public static final String KEY_CHAIN_PRIVATE_KEY_EXCEPTION = "Key Chain private key exception";
  public static final String KEY_NOT_FOUND = "key_not_found";
  public static final String MALFORMED_URL = "malformed_url";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_CODE = "multiple_account_pca_init_fail_account_mode";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_MESSAGE = "AccountMode in configuration is not set to multiple. Cannot initialize multiple account PublicClientApplication.";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_CODE = "multiple_account_pca_init_fail_on_shared_device";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_ON_SHARED_DEVICE_ERROR_MESSAGE = "AccountMode in configuration is set to multiple. However, the device is marked as shared (which requires single account mode).";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE = "multiple_account_pca_init_fail_unknown_reason";
  public static final String MULTIPLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE = "Multiple account PublicClientApplication could not be created for unknown reasons";
  public static final String MULTIPLE_MATCHING_TOKENS_DETECTED = "multiple_matching_tokens_detected";
  public static final String NO_ACCOUNT_FOUND = "no_account_found";
  public static final String NO_AVAILABLE_BROWSER_FOUND = "No available browser installed on the device.";
  public static final String NO_NETWORK_CONNECTION_POWER_OPTIMIZATION = "device_network_not_available_doze_mode";
  public static final String NO_SUCH_ALGORITHM = "no_such_algorithm";
  public static final String NO_TOKENS_FOUND = "no_tokens_found";
  public static final String PACKAGE_NAME_NOT_FOUND = "Package name is not resolved";
  public static final String REGISTERED_SHARED_DEVICE_DELETED_ON_SERVER_ERROR_CODE = "registered_shared_device_deleted_on_server";
  public static final String REGISTERED_SHARED_DEVICE_DELETED_ON_SERVER_ERROR_MESSAGE = "This device has been unregistered. Please return the device to your administrator.";
  public static final String REQUEST_TIMEOUT = "request_timeout";
  public static final String SERVICE_NOT_AVAILABLE = "service_not_available";
  public static final String SIGNATURE_EXCEPTION = "Signature exception";
  public static final String SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_CODE = "single_account_pca_init_fail_account_mode";
  public static final String SINGLE_ACCOUNT_PCA_INIT_FAIL_ACCOUNT_MODE_ERROR_MESSAGE = "AccountMode in configuration is not set to single. Cannot initialize single account PublicClientApplication.";
  public static final String SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_CODE = "single_account_pca_init_fail_unknown_reason";
  public static final String SINGLE_ACCOUNT_PCA_INIT_FAIL_UNKNOWN_REASON_ERROR_MESSAGE = "A single account public client application could not be created for unknown reasons.";
  public static final String SOCKET_TIMEOUT = "socket_timeout";
  public static final String STATE_MISMATCH = "state_mismatch";
  public static final String STK_PATCHING_FAILED = "STK patching failed";
  public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
  public static final String UNKNOWN_CALLER = "unknown_caller";
  public static final String UNKNOWN_ERROR = "unknown_error";
  public static final String UNRESOLVABLE_INTENT = "unresolvable_intent";
  public static final String UNSUPPORTED_BROKER_VERSION_ERROR_CODE = "unsupported_broker_version";
  public static final String UNSUPPORTED_BROKER_VERSION_ERROR_MESSAGE = "Please update Intune Company Portal and/or Microsoft Authenticator to the latest version.";
  public static final String UNSUPPORTED_ENCODING = "unsupported_encoding";
  public static final String UNSUPPORTED_URL = "unsupported_url";
  public static final String USER_CANCELLED = "User cancelled";
  public static final String USER_MISMATCH = "user_mismatch";
  public static final String WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED = "Redirect url scheme not SSL protected";
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.exception.ErrorStrings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */