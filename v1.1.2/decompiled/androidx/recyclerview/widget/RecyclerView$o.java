package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.util.ArrayList;

public class RecyclerView$o
{
  public SparseArray<a> a = new SparseArray();
  public int b = 0;
  
  public final a a(int paramInt)
  {
    a locala1 = (a)a.get(paramInt);
    a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new a();
      a.put(paramInt, locala2);
    }
    return locala2;
  }
  
  public static class a
  {
    public final ArrayList<RecyclerView.w> a = new ArrayList();
    public int b = 5;
    public long c = 0L;
    public long d = 0L;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */