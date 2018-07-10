console.log("Script loaded");
Java.perform(function () {
    console.log("Inside java perform function");

    Java.choose("com.google.ctf.shallweplayagame.GameActivity" , {
      onMatch : function(instance){ //This function will be called for every instance found by frida
        console.log("Found instance: " + instance);
        console.log("Calling win func");
        
        if(activity.hasWindowFocus()){

           var looper=Java.use("android.os.Looper");
           looper.prepare();

           instance.m());
        }
        
      },
      onComplete:doNothing
    });
});