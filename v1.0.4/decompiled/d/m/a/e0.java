package d.m.a;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.f.a;
import java.util.ArrayList;

public final class e0
  implements Runnable
{
  public e0(k0 paramk0, a parama, Object paramObject1, f0.b paramb, ArrayList paramArrayList1, View paramView, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList2, Object paramObject2, Rect paramRect) {}
  
  public void run()
  {
    Object localObject1 = f0.a(x, y, z, A);
    if (localObject1 != null)
    {
      B.addAll(((a)localObject1).values());
      B.add(C);
    }
    f0.a(D, E, F, (a)localObject1, false);
    Object localObject2 = z;
    if (localObject2 != null)
    {
      x.b(localObject2, G, B);
      localObject1 = f0.a((a)localObject1, A, H, F);
      if (localObject1 != null) {
        x.a((View)localObject1, I);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */