package l.a.b.a.d.g0;

import java.nio.ByteBuffer;
import l.a.b.a.d.d0;

public abstract class l<T1 extends l0, T2 extends l0>
  implements l0
{
  public static final ByteBuffer EMPTY = ByteBuffer.allocate(0);
  public final ByteBuffer _determinationBuffer;
  public boolean _head_closed = false;
  public l0 _selectedTransportWrapper;
  public boolean _tail_closed = false;
  public final T1 _wrapper1;
  public final T2 _wrapper2;
  
  public l(T1 paramT1, T2 paramT2)
  {
    _wrapper1 = paramT1;
    _wrapper2 = paramT2;
    _determinationBuffer = ByteBuffer.allocate(bufferSize());
  }
  
  public abstract int bufferSize();
  
  public int capacity()
  {
    if (isDeterminationMade()) {
      return _selectedTransportWrapper.capacity();
    }
    if (_tail_closed) {
      return -1;
    }
    return _determinationBuffer.remaining();
  }
  
  public void close_head()
  {
    if (isDeterminationMade()) {
      _selectedTransportWrapper.close_head();
    } else {
      _head_closed = true;
    }
  }
  
  public void close_tail()
  {
    try
    {
      if (isDeterminationMade()) {
        _selectedTransportWrapper.close_tail();
      }
      return;
    }
    finally
    {
      _tail_closed = true;
    }
  }
  
  public ByteBuffer head()
  {
    if (isDeterminationMade()) {
      return _selectedTransportWrapper.head();
    }
    return EMPTY;
  }
  
  public boolean isDeterminationMade()
  {
    boolean bool;
    if (_selectedTransportWrapper != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract void makeDetermination(byte[] paramArrayOfByte);
  
  public int pending()
  {
    if (_head_closed) {
      return -1;
    }
    if (isDeterminationMade()) {
      return _selectedTransportWrapper.pending();
    }
    return 0;
  }
  
  public void pop(int paramInt)
  {
    if (isDeterminationMade()) {
      _selectedTransportWrapper.pop(paramInt);
    } else {
      if (paramInt > 0) {
        break label25;
      }
    }
    return;
    label25:
    throw new IllegalStateException("no bytes have been read");
  }
  
  public int position()
  {
    if (isDeterminationMade()) {
      return _selectedTransportWrapper.position();
    }
    if (_tail_closed) {
      return -1;
    }
    return _determinationBuffer.position();
  }
  
  public void process()
  {
    if (isDeterminationMade())
    {
      _selectedTransportWrapper.process();
    }
    else if (_determinationBuffer.remaining() == 0)
    {
      _determinationBuffer.flip();
      byte[] arrayOfByte = new byte[_determinationBuffer.remaining()];
      _determinationBuffer.get(arrayOfByte);
      makeDetermination(arrayOfByte);
      _determinationBuffer.rewind();
      _selectedTransportWrapper.tail().put(_determinationBuffer);
      _selectedTransportWrapper.process();
    }
    else
    {
      if (_tail_closed) {
        break label106;
      }
    }
    return;
    label106:
    throw new d0("connection aborted");
  }
  
  public ByteBuffer tail()
  {
    if (isDeterminationMade()) {
      return _selectedTransportWrapper.tail();
    }
    return _determinationBuffer;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */