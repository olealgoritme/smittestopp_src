package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.c;
import java.util.List;

public class OpenIdProviderConfiguration
{
  @c("acr_values_supported")
  public List<String> mAcrValuesSupported;
  @c("authorization_endpoint")
  public String mAuthorizationEndpoint;
  @c("check_session_iframe")
  public String mCheckSessionIFrame;
  @c("claim_types_supported")
  public List<String> mClaimTypesSupported;
  @c("claims_locales_supported")
  public List<String> mClaimsLocalesSupported;
  @c("claims_parameter_supported")
  public Boolean mClaimsParameterSupported;
  @c("claims_supported")
  public List<String> mClaimsSupported;
  @c("cloud_graph_host_name")
  public String mCloudGraphHostName;
  @c("cloud_instance_name")
  public String mCloudInstanceName;
  @c("display_values_supported")
  public List<String> mDisplayValuesSupported;
  @c("end_session_endpoint")
  public String mEndSessionEndpoint;
  @c("frontchannel_logout_supported")
  public Boolean mFrontChannelLogoutSupported;
  @c("grant_types_supported")
  public List<String> mGrantTypesSupported;
  @c("http_logout_supported")
  public Boolean mHttpLogoutSupported;
  @c("id_token_encryption_alg_values_supported")
  public List<String> mIdTokenEncryptionAlgValuesSupported;
  @c("id_token_encryption_enc_values_supported")
  public List<String> mIdTokenEncryptionEncValuesSupported;
  @c("id_token_signing_alg_values_supported")
  public List<String> mIdTokenSigningAlgValuesSupported;
  @c("issuer")
  public String mIssuer;
  @c("jwks_uri")
  public String mJwksUri;
  @c("msgraph_host")
  public String mMsGraphHost;
  @c("op_policy_uri")
  public String mOpPolicyUri;
  @c("op_tos_uri")
  public String mOpTosUri;
  @c("rbac_url")
  public String mRbacUrl;
  @c("registration_endpoint")
  public String mRegistrationEndpoint;
  @c("request_object_encryption_alg_values_supported")
  public List<String> mRequestObjectEncryptionAlgValuesSupported;
  @c("request_object_encryption_enc_values_supported")
  public List<String> mRequestObjectEncryptionEncValuesSupported;
  @c("request_object_signing_alg_values_supported")
  public List<String> mRequestObjectSigningAlgValuesSupported;
  @c("request_parameter_supported")
  public Boolean mRequestParameterSupported;
  @c("request_uri_parameter_supported")
  public Boolean mRequestUriParameterSupported;
  @c("require_request_uri_registration")
  public Boolean mRequireRequestUriRegistration;
  @c("response_modes_supported")
  public List<String> mResponseModesSupported;
  @c("response_types_supported")
  public List<String> mResponseTypesSupported;
  @c("scopes_supported")
  public List<String> mScopesSupported;
  @c("service_documentation")
  public String mServiceDocumentation;
  @c("subject_types_supported")
  public List<String> mSubjectTypesSupported;
  @c("tenant_region_scope")
  public String mTenantRegionScope;
  @c("token_endpoint")
  public String mTokenEndpoint;
  @c("token_endpoint_auth_methods_supported")
  public List<String> mTokenEndpointAuthMethodsSupported;
  @c("token_endpoint_auth_signing_alg_values_supported")
  public List<String> mTokenEndpointAuthSigningAlgValuesSupported;
  @c("ui_locales_supported")
  public List<String> mUiLocalesSupported;
  @c("userinfo_encryption_alg_values_supported")
  public List<String> mUserInfoEncryptionAlgValuesSupported;
  @c("userinfo_encryption_enc_values_supported")
  public List<String> mUserInfoEncryptionEncValueSupported;
  @c("userinfo_endpoint")
  public String mUserInfoEndpoint;
  @c("userinfo_signing_alg_values_supported")
  public List<String> mUserInfoSigningAlgValuesSupported;
  
  public List<String> getAcrValuesSupported()
  {
    return mAcrValuesSupported;
  }
  
  public String getAuthorizationEndpoint()
  {
    return mAuthorizationEndpoint;
  }
  
  public String getCheckSessionIFrame()
  {
    return mCheckSessionIFrame;
  }
  
  public List<String> getClaimTypesSupported()
  {
    return mClaimTypesSupported;
  }
  
  public List<String> getClaimsLocalesSupported()
  {
    return mClaimsLocalesSupported;
  }
  
  public Boolean getClaimsParameterSupported()
  {
    return mClaimsParameterSupported;
  }
  
  public List<String> getClaimsSupported()
  {
    return mClaimsSupported;
  }
  
  public String getCloudGraphHostName()
  {
    return mCloudGraphHostName;
  }
  
  public String getCloudInstanceName()
  {
    return mCloudInstanceName;
  }
  
  public List<String> getDisplayValuesSupported()
  {
    return mDisplayValuesSupported;
  }
  
  public String getEndSessionEndpoint()
  {
    return mEndSessionEndpoint;
  }
  
  public Boolean getFrontChannelLogoutSupported()
  {
    return mFrontChannelLogoutSupported;
  }
  
  public List<String> getGrantTypesSupported()
  {
    return mGrantTypesSupported;
  }
  
  public Boolean getHttpLogoutSupported()
  {
    return mHttpLogoutSupported;
  }
  
  public List<String> getIdTokenEncryptionAlgValuesSupported()
  {
    return mIdTokenEncryptionAlgValuesSupported;
  }
  
  public List<String> getIdTokenEncryptionEncValuesSupported()
  {
    return mIdTokenEncryptionEncValuesSupported;
  }
  
  public List<String> getIdTokenSigningAlgValuesSupported()
  {
    return mIdTokenSigningAlgValuesSupported;
  }
  
  public String getIssuer()
  {
    return mIssuer;
  }
  
  public String getJwksUri()
  {
    return mJwksUri;
  }
  
  public String getMsGraphHost()
  {
    return mMsGraphHost;
  }
  
  public String getOpPolicyUri()
  {
    return mOpPolicyUri;
  }
  
  public String getOpTosUri()
  {
    return mOpTosUri;
  }
  
  public String getRbacUrl()
  {
    return mRbacUrl;
  }
  
  public String getRegistrationEndpoint()
  {
    return mRegistrationEndpoint;
  }
  
  public List<String> getRequestObjectEncryptionAlgValuesSupported()
  {
    return mRequestObjectEncryptionAlgValuesSupported;
  }
  
  public List<String> getRequestObjectEncryptionEncValuesSupported()
  {
    return mRequestObjectEncryptionEncValuesSupported;
  }
  
  public List<String> getRequestObjectSigningAlgValuesSupported()
  {
    return mRequestObjectSigningAlgValuesSupported;
  }
  
  public Boolean getRequestParameterSupported()
  {
    return mRequestParameterSupported;
  }
  
  public Boolean getRequestUriParameterSupported()
  {
    return mRequestUriParameterSupported;
  }
  
  public Boolean getRequireRequestUriRegistration()
  {
    return mRequireRequestUriRegistration;
  }
  
  public List<String> getResponseModesSupported()
  {
    return mResponseModesSupported;
  }
  
  public List<String> getResponseTypesSupported()
  {
    return mResponseTypesSupported;
  }
  
  public List<String> getScopesSupported()
  {
    return mScopesSupported;
  }
  
  public String getServiceDocumentation()
  {
    return mServiceDocumentation;
  }
  
  public List<String> getSubjectTypesSupported()
  {
    return mSubjectTypesSupported;
  }
  
  public String getTenantRegionScope()
  {
    return mTenantRegionScope;
  }
  
  public String getTokenEndpoint()
  {
    return mTokenEndpoint;
  }
  
  public List<String> getTokenEndpointAuthMethodsSupported()
  {
    return mTokenEndpointAuthMethodsSupported;
  }
  
  public List<String> getTokenEndpointAuthSigningAlgValuesSupported()
  {
    return mTokenEndpointAuthSigningAlgValuesSupported;
  }
  
  public List<String> getUiLocalesSupported()
  {
    return mUiLocalesSupported;
  }
  
  public List<String> getUserInfoEncryptionAlgValuesSupported()
  {
    return mUserInfoEncryptionAlgValuesSupported;
  }
  
  public List<String> getUserInfoEncryptionEncValueSupported()
  {
    return mUserInfoEncryptionEncValueSupported;
  }
  
  public String getUserInfoEndpoint()
  {
    return mUserInfoEndpoint;
  }
  
  public List<String> getUserInfoSigningAlgValuesSupported()
  {
    return mUserInfoSigningAlgValuesSupported;
  }
  
  public void setAcrValuesSupported(List<String> paramList)
  {
    mAcrValuesSupported = paramList;
  }
  
  public void setAuthorizationEndpoint(String paramString)
  {
    mAuthorizationEndpoint = paramString;
  }
  
  public void setCheckSessionIFrame(String paramString)
  {
    mCheckSessionIFrame = paramString;
  }
  
  public void setClaimTypesSupported(List<String> paramList)
  {
    mClaimTypesSupported = paramList;
  }
  
  public void setClaimsLocalesSupported(List<String> paramList)
  {
    mClaimsLocalesSupported = paramList;
  }
  
  public void setClaimsParameterSupported(Boolean paramBoolean)
  {
    mClaimsParameterSupported = paramBoolean;
  }
  
  public void setClaimsSupported(List<String> paramList)
  {
    mClaimsSupported = paramList;
  }
  
  public void setCloudGraphHostName(String paramString)
  {
    mCloudGraphHostName = paramString;
  }
  
  public void setCloudInstanceName(String paramString)
  {
    mCloudInstanceName = paramString;
  }
  
  public void setDisplayValuesSupported(List<String> paramList)
  {
    mDisplayValuesSupported = paramList;
  }
  
  public void setEndSessionEndpoint(String paramString)
  {
    mEndSessionEndpoint = paramString;
  }
  
  public void setFrontChannelLogoutSupported(Boolean paramBoolean)
  {
    mFrontChannelLogoutSupported = paramBoolean;
  }
  
  public void setGrantTypesSupported(List<String> paramList)
  {
    mGrantTypesSupported = paramList;
  }
  
  public void setHttpLogoutSupported(Boolean paramBoolean)
  {
    mHttpLogoutSupported = paramBoolean;
  }
  
  public void setIdTokenEncryptionAlgValuesSupported(List<String> paramList)
  {
    mIdTokenEncryptionAlgValuesSupported = paramList;
  }
  
  public void setIdTokenEncryptionEncValuesSupported(List<String> paramList)
  {
    mIdTokenEncryptionEncValuesSupported = paramList;
  }
  
  public void setIdTokenSigningAlgValuesSupported(List<String> paramList)
  {
    mIdTokenSigningAlgValuesSupported = paramList;
  }
  
  public void setIssuer(String paramString)
  {
    mIssuer = paramString;
  }
  
  public void setJwksUri(String paramString)
  {
    mJwksUri = paramString;
  }
  
  public void setMsGraphHost(String paramString)
  {
    mMsGraphHost = paramString;
  }
  
  public void setOpPolicyUri(String paramString)
  {
    mOpPolicyUri = paramString;
  }
  
  public void setOpTosUri(String paramString)
  {
    mOpTosUri = paramString;
  }
  
  public void setRbacUrl(String paramString)
  {
    mRbacUrl = paramString;
  }
  
  public void setRegistrationEndpoint(String paramString)
  {
    mRegistrationEndpoint = paramString;
  }
  
  public void setRequestObjectEncryptionAlgValuesSupported(List<String> paramList)
  {
    mRequestObjectEncryptionAlgValuesSupported = paramList;
  }
  
  public void setRequestObjectEncryptionEncValuesSupported(List<String> paramList)
  {
    mRequestObjectEncryptionEncValuesSupported = paramList;
  }
  
  public void setRequestObjectSigningAlgValuesSupported(List<String> paramList)
  {
    mRequestObjectSigningAlgValuesSupported = paramList;
  }
  
  public void setRequestParameterSupported(Boolean paramBoolean)
  {
    mRequestParameterSupported = paramBoolean;
  }
  
  public void setRequestUriParameterSupported(Boolean paramBoolean)
  {
    mRequestUriParameterSupported = paramBoolean;
  }
  
  public void setRequireRequestUriRegistration(Boolean paramBoolean)
  {
    mRequireRequestUriRegistration = paramBoolean;
  }
  
  public void setResponseModesSupported(List<String> paramList)
  {
    mResponseModesSupported = paramList;
  }
  
  public void setResponseTypesSupported(List<String> paramList)
  {
    mResponseTypesSupported = paramList;
  }
  
  public void setScopesSupported(List<String> paramList)
  {
    mScopesSupported = paramList;
  }
  
  public void setServiceDocumentation(String paramString)
  {
    mServiceDocumentation = paramString;
  }
  
  public void setSubjectTypesSupported(List<String> paramList)
  {
    mSubjectTypesSupported = paramList;
  }
  
  public void setTenantRegionScope(String paramString)
  {
    mTenantRegionScope = paramString;
  }
  
  public void setTokenEndpoint(String paramString)
  {
    mTokenEndpoint = paramString;
  }
  
  public void setTokenEndpointAuthMethodsSupported(List<String> paramList)
  {
    mTokenEndpointAuthMethodsSupported = paramList;
  }
  
  public void setTokenEndpointAuthSigningAlgValuesSupported(List<String> paramList)
  {
    mTokenEndpointAuthSigningAlgValuesSupported = paramList;
  }
  
  public void setUiLocalesSupported(List<String> paramList)
  {
    mUiLocalesSupported = paramList;
  }
  
  public void setUserInfoEncryptionAlgValuesSupported(List<String> paramList)
  {
    mUserInfoEncryptionAlgValuesSupported = paramList;
  }
  
  public void setUserInfoEncryptionEncValueSupported(List<String> paramList)
  {
    mUserInfoEncryptionEncValueSupported = paramList;
  }
  
  public void setUserInfoEndpoint(String paramString)
  {
    mUserInfoEndpoint = paramString;
  }
  
  public void setUserInfoSigningAlgValuesSupported(List<String> paramList)
  {
    mUserInfoSigningAlgValuesSupported = paramList;
  }
  
  public static final class SerializedNames
  {
    public static final String ACR_VALUES_SUPPORTED = "acr_values_supported";
    public static final String AUTHORIZATION_ENDPOINT = "authorization_endpoint";
    public static final String CHECK_SESSION_IFRAME = "check_session_iframe";
    public static final String CLAIMS_LOCALES_SUPPORTED = "claims_locales_supported";
    public static final String CLAIMS_PARAMETER_SUPPORTED = "claims_parameter_supported";
    public static final String CLAIMS_SUPPORTED = "claims_supported";
    public static final String CLAIM_TYPES_SUPPORTED = "claim_types_supported";
    public static final String CLOUD_GRAPH_HOST_NAME = "cloud_graph_host_name";
    public static final String CLOUD_INSTANCE_NAME = "cloud_instance_name";
    public static final String DISPLAY_VALUES_SUPPORTED = "display_values_supported";
    public static final String END_SESSION_ENDPOINT = "end_session_endpoint";
    public static final String FRONTCHANNEL_LOGOUT_SUPPORTED = "frontchannel_logout_supported";
    public static final String GRANT_TYPES_SUPPORTED = "grant_types_supported";
    public static final String HTTP_LOGOUT_SUPPORTED = "http_logout_supported";
    public static final String ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED = "id_token_encryption_alg_values_supported";
    public static final String ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED = "id_token_encryption_enc_values_supported";
    public static final String ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED = "id_token_signing_alg_values_supported";
    public static final String ISSUER = "issuer";
    public static final String JWKS_URI = "jwks_uri";
    public static final String MSGRAPH_HOST = "msgraph_host";
    public static final String OP_POLICY_URI = "op_policy_uri";
    public static final String OP_TOS_URI = "op_tos_uri";
    public static final String RBAC_URL = "rbac_url";
    public static final String REGISTRATION_ENDPOINT = "registration_endpoint";
    public static final String REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED = "request_object_encryption_alg_values_supported";
    public static final String REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED = "request_object_encryption_enc_values_supported";
    public static final String REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED = "request_object_signing_alg_values_supported";
    public static final String REQUEST_PARAMETER_SUPPORTED = "request_parameter_supported";
    public static final String REQUEST_URI_PARAMETER_SUPPORTED = "request_uri_parameter_supported";
    public static final String REQUIRE_REQUEST_URI_REGISTRATION = "require_request_uri_registration";
    public static final String RESPONSE_MODES_SUPPORTED = "response_modes_supported";
    public static final String RESPONSE_TYPES_SUPPORTED = "response_types_supported";
    public static final String SCOPES_SUPPORTED = "scopes_supported";
    public static final String SERVICE_DOCUMENTATION = "service_documentation";
    public static final String SUBJECT_TYPES_SUPPORTED = "subject_types_supported";
    public static final String TENANT_REGION_SCOPE = "tenant_region_scope";
    public static final String TOKEN_ENDPOINT = "token_endpoint";
    public static final String TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED = "token_endpoint_auth_methods_supported";
    public static final String TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED = "token_endpoint_auth_signing_alg_values_supported";
    public static final String UI_LOCALES_SUPPORTED = "ui_locales_supported";
    public static final String USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED = "userinfo_encryption_alg_values_supported";
    public static final String USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED = "userinfo_encryption_enc_values_supported";
    public static final String USERINFO_ENDPOINT = "userinfo_endpoint";
    public static final String USERINFO_SIGNING_ALG_VALUES_SUPPORTED = "userinfo_signing_alg_values_supported";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */