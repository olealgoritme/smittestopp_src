package e.c.a.b.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R.attr;
import com.google.android.material.R.dimen;
import d.b.d.i.h;
import d.b.d.i.j;
import d.b.d.i.p;
import java.util.ArrayList;

public class d
  extends ViewGroup
  implements p
{
  public static final int[] V = { 16842912 };
  public static final int[] W = { -16842910 };
  public final int A;
  public final int B;
  public final int C;
  public final View.OnClickListener D;
  public final d.i.h.b<a> E = new d.i.h.c(5);
  public boolean F;
  public int G;
  public a[] H;
  public int I = 0;
  public int J = 0;
  public ColorStateList K;
  public int L;
  public ColorStateList M;
  public final ColorStateList N;
  public int O;
  public int P;
  public Drawable Q;
  public int R;
  public int[] S;
  public e T;
  public h U;
  public final d.x.n x;
  public final int y;
  public final int z;
  
  public d(Context paramContext)
  {
    super(paramContext, null);
    paramContext = getResources();
    y = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    z = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    A = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    B = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    C = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    N = a(16842808);
    paramContext = new d.x.a();
    x = paramContext;
    paramContext.b(0);
    x.a(115L);
    x.a(new d.n.a.a.b());
    x.a(new e.c.a.b.j.d());
    D = new c(this);
    S = new int[5];
  }
  
  private a getNewItem()
  {
    a locala1 = (a)E.a();
    a locala2 = locala1;
    if (locala1 == null) {
      locala2 = new a(getContext());
    }
    return locala2;
  }
  
  public ColorStateList a(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = d.b.b.a.a.b(getContext(), resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    int i = data;
    int j = localColorStateList.getDefaultColor();
    localObject = W;
    int[] arrayOfInt1 = V;
    int[] arrayOfInt2 = ViewGroup.EMPTY_STATE_SET;
    paramInt = localColorStateList.getColorForState(W, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { paramInt, i, j });
  }
  
  public void a()
  {
    removeAllViews();
    Object localObject1 = H;
    Object localObject2;
    if (localObject1 != null)
    {
      int i = localObject1.length;
      for (j = 0; j < i; j++)
      {
        localObject2 = localObject1[j];
        if (localObject2 != null) {
          E.a(localObject2);
        }
      }
    }
    if (U.size() == 0)
    {
      I = 0;
      J = 0;
      H = null;
      return;
    }
    H = new a[U.size()];
    boolean bool = a(G, U.d().size());
    for (int j = 0; j < U.size(); j++)
    {
      T.z = true;
      U.getItem(j).setCheckable(true);
      T.z = false;
      localObject1 = getNewItem();
      H[j] = localObject1;
      ((a)localObject1).setIconTintList(K);
      ((a)localObject1).setIconSize(L);
      ((a)localObject1).setTextColor(N);
      ((a)localObject1).setTextAppearanceInactive(O);
      ((a)localObject1).setTextAppearanceActive(P);
      ((a)localObject1).setTextColor(M);
      localObject2 = Q;
      if (localObject2 != null) {
        ((a)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((a)localObject1).setItemBackground(R);
      }
      ((a)localObject1).setShifting(bool);
      ((a)localObject1).setLabelVisibilityMode(G);
      ((a)localObject1).a((j)U.getItem(j), 0);
      ((a)localObject1).setItemPosition(j);
      ((FrameLayout)localObject1).setOnClickListener(D);
      addView((View)localObject1);
    }
    j = Math.min(U.size() - 1, J);
    J = j;
    U.getItem(j).setChecked(true);
  }
  
  public void a(h paramh)
  {
    U = paramh;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 == -1 ? paramInt2 <= 3 : paramInt1 != 0) {
      bool = false;
    }
    return bool;
  }
  
  public ColorStateList getIconTintList()
  {
    return K;
  }
  
  public Drawable getItemBackground()
  {
    a[] arrayOfa = H;
    if ((arrayOfa != null) && (arrayOfa.length > 0)) {
      return arrayOfa[0].getBackground();
    }
    return Q;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return R;
  }
  
  public int getItemIconSize()
  {
    return L;
  }
  
  public int getItemTextAppearanceActive()
  {
    return P;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return O;
  }
  
  public ColorStateList getItemTextColor()
  {
    return M;
  }
  
  public int getLabelVisibilityMode()
  {
    return G;
  }
  
  public int getSelectedItemId()
  {
    return I;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (d.i.i.n.i(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2++;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = U.d().size();
    int k = getChildCount();
    int m = View.MeasureSpec.makeMeasureSpec(C, 1073741824);
    Object localObject;
    int n;
    if ((a(G, j)) && (F))
    {
      localObject = getChildAt(J);
      paramInt2 = B;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(A, Integer.MIN_VALUE), m);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = j - paramInt2;
      n = Math.min(i - z * paramInt2, Math.min(paramInt1, A));
      j = i - n;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      i = Math.min(j / paramInt1, y);
      paramInt2 = j - paramInt2 * i;
      paramInt1 = 0;
    }
    while (paramInt1 < k)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = S;
        if (paramInt1 == J) {
          j = n;
        } else {
          j = i;
        }
        localObject[paramInt1] = j;
        j = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = S;
          localObject[paramInt1] += 1;
          j = paramInt2 - 1;
        }
      }
      else
      {
        S[paramInt1] = 0;
        j = paramInt2;
      }
      paramInt1++;
      paramInt2 = j;
      continue;
      if (j == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = j;
      }
      n = Math.min(i / paramInt1, A);
      paramInt2 = i - j * n;
      paramInt1 = 0;
      while (paramInt1 < k)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = S;
          localObject[paramInt1] = n;
          j = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            j = paramInt2 - 1;
          }
        }
        else
        {
          S[paramInt1] = 0;
          j = paramInt2;
        }
        paramInt1++;
        paramInt2 = j;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < k)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(S[paramInt1], 1073741824), m);
        getLayoutParamswidth = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1++;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(C, m, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    K = paramColorStateList;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].setIconTintList(paramColorStateList);
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    Q = paramDrawable;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].setItemBackground(paramDrawable);
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    R = paramInt;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].setItemBackground(paramInt);
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    L = paramInt;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].setIconSize(paramInt);
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    P = paramInt;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++)
      {
        a locala = arrayOfa[j];
        locala.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = M;
        if (localColorStateList != null) {
          locala.setTextColor(localColorStateList);
        }
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    O = paramInt;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++)
      {
        a locala = arrayOfa[j];
        locala.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = M;
        if (localColorStateList != null) {
          locala.setTextColor(localColorStateList);
        }
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    M = paramColorStateList;
    a[] arrayOfa = H;
    if (arrayOfa != null)
    {
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].setTextColor(paramColorStateList);
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    G = paramInt;
  }
  
  public void setPresenter(e parame)
  {
    T = parame;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.d.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */