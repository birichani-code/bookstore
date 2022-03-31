package com.bookstore.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String cardName;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private int cvc;
	private String holderName;
	private boolean defaultPayment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
	private UserBilling userBilling;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.
				getClass(this) != Hibernate.getClass(o)) return false;
		UserPayment that = (UserPayment) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
