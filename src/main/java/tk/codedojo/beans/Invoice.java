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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {
	private static final long serialVersionUID = -5606066870734426992L;
	@Id
	@SequenceGenerator(name="INVOICE_SEQ", sequenceName="INVOICE_SEQ")
	@GeneratedValue(generator="INVOICE_SEQ", strategy=GenerationType.SEQUENCE)
	@Column(name="I_ID")
	private int id;
	@JoinTable(name="I_STATUS",
			joinColumns=@JoinColumn(name="I_STATUS"),
			inverseJoinColumns=@JoinColumn(name="IS_ID"))
	private String Status;
	@Column(name="TOTAL")
	private double total;
	@ManyToOne
	private ContactInfo contact;
	@ManyToOne
	private Customer customer;
}
