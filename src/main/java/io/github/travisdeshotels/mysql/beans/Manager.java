package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@PrimaryKeyJoinColumn(name="M_ID")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager extends User {
	private static final long serialVersionUID = 4202380130122285344L;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="R_ID")
	private Restaurant restaurant;
}
