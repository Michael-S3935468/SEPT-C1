package com.c1.q2.controller;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.c1.q2.dao.ItemDAO;
import com.c1.q2.model.Item;
import com.c1.q2.exception.ItemDoesNotExistException;



@SpringBootApplication
@RestController
public class Q2Application {

	private final ItemDAO items = new ItemDAO();

	public static void main(String[] args) {
		SpringApplication.run(Q2Application.class, args);
	}

	@GetMapping("/item/item{id}")
	ResponseEntity<Item> getItemById(@PathVariable(value="id") int id)
	{
		try {
			return ResponseEntity.ok().body(items.getById(id));
		} catch (ItemDoesNotExistException ex)
		{
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/item/item")
	ResponseEntity<ArrayList<Item>> getItems()
	{
		return ResponseEntity.ok().body(this.items.getAll());
	}

	@PutMapping("/item/item")
	ResponseEntity<String> updateItem(@RequestBody Item item)
	{
		this.items.updateItem(item);
		return ResponseEntity.ok().body("OK");
	}

	@DeleteMapping("/item/item")
	ResponseEntity<String> deleteItem(@RequestBody Item item)
	{
		try {
			this.items.deleteItem(item.getId());
			return ResponseEntity.ok().body("Deleted item with id " + item.getId());
		} catch (ItemDoesNotExistException ex)
		{
			return ResponseEntity.badRequest().body("No item with id " + item.getId());
		}
	}
}
