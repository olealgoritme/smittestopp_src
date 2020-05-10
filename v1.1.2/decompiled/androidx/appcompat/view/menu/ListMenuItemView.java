package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import d.b.d.i.h;
import d.b.d.i.j;
import d.b.d.i.p.a;
import d.b.e.u0;
import d.i.i.n;

public class ListMenuItemView
  extends LinearLayout
  implements p.a, AbsListView.SelectionBoundsAdjuster
{
  public TextView A;
  public CheckBox B;
  public TextView C;
  public ImageView D;
  public ImageView E;
  public LinearLayout F;
  public Drawable G;
  public int H;
  public Context I;
  public boolean J;
  public Drawable K;
  public boolean L;
  public LayoutInflater M;
  public boolean N;
  public j x;
  public ImageView y;
  public RadioButton z;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = u0.a(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    G = paramAttributeSet.b(R.styleable.MenuView_android_itemBackground);
    H = paramAttributeSet.g(R.styleable.MenuView_android_itemTextAppearance, -1);
    J = paramAttributeSet.a(R.styleable.MenuView_preserveIconSpacing, false);
    I = paramContext;
    K = paramAttributeSet.b(R.styleable.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = R.attr.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    L = paramContext.hasValue(0);
    b.recycle();
    paramContext.recycle();
  }
  
  private LayoutInflater getInflater()
  {
    if (M == null) {
      M = LayoutInflater.from(getContext());
    }
    return M;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = D;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public final void a()
  {
    CheckBox localCheckBox = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
    B = localCheckBox;
    LinearLayout localLinearLayout = F;
    if (localLinearLayout != null) {
      localLinearLayout.addView(localCheckBox, -1);
    } else {
      addView(localCheckBox, -1);
    }
  }
  
  public void a(j paramj, int paramInt)
  {
    x = paramj;
    boolean bool = paramj.isVisible();
    int i = 0;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    Object localObject;
    if (b()) {
      localObject = paramj.getTitleCondensed();
    } else {
      localObject = e;
    }
    setTitle((CharSequence)localObject);
    setCheckable(paramj.isCheckable());
    bool = paramj.f();
    paramj.b();
    if ((bool) && (x.f())) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    if (paramInt == 0)
    {
      TextView localTextView = C;
      j localj = x;
      char c = localj.b();
      if (c == 0)
      {
        localObject = "";
      }
      else
      {
        Resources localResources = n.a.getResources();
        localObject = new StringBuilder();
        if (ViewConfiguration.get(n.a).hasPermanentMenuKey()) {
          ((StringBuilder)localObject).append(localResources.getString(R.string.abc_prepend_shortcut_label));
        }
        if (n.f()) {
          i = k;
        } else {
          i = i;
        }
        j.a((StringBuilder)localObject, i, 65536, localResources.getString(R.string.abc_menu_meta_shortcut_label));
        j.a((StringBuilder)localObject, i, 4096, localResources.getString(R.string.abc_menu_ctrl_shortcut_label));
        j.a((StringBuilder)localObject, i, 2, localResources.getString(R.string.abc_menu_alt_shortcut_label));
        j.a((StringBuilder)localObject, i, 1, localResources.getString(R.string.abc_menu_shift_shortcut_label));
        j.a((StringBuilder)localObject, i, 4, localResources.getString(R.string.abc_menu_sym_shortcut_label));
        j.a((StringBuilder)localObject, i, 8, localResources.getString(R.string.abc_menu_function_shortcut_label));
        if (c != '\b')
        {
          if (c != '\n')
          {
            if (c != ' ') {
              ((StringBuilder)localObject).append(c);
            } else {
              ((StringBuilder)localObject).append(localResources.getString(R.string.abc_menu_space_shortcut_label));
            }
          }
          else {
            ((StringBuilder)localObject).append(localResources.getString(R.string.abc_menu_enter_shortcut_label));
          }
        }
        else {
          ((StringBuilder)localObject).append(localResources.getString(R.string.abc_menu_delete_shortcut_label));
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      localTextView.setText((CharSequence)localObject);
    }
    if (C.getVisibility() != paramInt) {
      C.setVisibility(paramInt);
    }
    setIcon(paramj.getIcon());
    setEnabled(paramj.isEnabled());
    setSubMenuArrowVisible(paramj.hasSubMenu());
    setContentDescription(q);
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    Object localObject = E;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)E.getLayoutParams();
      int i = top;
      top = (E.getHeight() + topMargin + bottomMargin + i);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final void c()
  {
    RadioButton localRadioButton = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
    z = localRadioButton;
    LinearLayout localLinearLayout = F;
    if (localLinearLayout != null) {
      localLinearLayout.addView(localRadioButton, -1);
    } else {
      addView(localRadioButton, -1);
    }
  }
  
  public j getItemData()
  {
    return x;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    n.a(this, G);
    Object localObject = (TextView)findViewById(R.id.title);
    A = ((TextView)localObject);
    int i = H;
    if (i != -1) {
      ((TextView)localObject).setTextAppearance(I, i);
    }
    C = ((TextView)findViewById(R.id.shortcut));
    localObject = (ImageView)findViewById(R.id.submenuarrow);
    D = ((ImageView)localObject);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(K);
    }
    E = ((ImageView)findViewById(R.id.group_divider));
    F = ((LinearLayout)findViewById(R.id.content));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((y != null) && (J))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)y.getLayoutParams();
      int i = height;
      if ((i > 0) && (width <= 0)) {
        width = i;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (z == null) && (B == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (x.e())
    {
      if (z == null) {
        c();
      }
      localObject1 = z;
      localObject2 = B;
    }
    else
    {
      if (B == null) {
        a();
      }
      localObject1 = B;
      localObject2 = z;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(x.isChecked());
      if (((CompoundButton)localObject1).getVisibility() != 0) {
        ((CompoundButton)localObject1).setVisibility(0);
      }
      if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
        ((CompoundButton)localObject2).setVisibility(8);
      }
    }
    else
    {
      localObject2 = B;
      if (localObject2 != null) {
        ((CheckBox)localObject2).setVisibility(8);
      }
      localObject2 = z;
      if (localObject2 != null) {
        ((RadioButton)localObject2).setVisibility(8);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (x.e())
    {
      if (z == null) {
        c();
      }
      localObject = z;
    }
    else
    {
      if (B == null) {
        a();
      }
      localObject = B;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    N = paramBoolean;
    J = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView = E;
    if (localImageView != null)
    {
      int i;
      if ((!L) && (paramBoolean)) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((!x.n.s) && (!N)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!J)) {
      return;
    }
    if ((y == null) && (paramDrawable == null) && (!J)) {
      return;
    }
    ImageView localImageView;
    if (y == null)
    {
      localImageView = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
      y = localImageView;
      LinearLayout localLinearLayout = F;
      if (localLinearLayout != null) {
        localLinearLayout.addView(localImageView, 0);
      } else {
        addView(localImageView, 0);
      }
    }
    if ((paramDrawable == null) && (!J))
    {
      y.setVisibility(8);
    }
    else
    {
      localImageView = y;
      if (i == 0) {
        paramDrawable = null;
      }
      localImageView.setImageDrawable(paramDrawable);
      if (y.getVisibility() != 0) {
        y.setVisibility(0);
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      A.setText(paramCharSequence);
      if (A.getVisibility() != 0) {
        A.setVisibility(0);
      }
    }
    else if (A.getVisibility() != 8)
    {
      A.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */