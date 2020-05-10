package d.o;

import java.util.concurrent.atomic.AtomicReference;

public abstract class g
{
  public g()
  {
    new AtomicReference();
  }
  
  public abstract void a(k paramk);
  
  public static enum a
  {
    static
    {
      ON_RESUME = new a("ON_RESUME", 2);
      ON_PAUSE = new a("ON_PAUSE", 3);
      ON_STOP = new a("ON_STOP", 4);
      ON_DESTROY = new a("ON_DESTROY", 5);
      a locala = new a("ON_ANY", 6);
      ON_ANY = locala;
      $VALUES = new a[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, locala };
    }
    
    public a() {}
  }
  
  public static enum b
  {
    static
    {
      CREATED = new b("CREATED", 2);
      STARTED = new b("STARTED", 3);
      b localb = new b("RESUMED", 4);
      RESUMED = localb;
      $VALUES = new b[] { DESTROYED, INITIALIZED, CREATED, STARTED, localb };
    }
    
    public b() {}
    
    public boolean isAtLeast(b paramb)
    {
      boolean bool;
      if (compareTo(paramb) >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     d.o.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */