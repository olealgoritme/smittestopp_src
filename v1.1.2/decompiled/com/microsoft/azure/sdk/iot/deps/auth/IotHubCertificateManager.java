package com.microsoft.azure.sdk.iot.deps.auth;

import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collection;

public class IotHubCertificateManager
{
  public static final String DEFAULT_CERT = "-----BEGIN CERTIFICATE-----\r\nMIIEMzCCAxugAwIBAgIDCYPzMA0GCSqGSIb3DQEBCwUAME0xCzAJBgNVBAYTAkRF\r\nMRUwEwYDVQQKDAxELVRydXN0IEdtYkgxJzAlBgNVBAMMHkQtVFJVU1QgUm9vdCBD\r\nbGFzcyAzIENBIDIgMjAwOTAeFw0wOTExMDUwODM1NThaFw0yOTExMDUwODM1NTha\r\nME0xCzAJBgNVBAYTAkRFMRUwEwYDVQQKDAxELVRydXN0IEdtYkgxJzAlBgNVBAMM\r\nHkQtVFJVU1QgUm9vdCBDbGFzcyAzIENBIDIgMjAwOTCCASIwDQYJKoZIhvcNAQEB\r\nBQADggEPADCCAQoCggEBANOySs96R+91myP6Oi/WUEWJNTrGa9v+2wBoqOADER03\r\nUAifTUpolDWzU9GUY6cgVq/eUXjsKj3zSEhQPgrfRlWLJ23DEE0NkVJD2IfgXU42\r\ntSHKXzlABF9bfsyjxiupQB7ZNoTWSPOSHjRGICTBpFGOShrvUD9pXRl/RcPHAY9R\r\nySPocq60vFYJfxLLHLGvKZAKyVXMD9O0Gu1HNVpK7ZxzBCHQqr0ME7UAyiZsxGsM\r\nlFqVlNpQmvH/pStmMaTJOKDfHR+4CS7zp+hnUquVH+BGPtikw8paxTGA6Eian5Rp\r\n/hnd2HN8gcqW3o7tszIFZYQ05ub9VxC1X3a/L7AQDcUCAwEAAaOCARowggEWMA8G\r\nA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYEFP3aFMSfMN4hvR5COfyrYyNJ4PGEMA4G\r\nA1UdDwEB/wQEAwIBBjCB0wYDVR0fBIHLMIHIMIGAoH6gfIZ6bGRhcDovL2RpcmVj\r\ndG9yeS5kLXRydXN0Lm5ldC9DTj1ELVRSVVNUJTIwUm9vdCUyMENsYXNzJTIwMyUy\r\nMENBJTIwMiUyMDIwMDksTz1ELVRydXN0JTIwR21iSCxDPURFP2NlcnRpZmljYXRl\r\ncmV2b2NhdGlvbmxpc3QwQ6BBoD+GPWh0dHA6Ly93d3cuZC10cnVzdC5uZXQvY3Js\r\nL2QtdHJ1c3Rfcm9vdF9jbGFzc18zX2NhXzJfMjAwOS5jcmwwDQYJKoZIhvcNAQEL\r\nBQADggEBAH+X2zDI36ScfSF6gHDOFBJpiBSVYEQBrLLpME+bUMJm2H6NMLVwMeni\r\nacfzcNsgFYbQDfC+rAF1hM5+n02/t2A7nPPKHeJeaNijnZflQGDSNiH+0LS4F9p0\r\no3/U37CYAqxva2ssJSRyoWXuJVrl5jLn8t+rSfrzkGkj2wTZ51xY/GXUl77M/C4K\r\nzCUqNQT4YJEVdT1B/yMfGchs64JTBKbkTCJNjYy6zltz7GRUUG3RnFX7acM2w4y8\r\nPIWmawomDeCTmGCufsYkl4phX5GOZpIJhzbNi5stPvZR1FDUWSi9g/LMKHtThm3Y\r\nJohw1+qRzT65ysCQblrGXnRl11z+o+I=\r\n-----END CERTIFICATE-----\r\n-----BEGIN CERTIFICATE-----\r\nMIIDrzCCApegAwIBAgIQCDvgVpBCRrGhdWrJWZHHSjANBgkqhkiG9w0BAQUFADBh\r\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\r\nd3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBD\r\nQTAeFw0wNjExMTAwMDAwMDBaFw0zMTExMTAwMDAwMDBaMGExCzAJBgNVBAYTAlVT\r\nMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\r\nb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IENBMIIBIjANBgkqhkiG\r\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4jvhEXLeqKTTo1eqUKKPC3eQyaKl7hLOllsB\r\nCSDMAZOnTjC3U/dDxGkAV53ijSLdhwZAAIEJzs4bg7/fzTtxRuLWZscFs3YnFo97\r\nnh6Vfe63SKMI2tavegw5BmV/Sl0fvBf4q77uKNd0f3p4mVmFaG5cIzJLv07A6Fpt\r\n43C/dxC//AH2hdmoRBBYMql1GNXRor5H4idq9Joz+EkIYIvUX7Q6hL+hqkpMfT7P\r\nT19sdl6gSzeRntwi5m3OFBqOasv+zbMUZBfHWymeMr/y7vrTC0LUq7dBMtoM1O/4\r\ngdW7jVg/tRvoSSiicNoxBN33shbyTApOB6jtSj1etX+jkMOvJwIDAQABo2MwYTAO\r\nBgNVHQ8BAf8EBAMCAYYwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUA95QNVbR\r\nTLtm8KPiGxvDl7I90VUwHwYDVR0jBBgwFoAUA95QNVbRTLtm8KPiGxvDl7I90VUw\r\nDQYJKoZIhvcNAQEFBQADggEBAMucN6pIExIK+t1EnE9SsPTfrgT1eXkIoyQY/Esr\r\nhMAtudXH/vTBH1jLuG2cenTnmCmrEbXjcKChzUyImZOMkXDiqw8cvpOp/2PV5Adg\r\n06O/nVsJ8dWO41P0jmP6P6fbtGbfYmbW0W5BjfIttep3Sp+dWOIrWcBAI+0tKIJF\r\nPnlUkiaY4IBIqDfv8NZ5YBberOgOzW6sRBc4L0na4UU+Krk2U886UAb3LujEV0ls\r\nYSEY1QSteDwsOoBrp+uvFRTp2InBuThs4pFsiv9kuXclVzDAGySj4dzp30d8tbQk\r\nCAUw7C29C79Fv1C5qfPrmAESrciIxpg0X40KPMbp1ZWVbd4=\r\n-----END CERTIFICATE-----\r\n-----BEGIN CERTIFICATE-----\r\nMIIDdzCCAl+gAwIBAgIEAgAAuTANBgkqhkiG9w0BAQUFADBaMQswCQYDVQQGEwJJ\r\nRTESMBAGA1UEChMJQmFsdGltb3JlMRMwEQYDVQQLEwpDeWJlclRydXN0MSIwIAYD\r\nVQQDExlCYWx0aW1vcmUgQ3liZXJUcnVzdCBSb290MB4XDTAwMDUxMjE4NDYwMFoX\r\nDTI1MDUxMjIzNTkwMFowWjELMAkGA1UEBhMCSUUxEjAQBgNVBAoTCUJhbHRpbW9y\r\nZTETMBEGA1UECxMKQ3liZXJUcnVzdDEiMCAGA1UEAxMZQmFsdGltb3JlIEN5YmVy\r\nVHJ1c3QgUm9vdDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKMEuyKr\r\nmD1X6CZymrV51Cni4eiVgLGw41uOKymaZN+hXe2wCQVt2yguzmKiYv60iNoS6zjr\r\nIZ3AQSsBUnuId9Mcj8e6uYi1agnnc+gRQKfRzMpijS3ljwumUNKoUMMo6vWrJYeK\r\nmpYcqWe4PwzV9/lSEy/CG9VwcPCPwBLKBsua4dnKM3p31vjsufFoREJIE9LAwqSu\r\nXmD+tqYF/LTdB1kC1FkYmGP1pWPgkAx9XbIGevOF6uvUA65ehD5f/xXtabz5OTZy\r\ndc93Uk3zyZAsuT3lySNTPx8kmCFcB5kpvcY67Oduhjprl3RjM71oGDHweI12v/ye\r\njl0qhqdNkNwnGjkCAwEAAaNFMEMwHQYDVR0OBBYEFOWdWTCCR1jMrPoIVDaGezq1\r\nBE3wMBIGA1UdEwEB/wQIMAYBAf8CAQMwDgYDVR0PAQH/BAQDAgEGMA0GCSqGSIb3\r\nDQEBBQUAA4IBAQCFDF2O5G9RaEIFoN27TyclhAO992T9Ldcw46QQF+vaKSm2eT92\r\n9hkTI7gQCvlYpNRhcL0EYWoSihfVCr3FvDB81ukMJY2GQE/szKN+OMY3EU/t3Wgx\r\njkzSswF07r51XgdIGn9w/xZchMB5hbgF/X++ZRGjD8ACtPhSNzkE1akxehi/oCr0\r\nEpn3o0WC4zxe9Z2etciefC7IpJ5OCBRLbf1wbWsaY71k5h+3zvDyny67G7fyUIhz\r\nksLi4xaNmjICq44Y3ekQEe5+NauQrz4wlHrQMz2nZQ/1/I6eYs9HRCwBXbsdtTLS\r\nR9I4LtD+gdwyah617jzV/OeBHRnDJELqYzmp\r\n-----END CERTIFICATE-----\r\n";
  public CertificateFactory certificateFactory;
  public Collection<? extends Certificate> certificates;
  
  /* Error */
  public IotHubCertificateManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 17	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 19
    //   7: invokestatic 25	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   10: putfield 27	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificateFactory	Ljava/security/cert/CertificateFactory;
    //   13: new 29	java/io/ByteArrayInputStream
    //   16: dup
    //   17: ldc 8
    //   19: invokevirtual 35	java/lang/String:getBytes	()[B
    //   22: invokespecial 38	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: astore_1
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 27	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificateFactory	Ljava/security/cert/CertificateFactory;
    //   31: aload_1
    //   32: invokevirtual 42	java/security/cert/CertificateFactory:generateCertificates	(Ljava/io/InputStream;)Ljava/util/Collection;
    //   35: putfield 44	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificates	Ljava/util/Collection;
    //   38: aload_1
    //   39: invokevirtual 49	java/io/InputStream:close	()V
    //   42: return
    //   43: astore_2
    //   44: aload_2
    //   45: athrow
    //   46: astore_3
    //   47: aload_1
    //   48: invokevirtual 49	java/io/InputStream:close	()V
    //   51: goto +9 -> 60
    //   54: astore_1
    //   55: aload_2
    //   56: aload_1
    //   57: invokevirtual 55	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   60: aload_3
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	IotHubCertificateManager
    //   25	23	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   54	3	1	localThrowable	Throwable
    //   43	13	2	localObject1	Object
    //   46	15	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	38	43	finally
    //   44	46	46	finally
    //   47	51	54	finally
  }
  
  public Collection<? extends Certificate> getCertificateCollection()
  {
    return certificates;
  }
  
  /* Error */
  public void setCertificates(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +80 -> 81
    //   4: aload_1
    //   5: invokevirtual 66	java/lang/String:isEmpty	()Z
    //   8: ifne +73 -> 81
    //   11: new 29	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_1
    //   16: invokevirtual 35	java/lang/String:getBytes	()[B
    //   19: invokespecial 38	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: astore_2
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 27	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificateFactory	Ljava/security/cert/CertificateFactory;
    //   28: aload_2
    //   29: invokevirtual 42	java/security/cert/CertificateFactory:generateCertificates	(Ljava/io/InputStream;)Ljava/util/Collection;
    //   32: putfield 44	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificates	Ljava/util/Collection;
    //   35: aload_2
    //   36: invokevirtual 49	java/io/InputStream:close	()V
    //   39: aload_0
    //   40: getfield 44	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificates	Ljava/util/Collection;
    //   43: invokeinterface 69 1 0
    //   48: ifne +4 -> 52
    //   51: return
    //   52: new 71	java/lang/IllegalArgumentException
    //   55: dup
    //   56: ldc 73
    //   58: invokespecial 75	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: astore_1
    //   63: aload_1
    //   64: athrow
    //   65: astore_3
    //   66: aload_2
    //   67: invokevirtual 49	java/io/InputStream:close	()V
    //   70: goto +9 -> 79
    //   73: astore_2
    //   74: aload_1
    //   75: aload_2
    //   76: invokevirtual 55	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   79: aload_3
    //   80: athrow
    //   81: new 71	java/lang/IllegalArgumentException
    //   84: dup
    //   85: ldc 77
    //   87: invokespecial 75	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	IotHubCertificateManager
    //   0	91	1	paramString	String
    //   22	45	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   73	3	2	localThrowable	Throwable
    //   65	15	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	35	62	finally
    //   63	65	65	finally
    //   66	70	73	finally
  }
  
  /* Error */
  public void setCertificatesPath(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +77 -> 78
    //   4: aload_1
    //   5: invokevirtual 66	java/lang/String:isEmpty	()Z
    //   8: ifne +70 -> 78
    //   11: new 80	java/io/FileInputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 27	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificateFactory	Ljava/security/cert/CertificateFactory;
    //   25: aload_2
    //   26: invokevirtual 42	java/security/cert/CertificateFactory:generateCertificates	(Ljava/io/InputStream;)Ljava/util/Collection;
    //   29: putfield 44	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificates	Ljava/util/Collection;
    //   32: aload_2
    //   33: invokevirtual 82	java/io/FileInputStream:close	()V
    //   36: aload_0
    //   37: getfield 44	com/microsoft/azure/sdk/iot/deps/auth/IotHubCertificateManager:certificates	Ljava/util/Collection;
    //   40: invokeinterface 69 1 0
    //   45: ifne +4 -> 49
    //   48: return
    //   49: new 71	java/lang/IllegalArgumentException
    //   52: dup
    //   53: ldc 84
    //   55: invokespecial 75	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: athrow
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 82	java/io/FileInputStream:close	()V
    //   67: goto +9 -> 76
    //   70: astore_2
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 55	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   76: aload_3
    //   77: athrow
    //   78: new 71	java/lang/IllegalArgumentException
    //   81: dup
    //   82: ldc 86
    //   84: invokespecial 75	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	IotHubCertificateManager
    //   0	88	1	paramString	String
    //   19	45	2	localFileInputStream	java.io.FileInputStream
    //   70	3	2	localThrowable	Throwable
    //   62	15	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	32	59	finally
    //   60	62	62	finally
    //   63	67	70	finally
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.auth.IotHubCertificateManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */