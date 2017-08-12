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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MENU_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem implements Serializable {
	private static final long serialVersionUID = -6437357436131993928L;
	@Id
	@Column(name="MI_ID")
	@SequenceGenerator(sequenceName="FOOD_ID_SEQ", name="FOOD_ID_SEQ")
	@GeneratedValue(generator="FOOD_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="MI_NAME")
	private String name;
	@Column(name="MI_DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private float price;
	@ManyToOne
	private Restaurant restaurant;
	@Column(name="MI_SPECIAL")
	private boolean isSpecial;
	private boolean soldOut;
}
