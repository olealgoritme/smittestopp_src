package d.b.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

public class e$a
  extends b.c
{
  public int[][] J;
  
  public e$a(a parama, e parame, Resources paramResources)
  {
    super(parama, parame, paramResources);
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

/* Location:
 * Qualified Name:     base.d.b.c.a.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */