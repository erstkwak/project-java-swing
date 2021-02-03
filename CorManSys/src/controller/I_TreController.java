package controller;

import java.util.ArrayList;

import common.vo.TreVO;

public interface I_TreController {

	public ArrayList<TreVO> listTreData();
	
	public void createTreData(TreVO treVO);
	
	public void updateTreData(TreVO treVO);
	
	public void deleteTreData(TreVO treVO);
	
}