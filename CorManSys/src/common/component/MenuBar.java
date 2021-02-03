package common.component;

import javax.swing.JMenuBar;
import common.component.Menu;

public class MenuBar {
	
	public static JMenuBar menuBar;

	public MenuBar() {
		menuBar = new JMenuBar();
		
		initMenuBar();
	}
	
	public void initMenuBar() {
		menuBar.add(Menu.patMenu);
		menuBar.add(Menu.isoMenu);
		menuBar.add(Menu.treMenu);
		menuBar.add(Menu.deaMenu);
		menuBar.add(Menu.offMenu);
	}
	
}