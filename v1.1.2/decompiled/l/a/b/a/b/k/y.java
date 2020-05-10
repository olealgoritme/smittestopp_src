package l.a.b.a.b.k;

import java.util.HashMap;
import java.util.Map;
import l.a.b.a.b.f;

public enum y
{
  public static final Map<f, y> _map;
  public f _policy;
  
  static
  {
    CONNECTION_CLOSE = new y("CONNECTION_CLOSE", 2, "connection-close");
    Object localObject = new y("NEVER", 3, "never");
    NEVER = (y)localObject;
    $VALUES = new y[] { LINK_DETACH, SESSION_END, CONNECTION_CLOSE, localObject };
    localObject = new HashMap();
    _map = (Map)localObject;
    ((Map)localObject).put(LINK_DETACH.getPolicy(), LINK_DETACH);
    _map.put(SESSION_END.getPolicy(), SESSION_END);
    _map.put(CONNECTION_CLOSE.getPolicy(), CONNECTION_CLOSE);
    _map.put(NEVER.getPolicy(), NEVER);
  }
  
  public y(String paramString)
  {
    _policy = f.a(paramString);
  }
  
  public static y valueOf(f paramf)
  {
    Object localObject = (y)_map.get(paramf);
    if (localObject != null) {
      return (y)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown TerminusExpiryPolicy: ");
    ((StringBuilder)localObject).append(paramf);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public f getPolicy()
  {
    return _policy;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.k.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */