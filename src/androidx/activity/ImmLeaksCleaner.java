package androidx.activity;

import android.app.Activity;
import d.o.j;
import java.lang.reflect.Field;

public final class ImmLeaksCleaner
  implements j
{
  public static Field A;
  public static Field B;
  public static int y;
  public static Field z;
  public Activity x;
  
  public ImmLeaksCleaner(Activity paramActivity)
  {
    x = paramActivity;
  }
  
  /* Error */
  public void a(d.o.l paraml, d.o.g.a parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 36	d/o/g$a:ON_DESTROY	Ld/o/g$a;
    //   4: if_acmpeq +4 -> 8
    //   7: return
    //   8: getstatic 38	androidx/activity/ImmLeaksCleaner:y	I
    //   11: ifne +66 -> 77
    //   14: iconst_2
    //   15: putstatic 38	androidx/activity/ImmLeaksCleaner:y	I
    //   18: ldc 40
    //   20: ldc 42
    //   22: invokevirtual 48	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   25: astore_1
    //   26: aload_1
    //   27: putstatic 50	androidx/activity/ImmLeaksCleaner:A	Ljava/lang/reflect/Field;
    //   30: aload_1
    //   31: iconst_1
    //   32: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   35: ldc 40
    //   37: ldc 58
    //   39: invokevirtual 48	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   42: astore_1
    //   43: aload_1
    //   44: putstatic 60	androidx/activity/ImmLeaksCleaner:B	Ljava/lang/reflect/Field;
    //   47: aload_1
    //   48: iconst_1
    //   49: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   52: ldc 40
    //   54: ldc 62
    //   56: invokevirtual 48	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   59: astore_1
    //   60: aload_1
    //   61: putstatic 64	androidx/activity/ImmLeaksCleaner:z	Ljava/lang/reflect/Field;
    //   64: aload_1
    //   65: iconst_1
    //   66: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   69: iconst_1
    //   70: putstatic 38	androidx/activity/ImmLeaksCleaner:y	I
    //   73: goto +4 -> 77
    //   76: astore_1
    //   77: getstatic 38	androidx/activity/ImmLeaksCleaner:y	I
    //   80: iconst_1
    //   81: if_icmpne +97 -> 178
    //   84: aload_0
    //   85: getfield 21	androidx/activity/ImmLeaksCleaner:x	Landroid/app/Activity;
    //   88: ldc 66
    //   90: invokevirtual 72	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   93: checkcast 40	android/view/inputmethod/InputMethodManager
    //   96: astore_2
    //   97: getstatic 64	androidx/activity/ImmLeaksCleaner:z	Ljava/lang/reflect/Field;
    //   100: aload_2
    //   101: invokevirtual 76	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnonnull +4 -> 110
    //   109: return
    //   110: aload_1
    //   111: monitorenter
    //   112: getstatic 50	androidx/activity/ImmLeaksCleaner:A	Ljava/lang/reflect/Field;
    //   115: aload_2
    //   116: invokevirtual 76	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 78	android/view/View
    //   122: astore_3
    //   123: aload_3
    //   124: ifnonnull +6 -> 130
    //   127: aload_1
    //   128: monitorexit
    //   129: return
    //   130: aload_3
    //   131: invokevirtual 82	android/view/View:isAttachedToWindow	()Z
    //   134: ifeq +6 -> 140
    //   137: aload_1
    //   138: monitorexit
    //   139: return
    //   140: getstatic 60	androidx/activity/ImmLeaksCleaner:B	Ljava/lang/reflect/Field;
    //   143: aload_2
    //   144: aconst_null
    //   145: invokevirtual 86	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   148: aload_1
    //   149: monitorexit
    //   150: aload_2
    //   151: invokevirtual 89	android/view/inputmethod/InputMethodManager:isActive	()Z
    //   154: pop
    //   155: goto +23 -> 178
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: return
    //   162: astore_2
    //   163: goto +11 -> 174
    //   166: astore_2
    //   167: aload_1
    //   168: monitorexit
    //   169: return
    //   170: astore_2
    //   171: aload_1
    //   172: monitorexit
    //   173: return
    //   174: aload_1
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: return
    //   179: astore_1
    //   180: goto -2 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ImmLeaksCleaner
    //   0	183	1	paraml	d.o.l
    //   0	183	2	parama	d.o.g.a
    //   122	9	3	localView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   14	73	76	java/lang/NoSuchFieldException
    //   140	148	158	java/lang/IllegalAccessException
    //   112	123	162	finally
    //   127	129	162	finally
    //   130	139	162	finally
    //   140	148	162	finally
    //   148	150	162	finally
    //   159	161	162	finally
    //   167	169	162	finally
    //   171	173	162	finally
    //   174	176	162	finally
    //   112	123	166	java/lang/ClassCastException
    //   112	123	170	java/lang/IllegalAccessException
    //   97	105	179	java/lang/IllegalAccessException
  }
}

/* Location:
 * Qualified Name:     base.androidx.activity.ImmLeaksCleaner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */