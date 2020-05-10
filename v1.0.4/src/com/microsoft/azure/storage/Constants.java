package com.microsoft.azure.storage;

public final class Constants
{
  public static final String ACCESS_POLICY = "AccessPolicy";
  public static final String ACCESS_TIER = "AccessTier";
  public static final String ACCESS_TIER_CHANGE_TIME = "AccessTierChangeTime";
  public static final String ACCESS_TIER_INFERRED = "AccessTierInferred";
  public static final String ARCHIVE_STATUS = "ArchiveStatus";
  public static final int BUFFER_COPY_LENGTH = 8192;
  public static final String COPY_COMPLETION_TIME_ELEMENT = "CopyCompletionTime";
  public static final String COPY_DESTINATION_SNAPSHOT_ID_ELEMENT = "CopyDestinationSnapshot";
  public static final String COPY_ID_ELEMENT = "CopyId";
  public static final String COPY_PROGRESS_ELEMENT = "CopyProgress";
  public static final String COPY_SOURCE_ELEMENT = "CopySource";
  public static final String COPY_STATUS_DESCRIPTION_ELEMENT = "CopyStatusDescription";
  public static final String COPY_STATUS_ELEMENT = "CopyStatus";
  public static final int DEFAULT_MINIMUM_READ_SIZE_IN_BYTES = 4194304;
  public static final int DEFAULT_READ_TIMEOUT = 300000;
  public static final int DEFAULT_STREAM_WRITE_IN_BYTES = 4194304;
  public static final String DELIMITER_ELEMENT = "Delimiter";
  public static final String EMPTY_STRING = "";
  public static final String END_ELEMENT = "End";
  public static final String ERROR_CODE = "Code";
  public static final String ERROR_EXCEPTION = "ExceptionDetails";
  public static final String ERROR_EXCEPTION_MESSAGE = "ExceptionMessage";
  public static final String ERROR_EXCEPTION_STACK_TRACE = "StackTrace";
  public static final String ERROR_MESSAGE = "Message";
  public static final String ERROR_ROOT_ELEMENT = "Error";
  public static final String ETAG_ELEMENT = "Etag";
  public static final String EXPIRY = "Expiry";
  public static final String FALSE = "false";
  public static final int GB = 1073741824;
  public static final String GEO_BOOTSTRAP_VALUE = "bootstrap";
  public static final String GEO_LIVE_VALUE = "live";
  public static final String GEO_UNAVAILABLE_VALUE = "unavailable";
  public static final String HTTP = "http";
  public static final String HTTPS = "https";
  public static final String HTTPS_HTTP = "https,http";
  public static final String HTTP_DELETE = "DELETE";
  public static final String HTTP_GET = "GET";
  public static final String HTTP_HEAD = "HEAD";
  public static final String HTTP_POST = "POST";
  public static final String HTTP_PUT = "PUT";
  public static final String ID = "Id";
  public static final String INCREMENTAL_COPY_ELEMENT = "IncrementalCopy";
  public static final String INVALID_METADATA_NAME = "x-ms-invalid-name";
  public static final int KB = 1024;
  public static final String LAST_MODIFIED_ELEMENT = "Last-Modified";
  public static final int LEASE_BREAK_PERIOD_MAX = 60;
  public static final int LEASE_BREAK_PERIOD_MIN = 0;
  public static final String LEASE_DURATION_ELEMENT = "LeaseDuration";
  public static final int LEASE_DURATION_MAX = 60;
  public static final int LEASE_DURATION_MIN = 15;
  public static final String LEASE_STATE_ELEMENT = "LeaseState";
  public static final String LEASE_STATUS_ELEMENT = "LeaseStatus";
  public static final String LOCKED_VALUE = "Locked";
  public static final String MARKER_ELEMENT = "Marker";
  public static final int MAXIMUM_SEGMENTED_RESULTS = 5000;
  public static int MAX_APPEND_BLOCK_SIZE = 4194304;
  public static final long MAX_BLOB_SIZE = 104857600 * 50000L;
  public static final long MAX_BLOCK_NUMBER = 50000L;
  public static int MAX_BLOCK_SIZE = 104857600;
  public static int MAX_FILE_WRITE_SIZE = 4194304;
  public static final int MAX_MARK_LENGTH = 268435456;
  public static int MAX_PAGE_WRITE_SIZE = 4194304;
  public static int MAX_RANGE_CONTENT_MD5 = 4194304;
  public static final String MAX_RESULTS_ELEMENT = "MaxResults";
  public static final int MAX_SHARED_ACCESS_POLICY_IDENTIFIERS = 5;
  public static final int MB = 1048576;
  public static final String METADATA_ELEMENT = "Metadata";
  public static int MIN_LARGE_BLOCK_SIZE = 4194305;
  public static final int MIN_PERMITTED_BLOCK_SIZE = 16384;
  public static int MIN_PERMITTED_FILE_WRITE_SIZE = 512;
  public static final String NAME_ELEMENT = "Name";
  public static final String NEXT_MARKER_ELEMENT = "NextMarker";
  public static final int PAGE_SIZE = 512;
  public static final String PERMISSION = "Permission";
  public static final String PREFIX_ELEMENT = "Prefix";
  public static final String PREFIX_FOR_STORAGE_HEADER = "x-ms-";
  public static final String PROPERTIES = "Properties";
  public static final String PUBLIC_ACCESS_ELEMENT = "PublicAccess";
  public static final String SERVER_ENCRYPTION_STATUS_ELEMENT = "ServerEncrypted";
  public static final String SIGNED_IDENTIFIERS_ELEMENT = "SignedIdentifiers";
  public static final String SIGNED_IDENTIFIER_ELEMENT = "SignedIdentifier";
  public static final String START = "Start";
  public static final int SUBSTREAM_BUFFER_SIZE = 4194304;
  public static final String TRUE = "true";
  public static final String UNLOCKED_VALUE = "Unlocked";
  public static final String UNSPECIFIED_VALUE = "Unspecified";
  public static final String URL_ELEMENT = "Url";
  public static final String UTF8_CHARSET = "UTF-8";
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.Constants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */