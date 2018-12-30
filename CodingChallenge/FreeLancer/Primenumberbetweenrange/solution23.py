prime_numbers = []
is_prime = True
for num in range(2, 2001):
    check_till = int(num/2)
    is_prime = True
    for x in range(2, check_till+1):
        if num%x == 0:
            is_prime = False

    if is_prime == True:
        prime_numbers.append(num)

print ('Prime number between 1 to 2000 (including) are')
print (prime_numbers)
print ('Total there are ' +str((len(prime_numbers))) + ' prime numbers')
