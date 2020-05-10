package d.b.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

import androidx.appcompat.resources.R.styleable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import d.b.a.r;
import d.b.e.n0;
import d.f.i;
import d.y.a.a.c;
import d.y.a.a.g;

@SuppressLint({"RestrictedAPI"})
public class a
  extends e
  implements d.i.c.j.a
{
  public a.c L;
  public a.g M;
  public int N = -1;
  public int O = -1;
  public boolean P;
  
  public a()
  {
    this(null, null);
  }
  
  public a(a.c paramc, Resources paramResources)
  {
    super(null);
    paramc = new a.c(paramc, this, paramResources);
    super.a(paramc);
    L = paramc;
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = paramXmlPullParser.getName();
    if (((String)localObject1).equals("animated-selector"))
    {
      localObject1 = null;
      a locala = new a(null, null);
      Object localObject2 = r.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
      locala.setVisible(((TypedArray)localObject2).getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
      Object localObject3 = L;
      d |= ((TypedArray)localObject2).getChangingConfigurations();
      i = ((TypedArray)localObject2).getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, i);
      l = ((TypedArray)localObject2).getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, l);
      A = ((TypedArray)localObject2).getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, A);
      B = ((TypedArray)localObject2).getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, B);
      locala.setDither(((TypedArray)localObject2).getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, x));
      x.a(paramResources);
      ((TypedArray)localObject2).recycle();
      int i = paramXmlPullParser.getDepth() + 1;
      label895:
      for (;;)
      {
        int j = paramXmlPullParser.next();
        if (j == 1) {
          break;
        }
        int k = paramXmlPullParser.getDepth();
        if ((k < i) && (j == 3)) {
          break;
        }
        if ((j == 2) && (k <= i))
        {
          int i2;
          if (paramXmlPullParser.getName().equals("item"))
          {
            localObject2 = r.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
            int m = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
            k = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
            if (k > 0) {
              localObject1 = n0.a().b(paramContext, k);
            }
            ((TypedArray)localObject2).recycle();
            int n = paramAttributeSet.getAttributeCount();
            localObject2 = new int[n];
            j = 0;
            k = 0;
            while (k < n)
            {
              int i1 = paramAttributeSet.getAttributeNameResource(k);
              i2 = j;
              if (i1 != 0)
              {
                i2 = j;
                if (i1 != 16842960)
                {
                  i2 = j;
                  if (i1 != 16843161)
                  {
                    if (paramAttributeSet.getAttributeBooleanValue(k, false)) {
                      i2 = i1;
                    } else {
                      i2 = -i1;
                    }
                    localObject2[j] = i2;
                    i2 = j + 1;
                  }
                }
              }
              k++;
              j = i2;
            }
            localObject3 = StateSet.trimStateSet((int[])localObject2, j);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              do
              {
                k = paramXmlPullParser.next();
              } while (k == 4);
              if (k == 2)
              {
                if (paramXmlPullParser.getName().equals("vector")) {
                  localObject2 = g.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
                } else {
                  localObject2 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
                }
              }
              else {
                throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
              }
            }
            if (localObject2 != null)
            {
              localObject1 = L;
              k = ((b.c)localObject1).a((Drawable)localObject2);
              J[k] = localObject3;
              L.c(k, Integer.valueOf(m));
            }
            else
            {
              throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
            }
          }
          else if (paramXmlPullParser.getName().equals("transition"))
          {
            localObject2 = r.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableTransition);
            k = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
            j = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
            i2 = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
            if (i2 > 0) {
              localObject1 = n0.a().b(paramContext, i2);
            } else {
              localObject1 = null;
            }
            boolean bool = ((TypedArray)localObject2).getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
            ((TypedArray)localObject2).recycle();
            if (localObject1 == null)
            {
              do
              {
                i2 = paramXmlPullParser.next();
              } while (i2 == 4);
              if (i2 == 2)
              {
                if (paramXmlPullParser.getName().equals("animated-vector"))
                {
                  localObject1 = new c(paramContext, null, null);
                  ((c)localObject1).inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
                }
                else
                {
                  localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
                }
              }
              else {
                throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
              }
            }
            if (localObject1 != null)
            {
              if ((k != -1) && (j != -1))
              {
                L.a(k, j, (Drawable)localObject1, bool);
                localObject1 = null;
                break label895;
              }
              throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
            }
            throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
          }
          localObject1 = null;
        }
      }
      locala.onStateChange(locala.getState());
      return locala;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": invalid animated-selector tag ");
    paramContext.append((String)localObject1);
    throw new XmlPullParserException(paramContext.toString());
  }
  
  public b.c a()
  {
    return new a.c(L, this, null);
  }
  
  public e.a a()
  {
    return new a.c(L, this, null);
  }
  
  public void a(b.c paramc)
  {
    super.a(paramc);
    if ((paramc instanceof a.c)) {
      L = ((a.c)paramc);
    }
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    a.g localg = M;
    if (localg != null)
    {
      localg.d();
      M = null;
      a(N);
      N = -1;
      O = -1;
    }
  }
  
  public Drawable mutate()
  {
    if (!P)
    {
      super.mutate();
      L.d();
      P = true;
    }
    return this;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = L.b(paramArrayOfInt);
    int j = D;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i != j)
    {
      localObject = M;
      if (localObject != null) {
        if (i != N) {}
      }
      for (;;)
      {
        j = 1;
        break label402;
        if ((i == O) && (((a.g)localObject).a()))
        {
          ((a.g)localObject).b();
          N = O;
          O = i;
        }
        else
        {
          j = N;
          ((a.g)localObject).d();
          M = null;
          O = -1;
          N = -1;
          a.c localc = L;
          int k = localc.b(j);
          int m = localc.b(i);
          if ((m == 0) || (k == 0)) {
            break;
          }
          long l = a.c.a(k, m);
          int n = (int)((Long)K.b(l, Long.valueOf(-1L))).longValue();
          if (n < 0) {
            break;
          }
          l = a.c.a(k, m);
          if ((((Long)K.b(l, Long.valueOf(-1L))).longValue() & 0x200000000) != 0L) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          a(n);
          localObject = z;
          if ((localObject instanceof AnimationDrawable))
          {
            l = a.c.a(k, m);
            if ((((Long)K.b(l, Long.valueOf(-1L))).longValue() & 0x100000000) != 0L) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            localObject = new a.e((AnimationDrawable)localObject, bool3, bool2);
          }
          else if ((localObject instanceof c))
          {
            localObject = new a.d((c)localObject);
          }
          else
          {
            if (!(localObject instanceof Animatable)) {
              break;
            }
            localObject = new a.b((Animatable)localObject);
          }
          ((a.g)localObject).c();
          M = ((a.g)localObject);
          O = j;
          N = i;
        }
      }
      j = 0;
      label402:
      if (j == 0)
      {
        bool2 = bool1;
        if (!a(i)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    Object localObject = z;
    boolean bool3 = bool2;
    if (localObject != null) {
      bool3 = bool2 | ((Drawable)localObject).setState(paramArrayOfInt);
    }
    return bool3;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((M != null) && ((bool) || (paramBoolean2))) {
      if (paramBoolean1) {
        M.c();
      } else {
        jumpToCurrentState();
      }
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */