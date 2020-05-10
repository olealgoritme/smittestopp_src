package g.c;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$b
{
  public static final List<String> a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(a.a("jnr.ffi.library.path"));
      localArrayList.addAll(a.a("jaffl.library.path"));
      localArrayList.addAll(a.a("jna.library.path"));
      localArrayList.addAll(a.a("java.library.path"));
      int i = da.ordinal();
      if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 9))
      {
        File localFile = new File("/etc/ld.so.conf");
        Object localObject = new File("/etc/ld.so.conf.d");
        if (localFile.exists()) {
          a(localArrayList, localFile);
        }
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).listFiles();
          int j = localObject.length;
          for (i = 0; i < j; i++) {
            a(localArrayList, localObject[i]);
          }
        }
      }
      a = Collections.unmodifiableList(new ArrayList(localArrayList));
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static void a(List<String> paramList, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 89	java/io/File:isFile	()Z
    //   4: ifeq +129 -> 133
    //   7: aload_1
    //   8: invokevirtual 62	java/io/File:exists	()Z
    //   11: ifne +6 -> 17
    //   14: goto +119 -> 133
    //   17: aconst_null
    //   18: astore_2
    //   19: aconst_null
    //   20: astore_3
    //   21: new 91	java/io/BufferedReader
    //   24: astore 4
    //   26: new 93	java/io/FileReader
    //   29: astore 5
    //   31: aload 5
    //   33: aload_1
    //   34: invokespecial 96	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   37: aload 4
    //   39: aload 5
    //   41: invokespecial 99	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: aload 4
    //   46: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +36 -> 87
    //   54: new 51	java/io/File
    //   57: astore_3
    //   58: aload_3
    //   59: aload_1
    //   60: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokevirtual 62	java/io/File:exists	()Z
    //   67: ifeq +11 -> 78
    //   70: aload_0
    //   71: aload_1
    //   72: invokeinterface 109 2 0
    //   77: pop
    //   78: aload 4
    //   80: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore_1
    //   84: goto -34 -> 50
    //   87: aload 4
    //   89: invokevirtual 112	java/io/BufferedReader:close	()V
    //   92: goto +41 -> 133
    //   95: astore_0
    //   96: aload 4
    //   98: astore_1
    //   99: goto +13 -> 112
    //   102: astore_0
    //   103: aload 4
    //   105: astore_0
    //   106: goto +19 -> 125
    //   109: astore_0
    //   110: aload_3
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 112	java/io/BufferedReader:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload_2
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 112	java/io/BufferedReader:close	()V
    //   133: return
    //   134: astore_0
    //   135: goto -2 -> 133
    //   138: astore_1
    //   139: goto -19 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramList	List<String>
    //   0	142	1	paramFile	File
    //   18	106	2	localObject	Object
    //   20	91	3	localFile	File
    //   24	80	4	localBufferedReader	java.io.BufferedReader
    //   29	11	5	localFileReader	java.io.FileReader
    // Exception table:
    //   from	to	target	type
    //   44	50	95	finally
    //   54	78	95	finally
    //   78	84	95	finally
    //   44	50	102	java/io/IOException
    //   54	78	102	java/io/IOException
    //   78	84	102	java/io/IOException
    //   21	44	109	finally
    //   21	44	122	java/io/IOException
    //   87	92	134	java/io/IOException
    //   129	133	134	java/io/IOException
    //   116	120	138	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     base.g.c.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */