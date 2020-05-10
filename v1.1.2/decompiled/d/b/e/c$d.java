package d.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.ActionMenuView.a;
import d.b.a.s;
import d.b.d.i.r;

public class c$d
  extends n
  implements ActionMenuView.a
{
  public c$d(c paramc, Context paramContext)
  {
    super(paramContext, null, R.attr.actionOverflowButtonStyle);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    s.a(this, getContentDescription());
    setOnTouchListener(new a(this, paramc));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean performClick()
  {
    if (super.performClick()) {
      return true;
    }
    playSoundEffect(0);
    z.g();
    return true;
  }
  
  public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable1 = getDrawable();
    Drawable localDrawable2 = getBackground();
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      int i = getWidth();
      paramInt4 = getHeight();
      paramInt1 = Math.max(i, paramInt4) / 2;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt2 = getPaddingBottom();
      i = (i + (j - k)) / 2;
      paramInt2 = (paramInt4 + (paramInt3 - paramInt2)) / 2;
      localDrawable2.setHotspotBounds(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
    }
    return bool;
  }
  
  public class a
    extends f0
  {
    public a(View paramView, c paramc)
    {
      super();
    }
    
    public r b()
    {
      c.e locale = z.S;
      if (locale == null) {
        return null;
      }
      return locale.a();
    }
    
    public boolean c()
    {
      z.g();
      return true;
    }
    
    public boolean d()
    {
      c localc = z;
      if (U != null) {
        return false;
      }
      localc.b();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */