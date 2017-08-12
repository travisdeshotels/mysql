package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="C_ID")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
	private static final long serialVersionUID = 1951060451225640025L;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@OneToMany(mappedBy="customer")
	private List<Invoice> orders = new ArrayList<Invoice>();
}
