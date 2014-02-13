// Init the plugin
var Pushbots = function () {

}

Pushbots.prototype.fail = function (msg) {
	console.log("Javascript Callback Error: " + msg)
}

Pushbots.prototype.setAlias = function (alias, win) {
	cordova.exec(win, this.fail, "PushbotsPlugin", "setAlias", [alias]);
}

Pushbots.prototype.Tag = function (tag, win) {
	cordova.exec(win, this.fail, "PushbotsPlugin", "Tag", [tag]);
}

Pushbots.prototype.delTag = function (tag, win) {
	cordova.exec(win, this.fail, "PushbotsPlugin", "delTag", [tag]);
}

Pushbots.prototype.isPushEnabled = function (win) {
	return cordova.exec(win, this.fail, "PushbotsPlugin", "isPushEnabled", []);
}

module.exports = new Pushbots();