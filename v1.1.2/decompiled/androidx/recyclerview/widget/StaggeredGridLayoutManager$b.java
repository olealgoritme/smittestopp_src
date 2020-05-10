package androidx.recyclerview.widget;

import java.util.Arrays;

public class StaggeredGridLayoutManager$b
{
  public int a;
  public int b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int[] f;
  
  public StaggeredGridLayoutManager$b(StaggeredGridLayoutManager paramStaggeredGridLayoutManager)
  {
    a();
  }
  
  public void a()
  {
    a = -1;
    b = Integer.MIN_VALUE;
    c = false;
    d = false;
    e = false;
    int[] arrayOfInt = f;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */