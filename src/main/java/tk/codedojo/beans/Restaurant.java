package tk.codedojo.beans;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="Restaurant")
public class Restaurant implements Serializable{
	private static final long serialVersionUID = 4524158945507038283L;
	@Id
	@Column(name="R_ID")
    @GeneratedValue
	private int id;
	@Column(name="R_Name")
	private String name;
	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
	private List<FoodItem> menu;
//	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
//	private List<Review> reviews;
	@OneToOne
	@JoinColumn(name="CI_ID")
	private ContactInfo address;
}
