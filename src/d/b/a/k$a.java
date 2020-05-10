package d.b.a;

public final class k$a
  implements Thread.UncaughtExceptionHandler
{
  public k$a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof Resources.NotFoundException;
    int i = 0;
    int j = i;
    Object localObject;
    if (bool)
    {
      localObject = paramThrowable.getMessage();
      j = i;
      if (localObject != null) {
        if (!((String)localObject).contains("drawable"))
        {
          j = i;
          if (!((String)localObject).contains("Drawable")) {}
        }
        else
        {
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
      localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
      ((Throwable)localObject).initCause(paramThrowable.getCause());
      ((Throwable)localObject).setStackTrace(paramThrowable.getStackTrace());
      a.uncaughtException(paramThread, (Throwable)localObject);
    }
    else
    {
      a.uncaughtException(paramThread, paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */