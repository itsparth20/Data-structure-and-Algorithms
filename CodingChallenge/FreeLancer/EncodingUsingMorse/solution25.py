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


def translate_string(input_str):
    output_str = ''
    for x in input_str:
        if x not in keys_dic:
            output_str = output_str + x

        else:
            output_str = output_str + ' ' + keys_dic[x] + ' '
    print ('Output String :' + output_str)


input_string = input('Please enter sentence: ').strip().lower()
translate_string(input_string)
