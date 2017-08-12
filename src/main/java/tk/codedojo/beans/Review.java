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
@Table(name="REVIEW")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
	private static final long serialVersionUID = 4940360422921148493L;
	@Id
	@Column(name="RATE_ID")
	@SequenceGenerator(sequenceName="RATING_SEQ", name="RATING_SEQ")
	@GeneratedValue(generator="RATING_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="STARS")
	private float stars;
	@Column(name="COMMENTS")
	private String comment;
	@ManyToOne
	private Restaurant restaurant;
}
