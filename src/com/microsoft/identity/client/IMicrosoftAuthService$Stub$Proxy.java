package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class IMicrosoftAuthService$Stub$Proxy
  implements IMicrosoftAuthService
{
  public IBinder mRemote;
  
  public IMicrosoftAuthService$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public Bundle acquireTokenSilently(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  public Bundle getAccounts(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle getCurrentAccount(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle getDeviceMode()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      Bundle localBundle;
      if (localParcel2.readInt() != 0) {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        localBundle = null;
      }
      return localBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Intent getIntentForInteractiveRequest()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      Intent localIntent;
      if (localParcel2.readInt() != 0) {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
      } else {
        localIntent = null;
      }
      return localIntent;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.microsoft.identity.client.IMicrosoftAuthService";
  }
  
  public Bundle hello(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle removeAccount(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle removeAccountFromSharedDevice(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.identity.client.IMicrosoftAuthService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMicrosoftAuthService.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */