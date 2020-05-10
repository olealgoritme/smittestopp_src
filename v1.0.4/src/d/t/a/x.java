package d.t.a;

import android.view.View;

public class x
{
  public final x.b a;
  public x.a b;
  
  public x(x.b paramb)
  {
    a = paramb;
    b = new x.a();
  }
  
  public View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = a.b();
    int j = a.a();
    int k;
    if (paramInt2 > paramInt1) {
      k = 1;
    } else {
      k = -1;
    }
    Object localObject2;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject2)
    {
      View localView = a.a(paramInt1);
      int m = a.b(localView);
      int n = a.a(localView);
      localObject2 = b;
      b = i;
      c = j;
      d = m;
      e = n;
      if (paramInt3 != 0)
      {
        a = 0;
        a = (paramInt3 | 0x0);
        if (((x.a)localObject2).a()) {
          return localView;
        }
      }
      localObject2 = localObject1;
      if (paramInt4 != 0)
      {
        x.a locala = b;
        a = 0;
        a = (paramInt4 | 0x0);
        localObject2 = localObject1;
        if (locala.a()) {
          localObject2 = localView;
        }
      }
      paramInt1 += k;
    }
    return (View)localObject1;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */