package common.component;

import javax.swing.JMenuItem;

 public class MenuItem {

	public static JMenuItem crePat;
	public static JMenuItem reaPat;
	public static JMenuItem updPat;
	public static JMenuItem delPat;
	
	public static JMenuItem creIso;
	public static JMenuItem reaIso;
	public static JMenuItem updIso;
	public static JMenuItem delIso;
	
	public static JMenuItem creTre;
	public static JMenuItem reaTre;
	public static JMenuItem updTre;
	public static JMenuItem delTre;
	
	public static JMenuItem creDea;
	public static JMenuItem reaDea;
	public static JMenuItem updDea;
	public static JMenuItem delDea;
	
	public static JMenuItem creOff;
	public static JMenuItem reaOff;
	public static JMenuItem updOff;
	public static JMenuItem delOff;
	
	public MenuItem() {
		reaPat = new JMenuItem("확진자 조회");
		crePat = new JMenuItem("확진자 추가");
		updPat = new JMenuItem("확진자 수정");
		delPat = new JMenuItem("확진자 삭제");
		
		reaIso = new JMenuItem("자가격리자 조회");
		creIso = new JMenuItem("자가격리자 추가");
		updIso = new JMenuItem("자가격리자 수정");
		delIso = new JMenuItem("자가격리자 삭제");
		
		reaTre = new JMenuItem("피검사자 조회");
		creTre = new JMenuItem("피검사자 추가");
		updTre = new JMenuItem("피검사자 수정");
		delTre = new JMenuItem("피검사자 삭제");
		
		reaDea = new JMenuItem("사망자 조회");
		creDea = new JMenuItem("사망자 추가");
		updDea = new JMenuItem("사망자 수정");
		delDea = new JMenuItem("사망자 삭제");
		
		reaOff = new JMenuItem("담당 공무원 조회");
		creOff = new JMenuItem("담당 공무원 추가");
		updOff = new JMenuItem("담당 공무원 수정");
		delOff = new JMenuItem("담당 공무원 삭제");
	}
	
}