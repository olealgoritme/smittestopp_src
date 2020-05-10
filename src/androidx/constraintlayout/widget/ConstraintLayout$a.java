package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.g.a.h.d;
import d.g.a.h.g;

public class ConstraintLayout$a
  extends ViewGroup.MarginLayoutParams
{
  public float A = 0.5F;
  public String B = null;
  public int C = 1;
  public float D = -1.0F;
  public float E = -1.0F;
  public int F = 0;
  public int G = 0;
  public int H = 0;
  public int I = 0;
  public int J = 0;
  public int K = 0;
  public int L = 0;
  public int M = 0;
  public float N = 1.0F;
  public float O = 1.0F;
  public int P = -1;
  public int Q = -1;
  public int R = -1;
  public boolean S = false;
  public boolean T = false;
  public boolean U = true;
  public boolean V = true;
  public boolean W = false;
  public boolean X = false;
  public boolean Y = false;
  public boolean Z = false;
  public int a = -1;
  public int a0 = -1;
  public int b = -1;
  public int b0 = -1;
  public float c = -1.0F;
  public int c0 = -1;
  public int d = -1;
  public int d0 = -1;
  public int e = -1;
  public int e0 = -1;
  public int f = -1;
  public int f0 = -1;
  public int g = -1;
  public float g0 = 0.5F;
  public int h = -1;
  public int h0;
  public int i = -1;
  public int i0;
  public int j = -1;
  public float j0;
  public int k = -1;
  public d k0 = new d();
  public int l = -1;
  public boolean l0 = false;
  public int m = -1;
  public int n = 0;
  public float o = 0.0F;
  public int p = -1;
  public int q = -1;
  public int r = -1;
  public int s = -1;
  public int t = -1;
  public int u = -1;
  public int v = -1;
  public int w = -1;
  public int x = -1;
  public int y = -1;
  public float z = 0.5F;
  
  public ConstraintLayout$a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintLayout$a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
    int i1 = paramContext.getIndexCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = paramContext.getIndex(i2);
      int i4 = ConstraintLayout.a.a.a.get(i3);
      String str;
      switch (i4)
      {
      default: 
        switch (i4)
        {
        default: 
          break;
        case 50: 
          Q = paramContext.getDimensionPixelOffset(i3, Q);
          break;
        case 49: 
          P = paramContext.getDimensionPixelOffset(i3, P);
          break;
        case 48: 
          G = paramContext.getInt(i3, 0);
          break;
        case 47: 
          F = paramContext.getInt(i3, 0);
          break;
        case 46: 
          E = paramContext.getFloat(i3, E);
          break;
        case 45: 
          D = paramContext.getFloat(i3, D);
          break;
        case 44: 
          paramAttributeSet = paramContext.getString(i3);
          B = paramAttributeSet;
          C = -1;
          if (paramAttributeSet != null)
          {
            i4 = paramAttributeSet.length();
            i3 = B.indexOf(',');
            if ((i3 > 0) && (i3 < i4 - 1))
            {
              paramAttributeSet = B.substring(0, i3);
              if (paramAttributeSet.equalsIgnoreCase("W")) {
                C = 0;
              } else if (paramAttributeSet.equalsIgnoreCase("H")) {
                C = 1;
              }
              i3++;
            }
            else
            {
              i3 = 0;
            }
            int i5 = B.indexOf(':');
            if ((i5 >= 0) && (i5 < i4 - 1))
            {
              paramAttributeSet = B.substring(i3, i5);
              str = B.substring(i5 + 1);
              if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                continue;
              }
            }
          }
          break;
        }
        break;
      }
      try
      {
        float f1 = Float.parseFloat(paramAttributeSet);
        f2 = Float.parseFloat(str);
        if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
          continue;
        }
        if (C == 1) {
          Math.abs(f2 / f1);
        } else {
          Math.abs(f1 / f2);
        }
      }
      catch (NumberFormatException paramAttributeSet)
      {
        float f2;
        continue;
      }
      paramAttributeSet = B.substring(i3);
      if (paramAttributeSet.length() > 0)
      {
        Float.parseFloat(paramAttributeSet);
        continue;
        O = Math.max(0.0F, paramContext.getFloat(i3, O));
        continue;
        try
        {
          M = paramContext.getDimensionPixelSize(i3, M);
        }
        catch (Exception paramAttributeSet)
        {
          if (paramContext.getInt(i3, M) != -2) {
            continue;
          }
        }
        M = -2;
        continue;
        try
        {
          K = paramContext.getDimensionPixelSize(i3, K);
        }
        catch (Exception paramAttributeSet)
        {
          if (paramContext.getInt(i3, K) != -2) {
            continue;
          }
        }
        K = -2;
        continue;
        N = Math.max(0.0F, paramContext.getFloat(i3, N));
        continue;
        try
        {
          L = paramContext.getDimensionPixelSize(i3, L);
        }
        catch (Exception paramAttributeSet)
        {
          if (paramContext.getInt(i3, L) != -2) {
            continue;
          }
        }
        L = -2;
        continue;
        try
        {
          J = paramContext.getDimensionPixelSize(i3, J);
        }
        catch (Exception paramAttributeSet)
        {
          if (paramContext.getInt(i3, J) != -2) {
            continue;
          }
        }
        J = -2;
        continue;
        i3 = paramContext.getInt(i3, 0);
        I = i3;
        if (i3 == 1)
        {
          Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
          continue;
          i3 = paramContext.getInt(i3, 0);
          H = i3;
          if (i3 == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            continue;
            A = paramContext.getFloat(i3, A);
            continue;
            z = paramContext.getFloat(i3, z);
            continue;
            T = paramContext.getBoolean(i3, T);
            continue;
            S = paramContext.getBoolean(i3, S);
            continue;
            y = paramContext.getDimensionPixelSize(i3, y);
            continue;
            x = paramContext.getDimensionPixelSize(i3, x);
            continue;
            w = paramContext.getDimensionPixelSize(i3, w);
            continue;
            v = paramContext.getDimensionPixelSize(i3, v);
            continue;
            u = paramContext.getDimensionPixelSize(i3, u);
            continue;
            t = paramContext.getDimensionPixelSize(i3, t);
            continue;
            i4 = paramContext.getResourceId(i3, s);
            s = i4;
            if (i4 == -1)
            {
              s = paramContext.getInt(i3, -1);
              continue;
              i4 = paramContext.getResourceId(i3, r);
              r = i4;
              if (i4 == -1)
              {
                r = paramContext.getInt(i3, -1);
                continue;
                i4 = paramContext.getResourceId(i3, q);
                q = i4;
                if (i4 == -1)
                {
                  q = paramContext.getInt(i3, -1);
                  continue;
                  i4 = paramContext.getResourceId(i3, p);
                  p = i4;
                  if (i4 == -1)
                  {
                    p = paramContext.getInt(i3, -1);
                    continue;
                    i4 = paramContext.getResourceId(i3, l);
                    l = i4;
                    if (i4 == -1)
                    {
                      l = paramContext.getInt(i3, -1);
                      continue;
                      i4 = paramContext.getResourceId(i3, k);
                      k = i4;
                      if (i4 == -1)
                      {
                        k = paramContext.getInt(i3, -1);
                        continue;
                        i4 = paramContext.getResourceId(i3, j);
                        j = i4;
                        if (i4 == -1)
                        {
                          j = paramContext.getInt(i3, -1);
                          continue;
                          i4 = paramContext.getResourceId(i3, i);
                          i = i4;
                          if (i4 == -1)
                          {
                            i = paramContext.getInt(i3, -1);
                            continue;
                            i4 = paramContext.getResourceId(i3, h);
                            h = i4;
                            if (i4 == -1)
                            {
                              h = paramContext.getInt(i3, -1);
                              continue;
                              i4 = paramContext.getResourceId(i3, g);
                              g = i4;
                              if (i4 == -1)
                              {
                                g = paramContext.getInt(i3, -1);
                                continue;
                                i4 = paramContext.getResourceId(i3, f);
                                f = i4;
                                if (i4 == -1)
                                {
                                  f = paramContext.getInt(i3, -1);
                                  continue;
                                  i4 = paramContext.getResourceId(i3, e);
                                  e = i4;
                                  if (i4 == -1)
                                  {
                                    e = paramContext.getInt(i3, -1);
                                    continue;
                                    i4 = paramContext.getResourceId(i3, d);
                                    d = i4;
                                    if (i4 == -1)
                                    {
                                      d = paramContext.getInt(i3, -1);
                                      continue;
                                      c = paramContext.getFloat(i3, c);
                                      continue;
                                      b = paramContext.getDimensionPixelOffset(i3, b);
                                      continue;
                                      a = paramContext.getDimensionPixelOffset(i3, a);
                                      continue;
                                      f2 = paramContext.getFloat(i3, o) % 360.0F;
                                      o = f2;
                                      if (f2 < 0.0F)
                                      {
                                        o = ((360.0F - f2) % 360.0F);
                                        continue;
                                        n = paramContext.getDimensionPixelSize(i3, n);
                                        continue;
                                        i4 = paramContext.getResourceId(i3, m);
                                        m = i4;
                                        if (i4 == -1)
                                        {
                                          m = paramContext.getInt(i3, -1);
                                          continue;
                                          R = paramContext.getInt(i3, R);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramContext.recycle();
    a();
  }
  
  public ConstraintLayout$a(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public void a()
  {
    X = false;
    U = true;
    V = true;
    if ((width == -2) && (S))
    {
      U = false;
      H = 1;
    }
    if ((height == -2) && (T))
    {
      V = false;
      I = 1;
    }
    int i1 = width;
    if ((i1 == 0) || (i1 == -1))
    {
      U = false;
      if ((width == 0) && (H == 1))
      {
        width = -2;
        S = true;
      }
    }
    i1 = height;
    if ((i1 == 0) || (i1 == -1))
    {
      V = false;
      if ((height == 0) && (I == 1))
      {
        height = -2;
        T = true;
      }
    }
    if ((c != -1.0F) || (a != -1) || (b != -1))
    {
      X = true;
      U = true;
      V = true;
      if (!(k0 instanceof g)) {
        k0 = new g();
      }
      ((g)k0).g(R);
    }
  }
  
  @TargetApi(17)
  public void resolveLayoutDirection(int paramInt)
  {
    int i1 = leftMargin;
    int i2 = rightMargin;
    super.resolveLayoutDirection(paramInt);
    c0 = -1;
    d0 = -1;
    a0 = -1;
    b0 = -1;
    e0 = -1;
    f0 = -1;
    e0 = t;
    f0 = v;
    g0 = z;
    h0 = a;
    i0 = b;
    j0 = c;
    paramInt = getLayoutDirection();
    int i3 = 0;
    if (1 == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramInt = p;
      if (paramInt != -1) {
        c0 = paramInt;
      }
      for (;;)
      {
        paramInt = 1;
        break;
        int i4 = q;
        paramInt = i3;
        if (i4 == -1) {
          break;
        }
        d0 = i4;
      }
      i3 = r;
      if (i3 != -1)
      {
        b0 = i3;
        paramInt = 1;
      }
      i3 = s;
      if (i3 != -1)
      {
        a0 = i3;
        paramInt = 1;
      }
      i3 = x;
      if (i3 != -1) {
        f0 = i3;
      }
      i3 = y;
      if (i3 != -1) {
        e0 = i3;
      }
      if (paramInt != 0) {
        g0 = (1.0F - z);
      }
      if ((X) && (R == 1))
      {
        float f1 = c;
        if (f1 != -1.0F)
        {
          j0 = (1.0F - f1);
          h0 = -1;
          i0 = -1;
        }
        else
        {
          paramInt = a;
          if (paramInt != -1)
          {
            i0 = paramInt;
            h0 = -1;
            j0 = -1.0F;
          }
          else
          {
            paramInt = b;
            if (paramInt != -1)
            {
              h0 = paramInt;
              i0 = -1;
              j0 = -1.0F;
            }
          }
        }
      }
    }
    else
    {
      paramInt = p;
      if (paramInt != -1) {
        b0 = paramInt;
      }
      paramInt = q;
      if (paramInt != -1) {
        a0 = paramInt;
      }
      paramInt = r;
      if (paramInt != -1) {
        c0 = paramInt;
      }
      paramInt = s;
      if (paramInt != -1) {
        d0 = paramInt;
      }
      paramInt = x;
      if (paramInt != -1) {
        e0 = paramInt;
      }
      paramInt = y;
      if (paramInt != -1) {
        f0 = paramInt;
      }
    }
    if ((r == -1) && (s == -1) && (q == -1) && (p == -1))
    {
      paramInt = f;
      if (paramInt != -1)
      {
        c0 = paramInt;
        if ((rightMargin <= 0) && (i2 > 0)) {
          rightMargin = i2;
        }
      }
      else
      {
        paramInt = g;
        if (paramInt != -1)
        {
          d0 = paramInt;
          if ((rightMargin <= 0) && (i2 > 0)) {
            rightMargin = i2;
          }
        }
      }
      paramInt = d;
      if (paramInt != -1)
      {
        a0 = paramInt;
        if ((leftMargin <= 0) && (i1 > 0)) {
          leftMargin = i1;
        }
      }
      else
      {
        paramInt = e;
        if (paramInt != -1)
        {
          b0 = paramInt;
          if ((leftMargin <= 0) && (i1 > 0)) {
            leftMargin = i1;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.constraintlayout.widget.ConstraintLayout.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */