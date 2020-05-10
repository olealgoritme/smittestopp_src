package d.z;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import d.f.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  public final d.f.a<String, Method> a;
  public final d.f.a<String, Method> b;
  public final d.f.a<String, Class> c;
  
  public a(d.f.a<String, Method> parama1, d.f.a<String, Method> parama2, d.f.a<String, Class> parama)
  {
    a = parama1;
    b = parama2;
    c = parama;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (!a(paramInt2)) {
      return paramInt1;
    }
    return e.readInt();
  }
  
  public <T extends Parcelable> T a(T paramT, int paramInt)
  {
    if (!a(paramInt)) {
      return paramT;
    }
    return e.readParcelable(b.class.getClassLoader());
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if (!a(paramInt)) {
      return paramCharSequence;
    }
    paramCharSequence = (b)this;
    return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(e);
  }
  
  public final Class a(Class<? extends c> paramClass)
  {
    Class localClass1 = (Class)c.getOrDefault(paramClass.getName(), null);
    Class localClass2 = localClass1;
    if (localClass1 == null)
    {
      localClass2 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      c.put(paramClass.getName(), localClass2);
    }
    return localClass2;
  }
  
  public final Method a(String paramString)
  {
    Method localMethod1 = (Method)a.getOrDefault(paramString, null);
    Method localMethod2 = localMethod1;
    if (localMethod1 == null)
    {
      System.currentTimeMillis();
      localMethod2 = Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class });
      a.put(paramString, localMethod2);
    }
    return localMethod2;
  }
  
  public abstract void a();
  
  /* Error */
  public void a(c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +15 -> 16
    //   4: aload_0
    //   5: checkcast 30	d/z/b
    //   8: getfield 34	d/z/b:e	Landroid/os/Parcel;
    //   11: aconst_null
    //   12: invokevirtual 132	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: invokevirtual 138	d/z/a:a	(Ljava/lang/Class;)Ljava/lang/Class;
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 72	java/lang/Class:getName	()Ljava/lang/String;
    //   29: astore_2
    //   30: aload_0
    //   31: checkcast 30	d/z/b
    //   34: getfield 34	d/z/b:e	Landroid/os/Parcel;
    //   37: aload_2
    //   38: invokevirtual 132	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: invokevirtual 141	d/z/a:b	()Ld/z/a;
    //   45: astore_2
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   51: invokevirtual 144	d/z/a:b	(Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: aconst_null
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_2
    //   66: aastore
    //   67: invokevirtual 148	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: aload_2
    //   72: invokevirtual 150	d/z/a:a	()V
    //   75: return
    //   76: astore_1
    //   77: new 152	java/lang/RuntimeException
    //   80: dup
    //   81: ldc -102
    //   83: aload_1
    //   84: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: astore_1
    //   89: new 152	java/lang/RuntimeException
    //   92: dup
    //   93: ldc -97
    //   95: aload_1
    //   96: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 163	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   105: instanceof 152
    //   108: ifeq +11 -> 119
    //   111: aload_1
    //   112: invokevirtual 163	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   115: checkcast 152	java/lang/RuntimeException
    //   118: athrow
    //   119: new 152	java/lang/RuntimeException
    //   122: dup
    //   123: ldc -91
    //   125: aload_1
    //   126: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore_1
    //   131: new 152	java/lang/RuntimeException
    //   134: dup
    //   135: ldc -89
    //   137: aload_1
    //   138: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: athrow
    //   142: astore_2
    //   143: new 169	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   150: astore_3
    //   151: aload_3
    //   152: aload_1
    //   153: invokevirtual 136	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 90	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   159: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_3
    //   164: ldc -80
    //   166: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: new 152	java/lang/RuntimeException
    //   173: dup
    //   174: aload_3
    //   175: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: aload_2
    //   179: invokespecial 157	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	a
    //   0	183	1	paramc	c
    //   24	48	2	localObject	Object
    //   142	37	2	localClassNotFoundException	ClassNotFoundException
    //   150	25	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	71	76	java/lang/ClassNotFoundException
    //   46	71	88	java/lang/NoSuchMethodException
    //   46	71	100	java/lang/reflect/InvocationTargetException
    //   46	71	130	java/lang/IllegalAccessException
    //   16	25	142	java/lang/ClassNotFoundException
  }
  
  public abstract boolean a(int paramInt);
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (!a(paramInt)) {
      return paramBoolean;
    }
    if (e.readInt() != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public abstract a b();
  
  public final Method b(Class paramClass)
  {
    Method localMethod = (Method)b.getOrDefault(paramClass.getName(), null);
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = a(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, a.class });
      b.put(paramClass.getName(), localObject);
    }
    return (Method)localObject;
  }
  
  public abstract void b(int paramInt);
  
  public void b(int paramInt1, int paramInt2)
  {
    b(paramInt2);
    e.writeInt(paramInt1);
  }
  
  public void b(Parcelable paramParcelable, int paramInt)
  {
    b(paramInt);
    e.writeParcelable(paramParcelable, 0);
  }
  
  public <T extends c> T c()
  {
    Object localObject = e.readString();
    if (localObject == null) {
      return null;
    }
    a locala = b();
    try
    {
      localObject = (c)a((String)localObject).invoke(null, new Object[] { locala });
      return (T)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", localClassNotFoundException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if ((localInvocationTargetException.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)localInvocationTargetException.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", localIllegalAccessException);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.z.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */