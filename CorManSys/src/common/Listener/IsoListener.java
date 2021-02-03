package common.Listener;

import common.handler.IsoHandler;
import common.component.MenuItem;

public class IsoListener {

	public IsoListener() {
		MenuItem.creIso.addActionListener(new IsoHandler());
		MenuItem.reaIso.addActionListener(new IsoHandler());
		MenuItem.updIso.addActionListener(new IsoHandler());
		MenuItem.delIso.addActionListener(new IsoHandler());
	}
	
}