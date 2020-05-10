package com.microsoft.azure.storage.table;

public enum TablePayloadFormat
{
  static
  {
    Json = new TablePayloadFormat("Json", 1);
    TablePayloadFormat localTablePayloadFormat = new TablePayloadFormat("JsonNoMetadata", 2);
    JsonNoMetadata = localTablePayloadFormat;
    $VALUES = new TablePayloadFormat[] { JsonFullMetadata, Json, localTablePayloadFormat };
  }
  
  public TablePayloadFormat() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TablePayloadFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */