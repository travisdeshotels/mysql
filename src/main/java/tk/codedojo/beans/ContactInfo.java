package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 7929748897411870510L;
	@Id
	@Column(name="CI_ID")
	@SequenceGenerator(sequenceName="CI_ID_SEQ", name="CI_ID_SEQ")
	@GeneratedValue(generator="CI_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATES")
	private String state;
	@Column(name="ZIP")
	private String zip;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	private String email;
}
