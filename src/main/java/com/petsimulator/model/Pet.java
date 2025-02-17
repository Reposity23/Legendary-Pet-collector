package com.petsimulator.model;

public class Pet {
    private String id;
    private String name;
    private Rarity rarity;
    private int level;
    private String ownerId;

    public enum Rarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY,
        GODLY
    }

    // Constructor
    public Pet(String id, String name, Rarity rarity, String ownerId) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.level = 1;
        this.ownerId = ownerId;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Rarity getRarity() { return rarity; }
    public void setRarity(Rarity rarity) { this.rarity = rarity; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
}