Phonegap-StatusBarNotification-Plugin
=====================================

## What's this?

A cordova/phonegap plugin to show notification texts on status bar. Tested on `cordova` 4.1.2, and should work on >= 4.0 .

## Installation

    cordova plugin add https://github.com/darkgeek/Phonegap-StatusBarNotification-Plugin.git

## Usage

This plugin provides a method `sendNotify()` to help `cordova` app send notifications to status bar:

    window.StatusBarNotification.sendNotify(title, text, ticker, enableExtraEffects, success, error)

where 

`title` is the title of the notification, in a standard notification;

`text` is the text of the notification, in a standard notification;

`ticker` is the text displayed in the status bar when the notification first arrives;

`enableExtraEffects` is a boolean value indicating whether vibrate and make sounds as well as lights when notification arrives;

`success` is a callback method, which will be called when showing notification successfully;

`error` is a callback method, which will be called when showing notification fails.

## Screenshot

![StatusBarNotification Screenshot](https://raw.githubusercontent.com/darkgeek/Phonegap-StatusBarNotification-Plugin/master/screenshot.png)
