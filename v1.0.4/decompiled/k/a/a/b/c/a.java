package k.a.a.b.c;

import java.util.Comparator;

public class a
  implements Object<Integer>
{
  public int a = 0;
  
  public a a(Object paramObject1, Object paramObject2, Comparator<?> paramComparator)
  {
    if (a != 0) {
      return this;
    }
    if (paramObject1 == paramObject2) {
      return this;
    }
    int i = -1;
    if (paramObject1 == null)
    {
      a = -1;
      return this;
    }
    if (paramObject2 == null)
    {
      a = 1;
      return this;
    }
    if (paramObject1.getClass().isArray())
    {
      boolean bool2 = paramObject1 instanceof long[];
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int j;
      if (bool2)
      {
        paramObject1 = (long[])paramObject1;
        paramObject2 = (long[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              i = 1;
            }
            a = i;
          }
          else
          {
            for (i2 = 0; i2 < paramObject1.length; i2++)
            {
              i = a;
              if (i != 0) {
                break;
              }
              long l1 = paramObject1[i2];
              long l2 = paramObject2[i2];
              if (i == 0)
              {
                boolean bool1 = l1 < l2;
                if (bool1) {
                  j = -1;
                } else if (j > 0) {
                  j = 1;
                } else {
                  j = 0;
                }
                a = j;
              }
            }
          }
        }
      }
      else if ((paramObject1 instanceof int[]))
      {
        paramObject1 = (int[])paramObject1;
        paramObject2 = (int[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            for (i2 = 0; i2 < paramObject1.length; i2++)
            {
              n = a;
              if (n != 0) {
                break;
              }
              j = paramObject1[i2];
              m = paramObject2[i2];
              if (n == 0)
              {
                if (j < m) {
                  j = -1;
                } else if (j > m) {
                  j = 1;
                } else {
                  j = 0;
                }
                a = j;
              }
            }
          }
        }
      }
      else if ((paramObject1 instanceof short[]))
      {
        paramObject1 = (short[])paramObject1;
        paramObject2 = (short[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            for (i2 = 0; i2 < paramObject1.length; i2++)
            {
              n = a;
              if (n != 0) {
                break;
              }
              j = paramObject1[i2];
              m = paramObject2[i2];
              if (n == 0)
              {
                if (j < m) {
                  j = -1;
                } else if (j > m) {
                  j = 1;
                } else {
                  j = 0;
                }
                a = j;
              }
            }
          }
        }
      }
      else if ((paramObject1 instanceof char[]))
      {
        paramObject1 = (char[])paramObject1;
        paramObject2 = (char[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            for (i2 = 0; i2 < paramObject1.length; i2++)
            {
              n = a;
              if (n != 0) {
                break;
              }
              j = paramObject1[i2];
              m = paramObject2[i2];
              if (n == 0)
              {
                if (j < m) {
                  j = -1;
                } else if (j > m) {
                  j = 1;
                } else {
                  j = 0;
                }
                a = j;
              }
            }
          }
        }
      }
      else if ((paramObject1 instanceof byte[]))
      {
        paramObject1 = (byte[])paramObject1;
        paramObject2 = (byte[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            for (i2 = 0; i2 < paramObject1.length; i2++)
            {
              j = a;
              if (j != 0) {
                break;
              }
              n = paramObject1[i2];
              m = paramObject2[i2];
              if (j == 0)
              {
                if (n < m) {
                  j = -1;
                } else if (n > m) {
                  j = 1;
                } else {
                  j = 0;
                }
                a = j;
              }
            }
          }
        }
      }
      else if ((paramObject1 instanceof double[]))
      {
        paramObject1 = (double[])paramObject1;
        paramObject2 = (double[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2)) {
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            while (i2 < paramObject1.length)
            {
              j = a;
              if (j != 0) {
                break;
              }
              double d1 = paramObject1[i2];
              double d2 = paramObject2[i2];
              if (j == 0) {
                a = Double.compare(d1, d2);
              }
              i2++;
            }
          }
        }
      }
      else if ((paramObject1 instanceof float[]))
      {
        paramObject1 = (float[])paramObject1;
        paramObject2 = (float[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2))
        {
          i2 = m;
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            while (i2 < paramObject1.length)
            {
              j = a;
              if (j != 0) {
                break;
              }
              float f1 = paramObject1[i2];
              float f2 = paramObject2[i2];
              if (j == 0) {
                a = Float.compare(f1, f2);
              }
              i2++;
            }
          }
        }
      }
      else if ((paramObject1 instanceof boolean[]))
      {
        paramObject1 = (boolean[])paramObject1;
        paramObject2 = (boolean[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2))
        {
          i2 = n;
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            while (i2 < paramObject1.length)
            {
              j = a;
              if (j != 0) {
                break;
              }
              int i3 = paramObject1[i2];
              int k = paramObject2[i2];
              if ((j == 0) && (i3 != k)) {
                if (i3 == 0) {
                  a = -1;
                } else {
                  a = 1;
                }
              }
              i2++;
            }
          }
        }
      }
      else
      {
        paramObject1 = (Object[])paramObject1;
        paramObject2 = (Object[])paramObject2;
        if ((a == 0) && (paramObject1 != paramObject2))
        {
          i2 = i1;
          if (paramObject1.length != paramObject2.length)
          {
            if (paramObject1.length >= paramObject2.length) {
              j = 1;
            }
            a = j;
          }
          else
          {
            while ((i2 < paramObject1.length) && (a == 0))
            {
              a(paramObject1[i2], paramObject2[i2], paramComparator);
              i2++;
            }
          }
        }
      }
    }
    else if (paramComparator == null)
    {
      a = ((Comparable)paramObject1).compareTo(paramObject2);
    }
    else
    {
      a = paramComparator.compare(paramObject1, paramObject2);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     base.k.a.a.b.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */