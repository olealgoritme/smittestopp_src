package com.microsoft.azure.sdk.iot.device.hsm;

import com.microsoft.azure.sdk.iot.device.transport.https.HttpsRequest;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsResponse;
import e.a.a.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpsRequestResponseSerializer
{
  public static final String CR = "\r";
  public static final String HeaderSeparator = ":";
  public static final String LF = "\n";
  public static final long MAXIMUM_HEADER_COUNT = 500L;
  public static final String Protocol = "HTTP";
  public static final String ProtocolVersionSeparator = "/";
  public static final String SP = " ";
  public static final String VERSION = "1.1";
  
  public static HttpsResponse deserializeResponse(BufferedReader paramBufferedReader)
  {
    if (paramBufferedReader != null)
    {
      Object localObject1 = paramBufferedReader.readLine();
      if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
      {
        localObject1 = ((String)localObject1).split(" ");
        if (localObject1.length == 3)
        {
          Object localObject2 = localObject1[0].split("/");
          if (localObject2.length == 2)
          {
            localObject2 = localObject2[1];
            try
            {
              int i = Integer.valueOf(localObject1[1]).intValue();
              localObject2 = readHeaderFields(paramBufferedReader);
              byte[] arrayOfByte = readBody(paramBufferedReader);
              localObject1 = localObject1[2].getBytes();
              paramBufferedReader.close();
              return new HttpsResponse(i, arrayOfByte, (Map)localObject2, (byte[])localObject1);
            }
            catch (NumberFormatException paramBufferedReader)
            {
              throw new IOException(a.a(a.a("StatusCode is not valid "), localObject1[1], "."));
            }
          }
          throw new IOException(a.a(a.a("Version is not valid "), localObject1[0], "."));
        }
        throw new IOException("Status line is not valid.");
      }
      throw new IOException("Response is empty.");
    }
    throw new IllegalArgumentException("buffered reader cannot be null");
  }
  
  public static String preProcessRequestPath(String paramString)
  {
    return paramString.replace("[", "").replace("]", "");
  }
  
  public static byte[] readBody(BufferedReader paramBufferedReader)
  {
    String str1 = paramBufferedReader.readLine();
    String str2 = "";
    while ((str1 != null) && (!str1.isEmpty()))
    {
      str2 = a.b(str2, str1);
      str1 = paramBufferedReader.readLine();
    }
    return str2.getBytes();
  }
  
  public static Map<String, List<String>> readHeaderFields(BufferedReader paramBufferedReader)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramBufferedReader.readLine();
    while ((localObject2 != null) && (!((String)localObject2).isEmpty()))
    {
      ((ArrayList)localObject1).add(localObject2);
      localObject2 = paramBufferedReader.readLine();
      if (((ArrayList)localObject1).size() > 500L) {
        throw new IOException("HSM provided too many http headers");
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
      {
        int i = ((String)localObject1).indexOf(":");
        if (i > 0)
        {
          paramBufferedReader = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject1);
          localHashMap.put(paramBufferedReader, localArrayList);
        }
        else
        {
          throw new IOException(a.a("Header is invalid ", (String)localObject1, "."));
        }
      }
    }
    return localHashMap;
  }
  
  public static byte[] serializeRequest(HttpsRequest paramHttpsRequest, String paramString1, String paramString2, String paramString3)
  {
    if (paramHttpsRequest != null)
    {
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        if ((paramString3 != null) && (!paramString3.isEmpty()))
        {
          paramHttpsRequest.setHeaderField("Connection", "close");
          Object localObject = preProcessRequestPath(paramString1);
          paramString1 = new StringBuilder();
          paramString1.append(paramHttpsRequest.getHttpMethod());
          paramString1.append(" ");
          paramString1.append((String)localObject);
          if ((paramString2 != null) && (!paramString2.isEmpty()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("?");
            ((StringBuilder)localObject).append(paramString2);
            paramString1.append(((StringBuilder)localObject).toString());
          }
          paramString1.append(" ");
          paramString1.append("HTTP/");
          paramString1.append("1.1");
          paramString1.append("\r");
          paramString1.append("\n");
          paramString2 = new StringBuilder();
          paramString2.append("Host: ");
          paramString2.append(paramString3);
          paramString2.append("\r\n");
          paramString1.append(paramString2.toString());
          if ((paramHttpsRequest.getRequestHeaders() != null) && (!paramHttpsRequest.getRequestHeaders().isEmpty())) {
            paramString1.append(paramHttpsRequest.getRequestHeaders());
          }
          if ((paramHttpsRequest.getBody() != null) && (paramHttpsRequest.getBody().length != 0))
          {
            paramString2 = a.a("Content-Length: ");
            paramString2.append(paramHttpsRequest.getBody().length);
            paramString2.append("\r\n");
            paramString1.append(paramString2.toString());
          }
          return a.a(paramString1, "\r", "\n").getBytes(StandardCharsets.US_ASCII);
        }
        throw new IllegalArgumentException("host cannot be null or empty");
      }
      throw new IllegalArgumentException("path cannot be null or empty");
    }
    throw new IllegalArgumentException("The httpsRequest cannot be null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.hsm.HttpsRequestResponseSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */