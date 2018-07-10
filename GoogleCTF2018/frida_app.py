import frida
import sys
import subprocess
import time

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
    else:
        print(message)

jscode = """
console.log("Script loaded");

function toHexString(byteArray) {
  for (var i = 0; i < 32; i++){
    console.log(byteArray[i]);
  }
}

var gameInstance;
function callwinFun() { //Defining the function that will be exported
    Java.perform(function () { //code that calls `win` function from the previous example
        
        if (gameInstance == null) {
            Java.choose("com.google.ctf.shallweplayagame.GameActivity", {
                onMatch: function (instance) {
                    console.log("Found instance: " + instance);
                    gameInstance = instance;
                    console.log("Calling win func");

                    console.log("q: ", JSON.stringify(gameInstance.q.value));

                    console.log(instance.n());


                },
                onComplete: function () { }
            });
        } else {
            console.log("Using instance: " + gameInstance);
            console.log("Calling win func");

            console.log("q: ", JSON.stringify(gameInstance.q.value));
            gameInstance._o.value= 2
            console.log("o: ", JSON.stringify(gameInstance._o.value));
            console.log(gameInstance.n());
            console.log(gameInstance.m())
        }
        
    });
}

function setQFun(arr){
    Java.perform(function () { //code that calls `win` function from the previous example
        
        Java.choose("com.google.ctf.shallweplayagame.GameActivity", {
            onMatch: function (instance) {
                console.log("Found instance: " + instance);
    
                console.log("Setting q");
                console.log("q was ", JSON.stringify(instance.q.value));
                instance.q.value = Java.array("byte", arr)
                console.log("q now ", JSON.stringify(instance.q.value));
            },
            onComplete: function () { }
        });
    });
}

rpc.exports = {
    callwinfunction: callwinFun, //exporting callwinFun as callwinfunction
    setqfunction: setQFun
  // the name of the export (callwinfunction) cannot have  neither Uppercase letter nor uderscores.
};

Java.perform(function () {
    console.log("Inside java perform function");

    // Hook setText
    var tv_class = Java.use("android.widget.TextView");
    tv_class.setText.overload("java.lang.CharSequence", 'android.widget.TextView$BufferType').implementation = function (x, y) {
        var string_to_send = x;
        console.log("textview ", JSON.stringify(string_to_send)); // send data to python code
        // this.setText(x, y)
    }
    
    // Function to hook is defined here
    var GameActivity = Java.use('com.google.ctf.shallweplayagame.GameActivity');

    GameActivity.k.implementation = function () {
            // Do nothing
        };
    
    GameActivity.onClick.implementation = function (v) {
        // Show a message to know that the function got called
        send('onClick');

        // Call the original onClick handler
        this.onClick(v);

        // Set our values after running the original onClick handler
    };
});
"""


'''
    GameActivity.k.implementation = function () {
        // Do nothing
    };
'''
# jscode = """
# console.log("Script loaded");
# Java.perform(function () {
#      console.log("Inside java perform function");
#     var looper=Java.use("android.os.Looper");
#     looper.prepare();

#     var gameClass = Java.use('com.google.ctf.shallweplayagame.GameActivity');
#     var game = gameClass.$new()
    
#     console.log(JSON.stringify(game.r));
#     var buffer = Java.array('byte', game.r);
#     console.log(buffer.length);
#     var result = "";
#     for(var i = 0; i < buffer.length; ++i){
#         result+= (String.fromCharCode(buffer[i]));
#     }

#     console.log(result);
# });

# """

try:
    process = frida.get_usb_device().attach('com.google.ctf.shallweplayagame')
    script = process.create_script(jscode)
    script.on('message', on_message)
    print('[*] Running CTF')
    script.load()

except: 
    print("FRIDA_APP ATTEMPTING TO RESTART GAME")
    subprocess.check_call("adb shell am force-stop com.google.ctf.shallweplayagame; adb shell am start -n com.google.ctf.shallweplayagame/com.google.ctf.shallweplayagame.GameActivity", shell=True)

    process = frida.get_usb_device().attach('com.google.ctf.shallweplayagame')
    script = process.create_script(jscode)
    script.on('message', on_message)
    print('[*] Running CTF')
    script.load()

if len(sys.argv) >= 3 and sys.argv[1] == "setq":
    script.exports.setqfunction(eval(sys.argv[2]))
for i in range(10000):
    print("i =", i, "!")
    script.exports.callWinFunction()
    time.sleep(.1)

sys.stdin.read()



