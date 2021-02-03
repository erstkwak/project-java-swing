package common.component;

import javax.swing.JMenu;
import common.component.MenuItem;

public class Menu {
	
	public static JMenu patMenu;
	public static JMenu isoMenu;
	public static JMenu treMenu;
	public static JMenu deaMenu;
	public static JMenu offMenu;
	public static JMenu Info;
	
	public Menu() {
		patMenu = new JMenu("확진자 관리"    );
		isoMenu = new JMenu("자가격리자 관리");
		treMenu = new JMenu("피검사자 관리"  );
		deaMenu = new JMenu("사망자 관리"    );
		offMenu = new JMenu("대응 인력 관리" );
		
		initMenu();
	}
	
	public void initMenu() {
		patMenu.add(MenuItem.reaPat);
		patMenu.add(MenuItem.crePat);
		patMenu.add(MenuItem.updPat);
		patMenu.add(MenuItem.delPat);
		
		isoMenu.add(MenuItem.reaIso);
		isoMenu.add(MenuItem.creIso);
		isoMenu.add(MenuItem.updIso);
		isoMenu.add(MenuItem.delIso);
		
		treMenu.add(MenuItem.reaTre);
		treMenu.add(MenuItem.creTre);
		treMenu.add(MenuItem.updTre);
		treMenu.add(MenuItem.delTre);
		
		deaMenu.add(MenuItem.reaDea);
		deaMenu.add(MenuItem.creDea);
		deaMenu.add(MenuItem.updDea);
		deaMenu.add(MenuItem.delDea);
		
		offMenu.add(MenuItem.reaOff);
		offMenu.add(MenuItem.creOff);
		offMenu.add(MenuItem.updOff);
		offMenu.add(MenuItem.delOff);
	}
	
}