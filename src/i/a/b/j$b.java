package i.a.b;

public class j$b
  implements j.g
{
  /* Error */
  public void a(String paramString, Appendable paramAppendable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 25	java/lang/String:length	()I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iload 4
    //   10: iload_3
    //   11: if_icmplt +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: iload 4
    //   18: invokevirtual 29	java/lang/String:charAt	(I)C
    //   21: istore 5
    //   23: iload 5
    //   25: bipush 12
    //   27: if_icmpeq +270 -> 297
    //   30: iload 5
    //   32: bipush 13
    //   34: if_icmpeq +251 -> 285
    //   37: iload 5
    //   39: bipush 34
    //   41: if_icmpeq +232 -> 273
    //   44: iload 5
    //   46: bipush 92
    //   48: if_icmpeq +213 -> 261
    //   51: iload 5
    //   53: tableswitch	default:+27->80, 8:+196->249, 9:+184->237, 10:+172->225
    //   80: iload 5
    //   82: iflt +10 -> 92
    //   85: iload 5
    //   87: bipush 31
    //   89: if_icmple +34 -> 123
    //   92: iload 5
    //   94: bipush 127
    //   96: if_icmplt +11 -> 107
    //   99: iload 5
    //   101: sipush 159
    //   104: if_icmple +19 -> 123
    //   107: iload 5
    //   109: sipush 8192
    //   112: if_icmplt +101 -> 213
    //   115: iload 5
    //   117: sipush 8447
    //   120: if_icmpgt +93 -> 213
    //   123: aload_2
    //   124: ldc 31
    //   126: invokeinterface 37 2 0
    //   131: pop
    //   132: aload_2
    //   133: ldc 39
    //   135: iload 5
    //   137: bipush 12
    //   139: ishr
    //   140: bipush 15
    //   142: iand
    //   143: invokevirtual 29	java/lang/String:charAt	(I)C
    //   146: invokeinterface 42 2 0
    //   151: pop
    //   152: aload_2
    //   153: ldc 39
    //   155: iload 5
    //   157: bipush 8
    //   159: ishr
    //   160: bipush 15
    //   162: iand
    //   163: invokevirtual 29	java/lang/String:charAt	(I)C
    //   166: invokeinterface 42 2 0
    //   171: pop
    //   172: aload_2
    //   173: ldc 39
    //   175: iload 5
    //   177: iconst_4
    //   178: ishr
    //   179: bipush 15
    //   181: iand
    //   182: invokevirtual 29	java/lang/String:charAt	(I)C
    //   185: invokeinterface 42 2 0
    //   190: pop
    //   191: aload_2
    //   192: ldc 39
    //   194: iload 5
    //   196: iconst_0
    //   197: ishr
    //   198: bipush 15
    //   200: iand
    //   201: invokevirtual 29	java/lang/String:charAt	(I)C
    //   204: invokeinterface 42 2 0
    //   209: pop
    //   210: goto +96 -> 306
    //   213: aload_2
    //   214: iload 5
    //   216: invokeinterface 42 2 0
    //   221: pop
    //   222: goto +84 -> 306
    //   225: aload_2
    //   226: ldc 44
    //   228: invokeinterface 37 2 0
    //   233: pop
    //   234: goto +72 -> 306
    //   237: aload_2
    //   238: ldc 46
    //   240: invokeinterface 37 2 0
    //   245: pop
    //   246: goto +60 -> 306
    //   249: aload_2
    //   250: ldc 48
    //   252: invokeinterface 37 2 0
    //   257: pop
    //   258: goto +48 -> 306
    //   261: aload_2
    //   262: ldc 50
    //   264: invokeinterface 37 2 0
    //   269: pop
    //   270: goto +36 -> 306
    //   273: aload_2
    //   274: ldc 52
    //   276: invokeinterface 37 2 0
    //   281: pop
    //   282: goto +24 -> 306
    //   285: aload_2
    //   286: ldc 54
    //   288: invokeinterface 37 2 0
    //   293: pop
    //   294: goto +12 -> 306
    //   297: aload_2
    //   298: ldc 56
    //   300: invokeinterface 37 2 0
    //   305: pop
    //   306: iinc 4 1
    //   309: goto -301 -> 8
    //   312: astore_1
    //   313: new 58	java/lang/RuntimeException
    //   316: dup
    //   317: ldc 60
    //   319: invokespecial 63	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   322: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	b
    //   0	323	1	paramString	String
    //   0	323	2	paramAppendable	Appendable
    //   4	8	3	i	int
    //   6	301	4	j	int
    //   21	194	5	c	char
    // Exception table:
    //   from	to	target	type
    //   0	5	312	java/io/IOException
    //   15	23	312	java/io/IOException
    //   123	210	312	java/io/IOException
    //   213	222	312	java/io/IOException
    //   225	234	312	java/io/IOException
    //   237	246	312	java/io/IOException
    //   249	258	312	java/io/IOException
    //   261	270	312	java/io/IOException
    //   273	282	312	java/io/IOException
    //   285	294	312	java/io/IOException
    //   297	306	312	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */