package com.android.volley.toolbox;

import android.widget.ImageView;
import com.android.volley.VolleyError;

public class ImageLoader$1
  implements ImageLoader.ImageListener
{
  public ImageLoader$1(int paramInt1, ImageView paramImageView, int paramInt2) {}
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    int i = val$errorImageResId;
    if (i != 0) {
      val$view.setImageResource(i);
    }
  }
  
  public void onResponse(ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean)
  {
    if (paramImageContainer.getBitmap() != null)
    {
      val$view.setImageBitmap(paramImageContainer.getBitmap());
    }
    else
    {
      int i = val$defaultImageResId;
      if (i != 0) {
        val$view.setImageResource(i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.ImageLoader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */