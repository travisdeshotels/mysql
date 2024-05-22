package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Invoice_Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem implements Serializable {
	private static final long serialVersionUID = 3535240967029267963L;
	@Id
	@Column(name="I_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="MI_ID")
	private FoodItem item;
	@Column(name="Quantity")
	private int quantity;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Inv_ID")
	private Invoice invoice;
}
