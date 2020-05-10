package l.d.b;

import android.database.SQLException;

public class d
  extends SQLException
{
  public d(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public d(String paramString, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 8	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: aload_2
    //   7: invokevirtual 14	android/database/SQLException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   10: pop
    //   11: goto +22 -> 33
    //   14: astore_1
    //   15: ldc 16
    //   17: ldc 18
    //   19: aload_1
    //   20: invokestatic 24	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   23: pop
    //   24: ldc 16
    //   26: ldc 26
    //   28: aload_2
    //   29: invokestatic 24	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   32: pop
    //   33: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	d
    //   0	34	1	paramString	String
    //   0	34	2	paramThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	11	14	finally
  }
}

/* Location:
 * Qualified Name:     l.d.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */