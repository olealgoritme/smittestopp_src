package d.x;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class o
{
  public static final boolean a;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  public static Animator a(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null) {
      return paramAnimator2;
    }
    if (paramAnimator2 == null) {
      return paramAnimator1;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  public static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    v.a.a(paramView1, localMatrix);
    v.a.b(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int i = Math.round(left);
    int j = Math.round(top);
    int k = Math.round(right);
    int m = Math.round(bottom);
    ImageView localImageView = new ImageView(paramView1.getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    boolean bool1 = paramView1.isAttachedToWindow() ^ true;
    boolean bool2;
    if (paramViewGroup == null) {
      bool2 = false;
    } else {
      bool2 = paramViewGroup.isAttachedToWindow();
    }
    paramView2 = null;
    Object localObject = null;
    ViewGroup localViewGroup;
    int n;
    if (bool1)
    {
      if (!bool2)
      {
        localObject = paramView2;
        break label415;
      }
      localViewGroup = (ViewGroup)paramView1.getParent();
      n = localViewGroup.indexOfChild(paramView1);
      paramViewGroup.getOverlay().add(paramView1);
    }
    else
    {
      localViewGroup = null;
      n = 0;
    }
    int i1 = Math.round(localRectF.width());
    int i2 = Math.round(localRectF.height());
    paramView2 = (View)localObject;
    if (i1 > 0)
    {
      paramView2 = (View)localObject;
      if (i2 > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (i1 * i2));
        i1 = Math.round(i1 * f);
        i2 = Math.round(i2 * f);
        localMatrix.postTranslate(-left, -top);
        localMatrix.postScale(f, f);
        if (a)
        {
          paramView2 = new Picture();
          localObject = paramView2.beginRecording(i1, i2);
          ((Canvas)localObject).concat(localMatrix);
          paramView1.draw((Canvas)localObject);
          paramView2.endRecording();
          paramView2 = Bitmap.createBitmap(paramView2);
        }
        else
        {
          paramView2 = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
          localObject = new Canvas(paramView2);
          ((Canvas)localObject).concat(localMatrix);
          paramView1.draw((Canvas)localObject);
        }
      }
    }
    localObject = paramView2;
    if (bool1)
    {
      paramViewGroup.getOverlay().remove(paramView1);
      localViewGroup.addView(paramView1, n);
      localObject = paramView2;
    }
    label415:
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localImageView.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    localImageView.layout(i, j, k, m);
    return localImageView;
  }
}

/* Location:
 * Qualified Name:     d.x.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */