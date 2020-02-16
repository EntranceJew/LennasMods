# Keyboard Events

code cited from `net.bytten.inceptus.frontend.LegendApplet`

* F12 (`123`)
  
  takes a screenshot that appears in `$userDirectory/screenshots/user/`
  * +SHIFT

    takes an atlas screenshot (the entire map of the current area)
    if hitboxes are on, it will show node graph of dungeon
    appears in `$userDirectory/screenshots/atlas/`
  * +CTRL

    begins recording a gif that will appear inside `$userDirectory/screenshots/recording/`
    records at the engine tick rate [default: `45.0D`] at a resolution of `320x192`
  * +ALT

    identical to not pressing the button, but has a code path defined anyway

* F (`70`)

  if a modifier `& 2 == 0`  is pressed, prevents further key handling

* F11 (`122`)
  toggles fullscreen on/off

* F10 (`121`)
  [requires devMode]
  toggles tile grid on/off
  will misalign at irregular screen resolutions

* F9 (`120`)
  [requires devMode]
  toggles action areas (hurtboxes + interactive spots) on/off
  aren't strictly square or points, sometimes polygons
  [see: `actions.json`]

* F8 (`119`)
  will reload all assets, potentially live reloading sprites / data
  if you hold this down it will lag your game a lot

* F7 (`118`)
  [requires devMode]
  toggles hitboxes on/off

* F6 (`117`)
  toggles shader on/off

* F5 (`116`)
  toggles FPS display on/off
  also disables extra TPS / map info in the title bar if devMode is on

* F4 (`115`)
  toggle HUD visibility

* F3 (`114`)
  by default is bound to be the `DEBUG` key, pressing it in certain circumstances does something:

  * if pressed while generating and `generationVisuals` are enabled then it will toggle making them bigger and easier to see
  * [requires engine.isCheatsEnabled()] if pressed while the game is loading, will load the TestLayer UI which will show a blank screen with a palette on it. pressing the confirm key on this screen then invokes a menu UI test that asks you for `new game / continue / quit` and has a dialog response for each choice but does nothing.
    * while on this screen, pressing it again will walk through some test dialog / fonts
  * [requires engine.isCheatsEnabled()] if pressed while in the game world, it will re-run the world gen utilities:
    * `BushToTreeAutotiler`
    * `BigRockAutotiler`
    * `VerticalFenceAutotiler`

* F2 (`113`)
  by default is bound to be the `CHEAT` key, pressing it in certain circumstances does something:

  * if pressed while screen transitioning, it will warp you to the edge of the screen you're warping from, similar to using the `MISSINGLASSES`
  * if pressed while the `STRAFE` key is held, causes an effect similar to the first time you visit the `Elder's Cave`
  * if pressed with no other keys active, will cause the game to run `scripts.TestScript` which contains some spoilery character portraits
  * if pressed while on the main menu `About` screen, will do a staff credits roll

* F1 (`112`)
  by default is bound to be the `HELP` key, but it is never referenced anywhere, not even by accident
