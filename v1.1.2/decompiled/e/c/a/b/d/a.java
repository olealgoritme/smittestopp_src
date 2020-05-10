package e.c.a.b.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import d.b.a.s;
import d.b.d.i.j;
import d.b.d.i.p.a;
import d.i.i.m;
import d.i.i.n;

public class a
  extends FrameLayout
  implements p.a
{
  public static final int[] J = { 16842912 };
  public float A;
  public int B;
  public boolean C;
  public ImageView D;
  public final TextView E;
  public final TextView F;
  public int G = -1;
  public j H;
  public ColorStateList I;
  public final int x;
  public float y;
  public float z;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 0);
    Resources localResources = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    x = localResources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    D = ((ImageView)findViewById(R.id.icon));
    E = ((TextView)findViewById(R.id.smallLabel));
    F = ((TextView)findViewById(R.id.largeLabel));
    n.e(E, 2);
    F.setImportantForAccessibility(2);
    setFocusable(true);
    a(E.getTextSize(), F.getTextSize());
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    y = (paramFloat1 - paramFloat2);
    z = (paramFloat2 * 1.0F / paramFloat1);
    A = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    topMargin = paramInt1;
    gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a(j paramj, int paramInt)
  {
    H = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(e);
    setId(a);
    if (!TextUtils.isEmpty(q)) {
      setContentDescription(q);
    }
    s.a(this, r);
    if (paramj.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public j getItemData()
  {
    return H;
  }
  
  public int getItemPosition()
  {
    return G;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    j localj = H;
    if ((localj != null) && (localj.isCheckable()) && (H.isChecked())) {
      FrameLayout.mergeDrawableStates(arrayOfInt, J);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    TextView localTextView = F;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = F;
    localTextView.setPivotY(localTextView.getBaseline());
    localTextView = E;
    localTextView.setPivotX(localTextView.getWidth() / 2);
    localTextView = E;
    localTextView.setPivotY(localTextView.getBaseline());
    int i = B;
    float f;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            a(D, x, 17);
            F.setVisibility(8);
            E.setVisibility(8);
          }
        }
        else if (paramBoolean)
        {
          a(D, (int)(x + y), 49);
          a(F, 1.0F, 1.0F, 0);
          localTextView = E;
          f = z;
          a(localTextView, f, f, 4);
        }
        else
        {
          a(D, x, 49);
          localTextView = F;
          f = A;
          a(localTextView, f, f, 4);
          a(E, 1.0F, 1.0F, 0);
        }
      }
      else
      {
        if (paramBoolean)
        {
          a(D, x, 49);
          a(F, 1.0F, 1.0F, 0);
        }
        else
        {
          a(D, x, 17);
          a(F, 0.5F, 0.5F, 4);
        }
        E.setVisibility(4);
      }
    }
    else if (C)
    {
      if (paramBoolean)
      {
        a(D, x, 49);
        a(F, 1.0F, 1.0F, 0);
      }
      else
      {
        a(D, x, 17);
        a(F, 0.5F, 0.5F, 4);
      }
      E.setVisibility(4);
    }
    else if (paramBoolean)
    {
      a(D, (int)(x + y), 49);
      a(F, 1.0F, 1.0F, 0);
      localTextView = E;
      f = z;
      a(localTextView, f, f, 4);
    }
    else
    {
      a(D, x, 49);
      localTextView = F;
      f = A;
      a(localTextView, f, f, 4);
      a(E, 1.0F, 1.0F, 0);
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    E.setEnabled(paramBoolean);
    F.setEnabled(paramBoolean);
    D.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = getContext();
      if (Build.VERSION.SDK_INT >= 24) {
        localObject = new m(PointerIcon.getSystemIcon((Context)localObject, 1002));
      } else {
        localObject = new m(null);
      }
      n.a(this, (m)localObject);
    }
    else
    {
      n.a(this, null);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      localObject = s.c(paramDrawable).mutate();
      ((Drawable)localObject).setTintList(I);
    }
    D.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)D.getLayoutParams();
    width = paramInt;
    height = paramInt;
    D.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    I = paramColorStateList;
    paramColorStateList = H;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = d.i.b.a.c(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    n.a(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    G = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (B != paramInt)
    {
      B = paramInt;
      if (H != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(H.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (C != paramBoolean)
    {
      C = paramBoolean;
      int i;
      if (H != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(H.isChecked());
      }
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    s.d(F, paramInt);
    a(E.getTextSize(), F.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    s.d(E, paramInt);
    a(E.getTextSize(), F.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      E.setTextColor(paramColorStateList);
      F.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    E.setText(paramCharSequence);
    F.setText(paramCharSequence);
    j localj = H;
    if ((localj == null) || (TextUtils.isEmpty(q))) {
      setContentDescription(paramCharSequence);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */