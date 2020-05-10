package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.net.URI;

public class StorageUri
{
  public URI primaryUri;
  public URI secondaryUri;
  
  public StorageUri(URI paramURI)
  {
    this(paramURI, null);
  }
  
  public StorageUri(URI paramURI1, URI paramURI2)
  {
    if ((paramURI1 == null) && (paramURI2 == null)) {
      throw new IllegalArgumentException("Primary and secondary location URIs in a StorageUri must not both be null.");
    }
    if ((paramURI1 != null) && (paramURI2 != null))
    {
      if (((paramURI1.getQuery() == null) && (paramURI2.getQuery() != null)) || ((paramURI1.getQuery() != null) && (!paramURI1.getQuery().equals(paramURI2.getQuery())))) {
        throw new IllegalArgumentException("Primary and secondary location URIs in a StorageUri must point to the same resource.");
      }
      boolean bool1 = Utility.determinePathStyleFromUri(paramURI1);
      boolean bool2 = Utility.determinePathStyleFromUri(paramURI2);
      if ((!bool1) && (!bool2))
      {
        if (((paramURI1.getPath() == null) && (paramURI2.getPath() != null)) || ((paramURI1.getPath() != null) && (!paramURI1.getPath().equals(paramURI2.getPath())))) {
          throw new IllegalArgumentException("Primary and secondary location URIs in a StorageUri must point to the same resource.");
        }
      }
      else
      {
        int i = 3;
        int j;
        if (bool1) {
          j = 3;
        } else {
          j = 2;
        }
        if (!bool2) {
          i = 2;
        }
        Object localObject = paramURI1.getPath().split("/", j);
        String[] arrayOfString = paramURI2.getPath().split("/", i);
        int k = localObject.length;
        String str = "";
        if (k == j) {
          localObject = localObject[(localObject.length - 1)];
        } else {
          localObject = "";
        }
        if (arrayOfString.length == i) {
          str = arrayOfString[(arrayOfString.length - 1)];
        }
        if (!((String)localObject).equals(str)) {
          throw new IllegalArgumentException("Primary and secondary location URIs in a StorageUri must point to the same resource.");
        }
      }
    }
    setPrimaryUri(paramURI1);
    setSecondaryUri(paramURI2);
  }
  
  public static boolean AreUrisEqual(URI paramURI1, URI paramURI2)
  {
    boolean bool;
    if (paramURI1 == null)
    {
      if (paramURI2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramURI1.equals(paramURI2);
    }
    return bool;
  }
  
  public static void AssertAbsoluteUri(URI paramURI)
  {
    if ((paramURI != null) && (!paramURI.isAbsolute())) {
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramURI.toString() }));
    }
  }
  
  private void setPrimaryUri(URI paramURI)
  {
    AssertAbsoluteUri(paramURI);
    primaryUri = paramURI;
  }
  
  private void setSecondaryUri(URI paramURI)
  {
    AssertAbsoluteUri(paramURI);
    secondaryUri = paramURI;
  }
  
  public boolean equals(StorageUri paramStorageUri)
  {
    boolean bool;
    if ((paramStorageUri != null) && (AreUrisEqual(primaryUri, primaryUri)) && (AreUrisEqual(secondaryUri, secondaryUri))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    return equals((StorageUri)paramObject);
  }
  
  public URI getPrimaryUri()
  {
    return primaryUri;
  }
  
  public String getQuery()
  {
    return primaryUri.getQuery();
  }
  
  public URI getSecondaryUri()
  {
    return secondaryUri;
  }
  
  public URI getUri(StorageLocation paramStorageLocation)
  {
    int i = paramStorageLocation.ordinal();
    if (i != 0)
    {
      if (i == 1) {
        return secondaryUri;
      }
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "location", paramStorageLocation.toString() }));
    }
    return primaryUri;
  }
  
  public int hashCode()
  {
    URI localURI = primaryUri;
    int i = 0;
    int j;
    if (localURI != null) {
      j = localURI.hashCode();
    } else {
      j = 0;
    }
    localURI = secondaryUri;
    if (localURI != null) {
      i = localURI.hashCode();
    }
    return j ^ i;
  }
  
  public boolean isAbsolute()
  {
    if (secondaryUri == null) {
      return primaryUri.isAbsolute();
    }
    boolean bool;
    if ((primaryUri.isAbsolute()) && (secondaryUri.isAbsolute())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    return String.format(Utility.LOCALE_US, "Primary = '%s'; Secondary = '%s'", new Object[] { primaryUri, secondaryUri });
  }
  
  public boolean validateLocationMode(LocationMode paramLocationMode)
  {
    int i = paramLocationMode.ordinal();
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (i != 0)
    {
      if (i != 2)
      {
        if ((primaryUri == null) || (secondaryUri == null)) {
          bool3 = false;
        }
        return bool3;
      }
      if (secondaryUri != null) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    if (primaryUri != null) {
      bool3 = bool2;
    } else {
      bool3 = false;
    }
    return bool3;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */