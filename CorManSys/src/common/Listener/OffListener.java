package common.Listener;

import common.handler.OffHandler;
import common.component.MenuItem;

public class OffListener {

	public OffListener() {
		MenuItem.creOff.addActionListener(new OffHandler());
		MenuItem.reaOff.addActionListener(new OffHandler());
		MenuItem.updOff.addActionListener(new OffHandler());
		MenuItem.delOff.addActionListener(new OffHandler());
	}
	
}