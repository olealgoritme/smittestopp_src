package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$c
{
  public final SparseIntArray a = new SparseIntArray();
  public boolean b = false;
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int n;
    for (int k = 0; i < paramInt1; k = n)
    {
      int m = j + 1;
      if (m == paramInt2)
      {
        n = k + 1;
        j = 0;
      }
      else
      {
        j = m;
        n = k;
        if (m > paramInt2)
        {
          n = k + 1;
          j = 1;
        }
      }
      i++;
    }
    paramInt1 = k;
    if (j + 1 > paramInt2) {
      paramInt1 = k + 1;
    }
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */