package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IMicrosoftAuthService$Stub
  extends Binder
  implements IMicrosoftAuthService
{
  public static final String DESCRIPTOR = "com.microsoft.identity.client.IMicrosoftAuthService";
  public static final int TRANSACTION_acquireTokenSilently = 3;
  public static final int TRANSACTION_getAccounts = 2;
  public static final int TRANSACTION_getCurrentAccount = 7;
  public static final int TRANSACTION_getDeviceMode = 6;
  public static final int TRANSACTION_getIntentForInteractiveRequest = 4;
  public static final int TRANSACTION_hello = 1;
  public static final int TRANSACTION_removeAccount = 5;
  public static final int TRANSACTION_removeAccountFromSharedDevice = 8;
  
  public IMicrosoftAuthService$Stub()
  {
    attachInterface(this, "com.microsoft.identity.client.IMicrosoftAuthService");
  }
  
  public static IMicrosoftAuthService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.microsoft.identity.client.IMicrosoftAuthService");
    if ((localIInterface != null) && ((localIInterface instanceof IMicrosoftAuthService))) {
      return (IMicrosoftAuthService)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 8: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        if (paramParcel1.readInt() != 0) {
          localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = removeAccountFromSharedDevice((Bundle)localObject6);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        localObject6 = localObject1;
        if (paramParcel1.readInt() != 0) {
          localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = getCurrentAccount((Bundle)localObject6);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        paramParcel1 = getDeviceMode();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        localObject6 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = removeAccount((Bundle)localObject6);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        paramParcel1 = getIntentForInteractiveRequest();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        localObject6 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = acquireTokenSilently((Bundle)localObject6);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
        localObject6 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = getAccounts((Bundle)localObject6);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      }
      paramParcel1.enforceInterface("com.microsoft.identity.client.IMicrosoftAuthService");
      localObject6 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = hello((Bundle)localObject6);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      else
      {
        paramParcel2.writeInt(0);
      }
      return true;
    }
    paramParcel2.writeString("com.microsoft.identity.client.IMicrosoftAuthService");
    return true;
  }
  
  public static class Proxy
    implements IMicrosoftAuthService
  {
    public IBinder mRemote;
    
    public Proxy(IBinder paramIBinder)
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IMicrosoftAuthService.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */