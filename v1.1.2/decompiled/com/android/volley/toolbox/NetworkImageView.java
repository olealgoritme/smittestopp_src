package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;

public class NetworkImageView
  extends ImageView
{
  public int mDefaultImageId;
  public int mErrorImageId;
  public ImageLoader.ImageContainer mImageContainer;
  public ImageLoader mImageLoader;
  public String mUrl;
  
  public NetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setDefaultImageOrNull()
  {
    int i = mDefaultImageId;
    if (i != 0) {
      setImageResource(i);
    } else {
      setImageBitmap(null);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public void loadImageIfNecessary(final boolean paramBoolean)
  {
    int i = getWidth();
    int j = getHeight();
    Object localObject1 = getScaleType();
    Object localObject2 = getLayoutParams();
    int k = 1;
    int n;
    if (localObject2 != null)
    {
      if (getLayoutParamswidth == -2) {
        m = 1;
      } else {
        m = 0;
      }
      n = m;
      if (getLayoutParamsheight == -2)
      {
        int i1 = 1;
        n = m;
        m = i1;
        break label87;
      }
    }
    else
    {
      n = 0;
    }
    int m = 0;
    label87:
    if ((n == 0) || (m == 0)) {
      k = 0;
    }
    if ((i == 0) && (j == 0) && (k == 0)) {
      return;
    }
    if (TextUtils.isEmpty(mUrl))
    {
      localObject1 = mImageContainer;
      if (localObject1 != null)
      {
        ((ImageLoader.ImageContainer)localObject1).cancelRequest();
        mImageContainer = null;
      }
      setDefaultImageOrNull();
      return;
    }
    localObject2 = mImageContainer;
    if ((localObject2 != null) && (((ImageLoader.ImageContainer)localObject2).getRequestUrl() != null))
    {
      if (mImageContainer.getRequestUrl().equals(mUrl)) {
        return;
      }
      mImageContainer.cancelRequest();
      setDefaultImageOrNull();
    }
    k = i;
    if (n != 0) {
      k = 0;
    }
    if (m != 0) {
      m = 0;
    } else {
      m = j;
    }
    mImageContainer = mImageLoader.get(mUrl, new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        if (NetworkImageView.access$000(NetworkImageView.this) != 0)
        {
          paramAnonymousVolleyError = NetworkImageView.this;
          paramAnonymousVolleyError.setImageResource(NetworkImageView.access$000(paramAnonymousVolleyError));
        }
      }
      
      public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (paramBoolean))
        {
          post(new Runnable()
          {
            public void run()
            {
              onResponse(paramAnonymousImageContainer, false);
            }
          });
          return;
        }
        if (paramAnonymousImageContainer.getBitmap() != null)
        {
          setImageBitmap(paramAnonymousImageContainer.getBitmap());
        }
        else if (NetworkImageView.access$100(NetworkImageView.this) != 0)
        {
          paramAnonymousImageContainer = NetworkImageView.this;
          paramAnonymousImageContainer.setImageResource(NetworkImageView.access$100(paramAnonymousImageContainer));
        }
      }
    }, k, m, (ImageView.ScaleType)localObject1);
  }
  
  public void onDetachedFromWindow()
  {
    ImageLoader.ImageContainer localImageContainer = mImageContainer;
    if (localImageContainer != null)
    {
      localImageContainer.cancelRequest();
      setImageBitmap(null);
      mImageContainer = null;
    }
    super.onDetachedFromWindow();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    loadImageIfNecessary(true);
  }
  
  public void setDefaultImageResId(int paramInt)
  {
    mDefaultImageId = paramInt;
  }
  
  public void setErrorImageResId(int paramInt)
  {
    mErrorImageId = paramInt;
  }
  
  public void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    Threads.throwIfNotOnMainThread();
    mUrl = paramString;
    mImageLoader = paramImageLoader;
    loadImageIfNecessary(false);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.NetworkImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */