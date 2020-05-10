package d.p.a;

import d.b.a.r;
import d.f.i;
import d.o.a0;
import d.o.b0;
import d.o.d0;
import d.o.e0;
import d.o.l;
import d.o.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class b
  extends a
{
  public final l a;
  public final b.c b;
  
  public b(l paraml, e0 parame0)
  {
    a = paraml;
    a0 locala0 = b.c.d;
    paraml = b.c.class.getCanonicalName();
    if (paraml != null)
    {
      Object localObject = e.a.a.a.a.b("androidx.lifecycle.ViewModelProvider.DefaultKey:", paraml);
      paraml = (y)a.get(localObject);
      if (b.c.class.isInstance(paraml))
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
          paraml = ((b0)locala0).a((String)localObject, b.c.class);
        } else {
          paraml = locala0.a(b.c.class);
        }
        localObject = (y)a.put(localObject, paraml);
        parame0 = paraml;
        if (localObject != null)
        {
          ((y)localObject).b();
          parame0 = paraml;
        }
      }
      b = ((b.c)parame0);
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
        paramArrayOfString = (b.a)c.d(0);
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
    r.a(a, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.p.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */