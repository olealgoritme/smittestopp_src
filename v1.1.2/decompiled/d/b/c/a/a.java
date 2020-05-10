package d.b.c.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.f.i;
import d.y.a.a.c;
import d.y.a.a.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
  extends e
{
  public c L;
  public g M;
  public int N = -1;
  public int O = -1;
  public boolean P;
  
  public a()
  {
    this(null, null);
  }
  
  public a(c paramc, Resources paramResources)
  {
    super(null);
    paramc = new c(paramc, this, paramResources);
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
      Object localObject2 = s.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
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
      label889:
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
            localObject2 = s.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
            int m = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
            j = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
            if (j > 0) {
              localObject1 = d.b.b.a.a.c(paramContext, j);
            }
            ((TypedArray)localObject2).recycle();
            int n = paramAttributeSet.getAttributeCount();
            localObject2 = new int[n];
            k = 0;
            j = 0;
            while (j < n)
            {
              int i1 = paramAttributeSet.getAttributeNameResource(j);
              i2 = k;
              if (i1 != 0)
              {
                i2 = k;
                if (i1 != 16842960)
                {
                  i2 = k;
                  if (i1 != 16843161)
                  {
                    if (paramAttributeSet.getAttributeBooleanValue(j, false)) {
                      i2 = i1;
                    } else {
                      i2 = -i1;
                    }
                    localObject2[k] = i2;
                    i2 = k + 1;
                  }
                }
              }
              j++;
              k = i2;
            }
            localObject3 = StateSet.trimStateSet((int[])localObject2, k);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              do
              {
                j = paramXmlPullParser.next();
              } while (j == 4);
              if (j == 2)
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
              j = ((b.c)localObject1).a((Drawable)localObject2);
              J[j] = localObject3;
              L.c(j, Integer.valueOf(m));
            }
            else
            {
              throw new XmlPullParserException(e.a.a.a.a.a(paramXmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
            }
          }
          else if (paramXmlPullParser.getName().equals("transition"))
          {
            localObject2 = s.a(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableTransition);
            k = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
            j = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
            i2 = ((TypedArray)localObject2).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
            if (i2 > 0) {
              localObject1 = d.b.b.a.a.c(paramContext, i2);
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
                break label889;
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
    return new c(L, this, null);
  }
  
  public e.a a()
  {
    return new c(L, this, null);
  }
  
  public void a(b.c paramc)
  {
    super.a(paramc);
    if ((paramc instanceof c)) {
      L = ((c)paramc);
    }
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    g localg = M;
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
        if ((i == O) && (((g)localObject).a()))
        {
          ((g)localObject).b();
          N = O;
          O = i;
        }
        else
        {
          j = N;
          ((g)localObject).d();
          M = null;
          O = -1;
          N = -1;
          localObject = L;
          int k = ((c)localObject).b(j);
          int m = ((c)localObject).b(i);
          if ((m == 0) || (k == 0)) {
            break;
          }
          long l = c.a(k, m);
          int n = (int)((Long)K.b(l, Long.valueOf(-1L))).longValue();
          if (n < 0) {
            break;
          }
          l = c.a(k, m);
          if ((((Long)K.b(l, Long.valueOf(-1L))).longValue() & 0x200000000) != 0L) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          a(n);
          Drawable localDrawable = z;
          if ((localDrawable instanceof AnimationDrawable))
          {
            l = c.a(k, m);
            if ((((Long)K.b(l, Long.valueOf(-1L))).longValue() & 0x100000000) != 0L) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            localObject = new e((AnimationDrawable)localDrawable, bool3, bool2);
          }
          else if ((localDrawable instanceof c))
          {
            localObject = new d((c)localDrawable);
          }
          else
          {
            if (!(localDrawable instanceof Animatable)) {
              break;
            }
            localObject = new b((Animatable)localDrawable);
          }
          ((g)localObject).c();
          M = ((g)localObject);
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
  
  public static class b
    extends a.g
  {
    public final Animatable a;
    
    public b(Animatable paramAnimatable)
    {
      super();
      a = paramAnimatable;
    }
    
    public void c()
    {
      a.start();
    }
    
    public void d()
    {
      a.stop();
    }
  }
  
  public static class c
    extends e.a
  {
    public d.f.e<Long> K;
    public i<Integer> L;
    
    public c(c paramc, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      if (paramc != null)
      {
        K = K;
        L = L;
      }
      else
      {
        K = new d.f.e();
        L = new i(10);
      }
    }
    
    public static long a(int paramInt1, int paramInt2)
    {
      long l = paramInt1;
      return paramInt2 | l << 32;
    }
    
    public int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      int i = super.a(paramDrawable);
      long l1 = a(paramInt1, paramInt2);
      long l2;
      if (paramBoolean) {
        l2 = 8589934592L;
      } else {
        l2 = 0L;
      }
      paramDrawable = K;
      long l3 = i;
      paramDrawable.a(l1, Long.valueOf(l3 | l2));
      if (paramBoolean)
      {
        l1 = a(paramInt2, paramInt1);
        K.a(l1, Long.valueOf(0x100000000 | l3 | l2));
      }
      return i;
    }
    
    public int b(int paramInt)
    {
      int i = 0;
      if (paramInt < 0) {
        paramInt = i;
      } else {
        paramInt = ((Integer)L.b(paramInt, Integer.valueOf(0))).intValue();
      }
      return paramInt;
    }
    
    public int b(int[] paramArrayOfInt)
    {
      int i = super.a(paramArrayOfInt);
      if (i >= 0) {
        return i;
      }
      return super.a(StateSet.WILD_CARD);
    }
    
    public void d()
    {
      K = K.clone();
      L = L.clone();
    }
    
    public Drawable newDrawable()
    {
      return new a(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new a(this, paramResources);
    }
  }
  
  public static class d
    extends a.g
  {
    public final c a;
    
    public d(c paramc)
    {
      super();
      a = paramc;
    }
    
    public void c()
    {
      a.start();
    }
    
    public void d()
    {
      a.stop();
    }
  }
  
  public static class e
    extends a.g
  {
    public final ObjectAnimator a;
    public final boolean b;
    
    public e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      int i = paramAnimationDrawable.getNumberOfFrames();
      int j;
      if (paramBoolean1) {
        j = i - 1;
      } else {
        j = 0;
      }
      if (paramBoolean1) {
        i = 0;
      } else {
        i--;
      }
      a.f localf = new a.f(paramAnimationDrawable, paramBoolean1);
      paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { j, i });
      paramAnimationDrawable.setAutoCancel(true);
      paramAnimationDrawable.setDuration(c);
      paramAnimationDrawable.setInterpolator(localf);
      b = paramBoolean2;
      a = paramAnimationDrawable;
    }
    
    public boolean a()
    {
      return b;
    }
    
    public void b()
    {
      a.reverse();
    }
    
    public void c()
    {
      a.start();
    }
    
    public void d()
    {
      a.cancel();
    }
  }
  
  public static class f
    implements TimeInterpolator
  {
    public int[] a;
    public int b;
    public int c;
    
    public f(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      int i = paramAnimationDrawable.getNumberOfFrames();
      b = i;
      int[] arrayOfInt = a;
      if ((arrayOfInt == null) || (arrayOfInt.length < i)) {
        a = new int[i];
      }
      arrayOfInt = a;
      int j = 0;
      int k = 0;
      while (j < i)
      {
        if (paramBoolean) {
          m = i - j - 1;
        } else {
          m = j;
        }
        int m = paramAnimationDrawable.getDuration(m);
        arrayOfInt[j] = m;
        k += m;
        j++;
      }
      c = k;
    }
    
    public float getInterpolation(float paramFloat)
    {
      int i = (int)(paramFloat * c + 0.5F);
      int j = b;
      int[] arrayOfInt = a;
      for (int k = 0; (k < j) && (i >= arrayOfInt[k]); k++) {
        i -= arrayOfInt[k];
      }
      if (k < j) {
        paramFloat = i / c;
      } else {
        paramFloat = 0.0F;
      }
      return k / j + paramFloat;
    }
  }
  
  public static abstract class g
  {
    public boolean a()
    {
      return false;
    }
    
    public void b() {}
    
    public abstract void c();
    
    public abstract void d();
  }
}

/* Location:
 * Qualified Name:     d.b.c.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */