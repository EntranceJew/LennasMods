# Launch Args

## executable options

These are options that can only be used when launching the executable:

* `-newgame`
* `-credits`
* `-noexit`
* `-gamepad-controls1`
* `-gamepad-controls2`
* `-keyboard-controls`

These can be used when you launch the game, but they can be passed down into when you start a new game. They can also be used in `challenges.json`'s `options` array:

* `-permadeath`
* `-file <arg>`
* `-gen <arg>`
* `-exgen <arg>`
* `-show-timer`
* `-heart-containers`
* `-no-heart-containers`
* `-glitch`
* `-targettps <arg>`
* `-record-timelapse`
* `-challenge <arg>`
* `-scorefile <arg>`
* `-daily <arg>`
* `-no-retry`
* `-expo`

## launch-config.json

If the launch option starts with a `-D` then it will be interpreted as a JSON pointer missing the leading slash, e.g. `-Dtest/path=value` would be `/test/path` being assigned `value`.

If the path section of the pointer ends with `+` like in `-Dtest/path+=item` it will be interpreted as `-Dtest/path/-=item`

### documented values

* `autoScreenshotRate` (int) [default: 600]
  
  in seconds, will be multiplied by 1000.0 to get a millisecond amount

### undocumented values

* `logging` contains a hash set of keys, presumably used to check log levels. found wherever `Logging.log` is called.
  known values are:
  * `BiomeRegistry`
  * `ImageLoader`
  * `ItemRegistry`
  * `MusicLoader`
  * `PhoneContactRegistry`
  * `Sandbox`
  * `ScriptLoader`
  * `SpawnerRegistry`
* `traceOpenGL` (bool)
* `debugOpenGL` (bool)
* `openGLProfileOverride` (string)
* `targetTPS` (double) [default: `45.0D`]

  this is overridden by `GameEngine.optTargetTPS`
* `targetFPS` (double) [default: `60.0D`]
* `siteBase` (string)
* `useGLFW` (bool)

## config.json

located in `launch-config.json`'s `userDirectory` path, consumed by `net.bytten.inceptus.frontend.FrontendConfig`

* `cameraMoveOnLook` (bool)
* `fullscreen` (bool) [default: false]
* `scores` (object)
  * `upload` (bool) [default: true]
* `volume` (object)
  * `music` (float) [default: `0.5F`]
  * `sound` (float) [default: `0.5F`]
* `cameraMoveSpeed` (float) [default: `0.25F`]
* `cameraMoveAmount` (float) [default: `0.2F`]
* `showWorldGen` (bool) [default: false]
* `safetyWarning` (bool) [default: true]
* `cameraMove` (bool) [default: true]
* `cameraMoveOnLook` (bool) [default: false]
* `cameraMoveSmart` (bool) [default: true]
* `screenshake` (bool) [default: true]
* `glitchEffects` (bool) [default: true]
* `flickerEffects` (bool) [default: true]
* `advanceGraphics` (bool) [default: true]
* `shaderEnabled` (bool) [default: true]
* `storyModeTimer` (bool) [default: true]
* `input` (object)
  * `keyboard` (object)

    children are in the form of `"KEYNAME": intKeyCode,` for standard keyboard/SDL keycode values, `KEYNAME` originate from `net.bytten.inceptus.util.Key` enum
* `version` (int) [default: 1]

  (@TODO: usage unknown?)
* `controllerPlayers` (object)

  used for multiplayer controller assignments, 0 = player 1, 1 = player 2
  (@TODO: find out more about this, never seemingly written to disk)
  * `keyboard` (int) [default: 0]
  * `controller4` (int) [default: 0]
  * `controller3` (int) [default: 0]
  * `controller2` (int) [default: 0]
  * `controller1` (int) [default: 0]
