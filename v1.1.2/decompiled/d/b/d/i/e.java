package d.b.d.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;
import d.b.e.d0;
import d.b.e.i0;
import d.b.e.j0;
import d.b.e.k0;
import d.i.i.n;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends m
  implements o, View.OnKeyListener, PopupWindow.OnDismissListener
{
  public static final int Y = R.layout.abc_cascading_menu_item_layout;
  public final int A;
  public final int B;
  public final boolean C;
  public final Handler D;
  public final List<h> E = new ArrayList();
  public final List<d> F = new ArrayList();
  public final ViewTreeObserver.OnGlobalLayoutListener G = new a();
  public final View.OnAttachStateChangeListener H = new b();
  public final j0 I = new c();
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
  public o.a U;
  public ViewTreeObserver V;
  public PopupWindow.OnDismissListener W;
  public boolean X;
  public final Context y;
  public final int z;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  public void a()
  {
    if (e()) {
      return;
    }
    Object localObject = E.iterator();
    while (((Iterator)localObject).hasNext()) {
      c((h)((Iterator)localObject).next());
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
  
  public void a(h paramh)
  {
    paramh.a(this, y);
    if (e()) {
      c(paramh);
    } else {
      E.add(paramh);
    }
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    int i = F.size();
    for (int j = 0; j < i; j++) {
      if (paramh == F.get(j)).b) {
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
    Object localObject = (d)F.remove(j);
    b.a(this);
    if (X)
    {
      k0 localk0 = a;
      if (localk0 != null)
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
        ((o.a)localObject).a(paramh, true);
      }
      paramh = V;
      if (paramh != null)
      {
        if (paramh.isAlive()) {
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
  
  public void a(o.a parama)
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
        localObject = (g)((HeaderViewListAdapter)localObject).getWrappedAdapter();
      } else {
        localObject = (g)localObject;
      }
      ((g)localObject).notifyDataSetChanged();
    }
  }
  
  public boolean a(t paramt)
  {
    Iterator localIterator = F.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (d)localIterator.next();
      if (paramt == b)
      {
        a.z.requestFocus();
        return true;
      }
    }
    if (paramt.hasVisibleItems())
    {
      paramt.a(this, y);
      if (e()) {
        c(paramt);
      } else {
        E.add(paramt);
      }
      localObject = U;
      if (localObject != null) {
        ((o.a)localObject).a(paramt);
      }
      return true;
    }
    return false;
  }
  
  public ListView b()
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
  
  public void b(int paramInt)
  {
    O = true;
    Q = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    S = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    P = true;
    R = paramInt;
  }
  
  public final void c(h paramh)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(y);
    Object localObject1 = new g(paramh, localLayoutInflater, C, Y);
    if ((!e()) && (S)) {
      z = true;
    } else if (e()) {
      z = m.b(paramh);
    }
    Object localObject2 = y;
    int i = z;
    Object localObject3 = null;
    int j = m.a((ListAdapter)localObject1, null, (Context)localObject2, i);
    k0 localk0 = new k0(y, null, A, B);
    c0 = I;
    P = this;
    Y.setOnDismissListener(this);
    O = L;
    I = K;
    localk0.a(true);
    Y.setInputMethodMode(2);
    localk0.a((ListAdapter)localObject1);
    localk0.a(j);
    I = K;
    Object localObject5;
    int k;
    label289:
    int m;
    if (F.size() > 0)
    {
      localObject1 = F;
      localObject1 = (d)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject5 = b;
      k = ((h)localObject5).size();
      for (i = 0; i < k; i++)
      {
        localObject2 = ((h)localObject5).getItem(i);
        if ((((MenuItem)localObject2).hasSubMenu()) && (paramh == ((MenuItem)localObject2).getSubMenu())) {
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
        localObject3 = (g)((HeaderViewListAdapter)localObject3).getWrappedAdapter();
      }
      else
      {
        localObject3 = (g)localObject3;
        k = 0;
      }
      m = ((g)localObject3).getCount();
      for (i = 0; i < m; i++) {
        if (localObject2 == ((g)localObject3).getItem(i)) {
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
      localObject3 = k0.d0;
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
      if (Build.VERSION.SDK_INT >= 23) {
        Y.setEnterTransition(null);
      }
      localObject4 = F;
      d0 locald0 = getsize1a.z;
      localObject4 = new int[2];
      locald0.getLocationOnScreen((int[])localObject4);
      localObject5 = new Rect();
      M.getWindowVisibleDisplayFrame((Rect)localObject5);
      if (N == 1)
      {
        i = localObject4[0];
        if (locald0.getWidth() + i + j > right) {
          break label660;
        }
      }
      else
      {
        if (localObject4[0] - j >= 0) {
          break label660;
        }
      }
      k = 1;
      break label663;
      label660:
      k = 0;
      label663:
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
        localObject4 = new int[2];
        L.getLocationOnScreen((int[])localObject4);
        localObject5 = new int[2];
        ((View)localObject1).getLocationOnScreen((int[])localObject5);
        if ((K & 0x7) == 5)
        {
          k = localObject4[0];
          localObject4[0] = (L.getWidth() + k);
          k = localObject5[0];
          localObject5[0] = (((View)localObject1).getWidth() + k);
        }
        m = localObject5[0] - localObject4[0];
        k = localObject5[1] - localObject4[1];
      }
      if ((K & 0x5) == 5)
      {
        if (i == 0)
        {
          j = ((View)localObject1).getWidth();
          break label850;
        }
      }
      else
      {
        if (i == 0) {
          break label850;
        }
        j = ((View)localObject1).getWidth();
      }
      i = m + j;
      break label857;
      label850:
      i = m - j;
      label857:
      C = i;
      H = true;
      G = true;
      localk0.b(k);
    }
    else
    {
      if (O) {
        C = Q;
      }
      if (P) {
        localk0.b(R);
      }
      W = x;
    }
    localObject1 = new d(localk0, paramh, N);
    F.add(localObject1);
    localk0.a();
    localObject1 = z;
    ((ListView)localObject1).setOnKeyListener(this);
    if ((localObject2 == null) && (T) && (m != null))
    {
      localObject2 = (FrameLayout)localLayoutInflater.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject1, false);
      localObject4 = (TextView)((FrameLayout)localObject2).findViewById(16908310);
      ((FrameLayout)localObject2).setEnabled(false);
      ((TextView)localObject4).setText(m);
      ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
      localk0.a();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    T = paramBoolean;
  }
  
  public boolean c()
  {
    return false;
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
      d[] arrayOfd = (d[])F.toArray(new d[i]);
      i--;
      while (i >= 0)
      {
        d locald = arrayOfd[i];
        if (a.e()) {
          a.dismiss();
        }
        i--;
      }
    }
  }
  
  public boolean e()
  {
    int i = F.size();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i > 0)
    {
      bool2 = bool1;
      if (F.get(0)).a.e()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void onDismiss()
  {
    int i = F.size();
    for (int j = 0; j < i; j++)
    {
      locald = (d)F.get(j);
      if (!a.e()) {
        break label52;
      }
    }
    d locald = null;
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
  
  public class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public a() {}
    
    public void onGlobalLayout()
    {
      if ((e()) && (F.size() > 0) && (!F.get(0)).a.X))
      {
        Object localObject = M;
        if ((localObject != null) && (((View)localObject).isShown())) {
          localObject = F.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          nexta.a();
          continue;
          dismiss();
        }
      }
    }
  }
  
  public class b
    implements View.OnAttachStateChangeListener
  {
    public b() {}
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      Object localObject = V;
      if (localObject != null)
      {
        if (!((ViewTreeObserver)localObject).isAlive()) {
          V = paramView.getViewTreeObserver();
        }
        localObject = e.this;
        V.removeGlobalOnLayoutListener(G);
      }
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
  
  public class c
    implements j0
  {
    public c() {}
    
    public void a(final h paramh, final MenuItem paramMenuItem)
    {
      Handler localHandler = D;
      final e.d locald = null;
      localHandler.removeCallbacksAndMessages(null);
      int i = F.size();
      for (int j = 0; j < i; j++) {
        if (paramh == F.get(j)).b) {
          break label76;
        }
      }
      j = -1;
      label76:
      if (j == -1) {
        return;
      }
      j++;
      if (j < F.size()) {
        locald = (e.d)F.get(j);
      }
      paramMenuItem = new a(locald, paramMenuItem, paramh);
      long l = SystemClock.uptimeMillis();
      D.postAtTime(paramMenuItem, paramh, l + 200L);
    }
    
    public void b(h paramh, MenuItem paramMenuItem)
    {
      D.removeCallbacksAndMessages(paramh);
    }
    
    public class a
      implements Runnable
    {
      public a(e.d paramd, MenuItem paramMenuItem, h paramh) {}
      
      public void run()
      {
        e.d locald = locald;
        if (locald != null)
        {
          X = true;
          b.a(false);
          X = false;
        }
        if ((paramMenuItem.isEnabled()) && (paramMenuItem.hasSubMenu())) {
          paramh.a(paramMenuItem, 4);
        }
      }
    }
  }
  
  public static class d
  {
    public final k0 a;
    public final h b;
    public final int c;
    
    public d(k0 paramk0, h paramh, int paramInt)
    {
      a = paramk0;
      b = paramh;
      c = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */