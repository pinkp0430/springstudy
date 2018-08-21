package member.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import member.dto.MemberDTO;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import src.main.webapp.lib.*;

public class MemberDAO {
	private SqlMapClientTemplate sqlMap;
	public MemberDAO(SqlMapClientTemplate sqlMap){
		this.sqlMap = sqlMap;
	}
	//회원데이터 insert메소드
	public void insertMember(MemberDTO mdto) throws SQLException{
		sqlMap.insert("insertMember", mdto);
	}
	//id로 회원 정보 조회
	public MemberDTO selectMemberById(String id) throws SQLException{
		return (MemberDTO)sqlMap.queryForObject("selectMemberById", id);
	}
	//주민번호로 조회
	public MemberDTO selectMemberByRegisterNumber(String rN1, String rN2)
						throws SQLException{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("registerNumber1", rN1);
		map.put("registerNumber2", rN2);
		return (MemberDTO)sqlMap.queryForObject(
												"selectMemberByRegisterNumber", map);
	}
	//전체 회원 정보조회
	public ArrayList<MemberDTO> selectAllMember() throws SQLException{
		return (ArrayList<MemberDTO>)sqlMap.queryForList("selectAllMember");
	}
	//회원정보 수정
	//update 메소드
	public int updateMember(MemberDTO mto) throws SQLException{
		return sqlMap.update("updateMemberById", mto);
	}
	//delete 메소드
	public int deleteMemberById(String id) throws SQLException{
		return sqlMap.delete("deleteMemberById", id);
	}
	public List selectMemberByMileageRange(int startMileage, int endMileage)
			throws SQLException{
		HashMap paramMap = new HashMap();
		paramMap.put("sMileage", startMileage);
		paramMap.put("eMileage", endMileage	);
		return sqlMap.queryForList("selectMemberByMileageRange", paramMap);
	}
	public List selectMemberByName(String name) throws SQLException{
		return sqlMap.queryForList("selectMemberByName", name);
	}
	//사진삭제처리
	public int updatePictureFilename(String id) throws SQLException{
		return sqlMap.update("updatePictureFilename", id);
	}
	
}











