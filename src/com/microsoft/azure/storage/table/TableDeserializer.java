package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.EncryptionData;
import com.microsoft.azure.storage.core.JsonUtilities;
import com.microsoft.azure.storage.core.Utility;
import e.a.a.a.a;
import e.b.a.a.i;
import e.b.a.a.l;
import e.b.a.a.o.c;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class TableDeserializer
{
  public static EdmType evaluateEdmType(l paraml, String paramString)
  {
    if ((paraml != l.VALUE_FALSE) && (paraml != l.VALUE_TRUE))
    {
      if (paraml == l.VALUE_NUMBER_FLOAT) {
        paraml = EdmType.DOUBLE;
      } else if (paraml == l.VALUE_NUMBER_INT) {
        paraml = EdmType.INT32;
      } else {
        paraml = EdmType.STRING;
      }
    }
    else {
      paraml = EdmType.BOOLEAN;
    }
    return paraml;
  }
  
  public static String getETagFromTimestamp(String paramString)
  {
    return a.a("W/\"datetime'", URLEncoder.encode(paramString, "UTF-8"), "'\"");
  }
  
  public static boolean isEncrypted(HashSet<String> paramHashSet, String paramString)
  {
    boolean bool;
    if ((paramHashSet != null) && (paramHashSet.contains(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T extends TableEntity, R> TableResult parseJsonEntity(i parami, Class<T> paramClass, HashMap<String, PropertyPair> paramHashMap, EntityResolver<R> paramEntityResolver, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    TableResult localTableResult = new TableResult();
    HashMap localHashMap = new HashMap();
    if (!parami.e()) {
      parami.f();
    }
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    String str1;
    while (parami.c().startsWith("odata."))
    {
      str1 = parami.c().substring(6);
      parami.f();
      if (str1.equals("etag")) {
        localTableResult.setEtag(parami.d());
      }
      parami.f();
    }
    if ((paramEntityResolver == null) && (paramClass == null)) {
      return localTableResult;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = (c)parami;
      if (y == l.END_OBJECT) {
        break;
      }
      if ((paramTableRequestOptions.getTablePayloadFormat() != TablePayloadFormat.JsonNoMetadata) && (parami.c().endsWith("@odata.type")))
      {
        parami.f();
        localObject1 = EdmType.parse(parami.d());
        parami.g();
        str1 = parami.c();
        localObject2 = parami.d();
      }
      else
      {
        str1 = parami.c();
        parami.f();
        localObject2 = parami.d();
        localObject1 = evaluateEdmType(y, parami.d());
      }
      localObject1 = new EntityProperty((String)localObject2, (EdmType)localObject1);
      ((EntityProperty)localObject1).setDateBackwardCompatibility(paramTableRequestOptions.getDateBackwardCompatibility().booleanValue());
      localHashMap.put(str1, localObject1);
      parami.f();
    }
    parami = (EntityProperty)localHashMap.remove("PartitionKey");
    HashSet localHashSet = null;
    if (parami != null) {
      str1 = parami.getValueAsString();
    } else {
      str1 = null;
    }
    parami = (EntityProperty)localHashMap.remove("RowKey");
    if (parami != null) {
      localObject1 = parami.getValueAsString();
    } else {
      localObject1 = null;
    }
    parami = (EntityProperty)localHashMap.remove("Timestamp");
    if (parami != null)
    {
      parami.setDateBackwardCompatibility(false);
      localObject2 = parami.getValueAsDate();
      if (localTableResult.getEtag() == null) {
        localTableResult.setEtag(getETagFromTimestamp(parami.getValueAsString()));
      }
    }
    else
    {
      localObject2 = null;
    }
    EncryptionData localEncryptionData = new EncryptionData();
    parami = paramTableRequestOptions.getEncryptionPolicy();
    String str2 = "_ClientEncryptionMetadata1";
    if (parami != null)
    {
      parami = (EntityProperty)localHashMap.get("_ClientEncryptionMetadata2");
      localObject3 = (EntityProperty)localHashMap.get("_ClientEncryptionMetadata1");
      if ((parami != null) && (!parami.getIsNull()) && (localObject3 != null) && (!((EntityProperty)localObject3).getIsNull()))
      {
        localObject3 = paramTableRequestOptions.getEncryptionPolicy().decryptMetadataAndReturnCEK(str1, (String)localObject1, (EntityProperty)localObject3, parami, localEncryptionData);
        localKey = key;
        localObject3 = isJavaV1;
        localHashMap.put("_ClientEncryptionMetadata2", parami);
        localHashSet = parsePropertyDetails(parami);
        break label528;
      }
      if ((paramTableRequestOptions.requireEncryption() != null) && (paramTableRequestOptions.requireEncryption().booleanValue())) {
        throw new StorageException("DecryptionError", "Encryption data does not exist. If you do not want to decrypt the data, please do not set the require encryption flag on request options", null);
      }
    }
    Key localKey = null;
    Object localObject3 = Boolean.valueOf(true);
    label528:
    String str3 = "_ClientEncryptionMetadata2";
    if ((paramTableRequestOptions.getTablePayloadFormat() == TablePayloadFormat.JsonNoMetadata) && ((paramTableRequestOptions.getPropertyResolver() != null) || (paramClass != null)))
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      Object localObject4;
      label1034:
      for (parami = paramHashMap; localIterator.hasNext(); parami = (i)localObject4)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (str2.equals(localEntry.getKey()))
        {
          paramHashMap = new EntityProperty(((EntityProperty)localEntry.getValue()).getValueAsString(), EdmType.STRING);
          localHashMap.put(localEntry.getKey(), paramHashMap);
        }
        for (;;)
        {
          localObject4 = parami;
          break label1034;
          if (str3.equals(localEntry.getKey()))
          {
            if (paramTableRequestOptions.getEncryptionPolicy() == null)
            {
              paramHashMap = new EntityProperty(((EntityProperty)localEntry.getValue()).getValueAsString(), EdmType.BINARY);
              localHashMap.put(localEntry.getKey(), paramHashMap);
            }
          }
          else if (paramTableRequestOptions.getPropertyResolver() != null)
          {
            String str4 = (String)localEntry.getKey();
            String str5 = ((EntityProperty)localEntry.getValue()).getValueAsString();
            try
            {
              localObject4 = paramTableRequestOptions.getPropertyResolver().propertyResolver(str1, (String)localObject1, str4, str5);
              try
              {
                EntityProperty localEntityProperty = new com/microsoft/azure/storage/table/EntityProperty;
                if (isEncrypted(localHashSet, str4)) {
                  paramHashMap = EdmType.BINARY;
                } else {
                  paramHashMap = (HashMap<String, PropertyPair>)localObject4;
                }
                localEntityProperty.<init>(str5, paramHashMap);
                localEntityProperty.setDateBackwardCompatibility(paramTableRequestOptions.getDateBackwardCompatibility().booleanValue());
                localHashMap.put(localEntry.getKey(), localEntityProperty);
              }
              catch (IllegalArgumentException parami)
              {
                throw new StorageException("InvalidType", String.format("Failed to parse property '%s' with value '%s' as type '%s'", new Object[] { str4, str5, localObject4 }), 306, null, parami);
              }
              localObject4 = parami;
            }
            catch (Exception parami)
            {
              throw new StorageException("InternalError", "The custom property resolver delegate threw an exception. Check the inner exception for more details.", 306, null, parami);
            }
          }
        }
        if (paramClass != null)
        {
          paramHashMap = parami;
          if (parami == null) {
            paramHashMap = PropertyPair.generatePropertyPairs(paramClass);
          }
          parami = (PropertyPair)paramHashMap.get(localEntry.getKey());
          localObject4 = paramHashMap;
          if (parami != null)
          {
            if (isEncrypted(localHashSet, (String)localEntry.getKey())) {
              parami = new EntityProperty(((EntityProperty)localEntry.getValue()).getValueAsString(), EdmType.BINARY);
            } else {
              parami = new EntityProperty(((EntityProperty)localEntry.getValue()).getValueAsString(), type);
            }
            parami.setDateBackwardCompatibility(paramTableRequestOptions.getDateBackwardCompatibility().booleanValue());
            localHashMap.put(localEntry.getKey(), parami);
            localObject4 = paramHashMap;
          }
        }
      }
    }
    if ((paramTableRequestOptions.getEncryptionPolicy() != null) && (localKey != null)) {
      parami = paramTableRequestOptions.getEncryptionPolicy().decryptEntity(localHashMap, localHashSet, str1, (String)localObject1, localKey, localEncryptionData, (Boolean)localObject3);
    } else {
      parami = localHashMap;
    }
    localTableResult.setProperties(parami);
    if (paramEntityResolver != null)
    {
      localTableResult.setResult(paramEntityResolver.resolve(str1, (String)localObject1, (Date)localObject2, parami, localTableResult.getEtag()));
    }
    else if (paramClass != null)
    {
      paramClass = (TableEntity)paramClass.newInstance();
      paramClass.setEtag(localTableResult.getEtag());
      paramClass.setPartitionKey(str1);
      paramClass.setRowKey((String)localObject1);
      paramClass.setTimestamp((Date)localObject2);
      paramClass.readEntity(parami, paramOperationContext);
      localTableResult.setResult(paramClass);
    }
    return localTableResult;
  }
  
  public static HashSet<String> parsePropertyDetails(EntityProperty paramEntityProperty)
  {
    if ((paramEntityProperty != null) && (!paramEntityProperty.getIsNull()))
    {
      paramEntityProperty = paramEntityProperty.getValueAsByteArray();
      paramEntityProperty = new String(paramEntityProperty, 0, paramEntityProperty.length, "UTF-8").replaceAll(" ", "").replaceAll("\"", "");
      paramEntityProperty = new HashSet(Arrays.asList(paramEntityProperty.substring(1, paramEntityProperty.length() - 1).split(",")));
    }
    else
    {
      paramEntityProperty = null;
    }
    return paramEntityProperty;
  }
  
  public static <T extends TableEntity, R> ODataPayload<?> parseQueryResponse(InputStream paramInputStream, TableRequestOptions paramTableRequestOptions, Class<T> paramClass, EntityResolver<R> paramEntityResolver, OperationContext paramOperationContext)
  {
    i locali = Utility.getJsonParser(paramInputStream);
    TableResult localTableResult = null;
    if (paramEntityResolver != null) {}
    try
    {
      paramInputStream = new com/microsoft/azure/storage/table/ODataPayload;
      paramInputStream.<init>();
      InputStream localInputStream1 = null;
      InputStream localInputStream2 = paramInputStream;
      break label44;
      paramInputStream = new ODataPayload();
      localInputStream2 = null;
      localInputStream1 = paramInputStream;
      label44:
      if (!locali.e()) {
        locali.f();
      }
      JsonUtilities.assertIsStartObjectJsonToken(locali);
      locali.f();
      Object localObject = localTableResult;
      if (paramTableRequestOptions.getTablePayloadFormat() == TablePayloadFormat.JsonNoMetadata)
      {
        localObject = localTableResult;
        if (paramClass != null) {
          localObject = PropertyPair.generatePropertyPairs(paramClass);
        }
      }
      while (y != null)
      {
        if ((y == l.FIELD_NAME) && (locali.c().equals("value")))
        {
          locali.f();
          JsonUtilities.assertIsStartArrayJsonToken(locali);
          locali.f();
          while (y == l.START_OBJECT)
          {
            localTableResult = parseJsonEntity(locali, paramClass, (HashMap)localObject, paramEntityResolver, paramTableRequestOptions, paramOperationContext);
            if (localInputStream1 != null) {
              tableResults.add(localTableResult);
            }
            if (paramEntityResolver != null) {
              results.add(localTableResult.getResult());
            } else {
              results.add((TableEntity)localTableResult.getResult());
            }
            locali.f();
          }
          JsonUtilities.assertIsEndArrayJsonToken(locali);
        }
        locali.f();
      }
      return paramInputStream;
    }
    finally
    {
      locali.close();
    }
  }
  
  public static <T extends TableEntity, R> TableResult parseSingleOpResponse(InputStream paramInputStream, TableRequestOptions paramTableRequestOptions, int paramInt, Class<T> paramClass, EntityResolver<R> paramEntityResolver, OperationContext paramOperationContext)
  {
    paramInputStream = Utility.getJsonParser(paramInputStream);
    try
    {
      paramTableRequestOptions = parseJsonEntity(paramInputStream, paramClass, null, paramEntityResolver, paramTableRequestOptions, paramOperationContext);
      paramTableRequestOptions.setHttpStatusCode(paramInt);
      return paramTableRequestOptions;
    }
    finally
    {
      paramInputStream.close();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */