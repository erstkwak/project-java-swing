package model;

import java.util.ArrayList;
import common.vo.DeaVO;

public interface I_DeaDAO {

	public ArrayList<DeaVO> listDeaData();
	
	public void createDeaData(DeaVO deaVO);
	
	public void updateDeaData(DeaVO deaVO);
	
	public void deleteDeaData(DeaVO deaVO);
	
}