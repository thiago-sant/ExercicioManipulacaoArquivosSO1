package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController implements IArquivosController{
	
		public ArquivosController() {
			super();
		}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()) {
			throw new IOException("Diretório inválido.");
		}
		
	}

	@Override
	public void readFile(String path, String name, String extension) throws IOException {
		File file = new File (path,name + extension);
		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			int i = 0;
			while (linha != null) {
				String object [] = linha.split(",");
				if (object[2].equalsIgnoreCase("Fruits")) {
					System.out.println(i + "\t");
					if (object[0].length() < 8) {
						System.out.print(object[0] + "\t\t\t\t");
					}
					else if (object[0].length() >= 8 && object[0].length() < 16)
					{
						System.out.print(object[0] + "\t\t\t");
					}
					else if (object[0].length() >= 16 && object[0].length() < 24)
					{
						System.out.print( object[0] + "\t\t");						
					}
					else 
					{
						System.out.print(object[0] + "\t");
					}

					if(object[1].length() < 8)
					{
						System.out.println(object[1] + "\t\t\t\t\t\t" + object[3]);
					}
					else if (object[1].length() >= 8 && object[1].length() < 16)
					{
						System.out.println(object[1] + "\t\t\t\t\t" + object[3]);
					}
					else if (object[1].length() >= 16 && object[1].length() < 24)
					{
						System.out.println(object[1] + "\t\t\t\t" + object[3]);
					}
					else if (object[1].length() >= 24 && object[1].length() < 32)
					{
						System.out.println(object[1] + "\t\t\t" + object[3]);
					}
					else
					{
						System.out.println(object[1] + "\t" + object[3]);						
					}
				}
				linha = buffer.readLine();
				i++;
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		else {
			throw new IOException("Arquivo Inválido.");
		}
	}

	@Override
	public void openFile(String path, String name, String extension) throws IOException {
		File file = new File (path, name + extension);
		
		if (file.exists() && file.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		} else {
			throw new IOException("Arquivo Inválido.");
		}
		
	}
	

}
