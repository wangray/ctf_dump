require 'wav-file'

wav = open("steg.wav")
format = WavFile::readFormat(wav)
chunk = WavFile::readDataChunk(wav)

puts format
puts chunk

wavs = chunk.data.unpack('s*')
lsb = wavs.map{|sample| sample[0]}.join
flag = lsb[1..100]
puts [flag].pack('b*')
wav.close
