package d.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Iterator;

import d.f.c;

public abstract class j
{
  public static final c<WeakReference<j>> x = new c();
  public static final Object y = new Object();
  
  public static j a(Activity paramActivity, i parami)
  {
    return new k(paramActivity, null, parami, paramActivity);
  }
  
  public static j a(Dialog paramDialog, i parami)
  {
    return new k(paramDialog.getContext(), paramDialog.getWindow(), parami, paramDialog);
  }
  
  public static void a(j paramj)
  {
    synchronized (y)
    {
      c(paramj);
      c localc = x;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(paramj);
      localc.add(localWeakReference);
      return;
    }
  }
  
  public static void b(j paramj)
  {
    synchronized (y)
    {
      c(paramj);
      return;
    }
  }
  
  public static void c(j paramj)
  {
    synchronized (y)
    {
      Iterator localIterator = x.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)((WeakReference)localIterator.next()).get();
        if ((localj == paramj) || (localj == null)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
  
  public abstract void a();
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract boolean a(int paramInt);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void c();
}

/* Location:
 * Qualified Name:     base.d.b.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */