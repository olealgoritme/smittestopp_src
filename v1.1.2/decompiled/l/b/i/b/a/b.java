package l.b.i.b.a;

import l.b.i.d.a.d;
import l.b.i.d.a.e;

public class b
  extends a
{
  public int b;
  public int c;
  public l.b.i.d.a.b d;
  public e e;
  public d f;
  public l.b.i.d.a.a g;
  
  public b(int paramInt1, int paramInt2, l.b.i.d.a.b paramb, e parame, d paramd, String paramString)
  {
    super(true, paramString);
    b = paramInt1;
    c = paramInt2;
    d = paramb;
    e = parame;
    g = ((l.b.i.d.a.a)localObject1);
    f = paramd;
    int i = parame.b();
    localObject1 = new e[i];
    int j;
    for (paramInt2 = 0;; paramInt2++)
    {
      j = i >> 1;
      paramInt1 = j;
      if (paramInt2 >= j) {
        break;
      }
      paramInt1 = paramInt2 << 1;
      paramd = new int[paramInt1 + 1];
      paramd[paramInt1] = 1;
      localObject1[paramInt2] = new e(paramb, paramd);
    }
    Object localObject2;
    while (paramInt1 < i)
    {
      paramInt2 = paramInt1 << 1;
      paramd = new int[paramInt2 + 1];
      paramd[paramInt2] = 1;
      e locale = new e(paramb, paramd);
      paramString = c;
      localObject2 = c;
      j = e.a((int[])localObject2);
      if (j != -1)
      {
        int k = paramString.length;
        paramd = new int[k];
        paramInt2 = e.a((int[])localObject2);
        if (paramInt2 == -1) {
          paramInt2 = 0;
        } else {
          paramInt2 = localObject2[paramInt2];
        }
        m = a.a(paramInt2);
        System.arraycopy(paramString, 0, paramd, 0, k);
        while (j <= e.a(paramd))
        {
          paramString = a;
          paramInt2 = e.a(paramd);
          if (paramInt2 == -1) {
            paramInt2 = 0;
          } else {
            paramInt2 = paramd[paramInt2];
          }
          int n = paramString.a(paramInt2, m);
          paramInt2 = e.a(paramd) - j;
          k = e.a((int[])localObject2);
          if (k == -1)
          {
            paramString = new int[1];
          }
          else
          {
            paramString = new int[k + paramInt2 + 1];
            System.arraycopy(localObject2, 0, paramString, paramInt2, k + 1);
          }
          paramd = locale.a(locale.a(paramString, n), paramd);
        }
        localObject1[paramInt1] = new e(a, paramd);
        paramInt1++;
      }
      else
      {
        throw new ArithmeticException("Division by zero");
      }
    }
    int m = parame.b();
    parame = new e[m];
    paramInt1 = m - 1;
    for (paramInt2 = paramInt1; paramInt2 >= 0; paramInt2--) {
      parame[paramInt2] = new e(localObject1[paramInt2]);
    }
    paramd = new e[m];
    while (paramInt1 >= 0)
    {
      paramd[paramInt1] = new e(paramb, paramInt1);
      paramInt1--;
    }
    for (paramInt2 = 0; paramInt2 < m; paramInt2++)
    {
      if (parame[paramInt2].a(paramInt2) == 0)
      {
        paramInt1 = paramInt2 + 1;
        j = 0;
        while (paramInt1 < m)
        {
          i = paramInt1;
          if (parame[paramInt1].a(paramInt2) != 0)
          {
            paramString = parame[paramInt2];
            parame[paramInt2] = parame[paramInt1];
            parame[paramInt1] = paramString;
            paramString = paramd[paramInt2];
            paramd[paramInt2] = paramd[paramInt1];
            paramd[paramInt1] = paramString;
            i = m;
            j = 1;
          }
          paramInt1 = i + 1;
        }
        if (j == 0) {
          throw new ArithmeticException("Squaring matrix is not invertible.");
        }
      }
      paramInt1 = paramb.a(parame[paramInt2].a(paramInt2));
      parame[paramInt2].b(paramInt1);
      paramd[paramInt2].b(paramInt1);
      for (paramInt1 = 0; paramInt1 < m; paramInt1++) {
        if (paramInt1 != paramInt2)
        {
          j = parame[paramInt1].a(paramInt2);
          if (j != 0)
          {
            localObject2 = parame[paramInt2].c(j);
            paramString = paramd[paramInt2].c(j);
            localObject1 = parame[paramInt1];
            c = ((e)localObject1).a(c, c);
            ((e)localObject1).a();
            localObject1 = paramd[paramInt1];
            c = ((e)localObject1).a(c, c);
            ((e)localObject1).a();
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */