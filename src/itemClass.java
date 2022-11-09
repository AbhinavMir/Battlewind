// import arraylist

class itemClass
{}

class itemBaseClass {

    String name;
    int cost;
    int requiredLevel;

    public itemBaseClass(String name, int cost, int requiredLevel) {
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }
}


class Weapon extends itemBaseClass {
    int damage;
    int requiredHands;

    public Weapon(String name, int cost, int requiredLevel, int damage, int requiredHands) {
        super(name, cost, requiredLevel);
        this.damage = damage;
        this.requiredHands = requiredHands;
    }
}

class Armor extends itemBaseClass {
    int damageReduction;

    public Armor(String name, int cost, int requiredLevel, int damageReduction) {
        super(name, cost, requiredLevel);
        this.damageReduction = damageReduction;
    }
}

class Potion extends itemBaseClass {
    int attributeIncrease;
    String attributeAffected;

    public Potion(String name, int cost, int requiredLevel, int attributeIncrease, String attributeAffected) {
        super(name, cost, requiredLevel);
        this.attributeIncrease = attributeIncrease;
        this.attributeAffected = attributeAffected;
    }
}

