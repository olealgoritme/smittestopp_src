package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Map;

public class IBrokerAccountService$Stub$Proxy
  implements IBrokerAccountService
{
  public IBinder mRemote;
  
  public IBrokerAccountService$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public Bundle acquireTokenSilently(Map paramMap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.aad.adal.IBrokerAccountService");
      localParcel1.writeMap(paramMap);
      mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramMap = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramMap = null;
      }
      return paramMap;
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
  
  public Bundle getBrokerUsers()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.aad.adal.IBrokerAccountService");
      mRemote.transact(1, localParcel1, localParcel2, 0);
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
  
  public Bundle getInactiveBrokerKey(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.aad.adal.IBrokerAccountService");
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
  
  public Intent getIntentForInteractiveRequest()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.aad.adal.IBrokerAccountService");
      mRemote.transact(3, localParcel1, localParcel2, 0);
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
    return "com.microsoft.aad.adal.IBrokerAccountService";
  }
  
  public void removeAccounts()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.microsoft.aad.adal.IBrokerAccountService");
      mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.aad.adal.IBrokerAccountService.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */