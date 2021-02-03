package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.vo.OffVO;
import view.off.OffUpdDialog;
import view.tre.TreUpdDialog;

public class OffDAO implements I_OffDAO {
	
	private Connection        conn  = null;
	private PreparedStatement pstmt = null;
	private ResultSet         rs    = null;
	private String            query = null;

	public ArrayList<OffVO> listOffData() {
		ArrayList<OffVO> offList = new ArrayList<OffVO>();
		
		try {
			conn = DB.connDB();
			
			query = "SELECT NAME"
				  + "     , CLASZ"
				  + "     , POSITION"
				  + "     , DEPT"
				  + "     , TEL"
				  + "     , RESP"
				  + "     , ID"
				  + "     , MEMO"
				  + "  FROM OFF"
				  + " ORDER BY NAME ASC";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			rs    = pstmt.executeQuery();
			
			while (rs.next()) {
				String name     = rs.getString("NAME"    );
				String clasz    = rs.getString("CLASZ"   );
				String position = rs.getString("POSITION");
				String dept     = rs.getString("DEPT"    );
				String tel      = rs.getString("TEL"     );
				String resp     = rs.getString("RESP"    );
				int    id       = rs.getInt   ("ID"      );
				String memo     = rs.getString("MEMO"    );
				
				OffVO offVO = new OffVO(name, clasz, position, dept, tel, resp, id, memo);
				offList.add(offVO);
			}
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}

		return offList;
	}

	public void createOffData(OffVO offVO_) {
		try {
			conn = DB.connDB();
			
			query = "INSERT INTO OFF"
				  +	"  (NAME, CLASZ, POSITION, DEPT, TEL, RESP, ID, MEMO)"
				  +	"  VALUES"
				  +	"  (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, offVO_.getName    ());
			pstmt.setString(2, offVO_.getClasz   ());
			pstmt.setString(3, offVO_.getPosition());
			pstmt.setString(4, offVO_.getDept    ());
			pstmt.setString(5, offVO_.getTel     ());
			pstmt.setString(6, offVO_.getResp    ());
			pstmt.setInt   (7, offVO_.getId      ());
			pstmt.setString(8, offVO_.getMemo    ());
			pstmt.executeUpdate();
	
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}		
	}

	public void updateOffData(OffVO offVO_) {
		try {
			conn = DB.connDB();
			
			query = "UPDATE OFF"
				  +	"   SET NAME     = ?"
				  +	"     , CLASZ    = ?"
				  +	"     , POSITION = ?"
				  +	"     , DEPT     = ?"
				  +	"     , TEL      = ?"
				  +	"     , RESP     = ?"
				  +	"     , ID       = ?"
				  +	"     , MEMO     = ?"
				  +	" WHERE ID       = ?";
			System.out.println(query);	
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, offVO_.getName    ());
			pstmt.setString(2, offVO_.getClasz   ());
			pstmt.setString(3, offVO_.getPosition());
			pstmt.setString(4, offVO_.getDept    ());
			pstmt.setString(5, offVO_.getTel     ());
			pstmt.setString(6, offVO_.getResp    ());
			pstmt.setInt   (7, offVO_.getId      ());
			pstmt.setString(8, offVO_.getMemo    ());
			pstmt.setString(9, OffUpdDialog.exId   );
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void deleteOffData(OffVO offVO_) {
		try {
			conn = DB.connDB();
		
			query = "DELETE" 
				  +	"  FROM OFF" 
				  + " WHERE ID = ?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, offVO_.getId());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}