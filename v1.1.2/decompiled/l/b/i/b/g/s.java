package l.b.i.b.g;

public final class s
  extends q
{
  public final r b;
  public final byte[] c;
  public final byte[] d;
  public final byte[] e;
  public final byte[] f;
  public volatile long g;
  public volatile b h;
  
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
    //   3: getfield 43	l/b/i/b/g/s:b	Ll/b/i/b/g/r;
    //   6: getfield 33	l/b/i/b/g/r:b	Ll/b/i/b/g/w;
    //   9: getfield 46	l/b/i/b/g/w:g	I
    //   12: istore_1
    //   13: aload_0
    //   14: getfield 43	l/b/i/b/g/s:b	Ll/b/i/b/g/r;
    //   17: getfield 54	l/b/i/b/g/r:c	I
    //   20: bipush 7
    //   22: iadd
    //   23: bipush 8
    //   25: idiv
    //   26: istore_2
    //   27: iload_2
    //   28: iload_1
    //   29: iadd
    //   30: iload_1
    //   31: iadd
    //   32: iload_1
    //   33: iadd
    //   34: iload_1
    //   35: iadd
    //   36: newarray <illegal type>
    //   38: astore_3
    //   39: aload_3
    //   40: aload_0
    //   41: getfield 61	l/b/i/b/g/s:g	J
    //   44: iload_2
    //   45: invokestatic 146	l/b/c/e/a:a	(JI)[B
    //   48: iconst_0
    //   49: invokestatic 149	l/b/c/e/a:a	([B[BI)V
    //   52: iinc 2 0
    //   55: aload_3
    //   56: aload_0
    //   57: getfield 69	l/b/i/b/g/s:c	[B
    //   60: iload_2
    //   61: invokestatic 149	l/b/c/e/a:a	([B[BI)V
    //   64: iload_2
    //   65: iload_1
    //   66: iadd
    //   67: istore_2
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 71	l/b/i/b/g/s:d	[B
    //   73: iload_2
    //   74: invokestatic 149	l/b/c/e/a:a	([B[BI)V
    //   77: iload_2
    //   78: iload_1
    //   79: iadd
    //   80: istore_2
    //   81: aload_3
    //   82: aload_0
    //   83: getfield 73	l/b/i/b/g/s:e	[B
    //   86: iload_2
    //   87: invokestatic 149	l/b/c/e/a:a	([B[BI)V
    //   90: aload_3
    //   91: aload_0
    //   92: getfield 75	l/b/i/b/g/s:f	[B
    //   95: iload_2
    //   96: iload_1
    //   97: iadd
    //   98: invokestatic 149	l/b/c/e/a:a	([B[BI)V
    //   101: aload_0
    //   102: getfield 88	l/b/i/b/g/s:h	Ll/b/i/b/g/b;
    //   105: astore 4
    //   107: new 151	java/io/ByteArrayOutputStream
    //   110: astore 5
    //   112: aload 5
    //   114: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   117: new 156	java/io/ObjectOutputStream
    //   120: astore 6
    //   122: aload 6
    //   124: aload 5
    //   126: invokespecial 159	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: aload 6
    //   131: aload 4
    //   133: invokevirtual 163	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   136: aload 6
    //   138: invokevirtual 166	java/io/ObjectOutputStream:flush	()V
    //   141: aload_3
    //   142: aload 5
    //   144: invokevirtual 169	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   147: invokestatic 172	l/b/c/e/a:a	([B[B)[B
    //   150: astore 5
    //   152: aload_0
    //   153: monitorexit
    //   154: aload 5
    //   156: areturn
    //   157: astore 4
    //   159: new 174	java/lang/IllegalStateException
    //   162: astore 5
    //   164: new 176	java/lang/StringBuilder
    //   167: astore_3
    //   168: aload_3
    //   169: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   172: aload_3
    //   173: ldc -77
    //   175: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: aload 4
    //   182: invokevirtual 98	java/io/IOException:getMessage	()Ljava/lang/String;
    //   185: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: aload_3
    //   192: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 4
    //   197: invokespecial 187	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload 5
    //   202: athrow
    //   203: astore 5
    //   205: aload_0
    //   206: monitorexit
    //   207: aload 5
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	s
    //   12	86	1	i	int
    //   26	72	2	j	int
    //   38	154	3	localObject1	Object
    //   105	27	4	localb	b
    //   157	39	4	localIOException	java.io.IOException
    //   110	91	5	localObject2	Object
    //   203	5	5	localObject3	Object
    //   120	17	6	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   101	152	157	java/io/IOException
    //   2	52	203	finally
    //   55	64	203	finally
    //   68	77	203	finally
    //   81	101	203	finally
    //   101	152	203	finally
    //   152	154	203	finally
    //   159	203	203	finally
    //   205	207	203	finally
  }
  
  public static class b
  {
    public final r a;
    public long b = 0L;
    public long c = -1L;
    public byte[] d = null;
    public byte[] e = null;
    public byte[] f = null;
    public byte[] g = null;
    public b h = null;
    public byte[] i = null;
    public w j = null;
    
    public b(r paramr)
    {
      a = paramr;
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */