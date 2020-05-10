package l.a.a.b.d.a;

import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class h
  extends b
{
  public final EnumSet<a> b;
  
  public h(a... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {
      b = EnumSet.copyOf(Arrays.asList(paramVarArgs));
    } else {
      b = EnumSet.copyOf(Arrays.asList(new a[] { a.semiColonRequired }));
    }
  }
  
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
  {
    int i = paramCharSequence.length();
    int j;
    int k;
    if ((paramCharSequence.charAt(paramInt) == '&') && (paramInt < i - 2) && (paramCharSequence.charAt(paramInt + 1) == '#'))
    {
      paramInt += 2;
      j = paramCharSequence.charAt(paramInt);
      if ((j != 120) && (j != 88))
      {
        j = 0;
      }
      else
      {
        paramInt++;
        if (paramInt == i) {
          return 0;
        }
        j = 1;
      }
      for (k = paramInt; (k < i) && (((paramCharSequence.charAt(k) >= '0') && (paramCharSequence.charAt(k) <= '9')) || ((paramCharSequence.charAt(k) >= 'a') && (paramCharSequence.charAt(k) <= 'f')) || ((paramCharSequence.charAt(k) >= 'A') && (paramCharSequence.charAt(k) <= 'F'))); k++) {}
      if ((k != i) && (paramCharSequence.charAt(k) == ';')) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        a locala = a.semiColonRequired;
        EnumSet localEnumSet = b;
        boolean bool;
        if (localEnumSet == null) {
          bool = false;
        } else {
          bool = localEnumSet.contains(locala);
        }
        if (bool) {
          return 0;
        }
        locala = a.errorIfNoSemiColon;
        localEnumSet = b;
        if (localEnumSet == null) {
          bool = false;
        } else {
          bool = localEnumSet.contains(locala);
        }
        if (bool) {
          throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
        }
      }
      if (j == 0) {}
    }
    try
    {
      int m = Integer.parseInt(paramCharSequence.subSequence(paramInt, k).toString(), 16);
      break label356;
      m = Integer.parseInt(paramCharSequence.subSequence(paramInt, k).toString(), 10);
      label356:
      if (m > 65535)
      {
        paramCharSequence = Character.toChars(m);
        paramWriter.write(paramCharSequence[0]);
        paramWriter.write(paramCharSequence[1]);
      }
      else
      {
        paramWriter.write(m);
      }
      return k + 2 - paramInt + j + i;
    }
    catch (NumberFormatException paramCharSequence)
    {
      for (;;) {}
    }
    return 0;
  }
  
  public static enum a
  {
    static
    {
      semiColonOptional = new a("semiColonOptional", 1);
      a locala = new a("errorIfNoSemiColon", 2);
      errorIfNoSemiColon = locala;
      $VALUES = new a[] { semiColonRequired, semiColonOptional, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.d.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */