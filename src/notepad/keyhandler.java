package notepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyhandler implements KeyListener{
	NOTEPADGUI notepadgui;
	
	public keyhandler(NOTEPADGUI notepadgui) {
		this.notepadgui=notepadgui;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			notepadgui.file.newFile();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			notepadgui.file.open();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			notepadgui.file.save();
		}
		if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S) {
			notepadgui.file.saveas();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Q) {
			notepadgui.file.exit();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) {
			notepadgui.edit.undo();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_X) {
			notepadgui.edit.redo();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_C) {
			notepadgui.edit.copy();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_V) {
			notepadgui.edit.paste();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_D) {
			notepadgui.edit.delete();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_A) {
			notepadgui.edit.selectall();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_Z) {
			notepadgui.format.wordwrap();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}
