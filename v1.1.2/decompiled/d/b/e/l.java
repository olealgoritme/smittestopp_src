package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.R.attr;

public class l
  extends ImageButton
{
  public final e x;
  public final m y;
  
  public l(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public l(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public l(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    paramContext = new m(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = x;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = y;
    if (localObject != null) {
      ((m)localObject).a();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).b();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).c();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    Object localObject = y;
    if (localObject != null)
    {
      localObject = b;
      if (localObject != null) {
        return a;
      }
    }
    localObject = null;
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    Object localObject = y;
    if (localObject != null)
    {
      localObject = b;
      if (localObject != null) {
        return b;
      }
    }
    localObject = null;
    return (PorterDuff.Mode)localObject;
  }
  
  public boolean hasOverlappingRendering()
  {
    boolean bool1 = y.a.getBackground() instanceof RippleDrawable;
    boolean bool2 = true;
    if ((!(bool1 ^ true)) || (!super.hasOverlappingRendering())) {
      bool2 = false;
    }
    return bool2;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = x;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    e locale = x;
    if (locale != null) {
      locale.a(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = y;
    if (paramBitmap != null) {
      paramBitmap.a();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = y;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    y.a(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = y;
    if (paramUri != null) {
      paramUri.a();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    e locale = x;
    if (locale != null) {
      locale.b(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    e locale = x;
    if (locale != null) {
      locale.a(paramMode);
    }
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    m localm = y;
    if (localm != null) {
      localm.a(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    m localm = y;
    if (localm != null) {
      localm.a(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */