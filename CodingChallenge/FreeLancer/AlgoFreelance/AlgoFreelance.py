def fun (positiveList):
  print ("\n" + str(i+1) + ".")
  x = int(input("x = "))
  y = int(input("y = "))
  if x-y > 0:
    positiveList.append(x-y)

count = int(input("How many time do you want to enter x and y value "))
positiveList = [];
for i in range(count):
  fun(positiveList)
print ("\nPositive numbers are "),
print positiveList