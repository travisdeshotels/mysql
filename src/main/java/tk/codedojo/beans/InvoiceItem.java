package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem implements Serializable {
	private static final long serialVersionUID = 3535240967029267963L;
	@Id
	@Column(name="I_ID")
	@SequenceGenerator(sequenceName="INVOICE_ITEM_SEQ", name="INVOICE_ITEM_SEQ")
	@GeneratedValue(generator="INVOICE_ITEM_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	private FoodItem item;
	@Column(name="QUANTITY")
	private int quantity;
}
