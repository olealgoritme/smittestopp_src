package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import d.o.g;
import d.o.g.a;
import d.o.j;
import d.o.m;
import d.s.b;
import d.s.i;
import d.s.n;
import d.s.p.a;
import d.s.p.b;

@p.b("dialog")
public final class DialogFragmentNavigator
  extends d.s.p<a>
{
  public final Context a;
  public final d.m.a.p b;
  public int c = 0;
  public j d = new j()
  {
    public void a(d.o.l paramAnonymousl, g.a paramAnonymousa)
    {
      if (paramAnonymousa == g.a.ON_STOP)
      {
        paramAnonymousl = (DialogFragment)paramAnonymousl;
        paramAnonymousa = G;
        if (paramAnonymousa != null)
        {
          if (!paramAnonymousa.isShowing()) {
            NavHostFragment.a(paramAnonymousl).b();
          }
        }
        else
        {
          paramAnonymousa = new StringBuilder();
          paramAnonymousa.append("DialogFragment ");
          paramAnonymousa.append(paramAnonymousl);
          paramAnonymousa.append(" does not have a Dialog.");
          throw new IllegalStateException(paramAnonymousa.toString());
        }
      }
    }
  };
  
  public DialogFragmentNavigator(Context paramContext, d.m.a.p paramp)
  {
    a = paramContext;
    b = paramp;
  }
  
  public i a()
  {
    return new a(this);
  }
  
  public i a(i parami, Bundle paramBundle, n paramn, p.a parama)
  {
    paramn = (a)parami;
    if (b.i())
    {
      Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
      parami = null;
    }
    else
    {
      parama = F;
      if (parama == null) {
        break label225;
      }
      parami = parama;
      if (parama.charAt(0) == '.')
      {
        parami = new StringBuilder();
        parami.append(a.getPackageName());
        parami.append(parama);
        parami = parami.toString();
      }
      parami = b.h().a(a.getClassLoader(), parami);
      if (!DialogFragment.class.isAssignableFrom(parami.getClass()))
      {
        parami = e.a.a.a.a.a("Dialog destination ");
        paramBundle = F;
        if (paramBundle != null) {
          throw new IllegalArgumentException(e.a.a.a.a.a(parami, paramBundle, " is not an instance of DialogFragment"));
        }
        throw new IllegalStateException("DialogFragment class was not set");
      }
      parami = (DialogFragment)parami;
      parami.setArguments(paramBundle);
      parami.getLifecycle().a(d);
      paramBundle = b;
      parama = e.a.a.a.a.a("androidx-nav-fragment:navigator:dialog:");
      int i = c;
      c = (i + 1);
      parama.append(i);
      parami.a(paramBundle, parama.toString());
      parami = paramn;
    }
    return parami;
    label225:
    throw new IllegalStateException("DialogFragment class was not set");
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = 0;
      c = paramBundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
      while (i < c)
      {
        d.m.a.p localp = b;
        paramBundle = new StringBuilder();
        paramBundle.append("androidx-nav-fragment:navigator:dialog:");
        paramBundle.append(i);
        paramBundle = (DialogFragment)localp.b(paramBundle.toString());
        if (paramBundle != null)
        {
          paramBundle.getLifecycle().a(d);
          i++;
        }
        else
        {
          throw new IllegalStateException(e.a.a.a.a.b("DialogFragment ", i, " doesn't exist in the FragmentManager"));
        }
      }
    }
  }
  
  public Bundle b()
  {
    if (c == 0) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("androidx-nav-dialogfragment:navigator:count", c);
    return localBundle;
  }
  
  public boolean c()
  {
    if (c == 0) {
      return false;
    }
    if (b.i())
    {
      Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
      return false;
    }
    Object localObject1 = b;
    Object localObject2 = e.a.a.a.a.a("androidx-nav-fragment:navigator:dialog:");
    int i = c - 1;
    c = i;
    ((StringBuilder)localObject2).append(i);
    localObject2 = ((d.m.a.p)localObject1).b(((StringBuilder)localObject2).toString());
    if (localObject2 != null)
    {
      localObject1 = ((Fragment)localObject2).getLifecycle();
      j localj = d;
      a.remove(localj);
      ((DialogFragment)localObject2).a(false, false);
    }
    return true;
  }
  
  public static class a
    extends i
    implements b
  {
    public String F;
    
    public a(d.s.p<? extends a> paramp)
    {
      super();
    }
    
    public void a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super.a(paramContext, paramAttributeSet);
      paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.DialogFragmentNavigator);
      paramContext = paramAttributeSet.getString(R.styleable.DialogFragmentNavigator_android_name);
      if (paramContext != null) {
        F = paramContext;
      }
      paramAttributeSet.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     androidx.navigation.fragment.DialogFragmentNavigator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */