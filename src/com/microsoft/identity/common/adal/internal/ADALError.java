package com.microsoft.identity.common.adal.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;

public enum ADALError
{
  public static final Map<String, ADALError> exceptionMap;
  public String mDescription;
  
  static
  {
    DEVELOPER_AUTHORITY_IS_EMPTY = new ADALError("DEVELOPER_AUTHORITY_IS_EMPTY", 3, "Authority is empty");
    DEVELOPER_ASYNC_TASK_REUSED = new ADALError("DEVELOPER_ASYNC_TASK_REUSED", 4, "Async tasks can only be executed one time. They are not supposed to be reused.");
    DEVELOPER_RESOURCE_IS_EMPTY = new ADALError("DEVELOPER_RESOURCE_IS_EMPTY", 5, "Resource is empty");
    DEVELOPER_CONTEXT_IS_NOT_PROVIDED = new ADALError("DEVELOPER_CONTEXT_IS_NOT_PROVIDED", 6, "Context is not provided");
    DEVELOPER_BEARER_HEADER_MULTIPLE_ITEMS = new ADALError("DEVELOPER_BEARER_HEADER_MULTIPLE_ITEMS", 7, "Key/value pair list contains redundant items in the header");
    CALLBACK_IS_NOT_FOUND = new ADALError("CALLBACK_IS_NOT_FOUND", 8, "Active callback is not found");
    DEVELOPER_ACTIVITY_IS_NOT_RESOLVED = new ADALError("DEVELOPER_ACTIVITY_IS_NOT_RESOLVED", 9, "Activity is not resolved. Verify the activity name in your manifest file");
    DEVELOPER_INTERNET_PERMISSION_MISSING = new ADALError("DEVELOPER_INTERNET_PERMISSION_MISSING", 10, "android.permission.INTERNET is not added to AndroidManifest file");
    DEVELOPER_BROKER_PERMISSIONS_MISSING = new ADALError("DEVELOPER_BROKER_PERMISSIONS_MISSING", 11, "GET_ACCOUNTS, MANAGE_ACCOUNTS, USE_CREDENTIALS are not added to AndroidManifest file");
    DEVELOPER_CALLING_ON_MAIN_THREAD = new ADALError("DEVELOPER_CALLING_ON_MAIN_THREAD", 12, "Calling from main thread for background operation");
    DEVELOPER_DIALOG_LAYOUT_INVALID = new ADALError("DEVELOPER_DIALOG_LAYOUT_INVALID", 13, "dialog_authentication.xml file has invalid elements");
    DEVELOPER_DIALOG_INFLATION_ERROR = new ADALError("DEVELOPER_DIALOG_INFLATION_ERROR", 14, "An error occur when attempting to inflate the authentication dialog");
    SERVER_INVALID_REQUEST = new ADALError("SERVER_INVALID_REQUEST", 15, "Invalid request to server");
    SERVER_ERROR = new ADALError("SERVER_ERROR", 16, "Server returned an error");
    IO_EXCEPTION = new ADALError("IO_EXCEPTION", 17, "I/O exception");
    SOCKET_TIMEOUT_EXCEPTION = new ADALError("SOCKET_TIMEOUT_EXCEPTION", 18, "Socket timeout exception");
    ARGUMENT_EXCEPTION = new ADALError("ARGUMENT_EXCEPTION", 19, "Invalid argument");
    ERROR_FAILED_SSL_HANDSHAKE = new ADALError("ERROR_FAILED_SSL_HANDSHAKE", 20, "Webview returned error for SSL");
    ERROR_WEBVIEW = new ADALError("ERROR_WEBVIEW", 21, "Webview returned an error");
    ACTIVITY_REQUEST_INTENT_DATA_IS_NULL = new ADALError("ACTIVITY_REQUEST_INTENT_DATA_IS_NULL", 22, "Request object is null");
    BROADCAST_RECEIVER_ERROR = new ADALError("BROADCAST_RECEIVER_ERROR", 23, "Broadcast receiver has an error");
    AUTH_FAILED = new ADALError("AUTH_FAILED", 24, "Authorization failed");
    AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED = new ADALError("AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED", 25, "Refresh token is failed and prompt is not allowed");
    AUTH_FAILED_SERVER_ERROR = new ADALError("AUTH_FAILED_SERVER_ERROR", 26, "The Authorization Server returned an unrecognized response");
    AUTH_FAILED_NO_RESOURCES = new ADALError("AUTH_FAILED_NO_RESOURCES", 27, "The required resource bundle could not be loaded");
    AUTH_FAILED_NO_STATE = new ADALError("AUTH_FAILED_NO_STATE", 28, "The authorization server response has incorrectly encoded state");
    AUTH_FAILED_BAD_STATE = new ADALError("AUTH_FAILED_BAD_STATE", 29, "The authorization server response has no encoded state");
    AUTH_FAILED_NO_TOKEN = new ADALError("AUTH_FAILED_NO_TOKEN", 30, "The requested access token could not be found");
    AUTH_FAILED_CANCELLED = new ADALError("AUTH_FAILED_CANCELLED", 31, "The user cancelled the authorization request");
    AUTH_FAILED_INTERNAL_ERROR = new ADALError("AUTH_FAILED_INTERNAL_ERROR", 32, "Invalid parameters for authorization operation");
    AUTH_FAILED_USER_MISMATCH = new ADALError("AUTH_FAILED_USER_MISMATCH", 33, "User returned by service does not match the one in the request");
    AUTH_FAILED_INTUNE_POLICY_REQUIRED = new ADALError("AUTH_FAILED_INTUNE_POLICY_REQUIRED", 34, "Intune App Protection Policy required");
    DEVICE_INTERNET_IS_NOT_AVAILABLE = new ADALError("DEVICE_INTERNET_IS_NOT_AVAILABLE", 35, "Internet permissions are not set for the app");
    NO_NETWORK_CONNECTION_POWER_OPTIMIZATION = new ADALError("NO_NETWORK_CONNECTION_POWER_OPTIMIZATION", 36, "Unable to access the network due to power optimizations");
    ON_ACTIVITY_RESULT_INTENT_NULL = new ADALError("ON_ACTIVITY_RESULT_INTENT_NULL", 37, "onActivityResult is called with null intent data");
    ON_ACTIVITY_RESULT_CALLBACK_NOT_FOUND = new ADALError("ON_ACTIVITY_RESULT_CALLBACK_NOT_FOUND", 38, "onActivityResult is called, but callback is not found");
    DEVICE_SHARED_PREF_IS_NOT_AVAILABLE = new ADALError("DEVICE_SHARED_PREF_IS_NOT_AVAILABLE", 39, "Shared preferences are not available");
    DEVICE_CACHE_IS_NOT_WORKING = new ADALError("DEVICE_CACHE_IS_NOT_WORKING", 40, "Cache is not saving the changes.");
    DEVICE_FILE_CACHE_IS_NOT_LOADED_FROM_FILE = new ADALError("DEVICE_FILE_CACHE_IS_NOT_LOADED_FROM_FILE", 41, "Cache is not loaded from File");
    DEVICE_FILE_CACHE_IS_NOT_WRITING_TO_FILE = new ADALError("DEVICE_FILE_CACHE_IS_NOT_WRITING_TO_FILE", 42, "FileCache could not write to the File");
    DEVICE_FILE_CACHE_FORMAT_IS_WRONG = new ADALError("DEVICE_FILE_CACHE_FORMAT_IS_WRONG", 43, "Wrong cache file format");
    DEVICE_CONNECTION_IS_NOT_AVAILABLE = new ADALError("DEVICE_CONNECTION_IS_NOT_AVAILABLE", 44, "Connection is not available");
    DEVICE_PRNG_FIX_ERROR = new ADALError("DEVICE_PRNG_FIX_ERROR", 45, "PRNG fixes are not applied");
    IDTOKEN_PARSING_FAILURE = new ADALError("IDTOKEN_PARSING_FAILURE", 46, "Cannot parse IdToken");
    DATE_PARSING_FAILURE = new ADALError("DATE_PARSING_FAILURE", 47, "Cannot parse date");
    AUTHORIZATION_CODE_NOT_EXCHANGED_FOR_TOKEN = new ADALError("AUTHORIZATION_CODE_NOT_EXCHANGED_FOR_TOKEN", 48, "Authorization code not exchanged for token");
    BROADCAST_CANCEL_NOT_SUCCESSFUL = new ADALError("BROADCAST_CANCEL_NOT_SUCCESSFUL", 49, "Cancel message is not successfully delivered to broadcast receiver.");
    CORRELATION_ID_FORMAT = new ADALError("CORRELATION_ID_FORMAT", 50, "Correlationid is not in UUID format");
    CORRELATION_ID_NOT_MATCHING_REQUEST_RESPONSE = new ADALError("CORRELATION_ID_NOT_MATCHING_REQUEST_RESPONSE", 51, "Correlationid provided in request is not matching the response");
    ENCODING_IS_NOT_SUPPORTED = new ADALError("ENCODING_IS_NOT_SUPPORTED", 52, "Encoding format is not supported");
    SERVER_INVALID_JSON_RESPONSE = new ADALError("SERVER_INVALID_JSON_RESPONSE", 53, "Server returned invalid JSON response");
    AUTH_REFRESH_FAILED = new ADALError("AUTH_REFRESH_FAILED", 54, "Refresh token request failed");
    ENCRYPTION_FAILED = new ADALError("ENCRYPTION_FAILED", 55, "Encryption failed");
    DECRYPTION_FAILED = new ADALError("DECRYPTION_FAILED", 56, "Decryption failed");
    ANDROIDKEYSTORE_FAILED = new ADALError("ANDROIDKEYSTORE_FAILED", 57, "Failed to use AndroidKeyStore");
    ANDROIDKEYSTORE_KEYPAIR_GENERATOR_FAILED = new ADALError("ANDROIDKEYSTORE_KEYPAIR_GENERATOR_FAILED", 58, "Failed to use KeyPairGeneratorSpec");
    DISCOVERY_NOT_SUPPORTED = new ADALError("DISCOVERY_NOT_SUPPORTED", 59, "Authority validation is not supported for ADFS authority.");
    BROKER_PACKAGE_NAME_NOT_FOUND = new ADALError("BROKER_PACKAGE_NAME_NOT_FOUND", 60, "Broker is not installed in your system");
    BROKER_PRT_FAILED = new ADALError("BROKER_PRT_FAILED", 61, "Broker failed to get PRT");
    BROKER_AUTHENTICATOR_NOT_RESPONDING = new ADALError("BROKER_AUTHENTICATOR_NOT_RESPONDING", 62, "Authenticator is not responding");
    BROKER_AUTHENTICATOR_OPERATION_CANCEL = new ADALError("BROKER_AUTHENTICATOR_OPERATION_CANCEL", 63, "Operation was cancelled by the broker");
    BROKER_AUTHENTICATOR_ERROR_GETAUTHTOKEN = new ADALError("BROKER_AUTHENTICATOR_ERROR_GETAUTHTOKEN", 64, "Authenticator error");
    BROKER_AUTHENTICATOR_BAD_ARGUMENTS = new ADALError("BROKER_AUTHENTICATOR_BAD_ARGUMENTS", 65, "Invalid arguments for Authenticator request");
    BROKER_AUTHENTICATOR_BAD_AUTHENTICATION = new ADALError("BROKER_AUTHENTICATOR_BAD_AUTHENTICATION", 66, "Authentication request failed");
    BROKER_AUTHENTICATOR_UNSUPPORTED_OPERATION = new ADALError("BROKER_AUTHENTICATOR_UNSUPPORTED_OPERATION", 67, "Authenticator is not supporting this operation");
    BROKER_AUTHENTICATOR_IO_EXCEPTION = new ADALError("BROKER_AUTHENTICATOR_IO_EXCEPTION", 68, "Authenticator has IO Exception");
    BROKER_AUTHENTICATOR_EXCEPTION = new ADALError("BROKER_AUTHENTICATOR_EXCEPTION", 69, "Authenticator has an Exception");
    BROKER_VERIFICATION_FAILED = new ADALError("BROKER_VERIFICATION_FAILED", 70, "Signature could not be verified");
    PACKAGE_NAME_NOT_FOUND = new ADALError("PACKAGE_NAME_NOT_FOUND", 71, "Package name is not resolved");
    DIGEST_ERROR = new ADALError("DIGEST_ERROR", 72, "Error in generating hash with MessageDigest");
    BROKER_AUTHENTICATION_REQUEST_IS_NULL = new ADALError("BROKER_AUTHENTICATION_REQUEST_IS_NULL", 73, "Authentication request is null");
    BROKER_APP_VERIFICATION_FAILED = new ADALError("BROKER_APP_VERIFICATION_FAILED", 74, "Calling app could not be verified");
    BROKER_ACTIVITY_INFO_NOT_FOUND = new ADALError("BROKER_ACTIVITY_INFO_NOT_FOUND", 75, "Activity information is not retrieved");
    BROKER_SIGNATURE_NOT_SAVED = new ADALError("BROKER_SIGNATURE_NOT_SAVED", 76, "Signature is not saved");
    BROKER_ACCOUNT_DEVICE_REGISTRY_FAILURE = new ADALError("BROKER_ACCOUNT_DEVICE_REGISTRY_FAILURE", 77, "Device registration failed");
    BROKER_ACCOUNT_FAILED_RESOLVED_INTERRUPT = new ADALError("BROKER_ACCOUNT_FAILED_RESOLVED_INTERRUPT", 78, "Token request after resolving web interrupt failed");
    DEVICE_NO_SUCH_ALGORITHM = new ADALError("DEVICE_NO_SUCH_ALGORITHM", 79, "Device does not support the algorithm");
    DEVICE_ALGORITHM_PADDING_EXCEPTION = new ADALError("DEVICE_ALGORITHM_PADDING_EXCEPTION", 80, "Requested padding is not available");
    APP_PACKAGE_NAME_NOT_FOUND = new ADALError("APP_PACKAGE_NAME_NOT_FOUND", 81, "App package name is not found in the package manager");
    ENCRYPTION_ERROR = new ADALError("ENCRYPTION_ERROR", 82, "Encryption related error");
    BROKER_ACTIVITY_IS_NOT_RESOLVED = new ADALError("BROKER_ACTIVITY_IS_NOT_RESOLVED", 83, "Broker activity is not resolved");
    BROKER_ACTIVITY_INVALID_REQUEST = new ADALError("BROKER_ACTIVITY_INVALID_REQUEST", 84, "Invalid request parameters");
    BROKER_ACCOUNT_SAVE_FAILED = new ADALError("BROKER_ACCOUNT_SAVE_FAILED", 85, "Broker could not save the new account");
    BROKER_ACCOUNT_DOES_NOT_EXIST = new ADALError("BROKER_ACCOUNT_DOES_NOT_EXIST", 86, "Broker account does not exist");
    BROKER_SINGLE_USER_EXPECTED = new ADALError("BROKER_SINGLE_USER_EXPECTED", 87, "Single user is expected");
    KEY_CHAIN_PRIVATE_KEY_EXCEPTION = new ADALError("KEY_CHAIN_PRIVATE_KEY_EXCEPTION", 88, "Key Chain private key exception");
    SIGNATURE_EXCEPTION = new ADALError("SIGNATURE_EXCEPTION", 89, "Signature exception");
    DEVICE_CERTIFICATE_RESPONSE_FAILED = new ADALError("DEVICE_CERTIFICATE_RESPONSE_FAILED", 90, "It is failed to create device certificate response");
    WEBVIEW_RETURNED_AUTHENTICATION_EXCEPTION = new ADALError("WEBVIEW_RETURNED_AUTHENTICATION_EXCEPTION", 91, "Webview returned Authentication Exception");
    WEBVIEW_RETURNED_INVALID_AUTHENTICATION_EXCEPTION = new ADALError("WEBVIEW_RETURNED_INVALID_AUTHENTICATION_EXCEPTION", 92, "Webview returned invalid or null Authentication Exception");
    WEBVIEW_RETURNED_EMPTY_REDIRECT_URL = new ADALError("WEBVIEW_RETURNED_EMPTY_REDIRECT_URL", 93, "Webview returned empty redirect url");
    WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED = new ADALError("WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED", 94, "The webview was redirected to an unsafe URL");
    DEVICE_CERTIFICATE_API_EXCEPTION = new ADALError("DEVICE_CERTIFICATE_API_EXCEPTION", 95, "Device certificate API has exception");
    DEVICE_CERTIFICATE_REQUEST_INVALID = new ADALError("DEVICE_CERTIFICATE_REQUEST_INVALID", 96, "Device certificate request is valid");
    RESOURCE_NOT_FOUND = new ADALError("RESOURCE_NOT_FOUND", 97, "Resource is not found in your project. Please include resource files.");
    CERTIFICATE_ENCODING_ERROR = new ADALError("CERTIFICATE_ENCODING_ERROR", 98, "Certificate encoding is not generated");
    ERROR_SILENT_REQUEST = new ADALError("ERROR_SILENT_REQUEST", 99, "Error in silent token request");
    DEVELOPER_REDIRECTURI_INVALID = new ADALError("DEVELOPER_REDIRECTURI_INVALID", 100, "The redirectUri for broker is invalid");
    DEVICE_CHALLENGE_FAILURE = new ADALError("DEVICE_CHALLENGE_FAILURE", 101, "Device challenge failure");
    RESOURCE_AUTHENTICATION_CHALLENGE_FAILURE = new ADALError("RESOURCE_AUTHENTICATION_CHALLENGE_FAILURE", 102, "Resource authentication challenge failure");
    INVALID_TOKEN_CACHE_ITEM = new ADALError("INVALID_TOKEN_CACHE_ITEM", 103, "Invalid token cache item");
    FAIL_TO_EXPORT = new ADALError("FAIL_TO_EXPORT", 104, "Fail to export");
    FAIL_TO_IMPORT = new ADALError("FAIL_TO_IMPORT", 105, "Fail to import");
    INCOMPATIBLE_BLOB_VERSION = new ADALError("INCOMPATIBLE_BLOB_VERSION", 106, "Fail to deserialize because the blob version is incompatible");
    TOKEN_CACHE_ITEM_NOT_FOUND = new ADALError("TOKEN_CACHE_ITEM_NOT_FOUND", 107, "Token cache item is not found");
    JSON_PARSE_ERROR = new ADALError("JSON_PARSE_ERROR", 108, "Fail to parse JSON");
    DRS_METADATA_URL_INVALID = new ADALError("DRS_METADATA_URL_INVALID", 109, "Malformed DRS metadata URL");
    DRS_FAILED_SERVER_ERROR = new ADALError("DRS_FAILED_SERVER_ERROR", 110, "Enrollment server returned an unrecognized response");
    DRS_DISCOVERY_FAILED_UNKNOWN_HOST = new ADALError("DRS_DISCOVERY_FAILED_UNKNOWN_HOST", 111, "DRS discovery failed: unknown host");
    BROKER_APP_INSTALLATION_STARTED = new ADALError("BROKER_APP_INSTALLATION_STARTED", 112, "Broker app installation started");
    PARALLEL_UI_REQUESTS = new ADALError("PARALLEL_UI_REQUESTS", 113, "Parallel UI requests, cancelling and only one request will be allowed.");
    X_MS_CLITELEM_VERSION_UNRECOGNIZED = new ADALError("X_MS_CLITELEM_VERSION_UNRECOGNIZED", 114, "Unrecognized x-ms-clitelem header version");
    X_MS_CLITELEM_MALFORMED = new ADALError("X_MS_CLITELEM_MALFORMED", 115, "Malformed x-ms-clitelem header");
    DEVICE_CERT_PROXY_UNINITIALIZED = new ADALError("DEVICE_CERT_PROXY_UNINITIALIZED", 116, "WPJ Device Certificate Proxy class was not initialized.");
    BROKER_BIND_SERVICE_FAILED = new ADALError("BROKER_BIND_SERVICE_FAILED", 117, "Failed to bind the service in broker app");
    Object localObject = new ADALError("MAPPING_FAILURE", 118, "Common core returned an exception code that ADAL cannot parse");
    MAPPING_FAILURE = (ADALError)localObject;
    $VALUES = new ADALError[] { DEVELOPER_AUTHORITY_CAN_NOT_BE_VALIDED, DEVELOPER_AUTHORITY_IS_NOT_VALID_INSTANCE, DEVELOPER_AUTHORITY_IS_NOT_VALID_URL, DEVELOPER_AUTHORITY_IS_EMPTY, DEVELOPER_ASYNC_TASK_REUSED, DEVELOPER_RESOURCE_IS_EMPTY, DEVELOPER_CONTEXT_IS_NOT_PROVIDED, DEVELOPER_BEARER_HEADER_MULTIPLE_ITEMS, CALLBACK_IS_NOT_FOUND, DEVELOPER_ACTIVITY_IS_NOT_RESOLVED, DEVELOPER_INTERNET_PERMISSION_MISSING, DEVELOPER_BROKER_PERMISSIONS_MISSING, DEVELOPER_CALLING_ON_MAIN_THREAD, DEVELOPER_DIALOG_LAYOUT_INVALID, DEVELOPER_DIALOG_INFLATION_ERROR, SERVER_INVALID_REQUEST, SERVER_ERROR, IO_EXCEPTION, SOCKET_TIMEOUT_EXCEPTION, ARGUMENT_EXCEPTION, ERROR_FAILED_SSL_HANDSHAKE, ERROR_WEBVIEW, ACTIVITY_REQUEST_INTENT_DATA_IS_NULL, BROADCAST_RECEIVER_ERROR, AUTH_FAILED, AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED, AUTH_FAILED_SERVER_ERROR, AUTH_FAILED_NO_RESOURCES, AUTH_FAILED_NO_STATE, AUTH_FAILED_BAD_STATE, AUTH_FAILED_NO_TOKEN, AUTH_FAILED_CANCELLED, AUTH_FAILED_INTERNAL_ERROR, AUTH_FAILED_USER_MISMATCH, AUTH_FAILED_INTUNE_POLICY_REQUIRED, DEVICE_INTERNET_IS_NOT_AVAILABLE, NO_NETWORK_CONNECTION_POWER_OPTIMIZATION, ON_ACTIVITY_RESULT_INTENT_NULL, ON_ACTIVITY_RESULT_CALLBACK_NOT_FOUND, DEVICE_SHARED_PREF_IS_NOT_AVAILABLE, DEVICE_CACHE_IS_NOT_WORKING, DEVICE_FILE_CACHE_IS_NOT_LOADED_FROM_FILE, DEVICE_FILE_CACHE_IS_NOT_WRITING_TO_FILE, DEVICE_FILE_CACHE_FORMAT_IS_WRONG, DEVICE_CONNECTION_IS_NOT_AVAILABLE, DEVICE_PRNG_FIX_ERROR, IDTOKEN_PARSING_FAILURE, DATE_PARSING_FAILURE, AUTHORIZATION_CODE_NOT_EXCHANGED_FOR_TOKEN, BROADCAST_CANCEL_NOT_SUCCESSFUL, CORRELATION_ID_FORMAT, CORRELATION_ID_NOT_MATCHING_REQUEST_RESPONSE, ENCODING_IS_NOT_SUPPORTED, SERVER_INVALID_JSON_RESPONSE, AUTH_REFRESH_FAILED, ENCRYPTION_FAILED, DECRYPTION_FAILED, ANDROIDKEYSTORE_FAILED, ANDROIDKEYSTORE_KEYPAIR_GENERATOR_FAILED, DISCOVERY_NOT_SUPPORTED, BROKER_PACKAGE_NAME_NOT_FOUND, BROKER_PRT_FAILED, BROKER_AUTHENTICATOR_NOT_RESPONDING, BROKER_AUTHENTICATOR_OPERATION_CANCEL, BROKER_AUTHENTICATOR_ERROR_GETAUTHTOKEN, BROKER_AUTHENTICATOR_BAD_ARGUMENTS, BROKER_AUTHENTICATOR_BAD_AUTHENTICATION, BROKER_AUTHENTICATOR_UNSUPPORTED_OPERATION, BROKER_AUTHENTICATOR_IO_EXCEPTION, BROKER_AUTHENTICATOR_EXCEPTION, BROKER_VERIFICATION_FAILED, PACKAGE_NAME_NOT_FOUND, DIGEST_ERROR, BROKER_AUTHENTICATION_REQUEST_IS_NULL, BROKER_APP_VERIFICATION_FAILED, BROKER_ACTIVITY_INFO_NOT_FOUND, BROKER_SIGNATURE_NOT_SAVED, BROKER_ACCOUNT_DEVICE_REGISTRY_FAILURE, BROKER_ACCOUNT_FAILED_RESOLVED_INTERRUPT, DEVICE_NO_SUCH_ALGORITHM, DEVICE_ALGORITHM_PADDING_EXCEPTION, APP_PACKAGE_NAME_NOT_FOUND, ENCRYPTION_ERROR, BROKER_ACTIVITY_IS_NOT_RESOLVED, BROKER_ACTIVITY_INVALID_REQUEST, BROKER_ACCOUNT_SAVE_FAILED, BROKER_ACCOUNT_DOES_NOT_EXIST, BROKER_SINGLE_USER_EXPECTED, KEY_CHAIN_PRIVATE_KEY_EXCEPTION, SIGNATURE_EXCEPTION, DEVICE_CERTIFICATE_RESPONSE_FAILED, WEBVIEW_RETURNED_AUTHENTICATION_EXCEPTION, WEBVIEW_RETURNED_INVALID_AUTHENTICATION_EXCEPTION, WEBVIEW_RETURNED_EMPTY_REDIRECT_URL, WEBVIEW_REDIRECTURL_NOT_SSL_PROTECTED, DEVICE_CERTIFICATE_API_EXCEPTION, DEVICE_CERTIFICATE_REQUEST_INVALID, RESOURCE_NOT_FOUND, CERTIFICATE_ENCODING_ERROR, ERROR_SILENT_REQUEST, DEVELOPER_REDIRECTURI_INVALID, DEVICE_CHALLENGE_FAILURE, RESOURCE_AUTHENTICATION_CHALLENGE_FAILURE, INVALID_TOKEN_CACHE_ITEM, FAIL_TO_EXPORT, FAIL_TO_IMPORT, INCOMPATIBLE_BLOB_VERSION, TOKEN_CACHE_ITEM_NOT_FOUND, JSON_PARSE_ERROR, DRS_METADATA_URL_INVALID, DRS_FAILED_SERVER_ERROR, DRS_DISCOVERY_FAILED_UNKNOWN_HOST, BROKER_APP_INSTALLATION_STARTED, PARALLEL_UI_REQUESTS, X_MS_CLITELEM_VERSION_UNRECOGNIZED, X_MS_CLITELEM_MALFORMED, DEVICE_CERT_PROXY_UNINITIALIZED, BROKER_BIND_SERVICE_FAILED, localObject };
    localObject = new HashMap();
    exceptionMap = (Map)localObject;
    ((Map)localObject).put("android_keystore_failed", ANDROIDKEYSTORE_FAILED);
    exceptionMap.put("authority_url_not_valid", DEVELOPER_AUTHORITY_IS_NOT_VALID_INSTANCE);
    exceptionMap.put("authority_validation_not_supported", DEVELOPER_AUTHORITY_CAN_NOT_BE_VALIDED);
    exceptionMap.put("decryption_error", DECRYPTION_FAILED);
    exceptionMap.put("device_network_not_available", DEVICE_CONNECTION_IS_NOT_AVAILABLE);
    exceptionMap.put("device_network_not_available_doze_mode", NO_NETWORK_CONNECTION_POWER_OPTIMIZATION);
    exceptionMap.put("encryption_error", ENCRYPTION_ERROR);
    exceptionMap.put("invalid_jwt", JSON_PARSE_ERROR);
    exceptionMap.put("io_error", IO_EXCEPTION);
    exceptionMap.put("socket_timeout", SOCKET_TIMEOUT_EXCEPTION);
    exceptionMap.put("json_parse_failure", JSON_PARSE_ERROR);
    exceptionMap.put("malformed_url", DEVELOPER_AUTHORITY_IS_NOT_VALID_URL);
    exceptionMap.put("multiple_matching_tokens_detected", AUTH_FAILED_USER_MISMATCH);
    exceptionMap.put("user_mismatch", AUTH_FAILED_USER_MISMATCH);
    exceptionMap.put("no_such_algorithm", DEVICE_NO_SUCH_ALGORITHM);
    exceptionMap.put("unsupported_encoding", ENCODING_IS_NOT_SUPPORTED);
    exceptionMap.put("access_denied", AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED);
    exceptionMap.put("invalid_instance", AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED);
    exceptionMap.put("invalid_request", SERVER_INVALID_REQUEST);
    exceptionMap.put("request_timeout", SERVER_ERROR);
    exceptionMap.put("service_not_available", SERVER_ERROR);
    exceptionMap.put("unknown_error", SERVER_ERROR);
    exceptionMap.put("Package name is not resolved", PACKAGE_NAME_NOT_FOUND);
    exceptionMap.put("Calling app could not be verified", BROKER_APP_VERIFICATION_FAILED);
    exceptionMap.put("App package name is not found in the package manager", APP_PACKAGE_NAME_NOT_FOUND);
  }
  
  public ADALError(String paramString)
  {
    mDescription = paramString;
  }
  
  public String getDescription()
  {
    return mDescription;
  }
  
  public String getLocalizedDescription(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getResources().getConfiguration();
      localObject = new Resources(paramContext.getAssets(), paramContext.getResources().getDisplayMetrics(), (Configuration)localObject);
      return ((Resources)localObject).getString(((Resources)localObject).getIdentifier(name(), "string", paramContext.getPackageName()));
    }
    return mDescription;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.ADALError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */