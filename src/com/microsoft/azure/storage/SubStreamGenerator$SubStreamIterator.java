package com.microsoft.azure.storage;

import com.microsoft.azure.storage.blob.SubStream;
import java.io.InputStream;
import java.util.Iterator;

public class SubStreamGenerator$SubStreamIterator
  implements Iterator<InputStream>
{
  public SubStreamGenerator$SubStreamIterator(SubStreamGenerator paramSubStreamGenerator) {}
  
  public boolean hasNext()
  {
    boolean bool;
    if (SubStreamGenerator.access$100(this$0) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public SubStream next()
  {
    SubStreamGenerator.access$110(this$0);
    InputStream localInputStream = SubStreamGenerator.access$200(this$0);
    long l1 = SubStreamGenerator.access$308(this$0);
    long l2 = SubStreamGenerator.access$400(this$0);
    long l3;
    if (SubStreamGenerator.access$100(this$0) > 0) {
      l3 = SubStreamGenerator.access$400(this$0);
    } else {
      l3 = SubStreamGenerator.access$500(this$0);
    }
    return new SubStream(localInputStream, l1 * l2, l3, SubStreamGenerator.access$600(this$0));
  }
  
  public void remove() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.SubStreamGenerator.SubStreamIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */