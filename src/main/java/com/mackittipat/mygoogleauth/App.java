package com.mackittipat.mygoogleauth;

import org.apache.commons.io.FileUtils;
import org.jboss.aerogear.security.otp.Totp;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main( String[] args ) {

        String filePath = args[0];
        String secret;
        try {
            secret = FileUtils.readFileToString(new File(filePath), "UTF-8").trim();
        } catch (IOException e) {
            System.out.println("File does not exist !!!");
            return;
        }

        Totp totp = new Totp(secret);
        String opt = totp.now();
        System.out.println(opt);

        // TODO Copy to clipboard.
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable transferable = new StringSelection("hello");
//        clipboard.setContents(transferable, null);
    }
}
