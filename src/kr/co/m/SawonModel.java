package kr.co.m;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class SawonModel {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public static SawonModel model = new SawonModel();
	public static SawonModel Instance(){
		return model;
	}
	
	public SawonModel(){
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<SawonDto> getdataAll(){
		ArrayList<SawonDto> list = new ArrayList<>();
		try {
			String sql = "select * from sawon";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SawonDto dto = new SawonDto();
	            dto.setSawon_name(rs.getString("sawon_name"));
	            dto.setSawon_jik(rs.getString("sawon_jik"));
	            dto.setSawon_ibsail(rs.getString("sawon_ibsail"));
	            dto.setSawon_gen(rs.getString("sawon_gen"));
	            dto.setSawon_no(rs.getInt("sawon_no"));
	            dto.setBuser_num(rs.getInt("buser_num"));
	            dto.setSawon_pay(rs.getInt("sawon_pay"));
	            list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
	
	
}
