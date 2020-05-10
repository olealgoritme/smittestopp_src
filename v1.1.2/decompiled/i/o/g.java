package i.o;

import i.l.a;
import java.util.Collection;
import java.util.Iterator;

public class g
  extends f
{
  public static final int a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return paramCharSequence.length() - 1;
    }
    i.k.b.g.a("$this$lastIndex");
    throw null;
  }
  
  public static final int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    Object localObject;
    if (!paramBoolean2)
    {
      i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      j = paramCharSequence1.length();
      paramInt1 = paramInt2;
      if (paramInt2 > j) {
        paramInt1 = j;
      }
      localObject = new i.l.c(i, paramInt1);
    }
    else
    {
      j = a(paramCharSequence1);
      i = paramInt1;
      if (paramInt1 > j) {
        i = j;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      localObject = new a(i, paramInt1, -1);
    }
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      paramInt1 = x;
      paramInt2 = y;
      i = z;
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (a((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    else
    {
      paramInt1 = x;
      i = y;
      paramInt2 = z;
      if (paramInt2 >= 0 ? paramInt1 <= i : paramInt1 >= i) {
        for (;;)
        {
          if (a(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == i) {
            break;
          }
          paramInt1 += paramInt2;
        }
      }
    }
    return -1;
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramCharSequence != null)
    {
      if (paramString != null)
      {
        if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
          paramInt = ((String)paramCharSequence).indexOf(paramString, paramInt);
        } else {
          paramInt = a(paramCharSequence, paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16);
        }
        return paramInt;
      }
      i.k.b.g.a("string");
      throw null;
    }
    i.k.b.g.a("$this$indexOf");
    throw null;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramCharSequence1 != null)
    {
      if (paramCharSequence2 != null)
      {
        if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 <= paramCharSequence1.length() - paramInt3) && (paramInt2 <= paramCharSequence2.length() - paramInt3))
        {
          for (int i = 0; i < paramInt3; i++) {
            if (!e.c.a.a.b.l.c.a(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
              return false;
            }
          }
          return true;
        }
        return false;
      }
      i.k.b.g.a("other");
      throw null;
    }
    i.k.b.g.a("$this$regionMatchesImpl");
    throw null;
  }
  
  public static final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        if (!paramBoolean) {
          paramBoolean = paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
        } else {
          paramBoolean = paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
        }
        return paramBoolean;
      }
      i.k.b.g.a("other");
      throw null;
    }
    i.k.b.g.a("$this$regionMatches");
    throw null;
  }
  
  public static final boolean b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      int i = paramCharSequence.length();
      boolean bool = false;
      if (i != 0)
      {
        Object localObject = new i.l.c(0, paramCharSequence.length() - 1);
        if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
        do
        {
          while (!((Iterator)localObject).hasNext())
          {
            i = 1;
            break;
            localObject = ((Iterable)localObject).iterator();
          }
          char c = paramCharSequence.charAt(((i.i.g)localObject).a());
          if ((!Character.isWhitespace(c)) && (!Character.isSpaceChar(c))) {
            i = 0;
          } else {
            i = 1;
          }
        } while (i != 0);
        i = 0;
        if (i == 0) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    i.k.b.g.a("$this$isBlank");
    throw null;
  }
}

/* Location:
 * Qualified Name:     i.o.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */