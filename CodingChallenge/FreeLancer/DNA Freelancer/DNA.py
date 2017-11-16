
species1 = input("Etner Species 1:")
species2 = input("Etner Species 2:")

print("You can do following operation on species")

while (True):
  print('''
  "a" for add
  "d" for delete
  "s" for score
  "q" for quit
  
  ''')
  
  

  choice = input("Enter your choice: ");
  if(choice == "q"):
    print("bye")
    break
  
  elif(choice == "a"):
    print("\nWhich Species you want to change.....?")
    print("1. " + species1)
    print("2. " + species2)
    number = int(input())
    default = ""
    if(number == 1):
      default = species1
    else:
      default = species2
    
    index = int(input("At what index do you want to make changes:"))
    if(index > len(default) or index < 0):
      print ("\nError: index out of range")
      continue
    default = default[0:index] + "-" + default[index:]
    if(number == 1):
      species1 = default
    else:
      species2 = default
    print ("\nSpecies now: " + default)
    
  elif(choice == "d"):
    print("\nWhich Species you want to change.....?")
    print("1. " + species1)
    print("2. " + species2)
    number = int(input())
    default = ""
    if(number == 1):
      default = species1
    else:
      default = species2
    
    index = int(input("At what index do you want to make changes:"))
    if(index > len(default) or index < 0):
      print ("\nError: index out of range")
      continue
    if(default[index] != "-"):
      print("\nError to delete a character that is not an indel.")
      continue
    default = default[0:index] + default[index+1:]
    if(number == 1):
      species1 = default
    else:
      species2 = default
    print ("\nSpecies now: " + default)
    
  elif choice == "s":
    size = 0
    if len(species1) < len(species2):
      size = len(species1)
      big = len(species2)
      for i in range(size, big):
        species1 = species1 + "-"
    else:
      size = len(species2)
      big = len(species1)
      for i in range(size, big):
        species2 = species2 + "-"
    
    
    default1 = species1.lower()
    default2 = species2.lower()
    str1= ""
    str2 = ""
    for i in range(len(default1)):
      if ( (default1[i] != '-') and (default2[i] != "-") and (default1[i] == default2[i]) ):
        str1 += default1[i].lower()
        str2 += default2[i].lower()
      else:
        str1 += default1[i].upper()
        str2 += default2[i].upper()
    print "\n------------------------score------------------------"
    print str1
    print str2