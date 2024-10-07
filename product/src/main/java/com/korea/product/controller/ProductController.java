package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

	private final ProductService service;

	// 상품 추가
	@PostMapping
	public ResponseEntity<?> addProduct() {

		return ResponseEntity.ok().body(service.addProduct());
	}

	// 상품 조회
	@GetMapping
	public ResponseEntity<?> getFilteredProducts(@RequestParam(value = "minPrice", required = false) Double minPrice,
			@RequestParam(value = "name", required = false) String name) {
		List<ProductDTO> products = service.getFilteredProducts(minPrice, name);
		return ResponseEntity.ok().body(products);

	}

	// 상품수정
	//localhost9090/api/products/1
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO dto) {
		ProductDTO updateDTO = service.updateProduct(id, dto);
		if (updateDTO != null) {
			return ResponseEntity.ok().body(updateDTO);
		}
		return ResponseEntity.badRequest().body("업데이트가 안됐습니다.");
	}

	// 상품 삭제
	// localhost9090/products/1
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		boolean isDeleted = service.deleteProduct(id);
		if (isDeleted) {
			return ResponseEntity.ok().body("삭제되었습니다.");
		}
		return ResponseEntity.badRequest().body("삭제되지 않았습니다.");
	}

}
