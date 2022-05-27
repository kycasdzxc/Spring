package works.yermi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AttachFileDTO {
	private String origin;
	private String uuid;
	private String path;
	private boolean image;
}
