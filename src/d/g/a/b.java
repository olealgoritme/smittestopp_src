package d.g.a;

public class b
  implements e.a
{
  public g a = null;
  public float b = 0.0F;
  public boolean c;
  public final a d;
  public boolean e = false;
  
  public b(c paramc)
  {
    d = new a(this, paramc);
  }
  
  public b a(e parame, int paramInt)
  {
    d.a(parame.a(paramInt, "ep"), 1.0F);
    d.a(parame.a(paramInt, "em"), -1.0F);
    return this;
  }
  
  public b a(g paramg1, g paramg2, g paramg3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      b = j;
    }
    if (i == 0)
    {
      d.a(paramg1, -1.0F);
      d.a(paramg2, 1.0F);
      d.a(paramg3, 1.0F);
    }
    else
    {
      d.a(paramg1, 1.0F);
      d.a(paramg2, -1.0F);
      d.a(paramg3, -1.0F);
    }
    return this;
  }
  
  public b a(g paramg1, g paramg2, g paramg3, g paramg4, float paramFloat)
  {
    d.a(paramg1, -1.0F);
    d.a(paramg2, 1.0F);
    d.a(paramg3, paramFloat);
    d.a(paramg4, -paramFloat);
    return this;
  }
  
  public void a(g paramg)
  {
    int i = d;
    float f = 1.0F;
    if (i != 1) {
      if (i == 2) {
        f = 1000.0F;
      } else if (i == 3) {
        f = 1000000.0F;
      } else if (i == 4) {
        f = 1.0E9F;
      } else if (i == 5) {
        f = 1.0E12F;
      }
    }
    d.a(paramg, f);
  }
  
  public b b(g paramg1, g paramg2, g paramg3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      b = j;
    }
    if (i == 0)
    {
      d.a(paramg1, -1.0F);
      d.a(paramg2, 1.0F);
      d.a(paramg3, -1.0F);
    }
    else
    {
      d.a(paramg1, 1.0F);
      d.a(paramg2, -1.0F);
      d.a(paramg3, 1.0F);
    }
    return this;
  }
  
  public b b(g paramg1, g paramg2, g paramg3, g paramg4, float paramFloat)
  {
    d.a(paramg3, 0.5F);
    d.a(paramg4, 0.5F);
    d.a(paramg1, -0.5F);
    d.a(paramg2, -0.5F);
    b = (-paramFloat);
    return this;
  }
  
  public void b(g paramg)
  {
    Object localObject = a;
    if (localObject != null)
    {
      d.a((g)localObject, -1.0F);
      a = null;
    }
    float f = d.a(paramg, true) * -1.0F;
    a = paramg;
    if (f == 1.0F) {
      return;
    }
    b /= f;
    paramg = d;
    int i = i;
    for (int j = 0; (i != -1) && (j < a); j++)
    {
      localObject = h;
      localObject[i] /= f;
      i = g[i];
    }
  }
  
  public String toString()
  {
    if (a == null)
    {
      localObject1 = "0";
    }
    else
    {
      localObject1 = e.a.a.a.a.a("");
      ((StringBuilder)localObject1).append(a);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = e.a.a.a.a.b((String)localObject1, " = ");
    float f1 = b;
    int i = 0;
    int j;
    if (f1 != 0.0F)
    {
      localObject1 = e.a.a.a.a.a((String)localObject1);
      ((StringBuilder)localObject1).append(b);
      localObject1 = ((StringBuilder)localObject1).toString();
      j = 1;
    }
    else
    {
      j = 0;
    }
    int k = d.a;
    while (i < k)
    {
      localObject2 = d.a(i);
      if (localObject2 != null)
      {
        float f2 = d.b(i);
        boolean bool = f2 < 0.0F;
        if (bool)
        {
          String str = ((g)localObject2).toString();
          if (j == 0)
          {
            localObject2 = localObject1;
            f1 = f2;
            if (f2 >= 0.0F) {
              break label207;
            }
            localObject2 = e.a.a.a.a.b((String)localObject1, "- ");
          }
          else
          {
            if (bool)
            {
              localObject2 = e.a.a.a.a.b((String)localObject1, " + ");
              f1 = f2;
              break label207;
            }
            localObject2 = e.a.a.a.a.b((String)localObject1, " - ");
          }
          f1 = f2 * -1.0F;
          label207:
          if (f1 == 1.0F)
          {
            localObject1 = e.a.a.a.a.b((String)localObject2, str);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(f1);
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(str);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          j = 1;
        }
      }
      i++;
    }
    Object localObject2 = localObject1;
    if (j == 0) {
      localObject2 = e.a.a.a.a.b((String)localObject1, "0.0");
    }
    return (String)localObject2;
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */