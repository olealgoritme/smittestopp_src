package l.b.i.b.g;

public final class x
  extends p
{
  public final w b;
  public final byte[] c;
  public final byte[] d;
  public final byte[] e;
  public final byte[] f;
  public volatile a g;
  
  public byte[] a()
  {
    try
    {
      byte[] arrayOfByte = b();
      return arrayOfByte;
    }
    finally {}
  }
  
  /* Error */
  public byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	l/b/i/b/g/x:b	Ll/b/i/b/g/w;
    //   6: getfield 39	l/b/i/b/g/w:g	I
    //   9: istore_1
    //   10: iload_1
    //   11: iconst_4
    //   12: iadd
    //   13: istore_2
    //   14: iload_2
    //   15: iload_1
    //   16: iadd
    //   17: istore_3
    //   18: iload_3
    //   19: iload_1
    //   20: iadd
    //   21: istore 4
    //   23: iload_1
    //   24: iload 4
    //   26: iadd
    //   27: newarray <illegal type>
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 79	l/b/i/b/g/x:g	Ll/b/i/b/g/a;
    //   35: getfield 71	l/b/i/b/g/a:G	I
    //   38: aload 5
    //   40: iconst_0
    //   41: invokestatic 160	l/b/c/e/a:b	(I[BI)V
    //   44: aload 5
    //   46: aload_0
    //   47: getfield 57	l/b/i/b/g/x:c	[B
    //   50: iconst_4
    //   51: invokestatic 163	l/b/c/e/a:a	([B[BI)V
    //   54: aload 5
    //   56: aload_0
    //   57: getfield 59	l/b/i/b/g/x:d	[B
    //   60: iload_2
    //   61: invokestatic 163	l/b/c/e/a:a	([B[BI)V
    //   64: aload 5
    //   66: aload_0
    //   67: getfield 61	l/b/i/b/g/x:e	[B
    //   70: iload_3
    //   71: invokestatic 163	l/b/c/e/a:a	([B[BI)V
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 63	l/b/i/b/g/x:f	[B
    //   80: iload 4
    //   82: invokestatic 163	l/b/c/e/a:a	([B[BI)V
    //   85: aload_0
    //   86: getfield 79	l/b/i/b/g/x:g	Ll/b/i/b/g/a;
    //   89: astore 6
    //   91: new 165	java/io/ByteArrayOutputStream
    //   94: astore 7
    //   96: aload 7
    //   98: invokespecial 166	java/io/ByteArrayOutputStream:<init>	()V
    //   101: new 168	java/io/ObjectOutputStream
    //   104: astore 8
    //   106: aload 8
    //   108: aload 7
    //   110: invokespecial 171	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   113: aload 8
    //   115: aload 6
    //   117: invokevirtual 175	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   120: aload 8
    //   122: invokevirtual 178	java/io/ObjectOutputStream:flush	()V
    //   125: aload 7
    //   127: invokevirtual 181	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: astore 6
    //   132: aload 5
    //   134: aload 6
    //   136: invokestatic 184	l/b/c/e/a:a	([B[B)[B
    //   139: astore 5
    //   141: aload_0
    //   142: monitorexit
    //   143: aload 5
    //   145: areturn
    //   146: astore 5
    //   148: new 186	java/lang/RuntimeException
    //   151: astore 6
    //   153: new 188	java/lang/StringBuilder
    //   156: astore 8
    //   158: aload 8
    //   160: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   163: aload 8
    //   165: ldc -65
    //   167: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 8
    //   173: aload 5
    //   175: invokevirtual 96	java/io/IOException:getMessage	()Ljava/lang/String;
    //   178: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 6
    //   184: aload 8
    //   186: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 199	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   192: aload 6
    //   194: athrow
    //   195: astore 5
    //   197: aload_0
    //   198: monitorexit
    //   199: aload 5
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	x
    //   9	18	1	i	int
    //   13	48	2	j	int
    //   17	54	3	k	int
    //   21	60	4	m	int
    //   29	115	5	arrayOfByte	byte[]
    //   146	28	5	localIOException	java.io.IOException
    //   195	5	5	localObject1	Object
    //   89	104	6	localObject2	Object
    //   94	32	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   104	81	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   85	132	146	java/io/IOException
    //   2	10	195	finally
    //   23	85	195	finally
    //   85	132	195	finally
    //   132	143	195	finally
    //   148	195	195	finally
    //   197	199	195	finally
  }
  
  public static class b
  {
    public final w a;
    public int b = 0;
    public int c = -1;
    public byte[] d = null;
    public byte[] e = null;
    public byte[] f = null;
    public byte[] g = null;
    public a h = null;
    public byte[] i = null;
    
    public b(w paramw)
    {
      a = paramw;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */