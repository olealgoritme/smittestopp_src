package d.b.c.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

public class e
  extends b
{
  public a J;
  public boolean K;
  
  public e(a parama)
  {
    if (parama != null) {
      a(parama);
    }
  }
  
  public e(a parama, Resources paramResources)
  {
    a(new a(parama, this, paramResources));
    onStateChange(getState());
  }
  
  public a a()
  {
    return new a(J, this, null);
  }
  
  public void a(b.c paramc)
  {
    super.a(paramc);
    if ((paramc instanceof a)) {
      J = ((a)paramc);
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
  
  public static class a
    extends b.c
  {
    public int[][] J;
    
    public a(a parama, e parame, Resources paramResources)
    {
      super(parame, paramResources);
      if (parama != null) {
        J = J;
      } else {
        J = new int[g.length][];
      }
    }
    
    public int a(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = J;
      int i = h;
      for (int j = 0; j < i; j++) {
        if (StateSet.stateSetMatches(arrayOfInt[j], paramArrayOfInt)) {
          return j;
        }
      }
      return -1;
    }
    
    public void d()
    {
      Object localObject = J;
      int[][] arrayOfInt = new int[localObject.length][];
      for (int i = localObject.length - 1; i >= 0; i--)
      {
        localObject = J;
        if (localObject[i] != null) {
          localObject = (int[])localObject[i].clone();
        } else {
          localObject = null;
        }
        arrayOfInt[i] = localObject;
      }
      J = arrayOfInt;
    }
    
    public Drawable newDrawable()
    {
      return new e(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new e(this, paramResources);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.c.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */