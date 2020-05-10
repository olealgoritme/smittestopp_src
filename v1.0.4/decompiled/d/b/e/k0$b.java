package d.b.e;

import android.database.DataSetObserver;

public class k0$b
  extends DataSetObserver
{
  public k0$b(k0 paramk0) {}
  
  public void onChanged()
  {
    if (a.a()) {
      a.c();
    }
  }
  
  public void onInvalidated()
  {
    a.dismiss();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.k0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */