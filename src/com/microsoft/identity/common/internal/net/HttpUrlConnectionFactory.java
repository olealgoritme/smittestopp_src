package com.microsoft.identity.common.internal.net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

public final class HttpUrlConnectionFactory
{
  public static Queue<HttpURLConnection> sMockedConnectionQueue = new LinkedList();
  
  public static void addMockedConnection(HttpURLConnection paramHttpURLConnection)
  {
    sMockedConnectionQueue.add(paramHttpURLConnection);
  }
  
  public static void clearMockedConnectionQueue()
  {
    sMockedConnectionQueue.clear();
  }
  
  public static HttpURLConnection createHttpURLConnection(URL paramURL)
  {
    if (!sMockedConnectionQueue.isEmpty()) {
      return (HttpURLConnection)sMockedConnectionQueue.poll();
    }
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public static int getMockedConnectionCountInQueue()
  {
    return sMockedConnectionQueue.size();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.net.HttpUrlConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */