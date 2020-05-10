package d.s;

public final class o$l<D extends Enum>
  extends o.p<D>
{
  public final Class<D> n;
  
  public o$l(Class<D> paramClass)
  {
    super(false, paramClass);
    if (paramClass.isEnum())
    {
      n = paramClass;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass);
    localStringBuilder.append(" is not an Enum type.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public D a(String paramString)
  {
    for (D ? : (Enum[])n.getEnumConstants()) {
      if (?.name().equals(paramString)) {
        return ?;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Enum value ");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append(" not found for type ");
    ((StringBuilder)???).append(n.getName());
    ((StringBuilder)???).append(".");
    throw new IllegalArgumentException(((StringBuilder)???).toString());
  }
  
  public String a()
  {
    return n.getName();
  }
}

/* Location:
 * Qualified Name:     base.d.s.o.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */