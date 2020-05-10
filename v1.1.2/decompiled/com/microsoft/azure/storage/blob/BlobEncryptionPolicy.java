package com.microsoft.azure.storage.blob;

import com.microsoft.azure.keyvault.core.IKey;
import com.microsoft.azure.keyvault.core.IKeyResolver;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.EncryptionAgent;
import com.microsoft.azure.storage.core.EncryptionAlgorithm;
import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedContentKey;
import java.io.OutputStream;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l.a.a.b.e.b;

public final class BlobEncryptionPolicy
{
  public IKeyResolver keyResolver;
  public IKey keyWrapper;
  
  public BlobEncryptionPolicy(IKey paramIKey, IKeyResolver paramIKeyResolver)
  {
    keyWrapper = paramIKey;
    keyResolver = paramIKeyResolver;
  }
  
  public static OutputStream wrapUserStreamWithDecryptStream(CloudBlob paramCloudBlob, OutputStream paramOutputStream, BlobRequestOptions paramBlobRequestOptions, Map<String, String> paramMap, long paramLong, boolean paramBoolean1, Long paramLong1, Long paramLong2, int paramInt, boolean paramBoolean2)
  {
    String str = (String)paramMap.get("encryptiondata");
    if ((paramBlobRequestOptions.requireEncryption() != null) && (paramBlobRequestOptions.requireEncryption().booleanValue()) && (str == null)) {
      throw new StorageException("DecryptionError", "Encryption data does not exist. If you do not want to decrypt the data, please do not set the require encryption flag on request options", null);
    }
    boolean bool = false;
    if (!paramBoolean1)
    {
      paramLong1 = paramBlobRequestOptions.getEncryptionPolicy();
      paramBlobRequestOptions = paramBlobRequestOptions.requireEncryption();
      paramBoolean1 = bool;
      if (paramCloudBlob.getProperties().getBlobType() == BlobType.PAGE_BLOB) {
        paramBoolean1 = true;
      }
      return paramLong1.decryptBlob(paramOutputStream, paramMap, paramBlobRequestOptions, null, paramBoolean1);
    }
    if ((paramCloudBlob.getProperties().getBlobType() != BlobType.PAGE_BLOB) && ((paramLong1 == null) || (paramLong1.longValue() >= paramLong - 16L))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    return new BlobDecryptStream(paramOutputStream, paramMap, paramLong2, paramInt, paramBoolean2, paramBoolean1, paramBlobRequestOptions.getEncryptionPolicy(), paramBlobRequestOptions.requireEncryption());
  }
  
  public Cipher createAndSetEncryptionContext(Map<String, String> paramMap, boolean paramBoolean)
  {
    Utility.assertNotNull("metadata", paramMap);
    if (keyWrapper != null) {
      try
      {
        Object localObject1 = KeyGenerator.getInstance("AES");
        ((KeyGenerator)localObject1).init(256);
        Cipher localCipher;
        if (paramBoolean) {
          localCipher = Cipher.getInstance("AES/CBC/NoPadding");
        } else {
          localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
        Object localObject2 = ((KeyGenerator)localObject1).generateKey();
        localCipher.init(1, (Key)localObject2);
        localObject1 = new com/microsoft/azure/storage/blob/BlobEncryptionData;
        ((BlobEncryptionData)localObject1).<init>();
        if (((EncryptionData)localObject1).getKeyWrappingMetadata() == null)
        {
          localObject3 = new java/util/HashMap;
          ((HashMap)localObject3).<init>();
          ((EncryptionData)localObject1).setKeyWrappingMetadata((HashMap)localObject3);
        }
        ((EncryptionData)localObject1).getKeyWrappingMetadata().put("EncryptionLibrary", "Java 8.1.0");
        Object localObject3 = new com/microsoft/azure/storage/core/EncryptionAgent;
        ((EncryptionAgent)localObject3).<init>("1.0", EncryptionAlgorithm.AES_CBC_256);
        ((EncryptionData)localObject1).setEncryptionAgent((EncryptionAgent)localObject3);
        localObject2 = (b)keyWrapper.wrapKeyAsync(((SecretKey)localObject2).getEncoded(), null).get();
        localObject3 = new com/microsoft/azure/storage/core/WrappedContentKey;
        ((WrappedContentKey)localObject3).<init>(keyWrapper.getKid(), (byte[])((b)localObject2).getKey(), (String)((b)localObject2).getValue());
        ((EncryptionData)localObject1).setWrappedContentKey((WrappedContentKey)localObject3);
        ((EncryptionData)localObject1).setContentEncryptionIV(localCipher.getIV());
        paramMap.put("encryptiondata", ((BlobEncryptionData)localObject1).serialize());
        return localCipher;
      }
      catch (Exception paramMap)
      {
        throw StorageException.translateClientException(paramMap);
      }
    }
    throw new IllegalArgumentException("Key is not initialized. Encryption requires it to be initialized.");
  }
  
  public OutputStream decryptBlob(OutputStream paramOutputStream, Map<String, String> paramMap, Boolean paramBoolean, byte[] paramArrayOfByte, boolean paramBoolean1)
  {
    Utility.assertNotNull("metadata", paramMap);
    paramMap = (String)paramMap.get("encryptiondata");
    if (paramMap != null) {
      try
      {
        BlobEncryptionData localBlobEncryptionData = BlobEncryptionData.deserialize(paramMap);
        Utility.assertNotNull("encryptionData", localBlobEncryptionData);
        Utility.assertNotNull("contentEncryptionIV", localBlobEncryptionData.getContentEncryptionIV());
        Utility.assertNotNull("encryptedKey", localBlobEncryptionData.getWrappedContentKey().getEncryptedKey());
        if ("1.0".equals(localBlobEncryptionData.getEncryptionAgent().getProtocol()))
        {
          if ((keyWrapper == null) && (keyResolver == null))
          {
            paramOutputStream = new com/microsoft/azure/storage/StorageException;
            paramOutputStream.<init>("DecryptionError", "Key and Resolver are not initialized. Decryption requires either of them to be initialized.", null);
            throw paramOutputStream;
          }
          if (keyResolver != null)
          {
            paramMap = (IKey)keyResolver.resolveKeyAsync(localBlobEncryptionData.getWrappedContentKey().getKeyId()).get();
            Utility.assertNotNull("keyEncryptionKey", paramMap);
            paramMap = (byte[])paramMap.unwrapKeyAsync(localBlobEncryptionData.getWrappedContentKey().getEncryptedKey(), localBlobEncryptionData.getWrappedContentKey().getAlgorithm()).get();
          }
          else
          {
            if (!localBlobEncryptionData.getWrappedContentKey().getKeyId().equals(keyWrapper.getKid())) {
              break label350;
            }
            paramMap = (byte[])keyWrapper.unwrapKeyAsync(localBlobEncryptionData.getWrappedContentKey().getEncryptedKey(), localBlobEncryptionData.getWrappedContentKey().getAlgorithm()).get();
          }
          if (localBlobEncryptionData.getEncryptionAgent().getEncryptionAlgorithm().ordinal() == 0)
          {
            if (paramBoolean1) {
              paramBoolean = Cipher.getInstance("AES/CBC/NoPadding");
            } else {
              paramBoolean = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
            if (paramArrayOfByte == null) {
              paramArrayOfByte = localBlobEncryptionData.getContentEncryptionIV();
            }
            localIvParameterSpec.<init>(paramArrayOfByte);
            paramArrayOfByte = new javax/crypto/spec/SecretKeySpec;
            paramArrayOfByte.<init>(paramMap, 0, paramMap.length, "AES");
            paramBoolean.init(2, paramArrayOfByte, localIvParameterSpec);
            return new CipherOutputStream(paramOutputStream, paramBoolean);
          }
          paramOutputStream = new com/microsoft/azure/storage/StorageException;
          paramOutputStream.<init>("DecryptionError", "Invalid Encryption Algorithm found on the resource. This version of the client library does not support the specified encryption algorithm.", null);
          throw paramOutputStream;
          label350:
          paramOutputStream = new com/microsoft/azure/storage/StorageException;
          paramOutputStream.<init>("DecryptionError", "Key mismatch. The key id stored on the service does not match the specified key.", null);
          throw paramOutputStream;
        }
        paramOutputStream = new com/microsoft/azure/storage/StorageException;
        paramOutputStream.<init>("DecryptionError", "Invalid Encryption Agent. This version of the client library does not understand the Encryption Agent set on the blob.", null);
        throw paramOutputStream;
      }
      catch (Exception paramOutputStream)
      {
        throw new StorageException("DecryptionError", "Decryption logic threw error. Please check the inner exception for more details.", paramOutputStream);
      }
      catch (StorageException paramOutputStream)
      {
        throw paramOutputStream;
      }
    }
    return paramOutputStream;
  }
  
  public IKey getKey()
  {
    return keyWrapper;
  }
  
  public IKeyResolver getKeyResolver()
  {
    return keyResolver;
  }
  
  public void setKey(IKey paramIKey)
  {
    keyWrapper = paramIKey;
  }
  
  public void setKeyResolver(IKeyResolver paramIKeyResolver)
  {
    keyResolver = paramIKeyResolver;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobEncryptionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */