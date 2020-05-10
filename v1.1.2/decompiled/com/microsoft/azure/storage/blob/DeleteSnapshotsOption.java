package com.microsoft.azure.storage.blob;

public enum DeleteSnapshotsOption
{
  static
  {
    DeleteSnapshotsOption localDeleteSnapshotsOption = new DeleteSnapshotsOption("NONE", 2);
    NONE = localDeleteSnapshotsOption;
    $VALUES = new DeleteSnapshotsOption[] { DELETE_SNAPSHOTS_ONLY, INCLUDE_SNAPSHOTS, localDeleteSnapshotsOption };
  }
  
  public DeleteSnapshotsOption() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.DeleteSnapshotsOption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */