package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class PathUtility
{
  public static StorageUri addToQuery(StorageUri paramStorageUri, String paramString)
  {
    return new StorageUri(addToSingleUriQuery(paramStorageUri.getPrimaryUri(), parseQueryString(paramString)), addToSingleUriQuery(paramStorageUri.getSecondaryUri(), parseQueryString(paramString)));
  }
  
  public static URI addToQuery(URI paramURI, String paramString)
  {
    return addToSingleUriQuery(paramURI, parseQueryString(paramString));
  }
  
  public static URI addToSingleUriQuery(URI paramURI, HashMap<String, String[]> paramHashMap)
  {
    if (paramURI == null) {
      return null;
    }
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      for (String str : (String[])localEntry.getValue()) {
        localUriQueryBuilder.add((String)localEntry.getKey(), str);
      }
    }
    return localUriQueryBuilder.addToURI(paramURI);
  }
  
  public static URI appendPathToSingleUri(URI paramURI, String paramString)
  {
    return appendPathToSingleUri(paramURI, paramString, "/");
  }
  
  public static URI appendPathToSingleUri(URI paramURI, String paramString1, String paramString2)
  {
    if (paramURI == null) {
      return null;
    }
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramURI.getPath().length() == 0) && (paramString1.startsWith(paramString2))) {
        return new URI(paramURI.getScheme(), paramURI.getAuthority(), paramString1, paramURI.getRawQuery(), paramURI.getRawFragment());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramURI.getPath());
      if (paramURI.getPath().endsWith(paramString2))
      {
        localStringBuilder.append(paramString1);
      }
      else
      {
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramString1);
      }
      return new URI(paramURI.getScheme(), paramURI.getAuthority(), localStringBuilder.toString(), paramURI.getQuery(), paramURI.getFragment());
    }
    return paramURI;
  }
  
  public static StorageUri appendPathToUri(StorageUri paramStorageUri, String paramString)
  {
    return appendPathToUri(paramStorageUri, paramString, "/");
  }
  
  public static StorageUri appendPathToUri(StorageUri paramStorageUri, String paramString1, String paramString2)
  {
    return new StorageUri(appendPathToSingleUri(paramStorageUri.getPrimaryUri(), paramString1, paramString2), appendPathToSingleUri(paramStorageUri.getSecondaryUri(), paramString1, paramString2));
  }
  
  public static String getBlobNameFromURI(URI paramURI, boolean paramBoolean)
  {
    return Utility.safeRelativize(new URI(getContainerURI(new StorageUri(paramURI), paramBoolean).getPrimaryUri().toString().concat("/")), paramURI);
  }
  
  public static String getCanonicalPathFromCredentials(StorageCredentials paramStorageCredentials, String paramString)
  {
    String str = paramStorageCredentials.getAccountName();
    if (str != null)
    {
      paramStorageCredentials = new StringBuilder("/");
      paramStorageCredentials.append(str);
      paramStorageCredentials.append(paramString);
      return paramStorageCredentials.toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature as the credentials does not have account name information. Please check that the credentials provided support creating Shared Access Signature.");
  }
  
  public static String getContainerNameFromUri(URI paramURI, boolean paramBoolean)
  {
    return getResourceNameFromUri(paramURI, paramBoolean, String.format("Invalid blob address '%s', missing container information", new Object[] { paramURI }));
  }
  
  public static StorageUri getContainerURI(StorageUri paramStorageUri, boolean paramBoolean)
  {
    String str = getContainerNameFromUri(paramStorageUri.getPrimaryUri(), paramBoolean);
    return appendPathToUri(getServiceClientBaseAddress(paramStorageUri, paramBoolean), str);
  }
  
  public static String getDirectoryNameFromURI(URI paramURI, boolean paramBoolean)
  {
    String[] arrayOfString = paramURI.getRawPath().split("/");
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    if (arrayOfString.length - 1 >= i)
    {
      if (arrayOfString.length - 1 == i) {
        return "";
      }
      return arrayOfString[(arrayOfString.length - 1)];
    }
    throw new IllegalArgumentException(String.format("Invalid directory address '%s'.", new Object[] { paramURI }));
  }
  
  public static String getFileNameFromURI(URI paramURI, boolean paramBoolean)
  {
    String[] arrayOfString = paramURI.getRawPath().split("/");
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    if (arrayOfString.length - 1 > i) {
      return arrayOfString[(arrayOfString.length - 1)];
    }
    throw new IllegalArgumentException(String.format("Invalid file address '%s'.", new Object[] { paramURI }));
  }
  
  public static String getResourceNameFromUri(URI paramURI, boolean paramBoolean, String paramString)
  {
    Utility.assertNotNull("resourceAddress", paramURI);
    paramURI = paramURI.getRawPath().split("/");
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    if (paramURI.length >= i)
    {
      if (paramBoolean) {
        paramURI = paramURI[2];
      } else {
        paramURI = paramURI[1];
      }
      return Utility.trimEnd(paramURI, '/');
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static StorageUri getServiceClientBaseAddress(StorageUri paramStorageUri, boolean paramBoolean)
  {
    URI localURI = new URI(getServiceClientBaseAddress(paramStorageUri.getPrimaryUri(), paramBoolean));
    if (paramStorageUri.getSecondaryUri() != null) {
      paramStorageUri = new URI(getServiceClientBaseAddress(paramStorageUri.getSecondaryUri(), paramBoolean));
    } else {
      paramStorageUri = null;
    }
    return new StorageUri(localURI, paramStorageUri);
  }
  
  public static String getServiceClientBaseAddress(URI paramURI, boolean paramBoolean)
  {
    if (paramURI == null) {
      return null;
    }
    if (paramBoolean)
    {
      String[] arrayOfString = paramURI.getRawPath().split("/");
      if (arrayOfString.length >= 2)
      {
        paramURI = new StringBuilder(new URI(paramURI.getScheme(), paramURI.getAuthority(), null, null, null).toString());
        paramURI.append("/");
        paramURI.append(Utility.trimEnd(arrayOfString[1], '/'));
        return paramURI.toString();
      }
      throw new IllegalArgumentException(String.format("Missing account name information inside path style URI. Path style URIs should be of the form http://<IPAddress:Port>/<accountName>", new Object[0]));
    }
    return new URI(paramURI.getScheme(), paramURI.getAuthority(), null, null, null).toString();
  }
  
  public static String getShareNameFromUri(URI paramURI, boolean paramBoolean)
  {
    return getResourceNameFromUri(paramURI, paramBoolean, String.format("Invalid file address '%s', missing share information", new Object[] { paramURI }));
  }
  
  public static StorageUri getShareURI(StorageUri paramStorageUri, boolean paramBoolean)
  {
    String str = getShareNameFromUri(paramStorageUri.getPrimaryUri(), paramBoolean);
    return appendPathToUri(getServiceClientBaseAddress(paramStorageUri, paramBoolean), str);
  }
  
  public static String getTableNameFromUri(URI paramURI, boolean paramBoolean)
  {
    return getResourceNameFromUri(paramURI, paramBoolean, String.format("Invalid table address '%s', missing table information", new Object[] { paramURI }));
  }
  
  public static HashMap<String, String[]> parseQueryString(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (Utility.isNullOrEmpty(paramString)) {
      return localHashMap;
    }
    int i = paramString.indexOf("?");
    Object localObject1 = paramString;
    if (i >= 0)
    {
      localObject1 = paramString;
      if (paramString.length() > 0) {
        localObject1 = paramString.substring(i + 1);
      }
    }
    paramString = "&";
    if (!((String)localObject1).contains("&")) {
      paramString = ";";
    }
    paramString = ((String)localObject1).split(paramString);
    for (i = 0; i < paramString.length; i++)
    {
      int j = paramString[i].indexOf("=");
      if ((j >= 0) && (j != paramString[i].length() - 1))
      {
        Object localObject2 = paramString[i].substring(0, j);
        localObject1 = paramString[i].substring(j + 1);
        localObject2 = Utility.safeDecode((String)localObject2);
        String str = Utility.safeDecode((String)localObject1);
        localObject1 = (String[])localHashMap.get(localObject2);
        if (localObject1 == null)
        {
          if (!str.equals("")) {
            localHashMap.put(localObject2, new String[] { str });
          }
        }
        else if (!str.equals(""))
        {
          int k = localObject1.length + 1;
          localObject2 = new String[k];
          for (j = 0; j < localObject1.length; j++) {
            localObject2[j] = localObject1[j];
          }
          localObject2[k] = str;
        }
      }
    }
    return localHashMap;
  }
  
  public static URI stripSingleURIQueryAndFragment(URI paramURI)
  {
    if (paramURI == null) {
      return null;
    }
    try
    {
      paramURI = new URI(paramURI.getScheme(), paramURI.getAuthority(), paramURI.getPath(), null, null);
      return paramURI;
    }
    catch (URISyntaxException paramURI)
    {
      throw Utility.generateNewUnexpectedStorageException(paramURI);
    }
  }
  
  public static StorageUri stripURIQueryAndFragment(StorageUri paramStorageUri)
  {
    return new StorageUri(stripSingleURIQueryAndFragment(paramStorageUri.getPrimaryUri()), stripSingleURIQueryAndFragment(paramStorageUri.getSecondaryUri()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.PathUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */