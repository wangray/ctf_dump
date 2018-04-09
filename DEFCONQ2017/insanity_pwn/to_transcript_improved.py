from pwn import *
import sys
import subprocess
import os

# program info
increment = "insanity "
set_qword = "insane "
size_limit = 0x10000

# say options
voices = ["Agnes", "Allison", "Ava", "Kathy", "Princess", "Samantha", "Susan", "Vicki", "Victoria", "Alex", "Bruce", "Fred", "Junior", "Ralph", "Tom"]

# ffmpeg options
audio_format = "u8"
audio_rate = str(16000)
audio_channels = str(1)
audio_codec = "pcm_" + audio_format

def encode_as_voice(qword):
    encoded = ""
    for _ in range(qword):
        encoded = encoded + increment
    encoded = encoded + set_qword
    return encoded

def create_audio(infile, voice, rate):
    base_file = infile + '-' + voice + '-' + str(rate)
    bin_file = infile
    txt_file = base_file + '.txt'
    aiff_file = base_file + '.aiff'
    raw_file = base_file + '.raw'
    zlib_file = raw_file + '.zlib'

    with open(bin_file, "rb") as input_file:
        with open(txt_file, "w") as output_file:
            qword = u64(input_file.read(8), endianness='little', sign='unsigned')
            output_file.write(encode_as_voice(qword).strip())

    with open(os.devnull, 'w') as DEVNULL:
        subprocess.check_call(["say", "--input-file="+txt_file, "-v", voice, "--output-file="+aiff_file, "--rate="+str(rate)], stdout=DEVNULL, stderr=DEVNULL)
        subprocess.check_call(["ffmpeg", "-i", aiff_file, "-f", audio_format, "-ar", audio_rate, "-ac", audio_channels, "-acodec", audio_codec, raw_file], stdout=DEVNULL, stderr=DEVNULL)
        subprocess.check_call(["zopfli", "--zlib", raw_file], stdout=DEVNULL, stderr=DEVNULL)

    if os.path.getsize(zlib_file) > size_limit:
        print "file too big"

if __name__ == "__main__":
    assert(sys.argv[2] in voices)
    create_audio(sys.argv[1], sys.argv[2], sys.argv[3])
