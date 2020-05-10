package e.c.a.a.b.j;

import android.os.IBinder;
import android.os.IInterface;
import e.c.a.a.d.b.a;
import e.c.a.a.d.b.b;

public abstract class k$a
  extends b
  implements k
{
  public static k a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    if ((localIInterface instanceof k)) {
      return (k)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public static final class a
    extends a
    implements k
  {
    public a(IBinder paramIBinder)
    {
      super("com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    /* Error */
    public final android.accounts.Account getAccount()
    {
      // Byte code:
      //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_1
      //   4: aload_1
      //   5: aload_0
      //   6: getfield 31	e/c/a/a/d/b/a:b	Ljava/lang/String;
      //   9: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   12: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   15: astore_2
      //   16: aload_0
      //   17: getfield 38	e/c/a/a/d/b/a:a	Landroid/os/IBinder;
      //   20: iconst_2
      //   21: aload_1
      //   22: aload_2
      //   23: iconst_0
      //   24: invokeinterface 44 5 0
      //   29: pop
      //   30: aload_2
      //   31: invokevirtual 48	android/os/Parcel:readException	()V
      //   34: aload_1
      //   35: invokevirtual 51	android/os/Parcel:recycle	()V
      //   38: aload_2
      //   39: getstatic 57	android/accounts/Account:CREATOR	Landroid/os/Parcelable$Creator;
      //   42: invokestatic 62	e/c/a/a/d/b/c:a	(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      //   45: checkcast 53	android/accounts/Account
      //   48: astore_1
      //   49: aload_2
      //   50: invokevirtual 51	android/os/Parcel:recycle	()V
      //   53: aload_1
      //   54: areturn
      //   55: astore_2
      //   56: goto +10 -> 66
      //   59: astore_3
      //   60: aload_2
      //   61: invokevirtual 51	android/os/Parcel:recycle	()V
      //   64: aload_3
      //   65: athrow
      //   66: aload_1
      //   67: invokevirtual 51	android/os/Parcel:recycle	()V
      //   70: aload_2
      //   71: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	this	a
      //   3	64	1	localObject1	Object
      //   15	35	2	localParcel	android.os.Parcel
      //   55	16	2	localObject2	Object
      //   59	6	3	localRuntimeException	RuntimeException
      // Exception table:
      //   from	to	target	type
      //   16	34	55	finally
      //   60	66	55	finally
      //   16	34	59	java/lang/RuntimeException
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */