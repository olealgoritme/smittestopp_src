package com.android.volley.toolbox;

import android.graphics.Bitmap;
import com.android.volley.Response.Listener;

public class ImageLoader$2
  implements Response.Listener<Bitmap>
{
  public ImageLoader$2(ImageLoader paramImageLoader, String paramString) {}
  
  public void onResponse(Bitmap paramBitmap)
  {
    this$0.onGetImageSuccess(val$cacheKey, paramBitmap);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.ImageLoader.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */