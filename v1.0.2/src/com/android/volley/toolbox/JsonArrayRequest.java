package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonArrayRequest
  extends JsonRequest<JSONArray>
{
  public JsonArrayRequest(int paramInt, String paramString, JSONArray paramJSONArray, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramJSONArray, paramListener, paramErrorListener);
  }
  
  public JsonArrayRequest(String paramString, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, null, paramListener, paramErrorListener);
  }
  
  public Response<JSONArray> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str = new java/lang/String;
      str.<init>(data, HttpHeaderParser.parseCharset(headers, "utf-8"));
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(str);
      paramNetworkResponse = Response.success(localJSONArray, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (JSONException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (UnsupportedEncodingException paramNetworkResponse) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.JsonArrayRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */