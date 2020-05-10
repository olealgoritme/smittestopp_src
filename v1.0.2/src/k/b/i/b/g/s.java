package k.b.i.b.g;

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
    //   3: getfield 43	k/b/i/b/g/s:b	Lk/b/i/b/g/r;
    //   6: getfield 33	k/b/i/b/g/r:b	Lk/b/i/b/g/w;
    //   9: getfield 46	k/b/i/b/g/w:g	I
    //   12: istore_1
    //   13: aload_0
    //   14: getfield 43	k/b/i/b/g/s:b	Lk/b/i/b/g/r;
    //   17: getfield 54	k/b/i/b/g/r:c	I
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
    //   41: getfield 61	k/b/i/b/g/s:g	J
    //   44: iload_2
    //   45: invokestatic 146	k/b/c/e/a:a	(JI)[B
    //   48: iconst_0
    //   49: invokestatic 149	k/b/c/e/a:a	([B[BI)V
    //   52: iinc 2 0
    //   55: aload_3
    //   56: aload_0
    //   57: getfield 69	k/b/i/b/g/s:c	[B
    //   60: iload_2
    //   61: invokestatic 149	k/b/c/e/a:a	([B[BI)V
    //   64: iload_2
    //   65: iload_1
    //   66: iadd
    //   67: istore_2
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 71	k/b/i/b/g/s:d	[B
    //   73: iload_2
    //   74: invokestatic 149	k/b/c/e/a:a	([B[BI)V
    //   77: iload_2
    //   78: iload_1
    //   79: iadd
    //   80: istore_2
    //   81: aload_3
    //   82: aload_0
    //   83: getfield 73	k/b/i/b/g/s:e	[B
    //   86: iload_2
    //   87: invokestatic 149	k/b/c/e/a:a	([B[BI)V
    //   90: aload_3
    //   91: aload_0
    //   92: getfield 75	k/b/i/b/g/s:f	[B
    //   95: iload_2
    //   96: iload_1
    //   97: iadd
    //   98: invokestatic 149	k/b/c/e/a:a	([B[BI)V
    //   101: aload_0
    //   102: getfield 88	k/b/i/b/g/s:h	Lk/b/i/b/g/b;
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
    //   147: invokestatic 172	k/b/c/e/a:a	([B[B)[B
    //   150: astore 4
    //   152: aload_0
    //   153: monitorexit
    //   154: aload 4
    //   156: areturn
    //   157: astore 5
    //   159: new 174	java/lang/IllegalStateException
    //   162: astore 4
    //   164: new 176	java/lang/StringBuilder
    //   167: astore 6
    //   169: aload 6
    //   171: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   174: aload 6
    //   176: ldc -77
    //   178: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 6
    //   184: aload 5
    //   186: invokevirtual 98	java/io/IOException:getMessage	()Ljava/lang/String;
    //   189: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: aload 6
    //   197: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aload 5
    //   202: invokespecial 187	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: aload_0
    //   211: monitorexit
    //   212: aload 4
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	s
    //   12	86	1	i	int
    //   26	72	2	j	int
    //   38	104	3	arrayOfByte	byte[]
    //   105	101	4	localObject1	Object
    //   208	5	4	localObject2	Object
    //   110	33	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   157	44	5	localIOException	java.io.IOException
    //   120	76	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	152	157	java/io/IOException
    //   2	52	208	finally
    //   55	64	208	finally
    //   68	77	208	finally
    //   81	101	208	finally
    //   101	152	208	finally
    //   152	154	208	finally
    //   159	208	208	finally
    //   210	212	208	finally
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */