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

    public static void avitoTest(String query) throws IOException {
        String url = "https://www.avito.ru/smolensk?q="+query;
        String q = ".items-items-38oUm div[data-marker=\"item\"] .iva-item-body-NPl6W";
        Document doc = Jsoup.connect(url).get();
        Elements sp = doc.select(q);
        for (Element item: sp) {
            String qt = ".iva-item-titleStep-2bjuh a";
            String text = item.select(qt).first().text();
            String qp = ".iva-item-priceStep-2qRpg .price-root-1n2wM";
            String price = item.select(qp).first().text();
            log(text + " - " + price);
        }
    }

    public static void log(String s){
        System.out.println(s);
    }
}
