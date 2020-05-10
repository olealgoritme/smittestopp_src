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
    for (localObject : (Enum[])n.getEnumConstants()) {
      if (((Enum)localObject).name().equals(paramString)) {
        return (D)localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enum value ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found for type ");
    ((StringBuilder)localObject).append(n.getName());
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public String a()
  {
    return n.getName();
  }
}

/* Location:
 * Qualified Name:     d.s.o.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */