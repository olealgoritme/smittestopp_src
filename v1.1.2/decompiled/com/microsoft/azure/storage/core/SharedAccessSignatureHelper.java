package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessAccountPolicy;
import com.microsoft.azure.storage.SharedAccessHeaders;
import com.microsoft.azure.storage.SharedAccessPolicy;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsSharedAccessSignature;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.queue.SharedAccessQueuePolicy;
import com.microsoft.azure.storage.table.SharedAccessTablePolicy;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SharedAccessSignatureHelper
{
  public static void addIfNotNullOrEmpty(UriQueryBuilder paramUriQueryBuilder, String paramString1, String paramString2)
  {
    if (!Utility.isNullOrEmpty(paramString2)) {
      paramUriQueryBuilder.add(paramString1, paramString2);
    }
  }
  
  public static UriQueryBuilder generateSharedAccessSignatureForAccount(SharedAccessAccountPolicy paramSharedAccessAccountPolicy, String paramString)
  {
    Utility.assertNotNull("policy", paramSharedAccessAccountPolicy);
    Utility.assertNotNull("signature", paramString);
    String str1 = paramSharedAccessAccountPolicy.permissionsToString();
    Date localDate1 = paramSharedAccessAccountPolicy.getSharedAccessStartTime();
    Date localDate2 = paramSharedAccessAccountPolicy.getSharedAccessExpiryTime();
    IPRange localIPRange = paramSharedAccessAccountPolicy.getRange();
    SharedAccessProtocols localSharedAccessProtocols = paramSharedAccessAccountPolicy.getProtocols();
    String str2 = paramSharedAccessAccountPolicy.servicesToString();
    paramSharedAccessAccountPolicy = paramSharedAccessAccountPolicy.resourceTypesToString();
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("sv", "2018-03-28");
    addIfNotNullOrEmpty(localUriQueryBuilder, "ss", str2);
    addIfNotNullOrEmpty(localUriQueryBuilder, "srt", paramSharedAccessAccountPolicy);
    addIfNotNullOrEmpty(localUriQueryBuilder, "sp", str1);
    addIfNotNullOrEmpty(localUriQueryBuilder, "st", Utility.getUTCTimeOrEmpty(localDate1));
    addIfNotNullOrEmpty(localUriQueryBuilder, "se", Utility.getUTCTimeOrEmpty(localDate2));
    addIfNotNullOrEmpty(localUriQueryBuilder, "sr", paramSharedAccessAccountPolicy);
    str2 = null;
    if (localIPRange != null) {
      paramSharedAccessAccountPolicy = localIPRange.toString();
    } else {
      paramSharedAccessAccountPolicy = null;
    }
    addIfNotNullOrEmpty(localUriQueryBuilder, "sip", paramSharedAccessAccountPolicy);
    paramSharedAccessAccountPolicy = str2;
    if (localSharedAccessProtocols != null) {
      paramSharedAccessAccountPolicy = localSharedAccessProtocols.toString();
    }
    addIfNotNullOrEmpty(localUriQueryBuilder, "spr", paramSharedAccessAccountPolicy);
    addIfNotNullOrEmpty(localUriQueryBuilder, "sig", paramString);
    return localUriQueryBuilder;
  }
  
  public static UriQueryBuilder generateSharedAccessSignatureForBlobAndFile(SharedAccessPolicy paramSharedAccessPolicy, SharedAccessHeaders paramSharedAccessHeaders, String paramString1, String paramString2, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString3)
  {
    Utility.assertNotNullOrEmpty("resourceType", paramString2);
    return generateSharedAccessSignatureHelper(paramSharedAccessPolicy, null, null, null, null, paramString1, paramString2, paramIPRange, paramSharedAccessProtocols, null, paramString3, paramSharedAccessHeaders);
  }
  
  public static UriQueryBuilder generateSharedAccessSignatureForQueue(SharedAccessQueuePolicy paramSharedAccessQueuePolicy, String paramString1, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString2)
  {
    return generateSharedAccessSignatureHelper(paramSharedAccessQueuePolicy, null, null, null, null, paramString1, null, paramIPRange, paramSharedAccessProtocols, null, paramString2, null);
  }
  
  public static UriQueryBuilder generateSharedAccessSignatureForTable(SharedAccessTablePolicy paramSharedAccessTablePolicy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString6, String paramString7)
  {
    Utility.assertNotNull("tableName", paramString6);
    return generateSharedAccessSignatureHelper(paramSharedAccessTablePolicy, paramString1, paramString2, paramString3, paramString4, paramString5, null, paramIPRange, paramSharedAccessProtocols, paramString6, paramString7, null);
  }
  
  public static String generateSharedAccessSignatureHashForAccount(String paramString, SharedAccessAccountPolicy paramSharedAccessAccountPolicy, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNullOrEmpty("resource", paramString);
    Utility.assertNotNull("credentials", paramStorageCredentials);
    Object localObject1 = null;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    String str1;
    if (paramSharedAccessAccountPolicy != null)
    {
      localObject1 = paramSharedAccessAccountPolicy.permissionsToString();
      localObject2 = paramSharedAccessAccountPolicy.getSharedAccessStartTime();
      localObject3 = paramSharedAccessAccountPolicy.getSharedAccessExpiryTime();
      localObject4 = paramSharedAccessAccountPolicy.getRange();
      localObject5 = paramSharedAccessAccountPolicy.getProtocols();
      localObject6 = paramSharedAccessAccountPolicy.servicesToString();
      str1 = paramSharedAccessAccountPolicy.resourceTypesToString();
      paramSharedAccessAccountPolicy = (SharedAccessAccountPolicy)localObject1;
    }
    else
    {
      str1 = null;
      paramSharedAccessAccountPolicy = str1;
      localObject3 = paramSharedAccessAccountPolicy;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject6 = localObject5;
      localObject2 = paramSharedAccessAccountPolicy;
      paramSharedAccessAccountPolicy = (SharedAccessAccountPolicy)localObject1;
    }
    String str2 = "";
    localObject1 = paramSharedAccessAccountPolicy;
    if (paramSharedAccessAccountPolicy == null) {
      localObject1 = "";
    }
    Object localObject2 = Utility.getUTCTimeOrEmpty((Date)localObject2);
    String str3 = Utility.getUTCTimeOrEmpty((Date)localObject3);
    if (localObject4 == null) {
      paramSharedAccessAccountPolicy = "";
    } else {
      paramSharedAccessAccountPolicy = ((IPRange)localObject4).toString();
    }
    if (localObject5 == null) {
      localObject3 = str2;
    } else {
      localObject3 = ((SharedAccessProtocols)localObject5).toString();
    }
    return generateSharedAccessSignatureHashHelper(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", new Object[] { paramString, localObject1, localObject6, str1, localObject2, str3, paramSharedAccessAccountPolicy, localObject3, "2018-03-28" }), paramStorageCredentials);
  }
  
  public static String generateSharedAccessSignatureHashForBlobAndFile(SharedAccessPolicy paramSharedAccessPolicy, SharedAccessHeaders paramSharedAccessHeaders, String paramString1, String paramString2, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, ServiceClient paramServiceClient)
  {
    String str = generateSharedAccessSignatureStringToSign(paramSharedAccessPolicy, paramString2, paramIPRange, paramSharedAccessProtocols, paramString1);
    paramIPRange = null;
    if (paramSharedAccessHeaders != null)
    {
      paramIPRange = paramSharedAccessHeaders.getCacheControl();
      paramString2 = paramSharedAccessHeaders.getContentDisposition();
      paramString1 = paramSharedAccessHeaders.getContentEncoding();
      paramSharedAccessProtocols = paramSharedAccessHeaders.getContentLanguage();
      paramSharedAccessPolicy = paramSharedAccessHeaders.getContentType();
      paramSharedAccessHeaders = paramSharedAccessProtocols;
    }
    else
    {
      paramSharedAccessPolicy = null;
      paramString2 = paramSharedAccessPolicy;
      paramString1 = paramString2;
      paramSharedAccessHeaders = paramString1;
    }
    paramSharedAccessProtocols = paramIPRange;
    if (paramIPRange == null) {
      paramSharedAccessProtocols = "";
    }
    paramIPRange = paramString2;
    if (paramString2 == null) {
      paramIPRange = "";
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    paramString1 = paramSharedAccessHeaders;
    if (paramSharedAccessHeaders == null) {
      paramString1 = "";
    }
    paramSharedAccessHeaders = paramSharedAccessPolicy;
    if (paramSharedAccessPolicy == null) {
      paramSharedAccessHeaders = "";
    }
    return generateSharedAccessSignatureHashHelper(String.format("%s\n%s\n%s\n%s\n%s\n%s", new Object[] { str, paramSharedAccessProtocols, paramIPRange, paramString2, paramString1, paramSharedAccessHeaders }), paramServiceClient.getCredentials());
  }
  
  public static String generateSharedAccessSignatureHashForQueue(SharedAccessQueuePolicy paramSharedAccessQueuePolicy, String paramString1, String paramString2, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, ServiceClient paramServiceClient)
  {
    return generateSharedAccessSignatureHashHelper(generateSharedAccessSignatureStringToSign(paramSharedAccessQueuePolicy, paramString2, paramIPRange, paramSharedAccessProtocols, paramString1), paramServiceClient.getCredentials());
  }
  
  public static String generateSharedAccessSignatureHashForTable(SharedAccessTablePolicy paramSharedAccessTablePolicy, String paramString1, String paramString2, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString3, String paramString4, String paramString5, String paramString6, ServiceClient paramServiceClient)
  {
    paramSharedAccessProtocols = generateSharedAccessSignatureStringToSign(paramSharedAccessTablePolicy, paramString2, paramIPRange, paramSharedAccessProtocols, paramString1);
    paramSharedAccessTablePolicy = paramString3;
    if (paramString3 == null) {
      paramSharedAccessTablePolicy = "";
    }
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString2 = paramString5;
    if (paramString5 == null) {
      paramString2 = "";
    }
    paramIPRange = paramString6;
    if (paramString6 == null) {
      paramIPRange = "";
    }
    return generateSharedAccessSignatureHashHelper(String.format("%s\n%s\n%s\n%s\n%s", new Object[] { paramSharedAccessProtocols, paramSharedAccessTablePolicy, paramString1, paramString2, paramIPRange }), paramServiceClient.getCredentials());
  }
  
  public static String generateSharedAccessSignatureHashHelper(String paramString, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("credentials", paramStorageCredentials);
    Logger.trace(null, "Signing %s", paramString);
    return StorageCredentialsHelper.computeHmac256(paramStorageCredentials, Utility.safeDecode(paramString));
  }
  
  public static UriQueryBuilder generateSharedAccessSignatureHelper(SharedAccessPolicy paramSharedAccessPolicy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString7, String paramString8, SharedAccessHeaders paramSharedAccessHeaders)
  {
    Utility.assertNotNull("signature", paramString8);
    Object localObject1 = null;
    Object localObject3;
    Object localObject4;
    if (paramSharedAccessPolicy != null)
    {
      localObject2 = paramSharedAccessPolicy.permissionsToString();
      localObject3 = paramSharedAccessPolicy.getSharedAccessStartTime();
      localObject4 = paramSharedAccessPolicy.getSharedAccessExpiryTime();
      paramSharedAccessPolicy = (SharedAccessPolicy)localObject2;
    }
    else
    {
      localObject2 = null;
      paramSharedAccessPolicy = (SharedAccessPolicy)localObject2;
      localObject4 = paramSharedAccessPolicy;
      localObject3 = paramSharedAccessPolicy;
      paramSharedAccessPolicy = (SharedAccessPolicy)localObject2;
    }
    Object localObject2 = new UriQueryBuilder();
    ((UriQueryBuilder)localObject2).add("sv", "2018-03-28");
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "sp", paramSharedAccessPolicy);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "st", Utility.getUTCTimeOrEmpty((Date)localObject3));
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "se", Utility.getUTCTimeOrEmpty((Date)localObject4));
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "spk", paramString1);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "srk", paramString2);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "epk", paramString3);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "erk", paramString4);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "si", paramString5);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "sr", paramString6);
    if (paramIPRange != null) {
      paramSharedAccessPolicy = paramIPRange.toString();
    } else {
      paramSharedAccessPolicy = null;
    }
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "sip", paramSharedAccessPolicy);
    paramSharedAccessPolicy = (SharedAccessPolicy)localObject1;
    if (paramSharedAccessProtocols != null) {
      paramSharedAccessPolicy = paramSharedAccessProtocols.toString();
    }
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "spr", paramSharedAccessPolicy);
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "tn", paramString7);
    if (paramSharedAccessHeaders != null)
    {
      addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "rscc", paramSharedAccessHeaders.getCacheControl());
      addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "rsct", paramSharedAccessHeaders.getContentType());
      addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "rsce", paramSharedAccessHeaders.getContentEncoding());
      addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "rscl", paramSharedAccessHeaders.getContentLanguage());
      addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "rscd", paramSharedAccessHeaders.getContentDisposition());
    }
    addIfNotNullOrEmpty((UriQueryBuilder)localObject2, "sig", paramString8);
    return (UriQueryBuilder)localObject2;
  }
  
  public static String generateSharedAccessSignatureStringToSign(SharedAccessPolicy paramSharedAccessPolicy, String paramString1, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols, String paramString2)
  {
    Utility.assertNotNullOrEmpty("resource", paramString1);
    Object localObject1 = null;
    if (paramSharedAccessPolicy != null)
    {
      localObject1 = paramSharedAccessPolicy.permissionsToString();
      localObject2 = paramSharedAccessPolicy.getSharedAccessStartTime();
      localObject3 = paramSharedAccessPolicy.getSharedAccessExpiryTime();
      paramSharedAccessPolicy = (SharedAccessPolicy)localObject1;
    }
    else
    {
      localObject3 = null;
      localObject2 = localObject3;
      paramSharedAccessPolicy = (SharedAccessPolicy)localObject1;
    }
    String str = "";
    localObject1 = paramSharedAccessPolicy;
    if (paramSharedAccessPolicy == null) {
      localObject1 = "";
    }
    Object localObject2 = Utility.getUTCTimeOrEmpty((Date)localObject2);
    Object localObject3 = Utility.getUTCTimeOrEmpty((Date)localObject3);
    paramSharedAccessPolicy = paramString2;
    if (paramString2 == null) {
      paramSharedAccessPolicy = "";
    }
    if (paramIPRange == null) {
      paramIPRange = "";
    } else {
      paramIPRange = paramIPRange.toString();
    }
    if (paramSharedAccessProtocols == null) {
      paramSharedAccessProtocols = str;
    } else {
      paramSharedAccessProtocols = paramSharedAccessProtocols.toString();
    }
    return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", new Object[] { localObject1, localObject2, localObject3, paramString1, paramSharedAccessPolicy, paramIPRange, paramSharedAccessProtocols, "2018-03-28" });
  }
  
  public static StorageCredentialsSharedAccessSignature parseQuery(StorageUri paramStorageUri)
  {
    return parseQuery(PathUtility.parseQueryString(paramStorageUri.getQuery()));
  }
  
  public static StorageCredentialsSharedAccessSignature parseQuery(HashMap<String, String[]> paramHashMap)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashMap.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = ((String)localEntry.getKey()).toLowerCase(Utility.LOCALE_US);
      if (((String)localObject3).equals("sig")) {
        i = 1;
      } else if (((String)localObject3).equals("comp")) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      } else if (((String)localObject3).equals("restype")) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      } else if (((String)localObject3).equals("snapshot")) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      } else if (((String)localObject3).equals("api-version")) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      } else if (((String)localObject3).equals("sharesnapshot")) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      }
    }
    Object localObject3 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      paramHashMap.remove((String)((Iterator)localObject3).next());
    }
    if (i != 0)
    {
      localObject1 = new UriQueryBuilder();
      localObject3 = new StringBuilder();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject2 = (Map.Entry)paramHashMap.next();
        ((StringBuilder)localObject3).setLength(0);
        for (i = 0; i < ((String[])((Map.Entry)localObject2).getValue()).length; i++)
        {
          ((StringBuilder)localObject3).append(((String[])localObject2.getValue())[i]);
          ((StringBuilder)localObject3).append(',');
        }
        ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
        addIfNotNullOrEmpty((UriQueryBuilder)localObject1, ((String)((Map.Entry)localObject2).getKey()).toLowerCase(), ((StringBuilder)localObject3).toString());
      }
      return new StorageCredentialsSharedAccessSignature(((UriQueryBuilder)localObject1).toString());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.SharedAccessSignatureHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */