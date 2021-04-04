'''
Vigenere Cipher Script
Created on Sep 26, 2019
@author: Colin Sather
'''
from alphabet import alphaFunctions

class Vig:
    tools = alphaFunctions()

    # generate key in a cyclic manner
    def generateKey(self, string, key):
        key = list(key)
        if len(key) == len(string):
            return(key)
        else:
            for i in range(len(string) - len(key)):
                key.append(key[i % len(key)])
        return("".join(key))

    # encryption function
    def cipherText(self, string, key): 
        letter_nums = self.tools.getIndicies(string)
        key_nums = self.tools.getIndicies(key)
        cipher_text = []
        j = 0
        for i in letter_nums:
            c = (i + key_nums[j]) % 26
            cipher_text.append(c)
            j += 1
        # convert cipher_text alpha indices to 
        # characters of a string 
        cipher_str = ''
        for index in cipher_text:
            cipher_str += self.tools.alpha[index]
        return cipher_str
        
    # encryption function
    def originalText(self, cipher_text, key): 
        letter_nums = self.tools.getIndicies(cipher_text)
        key_nums = self.tools.getIndicies(key)
        plain_text = []
        j = 0
        for i in letter_nums:
            p = (i - key_nums[j]) % 26
            plain_text.append(p)
            j += 1
        # convert plain_text alpha indices to 
        # characters of a string 
        plain_str = ''
        for index in plain_text:
            plain_str += self.tools.alpha[index]
        return plain_str

# Driver code 
if __name__ == "__main__": 
    string = "test"
    keyword = "rad"
    key = Vig().generateKey(string, keyword) 
    cipher_text = Vig().cipherText(string,key) 
    print("Ciphertext :", cipher_text) 
    print("Original/Decrypted Text :", Vig().originalText(cipher_text, key)) 
