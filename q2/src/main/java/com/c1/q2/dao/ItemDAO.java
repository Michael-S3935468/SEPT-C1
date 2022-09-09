package com.c1.q2.dao;

import java.util.HashMap;
import java.util.ArrayList;
import com.c1.q2.model.Item;
import com.c1.q2.exception.ItemDoesNotExistException;

public class ItemDAO
{
    private HashMap<String, Item> items;

    // Constructor
    public ItemDAO()
    {
        this.items = new HashMap<String, Item>();
    }

    // Check an item id exists. If it does not, throw an ItemDoesNotExistException.
    protected void ensureExists(int id) throws ItemDoesNotExistException {
        if (!this.items.containsKey(Integer.toString(id)))
        {
            throw new ItemDoesNotExistException(id);
        }
    }

    // Get a specific item by id.
    public Item getById(int id) throws ItemDoesNotExistException {
        this.ensureExists(id);
        return this.items.get(Integer.toString(id));
    }

    // Return a list of all items. Order is not defined.
    public ArrayList<Item> getAll()
    {
        ArrayList<Item> result = new ArrayList<Item>();

        // Add each item to list
        for (Item i : this.items.values())
        {
            result.add(i);
        }

        return result;
    }

    // Update an existing item, or add an item if no item exists with the specified item id.
    public void updateItem(Item item) {
        String id = Integer.toString(item.getId());

        if (!this.items.containsKey(id))
        {
            // Add new item
            this.items.put(id, item);
        }
        else
        {
            // Update item
            this.items.get(id).update(item);
        }
    }

    // Delete item
    public void deleteItem(int id) throws ItemDoesNotExistException {
        this.ensureExists(id);
        this.items.remove(Integer.toString(id));
    }
}