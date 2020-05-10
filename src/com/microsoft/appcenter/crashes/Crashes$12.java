package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class Crashes$12
  implements Runnable
{
  public Crashes$12(Crashes paramCrashes, int paramInt) {}
  
  public void run()
  {
    int i = val$userConfirmation;
    Object localObject1;
    Object localObject2;
    if (i == 1)
    {
      localObject1 = Crashes.access$1000(this$0).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UUID)((Iterator)localObject1).next();
        ((Iterator)localObject1).remove();
        Crashes.access$1500(this$0, (UUID)localObject2);
      }
    }
    if (i == 2) {
      SharedPreferencesManager.putBoolean("com.microsoft.appcenter.crashes.always.send", true);
    }
    Iterator localIterator = Crashes.access$1000(this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Crashes.ErrorLogReport localErrorLogReport = (Crashes.ErrorLogReport)localEntry.getValue();
      localObject1 = Crashes.ErrorLogReport.access$1300(localErrorLogReport).getDevice();
      localObject2 = null;
      String str;
      if ((localObject1 != null) && ("appcenter.ndk".equals(Crashes.ErrorLogReport.access$1300(localErrorLogReport).getDevice().getWrapperSdkName())))
      {
        Exception localException = Crashes.ErrorLogReport.access$1600(localErrorLogReport).getException();
        str = localException.getMinidumpFilePath();
        localException.setMinidumpFilePath(null);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = localException.getStackTrace();
          localException.setStackTrace(null);
        }
        if (localObject1 != null)
        {
          localObject2 = new File((String)localObject1);
          localObject1 = ErrorAttachmentLog.attachmentWithBinary(FileManager.readBytes((File)localObject2), "minidump.dmp", "application/octet-stream");
        }
        else
        {
          AppCenterLog.warn("AppCenterCrashes", "NativeException found without minidump.");
        }
      }
      else
      {
        str = null;
        localObject1 = localObject2;
        localObject2 = str;
      }
      Crashes.access$1700(this$0).enqueue(Crashes.ErrorLogReport.access$1600(localErrorLogReport), "groupErrors", 2);
      if (localObject1 != null)
      {
        Crashes.access$900(this$0, Crashes.ErrorLogReport.access$1600(localErrorLogReport).getId(), Collections.singleton(localObject1));
        ((File)localObject2).delete();
      }
      if (Crashes.access$1200(this$0))
      {
        localObject1 = Crashes.access$700(this$0).getErrorAttachments(Crashes.ErrorLogReport.access$1300(localErrorLogReport));
        Crashes.access$900(this$0, Crashes.ErrorLogReport.access$1600(localErrorLogReport).getId(), (Iterable)localObject1);
      }
      localIterator.remove();
      ErrorLogHelper.removeStoredErrorLogFile((UUID)localEntry.getKey());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */