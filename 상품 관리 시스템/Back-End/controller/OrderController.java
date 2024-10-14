package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.OrderDTO;
import com.korea.product.dto.ProductDTO;
import com.korea.product.dto.ResponseDTO;
import com.korea.product.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

	private final OrderService orderService;

	@GetMapping("total")
	public ResponseEntity<?> getAllOrderTotals() {
		List<OrderDTO> list = orderService.getAllOrderTotallPrices();
		ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
	public ResponseEntity<?> saveOrder(@RequestBody OrderDTO dto) {
		List<ProductDTO> list = orderService.save(dto);
		ResponseDTO<ProductDTO> reponse = ResponseDTO.<ProductDTO>builder().data(list).build();
		
		return ResponseEntity.ok().body(reponse);
	}

}
