package d.b.e;

import android.database.DataSetObserver;

public class i0$b
  extends DataSetObserver
{
  public i0$b(i0 parami0) {}
  
  public void onChanged()
  {
    if (a.e()) {
      a.a();
    }
  }
  
  public void onInvalidated()
  {
    a.dismiss();
  }
}

/* Location:
 * Qualified Name:     d.b.e.i0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */