package ua.samosfator.abitpoisk.wholeList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConfigReader config = new ConfigReader("config.txt");
        for (String s : config.getDirections()) {
            Parser parser = new Parser(s);
            for (String date : ConfigReader.getDates()) {
                HTMLwriter.write(parser.getHtml(date), parser.getFileName(date));
            }
        }
    }
}
