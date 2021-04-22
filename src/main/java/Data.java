public class Data {
    static String[] categories;
    static String[][] items;

    public static String[] getCategories() {
        return categories;
    }

    public static void setCategories(String[] categories) {
        Data.categories = categories;
    }

    public static String[][] getItems() {
        return items;
    }

    public static String[] getItemsForID(int id) {
        return items[id];
    }

    public static void setItems(String[][] items) {
        Data.items = items;
    }
}
