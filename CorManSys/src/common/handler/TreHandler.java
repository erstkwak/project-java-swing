package common.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.component.MenuItem;
import view.tre.TreCreDialog;
import view.tre.TreDelDialog;
import view.tre.TreReaDialog;
import view.tre.TreUpdDialog;

public class TreHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuItem.creTre) {
			TreCreDialog tc = new TreCreDialog("피검사자 명단 추가 화면");
			tc.createData();
			tc.initFrame();
		}
		if (e.getSource() == MenuItem.reaTre) {new TreReaDialog("피검사자 명단 조회 화면").initFrame();}
		if (e.getSource() == MenuItem.updTre) {new TreUpdDialog("피검사자 명단 수정 화면").initFrame();}
		if (e.getSource() == MenuItem.delTre) {new TreDelDialog("피검사자 명단 삭제 화면").initFrame();}
	}
}