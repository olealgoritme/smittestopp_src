package l.b.f.a;

public class d$d
  extends d.b
{
  public d$d(b paramb, c paramc1, c paramc2)
  {
    super(paramb, paramc1, paramc2);
  }
  
  public d$d(b paramb, c paramc1, c paramc2, c[] paramArrayOfc)
  {
    super(paramb, paramc1, paramc2, paramArrayOfc);
  }
  
  public c a(int paramInt)
  {
    if ((paramInt == 1) && (4 == a()))
    {
      c[] arrayOfc = d;
      c localc1 = arrayOfc[1];
      c localc2 = localc1;
      if (localc1 == null)
      {
        localc1 = arrayOfc[0];
        localc2 = a.b;
        if ((!localc2.e()) && (!localc1.d()))
        {
          c localc3 = localc1.g().g();
          localc1 = localc2.f();
          if (localc1.a() < localc2.a()) {
            localc2 = localc3.c(localc1).f();
          } else {
            localc2 = localc3.c(localc2);
          }
        }
        arrayOfc[1] = localc2;
      }
      return localc2;
    }
    return super.a(paramInt);
  }
}

/* Location:
 * Qualified Name:     l.b.f.a.d.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */