'''
Frequency Analysis Script
Created on September 20, 2019
@author: Colin Sather
'''
from alphabet import alphaFunctions
class freqAnalysis:
    alpha = alphaFunctions.alpha
    def findFreq(self, message):
        """Count the occurances of each letter in a given message and find the average
        
        param: message(string value)
        ret: percentages(double value)
        """
        
        # create an empty array containing 26 0s
        count_each = []
        i = 0
        while i < 26:
            count_each.append(0)
            i += 1
            
        # store characters of message in an array
        array = []
        for i in message:
            array.append(i)
        
        # count occurrences of each character
        for x in array:
            i = 0
            while i < 26:
                if x == self.alpha[i]:
                    count_each[i] += 1   
                i += 1
    
        # store relative frequency percentages in an array
        percentages = [] 
        for elem in count_each:
            rf = elem / len(message)
            answer = round(rf, 3) 
            percentages.append(answer)
            
        return percentages

check = freqAnalysis() 
string = "testing" 
print(string)
print(check.findFreq(string))
print(check.alpha)




        
