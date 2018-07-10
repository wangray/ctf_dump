import subprocess
from threading import Timer
import sys
import signal

totalcount = int(open("totalcount").read().strip())
q = sys.argv[1]
while True:
    try:   
        with open('frida_log', 'ab') as f:
            print("NEW PROCESS, setting q to ", q)
            cmd  = "python3 frida_app.py setq {}".format(q).split()
            process = subprocess.Popen(cmd , stdout=subprocess.PIPE)

            def _handler(signum, frame):
                print('Timeout reached, stopping execution')
                process.kill()


            # timer = Timer(50, process.kill)
            # timer.start()
            signal.signal(signal.SIGALRM, _handler)

            for line in iter(lambda: process.stdout.readline(), b''):
                signal.alarm(0)
                f.write(line)
                f.flush()

                if b"i = " in line:
                    icount  = int(line[3:line.index(b"!")].strip())
                    totalcount += 1
                    print("totalcount", totalcount)
                    with open("totalcount", "w") as countf:
                        countf.write(str(totalcount))

                if b"q: " in line:
                    q = str(line[3:].strip(), 'utf-8')
                    print("q", q)

                if b'CTF{' in line:
                    printf("FOUND FLAG", line)
                    exit()

                if b'OutOfMemoryError' in line:
                    subprocess.check_call("adb shell am force-stop com.google.ctf.shallweplayagame; adb shell am start -n com.google.ctf.shallweplayagame/com.google.ctf.shallweplayagame.GameActivity", shell=True)
                    break
                signal.alarm(5)

            # if timer.is_alive():
            #     timer.cancel()
        # while True:
        #     output = process.stdout.readline()
        #     if output == '' and process.poll() is not None:
        #         break
        #     if output:
        #         print("[]", output.strip())
        # rc = process.poll()
    except Exception as e:
        print(e)

    # if "{" in output:
    #     print("FOUND!", output)
    #     break
    # icount_end = output.split("i=")
    # icount = int(icount_end[:icount_end.index("!")])
    # print(icount)

    # totalcount += icount
    # print("totalcount", totalcount)
