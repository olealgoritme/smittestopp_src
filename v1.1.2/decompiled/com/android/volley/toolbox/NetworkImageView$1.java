package com.android.volley.toolbox;

import android.widget.ImageView;
import com.android.volley.VolleyError;

public class NetworkImageView$1
  implements ImageLoader.ImageListener
{
  public NetworkImageView$1(NetworkImageView paramNetworkImageView, boolean paramBoolean) {}
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    if (NetworkImageView.access$000(this$0) != 0)
    {
      paramVolleyError = this$0;
      paramVolleyError.setImageResource(NetworkImageView.access$000(paramVolleyError));
    }
  }
  
  public void onResponse(final ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean)
  {
    if ((paramBoolean) && (val$isInLayoutPass))
    {
      this$0.post(new Runnable()
      {
        public void run()
        {
          onResponse(paramImageContainer, false);
        }
      });
      return;
    }
    if (paramImageContainer.getBitmap() != null)
    {
      this$0.setImageBitmap(paramImageContainer.getBitmap());
    }
    else if (NetworkImageView.access$100(this$0) != 0)
    {
      paramImageContainer = this$0;
      paramImageContainer.setImageResource(NetworkImageView.access$100(paramImageContainer));
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.NetworkImageView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */