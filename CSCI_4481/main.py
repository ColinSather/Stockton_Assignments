'''
Created on Sep 24, 2019
Affine Tester Script 
@author: Colin Sather
'''
from caesarsCipher import caCipher
from affine import AffineCipher
from vigenere import Vig
from frequencyAnalysis import freqAnalysis
from alphabet import alphaFunctions


if __name__ == "__main__":
      caesar = caCipher()
      affy = AffineCipher()
      freq = freqAnalysis()
      alpha = alphaFunctions.alpha
      plain_str = "some message to encrypt and decrypt"

      # analyze the frequency of each character in the variable plain_str 
      print("Here is the average occurance of each letter (A - Z) in:", plain_str)
      ret = freq.findFreq(plain_str)
      counter = 0
      for x in ret:
            print(x, "average occurances of letter", alpha[counter])
            counter += 1

      # test caesars cipher encryption and decryption
      encryption = caesar.encrypt(plain_str)
      decryption = caesar.decrypt(plain_str)
      print("\nCaesar Cipher Test")
      print("Plain text :", plain_str, "\nCipher text :", encryption)
      print("\Caesar Decryption Test")
      print("Cipher text :", encryption, "\nPlain text :",decryption)

      # test affine encryption and decryption
      encryption = affy.encrypt(3, 2, plain_str)
      decryption = affy.decrypt(3, 2, encryption)
      print("\nAffine Encryption Test")
      print("Plain text :", plain_str, "\nCipher text :", encryption)
      print("\nAffine Decryption Test")
      print("Cipher text :", encryption, "\nPlain text :",decryption)

      



