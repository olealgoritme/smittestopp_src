package d.b.d.i;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.layout;
import d.b.e.d0;
import d.b.e.i0;
import d.b.e.k0;

public final class s
  extends m
  implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, o, View.OnKeyListener
{
  public static final int S = R.layout.abc_popup_menu_item_layout;
  public final g A;
  public final boolean B;
  public final int C;
  public final int D;
  public final int E;
  public final k0 F;
  public final ViewTreeObserver.OnGlobalLayoutListener G = new a();
  public final View.OnAttachStateChangeListener H = new b();
  public PopupWindow.OnDismissListener I;
  public View J;
  public View K;
  public o.a L;
  public ViewTreeObserver M;
  public boolean N;
  public boolean O;
  public int P;
  public int Q = 0;
  public boolean R;
  public final Context y;
  public final h z;
  
  public s(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    y = paramContext;
    z = paramh;
    B = paramBoolean;
    A = new g(paramh, LayoutInflater.from(paramContext), B, S);
    D = paramInt1;
    E = paramInt2;
    Resources localResources = paramContext.getResources();
    C = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    J = paramView;
    F = new k0(y, null, D, E);
    paramh.a(this, paramContext);
  }
  
  public void a()
  {
    boolean bool = e();
    int i = 0;
    if (bool) {}
    int j;
    for (;;)
    {
      j = 1;
      break;
      j = i;
      if (N) {
        break;
      }
      Object localObject1 = J;
      if (localObject1 == null)
      {
        j = i;
        break;
      }
      K = ((View)localObject1);
      F.Y.setOnDismissListener(this);
      localObject1 = F;
      P = this;
      ((i0)localObject1).a(true);
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
        P = m.a(A, null, y, C);
        O = true;
      }
      F.a(P);
      F.Y.setInputMethodMode(2);
      localObject1 = F;
      W = x;
      ((i0)localObject1).a();
      d0 locald0 = F.z;
      locald0.setOnKeyListener(this);
      if ((R) && (z.m != null))
      {
        localObject2 = (FrameLayout)LayoutInflater.from(y).inflate(R.layout.abc_popup_menu_header_item_layout, locald0, false);
        localObject1 = (TextView)((FrameLayout)localObject2).findViewById(16908310);
        if (localObject1 != null) {
          ((TextView)localObject1).setText(z.m);
        }
        ((FrameLayout)localObject2).setEnabled(false);
        locald0.addHeaderView((View)localObject2, null, false);
      }
      F.a(A);
      F.a();
    }
    if (j != 0) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
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
  
  public void a(h paramh) {}
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (paramh != z) {
      return;
    }
    dismiss();
    o.a locala = L;
    if (locala != null) {
      locala.a(paramh, paramBoolean);
    }
  }
  
  public void a(o.a parama)
  {
    L = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    O = false;
    g localg = A;
    if (localg != null) {
      localg.notifyDataSetChanged();
    }
  }
  
  public boolean a(t paramt)
  {
    if (paramt.hasVisibleItems())
    {
      Object localObject1 = new n(y, paramt, K, B, D, E);
      ((n)localObject1).a(L);
      boolean bool = m.b(paramt);
      h = bool;
      Object localObject2 = j;
      if (localObject2 != null) {
        ((m)localObject2).b(bool);
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
      if ((Gravity.getAbsoluteGravity(Q, d.i.i.n.i(J)) & 0x7) == 5) {
        k = i + J.getWidth();
      }
      if (!((n)localObject1).b())
      {
        if (f == null) {
          j = 0;
        } else {
          ((n)localObject1).a(k, j, true, true);
        }
      }
      else {
        j = 1;
      }
      if (j != 0)
      {
        localObject1 = L;
        if (localObject1 != null) {
          ((o.a)localObject1).a(paramt);
        }
        return true;
      }
    }
    return false;
  }
  
  public ListView b()
  {
    return F.z;
  }
  
  public void b(int paramInt)
  {
    F.C = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    A.z = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    k0 localk0 = F;
    D = paramInt;
    F = true;
  }
  
  public void c(boolean paramBoolean)
  {
    R = paramBoolean;
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
    if (e()) {
      F.dismiss();
    }
  }
  
  public boolean e()
  {
    boolean bool;
    if ((!N) && (F.e())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
  
  public class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public a() {}
    
    public void onGlobalLayout()
    {
      if (e())
      {
        Object localObject = s.this;
        if (!F.X)
        {
          localObject = K;
          if ((localObject != null) && (((View)localObject).isShown())) {
            F.a();
          } else {
            dismiss();
          }
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
      Object localObject = M;
      if (localObject != null)
      {
        if (!((ViewTreeObserver)localObject).isAlive()) {
          M = paramView.getViewTreeObserver();
        }
        localObject = s.this;
        M.removeGlobalOnLayoutListener(G);
      }
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */