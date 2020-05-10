package com.microsoft.identity.common.internal.logging;

import com.google.gson.Gson;
import java.util.HashMap;

public class RequestContext
  extends HashMap<String, String>
  implements IRequestContext
{
  public final Gson mGson = new Gson();
  
  public String toJsonString()
  {
    return mGson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.logging.RequestContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */