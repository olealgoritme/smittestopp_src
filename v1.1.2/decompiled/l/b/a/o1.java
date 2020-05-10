package l.b.a;

import java.io.ByteArrayOutputStream;

public class o1
  extends i
{
  public o1(f paramf)
  {
    super(paramf);
  }
  
  public o1(o paramo, l paraml, t paramt1, int paramInt, t paramt2)
  {
    super(paramo, paraml, paramt1, paramInt, paramt2);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = x;
    if (localObject != null) {
      localByteArrayOutputStream.write(((n)localObject).a("DL"));
    }
    localObject = y;
    if (localObject != null) {
      localByteArrayOutputStream.write(((n)localObject).a("DL"));
    }
    localObject = z;
    if (localObject != null) {
      localByteArrayOutputStream.write(((n)localObject).a("DL"));
    }
    localByteArrayOutputStream.write(new h1(true, A, B).a("DL"));
    paramr.a(paramBoolean, 32, 8, localByteArrayOutputStream.toByteArray());
  }
  
  public int f()
  {
    return e().length;
  }
  
  public t i()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     l.b.a.o1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */