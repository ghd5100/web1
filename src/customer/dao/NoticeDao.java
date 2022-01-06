package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {
	
	public List<Notice> noticeSelAll() throws Exception {
		//보따리 속에 또 보따리르 쌓아야함... 이 매소드는. 리스트에다가 클래스를 담아쥼요!
		
		Connection con=DBCon.getConnection();
		String sql="select * from notices order by to_number(seq) desc";
		
		
		//실행
		PreparedStatement pstmt=con.prepareStatement(sql);

		/*쿼리를 넣는데 대신 %자바%니까 ..%포함되게 */
		
		//결과
		ResultSet rs=pstmt.executeQuery();
		/*pstmt는 익스큐트쿼리괄호에 sql안들어감*/
		
		
		//리스트에 Notice 내용을 담기 *** 잘 이해해보기
		List<Notice> list=new ArrayList<Notice>();
		
		while (rs.next()) { //다음있을떄 까지 계속 돈다. if 절을 안에 만들필요는 없어... while문 자체가 참일떄 계속 도니까.
			Notice n=new Notice();
			n.setSeq(rs.getString("seq"));
			n.setContent(rs.getString("content"));
			n.setHit(rs.getInt("hit"));
			n.setWriter(rs.getString("writer"));
			n.setRegdate(rs.getDate("regdate"));
			n.setTitle(rs.getString("title"));
			list.add(n);
		}
		
		return list;
	}
	

		
}
	



