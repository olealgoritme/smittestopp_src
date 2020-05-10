package k.b.i.b.a;

import k.b.i.d.a.d;
import k.b.i.d.a.e;

public class b
  extends a
{
  public int b;
  public int c;
  public k.b.i.d.a.b d;
  public e e;
  public d f;
  public k.b.i.d.a.a g;
  
  public b(int paramInt1, int paramInt2, k.b.i.d.a.b paramb, e parame, d paramd, String paramString)
  {
    super(true, paramString);
    b = paramInt1;
    c = paramInt2;
    d = paramb;
    e = parame;
    g = ((k.b.i.d.a.a)localObject);
    f = paramd;
    int i = parame.b();
    localObject = new e[i];
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
      localObject[paramInt2] = new e(paramb, paramd);
    }
    int[] arrayOfInt;
    while (paramInt1 < i)
    {
      paramInt2 = paramInt1 << 1;
      paramd = new int[paramInt2 + 1];
      paramd[paramInt2] = 1;
      e locale = new e(paramb, paramd);
      paramString = c;
      arrayOfInt = c;
      j = e.a(arrayOfInt);
      if (j != -1)
      {
        int k = paramString.length;
        paramd = new int[k];
        paramInt2 = e.a(arrayOfInt);
        if (paramInt2 == -1) {
          paramInt2 = 0;
        } else {
          paramInt2 = arrayOfInt[paramInt2];
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
          paramInt2 = paramString.a(paramInt2, m);
          int n = e.a(paramd) - j;
          k = e.a(arrayOfInt);
          if (k == -1)
          {
            paramString = new int[1];
          }
          else
          {
            paramString = new int[k + n + 1];
            System.arraycopy(arrayOfInt, 0, paramString, n, k + 1);
          }
          paramd = locale.a(locale.a(paramString, paramInt2), paramd);
        }
        localObject[paramInt1] = new e(a, paramd);
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
      parame[paramInt2] = new e(localObject[paramInt2]);
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
            localObject = parame[paramInt2].c(j);
            paramString = paramd[paramInt2].c(j);
            arrayOfInt = parame[paramInt1];
            c = arrayOfInt.a(c, c);
            arrayOfInt.a();
            localObject = paramd[paramInt1];
            c = ((e)localObject).a(c, c);
            ((e)localObject).a();
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */