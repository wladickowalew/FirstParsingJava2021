import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import static java.net.Proxy.Type.HTTP;

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

    public static String getShitYandexMacLink(String name) throws UnsupportedEncodingException {
        String URL = "https://yandex.ru/images/search?text=" + URLEncoder.encode(name, java.nio.charset.StandardCharsets.UTF_8.toString());
        System.out.println(URL);
        try {
            Document html = Jsoup.connect(URL).get();
            //System.out.println(html.title());
            System.out.println(html);
            Element object = html.select(".serp-item__thumb").first();
            System.out.println(object);
            String url = object.absUrl("src");
            return url;
        }catch(Exception e){
            System.out.println("Error Yandex");
            return null;
        }
    }

    public static Image downloadImage(String url_str){
        Image image = null;
        try {
            URL url = new URL(url_str);
            image = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("Failed download: " + url_str);
        }
        return image;
    }

    public static void log(String s){
        System.out.println(s);
    }
}
