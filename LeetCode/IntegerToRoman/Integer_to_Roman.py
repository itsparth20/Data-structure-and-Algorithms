
def intToRoman(s):
    roman = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M']
    no_list = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    no_list.reverse()
    roman.reverse()
    number = ''
    i = 0;
    while s > 0:
        while s >= no_list[i]:
            s -= no_list[i]
            number += roman[i]
        i += 1
    return number

print romanToInt(49)