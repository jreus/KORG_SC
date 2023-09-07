/*
MIDI Control Class for the Korg NanoKontrol 2


USAGE:
l = NanoKontrol2.new
l.trace(true);
l.trace(false);
// set up all your widget callbacks like this...
l.setcb(0, "fader", {|val, spec| "I Got % on fader %".format(val, spec["name"]).postln });

TODO: implement gui and multi-bank control - see LPD8 implementation for an example

Example NanoKontrol2 keymap spec

---
# nanoKONTROL2 Korg
name: default
keymap:
  tracks: [
    {
        name: 	"track1",
        knob: 	{name: "k1", type: "control", num: 16, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f1", type: "control", num: 0, min: 0, max: 127, behavior: "continuous"},
        solo:	  {name: "s1", type: "control", num: 32, min: 0, max: 127, behavior: "button"},
        mute:	  {name: "m1", type: "control", num: 48, min: 0, max: 127, behavior: "button"},
        rec:	 {name: "r1", type: "control", num: 64, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track2",
        knob: 	{name: "k2", type: "control", num: 17, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f2", type: "control", num: 1, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s2", type: "control", num: 33, min: 0, max: 127, behavior: "button"},
        mute:	  {name: "m2", type: "control", num: 49, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r2", type: "control", num: 65, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track3",
        knob: 	{name: "k3", type: "control", num: 18, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f3", type: "control", num: 2, min: 0, max: 127, behavior: "continuous"},
        solo:	  {name: "s3", type: "control", num: 34, min: 0, max: 127, behavior: "button"},
        mute:	  {name: "m3", type: "control", num: 50, min: 0, max: 127, behavior: "button"},
        rec:		{name: "r3", type: "control", num: 66, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track4",
        knob: 	{name: "k4", type: "control", num: 19, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f4", type: "control", num: 3, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s4", type: "control", num: 35, min: 0, max: 127, behavior: "button"},
        mute:   {name: "m4", type: "control", num: 51, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r4", type: "control", num: 67, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track5",
        knob: 	{name: "k5", type: "control", num: 20, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f5", type: "control", num: 4, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s5", type: "control", num: 36, min: 0, max: 127, behavior: "button"},
        mute:   {name: "m5", type: "control", num: 52, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r5", type: "control", num: 68, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track6",
        knob: 	{name: "k6", type: "control", num: 21, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f6", type: "control", num: 5, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s6", type: "control", num: 37, min: 0, max: 127, behavior: "button"},
        mute:   {name: "m6", type: "control", num: 53, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r6", type: "control", num: 69, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track7",
        knob: 	{name: "k7", type: "control", num: 22, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f7", type: "control", num: 6, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s7", type: "control", num: 38, min: 0, max: 127, behavior: "button"},
        mute:   {name: "m7", type: "control", num: 54, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r7", type: "control", num: 70, min: 0, max: 127, behavior: "button"}
    },
    {
        name: 	"track8",
        knob: 	{name: "k8", type: "control", num: 23, min: 0, max: 127, behavior: "continuous"},
        fader: 	{name: "f8", type: "control", num: 7, min: 0, max: 127, behavior: "continuous"},
        solo:   {name: "s8", type: "control", num: 39, min: 0, max: 127, behavior: "button"},
        mute:   {name: "m8", type: "control", num: 55, min: 0, max: 127, behavior: "button"},
        rec:    {name: "r8", type: "control", num: 71, min: 0, max: 127, behavior: "button"}
    }]
  transport:
    rew: 				{name: "rew", type: "control", num: 43, min: 0, max: 127, behavior: "button"}
    ff: 				{name: "ff", type: "control", num: 44, min: 0, max: 127, behavior: "button"}
    stop: 			{name: "stop", type: "control", num: 42, min: 0, max: 127, behavior: "button"}
    play: 			{name: "play", type: "control", num: 41, min: 0, max: 127, behavior: "button"}
    rec: 				{name: rec, type: "control", num: 45, min: 0, max: 127, behavior: "button"}
    setmark:		{name: "setmark", type: "control", num: 60, min: 0, max: 127, behavior: "button"}
    prevmark: 	{name: "prevmark", type: "control", num: 61, min: 0, max: 127, behavior: "button"}
    nextmark: 	{name: "nextmark", type: "control", num: 62, min: 0, max: 127, behavior: "button"}
    prevtrack: 	{name: "prevtrack", type: "control", num: 58, min: 0, max: 127, behavior: "button"}
    nexttrack: 	{name: "nexttrack", type: "control", num: 59, min: 0, max: 127, behavior: "button"}
    cycle: 			{name: "cycle", type: "control", num: 46, min: 0, max: 127, behavior: "button"}
...


*/




