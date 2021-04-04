'''
Created on Sep 26, 2019
Integer to Alphabet Converter 
This class allows other scripts in the package to convert 
numbers into letters and letters into numbers
@author: Colin Sather
'''
class alphaFunctions:    
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                    'o','p','q','r','s','t','u','v','w','x','y','z']
    def getIndicies(self,string):
            string_length = range(len(string))
            alpha_length = range(len(self.alpha))
            indicies = []
            count = 0
            for j in string_length:
                for i in alpha_length:    
                    if string[j] == self.alpha[i]:
                        indicies.append(i)
                count += 1
            return indicies
        