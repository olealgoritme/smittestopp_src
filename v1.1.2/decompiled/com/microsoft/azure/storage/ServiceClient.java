package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
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
  
  public StorageRequest<ServiceClient, Void, ServiceProperties> downloadServicePropertiesImpl(final RequestOptions paramRequestOptions, final boolean paramBoolean)
  {
    new StorageRequest(paramRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
      {
        return BaseRequest.getServiceProperties(credentials.transformUri(paramAnonymousServiceClient.getEndpoint()), paramRequestOptions, null, paramAnonymousOperationContext);
      }
      
      public ServiceProperties postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext, ServiceProperties paramAnonymousServiceProperties)
      {
        return ServicePropertiesHandler.readServicePropertiesFromStream(paramAnonymousHttpURLConnection.getInputStream());
      }
      
      public ServiceProperties preProcessResponse(Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        if (paramBoolean) {
          StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, -1L, paramAnonymousOperationContext);
        } else {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, -1L, paramAnonymousOperationContext);
        }
      }
    };
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
  
  public StorageRequest<ServiceClient, Void, ServiceStats> getServiceStatsImpl(final RequestOptions paramRequestOptions, final boolean paramBoolean)
  {
    new StorageRequest(paramRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
      {
        return BaseRequest.getServiceStats(credentials.transformUri(paramAnonymousServiceClient.getStorageUri().getUri(getCurrentLocation())), paramRequestOptions, null, paramAnonymousOperationContext);
      }
      
      public ServiceStats postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext, ServiceStats paramAnonymousServiceStats)
      {
        return ServiceStatsHandler.readServiceStatsFromStream(paramAnonymousHttpURLConnection.getInputStream());
      }
      
      public ServiceStats preProcessResponse(Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void setRequestLocationMode()
      {
        applyLocationModeToRequest();
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        if (paramBoolean) {
          StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, -1L, paramAnonymousOperationContext);
        } else {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, -1L, paramAnonymousOperationContext);
        }
      }
    };
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
  
  public StorageRequest<ServiceClient, Void, Void> uploadServicePropertiesImpl(final ServiceProperties paramServiceProperties, final RequestOptions paramRequestOptions, final OperationContext paramOperationContext, final boolean paramBoolean)
  {
    try
    {
      paramOperationContext = ServicePropertiesSerializer.serializeToByteArray(paramServiceProperties);
      paramServiceProperties = new java/io/ByteArrayInputStream;
      paramServiceProperties.<init>(paramOperationContext);
      paramOperationContext = Utility.analyzeStream(paramServiceProperties, -1L, -1L, true, true);
      paramServiceProperties = new StorageRequest(paramRequestOptions, getStorageUri())
      {
        public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(paramServiceProperties);
          setLength(Long.valueOf(paramOperationContext.getLength()));
          return BaseRequest.setServiceProperties(credentials.transformUri(paramAnonymousServiceClient.getEndpoint()), paramRequestOptions, null, paramAnonymousOperationContext);
        }
        
        public Void preProcessResponse(Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
        {
          if (getResult().getStatusCode() != 202) {
            setNonExceptionedRetryableFailure(true);
          }
          return null;
        }
        
        public void recoveryAction(OperationContext paramAnonymousOperationContext)
        {
          paramServiceProperties.reset();
          paramServiceProperties.mark(268435456);
        }
        
        public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
        {
          paramAnonymousHttpURLConnection.setRequestProperty("Content-MD5", paramOperationContext.getMd5());
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
        {
          if (paramBoolean) {
            StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, paramOperationContext.getLength(), paramAnonymousOperationContext);
          } else {
            StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, paramOperationContext.getLength(), paramAnonymousOperationContext);
          }
        }
      };
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
 * Qualified Name:     com.microsoft.azure.storage.ServiceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */