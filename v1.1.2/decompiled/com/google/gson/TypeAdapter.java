package com.google.gson;

import e.c.c.j;
import e.c.c.k;
import e.c.c.y.c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T>
{
  public final T fromJson(Reader paramReader)
  {
    return (T)read(new e.c.c.y.a(paramReader));
  }
  
  public final T fromJson(String paramString)
  {
    return (T)fromJson(new StringReader(paramString));
  }
  
  public final T fromJsonTree(j paramj)
  {
    try
    {
      e.c.c.w.z.a locala = new e/c/c/w/z/a;
      locala.<init>(paramj);
      paramj = read(locala);
      return paramj;
    }
    catch (IOException paramj)
    {
      throw new k(paramj);
    }
  }
  
  public final TypeAdapter<T> nullSafe()
  {
    new TypeAdapter()
    {
      public T read(e.c.c.y.a paramAnonymousa)
      {
        if (paramAnonymousa.r() == e.c.c.y.b.NULL)
        {
          paramAnonymousa.o();
          return null;
        }
        return (T)TypeAdapter.this.read(paramAnonymousa);
      }
      
      public void write(c paramAnonymousc, T paramAnonymousT)
      {
        if (paramAnonymousT == null) {
          paramAnonymousc.g();
        } else {
          TypeAdapter.this.write(paramAnonymousc, paramAnonymousT);
        }
      }
    };
  }
  
  public abstract T read(e.c.c.y.a parama);
  
  public final String toJson(T paramT)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      toJson(localStringWriter, paramT);
      return localStringWriter.toString();
    }
    catch (IOException paramT)
    {
      throw new AssertionError(paramT);
    }
  }
  
  public final void toJson(Writer paramWriter, T paramT)
  {
    write(new c(paramWriter), paramT);
  }
  
  public final j toJsonTree(T paramT)
  {
    try
    {
      e.c.c.w.z.b localb = new e/c/c/w/z/b;
      localb.<init>();
      write(localb, paramT);
      paramT = localb.j();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new k(paramT);
    }
  }
  
  public abstract void write(c paramc, T paramT);
}

/* Location:
 * Qualified Name:     com.google.gson.TypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */