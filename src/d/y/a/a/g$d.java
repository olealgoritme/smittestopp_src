package d.y.a.a;

import android.graphics.Matrix;
import d.f.a;
import d.f.h;
import java.util.ArrayList;

public class g$d
  extends g.e
{
  public final Matrix a = new Matrix();
  public final ArrayList<g.e> b = new ArrayList();
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  public float f = 1.0F;
  public float g = 1.0F;
  public float h = 0.0F;
  public float i = 0.0F;
  public final Matrix j = new Matrix();
  public int k;
  public int[] l;
  public String m = null;
  
  public g$d()
  {
    super(null);
  }
  
  public g$d(d paramd, a<String, Object> parama)
  {
    super(null);
    c = c;
    d = d;
    e = e;
    f = f;
    g = g;
    h = h;
    i = i;
    l = l;
    Object localObject = m;
    m = ((String)localObject);
    k = k;
    if (localObject != null) {
      parama.put(localObject, this);
    }
    j.set(j);
    localObject = b;
    int n = 0;
    while (n < ((ArrayList)localObject).size())
    {
      paramd = ((ArrayList)localObject).get(n);
      if ((paramd instanceof d))
      {
        paramd = (d)paramd;
        b.add(new d(paramd, parama));
      }
      else
      {
        if ((paramd instanceof g.c))
        {
          paramd = new g.c((g.c)paramd);
        }
        else
        {
          if (!(paramd instanceof g.b)) {
            break label313;
          }
          paramd = new g.b((g.b)paramd);
        }
        b.add(paramd);
        String str = b;
        if (str != null) {
          parama.put(str, paramd);
        }
      }
      n++;
      continue;
      label313:
      throw new IllegalStateException("Unknown object in the tree!");
    }
  }
  
  public boolean a()
  {
    for (int n = 0; n < b.size(); n++) {
      if (((g.e)b.get(n)).a()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    int n = 0;
    boolean bool = false;
    while (n < b.size())
    {
      bool |= ((g.e)b.get(n)).a(paramArrayOfInt);
      n++;
    }
    return bool;
  }
  
  public final void b()
  {
    j.reset();
    j.postTranslate(-d, -e);
    j.postScale(f, g);
    j.postRotate(c, 0.0F, 0.0F);
    j.postTranslate(h + d, i + e);
  }
  
  public String getGroupName()
  {
    return m;
  }
  
  public Matrix getLocalMatrix()
  {
    return j;
  }
  
  public float getPivotX()
  {
    return d;
  }
  
  public float getPivotY()
  {
    return e;
  }
  
  public float getRotation()
  {
    return c;
  }
  
  public float getScaleX()
  {
    return f;
  }
  
  public float getScaleY()
  {
    return g;
  }
  
  public float getTranslateX()
  {
    return h;
  }
  
  public float getTranslateY()
  {
    return i;
  }
  
  public void setPivotX(float paramFloat)
  {
    if (paramFloat != d)
    {
      d = paramFloat;
      b();
    }
  }
  
  public void setPivotY(float paramFloat)
  {
    if (paramFloat != e)
    {
      e = paramFloat;
      b();
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (paramFloat != c)
    {
      c = paramFloat;
      b();
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (paramFloat != f)
    {
      f = paramFloat;
      b();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (paramFloat != g)
    {
      g = paramFloat;
      b();
    }
  }
  
  public void setTranslateX(float paramFloat)
  {
    if (paramFloat != h)
    {
      h = paramFloat;
      b();
    }
  }
  
  public void setTranslateY(float paramFloat)
  {
    if (paramFloat != i)
    {
      i = paramFloat;
      b();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.g.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */