package ua.samosfator.abitpoisk.wholeList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HTMLwriter {
    public static void write(String html, String name) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter(name.replaceAll("[^а-яА-ЯЄЮЇІяєюїі0-9\\.\\-]", " ").substring(0, 128) + ".html", "UTF-8");
        pw.write(html);
        pw.flush();
        pw.close();
    }
}
