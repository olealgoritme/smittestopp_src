package com.microsoft.identity.common.adal.internal;

import android.util.Base64;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
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
    catch (NoSuchAlgorithmException paramRSAPrivateKey)
    {
      paramArrayOfByte = a.a("Unsupported RSA algorithm: ");
      paramArrayOfByte.append(paramRSAPrivateKey.getMessage());
      throw new ClientException("no_such_algorithm", paramArrayOfByte.toString(), paramRSAPrivateKey);
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
            Gson localGson = new Gson();
            paramRSAPublicKey = new JWSBuilder.Claims(this, null);
            JWSBuilder.Claims.access$102(paramRSAPublicKey, paramString1);
            JWSBuilder.Claims.access$202(paramRSAPublicKey, paramString2);
            JWSBuilder.Claims.access$302(paramRSAPublicKey, System.currentTimeMillis() / 1000L);
            paramString2 = new JWSBuilder.JwsHeader(this, null);
            JWSBuilder.JwsHeader.access$502(paramString2, "RS256");
            JWSBuilder.JwsHeader.access$602(paramString2, "JWT");
            try
            {
              JWSBuilder.JwsHeader.access$702(paramString2, new String[1]);
              paramString1 = JWSBuilder.JwsHeader.access$700(paramString2);
              String str = new java/lang/String;
              str.<init>(Base64.encode(paramX509Certificate.getEncoded(), 2), "UTF-8");
              paramString1[0] = str;
              paramString1 = localGson.a(paramString2);
              paramRSAPublicKey = localGson.a(paramRSAPublicKey);
              Logger.verbose("JWSBuilder:generateSignedJWT", "Generate client certificate challenge response JWS Header. ");
              paramString2 = new java/lang/StringBuilder;
              paramString2.<init>();
              paramString2.append(StringExtensions.encodeBase64URLSafeString(paramString1.getBytes("UTF-8")));
              paramString2.append(".");
              paramString2.append(StringExtensions.encodeBase64URLSafeString(paramRSAPublicKey.getBytes("UTF-8")));
              paramString1 = paramString2.toString();
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.JWSBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */