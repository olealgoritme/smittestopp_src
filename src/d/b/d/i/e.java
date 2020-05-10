package d.b.d.i;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import androidx.appcompat.R.layout;
import androidx.appcompat.app.AlertController.b;
import androidx.appcompat.view.menu.ExpandedMenuView;

import d.b.a.g.a;

public class e
  implements m, AdapterView.OnItemClickListener
{
  public ExpandedMenuView A;
  public int B;
  public int C;
  public int D;
  public m.a E;
  public e.a F;
  public Context x;
  public LayoutInflater y;
  public g z;
  
  public e(Context paramContext, int paramInt)
  {
    D = paramInt;
    C = 0;
    x = paramContext;
    y = LayoutInflater.from(paramContext);
  }
  
  public ListAdapter a()
  {
    if (F == null) {
      F = new e.a(this);
    }
    return F;
  }
  
  public void a(Context paramContext, g paramg)
  {
    if (C != 0)
    {
      paramContext = new ContextThemeWrapper(paramContext, C);
      x = paramContext;
      y = LayoutInflater.from(paramContext);
    }
    else if (x != null)
    {
      x = paramContext;
      if (y == null) {
        y = LayoutInflater.from(paramContext);
      }
    }
    z = paramg;
    paramContext = F;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      A.restoreHierarchyState(paramParcelable);
    }
  }
  
  public void a(g paramg, boolean paramBoolean)
  {
    m.a locala = E;
    if (locala != null) {
      locala.a(paramg, paramBoolean);
    }
  }
  
  public void a(m.a parama)
  {
    E = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    e.a locala = F;
    if (locala != null) {
      locala.notifyDataSetChanged();
    }
  }
  
  public boolean a(g paramg, i parami)
  {
    return false;
  }
  
  public boolean a(r paramr)
  {
    if (!paramr.hasVisibleItems()) {
      return false;
    }
    Object localObject1 = new h(paramr);
    Object localObject2 = x;
    g.a locala = new g.a(a);
    Object localObject3 = new e(a.a, R.layout.abc_list_menu_item_layout);
    z = ((e)localObject3);
    E = ((m.a)localObject1);
    Object localObject4 = x;
    ((g)localObject4).a((m)localObject3, a);
    localObject3 = z.a();
    localObject4 = a;
    l = ((ListAdapter)localObject3);
    m = ((DialogInterface.OnClickListener)localObject1);
    localObject3 = o;
    if (localObject3 != null)
    {
      g = ((View)localObject3);
    }
    else
    {
      d = n;
      f = m;
    }
    a.k = ((DialogInterface.OnKeyListener)localObject1);
    localObject2 = locala.a();
    y = ((d.b.a.g)localObject2);
    ((Dialog)localObject2).setOnDismissListener((DialogInterface.OnDismissListener)localObject1);
    localObject2 = y.getWindow().getAttributes();
    type = 1003;
    flags |= 0x20000;
    y.show();
    localObject1 = E;
    if (localObject1 != null) {
      ((m.a)localObject1).a(paramr);
    }
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(g paramg, i parami)
  {
    return false;
  }
  
  public Parcelable d()
  {
    if (A == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    ExpandedMenuView localExpandedMenuView = A;
    if (localExpandedMenuView != null) {
      localExpandedMenuView.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    z.a(F.getItem(paramInt), this, 0);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */