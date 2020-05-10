package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d.b.d.i.h;
import d.b.d.i.p;

public class NavigationMenuView
  extends RecyclerView
  implements p
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
  
  public void a(h paramh) {}
  
  public int getWindowAnimations()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.internal.NavigationMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */