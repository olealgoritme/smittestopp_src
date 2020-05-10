package d.y.a.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public class c$c
  extends Drawable.ConstantState
{
  public final Drawable.ConstantState a;
  
  public c$c(Drawable.ConstantState paramConstantState)
  {
    a = paramConstantState;
  }
  
  public boolean canApplyTheme()
  {
    return a.canApplyTheme();
  }
  
  public int getChangingConfigurations()
  {
    return a.getChangingConfigurations();
  }
  
  public Drawable newDrawable()
  {
    c localc = new c(null, null, null);
    Drawable localDrawable = a.newDrawable();
    x = localDrawable;
    localDrawable.setCallback(B);
    return localc;
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    c localc = new c(null, null, null);
    paramResources = a.newDrawable(paramResources);
    x = paramResources;
    paramResources.setCallback(B);
    return localc;
  }
  
  public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    c localc = new c(null, null, null);
    paramResources = a.newDrawable(paramResources, paramTheme);
    x = paramResources;
    paramResources.setCallback(B);
    return localc;
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */