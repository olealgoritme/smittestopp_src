package k.e.a;

public class b
{
  public final String a;
  public byte[] b;
  public b c;
  
  public b(String paramString)
  {
    a = paramString;
  }
  
  public static int a(x paramx, int paramInt1, int paramInt2)
  {
    int i;
    if (((paramInt1 & 0x1000) != 0) && (c < 49))
    {
      paramx.c("Synthetic");
      i = 6;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (paramInt2 != 0)
    {
      paramx.c("Signature");
      j = i + 8;
    }
    paramInt2 = j;
    if ((paramInt1 & 0x20000) != 0)
    {
      paramx.c("Deprecated");
      paramInt2 = j + 6;
    }
    return paramInt2;
  }
  
  public static void a(x paramx, int paramInt1, int paramInt2, c paramc)
  {
    if (((paramInt1 & 0x1000) != 0) && (c < 49))
    {
      paramc.d(paramx.c("Synthetic"));
      paramc.c(0);
    }
    if (paramInt2 != 0)
    {
      paramc.d(paramx.c("Signature"));
      paramc.c(2);
      paramc.d(paramInt2);
    }
    if ((paramInt1 & 0x20000) != 0)
    {
      paramc.d(paramx.c("Deprecated"));
      paramc.c(0);
    }
  }
  
  public final int a()
  {
    int i = 0;
    for (b localb = this; localb != null; localb = c) {
      i++;
    }
    return i;
  }
  
  public final int a(x paramx)
  {
    return a(paramx, null, 0, -1, -1);
  }
  
  public final int a(x paramx, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = a;
    paramInt1 = 0;
    for (paramArrayOfByte = this; paramArrayOfByte != null; paramArrayOfByte = c)
    {
      paramx.c(a);
      paramInt1 += b.length + 6;
    }
    return paramInt1;
  }
  
  public final void a(x paramx, c paramc)
  {
    a(paramx, null, 0, -1, -1, paramc);
  }
  
  public final void a(x paramx, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, c paramc)
  {
    paramArrayOfByte = a;
    for (paramArrayOfByte = this; paramArrayOfByte != null; paramArrayOfByte = c)
    {
      byte[] arrayOfByte = b;
      paramInt1 = arrayOfByte.length;
      paramc.d(paramx.c(a));
      paramc.c(paramInt1);
      paramc.a(arrayOfByte, 0, paramInt1);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */