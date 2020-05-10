package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IconCompat
  extends CustomVersionedParcelable
{
  public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;
  public int a = -1;
  public Object b;
  public byte[] c = null;
  public Parcelable d = null;
  public int e = 0;
  public int f = 0;
  public ColorStateList g = null;
  public PorterDuff.Mode h = j;
  public String i = null;
  
  public IconCompat() {}
  
  public IconCompat(int paramInt)
  {
    a = paramInt;
  }
  
  public static IconCompat a(Resources paramResources, String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramInt != 0)
      {
        IconCompat localIconCompat = new IconCompat(2);
        e = paramInt;
        if (paramResources != null) {
          try
          {
            b = paramResources.getResourceName(paramInt);
          }
          catch (Resources.NotFoundException paramResources)
          {
            throw new IllegalArgumentException("Icon resource cannot be found");
          }
        } else {
          b = paramString;
        }
        return localIconCompat;
      }
      throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }
    throw new IllegalArgumentException("Package must not be null.");
  }
  
  public int a()
  {
    if (a == -1)
    {
      int k = Build.VERSION.SDK_INT;
      if (k >= 23)
      {
        Icon localIcon = (Icon)b;
        if (k >= 28)
        {
          k = localIcon.getResId();
        }
        else
        {
          int m = 0;
          try
          {
            k = ((Integer)localIcon.getClass().getMethod("getResId", new Class[0]).invoke(localIcon, new Object[0])).intValue();
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            Log.e("IconCompat", "Unable to get icon resource", localNoSuchMethodException);
            k = m;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Log.e("IconCompat", "Unable to get icon resource", localInvocationTargetException);
            k = m;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            Log.e("IconCompat", "Unable to get icon resource", localIllegalAccessException);
            k = m;
          }
        }
        return k;
      }
    }
    if (a == 2) {
      return e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("called getResId() on ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String b()
  {
    if (a == -1)
    {
      int k = Build.VERSION.SDK_INT;
      if (k >= 23)
      {
        Object localObject1 = (Icon)b;
        if (k >= 28)
        {
          localObject2 = ((Icon)localObject1).getResPackage();
        }
        else
        {
          localObject2 = null;
          try
          {
            localObject1 = (String)localObject1.getClass().getMethod("getResPackage", new Class[0]).invoke(localObject1, new Object[0]);
            localObject2 = localObject1;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            Log.e("IconCompat", "Unable to get icon package", localNoSuchMethodException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Log.e("IconCompat", "Unable to get icon package", localInvocationTargetException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            Log.e("IconCompat", "Unable to get icon package", localIllegalAccessException);
          }
        }
        return (String)localObject2;
      }
    }
    if (a == 2) {
      return ((String)b).split(":", -1)[0];
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("called getResPackage() on ");
    ((StringBuilder)localObject2).append(this);
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  public Icon c()
  {
    int k = a;
    if (k != -1)
    {
      Object localObject1;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k == 5)
              {
                if (Build.VERSION.SDK_INT >= 26)
                {
                  localObject1 = Icon.createWithAdaptiveBitmap((Bitmap)b);
                }
                else
                {
                  localObject2 = (Bitmap)b;
                  k = (int)(Math.min(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()) * 0.6666667F);
                  localObject1 = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
                  Canvas localCanvas = new Canvas((Bitmap)localObject1);
                  Paint localPaint = new Paint(3);
                  float f1 = k * 0.5F;
                  localPaint.setColor(-16777216);
                  Object localObject3 = Shader.TileMode.CLAMP;
                  BitmapShader localBitmapShader = new BitmapShader((Bitmap)localObject2, (Shader.TileMode)localObject3, (Shader.TileMode)localObject3);
                  localObject3 = new Matrix();
                  ((Matrix)localObject3).setTranslate(-(((Bitmap)localObject2).getWidth() - k) / 2, -(((Bitmap)localObject2).getHeight() - k) / 2);
                  localBitmapShader.setLocalMatrix((Matrix)localObject3);
                  localPaint.setShader(localBitmapShader);
                  localCanvas.drawCircle(f1, f1, 0.9166667F * f1, localPaint);
                  localCanvas.setBitmap(null);
                  localObject1 = Icon.createWithBitmap((Bitmap)localObject1);
                }
              }
              else {
                throw new IllegalArgumentException("Unknown type");
              }
            }
            else {
              localObject1 = Icon.createWithContentUri((String)b);
            }
          }
          else {
            localObject1 = Icon.createWithData((byte[])b, e, f);
          }
        }
        else {
          localObject1 = Icon.createWithResource(b(), e);
        }
      }
      else {
        localObject1 = Icon.createWithBitmap((Bitmap)b);
      }
      Object localObject2 = g;
      if (localObject2 != null) {
        ((Icon)localObject1).setTintList((ColorStateList)localObject2);
      }
      localObject2 = h;
      if (localObject2 != j) {
        ((Icon)localObject1).setTintMode((PorterDuff.Mode)localObject2);
      }
      return (Icon)localObject1;
    }
    return (Icon)b;
  }
  
  public String toString()
  {
    if (a == -1) {
      return String.valueOf(b);
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=");
    int k = a;
    String str;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              str = "UNKNOWN";
            } else {
              str = "BITMAP_MASKABLE";
            }
          }
          else {
            str = "URI";
          }
        }
        else {
          str = "DATA";
        }
      }
      else {
        str = "RESOURCE";
      }
    }
    else {
      str = "BITMAP";
    }
    localStringBuilder.append(str);
    k = a;
    if (k != 1) {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              break label298;
            }
          }
          else
          {
            localStringBuilder.append(" uri=");
            localStringBuilder.append(b);
            break label298;
          }
        }
        else
        {
          localStringBuilder.append(" len=");
          localStringBuilder.append(e);
          if (f == 0) {
            break label298;
          }
          localStringBuilder.append(" off=");
          localStringBuilder.append(f);
          break label298;
        }
      }
      else
      {
        localStringBuilder.append(" pkg=");
        localStringBuilder.append(b());
        localStringBuilder.append(" id=");
        localStringBuilder.append(String.format("0x%08x", new Object[] { Integer.valueOf(a()) }));
        break label298;
      }
    }
    localStringBuilder.append(" size=");
    localStringBuilder.append(((Bitmap)b).getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(((Bitmap)b).getHeight());
    label298:
    if (g != null)
    {
      localStringBuilder.append(" tint=");
      localStringBuilder.append(g);
    }
    if (h != j)
    {
      localStringBuilder.append(" mode=");
      localStringBuilder.append(h);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.androidx.core.graphics.drawable.IconCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */