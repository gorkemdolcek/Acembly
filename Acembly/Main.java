import java.awt.BorderLayout; // Frame'in boyutunu ayarlama.
import java.awt.event.ActionEvent; // Frame'de tıklama özelliği.
import java.awt.event.ActionListener; // Frame'de tıklama özelliği.

import javax.swing.ImageIcon; // Title logoyu ayarlama.
import javax.swing.JComboBox; // Title
import javax.swing.JFrame; // Frame oluşturma.
import javax.swing.JPanel; // Frame'de panel oluşturma.
import javax.swing.JTextArea; // Frame'de metin alanı oluşturma.

class KategoriGUI extends JFrame implements ActionListener {

     private JComboBox<String> categoryComboBox; // Kategori seçim kutusu
     private JTextArea itemTextArea; // Metin alanı

     public KategoriGUI() {
        super("Acembly"); // Frame'e başlık atama.

        // Kategorileri içeren bir JComboBox oluşturun
        String[] categories = { "Seçiniz", "Pyhton", "Java", "HTML" }; // Kategori seçim kutusunun içindeki kategoriler.
        categoryComboBox = new JComboBox<String>(categories); // Kategori seçim kutusunu oluşturma.
        categoryComboBox.addActionListener(this); // Kategori seçim kutusuna tıklama özelliği.

        // Metin alanını içeren bir JPanel oluşturun
        itemTextArea = new JTextArea(50,85 ); // Metin alanı boyutu.
        itemTextArea.setEditable(false); // Metin alanını değiştirilemez yapma.

        JPanel panel = new JPanel(); // Kategori seçim kutusunu içeren bir JPanel oluşturun
        panel.add(categoryComboBox); // Kategori seçim kutusunu panel'e ekleme.
        panel.setSize(getPreferredSize()); // Kategori seçim kutusunun boyutunu ayarlayın

        // GUI'nin ana düzenini oluşturun
        getContentPane().add(panel, BorderLayout.WEST); // Kategori seçim kutusunu sol tarafta gösterme.
        getContentPane().add(itemTextArea, BorderLayout.CENTER); // Metin alanını ortada gösterme.
        ImageIcon image= new ImageIcon("logo.png"); //Logo ekleme
        setIconImage(image.getImage()); // Title logoyu gösterme.
        

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Çıkış yolu.
        setVisible(true); // Çalışabilirliği.
        setResizable(false); // Boyut değiştirmeyi kapatma.
          
    }

     public static void main(String[] args) { // Main methodu.
       new KategoriGUI(); // KategoriGUI class'ını çağırma.
       
    }

     public void actionPerformed(ActionEvent e) {

        // Kategori seçim kutusunda bir öğe seçildiğinde metin alanını güncelleyin
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        String category = (String) cb.getSelectedItem();

        if (category.equals("Pyhton")) { // Kategori seçim kutusunda Pyhton seçildiğinde metin alanını güncelleme.
            itemTextArea.setText("Pyhton öğeleri: \n - Öğe 1\n - Öğe 2\n - Öğe 3");
        } else if (category.equals("Java")) {
            itemTextArea.setText("Java öğeleri: \n - Öğe A\n - Öğe B\n - Öğe C");
        } else if (category.equals("HTML")) {
            itemTextArea.setText("HTML öğeleri: \n - Öğe X\n - Öğe Y\n - Öğe Z");
        } else {
            itemTextArea.setText(""); // Kategori seçim kutusunda seçim yapılmadığında metin alanını boşaltma.
        }
    }
}

//signature de Dolcek
