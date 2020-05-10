package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.styleable;
import d.b.d.i.b;
import d.b.d.i.g;
import d.b.e.c;
import d.b.e.d1;

public class ActionBarContextView
  extends d.b.e.a
{
  public CharSequence F;
  public CharSequence G;
  public View H;
  public View I;
  public LinearLayout J;
  public TextView K;
  public TextView L;
  public int M;
  public int N;
  public boolean O;
  public int P;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    paramInt = R.styleable.ActionMode_background;
    if (paramAttributeSet.hasValue(paramInt))
    {
      int i = paramAttributeSet.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = d.b.b.a.a.c(paramContext, i);
        break label59;
      }
    }
    paramContext = paramAttributeSet.getDrawable(paramInt);
    label59:
    d.i.i.n.a(this, paramContext);
    M = paramAttributeSet.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    N = paramAttributeSet.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    B = paramAttributeSet.getLayoutDimension(R.styleable.ActionMode_height, 0);
    P = paramAttributeSet.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    paramAttributeSet.recycle();
  }
  
  public final void a()
  {
    if (J == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      localObject = (LinearLayout)getChildAt(getChildCount() - 1);
      J = ((LinearLayout)localObject);
      K = ((TextView)((LinearLayout)localObject).findViewById(R.id.action_bar_title));
      L = ((TextView)J.findViewById(R.id.action_bar_subtitle));
      if (M != 0) {
        K.setTextAppearance(getContext(), M);
      }
      if (N != 0) {
        L.setTextAppearance(getContext(), N);
      }
    }
    K.setText(F);
    L.setText(G);
    boolean bool1 = TextUtils.isEmpty(F);
    boolean bool2 = TextUtils.isEmpty(G) ^ true;
    Object localObject = L;
    int i = 0;
    if (bool2) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject).setVisibility(j);
    localObject = J;
    int j = i;
    if (!(bool1 ^ true)) {
      if (bool2) {
        j = i;
      } else {
        j = 8;
      }
    }
    ((LinearLayout)localObject).setVisibility(j);
    if (J.getParent() == null) {
      addView(J);
    }
  }
  
  public void a(d.b.d.a parama)
  {
    Object localObject = H;
    if (localObject == null)
    {
      localObject = LayoutInflater.from(getContext()).inflate(P, this, false);
      H = ((View)localObject);
      addView((View)localObject);
    }
    else if (((View)localObject).getParent() == null)
    {
      addView(H);
    }
    H.findViewById(R.id.action_mode_close_button).setOnClickListener(new ActionBarContextView.a(this, parama));
    localObject = (g)parama.c();
    parama = A;
    if (parama != null) {
      parama.a();
    }
    parama = new c(getContext());
    A = parama;
    J = true;
    K = true;
    parama = new ViewGroup.LayoutParams(-2, -1);
    ((g)localObject).a(A, y);
    localObject = A;
    d.b.d.i.n localn1 = E;
    if (localn1 == null)
    {
      localn2 = (d.b.d.i.n)A.inflate(C, this, false);
      E = localn2;
      localn2.a(z);
      ((b)localObject).a(true);
    }
    d.b.d.i.n localn2 = E;
    if (localn1 != localn2) {
      ((ActionMenuView)localn2).setPresenter((c)localObject);
    }
    localObject = (ActionMenuView)localn2;
    z = ((ActionMenuView)localObject);
    d.i.i.n.a((View)localObject, null);
    addView(z, parama);
  }
  
  public void b()
  {
    removeAllViews();
    I = null;
    z = null;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return G;
  }
  
  public CharSequence getTitle()
  {
    return F;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c localc = A;
    if (localc != null)
    {
      localc.c();
      A.e();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(ActionBarContextView.class.getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(F);
    }
    else
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = d1.a(this);
    int i;
    if (paramBoolean) {
      i = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    Object localObject = H;
    paramInt2 = i;
    if (localObject != null)
    {
      paramInt2 = i;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (ViewGroup.MarginLayoutParams)H.getLayoutParams();
        if (paramBoolean) {
          paramInt4 = rightMargin;
        } else {
          paramInt4 = leftMargin;
        }
        if (paramBoolean) {
          paramInt2 = leftMargin;
        } else {
          paramInt2 = rightMargin;
        }
        if (paramBoolean) {
          paramInt4 = i - paramInt4;
        } else {
          paramInt4 = i + paramInt4;
        }
        paramInt4 += a(H, paramInt4, j, k, paramBoolean);
        if (paramBoolean) {
          paramInt2 = paramInt4 - paramInt2;
        } else {
          paramInt2 = paramInt4 + paramInt2;
        }
      }
    }
    paramInt4 = paramInt2;
    localObject = J;
    paramInt2 = paramInt4;
    if (localObject != null)
    {
      paramInt2 = paramInt4;
      if (I == null)
      {
        paramInt2 = paramInt4;
        if (((LinearLayout)localObject).getVisibility() != 8) {
          paramInt2 = paramInt4 + a(J, paramInt4, j, k, paramBoolean);
        }
      }
    }
    localObject = I;
    if (localObject != null) {
      a((View)localObject, paramInt2, j, k, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    localObject = z;
    if (localObject != null) {
      a((View)localObject, paramInt1, j, k, paramBoolean ^ true);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = 1073741824;
    if (i == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int k = View.MeasureSpec.getSize(paramInt1);
        i = B;
        if (i <= 0) {
          i = View.MeasureSpec.getSize(paramInt2);
        }
        paramInt1 = getPaddingTop();
        int m = getPaddingBottom() + paramInt1;
        paramInt1 = k - getPaddingLeft() - getPaddingRight();
        int n = i - m;
        int i1 = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
        localObject = H;
        int i2 = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = a((View)localObject, paramInt1, i1, 0);
          localObject = (ViewGroup.MarginLayoutParams)H.getLayoutParams();
          paramInt2 = paramInt1 - (leftMargin + rightMargin);
        }
        localObject = z;
        paramInt1 = paramInt2;
        if (localObject != null)
        {
          paramInt1 = paramInt2;
          if (((ViewGroup)localObject).getParent() == this) {
            paramInt1 = a(z, paramInt2, i1, 0);
          }
        }
        localObject = J;
        paramInt2 = paramInt1;
        int i3;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (I == null) {
            if (O)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              J.measure(paramInt2, i1);
              i3 = J.getMeasuredWidth();
              if (i3 <= paramInt1) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              paramInt2 = paramInt1;
              if (i1 != 0) {
                paramInt2 = paramInt1 - i3;
              }
              localObject = J;
              if (i1 != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((LinearLayout)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = a((View)localObject, paramInt1, i1, 0);
            }
          }
        }
        localObject = I;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (width != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = Integer.MIN_VALUE;
          }
          i3 = width;
          i1 = paramInt2;
          if (i3 >= 0) {
            i1 = Math.min(i3, paramInt2);
          }
          if (height != -2) {
            paramInt2 = j;
          } else {
            paramInt2 = Integer.MIN_VALUE;
          }
          i3 = height;
          j = n;
          if (i3 >= 0) {
            j = Math.min(i3, n);
          }
          I.measure(View.MeasureSpec.makeMeasureSpec(i1, paramInt1), View.MeasureSpec.makeMeasureSpec(j, paramInt2));
        }
        if (B <= 0)
        {
          j = getChildCount();
          paramInt2 = 0;
          paramInt1 = i2;
          while (paramInt1 < j)
          {
            i1 = getChildAt(paramInt1).getMeasuredHeight() + m;
            i = paramInt2;
            if (i1 > paramInt2) {
              i = i1;
            }
            paramInt1++;
            paramInt2 = i;
          }
          setMeasuredDimension(k, paramInt2);
        }
        else
        {
          setMeasuredDimension(k, i);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ActionBarContextView.class.getSimpleName());
      ((StringBuilder)localObject).append(" can only be used with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ActionBarContextView.class.getSimpleName());
    ((StringBuilder)localObject).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    B = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = I;
    if (localObject != null) {
      removeView((View)localObject);
    }
    I = paramView;
    if (paramView != null)
    {
      localObject = J;
      if (localObject != null)
      {
        removeView((View)localObject);
        J = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    G = paramCharSequence;
    a();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    F = paramCharSequence;
    a();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != O) {
      requestLayout();
    }
    O = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionBarContextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */