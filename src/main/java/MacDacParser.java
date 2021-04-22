import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MacDacParser {

    static Document doc;

    public static void parse() throws IOException {
        String url = "https://mcdonalds.ru/menu/delivery";
        doc = Jsoup.connect(url).get();
    }

    public static String[] getCategories(){
        String q = ".page-catalog section";
        Elements sections = doc.select(q);
        int n = sections.size();
        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
            String qt = ".category-title";
            String text = sections.get(i).select(qt).first().text();
            ans[i] = text;
        }
        return ans;
    }

    public static Item[][] getItems(){
        String q = ".page-catalog section";
        Elements sections = doc.select(q);
        int n = sections.size();
        Item[][] ans = new Item[n][];
        for(int i = 0; i < n; i++) {
            String qt = "ul.menu-catalog li.catalog-product";
            Elements items = sections.get(i).select(qt);
            ans[i] = convertElements(items);
        }
        return ans;
    }

    public static Item[] convertElements(Elements el){
        int n = el.size();
        Item[] ans = new Item[n];
        for (int i = 0; i < n; i++){
            ans[i] = new Item(el.get(i));
        }
        return ans;
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
