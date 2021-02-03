package common.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.component.MenuItem;
import view.pat.PatCreDialog;
import view.pat.PatDelDialog;
import view.pat.PatReaDialog;
import view.pat.PatUpdDialog;

public class PatHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuItem.crePat) {
			PatCreDialog pd = new PatCreDialog("확진자 명단 추가 화면");
			pd.createData();
			pd.initFrame();
		}
		if (e.getSource() == MenuItem.reaPat) {new PatReaDialog("확진자 명단 조회 화면").initFrame();}
		if (e.getSource() == MenuItem.updPat) {new PatUpdDialog("확진자 명단 수정 화면").initFrame();}
		if (e.getSource() == MenuItem.delPat) {new PatDelDialog("확진자 명단 삭제 화면").initFrame();}
	}
}

