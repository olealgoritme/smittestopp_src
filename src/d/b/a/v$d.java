package d.b.a;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.ActionBarContextView;

import java.lang.ref.WeakReference;

import d.b.d.f;
import d.b.d.i.g;
import d.b.d.i.g.a;
import d.b.e.c;

public class v$d
  extends d.b.d.a
  implements g.a
{
  public final g A;
  public a.a B;
  public WeakReference<View> C;
  public final Context z;
  
  public v$d(v paramv, Context paramContext, a.a parama)
  {
    z = paramContext;
    B = parama;
    paramv = new g(paramContext);
    l = 1;
    A = paramv;
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
    D.e.j().sendAccessibilityEvent(32);
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
  
  public void a(g paramg)
  {
    if (B == null) {
      return;
    }
    g();
    paramg = D.f.A;
    if (paramg != null) {
      paramg.g();
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
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    paramg = B;
    if (paramg != null) {
      return paramg.a(this, paramMenuItem);
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
 * Qualified Name:     base.d.b.a.v.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */