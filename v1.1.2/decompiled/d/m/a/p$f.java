package d.m.a;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class p$f
  implements p.e
{
  public final String a;
  public final int b;
  public final int c;
  
  public p$f(p paramp, String paramString, int paramInt1, int paramInt2)
  {
    a = paramString;
    b = paramInt1;
    c = paramInt2;
  }
  
  public boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    Fragment localFragment = d.q;
    if ((localFragment != null) && (b < 0) && (a == null) && (localFragment.getChildFragmentManager().k())) {
      return false;
    }
    return d.a(paramArrayList, paramArrayList1, a, b, c);
  }
}

/* Location:
 * Qualified Name:     d.m.a.p.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */