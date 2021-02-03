package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.vo.IsoVO;
import view.iso.IsoUpdDialog;
import view.tre.TreUpdDialog;

public class IsoDAO implements I_IsoDAO {
	
	private Connection        conn  = null;
	private PreparedStatement pstmt = null;
	private ResultSet         rs    = null;
	private String            query = null;

	public ArrayList<IsoVO> listIsoData() {
		ArrayList<IsoVO> isoList = new ArrayList<IsoVO>();
		
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
				  + "  FROM ISO"
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
				
				IsoVO isoVO = new IsoVO(name, gender, age, phone, sido, gugun, address, memo);
				isoList.add(isoVO);
			}
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}

		return isoList;
	}

	public void createIsoData(IsoVO isoVO_) {
		try {
			conn = DB.connDB();
			
			query = "INSERT INTO ISO"
				  +	"  (NAME, GENDER, AGE, PHONE, SIDO, GUGUN, ADDRESS, MEMO)"
				  +	"  VALUES"
				  +	"  (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, isoVO_.getName   ());
			pstmt.setString(2, isoVO_.getGender ());
			pstmt.setInt   (3, isoVO_.getAge    ());
			pstmt.setString(4, isoVO_.getPhone  ());
			pstmt.setString(5, isoVO_.getSido   ());
			pstmt.setString(6, isoVO_.getGugun  ());
			pstmt.setString(7, isoVO_.getAddress());
			pstmt.setString(8, isoVO_.getMemo   ());
			pstmt.executeUpdate();
	
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}		
	}

	public void updateIsoData(IsoVO isoVO_) {
		try {
			conn = DB.connDB();
			
			query = "UPDATE ISO"
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
			
			pstmt.setString(1, isoVO_.getName    ());
			pstmt.setString(2, isoVO_.getGender  ());
			pstmt.setInt   (3, isoVO_.getAge     ());
			pstmt.setString(4, isoVO_.getPhone   ());
			pstmt.setString(5, isoVO_.getSido    ());
			pstmt.setString(6, isoVO_.getGugun   ());
			pstmt.setString(7, isoVO_.getAddress ());
			pstmt.setString(8, isoVO_.getMemo    ());
			pstmt.setString(9, IsoUpdDialog.exPhone);
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

	public void deleteIsoData(IsoVO isoVO_) {
		try {
			conn = DB.connDB();
		
			query = "DELETE" 
				  +	"  FROM ISO" 
				  + " WHERE PHONE = ?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, isoVO_.getPhone());
			pstmt.executeUpdate();
			
			DB.discDB(conn, pstmt, rs);
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}