package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.OperationContext;
import k.f.b;
import k.f.c;

public class Logger
{
  public static void debug(OperationContext paramOperationContext, String paramString)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.d()) {
        localb.b(formatLogEntry(paramOperationContext, paramString));
      }
    }
  }
  
  public static void debug(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.d()) {
        localb.b(formatLogEntry(paramOperationContext, paramString, paramObject));
      }
    }
  }
  
  public static void debug(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.d()) {
        localb.b(formatLogEntry(paramOperationContext, paramString, paramObject1, paramObject2));
      }
    }
  }
  
  public static void debug(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.d()) {
        localb.b(formatLogEntry(paramOperationContext, paramString, paramVarArgs));
      }
    }
  }
  
  public static void error(OperationContext paramOperationContext, String paramString)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.f()) {
        localb.a(formatLogEntry(paramOperationContext, paramString));
      }
    }
  }
  
  public static void error(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.f()) {
        localb.a(formatLogEntry(paramOperationContext, paramString, paramObject));
      }
    }
  }
  
  public static void error(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.f()) {
        localb.a(formatLogEntry(paramOperationContext, paramString, paramObject1, paramObject2));
      }
    }
  }
  
  public static void error(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.f()) {
        localb.a(formatLogEntry(paramOperationContext, paramString, paramVarArgs));
      }
    }
  }
  
  public static String formatLogEntry(OperationContext paramOperationContext, String paramString)
  {
    if (paramOperationContext == null) {
      paramOperationContext = "*";
    } else {
      paramOperationContext = paramOperationContext.getClientRequestID();
    }
    return String.format("{%s}: {%s}", new Object[] { paramOperationContext, paramString.replace('\n', '.') });
  }
  
  public static String formatLogEntry(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (paramOperationContext == null) {
      paramOperationContext = "*";
    } else {
      paramOperationContext = paramOperationContext.getClientRequestID();
    }
    return String.format("{%s}: {%s}", new Object[] { paramOperationContext, String.format(paramString, new Object[] { paramObject }).replace('\n', '.') });
  }
  
  public static String formatLogEntry(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramOperationContext == null) {
      paramOperationContext = "*";
    } else {
      paramOperationContext = paramOperationContext.getClientRequestID();
    }
    return String.format("{%s}: {%s}", new Object[] { paramOperationContext, String.format(paramString, new Object[] { paramObject1, paramObject2 }).replace('\n', '.') });
  }
  
  public static String formatLogEntry(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (paramOperationContext == null) {
      paramOperationContext = "*";
    } else {
      paramOperationContext = paramOperationContext.getClientRequestID();
    }
    return String.format("{%s}: {%s}", new Object[] { paramOperationContext, String.format(paramString, paramVarArgs).replace('\n', '.') });
  }
  
  public static void info(OperationContext paramOperationContext, String paramString)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.a()) {
        localb.c(formatLogEntry(paramOperationContext, paramString));
      }
    }
  }
  
  public static void info(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.a()) {
        localb.c(formatLogEntry(paramOperationContext, paramString, paramObject));
      }
    }
  }
  
  public static void info(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.a()) {
        localb.c(formatLogEntry(paramOperationContext, paramString, paramObject1, paramObject2));
      }
    }
  }
  
  public static void info(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.a()) {
        localb.c(formatLogEntry(paramOperationContext, paramString, paramVarArgs));
      }
    }
  }
  
  public static boolean shouldLog(OperationContext paramOperationContext)
  {
    if (paramOperationContext != null) {
      return paramOperationContext.isLoggingEnabled();
    }
    return OperationContext.isLoggingEnabledByDefault();
  }
  
  public static void trace(OperationContext paramOperationContext, String paramString)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.e()) {
        localb.e(formatLogEntry(paramOperationContext, paramString));
      }
    }
  }
  
  public static void trace(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.e()) {
        localb.e(formatLogEntry(paramOperationContext, paramString, paramObject));
      }
    }
  }
  
  public static void trace(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.e()) {
        localb.e(formatLogEntry(paramOperationContext, paramString, paramObject1, paramObject2));
      }
    }
  }
  
  public static void trace(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.e()) {
        localb.e(formatLogEntry(paramOperationContext, paramString, paramVarArgs));
      }
    }
  }
  
  public static void warn(OperationContext paramOperationContext, String paramString)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.b()) {
        localb.d(formatLogEntry(paramOperationContext, paramString));
      }
    }
  }
  
  public static void warn(OperationContext paramOperationContext, String paramString, Object paramObject)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.b()) {
        localb.d(formatLogEntry(paramOperationContext, paramString, paramObject));
      }
    }
  }
  
  public static void warn(OperationContext paramOperationContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.b()) {
        localb.d(formatLogEntry(paramOperationContext, paramString, paramObject1, paramObject2));
      }
    }
  }
  
  public static void warn(OperationContext paramOperationContext, String paramString, Object... paramVarArgs)
  {
    if (shouldLog(paramOperationContext))
    {
      b localb;
      if (paramOperationContext == null) {
        localb = c.a("ROOT");
      } else {
        localb = paramOperationContext.getLogger();
      }
      if (localb.b()) {
        localb.d(formatLogEntry(paramOperationContext, paramString, paramVarArgs));
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */