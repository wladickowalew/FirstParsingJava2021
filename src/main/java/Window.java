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
    JLabel price_lbl;

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
                itemsList.setListData(Data.getNamesForID(i));
            }
        });
        add(categoryList);

        itemsList = new JList();
        itemsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int c_i = categoryList.getSelectedIndex();
                int i_i = itemsList.getSelectedIndex();
                price_lbl.setText(Data.getPrice(c_i, i_i));
            }
        });
        JScrollPane itemsScroll = new JScrollPane(itemsList);
        itemsScroll.setBounds(260, 30, 300, 400);
        add(itemsScroll);

        price_lbl = new JLabel("выберите товар");
        price_lbl.setBounds(600, 30, 150, 30);
        add(price_lbl);
    }

}
