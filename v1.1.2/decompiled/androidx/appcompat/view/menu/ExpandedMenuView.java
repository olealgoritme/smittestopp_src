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
import d.b.d.i.h;
import d.b.d.i.h.b;
import d.b.d.i.j;
import d.b.d.i.p;

public final class ExpandedMenuView
  extends ListView
  implements h.b, p, AdapterView.OnItemClickListener
{
  public static final int[] y = { 16842964, 16843049 };
  public h x;
  
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
  
  public void a(h paramh)
  {
    x = paramh;
  }
  
  public boolean a(j paramj)
  {
    return x.a(paramj, null, 0);
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
    a((j)getAdapter().getItem(paramInt));
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.view.menu.ExpandedMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */