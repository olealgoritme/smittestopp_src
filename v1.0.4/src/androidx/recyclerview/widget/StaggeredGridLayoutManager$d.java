package androidx.recyclerview.widget;

import java.util.Arrays;
import java.util.List;

public class StaggeredGridLayoutManager$d
{
  public int[] a;
  public List<StaggeredGridLayoutManager.d.a> b;
  
  public StaggeredGridLayoutManager.d.a a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = b;
    if (localObject == null) {
      return null;
    }
    int i = ((List)localObject).size();
    for (int j = 0; j < i; j++)
    {
      localObject = (StaggeredGridLayoutManager.d.a)b.get(j);
      int k = x;
      if (k >= paramInt2) {
        return null;
      }
      if ((k >= paramInt1) && ((paramInt3 == 0) || (y == paramInt3) || ((paramBoolean) && (A)))) {
        return (StaggeredGridLayoutManager.d.a)localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    int[] arrayOfInt = a;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    b = null;
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt1 = a;
    if (arrayOfInt1 == null)
    {
      arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
      a = arrayOfInt1;
      Arrays.fill(arrayOfInt1, -1);
    }
    else if (paramInt >= arrayOfInt1.length)
    {
      int i = arrayOfInt1.length;
      while (i <= paramInt) {
        i *= 2;
      }
      int[] arrayOfInt2 = new int[i];
      a = arrayOfInt2;
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
      arrayOfInt2 = a;
      Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a;
    if ((localObject != null) && (paramInt1 < localObject.length))
    {
      int i = paramInt1 + paramInt2;
      a(i);
      localObject = a;
      System.arraycopy(localObject, paramInt1, localObject, i, localObject.length - paramInt1 - paramInt2);
      Arrays.fill(a, paramInt1, i, -1);
      localObject = b;
      if (localObject != null) {
        for (i = ((List)localObject).size() - 1; i >= 0; i--)
        {
          localObject = (StaggeredGridLayoutManager.d.a)b.get(i);
          int j = x;
          if (j >= paramInt1) {
            x = (j + paramInt2);
          }
        }
      }
    }
  }
  
  public int b(int paramInt)
  {
    List localList = b;
    if (localList != null) {
      for (int i = localList.size() - 1; i >= 0; i--) {
        if (b.get(i)).x >= paramInt) {
          b.remove(i);
        }
      }
    }
    return d(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = a;
    if ((localObject != null) && (paramInt1 < localObject.length))
    {
      int i = paramInt1 + paramInt2;
      a(i);
      localObject = a;
      System.arraycopy(localObject, i, localObject, paramInt1, localObject.length - paramInt1 - paramInt2);
      localObject = a;
      Arrays.fill((int[])localObject, localObject.length - paramInt2, localObject.length, -1);
      localObject = b;
      if (localObject != null) {
        for (int j = ((List)localObject).size() - 1; j >= 0; j--)
        {
          localObject = (StaggeredGridLayoutManager.d.a)b.get(j);
          int k = x;
          if (k >= paramInt1) {
            if (k < i) {
              b.remove(j);
            } else {
              x = (k - paramInt2);
            }
          }
        }
      }
    }
  }
  
  public StaggeredGridLayoutManager.d.a c(int paramInt)
  {
    Object localObject = b;
    if (localObject == null) {
      return null;
    }
    for (int i = ((List)localObject).size() - 1; i >= 0; i--)
    {
      localObject = (StaggeredGridLayoutManager.d.a)b.get(i);
      if (x == paramInt) {
        return (StaggeredGridLayoutManager.d.a)localObject;
      }
    }
    return null;
  }
  
  public int d(int paramInt)
  {
    Object localObject = a;
    if (localObject == null) {
      return -1;
    }
    if (paramInt >= localObject.length) {
      return -1;
    }
    if (b == null) {}
    label102:
    do
    {
      i = -1;
      break;
      localObject = c(paramInt);
      if (localObject != null) {
        b.remove(localObject);
      }
      int j = b.size();
      for (i = 0; i < j; i++) {
        if (b.get(i)).x >= paramInt) {
          break label102;
        }
      }
      i = -1;
    } while (i == -1);
    localObject = (StaggeredGridLayoutManager.d.a)b.get(i);
    b.remove(i);
    int i = x;
    if (i == -1)
    {
      localObject = a;
      Arrays.fill((int[])localObject, paramInt, localObject.length, -1);
      return a.length;
    }
    localObject = a;
    i++;
    Arrays.fill((int[])localObject, paramInt, i, -1);
    return i;
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.StaggeredGridLayoutManager.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */