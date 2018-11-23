import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class frame extends abstractClass {

    frame() {

        JFrame frame = new JFrame("sql");
        JLabel panel=new JLabel(new ImageIcon("C:\\Users\\Konrad\\Pictures\\Gray-Background.png"));

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getWidth()/2,dim.height/2-frame.getHeight()/2);
        panel.add(jta);

        Font font = new Font("Arial Rounded MT Bold", Font.ITALIC, 15);
        jta.setFont(font);
        jta.setBounds(0, 110, 395, 250);
        jta.setMargin(new Insets(0, 0, 0, 0));
        jta.setLineWrap(true);

        panel.add(button);
        button.setBounds(5, 410, 200, 30);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBackground(Color.WHITE);

        panel.add(button1);
        button1.setBounds(5, 440, 200, 30);
        button1.setMargin(new Insets(0, 0, 0, 0));
        button1.setBackground(Color.WHITE);

        button.addActionListener(e -> new jdbc());

        button1.addActionListener(ex -> {
            String str=jta.getText();
            try {
                PrintWriter zapis = new PrintWriter("zapis.txt");
                zapis.println(str);
                zapis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(str);
        });
    }
}
