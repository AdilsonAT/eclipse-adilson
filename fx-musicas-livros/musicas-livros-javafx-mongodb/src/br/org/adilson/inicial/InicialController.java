package br.org.adilson.inicial;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.org.adilson.carregadb.Biblioteca;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class InicialController implements Initializable{
	
	@FXML
	private Button botaoMain;
	@FXML
	private Label labelMensagem;
	@FXML
	private Button botaoMusicas;
	@FXML
	private Button botaoLivros;
	@FXML
	private Button botaoDVDs;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		labelMensagem.setText("dir /s /b > arquivo.txt");
		
		try {
			Runtime.getRuntime().exec("mongod");
//			Runtime.getRuntime().exec("tskill mongod");
//			tasklist /FI "IMAGENAME eq mongod"

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void carregaMusicas_Action() {
	}
	
	public void carregaLivros_Action() {
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("Lista de Livros", "listalivros.txt"));
		File file = f.showOpenDialog(new Stage());
		String path = file.getAbsolutePath();

		labelMensagem.setText("Path > " + path);
		System.out.println(path);
		
		Biblioteca.main(path);
	}
	
	public void carregaDVDs_Action() {
	}
}
