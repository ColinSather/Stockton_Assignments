'''
Affine Cipher Encryption and Decryption
Created on Sep 24, 2019
@author: colin
'''
from alphabet import alphaFunctions
class AffineCipher:
    alphabet = alphaFunctions()
    alpha_set = alphabet.alpha
    # gcd and relPrime functions used to check parameters
    def gcd(self, a, b):
        while b != 0:
            a, b = b, a % b
        return a
    def relPrime(self, a, b):
        return self.gcd(a, b) == 1
    
    def encrypt(self, a, b, message):
        cipher_txt = [] 
        # check if variable 'a' is relatively prime to 26
        if self.relPrime(a, 26) != 1:
            print("Bad parameter, a must be relatively prime to 26.")
            
        # performs a calculation for each character of message
        else:
            alpha_poss = self.alphabet.getIndicies(message)
            for pos in alpha_poss:
                cipher_num = (a*pos + b) % 26 
                cipher_txt.append(self.alpha_set[cipher_num])
            affine_c = ''
            for elem in cipher_txt:
                affine_c += elem    
        return affine_c
        
    # functions used for decryption
    def egcd(self, a, b): 
        x,y, u,v = 0,1, 1,0
        while a != 0: 
            q, r = b//a, b%a 
            m, n = x-u*q, y-v*q 
            b,a, x,y, u,v = a,r, u,v, m,n 
        gcd = b 
        return gcd, x, y 
        
    def modinv(self, a, m):  
        gcd, x, y = self.egcd(a, m) 
        if gcd != 1: 
            return None  # modular inverse does not exist 
        else: 
            return x % m
            
    # decryption function
    def decrypt(self, a, b, message):
        plain_txt = [] 
        # check if variable 'a' is relatively prime to 26
        if self.relPrime(a, 26) != 1:
            print("Bad parameter, a must be relatively prime to 26.")
        else:
            alpha_poss = self.alphabet.getIndicies(message)
            for c in alpha_poss:
                d_num = self.modinv(a, 26) * (c - b) % 26
                plain_txt.append(self.alpha_set[d_num])
            final = ''
            for elem in plain_txt:
                final += elem
        return final
    

    
    
    
    
    
