package l.a.b.a.f.d;

import java.nio.ByteBuffer;
import java.util.Date;
import l.a.b.a.b.f;
import l.a.b.a.b.g;
import l.a.b.a.b.h;
import l.a.b.a.b.k.d;
import l.a.b.a.b.k.j;
import l.a.b.a.b.k.k;
import l.a.b.a.b.k.l;
import l.a.b.a.b.k.p;
import l.a.b.a.b.k.t;
import l.a.b.a.c.k0;
import l.a.b.a.c.k0.a;
import l.a.b.a.c.r;
import l.a.b.a.c.u;
import l.a.b.a.c.x;
import l.a.b.a.c.y0;
import l.a.b.a.c.y0.a;
import l.a.b.a.f.b;

public class a
  implements l.a.b.a.f.c
{
  public static final ThreadLocal<b> tlsCodec = new a();
  public d _applicationProperties;
  public t _body;
  public j _deliveryAnnotations;
  public k _footer;
  public l _header;
  public l.a.b.a.b.k.m _messageAnnotations;
  public p _properties;
  
  public a() {}
  
  public a(l paraml, j paramj, l.a.b.a.b.k.m paramm, p paramp, d paramd, t paramt, k paramk)
  {
    _header = paraml;
    _deliveryAnnotations = paramj;
    _messageAnnotations = paramm;
    _properties = paramp;
    _applicationProperties = paramd;
    _body = paramt;
    _footer = paramk;
  }
  
  public void clear()
  {
    _body = null;
  }
  
  public int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    decode(paramArrayOfByte);
    return paramInt2 - paramArrayOfByte.remaining();
  }
  
  public void decode(ByteBuffer paramByteBuffer)
  {
    decode(new k0.a(paramByteBuffer));
  }
  
  public void decode(k0 paramk0)
  {
    r localr = tlsCodecgeta;
    a = paramk0;
    _header = null;
    _deliveryAnnotations = null;
    _messageAnnotations = null;
    _properties = null;
    _applicationProperties = null;
    _body = null;
    _footer = null;
    if (paramk0.b()) {
      localObject1 = (t)localr.d();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if ((localObject1 instanceof l))
    {
      _header = ((l)localObject1);
      if (paramk0.b()) {
        localObject2 = (t)localr.d();
      } else {
        localObject2 = null;
      }
    }
    Object localObject1 = localObject2;
    if ((localObject2 instanceof j))
    {
      _deliveryAnnotations = ((j)localObject2);
      if (paramk0.b()) {
        localObject1 = (t)localr.d();
      } else {
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if ((localObject1 instanceof l.a.b.a.b.k.m))
    {
      _messageAnnotations = ((l.a.b.a.b.k.m)localObject1);
      if (paramk0.b()) {
        localObject2 = (t)localr.d();
      } else {
        localObject2 = null;
      }
    }
    localObject1 = localObject2;
    if ((localObject2 instanceof p))
    {
      _properties = ((p)localObject2);
      if (paramk0.b()) {
        localObject1 = (t)localr.d();
      } else {
        localObject1 = null;
      }
    }
    localObject2 = localObject1;
    if ((localObject1 instanceof d))
    {
      _applicationProperties = ((d)localObject1);
      if (paramk0.b()) {
        localObject2 = (t)localr.d();
      } else {
        localObject2 = null;
      }
    }
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!(localObject2 instanceof k))
      {
        _body = ((t)localObject2);
        if (paramk0.b()) {
          localObject1 = (t)localr.d();
        } else {
          localObject1 = null;
        }
      }
    }
    if ((localObject1 instanceof k)) {
      _footer = ((k)localObject1);
    }
    a = null;
  }
  
  public int encode(y0 paramy0)
  {
    int i = paramy0.c();
    x localx = tlsCodecgetb;
    a = paramy0;
    if (getHeader() != null) {
      localx.b(getHeader());
    }
    if (getDeliveryAnnotations() != null) {
      localx.b(getDeliveryAnnotations());
    }
    if (getMessageAnnotations() != null) {
      localx.b(getMessageAnnotations());
    }
    if (getProperties() != null) {
      localx.b(getProperties());
    }
    if (getApplicationProperties() != null) {
      localx.b(getApplicationProperties());
    }
    if (getBody() != null) {
      localx.b(getBody());
    }
    if (getFooter() != null) {
      localx.b(getFooter());
    }
    a = null;
    return i - paramy0.c();
  }
  
  public int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return encode(new y0.a(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2)));
  }
  
  public int encode2(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new l.a.b.a.c.m(new y0.a(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2)), new u());
    paramInt1 = paramArrayOfByte.position();
    encode(paramArrayOfByte);
    return paramArrayOfByte.position() - paramInt1;
  }
  
  public String getAddress()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = c;
    }
    return (String)localObject;
  }
  
  public d getApplicationProperties()
  {
    return _applicationProperties;
  }
  
  public t getBody()
  {
    return _body;
  }
  
  public String getContentEncoding()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      localObject = h;
      if (localObject != null) {
        return x;
      }
    }
    localObject = null;
    return (String)localObject;
  }
  
  public String getContentType()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      localObject = g;
      if (localObject != null) {
        return x;
      }
    }
    localObject = null;
    return (String)localObject;
  }
  
  public Object getCorrelationId()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = f;
    }
    return localObject;
  }
  
  public long getCreationTime()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      localObject = j;
      if (localObject != null)
      {
        l = ((Date)localObject).getTime();
        return l;
      }
    }
    long l = 0L;
    return l;
  }
  
  public j getDeliveryAnnotations()
  {
    return _deliveryAnnotations;
  }
  
  public long getDeliveryCount()
  {
    Object localObject = _header;
    if (localObject != null)
    {
      localObject = e;
      if (localObject != null)
      {
        l = ((h)localObject).longValue();
        return l;
      }
    }
    long l = 0L;
    return l;
  }
  
  public b getError()
  {
    return b.OK;
  }
  
  public long getExpiryTime()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      localObject = i;
      if (localObject != null)
      {
        l = ((Date)localObject).getTime();
        return l;
      }
    }
    long l = 0L;
    return l;
  }
  
  public k getFooter()
  {
    return _footer;
  }
  
  public String getGroupId()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = k;
    }
    return (String)localObject;
  }
  
  public long getGroupSequence()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      localObject = l;
      if (localObject != null)
      {
        l = x;
        return l;
      }
    }
    long l = 0L;
    return l;
  }
  
  public l getHeader()
  {
    return _header;
  }
  
  public l.a.b.a.b.k.m getMessageAnnotations()
  {
    return _messageAnnotations;
  }
  
  public Object getMessageId()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = a;
    }
    return localObject;
  }
  
  public short getPriority()
  {
    Object localObject = _header;
    if (localObject != null)
    {
      localObject = b;
      if (localObject != null)
      {
        s1 = ((g)localObject).shortValue();
        return s1;
      }
    }
    short s1 = 4;
    short s2 = s1;
    return s2;
  }
  
  public p getProperties()
  {
    return _properties;
  }
  
  public String getReplyTo()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = e;
    }
    return (String)localObject;
  }
  
  public String getReplyToGroupId()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = m;
    }
    return (String)localObject;
  }
  
  public String getSubject()
  {
    Object localObject = _properties;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = d;
    }
    return (String)localObject;
  }
  
  public long getTtl()
  {
    Object localObject = _header;
    if (localObject != null)
    {
      localObject = c;
      if (localObject != null)
      {
        l = ((h)localObject).longValue();
        return l;
      }
    }
    long l = 0L;
    return l;
  }
  
  public byte[] getUserId()
  {
    Object localObject = _properties;
    if (localObject != null)
    {
      l.a.b.a.b.a locala = b;
      if (locala != null)
      {
        int i = c;
        localObject = new byte[i];
        System.arraycopy(a, b, localObject, 0, i);
        return (byte[])localObject;
      }
    }
    return null;
  }
  
  public boolean isDurable()
  {
    Object localObject = _header;
    if (localObject != null)
    {
      localObject = a;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public boolean isFirstAcquirer()
  {
    Object localObject = _header;
    if (localObject != null)
    {
      localObject = d;
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void setAddress(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.c = paramString;
  }
  
  public void setApplicationProperties(d paramd)
  {
    _applicationProperties = paramd;
  }
  
  public void setBody(t paramt)
  {
    _body = paramt;
  }
  
  public void setContentEncoding(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.h = f.a(paramString);
  }
  
  public void setContentType(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.g = f.a(paramString);
  }
  
  public void setCorrelationId(Object paramObject)
  {
    if (_properties == null)
    {
      if (paramObject == null) {
        return;
      }
      _properties = new p();
    }
    _properties.f = paramObject;
  }
  
  public void setCreationTime(long paramLong)
  {
    if (_properties == null)
    {
      if (paramLong == 0L) {
        return;
      }
      _properties = new p();
    }
    _properties.j = new Date(paramLong);
  }
  
  public void setDeliveryAnnotations(j paramj)
  {
    _deliveryAnnotations = paramj;
  }
  
  public void setDeliveryCount(long paramLong)
  {
    if (_header == null)
    {
      if (paramLong == 0L) {
        return;
      }
      _header = new l();
    }
    _header.e = h.a(paramLong);
  }
  
  public void setDurable(boolean paramBoolean)
  {
    if (_header == null) {
      if (paramBoolean) {
        _header = new l();
      } else {
        return;
      }
    }
    _header.a = Boolean.valueOf(paramBoolean);
  }
  
  public void setExpiryTime(long paramLong)
  {
    if (_properties == null)
    {
      if (paramLong == 0L) {
        return;
      }
      _properties = new p();
    }
    _properties.i = new Date(paramLong);
  }
  
  public void setFirstAcquirer(boolean paramBoolean)
  {
    if (_header == null)
    {
      if (!paramBoolean) {
        return;
      }
      _header = new l();
    }
    _header.d = Boolean.valueOf(paramBoolean);
  }
  
  public void setFooter(k paramk)
  {
    _footer = paramk;
  }
  
  public void setGroupId(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.k = paramString;
  }
  
  public void setGroupSequence(long paramLong)
  {
    if (_properties == null)
    {
      if (paramLong == 0L) {
        return;
      }
      _properties = new p();
    }
    _properties.l = h.a((int)paramLong);
  }
  
  public void setHeader(l paraml)
  {
    _header = paraml;
  }
  
  public void setMessageAnnotations(l.a.b.a.b.k.m paramm)
  {
    _messageAnnotations = paramm;
  }
  
  public void setMessageId(Object paramObject)
  {
    if (_properties == null)
    {
      if (paramObject == null) {
        return;
      }
      _properties = new p();
    }
    _properties.a = paramObject;
  }
  
  public void setPriority(short paramShort)
  {
    if (_header == null)
    {
      if (paramShort == 4) {
        return;
      }
      _header = new l();
    }
    _header.b = g.a((byte)paramShort);
  }
  
  public void setProperties(p paramp)
  {
    _properties = paramp;
  }
  
  public void setReplyTo(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.e = paramString;
  }
  
  public void setReplyToGroupId(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.m = paramString;
  }
  
  public void setSubject(String paramString)
  {
    if (_properties == null)
    {
      if (paramString == null) {
        return;
      }
      _properties = new p();
    }
    _properties.d = paramString;
  }
  
  public void setTtl(long paramLong)
  {
    if (_header == null) {
      if (paramLong != 0L) {
        _header = new l();
      } else {
        return;
      }
    }
    _header.c = h.a(paramLong);
  }
  
  public void setUserId(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = _properties;
      if (paramArrayOfByte != null) {
        b = null;
      }
    }
    else
    {
      if (_properties == null) {
        _properties = new p();
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      _properties.b = new l.a.b.a.b.a(arrayOfByte);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Message{");
    if (_header != null)
    {
      localStringBuilder.append("header=");
      localStringBuilder.append(_header);
    }
    if (_properties != null)
    {
      localStringBuilder.append("properties=");
      localStringBuilder.append(_properties);
    }
    if (_messageAnnotations != null)
    {
      localStringBuilder.append("message_annotations=");
      localStringBuilder.append(_messageAnnotations);
    }
    if (_body != null)
    {
      localStringBuilder.append("body=");
      localStringBuilder.append(_body);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static final class a
    extends ThreadLocal<a.b>
  {
    public Object initialValue()
    {
      return new a.b(null);
    }
  }
  
  public static class b
  {
    public r a;
    public x b;
    
    public b()
    {
      Object localObject = new r();
      a = ((r)localObject);
      localObject = new x((r)localObject);
      b = ((x)localObject);
      e.c.a.a.b.l.c.a(a, (x)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.f.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */