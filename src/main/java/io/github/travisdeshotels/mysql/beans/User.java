package io.github.travisdeshotels.mysql.beans;

import lombok.*;

import java.io.Serializable;
import java.security.SecureRandom;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Accounts")
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User implements Serializable {
	private static final long serialVersionUID = -5141943028394764957L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="A_ID")
	private int userId;
	@Column(name="U_NAME")
	private String userName;
	@NotNull
	@Column(name="P_WORD")
	private int password;
	@Column(name="MY_SALT")
	private String salt;

	public int salt(String pw){
		SecureRandom sr = new SecureRandom();
		if(this.salt == null){
			generateSalt();
			setSalt(this.salt + (int) (sr.nextDouble() * pw.length()));
		}
		int i = Integer.parseInt("" + this.salt.charAt(this.salt.length() - 1));
		pw = pw.substring(0, i) + this.salt + pw.substring(i);
		
		return pw.hashCode();
	}
	
	private void generateSalt(){
		String salt = "";
		SecureRandom sr = new SecureRandom();
		for(int i = 0; i < 100; i++){
			Character c;
			do{
				c = (char) (sr.nextDouble() *'z'+1);
			} while(!(Character.isLetter(c) ||Character.isDigit(c)));
			salt+= c;
		}
		
		setSalt(salt);
	}

	public boolean checkPassword(String pw){
		return salt(pw) == this.password;
	}

}

