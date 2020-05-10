package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import k.a.b.a.d.e;
import k.a.b.a.d.n;
import k.a.b.a.d.t;
import k.a.b.a.d.x;
import k.a.b.a.d.y;

public class AmqpDeviceOperations
{
  public String amqpLinkAddress;
  public Map<k.a.b.a.b.f, Object> amqpProperties = new HashMap();
  public t receiverLink = null;
  public String receiverLinkTag = "provision_receiver_link";
  public x senderLink = null;
  public String senderLinkTag = "provision_sender_link";
  
  public void addAmqpLinkProperty(String paramString1, String paramString2)
  {
    amqpProperties.put(k.a.b.a.b.f.a(paramString1), paramString2);
  }
  
  public void clearAmqpLinkProperty()
  {
    amqpProperties.clear();
  }
  
  public void closeLinks()
  {
    try
    {
      if (receiverLink != null) {
        receiverLink.close();
      }
      if (senderLink != null) {
        senderLink.close();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void initLink(n paramn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +136 -> 139
    //   6: aload_1
    //   7: invokeinterface 71 1 0
    //   12: aload_0
    //   13: getfield 28	com/microsoft/azure/sdk/iot/deps/transport/amqp/AmqpDeviceOperations:senderLinkTag	Ljava/lang/String;
    //   16: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +35 -> 54
    //   22: new 79	k/a/b/a/b/k/v
    //   25: astore_2
    //   26: aload_2
    //   27: invokespecial 80	k/a/b/a/b/k/v:<init>	()V
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 82	com/microsoft/azure/sdk/iot/deps/transport/amqp/AmqpDeviceOperations:amqpLinkAddress	Ljava/lang/String;
    //   35: putfield 86	k/a/b/a/b/k/w:a	Ljava/lang/String;
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 89 2 0
    //   45: aload_1
    //   46: getstatic 95	k/a/b/a/b/n/p:UNSETTLED	Lk/a/b/a/b/n/p;
    //   49: invokeinterface 98 2 0
    //   54: aload_1
    //   55: invokeinterface 71 1 0
    //   60: aload_0
    //   61: getfield 32	com/microsoft/azure/sdk/iot/deps/transport/amqp/AmqpDeviceOperations:receiverLinkTag	Ljava/lang/String;
    //   64: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +26 -> 93
    //   70: new 100	k/a/b/a/b/k/u
    //   73: astore_2
    //   74: aload_2
    //   75: invokespecial 101	k/a/b/a/b/k/u:<init>	()V
    //   78: aload_2
    //   79: aload_0
    //   80: getfield 82	com/microsoft/azure/sdk/iot/deps/transport/amqp/AmqpDeviceOperations:amqpLinkAddress	Ljava/lang/String;
    //   83: putfield 86	k/a/b/a/b/k/w:a	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_2
    //   88: invokeinterface 104 2 0
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: astore_1
    //   97: goto +54 -> 151
    //   100: astore_1
    //   101: new 106	java/io/IOException
    //   104: astore_3
    //   105: new 108	java/lang/StringBuilder
    //   108: astore_2
    //   109: aload_2
    //   110: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   113: aload_2
    //   114: ldc 111
    //   116: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: aload_1
    //   122: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_3
    //   130: aload_2
    //   131: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokespecial 124	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   137: aload_3
    //   138: athrow
    //   139: new 126	java/lang/IllegalArgumentException
    //   142: astore_1
    //   143: aload_1
    //   144: ldc -128
    //   146: invokespecial 129	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	AmqpDeviceOperations
    //   0	155	1	paramn	n
    //   25	106	2	localObject	Object
    //   104	34	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   6	54	96	finally
    //   54	93	96	finally
    //   101	139	96	finally
    //   139	151	96	finally
    //   6	54	100	java/lang/Exception
    //   54	93	100	java/lang/Exception
  }
  
  public boolean isReceiverLinkTag(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = receiverLinkTag.equals(paramString);
        if (bool) {
          return true;
        }
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    return false;
  }
  
  public void openLinks(y paramy)
  {
    if (paramy != null) {
      try
      {
        t localt = paramy.b(receiverLinkTag);
        receiverLink = localt;
        localt.a(amqpProperties);
        receiverLink.open();
        paramy = paramy.a(senderLinkTag);
        senderLink = paramy;
        paramy.a(amqpProperties);
        senderLink.open();
        return;
      }
      catch (Exception paramy)
      {
        throw new IOException("Proton exception", paramy);
      }
    }
    throw new IllegalArgumentException("The session cannot be null.");
  }
  
  public AmqpMessage receiverMessageFromLink(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramString != null) {
      if (paramString.isEmpty())
      {
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = receiverLink;
        if (localObject2 == null)
        {
          localObject2 = localObject1;
        }
        else
        {
          e locale = ((n)localObject2).k();
          localObject2 = localObject1;
          if (paramString.equals(receiverLinkTag))
          {
            localObject2 = localObject1;
            if (locale != null)
            {
              localObject2 = localObject1;
              if (locale.t())
              {
                localObject2 = localObject1;
                if (!locale.O())
                {
                  int i = locale.pending();
                  paramString = new byte[i];
                  i = receiverLink.b(paramString, 0, i);
                  receiverLink.d();
                  localObject2 = new AmqpMessage();
                  ((AmqpMessage)localObject2).decode(paramString, 0, i);
                }
              }
            }
          }
        }
      }
    }
    return (AmqpMessage)localObject2;
  }
  
  public void sendMessage(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    senderLink.a(paramArrayOfByte1);
    senderLink.a(paramArrayOfByte2, paramInt2, paramInt1);
    senderLink.d();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpDeviceOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */