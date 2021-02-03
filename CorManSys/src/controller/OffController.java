package controller;

import java.util.ArrayList;

import common.vo.OffVO;
import model.I_OffDAO;
import model.OffDAO;

public class OffController implements I_OffController {
	
	I_OffDAO         offDAO  = new OffDAO();
	OffVO            offVO   = new OffVO();
	ArrayList<OffVO> offList = null;
	
	public ArrayList<OffVO> listOffData() {offList = offDAO.listOffData(); return offList;}

	public void createOffData(OffVO offVO) {offDAO.createOffData(offVO);}

	public void updateOffData(OffVO offVO) {offDAO.updateOffData(offVO);}

	public void deleteOffData(OffVO offVO) {offDAO.deleteOffData(offVO);}

}