package model;

import java.util.ArrayList;
import common.vo.IsoVO;

public interface I_IsoDAO {

	public ArrayList<IsoVO> listIsoData();
	
	public void createIsoData(IsoVO isoVO);
	
	public void updateIsoData(IsoVO isoVO);
	
	public void deleteIsoData(IsoVO isoVO);
	
}