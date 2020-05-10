package j.a.b.l;

public class e
  extends Exception
{
  public Object x;
  
  public e(int paramInt1, int paramInt2, Object paramObject)
  {
    super(a(paramInt1, paramInt2, paramObject));
    x = paramObject;
  }
  
  public e(int paramInt, Throwable paramThrowable)
  {
    super(a(paramInt, 2, paramThrowable), paramThrowable);
  }
  
  public static String a(int paramInt1, int paramInt2, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt2 == 0)
    {
      localStringBuilder.append("Unexpected character (");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(") at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else if (paramInt2 == 1)
    {
      localStringBuilder.append("Unexpected token ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else if (paramInt2 == 2)
    {
      localStringBuilder.append("Unexpected exception ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" occur at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else if (paramInt2 == 3)
    {
      localStringBuilder.append("Unexpected End Of File position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramObject);
    }
    else if (paramInt2 == 4)
    {
      localStringBuilder.append("Unexpected unicode escape sequence ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else if (paramInt2 == 5)
    {
      localStringBuilder.append("Unexpected duplicate key:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else if (paramInt2 == 6)
    {
      localStringBuilder.append("Unexpected leading 0 in digit for token:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    else
    {
      localStringBuilder.append("Unkown error at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     j.a.b.l.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */