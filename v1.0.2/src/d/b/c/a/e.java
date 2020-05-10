package d.b.c.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

@SuppressLint({"RestrictedAPI"})
public class e
  extends b
{
  public e.a J;
  public boolean K;
  
  public e(e.a parama)
  {
    if (parama != null) {
      a(parama);
    }
  }
  
  public e(e.a parama, Resources paramResources)
  {
    a(new e.a(parama, this, paramResources));
    onStateChange(getState());
  }
  
  public e.a a()
  {
    return new e.a(J, this, null);
  }
  
  public void a(b.c paramc)
  {
    super.a(paramc);
    if ((paramc instanceof e.a)) {
      J = ((e.a)paramc);
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b.c localc = x;
    if (localc != null)
    {
      if (paramTheme != null)
      {
        localc.c();
        int i = h;
        Drawable[] arrayOfDrawable = g;
        for (int j = 0; j < i; j++) {
          if ((arrayOfDrawable[j] != null) && (arrayOfDrawable[j].canApplyTheme()))
          {
            arrayOfDrawable[j].applyTheme(paramTheme);
            e |= arrayOfDrawable[j].getChangingConfigurations();
          }
        }
        localc.a(paramTheme.getResources());
      }
      onStateChange(getState());
      return;
    }
    throw null;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    if (!K)
    {
      super.mutate();
      J.d();
      K = true;
    }
    return this;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = A;
    boolean bool1 = false;
    boolean bool2;
    if (localDrawable != null)
    {
      bool2 = localDrawable.setState(paramArrayOfInt);
    }
    else
    {
      localDrawable = z;
      if (localDrawable != null) {
        bool2 = localDrawable.setState(paramArrayOfInt);
      } else {
        bool2 = false;
      }
    }
    int i = J.a(paramArrayOfInt);
    int j = i;
    if (i < 0) {
      j = J.a(StateSet.WILD_CARD);
    }
    if ((a(j)) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */