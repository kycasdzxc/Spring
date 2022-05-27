package works.yermi.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class Board {
	private Long bno;
	private String title;
}
