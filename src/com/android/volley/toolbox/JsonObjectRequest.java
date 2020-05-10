package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest
  extends JsonRequest<JSONObject>
{
  public JsonObjectRequest(int paramInt, String paramString, JSONObject paramJSONObject, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramJSONObject, paramListener, paramErrorListener);
  }
  
  public JsonObjectRequest(String paramString, JSONObject paramJSONObject, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(i, paramString, paramJSONObject, paramListener, paramErrorListener);
  }
  
  public Response<JSONObject> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str = new java/lang/String;
      str.<init>(data, HttpHeaderParser.parseCharset(headers, "utf-8"));
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(str);
      paramNetworkResponse = Response.success(localJSONObject, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
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
 * Qualified Name:     base.com.android.volley.toolbox.JsonObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */