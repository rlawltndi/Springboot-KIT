package com.korea.product.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orders")
public class OrderEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId; //주문번호
	
	@ManyToOne //ProductEntity와 다대일 관계를 설정
	@JoinColumn(name="productId", nullable=false)
	private ProductEntity product; //상품번호
	
	private int productCount; //주문개수

	@CreationTimestamp
	private String orderDate; //주문날짜
	 
	
}
