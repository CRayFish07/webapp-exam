package edisonbetter.webexam.infra.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(generator="uuidGenerator")
	@GenericGenerator(name="uuidGenerator", strategy="uuid")
	private String uuid;
	
	@Version
	private long version;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
