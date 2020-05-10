package d.t.a;

public class x$a
{
  public int a = 0;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 == paramInt2) {
      return 2;
    }
    return 4;
  }
  
  public boolean a()
  {
    int i = a;
    if (((i & 0x7) != 0) && ((i & a(d, b) << 0) == 0)) {
      return false;
    }
    i = a;
    if (((i & 0x70) != 0) && ((i & a(d, c) << 4) == 0)) {
      return false;
    }
    i = a;
    if (((i & 0x700) != 0) && ((i & a(e, b) << 8) == 0)) {
      return false;
    }
    i = a;
    return ((i & 0x7000) == 0) || ((i & a(e, c) << 12) != 0);
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */