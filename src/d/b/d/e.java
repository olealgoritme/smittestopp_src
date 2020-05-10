package d.b.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import d.b.d.i.o;

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
    return new o(a, (d.i.d.a.a)b.c());
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
}

/* Location:
 * Qualified Name:     base.d.b.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */