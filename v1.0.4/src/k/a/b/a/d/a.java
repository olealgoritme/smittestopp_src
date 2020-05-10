package k.a.b.a.d;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import k.a.b.a.d.g0.g;
import k.a.b.a.d.g0.r;

public class a
  implements d
{
  public LinkedHashSet<l> children = new LinkedHashSet();
  
  public static l getHandler(j paramj)
  {
    return (l)l.class.cast(qa.get(l.class));
  }
  
  public static l getHandler(u paramu)
  {
    return (l)l.class.cast(a.get(l.class));
  }
  
  public static void setHandler(j paramj, l paraml)
  {
    qa.put(l.class, paraml);
  }
  
  public static void setHandler(u paramu, l paraml)
  {
    a.put(l.class, paraml);
  }
  
  public void add(l paraml)
  {
    children.add(paraml);
  }
  
  public Iterator<l> children()
  {
    return children.iterator();
  }
  
  public void handle(h paramh)
  {
    paramh = (g)paramh;
    switch (paramh.w().ordinal())
    {
    default: 
      break;
    case 40: 
      onUnhandled(paramh);
      break;
    case 3: 
      onTimerTask(paramh);
      break;
    case 36: 
      onSelectableWritable(paramh);
      break;
    case 34: 
      onSelectableWritable(paramh);
      break;
    case 35: 
      onSelectableReadable(paramh);
      break;
    case 33: 
      onSelectableInit(paramh);
      break;
    case 39: 
      onSelectableFinal(paramh);
      break;
    case 37: 
      onSelectableExpired(paramh);
      break;
    case 38: 
      onSelectableError(paramh);
      break;
    case 0: 
      onReactorInit(paramh);
      break;
    case 1: 
      onReactorQuiesced(paramh);
      break;
    case 2: 
      onReactorFinal(paramh);
      break;
    case 32: 
      onTransportClosed(paramh);
      break;
    case 31: 
      onTransportTailClosed(paramh);
      break;
    case 30: 
      onTransportHeadClosed(paramh);
      break;
    case 29: 
      onTransportError(paramh);
      break;
    case 28: 
      onTransport(paramh);
      break;
    case 27: 
      onDelivery(paramh);
      break;
    case 26: 
      onLinkFinal(paramh);
      break;
    case 25: 
      onLinkFlow(paramh);
      break;
    case 24: 
      onLinkRemoteClose(paramh);
      break;
    case 23: 
      onLinkLocalClose(paramh);
      break;
    case 22: 
      onLinkRemoteDetach(paramh);
      break;
    case 21: 
      onLinkLocalDetach(paramh);
      break;
    case 20: 
      onLinkRemoteOpen(paramh);
      break;
    case 19: 
      onLinkLocalOpen(paramh);
      break;
    case 18: 
      onLinkInit(paramh);
      break;
    case 17: 
      onSessionFinal(paramh);
      break;
    case 16: 
      onSessionRemoteClose(paramh);
      break;
    case 15: 
      onSessionLocalClose(paramh);
      break;
    case 14: 
      onSessionRemoteOpen(paramh);
      break;
    case 13: 
      onSessionLocalOpen(paramh);
      break;
    case 12: 
      onSessionInit(paramh);
      break;
    case 11: 
      onConnectionFinal(paramh);
      break;
    case 6: 
      onConnectionUnbound(paramh);
      break;
    case 5: 
      onConnectionBound(paramh);
      break;
    case 10: 
      onConnectionRemoteClose(paramh);
      break;
    case 9: 
      onConnectionLocalClose(paramh);
      break;
    case 8: 
      onConnectionRemoteOpen(paramh);
      break;
    case 7: 
      onConnectionLocalOpen(paramh);
      break;
    case 4: 
      onConnectionInit(paramh);
    }
  }
  
  public void onConnectionBound(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionFinal(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionInit(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionLocalClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionLocalOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionRemoteClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionRemoteOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onConnectionUnbound(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onDelivery(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkFinal(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkFlow(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkInit(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkLocalClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkLocalDetach(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkLocalOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkRemoteDetach(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onReactorFinal(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onReactorInit(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onReactorQuiesced(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableError(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableExpired(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableFinal(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableInit(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableReadable(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableUpdated(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSelectableWritable(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionFinal(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionInit(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionLocalClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionLocalOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTimerTask(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTransport(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTransportClosed(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTransportError(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTransportHeadClosed(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onTransportTailClosed(h paramh)
  {
    onUnhandled(paramh);
  }
  
  public void onUnhandled(h paramh) {}
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */