package d.o;

public class c0
  implements a0
{
  public <T extends y> T a(Class<T> paramClass)
  {
    try
    {
      localObject = (y)paramClass.newInstance();
      return (T)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot create an instance of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.o.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */