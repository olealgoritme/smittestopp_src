package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
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
import androidx.appcompat.R.color;
import androidx.appcompat.R.drawable;
import d.b.a.s;
import d.f.d;
import d.f.e;
import d.f.f;
import d.f.h;
import d.f.i;
import d.y.a.a.c;
import d.y.a.a.g;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class j
{
  public static final PorterDuff.Mode g = PorterDuff.Mode.SRC_IN;
  public static j h;
  public static final c i = new c(6);
  public static final int[] j = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
  public static final int[] k = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
  public static final int[] l = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
  public static final int[] m = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
  public static final int[] n = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  public static final int[] o = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  public WeakHashMap<Context, i<ColorStateList>> a;
  public d.f.a<String, d> b;
  public i<String> c;
  public final WeakHashMap<Context, e<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap(0);
  public TypedValue e;
  public boolean f;
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      Object localObject1 = i;
      if (localObject1 != null)
      {
        int i1 = (paramInt + 31) * 31;
        Object localObject2 = (PorterDuffColorFilter)((f)localObject1).a(Integer.valueOf(paramMode.hashCode() + i1));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new android/graphics/PorterDuffColorFilter;
          ((PorterDuffColorFilter)localObject1).<init>(paramInt, paramMode);
          localObject2 = i;
          if (localObject2 != null) {
            paramMode = (PorterDuffColorFilter)((f)localObject2).a(Integer.valueOf(paramMode.hashCode() + i1), localObject1);
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
  
  public static j a()
  {
    try
    {
      if (h == null)
      {
        localj = new d/b/e/j;
        localj.<init>();
        h = localj;
        if (Build.VERSION.SDK_INT < 24)
        {
          Object localObject2 = new d/b/e/j$e;
          ((e)localObject2).<init>();
          localj.a("vector", (d)localObject2);
          localObject2 = new d/b/e/j$b;
          ((b)localObject2).<init>();
          localj.a("animated-vector", (d)localObject2);
          localObject2 = new d/b/e/j$a;
          ((a)localObject2).<init>();
          localj.a("animated-selector", (d)localObject2);
        }
      }
      j localj = h;
      return localj;
    }
    finally {}
  }
  
  public static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (c0.a(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = g;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  public static void a(Drawable paramDrawable, s0 params0, int[] paramArrayOfInt)
  {
    if ((c0.a(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
      return;
    }
    if ((!d) && (!c))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      boolean bool = d;
      Object localObject = null;
      ColorStateList localColorStateList;
      if (bool) {
        localColorStateList = a;
      } else {
        localColorStateList = null;
      }
      PorterDuff.Mode localMode;
      if (c) {
        localMode = b;
      } else {
        localMode = g;
      }
      params0 = (s0)localObject;
      if (localColorStateList != null) {
        if (localMode == null) {
          params0 = (s0)localObject;
        } else {
          params0 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), localMode);
        }
      }
      paramDrawable.setColorFilter(params0);
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = g;
    boolean bool = a(j, paramInt);
    int i1 = 16842801;
    if (bool) {
      paramInt = R.attr.colorControlNormal;
    }
    for (;;)
    {
      for (i1 = -1;; i1 = Math.round(40.8F))
      {
        i2 = 1;
        break label116;
        if (a(l, paramInt))
        {
          paramInt = R.attr.colorControlActivated;
          break;
        }
        if (a(m, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          paramInt = i1;
          break;
        }
        if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
          break label95;
        }
        paramInt = 16842800;
      }
      label95:
      if (paramInt != R.drawable.abc_dialog_material_background) {
        break;
      }
      paramInt = i1;
    }
    i1 = -1;
    int i2 = 0;
    paramInt = 0;
    label116:
    if (i2 != 0)
    {
      Drawable localDrawable = paramDrawable;
      if (c0.a(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(a(p0.b(paramContext, paramInt), localMode));
      if (i1 != -1) {
        localDrawable.setAlpha(i1);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = paramArrayOfInt.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (paramArrayOfInt[i2] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public final ColorStateList a(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = p0.c(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = p0.b;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = p0.e;
      arrayOfInt1[1] = p0.b(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = p0.f;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = p0.b;
      arrayOfInt1[0] = p0.a(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = p0.e;
      arrayOfInt1[1] = p0.b(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = p0.f;
      arrayOfInt1[2] = p0.b(paramContext, R.attr.colorSwitchThumbNormal);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  public final ColorStateList a(Context paramContext, int paramInt)
  {
    int i1 = p0.b(paramContext, R.attr.colorControlHighlight);
    int i2 = p0.a(paramContext, R.attr.colorButtonNormal);
    int[] arrayOfInt1 = p0.b;
    int[] arrayOfInt2 = p0.d;
    int i3 = d.i.c.a.a(i1, paramInt);
    paramContext = p0.c;
    i1 = d.i.c.a.a(i1, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, paramContext, p0.f }, new int[] { i2, i3, i1, paramInt });
  }
  
  public Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    label177:
    try
    {
      Object localObject1;
      if (!f)
      {
        int i1 = 1;
        f = true;
        localObject1 = c(paramContext, R.drawable.abc_vector_test);
        if (localObject1 != null)
        {
          int i2 = i1;
          if (!(localObject1 instanceof g)) {
            if ("android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName())) {
              i2 = i1;
            } else {
              i2 = 0;
            }
          }
          if (i2 == 0) {}
        }
      }
      else
      {
        localObject1 = e(paramContext, paramInt);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = b(paramContext, paramInt);
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
          c0.b((Drawable)localObject2);
        }
        return (Drawable)localObject2;
      }
    }
    finally
    {
      break label177;
      f = false;
      paramContext = new java/lang/IllegalStateException;
      paramContext.<init>("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
      throw paramContext;
    }
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    ColorStateList localColorStateList = d(paramContext, paramInt);
    Object localObject = null;
    if (localColorStateList != null)
    {
      paramContext = paramDrawable;
      if (c0.a(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = s.c(paramContext);
      paramDrawable.setTintList(localColorStateList);
      paramContext = (Context)localObject;
      if (paramInt == R.drawable.abc_switch_thumb_material) {
        paramContext = PorterDuff.Mode.MULTIPLY;
      }
      localObject = paramDrawable;
      if (paramContext != null)
      {
        paramDrawable.setTintMode(paramContext);
        localObject = paramDrawable;
      }
    }
    else if (paramInt == R.drawable.abc_seekbar_track_material)
    {
      localObject = (LayerDrawable)paramDrawable;
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), p0.b(paramContext, R.attr.colorControlNormal), g);
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), p0.b(paramContext, R.attr.colorControlNormal), g);
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), p0.b(paramContext, R.attr.colorControlActivated), g);
      localObject = paramDrawable;
    }
    else if ((paramInt != R.drawable.abc_ratingbar_material) && (paramInt != R.drawable.abc_ratingbar_indicator_material) && (paramInt != R.drawable.abc_ratingbar_small_material))
    {
      localObject = paramDrawable;
      if (!a(paramContext, paramInt, paramDrawable))
      {
        localObject = paramDrawable;
        if (paramBoolean) {
          localObject = null;
        }
      }
    }
    else
    {
      localObject = (LayerDrawable)paramDrawable;
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), p0.a(paramContext, R.attr.colorControlNormal), g);
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), p0.b(paramContext, R.attr.colorControlActivated), g);
      a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), p0.b(paramContext, R.attr.colorControlActivated), g);
      localObject = paramDrawable;
    }
    return (Drawable)localObject;
  }
  
  public final Drawable a(Context paramContext, long paramLong)
  {
    try
    {
      e locale = (e)d.get(paramContext);
      if (locale == null) {
        return null;
      }
      Object localObject1 = (WeakReference)locale.b(paramLong, null);
      if (localObject1 != null)
      {
        localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          paramContext = ((Drawable.ConstantState)localObject1).newDrawable(paramContext.getResources());
          return paramContext;
        }
        int i1 = d.a(y, A, paramLong);
        if (i1 >= 0)
        {
          paramContext = z;
          Object localObject2 = paramContext[i1];
          localObject1 = e.B;
          if (localObject2 != localObject1)
          {
            paramContext[i1] = localObject1;
            x = true;
          }
        }
      }
      return null;
    }
    finally {}
  }
  
  public final void a(String paramString, d paramd)
  {
    if (b == null) {
      b = new d.f.a();
    }
    b.put(paramString, paramd);
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
  
  public final Drawable b(Context paramContext, int paramInt)
  {
    if (e == null) {
      e = new TypedValue();
    }
    TypedValue localTypedValue = e;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l1 = assetCookie << 32 | data;
    Object localObject = a(paramContext, l1);
    if (localObject != null) {
      return (Drawable)localObject;
    }
    if (paramInt == R.drawable.abc_cab_background_top_material) {
      localObject = new LayerDrawable(new Drawable[] { c(paramContext, R.drawable.abc_cab_background_internal_bg), c(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) });
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(changingConfigurations);
      a(paramContext, l1, (Drawable)localObject);
    }
    return (Drawable)localObject;
  }
  
  public void b(Context paramContext)
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
  
  public Drawable c(Context paramContext, int paramInt)
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
  
  public ColorStateList d(Context paramContext, int paramInt)
  {
    Object localObject2;
    try
    {
      Object localObject1 = a;
      localObject2 = null;
      Object localObject3 = localObject2;
      if (localObject1 != null)
      {
        localObject1 = (i)((WeakHashMap)localObject1).get(paramContext);
        localObject3 = localObject2;
        if (localObject1 != null) {
          localObject3 = (ColorStateList)((i)localObject1).b(paramInt, null);
        }
      }
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        if (paramInt == R.drawable.abc_edit_text_material) {
          localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_edittext);
        } else if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
          localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_switch_track);
        } else if (paramInt == R.drawable.abc_switch_thumb_material) {
          localObject3 = a(paramContext);
        } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
          localObject3 = a(paramContext, p0.b(paramContext, R.attr.colorButtonNormal));
        } else if (paramInt == R.drawable.abc_btn_borderless_material) {
          localObject3 = a(paramContext, 0);
        } else if (paramInt == R.drawable.abc_btn_colored_material) {
          localObject3 = a(paramContext, p0.b(paramContext, R.attr.colorAccent));
        } else if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
        {
          if (a(k, paramInt)) {
            localObject3 = p0.c(paramContext, R.attr.colorControlNormal);
          } else if (a(n, paramInt)) {
            localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_default);
          } else if (a(o, paramInt)) {
            localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_btn_checkable);
          } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
            localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_seek_thumb);
          }
        }
        else {
          localObject3 = d.b.b.a.a.b(paramContext, R.color.abc_tint_spinner);
        }
        localObject2 = localObject3;
        if (localObject3 != null)
        {
          if (a == null)
          {
            localObject2 = new java/util/WeakHashMap;
            ((WeakHashMap)localObject2).<init>();
            a = ((WeakHashMap)localObject2);
          }
          localObject1 = (i)a.get(paramContext);
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new d/f/i;
            ((i)localObject2).<init>(10);
            a.put(paramContext, localObject2);
          }
          ((i)localObject2).a(paramInt, localObject3);
          localObject2 = localObject3;
        }
      }
    }
    finally
    {
      break label385;
    }
    return (ColorStateList)localObject2;
    label385:
    throw paramContext;
  }
  
  public final Drawable e(Context paramContext, int paramInt)
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
      long l1 = assetCookie << 32 | data;
      Drawable localDrawable = a(paramContext, l1);
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
            localObject2 = ((Resources)localObject1).getXml(paramInt);
            localObject3 = localDrawable;
            AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject2);
            int i1;
            do
            {
              localObject3 = localDrawable;
              i1 = ((XmlPullParser)localObject2).next();
            } while ((i1 != 2) && (i1 != 1));
            if (i1 == 2)
            {
              localObject3 = localDrawable;
              localObject1 = ((XmlPullParser)localObject2).getName();
              localObject3 = localDrawable;
              c.a(paramInt, localObject1);
              localObject3 = localDrawable;
              d locald = (d)b.get(localObject1);
              localObject1 = localDrawable;
              if (locald != null)
              {
                localObject3 = localDrawable;
                localObject1 = locald.a(paramContext, (XmlPullParser)localObject2, localAttributeSet, paramContext.getTheme());
              }
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(changingConfigurations);
                localObject3 = localObject1;
                a(paramContext, l1, (Drawable)localObject1);
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
            Log.e("AppCompatDrawableManag", "Exception while inflating drawable", paramContext);
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
  
  public static class a
    implements j.d
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = d.b.c.a.a.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
      }
      return null;
    }
  }
  
  public static class b
    implements j.d
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        Resources localResources = paramContext.getResources();
        c localc = new d/y/a/a/c;
        localc.<init>(paramContext, null, null);
        localc.inflate(localResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        return localc;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  public static class c
    extends f<Integer, PorterDuffColorFilter>
  {
    public c(int paramInt)
    {
      super();
    }
  }
  
  public static abstract interface d
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  public static class e
    implements j.d
  {
    public Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = g.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */