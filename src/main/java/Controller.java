import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Controller {
    public Label label;
    public TextArea textArea;
    public Hyperlink weblink;

    public void handleParseHeader(){
        label.setText("success");
        // System.out.println("按钮被点击了");
        textArea.setText(Utils.parseHeader(textArea.getText()));
    }

    public void handleParseCookie(){
        label.setText("success");
        // System.out.println("按钮被点击了");
        textArea.setText(Utils.parseCookie(textArea.getText()));
    }

    public void handleLinkClick() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(weblink.getText()));
    }
}
