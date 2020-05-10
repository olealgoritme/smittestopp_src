package e.c.c.w;

public final class x
  extends y
{
  public <T> T a(Class<T> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot allocate ");
    localStringBuilder.append(paramClass);
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */