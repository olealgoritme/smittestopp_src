package d.k.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import d.i.i.n;
import java.util.Arrays;

public class a
{
  public static final Interpolator v = new a.a();
  public int a;
  public int b;
  public int c = -1;
  public float[] d;
  public float[] e;
  public float[] f;
  public float[] g;
  public int[] h;
  public int[] i;
  public int[] j;
  public int k;
  public VelocityTracker l;
  public float m;
  public float n;
  public int o;
  public OverScroller p;
  public final a.c q;
  public View r;
  public boolean s;
  public final ViewGroup t;
  public final Runnable u = new a.b(this);
  
  public a(Context paramContext, ViewGroup paramViewGroup, a.c paramc)
  {
    if (paramViewGroup != null)
    {
      if (paramc != null)
      {
        t = paramViewGroup;
        q = paramc;
        paramViewGroup = ViewConfiguration.get(paramContext);
        o = ((int)(getResourcesgetDisplayMetricsdensity * 20.0F + 0.5F));
        b = paramViewGroup.getScaledTouchSlop();
        m = paramViewGroup.getScaledMaximumFlingVelocity();
        n = paramViewGroup.getScaledMinimumFlingVelocity();
        p = new OverScroller(paramContext, v);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  public final float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      return 0.0F;
    }
    if (f1 > paramFloat3)
    {
      if (paramFloat1 <= 0.0F) {
        paramFloat3 = -paramFloat3;
      }
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      return 0;
    }
    if (i1 > paramInt3)
    {
      if (paramInt1 <= 0) {
        paramInt3 = -paramInt3;
      }
      return paramInt3;
    }
    return paramInt1;
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    int i1 = t.getChildCount() - 1;
    while (i1 >= 0)
    {
      Object localObject = t;
      if (q != null)
      {
        localObject = ((ViewGroup)localObject).getChildAt(i1);
        if ((paramInt1 >= ((View)localObject).getLeft()) && (paramInt1 < ((View)localObject).getRight()) && (paramInt2 >= ((View)localObject).getTop()) && (paramInt2 < ((View)localObject).getBottom())) {
          return (View)localObject;
        }
        i1--;
      }
      else
      {
        throw null;
      }
    }
    return null;
  }
  
  public void a()
  {
    c = -1;
    Object localObject = d;
    if (localObject != null)
    {
      Arrays.fill((float[])localObject, 0.0F);
      Arrays.fill(e, 0.0F);
      Arrays.fill(f, 0.0F);
      Arrays.fill(g, 0.0F);
      Arrays.fill(h, 0);
      Arrays.fill(i, 0);
      Arrays.fill(j, 0);
      k = 0;
    }
    localObject = l;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      l = null;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    s = true;
    q.a(r, paramFloat1, paramFloat2);
    s = false;
    if (a == 1) {
      d(0);
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i1 = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, 1)) {
      i1 = 0;
    }
    int i2 = i1;
    if (a(paramFloat2, paramFloat1, paramInt, 4)) {
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if (a(paramFloat1, paramFloat2, paramInt, 2)) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (a(paramFloat2, paramFloat1, paramInt, 8)) {
      i2 = i1 | 0x8;
    }
    if (i2 != 0)
    {
      int[] arrayOfInt = i;
      arrayOfInt[paramInt] |= i2;
      if (q == null) {
        throw null;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if ((d != null) && (b(paramInt)))
    {
      d[paramInt] = 0.0F;
      e[paramInt] = 0.0F;
      f[paramInt] = 0.0F;
      g[paramInt] = 0.0F;
      h[paramInt] = 0;
      i[paramInt] = 0;
      j[paramInt] = 0;
      k = (1 << paramInt & k);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0) {
      a();
    }
    if (l == null) {
      l = VelocityTracker.obtain();
    }
    l.addMovement(paramMotionEvent);
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        Object localObject;
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 == 6)
              {
                i3 = paramMotionEvent.getPointerId(i2);
                if ((a == 1) && (i3 == c))
                {
                  i4 = paramMotionEvent.getPointerCount();
                  while (i5 < i4)
                  {
                    i2 = paramMotionEvent.getPointerId(i5);
                    if (i2 != c)
                    {
                      f1 = paramMotionEvent.getX(i5);
                      f2 = paramMotionEvent.getY(i5);
                      View localView = a((int)f1, (int)f2);
                      localObject = r;
                      if ((localView == localObject) && (b((View)localObject, i2)))
                      {
                        i5 = c;
                        break label206;
                      }
                    }
                    i5++;
                  }
                  i5 = -1;
                  label206:
                  if (i5 == -1) {
                    b();
                  }
                }
                a(i3);
              }
            }
            else
            {
              i4 = paramMotionEvent.getPointerId(i2);
              f1 = paramMotionEvent.getX(i2);
              f2 = paramMotionEvent.getY(i2);
              b(f1, f2, i4);
              if (a == 0)
              {
                b(a((int)f1, (int)f2), i4);
                if (((h[i4] & 0x0) != 0) && (q == null)) {
                  throw null;
                }
              }
              else
              {
                i2 = (int)f1;
                i1 = (int)f2;
                paramMotionEvent = r;
                if (paramMotionEvent == null)
                {
                  i5 = i3;
                }
                else
                {
                  i5 = i3;
                  if (i2 >= paramMotionEvent.getLeft())
                  {
                    i5 = i3;
                    if (i2 < paramMotionEvent.getRight())
                    {
                      i5 = i3;
                      if (i1 >= paramMotionEvent.getTop())
                      {
                        i5 = i3;
                        if (i1 < paramMotionEvent.getBottom()) {
                          i5 = 1;
                        }
                      }
                    }
                  }
                }
                if (i5 != 0) {
                  b(r, i4);
                }
              }
            }
          }
          else
          {
            if (a == 1) {
              a(0.0F, 0.0F);
            }
            a();
          }
        }
        else if (a == 1)
        {
          if (c(c))
          {
            i5 = paramMotionEvent.findPointerIndex(c);
            f1 = paramMotionEvent.getX(i5);
            f2 = paramMotionEvent.getY(i5);
            localObject = f;
            i5 = c;
            i2 = (int)(f1 - localObject[i5]);
            int i6 = (int)(f2 - g[i5]);
            i3 = r.getLeft() + i2;
            i4 = r.getTop() + i6;
            i1 = r.getLeft();
            int i7 = r.getTop();
            i5 = i3;
            if (i2 != 0)
            {
              i5 = q.a(r, i3, i2);
              n.c(r, i5 - i1);
            }
            i3 = i4;
            if (i6 != 0)
            {
              i3 = q.b(r, i4, i6);
              n.d(r, i3 - i7);
            }
            if ((i2 != 0) || (i6 != 0)) {
              q.a(r, i5, i3, i5 - i1, i3 - i7);
            }
            b(paramMotionEvent);
          }
        }
        else
        {
          i3 = paramMotionEvent.getPointerCount();
          for (i5 = i4; i5 < i3; i5++)
          {
            i4 = paramMotionEvent.getPointerId(i5);
            if (c(i4))
            {
              float f3 = paramMotionEvent.getX(i5);
              f1 = paramMotionEvent.getY(i5);
              float f4 = f3 - d[i4];
              f2 = f1 - e[i4];
              a(f4, f2, i4);
              if (a == 1) {
                break;
              }
              localObject = a((int)f3, (int)f1);
              if ((a((View)localObject, f4, f2)) && (b((View)localObject, i4))) {
                break;
              }
            }
          }
          b(paramMotionEvent);
        }
      }
      else
      {
        if (a == 1) {
          b();
        }
        a();
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i5 = paramMotionEvent.getPointerId(0);
      paramMotionEvent = a((int)f1, (int)f2);
      b(f1, f2, i5);
      b(paramMotionEvent, i5);
      if (((h[i5] & 0x0) != 0) && (q == null)) {
        throw null;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView.getParent() == t)
    {
      r = paramView;
      c = paramInt;
      q.a(paramView, paramInt);
      d(1);
      return;
    }
    paramView = e.a.a.a.a.a("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    paramView.append(t);
    paramView.append(")");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i1 = h[paramInt1];
    boolean bool1 = false;
    boolean bool2 = bool1;
    if ((i1 & paramInt2) == paramInt2)
    {
      bool2 = bool1;
      if ((0x0 & paramInt2) != 0)
      {
        bool2 = bool1;
        if ((j[paramInt1] & paramInt2) != paramInt2)
        {
          bool2 = bool1;
          if ((i[paramInt1] & paramInt2) != paramInt2)
          {
            i1 = b;
            if ((paramFloat1 <= i1) && (paramFloat2 <= i1))
            {
              bool2 = bool1;
            }
            else
            {
              if ((paramFloat1 < paramFloat2 * 0.5F) && (q == null)) {
                throw null;
              }
              bool2 = bool1;
              if ((i[paramInt1] & paramInt2) == 0)
              {
                bool2 = bool1;
                if (paramFloat1 > b) {
                  bool2 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = r.getLeft();
    int i2 = r.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      p.abortAnimation();
      d(0);
      return false;
    }
    View localView = r;
    paramInt3 = a(paramInt3, (int)n, (int)m);
    paramInt4 = a(paramInt4, (int)n, (int)m);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(paramInt3);
    int i6 = Math.abs(paramInt4);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    if (paramInt3 != 0)
    {
      f1 = i5;
      f2 = i7;
    }
    else
    {
      f1 = i3;
      f2 = i8;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f2 = i6;
      f1 = i7;
    }
    else
    {
      f2 = i4;
      f1 = i8;
    }
    float f1 = f2 / f1;
    paramInt3 = b(paramInt1, paramInt3, q.a(localView));
    paramInt4 = b(paramInt2, paramInt4, q.b(localView));
    float f2 = paramInt3;
    paramInt3 = (int)(paramInt4 * f1 + f2 * f3);
    p.startScroll(i1, i2, paramInt1, paramInt2, paramInt3);
    d(2);
    return true;
  }
  
  public final boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramView == null) {
      return false;
    }
    int i1;
    if (q.a(paramView) > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (q.b(paramView) > 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0))
    {
      i1 = b;
      if (paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1 > i1 * i1) {
        bool3 = true;
      }
      return bool3;
    }
    if (i1 != 0)
    {
      bool3 = bool1;
      if (Math.abs(paramFloat1) > b) {
        bool3 = true;
      }
      return bool3;
    }
    bool3 = bool2;
    if (i2 != 0)
    {
      bool3 = bool2;
      if (Math.abs(paramFloat2) > b) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    r = paramView;
    c = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (a == 0) && (r != null)) {
      r = null;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i1 = a;
    boolean bool1 = false;
    if (i1 == 2)
    {
      boolean bool2 = p.computeScrollOffset();
      int i2 = p.getCurrX();
      i1 = p.getCurrY();
      int i3 = i2 - r.getLeft();
      int i4 = i1 - r.getTop();
      if (i3 != 0) {
        n.c(r, i3);
      }
      if (i4 != 0) {
        n.d(r, i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        q.a(r, i2, i1, i3, i4);
      }
      boolean bool3 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        if (i2 == p.getFinalX())
        {
          bool3 = bool2;
          if (i1 == p.getFinalY())
          {
            p.abortAnimation();
            bool3 = false;
          }
        }
      }
      if (!bool3) {
        if (paramBoolean) {
          t.post(u);
        } else {
          d(0);
        }
      }
    }
    paramBoolean = bool1;
    if (a == 2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = t.getWidth();
    int i2 = i1 / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f2 = i2;
    f1 = (float)Math.sin((f1 - 0.5F) * 0.47123894F);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 * f2 + f2) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  public final void b()
  {
    l.computeCurrentVelocity(1000, m);
    a(a(l.getXVelocity(c), n, m), a(l.getYVelocity(c), n, m));
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject1 = d;
    int i1 = 0;
    if ((localObject1 == null) || (localObject1.length <= paramInt))
    {
      i2 = paramInt + 1;
      float[] arrayOfFloat1 = new float[i2];
      float[] arrayOfFloat2 = new float[i2];
      float[] arrayOfFloat3 = new float[i2];
      localObject1 = new float[i2];
      int[] arrayOfInt1 = new int[i2];
      int[] arrayOfInt2 = new int[i2];
      int[] arrayOfInt3 = new int[i2];
      Object localObject2 = d;
      if (localObject2 != null)
      {
        System.arraycopy(localObject2, 0, arrayOfFloat1, 0, localObject2.length);
        localObject2 = e;
        System.arraycopy(localObject2, 0, arrayOfFloat2, 0, localObject2.length);
        localObject2 = f;
        System.arraycopy(localObject2, 0, arrayOfFloat3, 0, localObject2.length);
        localObject2 = g;
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        localObject2 = h;
        System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
        localObject2 = i;
        System.arraycopy(localObject2, 0, arrayOfInt2, 0, localObject2.length);
        localObject2 = j;
        System.arraycopy(localObject2, 0, arrayOfInt3, 0, localObject2.length);
      }
      d = arrayOfFloat1;
      e = arrayOfFloat2;
      f = arrayOfFloat3;
      g = ((float[])localObject1);
      h = arrayOfInt1;
      i = arrayOfInt2;
      j = arrayOfInt3;
    }
    localObject1 = d;
    f[paramInt] = paramFloat1;
    localObject1[paramInt] = paramFloat1;
    localObject1 = e;
    g[paramInt] = paramFloat2;
    localObject1[paramInt] = paramFloat2;
    localObject1 = h;
    int i3 = (int)paramFloat1;
    int i4 = (int)paramFloat2;
    if (i3 < t.getLeft() + o) {
      i1 = 1;
    }
    int i2 = i1;
    if (i4 < t.getTop() + o) {
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if (i3 > t.getRight() - o) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (i4 > t.getBottom() - o) {
      i2 = i1 | 0x8;
    }
    localObject1[paramInt] = i2;
    k |= 1 << paramInt;
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = paramMotionEvent.getPointerId(i2);
      if (c(i3))
      {
        float f1 = paramMotionEvent.getX(i2);
        float f2 = paramMotionEvent.getY(i2);
        f[i3] = f1;
        g[i3] = f2;
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    int i1 = k;
    boolean bool = true;
    if ((1 << paramInt & i1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (s) {
      return a(paramInt1, paramInt2, (int)l.getXVelocity(c), (int)l.getYVelocity(c));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean b(View paramView, int paramInt)
  {
    if ((paramView == r) && (c == paramInt)) {
      return true;
    }
    if ((paramView != null) && (q.b(paramView, paramInt)))
    {
      c = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public final boolean c(int paramInt)
  {
    if (!b(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring pointerId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" because ACTION_DOWN was not received ");
      localStringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
      localStringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
      Log.e("ViewDragHelper", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0) {
      a();
    }
    if (l == null) {
      l = VelocityTracker.obtain();
    }
    l.addMovement(paramMotionEvent);
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 == 3) {
            break label481;
          }
          if (i1 != 5) {
            if (i1 != 6) {
              break label572;
            }
          }
        }
      }
      for (;;)
      {
        a(paramMotionEvent.getPointerId(i2));
        continue;
        i1 = paramMotionEvent.getPointerId(i2);
        f1 = paramMotionEvent.getX(i2);
        f2 = paramMotionEvent.getY(i2);
        b(f1, f2, i1);
        i2 = a;
        if (i2 == 0)
        {
          if (((h[i1] & 0x0) != 0) && (q == null)) {
            throw null;
          }
        }
        else if (i2 == 2)
        {
          paramMotionEvent = a((int)f1, (int)f2);
          if (paramMotionEvent == r)
          {
            b(paramMotionEvent, i1);
            continue;
            if ((d != null) && (e != null))
            {
              int i3 = paramMotionEvent.getPointerCount();
              for (i2 = 0; i2 < i3; i2++)
              {
                int i4 = paramMotionEvent.getPointerId(i2);
                if (c(i4))
                {
                  f1 = paramMotionEvent.getX(i2);
                  float f3 = paramMotionEvent.getY(i2);
                  f2 = f1 - d[i4];
                  float f4 = f3 - e[i4];
                  View localView = a((int)f1, (int)f3);
                  if ((localView != null) && (a(localView, f2, f4))) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  }
                  if (i1 != 0)
                  {
                    int i5 = localView.getLeft();
                    int i6 = (int)f2;
                    int i7 = q.a(localView, i5 + i6, i6);
                    i6 = localView.getTop();
                    int i8 = (int)f4;
                    i8 = q.b(localView, i6 + i8, i8);
                    int i9 = q.a(localView);
                    int i10 = q.b(localView);
                    if (((i9 == 0) || ((i9 > 0) && (i7 == i5))) && ((i10 == 0) || ((i10 > 0) && (i8 == i6)))) {
                      break;
                    }
                  }
                  else
                  {
                    a(f2, f4, i4);
                    if ((a == 1) || ((i1 != 0) && (b(localView, i4)))) {
                      break;
                    }
                  }
                }
              }
              b(paramMotionEvent);
              continue;
              label481:
              a();
            }
          }
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i2 = paramMotionEvent.getPointerId(0);
      b(f1, f2, i2);
      paramMotionEvent = a((int)f1, (int)f2);
      if ((paramMotionEvent == r) && (a == 2)) {
        b(paramMotionEvent, i2);
      }
      if (((h[i2] & 0x0) != 0) && (q == null)) {
        throw null;
      }
    }
    label572:
    boolean bool;
    if (a == 1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void d(int paramInt)
  {
    t.removeCallbacks(u);
    if (a != paramInt)
    {
      a = paramInt;
      q.a(paramInt);
      if (a == 0) {
        r = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.k.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */