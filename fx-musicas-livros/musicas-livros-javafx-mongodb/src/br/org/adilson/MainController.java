package br.org.adilson;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tabelaTableViewClasse.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

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
		
		labelMensagem.setText("Selecionados " + TableViewList.size() + " livros" );
			
		ObservableList<TableViewClasse> livrosObservableList = FXCollections.observableArrayList(TableViewList);
		this.tabelaTableViewClasse.getItems().setAll(livrosObservableList);
	}

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
		
		labelMensagem.setText("Selecionadas " + TableViewList.size() + " musicas" );
		
		ObservableList<TableViewClasse> livrosObservableList = FXCollections.observableArrayList(TableViewList);
		this.tabelaTableViewClasse.getItems().setAll(livrosObservableList);
	}

}
