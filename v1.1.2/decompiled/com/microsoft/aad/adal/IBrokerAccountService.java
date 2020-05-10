package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Map;

public abstract interface IBrokerAccountService
  extends IInterface
{
  public abstract Bundle acquireTokenSilently(Map paramMap);
  
  public abstract Bundle getBrokerUsers();
  
  public abstract Bundle getInactiveBrokerKey(Bundle paramBundle);
  
  public abstract Intent getIntentForInteractiveRequest();
  
  public abstract void removeAccounts();
  
  public static abstract class Stub
    extends Binder
    implements IBrokerAccountService
  {
    public static final String DESCRIPTOR = "com.microsoft.aad.adal.IBrokerAccountService";
    public static final int TRANSACTION_acquireTokenSilently = 2;
    public static final int TRANSACTION_getBrokerUsers = 1;
    public static final int TRANSACTION_getInactiveBrokerKey = 5;
    public static final int TRANSACTION_getIntentForInteractiveRequest = 3;
    public static final int TRANSACTION_removeAccounts = 4;
    
    public Stub()
    {
      attachInterface(this, "com.microsoft.aad.adal.IBrokerAccountService");
    }
    
    public static IBrokerAccountService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.microsoft.aad.adal.IBrokerAccountService");
      if ((localIInterface != null) && ((localIInterface instanceof IBrokerAccountService))) {
        return (IBrokerAccountService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5)
              {
                if (paramInt1 != 1598968902) {
                  return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                }
                paramParcel2.writeString("com.microsoft.aad.adal.IBrokerAccountService");
                return true;
              }
              paramParcel1.enforceInterface("com.microsoft.aad.adal.IBrokerAccountService");
              if (paramParcel1.readInt() != 0) {
                paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
              } else {
                paramParcel1 = null;
              }
              paramParcel1 = getInactiveBrokerKey(paramParcel1);
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
            paramParcel1.enforceInterface("com.microsoft.aad.adal.IBrokerAccountService");
            removeAccounts();
            paramParcel2.writeNoException();
            return true;
          }
          paramParcel1.enforceInterface("com.microsoft.aad.adal.IBrokerAccountService");
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
        }
        paramParcel1.enforceInterface("com.microsoft.aad.adal.IBrokerAccountService");
        paramParcel1 = acquireTokenSilently(paramParcel1.readHashMap(Stub.class.getClassLoader()));
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
      paramParcel1.enforceInterface("com.microsoft.aad.adal.IBrokerAccountService");
      paramParcel1 = getBrokerUsers();
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
    
    public static class Proxy
      implements IBrokerAccountService
    {
      public IBinder mRemote;
      
      public Proxy(IBinder paramIBinder)
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
  }
}

/* Location:
 * Qualified Name:     com.microsoft.aad.adal.IBrokerAccountService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */