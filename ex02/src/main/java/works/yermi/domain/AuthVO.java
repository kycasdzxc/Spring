package works.yermi.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data @Alias("auth")
public class AuthVO {
	private String userid;
	private String auth;
}
