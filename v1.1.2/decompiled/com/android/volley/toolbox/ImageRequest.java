package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;

public class ImageRequest
  extends Request<Bitmap>
{
  public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0F;
  public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
  public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
  public static final Object sDecodeLock = new Object();
  public final Bitmap.Config mDecodeConfig;
  public Response.Listener<Bitmap> mListener;
  public final Object mLock = new Object();
  public final int mMaxHeight;
  public final int mMaxWidth;
  public final ImageView.ScaleType mScaleType;
  
  @Deprecated
  public ImageRequest(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener)
  {
    this(paramString, paramListener, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE, paramConfig, paramErrorListener);
  }
  
  public ImageRequest(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, paramErrorListener);
    setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0F));
    mListener = paramListener;
    mDecodeConfig = paramConfig;
    mMaxWidth = paramInt1;
    mMaxHeight = paramInt2;
    mScaleType = paramScaleType;
  }
  
  private Response<Bitmap> doParse(NetworkResponse paramNetworkResponse)
  {
    Object localObject1 = data;
    Object localObject2 = new BitmapFactory.Options();
    if ((mMaxWidth == 0) && (mMaxHeight == 0))
    {
      inPreferredConfig = mDecodeConfig;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
    }
    else
    {
      inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      int i = outWidth;
      int j = outHeight;
      int k = getResizedDimension(mMaxWidth, mMaxHeight, i, j, mScaleType);
      int m = getResizedDimension(mMaxHeight, mMaxWidth, j, i, mScaleType);
      inJustDecodeBounds = false;
      inSampleSize = findBestSampleSize(i, j, k, m);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      localObject2 = localObject1;
      if (localObject1 != null) {
        if (((Bitmap)localObject1).getWidth() <= k)
        {
          localObject2 = localObject1;
          if (((Bitmap)localObject1).getHeight() <= m) {}
        }
        else
        {
          localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, k, m, true);
          ((Bitmap)localObject1).recycle();
        }
      }
    }
    if (localObject2 == null) {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    return Response.success(localObject2, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }
  
  public static int findBestSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    float f2;
    for (float f1 = 1.0F;; f1 = f2)
    {
      f2 = 2.0F * f1;
      if (f2 > d) {
        break;
      }
    }
    return (int)f1;
  }
  
  public static int getResizedDimension(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return paramInt3;
    }
    if (paramScaleType == ImageView.ScaleType.FIT_XY)
    {
      if (paramInt1 == 0) {
        return paramInt3;
      }
      return paramInt1;
    }
    if (paramInt1 == 0)
    {
      d1 = paramInt2 / paramInt4;
      return (int)(paramInt3 * d1);
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    double d1 = paramInt4 / paramInt3;
    if (paramScaleType == ImageView.ScaleType.CENTER_CROP)
    {
      d2 = paramInt1;
      d3 = paramInt2;
      if (d2 * d1 < d3) {
        paramInt1 = (int)(d3 / d1);
      }
      return paramInt1;
    }
    double d2 = paramInt1;
    double d3 = paramInt2;
    if (d2 * d1 > d3) {
      paramInt1 = (int)(d3 / d1);
    }
    return paramInt1;
  }
  
  public void cancel()
  {
    super.cancel();
    synchronized (mLock)
    {
      mListener = null;
      return;
    }
  }
  
  public void deliverResponse(Bitmap paramBitmap)
  {
    synchronized (mLock)
    {
      Response.Listener localListener = mListener;
      if (localListener != null) {
        localListener.onResponse(paramBitmap);
      }
      return;
    }
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.LOW;
  }
  
  public Response<Bitmap> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      synchronized (sDecodeLock)
      {
        Response localResponse = doParse(paramNetworkResponse);
        return localResponse;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      VolleyLog.e("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(data.length), getUrl() });
      paramNetworkResponse = new com/android/volley/ParseError;
      paramNetworkResponse.<init>(localOutOfMemoryError);
      paramNetworkResponse = Response.error(paramNetworkResponse);
      return paramNetworkResponse;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.ImageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */