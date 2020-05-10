package l.a.b.a.c;

public final class n0$a
  implements r.b<String>
{
  /* Error */
  public Object a(r paramr, k0 paramk0)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 24	l/a/b/a/c/r:b	Ljava/nio/charset/CharsetDecoder;
    //   4: astore_1
    //   5: aload_2
    //   6: aload_1
    //   7: invokeinterface 29 2 0
    //   12: astore_2
    //   13: aload_1
    //   14: invokevirtual 35	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   17: pop
    //   18: aload_2
    //   19: areturn
    //   20: astore_2
    //   21: goto +16 -> 37
    //   24: astore_2
    //   25: new 37	java/lang/IllegalArgumentException
    //   28: astore_2
    //   29: aload_2
    //   30: ldc 39
    //   32: invokespecial 42	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: athrow
    //   37: aload_1
    //   38: invokevirtual 35	java/nio/charset/CharsetDecoder:reset	()Ljava/nio/charset/CharsetDecoder;
    //   41: pop
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	a
    //   0	44	1	paramr	r
    //   0	44	2	paramk0	k0
    // Exception table:
    //   from	to	target	type
    //   5	13	20	finally
    //   25	37	20	finally
    //   5	13	24	java/nio/charset/CharacterCodingException
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.n0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */