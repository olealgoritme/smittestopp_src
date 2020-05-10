package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionMenuView.a;
import d.b.a.r;
import d.b.d.i.g;
import d.b.d.i.g.b;
import d.b.d.i.i;
import d.b.d.i.n.a;
import d.b.e.h0;
import d.b.e.z;

public class ActionMenuItemView
  extends z
  implements n.a, View.OnClickListener, ActionMenuView.a
{
  public i B;
  public CharSequence C;
  public Drawable D;
  public g.b E;
  public h0 F;
  public ActionMenuItemView.b G;
  public boolean H;
  public boolean I;
  public int J;
  public int K;
  public int L;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    H = e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    J = paramContext.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    L = ((int)(getDisplayMetricsdensity * 32.0F + 0.5F));
    setOnClickListener(this);
    K = -1;
    setSaveEnabled(false);
  }
  
  public void a(i parami, int paramInt)
  {
    B = parami;
    setIcon(parami.getIcon());
    CharSequence localCharSequence;
    if (c()) {
      localCharSequence = parami.getTitleCondensed();
    } else {
      localCharSequence = e;
    }
    setTitle(localCharSequence);
    setId(a);
    if (parami.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setEnabled(parami.isEnabled());
    if ((parami.hasSubMenu()) && (F == null)) {
      F = new ActionMenuItemView.a(this);
    }
  }
  
  public boolean a()
  {
    return d();
  }
  
  public boolean b()
  {
    boolean bool;
    if ((d()) && (B.getIcon() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return TextUtils.isEmpty(getText()) ^ true;
  }
  
  public final boolean e()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int i = screenWidthDp;
    int j = screenHeightDp;
    boolean bool;
    if ((i < 480) && ((i < 640) || (j < 480)) && (orientation != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final void f()
  {
    boolean bool = TextUtils.isEmpty(C);
    int i = 1;
    int j = i;
    if (D != null)
    {
      if ((B.y & 0x4) == 4) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        j = i;
        if (H) {
          break label66;
        }
        if (I)
        {
          j = i;
          break label66;
        }
      }
      j = 0;
    }
    label66:
    j = (bool ^ true) & j;
    Object localObject1 = null;
    if (j != 0) {
      localObject2 = C;
    } else {
      localObject2 = null;
    }
    setText((CharSequence)localObject2);
    Object localObject2 = B.q;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (j != 0) {
        localObject2 = null;
      } else {
        localObject2 = B.e;
      }
      setContentDescription((CharSequence)localObject2);
    }
    else
    {
      setContentDescription((CharSequence)localObject2);
    }
    localObject2 = B.r;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (j != 0) {
        localObject2 = localObject1;
      } else {
        localObject2 = B.e;
      }
      r.a(this, (CharSequence)localObject2);
    }
    else
    {
      r.a(this, (CharSequence)localObject2);
    }
  }
  
  public i getItemData()
  {
    return B;
  }
  
  public void onClick(View paramView)
  {
    paramView = E;
    if (paramView != null) {
      paramView.a(B);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    H = e();
    f();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = d();
    if (bool)
    {
      i = K;
      if (i >= 0) {
        super.setPadding(i, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == Integer.MIN_VALUE) {
      paramInt1 = Math.min(paramInt1, J);
    } else {
      paramInt1 = J;
    }
    if ((i != 1073741824) && (J > 0) && (j < paramInt1)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
    }
    if ((!bool) && (D != null)) {
      super.setPadding((getMeasuredWidth() - D.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (B.hasSubMenu())
    {
      h0 localh0 = F;
      if ((localh0 != null) && (localh0.onTouch(this, paramMotionEvent))) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (I != paramBoolean)
    {
      I = paramBoolean;
      i locali = B;
      if (locali != null) {
        n.h();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    D = paramDrawable;
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      int k = L;
      int m = i;
      int n = j;
      float f;
      if (i > k)
      {
        f = k / i;
        n = (int)(j * f);
        m = k;
      }
      j = L;
      i = m;
      k = n;
      if (n > j)
      {
        f = j / n;
        i = (int)(m * f);
        k = j;
      }
      paramDrawable.setBounds(0, 0, i, k);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    f();
  }
  
  public void setItemInvoker(g.b paramb)
  {
    E = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    K = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(ActionMenuItemView.b paramb)
  {
    G = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    C = paramCharSequence;
    f();
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.view.menu.ActionMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */