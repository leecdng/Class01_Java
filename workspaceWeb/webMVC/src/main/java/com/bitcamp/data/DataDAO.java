package com.bitcamp.data;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.home.DBConnection;

public class DataDAO extends DBConnection {

	// �Խ��� �۾��� - ���ڵ� ���
	public int dataInsert(DataVO vo) {
		int result = 0;
		
		try {
			dbConn();
			
			sql = "insert into data(num, title, content, filename, userid) "
					+ "values(boardsq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getFilename());
			pstmt.setString(4, vo.getUserid());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Data ��� ����");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	
	// �Խ��� ��� - ���ڵ� ��ü ����
	public List<DataVO> dataSelect(){
		List<DataVO> list = new ArrayList<DataVO>();
		try {
			dbConn();
			sql = "select num, title, userid, filename, hit, to_char(writedate, 'MM-DD HH:MI') writedate" // ���� �����ִ� �� ����
				+ " from data order by num desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DataVO vo = new DataVO();
				vo.setNum(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setFilename(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
				
				list.add(vo);
				System.out.println("dao" + rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	
	// �ٿ�ε�Ƚ�� ����
	public int downCount(int num) {	// �߿����� �ʰ� ��� ó���� ������ ��� int result ��ȯ ���� �� ����
		int cnt = 0;
		try {
			dbConn();
			
			sql = "update data set downcount=downcount+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
			
			sql = "select downcount from data where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			System.out.println("�ٿ�ε�Ƚ������" + cnt);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	
	// ���ڵ� ����
	public DataVO oneSelect(int num) {
		DataVO vo = new DataVO();
		System.out.println("dao" + num);
		try {
			dbConn();
			
			sql = "select num, userid, title, content, filename, hit, downCount, writedate from data where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setFilename(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setDowncount(rs.getInt(7));
				vo.setWritedate(rs.getString(8));
			}
		} catch(Exception e) {
			
		} finally {
			dbClose();
		}
		return vo;
	}
	
	
	// ��ȸ�� ����
	public void hitCount(int num) {
		try {
			dbConn();
			
			sql = "update data set hit=hit+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("��ȸ�� ���� ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
}
























