package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.animator;
import com.google.android.material.R.id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.i.i.n;
import e.c.a.b.a.g;
import e.c.a.b.a.i;
import e.c.a.b.g.c.d;
import e.c.a.b.g.c.e;
import e.c.a.b.o.e;
import java.util.ArrayList;

public abstract class FabTransformationBehavior
  extends ExpandableTransformationBehavior
{
  public final Rect c = new Rect();
  public final RectF d = new RectF();
  public final RectF e = new RectF();
  public final int[] f = new int[2];
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final float a(View paramView1, View paramView2, i parami)
  {
    RectF localRectF1 = d;
    RectF localRectF2 = e;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    int i = a & 0x7;
    float f1;
    float f2;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          f1 = 0.0F;
          break label114;
        }
        f1 = right;
        f2 = right;
      }
      else
      {
        f1 = left;
        f2 = left;
      }
    }
    else
    {
      f1 = localRectF2.centerX();
      f2 = localRectF1.centerX();
    }
    f1 -= f2;
    label114:
    return f1 + b;
  }
  
  public final ViewGroup a(View paramView)
  {
    if ((paramView instanceof ViewGroup)) {
      return (ViewGroup)paramView;
    }
    return null;
  }
  
  public final void a(View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = f;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  public void a(CoordinatorLayout.f paramf)
  {
    if (h == 0) {
      h = 80;
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    if (paramView1.getVisibility() != 8)
    {
      boolean bool1 = paramView2 instanceof FloatingActionButton;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if (i != 0)
        {
          bool3 = bool2;
          if (i != paramView1.getId()) {}
        }
        else
        {
          bool3 = true;
        }
      }
      return bool3;
    }
    throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
  }
  
  public final float b(View paramView1, View paramView2, i parami)
  {
    RectF localRectF1 = d;
    RectF localRectF2 = e;
    a(paramView1, localRectF1);
    a(paramView2, localRectF2);
    int i = a & 0x70;
    float f1;
    float f2;
    if (i != 16)
    {
      if (i != 48)
      {
        if (i != 80)
        {
          f1 = 0.0F;
          break label117;
        }
        f1 = bottom;
        f2 = bottom;
      }
      else
      {
        f1 = top;
        f2 = top;
      }
    }
    else
    {
      f1 = localRectF2.centerY();
      f2 = localRectF1.centerY();
    }
    f1 -= f2;
    label117:
    return f1 + c;
  }
  
  public AnimatorSet b(final View paramView1, View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    final Object localObject1 = paramView2.getContext();
    int i;
    if (paramBoolean1) {
      i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    }
    localObject1 = g.a((Context)localObject1, i);
    Object localObject2 = new i(17, 0.0F, 0.0F);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = new ArrayList();
    float f1 = n.f(paramView2) - paramView1.getElevation();
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setTranslationZ(-f1);
      }
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
    }
    else
    {
      localObject4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f1 });
    }
    ((g)localObject1).a("elevation").a((Animator)localObject4);
    localArrayList.add(localObject4);
    RectF localRectF1 = d;
    float f2 = a(paramView1, paramView2, (i)localObject2);
    f1 = b(paramView1, paramView2, (i)localObject2);
    if (f2 != 0.0F)
    {
      boolean bool1 = f1 < 0.0F;
      if (bool1)
      {
        if (((paramBoolean1) && (f1 < 0.0F)) || ((!paramBoolean1) && (bool1)))
        {
          localObject4 = ((g)localObject1).a("translationXCurveUpwards");
          localObject5 = ((g)localObject1).a("translationYCurveUpwards");
          break label274;
        }
        localObject4 = ((g)localObject1).a("translationXCurveDownwards");
        localObject5 = ((g)localObject1).a("translationYCurveDownwards");
        break label274;
      }
    }
    Object localObject4 = ((g)localObject1).a("translationXLinear");
    Object localObject5 = ((g)localObject1).a("translationYLinear");
    label274:
    ObjectAnimator localObjectAnimator;
    Object localObject6;
    long l1;
    long l2;
    float f3;
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f2);
        paramView2.setTranslationY(-f1);
      }
      localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      localObject6 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      f2 = -f2;
      f1 = -f1;
      l1 = a;
      l2 = b;
      localObject7 = ((g)localObject1).a("expansion");
      f3 = (float)(a + b + 17L - l1) / (float)l2;
      f2 = e.c.a.b.a.a.a(f2, 0.0F, ((e.c.a.b.a.h)localObject4).a().getInterpolation(f3));
      l1 = a;
      l2 = b;
      localObject7 = ((g)localObject1).a("expansion");
      f3 = (float)(a + b + 17L - l1) / (float)l2;
      f1 = e.c.a.b.a.a.a(f1, 0.0F, ((e.c.a.b.a.h)localObject5).a().getInterpolation(f3));
      Object localObject8 = c;
      localObject7 = paramView2;
      ((View)localObject7).getWindowVisibleDisplayFrame((Rect)localObject8);
      RectF localRectF2 = d;
      localRectF2.set((Rect)localObject8);
      localObject8 = e;
      a((View)localObject7, (RectF)localObject8);
      ((RectF)localObject8).offset(f2, f1);
      ((RectF)localObject8).intersect(localRectF2);
      localRectF1.set((RectF)localObject8);
    }
    else
    {
      localObject6 = paramView2;
      localObjectAnimator = ObjectAnimator.ofFloat(localObject6, View.TRANSLATION_X, new float[] { -f2 });
      localObject6 = ObjectAnimator.ofFloat(localObject6, View.TRANSLATION_Y, new float[] { -f1 });
    }
    Object localObject7 = localObject2;
    localObject2 = paramView2;
    ((e.c.a.b.a.h)localObject4).a(localObjectAnimator);
    ((e.c.a.b.a.h)localObject5).a((Animator)localObject6);
    localArrayList.add(localObjectAnimator);
    localArrayList.add(localObject6);
    float f4 = localRectF1.width();
    float f5 = localRectF1.height();
    boolean bool2 = localObject2 instanceof e.c.a.b.g.c;
    if (bool2) {
      if ((paramView1 instanceof ImageView))
      {
        localObject5 = (e.c.a.b.g.c)localObject2;
        localObject6 = ((ImageView)paramView1).getDrawable();
        if (localObject6 == null) {}
      }
      else
      {
        ((Drawable)localObject6).mutate();
        if (paramBoolean1)
        {
          if (!paramBoolean2) {
            ((Drawable)localObject6).setAlpha(255);
          }
          localObject4 = ObjectAnimator.ofInt(localObject6, e.c.a.b.a.d.b, new int[] { 0 });
        }
        else
        {
          localObject4 = ObjectAnimator.ofInt(localObject6, e.c.a.b.a.d.b, new int[] { 255 });
        }
        ((ObjectAnimator)localObject4).addUpdateListener(new e.c.a.b.o.a(this, (View)localObject2));
        ((g)localObject1).a("iconFade").a((Animator)localObject4);
        localArrayList.add(localObject4);
        ((ArrayList)localObject3).add(new e.c.a.b.o.b(this, (e.c.a.b.g.c)localObject5, (Drawable)localObject6));
      }
    }
    localObject4 = localObject3;
    if (!bool2)
    {
      localObject5 = localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject3 = (e.c.a.b.g.c)localObject2;
      localObject6 = d;
      localObject5 = e;
      a(paramView1, (RectF)localObject6);
      a((View)localObject2, (RectF)localObject5);
      ((RectF)localObject5).offset(-a(paramView1, (View)localObject2, (i)localObject7), 0.0F);
      float f6 = ((RectF)localObject6).centerX() - left;
      localObject5 = d;
      localObject6 = e;
      a(paramView1, (RectF)localObject5);
      a((View)localObject2, (RectF)localObject6);
      ((RectF)localObject6).offset(0.0F, -b(paramView1, (View)localObject2, (i)localObject7));
      float f7 = ((RectF)localObject5).centerY() - top;
      ((FloatingActionButton)paramView1).a(c);
      f2 = c.width() / 2.0F;
      localObject6 = ((g)localObject1).a("expansion");
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          ((e.c.a.b.g.c)localObject3).setRevealInfo(new c.e(f6, f7, f2));
        }
        if (paramBoolean2) {
          f2 = getRevealInfoc;
        }
        f3 = e.c.a.a.b.l.c.a(f6, f7, 0.0F, 0.0F);
        f1 = e.c.a.a.b.l.c.a(f6, f7, f4, 0.0F);
        f4 = e.c.a.a.b.l.c.a(f6, f7, f4, f5);
        f5 = e.c.a.a.b.l.c.a(f6, f7, 0.0F, f5);
        if ((f3 > f1) && (f3 > f4) && (f3 > f5))
        {
          f1 = f3;
        }
        else if ((f1 <= f4) || (f1 <= f5))
        {
          f1 = f5;
          if (f4 > f5) {
            f1 = f4;
          }
        }
        localObject5 = e.c.a.a.b.l.c.a((e.c.a.b.g.c)localObject3, f6, f7, f1);
        ((Animator)localObject5).addListener(new e.c.a.b.o.c(this, (e.c.a.b.g.c)localObject3));
        l1 = a;
        k = (int)f6;
        j = (int)f7;
        if (l1 > 0L)
        {
          paramView2 = ViewAnimationUtils.createCircularReveal((View)localObject2, k, j, f2, f2);
          paramView2.setStartDelay(0L);
          paramView2.setDuration(l1);
          localArrayList.add(paramView2);
        }
        paramView2 = (View)localObject2;
      }
      else
      {
        f1 = getRevealInfoc;
        localObject5 = e.c.a.a.b.l.c.a((e.c.a.b.g.c)localObject3, f6, f7, f2);
        l1 = a;
        int m = (int)f6;
        int n = (int)f7;
        if (l1 > 0L)
        {
          localObject2 = ViewAnimationUtils.createCircularReveal((View)localObject2, m, n, f1, f1);
          ((Animator)localObject2).setStartDelay(0L);
          ((Animator)localObject2).setDuration(l1);
          localArrayList.add(localObject2);
        }
        l2 = a;
        long l3 = b;
        k = a.z;
        j = 0;
        l1 = 0L;
        while (j < k)
        {
          localObject2 = (e.c.a.b.a.h)a.e(j);
          l1 = Math.max(l1, a + b);
          j++;
        }
        l2 += l3;
        if (l2 < l1)
        {
          localObject2 = ViewAnimationUtils.createCircularReveal(paramView2, m, n, f2, f2);
          ((Animator)localObject2).setStartDelay(l2);
          ((Animator)localObject2).setDuration(l1 - l2);
          localArrayList.add(localObject2);
        }
      }
      ((e.c.a.b.a.h)localObject6).a((Animator)localObject5);
      localArrayList.add(localObject5);
      ((ArrayList)localObject4).add(new e.c.a.b.g.a((e.c.a.b.g.c)localObject3));
      localObject5 = localObject1;
      localObject1 = paramView2;
    }
    if (bool2)
    {
      localObject2 = (e.c.a.b.g.c)localObject1;
      paramView2 = paramView1.getBackgroundTintList();
      if (paramView2 != null) {
        j = paramView2.getColorForState(paramView1.getDrawableState(), paramView2.getDefaultColor());
      } else {
        j = 0;
      }
      if (paramBoolean1)
      {
        if (!paramBoolean2) {
          ((e.c.a.b.g.c)localObject2).setCircularRevealScrimColor(j);
        }
        paramView2 = ObjectAnimator.ofInt(localObject2, c.d.a, new int[] { 0xFFFFFF & j });
      }
      else
      {
        paramView2 = ObjectAnimator.ofInt(localObject2, c.d.a, new int[] { j });
      }
      paramView2.setEvaluator(e.c.a.b.a.b.a);
      ((g)localObject5).a("color").a(paramView2);
      localArrayList.add(paramView2);
    }
    if ((localObject1 instanceof ViewGroup))
    {
      paramView2 = ((View)localObject1).findViewById(R.id.mtrl_child_content_container);
      if (paramView2 != null)
      {
        paramView2 = a(paramView2);
      }
      else
      {
        paramView2 = this;
        if ((!(localObject1 instanceof e)) && (!(localObject1 instanceof e.c.a.b.o.d))) {
          paramView2 = paramView2.a((View)localObject1);
        } else {
          paramView2 = paramView2.a(((ViewGroup)localObject1).getChildAt(0));
        }
      }
      if (paramView2 != null)
      {
        if (paramBoolean1)
        {
          if (!paramBoolean2) {
            e.c.a.b.a.c.a.set(paramView2, Float.valueOf(0.0F));
          }
          paramView2 = ObjectAnimator.ofFloat(paramView2, e.c.a.b.a.c.a, new float[] { 1.0F });
        }
        else
        {
          paramView2 = ObjectAnimator.ofFloat(paramView2, e.c.a.b.a.c.a, new float[] { 0.0F });
        }
        ((g)localObject5).a("contentFade").a(paramView2);
        localArrayList.add(paramView2);
      }
    }
    paramView2 = new AnimatorSet();
    e.c.a.a.b.l.c.a(paramView2, localArrayList);
    paramView2.addListener(new a(paramBoolean1, (View)localObject1, paramView1));
    int k = ((ArrayList)localObject4).size();
    for (int j = 0; j < k; j++) {
      paramView2.addListener((Animator.AnimatorListener)((ArrayList)localObject4).get(j));
    }
    return paramView2;
  }
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a(boolean paramBoolean, View paramView1, View paramView2) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!paramBoolean1)
      {
        localObject1.setVisibility(4);
        paramView1.setAlpha(1.0F);
        paramView1.setVisibility(0);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (paramBoolean1)
      {
        localObject1.setVisibility(0);
        paramView1.setAlpha(0.0F);
        paramView1.setVisibility(4);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */