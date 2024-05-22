package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Customer")
@PrimaryKeyJoinColumn(name="C_ID")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
	private static final long serialVersionUID = 1951060451225640025L;
	@Column(name="F_NAME")
	private String firstName;
	@Column(name="L_NAME")
	private String lastName;
	@OneToMany(mappedBy="customer")
	private List<Invoice> orders;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="CI_ID")
	private ContactInfo contactInfo;
}
