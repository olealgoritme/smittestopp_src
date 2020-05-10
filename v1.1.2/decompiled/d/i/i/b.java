package d.i.i;

import android.content.Context;
import android.util.Log;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import d.b.d.i.k.a;
import e.a.a.a.a;

public abstract class b
{
  public a a;
  
  public b(Context paramContext) {}
  
  public View a(MenuItem paramMenuItem)
  {
    return b.onCreateActionView();
  }
  
  public void a(a parama)
  {
    if ((a != null) && (parama != null))
    {
      StringBuilder localStringBuilder = a.a("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
      Log.w("ActionProvider(support)", localStringBuilder.toString());
    }
    a = parama;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public static abstract interface a {}
}

/* Location:
 * Qualified Name:     d.i.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */