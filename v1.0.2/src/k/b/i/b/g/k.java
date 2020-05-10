package k.b.i.b.g;

public final class k
{
  public final m a;
  public final h b;
  public byte[] c;
  public byte[] d;
  
  public k(m paramm)
  {
    if (paramm != null)
    {
      a = paramm;
      int i = b;
      b = new h(g, i);
      c = new byte[i];
      d = new byte[i];
      return;
    }
    throw new NullPointerException("params == null");
  }
  
  public n a(j paramj)
  {
    if (paramj != null)
    {
      byte[][] arrayOfByte = new byte[a.d][];
      Object localObject;
      for (int i = 0;; i++)
      {
        localObject = a;
        if (i >= d) {
          break label171;
        }
        localObject = (j.b)((j.b)new j.b().b(a)).a(b);
        e = e;
        f = i;
        g = g;
        paramj = (j)((j.b)((o.a)localObject).a(d)).b();
        if ((i < 0) || (i >= a.d)) {
          break;
        }
        arrayOfByte[i] = a(b.a(c, k.b.c.e.a.a(i, 32)), 0, a.c - 1, paramj);
      }
      throw new IllegalArgumentException("index out of bounds");
      label171:
      return new n((m)localObject, arrayOfByte);
    }
    throw new NullPointerException("otsHashAddress == null");
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      int i = paramArrayOfByte1.length;
      int j = a.b;
      if (i == j)
      {
        if (paramArrayOfByte2 != null)
        {
          if (paramArrayOfByte2.length == j)
          {
            c = paramArrayOfByte1;
            d = paramArrayOfByte2;
            return;
          }
          throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new NullPointerException("publicSeed == null");
      }
      throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
    throw new NullPointerException("secretKeySeed == null");
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, j paramj)
  {
    int i = a.b;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == i)
      {
        if (paramj != null)
        {
          if (paramj.a() != null)
          {
            int j = paramInt1 + paramInt2;
            if (j <= a.c - 1)
            {
              if (paramInt2 == 0) {
                return paramArrayOfByte;
              }
              paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2 - 1, paramj);
              Object localObject1 = (j.b)((j.b)new j.b().b(a)).a(b);
              e = e;
              f = f;
              g = (j - 1);
              localObject1 = (j)((j.b)((o.a)localObject1).a(0)).b();
              paramj = b.a(d, ((j)localObject1).a());
              Object localObject2 = (j.b)((j.b)new j.b().b(a)).a(b);
              e = e;
              f = f;
              g = g;
              localObject1 = (j)((j.b)((o.a)localObject2).a(1)).b();
              localObject2 = b.a(d, ((j)localObject1).a());
              localObject1 = new byte[i];
              for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
                localObject1[paramInt1] = ((byte)(byte)(paramArrayOfByte[paramInt1] ^ localObject2[paramInt1]));
              }
              paramArrayOfByte = b;
              if (paramArrayOfByte != null)
              {
                paramInt2 = paramj.length;
                paramInt1 = b;
                if (paramInt2 == paramInt1)
                {
                  if (i == paramInt1) {
                    return paramArrayOfByte.a(0, paramj, (byte[])localObject1);
                  }
                  throw new IllegalArgumentException("wrong in length");
                }
                throw new IllegalArgumentException("wrong key length");
              }
              throw null;
            }
            throw new IllegalArgumentException("max chain length must not be greater than w");
          }
          throw new NullPointerException("otsHashAddress byte array == null");
        }
        throw new NullPointerException("otsHashAddress == null");
      }
      throw new IllegalArgumentException(e.a.a.a.a.b("startHash needs to be ", i, "bytes"));
    }
    throw new NullPointerException("startHash == null");
  }
  
  public byte[] a(byte[] paramArrayOfByte, j paramj)
  {
    j.b localb = (j.b)((j.b)new j.b().b(a)).a(b);
    e = e;
    paramj = (j)localb.b();
    return b.a(paramArrayOfByte, paramj.a());
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */