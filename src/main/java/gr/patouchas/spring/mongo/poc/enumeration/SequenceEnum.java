package gr.patouchas.spring.mongo.poc.enumeration;

import java.util.Arrays;

import gr.patouchas.spring.mongo.poc.User;
import gr.patouchas.spring.mongo.poc.UserGroup;

/**
 * The Enum SequenceEnum. Keeps information about the sequencies
 */
public enum SequenceEnum {

	USER("user_seq", User.class),
	
	USER_GROUP("usergroup_seq", UserGroup.class);
	
	private String seqName;
	
	private Class sequenceClass;

	private SequenceEnum(String seqName, Class sequenceClass) {
		this.seqName = seqName;
		this.sequenceClass = sequenceClass;
	}
	
	
	public String getSeqName() {
		return seqName;
	}


	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}


	public Class getSequenceClass() {
		return sequenceClass;
	}


	public void setSequenceClass(Class sequenceClass) {
		this.sequenceClass = sequenceClass;
	}


	public static SequenceEnum byClass(Class clazz){
		return Arrays.asList(SequenceEnum.values()).stream().filter(s -> s.getSequenceClass().equals(clazz)).findFirst().orElse(null);
	}
}
