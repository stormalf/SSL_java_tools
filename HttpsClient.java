/*
 * code based upon http://www.mkyong.com/java/java-https-client-httpsurlconnection-example retrieved on December 22, 2014
 * and found also in stackoverflow.
 Code updated to test SSL connection using keystore/truststore
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;


public class HttpsClient {
    private String httpsUrl;
    private String proxyServerHost;
    private String proxyServerPort;

    public static void main(String[] args)
    {
        HttpsClient httpsClient = new HttpsClient(); 
        System.setProperty("javax.net.debug","ssl");        
        switch (args.length - 1) {
            case 7:
                httpsClient.setProxyServerPort(args[7]);            
            case 6:
                httpsClient.setProxyServerHost(args[6]);            
            case 5:
                System.setProperty("https.protocols", args[5]);	            
            case 4:
			    System.setProperty("javax.net.ssl.trustStorePassword", args[4]);                
            case 3:                
                System.setProperty("javax.net.ssl.trustStore", args[3]);	                                            
            case 2:                                
			    System.setProperty("javax.net.ssl.keyStorePassword", args[2]);	                
            case 1:                                                
                System.setProperty("javax.net.ssl.keyStore", args[1]);	                
            case 0:                                                                            
                httpsClient.setHttpsUrl(args[0]);  
                break;              
            default: 
                printUsage();
                System.exit(1);
            }
        httpsClient.testIt();
    }

    public static void printUsage() {
        System.out.println("Usage: java HttpsClient httpsUrl keystore keystorepass truststore truststorepass protocol proxyServerHost proxyServerPort");
    }

    private void testIt(){
        URL url;
        try {
           url = new URL(this.httpsUrl);
           HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
           // print certificate info
           print_https_cert(con);
           // print the content
           print_content(con);
        } catch (MalformedURLException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    private void print_https_cert(HttpsURLConnection con){
        System.out.println("###started print_https_cert");
        if(con != null) {
            try {
                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");

                Certificate[] certs = con.getServerCertificates();
                for(Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : "
                            + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : "
                            + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }
            } catch (SSLPeerUnverifiedException e) {
                System.err.println("###SSLPeerUnverifiedException occurred: ");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("###IOException occurred: ");
                e.printStackTrace();
            }
        }
        System.out.println("###finished print_https_cert");
    }

    private void print_content(HttpsURLConnection con){
        System.out.println("###started print_content");
        if(con != null) {
            try {
               System.out.println("****** Content of the URL ********");
               BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
               String input;
               while ((input = br.readLine()) != null) {
                   System.out.println(input);
               }
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
        System.out.println("###finished print_content");
    }

    public void setHttpsUrl(String httpsUrl) {
        this.httpsUrl = httpsUrl;
    }

    public void setProxyServerHost(String proxyServerHost) {
        this.proxyServerHost = proxyServerHost;
    }

    public void setProxyServerPort(String proxyServerPort) {
        this.proxyServerPort = proxyServerPort;
    }
}