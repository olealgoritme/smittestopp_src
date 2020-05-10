package j.a.b;

public class g
{
  public static final g h = new g(0);
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public j.f e;
  public j.f f;
  public j.g g;
  
  static
  {
    new g(-1);
    new g(2);
  }
  
  public g(int paramInt)
  {
    boolean bool1 = false;
    if ((paramInt & 0x1) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    a = bool2;
    if ((paramInt & 0x4) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    c = bool2;
    if ((paramInt & 0x2) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    b = bool2;
    boolean bool2 = bool1;
    if ((paramInt & 0x10) > 0) {
      bool2 = true;
    }
    d = bool2;
    Object localObject;
    if ((paramInt & 0x8) > 0) {
      localObject = j.c;
    } else {
      localObject = j.a;
    }
    if (c) {
      f = j.b;
    } else {
      f = ((j.f)localObject);
    }
    if (a) {
      e = j.b;
    } else {
      e = ((j.f)localObject);
    }
    if (b) {
      g = j.e;
    } else {
      g = j.d;
    }
  }
  
  public void a(Appendable paramAppendable, String paramString)
  {
    if (!f.a(paramString))
    {
      paramAppendable.append(paramString);
    }
    else
    {
      paramAppendable.append('"');
      i.a(paramString, paramAppendable, this);
      paramAppendable.append('"');
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */