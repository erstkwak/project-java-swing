package controller;

import java.util.ArrayList;

import common.vo.PatVO;
import model.I_patDAO;
import model.PatDAO;

public class PatController implements I_PatController {
	
	I_patDAO         patDAO  = new PatDAO();
	PatVO            patVO   = new PatVO();
	ArrayList<PatVO> patList = null;
	
	public ArrayList<PatVO> listPatData() {patList = patDAO.listPatData(); return patList;}

	public void createPatData(PatVO patVO) {patDAO.createPatData(patVO);}

	public void updatePatData(PatVO patVO) {patDAO.updatePatData(patVO);}

	public void deletePatData(PatVO patVO) {patDAO.deletePatData(patVO);}

}