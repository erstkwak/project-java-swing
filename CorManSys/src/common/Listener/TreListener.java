package common.Listener;

import common.handler.TreHandler;
import common.component.MenuItem;

public class TreListener {

	public TreListener() {
		MenuItem.creTre.addActionListener(new TreHandler());
		MenuItem.reaTre.addActionListener(new TreHandler());
		MenuItem.updTre.addActionListener(new TreHandler());
		MenuItem.delTre.addActionListener(new TreHandler());
	}
	
}