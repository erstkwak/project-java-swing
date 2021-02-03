package common.Listener;

import common.handler.DeaHandler;
import common.component.MenuItem;

public class DeaListener {

	public DeaListener() {
		MenuItem.creDea.addActionListener(new DeaHandler());
		MenuItem.reaDea.addActionListener(new DeaHandler());
		MenuItem.updDea.addActionListener(new DeaHandler());
		MenuItem.delDea.addActionListener(new DeaHandler());
	}
	
}