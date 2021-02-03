package controller;

import java.util.ArrayList;

import common.vo.IsoVO;
import model.I_IsoDAO;
import model.IsoDAO;

public class IsoController implements I_IsoController {
	
	I_IsoDAO         isoDAO  = new IsoDAO();
	IsoVO            isoVO   = new IsoVO();
	ArrayList<IsoVO> isoList = null;
	
	public ArrayList<IsoVO> listIsoData() {isoList = isoDAO.listIsoData(); return isoList;}

	public void createIsoData(IsoVO isoVO) {isoDAO.createIsoData(isoVO);}

	public void updateIsoData(IsoVO isoVO) {isoDAO.updateIsoData(isoVO);}

	public void deleteIsoData(IsoVO isoVO) {isoDAO.deleteIsoData(isoVO);}

}