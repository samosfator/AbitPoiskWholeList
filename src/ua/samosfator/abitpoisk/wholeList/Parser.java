package ua.samosfator.abitpoisk.wholeList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    private String baseURL = "http://abit-poisk.org.ua/rate2013/direction_archive/";
    private String title;
    private String id;
    private int pages;

    public Parser(String id) throws IOException {
        String url = baseURL + id + "/2013-07-31";
        this.id = id;
        this.pages = getPageNumber(url);
        this.title = Jsoup.connect(url).timeout(0).get().title();
    }

    public String getHtml(String date) throws IOException {
        String html = "";

        for (int i = 1; i < pages + 1; i++) {
            String url = baseURL + id + "/" + date + "/?page=" + i;
            if (date.contains("08-30")) url = "http://abit-poisk.org.ua/rate2013/direction/" + id + "/?page=" + i;

            Document nextPage = Jsoup.connect(url).timeout(0).get();
            nextPage.select("script").remove();
            nextPage.select(".pagination").remove();

            if (i != 1) {
                Element tbody = nextPage.select("tbody").first();

                Document readyHtml = Jsoup.parse(html);
                readyHtml.select("tbody").last().after(tbody.html());

                html = readyHtml.html();
            } else html += nextPage;

            System.out.println(url);
        }

        return html;
    }

    private static int getPageNumber(String url) throws IOException {
        int pageNumber = 0;

        Document doc = Jsoup.connect(url).timeout(0).get();
        Elements li = doc.select(".pagination-sm").first().select("li");

        pageNumber = Integer.parseInt(li.eq(li.size() - 2).select("a").text());

        return pageNumber;
    }

    public String getFileName(String date) throws IOException {
        return date + title.substring(40);
    }
}
