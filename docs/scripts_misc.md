# Scripts (Misc Info)

## Finding Scripts You Can Call

Most game scripts you can call via the phone must be self-invokable, e.g. must not require calling a function directly (unlike some onPlayerInteract triggers) due to the class being instantitated by the game; therefore the ideal callable script is:

* extends net.bytten.inceptus.scripting.AdvancedScript
  * in squre brackets:
    * [net.bytten.inceptus.model.block.Block]
  * **NOT** in square brackets:
    * [net.bytten.inceptus.model.GameObject] (@TODO: **sometimes** works, why it be this way?)
    * [net.bytten.inceptus.model.mob.NPCMob]
    * [net.bytten.inceptus.model.mob.Mob]
* has a `run()` function override

## Known Scripts You Can Call

* `scripts.minigame.SlotMachine`
* `scripts.SoundTest`
* `scripts.phone.*`
* `scripts.minigame.InvestorAccountant`
* `scripts.minigame.BattleArenaCave` works but does nothing
* `scripts.minigame.StealthScene` works but does nothing

* `scripts.story.BankInterior`
* `scripts.story.PortalVoid`
* `scripts.story.ShadowTemplePowerSlot`
* `scripts.story.CryptCutscene`
* `scripts.PortableHoleScript` makes a hole but has no way to set the coordinates
* `scripts.PotionStore`
* `scripts.TestScript`
* `scripts.TownNPCGeneratorScript`
* `scripts.TunicCrafting`
* `scripts.TunicStore`