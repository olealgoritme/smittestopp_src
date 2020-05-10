package k.b.a.y;

import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties;
import m.a.a.b;

public final class a
{
  public static final void a(String paramString)
  {
    EventProperties localEventProperties = new EventProperties();
    localEventProperties.set("test", paramString);
    Analytics.trackEvent("Emulator detection failed", localEventProperties);
    m.a.a.d.a(paramString, new Object[0]);
  }
  
  public static final void b(String paramString)
  {
    EventProperties localEventProperties = new EventProperties();
    localEventProperties.set("test", paramString);
    Analytics.trackEvent("Root detection failed", localEventProperties);
    m.a.a.d.a(paramString, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     k.b.a.y.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */