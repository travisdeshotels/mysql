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
@Table(name="Contact_Info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 7929748897411870510L;
	@Id
	@Column(name="CI_ID")
	@GeneratedValue
	private int id;
	@Column(name="Street")
	private String street;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Zip")
	private String zip;
	@Column(name="Phone")
	private String phone;
	@Column(name="Email")
	private String email;
}
