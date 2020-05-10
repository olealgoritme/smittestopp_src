package k.a.a.a.a.a;

import android.os.ParcelUuid;
import e.a.a.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public final class e
{
  public static final ParcelUuid a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
  
  public static ParcelUuid a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      if ((i != 2) && (i != 4) && (i != 16)) {
        throw new IllegalArgumentException(a.a("uuidBytes length invalid - ", i));
      }
      if (i == 16)
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        return new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
      }
      long l1;
      if (i == 2)
      {
        l1 = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
      }
      else
      {
        long l2 = paramArrayOfByte[0] & 0xFF;
        l1 = (paramArrayOfByte[1] & 0xFF) << 8;
        long l3 = (paramArrayOfByte[2] & 0xFF) << 16;
        l1 = ((paramArrayOfByte[3] & 0xFF) << 24) + (l2 + l1 + l3);
      }
      return new ParcelUuid(new UUID(a.getUuid().getMostSignificantBits() + (l1 << 32), a.getUuid().getLeastSignificantBits()));
    }
    throw new IllegalArgumentException("uuidBytes cannot be null");
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */