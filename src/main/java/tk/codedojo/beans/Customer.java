package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@PrimaryKeyJoinColumn(name="C_ID")
@Getter
@Setter
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
	@OneToOne
	@JoinColumn(name="CI_ID")
	private ContactInfo contactInfo;
}