NanoKontrol2 {
	classvar default_keymap_file = "nano_config.yaml";
	var mididef; // MIDIdef that does all incoming midi parsing from controller
	var spec;  // keymap spec
	var device; // MIDI in/out endpoints for device
	var cbbycc; // Callbacks by CC number


	*new {|keymapfile=nil, initmidi=true|
		^super.new.init(keymapfile,initmidi);
	}

	init {|keymapfile,initmidi|
		cbbycc = IdentityDictionary.new;

		if(keymapfile.isNil) { // Use default keymapfile
			var sourcepaths = [
				Platform.userExtensionDir +/+ "KORG_SC",
				Platform.systemExtensionDir +/+ "KORG_SC",
			];

			// Look for nano_config.yaml in one of the source paths
			warn("No keymap file provided, searching source paths...");
			sourcepaths.do {|path, idx|
				var fullpath = path +/+ default_keymap_file;
				if(PathName(fullpath).isFile) {
					"Found config file % in %".format(default_keymap_file, path).postln;
					keymapfile = fullpath;
				} {
					"Did not find config file in %".format(path).postln;
				};
			};
		};

		spec = (keymapfile.parseYAMLFile)["keymap"];

		if(initmidi) {
			MIDIClient.init;
		};

		device = [nil, nil]; // MIDIEndPoint source and destination
		MIDIClient.sources.do {|src|
			//postln("%:%:%".format(src.device, src.name, src.uid));
			if(src.device.toLower == "nanokontrol2") {
				device[0] = src;
			};
		};
		MIDIClient.destinations.do {|src|
			//postln("%:%:%".format(src.device, src.name, src.uid));
			if(src.device.toLower == "nanokontrol2") {
				device[1] = src;
			};
		};

		postln("Found Source & Destination:\nSRC: %\nDST: %".format(device[0], device[1]));
		MIDIIn.connect(0, device[0].uid);
		MIDIOut.connect(0, device[1].uid);

		// Set up default callback functions for tracks and transport
		spec["tracks"].do {|tr,idx|
			this.setcb(idx, "knob", {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
			this.setcb(idx, "fader", {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
			this.setcb(idx, "solo", {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
			this.setcb(idx, "mute", {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
			this.setcb(idx, "rec", {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
		};
		spec["transport"].keysValuesDo {|thename,thespec|
			this.setcb("transport", thename, {|val, spec| postln("nano2 %: %".format(spec["name"], val)) }, true);
		};

		// Create general purpose MIDIdef...
		mididef = MIDIdef.cc(\nanokontrol2_tracks, {|theval, cc, chan, srcid|
			var cb = cbbycc[cc];
			if(cb.notNil) {
				theval = theval.linlin(0, 127, 0.0, 1.0).round(0.001);
				cb[\func].value(theval, cb[\spec]);
			} {
				error("Got unexpected MIDI from CC %: %".format(cc, theval));
			};
		}, ccNum: nil, chan: 0, srcID: device[0].uid);
	}

	// Convenience function around MIDIFunc.trace
	trace {|val=true| MIDIFunc.trace(val) }

	/*
	Set a callback function for a specific control widget.

	track <int|string> either track 0-7 or "transport"
	name <string> name of the widget, e.g. fader, knob, solo, rec...
	func callback function
	silent gives callback affirmation text if set to true
	*/
	setcb {|track="transport", name, func, silent=false|
		var widgetspec;
		if(track == "transport") {
			widgetspec = spec["transport"][name];
		} {
			var tr = spec["tracks"][track];
			widgetspec = tr[name];
		};

		if(widgetspec.notNil) {
			if(silent.not) {
				postln("Assigning callback to % % (CC %)".format(track, widgetspec["name"], widgetspec["num"]));
			};
			cbbycc.put( widgetspec["num"].asInteger, IdentityDictionary.newFrom([\func, func, \spec, widgetspec]) );
		} {
			error("No track % or transport or spec %".format(track, name));
		};
	}
}
