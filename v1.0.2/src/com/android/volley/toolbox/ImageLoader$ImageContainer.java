package com.android.volley.toolbox;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;

public class ImageLoader$ImageContainer
{
  public Bitmap mBitmap;
  public final String mCacheKey;
  public final ImageLoader.ImageListener mListener;
  public final String mRequestUrl;
  
  public ImageLoader$ImageContainer(ImageLoader paramImageLoader, Bitmap paramBitmap, String paramString1, String paramString2, ImageLoader.ImageListener paramImageListener)
  {
    mBitmap = paramBitmap;
    mRequestUrl = paramString1;
    mCacheKey = paramString2;
    mListener = paramImageListener;
  }
  
  public void cancelRequest()
  {
    
    if (mListener == null) {
      return;
    }
    ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)ImageLoader.access$100(this$0).get(mCacheKey);
    if (localBatchedImageRequest != null)
    {
      if (localBatchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
        ImageLoader.access$100(this$0).remove(mCacheKey);
      }
    }
    else
    {
      localBatchedImageRequest = (ImageLoader.BatchedImageRequest)ImageLoader.access$200(this$0).get(mCacheKey);
      if (localBatchedImageRequest != null)
      {
        localBatchedImageRequest.removeContainerAndCancelIfNecessary(this);
        if (ImageLoader.BatchedImageRequest.access$300(localBatchedImageRequest).size() == 0) {
          ImageLoader.access$200(this$0).remove(mCacheKey);
        }
      }
    }
  }
  
  public Bitmap getBitmap()
  {
    return mBitmap;
  }
  
  public String getRequestUrl()
  {
    return mRequestUrl;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.ImageLoader.ImageContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */