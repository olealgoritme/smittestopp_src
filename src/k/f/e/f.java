package k.f.e;

import java.io.PrintStream;

public final class f
{
  public static f.b a;
  public static boolean b = false;
  
  public static final void a(String paramString)
  {
    PrintStream localPrintStream = System.err;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SLF4J: ");
    localStringBuilder.append(paramString);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public static final void a(String paramString, Throwable paramThrowable)
  {
    System.err.println(paramString);
    System.err.println("Reported exception:");
    paramThrowable.printStackTrace();
  }
}

/* Location:
 * Qualified Name:     base.k.f.e.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */