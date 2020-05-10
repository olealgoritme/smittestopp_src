package com.microsoft.appcenter.utils;

import android.os.Bundle;
import java.lang.reflect.Method;

public class InstrumentationRegistryHelper
{
  public static final String[] LOCATIONS = { "androidx.test.platform.app.InstrumentationRegistry", "androidx.test.InstrumentationRegistry", "androidx.test.InstrumentationRegistry" };
  
  public static Bundle getArguments()
  {
    String[] arrayOfString = LOCATIONS;
    int i = arrayOfString.length;
    Object localObject = null;
    int j = 0;
    while (j < i)
    {
      localObject = arrayOfString[j];
      try
      {
        localObject = (Bundle)getClass((String)localObject).getMethod("getArguments", new Class[0]).invoke(null, new Object[0]);
        return (Bundle)localObject;
      }
      catch (Exception localException)
      {
        j++;
      }
    }
    throw new IllegalStateException(localException);
  }
  
  public static Class<?> getClass(String paramString)
  {
    return Class.forName(paramString);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.InstrumentationRegistryHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */