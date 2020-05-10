package d.i.c.j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public final class e
  extends Drawable.ConstantState
{
  public int a;
  public Drawable.ConstantState b;
  public ColorStateList c = null;
  public PorterDuff.Mode d = c.D;
  
  public e(e parame)
  {
    if (parame != null)
    {
      a = a;
      b = b;
      c = c;
      d = d;
    }
  }
  
  public int getChangingConfigurations()
  {
    int i = a;
    Drawable.ConstantState localConstantState = b;
    int j;
    if (localConstantState != null) {
      j = localConstantState.getChangingConfigurations();
    } else {
      j = 0;
    }
    return i | j;
  }
  
  public Drawable newDrawable()
  {
    return new d(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new d(this, paramResources);
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */