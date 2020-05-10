package d.b.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import d.b.d.a.a;
import d.i.i.c;
import d.i.i.c.a;

public class r
  extends Dialog
  implements i
{
  public j x;
  public final c.a y = new a();
  
  public r(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    a().a(null);
    a().a();
  }
  
  public j a()
  {
    if (x == null) {
      x = new k(getContext(), getWindow(), this);
    }
    return x;
  }
  
  public d.b.d.a a(a.a parama)
  {
    return null;
  }
  
  public void a(d.b.d.a parama) {}
  
  public boolean a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    k localk = (k)a();
    localk.f();
    ((ViewGroup)P.findViewById(16908290)).addView(paramView, paramLayoutParams);
    z.onContentChanged();
  }
  
  public void b(d.b.d.a parama) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return c.a(y, localView, this, paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    k localk = (k)a();
    localk.f();
    return y.findViewById(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a().b();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = (k)a();
    ((k)localObject).i();
    a locala = C;
    if (locala != null) {
      locala.d(false);
    }
    localObject = g0;
    if (localObject != null) {
      ((k.f)localObject).a();
    }
  }
  
  public void setContentView(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
  
  public class a
    implements c.a
  {
    public a() {}
    
    public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return a(paramKeyEvent);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */