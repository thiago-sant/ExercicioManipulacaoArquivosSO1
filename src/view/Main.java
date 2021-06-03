package view;

import java.io.IOException;
import java.util.Scanner;

import controller.ArquivosController;
import controller.IArquivosController;

public class Main {
	public static void main(String[] args) {
		IArquivosController fileCont = new ArquivosController();
		
		String dirPath = "C:\\TEMP";
		String fileName = "generic_food";
		String fileExtension = ".csv";
		
		try {
			fileCont.readDir(dirPath);
			fileCont.readFile(dirPath, fileName, fileExtension);
			Scanner scanner = new Scanner(System.in);
			int opt = scanner.nextInt();
			
			if (opt == 1) {
				fileCont.openFile(dirPath, fileName, fileExtension);
				System.out.println("Abrindo o arquivo...");
			}
			System.out.println("Finalizando...");
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
