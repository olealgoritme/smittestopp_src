package m.a;

import e.a.a.a.a;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class a$b
{
  public final ThreadLocal<String> a = new ThreadLocal();
  
  public abstract void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public final void a(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    String str1 = (String)a.get();
    if (str1 != null) {
      a.remove();
    }
    String str2 = paramString;
    if (paramString != null)
    {
      str2 = paramString;
      if (paramString.length() == 0) {
        str2 = null;
      }
    }
    if (str2 == null)
    {
      if (paramThrowable == null) {
        return;
      }
      paramVarArgs = c(paramThrowable);
    }
    else
    {
      paramString = str2;
      if (paramVarArgs != null)
      {
        paramString = str2;
        if (paramVarArgs.length > 0) {
          paramString = String.format(str2, paramVarArgs);
        }
      }
      paramVarArgs = paramString;
      if (paramThrowable != null)
      {
        paramString = a.a(paramString, "\n");
        paramString.append(c(paramThrowable));
        paramVarArgs = paramString.toString();
      }
    }
    a(paramInt, str1, paramVarArgs, paramThrowable);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    a(3, null, paramString, paramVarArgs);
  }
  
  public void a(Throwable paramThrowable)
  {
    a(3, paramThrowable, null, new Object[0]);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    a(6, null, paramString, paramVarArgs);
  }
  
  public void b(Throwable paramThrowable)
  {
    a(6, paramThrowable, null, new Object[0]);
  }
  
  public final String c(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter(256);
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, false);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    a(4, null, paramString, paramVarArgs);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    a(5, null, paramString, paramVarArgs);
  }
}

/* Location:
 * Qualified Name:     m.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */