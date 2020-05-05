package br.org.adilson.carregadb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class DVDteca {

//	public static void main(String[] args) {
	public static void main() {
		
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("Lista de DVDs", "listadvds.txt"));
		File file = f.showOpenDialog(new Stage());
		String path = file.getAbsolutePath();
		
		MongoClient client = new MongoClient();		// conexão
		MongoDatabase bancoDeDados = client.getDatabase("dvdteca");		// banco de dados
		MongoCollection<Document> dvds = bancoDeDados.getCollection("dvd");		// coleção
		
		BasicDBObject delete = new BasicDBObject();		// limpar a coleção
		dvds.deleteMany(delete);						//
		
		Document inseredvd = new Document();
		String linhaSplit[] = new String[10];	
			 
		try {
			
		
//			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Adilson\\Documents\\listadvds.txt"));
			BufferedReader br = new BufferedReader(new FileReader(path));

			while (br.ready()) {
				
				String linha = br.readLine();
				String pasta = null;
				
				linhaSplit = linha.split("\\\\");
				
				if (linhaSplit[linhaSplit.length - 1].lastIndexOf(".") != -1) {
					pasta = linhaSplit[0] + "\\";
					for(Integer i=1; i<linhaSplit.length-1; i++ ) {
						pasta = pasta + linhaSplit[i] + "\\";
					}		
										
					ObjectId id = new ObjectId();
					inseredvd.append("tipo", linhaSplit[linhaSplit.length - 1].substring(linhaSplit[linhaSplit.length -1 ].lastIndexOf(".") + 1))
							   .append("dvd", linhaSplit[linhaSplit.length - 1])
							   .append("pasta", pasta)
							   .append("_id", id);
					
					dvds.insertOne(inseredvd);
				}
			}
			
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		client.close();		
	}
}

