package com.android.volley.toolbox;

import java.io.FilterInputStream;
import java.net.HttpURLConnection;

public class HurlStack$UrlConnectionInputStream
  extends FilterInputStream
{
  public final HttpURLConnection mConnection;
  
  public HurlStack$UrlConnectionInputStream(HttpURLConnection paramHttpURLConnection)
  {
    super(HurlStack.access$000(paramHttpURLConnection));
    mConnection = paramHttpURLConnection;
  }
  
  public void close()
  {
    super.close();
    mConnection.disconnect();
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.HurlStack.UrlConnectionInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */