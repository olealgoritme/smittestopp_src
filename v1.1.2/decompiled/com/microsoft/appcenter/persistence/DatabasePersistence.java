package com.microsoft.appcenter.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.Flags;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import com.microsoft.appcenter.utils.crypto.CryptoUtils.DecryptedData;
import com.microsoft.appcenter.utils.storage.DatabaseManager;
import com.microsoft.appcenter.utils.storage.DatabaseManager.Listener;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SQLiteUtils;
import e.a.a.a.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;

public class DatabasePersistence
  extends Persistence
{
  public static final String COLUMN_DATA_TYPE = "type";
  public static final String COLUMN_GROUP = "persistence_group";
  public static final String COLUMN_LOG = "log";
  public static final String COLUMN_PRIORITY = "priority";
  public static final String COLUMN_TARGET_KEY = "target_key";
  public static final String COLUMN_TARGET_TOKEN = "target_token";
  public static final String DATABASE = "com.microsoft.appcenter.persistence";
  public static final String GET_SORT_ORDER = "priority DESC, oid";
  public static final String INDEX_PRIORITY = "ix_logs_priority";
  public static final String PAYLOAD_FILE_EXTENSION = ".json";
  public static final String PAYLOAD_LARGE_DIRECTORY = "/appcenter/database_large_payloads";
  public static final int PAYLOAD_MAX_SIZE = 1992294;
  public static final ContentValues SCHEMA = getContentValues("", "", "", "", "", 0);
  public static final String TABLE = "logs";
  public static final int VERSION = 6;
  public static final int VERSION_TIMESTAMP_COLUMN = 5;
  public final Context mContext;
  public final DatabaseManager mDatabaseManager;
  public final File mLargePayloadDirectory;
  public final Set<Long> mPendingDbIdentifiers;
  public final Map<String, List<Long>> mPendingDbIdentifiersGroups;
  
  public DatabasePersistence(Context paramContext)
  {
    this(paramContext, 6, SCHEMA);
  }
  
  public DatabasePersistence(Context paramContext, int paramInt, final ContentValues paramContentValues)
  {
    mContext = paramContext;
    mPendingDbIdentifiersGroups = new HashMap();
    mPendingDbIdentifiers = new HashSet();
    mDatabaseManager = new DatabaseManager(paramContext, "com.microsoft.appcenter.persistence", "logs", paramInt, paramContentValues, new DatabaseManager.Listener()
    {
      private void createPriorityIndex(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramAnonymousSQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
      }
      
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        createPriorityIndex(paramAnonymousSQLiteDatabase);
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        SQLiteUtils.dropTable(paramAnonymousSQLiteDatabase, "logs");
        SQLiteUtils.createTable(paramAnonymousSQLiteDatabase, "logs", paramContentValues);
        createPriorityIndex(paramAnonymousSQLiteDatabase);
      }
    });
    paramContext = new File(a.a(new StringBuilder(), Constants.FILES_PATH, "/appcenter/database_large_payloads"));
    mLargePayloadDirectory = paramContext;
    paramContext.mkdirs();
  }
  
  private void deleteLog(File paramFile, long paramLong)
  {
    getLargePayloadFile(paramFile, paramLong).delete();
    mDatabaseManager.delete(paramLong);
  }
  
  public static ContentValues getContentValues(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("persistence_group", paramString1);
    localContentValues.put("log", paramString2);
    localContentValues.put("target_token", paramString3);
    localContentValues.put("type", paramString4);
    localContentValues.put("target_key", paramString5);
    localContentValues.put("priority", Integer.valueOf(paramInt));
    return localContentValues;
  }
  
  /* Error */
  private List<Long> getLogsIds(SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 163	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 164	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 104	com/microsoft/appcenter/persistence/DatabasePersistence:mDatabaseManager	Lcom/microsoft/appcenter/utils/storage/DatabaseManager;
    //   12: aload_1
    //   13: getstatic 168	com/microsoft/appcenter/utils/storage/DatabaseManager:SELECT_PRIMARY_KEY	[Ljava/lang/String;
    //   16: aload_2
    //   17: aconst_null
    //   18: invokevirtual 172	com/microsoft/appcenter/utils/storage/DatabaseManager:getCursor	(Landroid/database/sqlite/SQLiteQueryBuilder;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: invokeinterface 177 1 0
    //   28: ifeq +24 -> 52
    //   31: aload_3
    //   32: aload_0
    //   33: getfield 104	com/microsoft/appcenter/persistence/DatabasePersistence:mDatabaseManager	Lcom/microsoft/appcenter/utils/storage/DatabaseManager;
    //   36: aload_1
    //   37: invokevirtual 181	com/microsoft/appcenter/utils/storage/DatabaseManager:buildValues	(Landroid/database/Cursor;)Landroid/content/ContentValues;
    //   40: ldc -73
    //   42: invokevirtual 187	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   45: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: goto -27 -> 22
    //   52: aload_1
    //   53: invokeinterface 194 1 0
    //   58: goto +21 -> 79
    //   61: astore_2
    //   62: aload_1
    //   63: invokeinterface 194 1 0
    //   68: aload_2
    //   69: athrow
    //   70: astore_1
    //   71: ldc -60
    //   73: ldc -58
    //   75: aload_1
    //   76: invokestatic 204	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   79: aload_3
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	DatabasePersistence
    //   0	81	1	paramSQLiteQueryBuilder	SQLiteQueryBuilder
    //   0	81	2	paramArrayOfString	String[]
    //   7	73	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	49	61	finally
    //   8	22	70	java/lang/RuntimeException
    //   52	58	70	java/lang/RuntimeException
    //   62	70	70	java/lang/RuntimeException
  }
  
  public void clearPendingLogState()
  {
    mPendingDbIdentifiers.clear();
    mPendingDbIdentifiersGroups.clear();
    AppCenterLog.debug("AppCenter", "Cleared pending log states");
  }
  
  public void close()
  {
    mDatabaseManager.close();
  }
  
  /* Error */
  public int countLogs(String paramString)
  {
    // Byte code:
    //   0: invokestatic 229	com/microsoft/appcenter/utils/storage/SQLiteUtils:newSQLiteQueryBuilder	()Landroid/database/sqlite/SQLiteQueryBuilder;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc -25
    //   7: invokevirtual 237	android/database/sqlite/SQLiteQueryBuilder:appendWhere	(Ljava/lang/CharSequence;)V
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_3
    //   13: istore 4
    //   15: aload_0
    //   16: getfield 104	com/microsoft/appcenter/persistence/DatabasePersistence:mDatabaseManager	Lcom/microsoft/appcenter/utils/storage/DatabaseManager;
    //   19: aload_2
    //   20: iconst_1
    //   21: anewarray 239	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc -15
    //   28: aastore
    //   29: iconst_1
    //   30: anewarray 239	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: aconst_null
    //   38: invokevirtual 172	com/microsoft/appcenter/utils/storage/DatabaseManager:getCursor	(Landroid/database/sqlite/SQLiteQueryBuilder;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface 177 1 0
    //   48: pop
    //   49: aload_1
    //   50: iconst_0
    //   51: invokeinterface 245 2 0
    //   56: istore 5
    //   58: iload 5
    //   60: istore 4
    //   62: aload_1
    //   63: invokeinterface 194 1 0
    //   68: iload 5
    //   70: istore 4
    //   72: goto +27 -> 99
    //   75: astore_2
    //   76: iload_3
    //   77: istore 4
    //   79: aload_1
    //   80: invokeinterface 194 1 0
    //   85: iload_3
    //   86: istore 4
    //   88: aload_2
    //   89: athrow
    //   90: astore_1
    //   91: ldc -60
    //   93: ldc -9
    //   95: aload_1
    //   96: invokestatic 204	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: iload 4
    //   101: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	DatabasePersistence
    //   0	102	1	paramString	String
    //   3	17	2	localSQLiteQueryBuilder	SQLiteQueryBuilder
    //   75	14	2	localObject	Object
    //   11	75	3	i	int
    //   13	87	4	j	int
    //   56	13	5	k	int
    // Exception table:
    //   from	to	target	type
    //   42	58	75	finally
    //   15	42	90	java/lang/RuntimeException
    //   62	68	90	java/lang/RuntimeException
    //   79	85	90	java/lang/RuntimeException
    //   88	90	90	java/lang/RuntimeException
  }
  
  public void deleteLogs(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Deleting all logs from the Persistence database for ");
    ((StringBuilder)localObject).append(paramString);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
    File localFile = getLargePayloadGroupDirectory(paramString);
    localObject = localFile.listFiles();
    if (localObject != null)
    {
      int i = localObject.length;
      for (j = 0; j < i; j++) {
        localObject[j].delete();
      }
    }
    localFile.delete();
    int j = mDatabaseManager.delete("persistence_group", paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Deleted ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" logs.");
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
    localObject = mPendingDbIdentifiersGroups.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((String)((Iterator)localObject).next()).startsWith(paramString)) {
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public void deleteLogs(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Deleting logs from the Persistence database for ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" with ");
    ((StringBuilder)localObject1).append(paramString2);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
    AppCenterLog.debug("AppCenter", "The IDs for deleting log(s) is/are:");
    localObject1 = mPendingDbIdentifiersGroups;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(paramString2);
    paramString2 = (List)((Map)localObject1).remove(((StringBuilder)localObject2).toString());
    paramString1 = getLargePayloadGroupDirectory(paramString1);
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        localObject2 = (Long)paramString2.next();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(localObject2);
        AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
        deleteLog(paramString1, ((Long)localObject2).longValue());
        mPendingDbIdentifiers.remove(localObject2);
      }
    }
  }
  
  public File getLargePayloadFile(File paramFile, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append(".json");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public File getLargePayloadGroupDirectory(String paramString)
  {
    return new File(mLargePayloadDirectory, paramString);
  }
  
  public String getLogs(String paramString, Collection<String> paramCollection, int paramInt, List<Log> paramList)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Trying to get ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" logs from the Persistence database for ");
    ((StringBuilder)localObject1).append(paramString);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
    Object localObject4 = SQLiteUtils.newSQLiteQueryBuilder();
    ((SQLiteQueryBuilder)localObject4).appendWhere("persistence_group = ?");
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramString);
    if (!paramCollection.isEmpty())
    {
      localObject5 = new StringBuilder();
      for (i = 0; i < paramCollection.size(); i++) {
        ((StringBuilder)localObject5).append("?,");
      }
      ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      ((SQLiteQueryBuilder)localObject4).appendWhere(" AND ");
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("target_key NOT IN (");
      ((StringBuilder)localObject6).append(((StringBuilder)localObject5).toString());
      ((StringBuilder)localObject6).append(")");
      ((SQLiteQueryBuilder)localObject4).appendWhere(((StringBuilder)localObject6).toString());
      ((ArrayList)localObject1).addAll(paramCollection);
    }
    Object localObject5 = new LinkedHashMap();
    ArrayList localArrayList = new ArrayList();
    Object localObject7 = getLargePayloadGroupDirectory(paramString);
    String[] arrayOfString = (String[])((ArrayList)localObject1).toArray(new String[0]);
    paramCollection = null;
    try
    {
      localObject1 = mDatabaseManager.getCursor((SQLiteQueryBuilder)localObject4, null, arrayOfString, "priority DESC, oid");
      paramCollection = (Collection<String>)localObject1;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Failed to get logs: ", localRuntimeException);
    }
    int i = 0;
    for (;;)
    {
      if (paramCollection == null) {
        break label650;
      }
      ContentValues localContentValues = mDatabaseManager.nextValues(paramCollection);
      if ((localContentValues == null) || (i >= paramInt)) {
        break label650;
      }
      Long localLong = localContentValues.getAsLong("oid");
      Object localObject2;
      if (localLong == null)
      {
        AppCenterLog.error("AppCenter", "Empty database record, probably content was larger than 2MB, need to delete as it's now corrupted.");
        localObject6 = getLogsIds((SQLiteQueryBuilder)localObject4, arrayOfString).iterator();
        if (!((Iterator)localObject6).hasNext()) {
          continue;
        }
        localObject2 = (Long)((Iterator)localObject6).next();
        if ((mPendingDbIdentifiers.contains(localObject2)) || (((HashMap)localObject5).containsKey(localObject2))) {
          break;
        }
        deleteLog((File)localObject7, ((Long)localObject2).longValue());
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("Empty database corrupted empty record deleted, id=");
        ((StringBuilder)localObject6).append(localObject2);
        AppCenterLog.error("AppCenter", ((StringBuilder)localObject6).toString());
        continue;
      }
      if (!mPendingDbIdentifiers.contains(localLong)) {
        try
        {
          localObject6 = localContentValues.getAsString("log");
          localObject2 = localObject6;
          if (localObject6 == null)
          {
            localObject6 = getLargePayloadFile((File)localObject7, localLong.longValue());
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("Read payload file ");
            ((StringBuilder)localObject2).append(localObject6);
            AppCenterLog.debug("AppCenter", ((StringBuilder)localObject2).toString());
            localObject2 = FileManager.read((File)localObject6);
            if (localObject2 == null)
            {
              localObject2 = new org/json/JSONException;
              ((JSONException)localObject2).<init>("Log payload is null and not stored as a file.");
              throw ((Throwable)localObject2);
            }
          }
          localObject6 = localContentValues.getAsString("type");
          localObject2 = getLogSerializer().deserializeLog((String)localObject2, (String)localObject6);
          localObject6 = localContentValues.getAsString("target_token");
          if (localObject6 != null) {
            ((Log)localObject2).addTransmissionTarget(CryptoUtils.getInstance(mContext).decrypt((String)localObject6).getDecryptedData());
          }
          ((HashMap)localObject5).put(localLong, localObject2);
          i++;
        }
        catch (JSONException localJSONException)
        {
          AppCenterLog.error("AppCenter", "Cannot deserialize a log in the database", localJSONException);
          localArrayList.add(localLong);
        }
      }
    }
    label650:
    if (paramCollection != null) {
      try
      {
        paramCollection.close();
      }
      catch (RuntimeException paramCollection) {}
    }
    if (localArrayList.size() > 0)
    {
      paramCollection = localArrayList.iterator();
      while (paramCollection.hasNext()) {
        deleteLog((File)localObject7, ((Long)paramCollection.next()).longValue());
      }
      AppCenterLog.warn("AppCenter", "Deleted logs that cannot be deserialized");
    }
    if (((HashMap)localObject5).size() <= 0)
    {
      AppCenterLog.debug("AppCenter", "No logs found in the Persistence database at the moment");
      return null;
    }
    paramCollection = UUID.randomUUID().toString();
    Object localObject3 = a.a("Returning ");
    ((StringBuilder)localObject3).append(((HashMap)localObject5).size());
    ((StringBuilder)localObject3).append(" log(s) with an ID, ");
    ((StringBuilder)localObject3).append(paramCollection);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject3).toString());
    AppCenterLog.debug("AppCenter", "The SID/ID pairs for returning log(s) is/are:");
    localObject3 = new ArrayList();
    localObject5 = ((LinkedHashMap)localObject5).entrySet().iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject7 = (Map.Entry)((Iterator)localObject5).next();
      localObject6 = (Long)((Map.Entry)localObject7).getKey();
      mPendingDbIdentifiers.add(localObject6);
      ((ArrayList)localObject3).add(localObject6);
      paramList.add(((Map.Entry)localObject7).getValue());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("\t");
      ((StringBuilder)localObject4).append(((Log)((Map.Entry)localObject7).getValue()).getSid());
      ((StringBuilder)localObject4).append(" / ");
      ((StringBuilder)localObject4).append(localObject6);
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject4).toString());
    }
    paramList = mPendingDbIdentifiersGroups;
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append(paramString);
    ((StringBuilder)localObject6).append(paramCollection);
    paramList.put(((StringBuilder)localObject6).toString(), localObject3);
    return paramCollection;
  }
  
  public long putLog(Log paramLog, String paramString, int paramInt)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("Storing a log to the Persistence database for log type ");
      ((StringBuilder)localObject).append(paramLog.getType());
      ((StringBuilder)localObject).append(" with flags=");
      ((StringBuilder)localObject).append(paramInt);
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
      String str1 = getLogSerializer().serializeLog(paramLog);
      int i = str1.getBytes("UTF-8").length;
      int j;
      if (i >= 1992294) {
        j = 1;
      } else {
        j = 0;
      }
      String str2;
      if ((paramLog instanceof CommonSchemaLog))
      {
        if (j == 0)
        {
          str2 = (String)paramLog.getTransmissionTargetTokens().iterator().next();
          localObject = PartAUtils.getTargetKey(str2);
          str2 = CryptoUtils.getInstance(mContext).encrypt(str2);
        }
        else
        {
          paramLog = new com/microsoft/appcenter/persistence/Persistence$PersistenceException;
          paramLog.<init>("Log is larger than 1992294 bytes, cannot send to OneCollector.");
          throw paramLog;
        }
      }
      else
      {
        str2 = null;
        localObject = str2;
      }
      long l = mDatabaseManager.getMaxSize();
      if (l != -1L)
      {
        if ((j == 0) && (l <= i))
        {
          paramString = new com/microsoft/appcenter/persistence/Persistence$PersistenceException;
          paramLog = new java/lang/StringBuilder;
          paramLog.<init>();
          paramLog.append("Log is too large (");
          paramLog.append(i);
          paramLog.append(" bytes) to store in database. Current maximum database size is ");
          paramLog.append(l);
          paramLog.append(" bytes.");
          paramString.<init>(paramLog.toString());
          throw paramString;
        }
        String str3;
        if (j != 0) {
          str3 = null;
        } else {
          str3 = str1;
        }
        localObject = getContentValues(paramString, str3, str2, paramLog.getType(), (String)localObject, Flags.getPersistenceFlag(paramInt, false));
        l = mDatabaseManager.put((ContentValues)localObject, "priority");
        if (l != -1L)
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          ((StringBuilder)localObject).append("Stored a log to the Persistence database for log type ");
          ((StringBuilder)localObject).append(paramLog.getType());
          ((StringBuilder)localObject).append(" with databaseId=");
          ((StringBuilder)localObject).append(l);
          AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
          if (j != 0)
          {
            AppCenterLog.debug("AppCenter", "Payload is larger than what SQLite supports, storing payload in a separate file.");
            paramLog = getLargePayloadGroupDirectory(paramString);
            paramLog.mkdir();
            paramLog = getLargePayloadFile(paramLog, l);
            try
            {
              FileManager.write(paramLog, str1);
              paramString = new java/lang/StringBuilder;
              paramString.<init>();
              paramString.append("Payload written to ");
              paramString.append(paramLog);
              AppCenterLog.debug("AppCenter", paramString.toString());
            }
            catch (IOException paramLog)
            {
              mDatabaseManager.delete(l);
              throw paramLog;
            }
          }
          return l;
        }
        paramString = new com/microsoft/appcenter/persistence/Persistence$PersistenceException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Failed to store a log to the Persistence database for log type ");
        ((StringBuilder)localObject).append(paramLog.getType());
        ((StringBuilder)localObject).append(".");
        paramString.<init>(((StringBuilder)localObject).toString());
        throw paramString;
      }
      paramLog = new com/microsoft/appcenter/persistence/Persistence$PersistenceException;
      paramLog.<init>("Failed to store a log to the Persistence database.");
      throw paramLog;
    }
    catch (IOException paramLog) {}catch (JSONException paramLog) {}
    throw new Persistence.PersistenceException("Cannot save large payload in a file.", paramLog);
    throw new Persistence.PersistenceException("Cannot convert to JSON string.", paramLog);
  }
  
  public boolean setMaxStorageSize(long paramLong)
  {
    return mDatabaseManager.setMaxSize(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.persistence.DatabasePersistence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */