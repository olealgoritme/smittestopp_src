package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.CursorWindow;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import e.a.a.a.a;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class DatabaseUtils
{
  public static final boolean DEBUG = false;
  public static final char[] HEX_DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final boolean LOCAL_LOGV = false;
  public static final String TAG = "DatabaseUtils";
  public static final String[] countProjection = { "count(*)" };
  public static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int i = paramString.length();
      for (int j = 0; j < i; j++)
      {
        char c = paramString.charAt(j);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null) {
      paramStringBuilder.append("NULL");
    } else if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {
        paramStringBuilder.append('1');
      } else {
        paramStringBuilder.append('0');
      }
    }
    else {
      appendEscapedSQLString(paramStringBuilder, paramObject.toString());
    }
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      paramSQLiteProgram.bindNull(paramInt);
    } else if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float)))
    {
      if ((paramObject instanceof Number)) {
        paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
      } else if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {
          paramSQLiteProgram.bindLong(paramInt, 1L);
        } else {
          paramSQLiteProgram.bindLong(paramInt, 0L);
        }
      }
      else if ((paramObject instanceof byte[])) {
        paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
      } else {
        paramSQLiteProgram.bindString(paramInt, paramObject.toString());
      }
    }
    else {
      paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
    }
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(") AND (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
    } else {
      paramContentValues.put(paramString2, null);
    }
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if ((paramInt >= 0) && (paramInt < paramCursor.getCount()))
    {
      int i = paramCursor.getPosition();
      int j = paramCursor.getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(j);
      if (paramCursor.moveToPosition(paramInt)) {
        do
        {
          if (!paramCursorWindow.allocRow()) {
            break;
          }
          for (int k = 0; k < j; k++)
          {
            int m = paramCursor.getType(k);
            boolean bool;
            if (m != 0)
            {
              if (m != 1)
              {
                if (m != 2)
                {
                  Object localObject;
                  if (m != 4)
                  {
                    localObject = paramCursor.getString(k);
                    if (localObject != null) {
                      bool = paramCursorWindow.putString((String)localObject, paramInt, k);
                    } else {
                      bool = paramCursorWindow.putNull(paramInt, k);
                    }
                  }
                  else
                  {
                    localObject = paramCursor.getBlob(k);
                    if (localObject != null) {
                      bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, k);
                    } else {
                      bool = paramCursorWindow.putNull(paramInt, k);
                    }
                  }
                }
                else
                {
                  bool = paramCursorWindow.putDouble(paramCursor.getDouble(k), paramInt, k);
                }
              }
              else {
                bool = paramCursorWindow.putLong(paramCursor.getLong(k), paramInt, k);
              }
            }
            else {
              bool = paramCursorWindow.putNull(paramInt, k);
            }
            if (!bool)
            {
              paramCursorWindow.freeLastRow();
              break;
            }
          }
          paramInt++;
        } while (paramCursor.moveToNext());
      }
      paramCursor.moveToPosition(i);
    }
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
    } else {
      paramContentValues.put(paramString2, null);
    }
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
    } else {
      paramContentValues.put(paramString2, null);
    }
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AbstractWindowedCursor localAbstractWindowedCursor;
    if ((paramCursor instanceof AbstractWindowedCursor)) {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
    } else {
      localAbstractWindowedCursor = null;
    }
    String[] arrayOfString = paramCursor.getColumnNames();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++) {
      if ((localAbstractWindowedCursor != null) && (localAbstractWindowedCursor.isBlob(j))) {
        paramContentValues.put(arrayOfString[j], paramCursor.getBlob(j));
      } else {
        paramContentValues.put(arrayOfString[j], paramCursor.getString(j));
      }
    }
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    dumpCurrentRow(paramCursor, System.out);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = a.a("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {");
    paramPrintStream.println(((StringBuilder)localObject).toString());
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str;
      try
      {
        localObject = paramCursor.getString(j);
      }
      catch (SQLiteException localSQLiteException)
      {
        str = "<unprintable>";
      }
      StringBuilder localStringBuilder = a.a("   ");
      localStringBuilder.append(arrayOfString[j]);
      localStringBuilder.append('=');
      localStringBuilder.append(str);
      paramPrintStream.println(localStringBuilder.toString());
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = a.a("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {\n");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str;
      try
      {
        localObject = paramCursor.getString(j);
      }
      catch (SQLiteException localSQLiteException)
      {
        str = "<unprintable>";
      }
      StringBuilder localStringBuilder = a.a("   ");
      localStringBuilder.append(arrayOfString[j]);
      localStringBuilder.append('=');
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      paramStringBuilder.append(localStringBuilder.toString());
    }
    paramStringBuilder.append("}\n");
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    dumpCursor(paramCursor, System.out);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    paramPrintStream.println(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    localStringBuilder.append("\n");
    paramStringBuilder.append(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int i = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i << 1];
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = k + 1;
      arrayOfChar[k] = ((char)paramArrayOfChar[((paramArrayOfByte[j] & 0xF0) >>> 4)]);
      k = m + 1;
      arrayOfChar[m] = ((char)paramArrayOfChar[(paramArrayOfByte[j] & 0xF)]);
      j++;
    }
    return arrayOfChar;
  }
  
  public static String getCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new String(paramString, 0, getKeyLen(paramString), "ISO8859_1");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static byte[] getCollationKeyInBytes(String paramString)
  {
    if (mColl == null)
    {
      Collator localCollator = Collator.getInstance();
      mColl = localCollator;
      localCollator.setStrength(0);
    }
    return mColl.getCollationKey(paramString).toByteArray();
  }
  
  public static String getHexCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    return new String(encodeHex(paramString, HEX_DIGITS_LOWER), 0, getKeyLen(paramString) * 2);
  }
  
  public static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {
      return paramArrayOfByte.length;
    }
    return paramArrayOfByte.length - 1;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer))) {
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      int k;
      for (int j = 0; j < i; j = k)
      {
        k = j + 1;
        bindObjectToProgram(paramSQLiteStatement, k, paramArrayOfString[j]);
      }
    }
    return paramSQLiteStatement.simpleQueryForLong();
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query(paramString, countProjection, null, null, null, null, null);
    try
    {
      paramSQLiteDatabase.moveToFirst();
      long l = paramSQLiteDatabase.getLong(0);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 9: 
      throw new SQLiteException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 1)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new FileNotFoundException(str);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 10)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new OperationApplicationException(str);
  }
  
  public static String sqlEscapeString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      int k;
      for (int j = 0; j < i; j = k)
      {
        k = j + 1;
        bindObjectToProgram(paramSQLiteStatement, k, paramArrayOfString[j]);
      }
    }
    return paramSQLiteStatement.simpleQueryForString();
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    boolean bool = paramException instanceof FileNotFoundException;
    int i = 1;
    int j;
    if (bool)
    {
      j = 0;
    }
    else if ((paramException instanceof IllegalArgumentException))
    {
      j = 1;
      i = 2;
    }
    else if ((paramException instanceof UnsupportedOperationException))
    {
      j = 1;
      i = 3;
    }
    else if ((paramException instanceof SQLiteAbortException))
    {
      j = 1;
      i = 4;
    }
    else if ((paramException instanceof SQLiteConstraintException))
    {
      j = 1;
      i = 5;
    }
    else if ((paramException instanceof SQLiteDatabaseCorruptException))
    {
      j = 1;
      i = 6;
    }
    else if ((paramException instanceof SQLiteFullException))
    {
      j = 1;
      i = 7;
    }
    else if ((paramException instanceof SQLiteDiskIOException))
    {
      j = 1;
      i = 8;
    }
    else if ((paramException instanceof SQLiteException))
    {
      j = 1;
      i = 9;
    }
    else
    {
      if (!(paramException instanceof OperationApplicationException)) {
        break label183;
      }
      j = 1;
      i = 10;
    }
    paramParcel.writeInt(i);
    paramParcel.writeString(paramException.getMessage());
    if (j != 0) {
      Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
    }
    return;
    label183:
    paramParcel.writeException(paramException);
    Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
  }
  
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    public HashMap<String, Integer> mColumns;
    public final SQLiteDatabase mDb;
    public String mInsertSQL = null;
    public SQLiteStatement mInsertStatement = null;
    public SQLiteStatement mPreparedStatement = null;
    public SQLiteStatement mReplaceStatement = null;
    public final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      mDb = paramSQLiteDatabase;
      mTableName = paramString;
    }
    
    private void buildSQL()
    {
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append("INSERT INTO ");
      localStringBuilder1.append(mTableName);
      localStringBuilder1.append(" (");
      StringBuilder localStringBuilder2 = new StringBuilder(128);
      localStringBuilder2.append("VALUES (");
      Object localObject1 = null;
      Object localObject3 = localObject1;
      try
      {
        Object localObject4 = mDb;
        localObject3 = localObject1;
        Object localObject5 = new java/lang/StringBuilder;
        localObject3 = localObject1;
        ((StringBuilder)localObject5).<init>();
        localObject3 = localObject1;
        ((StringBuilder)localObject5).append("PRAGMA table_info(");
        localObject3 = localObject1;
        ((StringBuilder)localObject5).append(mTableName);
        localObject3 = localObject1;
        ((StringBuilder)localObject5).append(")");
        localObject3 = localObject1;
        localObject4 = ((SQLiteDatabase)localObject4).rawQuery(((StringBuilder)localObject5).toString(), null);
        localObject3 = localObject4;
        localObject1 = new java/util/HashMap;
        localObject3 = localObject4;
        ((HashMap)localObject1).<init>(((android.database.Cursor)localObject4).getCount());
        localObject3 = localObject4;
        mColumns = ((HashMap)localObject1);
        for (int i = 1;; i++)
        {
          localObject3 = localObject4;
          if (!((android.database.Cursor)localObject4).moveToNext()) {
            break;
          }
          localObject3 = localObject4;
          localObject1 = ((android.database.Cursor)localObject4).getString(1);
          localObject3 = localObject4;
          localObject5 = ((android.database.Cursor)localObject4).getString(4);
          localObject3 = localObject4;
          mColumns.put(localObject1, Integer.valueOf(i));
          localObject3 = localObject4;
          localStringBuilder1.append("'");
          localObject3 = localObject4;
          localStringBuilder1.append((String)localObject1);
          localObject3 = localObject4;
          localStringBuilder1.append("'");
          if (localObject5 == null)
          {
            localObject3 = localObject4;
            localStringBuilder2.append("?");
          }
          else
          {
            localObject3 = localObject4;
            localStringBuilder2.append("COALESCE(?, ");
            localObject3 = localObject4;
            localStringBuilder2.append((String)localObject5);
            localObject3 = localObject4;
            localStringBuilder2.append(")");
          }
          localObject3 = localObject4;
          int j = ((android.database.Cursor)localObject4).getCount();
          localObject5 = ", ";
          if (i == j) {
            localObject1 = ") ";
          } else {
            localObject1 = ", ";
          }
          localObject3 = localObject4;
          localStringBuilder1.append((String)localObject1);
          localObject1 = localObject5;
          localObject3 = localObject4;
          if (i == ((android.database.Cursor)localObject4).getCount()) {
            localObject1 = ");";
          }
          localObject3 = localObject4;
          localStringBuilder2.append((String)localObject1);
        }
        ((android.database.Cursor)localObject4).close();
        localStringBuilder1.append(localStringBuilder2);
        mInsertSQL = localStringBuilder1.toString();
        return;
      }
      finally
      {
        if (localObject3 != null) {
          ((android.database.Cursor)localObject3).close();
        }
      }
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (mReplaceStatement == null)
        {
          if (mInsertSQL == null) {
            buildSQL();
          }
          Object localObject = a.a("INSERT OR REPLACE");
          ((StringBuilder)localObject).append(mInsertSQL.substring(6));
          localObject = ((StringBuilder)localObject).toString();
          mReplaceStatement = mDb.compileStatement((String)localObject);
        }
        return mReplaceStatement;
      }
      if (mInsertStatement == null)
      {
        if (mInsertSQL == null) {
          buildSQL();
        }
        mInsertStatement = mDb.compileStatement(mInsertSQL);
      }
      return mInsertStatement;
    }
    
    /* Error */
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_2
      //   4: invokespecial 146	net/sqlcipher/DatabaseUtils$InsertHelper:getStatement	(Z)Lnet/sqlcipher/database/SQLiteStatement;
      //   7: astore_3
      //   8: aload_3
      //   9: invokevirtual 151	net/sqlcipher/database/SQLiteProgram:clearBindings	()V
      //   12: aload_1
      //   13: invokevirtual 157	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   16: invokeinterface 163 1 0
      //   21: astore 4
      //   23: aload 4
      //   25: invokeinterface 168 1 0
      //   30: ifeq +43 -> 73
      //   33: aload 4
      //   35: invokeinterface 172 1 0
      //   40: checkcast 174	java/util/Map$Entry
      //   43: astore 5
      //   45: aload_3
      //   46: aload_0
      //   47: aload 5
      //   49: invokeinterface 177 1 0
      //   54: checkcast 133	java/lang/String
      //   57: invokevirtual 181	net/sqlcipher/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   60: aload 5
      //   62: invokeinterface 184 1 0
      //   67: invokestatic 188	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      //   70: goto -47 -> 23
      //   73: aload_3
      //   74: invokevirtual 194	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
      //   77: lstore 6
      //   79: aload_0
      //   80: monitorexit
      //   81: lload 6
      //   83: lreturn
      //   84: astore_1
      //   85: goto +67 -> 152
      //   88: astore 4
      //   90: new 45	java/lang/StringBuilder
      //   93: astore 5
      //   95: aload 5
      //   97: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   100: aload 5
      //   102: ldc -60
      //   104: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: pop
      //   108: aload 5
      //   110: aload_1
      //   111: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   114: pop
      //   115: aload 5
      //   117: ldc -55
      //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   122: pop
      //   123: aload 5
      //   125: aload_0
      //   126: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   129: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   132: pop
      //   133: ldc -53
      //   135: aload 5
      //   137: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   140: aload 4
      //   142: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   145: pop
      //   146: aload_0
      //   147: monitorexit
      //   148: ldc2_w 210
      //   151: lreturn
      //   152: aload_0
      //   153: monitorexit
      //   154: aload_1
      //   155: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	InsertHelper
      //   0	156	1	paramContentValues	ContentValues
      //   0	156	2	paramBoolean	boolean
      //   7	67	3	localSQLiteStatement	SQLiteStatement
      //   21	13	4	localIterator	java.util.Iterator
      //   88	53	4	localSQLException	SQLException
      //   43	93	5	localObject	Object
      //   77	5	6	l	long
      // Exception table:
      //   from	to	target	type
      //   2	23	84	finally
      //   23	70	84	finally
      //   73	79	84	finally
      //   90	146	84	finally
      //   2	23	88	net/sqlcipher/SQLException
      //   23	70	88	net/sqlcipher/SQLException
      //   73	79	88	net/sqlcipher/SQLException
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      mPreparedStatement.bindDouble(paramInt, paramDouble);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      mPreparedStatement.bindDouble(paramInt, paramFloat);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      mPreparedStatement.bindLong(paramInt1, paramInt2);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      mPreparedStatement.bindLong(paramInt, paramLong);
    }
    
    public void bind(int paramInt, String paramString)
    {
      if (paramString == null) {
        mPreparedStatement.bindNull(paramInt);
      } else {
        mPreparedStatement.bindString(paramInt, paramString);
      }
    }
    
    public void bind(int paramInt, boolean paramBoolean)
    {
      SQLiteStatement localSQLiteStatement = mPreparedStatement;
      long l;
      if (paramBoolean) {
        l = 1L;
      } else {
        l = 0L;
      }
      localSQLiteStatement.bindLong(paramInt, l);
    }
    
    public void bind(int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        mPreparedStatement.bindNull(paramInt);
      } else {
        mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
      }
    }
    
    public void bindNull(int paramInt)
    {
      mPreparedStatement.bindNull(paramInt);
    }
    
    public void close()
    {
      SQLiteStatement localSQLiteStatement = mInsertStatement;
      if (localSQLiteStatement != null)
      {
        localSQLiteStatement.close();
        mInsertStatement = null;
      }
      localSQLiteStatement = mReplaceStatement;
      if (localSQLiteStatement != null)
      {
        localSQLiteStatement.close();
        mReplaceStatement = null;
      }
      mInsertSQL = null;
      mColumns = null;
    }
    
    /* Error */
    public long execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   4: astore_1
      //   5: aload_1
      //   6: ifnull +76 -> 82
      //   9: aload_1
      //   10: invokevirtual 194	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
      //   13: lstore_2
      //   14: aload_0
      //   15: aconst_null
      //   16: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   19: lload_2
      //   20: lreturn
      //   21: astore_1
      //   22: goto +53 -> 75
      //   25: astore_1
      //   26: new 45	java/lang/StringBuilder
      //   29: astore 4
      //   31: aload 4
      //   33: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   36: aload 4
      //   38: ldc -18
      //   40: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: pop
      //   44: aload 4
      //   46: aload_0
      //   47: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: pop
      //   54: ldc -53
      //   56: aload 4
      //   58: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   61: aload_1
      //   62: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   65: pop
      //   66: aload_0
      //   67: aconst_null
      //   68: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   71: ldc2_w 210
      //   74: lreturn
      //   75: aload_0
      //   76: aconst_null
      //   77: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
      //   80: aload_1
      //   81: athrow
      //   82: new 240	java/lang/IllegalStateException
      //   85: dup
      //   86: ldc -14
      //   88: invokespecial 245	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   91: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	InsertHelper
      //   4	6	1	localSQLiteStatement	SQLiteStatement
      //   21	1	1	localObject	Object
      //   25	56	1	localSQLException	SQLException
      //   13	7	2	l	long
      //   29	28	4	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   9	14	21	finally
      //   26	66	21	finally
      //   9	14	25	net/sqlcipher/SQLException
    }
    
    public int getColumnIndex(String paramString)
    {
      getStatement(false);
      Integer localInteger = (Integer)mColumns.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      throw new IllegalArgumentException(a.a("column '", paramString, "' is invalid"));
    }
    
    public long insert(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, false);
    }
    
    public void prepareForInsert()
    {
      SQLiteStatement localSQLiteStatement = getStatement(false);
      mPreparedStatement = localSQLiteStatement;
      localSQLiteStatement.clearBindings();
    }
    
    public void prepareForReplace()
    {
      SQLiteStatement localSQLiteStatement = getStatement(true);
      mPreparedStatement = localSQLiteStatement;
      localSQLiteStatement.clearBindings();
    }
    
    public long replace(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, true);
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.DatabaseUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */