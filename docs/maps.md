# maps

## map custom properties

properties found in custom map areas

- `colors`: comma separated list of colors (4 total) using the 0x555 notation, a semicolon is used whenever a map uses multiple values in the tilesheets section
  ex:
  - `0x000,0x200,0x410,0x541;0x000,0x200,0x410,0x541`
  - `0x000,0x200,0x400,0x511;0x000,0x200,0x410,0x541;0x000,0x200,0x410,0x541`
- `description`: a flash that appears like when you enter a dungeon / special area
  - `Level 9 - Archangel School`
  - `Memory #1\n#{font:bold}Archangels`
- `music`: sets the music to play when entering the map
  ex:
  - `town`
  - `cave`
  - `laboratory`
  - `boss`
  - `overworld_west`
  - `dark_theme`
  - `bank`
  - `church`
  - `glitch`
- `primaryBiome`: used for paige dialog / generation probably
  ex:
  - `house`
  - `laboratory`
  - `cave_normal`
  - `overworld_water`
  - `house_edges`
  - `dungeon_dungeon9`
  - `bank`
  - `church`
- `tilesheets`: comma separated list of all tilesheets for the engine to load (separate from the Tiled feature to reference external sheets) like `house,bedroom`
  known values:
  - `bank`
  - `house`
  - `bedroom`
  - `cave0`
  - `laboratory`
  - `bridge`
  - `dungeon2`
  - `dungeon9`
  - `church`
- `requiresItem`: used for grove generation, player must have this item in order for it to appear in the spawn pool (@TODO: TEST THIS)
  eg:
  - `SPRING`

## special object types

- `Scene`: usually the size of a screen (320x176)

  known custom properties:
  - `paletteKind`: for special effects (claymore cutscene)

    known values:
    - `GRAYISH`
    - `DEFAULT` (not used in-game / default)
    - `GRAY` (not used in-game)

  - `music`: see: (`Map:music` above)
  - `onSceneLoad`: calls a script function, usually found on objects named Scene in a layer named `Scenes` (this property can also be on Blocks as triggers)
    ex:
    - `scripts.DropLootScript("HEART")`
    - `scripts.minigame.StealthScene(0)`
    - `scripts.story.LibraryInteriorFront`
    - `scripts.story.PortalVoid`
    - `scripts.story.Dungeon9Room(8)`
    - `scripts.story.DungeonExterior(3)`
    - `scripts.story.BankInterior`
    - `scripts.story.PalaceBossRoom`
    - `scripts.story.PalaceSkeletonMonarchRoom("scene:*-palace:F0N")`
    - `scripts.story.PalaceTowerRoom`
    - `scripts.story.PalaceWinRoom`
    - `scripts.story.SchoolInterior`
    - `scripts.story.PalaceSouthWall`
    - `scripts.GlitchWarp("scene:*-palace:safeRoom")` the spiral warps in the palace (suggests onSceneLoad only works if the player is initialized in this location)
  - `tags`: presumably comma separated list of special tags for rooms
    - `elderCave`
    - `librarySecretRoom`
    - `libraryBackRoom`
    - `library`
    - `bridge`
    - `sceneSpacing`
    - `shadowTemple`
- `Guide`: identical to Scene, only used in Maxwell's Lab (@TODO: find out more)
- `label`: usually just for the map developer to know what is happening

  known special names:
  - `exit`: will transition the player out of the submap / map stack (@TODO: find out more about this) usually 2 tiles big on the bottom of screens
  - `teleport`: usually on the front of objects/structures
  - `nospread`: unknown, the mat rupert sits on, maybe at one point prevents fire spread?
  - `redirect`: only used in front of the Devs house
  - `blacksmithyRedirect`: unknown?
  - `sign`: the sign in front of the library
  - `sewer`: the water warp to the palace toilet
  - `schoolTeleport`: the school's teleport
- `Reachable`: presumably it is some constraint on the generator for placing objects (like their entrance location)

- `POI`: makes the world map show an indicator for this object (@TODO: maybe you have to touch it to trigger the warp?)
- `Redirect`: a warp in/out to different zones
  
  known special names:
  - `default`: where the player will be placed when they enter the area (presumably from some sort of entrance), has no width or height (would be a "point" object if they existed when development started)
  - `win`: you win the game?
  - `gameStart`: you are here
  - `entry0`/`entry1`: used when a map has multiple "versions" (status effect store) or when there are multiple places on a sub-map
  
  known properties:
  - `sceneOnly`: a boolean, usually used if it's setting the camera's top-left position for a cutscene (or the main menu) basically means no player
- `Block`:  a region, usually against something the player can't enter (lower half of a bookcase) that is interactable

  known custom properties:
  - `onEnemiesDefeated`: a script function to execute when all enemies on screen (including ones spawned from destructible items) are killed

    eg:
    - `scripts.RandomLootFallScript("grove")`
    - `scripts.RandomLootFallScript("groveChain")`
  - `onSceneLoad`: for when the screen/scene this region is in is loaded (see: `Scene:onSceneLoad`)
    - `scripts.story.ElderCaveExterior`
    - `scripts.story.LaboratoryGates`
    - `scripts.story.LaboratoryExteriorEntry`
    - `scripts.story.LibraryGates`
    - `scripts.story.PalaceExterior`
    - `scripts.story.SchoolExterior`
  - `glitchedGraphic`: whether or not the block appears glitched, usually `true` if present
  - `glitched`: whether or not the object is glitched (requires MISSINGLASSES), usually `true` if present
  - `onPlayerInteract`: a script function to execute when the action button is pressed while the player is in contact with it
    ex:
    - `scripts.DialogScript("A row of bookcases dedicated to hammers.")`
    - `scripts.BookcaseOfStolenBooks`
    - `scripts.story.LibraryCatalog`
    - `scripts.story.SelfView`
    - `scripts.SoundTest`
    - `scripts.minigame.SlotMachine`
    - `scripts.minigame.InvestorAccountant`
    - `scripts.CheatMenu`
    - `scripts.story.ShadowTemplePowerSlot`
    - `scripts.TunicStore`
    - `scripts.PotionStore`
    - `scripts.TunicCrafting`
    - `scripts.npcs.PrinceCell`
    - `scripts.npcs.Rupert`
    - `scripts.story.SchoolDesk(0)` argument is boss index, left-right, top-bottom
  - `onPlayerPush`: a script function to execute when walked against by the player
    ex:
    - `scripts.TeleportScript("scene:*-laboratory:basement")`
    - `scripts.story.SchoolExitTeleport`
    - `scripts.TMXGenerateTeleportScript("map:*-palace-tower", "/tmx/maps/palace-tower.json", "scene:*-palace-tower:F1S")`
  - `onPlayerTouch`: similar to `onPlayerPush` but less sensitive
    ex:
    - `scripts.TeleportScript("scene:*-dungeon3:default")`
    - `scripts.story.CryptCutscene`
  - `altTilesheet`: it switches to the tilesheet of the corresponding index in the map's `tilesheets` property, presumably only for that region (@TODO: possibly only when the player is inside?)
    - sometimes found on a bunch of trees in a region named `grass`?
  - `onLoot`: a script function to run when:
    - grass is cut
    - a box is lifted
    - a pushable block is pushed

    ex:
    - `scripts.story.LaboratoryGateSwitch`
    - `scripts.RandomLootOnceScript("library-secret")`
    - `scripts.ResetBlockScript(4, 0, 0, "QUEST")`
    - `scripts.GraveRobScript("grave")`
    - `scripts.RandomLootScript("groveMinorPrize")`
    - `scripts.RandomLootScript("groveChainTest")`
- `Pickup`: will award the player an item equal to whatever the object is named

  ex:
  - `WRAPPED_PARCEL`

  known properties:
  - `fallFromSky`: overrides whether or not an item falls from the sky when it appears on a screen

- `NPC`: an NPC that exists!
  known custom properties:
  - `tags`: see `Block` tags
    ex:
    - `scythe`
    - `pizza`
    - `fire`
  - `script`: calls a script to create/setup the NPC (@TODO: more about the type/interface)
    ex:
    - `scripts.npcs.MaxwellNPC("trapped")` argument sets his script, for putting him in several spots
    - `scripts.npcs.BridgeChairman(0)` argument 0 through 1 to set his behavior
    - `scripts.npcs.SiblingPotter(false)` false = has not found Tressa
    - `scripts.npcs.SiblingTunley(true)` true = has found Tressa
    - `scripts.npcs.SiblingTressa(true)` true = has found Tressa
    - `scripts.npcs.BridgeDelvin`
    - `scripts.npcs.RupertsWife`
    - `scripts.npcs.BearNPC`
    - `scripts.story.Hammy`
    - `scripts.misc.Permafire`
    - `scripts.npcs.ArtistNPC`
    - `scripts.npcs.DevNPC`
    - `scripts.npcs.ShopKeeper`
    - `scripts.npcs.Trader(0)`
    - `scripts.npcs.Woodcutter`
    - `scripts.npcs.EscapingChairman(1)`
    - `scripts.npcs.TravellingMerchant(3)` (0-3) traveling merchant steps
    - `scripts.minigame.BattleArenaNPC`
    - `scripts.minigame.InvestorAssistant`
    - `scripts.minigame.InvestorAccountantNPC`
    - `scripts.npcs.BankOfficeChairman`
    - `scripts.npcs.LibrarianNPC()`
    - `scripts.npcs.EscapingChairman(0)`
    - `scripts.npcs.TressaAccountant`
    - `scripts.npcs.DeadGuard`
    - `scripts.npcs.PrinceNPC("cell")`
    - `scripts.misc.Bloodstain`
    - `scripts.npcs.CryptLance`
    - ``
    - `scripts.npcs.SkeletonMonarchNPC("allen")` named Alice
    - `scripts.npcs.SkeletonMonarchNPC("edgar")` named Aiden
    - `scripts.npcs.Trader(3)`
    - `scripts.story.SchoolKid(4)`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/elder","$sheetRow=2", "$renderOrder=-1", "$tags=elder", "It's the elder!", "He's not breathing...")`
    - `scripts.npcs.TalkingNPC("$sheetName=items/scythe", "$dialogue=/dialogue/lenna.json", "%descriptions/school:scythe")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/lance","$sheetRow=0", "$tags=lance", "$animateRegardless=false", "$direction=N", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/elder","$sheetRow=0", "$animateRegardless=true", "$tags=elder", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/scythe","$sheetRow=0", "$tags=scythe", "$animateRegardless=true", "$directional=false", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/lance","$sheetRow=0", "$tags=lance", "$animateRegardless=false", "$direction=W", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/lance","$sheetRow=0", "$tags=lance", "$animateRegardless=false", "$direction=N", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/archangellenna","$sheetRow=20", "$tags=aalenna", "$animateRegardless=true", "$directional=false", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=boss/azraflail/body","$sheetRow=2", "$tags=azraflail", "$animateRegardless=true", "$directional=false", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=boss/azraflail/mace","$sheetRow=0", "$tags=mace", "$animateRegardless=false", "$directional=false", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/investor","$direction=N","%encounters/guildbank:bankerEvilJar2")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/investor","$direction=S","%encounters/guildbank:bankerEvilJar1")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/eviljar","$animateRegardless=true", "%descriptions/guildbank:eviljar")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/investor","$direction=S","%encounters/guildbank:bankerGroundFloor4")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/archangellenna","$sheetRow=1", "$tags=aalenna", "$animateRegardless=true", "$direction=S", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=boss/tentaluchus/tentaluchus","$sheetRow=14", "$tags=tentaluchus","$animateRegardless=true","")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/humandelvin","$sheetRow=0", "$tags=delvin", "$animateRegardless=false", "$direction=W", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=npcs/fridge","$sheetRow=0", "$tags=8fridge", "$animateRegardless=false", "$direction=S", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=pet-chicken","$sheetRow=0", "$tags=chicken", "$animateRegardless=true", "$direction=W", "")`
    - `scripts.npcs.TalkingNPC("$sheetName=items/items","$sheetRow=42")`
    - ``
- `DungeonMonster`: an enemy, will be replaced with an actual enemy with the ID of what this region is named

  known properties:
  - `initialState`: unknown, only found on one SHARKTULA in the palace with a value of -5 (presumably swimming) (@TODO: find out more)

  ex:
  - `SMILEDER`
  - `CRAB_KNIGHT`
  - `SHARKTULA`
  - `SKELETON`
  - `SKELETON_MONARCH`
  - `SKELETON_SPIDER`
  - `SKELETON_WIZARD`
  - `SHIELDED_CRAB_KNIGHT`
  - `SKELETON_BAT`
  - `SKELETON_WARRIOR`
  - `SNAIL`
  - `GREEN_SLIME`
  - `GREEN_WIZARD`
  - `WALLHUGGER`
  - `BOMB_SNAIL`
- `Pet`: a companion/follower, will be replaced with a companion matching the ID of what this region is named
  ex:
  - `CHICKEN`
  - `BAT`
  - `PUMPKIN`
  - `LIBRARIAN`

## special image properties

- `blendMode`: changes the way that images are drawn in the map, probably has other color math constants like darken/brighten/etc
  - ex: `multiply`
- `topRows`: how tall the object is visibly (prevents walking behind it/causes collision)
- `drawOverNeighborScenes`: a boolean, controls whether or not it draws over neighboring maps (@TODO: test this)

## known script functions

- `scripts.minigame.StealthScene(int sceneIndex)`: sceneIndex is an int from 0 to 2, causes goldilocks to do her thing
- `scripts.DialogScript("A row of bookcases dedicated to hammers.")`
- `scripts.story.Hammy`
- `scripts.misc.Permafire`
- `scripts.npcs.TalkingNPC("$sheetName=npcs/elder","$sheetRow=2", "$renderOrder=-1", "$tags=elder", "It's the elder!", "He's not breathing...")`: bazinga
- `scripts.TeleportScript("scene:*-laboratory:basement")`: argument is a scene-code
  - `scene:`: specifies the scene name
  - `*-laboratory`: globbed scene name
  - `:basement`: jump to the Redirect named "basement"
- `scripts.RandomLootOnceScript("library-secret")`: argument is the name of a pool defined in `items/loot/droppools.json`
