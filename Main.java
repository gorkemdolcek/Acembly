import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
    private HostServices hostServices; // Store the HostServices reference

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Acembly");

        // Dark theme colors
        Color backgroundColor = Color.rgb(21, 13, 41); // Arkaplan rengi
        Color foregroundColor = Color.rgb(99, 32, 238); // Yazı rengi

        // Main menüLogo
        ImageView logoImage = new ImageView("logo.png"); // Logo resmini al.
        logoImage.setFitWidth(550); // Logo genişliğini 550px yap.
        logoImage.setFitHeight(100); // Logo yüksekliğini 100px yap.
        logoImage.setPreserveRatio(true); // Logo oranını koru.
        logoImage.setSmooth(true); // Logo görüntüsünü iyileştir.
        logoImage.setTranslateX(50); // Logoyu 50px sağa kaydır.
        logoImage.setTranslateY(10); // Logoyu 10px aşağı kaydır.

        logoImage.setOnMouseClicked(event -> {
            String url = "https://github.com/gorkemdolcek/Acembly";
            hostServices.showDocument(url);
        });

        // Ana panelin oluşturulması
        BorderPane rootPane = new BorderPane(); //
        rootPane.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        rootPane.setTop(logoImage); // Logoyu üst kısma ekle.

        // Sol panelin oluşturulması
        FlowPane leftPanel = new FlowPane(); // Sol paneli oluştur.
        leftPanel.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        leftPanel.setHgap(50); // Sol paneldeki elemanlar arası yatay boşluk ayarla.
        leftPanel.setVgap(50); // Sol paneldeki elemanlar arası dikey boşluk ayarla.
        leftPanel.setAlignment(Pos.CENTER_LEFT); // Sol paneldeki elemanların hizalamasını ayarla.

        // Sağ panelin oluşturulması
        FlowPane rightPanel = new FlowPane(); // Sağ paneli oluştur.
        rightPanel.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        rightPanel.setPadding(new Insets(10)); // Sağ panelin iç boşluğunu ayarla.
        rightPanel.setHgap(10); // Sağ paneldeki elemanlar arası yatay boşluk ayarla.
        rightPanel.setVgap(10); // Sağ paneldeki elemanlar arası dikey boşluk ayarla.
        rightPanel.setAlignment(Pos.CENTER); // Sağ paneldeki elemanların hizalamasını ayarla.

        // Alt panelin oluşturulması
        FlowPane bottomPanel = new FlowPane();
        bottomPanel.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        bottomPanel.setPrefSize(10, 609); // Alt panelin genişlik ve yükseklik ayarları
        bottomPanel.setAlignment(Pos.CENTER); // Alt paneldeki elemanların hizalamasını ayarla.
        rootPane.setBottom(bottomPanel);
        BorderPane.setAlignment(rightPanel, Pos.TOP_CENTER);

        // Sağ panelin kaydırılabilir olması için ScrollPane oluştur.
        ScrollPane scrollPane = new ScrollPane(rightPanel); // Sağ paneli kaydırılabilir yap.
        scrollPane.setFitToWidth(true); // Sağ panelin genişliğini tamamına sığdır.
        scrollPane.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

        //
        rootPane.setLeft(leftPanel); // Sol paneli ana panele ekle.
        rootPane.setCenter(scrollPane); // Sağ paneli ana panele ekle.

        primaryStage.setWidth(1400); // Pencere genişliğini ayarla.
        primaryStage.setHeight(900); // Pencere yüksekliğini ayarla.
        primaryStage.setResizable(false); // Pencerenin boyutunun değiştirilebilir olmasını engelle.

        TextField searchField = new TextField(); // Arama kutusu oluştur.
        searchField.setPromptText("Enter lesson name"); // Arama kutusuna yazı yazılınca görünecek yazıyı ayarla.
        searchField.setPrefWidth(200); // Arama kutusunun genişliğini ayarla.

        Button searchButton = createButton("Search", foregroundColor, backgroundColor); // Arama butonu oluştur.
        FlowPane searchPane = new FlowPane(); // Arama paneli oluştur.
        searchPane.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        searchPane.setPadding(new Insets(10)); // Arama panelinin iç boşluğunu ayarla.
        searchPane.setAlignment(Pos.TOP_RIGHT); // Arama panelindeki elemanların hizalamasını ayarla.
        searchPane.getChildren().addAll(searchField, searchButton);
        searchPane.setPrefSize(1, 1); // Arama panelinin boyutunu ayarla.
        rootPane.setRight(searchPane); // Arama panelini ana panele ekle.


        Text text = createText("Acembly", foregroundColor, FontWeight.BOLD, 47); // İlk metin oluştur
        Button button1 = createButton("Anasayfa", foregroundColor, backgroundColor); // Buton oluştur.
        Button button2 = createButton("Python Dili", foregroundColor, backgroundColor); // Buton oluştur.
        Button button3 = createButton("Java Dili", foregroundColor, backgroundColor); // Buton oluştur.
        Button button4 = createButton("HTML Dili", foregroundColor, backgroundColor); // Buton oluştur.
        Button button5 = createButton("Üreticiler", foregroundColor, backgroundColor); // Buton oluştur.

        leftPanel.getChildren().addAll(text, button1, button2, button3, button4, button5); // Sol paneldeki elemanları ekle.
        leftPanel.setPrefWidth(100); // Sol panelin genişliğini ayarla.

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String lessonName = searchField.getText(); // Arama kutusundaki metni al.
                String videoUrl = getVideoUrlForLesson(lessonName); // Ders adına göre video url al.
                if (videoUrl != null) { // Eğer video url null değilse
                    openWebPage(videoUrl); // Videoyu aç.
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // Butonun işlevini belirle
                rightPanel.getChildren().clear(); // Sağ paneldeki elemanları temizle.
                String[] urls = { // Butona tıklandığında sağ panelde gösterilecek linkleri belirle.
                        "https://www.youtube.com/watch?v=0Qnk-wU9kYU",
                        "https://www.example.com/link2",
                        "https://www.example.com/link3",
                        "https://www.example.com/link4",
                        "https://www.example.com/link5",
                        "https://www.example.com/link6"
                };

                for (int i = 0; i < urls.length; i++) { // Linklerin sayısı kadar döngü oluştur.
                    final int index = i; // Döngü değişkenini final yap.
                    Button selamButton = createButton("Ders" + (i + 1), foregroundColor, backgroundColor); // Buton
                                                                                                           // oluştur.
                    selamButton.setOnAction(new EventHandler<ActionEvent>() { // Butona tıklandığında
                        @Override
                        public void handle(ActionEvent event) { // Butonun işlevini belirle
                            openWebPage(urls[index]); // Linki aç.
                        }
                    });
                    rightPanel.getChildren().add(selamButton); // Sağ paneldeki elemanları ekle.
                }
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // Butonun işlevini belirle
                rightPanel.getChildren().clear(); // Sağ paneldeki elemanları temizle.
                String[] urls = { // Butona tıklandığında sağ panelde gösterilecek linkleri belirle.
                        "https://www.youtube.com/watch?v=0Qnk-wU9kYU",
                        "https://www.example.com/link2",
                        "https://www.example.com/link3",
                        "https://www.example.com/link4",
                        "https://www.example.com/link5",
                        "https://www.example.com/link6",
                        "https://www.example.com/link7",
                        "https://www.example.com/link8",
                };

                for (int i = 0; i < urls.length; i++) { // Linklerin sayısı kadar döngü oluştur.
                    final int index = i; // Döngü değişkenini final yap.
                    Button selamButton = createButton("Ders" + (i + 1), foregroundColor, backgroundColor);
                    selamButton.setOnAction(new EventHandler<ActionEvent>() { // Butona tıklandığında
                        @Override
                        public void handle(ActionEvent event) { // Butonun işlevini belirle
                            openWebPage(urls[index]); // Linki aç.
                        }
                    });
                    rightPanel.getChildren().add(selamButton); // Sağ paneldeki elemanları ekle.
                }
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { // Butonun işlevini belirle
                rightPanel.getChildren().clear(); // Sağ paneldeki elemanları temizle.
                String[] urls = { // Butona tıklandığında sağ panelde gösterilecek linkleri belirle.
                        "https://www.youtube.com/watch?v=0Qnk-wU9kYU",
                        "https://www.example.com/link2",
                        "https://www.example.com/link3",
                        "https://www.example.com/link4",
                        "https://www.example.com/link5",

                };

                for (int i = 0; i < urls.length; i++) { // Linklerin sayısı kadar döngü oluştur.
                    final int index = i; // Döngü değişkenini final yap.
                    Button selamButton = createButton("Ders" + (i + 1), foregroundColor, backgroundColor); // Buton
                                                                                                           // oluştur.
                    selamButton.setOnAction(new EventHandler<ActionEvent>() { // Butona tıklandığında
                        @Override
                        public void handle(ActionEvent event) { // Butonun işlevini belirle
                            openWebPage(urls[index]); // Linki aç.
                        }
                    });
                    rightPanel.getChildren().add(selamButton); // Sağ paneldeki elemanları ekle.
                }
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox genelText = new VBox();
                genelText.setSpacing(10);

                Text text1 = createText("Görkem Dolcek", foregroundColor, FontWeight.BOLD, 23); // İlk metin oluştur
                Text text2 = createText("Talha Çaylı", foregroundColor, FontWeight.BOLD, 23); // İkinci metin oluştur
                Text text3 = createText("Yıldıray Dikbaş", foregroundColor, FontWeight.BOLD, 23); // Üçüncü metin
                                                                                                  // oluştur
                Text text4 = createText("Asil Demir Aydın", foregroundColor, FontWeight.BOLD, 23); // Dördüncü metin
                                                                                                   // oluştur

                genelText.getChildren().addAll(text1, text2, text3, text4); // Metinleri ekle

                Pane coloredPane = new Pane();
                coloredPane.setBackground(
                        new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY))); // Arka plan
                                                                                                            // rengini
                                                                                                            // ayarla
                coloredPane.getChildren().add(genelText); // VBox'ı Pane içine ekle

                bottomPanel.getChildren().clear(); // Önceki içeriği temizle
                bottomPanel.getChildren().add(coloredPane); // coloredPane'i bottomPanel'a ekle
            }
        });

        Scene scene = new Scene(rootPane); // Pencereye sahne ekle.
        primaryStage.setScene(scene); // Pencerenin sahnesini ayarla.
        primaryStage.show(); // Pencereyi göster.

        hostServices = getHostServices(); // Host servislerini al.
    }

    private Node Text(String string, int i, Color foregroundColor) {
        return null;
    }

    private Text createText(String text, Color color, FontWeight fontWeight, double fontSize) {
        Text genelText = new Text(text); // Yeni bir Text nesnesi oluştur
        genelText.setFill(color); // Metin rengini ayarla
        genelText.setFont(Font.font("Arial", fontWeight, fontSize)); // Metin fontunu ayarla
        return genelText; // Metni döndür
    }

    private Button createButton(String text, Color textColor, Color backgroundColor) { // Buton oluştur.
        Button button = new Button(text); // Buton oluştur.
        button.setPrefSize(200, 60); // Buton oluştur
        button.setFont(Font.font("Arial", FontWeight.BOLD, 26)); // Butonun yazı tipini ve boyutunu ayarla.
        button.setTextFill(textColor); // Butonun yazı rengini ayarla.
        button.setStyle("-fx-background-color: #" + backgroundColor.toString().substring(2));
        return button; // Butonu döndür.
    }

    private void openWebPage(String url) { // Linki aç.
        hostServices.showDocument(url); // Linki aç.
    }

    private String getVideoUrlForLesson(String lessonName) { // Ders adına göre video url al.

        if (lessonName.equalsIgnoreCase("Ders1, ders 1")) { // Eğer ders adı Ders1 ise
            return "https://www.youtube.com/watch?v=video1"; // Video url Ders1'e göre ayarla.
        } else if (lessonName.equalsIgnoreCase("Ders2")) { // Eğer ders adı Ders2 ise
            return "https://www.youtube.com/watch?v=video2"; // Video url Ders2'ye göre ayarla.
        } else if (lessonName.equalsIgnoreCase("Ders0")) { // Eğer ders adı Ders2 ise
                return "https://www.youtube.com/watch?v=video2"; // Video url Ders2'ye göre ayarla.
        } else if (lessonName.equalsIgnoreCase("Ders3")) {
            return "https://www.youtube.com/watch?v=video3";
        } else {
            return null; //
        }
    }
}