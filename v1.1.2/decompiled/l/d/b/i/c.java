package l.d.b.i;

public final class c<T>
{
  public a<T>[] a = new a[16];
  public int b = 16;
  public int c = 21;
  public int d;
  
  public T a(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = b;
    for (a locala = a[(((j ^ i) & 0x7FFFFFFF) % k)]; locala != null; locala = c) {
      if (a == paramLong) {
        return (T)b;
      }
    }
    return null;
  }
  
  public T a(long paramLong, T paramT)
  {
    int i = (int)(paramLong >>> 32);
    i = (((int)paramLong ^ i) & 0x7FFFFFFF) % b;
    Object localObject1 = a[i];
    for (Object localObject2 = localObject1; localObject2 != null; localObject2 = c) {
      if (a == paramLong)
      {
        localObject1 = b;
        b = paramT;
        return (T)localObject1;
      }
    }
    a[i] = new a(paramLong, paramT, (a)localObject1);
    i = d + 1;
    d = i;
    if (i > c) {
      a(b * 2);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    a[] arrayOfa = new a[paramInt];
    int i = a.length;
    for (int j = 0; j < i; j++)
    {
      a locala;
      for (Object localObject = a[j]; localObject != null; localObject = locala)
      {
        long l = a;
        int k = (((int)(l >>> 32) ^ (int)l) & 0x7FFFFFFF) % paramInt;
        locala = c;
        c = arrayOfa[k];
        arrayOfa[k] = localObject;
      }
    }
    a = arrayOfa;
    b = paramInt;
    c = (paramInt * 4 / 3);
  }
  
  public static final class a<T>
  {
    public final long a;
    public T b;
    public a<T> c;
    
    public a(long paramLong, T paramT, a<T> parama)
    {
      a = paramLong;
      b = paramT;
      c = parama;
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */