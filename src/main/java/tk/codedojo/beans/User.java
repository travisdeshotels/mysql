package tk.codedojo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.security.SecureRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACCOUNTS")
@Inheritance(strategy=InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User implements Serializable {
	private static final long serialVersionUID = -5141943028394764957L;
	@Id
	@SequenceGenerator(name="ACCOUNT_SEQ", sequenceName="ACCOUNT_SEQ")
	@GeneratedValue(generator="ACCOUNT_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="A_ID")
	private int userId;
	@Column(name="U_NAME")
	private String username;
	@NotNull
	@Column(name="P_WORD")
	private int password;
	@Column(name="MY_SALT")
	private String salt;

	private int salt(String pw){
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

