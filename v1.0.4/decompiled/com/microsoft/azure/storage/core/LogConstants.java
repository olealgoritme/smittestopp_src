package com.microsoft.azure.storage.core;

public class LogConstants
{
  public static final String COMPLETE = "Operation completed.";
  public static final String DO_NOT_RETRY_POLICY = "Retry policy did not allow for a retry. Failing. Error Message = '%s'.";
  public static final String DO_NOT_RETRY_TIMEOUT = "Operation cannot be retried because maximum execution timeout has been reached. Failing. Inner error Message = '%s'.";
  public static final String ERROR_RECEIVING_RESPONSE = "A network error occurred before the HTTP response status and headers were received.";
  public static final String GET_RESPONSE = "Waiting for response.";
  public static final String INIT_LOCATION = "Starting operation with location '%s' per location mode '%s'.";
  public static final String NEXT_LOCATION = "The next location has been set to '%s', per location mode '%s'.";
  public static final String POST_PROCESS = "Processing response body.";
  public static final String POST_PROCESS_DONE = "Response body was parsed successfully.";
  public static final String PRE_PROCESS = "Processing response headers.";
  public static final String PRE_PROCESS_DONE = "Response headers were processed successfully.";
  public static final String RESPONSE_RECEIVED = "Response received. Status code = '%d', Request ID = '%s', Content-MD5 = '%s', ETag = '%s', Date = '%s'.";
  public static final String RETRY = "Retrying failed operation.";
  public static final String RETRYABLE_EXCEPTION = "Retryable exception thrown. Class = '%s', Message = '%s'.";
  public static final String RETRY_CHECK = "Checking if the operation should be retried. Retry count = '%d', HTTP status code = '%d', Error Message = '%s'.";
  public static final String RETRY_DELAY = "Operation will be retried after '%d'ms.";
  public static final String RETRY_INFO = "The retry policy set the next location to '%s' and updated the location mode to '%s'.";
  public static final String SIGNING = "Signing %s";
  public static final String STARTING = "Starting operation.";
  public static final String START_REQUEST = "Starting request to '%s' at '%s'.";
  public static final String UNEXPECTED_RESULT_OR_EXCEPTION = "Operation did not return the expected result or returned an exception.";
  public static final String UNRETRYABLE_EXCEPTION = "Un-retryable exception thrown. Class = '%s', Message = '%s'.";
  public static final String UPLOAD = "Writing request data.";
  public static final String UPLOADDONE = "Request data was written successfully.";
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.LogConstants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */