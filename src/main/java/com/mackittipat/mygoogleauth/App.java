package com.mackittipat.mygoogleauth;

import org.jboss.aerogear.security.otp.Totp;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class App {
    public static void main( String[] args ) {

        // Hide Java coffee cup icon from Dock in Mac OS.
        System.setProperty("apple.awt.UIElement", "true");

        System.out.println("=============== my-google-auth ==============");
        System.out.println("https://github.com/MacKittipat/my-google-auth");


        // Read config file.
        String filePath = args[0];
        InputStream input;
        try {
            input = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist !!!");
            return;
        }

        Yaml yaml = new Yaml();
        Map<String, String> data = (Map) yaml.load(input);
        String secret = data.get("secret");
        String prefixPwd = data.get("prefix-password");

        // Generate OTP.
        Totp totp = new Totp(secret);
        String opt = totp.now();
        System.out.println("===== OPT =====");
        System.out.println(opt);

        // Copy OTP to clipboard.
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(prefixPwd + opt);
        clipboard.setContents(transferable, null);
    }
}
