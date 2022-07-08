# SSL_java_tools

SSL java small tools is a repository with useful small tools to test SSL connection in command line or to print protocols allowed.
All the examples are found in stackoverflow and personalized to add some more features like truststore and keystore.

## tls

tls is a small tool to print protocols allowed/supported by java

To compile it :

    javac tls.java

### example

java tls

    [TLSv1.3, TLSv1.2, SSLv2Hello]

## HttpsClient

HttpsClient sends details about success or failure of connection to server using SSL.
You can test using several protocols and print details about success or failure.

To compile it :

        javac HttpsClient.java

### examples

java HttpsClient https://your_url:your_port your_keystore.jks yourpass your_truststore.jks yourpass

    javax.net.ssl|DEBUG|01|main|2022-07-08 23:33:14.886 CEST|SSLCipher.java:464|jdk.tls.keyLimits:  entry = AES/GCM/NoPadding KeyUpdate 2^37. AES/GCM/NOPADDING:KEYUPDATE = 137438953472
    ###started print_https_cert
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:33:15.110 CEST|SSLCipher.java:1866|KeyLimit read side: algorithm = AES/GCM/NOPADDING:KEYUPDATE
    countdown value = 137438953472
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:33:15.111 CEST|SSLCipher.java:2020|KeyLimit write side: algorithm = AES/GCM/NOPADDING:KEYUPDATE
    countdown value = 137438953472
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:33:15.172 CEST|SSLCipher.java:1866|KeyLimit read side: algorithm = AES/GCM/NOPADDING:KEYUPDATE
    countdown value = 137438953472
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:33:15.173 CEST|SSLCipher.java:2020|KeyLimit write side: algorithm = AES/GCM/NOPADDING:KEYUPDATE
    countdown value = 137438953472
    Response Code : 401
    Cipher Suite : TLS_AES_256_GCM_SHA384


    Cert Type : X.509
    Cert Hash Code : -1964062539
    Cert Public Key Algorithm : RSA
    Cert Public Key Format : X.509


    ###finished print_https_cert
    ###started print_content
    ****** Content of the URL ********

java HttpsClient https://your_url:your_port your_keystore.jks yourpass your_truststore.jks yourpass TLSv1

    javax.net.ssl|DEBUG|01|main|2022-07-08 23:36:11.507 CEST|SSLCipher.java:464|jdk.tls.keyLimits:  entry = AES/GCM/NoPadding KeyUpdate 2^37. AES/GCM/NOPADDING:KEYUPDATE = 137438953472
    ###started print_https_cert
    javax.net.ssl|ERROR|01|main|2022-07-08 23:36:11.640 CEST|TransportContext.java:345|Fatal (HANDSHAKE_FAILURE): Couldn't kickstart handshaking (
    "throwable" : {
    javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
            at java.base/sun.security.ssl.HandshakeContext.<init>(HandshakeContext.java:170)
            at java.base/sun.security.ssl.ClientHandshakeContext.<init>(ClientHandshakeContext.java:103)
            at java.base/sun.security.ssl.TransportContext.kickstart(TransportContext.java:222)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:449)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:427)
            at java.base/sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:572)
            at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:197)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1592)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)
            at java.base/java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:527)
            at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getResponseCode(HttpsURLConnectionImpl.java:334)
            at HttpsClient.print_https_cert(HttpsClient.java:74)
            at HttpsClient.testIt(HttpsClient.java:60)
            at HttpsClient.main(HttpsClient.java:47)}

    )
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:36:11.640 CEST|SSLSocketImpl.java:1736|close the underlying socket
    javax.net.ssl|DEBUG|01|main|2022-07-08 23:36:11.641 CEST|SSLSocketImpl.java:1755|close the SSL connection (initiative)
    ###IOException occurred:
    javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
            at java.base/sun.security.ssl.HandshakeContext.<init>(HandshakeContext.java:170)
            at java.base/sun.security.ssl.ClientHandshakeContext.<init>(ClientHandshakeContext.java:103)
            at java.base/sun.security.ssl.TransportContext.kickstart(TransportContext.java:222)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:449)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:427)
            at java.base/sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:572)
            at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:197)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1592)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)
            at java.base/java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:527)
            at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getResponseCode(HttpsURLConnectionImpl.java:334)
            at HttpsClient.print_https_cert(HttpsClient.java:74)
            at HttpsClient.testIt(HttpsClient.java:60)
            at HttpsClient.main(HttpsClient.java:47)
    ###finished print_https_cert
    ###started print_content
    ****** Content of the URL ********
    javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
            at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
            at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
            at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
            at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
            at java.base/sun.net.www.protocol.http.HttpURLConnection$10.run(HttpURLConnection.java:1974)
            at java.base/sun.net.www.protocol.http.HttpURLConnection$10.run(HttpURLConnection.java:1969)
            at java.base/java.security.AccessController.doPrivileged(Native Method)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getChainedException(HttpURLConnection.java:1968)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1536)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)
            at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:250)
            at HttpsClient.print_content(HttpsClient.java:104)
            at HttpsClient.testIt(HttpsClient.java:62)
            at HttpsClient.main(HttpsClient.java:47)
    Caused by: javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
            at java.base/sun.security.ssl.HandshakeContext.<init>(HandshakeContext.java:170)
            at java.base/sun.security.ssl.ClientHandshakeContext.<init>(ClientHandshakeContext.java:103)
            at java.base/sun.security.ssl.TransportContext.kickstart(TransportContext.java:222)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:449)
            at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:427)
            at java.base/sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:572)
            at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:197)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1592)
            at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)
            at java.base/java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:527)
            at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getResponseCode(HttpsURLConnectionImpl.java:334)
            at HttpsClient.print_https_cert(HttpsClient.java:74)
            at HttpsClient.testIt(HttpsClient.java:60)
            ... 1 more
    ###finished print_content

### Remarks

I didn't test the proxy parameters (proxyHost, proxyPort).
