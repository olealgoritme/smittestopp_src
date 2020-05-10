package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.b;
import e.c.c.y.c;
import java.util.BitSet;

public final class TypeAdapters$2
  extends TypeAdapter<BitSet>
{
  public Object read(e.c.c.y.a parama)
  {
    BitSet localBitSet = new BitSet();
    parama.a();
    Object localObject = parama.r();
    int i = 0;
    while (localObject != b.END_ARRAY)
    {
      int j = ((Enum)localObject).ordinal();
      boolean bool;
      if (j != 5)
      {
        if (j != 6)
        {
          if (j == 7)
          {
            bool = parama.j();
            break label130;
          }
          parama = new StringBuilder();
          parama.append("Invalid bitset value type: ");
          parama.append(localObject);
          throw new s(parama.toString());
        }
        if (parama.l() == 0) {
          break label127;
        }
      }
      else
      {
        localObject = parama.p();
      }
      try
      {
        j = Integer.parseInt((String)localObject);
        if (j != 0) {
          bool = true;
        } else {
          label127:
          bool = false;
        }
        label130:
        if (bool) {
          localBitSet.set(i);
        }
        i++;
        localObject = parama.r();
      }
      catch (NumberFormatException parama)
      {
        throw new s(e.a.a.a.a.b("Error: Expecting: bitset number value (1, 0), Found: ", (String)localObject));
      }
    }
    parama.e();
    return localBitSet;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (BitSet)paramObject;
    paramc.b();
    int i = ((BitSet)paramObject).length();
    for (int j = 0; j < i; j++) {
      paramc.a(((BitSet)paramObject).get(j));
    }
    paramc.d();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */