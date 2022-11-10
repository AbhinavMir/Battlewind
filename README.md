# CS611- PA3

## Legends: Monsters And Heroes

---------------------------------------------------------------------------
Abhinav Srivastva 
sabhinav@bu.edu

## Files

---------------------------------------------------------------------------
### A brief description of each file and what it does
`Battle.java` - A class to handle the battle between the hero and the monster. Can have one-to-one attack as chosen by user. A new instance is created when a battle is initiated in COMMON grounds. Local variable copies are maintained for speed

`ManualHandler.java` - A fallback handler when the readHandler fails. Only use for suspected corrupt files.

`Market.java` - A Market module to handle all market interactions.

`gameData.java` - A local DB-type storage for live game data.

`readHandler.java` - Handles read/write of data files.

`Characters.java` - Defines behvaiour and attributes of Heroes and Monsters (both are extended subclasses of Character class.

`Map.java` - Defines the behvaiour on Map. Each map is a 2D array of Tiles.

`PrettyPrint.java` - A simple processor to handle beautified printing. Not essential.

`itemClass.java` - Used to handle Item storage, inventory and such. Heavily extendible.

### Maps
Every `Tile` has a few essential members such as type (enum), x co-ordinate and y co-ordinate. Another important aspect is the `isPlayer` boolean that let's the parser know if there are any players on current tile. `getTileImage()` -  Parses current tile and returns a certain way the tile is to be printed. The Map is then a 2D array of Tiles. This allows for extendibility and modularity. All maps are inherently randomized.

### Heroes
All heroes are an extended subclass of the `Character` class. GameData stores an instance of chosen heroes. readHandler keeps an archive of all heroes. Heroes can call `attack()` and `spell()`. They can buy and sell in markets too. For simplicity, the spells are also stored here (in the Character superclass).

### Monsters
All monsters are an extended subclass of the `Character` class. Every Battle instance stores a randomly chosen roster of Monsters (level matched) in local scope. They're destroyed after battle is over.

### Item Class
Stores all the potions, armours and weapons. Every instance of market and hero calls these things from here.

### Read Handler and Manual Handler
These are used to read data from the `txt` files. They then store it in readHandler class. If anything fails, it calls `manualHandler`, which then makes ammends. For me, `dragons.txt` failed, so I've called it via manualHandler, but only after trying it with readHandler.

### Market
Markets are places where merchants sell and buy a bunch of things. Uses in-game currency called Gold. Each hero has a certain amount of Gold that they can use. Defeating a monster gets them some gold. Losing a hero means losing all their gold.

### Battle
Can have directed attacks/spells towards a certain monster. Individual heroes can die too. Winning gets every hero certain amount of experience based on level of involvement.

## Notes
---------------------------------------------------------------------------
1. Files to be parsed should be stored in gameUtils, for parser class to
read class

2. #### Bonus Done

	- Probability of encountering an enemy reduces if hero has a repelling item
	- Prettified printing
	- Data read from txt
	- Map size modifiable

### Rules

Hero’s spell damage = 𝑠𝑝𝑒𝑙𝑙_𝑏𝑎𝑠𝑒_𝑑𝑎𝑚𝑎𝑔𝑒 + (
𝑑𝑒𝑥𝑡𝑒𝑟𝑖𝑡𝑦
10000 ) × 𝑠𝑝𝑒𝑙𝑙_𝑏𝑎𝑠𝑒_𝑑𝑎𝑚𝑎𝑔𝑒
• HP of monsters and heroes = 𝑙𝑒𝑣𝑒𝑙 × 100
When a hero levels up, this formula is used to reset their HP.
• MP of the heroes when they level up = 𝑐𝑢𝑟𝑟𝑒𝑛𝑡_𝑚𝑎𝑛𝑎 × 1.1
• Hero’s attack damage (with weapon) = (𝑠𝑡𝑟𝑒𝑛𝑔𝑡ℎ + 𝑤𝑒𝑎𝑝𝑜𝑛_𝑑𝑎𝑚𝑎𝑔𝑒) × 0.05
• Hero’s dodge chance = 𝑎𝑔𝑖𝑙𝑖𝑡𝑦 × 0.002
• Monster’s dodge chance = 𝑑𝑜𝑑𝑔𝑒_𝑐ℎ𝑎𝑛𝑐𝑒 × .01
• Experience points to level up = ℎ𝑒𝑟𝑜_𝑐𝑢𝑟𝑟𝑒𝑛𝑡_𝑙𝑒𝑣𝑒𝑙 × 10
• When a hero levels up all of their skills increase by 5% and their favored skills increase
by an extra 5%.
• At the end of each round of a battle the heroes regain 10% of their HP and 10% of their
MP. That is, 𝐻𝑃 = 𝐻𝑃 × 1.1 and 𝑀𝑃 = 𝑀𝑃 × 1.1
• Hero gold gain = 𝑚𝑜𝑛𝑠𝑡𝑒𝑟_𝑙𝑒𝑣𝑒𝑙 × 100 for heroes who did not faint
• Hero experience gain = 𝑛𝑢𝑚𝑏𝑒𝑟_𝑚𝑜𝑛𝑠𝑡𝑒𝑟𝑠 × 2
• Monster’s skill loss caused by spell effect = 𝑎𝑓𝑓𝑒𝑐𝑡𝑒𝑑𝑠𝑘𝑖𝑙𝑙 × 0.1
• Monster’s level = level of highest-level hero in the party
• Items sell for half of their purchase price.
• The party size is between 1 and 3 heroes

## How to compile and run

---------------------------------------------------------------------------

1. Navigate to `src` (`cd src`)
2. Run the following instructions:

	javac -d gameUtils *.java
	cd ../gameUtils
	java Main

## Game Example

---------------------------------------------------------------------------

```
Loading data, please wait...
  <=======]}======
    --.   /|
   _\"/_.'/
 .'._._,.'
 :/ \{}/
(L  /--',----._
    |          \\
   : /-\ .'-'\ / |
snd \\, ||    \|
     \/ ||    ||
Welcome to Legends: Monsters and Heroes
Enter size of map:
8
How many heroes?
1
Which type of hero would you like?
1. Warrior 	 2. Paladin 	 3. Sorcerer
2
Name | mana | strength | agility | dexterity | starting money | starting experience
Parzival | 300 | 750 | 650 | 700 | 2500 | 7
Sehanine_Moonbow | 300 | 750 | 700 | 700 | 2500 | 7
Skoraeus_Stonebones | 250 | 650 | 600 | 350 | 2500 | 4
Garl_Glittergold | 100 | 600 | 500 | 400 | 2500 | 5
Amaryllis_Astra | 500 | 500 | 500 | 500 | 2500 | 5
Caliber_Heist | 400 | 400 | 400 | 400 | 2500 | 8
Which Paladin would you like?
1
Name: Sehanine_Moonbow Level: 0 Exp: 7 HP: 0 Base Damage: 750 Mana: 300 Strength: 750 Agility: 700 Dexterity: 700 Gold: 0
Your team:
0: Name: Sehanine_Moonbow | Level: 0 | Damage: 750 | Defense: 0 | Dodge Chance: 0 | Gold: 0
Loading data, please wait...
YOU                           
                  (M)         
            (M)   (M)      (M)
               (M)      (M)   
                        (M)   
                              
                              
                        (M)   
                              
                             
```

