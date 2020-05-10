package d.s.s;

import android.graphics.drawable.Drawable;
import d.b.a.h;
import d.b.a.k;

public class b
  extends a
{
  public final h f;
  
  public b(h paramh, c paramc) {}
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    Object localObject = f.k();
    if (paramDrawable == null)
    {
      ((d.b.a.a)localObject).c(false);
    }
    else
    {
      ((d.b.a.a)localObject).c(true);
      localObject = (k)f.j();
      if (localObject == null) {
        break label64;
      }
      ((k)localObject).k();
      localObject = E;
      if (localObject != null)
      {
        ((d.b.a.a)localObject).a(paramDrawable);
        ((d.b.a.a)localObject).a(paramInt);
      }
    }
    return;
    label64:
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.s.s.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */