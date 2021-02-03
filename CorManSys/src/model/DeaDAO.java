package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.vo.DeaVO;
import view.dea.DeaUpdDialog;
import view.tre.TreUpdDialog;

public class DeaDAO implements I_DeaDAO {
	
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet 		  rs    = null;
	String 			  query = null;
	
	public ArrayList<DeaVO> listDeaData() {
		ArrayList<DeaVO> deaList = new ArrayList<DeaVO>();
		
		try {
			conn = DB.connDB();
		
			query = "SELECT NAME"
			      + "     , GENDER"
				  + "     , AGE"
				  + "     , PHONE"
			      + "     , SIDO"
				  + "     , GUGUN"
				  + "     , ADDRESS"
				  + "     , MEMO"
				  + "  FROM DEA"
				  + " ORDER BY NAME ASC";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			rs    = pstmt.executeQuery();
			
			while (rs.next()) {
				String name    = rs.getString("NAME"   );
				String gender  = rs.getString("GENDER" );
				int    age     = rs.getInt   ("AGE"    );
				String phone   = rs.getString("PHONE"  );
				String sido    = rs.getString("SIDO"   );
				String gugun   = rs.getString("GUGUN"  );
				String address = rs.getString("ADDRESS");
				String memo    = rs.getString("MEMO"   );
				
				DeaVO deaVO = new DeaVO(name, gender, age, phone, sido, gugun, address, memo);
				deaList.add(deaVO);
			}
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
		
		return deaList;
	}

	public void createDeaData(DeaVO deaVO_) {
		try {
			conn = DB.connDB();

			query = "INSERT INTO DEA"
				  +	"  (NAME, GENDER, AGE, PHONE, SIDO, GUGUN, ADDRESS, MEMO)"
				  +	"  VALUES"
				  +	"  (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, deaVO_.getName   ());
			pstmt.setString(2, deaVO_.getGender ());
			pstmt.setInt   (3, deaVO_.getAge    ());
			pstmt.setString(4, deaVO_.getPhone  ());
			pstmt.setString(5, deaVO_.getSido   ());
			pstmt.setString(6, deaVO_.getGugun  ());
			pstmt.setString(7, deaVO_.getAddress());
			pstmt.setString(8, deaVO_.getMemo   ());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void updateDeaData(DeaVO deaVO_) {
		try {
			conn = DB.connDB();

			query = "UPDATE DEA"
				  +	"   SET NAME    = ?"
				  +	"     , GENDER  = ?"
				  +	"     , AGE     = ?"
				  +	"     , PHONE   = ?"
				  +	"     , SIDO    = ?"
				  +	"     , GUGUN   = ?"
				  +	"     , ADDRESS = ?"
				  +	"     , MEMO    = ?"
				  +	" WHERE PHONE   = ?";
			System.out.println(query);	
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, deaVO_.getName    ());
			pstmt.setString(2, deaVO_.getGender  ());
			pstmt.setInt   (3, deaVO_.getAge     ());			
			pstmt.setString(4, deaVO_.getPhone   ());
			pstmt.setString(5, deaVO_.getSido    ());
			pstmt.setString(6, deaVO_.getGugun   ());
			pstmt.setString(7, deaVO_.getAddress ());
			pstmt.setString(8, deaVO_.getMemo    ());
			pstmt.setString(9, DeaUpdDialog.exPhone);
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void deleteDeaData(DeaVO deaVO_) {
		try {
			conn = DB.connDB();

			query = "DELETE"
				  +	"  FROM DEA"
				  + " WHERE PHONE = ?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, deaVO_.getPhone());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}