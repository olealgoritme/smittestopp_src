package k.b.a;

import java.io.InputStream;

public abstract class b2
  extends InputStream
{
  public final InputStream x;
  public int y;
  
  public b2(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    x = paramInputStream;
    y = paramInt1;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = x;
    if ((localObject instanceof y1))
    {
      localObject = (y1)localObject;
      C = paramBoolean;
      ((y1)localObject).a();
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.b2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */