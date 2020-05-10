package d.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.ActionMenuView.a;
import d.b.a.r;

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
    r.a(this, getContentDescription());
    setOnTouchListener(new c.d.a(this, this, paramc));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
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
      paramInt2 = getHeight();
      paramInt1 = Math.max(i, paramInt2) / 2;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      j = (i + (j - k)) / 2;
      paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
      localDrawable2.setHotspotBounds(j - paramInt1, paramInt2 - paramInt1, j + paramInt1, paramInt2 + paramInt1);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */