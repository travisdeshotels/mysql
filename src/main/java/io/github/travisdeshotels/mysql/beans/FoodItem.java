package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Food_Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem implements Serializable {
	private static final long serialVersionUID = -6437357436131993928L;
	@Id
	@Column(name="MI_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
