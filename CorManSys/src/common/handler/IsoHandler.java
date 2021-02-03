package common.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.component.MenuItem;
import view.iso.IsoCreDialog;
import view.iso.IsoDelDialog;
import view.iso.IsoReaDialog;
import view.iso.IsoUpdDialog;

public class IsoHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuItem.creIso) {
			IsoCreDialog ic = new IsoCreDialog("자가격리자 명단 추가 화면");
			ic.createData();
			ic.initFrame();
		}
		if (e.getSource() == MenuItem.reaIso) {new IsoReaDialog("자가격리자 명단 조회 화면").initFrame();}
		if (e.getSource() == MenuItem.updIso) {new IsoUpdDialog("자가격리자 명단 수정 화면").initFrame();}
		if (e.getSource() == MenuItem.delIso) {new IsoDelDialog("자가격리자 명단 삭제 화면").initFrame();}
	}
}