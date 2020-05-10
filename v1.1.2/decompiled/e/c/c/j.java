package e.c.c;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import e.c.c.y.c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class j
{
  public int a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public g b()
  {
    if ((this instanceof g)) {
      return (g)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Array: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public m c()
  {
    if ((this instanceof m)) {
      return (m)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Object: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public p d()
  {
    if ((this instanceof p)) {
      return (p)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Primitive: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new java/io/StringWriter;
      ((StringWriter)localObject).<init>();
      c localc = new e/c/c/y/c;
      localc.<init>((Writer)localObject);
      C = true;
      TypeAdapters.X.write(localc, this);
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */