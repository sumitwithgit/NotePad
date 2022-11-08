package notepad;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class NOTEPADGUI implements ActionListener
{

	
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JLabel statusbar;
	JPopupMenu popupMenu;
	JMenu menuFile,menuEdit,menuFormat,menuView,menuHelp,menuzoom,menuFont,menuSize,menuFontstyle;
	JMenuItem iArial,iTNR,iVerdana,iColor,iBackColor;
	JMenuItem iFont8,iFont12,iFont16,iFont20,iFont24,iFont28,iFont32,iFont36,iFont48,iFont72;
	JMenuItem iNew,iOpen,iSave,iSaveas,iExit,iUndo,iRedo,iCopy,iCut,iPaste,iDelete,iSelectAll,iwordwrap,izoomin,izoomout,istatusbar,iviewhelp,isendfeedback,iaboutnotepad;
	boolean wordwrapOn=false;
	boolean statusbarOn=false;
	
	function_file file=new function_file(this);
	function_format format=new function_format(this);
	function_edit edit=new function_edit(this);
	keyhandler kg=new keyhandler(this);
	UndoManager um=new UndoManager();
	
	public static void main(String[] args)
	{
		new NOTEPADGUI();
	}
	
	
	public NOTEPADGUI(){
		createwindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createPopUpMenu();
		format.selectedFont="Arial";
		format.createFont(16);
		window.setVisible(true);
		createFormatMenu();
		createViewMenu();
		createHelpMenu();
		window.setVisible(true);
		
	}
	
	
	public void createwindow() {
		window=new JFrame("Untitled - Notepad");
		window.setSize(1366,768);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		textArea =new JTextArea();
		textArea.addKeyListener(kg);
		statusbar = new JLabel("Status Bar : Chars: 0 ,   Words : 0");
		statusbar.setBounds(0, 660, 700, 22);
		window.add(statusbar);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				String text=textArea.getText();
				String data[]=text.split(" ");
				int chars=text.length();
				int words=data.length;
				
				statusbar.setText("Status Bar : Chars: "+chars+" ,   Words : "+words);
				
			}
		});
		
		
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		
		
		scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);

	}
	
	public void createMenuBar() {
		menuBar =new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile =new JMenu("File");
		menuBar.add(menuFile);
		menuFile.setToolTipText("Click File to see basic options");
		menuFile.setMnemonic('F');
		
		menuEdit =new JMenu("Edit");
		menuBar.add(menuEdit);
		menuEdit.setToolTipText("Click Edit to see basic options");
		menuEdit.setMnemonic('E');
		
		menuFormat =new JMenu("Format");
		menuBar.add(menuFormat);
		menuFormat.setToolTipText("Click Format to see basic options");
		menuFormat.setMnemonic('F');
		
		menuView =new JMenu("View");
		menuBar.add(menuView);
		menuView.setToolTipText("Click View to see basic options");
		menuView.setMnemonic('V');
		
		menuHelp =new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.setToolTipText("Click Help to see basic options");
		menuHelp.setMnemonic('H');
	}
	
	public void createFileMenu() {
		iNew=new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen=new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave=new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveas=new JMenuItem("Save As");
		iSaveas.addActionListener(this);
		iSaveas.setActionCommand("SaveAs");
		menuFile.add(iSaveas);
		
		iExit=new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	public void createEditMenu() {
		iUndo=new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo=new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
		iCopy=new JMenuItem("Copy");
		iCopy.addActionListener(this);
		iCopy.setActionCommand("Copy");
		menuEdit.add(iCopy);
		
		iCut=new JMenuItem("Cut");
		iCut.addActionListener(this);
		iCut.setActionCommand("Cut");
		menuEdit.add(iCut);
		
		iPaste=new JMenuItem("Paste");
		iPaste.addActionListener(this);
		iPaste.setActionCommand("Paste");
		menuEdit.add(iPaste);
		
		iSelectAll=new JMenuItem("Select All");
		iSelectAll.addActionListener(this);
		iSelectAll.setActionCommand("Select All");
		menuEdit.add(iSelectAll);
		
		iDelete=new JMenuItem("Delete");
		iDelete.addActionListener(this);
		iDelete.setActionCommand("Delete");
		menuEdit.add(iDelete);
	}
	public void createFormatMenu() {
		iwordwrap=new JMenuItem("Word Wrap : Off");
		iwordwrap.addActionListener(this);
		iwordwrap.setActionCommand("Word Wrap");
		menuFormat.add(iwordwrap);
		
		menuFont =new JMenu("Font");
		menuFormat.add(menuFont);
		
		menuFontstyle =new JMenu("Font Style");
		menuFont.add(menuFontstyle);
		
		iArial=new JMenuItem("Arial");
		iArial.addActionListener(this);
		iArial.setActionCommand("Arial");
		menuFontstyle.add(iArial);
		
		iVerdana=new JMenuItem("Verdana");
		iVerdana.addActionListener(this);
		iVerdana.setActionCommand("Verdana");
		menuFontstyle.add(iVerdana);
		
		iTNR=new JMenuItem("Times New Roman");
		iTNR.addActionListener(this);
		iTNR.setActionCommand("Times New Roman");
		menuFontstyle.add(iTNR);
		
		menuSize =new JMenu("Font Size");
		menuFont.add(menuSize);
		
		iFont8=new JMenuItem("8");
		iFont8.addActionListener(this);
		iFont8.setActionCommand("size8");
		menuSize.add(iFont8);
		
		iFont12=new JMenuItem("12");
		iFont12.addActionListener(this);
		iFont12.setActionCommand("size12");
		menuSize.add(iFont12);
		
		iFont16=new JMenuItem("16");
		iFont16.addActionListener(this);
		iFont16.setActionCommand("size16");
		menuSize.add(iFont16);
		
		iFont20=new JMenuItem("20");
		iFont20.addActionListener(this);
		iFont20.setActionCommand("size20");
		menuSize.add(iFont20);
		
		iFont24=new JMenuItem("24");
		iFont24.addActionListener(this);
		iFont24.setActionCommand("size24");
		menuSize.add(iFont24);
		
		iFont28=new JMenuItem("28");
		iFont28.addActionListener(this);
		iFont28.setActionCommand("size28");
		menuSize.add(iFont28);
		
		iFont32=new JMenuItem("32");
		iFont32.addActionListener(this);
		iFont32.setActionCommand("size32");
		menuSize.add(iFont32);
		
		iFont36=new JMenuItem("36");
		iFont36.addActionListener(this);
		iFont36.setActionCommand("size36");
		menuSize.add(iFont36);
		
		iFont48=new JMenuItem("48");
		iFont48.addActionListener(this);
		iFont48.setActionCommand("size48");
		menuSize.add(iFont48);
		
		iFont72=new JMenuItem("72");
		iFont72.addActionListener(this);
		iFont72.setActionCommand("size72");
		menuSize.add(iFont72);
		
		iColor =new JMenuItem("Font Color");
		iColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color=JColorChooser.showDialog(textArea.getParent(), "Choose Text Color",Color.black);
				textArea.setForeground(color);
			}
		});
		menuFont.add(iColor);
		
		
		iBackColor =new JMenuItem("Background Color");
		iBackColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color=JColorChooser.showDialog(textArea.getParent(), "Choose Text Color",Color.black);
				textArea.setBackground(color);
			}
		});
		menuFont.add(iBackColor);
	}
	
	public void createViewMenu() {
		istatusbar=new JMenuItem("Status Bar : Off");
		istatusbar.addActionListener(this);
		istatusbar.setActionCommand("Status Bar");
		menuView.add(istatusbar);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	
	public void createPopUpMenu() {
		 popupMenu = new JPopupMenu();
		 addPopup(textArea, popupMenu);
			 iUndo = new JMenuItem("Undo");
			 iUndo.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		um.undo();
			 	}
			 });
			popupMenu.add(iUndo);
			
			iRedo = new JMenuItem("Redo");
			 iRedo.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		um.redo();
			 	}
			 });
			popupMenu.add(iRedo);
			
			 iCut = new JMenuItem("Cut");
			 iCut.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		textArea.cut();
			 	}
			 });
			 
			popupMenu.add(iCut);
			
			 iCopy = new JMenuItem("Copy");
			 iCopy.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		textArea.copy();
			 	}
			 });
			popupMenu.add(iCopy);
			
			 iPaste = new JMenuItem("Paste");
			 iPaste.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		textArea.paste();
			 	}
			 });
			popupMenu.add(iPaste);
			
			 iDelete = new JMenuItem("DeleteAll");
			 iDelete.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String data=textArea.getText();
					if(data!="" || data!=null) {
						textArea.setText("");
					}
			 	}
			 });
			popupMenu.add(iDelete);
			
			iSelectAll = new JMenuItem("Select All");
			iSelectAll.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		textArea.selectAll();
			 	}
			 });
			popupMenu.add(iSelectAll);
	}
	
	public void createHelpMenu() {
		
		iviewhelp=new JMenuItem("View Help");
		iviewhelp.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		JOptionPane.showMessageDialog(textArea.getParent(), "Ctrl+N - For New File\nCtrl+O - For Open A File\nCtrl+S - For Save File\nCtrl+Shift+S - For Save As\nCtrl+Q - For Exit\nCtrl+Z - For Undo\nCtrl+X - For Redo\nCtrl+D - For Delete\nAlt+Z - For Word Wrap");
			 	}
			 });
		menuHelp.add(iviewhelp);
		
		isendfeedback=new JMenuItem("Send Feedback");
		
		menuHelp.add(isendfeedback);
		
		iaboutnotepad=new JMenuItem("About Notepad");
		iaboutnotepad.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(textArea.getParent(), "ThankYou For Using This Product.");
		 	}
		 });
		menuHelp.add(iaboutnotepad);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		switch(command)
		{
			case "New":file.newFile();
			break;
			case "Open":file.open();
			break;
			case "Save":file.save();
			break;
			case "SaveAs":file.saveas();
			break;
			case "Exit":file.exit();
			break;
			case "Undo":edit.undo();
			break;
			case "Redo":edit.redo();
			break;
			case "Copy":edit.copy();
			break;
			case "Cut":edit.cut();
			break;
			case "Paste":edit.paste();
			break;
			case "Select All":edit.selectall();
			break;
			case "Delete":edit.delete();
			break;
			case "Word Wrap":format.wordwrap();
			break;
			case "Status Bar":format.showStatusbar();
			break;
			case "Arial":format.setFont(command);
			break;
			case "Verdana":format.setFont(command);
			break;
			case "Times New Roman":format.setFont(command);
			break;
			case "size8":format.createFont(8);
			break;
			case "size12":format.createFont(12);
			break;
			case "size16":format.createFont(16);
			break;
			case "size20":format.createFont(20);
			break;
			case "size24":format.createFont(24);
			break;
			case "size28":format.createFont(28);
			break;
			case "size32":format.createFont(32);
			break;
			case "size36":format.createFont(36);
			break;
			case "size48":format.createFont(48);
			break;
			case "size72":format.createFont(72);
			break;	
		}
	}

}
