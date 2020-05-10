package e.c.a.a.b.j;

public class a
  extends k.a
{
  /* Error */
  public static android.accounts.Account a(k paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +47 -> 48
    //   4: invokestatic 14	android/os/Binder:clearCallingIdentity	()J
    //   7: lstore_1
    //   8: aload_0
    //   9: invokeinterface 20 1 0
    //   14: astore_0
    //   15: lload_1
    //   16: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   19: goto +31 -> 50
    //   22: astore_0
    //   23: goto +19 -> 42
    //   26: astore_0
    //   27: ldc 26
    //   29: ldc 28
    //   31: invokestatic 34	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: lload_1
    //   36: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   39: goto +9 -> 48
    //   42: lload_1
    //   43: invokestatic 24	android/os/Binder:restoreCallingIdentity	(J)V
    //   46: aload_0
    //   47: athrow
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramk	k
    //   7	36	1	l	long
    // Exception table:
    //   from	to	target	type
    //   8	15	22	finally
    //   27	35	22	finally
    //   8	15	26	android/os/RemoteException
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */