package notepad;

import java.awt.Font;

public class function_format {
	NOTEPADGUI notepadgui;
	Font arial,verdana,TNR;
	String selectedFont;
	public function_format(NOTEPADGUI notepadgui) {
		this.notepadgui=notepadgui;
		
	}
	public void wordwrap() {
		if(notepadgui.wordwrapOn==false) {
			notepadgui.wordwrapOn=true;
			notepadgui.textArea.setLineWrap(true);
			notepadgui.textArea.setWrapStyleWord(true);
			notepadgui.iwordwrap.setText("Word Wrap : On");
		}else if(notepadgui.wordwrapOn==true) {
			notepadgui.wordwrapOn=false;
			notepadgui.textArea.setLineWrap(false);
			notepadgui.textArea.setWrapStyleWord(false);
			notepadgui.iwordwrap.setText("Word Wrap : Off");
		}
	}

	public void createFont(int fontsize) {
		arial=new Font("Arial",Font.PLAIN,fontsize);
		verdana=new Font("Verdana",Font.PLAIN,fontsize);
		TNR=new Font("Times New Roman",Font.PLAIN,fontsize);
		setFont(selectedFont);
	}

	public void setFont(String Font) {
		selectedFont=Font;
		switch(selectedFont) {
			case "Arial":notepadgui.textArea.setFont(arial);break;
			case "Verdana":notepadgui.textArea.setFont(verdana);break;
			case "Times New Roman":notepadgui.textArea.setFont(TNR);break;
		}
	}
	public void showStatusbar() {
		if(notepadgui.statusbarOn==true) {
 			notepadgui.statusbarOn=false;
 			notepadgui.statusbar.show(false);
 			notepadgui.istatusbar.setText("Status Bar : On");
		}else if(notepadgui.statusbarOn==false) {
			notepadgui.statusbarOn=true;
			notepadgui.statusbar.show(true);
			notepadgui.istatusbar.setText("Status Bar : Off");
		}
	}
}
