package com.ahiru8b.autostore.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detail_id")
	private Detail detail;
	private Integer count;

	public int price() {
		return detail.getPrice() * count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", detail=" + detail + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, detail, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(count, other.count) && Objects.equals(detail, other.detail)
				&& Objects.equals(id, other.id);
	}

}
