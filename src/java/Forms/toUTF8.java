/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author shadi
 */
public class toUTF8 {
     public static String toUTF8(String isoString){
        String utf8String = null;
        if (null != isoString && !isoString.equals("")){
            try{
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
                utf8String = new String(stringBytesISO, "UTF-8");
            }catch(UnsupportedEncodingException e) {
        //  TODO: This should never happen. The UnsupportedEncodingException
        // should be propagated instead of swallowed. This error would indicate
        // a severe misconfiguration of the JVM.
        // As we can't translate just send back the best guess.
        System.out.println("UnsupportedEncodingException is: " +e.getMessage());
        utf8String = isoString;
       }
        }else {
       utf8String = isoString;
        }
        return utf8String;
     }
}
