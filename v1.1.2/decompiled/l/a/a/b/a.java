package l.a.a.b;

public class a
{
  @Deprecated
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return paramObject1.equals(paramObject2);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */