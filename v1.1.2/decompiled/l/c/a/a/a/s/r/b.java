package l.c.a.a.a.s.r;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class b
  extends ByteArrayOutputStream
{
  public final f x;
  public final i y;
  
  public b(f paramf)
  {
    x = paramf;
    y = null;
  }
  
  public b(i parami)
  {
    x = null;
    y = parami;
  }
  
  public OutputStream a()
  {
    Object localObject = x;
    if (localObject != null) {
      return ((f)localObject).d();
    }
    localObject = y;
    if (localObject != null) {
      return ((i)localObject).d();
    }
    return null;
  }
  
  public void flush()
  {
    try
    {
      Object localObject1 = ByteBuffer.wrap(toByteArray());
      reset();
      localObject1 = new d((byte)2, true, ((ByteBuffer)localObject1).array()).a();
      a().write((byte[])localObject1);
      a().flush();
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.r.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */