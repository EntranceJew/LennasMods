# README

hey it's me i'm a cool file

## topics to cover

- packaging mods
- simple graphics mods (controller button display changes)
- advanced graphics mods (sprites.json, json patches)
- generator mods?
- text formatting

  eg:
  - `Memory #1\n#{font:bold}Archangels`
  - `${world.name} Palace`
- NPCs (`scripts.npcs.TalkingNPC`)
  - adding phone contacts
  - adding them to maps
  - `dialogue/*` format
  - `scripts.DialogRefScript("descriptions/palace:stainedglass/0")`

- blocks
  - if they have a + in their name it means it's just a frame of an animated block (`blocks.json`)
  - `/tiles/*.json` define tile banks (@TODO: more on these formats) and variant images
  - frame index corresponds to position from top left in variant image

- replacing `title-overworld.gamemap`
  - make a save
  - rename most recent `.dat` to `.zip`
  - find `WORLD.map.title_screen-overworld-west` and copy and paste it in place of that file
