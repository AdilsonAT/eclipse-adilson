package br.org.adilson.inicial;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.org.adilson.carregadb.Biblioteca;
import br.org.adilson.carregadb.DVDteca;
import br.org.adilson.carregadb.Discoteca;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InicialController implements Initializable{
	
	@FXML
	private Button botaoMongodbKill;
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
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void carregaMusicas_Action() {
		Discoteca.main();
	}
	
	public void carregaLivros_Action() {
		Biblioteca.main();
	}
	
	public void carregaDVDs_Action() {
		DVDteca.main();
	}
	
	public void mongodbKill_Action() {
		try {
		Runtime.getRuntime().exec("tskill mongod");
//		tasklist /FI "IMAGENAME eq mongod"
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
