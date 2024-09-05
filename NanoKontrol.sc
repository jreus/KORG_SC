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
	classvar <default_keymap_file = "nano_config.yaml";
	var <mididef; // MIDIdef that does all incoming midi parsing from controller
	var <spec;  // keymap spec
	var <device; // MIDI in/out endpoints for device
	var <cbbycc; // Callbacks by CC number


	// Metaparameters that may be used arbitrarily by client code.
	var <>controlStates; // internally stored memory of controller states
	var <>currentControl=0;
	var <>assignControl; // assignControl callback


	// GUI object
	var <>gui;

	*new {|keymapfile=nil, initmidi=true|
		^super.new.init(keymapfile,initmidi);
	}

	init {|keymapfile,initmidi|
		var parsed_spec;
		cbbycc = IdentityDictionary.new;

		if(keymapfile.isNil) { // Use default keymapfile
			var sourcepaths = [
				Platform.userExtensionDir +/+ "KORG_SC",
				Platform.systemExtensionDir +/+ "KORG_SC",
			];

			// Look for nano_config.yaml in one of the source paths
			warn("No keymap file provided for Nanokontrol2, searching source paths...");
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

		parsed_spec = (keymapfile.parseYAMLFile)["keymap"].deepCopy;

		// Parse spec and copy into mutable data structures
		// TODO: This is terrible code! Rewrite this as a recursive function (as a utility function?)
		// TODO: also would be nice to convert ints and floats from strings
		spec=Dictionary.new;
		parsed_spec.keysValuesDo {|key, val|
			if(val.isKindOf(Dictionary)) {
				val = Dictionary.newFrom(val);
			} {
				if(val.isKindOf(String)) {
					val=val.copy;
				} {
					if(val.isKindOf(SequenceableCollection)) {
						val = val.collect {|arritem|
							if(arritem.isKindOf(Dictionary)) {
								arritem=Dictionary.newFrom(arritem);
								arritem.keysValuesDo {|subkey, subval|
									if(subval.isKindOf(Dictionary)) {
										subval = Dictionary.newFrom(subval);
									};
									arritem[subkey]=subval;
								};
							};
							arritem;
						};
					};
				};
			};
			spec.put(key, val);
		};

		// Init gui
		gui = ();
		gui.win = nil;

		// Keep an internal record of control states for each bank
		controlStates = 4.collect {|idx|
			IdentityDictionary.newFrom([\sliders, 0.0!8, \knobs, 1.0!8, \frozen, false]);
		};
		assignControl = {|val| "Assign Control Bank %".format(val).postln };

		device = [nil, nil]; // MIDIEndPoint source and destination
		if(initmidi) {
			MIDIClient.init;

			MIDIClient.sources.do {|src|
				//postln("%:%:%".format(src.device, src.name, src.uid));
				if(src.device.toLower == "nanokontrol2") { device[0] = src };
			};
			MIDIClient.destinations.do {|src|
				//postln("%:%:%".format(src.device, src.name, src.uid));
				if(src.device.toLower == "nanokontrol2") { device[1] = src };
			};

			if(device[0].notNil) {
				postln("Found Source & Destination:\nSRC: %\nDST: %".format(device[0], device[1]));
				MIDIIn.connect(0, device[0].uid);
				MIDIOut.connect(0, device[1].uid);

				// Create general purpose MIDIdef...
				mididef = MIDIdef.cc(\nanokontrol2_tracks, {|theval, cc, chan, srcid|
					var cb = cbbycc[cc];
					if(cb.notNil) {
						theval = theval.linlin(0, 127, 0.0, 1.0).round(0.001);
						// update gui widget if it exists
						if(cb[\spec]["view"].notNil) {
							{cb[\spec]["view"].valueAction = cb[\spec]["view"].controlSpec.map(theval)}.fork(AppClock);
						} { // no gui widget, so just run the callback headless
							cb[\func].value(theval, cb[\spec]);
						};
					} {
						error("Got unexpected MIDI from CC %: %".format(cc, theval));
					};
				}, ccNum: nil, chan: 0, srcID: device[0].uid);

			} {
				error("MIDI Device 'nanokontrol2' not found! MIDI will not be available for Nanokontrol2 object.");
			};
		};

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

	/*
	Get a callback function for a specific control widget
	track <int|string> either track 0-7 or "transport"
	name <string> name of the widget, e.g. fader, knob, solo, rec...
	*/
	pr_getcb_by_spec {|track="transport", name|
		var res, widgetspec;
		if(track == "transport") {
			widgetspec = spec["transport"][name];
		} {
			var tr = spec["tracks"][track];
			widgetspec = tr[name];
		};

		if(widgetspec.notNil) {
			res = cbbycc.at( widgetspec["num"].asInteger )
		};
		^res;
	}

	/*
	Run a callback function for a specific control widget
	track <int|string> either track 0-7 or "transport"
	name <string> name of the widget, e.g. fader, knob, solo, rec...
	theval <float> the value to call the cb with
	*/
	callcb_byspec {|track="transport", name, theval|
		var cb = this.pr_getcb_by_spec(track, name);
		postln("Run % % CB: % with val: % theval".format(track, name, cb, theval));
		if(cb.notNil) {
			cb[\func].value(theval, cb[\spec]);
			^theval;
		} {
			warn("No cb found for % %".format(track, name));
			^nil;
		};
	}

	// GUI stuff
	// TODO: Allow more control over the controlspec of data translation for use in callback functions
	makeGUI {|modelids, width=380, height=680|
		if(gui.win.notNil) { gui.win.close; gui.win=nil };

		gui.win = Window.new("igouwei", Rect(Window.screenBounds.width - width, 0, width, height));

		// MODEL MORPHING CONTROLS
		// TODO: integrate this / make this possible - into a more generalized useable GUI
		// For igowei these use tracks 7 & 8 in a way that is separate from the others which control latents..
		// TODO: Make Nanokontrol2 a more generalized gui interface - or break out the gui in a composed class.
		//       And subclass the gui for Igowei
		gui.balanceview = CompositeView(gui.win, Rect(0 , 0, width, 260));


		// KNOBS/FADERS VIEW
		gui.sliderview = CompositeView(gui.win, Rect(0, 270, width, 320));
		gui.knobs=Array.newClear(8);
		gui.sliders=Array.newClear(8);
		gui.slider2d=Slider2D( gui.balanceview, Rect(10,15,160,160) );
		gui.model_labels=[
			StaticText(gui.balanceview, Rect(5,0, 100, 15)).string_(modelids[0]),
			StaticText(gui.balanceview, Rect(120,0, 100, 15)).string_(modelids[1]),
			StaticText(gui.balanceview, Rect(5, 170, 100, 15)).string_(modelids[2]),
			StaticText(gui.balanceview, Rect(120,170, 100, 15)).string_(modelids[3]),
		];

		8.do {|idx|
			var knob,slider;

			switch(idx,

				6, { // track 6 - knob controls X morphing between models, fader controls source level
					knob = EZKnob(
						gui.balanceview,
						Rect(160/3 - 5,170+10,70,70),
						label: "X".format(modelids[3], modelids[2]),
						controlSpec: [-1.0, 1.0, \lin, 0.01, 1.0].asSpec,
						action: {|widget|
							this.callcb_byspec(6, "knob", widget.value);
							postln("From knob - set slider X: %".format(widget.value));
							gui.slider2d.x_(widget.value.linlin(-1.0, 1.0, 0.0, 1.0));
					});

					slider = EZSlider(
						gui.balanceview,
						Rect(280,0,40,260),
						label: "source",
						controlSpec: [0.0, 1.0, \lin, 0.01, 0.0].asSpec,
						action: {|widget| this.callcb_byspec(6, "fader", widget.value) },
						layout: \vert,
					);
				},
				7, { // track 7 - knob controls Y morphing between models, fader controls model level
					knob = EZKnob(
						gui.balanceview,
						Rect(160+20,160/4 + 5,70,70),
						label: "Y".format(modelids[1], modelids[0]),
						controlSpec: [-1.0, 1.0, \lin, 0.01, 1.0].asSpec,
						action: {|widget|
							this.callcb_byspec(7, "knob", widget.value);
							postln("From knob - set slider Y: %".format(widget.value));
							gui.slider2d.y_(widget.value.linlin(-1.0, 1.0, 0.0, 1.0));
						});


					slider = EZSlider(
						gui.balanceview,
						Rect(325,0,40,260),
						label: "VAE",
						controlSpec: [0.0, 1.0, \lin, 0.01, 0.0].asSpec,
						action: {|widget| this.callcb_byspec(7, "fader", widget.value) },
						layout: \vert,
					);

				},
				{ // all other tracks
					knob=EZKnob(
						gui.sliderview,
						Rect((idx*62)+5,0,60,100),
						label: idx.asString,
						controlSpec: [0.0, 3.0, \lin, 0.01, 1.0].asSpec,
						action: {|widget| this.callcb_byspec(idx, "knob", widget.value) },
					);

					slider=EZSlider(
						gui.sliderview,
						Rect((idx*62)+5,110,60,200),
						controlSpec: [-3.0, 3.0, \lin, 0.01, 0.0].asSpec,
						action: {|widget| this.callcb_byspec(idx, "fader", widget.value) },
						layout: \vert,
					);
				}
			);

			gui.knobs[idx] =knob;
			gui.sliders[idx] =slider;

			// Set reference to GUI view in keyspec
			spec["tracks"][idx]["knob"].put("view", knob);
			spec["tracks"][idx]["fader"].put("view", slider);
		};

		gui.slider2d.action = {|widget|
			gui.knobs[6].valueAction_(widget.x.linlin(0.0, 1.0, -1.0, 1.0));
			gui.knobs[7].valueAction_(widget.y.linlin(0.0, 1.0, -1.0, 1.0));
		};

		// Initialize to upper left corner of 2D slider
		gui.knobs[6].valueAction_(-1.0);
		gui.knobs[7].valueAction_(1.0);
		// Initialize src & rave levels
		gui.sliders[6].valueAction_(0.0);
		gui.sliders[7].valueAction_(1.0);



		// MODEL SELECTION BUTTONS VIEW
		// These are effectively different "banks" - with saved control states for each bank.
		gui.aButtons=Array.newClear(4);
		gui.buttonsview = CompositeView(gui.win, Rect(5, 585, 400, 100));
		4.do {|idx|

			"Make bank button %".format(idx).postln;

			gui.aButtons[idx] = Button.new(gui.buttonsview, Rect((idx*92)+5, 0, 90, 90)).states_(
				[["", Color.grey, Color.grey],["++", Color.green, Color.yellow]]
			).action_({|bt| if(bt.value==1) {
				// Activate this one...
				// 1. Activate control over the new model if not already done directly by the controller...
				if(currentControl != idx) {
					assignControl.value(idx);
					currentControl = idx;
				};
				// 2. Update the controller knobs/faders with the stored values...
				// TODO: These only affect the first 6 tracks! This is not generalizable to Nanokontrol2 setups...
				//       generalize this class and make an igowei-specific subclass
				6.do {|jx|
					gui.knobs[jx].value = controlStates[idx][\knobs][jx];
					gui.sliders[jx].value = controlStates[idx][\sliders][jx];
				};
			} });
		};
		gui.aButtons[0].valueAction = 1;

		// Finally, show window
		gui.win.front;
	}

}
