package h.a;

public final class c$c
{
  public static final String a;
  
  static
  {
    Object localObject = new c();
    String str;
    try
    {
      localObject = localObject.getClass();
      Package localPackage = ((Class)localObject).getPackage();
      if (localPackage != null) {
        localObject = localPackage.getName();
      } else {
        localObject = ((Class)localObject).getName().substring(0, ((Class)localObject).getName().lastIndexOf('.'));
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      str = "jnr.constants";
    }
    a = str;
  }
}

/* Location:
 * Qualified Name:     h.a.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */