package com.microsoft.azure.storage.file;

public enum DeleteShareSnapshotsOption
{
  static
  {
    DeleteShareSnapshotsOption localDeleteShareSnapshotsOption = new DeleteShareSnapshotsOption("NONE", 1);
    NONE = localDeleteShareSnapshotsOption;
    $VALUES = new DeleteShareSnapshotsOption[] { INCLUDE_SNAPSHOTS, localDeleteShareSnapshotsOption };
  }
  
  public DeleteShareSnapshotsOption() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.DeleteShareSnapshotsOption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */