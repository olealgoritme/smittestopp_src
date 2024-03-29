package com.microsoft.azure.proton.transport.proxy.impl;

import com.microsoft.azure.proton.transport.proxy.Proxy.ProxyState;
import com.microsoft.azure.proton.transport.proxy.ProxyAuthenticationType;
import com.microsoft.azure.proton.transport.proxy.ProxyChallengeProcessor;
import com.microsoft.azure.proton.transport.proxy.ProxyConfiguration;
import com.microsoft.azure.proton.transport.proxy.ProxyHandler;
import com.microsoft.azure.proton.transport.proxy.ProxyHandler.ProxyResponseResult;
import e.a.a.a.a;
import e.d.a.a.a.a.a.d;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import k.a.b.a.d.d0;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.b0;
import k.a.b.a.d.g0.f0;
import k.a.b.a.d.g0.l0;
import k.f.b;

public class ProxyImpl$ProxyTransportWrapper
  implements l0
{
  public final ByteBuffer head;
  public final b0 underlyingInput;
  public final f0 underlyingOutput;
  
  public ProxyImpl$ProxyTransportWrapper(ProxyImpl paramProxyImpl, b0 paramb0, f0 paramf0)
  {
    underlyingInput = paramb0;
    underlyingOutput = paramf0;
    head = ProxyImpl.access$000(paramProxyImpl).asReadOnlyBuffer();
  }
  
  private void closeTailProxyError(String paramString)
  {
    ProxyImpl.access$102(this$0, true);
    ProxyImpl.access$1000(this$0).a(new d0(paramString));
  }
  
  /* Error */
  private Set<ProxyAuthenticationType> getAuthenticationTypes(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 65
    //   3: invokevirtual 71	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   6: iconst_m1
    //   7: if_icmpne +7 -> 14
    //   10: invokestatic 77	java/util/Collections:emptySet	()Ljava/util/Set;
    //   13: areturn
    //   14: new 79	java/util/HashSet
    //   17: dup
    //   18: invokespecial 80	java/util/HashSet:<init>	()V
    //   21: astore_2
    //   22: new 82	java/util/Scanner
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 83	java/util/Scanner:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 87	java/util/Scanner:hasNextLine	()Z
    //   35: ifeq +81 -> 116
    //   38: aload_1
    //   39: invokevirtual 91	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   42: invokevirtual 94	java/lang/String:trim	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ldc 65
    //   49: invokevirtual 98	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifne +6 -> 58
    //   55: goto -24 -> 31
    //   58: aload_3
    //   59: bipush 19
    //   61: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 94	java/lang/String:trim	()Ljava/lang/String;
    //   67: getstatic 108	java/util/Locale:ROOT	Ljava/util/Locale;
    //   70: invokevirtual 112	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_3
    //   75: getstatic 118	com/microsoft/azure/proton/transport/proxy/impl/Constants:BASIC_LOWERCASE	Ljava/lang/String;
    //   78: invokevirtual 98	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   81: ifeq +14 -> 95
    //   84: aload_2
    //   85: getstatic 124	com/microsoft/azure/proton/transport/proxy/ProxyAuthenticationType:BASIC	Lcom/microsoft/azure/proton/transport/proxy/ProxyAuthenticationType;
    //   88: invokevirtual 128	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -61 -> 31
    //   95: aload_3
    //   96: getstatic 131	com/microsoft/azure/proton/transport/proxy/impl/Constants:DIGEST_LOWERCASE	Ljava/lang/String;
    //   99: invokevirtual 98	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq -71 -> 31
    //   105: aload_2
    //   106: getstatic 134	com/microsoft/azure/proton/transport/proxy/ProxyAuthenticationType:DIGEST	Lcom/microsoft/azure/proton/transport/proxy/ProxyAuthenticationType;
    //   109: invokevirtual 128	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: goto -82 -> 31
    //   116: aload_1
    //   117: invokevirtual 137	java/util/Scanner:close	()V
    //   120: aload_2
    //   121: areturn
    //   122: astore_2
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_1
    //   127: invokevirtual 137	java/util/Scanner:close	()V
    //   130: goto +9 -> 139
    //   133: astore_1
    //   134: aload_2
    //   135: aload_1
    //   136: invokevirtual 143	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   139: aload_3
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	ProxyTransportWrapper
    //   0	141	1	paramString	String
    //   21	100	2	localHashSet	java.util.HashSet
    //   122	13	2	localObject1	Object
    //   45	51	3	str	String
    //   125	15	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	55	122	finally
    //   58	92	122	finally
    //   95	113	122	finally
    //   123	125	125	finally
    //   126	130	133	finally
  }
  
  private ProxyChallengeProcessor getChallengeProcessor(String paramString1, String paramString2, ProxyAuthenticationType paramProxyAuthenticationType)
  {
    ProxyAuthenticator localProxyAuthenticator;
    if (ProxyImpl.access$500(this$0) != null) {
      localProxyAuthenticator = new ProxyAuthenticator(ProxyImpl.access$500(this$0));
    } else {
      localProxyAuthenticator = new ProxyAuthenticator();
    }
    int i = paramProxyAuthenticationType.ordinal();
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return new DigestProxyChallengeProcessorImpl(paramString1, paramString2, localProxyAuthenticator);
    }
    return new BasicProxyChallengeProcessorImpl(paramString1, localProxyAuthenticator);
  }
  
  private ProxyChallengeProcessor getChallengeProcessor(String paramString1, String paramString2, Set<ProxyAuthenticationType> paramSet)
  {
    if (paramSet.contains(ProxyAuthenticationType.DIGEST)) {
      return getChallengeProcessor(paramString1, paramString2, ProxyAuthenticationType.DIGEST);
    }
    if (paramSet.contains(ProxyAuthenticationType.BASIC)) {
      return getChallengeProcessor(paramString1, paramString2, ProxyAuthenticationType.BASIC);
    }
    return null;
  }
  
  public int capacity()
  {
    if (this$0.getIsHandshakeInProgress())
    {
      if (ProxyImpl.access$100(this$0)) {
        return -1;
      }
      return ProxyImpl.access$200(this$0).remaining();
    }
    return underlyingInput.capacity();
  }
  
  public void close_head()
  {
    ProxyImpl.access$902(this$0, true);
    underlyingOutput.close_head();
  }
  
  public void close_tail()
  {
    ProxyImpl.access$102(this$0, true);
    if (this$0.getIsHandshakeInProgress()) {
      ProxyImpl.access$902(this$0, true);
    }
    underlyingInput.close_tail();
  }
  
  public ByteBuffer head()
  {
    if (this$0.getIsHandshakeInProgress())
    {
      int i = ProxyImpl.access$300(this$0).ordinal();
      if ((i != 1) && (i != 3)) {
        return underlyingOutput.head();
      }
      return head;
    }
    return underlyingOutput.head();
  }
  
  public int pending()
  {
    if (!this$0.getIsHandshakeInProgress()) {
      return underlyingOutput.pending();
    }
    int i = ProxyImpl.access$300(this$0).ordinal();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return -1;
          }
        }
        else
        {
          if (ProxyImpl.access$000(this$0).position() == 0)
          {
            ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_CHALLENGE_RESPONDED);
            this$0.writeProxyRequest();
            head.limit(ProxyImpl.access$000(this$0).position());
            if (ProxyImpl.access$900(this$0))
            {
              ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_FAILED);
              return -1;
            }
            return ProxyImpl.access$000(this$0).position();
          }
          return ProxyImpl.access$000(this$0).position();
        }
      }
      if ((ProxyImpl.access$900(this$0)) && (ProxyImpl.access$000(this$0).position() == 0))
      {
        ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_FAILED);
        return -1;
      }
      return ProxyImpl.access$000(this$0).position();
    }
    if (ProxyImpl.access$000(this$0).position() == 0)
    {
      ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_CONNECTING);
      this$0.writeProxyRequest();
      head.limit(ProxyImpl.access$000(this$0).position());
      if (ProxyImpl.access$900(this$0))
      {
        ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_FAILED);
        return -1;
      }
      return ProxyImpl.access$000(this$0).position();
    }
    return ProxyImpl.access$000(this$0).position();
  }
  
  public void pop(int paramInt)
  {
    if (this$0.getIsHandshakeInProgress())
    {
      int i = ProxyImpl.access$300(this$0).ordinal();
      if ((i != 1) && (i != 3))
      {
        underlyingOutput.pop(paramInt);
      }
      else if (ProxyImpl.access$000(this$0).position() != 0)
      {
        ProxyImpl.access$000(this$0).flip();
        ProxyImpl.access$000(this$0).position(paramInt);
        ProxyImpl.access$000(this$0).compact();
        head.position(0);
        head.limit(ProxyImpl.access$000(this$0).position());
      }
      else
      {
        underlyingOutput.pop(paramInt);
      }
    }
    else
    {
      underlyingOutput.pop(paramInt);
    }
  }
  
  public int position()
  {
    if (this$0.getIsHandshakeInProgress())
    {
      if (ProxyImpl.access$100(this$0)) {
        return -1;
      }
      return ProxyImpl.access$200(this$0).position();
    }
    return underlyingInput.position();
  }
  
  public void process()
  {
    if (!this$0.getIsHandshakeInProgress())
    {
      underlyingInput.process();
      return;
    }
    int i = ProxyImpl.access$300(this$0).ordinal();
    Object localObject1;
    Object localObject2;
    if (i != 1)
    {
      if (i != 3)
      {
        underlyingInput.process();
      }
      else
      {
        ProxyImpl.access$200(this$0).flip();
        localObject1 = ProxyImpl.access$400(this$0).validateProxyResponse(ProxyImpl.access$200(this$0));
        ProxyImpl.access$200(this$0).compact();
        if (((ProxyHandler.ProxyResponseResult)localObject1).getIsSuccess().booleanValue())
        {
          ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_CONNECTED);
        }
        else
        {
          localObject2 = a.a("Proxy connect request failed with error: ");
          ((StringBuilder)localObject2).append(((ProxyHandler.ProxyResponseResult)localObject1).getError());
          closeTailProxyError(((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      ProxyImpl.access$200(this$0).flip();
      localObject2 = ProxyImpl.access$400(this$0).validateProxyResponse(ProxyImpl.access$200(this$0));
      ProxyImpl.access$200(this$0).compact();
      ProxyImpl.access$200(this$0).clear();
      if (((ProxyHandler.ProxyResponseResult)localObject2).getIsSuccess().booleanValue())
      {
        if ((ProxyImpl.access$500(this$0) != null) && (ProxyImpl.access$500(this$0).authentication() != ProxyAuthenticationType.NONE))
        {
          if (ProxyImpl.access$600().f()) {
            ProxyImpl.access$600().a("ProxyConfiguration mismatch. User configured: '{}', but authentication is not required", ProxyImpl.access$500(this$0).authentication());
          }
          closeTailProxyError("User configuration error. Using non-matching proxy authentication.");
        }
        else
        {
          ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_CONNECTED);
        }
      }
      else
      {
        localObject1 = ((ProxyHandler.ProxyResponseResult)localObject2).getError();
        localObject2 = getAuthenticationTypes((String)localObject1);
        if ((ProxyImpl.access$500(this$0) != null) && (!((Set)localObject2).contains(ProxyImpl.access$500(this$0).authentication())))
        {
          if (ProxyImpl.access$600().f()) {
            ProxyImpl.access$600().d("Proxy authentication required. User configured: '{}', but supported proxy authentication methods are: {}", ProxyImpl.access$500(this$0).authentication(), ((Set)localObject2).stream().map(d.a).collect(Collectors.joining(",")));
          }
          closeTailProxyError(a.b("User configuration error. Using non-matching proxy authentication.Proxy connect request failed with error: ", (String)localObject1));
        }
        else
        {
          if (ProxyImpl.access$500(this$0) != null) {
            localObject2 = getChallengeProcessor(ProxyImpl.access$700(this$0), (String)localObject1, ProxyImpl.access$500(this$0).authentication());
          } else {
            localObject2 = getChallengeProcessor(ProxyImpl.access$700(this$0), (String)localObject1, (Set)localObject2);
          }
          if (localObject2 != null)
          {
            ProxyImpl.access$302(this$0, Proxy.ProxyState.PN_PROXY_CHALLENGE);
            ProxyImpl.access$802(this$0, ((ProxyChallengeProcessor)localObject2).getHeader());
          }
          else
          {
            closeTailProxyError(a.b("Proxy connect request failed with error: ", (String)localObject1));
          }
        }
      }
    }
  }
  
  public ByteBuffer tail()
  {
    if (this$0.getIsHandshakeInProgress()) {
      return ProxyImpl.access$200(this$0);
    }
    return underlyingInput.tail();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.ProxyImpl.ProxyTransportWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */