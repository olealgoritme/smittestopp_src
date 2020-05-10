package d.i.b.b;

import java.util.List;

public final class f
{
  public final int[] a;
  public final float[] b;
  
  public f(int paramInt1, int paramInt2)
  {
    a = new int[] { paramInt1, paramInt2 };
    b = new float[] { 0.0F, 1.0F };
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    a = new int[] { paramInt1, paramInt2, paramInt3 };
    b = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  public f(List<Integer> paramList, List<Float> paramList1)
  {
    int i = paramList.size();
    a = new int[i];
    b = new float[i];
    for (int j = 0; j < i; j++)
    {
      a[j] = ((Integer)paramList.get(j)).intValue();
      b[j] = ((Float)paramList1.get(j)).floatValue();
    }
  }
}

/* Location:
 * Qualified Name:     d.i.b.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */