package d.b.d.i;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

import d.i.i.b.a;

public class j$b
  extends j.a
  implements ActionProvider.VisibilityListener
{
  public b.a d;
  
  public j$b(j paramj, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramj, paramContext, paramActionProvider);
  }
  
  public View a(MenuItem paramMenuItem)
  {
    return b.onCreateActionView(paramMenuItem);
  }
  
  public void a(b.a parama)
  {
    d = parama;
    ActionProvider localActionProvider = b;
    if (parama != null) {
      parama = this;
    } else {
      parama = null;
    }
    localActionProvider.setVisibilityListener(parama);
  }
  
  public boolean a()
  {
    return b.isVisible();
  }
  
  public boolean b()
  {
    return b.overridesItemVisibility();
  }
  
  public void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    Object localObject = d;
    if (localObject != null)
    {
      localObject = a.n;
      h = true;
      ((g)localObject).b(true);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */