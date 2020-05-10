package com.microsoft.azure.proton.transport.proxy.impl;

import com.microsoft.azure.proton.transport.proxy.ProxyChallengeProcessor;
import e.d.a.a.a.a.a.a;
import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import k.f.c;

public class DigestProxyChallengeProcessorImpl
  implements ProxyChallengeProcessor
{
  public static final String DEFAULT_ALGORITHM = "MD5";
  public static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();
  public static final String PROXY_AUTH_DIGEST = "Proxy-Authenticate: Digest";
  public final String challenge;
  public final Map<String, String> headers;
  public final String host;
  public final k.f.b logger = c.a(DigestProxyChallengeProcessorImpl.class);
  public final AtomicInteger nonceCounter = new AtomicInteger(0);
  public final ProxyAuthenticator proxyAuthenticator;
  
  public DigestProxyChallengeProcessorImpl(String paramString1, String paramString2, ProxyAuthenticator paramProxyAuthenticator)
  {
    Objects.requireNonNull(paramProxyAuthenticator);
    host = paramString1;
    challenge = paramString2;
    headers = new HashMap();
    proxyAuthenticator = paramProxyAuthenticator;
  }
  
  private void computeDigestAuthHeader(Map<String, String> paramMap, String paramString, PasswordAuthentication paramPasswordAuthentication)
  {
    if (logger.a()) {
      logger.c("Computing password authentication...");
    }
    if (!ProxyAuthenticator.isPasswordAuthenticationHasValues(paramPasswordAuthentication))
    {
      if (logger.f()) {
        logger.a("Password authentication does not have values. Not computing authorization header.");
      }
      return;
    }
    String str1 = paramPasswordAuthentication.getUserName();
    String str2 = new String(paramPasswordAuthentication.getPassword());
    try
    {
      String str3 = (String)paramMap.get("nonce");
      paramPasswordAuthentication = (String)paramMap.get("realm");
      paramMap = (String)paramMap.get("qop");
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      Object localObject = new java/security/SecureRandom;
      ((SecureRandom)localObject).<init>();
      str2 = printHexBinary(localMessageDigest.digest(String.format("%s:%s:%s", new Object[] { str1, paramPasswordAuthentication, str2 }).getBytes(StandardCharsets.UTF_8)));
      String str4 = printHexBinary(localMessageDigest.digest(String.format("%s:%s", new Object[] { "CONNECT", paramString }).getBytes(StandardCharsets.UTF_8)));
      byte[] arrayOfByte = new byte[16];
      ((SecureRandom)localObject).nextBytes(arrayOfByte);
      localObject = printHexBinary(arrayOfByte);
      if (StringUtils.isNullOrEmpty(paramMap))
      {
        paramMap = String.format("Digest username=\"%s\",realm=\"%s\",nonce=\"%s\",uri=\"%s\",cnonce=\"%s\",response=\"%s\"", new Object[] { str1, paramPasswordAuthentication, str3, paramString, localObject, printHexBinary(localMessageDigest.digest(String.format("%s:%s:%s", new Object[] { str2, str3, str4 }).getBytes(StandardCharsets.UTF_8))) });
      }
      else
      {
        int i = nonceCounter.incrementAndGet();
        paramMap = String.format("Digest username=\"%s\",realm=\"%s\",nonce=\"%s\",uri=\"%s\",cnonce=\"%s\",nc=%08X,response=\"%s\",qop=\"%s\"", new Object[] { str1, paramPasswordAuthentication, str3, paramString, localObject, Integer.valueOf(i), printHexBinary(localMessageDigest.digest(String.format("%s:%s:%08X:%s:%s:%s", new Object[] { str2, str3, Integer.valueOf(i), localObject, paramMap, str4 }).getBytes(StandardCharsets.UTF_8))), paramMap });
      }
      headers.put("Proxy-Authorization", paramMap);
      if (logger.a()) {
        logger.a("Adding authorization header. {} '{}'", "Proxy-Authorization", paramMap);
      }
      return;
    }
    catch (NoSuchAlgorithmException paramMap)
    {
      if (logger.f()) {
        logger.e("Error encountered when computing header.", paramMap);
      }
      throw new RuntimeException(paramMap);
    }
  }
  
  private void getChallengeQuestionHeaders(String paramString, Map<String, String> paramMap)
  {
    String[] arrayOfString = paramString.substring(26).split(",");
    if (logger.a()) {
      logger.c("Fetching challenge questions.");
    }
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = arrayOfString[j];
      if (str.contains("="))
      {
        paramString = str.substring(0, str.indexOf("="));
        str = str.substring(str.indexOf("=") + 1);
        paramMap.put(paramString.trim(), str.replaceAll("\"", "").trim());
      }
    }
    if (logger.a())
    {
      logger.c("Challenge questions are: ");
      paramMap.forEach(new a(this));
    }
  }
  
  public static String printHexBinary(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfByte[j];
      localStringBuilder.append(HEX_CODE[(k >> 4 & 0xF)]);
      localStringBuilder.append(HEX_CODE[(k & 0xF)]);
    }
    return localStringBuilder.toString().toLowerCase(Locale.ROOT);
  }
  
  public Map<String, String> getHeader()
  {
    Object localObject = new Scanner(challenge);
    HashMap localHashMap = new HashMap();
    if (logger.a()) {
      logger.c("Fetching header from:");
    }
    while (((Scanner)localObject).hasNextLine())
    {
      String str = ((Scanner)localObject).nextLine();
      if (logger.a()) {
        logger.c(str);
      }
      if (str.contains("Proxy-Authenticate: Digest"))
      {
        getChallengeQuestionHeaders(str, localHashMap);
        localObject = host;
        computeDigestAuthHeader(localHashMap, (String)localObject, proxyAuthenticator.getPasswordAuthentication(Constants.DIGEST_LOWERCASE, (String)localObject));
        logger.c("Finished getting auth header.");
      }
    }
    if (logger.a())
    {
      logger.c("Headers added are:");
      headers.forEach(new e.d.a.a.a.a.a.b(this));
    }
    return headers;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.DigestProxyChallengeProcessorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */