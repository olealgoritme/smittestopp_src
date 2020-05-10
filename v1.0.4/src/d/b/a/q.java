package d.b.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.R.attr;

import d.b.d.a;
import d.i.i.c;
import d.i.i.c.a;

public class q
  extends Dialog
  implements i
{
  public j x;
  public final c.a y = new q.a(this);
  
  public q(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    Object localObject = a();
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(R.attr.dialogTheme, localTypedValue, true);
      i = resourceId;
    }
    k0 = i;
    ((j)localObject).a(null);
  }
  
  public j a()
  {
    if (x == null) {
      x = j.a(this, this);
    }
    return x;
  }
  
  public a a(a.a parama)
  {
    return null;
  }
  
  public void a(a parama) {}
  
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
    a().a(paramView, paramLayoutParams);
  }
  
  public void b(a parama) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return c.a(y, localView, this, paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    k localk = (k)a();
    localk.f();
    return B.findViewById(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a().a();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  public void onStop()
  {
    super.onStop();
    a().c();
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
    a().b(paramView, paramLayoutParams);
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
}

/* Location:
 * Qualified Name:     base.d.b.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */