package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IBrokerAccountService$Stub
  extends Binder
  implements IBrokerAccountService
{
  public static final String DESCRIPTOR = "com.microsoft.aad.adal.IBrokerAccountService";
  public static final int TRANSACTION_acquireTokenSilently = 2;
  public static final int TRANSACTION_getBrokerUsers = 1;
  public static final int TRANSACTION_getInactiveBrokerKey = 5;
  public static final int TRANSACTION_getIntentForInteractiveRequest = 3;
  public static final int TRANSACTION_removeAccounts = 4;
  
  public IBrokerAccountService$Stub()
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
    return new IBrokerAccountService.Stub.Proxy(paramIBinder);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.aad.adal.IBrokerAccountService.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */