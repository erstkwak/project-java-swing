package controller;

import java.util.ArrayList;

import common.vo.DeaVO;
import model.DeaDAO;
import model.I_DeaDAO;

public class DeaController implements I_DeaController {
	
	I_DeaDAO         deaDAO  = new DeaDAO();
	DeaVO            deaVO   = new DeaVO();
	ArrayList<DeaVO> deaList = null;
	
	public ArrayList<DeaVO> listDeaData() {deaList = deaDAO.listDeaData(); return deaList;}

	public void createDeaData(DeaVO deaVO) {deaDAO.createDeaData(deaVO);}

	public void updateDeaData(DeaVO deaVO) {deaDAO.updateDeaData(deaVO);}

	public void deleteDeaData(DeaVO deaVO) {deaDAO.deleteDeaData(deaVO);}

}