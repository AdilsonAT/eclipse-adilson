import java.io.IOException;

public class MainTest {

	public static void main(String[] args) {

		try {
			Runtime.getRuntime().exec("mongod");
//			Runtime.getRuntime().exec("tskill mongod");
//			tasklist /FI "IMAGENAME eq mongod"

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
