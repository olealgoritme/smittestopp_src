package k.d.a;

public final class k
{
  public j a;
  public j b;
  
  public j a()
  {
    try
    {
      j localj1 = a;
      if (a != null)
      {
        j localj2 = a.c;
        a = localj2;
        if (localj2 == null) {
          b = null;
        }
      }
      return localj1;
    }
    finally {}
  }
  
  public j a(int paramInt)
  {
    try
    {
      if (a == null) {
        wait(paramInt);
      }
      j localj = a();
      return localj;
    }
    finally {}
  }
  
  public void a(j paramj)
  {
    if (paramj != null) {
      try
      {
        if (b != null)
        {
          b.c = paramj;
          b = paramj;
        }
        else
        {
          if (a != null) {
            break label53;
          }
          b = paramj;
          a = paramj;
        }
        notifyAll();
        return;
        label53:
        paramj = new java/lang/IllegalStateException;
        paramj.<init>("Head present, but no tail");
        throw paramj;
      }
      finally
      {
        break label81;
      }
    }
    paramj = new java/lang/NullPointerException;
    paramj.<init>("null cannot be enqueued");
    throw paramj;
    label81:
    throw paramj;
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */