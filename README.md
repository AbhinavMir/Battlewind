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



## How to compile and run
---------------------------------------------------------------------------

1. Navigate to the root directory after unzipping. Also called the src folder.
2. Run the following instructions:

	Go into root folder (src folder)	
		Run the below commands
	
	-javac Main.java
	-java Main


## Game Example
---------------------------------------------------------------------------

Welcome to the Legacy of Ra
Before we begin with your journey, tell me a little about yourself brave warrior
Please enter your name
Input: Abhishek

As the clouds grew thicker and the wind blew stronger... The name Abhishek echoed in the sky, shivers ran down the spine of monsters and ghouls
||                                                        ||
|  |                                                      |  |
|----|                   Warriors of Ra                   |----|
[______]   Birth place of the worlds strongest warriors   [______]
|    |         _____                        _____         |    |
|[]  |        [     ]                      [     ]        |  []|
|    |       [_______][ ][ ][ ][][ ][ ][ ][_______]       |    |
|    [ ][ ][ ]|     |  ,----------------,  |     |[ ][ ][ ]    |
|             |     ||'    ____..____    '||     |             |
|  []         |     |    |'    ||    '|    |     |        []  |
|      []     |     |   |o     ||     o|   |     |  []       |
|             |  _  |   |     _||_     |   |  _  |           |
|   []        | (_) |   |    (_||_)    |   | (_) |       []  |
|             |     |   |     (||)     |   |     |           |
|             |     |   |      ||      |   |     |           |
/''           |     |   |o     ||     o|   |     |           ''|
[_____________[_______]--'------''------'--[_______]_____________]
In the year 27 BC there was a kingdom in the depths of Lanchestier where the great warriors of Ra trained and fought of dangerous predators who preyed on the weak.
Any child born irrespective of their gender or choices had a heart to fight for those who could not fight for themselves.
All brave soldiers trained together, battled together, lived together.
Until one day...........
News of the Queen's death turned the kingdom upside down
War broke out between the warriors and monsters
Only warrior who could stop it all was the Queens sibling.
Brave Warrior! You shall play as the Queen's sibling travelling through the grounds of the fallen Lanchestier
Fight the monsters, save the kingdom, bring justice to the people and save your brave and valiant sisters legacy
For her last letter to you asked only one thing of you, "Save our people my Dear Abhishek"
Continuing in 2 seconds...

Please enter size of your team. Size should be between 1 and 3
Careful! Stronger your team, stronger the enemies
Read ChanceOfStats document for clarity on difficulty and learning models of monsters
Input: 2


-----Select Hero Type-----
1. Warrior
2. Sorcerer
3. Paladin
0. Quit Game

Input: 3

Paladins:- 
|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||            Parzival||    1500||    1400||    2500||       750||        700||      650||                    7||        0|
|           2||    Sehanine_Moonbow||    1500||    1400||    2500||       750||        700||      700||                    7||        0|
|           3|| Skoraeus_Stonebones||    1000||     700||    2500||       650||        350||      600||                    4||        0|
|           4||    Garl_Glittergold||    1000||     800||    2500||       600||        400||      500||                    5||        0|
|           5||     Amaryllis_Astra||    1000||    1000||    2500||       500||        500||      500||                    5||        0|
|           6||       Caliber_Heist||    2000||     800||    2500||       400||        400||      400||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 2


-----Select Hero Type-----
1. Warrior
2. Sorcerer
3. Paladin
0. Quit Game

Input: 2

Sorcerers:- 
|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1|| Rillifane_Rallathil||    2000||    1000||    2500||       750||        500||      450||                    9||        0|
|           2|| Segojan_Earthcaller||    1000||    1300||    2500||       800||        650||      500||                    5||        0|
|           3||         Reign_Havoc||    2000||    1600||    2500||       800||        800||      800||                    8||        0|
|           4||      Reverie_Ashels||    1500||     800||    2500||       800||        400||      700||                    7||        0|
|           5||             Kalabar||    1500||    1200||    2500||       850||        600||      400||                    6||        0|
|           6||           Skye_Soar||    1000||    1000||    2500||       700||        500||      400||                    5||        0|
|           0||                                                                             Return to Previous menu|
Input: 3


-----Please Select Difficulty of Game-----
1. Easy (8x8 map size)
2. Medium (10x10 map size)
3. Hard (15x15 map size)
4. Enter Custom dimensions (To enjoy the game please keep dimensions logical, within 25)
0. Quit Game

Input: 1


-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
| P ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: m

----Please select Hero to purchase products for----
|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||    2500||       750||        700||      700||                    7||        0|
|           2||         Reign_Havoc||    2000||    1600||    2500||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 1

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 1


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||--Attributes Affected---||--Attribute Increment---||--------Item Cost-------|

|           1||          Healing_Potion||                       1||                       0||                [Health]||                     100||                     250|
|           2||         Strength_Potion||                       1||                       0||              [Strength]||                      75||                     200|
|           3||            Magic_Potion||                       2||                       0||                  [Mana]||                     100||                     350|
|           4||             Luck_Elixir||                       4||                       0||               [Agility]||                      65||                     500|
|           5||           Mermaid_Tears||                       5||                       0||                [Health]||                     100||                     850|
|           6||                Ambrosia||                       8||                       0||                [Health]||                     150||                    1000|

0. Return to Previous Menu

Input: 1


Sehanine_Moonbow bought Healing_Potion for 250


Sehanine_Moonbow has 2250 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 1


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||--Attributes Affected---||--Attribute Increment---||--------Item Cost-------|

|           1||          Healing_Potion||                       1||                       1||                [Health]||                     100||                     250|
|           2||         Strength_Potion||                       1||                       0||              [Strength]||                      75||                     200|
|           3||            Magic_Potion||                       2||                       0||                  [Mana]||                     100||                     350|
|           4||             Luck_Elixir||                       4||                       0||               [Agility]||                      65||                     500|
|           5||           Mermaid_Tears||                       5||                       0||                [Health]||                     100||                     850|
|           6||                Ambrosia||                       8||                       0||                [Health]||                     150||                    1000|

0. Return to Previous Menu

Input: 2


Sehanine_Moonbow bought Strength_Potion for 200


Sehanine_Moonbow has 2050 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 2


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       0||                     200||                   false||                     150|
|           2||             Breastplate||                       3||                       0||                     600||                   false||                     350|
|           3||         Full_Body_Armor||                       8||                       0||                    1100||                   false||                    1000|
|           4||           Wizard_Shield||                      10||                       0||                    1500||                   false||                    1200|
|           5||          Guardian_Angel||                      10||                       0||                    1000||                   false||                    1000|

0. Return to Previous Menu

Input: 1


Sehanine_Moonbow bought Platinum_Shield for 150


Sehanine_Moonbow has 1900 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 2


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                   false||                     150|
|           2||             Breastplate||                       3||                       0||                     600||                   false||                     350|
|           3||         Full_Body_Armor||                       8||                       0||                    1100||                   false||                    1000|
|           4||           Wizard_Shield||                      10||                       0||                    1500||                   false||                    1200|
|           5||          Guardian_Angel||                      10||                       0||                    1000||                   false||                    1000|

0. Return to Previous Menu

Input: 3


Sehanine_Moonbow bought Full_Body_Armor for 1000


Sehanine_Moonbow has 900 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 3


|-Select Key-||----------Name----------||-----Required level-----||---------Damage---------||-----Hands Required-----||--------Item Cost-------|

|           1||                   Sword||                       1||                     800||                       1||                     500|
|           2||                     Bow||                       2||                     500||                       2||                     300|
|           3||                  Scythe||                       6||                    1100||                       2||                    1000|
|           4||                     Axe||                       5||                     850||                       1||                     550|
|           5||                 TSwords||                       8||                    1600||                       2||                    1400|
|           6||                  Dagger||                       1||                     250||                       1||                     200|

0. Return to Previous Menu

Input: 1


Sehanine_Moonbow bought Sword for 500


Sehanine_Moonbow has 400 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 6
Input doesn't match specifications. Enter a number between 0 and 5
Input: 4


|-Select Key-||----------Name----------||-Item Cost-||-Mana Cost-||---Damage---||-Required level-||-Attributes Effected-||-CoolDown Time-||------Type----|

|           1||             Snow_Cannon||          500||        250||         650||               2||             [Damage]||              0||     ice spell|
|           2||               Ice_Blade||          250||        100||         450||               1||             [Damage]||              0||     ice spell|
|           3||          Frost_Blizzard||          750||        350||         850||               5||             [Damage]||              0||     ice spell|
|           4||            Arctic_Storm||          700||        300||         800||               6||             [Damage]||              0||     ice spell|
|           5||           Flame_Tornado||          700||        300||         850||               4||            [Defence]||              0||    fire spell|
|           6||          Breath_of_Fire||          350||        100||         450||               1||            [Defence]||              0||    fire spell|
|           7||               Heat_Wave||          450||        150||         600||               2||            [Defence]||              0||    fire spell|
|           8||              Lava_Comet||          800||        550||        1000||               7||            [Defence]||              0||    fire spell|
|           9||              Hell_Storm||          600||        600||         950||               3||            [Defence]||              0||    fire spell|
|          10||        Lightning_Dagger||          400||        150||         500||               1||        [dodgeChance]||              0||lightning spell|
|          11||           Thunder_Blast||          750||        400||         950||               4||        [dodgeChance]||              0||lightning spell|
|          12||         Electric_Arrows||          550||        200||         650||               5||        [dodgeChance]||              0||lightning spell|
|          13||           Spark_Needles||          500||        200||         600||               2||        [dodgeChance]||              0||lightning spell|

0. Return to Previous Menu

Input: 1

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 0

----Please select Hero to purchase products for----
|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||       750||        700||      700||                    7||        0|
|           2||         Reign_Havoc||    2000||    1600||    2500||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 2

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 2


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       0||                     200||                   false||                     150|
|           2||             Breastplate||                       3||                       0||                     600||                   false||                     350|
|           3||         Full_Body_Armor||                       8||                       0||                    1100||                   false||                    1000|
|           4||           Wizard_Shield||                      10||                       0||                    1500||                   false||                    1200|
|           5||          Guardian_Angel||                      10||                       0||                    1000||                   false||                    1000|

0. Return to Previous Menu

Input: 1


Reign_Havoc bought Platinum_Shield for 150


Reign_Havoc has 2350 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 2


|-Select Key-||----------Name----------||-----Required level-----||---Quantity Purchased---||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                   false||                     150|
|           2||             Breastplate||                       3||                       0||                     600||                   false||                     350|
|           3||         Full_Body_Armor||                       8||                       0||                    1100||                   false||                    1000|
|           4||           Wizard_Shield||                      10||                       0||                    1500||                   false||                    1200|
|           5||          Guardian_Angel||                      10||                       0||                    1000||                   false||                    1000|

0. Return to Previous Menu

Input: 2


Reign_Havoc bought Breastplate for 350


Reign_Havoc has 2000 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 3


|-Select Key-||----------Name----------||-----Required level-----||---------Damage---------||-----Hands Required-----||--------Item Cost-------|

|           1||                   Sword||                       1||                     800||                       1||                     500|
|           2||                     Bow||                       2||                     500||                       2||                     300|
|           3||                  Scythe||                       6||                    1100||                       2||                    1000|
|           4||                     Axe||                       5||                     850||                       1||                     550|
|           5||                 TSwords||                       8||                    1600||                       2||                    1400|
|           6||                  Dagger||                       1||                     250||                       1||                     200|

0. Return to Previous Menu

Input: 1


Reign_Havoc bought Sword for 500


Reign_Havoc has 1500 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 4


|-Select Key-||----------Name----------||-Item Cost-||-Mana Cost-||---Damage---||-Required level-||-Attributes Effected-||-CoolDown Time-||------Type----|

|           1||             Snow_Cannon||          500||        250||         650||               2||             [Damage]||              0||     ice spell|
|           2||               Ice_Blade||          250||        100||         450||               1||             [Damage]||              0||     ice spell|
|           3||          Frost_Blizzard||          750||        350||         850||               5||             [Damage]||              0||     ice spell|
|           4||            Arctic_Storm||          700||        300||         800||               6||             [Damage]||              0||     ice spell|
|           5||           Flame_Tornado||          700||        300||         850||               4||            [Defence]||              0||    fire spell|
|           6||          Breath_of_Fire||          350||        100||         450||               1||            [Defence]||              0||    fire spell|
|           7||               Heat_Wave||          450||        150||         600||               2||            [Defence]||              0||    fire spell|
|           8||              Lava_Comet||          800||        550||        1000||               7||            [Defence]||              0||    fire spell|
|           9||              Hell_Storm||          600||        600||         950||               3||            [Defence]||              0||    fire spell|
|          10||        Lightning_Dagger||          400||        150||         500||               1||        [dodgeChance]||              0||lightning spell|
|          11||           Thunder_Blast||          750||        400||         950||               4||        [dodgeChance]||              0||lightning spell|
|          12||         Electric_Arrows||          550||        200||         650||               5||        [dodgeChance]||              0||lightning spell|
|          13||           Spark_Needles||          500||        200||         600||               2||        [dodgeChance]||              0||lightning spell|

0. Return to Previous Menu

Input: 1


Reign_Havoc bought Snow_Cannon for 500


Reign_Havoc has 1000 left in their bank. 

---Please select your choice---
1. Potions
2. Armours
3. Weapons
4. Spells
5. Sell Items
0. Return to Previous Menu
Input: 0

----Please select Hero to purchase products for----
|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||       750||        700||      700||                    7||        0|
|           2||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 0

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||       750||        700||      700||                    7||        0|
|           2||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
| P ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: i


----Please select Hero to open Inventory of----

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||       750||        700||      700||                    7||        0|
|           2||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 1


---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 2


|-Select Key-||----------Name----------||-----Required level-----||--------Quantity--------||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                   false||                     150|
|           2||         Full_Body_Armor||                       8||                       1||                    1100||                   false||                    1000|

0. Return to Previous Menu

Input: 2


---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 2


|-Select Key-||----------Name----------||-----Required level-----||--------Quantity--------||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                   false||                     150|
|           2||         Full_Body_Armor||                       8||                       1||                    1100||                   false||                    1000|

0. Return to Previous Menu

Input: 1


Sehanine_Moonbow equipped the item Platinum_Shield


Damage for the hero decreased by 200

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||       750||        700||      700||          3||      200|

---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 3


|-Select Key-||----------Name----------||-----Required level-----||---------Damage---------||-----Hands Required-----||--------Item Cost-------|

|           1||                   Sword||                       1||                     800||                       1||                     500|

0. Return to Previous Menu

Input: 1


Sehanine_Moonbow equipped the item Sword


Attack for the hero increased by 800

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||      1550||        700||      700||          3||      200|

---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 0


----Please select Hero to open Inventory of----

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||      1550||        700||      700||                    7||      200|
|           2||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||                    8||        0|
|           0||                                                                             Return to Previous menu|
Input: 2


---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 2


|-Select Key-||----------Name----------||-----Required level-----||--------Quantity--------||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                   false||                     150|
|           2||             Breastplate||                       3||                       1||                     600||                   false||                     350|

0. Return to Previous Menu

Input: 1


Reign_Havoc equipped the item Platinum_Shield


Damage for the hero decreased by 200

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||          4||      200|

---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 2


|-Select Key-||----------Name----------||-----Required level-----||--------Quantity--------||----Damage Reduction----||----Armour Equipped-----||--------Item Cost-------|

|           1||         Platinum_Shield||                       1||                       1||                     200||                    true||                     150|
|           2||             Breastplate||                       3||                       1||                     600||                   false||                     350|

0. Return to Previous Menu

Input: 2


Reign_Havoc equipped the item Breastplate


Damage for the hero decreased by 600

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||         Reign_Havoc||    2000||    1600||    1000||       800||        800||      800||          4||      800|

---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 3


|-Select Key-||----------Name----------||-----Required level-----||---------Damage---------||-----Hands Required-----||--------Item Cost-------|

|           1||                   Sword||                       1||                     800||                       1||                     500|

0. Return to Previous Menu

Input: 1


Reign_Havoc equipped the item Sword


Attack for the hero increased by 800

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||          4||      800|

---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 0


----Please select Hero to open Inventory of----

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||      1550||        700||      700||                    7||      200|
|           2||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||                    8||      800|
|           0||                                                                             Return to Previous menu|
Input: 0


-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
| P ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
| P ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: p

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||      1550||        700||      700||                    7||      200|
|           2||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||                    8||      800|
|           0||                                                                             Return to Previous menu|

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
| P ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: d


Beware! You were spotted by a monster


Battle Scenario

Heroes                   Hero Health                       Monsters                Monster Health                
Sehanine_Moonbow         1500                              TheWeatherbe            1600                          
Reign_Havoc              2000                              Alexstraszan            2000                          

Warrior, it is time for you to fight

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1500||    1400||     400||      1550||        700||      700||          3||      200|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        TheWeatherbe||                 1600||                  800||                    8||                   80||                  900|
|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           2||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


TheWeatherbe Dodged the attack and suffered no damage

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           2||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||          4||      800|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        TheWeatherbe||                 1600||                  800||                    8||                   80||                  900|
|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           2||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Reign_Havoc attacks TheWeatherbe and gives a damage of 800


Sehanine_Moonbow Dodged the attack and suffered no damage


Alexstraszan attacks Sehanine_Moonbow and gives a damage of 200

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1300||    1400||     400||      1550||        700||      700||          3||      200|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 5

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           0||        TheWeatherbe||                  800||                  800||                    8||                   80||                  900|
|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        TheWeatherbe||                  800||                  800||                    8||                   80||                  900|
|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           2||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


TheWeatherbe Dodged the attack and suffered no damage

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           2||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||          4||      800|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        TheWeatherbe||                  800||                  800||                    8||                   80||                  900|
|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           2||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Reign_Havoc attacks TheWeatherbe and gives a damage of 800


Sehanine_Moonbow Dodged the attack and suffered no damage


Reign_Havoc Dodged the attack and suffered no damage

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1300||    1400||     400||      1550||        700||      700||          3||      200|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 3


You need to purchase spells before using them in a battle


Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 1


---Please select item type---
1. Potions
2. Armours
3. Weapons
4. Purchased Spells
0. Return to Previous Menu

Input: 0


Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        Alexstraszan||                 2000||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Sehanine_Moonbow attacks Alexstraszan and gives a damage of 750

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           2||         Reign_Havoc||    2000||    1600||    1000||      1600||        800||      800||          4||      800|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 3


Please select a spell to use

|-Select Key-||----------Name----------||--------Item Cost-------||--------Mana Cost-------||---------Damage---------||-----Required level-----||---Attributes Effected--||-----CoolDown Time------||----------Type----------|
|           1||             Snow_Cannon||          500||        250||         650||               2||             [Damage]||              0||     ice spell|
0. Go back to previous menu
Input: 1


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        Alexstraszan||                 1250||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Reign_Havoc attacks Alexstraszan and gives a damage of 400


Sehanine_Moonbow Dodged the attack and suffered no damage

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           1||    Sehanine_Moonbow||    1300||    1400||     400||      1550||        700||      700||          3||      200|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 5

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           0||        Alexstraszan||                  850||                 1000||                   10||                   55||                  900|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        Alexstraszan||                  850||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Sehanine_Moonbow attacks Alexstraszan and gives a damage of 750

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||---Level---||-Defence-|
|           2||         Reign_Havoc||    2000||    1350||    1000||      1600||        800||      800||          4||      800|

Warrior! Choose your next move.
Remember your sisters words. They are more scared of you than you are of them
1. Open Inventory (Skips a turn if you use an item)
2. Attack
3. Use Spell
4. Know current hero stats
5. Know monster stats
6. Escape Battle

Input: 2


Please select a monster to attack

|-Select Key-||--------Name--------||-------Health--------||-------Damage--------||--------Level--------||----Dodge Chance-----||-------Defence-------|
|           1||        Alexstraszan||                  100||                 1000||                   10||                   55||                  900|

0. Cancel attack and make a different choice

Input: 1


Reign_Havoc attacks Alexstraszan and gives a damage of 800


Reign_Havoc Dodged the attack and suffered no damage


Congratulations great warrior. You won the battle!!

Sehanine_Moonbow has gained experience 18
Sehanine_Moonbow has evolved to 12 level 
Your heroes gained 9000 gold
Reign_Havoc has gained experience 18
Reign_Havoc has evolved to 13 level 
Your heroes gained 9000 gold

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
|   || P ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
|   || P ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: p

|-Select Key-||--------Name--------||-Health-||--Mana--||--Gold--||-Strength-||-Dexterity-||-Agility-||-Starting Experience-||-Defence-|
|           1||    Sehanine_Moonbow||    4800||    1400||    9400||      1550||        700||      700||                    7||      200|
|           2||         Reign_Havoc||    5200||    1350||   10000||      1600||        800||      800||                    8||      800|
|           0||                                                                             Return to Previous menu|

-------Map Terms-------
P: Player current location
White Background: Place yet to visit! Monsters lurk in the dark my friend
Red Background with X: Place unavailable
Green Background: Market
Blue Background: Healer
No Color: Normal space for movement

----------------------------------------
|   || P ||   ||   ||   ||   ||   ||   |
----------------------------------------
| X ||   ||   || X ||   || X ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   || X ||   ||   ||   ||   ||   |
----------------------------------------
|   || X ||   ||   ||   ||   ||   || X |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
|   ||   ||   ||   ||   ||   ||   ||   |
----------------------------------------
---- What is your next move warrior? ----
w: Move up
a: Move left
s: Move down
d: Move right
p: Print hero details
i: access Inventory
m: Access Market (Only works on green cells)
r: rest for sometime (Increases HP and Mana)
q: Quit Game
Input: q

Thank you for playing
Would love to hear your feedback, email me at amalakar@bu.edu

Process finished with exit code 200