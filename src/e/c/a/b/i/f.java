package e.c.a.b.i;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.b;
import e.c.a.b.l.a;
import e.c.a.b.l.b;
import java.util.ArrayList;

public class f
  extends e
{
  public InsetDrawable C;
  
  public f(e.c.a.b.j.f paramf, b paramb)
  {
    super(paramf, paramb);
  }
  
  public float a()
  {
    return o.getElevation();
  }
  
  public final Animator a(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(o, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(o, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(e.v);
    return localAnimatorSet;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      o.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(e.w, a(paramFloat1, paramFloat3));
      localStateListAnimator.addState(e.x, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(e.y, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(e.z, a(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(o, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      int i = Build.VERSION.SDK_INT;
      if ((i >= 22) && (i <= 24))
      {
        e.c.a.b.j.f localf = o;
        localArrayList.add(ObjectAnimator.ofFloat(localf, View.TRANSLATION_Z, new float[] { localf.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(o, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(e.v);
      localStateListAnimator.addState(e.A, localAnimatorSet);
      localStateListAnimator.addState(e.B, a(0.0F, 0.0F));
      o.setStateListAnimator(localStateListAnimator);
    }
    if (p).a.G) {
      g();
    }
  }
  
  public void a(ColorStateList paramColorStateList) {}
  
  public void a(Rect paramRect)
  {
    b localb = p;
    if (a.G)
    {
      float f1 = a.getSizeDimension() / 2.0F;
      float f2 = o.getElevation() + k;
      int i = (int)Math.ceil(a.a(f2, f1, false));
      int j = (int)Math.ceil(f2 * 1.5F);
      paramRect.set(i, j, i, j);
    }
    else
    {
      paramRect.set(0, 0, 0, 0);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21) {
      if (o.isEnabled())
      {
        o.setElevation(i);
        if (o.isPressed()) {
          o.setTranslationZ(k);
        } else if ((!o.isFocused()) && (!o.isHovered())) {
          o.setTranslationZ(0.0F);
        } else {
          o.setTranslationZ(j);
        }
      }
      else
      {
        o.setElevation(0.0F);
        o.setTranslationZ(0.0F);
      }
    }
  }
  
  public void b(Rect paramRect)
  {
    FloatingActionButton localFloatingActionButton = p).a;
    if (G)
    {
      paramRect = new InsetDrawable(null, left, top, right, bottom);
      C = paramRect;
      FloatingActionButton.a(p).a, paramRect);
    }
    else
    {
      FloatingActionButton.a(localFloatingActionButton, null);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    g();
  }
  
  public boolean e()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.i.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */