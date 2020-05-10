package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import java.io.File;

public class Volley
{
  public static final String DEFAULT_CACHE_DIR = "volley";
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    return newRequestQueue(paramContext, null);
  }
  
  public static RequestQueue newRequestQueue(Context paramContext, Network paramNetwork)
  {
    paramContext = new RequestQueue(new DiskBasedCache(new File(paramContext.getCacheDir(), "volley")), paramNetwork);
    paramContext.start();
    return paramContext;
  }
  
  public static RequestQueue newRequestQueue(Context paramContext, BaseHttpStack paramBaseHttpStack)
  {
    if (paramBaseHttpStack == null) {
      paramBaseHttpStack = new BasicNetwork(new HurlStack());
    } else {
      paramBaseHttpStack = new BasicNetwork(paramBaseHttpStack);
    }
    return newRequestQueue(paramContext, paramBaseHttpStack);
  }
  
  @Deprecated
  public static RequestQueue newRequestQueue(Context paramContext, HttpStack paramHttpStack)
  {
    if (paramHttpStack == null) {
      return newRequestQueue(paramContext, null);
    }
    return newRequestQueue(paramContext, new BasicNetwork(paramHttpStack));
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.Volley
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */