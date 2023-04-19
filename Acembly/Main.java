import javax.swing.*; // JFrame, JPanel, JButton, JLabel, JSplitPane
import java.awt.*; // GridLayout, FlowLayout, Dimension
import java.awt.event.*; // ActionEvent, ActionListener

public class Main { // Main class

    public static void main(String[] args) {  // Main method
    
        JFrame frame = new JFrame("Acembly"); // Frame oluşturuldu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Çarpıya basınca kapanması için
       
        // sol panelde logo ekleme
        ImageIcon logoIcon = new ImageIcon("logo.png"); // logo.png dosyasını ImageIcon nesnesine atadık
        JLabel logoLabel = new JLabel(logoIcon); // logoLabel adında JLabel nesnesi oluşturduk ve içine logoIcon nesnesini attık,
        logoLabel.setPreferredSize(new Dimension(600, 100)); // logoLabel nesnesinin boyutunu ayarladık **gereksiz kod -dolcek :P
      
        
        JPanel leftPanel = new JPanel(); // leftPanel adında JPanel nesnesi oluşturduk
        leftPanel.setLayout(new GridLayout(6, 1)); // leftPanel nesnesinin layoutunu GridLayout olarak ayarladık
        leftPanel.add(logoLabel); // leftPanel nesnesine logoLabel nesnesini ekledik

        JButton button1 = new JButton("Python"); // button1 adında JButton nesnesi oluşturduk ve içine "Python" yazısını attık
        JButton button2 = new JButton("Java"); // button2 adında JButton nesnesi oluşturduk ve içine "Java" yazısını attık
        JButton button3 = new JButton("HTML"); // button3 adında JButton nesnesi oluşturduk ve içine "HTML" yazısını attık

        leftPanel.add(button1); // leftPanel nesnesine button1 nesnesini ekledik
        leftPanel.add(button2); // leftPanel nesnesine button2 nesnesini ekledik
        leftPanel.add(button3); // leftPanel nesnesine button3 nesnesini ekledik

        JPanel rightPanel = new JPanel(); // rightPanel adında JPanel nesnesi oluşturduk
        rightPanel.setLayout(new FlowLayout()); // rightPanel nesnesinin layoutunu FlowLayout olarak ayarladık

        button1.addActionListener(new ActionListener() { // button1 nesnesine tıklandığında yapılacak işlemleri belirttik
          public void actionPerformed(ActionEvent e) { // button1 nesnesine tıklandığında yapılacak işlemleri belirttik
                JButton selamButton = new JButton("Ders1"); // selamButton adında JButton nesnesi oluşturduk ve içine "Ders1" yazısını attık
                selamButton.setPreferredSize(new Dimension(100, 50)); // selamButton nesnesinin boyutunu ayarladık
                rightPanel.add(selamButton); // rightPanel nesnesine selamButton nesnesini ekledik
                frame.validate(); // frame nesnesinin boyutunu yeniden hesaplatıyor
                frame.repaint(); // frame nesnesini yeniden çiziyor

                selamButton.addActionListener(new ActionListener() { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                    public void actionPerformed(ActionEvent e) { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                        JFrame newFrame = new JFrame("Merhaba!"); // newFrame adında JFrame nesnesi oluşturduk ve içine "Merhaba!" yazısını attık   
                        JLabel label = new JLabel("Merhaba!"); // label adında JLabel nesnesi oluşturduk ve içine "Merhaba!" yazısını attık
                        newFrame.add(label); // newFrame nesnesine label nesnesini ekledik
                        newFrame.setSize(200, 100); // newFrame nesnesinin boyutunu ayarladık
                        newFrame.setVisible(true); // newFrame nesnesini görünür yaptık
                    }
                }); 
            }
        });

        button2.addActionListener(new ActionListener() { // button2 nesnesine tıklandığında yapılacak işlemleri belirttik
            public void actionPerformed(ActionEvent e) { // button2 nesnesine tıklandığında yapılacak işlemleri belirttik
                JButton selamButton = new JButton("Ders1"); // selamButton adında JButton nesnesi oluşturduk ve içine "Ders1" yazısını attık
                selamButton.setPreferredSize(new Dimension(100, 50)); // selamButton nesnesinin boyutunu ayarladık
                rightPanel.add(selamButton); // rightPanel nesnesine selamButton nesnesini ekledik
                frame.validate(); // frame nesnesinin boyutunu yeniden hesaplatıyor
                frame.repaint(); // frame nesnesini yeniden çiziyor
 
                selamButton.addActionListener(new ActionListener() { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                    public void actionPerformed(ActionEvent e) { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                        JFrame newFrame = new JFrame("Merhaba!"); // newFrame adında JFrame nesnesi oluşturduk ve içine "Merhaba!" yazısını attık
                        JLabel label = new JLabel("Merhaba!"); // label adında JLabel nesnesi oluşturduk ve içine "Merhaba!" yazısını attık
                        newFrame.add(label); // newFrame nesnesine label nesnesini ekledik
                        newFrame.setSize(200, 100); // newFrame nesnesinin boyutunu ayarladık
                        newFrame.setVisible(true); // newFrame nesnesini görünür yaptık
                    }
                });
            }
        });

        button3.addActionListener(new ActionListener() { // button3 nesnesine tıklandığında yapılacak işlemleri belirttik
            public void actionPerformed(ActionEvent e) { // button3 nesnesine tıklandığında yapılacak işlemleri belirttik
                JButton selamButton = new JButton("Ders1"); // selamButton adında JButton nesnesi oluşturduk ve içine "Ders1" yazısını attık
                selamButton.setPreferredSize(new Dimension(100, 50)); // selamButton nesnesinin boyutunu ayarladık
                rightPanel.add(selamButton); // rightPanel nesnesine selamButton nesnesini ekledik
                frame.validate(); // frame nesnesinin boyutunu yeniden hesaplatıyor
                frame.repaint(); // frame nesnesini yeniden çiziyor

                selamButton.addActionListener(new ActionListener() { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                    public void actionPerformed(ActionEvent e) { // selamButton nesnesine tıklandığında yapılacak işlemleri belirttik
                        JFrame newFrame = new JFrame("Merhaba!"); // newFrame adında JFrame nesnesi oluşturduk ve içine "Merhaba!" yazısını attık
                        JLabel label = new JLabel("Merhaba!"); // label adında JLabel nesnesi oluşturduk ve içine "Merhaba!" yazısını attık
                        newFrame.add(label); // newFrame nesnesine label nesnesini ekledik
                        newFrame.setSize(200, 100); // newFrame nesnesinin boyutunu ayarladık
                        newFrame.setVisible(true); // newFrame nesnesini görünür yaptık
                    }
                });
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel); // splitPane adında JSplitPane nesnesi oluşturduk ve içine leftPanel ve rightPanel nesnelerini attık
        frame.getContentPane().add(splitPane); // frame nesnesine splitPane nesnesini ekledik

        frame.setSize(1400, 800); // frame nesnesinin boyutunu ayarladık
        frame.setVisible(true); // frame nesnesini görünür yaptık
        frame.setResizable(false); // frame nesnesinin boyutunu değiştirmesini engelledik
        
    }
}