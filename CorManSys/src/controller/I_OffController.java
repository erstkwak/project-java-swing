package controller;

import java.util.ArrayList;

import common.vo.OffVO;

public interface I_OffController {

	public ArrayList<OffVO> listOffData();
	
	public void createOffData(OffVO offVO);
	
	public void updateOffData(OffVO offVO);
	
	public void deleteOffData(OffVO offVO);
	
}