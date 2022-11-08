package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class function_file {

	NOTEPADGUI notepadgui;
	String filename;
	String fileAddress;
	
	public function_file(NOTEPADGUI notepadgui) {
		this.notepadgui=notepadgui;
		
	}
	public void newFile() {
		String data=notepadgui.textArea.getText();
		if(data=="" || data==null)
		{
			notepadgui.textArea.setText("");
			notepadgui.window.setTitle("Untitled - Notepad");
			filename=null;
			fileAddress=null;
		}
		else
		{
			int status=JOptionPane.showConfirmDialog(null, "Do you want to save this file?");
			if(status==JOptionPane.YES_OPTION)
			{
				save();
				notepadgui.textArea.setText("");
				notepadgui.window.setTitle("Untitled - Notepad");
				filename=null;
				fileAddress=null;
			}
			else if(status==JOptionPane.NO_OPTION)
			{
				notepadgui.textArea.setText("");
				notepadgui.window.setTitle("Untitled - Notepad");
				filename=null;
				fileAddress=null;
			}
		}
	}
	
	public void open() {
		FileDialog fd=new FileDialog(notepadgui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		if(fd.getFile()!=null) {
			filename=fd.getFile();
			fileAddress=fd.getDirectory();
			notepadgui.window.setTitle(filename);
		}
		System.out.println("file address and name is : "+fileAddress+filename);
		try {
			BufferedReader br=new BufferedReader(new FileReader(fileAddress+filename));
			notepadgui.textArea.setText("");
			String line=null;
			while((line=br.readLine())!=null) {
				notepadgui.textArea.append(line+"\n");
			}
			br.close();
		}catch(Exception e) {
			System.out.println("FILE NOT OPENED.");
		}
	}
	public void save() {
		if(filename==null) {
			saveas();
		}else {
			try {
				FileWriter fw=new FileWriter(fileAddress+filename);
				fw.write(notepadgui.textArea.getText());
				notepadgui.window.setTitle(filename);
				fw.close();
			}catch(Exception e) {
				System.out.println("SOMETHING WRONG");
			}
		}
	}
	public void saveas() {
		FileDialog fd=new FileDialog(notepadgui.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		if(fd.getFile()!=null) {
			filename=fd.getFile();
			fileAddress=fd.getDirectory();
			notepadgui.window.setTitle(filename);
		}
		try {
			FileWriter fw=new FileWriter(fileAddress+filename);
			fw.write(notepadgui.textArea.getText());
			fw.close();
		}catch(Exception e) {
			System.out.println("SOMETHING WRONG");
		}
	}
	public void exit() {
		System.exit(0);
	}
}
