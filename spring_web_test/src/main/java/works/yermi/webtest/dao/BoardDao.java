package works.yermi.webtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import works.yermi.webtest.domain.Board;

@Service
public class BoardDao {
	public List<Board> list() {
		List <Board> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@np.yermi.works:1521/xe", "odoung", "1234");
			ResultSet rs = conn.prepareStatement("SELECT BNO, TITLE, CONTENT FROM TBL_BOARD WHERE ROWNUM <= 10").executeQuery();
			while(rs.next()) {
				int idx = 1;
				Board board = new Board(rs.getLong(idx++), rs.getString(idx++), rs.getString(idx++));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
