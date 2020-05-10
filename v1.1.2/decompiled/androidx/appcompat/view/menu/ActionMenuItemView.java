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
import d.b.a.s;
import d.b.d.i.h;
import d.b.d.i.h.b;
import d.b.d.i.j;
import d.b.d.i.n;
import d.b.d.i.p.a;
import d.b.d.i.r;
import d.b.e.c;
import d.b.e.c.b;
import d.b.e.f0;
import d.b.e.y;

public class ActionMenuItemView
  extends y
  implements p.a, View.OnClickListener, ActionMenuView.a
{
  public j A;
  public CharSequence B;
  public Drawable C;
  public h.b D;
  public f0 E;
  public b F;
  public boolean G;
  public boolean H;
  public int I;
  public int J;
  public int K;
  
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
    G = e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    I = paramContext.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    K = ((int)(getDisplayMetricsdensity * 32.0F + 0.5F));
    setOnClickListener(this);
    J = -1;
    setSaveEnabled(false);
  }
  
  public void a(j paramj, int paramInt)
  {
    A = paramj;
    setIcon(paramj.getIcon());
    CharSequence localCharSequence;
    if (b()) {
      localCharSequence = paramj.getTitleCondensed();
    } else {
      localCharSequence = e;
    }
    setTitle(localCharSequence);
    setId(a);
    if (paramj.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setEnabled(paramj.isEnabled());
    if ((paramj.hasSubMenu()) && (E == null)) {
      E = new a();
    }
  }
  
  public boolean a()
  {
    return d();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    boolean bool;
    if ((d()) && (A.getIcon() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
    boolean bool = TextUtils.isEmpty(B);
    int i = 1;
    int j = i;
    if (C != null)
    {
      if ((A.y & 0x4) == 4) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        j = i;
        if (G) {
          break label66;
        }
        if (H)
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
      localObject2 = B;
    } else {
      localObject2 = null;
    }
    setText((CharSequence)localObject2);
    Object localObject2 = A.q;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (j != 0) {
        localObject2 = null;
      } else {
        localObject2 = A.e;
      }
      setContentDescription((CharSequence)localObject2);
    }
    else
    {
      setContentDescription((CharSequence)localObject2);
    }
    localObject2 = A.r;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (j != 0) {
        localObject2 = localObject1;
      } else {
        localObject2 = A.e;
      }
      s.a(this, (CharSequence)localObject2);
    }
    else
    {
      s.a(this, (CharSequence)localObject2);
    }
  }
  
  public j getItemData()
  {
    return A;
  }
  
  public void onClick(View paramView)
  {
    paramView = D;
    if (paramView != null) {
      paramView.a(A);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    G = e();
    f();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = d();
    if (bool)
    {
      i = J;
      if (i >= 0) {
        super.setPadding(i, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == Integer.MIN_VALUE) {
      paramInt1 = Math.min(paramInt1, I);
    } else {
      paramInt1 = I;
    }
    if ((i != 1073741824) && (I > 0) && (j < paramInt1)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
    }
    if ((!bool) && (C != null)) {
      super.setPadding((getMeasuredWidth() - C.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (A.hasSubMenu())
    {
      f0 localf0 = E;
      if ((localf0 != null) && (localf0.onTouch(this, paramMotionEvent))) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (H != paramBoolean)
    {
      H = paramBoolean;
      j localj = A;
      if (localj != null) {
        n.h();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    C = paramDrawable;
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      int k = K;
      int m = i;
      int n = j;
      float f;
      if (i > k)
      {
        f = k / i;
        n = (int)(j * f);
        m = k;
      }
      j = K;
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
  
  public void setItemInvoker(h.b paramb)
  {
    D = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    J = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    F = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    B = paramCharSequence;
    f();
  }
  
  public class a
    extends f0
  {
    public a()
    {
      super();
    }
    
    public r b()
    {
      Object localObject1 = F;
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if (localObject1 != null)
      {
        localObject1 = a.T;
        localObject3 = localObject2;
        if (localObject1 != null) {
          localObject3 = ((n)localObject1).a();
        }
      }
      return (r)localObject3;
    }
    
    public boolean c()
    {
      Object localObject = ActionMenuItemView.this;
      h.b localb = D;
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (localb != null)
      {
        bool2 = bool1;
        if (localb.a(A))
        {
          localObject = b();
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((r)localObject).e()) {
              bool2 = true;
            }
          }
        }
      }
      return bool2;
    }
  }
  
  public static abstract class b {}
}

/* Location:
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */