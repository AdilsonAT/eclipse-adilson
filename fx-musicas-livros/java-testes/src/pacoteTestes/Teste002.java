package pacoteTestes;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

public class Teste002 {

	public static void main(String[] args) {

		File[] paths;
		FileSystemView fsv = FileSystemView.getFileSystemView();
		
		// Returns pathnames for files and directory
		paths = File.listRoots();
		
		// For each pathname in pathname array
		for(File path:paths) {
			// Prints file and directory paths
			System.out.println("Diver name: "+path);
			System.out.println("Description: "+fsv.getSystemTypeDescription(path));
		}
		
		
		try {
			Runtime.getRuntime().exec("explorer G:\\########## G e r a l ##########\\Videos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
