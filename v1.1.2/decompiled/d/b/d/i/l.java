package d.b.d.i;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import d.i.d.a.b;
import d.i.i.b.a;

public class l
  extends k
{
  public l(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  public k.a a(ActionProvider paramActionProvider)
  {
    return new a(b, paramActionProvider);
  }
  
  public class a
    extends k.a
    implements ActionProvider.VisibilityListener
  {
    public b.a d;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
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
        ((h)localObject).b(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */