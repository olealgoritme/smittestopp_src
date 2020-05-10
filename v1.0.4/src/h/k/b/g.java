package h.k.b;

import java.util.Arrays;

public class g
{
  public static <T extends Throwable> T a(T paramT)
  {
    String str = g.class.getName();
    StackTraceElement[] arrayOfStackTraceElement = paramT.getStackTrace();
    int i = arrayOfStackTraceElement.length;
    int j = -1;
    for (int k = 0; k < i; k++) {
      if (str.equals(arrayOfStackTraceElement[k].getClassName())) {
        j = k;
      }
    }
    paramT.setStackTrace((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, j + 1, i));
    return paramT;
  }
  
  public static void a()
  {
    h.a locala = new h.a();
    a(locala);
    throw ((h.a)locala);
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new IllegalStateException(e.a.a.a.a.b(paramString, " must not be null"));
    a((Throwable)paramObject);
    throw ((IllegalStateException)paramObject);
  }
  
  public static void a(String paramString)
  {
    Object localObject = Thread.currentThread().getStackTrace()[3];
    String str1 = ((StackTraceElement)localObject).getClassName();
    String str2 = ((StackTraceElement)localObject).getMethodName();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Parameter specified as non-null is null: method ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", parameter ");
    ((StringBuilder)localObject).append(paramString);
    paramString = new IllegalArgumentException(((StringBuilder)localObject).toString());
    a(paramString);
    throw ((IllegalArgumentException)paramString);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
  }
  
  public static void b(String paramString)
  {
    paramString = new h.g(e.a.a.a.a.a("lateinit property ", paramString, " has not been initialized"));
    a(paramString);
    throw paramString;
  }
}

/* Location:
 * Qualified Name:     base.h.k.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */