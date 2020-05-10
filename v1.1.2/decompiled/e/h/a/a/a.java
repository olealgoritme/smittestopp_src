package e.h.a.a;

import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  public static final AtomicBoolean a = new AtomicBoolean(false);
  
  public static a a(String paramString, c paramc)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    a();
    Object localObject = new SecureRandom();
    paramString = new byte[16];
    ((SecureRandom)localObject).nextBytes(paramString);
    localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
    ((Cipher)localObject).init(1, a, new IvParameterSpec(paramString));
    paramString = ((Cipher)localObject).getIV();
    arrayOfByte = ((Cipher)localObject).doFinal(arrayOfByte);
    localObject = a.a(paramString, arrayOfByte);
    paramc = b;
    Mac localMac = Mac.getInstance("HmacSHA256");
    localMac.init(paramc);
    return new a(arrayOfByte, paramString, localMac.doFinal((byte[])localObject));
  }
  
  public static c a(String paramString)
  {
    Object localObject = paramString.split(":");
    if (localObject.length == 2)
    {
      paramString = Base64.decode(localObject[0], 2);
      if (paramString.length == 16)
      {
        localObject = Base64.decode(localObject[1], 2);
        if (localObject.length == 32) {
          return new c(new SecretKeySpec(paramString, 0, paramString.length, "AES"), new SecretKeySpec((byte[])localObject, "HmacSHA256"));
        }
        throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
      }
      throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
    }
    throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
  }
  
  public static c a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    a();
    paramString = new PBEKeySpec(paramString.toCharArray(), paramArrayOfByte, paramInt, 384);
    byte[] arrayOfByte = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(paramString).getEncoded();
    paramArrayOfByte = new byte[16];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, 16);
    paramString = new byte[32];
    System.arraycopy(arrayOfByte, 16, paramString, 0, 32);
    return new c(new SecretKeySpec(paramArrayOfByte, "AES"), new SecretKeySpec(paramString, "HmacSHA256"));
  }
  
  public static String a(a parama, c paramc)
  {
    Object localObject1 = a.a(b, a);
    Object localObject2 = b;
    Mac localMac = Mac.getInstance("HmacSHA256");
    localMac.init((Key)localObject2);
    localObject1 = localMac.doFinal((byte[])localObject1);
    localObject2 = c;
    int i = localObject1.length;
    int j = localObject2.length;
    int k = 0;
    if (i != j)
    {
      j = k;
    }
    else
    {
      j = 0;
      i = 0;
      while (j < localObject1.length)
      {
        i |= localObject1[j] ^ localObject2[j];
        j++;
      }
      j = k;
      if (i == 0) {
        j = 1;
      }
    }
    if (j != 0)
    {
      localObject1 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject1).init(2, a, new IvParameterSpec(b));
      return new String(((Cipher)localObject1).doFinal(a), "UTF-8");
    }
    throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
  }
  
  public static void a()
  {
    if (!a.get()) {
      try
      {
        if (!a.get())
        {
          b.a();
          a.set(true);
        }
      }
      finally {}
    }
  }
  
  public static c b()
  {
    a();
    Object localObject = KeyGenerator.getInstance("AES");
    ((KeyGenerator)localObject).init(128);
    SecretKey localSecretKey = ((KeyGenerator)localObject).generateKey();
    a();
    localObject = new SecureRandom();
    byte[] arrayOfByte = new byte[32];
    ((SecureRandom)localObject).nextBytes(arrayOfByte);
    return new c(localSecretKey, new SecretKeySpec(arrayOfByte, "HmacSHA256"));
  }
  
  public static class a
  {
    public final byte[] a;
    public final byte[] b;
    public final byte[] c;
    
    public a(String paramString)
    {
      paramString = paramString.split(":");
      if (paramString.length == 3)
      {
        b = Base64.decode(paramString[0], 2);
        c = Base64.decode(paramString[1], 2);
        a = Base64.decode(paramString[2], 2);
        return;
      }
      throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
    }
    
    public a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
      a = arrayOfByte;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = new byte[paramArrayOfByte2.length];
      b = paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
      paramArrayOfByte1 = new byte[paramArrayOfByte3.length];
      c = paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
    }
    
    public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      return arrayOfByte;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (a.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (a)paramObject;
      if (!Arrays.equals(a, a)) {
        return false;
      }
      if (!Arrays.equals(b, b)) {
        return false;
      }
      return Arrays.equals(c, c);
    }
    
    public int hashCode()
    {
      int i = Arrays.hashCode(a);
      int j = Arrays.hashCode(b);
      return Arrays.hashCode(c) + (j + (i + 31) * 31) * 31;
    }
    
    public String toString()
    {
      String str1 = Base64.encodeToString(b, 2);
      String str2 = Base64.encodeToString(a, 2);
      String str3 = Base64.encodeToString(c, 2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(":");
      localStringBuilder.append(str3);
      localStringBuilder.append(":");
      localStringBuilder.append(str2);
      return String.format(localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public static final class b
  {
    public static final byte[] a;
    
    static
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = Build.FINGERPRINT;
      if (localObject != null) {
        localStringBuilder.append((String)localObject);
      }
      localObject = null;
      try
      {
        String str = (String)Build.class.getField("SERIAL").get(null);
        localObject = str;
      }
      catch (Exception localException) {}
      if (localObject != null) {
        localStringBuilder.append((String)localObject);
      }
      try
      {
        localObject = localStringBuilder.toString().getBytes("UTF-8");
        a = (byte[])localObject;
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException("UTF-8 encoding not supported");
      }
    }
    
    public static void a() {}
  }
  
  public static class c
  {
    public SecretKey a;
    public SecretKey b;
    
    public c(SecretKey paramSecretKey1, SecretKey paramSecretKey2)
    {
      a = paramSecretKey1;
      b = paramSecretKey2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (c.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (c)paramObject;
      if (!b.equals(b)) {
        return false;
      }
      return a.equals(a);
    }
    
    public int hashCode()
    {
      int i = a.hashCode();
      return b.hashCode() + (i + 31) * 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Base64.encodeToString(a.getEncoded(), 2));
      localStringBuilder.append(":");
      localStringBuilder.append(Base64.encodeToString(b.getEncoded(), 2));
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     e.h.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */