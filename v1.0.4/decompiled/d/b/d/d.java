package d.b.d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.ActionBarContextView;

import java.lang.ref.WeakReference;

import d.b.d.i.g;
import d.b.d.i.g.a;

public class d
  extends a
  implements g.a
{
  public ActionBarContextView A;
  public a.a B;
  public WeakReference<View> C;
  public boolean D;
  public g E;
  public Context z;
  
  public d(Context paramContext, ActionBarContextView paramActionBarContextView, a.a parama, boolean paramBoolean)
  {
    z = paramContext;
    A = paramActionBarContextView;
    B = parama;
    paramContext = new g(paramActionBarContextView.getContext());
    l = 1;
    E = paramContext;
    e = this;
  }
  
  public void a()
  {
    if (D) {
      return;
    }
    D = true;
    A.sendAccessibilityEvent(32);
    B.a(this);
  }
  
  public void a(int paramInt)
  {
    String str = z.getString(paramInt);
    A.setSubtitle(str);
  }
  
  public void a(View paramView)
  {
    A.setCustomView(paramView);
    if (paramView != null) {
      paramView = new WeakReference(paramView);
    } else {
      paramView = null;
    }
    C = paramView;
  }
  
  public void a(g paramg)
  {
    g();
    paramg = A.A;
    if (paramg != null) {
      paramg.g();
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    A.setSubtitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    y = paramBoolean;
    A.setTitleOptional(paramBoolean);
  }
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    return B.a(this, paramMenuItem);
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
    String str = z.getString(paramInt);
    A.setTitle(str);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    A.setTitle(paramCharSequence);
  }
  
  public Menu c()
  {
    return E;
  }
  
  public MenuInflater d()
  {
    return new f(A.getContext());
  }
  
  public CharSequence e()
  {
    return A.getSubtitle();
  }
  
  public CharSequence f()
  {
    return A.getTitle();
  }
  
  public void g()
  {
    B.a(this, E);
  }
  
  public boolean h()
  {
    return A.O;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */