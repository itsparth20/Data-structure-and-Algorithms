# Q1. Given a string. Find distance of all characters from a target character. 
# For example, "Google", target character= 'g', then result will be [0,1,1,0,1,2]
import sys
def find_sortest_dist(input, ch):
    if input is None or input.strip() == '':
        return []    
    lower_ch = ch.strip().lower()
    lower_input = input.strip().lower()    
    sum_from_left = find_total_count(lower_input, lower_ch)
    sum_from_right = find_total_count(lower_input[::-1], lower_ch)[::-1]

    arr = []
    for i in range(0, len(sum_from_left)):
        arr.append(min(sum_from_left[i], sum_from_right[i]))
    print (arr)
    return arr
 

def find_total_count(lower_input, lower_ch):
    count_from_left = []
    if lower_input[0] == lower_ch:
        count_from_left.append(0)
    else:
        count_from_left.append(sys.maxsize)
    
    for x in range(1, len(lower_input)):
        if lower_input[x] == lower_ch:
            count_from_left.append(0)
        else:
            count_from_left.append(count_from_left[x-1]+1)
    return count_from_left


actual_1 = find_sortest_dist('Google', 'g')
expected_1 = [0, 1, 1, 0, 1, 2]
if actual_1 != expected_1:
    raise ValueError("find_sortest_dist('Google', 'g') answer is wrong")
