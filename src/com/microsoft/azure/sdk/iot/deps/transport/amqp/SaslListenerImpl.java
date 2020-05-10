package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import java.nio.ByteBuffer;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.d.c0;
import k.a.b.a.d.g0.v.b;
import k.a.b.a.d.w;

public class SaslListenerImpl
  implements w
{
  public static final String PLAIN = "PLAIN";
  public SaslHandler saslHandler;
  public Exception savedException;
  
  public SaslListenerImpl(SaslHandler paramSaslHandler)
  {
    saslHandler = paramSaslHandler;
  }
  
  public Exception getSavedException()
  {
    return savedException;
  }
  
  public void onSaslChallenge(k.a.b.a.d.v paramv, c0 paramc0)
  {
    if (paramv == null)
    {
      savedException = new IllegalArgumentException("Sasl cannot be null");
    }
    else
    {
      paramc0 = (k.a.b.a.d.g0.v)paramv;
      Object localObject = i;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((ByteBuffer)localObject).remaining();
      }
      localObject = new byte[i];
      ByteBuffer localByteBuffer = i;
      if (localByteBuffer != null)
      {
        localByteBuffer.get((byte[])localObject, 0, Math.min(localByteBuffer.remaining(), i));
        if (!i.hasRemaining()) {
          i = null;
        }
      }
      try
      {
        paramc0 = saslHandler.handleChallenge((byte[])localObject);
        i = paramc0.length;
        localObject = (k.a.b.a.d.g0.v)paramv;
        paramv = new byte[i];
        System.arraycopy(paramc0, 0, paramv, 0, i);
        paramc0 = new k/a/b/a/b/a;
        paramc0.<init>(paramv);
        k = paramc0;
      }
      catch (Exception paramv)
      {
        savedException = paramv;
      }
    }
  }
  
  public void onSaslInit(k.a.b.a.d.v paramv, c0 paramc0) {}
  
  public void onSaslMechanisms(k.a.b.a.d.v paramv, c0 paramc0)
  {
    if (paramv == null)
    {
      savedException = new IllegalArgumentException("Sasl cannot be null");
    }
    else
    {
      k.a.b.a.d.g0.v localv = (k.a.b.a.d.g0.v)paramv;
      paramc0 = v;
      Object localObject;
      int i;
      if (paramc0 == v.b.SERVER)
      {
        paramc0 = u;
        if (paramc0 == null) {
          paramc0 = new String[0];
        } else {
          paramc0 = new String[] { x };
        }
      }
      else
      {
        if (paramc0 != v.b.CLIENT) {
          break label263;
        }
        paramc0 = t;
        if (paramc0 == null)
        {
          paramc0 = new String[0];
        }
        else
        {
          localObject = new String[paramc0.length];
          for (i = 0;; i++)
          {
            f[] arrayOff = t;
            paramc0 = (c0)localObject;
            if (i >= arrayOff.length) {
              break;
            }
            localObject[i] = x;
          }
        }
      }
      try
      {
        paramc0 = saslHandler.chooseSaslMechanism(paramc0);
        localv.a(new String[] { paramc0 });
        if ("PLAIN".equalsIgnoreCase(paramc0)) {
          localv.a(saslHandler.getPlainUsername(), saslHandler.getPlainPassword());
        }
        paramc0 = saslHandler.getInitPayload(paramc0);
        if ((paramc0 != null) && (paramc0.length > 0))
        {
          i = paramc0.length;
          paramv = (k.a.b.a.d.g0.v)paramv;
          localObject = new byte[i];
          System.arraycopy(paramc0, 0, localObject, 0, i);
          paramc0 = new k/a/b/a/b/a;
          paramc0.<init>((byte[])localObject);
          k = paramc0;
        }
      }
      catch (Exception paramv)
      {
        savedException = paramv;
      }
    }
    return;
    label263:
    throw new IllegalStateException();
  }
  
  public void onSaslOutcome(k.a.b.a.d.v paramv, c0 paramc0)
  {
    if (paramv == null) {
      savedException = new IllegalArgumentException("Sasl cannot be null");
    } else {
      try
      {
        int i = p.ordinal();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 4)
              {
                if (i != 5) {
                  saslHandler.handleOutcome(SaslHandler.SaslOutcome.SYS);
                } else {
                  saslHandler.handleOutcome(SaslHandler.SaslOutcome.SYS_TEMP);
                }
              }
              else {
                saslHandler.handleOutcome(SaslHandler.SaslOutcome.SYS_PERM);
              }
            }
            else {
              saslHandler.handleOutcome(SaslHandler.SaslOutcome.AUTH);
            }
          }
          else {
            saslHandler.handleOutcome(SaslHandler.SaslOutcome.OK);
          }
        }
        else
        {
          paramv = new java/lang/IllegalStateException;
          paramv.<init>("Sasl negotiation did not finish yet");
          throw paramv;
        }
      }
      catch (Exception paramv)
      {
        savedException = paramv;
      }
    }
  }
  
  public void onSaslResponse(k.a.b.a.d.v paramv, c0 paramc0) {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.SaslListenerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */