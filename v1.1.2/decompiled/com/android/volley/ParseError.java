package com.android.volley;

public class ParseError
  extends VolleyError
{
  public ParseError() {}
  
  public ParseError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public ParseError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.android.volley.ParseError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */