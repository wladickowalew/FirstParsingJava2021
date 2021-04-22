import org.jsoup.nodes.Element;

public class Item {
    public String name;
    public String price;
    public String img_link;

    public Item(Element element){
        String qt = ".catalog-product__content .catalog-product-title";
        name  = element.select(qt).first().text();
        String qp = ".catalog-product__content .catalog-product__price";
        price = element.select(qp).first().text();
        img_link = "no_image";
    }
}
