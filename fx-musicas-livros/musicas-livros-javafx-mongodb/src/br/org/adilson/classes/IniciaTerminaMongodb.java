package br.org.adilson.classes;

import java.io.IOException;

public class IniciaTerminaMongodb {

	public static void IniciarMongodb() {
		try {
			Runtime.getRuntime().exec("mongod");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
