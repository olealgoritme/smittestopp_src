package d.i.j;

public class a$a
{
  public int a;
  public int b;
  public float c;
  public float d;
  public long e = Long.MIN_VALUE;
  public long f = 0L;
  public int g = 0;
  public int h = 0;
  public long i = -1L;
  public float j;
  public int k;
  
  public final float a(long paramLong)
  {
    if (paramLong < e) {
      return 0.0F;
    }
    long l = i;
    if ((l >= 0L) && (paramLong >= l))
    {
      float f1 = j;
      return a.a((float)(paramLong - l) / k, 0.0F, 1.0F) * f1 + (1.0F - f1);
    }
    return a.a((float)(paramLong - e) / a, 0.0F, 1.0F) * 0.5F;
  }
}

/* Location:
 * Qualified Name:     d.i.j.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */