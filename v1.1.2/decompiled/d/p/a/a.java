package d.p.a;

import d.o.f0;
import d.o.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a
{
  public static <T extends l,  extends f0> a a(T paramT)
  {
    return new b(paramT, ((f0)paramT).getViewModelStore());
  }
  
  @Deprecated
  public abstract void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
}

/* Location:
 * Qualified Name:     d.p.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */