package d.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.a;
import androidx.constraintlayout.widget.R.id;
import androidx.constraintlayout.widget.R.styleable;
import e.a.a.a.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c
{
  public static final int[] b = { 0, 4, 8 };
  public static SparseIntArray c;
  public HashMap<Integer, a> a = new HashMap();
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    c = localSparseIntArray;
    localSparseIntArray.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    c.append(R.styleable.ConstraintSet_android_orientation, 27);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
    c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    c.append(R.styleable.ConstraintSet_android_layout_width, 23);
    c.append(R.styleable.ConstraintSet_android_layout_height, 21);
    c.append(R.styleable.ConstraintSet_android_visibility, 22);
    c.append(R.styleable.ConstraintSet_android_alpha, 43);
    c.append(R.styleable.ConstraintSet_android_elevation, 44);
    c.append(R.styleable.ConstraintSet_android_rotationX, 45);
    c.append(R.styleable.ConstraintSet_android_rotationY, 46);
    c.append(R.styleable.ConstraintSet_android_rotation, 60);
    c.append(R.styleable.ConstraintSet_android_scaleX, 47);
    c.append(R.styleable.ConstraintSet_android_scaleY, 48);
    c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    c.append(R.styleable.ConstraintSet_android_translationX, 51);
    c.append(R.styleable.ConstraintSet_android_translationY, 52);
    c.append(R.styleable.ConstraintSet_android_translationZ, 53);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    c.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    c.append(R.styleable.ConstraintSet_android_id, 38);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
    c.append(R.styleable.ConstraintSet_chainUseRtl, 71);
    c.append(R.styleable.ConstraintSet_barrierDirection, 72);
    c.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
    c.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
  }
  
  public final a a(Context paramContext, AttributeSet paramAttributeSet)
  {
    a locala = new a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    int i = paramContext.getIndexCount();
    for (int j = 0; j < i; j++)
    {
      int k = paramContext.getIndex(j);
      int m = c.get(k);
      int n;
      switch (m)
      {
      default: 
        switch (m)
        {
        default: 
          switch (m)
          {
          default: 
            paramAttributeSet = a.a("Unknown attribute 0x");
            paramAttributeSet.append(Integer.toHexString(k));
            paramAttributeSet.append("   ");
            paramAttributeSet.append(c.get(k));
            Log.w("ConstraintSet", paramAttributeSet.toString());
          }
          break;
        }
        break;
      case 53: 
        g0 = paramContext.getDimension(k, g0);
        break;
      case 52: 
        f0 = paramContext.getDimension(k, f0);
        break;
      case 51: 
        e0 = paramContext.getDimension(k, e0);
        break;
      case 50: 
        d0 = paramContext.getFloat(k, d0);
        break;
      case 49: 
        c0 = paramContext.getFloat(k, c0);
        break;
      case 48: 
        b0 = paramContext.getFloat(k, b0);
        break;
      case 47: 
        a0 = paramContext.getFloat(k, a0);
        break;
      case 46: 
        Z = paramContext.getFloat(k, Z);
        break;
      case 45: 
        Y = paramContext.getFloat(k, Y);
        break;
      case 44: 
        V = true;
        W = paramContext.getDimension(k, W);
        break;
      case 43: 
        U = paramContext.getFloat(k, U);
        break;
      case 42: 
        T = paramContext.getInt(k, T);
        break;
      case 41: 
        S = paramContext.getInt(k, S);
        break;
      case 40: 
        Q = paramContext.getFloat(k, Q);
        break;
      case 39: 
        R = paramContext.getFloat(k, R);
        break;
      case 38: 
        d = paramContext.getResourceId(k, d);
        break;
      case 37: 
        v = paramContext.getFloat(k, v);
        break;
      case 36: 
        n = paramContext.getResourceId(k, l);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        l = m;
        break;
      case 35: 
        n = paramContext.getResourceId(k, m);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        m = m;
        break;
      case 34: 
        F = paramContext.getDimensionPixelSize(k, F);
        break;
      case 33: 
        n = paramContext.getResourceId(k, r);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        r = m;
        break;
      case 32: 
        n = paramContext.getResourceId(k, q);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        q = m;
        break;
      case 31: 
        I = paramContext.getDimensionPixelSize(k, I);
        break;
      case 30: 
        n = paramContext.getResourceId(k, k);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        k = m;
        break;
      case 29: 
        n = paramContext.getResourceId(k, j);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        j = m;
        break;
      case 28: 
        E = paramContext.getDimensionPixelSize(k, E);
        break;
      case 27: 
        C = paramContext.getInt(k, C);
        break;
      case 26: 
        n = paramContext.getResourceId(k, i);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        i = m;
        break;
      case 25: 
        n = paramContext.getResourceId(k, h);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        h = m;
        break;
      case 24: 
        D = paramContext.getDimensionPixelSize(k, D);
        break;
      case 23: 
        b = paramContext.getLayoutDimension(k, b);
        break;
      case 22: 
        m = paramContext.getInt(k, J);
        J = m;
        J = b[m];
        break;
      case 21: 
        c = paramContext.getLayoutDimension(k, c);
        break;
      case 20: 
        u = paramContext.getFloat(k, u);
        break;
      case 19: 
        g = paramContext.getFloat(k, g);
        break;
      case 18: 
        f = paramContext.getDimensionPixelOffset(k, f);
        break;
      case 17: 
        e = paramContext.getDimensionPixelOffset(k, e);
        break;
      case 16: 
        L = paramContext.getDimensionPixelSize(k, L);
        break;
      case 15: 
        P = paramContext.getDimensionPixelSize(k, P);
        break;
      case 14: 
        M = paramContext.getDimensionPixelSize(k, M);
        break;
      case 13: 
        K = paramContext.getDimensionPixelSize(k, K);
        break;
      case 12: 
        O = paramContext.getDimensionPixelSize(k, O);
        break;
      case 11: 
        N = paramContext.getDimensionPixelSize(k, N);
        break;
      case 10: 
        n = paramContext.getResourceId(k, s);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        s = m;
        break;
      case 9: 
        n = paramContext.getResourceId(k, t);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        t = m;
        break;
      case 8: 
        H = paramContext.getDimensionPixelSize(k, H);
        break;
      case 7: 
        B = paramContext.getDimensionPixelOffset(k, B);
        break;
      case 6: 
        A = paramContext.getDimensionPixelOffset(k, A);
        break;
      case 5: 
        w = paramContext.getString(k);
        break;
      case 4: 
        n = paramContext.getResourceId(k, n);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        n = m;
        break;
      case 3: 
        n = paramContext.getResourceId(k, o);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        o = m;
        break;
      case 2: 
        G = paramContext.getDimensionPixelSize(k, G);
        break;
      case 1: 
        n = paramContext.getResourceId(k, p);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        p = m;
        continue;
        z = paramContext.getFloat(k, z);
        continue;
        y = paramContext.getDimensionPixelSize(k, y);
        continue;
        n = paramContext.getResourceId(k, x);
        m = n;
        if (n == -1) {
          m = paramContext.getInt(k, -1);
        }
        x = m;
        continue;
        X = paramContext.getFloat(k, X);
        continue;
        paramAttributeSet = a.a("unused attribute 0x");
        paramAttributeSet.append(Integer.toHexString(k));
        paramAttributeSet.append("   ");
        paramAttributeSet.append(c.get(k));
        Log.w("ConstraintSet", paramAttributeSet.toString());
        continue;
        r0 = paramContext.getBoolean(k, r0);
        continue;
        v0 = paramContext.getString(k);
        continue;
        s0 = paramContext.getInt(k, s0);
        continue;
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        continue;
        q0 = paramContext.getFloat(k, 1.0F);
        continue;
        p0 = paramContext.getFloat(k, 1.0F);
      }
    }
    paramContext.recycle();
    return locala;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      for (paramInt = localXmlResourceParser.getEventType(); paramInt != 1; paramInt = localXmlResourceParser.next()) {
        if (paramInt != 0)
        {
          if (paramInt == 2)
          {
            String str = localXmlResourceParser.getName();
            a locala = a(paramContext, Xml.asAttributeSet(localXmlResourceParser));
            if (str.equalsIgnoreCase("Guideline")) {
              a = true;
            }
            a.put(Integer.valueOf(d), locala);
          }
        }
        else {
          localXmlResourceParser.getName();
        }
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final int[] a(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    Context localContext = paramView.getContext();
    paramString = new int[arrayOfString.length];
    int i = 0;
    for (int j = 0; i < arrayOfString.length; j++)
    {
      String str = arrayOfString[i].trim();
      try
      {
        k = R.id.class.getField(str).getInt(null);
      }
      catch (Exception localException)
      {
        k = 0;
      }
      int m = k;
      if (k == 0) {
        m = localContext.getResources().getIdentifier(str, "id", localContext.getPackageName());
      }
      int k = m;
      if (m == 0)
      {
        k = m;
        if (paramView.isInEditMode())
        {
          k = m;
          if ((paramView.getParent() instanceof ConstraintLayout))
          {
            Object localObject = ((ConstraintLayout)paramView.getParent()).a(0, str);
            k = m;
            if (localObject != null)
            {
              k = m;
              if ((localObject instanceof Integer)) {
                k = ((Integer)localObject).intValue();
              }
            }
          }
        }
      }
      paramString[j] = k;
      i++;
    }
    paramView = paramString;
    if (j != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, j);
    }
    return paramView;
  }
  
  public static class a
  {
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = -1;
    public int I = -1;
    public int J = 0;
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public int P = -1;
    public float Q = 0.0F;
    public float R = 0.0F;
    public int S = 0;
    public int T = 0;
    public float U = 1.0F;
    public boolean V = false;
    public float W = 0.0F;
    public float X = 0.0F;
    public float Y = 0.0F;
    public float Z = 0.0F;
    public boolean a = false;
    public float a0 = 1.0F;
    public int b;
    public float b0 = 1.0F;
    public int c;
    public float c0 = NaN.0F;
    public int d;
    public float d0 = NaN.0F;
    public int e = -1;
    public float e0 = 0.0F;
    public int f = -1;
    public float f0 = 0.0F;
    public float g = -1.0F;
    public float g0 = 0.0F;
    public int h = -1;
    public boolean h0 = false;
    public int i = -1;
    public boolean i0 = false;
    public int j = -1;
    public int j0 = 0;
    public int k = -1;
    public int k0 = 0;
    public int l = -1;
    public int l0 = -1;
    public int m = -1;
    public int m0 = -1;
    public int n = -1;
    public int n0 = -1;
    public int o = -1;
    public int o0 = -1;
    public int p = -1;
    public float p0 = 1.0F;
    public int q = -1;
    public float q0 = 1.0F;
    public int r = -1;
    public boolean r0 = false;
    public int s = -1;
    public int s0 = -1;
    public int t = -1;
    public int t0 = -1;
    public float u = 0.5F;
    public int[] u0;
    public float v = 0.5F;
    public String v0;
    public String w = null;
    public int x = -1;
    public int y = 0;
    public float z = 0.0F;
    
    public final void a(int paramInt, d.a parama)
    {
      d = paramInt;
      h = d;
      i = e;
      j = f;
      k = g;
      l = h;
      m = i;
      n = j;
      o = k;
      p = l;
      q = p;
      r = q;
      s = r;
      t = s;
      u = z;
      v = A;
      w = B;
      x = m;
      y = n;
      z = o;
      A = P;
      B = Q;
      C = R;
      g = c;
      e = a;
      f = b;
      b = width;
      c = height;
      D = leftMargin;
      E = rightMargin;
      F = topMargin;
      G = bottomMargin;
      Q = E;
      R = D;
      T = G;
      S = F;
      boolean bool = S;
      h0 = bool;
      i0 = T;
      j0 = H;
      k0 = I;
      h0 = bool;
      l0 = L;
      m0 = M;
      n0 = J;
      o0 = K;
      p0 = N;
      q0 = O;
      H = parama.getMarginEnd();
      I = parama.getMarginStart();
      U = m0;
      X = p0;
      Y = q0;
      Z = r0;
      a0 = s0;
      b0 = t0;
      c0 = u0;
      d0 = v0;
      e0 = w0;
      f0 = x0;
      g0 = y0;
      W = o0;
      V = n0;
    }
    
    public void a(ConstraintLayout.a parama)
    {
      d = h;
      e = i;
      f = j;
      g = k;
      h = l;
      i = m;
      j = n;
      k = o;
      l = p;
      p = q;
      q = r;
      r = s;
      s = t;
      leftMargin = D;
      rightMargin = E;
      topMargin = F;
      bottomMargin = G;
      x = P;
      y = O;
      z = u;
      A = v;
      m = x;
      n = y;
      o = z;
      B = w;
      P = A;
      Q = B;
      E = Q;
      D = R;
      G = T;
      F = S;
      S = h0;
      T = i0;
      H = j0;
      I = k0;
      L = l0;
      M = m0;
      J = n0;
      K = o0;
      N = p0;
      O = q0;
      R = C;
      c = g;
      a = e;
      b = f;
      width = b;
      height = c;
      parama.setMarginStart(I);
      parama.setMarginEnd(H);
      parama.a();
    }
    
    public Object clone()
    {
      a locala = new a();
      a = a;
      b = b;
      c = c;
      e = e;
      f = f;
      g = g;
      h = h;
      i = i;
      j = j;
      k = k;
      l = l;
      m = m;
      n = n;
      o = o;
      p = p;
      q = q;
      r = r;
      s = s;
      t = t;
      u = u;
      v = v;
      w = w;
      A = A;
      B = B;
      u = u;
      u = u;
      u = u;
      u = u;
      u = u;
      C = C;
      D = D;
      E = E;
      F = F;
      G = G;
      H = H;
      I = I;
      J = J;
      K = K;
      L = L;
      M = M;
      N = N;
      O = O;
      P = P;
      Q = Q;
      R = R;
      S = S;
      T = T;
      U = U;
      V = V;
      W = W;
      X = X;
      Y = Y;
      Z = Z;
      a0 = a0;
      b0 = b0;
      c0 = c0;
      d0 = d0;
      e0 = e0;
      f0 = f0;
      g0 = g0;
      h0 = h0;
      i0 = i0;
      j0 = j0;
      k0 = k0;
      l0 = l0;
      m0 = m0;
      n0 = n0;
      o0 = o0;
      p0 = p0;
      q0 = q0;
      s0 = s0;
      t0 = t0;
      int[] arrayOfInt = u0;
      if (arrayOfInt != null) {
        u0 = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
      }
      x = x;
      y = y;
      z = z;
      r0 = r0;
      return locala;
    }
  }
}

/* Location:
 * Qualified Name:     d.g.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */