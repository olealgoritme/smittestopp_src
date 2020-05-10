package com.microsoft.azure.storage.table;

import com.microsoft.azure.keyvault.core.IKey;
import com.microsoft.azure.keyvault.core.IKeyResolver;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.EncryptionAgent;
import com.microsoft.azure.storage.core.EncryptionAlgorithm;
import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedContentKey;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l.a.a.b.e.b;

public class TableEncryptionPolicy
{
  public IKeyResolver keyResolver;
  public IKey keyWrapper;
  
  public TableEncryptionPolicy(IKey paramIKey, IKeyResolver paramIKeyResolver)
  {
    keyWrapper = paramIKey;
    keyResolver = paramIKeyResolver;
  }
  
  public HashMap<String, EntityProperty> decryptEntity(HashMap<String, EntityProperty> paramHashMap, HashSet<String> paramHashSet, String paramString1, String paramString2, Key paramKey, EncryptionData paramEncryptionData, Boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if (paramEncryptionData.getEncryptionAgent().getEncryptionAlgorithm().ordinal() == 0)
      {
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          if ((((Map.Entry)localObject1).getKey() != "_ClientEncryptionMetadata1") && (((Map.Entry)localObject1).getKey() != "_ClientEncryptionMetadata2")) {
            if (paramHashSet.contains(((Map.Entry)localObject1).getKey()))
            {
              Object localObject2 = MessageDigest.getInstance("SHA-256");
              if (paramBoolean.booleanValue())
              {
                paramHashMap = new java/lang/StringBuilder;
                paramHashMap.<init>();
                paramHashMap.append(paramString1);
                paramHashMap.append(paramString2);
                paramHashMap.append((String)((Map.Entry)localObject1).getKey());
              }
              for (;;)
              {
                paramHashMap = paramHashMap.toString();
                break;
                paramHashMap = new java/lang/StringBuilder;
                paramHashMap.<init>();
                paramHashMap.append(paramString2);
                paramHashMap.append(paramString1);
                paramHashMap.append((String)((Map.Entry)localObject1).getKey());
              }
              localObject2 = ((MessageDigest)localObject2).digest(Utility.binaryAppend(paramEncryptionData.getContentEncryptionIV(), paramHashMap.getBytes("UTF-8")));
              paramHashMap = new byte[16];
              System.arraycopy(localObject2, 0, paramHashMap, 0, 16);
              localObject2 = new javax/crypto/spec/IvParameterSpec;
              ((IvParameterSpec)localObject2).<init>(paramHashMap);
              localCipher.init(2, paramKey, (AlgorithmParameterSpec)localObject2);
              paramHashMap = ((EntityProperty)((Map.Entry)localObject1).getValue()).getValueAsByteArray();
              localObject2 = localCipher.doFinal(paramHashMap, 0, paramHashMap.length);
              paramHashMap = new java/lang/String;
              paramHashMap.<init>((byte[])localObject2, "UTF-8");
              localObject1 = ((Map.Entry)localObject1).getKey();
              localObject2 = new com/microsoft/azure/storage/table/EntityProperty;
              ((EntityProperty)localObject2).<init>(paramHashMap);
              localHashMap.put(localObject1, localObject2);
            }
            else
            {
              localHashMap.put(((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
            }
          }
        }
        return localHashMap;
      }
      paramHashMap = new com/microsoft/azure/storage/StorageException;
      paramHashMap.<init>("DecryptionError", "Invalid Encryption Algorithm found on the resource. This version of the client library does not support the specified encryption algorithm.", null);
      throw paramHashMap;
    }
    catch (Exception paramHashMap)
    {
      throw new StorageException("DecryptionError", "Decryption logic threw error. Please check the inner exception for more details.", paramHashMap);
    }
    catch (StorageException paramHashMap)
    {
      throw paramHashMap;
    }
  }
  
  public CEKReturn decryptMetadataAndReturnCEK(String paramString1, String paramString2, EntityProperty paramEntityProperty1, EntityProperty paramEntityProperty2, EncryptionData paramEncryptionData)
  {
    if ((keyWrapper == null) && (keyResolver == null)) {
      throw new StorageException("DecryptionError", "Key and Resolver are not initialized. Decryption requires either of them to be initialized.", null);
    }
    try
    {
      paramEncryptionData.copyValues(EncryptionData.deserialize(paramEntityProperty1.getValueAsString()));
      Utility.assertNotNull("contentEncryptionIV", paramEncryptionData.getContentEncryptionIV());
      Utility.assertNotNull("encryptedKey", paramEncryptionData.getWrappedContentKey().getEncryptedKey());
      if ("1.0".equals(paramEncryptionData.getEncryptionAgent().getProtocol()))
      {
        if ((paramEncryptionData.getEncryptionAgent().getProtocol().equals("1.0")) && ((paramEncryptionData.getKeyWrappingMetadata() == null) || ((paramEncryptionData.getKeyWrappingMetadata().containsKey("EncryptionLibrary")) && (((String)paramEncryptionData.getKeyWrappingMetadata().get("EncryptionLibrary")).contains("Java"))))) {
          bool = true;
        } else {
          bool = false;
        }
        Boolean localBoolean = Boolean.valueOf(bool);
        if (keyResolver != null)
        {
          paramEntityProperty1 = (IKey)keyResolver.resolveKeyAsync(paramEncryptionData.getWrappedContentKey().getKeyId()).get();
          Utility.assertNotNull("keyEncryptionKey", paramEntityProperty1);
          paramEntityProperty1 = (byte[])paramEntityProperty1.unwrapKeyAsync(paramEncryptionData.getWrappedContentKey().getEncryptedKey(), paramEncryptionData.getWrappedContentKey().getAlgorithm()).get();
        }
        else
        {
          if (!paramEncryptionData.getWrappedContentKey().getKeyId().equals(keyWrapper.getKid())) {
            break label500;
          }
          paramEntityProperty1 = (byte[])keyWrapper.unwrapKeyAsync(paramEncryptionData.getWrappedContentKey().getEncryptedKey(), paramEncryptionData.getWrappedContentKey().getAlgorithm()).get();
        }
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        boolean bool = localBoolean.booleanValue();
        StringBuilder localStringBuilder;
        if (bool)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(paramString2);
          localStringBuilder.append("_ClientEncryptionMetadata2");
        }
        for (paramString1 = localStringBuilder;; paramString1 = localStringBuilder)
        {
          paramString1 = paramString1.toString();
          break;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append(paramString2);
          localStringBuilder.append(paramString1);
          localStringBuilder.append("_ClientEncryptionMetadata2");
        }
        paramString2 = localMessageDigest.digest(Utility.binaryAppend(paramEncryptionData.getContentEncryptionIV(), paramString1.getBytes("UTF-8")));
        paramString1 = new byte[16];
        System.arraycopy(paramString2, 0, paramString1, 0, 16);
        paramString2 = new javax/crypto/spec/IvParameterSpec;
        paramString2.<init>(paramString1);
        paramString1 = new javax/crypto/spec/SecretKeySpec;
        paramString1.<init>(paramEntityProperty1, 0, paramEntityProperty1.length, "AES");
        localCipher.init(2, paramString1, paramString2);
        paramString2 = paramEntityProperty2.getValueAsByteArray();
        paramEntityProperty2.setValue(localCipher.doFinal(paramString2, 0, paramString2.length));
        paramString2 = new com/microsoft/azure/storage/table/CEKReturn;
        paramString2.<init>();
        key = paramString1;
        isJavaV1 = localBoolean;
        return paramString2;
        label500:
        paramString1 = new com/microsoft/azure/storage/StorageException;
        paramString1.<init>("DecryptionError", "Key mismatch. The key id stored on the service does not match the specified key.", null);
        throw paramString1;
      }
      paramString1 = new com/microsoft/azure/storage/StorageException;
      paramString1.<init>("DecryptionError", "Invalid Encryption Agent. This version of the client library does not understand the Encryption Agent set on the blob.", null);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      throw new StorageException("DecryptionError", "Decryption logic threw error. Please check the inner exception for more details.", paramString1);
    }
    catch (StorageException paramString1)
    {
      throw paramString1;
    }
  }
  
  public Map<String, EntityProperty> encryptEntity(Map<String, EntityProperty> paramMap, String paramString1, String paramString2, TableRequestOptions.EncryptionResolver paramEncryptionResolver)
  {
    Utility.assertNotNull("properties", paramMap);
    if (keyWrapper != null)
    {
      EncryptionData localEncryptionData = new EncryptionData();
      if (localEncryptionData.getKeyWrappingMetadata() == null) {
        localEncryptionData.setKeyWrappingMetadata(new HashMap());
      }
      localEncryptionData.getKeyWrappingMetadata().put("EncryptionLibrary", "Java 8.1.0");
      localEncryptionData.setEncryptionAgent(new EncryptionAgent("1.0", EncryptionAlgorithm.AES_CBC_256));
      try
      {
        HashMap localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        HashSet localHashSet = new java/util/HashSet;
        localHashSet.<init>();
        Object localObject1 = KeyGenerator.getInstance("AES");
        ((KeyGenerator)localObject1).init(256);
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey localSecretKey = ((KeyGenerator)localObject1).generateKey();
        localCipher.init(1, localSecretKey);
        Object localObject2 = (b)keyWrapper.wrapKeyAsync(localSecretKey.getEncoded(), null).get();
        localObject1 = new com/microsoft/azure/storage/core/WrappedContentKey;
        ((WrappedContentKey)localObject1).<init>(keyWrapper.getKid(), (byte[])((b)localObject2).getKey(), (String)((b)localObject2).getValue());
        localEncryptionData.setWrappedContentKey((WrappedContentKey)localObject1);
        localEncryptionData.setContentEncryptionIV(localCipher.getIV());
        localObject2 = MessageDigest.getInstance("SHA-256");
        paramMap = paramMap.entrySet().iterator();
        for (;;)
        {
          localObject1 = paramEncryptionResolver;
          if (!paramMap.hasNext()) {
            break;
          }
          Object localObject3 = (Map.Entry)paramMap.next();
          if ((localObject1 != null) && (((TableRequestOptions.EncryptionResolver)localObject1).encryptionResolver(paramString1, paramString2, (String)((Map.Entry)localObject3).getKey()))) {
            if (((Map.Entry)localObject3).getValue() != null)
            {
              ((EntityProperty)((Map.Entry)localObject3).getValue()).setIsEncrypted(true);
            }
            else
            {
              paramMap = new java/lang/IllegalArgumentException;
              paramMap.<init>("Null properties cannot be encrypted. Please assign a default value to the property if you wish to encrypt it.");
              throw paramMap;
            }
          }
          localObject1 = ((Map.Entry)localObject3).getValue();
          if ((localObject1 != null) && (((EntityProperty)((Map.Entry)localObject3).getValue()).isEncrypted()))
          {
            if (((EntityProperty)((Map.Entry)localObject3).getValue()).getEdmType() == EdmType.STRING)
            {
              localObject1 = localEncryptionData.getContentEncryptionIV();
              Object localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append(paramString1);
              ((StringBuilder)localObject4).append(paramString2);
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
              localObject4 = ((MessageDigest)localObject2).digest(Utility.binaryAppend((byte[])localObject1, ((StringBuilder)localObject4).toString().getBytes("UTF-8")));
              localObject1 = new byte[16];
              System.arraycopy(localObject4, 0, localObject1, 0, 16);
              localObject4 = new javax/crypto/spec/IvParameterSpec;
              ((IvParameterSpec)localObject4).<init>((byte[])localObject1);
              localCipher.init(1, localSecretKey, (AlgorithmParameterSpec)localObject4);
              if (((Map.Entry)localObject3).getValue() != null)
              {
                localObject1 = ((EntityProperty)((Map.Entry)localObject3).getValue()).getValueAsString().getBytes("UTF-8");
                localObject1 = localCipher.doFinal((byte[])localObject1, 0, localObject1.length);
                localObject4 = ((Map.Entry)localObject3).getKey();
                EntityProperty localEntityProperty = new com/microsoft/azure/storage/table/EntityProperty;
                localEntityProperty.<init>((byte[])localObject1);
                localHashMap.put(localObject4, localEntityProperty);
                localHashSet.add(((Map.Entry)localObject3).getKey());
              }
              else
              {
                paramMap = new java/lang/IllegalArgumentException;
                paramMap.<init>("Null properties cannot be encrypted. Please assign a default value to the property if you wish to encrypt it.");
                throw paramMap;
              }
            }
            else
            {
              paramMap = new java/lang/IllegalArgumentException;
              paramMap.<init>(String.format("Unsupported type : %s encountered during encryption. Only string properties can be encrypted on the client side.", new Object[] { ((EntityProperty)((Map.Entry)localObject3).getValue()).getEdmType() }));
              throw paramMap;
            }
          }
          else {
            localHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          }
          localObject1 = localEncryptionData.getContentEncryptionIV();
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append(paramString1);
          ((StringBuilder)localObject3).append(paramString2);
          ((StringBuilder)localObject3).append("_ClientEncryptionMetadata2");
          localObject3 = ((MessageDigest)localObject2).digest(Utility.binaryAppend((byte[])localObject1, ((StringBuilder)localObject3).toString().getBytes("UTF-8")));
          localObject1 = new byte[16];
          System.arraycopy(localObject3, 0, localObject1, 0, 16);
          localObject3 = new javax/crypto/spec/IvParameterSpec;
          ((IvParameterSpec)localObject3).<init>((byte[])localObject1);
          localCipher.init(1, localSecretKey, (AlgorithmParameterSpec)localObject3);
          localObject1 = Arrays.toString(localHashSet.toArray()).getBytes("UTF-8");
          localObject1 = localCipher.doFinal((byte[])localObject1, 0, localObject1.length);
          localObject3 = new com/microsoft/azure/storage/table/EntityProperty;
          ((EntityProperty)localObject3).<init>((byte[])localObject1);
          localHashMap.put("_ClientEncryptionMetadata2", localObject3);
        }
        paramMap = new com/microsoft/azure/storage/table/EntityProperty;
        paramMap.<init>(localEncryptionData.serialize());
        localHashMap.put("_ClientEncryptionMetadata1", paramMap);
        return localHashMap;
      }
      catch (Exception paramMap)
      {
        throw StorageException.translateClientException(paramMap);
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
 * Qualified Name:     com.microsoft.azure.storage.table.TableEncryptionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */