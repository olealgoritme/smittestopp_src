package l.a.b.a.c;

public class n0$b
  extends d0<String>
  implements n0.d
{
  public String c;
  public int d;
  
  public n0$b(n0 paramn0, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public void a(String paramString, int paramInt)
  {
    c = paramString;
    d = paramInt;
  }
  
  public boolean a(r0<String> paramr0)
  {
    boolean bool;
    if (e == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c(Object paramObject)
  {
    paramObject = (String)paramObject;
    int i;
    if (paramObject == c) {
      i = d;
    } else {
      i = n0.a((String)paramObject);
    }
    return i;
  }
  
  public void d(Object paramObject)
  {
    paramObject = (String)paramObject;
    y0 localy0 = a.a;
    int i;
    if (paramObject == c) {
      i = d;
    } else {
      i = n0.a((String)paramObject);
    }
    localy0.b(i);
    a.a.a((String)paramObject);
  }
  
  public byte f()
  {
    return -79;
  }
  
  public a getType()
  {
    return e;
  }
  
  public i0 getType()
  {
    return e;
  }
  
  public Object i()
  {
    Object localObject = b;
    int i = ((r)localObject).f();
    if (i == 0) {
      localObject = "";
    } else {
      localObject = (String)((r)localObject).a(n0.c, i);
    }
    return localObject;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.n0.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */