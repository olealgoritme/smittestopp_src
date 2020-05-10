package com.microsoft.identity.common.internal.util;

import com.google.gson.Gson;
import e.c.c.x.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeaderSerializationUtil
{
  public static HashMap<String, List<String>> fromJson(String paramString)
  {
    return (HashMap)new Gson().a(paramString, new HeaderSerializationUtil.1().getType());
  }
  
  public static String toJson(Map<String, List<String>> paramMap)
  {
    return new Gson().a(paramMap);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.util.HeaderSerializationUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */