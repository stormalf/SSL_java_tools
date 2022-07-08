import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import javax.net.ssl.SSLContext;

public class tls {
    private static String getActiveProtocols() {
        try {
            return Arrays.toString(SSLContext.getDefault().createSSLEngine().getEnabledProtocols());
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            return "Unable to get enabled protocols: " + e.getMessage()  + stringWriter;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getActiveProtocols());
    }

}