package com.microsoft.identity.common.internal.providers.microsoft;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.PkceChallenge;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.c.c.v.a;
import e.c.c.v.c;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

public abstract class MicrosoftAuthorizationRequest<T extends MicrosoftAuthorizationRequest<T>>
  extends AuthorizationRequest<T>
{
  public static final String INSTANCE_AWARE = "instance_aware";
  public static final String TAG = MicrosoftAuthorizationRequest.class.getSimpleName();
  public static final long serialVersionUID = 6873634931996113294L;
  public transient URL mAuthority;
  @c("code_challenge")
  public String mCodeChallenge;
  @c("code_challenge_method")
  public String mCodeChallengeMethod;
  @a
  @c("client-request-id")
  public UUID mCorrelationId;
  @a
  @c("x-client-CPU")
  public String mDiagnosticCPU;
  @a
  @c("x-client-DM")
  public String mDiagnosticDM;
  @a
  @c("x-client-OS")
  public String mDiagnosticOS;
  public transient Map<String, String> mFlightParameters;
  @a
  @c("x-client-SKU")
  public String mLibraryName;
  @a
  @c("x-client-Ver")
  public String mLibraryVersion;
  @c("login_hint")
  public String mLoginHint;
  @a
  @c("instance_aware")
  public Boolean mMultipleCloudAware;
  public transient PkceChallenge mPkceChallenge;
  public transient AzureActiveDirectorySlice mSlice;
  
  public MicrosoftAuthorizationRequest(MicrosoftAuthorizationRequest.Builder paramBuilder)
  {
    super(paramBuilder);
    mAuthority = MicrosoftAuthorizationRequest.Builder.access$000(paramBuilder);
    mLoginHint = mLoginHint;
    mCorrelationId = mCorrelationId;
    PkceChallenge localPkceChallenge = PkceChallenge.newPkceChallenge();
    mPkceChallenge = localPkceChallenge;
    mCodeChallengeMethod = localPkceChallenge.getCodeChallengeMethod();
    mCodeChallenge = mPkceChallenge.getCodeChallenge();
    mState = generateEncodedState();
    if (MicrosoftAuthorizationRequest.Builder.access$100(paramBuilder) != null) {
      mSlice = MicrosoftAuthorizationRequest.Builder.access$100(paramBuilder);
    }
    mFlightParameters = MicrosoftAuthorizationRequest.Builder.access$200(paramBuilder);
    mMultipleCloudAware = MicrosoftAuthorizationRequest.Builder.access$300(paramBuilder);
    mLibraryVersion = MicrosoftAuthorizationRequest.Builder.access$400(paramBuilder);
    mLibraryName = MicrosoftAuthorizationRequest.Builder.access$500(paramBuilder);
    mDiagnosticOS = String.valueOf(Build.VERSION.SDK_INT);
    mDiagnosticDM = Build.MODEL;
    paramBuilder = Build.SUPPORTED_ABIS;
    if ((paramBuilder != null) && (paramBuilder.length > 0)) {
      mDiagnosticCPU = paramBuilder[0];
    }
  }
  
  public static String decodeState(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
    {
      Logger.warn(TAG, "Decode state failed because the input state is empty.");
      return null;
    }
    return new String(Base64.decode(paramString, 9), Charset.defaultCharset());
  }
  
  public static String generateEncodedState()
  {
    UUID localUUID1 = UUID.randomUUID();
    UUID localUUID2 = UUID.randomUUID();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localUUID1.toString());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(localUUID2.toString());
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = Base64.encodeToString(((String)localObject).getBytes("UTF-8"), 11);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("Error generating encoded state parameter for Authorization Request", localException);
    }
  }
  
  public URL getAuthority()
  {
    return mAuthority;
  }
  
  public String getCodeChallenge()
  {
    return mCodeChallenge;
  }
  
  public String getCodeChallengeMethod()
  {
    return mCodeChallengeMethod;
  }
  
  public UUID getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getDiagnosticCPU()
  {
    return mDiagnosticCPU;
  }
  
  public String getDiagnosticDM()
  {
    return mDiagnosticDM;
  }
  
  public String getDiagnosticOS()
  {
    return mDiagnosticOS;
  }
  
  public String getLibraryName()
  {
    return mLibraryName;
  }
  
  public String getLibraryVersion()
  {
    return mLibraryVersion;
  }
  
  public String getLoginHint()
  {
    return mLoginHint;
  }
  
  public Boolean getMultipleCloudAware()
  {
    return mMultipleCloudAware;
  }
  
  public PkceChallenge getPkceChallenge()
  {
    return mPkceChallenge;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */