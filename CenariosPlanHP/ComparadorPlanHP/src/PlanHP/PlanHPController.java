package PlanHP;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Comparador.Comparador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class PlanHPController {
	
    @FXML
    private Button botaoXlsxPlan;
    @FXML
    private Button botaoXlsxHP;
    @FXML
    private TextField textColuna;
    @FXML
    private TextField textPrefixo;
	@FXML
	private Button botaoComparar;
	@FXML
	private Label labelTot11;
	@FXML
	private Label labelTot12;
	@FXML
	private Label labelTot13;
	@FXML
	private Label labelTot14;
	@FXML
	private Label labelTot21;
	@FXML
	private Label labelTot22;
	@FXML
	private Label labelTot23;
	@FXML
	private Label labelTot24;
	
    
    private String pathPlan;
    private String pathHP;
	
    @FXML
	void botaoXlsxPlan_Action() {
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("Planejamento xlsx", "*.xlsx"));
		File file = f.showOpenDialog(new Stage());
		pathPlan = file.getAbsolutePath();
		botaoXlsxPlan.setText(pathPlan);
	}
	
    @FXML
	void botaoXlsxHP_Action() {
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("HP xlsx", "*.xlsx"));
		File file = f.showOpenDialog(new Stage());
		pathHP = file.getAbsolutePath();
		botaoXlsxHP.setText(pathHP);
	}
	
	@FXML
	public void botaoComparar_Action() throws IOException {		
		
		int coluna = Integer.parseInt(textColuna.getText());
		String prefixo = textPrefixo.getText();
		
		Comparador comparador = new Comparador();
		List<String> totais = comparador.Compara(pathPlan, pathHP, coluna, prefixo);

		labelTot11.setText(totais.get(0));
		labelTot12.setText(totais.get(1));
		labelTot13.setText(totais.get(2));
		labelTot14.setText(totais.get(3));
		labelTot21.setText(totais.get(4));
		labelTot22.setText(totais.get(5));
		labelTot23.setText(totais.get(6));
		labelTot24.setText(totais.get(7));
	}
}
