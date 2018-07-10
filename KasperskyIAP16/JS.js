// Step 1

//
// function PTqcvBLORZfCFHISXdg(data) {var b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";var o1, o2, o3, h1, h2, h3, h4, bits, i=0, enc='';do {h1 = b64.indexOf(data.charAt(i++));h2 = b64.indexOf(data.charAt(i++));h3 = b64.indexOf(data.charAt(i++));h4 = b64.indexOf(data.charAt(i++));bits = h1<<18 | h2<<12 | h3<<6 | h4;o1 = bits>>16 & 0xff;o2 = bits>>8 & 0xff;o3 = bits & 0xff;if (h3 == 64)      enc += String.fromCharCode(o1);else if (h4 == 64) enc += String.fromCharCode(o1, o2);else enc += String.fromCharCode(o1, o2, o3);} while(i < data.length);return unescape(enc);}
//
//
// 	function Start()
// 	{
// 		eval(PTqcvBLORZfCFHISXdg("ZXZhbChmdW5jdGlvbihwLGEsYyxrLGUsZCl7ZT1mdW5jdGlvbihjKXtyZXR1cm4gYy50b1N0cmluZygzNil9O2lmKCEnJy5yZXBsYWNlKC9eLyxTdHJpbmcpKXt3aGlsZShjLS0pe2RbYy50b1N0cmluZyhhKV09a1tjXXx8Yy50b1N0cmluZyhhKX1rPVtmdW5jdGlvbihlKXtyZXR1cm4gZFtlXX1dO2U9ZnVuY3Rpb24oKXtyZXR1cm4nXFx3Kyd9O2M9MX07d2hpbGUoYy0tKXtpZihrW2NdKXtwPXAucmVwbGFjZShuZXcgUmVnRXhwKCdcXGInK2UoYykrJ1xcYicsJ2cnKSxrW2NdKX19cmV0dXJuIHB9KCdnKGMoKXsxIDM9ImwiOzEgNT1kOzEgND0iIjtlKDEgaT0wO2k8My5iO2krPTIpezEgNz05KDMuZihpLGkrMiksNileNTs0Kz03LmsoNikuaigpfW8uaCgibiIpLmE9NH0sOCptKTsnLDI1LDI1LCd8dmFyfHxGdWxsS2V5fEZsYWd8S2V5fDE2fHRtcHwxMDAwfHBhcnNlSW50fGlubmVySFRNTHxsZW5ndGh8ZnVuY3Rpb258MHgzM3xmb3J8c3Vic3RyaW5nfHNldEludGVydmFsfGdldEVsZW1lbnRCeUlkfHx0b1VwcGVyQ2FzZXx0b1N0cmluZ3wyQzI2RDMzQTBGQkI2M0IyODYxN0VERUZDRDFFQzVCQ3w5OTk5fGZsYWd8ZG9jdW1lbnQnLnNwbGl0KCd8JyksMCx7fSkp"));
// 	}
//
//
// var res = PTqcvBLORZfCFHISXdg("ZXZhbChmdW5jdGlvbihwLGEsYyxrLGUsZCl7ZT1mdW5jdGlvbihjKXtyZXR1cm4gYy50b1N0cmluZygzNil9O2lmKCEnJy5yZXBsYWNlKC9eLyxTdHJpbmcpKXt3aGlsZShjLS0pe2RbYy50b1N0cmluZyhhKV09a1tjXXx8Yy50b1N0cmluZyhhKX1rPVtmdW5jdGlvbihlKXtyZXR1cm4gZFtlXX1dO2U9ZnVuY3Rpb24oKXtyZXR1cm4nXFx3Kyd9O2M9MX07d2hpbGUoYy0tKXtpZihrW2NdKXtwPXAucmVwbGFjZShuZXcgUmVnRXhwKCdcXGInK2UoYykrJ1xcYicsJ2cnKSxrW2NdKX19cmV0dXJuIHB9KCdnKGMoKXsxIDM9ImwiOzEgNT1kOzEgND0iIjtlKDEgaT0wO2k8My5iO2krPTIpezEgNz05KDMuZihpLGkrMiksNileNTs0Kz03LmsoNikuaigpfW8uaCgibiIpLmE9NH0sOCptKTsnLDI1LDI1LCd8dmFyfHxGdWxsS2V5fEZsYWd8S2V5fDE2fHRtcHwxMDAwfHBhcnNlSW50fGlubmVySFRNTHxsZW5ndGh8ZnVuY3Rpb258MHgzM3xmb3J8c3Vic3RyaW5nfHNldEludGVydmFsfGdldEVsZW1lbnRCeUlkfHx0b1VwcGVyQ2FzZXx0b1N0cmluZ3wyQzI2RDMzQTBGQkI2M0IyODYxN0VERUZDRDFFQzVCQ3w5OTk5fGZsYWd8ZG9jdW1lbnQnLnNwbGl0KCd8JyksMCx7fSkp");
//
// console.log(res);

// Step 2, decoded from above:

// newfunc = function(p, a, c, k, e, d) {
//   e = function(c) {
//     return c.toString(36)
//   };
//   if (!''.replace(/^/, String)) {
//     while (c--) {
//       d[c.toString(a)] = k[c] || c.toString(a)
//     }
//     k = [function(e) {
//       return d[e]
//     }];
//     e = function() {
//       return '\\w+'
//     };
//     c = 1
//   };
//   while (c--) {
//     if (k[c]) {
//       p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
//     }
//   }
//   return p
// }
//
// var flag = newfunc(
//   'g(c(){1 3="l";1 5=d;1 4="";e(1 i=0;i<3.b;i+=2){1 7=9(3.f(i,i+2),6)^5;4+=7.k(6).j()}o.h("n").a=4},8*m);',
//   25, 25,
//   '|var||FullKey|Flag|Key|16|tmp|1000|parseInt|innerHTML|length|function|0x33|for|substring|setInterval|getElementById||toUpperCase|toString|2C26D33A0FBB63B28617EDEFCD1EC5BC|9999|flag|document'
//   .split('|'), 0, {});
//
// console.log(flag);


//Step 3

setInterval(function() {
  var FullKey = "2C26D33A0FBB63B28617EDEFCD1EC5BC";
  var Key = 0x33;
  var Flag = "";
  for (var i = 0; i < FullKey.length; i += 2) {
    var tmp = parseInt(FullKey.substring(i, i + 2), 16) ^ Key;
    Flag += tmp.toString(16).toUpperCase()
  }
  document.getElementById("flag").innerHTML = Flag
}, 1000 * 9999);
