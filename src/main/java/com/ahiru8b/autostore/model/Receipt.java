package com.ahiru8b.autostore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Person customer;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItem> items = new ArrayList<>();

	public int price() {
		int price = 0;
		for (OrderItem item : items) {
			price += item.price();
		}
		return price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", customer=" + customer + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipt other = (Receipt) obj;
		return Objects.equals(id, other.id);
	}

}
