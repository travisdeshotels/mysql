package tk.codedojo.beans;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {
	private static final long serialVersionUID = -5606066870734426992L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Inv_ID")
	private int id;
	@Column(name="Total")
	private double total;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="C_ID")
	private Customer customer;
	@OneToMany(mappedBy="invoice")
	List<InvoiceItem> invoiceItems;
}
