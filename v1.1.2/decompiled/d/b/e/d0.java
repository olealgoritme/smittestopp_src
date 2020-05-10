package d.b.e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R.attr;
import d.i.i.s;
import d.i.j.a;
import java.lang.reflect.Field;

public class d0
  extends ListView
{
  public int A = 0;
  public int B = 0;
  public int C;
  public Field D;
  public a E;
  public boolean F;
  public boolean G;
  public boolean H;
  public s I;
  public d.i.j.c J;
  public b K;
  public final Rect x = new Rect();
  public int y = 0;
  public int z = 0;
  
  public d0(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    G = paramBoolean;
    setCacheColorHint(0);
    try
    {
      paramContext = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      D = paramContext;
      paramContext.setAccessible(true);
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    a locala = E;
    if (locala != null) {
      y = paramBoolean;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int k = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return i + j;
    }
    j = i + j;
    if ((k <= 0) || (localObject == null)) {
      k = 0;
    }
    int m = localListAdapter.getCount();
    localObject = null;
    int n = 0;
    int i1 = 0;
    int i2;
    for (i = 0; n < m; i = i2)
    {
      i2 = localListAdapter.getItemViewType(n);
      int i3 = i1;
      if (i2 != i1)
      {
        localObject = null;
        i3 = i2;
      }
      View localView = localListAdapter.getView(n, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i1 = height;
      if (i1 > 0) {
        i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
      } else {
        i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, i1);
      localView.forceLayout();
      i1 = j;
      if (n > 0) {
        i1 = j + k;
      }
      j = i1 + localView.getMeasuredHeight();
      if (j >= paramInt2)
      {
        paramInt1 = paramInt2;
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt2;
          if (n > paramInt3)
          {
            paramInt1 = paramInt2;
            if (i > 0)
            {
              paramInt1 = paramInt2;
              if (j != paramInt2) {
                paramInt1 = i;
              }
            }
          }
        }
        return paramInt1;
      }
      i2 = i;
      if (paramInt3 >= 0)
      {
        i2 = i;
        if (n >= paramInt3) {
          i2 = j;
        }
      }
      n++;
      i1 = i3;
      localObject = localView;
    }
    return j;
  }
  
  public final void a()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (H) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = 1;
    boolean bool1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label47;
        }
        break label544;
      }
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    int k = paramMotionEvent.findPointerIndex(paramInt);
    label47:
    Object localObject1;
    if (k < 0)
    {
      bool1 = false;
    }
    else
    {
      paramInt = (int)paramMotionEvent.getX(k);
      int m = (int)paramMotionEvent.getY(k);
      k = pointToPosition(paramInt, m);
      if (k == -1)
      {
        paramInt = j;
        break label549;
      }
      localObject1 = getChildAt(k - getFirstVisiblePosition());
      float f1 = paramInt;
      float f2 = m;
      H = true;
      drawableHotspotChanged(f1, f2);
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      paramInt = C;
      if (paramInt != -1)
      {
        localObject2 = getChildAt(paramInt - getFirstVisiblePosition());
        if ((localObject2 != null) && (localObject2 != localObject1) && (((View)localObject2).isPressed())) {
          ((View)localObject2).setPressed(false);
        }
      }
      C = k;
      ((View)localObject1).drawableHotspotChanged(f1 - ((View)localObject1).getLeft(), f2 - ((View)localObject1).getTop());
      if (!((View)localObject1).isPressed()) {
        ((View)localObject1).setPressed(true);
      }
      Object localObject2 = getSelector();
      if ((localObject2 != null) && (k != -1)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        ((Drawable)localObject2).setVisible(false, false);
      }
      Object localObject3 = x;
      ((Rect)localObject3).set(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
      left -= y;
      top -= z;
      right += A;
      bottom += B;
      try
      {
        bool1 = D.getBoolean(this);
        if (((View)localObject1).isEnabled() != bool1)
        {
          localObject3 = D;
          if (!bool1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Field)localObject3).set(this, Boolean.valueOf(bool1));
          if (k != -1) {
            refreshDrawableState();
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      if (paramInt != 0)
      {
        Rect localRect = x;
        float f3 = localRect.exactCenterX();
        float f4 = localRect.exactCenterY();
        if (getVisibility() == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((Drawable)localObject2).setVisible(bool1, false);
        ((Drawable)localObject2).setHotspot(f3, f4);
      }
      localObject2 = getSelector();
      if ((localObject2 != null) && (k != -1)) {
        ((Drawable)localObject2).setHotspot(f1, f2);
      }
      setSelectorEnabled(false);
      refreshDrawableState();
      if (i == 1) {
        performItemClick((View)localObject1, k, getItemIdAtPosition(k));
      }
      label544:
      bool1 = true;
    }
    paramInt = 0;
    label549:
    if ((!bool1) || (paramInt != 0))
    {
      H = false;
      setPressed(false);
      drawableStateChanged();
      localObject1 = getChildAt(C - getFirstVisiblePosition());
      if (localObject1 != null) {
        ((View)localObject1).setPressed(false);
      }
      localObject1 = I;
      if (localObject1 != null)
      {
        ((s)localObject1).a();
        I = null;
      }
    }
    if (bool1)
    {
      if (J == null) {
        J = new d.i.j.c(this);
      }
      localObject1 = J;
      boolean bool2 = M;
      M = true;
      ((a)localObject1).onTouch(this, paramMotionEvent);
    }
    else
    {
      paramMotionEvent = J;
      if (paramMotionEvent != null)
      {
        if (M) {
          paramMotionEvent.a();
        }
        M = false;
      }
    }
    return bool1;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (!x.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(x);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void drawableStateChanged()
  {
    if (K != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    a();
  }
  
  public boolean hasFocus()
  {
    boolean bool;
    if ((!G) && (!super.hasFocus())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean hasWindowFocus()
  {
    boolean bool;
    if ((!G) && (!super.hasWindowFocus())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFocused()
  {
    boolean bool;
    if ((!G) && (!super.isFocused())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isInTouchMode()
  {
    boolean bool;
    if (((G) && (F)) || (super.isInTouchMode())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onDetachedFromWindow()
  {
    K = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getActionMasked();
    if ((i == 10) && (K == null))
    {
      b localb = new b();
      K = localb;
      x.post(localb);
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((i != 9) && (i != 7))
    {
      setSelection(-1);
    }
    else
    {
      i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i != -1) && (i != getSelectedItemPosition()))
      {
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
        if (paramMotionEvent.isEnabled()) {
          setSelectionFromTop(i, paramMotionEvent.getTop() - getTop());
        }
        a();
      }
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      C = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    b localb = K;
    if (localb != null)
    {
      d0 locald0 = x;
      K = null;
      locald0.removeCallbacks(localb);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setListSelectionHidden(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new a(paramDrawable);
    } else {
      localObject = null;
    }
    E = ((a)localObject);
    super.setSelector((Drawable)localObject);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    y = left;
    z = top;
    A = right;
    B = bottom;
  }
  
  public static class a
    extends d.b.c.a.c
  {
    public boolean y = true;
    
    public a(Drawable paramDrawable)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      if (y) {
        x.draw(paramCanvas);
      }
    }
    
    public void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (y) {
        x.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (y) {
        x.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public boolean setState(int[] paramArrayOfInt)
    {
      if (y) {
        return x.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (y) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      d0 locald0 = d0.this;
      K = null;
      locald0.drawableStateChanged();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.d0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */