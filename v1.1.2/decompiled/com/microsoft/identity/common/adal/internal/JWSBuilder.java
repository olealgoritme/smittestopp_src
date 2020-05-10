package com.microsoft.identity.common.adal.internal;

import android.util.Base64;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import e.c.c.v.c;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JWSBuilder
{
  public static final String JWS_ALGORITHM = "SHA256withRSA";
  public static final String JWS_HEADER_ALG = "RS256";
  public static final long SECONDS_MS = 1000L;
  public static final String TAG = "JWSBuilder";
  
  public static String sign(RSAPrivateKey paramRSAPrivateKey, byte[] paramArrayOfByte)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA256withRSA");
      localSignature.initSign(paramRSAPrivateKey);
      localSignature.update(paramArrayOfByte);
      paramRSAPrivateKey = StringExtensions.encodeBase64URLSafeString(localSignature.sign());
      return paramRSAPrivateKey;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramRSAPrivateKey = a.a("Unsupported RSA algorithm: ");
      paramRSAPrivateKey.append(paramArrayOfByte.getMessage());
      throw new ClientException("no_such_algorithm", paramRSAPrivateKey.toString(), paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramRSAPrivateKey)
    {
      throw new ClientException("unsupported_encoding", "Unsupported encoding", paramRSAPrivateKey);
    }
    catch (SignatureException paramRSAPrivateKey)
    {
      paramArrayOfByte = a.a("RSA signature exception: ");
      paramArrayOfByte.append(paramRSAPrivateKey.getMessage());
      throw new ClientException("Signature exception", paramArrayOfByte.toString(), paramRSAPrivateKey);
    }
    catch (InvalidKeyException paramRSAPrivateKey)
    {
      paramArrayOfByte = a.a("Invalid private RSA key: ");
      paramArrayOfByte.append(paramRSAPrivateKey.getMessage());
      throw new ClientException("Key Chain private key exception", paramArrayOfByte.toString(), paramRSAPrivateKey);
    }
  }
  
  public String generateSignedJWT(String paramString1, String paramString2, RSAPrivateKey paramRSAPrivateKey, RSAPublicKey paramRSAPublicKey, X509Certificate paramX509Certificate)
  {
    if (!StringExtensions.isNullOrBlank(paramString1))
    {
      if (!StringExtensions.isNullOrBlank(paramString2))
      {
        if (paramRSAPrivateKey != null)
        {
          if (paramRSAPublicKey != null)
          {
            paramRSAPublicKey = new Gson();
            Claims localClaims = new Claims(null);
            Claims.access$102(localClaims, paramString1);
            Claims.access$202(localClaims, paramString2);
            Claims.access$302(localClaims, System.currentTimeMillis() / 1000L);
            paramString2 = new JwsHeader(null);
            JwsHeader.access$502(paramString2, "RS256");
            JwsHeader.access$602(paramString2, "JWT");
            try
            {
              JwsHeader.access$702(paramString2, new String[1]);
              String[] arrayOfString = JwsHeader.access$700(paramString2);
              paramString1 = new java/lang/String;
              paramString1.<init>(Base64.encode(paramX509Certificate.getEncoded(), 2), "UTF-8");
              arrayOfString[0] = paramString1;
              paramString1 = paramRSAPublicKey.a(paramString2);
              paramString2 = paramRSAPublicKey.a(localClaims);
              Logger.verbose("JWSBuilder:generateSignedJWT", "Generate client certificate challenge response JWS Header. ");
              paramRSAPublicKey = new java/lang/StringBuilder;
              paramRSAPublicKey.<init>();
              paramRSAPublicKey.append(StringExtensions.encodeBase64URLSafeString(paramString1.getBytes("UTF-8")));
              paramRSAPublicKey.append(".");
              paramRSAPublicKey.append(StringExtensions.encodeBase64URLSafeString(paramString2.getBytes("UTF-8")));
              paramString1 = paramRSAPublicKey.toString();
              paramString2 = sign(paramRSAPrivateKey, paramString1.getBytes("UTF-8"));
              return a.a(paramString1, ".", paramString2);
            }
            catch (CertificateEncodingException paramString1)
            {
              throw new ClientException("Certificate encoding is not generated", "Certificate encoding error", paramString1);
            }
            catch (UnsupportedEncodingException paramString1)
            {
              throw new ClientException("unsupported_encoding", "Unsupported encoding", paramString1);
            }
          }
          throw new IllegalArgumentException("pubKey");
        }
        throw new IllegalArgumentException("privateKey");
      }
      throw new IllegalArgumentException("audience");
    }
    throw new IllegalArgumentException("nonce");
  }
  
  public final class Claims
  {
    @c("aud")
    public String mAudience;
    @c("iat")
    public long mIssueAt;
    @c("nonce")
    public String mNonce;
    
    public Claims() {}
  }
  
  public final class JwsHeader
  {
    @c("alg")
    public String mAlgorithm;
    @c("x5c")
    public String[] mCert;
    @c("typ")
    public String mType;
    
    public JwsHeader() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.JWSBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */