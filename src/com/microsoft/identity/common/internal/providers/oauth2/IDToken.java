package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import e.e.b.b;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IDToken
{
  public static final String ADDRESS = "address";
  public static final String BIRTHDATE = "birthdate";
  public static final String EMAIL = "email";
  public static final String EMAIL_VERIFIED = "email_verified";
  public static final String FAMILY_NAME = "family_name";
  public static final String GENDER = "gender";
  public static final String GIVEN_NAME = "given_name";
  public static final String LOCALE = "locale";
  public static final String MIDDLE_NAME = "middle_name";
  public static final String NAME = "name";
  public static final String NICKNAME = "nickname";
  public static final String PHONE_NUMBER = "phone_number";
  public static final String PHONE_NUMBER_VERIFIED = "phone_number_verified";
  public static final String PICTURE = "picture";
  public static final String PREFERRED_USERNAME = "preferred_username";
  public static final String PROFILE = "profile";
  public static final String SUBJECT = "sub";
  public static final String UPDATED_AT = "updated_at";
  public static final String WEBSITE = "website";
  public static final String ZONEINFO = "zoneinfo";
  public final String mRawIdToken;
  public Map<String, ?> mTokenClaims = null;
  
  public IDToken(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      mRawIdToken = paramString;
      mTokenClaims = parseJWT(paramString);
      return;
    }
    throw new IllegalArgumentException("null or empty raw idtoken");
  }
  
  public static Map<String, ?> parseJWT(String paramString)
  {
    Object localObject = new HashMap();
    try
    {
      ((HashMap)localObject).putAll(Collections.unmodifiableMap(bcx));
      return (Map<String, ?>)localObject;
    }
    catch (ParseException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ObjectMapper.TAG);
      ((StringBuilder)localObject).append(":getClaims(String)");
      Logger.error(((StringBuilder)localObject).toString(), "Failed to parse IdToken", paramString);
      throw new ServiceException("Failed to parse JWT", "invalid_jwt", paramString);
    }
  }
  
  public String getRawIDToken()
  {
    return mRawIdToken;
  }
  
  public Map<String, ?> getTokenClaims()
  {
    return Collections.unmodifiableMap(mTokenClaims);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.IDToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */