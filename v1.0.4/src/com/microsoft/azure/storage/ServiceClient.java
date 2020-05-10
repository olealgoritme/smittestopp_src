package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import javax.xml.stream.XMLStreamException;

public abstract class ServiceClient
{
  public StorageCredentials credentials;
  public StorageUri storageUri;
  public boolean usePathStyleUris;
  
  public ServiceClient(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("baseUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      StorageCredentials localStorageCredentials = paramStorageCredentials;
      if (paramStorageCredentials == null) {
        localStorageCredentials = StorageCredentialsAnonymous.ANONYMOUS;
      }
      credentials = localStorageCredentials;
      usePathStyleUris = Utility.determinePathStyleFromUri(paramStorageUri.getPrimaryUri());
      storageUri = paramStorageUri;
      return;
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri }));
  }
  
  public StorageRequest<ServiceClient, Void, ServiceProperties> downloadServicePropertiesImpl(RequestOptions paramRequestOptions, boolean paramBoolean)
  {
    return new ServiceClient.1(this, paramRequestOptions, getStorageUri(), paramRequestOptions, paramBoolean);
  }
  
  public final StorageCredentials getCredentials()
  {
    return credentials;
  }
  
  public abstract RequestOptions getDefaultRequestOptions();
  
  public final URI getEndpoint()
  {
    return storageUri.getPrimaryUri();
  }
  
  public StorageRequest<ServiceClient, Void, ServiceStats> getServiceStatsImpl(RequestOptions paramRequestOptions, boolean paramBoolean)
  {
    return new ServiceClient.2(this, paramRequestOptions, getStorageUri(), paramRequestOptions, paramBoolean);
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public boolean isUsePathStyleUris()
  {
    return usePathStyleUris;
  }
  
  public final void setCredentials(StorageCredentials paramStorageCredentials)
  {
    credentials = paramStorageCredentials;
  }
  
  public final void setStorageUri(StorageUri paramStorageUri)
  {
    usePathStyleUris = Utility.determinePathStyleFromUri(paramStorageUri.getPrimaryUri());
    storageUri = paramStorageUri;
  }
  
  public StorageRequest<ServiceClient, Void, Void> uploadServicePropertiesImpl(ServiceProperties paramServiceProperties, RequestOptions paramRequestOptions, OperationContext paramOperationContext, boolean paramBoolean)
  {
    try
    {
      paramOperationContext = ServicePropertiesSerializer.serializeToByteArray(paramServiceProperties);
      paramServiceProperties = new java/io/ByteArrayInputStream;
      paramServiceProperties.<init>(paramOperationContext);
      paramOperationContext = Utility.analyzeStream(paramServiceProperties, -1L, -1L, true, true);
      paramServiceProperties = new ServiceClient.3(this, paramRequestOptions, getStorageUri(), paramServiceProperties, paramOperationContext, paramRequestOptions, paramBoolean);
      return paramServiceProperties;
    }
    catch (IOException paramServiceProperties)
    {
      throw StorageException.translateClientException(paramServiceProperties);
    }
    catch (XMLStreamException paramServiceProperties)
    {
      throw StorageException.translateClientException(paramServiceProperties);
    }
    catch (IllegalArgumentException paramServiceProperties)
    {
      throw StorageException.translateClientException(paramServiceProperties);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServiceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */