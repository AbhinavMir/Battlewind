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

All heroes are an extended subclass of the `Character` class.


14.	Antagonists Interface
a.	Here is where the factory design pattern starts
b.	Antagonists interface defines the interface for any villain of any game
c.	Takes their basic information and provides it to the game
15.	Protagonists Interface
a.	Here is where the factory design pattern starts
b.	Protagonists interface defines the interface for any hero of any game
c.	Takes their basic information and provides it to the game

16.	Usable Interface
a.	Here is where the factory design pattern starts
b.	Usable interface defines the interface for any usable item of any game
c.	Takes their basic information and provides it to the game

17.	LorHeroes class
a.	The heroes implementation
b.	It extends the piece class and holds information for the pieces
c.	It is also the main store in the object mapper factory pattern for monsters and hence implements Protagonists

18.	LorMonsters class
a.	The monsters implementation
b.	It extends the piece class and holds information for the pieces
c.	It is also the main store in the object mapper factory pattern for monsters and hence implements Antagonists

19.	LorItems class
a.	The potions/weapons/armours implementation
b.	It extends the piece class and holds information for the pieces
c.	It is also the main store in the object mapper factory pattern for monsters and hence implements Usable

20.	LorSpells abstract class
a.	The spells implementation
b.	It extends the piece class and holds information for the pieces
c.	It is also the main store in the object mapper factory pattern for spells


21.	Game abstract Class
a.	The actual game abstract class
b.	This class just holds the skeleton of any game
c.	It includes basic information of the game such as type, rules and maximum number of players
d.	THis class is extended by our play class for our current purpose
22.	Intro Class
a.	Class generating the intro
23.	Inventory Class
a.	The main inventory of the game
b.	Here all the purchased goods of heroes are stored apart from spells (Cuz spells don't go in the bag :p)




24.	Learning Models Class
a.	A special class unique to this game
b.	This class allows changing of properties mid game
c.	The game checks and learns what are the current stats of heroes to make the game less or more difficult
d.	by building a story line around it.
e.	Such as, if the heroes are too waeak, the game sets chances of battle to a lower value
f.	allowing the heroes to take rest or go to a healer
25.	Market Class
a.	Main market class
b.	This class decides the market, randomizes which market shows up
c.	It allows sale and purchase of products
d.	The functions of the class are self explanatory
26.	Piece abstract class
a.	Main piece class
b.	THis class is something which is implemented by all our checkers in the game
27.	Game Map class
a.	Game Map class is the actual class which generates a map at the start of the game
b.	The class is tasked with only the above function but has some work it has to do
c.	It has to generate cells for markets, healers, blocked cells and normal cells in the ration of 2:2:1:5
d.	These locations are randomly assigned one after the other so as to not overlap
e.	A hashcode is generated for the coordinates to make sure that these locations generated do not overlap
f.	When a player will step on a cell the coordinates for the cell stepped on will be hashed and sent here to get the exact cell
g.	Once we have the cell we will get its properties from the map cell class
h.	I have used hash map to make sure that constant time lookup is possible as we do not want the process to slow down
i.	Please note that even though a hashmap is being used, you can assume it to be like a 2D matrix of size x*y as each (x,y) is hashed to form the lookup
28.	Location Properties class
a.	This class is used to give location properties as the enum which describes all available locations
b.	Please note that to make my game Interesting I have made a healer location
c.	A team member can only be healed at this location or else by using potions
d.	The hashmap used in this class is again just for constant lookup while creating a location cell




29.	LorMapCell class
a.	The following class extends abstract Map cell, implements the set properties function
b.	This class will also give the map cell specific properties which are only related to this game
c.	Such as we shall be checking if a cell has been visited, if it is then fog of movement will be lifted (Check Readme to know what fog of movement is)
d.	Further, if a market or blocked cell is present here then the properties of location will be written as required
30.	Map Cell Abstract Class
a.	Abstract Class MapCell is a class that can further be used for any game
b.	It defines a cell for a specific map based on longitude (x) and latitude (y) properties
c.	All games across the world breakdown maps to two intrinsic properties longitude and latitude
d.	Further implementation of this abstract class can be used to add other properties.

Singleton Classes
31.	ClearScreen class
a.	Singleton design pattern class which allows clearning of the console
32.	Colors class
a.	Class with static variables to give some color to the game
33.	GenerateHash class
a.	The following class is a singleton factory type design pattern class. It has only one static function
b.	The use of this function is to generate a hashcode for coordinates
c.	We use this hashcode to find properties of the cell which a player might enter into
d.	More information on the same can be found in the Game Map class
34.	HashHelpers Class
a.	This class is a helper class
b.	It helps in finding keys for values which are being used in hash maps
c.	The requirement is only in specific cases where a value without key pair could exist
35.	PrintStatements Class
a.	Singleton class to print statements such as narrations and warnings
b.	This class also prints the battle format
36.	TakeInput Class
a.	Singeton design pattern to use to take inputs
b.	please note that here we also validate inputs to make sure correct things are entered
37.	Waitfortime class
a.	Singleton design pattern to use for waiting during iterations
38.	Coordinate Class
a.	Class containing coordinates of cells
b.	This class is also used to hold the current coordinate of the player

39.	Move Class
a.	A class to make moves
b.	It chooses a piece and sets its new x and y values based on the hashes
40.	Movement Class
a.	A class containing information on how to make moves
b.	Also contains information on what hashes are stored and what hash to make next
c.	Please note that this is of the form of a node with information of the next coordinate and the previous coordinate
d.	It is implementation of a linked list
41.	Map Objects Factory Class
a.	The most important design patter being used by the game
b.	The skeleton is built on this classes functionality
c.	This uses factory design pattern to build the game

d.	There are 3 main interfaces
e.	Protagonists (Heroes) ---> LorHeroes (Implementation of protagonists for this specific game) ---> Paladins/Sorcerers/Warriors Mapper (Extension of Heroes)
f.	Antagonists (Monsters/Villains) ---> LorMonsters (Implementation of antagonists for this specific game) ---> Dragons/Spirits/Skeletons (Extention of Monsters)
g.	Usable --> LorItems & LorSpells (Implementation of usable in this game) ---> Potions, Weapons, Armours, Fire/ice/lightning spells (Extension)

h.	All the above 3 are built in this factory of object mapper depending on the choice given in the method

Menu Classes
42.	Battle Menu Class
a.	This class just builds a menu for the player during the battle
43.	Game Difficulty Menu Class
a.	This class sets the difficulty of the game
b.	It sets the map size as well as goes on to decide the percentage of blocks
44.	Hero Selection Menu Class
a.	Hero selection menu is a special implementation of menu
b.	This allows selection of heroes for the game
c.	Gives a choice of the total number of players to use
d.	Further allows choosing heroes and updates the same which is an intrinsic property of the Player class
45.	Inventory Menu Class
a.	The inventory menu has a few more functionalities other than just showing the menu
b.	The class also displays a players inventory and allows basic selections of the items.
c.	Seperate functions are used to achieve the above which are intrinsic properties of the Player

46.	Limit Length Printer Singleton Class
a.	This is a helper class
b.	The class helps in formatting string according to requirements for better display
47.	Menu Interface
a.	Menu is an interface with just one function showMenu
b.	Further this is implemented by different types of Menus
48.	Next Choice Menu
a.	This is a class implementing menu for next choices to be displayed
49.	LorPlayer Class
a.	This class extends the Player class and builds the actual player for the game
b.	The player is the main collection of heroes hence holds an object of type LorHeroes
c.	Further the player has a coordinate location and a boolean putting them in battle
50.	Player Class
a.	Actual player class
b.	This class is for a basic player which takes their basic details such as name and stores a state and game score for them
c.	For this game we shall only be extending this class and not using it completely
51.	Bank Class
a.	Main bank class
52.	LorBank Class
a.	Bank for holding the player amounts


At all points game is handled via while loops to start games and return back in case of replay. Validations are made to check all inputs and in case of illegal inputs
validator breaks the game and exits. Only in case of out of bound inputs players are given a chance to re-enter values as they are generic errors which do not break process.

## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>

2. <Bonus Done>

	- Learning System for deciding when to give enemies 
	- probability of fighting an enemy reduces based on health of players
	- healers added to the game to heal players
	- rest power added to regenrate health
	- design patterns implmented
	- Story added to the game
	- Learning system for health and fighting
	- learning system for dodging, using the same capability makes dodging easier (such as spells and without weapon attacks)
	- Map size can be changed by requirement


Health of Hero is based on Different parameters

1. If Hero is of lower level (level < 10)
Health = Strength + Level * 500
2. If Hero is of level between 10 and 20
Health = Strength + Level * 400
3. If Hero is of level between 20 and 30
Health = Strength + Level * 350
4. If Hero is of level more than 30
Health = Strength + Level * 300

Mana of Hero is based on their Dexterity

Mana = Dexterity * 2

Sorcerers have higher mana to use more spells than other types

Chance of getting a battle

Chance of getting a battle changes through the game based on the heroes health and the number of battles they fight

1. If they have fought many battles then the chance of getting a battle reduces by 0.1 for every battle
2. Once battle stat reaches 0.2 it resets to original of 0.7 (70% chance of a battle)
3. If the heroes are too weak (Total health less than 70%) then the chance of a battle is 0.5 (50%)
4. If heroes get weaker where their total health goes below 50% chance of battle reduces further to 0.3
5. If the heroes are very weak which is their health is less than 10% of their total health then chance of battle reduces to 0 until they get their health regenerated

Dodge chance

Chance of dodge is dependent on the capabilities of the fighter

Chance of dodge = (attack power - dodge capability/agility)/(attack power + dodge capability/agility)

If the chance of dodging is too high then the player is given a warning asking them to use a weapon or potion to increase their stats as the enemy would be doging most of their attacks
and chance of dodge is set to a 50% chance 
Spells cannot be dodged 

Player can put on more than one armour and the defence increases by the total
Player can equip/dequip weapons and armours based on their level and available hands

Player can use potions, equip items, dequip items etc at any point of time even between battles 

More number of heroes more number of monsters with better stats causing more stronger battles. hence choose lesser players to have an easy game :p

While building the map first markets are placed at random spaces followed by healers followed by blocked regions and then the rest of the normal regions

Please note that with this process and choice of statistics it will never happen that the player will be blocked to move as the numbers and pipeline of building cells is made in such a way
In the worst case (This will never arise the player cannot move and the map is unplayable they can click on restart to regenerate a new map). 


3. <Notes to grader>
    - Game shows information for playing in the terminal, same has been included in the Game Example Section
    - Please note that pauses in the game are not an efficiency problem but deliberately added to create an effect for the UI
        - Clearing screen has an added pause of a few seconds
        - Text displaying has an added pause to give a better look and feel
    - Chance of stat document includes all the functions used for data.

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