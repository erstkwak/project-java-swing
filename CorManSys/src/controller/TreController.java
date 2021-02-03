package controller;

import java.util.ArrayList;

import common.vo.TreVO;
import model.I_TreDAO;
import model.TreDAO;

public class TreController implements I_TreController {
	
	I_TreDAO         treDAO  = new TreDAO();
	TreVO            treVO   = new TreVO();
	ArrayList<TreVO> treList = null;
	
	public ArrayList<TreVO> listTreData() {treList = treDAO.listTreData(); return treList;}

	public void createTreData(TreVO treVO) {treDAO.createTreData(treVO);}

	public void updateTreData(TreVO treVO) {treDAO.updateTreData(treVO);}

	public void deleteTreData(TreVO treVO) {treDAO.deleteTreData(treVO);}

}