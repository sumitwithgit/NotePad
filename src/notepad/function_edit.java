package notepad;
public class function_edit {
	
	NOTEPADGUI notepadgui;
	public function_edit(NOTEPADGUI notepadgui) {
		this.notepadgui=notepadgui;
	}
	public void undo() {
		notepadgui.um.undo();
	}
	public void redo() {
		notepadgui.um.redo();
	}
	public void copy() {
		notepadgui.textArea.copy();
	}
	public void cut() {
		notepadgui.textArea.cut();
	}
	public void paste() {
		notepadgui.textArea.paste();
	}
	public void selectall() {
		notepadgui.textArea.selectAll();
	}
	public void delete() {
		String data=notepadgui.textArea.getText();
		if(data!="" || data!=null) {
			notepadgui.textArea.setText("");
		}
	}
}
