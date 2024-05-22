package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Contact_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 7929748897411870510L;
	@Id
	@Column(name="CI_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
