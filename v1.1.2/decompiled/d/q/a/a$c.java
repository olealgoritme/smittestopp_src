package d.q.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public final class a$c
{
  public final IntentFilter a;
  public final BroadcastReceiver b;
  public boolean c;
  public boolean d;
  
  public a$c(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    a = paramIntentFilter;
    b = paramBroadcastReceiver;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(b);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(a);
    if (d) {
      localStringBuilder.append(" DEAD");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     d.q.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */