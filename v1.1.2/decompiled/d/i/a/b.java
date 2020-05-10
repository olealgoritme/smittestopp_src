package d.i.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import d.f.h;
import d.i.i.c;
import d.i.i.c.a;
import d.i.i.n;
import d.o.g;
import d.o.g.b;
import d.o.l;
import d.o.m;
import d.o.v;

public class b
  extends Activity
  implements l, c.a
{
  public h<Class<? extends a>, a> mExtraDataMap = new h();
  public m mLifecycleRegistry = new m(this);
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (n.b(localView, paramKeyEvent))) {
      return true;
    }
    return c.a(this, localView, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (n.b(localView, paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  @Deprecated
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)mExtraDataMap.getOrDefault(paramClass, null);
  }
  
  public g getLifecycle()
  {
    throw null;
  }
  
  @SuppressLint({"RestrictedApi"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    v.b(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    mLifecycleRegistry.a(g.b.CREATED);
    super.onSaveInstanceState(paramBundle);
  }
  
  @Deprecated
  public void putExtraData(a parama)
  {
    mExtraDataMap.put(parama.getClass(), parama);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @Deprecated
  public static class a {}
}

/* Location:
 * Qualified Name:     d.i.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */