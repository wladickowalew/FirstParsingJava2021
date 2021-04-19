import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MacDacParser {

    public static void parse() throws IOException {
        String url = "https://mcdonalds.ru/menu/delivery";
        String q = ".page-catalog section";
        Document doc = Jsoup.connect(url).get();
        Elements sections = doc.select(q);
        for(Element section: sections)
            parseSection(section);
    }

    public static void parseSection(Element section) throws IOException {
        String qt = ".category-title";
        String text = section.select(qt).first().text();
        log(text);
        String q = "ul.menu-catalog li.catalog-product";
        Elements items = section.select(q);
        for(int i = 0; i < items.size(); i++)
            parseItem(items.get(i), i + 1);
    }

    public static void parseItem(Element item, int ind) throws IOException {
        String qt = ".catalog-product__content .catalog-product-title";
        String text = item.select(qt).first().text();
        String qp = ".catalog-product__content .catalog-product__price";
        String price = item.select(qp).first().text();
        System.out.println("    "+ind + " " + text + " - " + price);
    }

    public static void log(String s){
        System.out.println(s);
    }
}
