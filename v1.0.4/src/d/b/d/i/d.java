package d.b.d.i;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import d.b.e.l0;
import d.b.e.m0;
import d.i.i.n;

public final class d
  extends k
  implements m, View.OnKeyListener, PopupWindow.OnDismissListener
{
  public static final int Y = R.layout.abc_cascading_menu_item_layout;
  public final int A;
  public final int B;
  public final boolean C;
  public final Handler D;
  public final List<g> E = new ArrayList();
  public final List<d.d> F = new ArrayList();
  public final ViewTreeObserver.OnGlobalLayoutListener G = new d.a(this);
  public final View.OnAttachStateChangeListener H = new d.b(this);
  public final l0 I = new d.c(this);
  public int J;
  public int K;
  public View L;
  public View M;
  public int N;
  public boolean O;
  public boolean P;
  public int Q;
  public int R;
  public boolean S;
  public boolean T;
  public m.a U;
  public ViewTreeObserver V;
  public PopupWindow.OnDismissListener W;
  public boolean X;
  public final Context y;
  public final int z;
  
  public d(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    J = 0;
    K = 0;
    y = paramContext;
    L = paramView;
    A = paramInt1;
    B = paramInt2;
    C = paramBoolean;
    S = false;
    if (n.i(paramView) == 1) {
      paramInt1 = i;
    } else {
      paramInt1 = 1;
    }
    N = paramInt1;
    paramContext = paramContext.getResources();
    z = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    D = new Handler();
  }
  
  public void a(int paramInt)
  {
    if (J != paramInt)
    {
      J = paramInt;
      K = Gravity.getAbsoluteGravity(paramInt, n.i(L));
    }
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(View paramView)
  {
    if (L != paramView)
    {
      L = paramView;
      K = Gravity.getAbsoluteGravity(J, n.i(paramView));
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    W = paramOnDismissListener;
  }
  
  public void a(g paramg)
  {
    paramg.a(this, y);
    if (a()) {
      c(paramg);
    } else {
      E.add(paramg);
    }
  }
  
  public void a(g paramg, boolean paramBoolean)
  {
    int i = F.size();
    for (int j = 0; j < i; j++) {
      if (paramg == F.get(j)).b) {
        break label52;
      }
    }
    j = -1;
    label52:
    if (j < 0) {
      return;
    }
    i = j + 1;
    if (i < F.size()) {
      F.get(i)).b.a(false);
    }
    Object localObject = (d.d)F.remove(j);
    b.a(this);
    if (X)
    {
      m0 localm0 = a;
      if (localm0 != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Y.setExitTransition(null);
        }
        a.Y.setAnimationStyle(0);
      }
      else
      {
        throw null;
      }
    }
    a.dismiss();
    i = F.size();
    if (i > 0)
    {
      N = F.get(i - 1)).c;
    }
    else
    {
      if (n.i(L) == 1) {
        j = 0;
      } else {
        j = 1;
      }
      N = j;
    }
    if (i == 0)
    {
      dismiss();
      localObject = U;
      if (localObject != null) {
        ((m.a)localObject).a(paramg, true);
      }
      paramg = V;
      if (paramg != null)
      {
        if (paramg.isAlive()) {
          V.removeGlobalOnLayoutListener(G);
        }
        V = null;
      }
      M.removeOnAttachStateChangeListener(H);
      W.onDismiss();
    }
    else if (paramBoolean)
    {
      F.get(0)).b.a(false);
    }
  }
  
  public void a(m.a parama)
  {
    U = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = F.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = nexta.z.getAdapter();
      if ((localObject instanceof HeaderViewListAdapter)) {
        localObject = (f)((HeaderViewListAdapter)localObject).getWrappedAdapter();
      } else {
        localObject = (f)localObject;
      }
      ((f)localObject).notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    int i = F.size();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i > 0)
    {
      bool2 = bool1;
      if (F.get(0)).a.a()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean a(r paramr)
  {
    Iterator localIterator = F.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (d.d)localIterator.next();
      if (paramr == b)
      {
        a.z.requestFocus();
        return true;
      }
    }
    if (paramr.hasVisibleItems())
    {
      paramr.a(this, y);
      if (a()) {
        c(paramr);
      } else {
        E.add(paramr);
      }
      localObject = U;
      if (localObject != null) {
        ((m.a)localObject).a(paramr);
      }
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    O = true;
    Q = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    S = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (a()) {
      return;
    }
    Object localObject = E.iterator();
    while (((Iterator)localObject).hasNext()) {
      c((g)((Iterator)localObject).next());
    }
    E.clear();
    localObject = L;
    M = ((View)localObject);
    if (localObject != null)
    {
      int i;
      if (V == null) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = M.getViewTreeObserver();
      V = ((ViewTreeObserver)localObject);
      if (i != 0) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(G);
      }
      M.addOnAttachStateChangeListener(H);
    }
  }
  
  public void c(int paramInt)
  {
    P = true;
    R = paramInt;
  }
  
  public final void c(g paramg)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(y);
    Object localObject1 = new f(paramg, localLayoutInflater, C, Y);
    if ((!a()) && (S)) {
      z = true;
    } else if (a()) {
      z = k.b(paramg);
    }
    Object localObject2 = y;
    int i = z;
    Object localObject3 = null;
    int j = k.a((ListAdapter)localObject1, null, (Context)localObject2, i);
    m0 localm0 = new m0(y, null, A, B);
    c0 = I;
    P = this;
    Y.setOnDismissListener(this);
    O = L;
    I = K;
    localm0.a(true);
    Y.setInputMethodMode(2);
    localm0.a((ListAdapter)localObject1);
    localm0.d(j);
    I = K;
    Object localObject5;
    int k;
    label289:
    int m;
    if (F.size() > 0)
    {
      localObject1 = F;
      localObject1 = (d.d)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject5 = b;
      k = ((g)localObject5).size();
      for (i = 0; i < k; i++)
      {
        localObject2 = ((g)localObject5).getItem(i);
        if ((((MenuItem)localObject2).hasSubMenu()) && (paramg == ((MenuItem)localObject2).getSubMenu())) {
          break label289;
        }
      }
      localObject2 = null;
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label477;
      }
      localObject5 = a.z;
      localObject3 = ((ListView)localObject5).getAdapter();
      if ((localObject3 instanceof HeaderViewListAdapter))
      {
        localObject3 = (HeaderViewListAdapter)localObject3;
        k = ((HeaderViewListAdapter)localObject3).getHeadersCount();
        localObject3 = (f)((HeaderViewListAdapter)localObject3).getWrappedAdapter();
      }
      else
      {
        localObject3 = (f)localObject3;
        k = 0;
      }
      m = ((f)localObject3).getCount();
      for (i = 0; i < m; i++) {
        if (localObject2 == ((f)localObject3).getItem(i)) {
          break label405;
        }
      }
      i = -1;
      label405:
      if (i == -1)
      {
        localObject2 = localObject1;
      }
      else
      {
        i = i + k - ((ListView)localObject5).getFirstVisiblePosition();
        localObject2 = localObject1;
        if (i >= 0) {
          if (i >= ((ListView)localObject5).getChildCount())
          {
            localObject2 = localObject1;
          }
          else
          {
            localObject3 = ((ListView)localObject5).getChildAt(i);
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label477;
          }
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = null;
    label477:
    Object localObject4;
    if (localObject1 != null)
    {
      if (Build.VERSION.SDK_INT <= 28)
      {
        localObject3 = m0.d0;
        if (localObject3 != null) {
          try
          {
            ((Method)localObject3).invoke(Y, new Object[] { Boolean.valueOf(false) });
          }
          catch (Exception localException)
          {
            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
          }
        }
      }
      else
      {
        Y.setTouchModal(false);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        Y.setEnterTransition(null);
      }
      localObject4 = F;
      localObject5 = getsize1a.z;
      localObject4 = new int[2];
      ((ListView)localObject5).getLocationOnScreen((int[])localObject4);
      Rect localRect = new Rect();
      M.getWindowVisibleDisplayFrame(localRect);
      if (N == 1)
      {
        i = localObject4[0];
        if (((ListView)localObject5).getWidth() + i + j > right) {
          break label680;
        }
      }
      else
      {
        if (localObject4[0] - j >= 0) {
          break label680;
        }
      }
      k = 1;
      break label683;
      label680:
      k = 0;
      label683:
      if (k == 1) {
        i = 1;
      } else {
        i = 0;
      }
      N = k;
      if (Build.VERSION.SDK_INT >= 26)
      {
        O = ((View)localObject1);
        k = 0;
        m = 0;
      }
      else
      {
        localObject5 = new int[2];
        L.getLocationOnScreen((int[])localObject5);
        localObject4 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject4);
        if ((K & 0x7) == 5)
        {
          k = localObject5[0];
          localObject5[0] = (L.getWidth() + k);
          k = localObject4[0];
          localObject4[0] = (((View)localObject1).getWidth() + k);
        }
        m = localObject4[0] - localObject5[0];
        k = localObject4[1] - localObject5[1];
      }
      if ((K & 0x5) == 5)
      {
        if (i == 0)
        {
          j = ((View)localObject1).getWidth();
          break label870;
        }
      }
      else
      {
        if (i == 0) {
          break label870;
        }
        j = ((View)localObject1).getWidth();
      }
      i = m + j;
      break label877;
      label870:
      i = m - j;
      label877:
      C = i;
      H = true;
      G = true;
      localm0.b(k);
    }
    else
    {
      if (O) {
        C = Q;
      }
      if (P) {
        localm0.b(R);
      }
      localObject1 = x;
      if (localObject1 != null) {
        localObject1 = new Rect((Rect)localObject1);
      } else {
        localObject1 = null;
      }
      W = ((Rect)localObject1);
    }
    localObject1 = new d.d(localm0, paramg, N);
    F.add(localObject1);
    localm0.c();
    localObject1 = z;
    ((ListView)localObject1).setOnKeyListener(this);
    if ((localObject2 == null) && (T) && (m != null))
    {
      localObject2 = (FrameLayout)localLayoutInflater.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject1, false);
      localObject4 = (TextView)((FrameLayout)localObject2).findViewById(16908310);
      ((FrameLayout)localObject2).setEnabled(false);
      ((TextView)localObject4).setText(m);
      ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
      localm0.c();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    T = paramBoolean;
  }
  
  public Parcelable d()
  {
    return null;
  }
  
  public void dismiss()
  {
    int i = F.size();
    if (i > 0)
    {
      d.d[] arrayOfd = (d.d[])F.toArray(new d.d[i]);
      i--;
      while (i >= 0)
      {
        d.d locald = arrayOfd[i];
        if (a.a()) {
          a.dismiss();
        }
        i--;
      }
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public ListView g()
  {
    Object localObject;
    if (F.isEmpty())
    {
      localObject = null;
    }
    else
    {
      localObject = F;
      localObject = getsize1a.z;
    }
    return (ListView)localObject;
  }
  
  public void onDismiss()
  {
    int i = F.size();
    for (int j = 0; j < i; j++)
    {
      locald = (d.d)F.get(j);
      if (!a.a()) {
        break label52;
      }
    }
    d.d locald = null;
    label52:
    if (locald != null) {
      b.a(false);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */