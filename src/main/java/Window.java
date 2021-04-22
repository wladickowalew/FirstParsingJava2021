import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    JList categoryList, itemsList;

    public MyPanel(){
        setLayout(null);
        addComponents();
    }

    public void addComponents(){
        categoryList = new JList();
        categoryList.setBounds(30, 30, 200, 400);
        categoryList.setListData(Data.getCategories());
        categoryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int i = categoryList.getSelectedIndex();
                itemsList.setListData(Data.getItemsForID(i));
            }
        });
        add(categoryList);

        itemsList = new JList();
        itemsList.setBounds(260, 30, 300, 400);
        add(itemsList);
    }

}
