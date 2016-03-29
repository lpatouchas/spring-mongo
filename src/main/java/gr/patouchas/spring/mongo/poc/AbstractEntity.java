package gr.patouchas.spring.mongo.poc;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/** The type {@link AbstractEntity} is the abstract domain class. All domain objects should extend this entity. */

public abstract class AbstractEntity<ID extends Serializable> implements Serializable {
	/** The constant serialVersionUID. */
	private static final long serialVersionUID = 4287803674125626642L;

	/** The id of the entity. */
	@Id
	protected ID id;


	/**
	 * Gets the id of the entity.
	 *
	 * @return the id of the entity
	 */
	public ID getId() {
		return this.id;
	}

	/**
	 * Sets the id of the entity.
	 *
	 * @param id the id of the entity
	 */
	public void setId(final ID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("AbstractEntity [id=");
		builder.append(this.id);
		builder.append("]");
		return builder.toString();
	}


}
