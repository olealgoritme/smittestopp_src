package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import d.b.b.a.a;
import d.b.d.i.g;
import d.b.d.i.g.b;
import d.b.d.i.i;
import d.b.d.i.n;

public final class ExpandedMenuView
  extends ListView
  implements g.b, n, AdapterView.OnItemClickListener
{
  public static final int[] y = { 16842964, 16843049 };
  public g x;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, y, paramInt, 0);
    if (localTypedArray.hasValue(0))
    {
      if (localTypedArray.hasValue(0))
      {
        paramInt = localTypedArray.getResourceId(0, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = a.c(paramContext, paramInt);
          break label69;
        }
      }
      paramAttributeSet = localTypedArray.getDrawable(0);
      label69:
      setBackgroundDrawable(paramAttributeSet);
    }
    if (localTypedArray.hasValue(1))
    {
      if (localTypedArray.hasValue(1))
      {
        paramInt = localTypedArray.getResourceId(1, 0);
        if (paramInt != 0)
        {
          paramContext = a.c(paramContext, paramInt);
          break label120;
        }
      }
      paramContext = localTypedArray.getDrawable(1);
      label120:
      setDivider(paramContext);
    }
    localTypedArray.recycle();
  }
  
  public void a(g paramg)
  {
    x = paramg;
  }
  
  public boolean a(i parami)
  {
    return x.a(parami, null, 0);
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((i)getAdapter().getItem(paramInt));
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.view.menu.ExpandedMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */