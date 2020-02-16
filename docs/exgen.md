# exgen

Stuff that concerns these code files:

* `net.bytten.inceptus.generator.AbstractGameGenerator` and all children

## syntax

Are usually in the format of `key=value` but occasionally they can begin with a `#` which acts as a comment, essentially meaning that you're assigning a key that is never read or used. For certain keys marked as type `(has)` -- their mere existence will be taken to mean to do something, similar to a `(bool)` type with its value set to `1`.

## found keys

* `archangelMurders` (int)

  how many bosses were defeated through violence
* `boss` (str)

  will make the bossId specified the boss of the dungeon (presumably only used on single-dungeon mode)
* `cavernous` (bool) ???
* `completeQuest` (str) `/data/quests.json`
* `disableHeartContainers` (bool)
* `dequip` (str)

  removes the item by this name from your posession (usually used to remove PLANK or other startWithItems)
* `dungeonsMapped` (int)
* `equip` (str)

  give the player an item of this name
* `equipInf` (str)

  give item of this name, with infinte ammo
* `giveAllBooks` (has)
* `giveAllPotions` (has)
* `giveAllQuests` (has)
* `giveAllTokens` (has)
* `giveAllTunics` (has)
* `id` (str)

  used internally for AbstractGameGenerator?
* `initialHas` (str)

  seems to work like `equip=` but different? maybe an array? comma separated. might define equipment the player starts with for the dungeon generation purposes.
* `knowAllPotions` (has)
* `knowAllTunics` (has)
* `level` (int)

  the level for the boss progression
* `levels` (int)

  how many dungeons to create
* `overworldDemo` (bool)

  when getLevelExit is run it will provide `scene:demo-overworld:dungeon-exit` instead
  does not seem to actually be used, crashes the game if used
* `pet` (str) (see: `net.bytten.inceptus.player.Pet.Kind`)
* `planner-config` (str)

  the json file to use for planning, for example: `/generation/*towerplanning.json`
* `rooms` (has)

  if present, BlankGameGenerator will randomly generate a room
* `seed` (long)

  the actual seed integer used for the procgen, usually derived from `worldName` but sometimes differs
* `setFlag` (str) (@TODO: determine valid flags)

  known flag names:
  * `beatChairman`
  * `beatDelvin`
  * `chairmanSpared`
  * `delvinSpared`
  * `lanceSaved`
  * `elderSaved`
* `singleDungeon` (bool)
* `skip-boss` (str)

  the bossId to skip when populating boss pools
* `slow` (str)

  makes map generation slow?
* `startCoins` (int)
* `startHeartContainers` (int)
* `startPos` (vec)
* `startQuest` (str) `/data/quests.json`
* `startRandomPet` (double)
  
  a random chance at getting a pet, 0 = no chance, 1 = guaranteed
* `startRandomPotions` (int)

  the quantity of potions to give the player from the random pool at the beginning
* `startRandomTunics` (int)

  the quantity of tunics to give the player from the random pool at the beginning
* `startSceneId` (str)

  where the player will begin the game from in the world, follows the scene reference format (@TODO: link to there from here)
* `unlockMultiplayer` (has)
* `worldName` (str)

  the name to use for the world
  