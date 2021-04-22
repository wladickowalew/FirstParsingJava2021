import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        setBounds(30, 30, 800, 600);
        setTitle("MacDac Parser");
        getContentPane().add(new MyPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class MyPanel extends JPanel{

    public MyPanel(){
        setLayout(null);
        addComponents();
    }

    public void addComponents(){
        JList categoryList = new JList();
        categoryList.setBounds(30, 30, 200, 400);
        categoryList.setListData(Data.getCategories());
        add(categoryList);
    }

}
