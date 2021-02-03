package common.Listener;

import common.handler.PatHandler;
import common.component.MenuItem;

public class PatListener {

	public PatListener() {
		MenuItem.crePat.addActionListener(new PatHandler());
		MenuItem.reaPat.addActionListener(new PatHandler());
		MenuItem.updPat.addActionListener(new PatHandler());
		MenuItem.delPat.addActionListener(new PatHandler());
	}
	
}