package d.o;

public class c0
  implements a0
{
  public <T extends y> T a(Class<T> paramClass)
  {
    try
    {
      y localy = (y)paramClass.newInstance();
      return localy;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Cannot create an instance of ");
      localStringBuilder2.append(paramClass);
      throw new RuntimeException(localStringBuilder2.toString(), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Cannot create an instance of ");
      localStringBuilder1.append(paramClass);
      throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
    }
  }
}

/* Location:
 * Qualified Name:     d.o.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */