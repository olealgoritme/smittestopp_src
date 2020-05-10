package d.x;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

public class v
{
  public static final z a;
  public static Field b;
  public static boolean c;
  public static final Property<View, Float> d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      a = new y();
    } else {
      a = new x();
    }
    d = new v.a(Float.class, "translationAlpha");
    new v.b(Rect.class, "clipBounds");
  }
  
  public static u a(View paramView)
  {
    return new t(paramView);
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (!c)
    {
      try
      {
        Field localField1 = View.class.getDeclaredField("mViewFlags");
        b = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i("ViewUtils", "fetchViewFlagsField: ");
      }
      c = true;
    }
    Field localField2 = b;
    if (localField2 != null) {}
    try
    {
      int i = localField2.getInt(paramView);
      b.setInt(paramView, paramInt | i & 0xFFFFFFF3);
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static float b(View paramView)
  {
    return a.b(paramView);
  }
  
  public static d0 c(View paramView)
  {
    return new c0(paramView);
  }
}

/* Location:
 * Qualified Name:     base.d.x.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */