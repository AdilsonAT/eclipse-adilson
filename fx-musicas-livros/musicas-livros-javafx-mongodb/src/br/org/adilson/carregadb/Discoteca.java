package br.org.adilson.carregadb;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Discoteca {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();		// conexão
		MongoDatabase bancoDeDados = client.getDatabase("discoteca");		// banco de dados
		MongoCollection<Document> discos = bancoDeDados.getCollection("disco");		// coleção
		
		BasicDBObject delete = new BasicDBObject();		// limpar a coleção
		discos.deleteMany(delete);						//
		
		Document inseredisco = new Document();
		String linhaSplit[] = new String[10];	
			 
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Adilson\\Documents\\lista.txt"));

			while (br.ready()) {
				
				String linha = br.readLine();
				String pasta = null;
				
				linhaSplit = linha.split("\\\\");
				if (linhaSplit[linhaSplit.length - 1].toLowerCase().contains(".mp")) {
					pasta = linhaSplit[0] + "\\";
					for(Integer i=1; i<linhaSplit.length-1; i++ ) {
						pasta = pasta + linhaSplit[i] + "\\";
					}					
					ObjectId id = new ObjectId();
					inseredisco.append("musica", linhaSplit[linhaSplit.length - 1])
								.append("pasta", pasta)
								.append("_id", id);
					
					discos.insertOne(inseredisco);
				}
			}
			
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		client.close();		
	}
}
