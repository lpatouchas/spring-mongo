package gr.patouchas.spring.mongo.poc;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User extends AbstractEntity<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Indexed(unique = true)
	private String name;

	@DBRef
	private List<UserGroup> usergroups;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<UserGroup> getUsergroups() {
		return this.usergroups;
	}

	public void setUsergroups(final List<UserGroup> usergroups) {
		this.usergroups = usergroups;
	}

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", usergroups=" + this.usergroups + "]";
	}

}
