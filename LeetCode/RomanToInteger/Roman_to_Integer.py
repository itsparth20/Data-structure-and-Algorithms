
def romanToInt(s):
    roman = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M']
    no_list = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    number = 0
    i = 0;
    while i < len(s):
        for j in range(len(roman)-1,-1,-1):
            if s[i:i+len(roman[j])] == roman[j]:
                number += no_list[j]
                i += len(roman[j])
                break
    return number
    
print romanToInt('XXXV')