package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import d.b.a.r;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount
  extends e.c.a.a.b.j.s.a
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e.c.a.a.a.a.a.b();
  public static e.c.a.a.b.l.a K = e.c.a.a.b.l.b.a;
  public String A;
  public String B;
  public Uri C;
  public String D;
  public long E;
  public String F;
  public List<Scope> G;
  public String H;
  public String I;
  public Set<Scope> J = new HashSet();
  public final int x;
  public String y;
  public String z;
  
  public GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    x = paramInt;
    y = paramString1;
    z = paramString2;
    A = paramString3;
    B = paramString4;
    C = paramUri;
    D = paramString5;
    E = paramLong;
    F = paramString6;
    G = paramList;
    H = paramString7;
    I = paramString8;
  }
  
  public static GoogleSignInAccount a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = Uri.parse(paramString);
    } else {
      paramString = null;
    }
    long l = Long.parseLong(localJSONObject.getString("expirationTime"));
    HashSet localHashSet = new HashSet();
    Object localObject = localJSONObject.getJSONArray("grantedScopes");
    int i = ((JSONArray)localObject).length();
    for (int j = 0; j < i; j++) {
      localHashSet.add(new Scope(1, ((JSONArray)localObject).getString(j)));
    }
    String str1 = localJSONObject.optString("id");
    String str2 = localJSONObject.optString("tokenId", null);
    String str3 = localJSONObject.optString("email", null);
    String str4 = localJSONObject.optString("displayName", null);
    String str5 = localJSONObject.optString("givenName", null);
    String str6 = localJSONObject.optString("familyName", null);
    Long localLong = Long.valueOf(l);
    String str7 = localJSONObject.getString("obfuscatedIdentifier");
    localObject = localLong;
    if (localLong == null) {
      if ((e.c.a.a.b.l.b)K != null) {
        localObject = Long.valueOf(System.currentTimeMillis() / 1000L);
      } else {
        throw null;
      }
    }
    l = ((Long)localObject).longValue();
    r.a(str7);
    r.a(localHashSet);
    paramString = new GoogleSignInAccount(3, str1, str2, str3, str4, paramString, null, l, str7, new ArrayList(localHashSet), str5, str6);
    D = localJSONObject.optString("serverAuthCode", null);
    return paramString;
  }
  
  public Set<Scope> b()
  {
    HashSet localHashSet = new HashSet(G);
    localHashSet.addAll(J);
    return localHashSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    paramObject = (GoogleSignInAccount)paramObject;
    if (F.equals(F))
    {
      paramObject = ((GoogleSignInAccount)paramObject).b();
      Set localSet = b();
      if (((AbstractSet)paramObject).equals(localSet)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = F.hashCode();
    return ((AbstractSet)b()).hashCode() + (i + 527) * 31;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = r.a(paramParcel);
    r.a(paramParcel, 1, x);
    r.a(paramParcel, 2, y, false);
    r.a(paramParcel, 3, z, false);
    r.a(paramParcel, 4, A, false);
    r.a(paramParcel, 5, B, false);
    r.a(paramParcel, 6, C, paramInt, false);
    r.a(paramParcel, 7, D, false);
    r.a(paramParcel, 8, E);
    r.a(paramParcel, 9, F, false);
    r.a(paramParcel, 10, G, false);
    r.a(paramParcel, 11, H, false);
    r.a(paramParcel, 12, I, false);
    r.k(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */