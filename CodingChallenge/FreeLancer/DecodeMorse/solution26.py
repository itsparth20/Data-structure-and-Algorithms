keys_dic = {
    '0': '-----', '1': '.----', '2': '..---', '3': '...--',
    '4': '....-', '5': '.....', '6': '-....', '7': '--...', '8': '---..',
    '9': '----.',

    'a': '.-', 'b': '-...', 'c': '-.-', 'd': '-..', 'e': '.',
    'f': '..-.', 'g': '--.', 'h': '....', 'i': '..', 'j': '.---',
    'k': '-.-', 'l': '.-..', 'm': '--', 'n': '-.', 'o': '---',
    'p': '.--.', 'q': '--.-', 'r': '.-.', 's': '...', 't': '-',
    'u': '..-', 'v': '...-', 'w': '.--', 'x': '-..-', 'y': '-.--',
    'z': '--..',
}


def _decode(string):
    lst = string.split(' ')
    print (lst)
    encode = ''
    i = 0;
    l = len(lst)
    white_space_allow = False
    for encoded_code in lst:
        i += 1
        for key, value in keys_dic.items():
            if value.strip() == encoded_code:
                encode += key
                white_space_allow = False
                break
        else:
            if encoded_code == '':
                if white_space_allow:
                    encode += ' '
                else:
                    white_space_allow = True
            else:
                encode += encoded_code

    print ('Encode String :')
    print (encode)


string = input('Please enter a sentence:')
# decode(string)


def decode(input):
    output_str = ''
    i = 0
    for j in range(0, len(input)):
        if i < len(input):
            for key in keys_dic:
                length = len(' ' + keys_dic[key] + ' ')
                end_i = i + length
                if end_i <= len(input):
                    sub_string = input[i:end_i]
                    if sub_string == (' ' + keys_dic[key] + ' '):
                        i = end_i
                        output_str += key
                        break
            else:
                output_str += input[i]
                i += 1
        else:
            break

    return output_str


print (decode(string))
