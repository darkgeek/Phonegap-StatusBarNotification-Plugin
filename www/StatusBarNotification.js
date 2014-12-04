window.StatusBarNotification = {
    sendNotify: function(title, text, ticker, enableExtraEffects, success, error) {
        cordova.exec(success, error, "StatusBarNotification", "sendNotify",[title, text, ticker, enableExtraEffects]);
    },
};

module.exports = StatusBarNotification;
