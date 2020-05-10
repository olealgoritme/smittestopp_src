package e.f.a.c;

import android.util.Log;

public final class a
{
  public static String a()
  {
    Object localObject = new Throwable().getStackTrace();
    String str1 = localObject[2].getMethodName();
    String str2 = localObject[2].getClassName();
    int i = localObject[2].getLineNumber();
    str2 = str2.substring(str2.lastIndexOf('.') + 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("() [");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("] - ");
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(String.valueOf(paramObject));
    Log.e("RootBeer", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(String.valueOf(paramObject));
    Log.e("QLog", localStringBuilder.toString());
  }
  
  public static void b(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(String.valueOf(paramObject));
    Log.v("RootBeer", localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     e.f.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */