package br.org.adilson;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.filechooser.FileSystemView;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import br.org.adilson.classes.TableViewInterface;
import br.org.adilson.classes.TableViewRepositorio;
import br.org.adilson.entidades.Disco;
import br.org.adilson.entidades.Livro;
import br.org.adilson.entidades.TableViewClasse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	@FXML
	private Button botaoMusicas;
	@FXML
	private Button botaoLivros;
	@FXML
	private Button botaoDVDs;
	@FXML
	private TableView<Livro> tabelaLivros;
	@FXML
	private TableView<Disco> tabelaDiscos;
	@FXML
	private TableView<TableViewClasse> tabelaTableViewClasse;
	@FXML
	private TextField txfPesquisa;
	@FXML
	private RadioButton radioButtonPasta;
	@FXML
	private Label labelMensagem = new Label();
	@FXML
	private Button botaoAcessar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tabelaTableViewClasse.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	@FXML
	public void botaoLivros_Action() {
		TableViewInterface<TableViewClasse> repositorioTableView = new TableViewRepositorio();
		List<TableViewClasse> TableViewList = repositorioTableView.selecionar();
		TableViewList.clear();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("biblioteca");
//		FindIterable<Document> iterable = db.getCollection("livro").find();

		Document teste = new Document();
		teste.put("$regex", txfPesquisa.getText());
		teste.append("$options", "i");
		Document query = new Document();
		if (radioButtonPasta.isSelected()) {
			query.append("pasta", teste);
		} else {
			query.append("livro", teste);
		}
		FindIterable<Document> iterable = db.getCollection("livro").find(query);

		for (Document document : iterable) {
			TableViewClasse TVCNew = new TableViewClasse();
			TVCNew.setColuna01(document.getString("livro"));
			TVCNew.setColuna02(document.getString("pasta"));
			TableViewList.add(TVCNew);
		}

		mongoClient.close();

		labelMensagem.setText("Selecionados " + TableViewList.size() + " livros");

		ObservableList<TableViewClasse> livrosObservableList = FXCollections.observableArrayList(TableViewList);
		this.tabelaTableViewClasse.getItems().setAll(livrosObservableList);
	}
	
	@FXML
	public void botaoMusicas_Action() {
		TableViewInterface<TableViewClasse> repositorioTableView = new TableViewRepositorio();
		List<TableViewClasse> TableViewList = repositorioTableView.selecionar();
		TableViewList.clear();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("discoteca");
//		FindIterable<Document> iterable = db.getCollection("disco").find();

		Document teste = new Document();
		teste.put("$regex", txfPesquisa.getText());
		teste.append("$options", "i");
		Document query = new Document();
		if (radioButtonPasta.isSelected()) {
			query.append("pasta", teste);
		} else {
			query.append("musica", teste);
		}
		FindIterable<Document> iterable = db.getCollection("disco").find(query);

		for (Document document : iterable) {
			TableViewClasse TVCNew = new TableViewClasse();
			TVCNew.setColuna01(document.getString("musica"));
			TVCNew.setColuna02(document.getString("pasta"));
			TableViewList.add(TVCNew);
		}

		mongoClient.close();

		labelMensagem.setText("Selecionadas " + TableViewList.size() + " musicas");

		ObservableList<TableViewClasse> livrosObservableList = FXCollections.observableArrayList(TableViewList);
		this.tabelaTableViewClasse.getItems().setAll(livrosObservableList);
	}
	
	@FXML
	public void botaoDVDs_Action() {
		TableViewInterface<TableViewClasse> repositorioTableView = new TableViewRepositorio();
		List<TableViewClasse> TableViewList = repositorioTableView.selecionar();
		TableViewList.clear();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("dvdteca");
//		FindIterable<Document> iterable = db.getCollection("DVD").find();

		Document teste = new Document();
		teste.put("$regex", txfPesquisa.getText());
		teste.append("$options", "i");
		Document query = new Document();
		if (radioButtonPasta.isSelected()) {
			query.append("pasta", teste);
		} else {
			query.append("dvd", teste);
		}
		FindIterable<Document> iterable = db.getCollection("dvd").find(query);

		for (Document document : iterable) {
			TableViewClasse TVCNew = new TableViewClasse();
			TVCNew.setColuna01(document.getString("dvd"));
			TVCNew.setColuna02(document.getString("pasta"));
			TableViewList.add(TVCNew);
		}

		mongoClient.close();

		labelMensagem.setText("Selecionados " + TableViewList.size() + " DVDs");

		ObservableList<TableViewClasse> DVDsObservableList = FXCollections.observableArrayList(TableViewList);
		this.tabelaTableViewClasse.getItems().setAll(DVDsObservableList);
	}
	
	@FXML
	public void acessarDaTabela_Action() {
		String unidade = null;
		File[] paths;
		FileSystemView fsv = FileSystemView.getFileSystemView();

		// Returns pathnames for files and directory
		paths = File.listRoots();

		// For each pathname in pathname array
		for (File path : paths) {
			// Prints file and directory paths
//			System.out.println("Diver name: " + path);
//			System.out.println("Description: " + fsv.getSystemTypeDescription(path));
			unidade = path.toString();
		}
		
//		System.out.println(tabelaTableViewClasse.getSelectionModel().getSelectedItem().getColuna01());
//		System.out.println(tabelaTableViewClasse.getSelectionModel().getSelectedItem().getColuna02());
		
		String caminho = tabelaTableViewClasse.getSelectionModel().getSelectedItem().getColuna02().
			substring(3, tabelaTableViewClasse.getSelectionModel().getSelectedItem().getColuna02().length());
		
		caminho=unidade + caminho;
		
		labelMensagem.setText(caminho + tabelaTableViewClasse.getSelectionModel().getSelectedItem().getColuna01());
		
		try {
			Runtime.getRuntime().exec("explorer "+caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
