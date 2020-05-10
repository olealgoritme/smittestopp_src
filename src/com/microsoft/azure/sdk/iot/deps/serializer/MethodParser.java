package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.o;
import e.c.c.p;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MethodParser
{
  public static final String CONNECT_TIMEOUT_IN_SECONDS_TAG = "connectTimeoutInSeconds";
  public static final String METHOD_NAME_TAG = "methodName";
  public static final String PAYLOAD_TAG = "payload";
  public static final String RESPONSE_TIMEOUT_IN_SECONDS_TAG = "responseTimeoutInSeconds";
  public static final String STATUS_TAG = "status";
  @a(deserialize=false, serialize=true)
  @c("connectTimeoutInSeconds")
  public Long connectTimeout = null;
  @a(deserialize=false, serialize=true)
  @c("methodName")
  public String name = null;
  @a(deserialize=false, serialize=false)
  public MethodParser.Operation operation = MethodParser.Operation.none;
  @c("payload")
  public Object payload = null;
  @a(deserialize=false, serialize=true)
  @c("responseTimeoutInSeconds")
  public Long responseTimeout = null;
  @a(deserialize=true, serialize=false)
  @c("status")
  public Integer status = null;
  
  public MethodParser() {}
  
  public MethodParser(Object paramObject)
  {
    this();
    payload = paramObject;
    operation = MethodParser.Operation.payload;
  }
  
  public MethodParser(String paramString, Long paramLong1, Long paramLong2, Object paramObject)
  {
    this();
    validateKey(paramString);
    if (paramLong1 != null) {
      validateTimeout(paramLong1);
    }
    if (paramLong2 != null) {
      validateTimeout(paramLong2);
    }
    payload = paramObject;
    operation = MethodParser.Operation.invoke;
  }
  
  private j jsonizePayload(Object paramObject)
  {
    if (paramObject == null) {
      return new l();
    }
    if ((paramObject instanceof j)) {
      return (j)paramObject;
    }
    Object localObject2;
    if ((paramObject instanceof Map))
    {
      localObject1 = new m();
      localObject2 = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramObject = (Map.Entry)((Iterator)localObject2).next();
        ((m)localObject1).a((String)((Map.Entry)paramObject).getKey(), jsonizePayload(((Map.Entry)paramObject).getValue()));
      }
      return (j)localObject1;
    }
    Object localObject1 = new o();
    try
    {
      String str = paramObject.toString();
      localObject2 = ((o)localObject1).a(str);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof l)) {
          localObject1 = new p(str);
        }
        return (j)localObject1;
      }
      throw null;
    }
    catch (s locals) {}
    return new Gson().b(paramObject);
  }
  
  private void validateKey(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (paramString.length() <= 128)
      {
        if ((!paramString.contains("$")) && (!paramString.contains(".")) && (!paramString.contains(" "))) {
          return;
        }
        throw new IllegalArgumentException("Key cannot contain '$', '.', or space");
      }
      throw new IllegalArgumentException("Key cannot be longer than 128 characters");
    }
    throw new IllegalArgumentException("Key cannot be null or empty");
  }
  
  private void validateTimeout(Long paramLong)
  {
    if (paramLong.longValue() >= 0L) {
      return;
    }
    throw new IllegalArgumentException("Negative timeout");
  }
  
  public void fromJson(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.isEmpty())
      {
        Object localObject = new e/c/c/o;
        ((o)localObject).<init>();
        try
        {
          paramString = ((o)localObject).a(paramString);
          if ((!(paramString instanceof p)) && (!(paramString instanceof g)))
          {
            if ((paramString instanceof m))
            {
              paramString = (m)paramString;
              j localj = paramString.a("status");
              localObject = paramString.a("methodName");
              if (localObject == null)
              {
                if (localj == null)
                {
                  operation = MethodParser.Operation.payload;
                  payload = ParserUtility.getJsonObjectValue(paramString);
                }
                else
                {
                  operation = MethodParser.Operation.response;
                  if ((localj instanceof p)) {
                    status = Integer.valueOf(localj.a());
                  }
                  paramString = paramString.a("payload");
                  if (paramString != null) {
                    payload = ParserUtility.resolveJsonElement(paramString);
                  }
                }
              }
              else if (localj == null)
              {
                operation = MethodParser.Operation.invoke;
                name = ((j)localObject).f();
                localObject = paramString.a("responseTimeoutInSeconds");
                if (localObject != null) {
                  responseTimeout = Long.valueOf(((j)localObject).e());
                }
                localObject = paramString.a("connectTimeoutInSeconds");
                if (localObject != null) {
                  connectTimeout = Long.valueOf(((j)localObject).e());
                }
                paramString = paramString.a("payload");
                if (paramString != null) {
                  payload = ParserUtility.resolveJsonElement(paramString);
                }
              }
              else
              {
                paramString = new java/lang/IllegalArgumentException;
                paramString.<init>("Invoke method name and Status reported in the same json");
                throw paramString;
              }
            }
            else
            {
              paramString = new java/lang/IllegalArgumentException;
              paramString.<init>("Invalid json.");
              throw paramString;
            }
          }
          else
          {
            operation = MethodParser.Operation.payload;
            payload = ParserUtility.resolveJsonElement(paramString);
          }
          return;
        }
        catch (Exception localException)
        {
          paramString = new java/lang/IllegalArgumentException;
          paramString.<init>("Malformed json.", localException);
          throw paramString;
        }
      }
      paramString = new java/lang/IllegalArgumentException;
      paramString.<init>("Invalid json.");
      throw paramString;
    }
    finally {}
  }
  
  public Object getPayload()
  {
    Object localObject = payload;
    if ((localObject instanceof j))
    {
      j localj = (j)localObject;
      if (localj != null)
      {
        if (((localj instanceof p)) && ((a instanceof String))) {
          return ((p)localObject).f();
        }
      }
      else {
        throw null;
      }
    }
    return payload;
  }
  
  public Integer getStatus()
  {
    if (operation == MethodParser.Operation.response) {
      return status;
    }
    throw new IllegalArgumentException("No response to report status");
  }
  
  public String toJson()
  {
    return toJsonElement().toString();
  }
  
  public j toJsonElement()
  {
    Object localObject = operation;
    if (localObject == MethodParser.Operation.invoke)
    {
      localObject = name;
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        localObject = new m();
        ((m)localObject).a("methodName", ((m)localObject).a(name));
        Long localLong = responseTimeout;
        if (localLong != null) {
          ((m)localObject).a("responseTimeoutInSeconds", ((m)localObject).a(localLong));
        }
        localLong = connectTimeout;
        if (localLong != null) {
          ((m)localObject).a("connectTimeoutInSeconds", ((m)localObject).a(localLong));
        }
        ((m)localObject).a("payload", jsonizePayload(payload));
        return (j)localObject;
      }
      throw new IllegalArgumentException("cannot invoke method with null name");
    }
    if (localObject == MethodParser.Operation.response)
    {
      localObject = new m();
      ((m)localObject).a("status", ((m)localObject).a(status));
      ((m)localObject).a("payload", jsonizePayload(payload));
      return (j)localObject;
    }
    if (localObject == MethodParser.Operation.payload) {
      return jsonizePayload(payload);
    }
    throw new IllegalArgumentException("There is no content to parser");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.MethodParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */