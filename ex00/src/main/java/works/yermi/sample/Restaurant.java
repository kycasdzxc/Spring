package works.yermi.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString @RequiredArgsConstructor /*@Setter*/ @Getter
public class Restaurant {
    @NonNull //	@Autowired // setter는 autowired랑 한쌍. 생성자 주입은 생략 가능
	private Chef chef;
}
