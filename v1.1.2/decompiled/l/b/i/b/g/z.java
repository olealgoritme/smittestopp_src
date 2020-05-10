package l.b.i.b.g;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

public class z
  extends ObjectInputStream
{
  public static final Set z;
  public final Class x;
  public boolean y = false;
  
  static
  {
    HashSet localHashSet = new HashSet();
    z = localHashSet;
    localHashSet.add("java.util.TreeMap");
    z.add("java.lang.Integer");
    z.add("java.lang.Number");
    z.add("org.bouncycastle.pqc.crypto.xmss.BDS");
    z.add("java.util.ArrayList");
    z.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
    z.add("[B");
    z.add("java.util.LinkedList");
    z.add("java.util.Stack");
    z.add("java.util.Vector");
    z.add("[Ljava.lang.Object;");
    z.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
  }
  
  public z(Class paramClass, InputStream paramInputStream)
  {
    super(paramInputStream);
    x = paramClass;
  }
  
  public Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
  {
    if (!y)
    {
      if (paramObjectStreamClass.getName().equals(x.getName())) {
        y = true;
      } else {
        throw new InvalidClassException("unexpected class: ", paramObjectStreamClass.getName());
      }
    }
    else {
      if (!z.contains(paramObjectStreamClass.getName())) {
        break label67;
      }
    }
    return super.resolveClass(paramObjectStreamClass);
    label67:
    throw new InvalidClassException("unexpected class: ", paramObjectStreamClass.getName());
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */