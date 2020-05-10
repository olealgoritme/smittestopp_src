package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;

public class FileManager
{
  @SuppressLint({"StaticFieldLeak"})
  public static Context sContext;
  
  public static boolean delete(File paramFile)
  {
    return paramFile.delete();
  }
  
  public static boolean delete(String paramString)
  {
    return delete(new File(paramString));
  }
  
  public static boolean deleteDir(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        deleteDir(arrayOfFile[j]);
      }
    }
    return paramFile.delete();
  }
  
  public static String[] getFilenames(String paramString, FilenameFilter paramFilenameFilter)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.list(paramFilenameFilter);
    }
    return new String[0];
  }
  
  public static void initialize(Context paramContext)
  {
    try
    {
      if (sContext == null) {
        sContext = paramContext;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static File lastModifiedFile(File paramFile, FilenameFilter paramFilenameFilter)
  {
    boolean bool = paramFile.exists();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject1;
    if (bool)
    {
      File[] arrayOfFile = paramFile.listFiles(paramFilenameFilter);
      long l1 = 0L;
      localObject3 = localObject1;
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        int j = 0;
        paramFile = (File)localObject2;
        for (;;)
        {
          localObject3 = paramFile;
          if (j >= i) {
            break;
          }
          paramFilenameFilter = arrayOfFile[j];
          long l2 = l1;
          if (paramFilenameFilter.lastModified() > l1)
          {
            l2 = paramFilenameFilter.lastModified();
            paramFile = paramFilenameFilter;
          }
          j++;
          l1 = l2;
        }
      }
    }
    return (File)localObject3;
  }
  
  public static File lastModifiedFile(String paramString, FilenameFilter paramFilenameFilter)
  {
    return lastModifiedFile(new File(paramString), paramFilenameFilter);
  }
  
  public static void mkdir(String paramString)
  {
    new File(paramString).mkdirs();
  }
  
  public static String read(File paramFile)
  {
    try
    {
      Object localObject1 = new java/io/BufferedReader;
      Object localObject2 = new java/io/FileReader;
      ((FileReader)localObject2).<init>(paramFile);
      ((BufferedReader)localObject1).<init>((Reader)localObject2);
      try
      {
        String str1 = System.getProperty("line.separator");
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        String str2 = ((BufferedReader)localObject1).readLine();
        if (str2 != null)
        {
          ((StringBuilder)localObject2).append(str2);
          for (;;)
          {
            str2 = ((BufferedReader)localObject1).readLine();
            if (str2 == null) {
              break;
            }
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(str2);
          }
        }
        return ((StringBuilder)localObject2).toString();
      }
      finally
      {
        ((BufferedReader)localObject1).close();
      }
      return null;
    }
    catch (IOException localIOException)
    {
      localObject1 = a.a("Could not read file ");
      ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
      AppCenterLog.error("AppCenter", ((StringBuilder)localObject1).toString(), localIOException);
    }
  }
  
  public static String read(String paramString)
  {
    return read(new File(paramString));
  }
  
  public static byte[] readBytes(File paramFile)
  {
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    try
    {
      FileInputStream localFileInputStream = new java/io/FileInputStream;
      localFileInputStream.<init>(paramFile);
      try
      {
        DataInputStream localDataInputStream = new java/io/DataInputStream;
        localDataInputStream.<init>(localFileInputStream);
        localDataInputStream.readFully(arrayOfByte);
        return arrayOfByte;
      }
      finally
      {
        localFileInputStream.close();
      }
      StringBuilder localStringBuilder;
      return null;
    }
    catch (IOException localIOException)
    {
      localStringBuilder = a.a("Could not read file ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      AppCenterLog.error("AppCenter", localStringBuilder.toString(), localIOException);
    }
  }
  
  public static void write(File paramFile, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (TextUtils.getTrimmedLength(paramString) > 0))
    {
      paramFile = new BufferedWriter(new FileWriter(paramFile));
      try
      {
        paramFile.write(paramString);
        return;
      }
      finally
      {
        paramFile.close();
      }
    }
  }
  
  public static void write(String paramString1, String paramString2)
  {
    write(new File(paramString1), paramString2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.storage.FileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */