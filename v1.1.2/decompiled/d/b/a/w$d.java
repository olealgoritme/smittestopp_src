package d.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import d.b.d.a.a;
import d.b.d.f;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.e.b0;
import d.b.e.c;
import java.lang.ref.WeakReference;

public class w$d
  extends d.b.d.a
  implements h.a
{
  public final h A;
  public a.a B;
  public WeakReference<View> C;
  public final Context z;
  
  public w$d(w paramw, Context paramContext, a.a parama)
  {
    z = paramContext;
    B = parama;
    paramw = new h(paramContext);
    l = 1;
    A = paramw;
    e = this;
  }
  
  public void a()
  {
    Object localObject = D;
    if (i != this) {
      return;
    }
    boolean bool1 = q;
    boolean bool2 = r;
    int i = 1;
    if ((bool1) || (bool2)) {
      i = 0;
    }
    if (i == 0)
    {
      localObject = D;
      j = this;
      k = B;
    }
    else
    {
      B.a(this);
    }
    B = null;
    D.e(false);
    localObject = D.f;
    if (H == null) {
      ((ActionBarContextView)localObject).b();
    }
    D.e.h().sendAccessibilityEvent(32);
    localObject = D;
    c.setHideOnContentScrollEnabled(w);
    D.i = null;
  }
  
  public void a(int paramInt)
  {
    String str = D.a.getResources().getString(paramInt);
    D.f.setSubtitle(str);
  }
  
  public void a(View paramView)
  {
    D.f.setCustomView(paramView);
    C = new WeakReference(paramView);
  }
  
  public void a(h paramh)
  {
    if (B == null) {
      return;
    }
    g();
    paramh = D.f.A;
    if (paramh != null) {
      paramh.g();
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    D.f.setSubtitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    y = paramBoolean;
    D.f.setTitleOptional(paramBoolean);
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    paramh = B;
    if (paramh != null) {
      return paramh.a(this, paramMenuItem);
    }
    return false;
  }
  
  public View b()
  {
    Object localObject = C;
    if (localObject != null) {
      localObject = (View)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    return (View)localObject;
  }
  
  public void b(int paramInt)
  {
    String str = D.a.getResources().getString(paramInt);
    D.f.setTitle(str);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    D.f.setTitle(paramCharSequence);
  }
  
  public Menu c()
  {
    return A;
  }
  
  public MenuInflater d()
  {
    return new f(z);
  }
  
  public CharSequence e()
  {
    return D.f.getSubtitle();
  }
  
  public CharSequence f()
  {
    return D.f.getTitle();
  }
  
  public void g()
  {
    if (D.i != this) {
      return;
    }
    A.j();
    try
    {
      B.a(this, A);
      return;
    }
    finally
    {
      A.i();
    }
  }
  
  public boolean h()
  {
    return D.f.O;
  }
}

/* Location:
 * Qualified Name:     d.b.a.w.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */