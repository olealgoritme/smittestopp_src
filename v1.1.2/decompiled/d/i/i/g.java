package d.i.i;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public class g
{
  public ViewParent a;
  public ViewParent b;
  public final View c;
  public boolean d;
  public int[] e;
  
  public g(View paramView)
  {
    c = paramView;
  }
  
  public final ViewParent a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return b;
    }
    return a;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = d;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      ViewParent localViewParent = a(0);
      bool3 = bool2;
      if (localViewParent != null)
      {
        View localView = c;
        try
        {
          bool3 = localViewParent.onNestedPreFling(localView, paramFloat1, paramFloat2);
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ViewParent ");
          localStringBuilder.append(localViewParent);
          localStringBuilder.append(" does not implement interface method onNestedPreFling");
          Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
          bool3 = bool2;
        }
      }
    }
    return bool3;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool1 = d;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      ViewParent localViewParent = a(0);
      bool3 = bool2;
      if (localViewParent != null)
      {
        View localView = c;
        try
        {
          bool3 = localViewParent.onNestedFling(localView, paramFloat1, paramFloat2, paramBoolean);
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ViewParent ");
          localStringBuilder.append(localViewParent);
          localStringBuilder.append(" does not implement interface method onNestedFling");
          Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
          bool3 = bool2;
        }
      }
    }
    return bool3;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i;
    if (a(paramInt2) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    if (d)
    {
      ViewParent localViewParent = c.getParent();
      View localView1 = c;
      while (localViewParent != null)
      {
        View localView3 = c;
        boolean bool1 = localViewParent instanceof h;
        boolean bool2;
        if (bool1) {
          bool2 = ((h)localViewParent).b(localView1, localView3, paramInt1, paramInt2);
        } else if (paramInt2 == 0) {
          try
          {
            bool2 = localViewParent.onStartNestedScroll(localView1, localView3, paramInt1);
          }
          catch (AbstractMethodError localAbstractMethodError2)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ViewParent ");
            localStringBuilder.append(localViewParent);
            localStringBuilder.append(" does not implement interface method onStartNestedScroll");
            Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError2);
          }
        } else {
          bool2 = false;
        }
        if (bool2)
        {
          if (paramInt2 != 0)
          {
            if (paramInt2 == 1) {
              b = localViewParent;
            }
          }
          else {
            a = localViewParent;
          }
          Object localObject = c;
          if (bool1) {
            ((h)localViewParent).a(localView1, (View)localObject, paramInt1, paramInt2);
          } else if (paramInt2 == 0) {
            try
            {
              localViewParent.onNestedScrollAccepted(localView1, (View)localObject, paramInt1);
            }
            catch (AbstractMethodError localAbstractMethodError1)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("ViewParent ");
              ((StringBuilder)localObject).append(localViewParent);
              ((StringBuilder)localObject).append(" does not implement interface method onNestedScrollAccepted");
              Log.e("ViewParentCompat", ((StringBuilder)localObject).toString(), localAbstractMethodError1);
            }
          }
          return true;
        }
        if ((localViewParent instanceof View)) {
          View localView2 = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0, null);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    if (d)
    {
      ViewParent localViewParent = a(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
      {
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1[0] = 0;
          paramArrayOfInt1[1] = 0;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt1 != null)
        {
          c.getLocationInWindow(paramArrayOfInt1);
          i = paramArrayOfInt1[0];
          j = paramArrayOfInt1[1];
        }
        else
        {
          i = 0;
          j = 0;
        }
        if (paramArrayOfInt2 == null)
        {
          if (e == null) {
            e = new int[2];
          }
          paramArrayOfInt2 = e;
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        View localView = c;
        if ((localViewParent instanceof i))
        {
          ((i)localViewParent).a(localView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt2);
        }
        else
        {
          paramArrayOfInt2[0] += paramInt3;
          paramArrayOfInt2[1] += paramInt4;
          if ((localViewParent instanceof h)) {
            ((h)localViewParent).a(localView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
          } else if (paramInt5 == 0) {
            try
            {
              localViewParent.onNestedScroll(localView, paramInt1, paramInt2, paramInt3, paramInt4);
            }
            catch (AbstractMethodError localAbstractMethodError)
            {
              paramArrayOfInt2 = new StringBuilder();
              paramArrayOfInt2.append("ViewParent ");
              paramArrayOfInt2.append(localViewParent);
              paramArrayOfInt2.append(" does not implement interface method onNestedScroll");
              Log.e("ViewParentCompat", paramArrayOfInt2.toString(), localAbstractMethodError);
            }
          }
        }
        if (paramArrayOfInt1 != null)
        {
          c.getLocationInWindow(paramArrayOfInt1);
          paramArrayOfInt1[0] -= i;
          paramArrayOfInt1[1] -= j;
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    boolean bool1 = d;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      ViewParent localViewParent = a(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool3 = bool2;
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
          bool3 = bool2;
        }
      }
      else
      {
        int i;
        int k;
        if (paramArrayOfInt2 != null)
        {
          c.getLocationInWindow(paramArrayOfInt2);
          i = paramArrayOfInt2[0];
          int j = paramArrayOfInt2[1];
          k = i;
          i = j;
        }
        else
        {
          k = 0;
          i = 0;
        }
        if (paramArrayOfInt1 == null)
        {
          if (e == null) {
            e = new int[2];
          }
          paramArrayOfInt1 = e;
        }
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        View localView = c;
        if ((localViewParent instanceof h)) {
          ((h)localViewParent).a(localView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        } else if (paramInt3 == 0) {
          try
          {
            localViewParent.onNestedPreScroll(localView, paramInt1, paramInt2, paramArrayOfInt1);
          }
          catch (AbstractMethodError localAbstractMethodError)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ViewParent ");
            localStringBuilder.append(localViewParent);
            localStringBuilder.append(" does not implement interface method onNestedPreScroll");
            Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
          }
        }
        if (paramArrayOfInt2 != null)
        {
          c.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= k;
          paramArrayOfInt2[1] -= i;
        }
        if (paramArrayOfInt1[0] == 0)
        {
          bool3 = bool2;
          if (paramArrayOfInt1[1] == 0) {}
        }
        else
        {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    if (a(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c(int paramInt)
  {
    ViewParent localViewParent = a(paramInt);
    if (localViewParent != null)
    {
      View localView = c;
      if ((localViewParent instanceof h)) {
        ((h)localViewParent).a(localView, paramInt);
      } else if (paramInt == 0) {
        try
        {
          localViewParent.onStopNestedScroll(localView);
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ViewParent ");
          localStringBuilder.append(localViewParent);
          localStringBuilder.append(" does not implement interface method onStopNestedScroll");
          Log.e("ViewParentCompat", localStringBuilder.toString(), localAbstractMethodError);
        }
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          b = null;
        }
      }
      else {
        a = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.i.i.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */