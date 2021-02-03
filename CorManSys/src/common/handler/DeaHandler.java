package common.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import common.component.MenuItem;
import view.dea.DeaCreDialog;
import view.dea.DeaDelDialog;
import view.dea.DeaReaDialog;
import view.dea.DeaUpdDialog;

public class DeaHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuItem.creDea) {
			DeaCreDialog dc = new DeaCreDialog("사망자 명단 추가 화면");
			dc.createData();
			dc.initFrame();
		}
		if (e.getSource() == MenuItem.reaDea) {new DeaReaDialog("사망자 명단 조회 화면").initFrame();}
		if (e.getSource() == MenuItem.updDea) {new DeaUpdDialog("사망자 명단 수정 화면").initFrame();}
		if (e.getSource() == MenuItem.delDea) {new DeaDelDialog("사망자 명단 삭제 화면").initFrame();}
	}
}