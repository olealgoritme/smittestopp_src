package d.b.e;

public class m0
{
  public int a = 0;
  public int b = 0;
  public int c = Integer.MIN_VALUE;
  public int d = Integer.MIN_VALUE;
  public int e = 0;
  public int f = 0;
  public boolean g = false;
  public boolean h = false;
  
  public void a(int paramInt1, int paramInt2)
  {
    c = paramInt1;
    d = paramInt2;
    h = true;
    if (g)
    {
      if (paramInt2 != Integer.MIN_VALUE) {
        a = paramInt2;
      }
      if (paramInt1 != Integer.MIN_VALUE) {
        b = paramInt1;
      }
    }
    else
    {
      if (paramInt1 != Integer.MIN_VALUE) {
        a = paramInt1;
      }
      if (paramInt2 != Integer.MIN_VALUE) {
        b = paramInt2;
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.m0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */