package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import java.util.HashMap;

public class ImageLoader
{
  public int mBatchResponseDelayMs = 100;
  public final HashMap<String, ImageLoader.BatchedImageRequest> mBatchedResponses = new HashMap();
  public final ImageLoader.ImageCache mCache;
  public final Handler mHandler = new Handler(Looper.getMainLooper());
  public final HashMap<String, ImageLoader.BatchedImageRequest> mInFlightRequests = new HashMap();
  public final RequestQueue mRequestQueue;
  public Runnable mRunnable;
  
  public ImageLoader(RequestQueue paramRequestQueue, ImageLoader.ImageCache paramImageCache)
  {
    mRequestQueue = paramRequestQueue;
    mCache = paramImageCache;
  }
  
  private void batchResponse(String paramString, ImageLoader.BatchedImageRequest paramBatchedImageRequest)
  {
    mBatchedResponses.put(paramString, paramBatchedImageRequest);
    if (mRunnable == null)
    {
      paramString = new ImageLoader.4(this);
      mRunnable = paramString;
      mHandler.postDelayed(paramString, mBatchResponseDelayMs);
    }
  }
  
  public static String getCacheKey(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 12);
    localStringBuilder.append("#W");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("#H");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("#S");
    localStringBuilder.append(paramScaleType.ordinal());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static ImageLoader.ImageListener getImageListener(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    return new ImageLoader.1(paramInt2, paramImageView, paramInt1);
  }
  
  public ImageLoader.ImageContainer get(String paramString, ImageLoader.ImageListener paramImageListener)
  {
    return get(paramString, paramImageListener, 0, 0);
  }
  
  public ImageLoader.ImageContainer get(String paramString, ImageLoader.ImageListener paramImageListener, int paramInt1, int paramInt2)
  {
    return get(paramString, paramImageListener, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public ImageLoader.ImageContainer get(String paramString, ImageLoader.ImageListener paramImageListener, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    Threads.throwIfNotOnMainThread();
    String str = getCacheKey(paramString, paramInt1, paramInt2, paramScaleType);
    Object localObject = mCache.getBitmap(str);
    if (localObject != null)
    {
      paramString = new ImageLoader.ImageContainer(this, (Bitmap)localObject, paramString, null, null);
      paramImageListener.onResponse(paramString, true);
      return paramString;
    }
    localObject = new ImageLoader.ImageContainer(this, null, paramString, str, paramImageListener);
    paramImageListener.onResponse((ImageLoader.ImageContainer)localObject, true);
    paramImageListener = (ImageLoader.BatchedImageRequest)mInFlightRequests.get(str);
    if (paramImageListener != null)
    {
      paramImageListener.addContainer((ImageLoader.ImageContainer)localObject);
      return (ImageLoader.ImageContainer)localObject;
    }
    paramString = makeImageRequest(paramString, paramInt1, paramInt2, paramScaleType, str);
    mRequestQueue.add(paramString);
    mInFlightRequests.put(str, new ImageLoader.BatchedImageRequest(paramString, (ImageLoader.ImageContainer)localObject));
    return (ImageLoader.ImageContainer)localObject;
  }
  
  public boolean isCached(String paramString, int paramInt1, int paramInt2)
  {
    return isCached(paramString, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public boolean isCached(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    Threads.throwIfNotOnMainThread();
    paramString = getCacheKey(paramString, paramInt1, paramInt2, paramScaleType);
    boolean bool;
    if (mCache.getBitmap(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Request<Bitmap> makeImageRequest(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, String paramString2)
  {
    return new ImageRequest(paramString1, new ImageLoader.2(this, paramString2), paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565, new ImageLoader.3(this, paramString2));
  }
  
  public void onGetImageError(String paramString, VolleyError paramVolleyError)
  {
    ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)mInFlightRequests.remove(paramString);
    if (localBatchedImageRequest != null)
    {
      localBatchedImageRequest.setError(paramVolleyError);
      batchResponse(paramString, localBatchedImageRequest);
    }
  }
  
  public void onGetImageSuccess(String paramString, Bitmap paramBitmap)
  {
    mCache.putBitmap(paramString, paramBitmap);
    ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)mInFlightRequests.remove(paramString);
    if (localBatchedImageRequest != null)
    {
      ImageLoader.BatchedImageRequest.access$002(localBatchedImageRequest, paramBitmap);
      batchResponse(paramString, localBatchedImageRequest);
    }
  }
  
  public void setBatchedResponseDelay(int paramInt)
  {
    mBatchResponseDelayMs = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.ImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */