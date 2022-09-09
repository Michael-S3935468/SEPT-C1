package com.c1.q2.model;

public class Item
{
    protected int id;
    protected String title;
    protected String desc;
    protected String imagePath;
    protected float price;

    // Constructor
    public Item(int id, String title, String desc, String imagePath, float price)
    {
        this.id = id;
        this.setTitle(title);
        this.setDesc(desc);
        this.setImagePath(imagePath);
        this.setPrice(price);
    }

    // Update from an existing item
    public void update(Item other)
    {
        // Items are keyed by ID, so we should never change ID.
        assert(this.id == other.id);

        this.setTitle(other.getTitle());
        this.setDesc(other.getDesc());
        this.setImagePath(other.getImagePath());
        this.setPrice(other.getPrice());
    }

    // Getters/setters
    // id
    public int getId() { return this.id; }

    // title
    public void setTitle(String title) { this.title = title; }
    public String getTitle() { return this.title; }

    // desc
    public void setDesc(String desc) { this.desc = desc; }
    public String getDesc() { return this.desc; }

    // imagePath
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public String getImagePath() { return this.imagePath; }

    // price
    public void setPrice(float price) { this.price = price; }
    public float getPrice() { return this.price; }
}
