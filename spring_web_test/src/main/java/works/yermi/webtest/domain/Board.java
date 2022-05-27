package works.yermi.webtest.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @NoArgsConstructor @AllArgsConstructor
public class Board {
	private Long bno;
	private String title;
	private String content;
}
