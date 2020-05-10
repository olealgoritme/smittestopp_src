package d.a0.a;

import android.database.DataSetObservable;
import android.os.Parcelable;
import android.view.ViewGroup;

public abstract class a
{
  public a()
  {
    new DataSetObservable();
  }
  
  /* Error */
  public void a(android.database.DataSetObserver paramDataSetObserver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorexit
    //   4: return
    //   5: astore_1
    //   6: aload_0
    //   7: monitorexit
    //   8: aload_1
    //   9: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	a
    //   0	10	1	paramDataSetObserver	android.database.DataSetObserver
    // Exception table:
    //   from	to	target	type
    //   2	4	5	finally
    //   6	8	5	finally
  }
  
  public abstract void a(Parcelable paramParcelable, ClassLoader paramClassLoader);
  
  public abstract void a(ViewGroup paramViewGroup);
  
  public abstract void a(ViewGroup paramViewGroup, int paramInt, Object paramObject);
  
  public abstract void b(ViewGroup paramViewGroup);
}

/* Location:
 * Qualified Name:     base.d.a0.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */