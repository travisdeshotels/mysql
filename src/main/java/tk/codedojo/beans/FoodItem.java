package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Food_Item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem implements Serializable {
	private static final long serialVersionUID = -6437357436131993928L;
	@Id
	@Column(name="MI_ID")
	@GeneratedValue
	private int id;
	@Column(name="MI_Name")
	private String name;
	@Column(name="MI_Description")
	private String description;
	@Column(name="Price")
	private float price;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="R_ID")
	private Restaurant restaurant;
	@Column(name="MI_Special")
	private boolean isSpecial;
	@Column(name="Sold_Out")
	private boolean soldOut;
}
