package gr.patouchas.spring.mongo.poc;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usergroup")
public class UserGroup extends AbstractEntity<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Indexed(unique = true)
	private String name;



	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserGroup [id=" + this.id + ", name=" + this.name + "]";
	}

}
