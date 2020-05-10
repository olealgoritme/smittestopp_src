package d.b.e;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import d.i.c.j.b;

public class q
{
  public static final int[] c = { 16843067, 16843068 };
  public final ProgressBar a;
  public Bitmap b;
  
  public q(ProgressBar paramProgressBar)
  {
    a = paramProgressBar;
  }
  
  public final Drawable a(Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((paramDrawable instanceof b))
    {
      localObject1 = (b)paramDrawable;
      localObject2 = ((b)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject1).a(a((Drawable)localObject2, paramBoolean));
      }
    }
    else
    {
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = paramDrawable.getNumberOfLayers();
        localObject2 = new Drawable[i];
        int j = 0;
        for (int k = 0; k < i; k++)
        {
          int m = paramDrawable.getId(k);
          localObject1 = paramDrawable.getDrawable(k);
          if ((m != 16908301) && (m != 16908303)) {
            paramBoolean = false;
          } else {
            paramBoolean = true;
          }
          localObject2[k] = a((Drawable)localObject1, paramBoolean);
        }
        localObject2 = new LayerDrawable((Drawable[])localObject2);
        for (k = j; k < i; k++) {
          ((LayerDrawable)localObject2).setId(k, paramDrawable.getId(k));
        }
        return (Drawable)localObject2;
      }
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = (BitmapDrawable)paramDrawable;
        localObject1 = paramDrawable.getBitmap();
        if (b == null) {
          b = ((Bitmap)localObject1);
        }
        localObject2 = new ShapeDrawable(new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null));
        localObject1 = new BitmapShader((Bitmap)localObject1, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        ((ShapeDrawable)localObject2).getPaint().setShader((Shader)localObject1);
        ((ShapeDrawable)localObject2).getPaint().setColorFilter(paramDrawable.getPaint().getColorFilter());
        paramDrawable = (Drawable)localObject2;
        if (paramBoolean) {
          paramDrawable = new ClipDrawable((Drawable)localObject2, 3, 1);
        }
        return paramDrawable;
      }
    }
    return paramDrawable;
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    x0 localx0 = x0.a(a.getContext(), paramAttributeSet, c, paramInt, 0);
    Drawable localDrawable = localx0.c(0);
    if (localDrawable != null)
    {
      ProgressBar localProgressBar = a;
      paramAttributeSet = localDrawable;
      if ((localDrawable instanceof AnimationDrawable))
      {
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)localDrawable;
        int i = localAnimationDrawable.getNumberOfFrames();
        paramAttributeSet = new AnimationDrawable();
        paramAttributeSet.setOneShot(localAnimationDrawable.isOneShot());
        for (paramInt = 0; paramInt < i; paramInt++)
        {
          localDrawable = a(localAnimationDrawable.getFrame(paramInt), true);
          localDrawable.setLevel(10000);
          paramAttributeSet.addFrame(localDrawable, localAnimationDrawable.getDuration(paramInt));
        }
        paramAttributeSet.setLevel(10000);
      }
      localProgressBar.setIndeterminateDrawable(paramAttributeSet);
    }
    paramAttributeSet = localx0.c(1);
    if (paramAttributeSet != null) {
      a.setProgressDrawable(a(paramAttributeSet, false));
    }
    b.recycle();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */