package com.microsoft.identity.common.internal.providers.oauth2;

import android.util.Base64;
import e.c.c.v.c;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class PkceChallenge
  implements Serializable
{
  public static final String CHALLENGE_SHA256 = "S256";
  public static final int CODE_VERIFIER_BYTE_SIZE = 32;
  public static final String DIGEST_ALGORITHM = "SHA-256";
  public static final int ENCODE_MASK = 11;
  public static final String ISO_8859_1 = "ISO_8859_1";
  public static final long serialVersionUID = 8549806628675994235L;
  @c("code_challenge")
  public final String mCodeChallenge;
  @c("code_challenge_method")
  public final String mCodeChallengeMethod = "S256";
  public final transient String mCodeVerifier;
  
  public PkceChallenge(String paramString1, String paramString2)
  {
    mCodeVerifier = paramString1;
    mCodeChallenge = paramString2;
  }
  
  public static String generateCodeVerifier()
  {
    byte[] arrayOfByte = new byte[32];
    new SecureRandom().nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 11);
  }
  
  public static String generateCodeVerifierChallenge(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes("ISO_8859_1"));
      paramString = Base64.encodeToString(localMessageDigest.digest(), 11);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Every implementation of the Java platform is required to support ISO-8859-1.Consult the release documentation for your implementation.", paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException("Failed to generate the code verifier challenge", paramString);
    }
  }
  
  public static PkceChallenge newPkceChallenge()
  {
    String str = generateCodeVerifier();
    return new PkceChallenge(str, generateCodeVerifierChallenge(str));
  }
  
  public String getCodeChallenge()
  {
    return mCodeChallenge;
  }
  
  public String getCodeChallengeMethod()
  {
    return "S256";
  }
  
  public String getCodeVerifier()
  {
    return mCodeVerifier;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.PkceChallenge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */