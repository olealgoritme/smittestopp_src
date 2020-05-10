package d.b.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import d.b.d.i.l;
import d.b.d.i.q;
import d.f.h;
import d.i.d.a.b;
import java.util.ArrayList;

public class e
  extends ActionMode
{
  public final Context a;
  public final a b;
  
  public e(Context paramContext, a parama)
  {
    a = paramContext;
    b = parama;
  }
  
  public void finish()
  {
    b.a();
  }
  
  public View getCustomView()
  {
    return b.b();
  }
  
  public Menu getMenu()
  {
    return new q(a, (d.i.d.a.a)b.c());
  }
  
  public MenuInflater getMenuInflater()
  {
    return b.d();
  }
  
  public CharSequence getSubtitle()
  {
    return b.e();
  }
  
  public Object getTag()
  {
    return b.x;
  }
  
  public CharSequence getTitle()
  {
    return b.f();
  }
  
  public boolean getTitleOptionalHint()
  {
    return b.y;
  }
  
  public void invalidate()
  {
    b.g();
  }
  
  public boolean isTitleOptional()
  {
    return b.h();
  }
  
  public void setCustomView(View paramView)
  {
    b.a(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    b.a(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    b.a(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    b.x = paramObject;
  }
  
  public void setTitle(int paramInt)
  {
    b.b(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    b.b(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    b.a(paramBoolean);
  }
  
  public static class a
    implements a.a
  {
    public final ActionMode.Callback a;
    public final Context b;
    public final ArrayList<e> c;
    public final h<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      b = paramContext;
      a = paramCallback;
      c = new ArrayList();
      d = new h();
    }
    
    public final Menu a(Menu paramMenu)
    {
      Menu localMenu = (Menu)d.getOrDefault(paramMenu, null);
      Object localObject = localMenu;
      if (localMenu == null)
      {
        localObject = new q(b, (d.i.d.a.a)paramMenu);
        d.put(paramMenu, localObject);
      }
      return (Menu)localObject;
    }
    
    public void a(a parama)
    {
      a.onDestroyActionMode(b(parama));
    }
    
    public boolean a(a parama, Menu paramMenu)
    {
      return a.onPrepareActionMode(b(parama), a(paramMenu));
    }
    
    public boolean a(a parama, MenuItem paramMenuItem)
    {
      return a.onActionItemClicked(b(parama), new l(b, (b)paramMenuItem));
    }
    
    public ActionMode b(a parama)
    {
      int i = c.size();
      for (int j = 0; j < i; j++)
      {
        e locale = (e)c.get(j);
        if ((locale != null) && (b == parama)) {
          return locale;
        }
      }
      parama = new e(b, parama);
      c.add(parama);
      return parama;
    }
    
    public boolean b(a parama, Menu paramMenu)
    {
      return a.onCreateActionMode(b(parama), a(paramMenu));
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */