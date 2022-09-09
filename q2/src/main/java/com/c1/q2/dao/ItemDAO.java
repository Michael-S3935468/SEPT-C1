package com.c1.q2.controller;

import java.util.HashMap;
import java.util.ArrayList;
import com.c1.q2.model.Item;

class ItemDAO
{
    private HashMap<int, Item> items;

    // Get a specific item by id.
    public Item getById(int id)
    {
        return items[id];
    }

    // Return a list of all items. Order is not defined.
    public ArrayList<Item> getAll()
    {
        ArrayList<Item> result;

        // Add each item to list
        for (Item i : this.items.values())
        {
            result.add(i);
        }

        return result;
    }

    // Update an existing item, or add an item if no item exists with the specified item id.
    public void updateItem(Item item)
    {
        if (!this.items.containsKey(item.id))
        {
            // Add new item
            this.items[item.id] = item;
        }
        else
        {
            // Update item
            this.items[item.id].update(item);
        }
    }

    // Delete item
    public void deleteItem(Item item)
    {
        if (this.items.containsKey(item.id)) {
            this.items.remove(item.id);
        }
    }
}