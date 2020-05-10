package d.t.a;

import android.util.SparseArray;

public class s$p
{
  public SparseArray<s.p.a> a = new SparseArray();
  public int b = 0;
  
  public final s.p.a a(int paramInt)
  {
    s.p.a locala1 = (s.p.a)a.get(paramInt);
    s.p.a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new s.p.a();
      a.put(paramInt, locala2);
    }
    return locala2;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */