package d.i.c;

import android.graphics.Path;
import android.util.Log;
import d.b.a.r;

public class b
{
  public char a;
  public float[] b;
  
  public b(char paramChar, float[] paramArrayOfFloat)
  {
    a = ((char)paramChar);
    b = paramArrayOfFloat;
  }
  
  public b(b paramb)
  {
    a = ((char)a);
    paramb = b;
    b = r.a(paramb, 0, paramb.length);
  }
  
  public static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d1 = Math.toRadians(paramFloat7);
    double d2 = Math.cos(d1);
    double d3 = Math.sin(d1);
    double d4 = paramFloat1;
    double d5 = paramFloat2;
    double d6 = d4;
    double d7 = paramFloat5;
    d4 = (d5 * d3 + d4 * d2) / d7;
    double d8 = -paramFloat1;
    double d9 = paramFloat6;
    double d10 = (d5 * d2 + d8 * d3) / d9;
    double d11 = paramFloat3;
    d8 = paramFloat4;
    double d12 = (d8 * d3 + d11 * d2) / d7;
    double d13 = (d8 * d2 + -paramFloat3 * d3) / d9;
    double d14 = d4 - d12;
    double d15 = d10 - d13;
    d11 = (d4 + d12) / 2.0D;
    d8 = (d10 + d13) / 2.0D;
    double d16 = d15 * d15 + d14 * d14;
    if (d16 == 0.0D)
    {
      Log.w("PathParser", " Points are coincident");
      return;
    }
    double d17 = 1.0D / d16 - 0.25D;
    if (d17 < 0.0D)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Points are too far apart ");
      localStringBuilder.append(d16);
      Log.w("PathParser", localStringBuilder.toString());
      float f = (float)(Math.sqrt(d16) / 1.99999D);
      a(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
      return;
    }
    d17 = Math.sqrt(d17);
    d14 *= d17;
    d15 = d17 * d15;
    if (paramBoolean1 == paramBoolean2)
    {
      d11 -= d15;
      d8 += d14;
    }
    else
    {
      d11 += d15;
      d8 -= d14;
    }
    d14 = Math.atan2(d10 - d8, d4 - d11);
    d10 = Math.atan2(d13 - d8, d12 - d11) - d14;
    int i = 0;
    boolean bool = d10 < 0.0D;
    if (!bool) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    d4 = d10;
    if (paramBoolean2 != paramBoolean1) {
      if (bool) {
        d4 = d10 - 6.283185307179586D;
      } else {
        d4 = d10 + 6.283185307179586D;
      }
    }
    double d18 = d11 * d7;
    double d19 = d8 * d9;
    d12 = d18 * d2 - d19 * d3;
    int j = (int)Math.ceil(Math.abs(d4 * 4.0D / 3.141592653589793D));
    d8 = Math.cos(d1);
    double d20 = Math.sin(d1);
    d10 = Math.cos(d14);
    d1 = Math.sin(d14);
    d13 = -d7;
    double d21 = d13 * d8;
    double d22 = d9 * d20;
    d11 = d21 * d1 - d22 * d10;
    d17 = d13 * d20;
    d13 = d9 * d8;
    d10 = d10 * d13 + d1 * d17;
    d15 = d4 / j;
    d1 = d5;
    d9 = d6;
    d4 = d7;
    d5 = d8;
    d8 = d17;
    d6 = d12;
    d7 = d13;
    d12 = d15;
    while (i < j)
    {
      d16 = d14 + d12;
      double d23 = Math.sin(d16);
      double d24 = Math.cos(d16);
      d15 = d4 * d5 * d24 + d6 - d22 * d23;
      d13 = d7 * d23 + (d4 * d20 * d24 + (d19 * d2 + d18 * d3));
      d17 = d21 * d23 - d22 * d24;
      d23 = d24 * d7 + d23 * d8;
      d24 = d16 - d14;
      d14 = Math.tan(d24 / 2.0D);
      d24 = Math.sin(d24);
      d14 = (Math.sqrt(d14 * 3.0D * d14 + 4.0D) - 1.0D) * d24 / 3.0D;
      paramPath.rLineTo(0.0F, 0.0F);
      paramPath.cubicTo((float)(d11 * d14 + d9), (float)(d10 * d14 + d1), (float)(d15 - d14 * d17), (float)(d13 - d14 * d23), (float)d15, (float)d13);
      i++;
      d14 = d16;
      d10 = d23;
      d11 = d17;
      d9 = d15;
      d1 = d13;
    }
  }
  
  public static void a(b[] paramArrayOfb, Path paramPath)
  {
    float[] arrayOfFloat = new float[6];
    int i = 109;
    int i1;
    for (int j = 0;; j = i1 + 1)
    {
      Object localObject1 = paramArrayOfb;
      if (j >= localObject1.length) {
        break;
      }
      int k = a;
      localObject1 = b;
      float f1 = arrayOfFloat[0];
      float f2 = arrayOfFloat[1];
      float f3 = arrayOfFloat[2];
      float f4 = arrayOfFloat[3];
      float f5 = arrayOfFloat[4];
      float f6 = arrayOfFloat[5];
      switch (k)
      {
      default: 
        break;
      case 90: 
      case 122: 
        paramPath.close();
        paramPath.moveTo(f5, f6);
        f1 = f5;
        f3 = f1;
        f2 = f6;
        f4 = f2;
        break;
      case 81: 
      case 83: 
      case 113: 
      case 115: 
        m = 4;
        break;
      case 72: 
      case 86: 
      case 104: 
      case 118: 
        m = 1;
        break;
      case 67: 
      case 99: 
        m = 6;
        break;
      case 65: 
      case 97: 
        m = 7;
        break;
      }
      int m = 2;
      float f7 = f2;
      int n = 0;
      i1 = j;
      f2 = f1;
      f1 = f7;
      j = n;
      while (j < localObject1.length)
      {
        float f8;
        float f9;
        int i3;
        label1015:
        label1241:
        label1488:
        label1511:
        boolean bool1;
        boolean bool2;
        Object localObject2;
        if (k != 65)
        {
          int i2;
          if (k != 67)
          {
            if (k != 72)
            {
              if (k != 81)
              {
                if (k != 86)
                {
                  if (k != 97)
                  {
                    if (k != 99)
                    {
                      if (k != 104)
                      {
                        if (k != 113)
                        {
                          if (k != 118)
                          {
                            if (k != 76)
                            {
                              if (k != 77)
                              {
                                if (k != 83)
                                {
                                  if (k != 84)
                                  {
                                    if (k != 108)
                                    {
                                      if (k != 109)
                                      {
                                        if (k != 115)
                                        {
                                          if (k != 116) {
                                            break label1511;
                                          }
                                          for (;;)
                                          {
                                            if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
                                            {
                                              f3 = 0.0F;
                                              f4 = 0.0F;
                                            }
                                            else
                                            {
                                              f3 = f2 - f3;
                                              f7 = f1 - f4;
                                              f4 = f3;
                                              f3 = f7;
                                            }
                                            i = j + 0;
                                            f7 = localObject1[i];
                                            n = j + 1;
                                            paramPath.rQuadTo(f4, f3, f7, localObject1[n]);
                                            f4 += f2;
                                            f2 += localObject1[i];
                                            f7 = f1 + localObject1[n];
                                            f1 = f3 + f1;
                                            f3 = f4;
                                            f4 = f1;
                                            f1 = f7;
                                          }
                                        }
                                        if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
                                        {
                                          f4 = 0.0F;
                                          f3 = 0.0F;
                                        }
                                        else
                                        {
                                          f7 = f1 - f4;
                                          f4 = f2 - f3;
                                          f3 = f7;
                                        }
                                        n = j + 0;
                                        f7 = localObject1[n];
                                        i = j + 1;
                                        f8 = localObject1[i];
                                        i2 = j + 2;
                                        f9 = localObject1[i2];
                                        i3 = j + 3;
                                        paramPath.rCubicTo(f4, f3, f7, f8, f9, localObject1[i3]);
                                        f4 = localObject1[n] + f2;
                                        f3 = localObject1[i] + f1;
                                        f2 += localObject1[i2];
                                        f7 = localObject1[i3];
                                        break label1488;
                                      }
                                      i = j;
                                      n = i + 0;
                                      f2 += localObject1[n];
                                      i3 = i + 1;
                                      f1 += localObject1[i3];
                                      if (i > 0)
                                      {
                                        paramPath.rLineTo(localObject1[n], localObject1[i3]);
                                        break label1511;
                                      }
                                      paramPath.rMoveTo(localObject1[n], localObject1[i3]);
                                    }
                                    else
                                    {
                                      i = j;
                                      n = i + 0;
                                      f7 = localObject1[n];
                                      i++;
                                      paramPath.rLineTo(f7, localObject1[i]);
                                      f2 += localObject1[n];
                                      f7 = localObject1[i];
                                      break label1241;
                                    }
                                  }
                                  else
                                  {
                                    n = j;
                                    if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
                                    {
                                      f3 = f2;
                                      f2 = f1;
                                      f1 = f3;
                                    }
                                    else
                                    {
                                      f2 = f2 * 2.0F - f3;
                                      f3 = f1 * 2.0F - f4;
                                      f1 = f2;
                                      f2 = f3;
                                    }
                                    i = n + 0;
                                    f3 = localObject1[i];
                                    n++;
                                    paramPath.quadTo(f1, f2, f3, localObject1[n]);
                                    f7 = localObject1[i];
                                    f8 = localObject1[n];
                                    f3 = f1;
                                    f4 = f2;
                                    f1 = f8;
                                    f2 = f7;
                                    break label2069;
                                  }
                                }
                                else
                                {
                                  n = j;
                                  if ((i != 99) && (i != 115) && (i != 67) && (i != 83)) {
                                    break label1015;
                                  }
                                  f1 = f1 * 2.0F - f4;
                                  f2 = f2 * 2.0F - f3;
                                  i2 = n + 0;
                                  f3 = localObject1[i2];
                                  i = n + 1;
                                  f7 = localObject1[i];
                                  i3 = n + 2;
                                  f4 = localObject1[i3];
                                  n += 3;
                                  paramPath.cubicTo(f2, f1, f3, f7, f4, localObject1[n]);
                                  f3 = localObject1[i2];
                                  f4 = localObject1[i];
                                  f2 = localObject1[i3];
                                  f1 = localObject1[n];
                                  break label1511;
                                }
                              }
                              else
                              {
                                i = j;
                                n = i + 0;
                                f2 = localObject1[n];
                                i3 = i + 1;
                                f1 = localObject1[i3];
                                if (i > 0)
                                {
                                  paramPath.lineTo(localObject1[n], localObject1[i3]);
                                  break label1511;
                                }
                                paramPath.moveTo(localObject1[n], localObject1[i3]);
                              }
                              f6 = f1;
                              f5 = f2;
                              break label1511;
                            }
                            else
                            {
                              i = j;
                              n = i + 0;
                              f1 = localObject1[n];
                              i++;
                              paramPath.lineTo(f1, localObject1[i]);
                              f2 = localObject1[n];
                              f1 = localObject1[i];
                              break label1511;
                            }
                          }
                          else
                          {
                            i = j + 0;
                            paramPath.rLineTo(0.0F, localObject1[i]);
                            f7 = localObject1[i];
                          }
                          f1 += f7;
                          break label1511;
                        }
                        else
                        {
                          i = j;
                          n = i + 0;
                          f7 = localObject1[n];
                          i3 = i + 1;
                          f3 = localObject1[i3];
                          i2 = i + 2;
                          f4 = localObject1[i2];
                          i += 3;
                          paramPath.rQuadTo(f7, f3, f4, localObject1[i]);
                          f4 = localObject1[n] + f2;
                          f3 = localObject1[i3] + f1;
                          f8 = localObject1[i2];
                          f7 = localObject1[i];
                          f2 += f8;
                        }
                      }
                      else
                      {
                        i = j + 0;
                        paramPath.rLineTo(localObject1[i], 0.0F);
                        f2 += localObject1[i];
                        break label1511;
                      }
                    }
                    else
                    {
                      i = j;
                      f8 = localObject1[(i + 0)];
                      f3 = localObject1[(i + 1)];
                      n = i + 2;
                      f7 = localObject1[n];
                      i2 = i + 3;
                      f4 = localObject1[i2];
                      i3 = i + 4;
                      f9 = localObject1[i3];
                      i += 5;
                      paramPath.rCubicTo(f8, f3, f7, f4, f9, localObject1[i]);
                      f4 = localObject1[n] + f2;
                      f3 = localObject1[i2] + f1;
                      f2 += localObject1[i3];
                      f7 = localObject1[i];
                    }
                    f7 = f1 + f7;
                    f1 = f4;
                    f4 = f3;
                    f3 = f1;
                    f1 = f7;
                    break label2069;
                  }
                  i = j;
                  i3 = i + 5;
                  f9 = localObject1[i3];
                  n = i + 6;
                  f4 = localObject1[n];
                  f8 = localObject1[(i + 0)];
                  f7 = localObject1[(i + 1)];
                  f3 = localObject1[(i + 2)];
                  if (localObject1[(i + 3)] != 0.0F) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                  if (localObject1[(i + 4)] != 0.0F) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  }
                  localObject2 = localObject1;
                  a(paramPath, f2, f1, f9 + f2, f4 + f1, f8, f7, f3, bool1, bool2);
                  f2 += localObject2[i3];
                  f1 += localObject2[n];
                  break label2061;
                }
                localObject2 = localObject1;
                i = j + 0;
                paramPath.lineTo(f2, localObject2[i]);
                f1 = localObject2[i];
                break label2069;
              }
              i = j;
              localObject2 = localObject1;
              i2 = i + 0;
              f1 = localObject2[i2];
              n = i + 1;
              f3 = localObject2[n];
              i3 = i + 2;
              f2 = localObject2[i3];
              i += 3;
              paramPath.quadTo(f1, f3, f2, localObject2[i]);
              f4 = localObject2[i2];
              f3 = localObject2[n];
              f2 = localObject2[i3];
              f1 = localObject2[i];
            }
            else
            {
              localObject2 = localObject1;
              i = j + 0;
              paramPath.lineTo(localObject2[i], f1);
              f2 = localObject2[i];
              break label2069;
            }
          }
          else
          {
            i = j;
            localObject2 = localObject1;
            f1 = localObject2[(i + 0)];
            f4 = localObject2[(i + 1)];
            n = i + 2;
            f3 = localObject2[n];
            i3 = i + 3;
            f7 = localObject2[i3];
            i2 = i + 4;
            f2 = localObject2[i2];
            i += 5;
            paramPath.cubicTo(f1, f4, f3, f7, f2, localObject2[i]);
            f2 = localObject2[i2];
            f1 = localObject2[i];
            f4 = localObject2[n];
            f3 = localObject2[i3];
          }
          f7 = f4;
          f4 = f3;
          f3 = f7;
          break label2069;
        }
        else
        {
          i = j;
          localObject2 = localObject1;
          i3 = i + 5;
          f8 = localObject2[i3];
          n = i + 6;
          f3 = localObject2[n];
          f9 = localObject2[(i + 0)];
          f7 = localObject2[(i + 1)];
          f4 = localObject2[(i + 2)];
          if (localObject2[(i + 3)] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (localObject2[(i + 4)] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          a(paramPath, f2, f1, f8, f3, f9, f7, f4, bool1, bool2);
          f2 = localObject2[i3];
          f1 = localObject2[n];
        }
        label2061:
        f4 = f1;
        f3 = f2;
        label2069:
        j += m;
        n = k;
        i = k;
        k = n;
      }
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f1;
      arrayOfFloat[2] = f3;
      arrayOfFloat[3] = f4;
      arrayOfFloat[4] = f5;
      arrayOfFloat[5] = f6;
      i = a;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */