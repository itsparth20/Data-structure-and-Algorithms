occurrence = {}
given_list = [ 3, 4, 4, 7, 9, 5, 2, 3, 1, 4, 0, 8, 4, 3, 3, 4, 4, 2, 4, 9, 6, 0, 9, 0, 7, 5, 5, 1, 9, 6, 6, 8, 4, 1, 2, 9, 9, 2, 9, 5, 5, 9, 5, 6, 5, 1, 7, 2, 2, 5, 4, 2, 8, 1, 3, 1, 5, 2, 1, 3, 7, 6, 0, 8, 3, 4, 3, 2, 1, 4, 2, 1, 7, 0, 6, 9, 1, 7, 3, 5, 9, 2, 7, 4, 7, 1, 1, 8, 4, 3, 9, 3, 5, 2, 5, 0, 6, 7, 1]


def calculate_list_elements(given_list):
    for i in range(0, len(given_list)):
        num = given_list[i]
        if num not in occurrence:
            occurrence[num] = 1
        else:
            occurrence[num] = occurrence[num] + 1

    for key, value in occurrence.items():
        print (str(key) + ' has been occurred ' + str(value) + ' time in a list')


calculate_list_elements(given_list)
