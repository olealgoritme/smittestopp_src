package d.r;

import java.io.File;
import java.io.FileFilter;

public class c
  implements FileFilter
{
  public c(d paramd) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().equals("MultiDex.lock") ^ true;
  }
}

/* Location:
 * Qualified Name:     d.r.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */