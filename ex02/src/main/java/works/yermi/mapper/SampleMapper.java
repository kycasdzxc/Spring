package works.yermi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SampleMapper {
	@Insert("INSERT INTO TBL_SAMPLE1 VALUES (#{str})")
	int insert1(String str);
	
	@Insert("INSERT INTO TBL_SAMPLE2 VALUES (#{str})")
	int insert2(String str);
	
	@Select("SELECT * FROM USERS")
	List<Map<String, String>> getUsers();
	
	@Update("UPDATE USERS SET PASSWORD = #{val2} WHERE USERNAME = #{val1}")
	void updateUser(@Param("val1") String val1, @Param("val2") String val2);
}
