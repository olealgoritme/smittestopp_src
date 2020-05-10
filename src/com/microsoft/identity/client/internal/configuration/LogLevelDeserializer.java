package com.microsoft.identity.client.internal.configuration;

import com.microsoft.identity.client.Logger.LogLevel;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import java.lang.reflect.Type;
import java.util.Locale;

public class LogLevelDeserializer
  implements i<Logger.LogLevel>
{
  public Logger.LogLevel deserialize(j paramj, Type paramType, h paramh)
  {
    return Logger.LogLevel.valueOf(paramj.f().toUpperCase(Locale.US));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.configuration.LogLevelDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */