package d.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import androidx.constraintlayout.widget.R.id;
import androidx.constraintlayout.widget.R.styleable;
import d.g.a.h.d;
import d.g.a.h.h;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class b
  extends View
{
  public h A;
  public boolean B = false;
  public String C;
  public int[] x = new int[32];
  public int y;
  public Context z;
  
  public b(Context paramContext)
  {
    super(paramContext);
    z = paramContext;
    a(null);
  }
  
  private void setIds(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = paramString.indexOf(',', i);
      if (j == -1)
      {
        a(paramString.substring(i));
        return;
      }
      a(paramString.substring(i, j));
    }
  }
  
  public void a()
  {
    if (A == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.a)) {
      k0 = A;
    }
  }
  
  public void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          String str = paramAttributeSet.getString(k);
          C = str;
          setIds(str);
        }
      }
    }
  }
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(C);
    }
    h localh = A;
    if (localh == null) {
      return;
    }
    int i = 0;
    l0 = 0;
    while (i < y)
    {
      int j = x[i];
      Object localObject = (View)x.get(j);
      if (localObject != null)
      {
        localh = A;
        localObject = paramConstraintLayout.a((View)localObject);
        j = l0;
        d[] arrayOfd = k0;
        if (j + 1 > arrayOfd.length) {
          k0 = ((d[])Arrays.copyOf(arrayOfd, arrayOfd.length * 2));
        }
        arrayOfd = k0;
        j = l0;
        arrayOfd[j] = localObject;
        l0 = (j + 1);
      }
      i++;
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (z == null) {
      return;
    }
    paramString = paramString.trim();
    try
    {
      i = R.id.class.getField(paramString).getInt(null);
    }
    catch (Exception localException)
    {
      i = 0;
    }
    int j = i;
    if (i == 0) {
      j = z.getResources().getIdentifier(paramString, "id", z.getPackageName());
    }
    int i = j;
    Object localObject;
    if (j == 0)
    {
      i = j;
      if (isInEditMode())
      {
        i = j;
        if ((getParent() instanceof ConstraintLayout))
        {
          localObject = ((ConstraintLayout)getParent()).a(0, paramString);
          i = j;
          if (localObject != null)
          {
            i = j;
            if ((localObject instanceof Integer)) {
              i = ((Integer)localObject).intValue();
            }
          }
        }
      }
    }
    if (i != 0)
    {
      setTag(i, null);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find id of \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(x, y);
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (B) {
      super.onMeasure(paramInt1, paramInt2);
    } else {
      setMeasuredDimension(0, 0);
    }
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    int i = 0;
    y = 0;
    while (i < paramArrayOfInt.length)
    {
      setTag(paramArrayOfInt[i], null);
      i++;
    }
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    int i = y;
    paramObject = x;
    if (i + 1 > paramObject.length) {
      x = Arrays.copyOf((int[])paramObject, paramObject.length * 2);
    }
    paramObject = x;
    i = y;
    paramObject[i] = paramInt;
    y = (i + 1);
  }
}

/* Location:
 * Qualified Name:     d.g.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */