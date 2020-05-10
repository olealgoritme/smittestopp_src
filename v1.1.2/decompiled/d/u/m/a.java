package d.u.m;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a
{
  public static final Map<String, Lock> e = new HashMap();
  public final File a;
  public final Lock b;
  public final boolean c;
  public FileChannel d;
  
  public a(String paramString, File paramFile, boolean paramBoolean)
  {
    paramString = new File(paramFile, e.a.a.a.a.b(paramString, ".lck"));
    a = paramString;
    b = a(paramString.getAbsolutePath());
    c = paramBoolean;
  }
  
  public static Lock a(String paramString)
  {
    synchronized (e)
    {
      Lock localLock = (Lock)e.get(paramString);
      Object localObject = localLock;
      if (localLock == null)
      {
        localObject = new java/util/concurrent/locks/ReentrantLock;
        ((ReentrantLock)localObject).<init>();
        e.put(paramString, localObject);
      }
      return (Lock)localObject;
    }
  }
  
  public void a()
  {
    FileChannel localFileChannel = d;
    if (localFileChannel != null) {}
    try
    {
      localFileChannel.close();
      b.unlock();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     d.u.m.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */