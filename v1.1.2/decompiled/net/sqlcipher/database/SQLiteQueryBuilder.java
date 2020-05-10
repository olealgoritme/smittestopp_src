package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import e.a.a.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;

public class SQLiteQueryBuilder
{
  public static final String TAG = "SQLiteQueryBuilder";
  public static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  public boolean mDistinct = false;
  public SQLiteDatabase.CursorFactory mFactory = null;
  public Map<String, String> mProjectionMap = null;
  public boolean mStrictProjectionMap;
  public String mTables = "";
  public StringBuilder mWhereClause = null;
  
  public static void appendClause(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
  }
  
  public static void appendClauseEscapeClause(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      DatabaseUtils.appendEscapedSQLString(paramStringBuilder, paramString2);
    }
  }
  
  public static void appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (str != null)
      {
        if (j > 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(str);
      }
    }
    paramStringBuilder.append(' ');
  }
  
  public static String buildQueryString(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!sLimitPattern.matcher(paramString6).matches())) {
      throw new IllegalArgumentException(a.b("invalid LIMIT clauses:", paramString6));
    }
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("SELECT ");
    if (paramBoolean) {
      localStringBuilder.append("DISTINCT ");
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      appendColumns(localStringBuilder, paramArrayOfString);
    } else {
      localStringBuilder.append("* ");
    }
    localStringBuilder.append("FROM ");
    localStringBuilder.append(paramString1);
    appendClause(localStringBuilder, " WHERE ", paramString2);
    appendClause(localStringBuilder, " GROUP BY ", paramString3);
    appendClause(localStringBuilder, " HAVING ", paramString4);
    appendClause(localStringBuilder, " ORDER BY ", paramString5);
    appendClause(localStringBuilder, " LIMIT ", paramString6);
    return localStringBuilder.toString();
  }
  
  private String[] computeProjection(String[] paramArrayOfString)
  {
    int i = 0;
    int j = 0;
    Object localObject1;
    Object localObject2;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (mProjectionMap != null)
      {
        String[] arrayOfString = new String[paramArrayOfString.length];
        i = paramArrayOfString.length;
        while (j < i)
        {
          localObject1 = paramArrayOfString[j];
          localObject2 = (String)mProjectionMap.get(localObject1);
          if (localObject2 != null)
          {
            arrayOfString[j] = localObject2;
          }
          else
          {
            if ((mStrictProjectionMap) || ((!((String)localObject1).contains(" AS ")) && (!((String)localObject1).contains(" as ")))) {
              break label109;
            }
            arrayOfString[j] = localObject1;
          }
          j++;
          continue;
          label109:
          localObject2 = a.a("Invalid column ");
          ((StringBuilder)localObject2).append(paramArrayOfString[j]);
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        }
        return arrayOfString;
      }
      return paramArrayOfString;
    }
    paramArrayOfString = mProjectionMap;
    if (paramArrayOfString != null)
    {
      localObject2 = paramArrayOfString.entrySet();
      paramArrayOfString = new String[((Set)localObject2).size()];
      localObject2 = ((Set)localObject2).iterator();
      j = i;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        if (!((String)((Map.Entry)localObject1).getKey()).equals("_count"))
        {
          paramArrayOfString[j] = ((String)((Map.Entry)localObject1).getValue());
          j++;
        }
      }
      return paramArrayOfString;
    }
    return null;
  }
  
  public void appendWhere(CharSequence paramCharSequence)
  {
    if (mWhereClause == null) {
      mWhereClause = new StringBuilder(paramCharSequence.length() + 16);
    }
    if (mWhereClause.length() == 0) {
      mWhereClause.append('(');
    }
    mWhereClause.append(paramCharSequence);
  }
  
  public void appendWhereEscapeString(String paramString)
  {
    if (mWhereClause == null) {
      mWhereClause = new StringBuilder(paramString.length() + 16);
    }
    if (mWhereClause.length() == 0) {
      mWhereClause.append('(');
    }
    DatabaseUtils.appendEscapedSQLString(mWhereClause, paramString);
  }
  
  public String buildQuery(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramArrayOfString1 = computeProjection(paramArrayOfString1);
    paramArrayOfString2 = new StringBuilder();
    StringBuilder localStringBuilder = mWhereClause;
    int i;
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramArrayOfString2.append(mWhereClause.toString());
      paramArrayOfString2.append(')');
    }
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      if (i != 0) {
        paramArrayOfString2.append(" AND ");
      }
      paramArrayOfString2.append('(');
      paramArrayOfString2.append(paramString1);
      paramArrayOfString2.append(')');
    }
    return buildQueryString(mDistinct, mTables, paramArrayOfString1, paramArrayOfString2.toString(), paramString2, paramString3, paramString4, paramString5);
  }
  
  public String buildUnionQuery(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = paramArrayOfString.length;
    String str;
    if (mDistinct) {
      str = " UNION ";
    } else {
      str = " UNION ALL ";
    }
    for (int j = 0; j < i; j++)
    {
      if (j > 0) {
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramArrayOfString[j]);
    }
    appendClause(localStringBuilder, " ORDER BY ", paramString1);
    appendClause(localStringBuilder, " LIMIT ", paramString2);
    return localStringBuilder.toString();
  }
  
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString1, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString2, String paramString4, String paramString5)
  {
    int i = paramArrayOfString1.length;
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramArrayOfString1[j];
      if (((String)localObject).equals(paramString1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("'");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("' AS ");
        ((StringBuilder)localObject).append(paramString1);
        arrayOfString[j] = ((StringBuilder)localObject).toString();
      }
      else if ((j > paramInt) && (!paramSet.contains(localObject)))
      {
        arrayOfString[j] = a.b("NULL AS ", (String)localObject);
      }
      else
      {
        arrayOfString[j] = localObject;
      }
    }
    return buildQuery(arrayOfString, paramString3, paramArrayOfString2, paramString4, paramString5, null, null);
  }
  
  public String getTables()
  {
    return mTables;
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    return query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, null);
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (mTables == null) {
      return null;
    }
    paramArrayOfString1 = buildQuery(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5);
    if (Log.isLoggable("SQLiteQueryBuilder", 3))
    {
      paramString1 = new StringBuilder();
      paramString1.append("Performing query: ");
      paramString1.append(paramArrayOfString1);
      Log.d("SQLiteQueryBuilder", paramString1.toString());
    }
    return paramSQLiteDatabase.rawQueryWithFactory(mFactory, paramArrayOfString1, paramArrayOfString2, SQLiteDatabase.findEditTable(mTables));
  }
  
  public void setCursorFactory(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    mFactory = paramCursorFactory;
  }
  
  public void setDistinct(boolean paramBoolean)
  {
    mDistinct = paramBoolean;
  }
  
  public void setProjectionMap(Map<String, String> paramMap)
  {
    mProjectionMap = paramMap;
  }
  
  public void setStrictProjectionMap(boolean paramBoolean)
  {
    mStrictProjectionMap = paramBoolean;
  }
  
  public void setTables(String paramString)
  {
    mTables = paramString;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteQueryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */