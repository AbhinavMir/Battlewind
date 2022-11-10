// import arraylist

class itemClass {
}

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

    {
        System.out.println("You are not high enough level to use this item.");
    }

    public Potion(String name, int cost, int requiredLevel, int attributeIncrease, String attributeAffected) {
        super(name, cost, requiredLevel);
        this.attributeIncrease = attributeIncrease;
        this.attributeAffected = attributeAffected;
    }

    public void usePotion(Characters.Hero hero, Potion potion) {
        if (hero.level == potion.requiredLevel) {
            String attributeAffected = potion.attributeAffected;
            int amount = potion.attributeIncrease;
            // Health/Mana/Strength/Dexterity/Defense/Agility
            if (attributeAffected == "Health") {
                int heroHp = hero.getCurrentHp();
                hero.setCurrentHp(heroHp + amount);
            } else if (attributeAffected == "Mana") {
                int heroMp = hero.getMp();
                hero.setMp(heroMp + amount);
            } else if (attributeAffected == "Strength") {
                int heroDamage = hero.getBaseDamage();
                hero.setBaseDamage(heroDamage + amount);
            } else if (attributeAffected == "Agility") {
                int heroDodge = hero.getDodgeChance();
                hero.setDodgeChance(heroDodge + amount);
            } else if (attributeAffected == "Defense") {
                int heroDefense = hero.getDefense();
                hero.setDefense(heroDefense + amount);
            } else if (attributeAffected == "Dexterity") {
                int heroDexterity = hero.getDexterity();
                hero.setDexterity(heroDexterity + amount);
            } else if (attributeAffected.equals("All Health/Mana/Strength/Dexterity/Defense/Agility")) {
                int heroHp = hero.getCurrentHp();
                hero.setCurrentHp(heroHp + amount);
                int heroMp = hero.getMp();
                hero.setMp(heroMp + amount);
                int heroDamage = hero.getBaseDamage();
                hero.setBaseDamage(heroDamage + amount);
                int heroDodge = hero.getDodgeChance();
                hero.setDodgeChance(heroDodge + amount);
                int heroDefense = hero.getDefense();
                hero.setDefense(heroDefense + amount);
                int heroDexterity = hero.getDexterity();
                hero.setDexterity(heroDexterity + amount);
            }
        }
    }
}

