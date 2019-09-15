import time
movie_duration = [90, 85, 75, 60, 120, 150, 125]
total_duration = 250

def get_pair(lst, d):
    if lst is None or len(lst) == 0:
        return
    
    expected_time = d - 30
    lst.sort()
    x = 0
    y = len(lst)-1
    pair = tuple()
    pair_total = 0
    while x != y:
        left = lst[x]
        right = lst[y]
        total = left + right
        if total > pair_total and total <= expected_time:
            pair_total = total
            pair = (left, right)

        if total < expected_time:
            x += 1
        else:
            y -= 1
    return pair
            

print (get_pair(movie_duration, total_duration))
time.sleep(60)
