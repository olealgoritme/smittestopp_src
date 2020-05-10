package k.b.i.b.a;

import k.b.i.d.a.b;

public class e
  extends d
{
  public int a;
  public int b;
  public b c;
  public k.b.i.d.a.e d;
  public k.b.i.d.a.a e;
  public k.b.i.d.a.d f;
  public k.b.i.d.a.d g;
  
  public e(int paramInt1, int paramInt2, b paramb, k.b.i.d.a.e parame, k.b.i.d.a.d paramd1, k.b.i.d.a.d paramd2, k.b.i.d.a.a parama)
  {
    super(true);
    b = paramInt2;
    a = paramInt1;
    c = paramb;
    d = parame;
    e = parama;
    f = paramd1;
    g = paramd2;
    k.b.c.e.a.a(paramb, parame);
    int i = parame.b();
    parama = new k.b.i.d.a.e[i];
    int j;
    for (paramInt2 = 0;; paramInt2++)
    {
      j = i >> 1;
      paramInt1 = j;
      if (paramInt2 >= j) {
        break;
      }
      paramInt1 = paramInt2 << 1;
      paramd1 = new int[paramInt1 + 1];
      paramd1[paramInt1] = 1;
      parama[paramInt2] = new k.b.i.d.a.e(paramb, paramd1);
    }
    int[] arrayOfInt;
    while (paramInt1 < i)
    {
      paramInt2 = paramInt1 << 1;
      paramd1 = new int[paramInt2 + 1];
      paramd1[paramInt2] = 1;
      k.b.i.d.a.e locale = new k.b.i.d.a.e(paramb, paramd1);
      paramd2 = c;
      arrayOfInt = c;
      j = k.b.i.d.a.e.a(arrayOfInt);
      if (j != -1)
      {
        int k = paramd2.length;
        paramd1 = new int[k];
        paramInt2 = k.b.i.d.a.e.a(arrayOfInt);
        if (paramInt2 == -1) {
          paramInt2 = 0;
        } else {
          paramInt2 = arrayOfInt[paramInt2];
        }
        m = a.a(paramInt2);
        System.arraycopy(paramd2, 0, paramd1, 0, k);
        while (j <= k.b.i.d.a.e.a(paramd1))
        {
          paramd2 = a;
          paramInt2 = k.b.i.d.a.e.a(paramd1);
          if (paramInt2 == -1) {
            paramInt2 = 0;
          } else {
            paramInt2 = paramd1[paramInt2];
          }
          k = paramd2.a(paramInt2, m);
          paramInt2 = k.b.i.d.a.e.a(paramd1) - j;
          int n = k.b.i.d.a.e.a(arrayOfInt);
          if (n == -1)
          {
            paramd2 = new int[1];
          }
          else
          {
            paramd2 = new int[n + paramInt2 + 1];
            System.arraycopy(arrayOfInt, 0, paramd2, paramInt2, n + 1);
          }
          paramd1 = locale.a(locale.a(paramd2, k), paramd1);
        }
        parama[paramInt1] = new k.b.i.d.a.e(a, paramd1);
        paramInt1++;
      }
      else
      {
        throw new ArithmeticException("Division by zero");
      }
    }
    int m = parame.b();
    parame = new k.b.i.d.a.e[m];
    paramInt1 = m - 1;
    for (paramInt2 = paramInt1; paramInt2 >= 0; paramInt2--) {
      parame[paramInt2] = new k.b.i.d.a.e(parama[paramInt2]);
    }
    paramd1 = new k.b.i.d.a.e[m];
    while (paramInt1 >= 0)
    {
      paramd1[paramInt1] = new k.b.i.d.a.e(paramb, paramInt1);
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
            paramd2 = parame[paramInt2];
            parame[paramInt2] = parame[paramInt1];
            parame[paramInt1] = paramd2;
            paramd2 = paramd1[paramInt2];
            paramd1[paramInt2] = paramd1[paramInt1];
            paramd1[paramInt1] = paramd2;
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
      paramd1[paramInt2].b(paramInt1);
      for (paramInt1 = 0; paramInt1 < m; paramInt1++) {
        if (paramInt1 != paramInt2)
        {
          j = parame[paramInt1].a(paramInt2);
          if (j != 0)
          {
            parama = parame[paramInt2].c(j);
            paramd2 = paramd1[paramInt2].c(j);
            arrayOfInt = parame[paramInt1];
            c = arrayOfInt.a(c, c);
            arrayOfInt.a();
            parama = paramd1[paramInt1];
            c = parama.a(c, c);
            parama.a();
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */