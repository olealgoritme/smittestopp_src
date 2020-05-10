package d.b.d.i;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R.layout;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.app.AlertController.b;
import androidx.appcompat.app.AlertController.d;
import androidx.appcompat.view.menu.ExpandedMenuView;
import d.b.a.g;
import java.util.ArrayList;

public class f
  implements o, AdapterView.OnItemClickListener
{
  public ExpandedMenuView A;
  public int B;
  public int C;
  public int D;
  public o.a E;
  public a F;
  public Context x;
  public LayoutInflater y;
  public h z;
  
  public f(Context paramContext, int paramInt)
  {
    D = paramInt;
    C = 0;
    x = paramContext;
    y = LayoutInflater.from(paramContext);
  }
  
  public ListAdapter a()
  {
    if (F == null) {
      F = new a();
    }
    return F;
  }
  
  public void a(Context paramContext, h paramh)
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
    z = paramh;
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
  
  public void a(h paramh, boolean paramBoolean)
  {
    o.a locala = E;
    if (locala != null) {
      locala.a(paramh, paramBoolean);
    }
  }
  
  public void a(o.a parama)
  {
    E = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    a locala = F;
    if (locala != null) {
      locala.notifyDataSetChanged();
    }
  }
  
  public boolean a(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean a(t paramt)
  {
    if (!paramt.hasVisibleItems()) {
      return false;
    }
    i locali = new i(paramt);
    Object localObject1 = x;
    Object localObject2 = a;
    int i = g.a((Context)localObject2, 0);
    localObject2 = new AlertController.b(new ContextThemeWrapper((Context)localObject2, g.a((Context)localObject2, i)));
    Object localObject3 = new f(a, R.layout.abc_list_menu_item_layout);
    z = ((f)localObject3);
    E = locali;
    Object localObject4 = x;
    ((h)localObject4).a((o)localObject3, a);
    j = z.a();
    k = locali;
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
    i = locali;
    localObject3 = new g(a, i);
    localObject4 = z;
    localObject1 = g;
    Object localObject5;
    if (localObject1 != null)
    {
      G = ((View)localObject1);
    }
    else
    {
      localObject5 = f;
      if (localObject5 != null)
      {
        e = ((CharSequence)localObject5);
        localObject1 = E;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localObject5);
        }
      }
      localObject5 = d;
      if (localObject5 != null)
      {
        C = ((Drawable)localObject5);
        B = 0;
        localObject1 = D;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(0);
          D.setImageDrawable((Drawable)localObject5);
        }
      }
      i = c;
      if (i != 0) {
        ((AlertController)localObject4).a(i);
      }
      i = e;
      if (i != 0) {
        if (localObject4 != null)
        {
          localObject1 = new TypedValue();
          a.getTheme().resolveAttribute(i, (TypedValue)localObject1, true);
          ((AlertController)localObject4).a(resourceId);
        }
        else
        {
          throw null;
        }
      }
    }
    if (j != null)
    {
      localObject5 = (AlertController.RecycleListView)b.inflate(L, null);
      i = O;
      localObject1 = j;
      if (localObject1 == null) {
        localObject1 = new AlertController.d(a, i, 16908308, null);
      }
      H = ((ListAdapter)localObject1);
      I = n;
      if (k != null) {
        ((ListView)localObject5).setOnItemClickListener(new d.b.a.f((AlertController.b)localObject2, (AlertController)localObject4));
      }
      g = ((ListView)localObject5);
    }
    ((Dialog)localObject3).setCancelable(h);
    if (h) {
      ((Dialog)localObject3).setCanceledOnTouchOutside(true);
    }
    ((Dialog)localObject3).setOnCancelListener(null);
    ((Dialog)localObject3).setOnDismissListener(null);
    localObject1 = i;
    if (localObject1 != null) {
      ((Dialog)localObject3).setOnKeyListener((DialogInterface.OnKeyListener)localObject1);
    }
    y = ((g)localObject3);
    ((Dialog)localObject3).setOnDismissListener(locali);
    localObject1 = y.getWindow().getAttributes();
    type = 1003;
    flags |= 0x20000;
    y.show();
    localObject1 = E;
    if (localObject1 != null) {
      ((o.a)localObject1).a(paramt);
    }
    return true;
  }
  
  public boolean b(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean c()
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
  
  public class a
    extends BaseAdapter
  {
    public int x = -1;
    
    public a()
    {
      a();
    }
    
    public void a()
    {
      Object localObject = z;
      j localj = w;
      if (localj != null)
      {
        ((h)localObject).a();
        localObject = j;
        int i = ((ArrayList)localObject).size();
        for (int j = 0; j < i; j++) {
          if ((j)((ArrayList)localObject).get(j) == localj)
          {
            x = j;
            return;
          }
        }
      }
      x = -1;
    }
    
    public int getCount()
    {
      h localh = z;
      localh.a();
      int i = j.size() - B;
      if (x < 0) {
        return i;
      }
      return i - 1;
    }
    
    public j getItem(int paramInt)
    {
      Object localObject = z;
      ((h)localObject).a();
      localObject = j;
      int i = paramInt + B;
      int j = x;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (j)((ArrayList)localObject).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        paramView = f.this;
        localView = y.inflate(D, paramViewGroup, false);
      }
      ((p.a)localView).a(getItem(paramInt), 0);
      return localView;
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */