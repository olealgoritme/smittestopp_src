package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R.attr;
import d.b.a.r;
import d.f.d;
import d.f.e;
import d.f.f;
import d.f.h;
import d.f.i;
import d.y.a.a.g;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class n0
{
  public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
  public static n0 i;
  public static final n0.c j = new n0.c(6);
  public WeakHashMap<Context, i<ColorStateList>> a;
  public d.f.a<String, n0.d> b;
  public i<String> c;
  public final WeakHashMap<Context, e<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap(0);
  public TypedValue e;
  public boolean f;
  public n0.e g;
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      Object localObject1 = j;
      if (localObject1 != null)
      {
        int k = (paramInt + 31) * 31;
        Object localObject2 = (PorterDuffColorFilter)((f)localObject1).a(Integer.valueOf(paramMode.hashCode() + k));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new android/graphics/PorterDuffColorFilter;
          ((PorterDuffColorFilter)localObject1).<init>(paramInt, paramMode);
          localObject2 = j;
          if (localObject2 != null) {
            paramMode = (PorterDuffColorFilter)((f)localObject2).a(Integer.valueOf(paramMode.hashCode() + k), localObject1);
          } else {
            throw null;
          }
        }
        return (PorterDuffColorFilter)localObject1;
      }
      throw null;
    }
    finally {}
  }
  
  public static n0 a()
  {
    try
    {
      if (i == null)
      {
        localn0 = new d/b/e/n0;
        localn0.<init>();
        i = localn0;
        if (Build.VERSION.SDK_INT < 24)
        {
          Object localObject2 = new d/b/e/n0$f;
          ((n0.f)localObject2).<init>();
          localn0.a("vector", (n0.d)localObject2);
          localObject2 = new d/b/e/n0$b;
          ((n0.b)localObject2).<init>();
          localn0.a("animated-vector", (n0.d)localObject2);
          localObject2 = new d/b/e/n0$a;
          ((n0.a)localObject2).<init>();
          localn0.a("animated-selector", (n0.d)localObject2);
        }
      }
      n0 localn0 = i;
      return localn0;
    }
    finally {}
  }
  
  public static void a(Drawable paramDrawable, v0 paramv0, int[] paramArrayOfInt)
  {
    if ((e0.a(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
      return;
    }
    if ((!d) && (!c))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      boolean bool = d;
      Object localObject1 = null;
      ColorStateList localColorStateList;
      if (bool) {
        localColorStateList = a;
      } else {
        localColorStateList = null;
      }
      if (c) {
        paramv0 = b;
      } else {
        paramv0 = h;
      }
      Object localObject2 = localObject1;
      if (localColorStateList != null) {
        if (paramv0 == null) {
          localObject2 = localObject1;
        } else {
          localObject2 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramv0);
        }
      }
      paramDrawable.setColorFilter((ColorFilter)localObject2);
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public final Drawable a(Context paramContext, int paramInt)
  {
    if (e == null) {
      e = new TypedValue();
    }
    TypedValue localTypedValue = e;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = assetCookie << 32 | data;
    Object localObject1 = a(paramContext, l);
    if (localObject1 != null) {
      return (Drawable)localObject1;
    }
    Object localObject2 = g;
    localObject1 = null;
    if (localObject2 != null)
    {
      localObject2 = (j.a)localObject2;
      if (paramInt == androidx.appcompat.R.drawable.abc_cab_background_top_material) {
        localObject1 = new LayerDrawable(new Drawable[] { b(paramContext, androidx.appcompat.R.drawable.abc_cab_background_internal_bg), b(paramContext, androidx.appcompat.R.drawable.abc_cab_background_top_mtrl_alpha) });
      }
    }
    if (localObject1 != null)
    {
      ((Drawable)localObject1).setChangingConfigurations(changingConfigurations);
      a(paramContext, l, (Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  public Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    label176:
    try
    {
      Object localObject1;
      if (!f)
      {
        int k = 1;
        f = true;
        localObject1 = b(paramContext, androidx.appcompat.resources.R.drawable.abc_vector_test);
        if (localObject1 != null)
        {
          int m = k;
          if (!(localObject1 instanceof g)) {
            if ("android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName())) {
              m = k;
            } else {
              m = 0;
            }
          }
          if (m == 0) {}
        }
      }
      else
      {
        localObject1 = d(paramContext, paramInt);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, paramInt);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = d.i.b.a.c(paramContext, paramInt);
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject1);
        }
        if (localObject2 != null) {
          e0.b((Drawable)localObject2);
        }
        return (Drawable)localObject2;
      }
    }
    finally
    {
      break label176;
      f = false;
      paramContext = new java/lang/IllegalStateException;
      paramContext.<init>("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
      throw paramContext;
    }
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject1 = c(paramContext, paramInt);
    Object localObject2 = null;
    if (localObject1 != null)
    {
      paramContext = paramDrawable;
      if (e0.a(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = r.c(paramContext);
      paramDrawable.setTintList((ColorStateList)localObject1);
      paramContext = g;
      if (paramContext == null)
      {
        paramContext = (Context)localObject2;
      }
      else
      {
        paramContext = (j.a)paramContext;
        paramContext = (Context)localObject2;
        if (paramInt == androidx.appcompat.R.drawable.abc_switch_thumb_material) {
          paramContext = PorterDuff.Mode.MULTIPLY;
        }
      }
      localObject2 = paramDrawable;
      if (paramContext != null)
      {
        paramDrawable.setTintMode(paramContext);
        localObject2 = paramDrawable;
      }
    }
    else
    {
      localObject2 = g;
      if (localObject2 != null)
      {
        localObject2 = (j.a)localObject2;
        if (localObject2 != null)
        {
          int k = androidx.appcompat.R.drawable.abc_seekbar_track_material;
          int m = 1;
          if (paramInt == k)
          {
            localObject1 = (LayerDrawable)paramDrawable;
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908288), s0.b(paramContext, R.attr.colorControlNormal), j.b);
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908303), s0.b(paramContext, R.attr.colorControlNormal), j.b);
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908301), s0.b(paramContext, R.attr.colorControlActivated), j.b);
          }
          else if ((paramInt != androidx.appcompat.R.drawable.abc_ratingbar_material) && (paramInt != androidx.appcompat.R.drawable.abc_ratingbar_indicator_material) && (paramInt != androidx.appcompat.R.drawable.abc_ratingbar_small_material))
          {
            m = 0;
          }
          else
          {
            localObject1 = (LayerDrawable)paramDrawable;
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908288), s0.a(paramContext, R.attr.colorControlNormal), j.b);
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908303), s0.b(paramContext, R.attr.colorControlActivated), j.b);
            ((j.a)localObject2).a(((LayerDrawable)localObject1).findDrawableByLayerId(16908301), s0.b(paramContext, R.attr.colorControlActivated), j.b);
          }
          if (m != 0)
          {
            localObject2 = paramDrawable;
            break label363;
          }
        }
        else
        {
          throw null;
        }
      }
      localObject2 = paramDrawable;
      if (!a(paramContext, paramInt, paramDrawable))
      {
        localObject2 = paramDrawable;
        if (paramBoolean) {
          localObject2 = null;
        }
      }
    }
    label363:
    return (Drawable)localObject2;
  }
  
  public final Drawable a(Context paramContext, long paramLong)
  {
    try
    {
      e locale = (e)d.get(paramContext);
      if (locale == null) {
        return null;
      }
      Object localObject = (WeakReference)locale.b(paramLong, null);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        int k = d.a(y, A, paramLong);
        if (k >= 0)
        {
          Object[] arrayOfObject = z;
          paramContext = arrayOfObject[k];
          localObject = e.B;
          if (paramContext != localObject)
          {
            arrayOfObject[k] = localObject;
            x = true;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    try
    {
      paramContext = (e)d.get(paramContext);
      if (paramContext != null) {
        paramContext.a();
      }
      return;
    }
    finally {}
  }
  
  public void a(n0.e parame)
  {
    try
    {
      g = parame;
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void a(String paramString, n0.d paramd)
  {
    if (b == null) {
      b = new d.f.a();
    }
    b.put(paramString, paramd);
  }
  
  public boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    Object localObject1 = g;
    boolean bool1 = true;
    if (localObject1 != null)
    {
      Object localObject2 = (j.a)localObject1;
      if (localObject2 != null)
      {
        localObject1 = j.b;
        boolean bool2 = ((j.a)localObject2).a(a, paramInt);
        int k = 16842801;
        if (bool2)
        {
          paramInt = R.attr.colorControlNormal;
        }
        else if (((j.a)localObject2).a(c, paramInt))
        {
          paramInt = R.attr.colorControlActivated;
        }
        else if (((j.a)localObject2).a(d, paramInt))
        {
          localObject1 = PorterDuff.Mode.MULTIPLY;
          paramInt = k;
        }
        else
        {
          if (paramInt == androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha)
          {
            paramInt = 16842800;
            k = Math.round(40.8F);
            break label142;
          }
          if (paramInt != androidx.appcompat.R.drawable.abc_dialog_material_background) {
            break label156;
          }
          paramInt = k;
        }
        k = -1;
        label142:
        int m = 1;
        int n = k;
        k = m;
        break label164;
        label156:
        paramInt = 0;
        n = -1;
        k = 0;
        label164:
        if (k != 0)
        {
          localObject2 = paramDrawable;
          if (e0.a(paramDrawable)) {
            localObject2 = paramDrawable.mutate();
          }
          ((Drawable)localObject2).setColorFilter(j.a(s0.b(paramContext, paramInt), (PorterDuff.Mode)localObject1));
          if (n != -1) {
            ((Drawable)localObject2).setAlpha(n);
          }
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        if (paramInt != 0) {
          break label232;
        }
      }
      else
      {
        throw null;
      }
    }
    bool1 = false;
    label232:
    return bool1;
  }
  
  public final boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        e locale = (e)d.get(paramContext);
        paramDrawable = locale;
        if (locale == null)
        {
          paramDrawable = new d/f/e;
          paramDrawable.<init>();
          d.put(paramContext, paramDrawable);
        }
        paramContext = new java/lang/ref/WeakReference;
        paramContext.<init>(localConstantState);
        paramDrawable.c(paramLong, paramContext);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public Drawable b(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = a(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public ColorStateList c(Context paramContext, int paramInt)
  {
    label42:
    Object localObject2;
    try
    {
      Object localObject1 = a;
      i locali = null;
      if (localObject1 != null)
      {
        localObject1 = (i)((WeakHashMap)localObject1).get(paramContext);
        if (localObject1 != null)
        {
          localObject1 = (ColorStateList)((i)localObject1).b(paramInt, null);
          break label42;
        }
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (g == null)
        {
          localObject1 = locali;
        }
        else
        {
          localObject1 = g;
          localObject1 = (j.a)localObject1;
          localObject1 = ((j.a)localObject1).b(paramContext, paramInt);
        }
        if (localObject1 != null)
        {
          if (a == null)
          {
            localObject2 = new java/util/WeakHashMap;
            ((WeakHashMap)localObject2).<init>();
            a = ((WeakHashMap)localObject2);
          }
          locali = (i)a.get(paramContext);
          localObject2 = locali;
          if (locali == null)
          {
            localObject2 = new d/f/i;
            ((i)localObject2).<init>(10);
            a.put(paramContext, localObject2);
          }
          ((i)localObject2).a(paramInt, localObject1);
        }
        localObject2 = localObject1;
      }
    }
    finally
    {
      break label173;
    }
    return (ColorStateList)localObject2;
    label173:
    throw paramContext;
  }
  
  public final Drawable d(Context paramContext, int paramInt)
  {
    Object localObject1 = b;
    if ((localObject1 != null) && (!((h)localObject1).isEmpty()))
    {
      localObject1 = c;
      if (localObject1 != null)
      {
        localObject1 = (String)((i)localObject1).b(paramInt, null);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (b.getOrDefault(localObject1, null) == null))) {
          return null;
        }
      }
      else
      {
        c = new i(10);
      }
      if (e == null) {
        e = new TypedValue();
      }
      TypedValue localTypedValue = e;
      localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = assetCookie << 32 | data;
      Drawable localDrawable = a(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = string;
      Object localObject3 = localDrawable;
      if (localObject2 != null)
      {
        localObject3 = localDrawable;
        if (((CharSequence)localObject2).toString().endsWith(".xml"))
        {
          localObject3 = localDrawable;
          try
          {
            XmlResourceParser localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject3 = localDrawable;
            localObject2 = Xml.asAttributeSet(localXmlResourceParser);
            int k;
            do
            {
              localObject3 = localDrawable;
              k = localXmlResourceParser.next();
            } while ((k != 2) && (k != 1));
            if (k == 2)
            {
              localObject3 = localDrawable;
              localObject1 = localXmlResourceParser.getName();
              localObject3 = localDrawable;
              c.a(paramInt, localObject1);
              localObject3 = localDrawable;
              n0.d locald = (n0.d)b.get(localObject1);
              localObject1 = localDrawable;
              if (locald != null)
              {
                localObject3 = localDrawable;
                localObject1 = locald.a(paramContext, localXmlResourceParser, (AttributeSet)localObject2, paramContext.getTheme());
              }
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(changingConfigurations);
                localObject3 = localObject1;
                a(paramContext, l, (Drawable)localObject1);
                localObject3 = localObject1;
              }
            }
            else
            {
              localObject3 = localDrawable;
              paramContext = new org/xmlpull/v1/XmlPullParserException;
              localObject3 = localDrawable;
              paramContext.<init>("No start tag found");
              localObject3 = localDrawable;
              throw paramContext;
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject3 == null) {
        c.a(paramInt, "appcompat_skip_skip");
      }
      return (Drawable)localObject3;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.n0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */