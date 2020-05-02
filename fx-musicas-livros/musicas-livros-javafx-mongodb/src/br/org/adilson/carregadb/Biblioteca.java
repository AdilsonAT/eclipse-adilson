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

public class Biblioteca {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();		// conexão
		MongoDatabase bancoDeDados = client.getDatabase("biblioteca");		// banco de dados
		MongoCollection<Document> livros = bancoDeDados.getCollection("livro");		// coleção
		
		BasicDBObject delete = new BasicDBObject();		// limpar a coleção
		livros.deleteMany(delete);						//
		
		Document inserelivro = new Document();
		String linhaSplit[] = new String[10];	
			 
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Adilson\\Documents\\listaLivros.txt"));

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
					inserelivro.append("tipo", linhaSplit[linhaSplit.length - 1].substring(linhaSplit[linhaSplit.length -1 ].lastIndexOf(".") + 1))
							   .append("livro", linhaSplit[linhaSplit.length - 1])
							   .append("pasta", pasta)
							   .append("_id", id);
					
					livros.insertOne(inserelivro);
				}
			}
			
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		client.close();		
	}
}

