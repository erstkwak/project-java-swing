package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.vo.PatVO;
import view.pat.PatUpdDialog;
import view.tre.TreUpdDialog;

public class PatDAO implements I_patDAO {
	
	private Connection        conn  = null;
	private PreparedStatement pstmt = null;
	private ResultSet         rs    = null;
	private String            query = null;

	public ArrayList<PatVO> listPatData() {
		ArrayList<PatVO> patList = new ArrayList<PatVO>();
		
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
				  + "  FROM PAT"
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
				
				PatVO patVO = new PatVO(name, gender, age, phone, sido, gugun, address, memo);
				patList.add(patVO);
			}
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}

		return patList;
	}

	public void createPatData(PatVO patVO_) {
		try {
			conn = DB.connDB();
			
			query = "INSERT INTO PAT"
				  +	"  (NAME, GENDER, AGE, PHONE, SIDO, GUGUN, ADDRESS, MEMO)"
				  +	"  VALUES"
				  +	"  (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, patVO_.getName   ());
			pstmt.setString(2, patVO_.getGender ());
			pstmt.setInt   (3, patVO_.getAge    ());
			pstmt.setString(4, patVO_.getPhone  ());
			pstmt.setString(5, patVO_.getSido   ());
			pstmt.setString(6, patVO_.getGugun  ());
			pstmt.setString(7, patVO_.getAddress());
			pstmt.setString(8, patVO_.getMemo   ());
			pstmt.executeUpdate();
	
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}		
	}

	public void updatePatData(PatVO patVO_) {
		try {
			conn = DB.connDB();
			
			query = "UPDATE PAT"
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
			
			pstmt.setString(1, patVO_.getName    ());
			pstmt.setString(2, patVO_.getGender  ());
			pstmt.setInt   (3, patVO_.getAge     ());
			pstmt.setString(4, patVO_.getPhone   ());
			pstmt.setString(5, patVO_.getSido    ());
			pstmt.setString(6, patVO_.getGugun   ());
			pstmt.setString(7, patVO_.getAddress ());
			pstmt.setString(8, patVO_.getMemo    ());
			pstmt.setString(9, PatUpdDialog.exPhone);
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void deletePatData(PatVO patVO_) {
		try {
			conn = DB.connDB();
		
			query = "DELETE" 
				  +	"  FROM PAT" 
				  + " WHERE PHONE = ?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, patVO_.getPhone());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}