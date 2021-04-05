import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MyParser {
    public static void wikiTest() throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn ul li b a");
        for (Element headline : newsHeadlines) {
            log(headline.attr("title"));
            log(headline.absUrl("href"));
        }
    }

    public static void avitoTest() throws IOException {
        Document doc = Jsoup.connect("https://www.avito.ru/smolensk").get();
        log(doc.title());
        Elements divs = doc.select(".carousel-list-1efLg .story-previewer-title-eJkxt");
        for (Element headline : divs) {
            log(headline.text());
        }
    }

    public static void log(String s){
        System.out.println(s);
    }
}
