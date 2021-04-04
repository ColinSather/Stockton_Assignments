'''
Caesar's Cipher Script
Created on September 20, 2019
@author: Colin Sather
'''
from alphabet import alphaFunctions

class CaesarCipher:
    tools = alphaFunctions()
    alpha = tools.alpha
    # Encrypt given string and shift value integer
    def encrypt(self, string, shift):
        cipher = ''
        for char in string: 
            cipher = cipher + chr((ord(char) + shift - 97) % 26 + 97)
        return cipher
    
    # Decrypt using known shift value
    def decrypt(self, cipher, shift):
        plaintext = ''
        for char in cipher:
            plaintext = plaintext + chr((ord(char) - shift - 97) % 26 + 97)
        return plaintext
    
    # Brute force 1-26 possible shift values 
    def bruteForce(self, secret):
        i = 1
        while i < 27:
            plain_t = self.decrypt(secret, i)
            print("Try shift value",i ,plain_t)
            i += 1   

# Call functions
code = "xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpitghlxiwiwtxgqadds"
f1 = CaesarCipher()
brute = f1.bruteForce(code)    
decrypt = f1.decrypt(code, 15)
re_encrypt = f1.encrypt(decrypt, 15)

print("\nFound match plain text :", decrypt)
print("Re-encrypt text :", re_encrypt)


