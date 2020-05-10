package j.a.b;

public class j
{
  public static final d a = new d(null);
  public static final e b = new e(null);
  public static final c c = new c(null);
  public static final b d = new b(null);
  public static final a e = new a(null);
  
  public static boolean a(char paramChar)
  {
    return (paramChar == '{') || (paramChar == '[') || (paramChar == ',') || (paramChar == '}') || (paramChar == ']') || (paramChar == ':') || (paramChar == '\'') || (paramChar == '"');
  }
  
  public static boolean a(String paramString)
  {
    if (paramString.length() < 3) {
      return false;
    }
    int i = paramString.charAt(0);
    if (i == 110) {
      return paramString.equals("null");
    }
    if (i == 116) {
      return paramString.equals("true");
    }
    if (i == 102) {
      return paramString.equals("false");
    }
    if (i == 78) {
      return paramString.equals("NaN");
    }
    return false;
  }
  
  public static boolean b(char paramChar)
  {
    return ((paramChar >= 0) && (paramChar <= '\037')) || ((paramChar >= '') && (paramChar <= '')) || ((paramChar >= ' ') && (paramChar <= '⃿'));
  }
  
  public static class a
    implements j.g
  {
    /* Error */
    public void a(String paramString, Appendable paramAppendable)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 24	java/lang/String:length	()I
      //   4: istore_3
      //   5: iconst_0
      //   6: istore 4
      //   8: iload 4
      //   10: iload_3
      //   11: if_icmplt +4 -> 15
      //   14: return
      //   15: aload_1
      //   16: iload 4
      //   18: invokevirtual 28	java/lang/String:charAt	(I)C
      //   21: istore 5
      //   23: iload 5
      //   25: bipush 12
      //   27: if_icmpeq +290 -> 317
      //   30: iload 5
      //   32: bipush 13
      //   34: if_icmpeq +271 -> 305
      //   37: iload 5
      //   39: bipush 34
      //   41: if_icmpeq +252 -> 293
      //   44: iload 5
      //   46: bipush 47
      //   48: if_icmpeq +233 -> 281
      //   51: iload 5
      //   53: bipush 92
      //   55: if_icmpeq +214 -> 269
      //   58: iload 5
      //   60: tableswitch	default:+28->88, 8:+197->257, 9:+185->245, 10:+173->233
      //   88: iload 5
      //   90: iflt +10 -> 100
      //   93: iload 5
      //   95: bipush 31
      //   97: if_icmple +34 -> 131
      //   100: iload 5
      //   102: bipush 127
      //   104: if_icmplt +11 -> 115
      //   107: iload 5
      //   109: sipush 159
      //   112: if_icmple +19 -> 131
      //   115: iload 5
      //   117: sipush 8192
      //   120: if_icmplt +101 -> 221
      //   123: iload 5
      //   125: sipush 8447
      //   128: if_icmpgt +93 -> 221
      //   131: aload_2
      //   132: ldc 30
      //   134: invokeinterface 36 2 0
      //   139: pop
      //   140: aload_2
      //   141: ldc 38
      //   143: iload 5
      //   145: bipush 12
      //   147: ishr
      //   148: bipush 15
      //   150: iand
      //   151: invokevirtual 28	java/lang/String:charAt	(I)C
      //   154: invokeinterface 41 2 0
      //   159: pop
      //   160: aload_2
      //   161: ldc 38
      //   163: iload 5
      //   165: bipush 8
      //   167: ishr
      //   168: bipush 15
      //   170: iand
      //   171: invokevirtual 28	java/lang/String:charAt	(I)C
      //   174: invokeinterface 41 2 0
      //   179: pop
      //   180: aload_2
      //   181: ldc 38
      //   183: iload 5
      //   185: iconst_4
      //   186: ishr
      //   187: bipush 15
      //   189: iand
      //   190: invokevirtual 28	java/lang/String:charAt	(I)C
      //   193: invokeinterface 41 2 0
      //   198: pop
      //   199: aload_2
      //   200: ldc 38
      //   202: iload 5
      //   204: iconst_0
      //   205: ishr
      //   206: bipush 15
      //   208: iand
      //   209: invokevirtual 28	java/lang/String:charAt	(I)C
      //   212: invokeinterface 41 2 0
      //   217: pop
      //   218: goto +108 -> 326
      //   221: aload_2
      //   222: iload 5
      //   224: invokeinterface 41 2 0
      //   229: pop
      //   230: goto +96 -> 326
      //   233: aload_2
      //   234: ldc 43
      //   236: invokeinterface 36 2 0
      //   241: pop
      //   242: goto +84 -> 326
      //   245: aload_2
      //   246: ldc 45
      //   248: invokeinterface 36 2 0
      //   253: pop
      //   254: goto +72 -> 326
      //   257: aload_2
      //   258: ldc 47
      //   260: invokeinterface 36 2 0
      //   265: pop
      //   266: goto +60 -> 326
      //   269: aload_2
      //   270: ldc 49
      //   272: invokeinterface 36 2 0
      //   277: pop
      //   278: goto +48 -> 326
      //   281: aload_2
      //   282: ldc 51
      //   284: invokeinterface 36 2 0
      //   289: pop
      //   290: goto +36 -> 326
      //   293: aload_2
      //   294: ldc 53
      //   296: invokeinterface 36 2 0
      //   301: pop
      //   302: goto +24 -> 326
      //   305: aload_2
      //   306: ldc 55
      //   308: invokeinterface 36 2 0
      //   313: pop
      //   314: goto +12 -> 326
      //   317: aload_2
      //   318: ldc 57
      //   320: invokeinterface 36 2 0
      //   325: pop
      //   326: iinc 4 1
      //   329: goto -321 -> 8
      //   332: astore_1
      //   333: new 59	java/lang/RuntimeException
      //   336: dup
      //   337: ldc 61
      //   339: invokespecial 64	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   342: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	343	0	this	a
      //   0	343	1	paramString	String
      //   0	343	2	paramAppendable	Appendable
      //   4	8	3	i	int
      //   6	321	4	j	int
      //   21	202	5	c	char
      // Exception table:
      //   from	to	target	type
      //   0	5	332	java/io/IOException
      //   15	23	332	java/io/IOException
      //   131	218	332	java/io/IOException
      //   221	230	332	java/io/IOException
      //   233	242	332	java/io/IOException
      //   245	254	332	java/io/IOException
      //   257	266	332	java/io/IOException
      //   269	278	332	java/io/IOException
      //   281	290	332	java/io/IOException
      //   293	302	332	java/io/IOException
      //   305	314	332	java/io/IOException
      //   317	326	332	java/io/IOException
    }
  }
  
  public static class b
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
  
  public static class c
    implements j.f
  {
    public boolean a(String paramString)
    {
      if (paramString == null) {
        return false;
      }
      int i = paramString.length();
      if (i == 0) {
        return true;
      }
      if (paramString.trim() != paramString) {
        return true;
      }
      char c = paramString.charAt(0);
      if ((!j.a(c)) && (!j.b(c))) {
        for (int j = 1;; j++)
        {
          int m;
          if (j >= i)
          {
            if (j.a(paramString)) {
              return true;
            }
            int k = paramString.charAt(0);
            if (((k >= 48) && (k <= 57)) || (k == 45))
            {
              m = 1;
              while (m < i)
              {
                j = paramString.charAt(m);
                k = j;
                if (j < 48) {
                  break;
                }
                if (j > 57)
                {
                  k = j;
                  break;
                }
                m++;
                k = j;
              }
              if (m == i) {
                return true;
              }
              int n = k;
              j = m;
              if (k == 46) {}
              do
              {
                j = m + 1;
                n = k;
                if (j >= i)
                {
                  k = n;
                  break;
                }
                n = paramString.charAt(j);
                k = n;
                if (n < 48) {
                  break;
                }
                k = n;
                m = j;
              } while (n <= 57);
              k = n;
              if (j == i) {
                return true;
              }
              if (k != 69)
              {
                m = j;
                if (k != 101) {}
              }
              else
              {
                j++;
                if (j == i) {
                  return false;
                }
                k = paramString.charAt(j);
                if (k != 43)
                {
                  m = j;
                  if (k != 45) {}
                }
                else
                {
                  m = j + 1;
                  paramString.charAt(m);
                }
              }
              j = m;
              if (m == i) {
                return false;
              }
              while (j < i)
              {
                m = paramString.charAt(j);
                if ((m < 48) || (m > 57)) {
                  break;
                }
                j++;
              }
              if (j == i) {
                return true;
              }
            }
            return false;
          }
          c = paramString.charAt(j);
          if ((c != '}') && (c != ']') && (c != ',') && (c != ':')) {
            m = 0;
          } else {
            m = 1;
          }
          if ((m != 0) || (j.b(c))) {
            break;
          }
        }
      }
      return true;
    }
  }
  
  public static class d
    implements j.f
  {
    public boolean a(String paramString)
    {
      if (paramString == null) {
        return false;
      }
      int i = paramString.length();
      if (i == 0) {
        return true;
      }
      if (paramString.trim() != paramString) {
        return true;
      }
      int j = paramString.charAt(0);
      if (((j >= 48) && (j <= 57)) || (j == 45)) {
        return true;
      }
      for (j = 0;; j++)
      {
        if (j >= i) {
          return j.a(paramString);
        }
        char c = paramString.charAt(j);
        int k;
        if ((c != '\r') && (c != '\n') && (c != '\t') && (c != ' ')) {
          k = 0;
        } else {
          k = 1;
        }
        if (k != 0) {
          return true;
        }
        if (j.a(c)) {
          return true;
        }
        if ((c != '\b') && (c != '\f') && (c != '\n')) {
          k = 0;
        } else {
          k = 1;
        }
        if (k != 0) {
          return true;
        }
        if (j.b(c)) {
          return true;
        }
      }
    }
  }
  
  public static class e
    implements j.f
  {
    public boolean a(String paramString)
    {
      return true;
    }
  }
  
  public static abstract interface f
  {
    public abstract boolean a(String paramString);
  }
  
  public static abstract interface g
  {
    public abstract void a(String paramString, Appendable paramAppendable);
  }
}

/* Location:
 * Qualified Name:     j.a.b.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */