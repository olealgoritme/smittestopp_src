package d.x;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import java.util.Map;

public abstract class b0
  extends h
{
  public static final String[] g0 = { "android:visibility:visibility", "android:visibility:parent" };
  public int f0 = 3;
  
  public abstract Animator a(ViewGroup paramViewGroup, View paramView, p paramp1, p paramp2);
  
  public Animator a(ViewGroup paramViewGroup, p paramp1, p paramp2)
  {
    b0.b localb = b(paramp1, paramp2);
    boolean bool = a;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject1;
    if (bool) {
      if (e == null)
      {
        localObject3 = localObject1;
        if (f == null) {}
      }
      else
      {
        if (b)
        {
          paramViewGroup = (ViewGroup)localObject2;
          if ((f0 & 0x1) == 1) {
            if (paramp2 == null)
            {
              paramViewGroup = (ViewGroup)localObject2;
            }
            else
            {
              if (paramp1 == null)
              {
                paramViewGroup = (View)b.getParent();
                if (bbca)
                {
                  paramViewGroup = (ViewGroup)localObject2;
                  break label195;
                }
              }
              paramp2 = b;
              paramViewGroup = (c)this;
              float f1 = 0.0F;
              if (paramp1 != null)
              {
                paramp1 = (Float)a.get("android:fade:transitionAlpha");
                if (paramp1 != null)
                {
                  f2 = paramp1.floatValue();
                  break label172;
                }
              }
              float f2 = 0.0F;
              label172:
              if (f2 == 1.0F) {
                f2 = f1;
              }
              paramViewGroup = paramViewGroup.a(paramp2, f2, 1.0F);
            }
          }
          label195:
          return paramViewGroup;
        }
        int i = d;
        if ((f0 & 0x2) != 2)
        {
          localObject3 = localObject1;
        }
        else
        {
          if (paramp1 != null) {
            localObject3 = b;
          } else {
            localObject3 = null;
          }
          if (paramp2 != null) {
            localObject2 = b;
          } else {
            localObject2 = null;
          }
          int j;
          if ((localObject2 != null) && (((View)localObject2).getParent() != null))
          {
            if ((i == 4) || (localObject3 == localObject2))
            {
              localObject3 = null;
              break label478;
            }
            if (S) {
              localObject2 = localObject3;
            } else {
              localObject2 = o.a(paramViewGroup, (View)localObject3, (View)((View)localObject3).getParent());
            }
          }
          else if (localObject2 == null)
          {
            if (localObject3 == null) {
              break label471;
            }
            if (((View)localObject3).getParent() == null)
            {
              localObject2 = localObject3;
            }
            else
            {
              if (!(((View)localObject3).getParent() instanceof View)) {
                break label471;
              }
              localObject2 = (View)((View)localObject3).getParent();
              if (!bcba)
              {
                localObject2 = o.a(paramViewGroup, (View)localObject3, (View)localObject2);
              }
              else
              {
                if (((View)localObject2).getParent() == null)
                {
                  j = ((View)localObject2).getId();
                  if ((j != -1) && (paramViewGroup.findViewById(j) != null) && (S))
                  {
                    localObject2 = localObject3;
                    break label457;
                  }
                }
                localObject2 = null;
              }
            }
          }
          label457:
          localb = null;
          localObject3 = localObject2;
          localObject2 = localb;
          break label478;
          label471:
          localObject3 = null;
          localObject2 = localObject3;
          label478:
          if ((localObject3 != null) && (paramp1 != null))
          {
            localObject2 = (int[])a.get("android:visibility:screenLocation");
            i = localObject2[0];
            j = localObject2[1];
            localObject2 = new int[2];
            paramViewGroup.getLocationOnScreen((int[])localObject2);
            ((View)localObject3).offsetLeftAndRight(i - localObject2[0] - ((View)localObject3).getLeft());
            ((View)localObject3).offsetTopAndBottom(j - localObject2[1] - ((View)localObject3).getTop());
            localObject2 = new r(paramViewGroup);
            a.add((View)localObject3);
            paramViewGroup = a(paramViewGroup, (View)localObject3, paramp1, paramp2);
            if (paramViewGroup == null)
            {
              a.remove((View)localObject3);
              localObject3 = paramViewGroup;
            }
            else
            {
              paramViewGroup.addListener(new a0(this, (s)localObject2, (View)localObject3));
              localObject3 = paramViewGroup;
            }
          }
          else
          {
            localObject3 = localObject1;
            if (localObject2 != null)
            {
              j = ((View)localObject2).getVisibility();
              v.a((View)localObject2, 0);
              localObject3 = a(paramViewGroup, (View)localObject2, paramp1, paramp2);
              if (localObject3 != null)
              {
                paramViewGroup = new b0.a((View)localObject2, i, true);
                ((Animator)localObject3).addListener(paramViewGroup);
                ((Animator)localObject3).addPauseListener(paramViewGroup);
                a(paramViewGroup);
              }
              else
              {
                v.a((View)localObject2, j);
              }
            }
          }
        }
      }
    }
    return (Animator)localObject3;
  }
  
  public void a(p paramp)
  {
    d(paramp);
  }
  
  public boolean a(p paramp1, p paramp2)
  {
    boolean bool1 = false;
    if ((paramp1 == null) && (paramp2 == null)) {
      return false;
    }
    if ((paramp1 != null) && (paramp2 != null) && (a.containsKey("android:visibility:visibility") != a.containsKey("android:visibility:visibility"))) {
      return false;
    }
    paramp1 = b(paramp1, paramp2);
    boolean bool2 = bool1;
    if (a) {
      if (c != 0)
      {
        bool2 = bool1;
        if (d != 0) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public final b0.b b(p paramp1, p paramp2)
  {
    b0.b localb = new b0.b();
    a = false;
    b = false;
    if ((paramp1 != null) && (a.containsKey("android:visibility:visibility")))
    {
      c = ((Integer)a.get("android:visibility:visibility")).intValue();
      e = ((ViewGroup)a.get("android:visibility:parent"));
    }
    else
    {
      c = -1;
      e = null;
    }
    if ((paramp2 != null) && (a.containsKey("android:visibility:visibility")))
    {
      d = ((Integer)a.get("android:visibility:visibility")).intValue();
      f = ((ViewGroup)a.get("android:visibility:parent"));
    }
    else
    {
      d = -1;
      f = null;
    }
    if ((paramp1 != null) && (paramp2 != null))
    {
      if ((c == d) && (e == f)) {
        return localb;
      }
      int i = c;
      int j = d;
      if (i != j)
      {
        if (i == 0)
        {
          b = false;
          a = true;
        }
        else if (j == 0)
        {
          b = true;
          a = true;
        }
      }
      else if (f == null)
      {
        b = false;
        a = true;
      }
      else if (e == null)
      {
        b = true;
        a = true;
      }
    }
    else if ((paramp1 == null) && (d == 0))
    {
      b = true;
      a = true;
    }
    else if ((paramp2 == null) && (c == 0))
    {
      b = false;
      a = true;
    }
    return localb;
  }
  
  public String[] b()
  {
    return g0;
  }
  
  public final void d(p paramp)
  {
    int i = b.getVisibility();
    a.put("android:visibility:visibility", Integer.valueOf(i));
    a.put("android:visibility:parent", b.getParent());
    int[] arrayOfInt = new int[2];
    b.getLocationOnScreen(arrayOfInt);
    a.put("android:visibility:screenLocation", arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     base.d.x.b0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */