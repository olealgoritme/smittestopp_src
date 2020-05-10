package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.core.BaseResponse;
import java.net.HttpURLConnection;

public final class QueueResponse
  extends BaseResponse
{
  public static long getApproximateMessageCount(HttpURLConnection paramHttpURLConnection)
  {
    return Long.parseLong(paramHttpURLConnection.getHeaderField("x-ms-approximate-messages-count"));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */