package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.vo.TreVO;
import view.tre.TreUpdDialog;

public class TreDAO implements I_TreDAO {
	
	private Connection        conn  = null;
	private PreparedStatement pstmt = null;
	private ResultSet         rs    = null;
	private String            query = null;

	public ArrayList<TreVO> listTreData() {
		ArrayList<TreVO> treList = new ArrayList<TreVO>();
		
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
				  + "  FROM TRE"
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
				
				TreVO treVO = new TreVO(name, gender, age, phone, sido, gugun, address, memo);
				treList.add(treVO);
			}
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
		
		return treList;
	}

	public void createTreData(TreVO treVO_) {
		try {
			conn = DB.connDB();
			
			query = "INSERT INTO TRE"
				  +	"  (NAME, GENDER, AGE, PHONE, SIDO, GUGUN, ADDRESS, MEMO)"
				  +	"  VALUES"
				  +	"  (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, treVO_.getName   ());
			pstmt.setString(2, treVO_.getGender ());
			pstmt.setInt   (3, treVO_.getAge    ());
			pstmt.setString(4, treVO_.getPhone  ());
			pstmt.setString(5, treVO_.getSido   ());
			pstmt.setString(6, treVO_.getGugun  ());
			pstmt.setString(7, treVO_.getAddress());
			pstmt.setString(8, treVO_.getMemo   ());
			pstmt.executeUpdate();
	
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}		
	}

	public void updateTreData(TreVO treVO_) {
		try {
			conn = DB.connDB();
			
			query = "UPDATE TRE"
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
			
			pstmt.setString(1, treVO_.getName    ());
			pstmt.setString(2, treVO_.getGender  ());
			pstmt.setInt   (3, treVO_.getAge     ());
			pstmt.setString(4, treVO_.getPhone   ());
			pstmt.setString(5, treVO_.getSido    ());
			pstmt.setString(6, treVO_.getGugun   ());
			pstmt.setString(7, treVO_.getAddress ());
			pstmt.setString(8, treVO_.getMemo    ());
			pstmt.setString(9, TreUpdDialog.exPhone);
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void deleteTreData(TreVO treVO_) {
		try {
			conn = DB.connDB();
		
			query = "DELETE" 
				  +	"  FROM TRE" 
				  + " WHERE PHONE = ?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, treVO_.getPhone());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}