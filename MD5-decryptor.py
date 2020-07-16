import hashlib
import os
import sys

banner = """

      ------------------                                                  
      < MD5 Decryptor! >             
      ------------------                                                        
              \   ^__^         
               \  (00)\_______                                                  
                  (__)\       )\/\                                              
                      ||----w |      
                      ||     ||  

"""
print (banner)
class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

folder = raw_input("Please specify the directory with the wordlist [FULL PATH] > ")
wordlist = raw_input("Please specify the wordlist filename > ")
fname = os.path.join(folder, wordlist)

with open(fname) as f:
    content = f.readlines(10000000)
    word1 = [x.strip() for x in content] 
input_hash = raw_input("Please input the MD5 hash you want to decrypt" " > ")
#print (lines)
for number in word1:
    encrypted = hashlib.md5(number).hexdigest()
    if encrypted == input_hash:
        print (bcolors.OKGREEN + "HASH FOUND : Password is " + bcolors.ENDC+ bcolors.FAIL + "{p}".format(p=number))+ bcolors.ENDC
        sys.exit(1)
print
print(bcolors.WARNING + "FAILED TO DECRYPT HAS TRY USING SECLISTS WORDLIST" + bcolors.ENDC)
