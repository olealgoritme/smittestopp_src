package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import d.b.d.i.g;
import d.b.d.i.n;
import d.t.a.s;

public class NavigationMenuView
  extends s
  implements n
{
  public NavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutManager(new LinearLayoutManager(1, false));
  }
  
  public void a(g paramg) {}
  
  public int getWindowAnimations()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.internal.NavigationMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */