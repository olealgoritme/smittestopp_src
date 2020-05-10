package d.p.a;

import androidx.lifecycle.LiveData;
import d.b.a.s;
import d.f.i;
import d.o.a0;
import d.o.b0;
import d.o.d0;
import d.o.e0;
import d.o.l;
import d.o.q;
import d.o.r;
import d.o.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class b
  extends a
{
  public final l a;
  public final c b;
  
  public b(l paraml, e0 parame0)
  {
    a = paraml;
    a0 locala0 = c.d;
    paraml = c.class.getCanonicalName();
    if (paraml != null)
    {
      Object localObject = e.a.a.a.a.b("androidx.lifecycle.ViewModelProvider.DefaultKey:", paraml);
      paraml = (y)a.get(localObject);
      if (c.class.isInstance(paraml))
      {
        parame0 = paraml;
        if ((locala0 instanceof d0))
        {
          ((d0)locala0).a(paraml);
          parame0 = paraml;
        }
      }
      else
      {
        if ((locala0 instanceof b0)) {
          paraml = ((b0)locala0).a((String)localObject, c.class);
        } else {
          paraml = locala0.a(c.class);
        }
        localObject = (y)a.put(localObject, paraml);
        parame0 = paraml;
        if (localObject != null)
        {
          ((y)localObject).b();
          parame0 = paraml;
        }
      }
      b = ((c)parame0);
      return;
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @Deprecated
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramFileDescriptor = b;
    if (c.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append(paramString);
      paramArrayOfString.append("    ");
      String str = paramArrayOfString.toString();
      if (c.b() > 0)
      {
        paramArrayOfString = (a)c.d(0);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(c.b(0));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramArrayOfString.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(0);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(null);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(null);
        throw null;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    s.a(a, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class a<D>
    extends q<D>
    implements Object<D>
  {
    public l j;
    public b.b<D> k;
    
    public void a()
    {
      throw null;
    }
    
    public void a(r<? super D> paramr)
    {
      super.a(paramr);
      j = null;
      k = null;
    }
    
    public void a(D paramD)
    {
      super.a(paramD);
    }
    
    public void b()
    {
      throw null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(0);
      localStringBuilder.append(" : ");
      s.a(null, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  public static class b<D>
    implements r<D>
  {}
  
  public static class c
    extends y
  {
    public static final a0 d = new a();
    public i<b.a> c = new i(10);
    
    public void b()
    {
      if (c.b() > 0)
      {
        if ((b.a)c.d(0) != null) {
          throw null;
        }
        throw null;
      }
      i locali = c;
      int i = A;
      Object[] arrayOfObject = z;
      for (int j = 0; j < i; j++) {
        arrayOfObject[j] = null;
      }
      A = 0;
      x = false;
    }
    
    public static final class a
      implements a0
    {
      public <T extends y> T a(Class<T> paramClass)
      {
        return new b.c();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.p.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */