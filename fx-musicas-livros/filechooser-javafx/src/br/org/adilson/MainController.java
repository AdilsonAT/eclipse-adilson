package br.org.adilson;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML
	private Label labelMensagem = new Label();
	@FXML
	private Button botaoFazAlgo = new Button();
	@FXML
	private ImageView imagem;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		imagem.setOnMouseClicked((MouseEvent e) -> {carregaImagem_Action();});
	}
	
	public void botaoFazAlgo_Action() {
		
		labelMensagem.setText("Clique em cima da imagem");
	}

	public void carregaImagem_Action() {
		botaoFazAlgo.setText("Clicou");

		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("Imagem", "*.jpg", "*.png", "*.jpeg"));
		File file = f.showOpenDialog(new Stage());
		String path = file.getAbsolutePath();

		labelMensagem.setText("Path > " + path);

		if (file != null) {
			imagem.setImage(new Image("file:///"+file.getAbsolutePath()));
		}
	}
}
