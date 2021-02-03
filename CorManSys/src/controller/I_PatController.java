package controller;

import java.util.ArrayList;

import common.vo.PatVO;

public interface I_PatController {

	public ArrayList<PatVO> listPatData();
	
	public void createPatData(PatVO patVO);
	
	public void updatePatData(PatVO patVO);
	
	public void deletePatData(PatVO patVO);
	
}