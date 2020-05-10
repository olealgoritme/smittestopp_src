package com.android.volley.toolbox;

import com.android.volley.Response.ErrorListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageLoader$4
  implements Runnable
{
  public ImageLoader$4(ImageLoader paramImageLoader) {}
  
  public void run()
  {
    Iterator localIterator1 = ImageLoader.access$200(this$0).values().iterator();
    while (localIterator1.hasNext())
    {
      ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)localIterator1.next();
      Iterator localIterator2 = ImageLoader.BatchedImageRequest.access$300(localBatchedImageRequest).iterator();
      while (localIterator2.hasNext())
      {
        ImageLoader.ImageContainer localImageContainer = (ImageLoader.ImageContainer)localIterator2.next();
        if (ImageLoader.ImageContainer.access$400(localImageContainer) != null) {
          if (localBatchedImageRequest.getError() == null)
          {
            ImageLoader.ImageContainer.access$502(localImageContainer, ImageLoader.BatchedImageRequest.access$000(localBatchedImageRequest));
            ImageLoader.ImageContainer.access$400(localImageContainer).onResponse(localImageContainer, false);
          }
          else
          {
            ImageLoader.ImageContainer.access$400(localImageContainer).onErrorResponse(localBatchedImageRequest.getError());
          }
        }
      }
    }
    ImageLoader.access$200(this$0).clear();
    ImageLoader.access$602(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.ImageLoader.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */