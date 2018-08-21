package member.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.dto.MemberDTO;
import member.model.dao.MemberDAO;
import member.model.exception.DuplicatedIdException;
import member.model.exception.DuplicatedRegisterNumberException;

import org.springframework.web.multipart.MultipartFile;
//회원 관리 Business Logic을 처리하는 Business Service 클래스
public class MemberManageService {

	private MemberDAO dao;
	private String pictureDir;
	public MemberManageService(MemberDAO dao, String pictureDir){
		this.dao = dao;
		this.pictureDir = pictureDir;
	}
	
	//가입처리 메소드
	public void registerMember(MemberDTO mto) throws SQLException,
																			DuplicatedIdException,
																			DuplicatedRegisterNumberException,
																			IOException{
		//1. 등록된 ID가 있는 지 체크
		//    - 이미 등록된 ID라면 DuplicatedIdException를 발생 시킨다.
		if(dao.selectMemberById(mto.getId())!=null){
			throw new DuplicatedIdException(mto.getId()+"는 이미 등록된 아이디입니다. ID를 변경하세요");
		}
		//2. 주민번호가 등록되있는지 체크
		//   - 이미 등록된 주민번호라면 DuplicatedRegisterNumberException를 발생시킨다.
		if(dao.selectMemberByRegisterNumber(mto.getRegisterNumber1(), mto.getRegisterNumber2())!= null){
			throw new DuplicatedRegisterNumberException("이미 가입된 주민번호 입니다.");
		}
		//3. 디비에 회원정보 등록 처리
		MultipartFile file = mto.getUpfile();
		//4. 업로드 처리
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf("."));
			long time = System.currentTimeMillis();
			String newFileName = time+extension;
			System.out.println(newFileName);
			file.transferTo(new File(pictureDir, newFileName));
			mto.setPictureFilename(newFileName);
		}
		//5. DB에 insert
		dao.insertMember(mto);
	}
	//전체 회원 목록 조회
	public ArrayList<MemberDTO> getMemberList() throws SQLException{
		return dao.selectAllMember();
	}

	public MemberDTO getMemberById(String id) throws SQLException{
		return dao.selectMemberById(id);
	}
	public void modifyMember(MemberDTO mto) throws SQLException, IOException{
//		파일 업로드 처리
		MultipartFile upfile = mto.getUpfile();
		if(upfile!=null&&!upfile.isEmpty()){// 수정시에는 upfile이란 이름으로 요청파라미터가 아예 안넘어 올 수 있기 때문에 null체크 필요
			String fileName = upfile.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf("."));
			long time = System.currentTimeMillis();
			String pictureFilename = time+extension;
			upfile.transferTo(new File(pictureDir, time+extension));
//			MemberDTO에 설정
			mto.setPictureFilename(pictureFilename);
		}
		dao.updateMember(mto);
	}
	public void removeMemberById(MemberDTO mto)throws Exception {
		dao.deleteMemberById(mto.getId());
//		업로드시 추가 - 파일 삭제
		new File(pictureDir, mto.getPictureFilename()).delete();
	}
	public List searchMemberByName(String name) throws SQLException{
		return  dao.selectMemberByName(name);
	}
	//마일리지 범위로 조회
	public List searchMemberByMileageRange(int sMileage, int eMileage) throws SQLException{
		return dao.selectMemberByMileageRange(sMileage, eMileage);
	} 	
	//수정시 파일 삭제 처리
	public void deleteFile(MemberDTO mto) throws SQLException{
		int cnt = dao.updatePictureFilename(mto.getId());
		if(cnt==1){//DB에서 삭제가 처리되었으면
			//pictures 폴더에서 사진 삭제
			new File(pictureDir, mto.getPictureFilename()).delete();
			//session정보에서도 사진 정보 삭제
			mto.setPictureFilename(null);
		}
	}
	
}

















