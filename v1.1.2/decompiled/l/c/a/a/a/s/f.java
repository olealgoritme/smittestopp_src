package l.c.a.a.a.s;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import l.c.a.a.a.j;
import l.c.a.a.a.k;
import l.c.a.a.a.q;
import l.c.a.a.a.s.s.o;
import l.c.a.a.a.s.s.u;
import l.c.a.a.a.t.b;
import l.c.a.a.a.t.c;

public class f
{
  public b a;
  public final Hashtable b;
  public String c;
  public k d;
  
  public f(String paramString)
  {
    b localb = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "l.c.a.a.a.s.f");
    a = localb;
    d = null;
    localb.a(paramString);
    b = new Hashtable();
    c = paramString;
    a.b("l.c.a.a.a.s.f", "<Init>", "308");
  }
  
  public j a(o paramo)
  {
    synchronized (b)
    {
      String str = Integer.toString(b);
      j localj;
      if (b.containsKey(str))
      {
        localj = (j)b.get(str);
        a.b("l.c.a.a.a.s.f", "restoreToken", "302", new Object[] { str, paramo, localj });
        paramo = localj;
      }
      else
      {
        localj = new l/c/a/a/a/j;
        localj.<init>(c);
        a.j = str;
        b.put(str, localj);
        a.b("l.c.a.a.a.s.f", "restoreToken", "303", new Object[] { str, paramo, localj });
        paramo = localj;
      }
      return paramo;
    }
  }
  
  public q a(String paramString)
  {
    a.b("l.c.a.a.a.s.f", "removeToken", "306", new Object[] { paramString });
    if (paramString != null) {
      return (q)b.remove(paramString);
    }
    return null;
  }
  
  public q a(u paramu)
  {
    paramu = paramu.i();
    return (q)b.get(paramu);
  }
  
  public void a()
  {
    a.b("l.c.a.a.a.s.f", "clear", "305", new Object[] { Integer.valueOf(b.size()) });
    synchronized (b)
    {
      b.clear();
      return;
    }
  }
  
  public void a(k paramk)
  {
    synchronized (b)
    {
      a.b("l.c.a.a.a.s.f", "quiesce", "309", new Object[] { paramk });
      d = paramk;
      return;
    }
  }
  
  public void a(q paramq, String paramString)
  {
    synchronized (b)
    {
      a.b("l.c.a.a.a.s.f", "saveToken", "307", new Object[] { paramString, paramq.toString() });
      a.j = paramString;
      b.put(paramString, paramq);
      return;
    }
  }
  
  public void a(q paramq, u paramu)
  {
    synchronized (b)
    {
      if (d == null)
      {
        String str = paramu.i();
        a.b("l.c.a.a.a.s.f", "saveToken", "300", new Object[] { str, paramu });
        a(paramq, str);
        return;
      }
      throw d;
    }
  }
  
  public int b()
  {
    synchronized (b)
    {
      int i = b.size();
      return i;
    }
  }
  
  public q b(u paramu)
  {
    if (paramu != null) {
      return a(paramu.i());
    }
    return null;
  }
  
  public j[] c()
  {
    synchronized (b)
    {
      a.b("l.c.a.a.a.s.f", "getOutstandingDelTokens", "311");
      Vector localVector = new java/util/Vector;
      localVector.<init>();
      Enumeration localEnumeration = b.elements();
      Object localObject1;
      do
      {
        if (!localEnumeration.hasMoreElements())
        {
          localObject1 = (j[])localVector.toArray(new j[localVector.size()]);
          return (j[])localObject1;
        }
        localObject1 = (q)localEnumeration.nextElement();
      } while ((localObject1 == null) || (!(localObject1 instanceof j)) || (a.o));
      localVector.addElement(localObject1);
    }
  }
  
  public Vector d()
  {
    synchronized (b)
    {
      a.b("l.c.a.a.a.s.f", "getOutstandingTokens", "312");
      Vector localVector = new java/util/Vector;
      localVector.<init>();
      Enumeration localEnumeration = b.elements();
      q localq;
      do
      {
        if (!localEnumeration.hasMoreElements()) {
          return localVector;
        }
        localq = (q)localEnumeration.nextElement();
      } while (localq == null);
      localVector.addElement(localq);
    }
  }
  
  public void e()
  {
    synchronized (b)
    {
      a.b("l.c.a.a.a.s.f", "open", "310");
      d = null;
      return;
    }
  }
  
  public String toString()
  {
    String str = System.getProperty("line.separator", "\n");
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized (b)
    {
      Enumeration localEnumeration = b.elements();
      if (!localEnumeration.hasMoreElements())
      {
        localObject1 = localStringBuffer.toString();
        return (String)localObject1;
      }
      q localq = (q)localEnumeration.nextElement();
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("{");
      ((StringBuilder)localObject1).append(a);
      ((StringBuilder)localObject1).append("}");
      ((StringBuilder)localObject1).append(str);
      localStringBuffer.append(((StringBuilder)localObject1).toString());
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */