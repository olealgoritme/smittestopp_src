package d.b.d.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;

import d.b.e.k0;
import d.b.e.m0;
import d.i.i.n;

public final class q
  extends k
  implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener
{
  public static final int S = R.layout.abc_popup_menu_item_layout;
  public final f A;
  public final boolean B;
  public final int C;
  public final int D;
  public final int E;
  public final m0 F;
  public final ViewTreeObserver.OnGlobalLayoutListener G = new q.a(this);
  public final View.OnAttachStateChangeListener H = new q.b(this);
  public PopupWindow.OnDismissListener I;
  public View J;
  public View K;
  public m.a L;
  public ViewTreeObserver M;
  public boolean N;
  public boolean O;
  public int P;
  public int Q = 0;
  public boolean R;
  public final Context y;
  public final g z;
  
  public q(Context paramContext, g paramg, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    y = paramContext;
    z = paramg;
    B = paramBoolean;
    A = new f(paramg, LayoutInflater.from(paramContext), B, S);
    D = paramInt1;
    E = paramInt2;
    Resources localResources = paramContext.getResources();
    C = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    J = paramView;
    F = new m0(y, null, D, E);
    paramg.a(this, paramContext);
  }
  
  public void a(int paramInt)
  {
    Q = paramInt;
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(View paramView)
  {
    J = paramView;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    I = paramOnDismissListener;
  }
  
  public void a(g paramg) {}
  
  public void a(g paramg, boolean paramBoolean)
  {
    if (paramg != z) {
      return;
    }
    dismiss();
    m.a locala = L;
    if (locala != null) {
      locala.a(paramg, paramBoolean);
    }
  }
  
  public void a(m.a parama)
  {
    L = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    O = false;
    f localf = A;
    if (localf != null) {
      localf.notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if ((!N) && (F.a())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(r paramr)
  {
    if (paramr.hasVisibleItems())
    {
      Object localObject1 = new l(y, paramr, K, B, D, E);
      ((l)localObject1).a(L);
      boolean bool = k.b(paramr);
      h = bool;
      Object localObject2 = j;
      if (localObject2 != null) {
        ((k)localObject2).b(bool);
      }
      k = I;
      I = null;
      z.a(false);
      localObject2 = F;
      int i = C;
      int j;
      if (!F) {
        j = 0;
      } else {
        j = D;
      }
      int k = i;
      if ((Gravity.getAbsoluteGravity(Q, n.i(J)) & 0x7) == 5) {
        k = i + J.getWidth();
      }
      if (!((l)localObject1).b())
      {
        if (f == null) {
          j = 0;
        } else {
          ((l)localObject1).a(k, j, true, true);
        }
      }
      else {
        j = 1;
      }
      if (j != 0)
      {
        localObject1 = L;
        if (localObject1 != null) {
          ((m.a)localObject1).a(paramr);
        }
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    F.C = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    A.z = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    boolean bool = a();
    int i = 0;
    if (bool) {}
    int j;
    for (;;)
    {
      j = 1;
      break label381;
      j = i;
      if (N) {
        break label381;
      }
      Object localObject1 = J;
      if (localObject1 == null)
      {
        j = i;
        break label381;
      }
      K = ((View)localObject1);
      F.Y.setOnDismissListener(this);
      localObject1 = F;
      P = this;
      ((k0)localObject1).a(true);
      localObject1 = K;
      if (M == null) {
        j = 1;
      } else {
        j = 0;
      }
      Object localObject2 = ((View)localObject1).getViewTreeObserver();
      M = ((ViewTreeObserver)localObject2);
      if (j != 0) {
        ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener(G);
      }
      ((View)localObject1).addOnAttachStateChangeListener(H);
      localObject2 = F;
      O = ((View)localObject1);
      I = Q;
      if (!O)
      {
        P = k.a(A, null, y, C);
        O = true;
      }
      F.d(P);
      F.Y.setInputMethodMode(2);
      localObject2 = F;
      localObject1 = x;
      if (localObject2 == null) {
        break;
      }
      if (localObject1 != null) {
        localObject1 = new Rect((Rect)localObject1);
      } else {
        localObject1 = null;
      }
      W = ((Rect)localObject1);
      F.c();
      localObject2 = F.z;
      ((ListView)localObject2).setOnKeyListener(this);
      if ((R) && (z.m != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(y).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
        localObject1 = (TextView)localFrameLayout.findViewById(16908310);
        if (localObject1 != null) {
          ((TextView)localObject1).setText(z.m);
        }
        localFrameLayout.setEnabled(false);
        ((ListView)localObject2).addHeaderView(localFrameLayout, null, false);
      }
      F.a(A);
      F.c();
    }
    throw null;
    label381:
    if (j != 0) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void c(int paramInt)
  {
    m0 localm0 = F;
    D = paramInt;
    F = true;
  }
  
  public void c(boolean paramBoolean)
  {
    R = paramBoolean;
  }
  
  public Parcelable d()
  {
    return null;
  }
  
  public void dismiss()
  {
    if (a()) {
      F.dismiss();
    }
  }
  
  public ListView g()
  {
    return F.z;
  }
  
  public void onDismiss()
  {
    N = true;
    z.a(true);
    Object localObject = M;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        M = K.getViewTreeObserver();
      }
      M.removeGlobalOnLayoutListener(G);
      M = null;
    }
    K.removeOnAttachStateChangeListener(H);
    localObject = I;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
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
 * Qualified Name:     base.d.b.d.i.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */