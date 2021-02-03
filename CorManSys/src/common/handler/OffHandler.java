package common.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.component.MenuItem;
import view.off.OffCreDialog;
import view.off.OffDelDialog;
import view.off.OffReaDialog;
import view.off.OffUpdDialog;

public class OffHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuItem.creOff) {
			OffCreDialog oc = new OffCreDialog("담당 공무원 명단 추가 화면");
			oc.createData();
			oc.initFrame();
		}
		if (e.getSource() == MenuItem.reaOff) {new OffReaDialog("담당 공무원 명단 조회 화면").initFrame();}
		if (e.getSource() == MenuItem.updOff) {new OffUpdDialog("담당 공무원 명단 수정 화면").initFrame();}
		if (e.getSource() == MenuItem.delOff) {new OffDelDialog("담당 공무원 명단 삭제 화면").initFrame();}
	}
}