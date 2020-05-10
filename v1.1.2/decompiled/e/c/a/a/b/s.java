package e.c.a.a.b;

import java.lang.ref.WeakReference;

public abstract class s
  extends q
{
  public static final WeakReference<byte[]> c = new WeakReference(null);
  public WeakReference<byte[]> b = c;
  
  public s(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public final byte[] c()
  {
    try
    {
      Object localObject1 = (byte[])b.get();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = d();
        localObject1 = new java/lang/ref/WeakReference;
        ((WeakReference)localObject1).<init>(localObject2);
        b = ((WeakReference)localObject1);
      }
      return (byte[])localObject2;
    }
    finally {}
  }
  
  public abstract byte[] d();
}

/* Location:
 * Qualified Name:     e.c.a.a.b.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */