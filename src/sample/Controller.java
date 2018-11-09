package sample;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cod_bot;

    @FXML
    private MenuBar menuBar = new MenuBar();

    @FXML
    private Button cp_bot;

    @FXML
    private Button dec_bot;

    @FXML
    private Label l1;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextArea decode_text;

    @FXML
    private TextArea code_text;

    private Shiphr shiphr = new Shiphr();
    private String string = "";

    @FXML
    void initialize() {

        Menu f = new Menu("File");
        MenuItem clo = new MenuItem("Exit");

        f.getItems().addAll(clo);
        menuBar.getMenus().addAll(f);

        clo.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        clo.setOnAction(event -> {
            System.exit(999);
        });

        cod_bot.setOnAction(event -> {
            string = decode_text.getText();
            System.out.println(string);
            code_text.setText(shiphr.code(string));
            l1.setText("Done");
        });
        dec_bot.setOnAction(event -> {
            string = decode_text.getText();
            code_text.setText(shiphr.decode(string));
            l1.setText("Done");
        });

        cp_bot.setOnAction(event -> {
            if(!code_text.getText().equals("")){
                StringSelection selection = new StringSelection(code_text.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
                l1.setText("Скопированно в буфер");
            }
        });
    }
}
