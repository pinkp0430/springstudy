package com.wind.web.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.BDto;
import com.wind.web.util.Constant;

public class BDao {
	
//	DataSource dataSource;
	
//	JdbcTemplate template = null;
	
	private JdbcTemplate template;
	
	@Autowired  //기본 셋을 하란 야그.. servlet-context.xml에서 bean 두개로 DB 연결해 오는 셋팅을 해놧기 때문에 이걸 쓸 수 있다.
	public void setTemplate(JdbcTemplate template) {
		this.template = template; //private 셋으로 함 감춰주고?? 
//		Constant.template = this.template; // static한 Constant.template에 다시 넣어준다.
	}
	
	public BDao() {	// 
		
//		template = Constant.template;
		
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = null;
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
				+ "from mvc_board order by bGroup desc, bStep asc"; // DB를 가져올 때, 그룹별로, bStep별로 sorting을 해서 list를 만든다. list.jsp에서는 이 걸 뿌려주기만함. 
		dtos = (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dtos;
				
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		BDto dto;
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "
//					+ "from mvc_board order by bGroup desc, bStep asc, bDate asc "; // DB를 가져올 때, 그룹별로, bStep별로 sorting을 해서 list를 만든다. list.jsp에서는 이 걸 뿌려주기만함. 
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
//				dtos.add(dto);
//			}
//		} catch (Exception e1) {e1.printStackTrace();}
//			finally {
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				} catch(Exception e2) {e2.printStackTrace();}
//			}
//		return dtos;
	}
	
	public BDto contentView(String strID) {
		
		upHit(strID);
		
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		BDto dto = null;
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			String query = "select * from mvc_board where bId = ?";
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strID));
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//		} catch (SQLException e) { e.printStackTrace();	}
//		finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch(Exception e2) {e2.printStackTrace();}
//		}
//		return dto;
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		
		String query = "insert into mvc_board ("
				+ "bId, bName, bTitle, bContent, bHit, bGroup, "
				+ "bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			String query = "insert into mvc_board ("
//					+ "bId, bName, bTitle, bContent, bHit, bGroup, "
//					+ "bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
//				
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch (Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}
		
	}
	
	public void delete(final String bId) {
		
		String query = "delete from mvc_board where bId=?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bId);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			String query = "delete from mvc_board where bId=?";
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(bId));
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch (Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}	
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update mvc_board set bName = ?, bTitle = ? , bContent = ?  where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setString(4, bId);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			String query = "update mvc_board set bName = ?, bTitle = ? , bContent = ?  where bId = ?";
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setInt(4, Integer.parseInt(bId));
//			int rn = preparedStatement.executeUpdate();
//			System.out.println( bId + bName + bTitle + bContent);
//		} catch(Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}
	}
	
	public BDto reply_view(String strId) {
		
		String query = "select * from mvc_board where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
//		BDto dto = null;
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			String query = "select * from mvc_board where bId = ?";
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strId));
//			resultSet = preparedStatement.executeQuery();
//			
//			System.out.println(strId);
//			
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//		} catch (SQLException e) { e.printStackTrace();	}
//		finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch(Exception e2) {e2.printStackTrace();}
//		}
//		return dto;
	}
	
	public void reply(String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
		
		replyShape(bGroup, bStep);
		
		String query = "insert into mvc_board (bId, bName, bTitle, " 
				+ "bContent, bGroup, bStep, bIndent) values (" 
				+ "mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep)+1);
				ps.setInt(6, Integer.parseInt(bIndent)+1);
			}
		});
		
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			String query = "insert into mvc_board (bId, bName, bTitle, " 
//										+ "bContent, bGroup, bStep, bIndent) values (" 
//										+ "mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
//			
//			connection = dataSource.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setInt(4, Integer.parseInt(bGroup));
//			preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
//			preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
//			int rn = preparedStatement.executeUpdate();
//			
//			System.out.println( bId + bName + bTitle + bContent);
//			
//		} catch(Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}
		
	}

	public void upHit(final String bId) { // 수정이든, 답글이든, 이 글을 조회하면 1씩 증가
		
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bId);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//		
//			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
//			connection = dataSource.getConnection();	
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bId); 
////			preparedStatement.setInt(4, Integer.parseInt(bId));
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}
		
	}
	
	public void replyShape(final String strGroup, final String strStep) {
		
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//		
//			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
//			connection = dataSource.getConnection();	
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strGroup));
//			preparedStatement.setInt(2, Integer.parseInt(strStep));
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) { e.printStackTrace(); }
//		finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (SQLException e2) {	e2.printStackTrace();	}
//		}
		
	}

}
