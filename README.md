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

### usage

Usage: java HttpsClient httpsUrl keystore keystorepass truststore truststorepass protocol proxyServerHost proxyServerPort

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
Depending the platform, sometimes the HttpsClient can fail with cast exception. In this case, you can try to run the program replacing :

           url = new URL(this.httpsUrl);

by:

           url = new URL(null, this.httpsUrl,  new sun.net.www.protocol.https.Handler());

## SSL tips

A great command that can help to see the server SSL certificate and server TLS information is :

        openssl s_client -connect localhost:12345 -showcerts

        CONNECTED(00000003)
        Can't use SSL_get_servername
        depth=0 C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        verify error:num=18:self-signed certificate
        verify return:1
        depth=0 C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        verify return:1
        ---
        Certificate chain
        0 s:C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        i:C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        a:PKEY: rsaEncryption, 2048 (bit); sigalg: RSA-SHA256
        v:NotBefore: Jan  9 16:32:51 2020 GMT; NotAfter: Jan  9 16:32:51 2025 GMT
        -----BEGIN CERTIFICATE-----
        MIIDZDCCAkygAwIBAgIEXhdVszANBgkqhkiG9w0BAQsFADB0MQswCQYDVQQGEwJG
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        DCCAkygAwIBAgIEXhdVszANBgkqhkiG9w0BAQsFADB0MQswCQYDVQQGEwJGDVQQK
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        BAMMCmFmcy1zZXJ2ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCy
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        BAMMCmFmcy1zZXJ2ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCy
        BfpY+cmugPpkZ5jLzrCTVROxguRHNp6QUxukZspcbY/EGSyGE/tgRGVahMGHGMlv
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        j17tU1shEVFCRuGI/IKr9vMgS5K3Hb5feev5msgGTQcNkwhVjwY+sJ3uBWy9Pot2
        DLRHK2ONqO0=
        -----END CERTIFICATE-----
        ---
        Server certificate
        subject=C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        issuer=C = FR, ST = fr, L = city, O = organization, OU = organization_unit, CN = alternative_name
        ---
        No client certificate CA names sent
        Peer signing digest: SHA256
        Peer signature type: RSA-PSS
        Server Temp Key: ECDH, prime256v1, 256 bits
        ---
        SSL handshake has read 1631 bytes and written 804 bytes
        Verification error: self-signed certificate
        ---
        New, TLSv1.3, Cipher is TLS_AES_256_GCM_SHA384
        Server public key is 2048 bit
        Secure Renegotiation IS NOT supported
        Compression: NONE
        Expansion: NONE
        No ALPN negotiated
        Early data was not sent
        Verify return code: 18 (self-signed certificate)
        ---
        ---
        Post-Handshake New Session Ticket arrived:
        SSL-Session:
        Protocol  : TLSv1.3
        Cipher    : TLS_AES_256_GCM_SHA384
        Session-ID: 77C04AD369802FAE2BF2A27E8B5ACD219D83DE9802FAE2BF2A27E8B5ACD219D83DE
        Session-ID-ctx:
        Resumption PSK: DAA9EAAB40B6FB1217E676E7BEBEBF18D4FF847FD6F26645C12EAAB40B6FB1217E676E7BEBEBF18D4FF847FD6F26645C12
        PSK identity: None
        PSK identity hint: None
        SRP username: None
        TLS session ticket lifetime hint: 86400 (seconds)
        TLS session ticket:
        0000 - 47 33 9f e9 94 92 f8 4e-96 e0 45 59 86 cf 79 aa   fz.....H..EY..y.
        0010 - 33 9f e9 07 94 f6 46 ab-fc 87 39 ad 57 54 79 08   3..A..K...3.ZZ..

        Start Time: 1657370325
        Timeout   : 7200 (sec)
        Verify return code: 18 (self-signed certificate)
        Extended master secret: no
        Max Early Data: 0
        ---
        read R BLOCK

Great graphical tool to manage SSL certificates : keystore explorer.

## build.xml

you can execute :

        ant run

It compiles the java sources and run them. For HttpsClient it executes with one argument only https://github.com. You can change and adapt to your needs.
