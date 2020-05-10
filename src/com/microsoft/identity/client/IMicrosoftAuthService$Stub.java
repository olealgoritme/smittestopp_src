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
    return new IMicrosoftAuthService.Stub.Proxy(paramIBinder);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMicrosoftAuthService.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */