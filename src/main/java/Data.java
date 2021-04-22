public class Data {
    static String[] categories;
    static Item[][] items;

    public static String[] getCategories() {
        return categories;
    }

    public static void setCategories(String[] categories) {
        Data.categories = categories;
    }

    public static Item[][] getItems() {
        return items;
    }

    public static String[] getNamesForID(int id) {
        int n = items[id].length;
        String[] ans = new String[n];
        for(int i = 0; i < n ; i++)
            ans[i] = items[id][i].name;
        return ans;
    }



    public static void setItems(Item[][] items) {
        Data.items = items;
    }
}
