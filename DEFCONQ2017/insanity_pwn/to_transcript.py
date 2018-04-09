from pwn import *
import sys
import subprocess


increment = "insanity "
set_qword = "insane "

# say options
voice = "Samantha"
rate = "300"

# ffmpeg options
audio_format = "u8"
audio_rate = "16000"
audio_channels = "1"
audio_codec = "pcm_" + audio_format

def encode_as_voice(qword):
    encoded = ""
    for _ in range(qword):
        encoded = encoded + increment
    encoded = encoded + set_qword
    return encoded

bin_file = "input"
txt_file = "input" + '.txt'
aiff_file = "input" + '.aiff'
raw_file = "input" + '.raw'


for i in xrange(10, 101):

	enc = encode_as_voice(i)
	with open("txtinput" + str(i), 'w') as txtinput:
		txtinput.write(enc)

	print "--output-file="+aiff_file + str(i)
	subprocess.check_output(["say", "--input-file="+"txtinput" + str(i), "-v", voice, "-r", rate, "--output-file="+aiff_file + str(i)])
	subprocess.check_output(["ffmpeg", "-i", aiff_file + str(i), "-f", audio_format, "-ar", audio_rate, "-ac", audio_channels, "-acodec", audio_codec, raw_file + str(i)])
	subprocess.check_output(["zopfli", "--zlib", raw_file + str(i)])
