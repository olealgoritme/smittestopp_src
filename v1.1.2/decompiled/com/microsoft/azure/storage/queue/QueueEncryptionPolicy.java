package com.microsoft.azure.storage.queue;

import com.microsoft.azure.keyvault.core.IKey;
import com.microsoft.azure.keyvault.core.IKeyResolver;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.EncryptionAgent;
import com.microsoft.azure.storage.core.EncryptionAlgorithm;
import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedContentKey;
import java.security.Key;
import java.util.HashMap;
import java.util.concurrent.Future;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l.a.a.b.e.b;

public final class QueueEncryptionPolicy
{
  public IKeyResolver keyResolver;
  public IKey keyWrapper;
  
  public QueueEncryptionPolicy(IKey paramIKey, IKeyResolver paramIKeyResolver)
  {
    keyWrapper = paramIKey;
    keyResolver = paramIKeyResolver;
  }
  
  public byte[] decryptMessage(String paramString, Boolean paramBoolean)
  {
    Utility.assertNotNull("inputMessage", paramString);
    try
    {
      CloudQueueEncryptedMessage localCloudQueueEncryptedMessage = CloudQueueEncryptedMessage.deserialize(paramString);
      if ((paramBoolean != null) && (paramBoolean.booleanValue()) && (localCloudQueueEncryptedMessage.getEncryptionData() == null))
      {
        paramString = new com/microsoft/azure/storage/StorageException;
        paramString.<init>("DecryptionError", "Encryption data does not exist. If you do not want to decrypt the data, please do not set the require encryption flag on request options", null);
        throw paramString;
      }
      if (localCloudQueueEncryptedMessage.getEncryptionData() != null)
      {
        paramBoolean = localCloudQueueEncryptedMessage.getEncryptionData();
        Utility.assertNotNull("contentEncryptionIV", paramBoolean.getContentEncryptionIV());
        Utility.assertNotNull("encryptedKey", paramBoolean.getWrappedContentKey().getEncryptedKey());
        if ("1.0".equals(paramBoolean.getEncryptionAgent().getProtocol()))
        {
          if ((keyWrapper == null) && (keyResolver == null))
          {
            paramString = new com/microsoft/azure/storage/StorageException;
            paramString.<init>("DecryptionError", "Key and Resolver are not initialized. Decryption requires either of them to be initialized.", null);
            throw paramString;
          }
          if (keyResolver != null)
          {
            paramString = (IKey)keyResolver.resolveKeyAsync(paramBoolean.getWrappedContentKey().getKeyId()).get();
            Utility.assertNotNull("keyEncryptionKey", paramString);
            paramString = (byte[])paramString.unwrapKeyAsync(paramBoolean.getWrappedContentKey().getEncryptedKey(), paramBoolean.getWrappedContentKey().getAlgorithm()).get();
          }
          else
          {
            if (!paramBoolean.getWrappedContentKey().getKeyId().equals(keyWrapper.getKid())) {
              break label341;
            }
            paramString = (byte[])keyWrapper.unwrapKeyAsync(paramBoolean.getWrappedContentKey().getEncryptedKey(), paramBoolean.getWrappedContentKey().getAlgorithm()).get();
          }
          if (paramBoolean.getEncryptionAgent().getEncryptionAlgorithm().ordinal() == 0)
          {
            Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
            localIvParameterSpec.<init>(paramBoolean.getContentEncryptionIV());
            paramBoolean = new javax/crypto/spec/SecretKeySpec;
            paramBoolean.<init>(paramString, 0, paramString.length, "AES");
            localCipher.init(2, paramBoolean, localIvParameterSpec);
            paramString = Base64.decode(localCloudQueueEncryptedMessage.getEncryptedMessageContents());
            return localCipher.doFinal(paramString, 0, paramString.length);
          }
          paramString = new com/microsoft/azure/storage/StorageException;
          paramString.<init>("DecryptionError", "Invalid Encryption Algorithm found on the resource. This version of the client library does not support the specified encryption algorithm.", null);
          throw paramString;
          label341:
          paramString = new com/microsoft/azure/storage/StorageException;
          paramString.<init>("DecryptionError", "Key mismatch. The key id stored on the service does not match the specified key.", null);
          throw paramString;
        }
        paramString = new com/microsoft/azure/storage/StorageException;
        paramString.<init>("DecryptionError", "Invalid Encryption Agent. This version of the client library does not understand the Encryption Agent set on the blob.", null);
        throw paramString;
      }
      paramString = Base64.decode(localCloudQueueEncryptedMessage.getEncryptedMessageContents());
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new StorageException("DecryptionError", "Decryption logic threw error. Please check the inner exception for more details.", paramString);
    }
    catch (StorageException paramString)
    {
      throw paramString;
    }
  }
  
  public String encryptMessage(byte[] paramArrayOfByte)
  {
    Utility.assertNotNull("inputMessage", paramArrayOfByte);
    if (keyWrapper != null)
    {
      CloudQueueEncryptedMessage localCloudQueueEncryptedMessage = new CloudQueueEncryptedMessage();
      EncryptionData localEncryptionData = new EncryptionData();
      if (localEncryptionData.getKeyWrappingMetadata() == null) {
        localEncryptionData.setKeyWrappingMetadata(new HashMap());
      }
      localEncryptionData.getKeyWrappingMetadata().put("EncryptionLibrary", "Java 8.1.0");
      localEncryptionData.setEncryptionAgent(new EncryptionAgent("1.0", EncryptionAlgorithm.AES_CBC_256));
      try
      {
        Object localObject = KeyGenerator.getInstance("AES");
        ((KeyGenerator)localObject).init(256);
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localObject = ((KeyGenerator)localObject).generateKey();
        localCipher.init(1, (Key)localObject);
        b localb = (b)keyWrapper.wrapKeyAsync(((SecretKey)localObject).getEncoded(), null).get();
        localObject = new com/microsoft/azure/storage/core/WrappedContentKey;
        ((WrappedContentKey)localObject).<init>(keyWrapper.getKid(), (byte[])localb.getKey(), (String)localb.getValue());
        localEncryptionData.setWrappedContentKey((WrappedContentKey)localObject);
        localObject = new java/lang/String;
        ((String)localObject).<init>(Base64.encode(localCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length)));
        localCloudQueueEncryptedMessage.setEncryptedMessageContents((String)localObject);
        localEncryptionData.setContentEncryptionIV(localCipher.getIV());
        localCloudQueueEncryptedMessage.setEncryptionData(localEncryptionData);
        paramArrayOfByte = localCloudQueueEncryptedMessage.serialize();
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        throw StorageException.translateClientException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("Key is not initialized. Encryption requires it to be initialized.");
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
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueEncryptionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */