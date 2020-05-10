package e.c.a.a.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import d.b.a.s;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class a
{
  public static final Lock c = new ReentrantLock();
  @GuardedBy("sLk")
  public static a d;
  public final Lock a = new ReentrantLock();
  @GuardedBy("mLk")
  public final SharedPreferences b;
  
  public a(Context paramContext)
  {
    b = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static a a(Context paramContext)
  {
    s.a(paramContext);
    c.lock();
    try
    {
      if (d == null)
      {
        a locala = new e/c/a/a/a/a/a/a/a;
        locala.<init>(paramContext.getApplicationContext());
        d = locala;
      }
      paramContext = d;
      return paramContext;
    }
    finally
    {
      c.unlock();
    }
  }
  
  @Nullable
  public GoogleSignInAccount a()
  {
    String str = a("defaultGoogleSignInAccount");
    boolean bool = TextUtils.isEmpty(str);
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = new StringBuilder(String.valueOf(str).length() + 20);
      ((StringBuilder)localObject2).append("googleSignInAccount");
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(str);
      str = a(((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
      if (str == null) {}
    }
    try
    {
      localObject2 = GoogleSignInAccount.a(str);
      return (GoogleSignInAccount)localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
  }
  
  @Nullable
  public final String a(String paramString)
  {
    a.lock();
    try
    {
      paramString = b.getString(paramString, null);
      return paramString;
    }
    finally
    {
      a.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.a.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */