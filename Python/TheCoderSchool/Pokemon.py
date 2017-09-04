
#PokemonAdventures by Lorenzo Uk
import random
from time import sleep

class Player:
  def __init__(self, name, pokeballs, money, postions, pokemon)
    self.name = name
    self.pokeballs = pokeballs
    self.money = money
    self.pokemon = pokemon

class NPC:
  def __init__(self, name, money, pokemon)
    self.name = name
    self.pokeballs = pokeballs
    self.money = money
    self.pokemon = pokemon  

class Move:
  def __init__(self, name, dmg, lmt, acc, move_type):
    self.name = name 
    self.dmg = dmg
    self.lmt = lmt
    self.acc = acc
    self.move_type = move_type
  def use_on(self, pokemon):
    if random.random() < self.acc:
      pokemon.heath = pokemon.health - self.dmg
      print("The Attack Hit!")
    else:
      print("The Attack Missed")
  
  
class Pokemon:
	def __init__(self,name,pokemon,health,typeOfPokemon,moves):
	  self.name = name
	  self.pokemon = pokemon
	  self.health = health
	  self.typeOfPokemon = typeOfPokemon
	  self.moves = moves
	def attack(self,move,opp):
	  if move in self.moves:
	    move.use_on(opp)
	  else:
	    print("You can't use this move!")
	    
class WildPokemon(Pokemon):
  def __init__(self,name,pokemon,health,typeOfPokemon,moves,encounterRate,catchRate):
    super().__init__(name,pokemon,health,typeOfPokemon,moves)
    self.encounterRate = encounterRate
    self.catchRate = catchRate

#CheckIfUserCanUseAMoveInTheRightList
def checkPokemonMoves(moveObjectList,moveName):
  for i in moveObjectList:
    if(i.name == moveName.title()):
      return True
  return False

#GetPokemonBeforeCheckingLmt
def getPokemon(moveObjectList,moveName):
  for i in moveObjectList:
    
    if(i.name == moveName.title()):
      return i
  return None
  
#GetRandomMoveName
def getMoveName(moveObjectList):
  oppindex = random.randint(0,len(moveObjectList)-1)
  return moveObjectList[oppindex]

#HitOrMissOrCriticalSquirtle
def findAcc(accurcy):
  ran = random.randint(1,100)
  #print("Your random number is: " + str(ran))
  total = accurcy+ran
  if(total >= 150):
    return 2
  elif (total >= 100):
    return 1
  else:
    return 0
#GetHealth
def getHealth(ownerSelectedPokemon, oppPokemonhealth):
  hitAcc = findAcc(ownerSelectedPokemon.acc*100)
  if(hitAcc == 2):
    print("Critical Hit!")
    return oppPokemonhealth - ownerSelectedPokemon.dmg*2
  elif(hitAcc == 1):
    return oppPokemonhealth - ownerSelectedPokemon.dmg
  else:
    print("The Pokemon avoided the attack!")
    return oppPokemonhealth
#GetRoute
def getRoute():
  routeSelector = False
  while(not(routeSelector)):
    route = input("Gale Forest or Hog Peak: ")
    if(route == "Gale Forest"):
      routeSelector = True
      print("You have entered " + route)
      goToGale()
    elif(route == "Hog Peak"):
      routeSelector = True
      print("You are now climbing " + route)
    else:
      print("You can't travel there!")
    
  return route
      
def goToGale():
  print("")
  print("You find a pit of tall grass")
  print("Whats inside there?")
  
  
  
  
  
#Moves
#GrassType
vine_whip = Move("Vine Whip", 45, 8, 1, "Grass")
razor_leaf = Move("Razor Leaf", 55, 5, 0.9, "Grass")
solar_beam = Move("Solar Beam", 120, 2, 0.5, "Grass")
#FireType
ember = Move("Ember", 40, 8, 0.9, "Fire")
flamethrower = Move("Flamethrower", 100, 2, 0.7, "Fire")
#WaterType
water_gun = Move("Water Gun", 40, 8, 1, "Water")
hydro_pump = Move("Hydro Pump", 110, 2, 0.6, "Water")
water_pulse = Move("Water Pulse", 60, 5, 0.8, "Water")
#NormalType
scratch = Move("Scratch", 40, 10, 1, "Normal")
tail_slap = Move("Tail Slap", 55, 8, 1, "Normal")
hyper_beam = Move("Hyper Beam", 150, 2, 0.4, "Normal")
tackle = Move("Tackle", 40, 10, 1, "Normal")
#GroundType
sand_attack = Move("Sand Attack", 60, 5, 0.9, "Ground")
#DragonType
dragon_claw = Move("Dragon Claw", 60, 5, 1, "Dragon")
#DarkType
bite = Move("Bite", 50, 10, 1, "Dark")
#BugType
bug_bite = Move("Bug Bite", 60, 10, 1, "Bug")
bug_buzz = Move("Bug Buzz", 100, 2, 0.5, "Bug")
#ElectricType
thunderbolt = Move("Thunderbolt", 100, 2, 0.6, "Electric")
electro_ball = Move("Electro Ball", 90, 5, 0.8, "Electric")
#SteelType
iron_tail = Move("Iron Tail", 80, 8, 0.9, "Steel")
#PsychicType
psychic = Move("Psychic", 150, 2, 1, "Psychic")
psybeam = Move("Psybeam", 90, 5, 0.6, "Psychic")
zen_headbutt = Move("Zen Headbutt", 80, 8, 0.7, "Psychic")


#Pokemon
bulbasaur_moves = [vine_whip,razor_leaf,solar_beam,tackle]
bulbasaur = Pokemon("", "Bulbasaur", 245, "Grass", bulbasaur_moves)

charmander_moves = [ember,flamethrower,scratch,dragon_claw]
charmander = Pokemon("", "Charmander", 239, "Fire", charmander_moves)

squirtle_moves = [water_gun,water_pulse,hydro_pump,tackle]
squirtle = Pokemon("", "Squirtle", 244, "Water", squirtle_moves)

eevee_moves = [tackle,tail_slap,sand_attack,hyper_beam]
eevee = Pokemon("", "Eevee", 255, "Normal", eevee_moves)

#WildPokemonGaleForest
rattata_moves = [tackle,tail_slap,hyper_beam,bite]
rattata = WildPokemon("", "Rattata", 130, "Normal", rattata_moves, 70, 90)

metapod_moves = [bug_bite,tackle,razor_leaf,bug_buzz]
metapod = WildPokemon("", "Metapod", 90, "Bug", metapod_moves, 80, 100)

pikachu_moves = [thunderbolt,electro_ball,tackle,iron_tail]
pikachu = WildPokemon("", "Pikachu", 235, "Electric", pikachu_moves, 20, 50)

abra_moves = [psychic,psybeam,zen_headbutt,thunderbolt]
abra = WildPokemon("", "Abra", 225, "Psychic", abra_moves, 10, 20)

#Player
brian = Player("Brian", 0, 0, 0, 0)
#NPC
gabe = NPC("Gabe", 999999999999, 0)
john = NPC("John", 999999999999, 0)
marina = NPC("Marina", 999999999999, 0)
#NPCTeamAlphaLeader
profflycran = NPC("Proffesor Lycran", 999999999999, 6)
#NPCTeamAlphaAdmins
alphaaben = NPC("Team Alpha Admin Ben", 999999999999, 6)
alphaajeffery = NPC("Team Alpha Admin Jeffery", 999999999999, 6)
#NPCTeamAlphaManagers
alphamralph = NPC("Team Alpha Manager Ralph", 999999999999, 5)
alphamanais = NPC("Team Alpha Manager Anais", 999999999999, 5)
alphamcristian = NPC("Team Alpha Manager Cristian", 999999999999, 5)
#NPCTeamAlphaElites
alphaegreg = NPC("Team Alpha Elite Greg", 999999999999, 3)
alphaechris = NPC("Team Alpha Elite Chris", 999999999999, 3)
alphaecristian = NPC("Team Alpha Manager Cristian", 999999999999, 3)
alphaeralph = NPC("Team Alpha Manager Ralph", 999999999999, 3)
alphaeanais = NPC("Team Alpha Manager Anais", 999999999999, 3)
alphaecristian = NPC("Team Alpha Manager Cristian", 999999999999, 3)
#NPCTeamAlphaMembers




#StartOfAdventure
print("Today you get to pick your first pokemon!")
print("You can choose 3 different breeds\n")

#AskForAStarter
choosePokemon = input(bulbasaur.pokemon + " " + charmander.pokemon + " " + squirtle.pokemon)
your_pokemon = None

#IfYouChooseAnyTheseMightHappen
if (choosePokemon == bulbasaur.pokemon):
	print("You choose " + bulbasaur.pokemon + ", the Grass type")
	your_pokemon = bulbasaur
	
elif(choosePokemon == charmander.pokemon):
	print("You choose " + charmander.pokemon + ", the Fire type")
	your_pokemon = charmander
	
elif(choosePokemon == squirtle.pokemon):
	print("You choose " + squirtle.pokemon + ", the Water type")
	your_pokemon = squirtle

else:
	print("Invalid Starter Pokemon of Gen.1")
	quit()
print("")

print("Exellent Choice!\n")

print("Now your friend, Gabe wants to battle\n")

print("Gabe sends out " + eevee.pokemon + "!\n")

print("You send out " + your_pokemon.pokemon + "!\n")

ownerPokemon = your_pokemon
oppPokemon = eevee

#Battleing
ownerPokemonhealth = ownerPokemon.health
oppPokemonhealth = oppPokemon.health

#StartsBattle
while(ownerPokemonhealth > 0 and oppPokemonhealth > 0):
  ownerPokemonMovelmt = False
  oppPokemonMovelmt = False
  while(not oppPokemonMovelmt):
    print("")
    print("What should " + ownerPokemon.pokemon + " do?" )
    #PrintsPokemonMoves
    for i in ownerPokemon.moves:
      print (i.name)
    moveName = input()
    print("")
    #CheckLmt
    moveNameIsthere = checkPokemonMoves(ownerPokemon.moves,moveName)
    if(moveNameIsthere):
      ownerSelectedPokemon = getPokemon(ownerPokemon.moves,moveName)
      if(ownerSelectedPokemon.lmt == 0):
        print("You can't use this move!")
        continue
      #CheckAccForOwner
      oppPokemonhealth = getHealth(ownerSelectedPokemon, oppPokemonhealth)
      ownerSelectedPokemon.lmt -= 1
      print((ownerPokemon.pokemon) + " used " + (moveName))
      #OppPokemonTakesDmg
      if(oppPokemonhealth <= 0):
        oppPokemonhealth = 0
      print("")
      print("Eevee's HP is now " + str(oppPokemonhealth))
    ownerPokemonMovelmt = True
    #OppPokemonLmtCheck
    while(not oppPokemonMovelmt):  
      if(oppPokemonhealth > 0 and ownerPokemonhealth > 0):
        oppPokemonMoveName = getMoveName(oppPokemon.moves)
        print("The Opposing " + oppPokemon.pokemon + " used " + (oppPokemonMoveName.name))
        #OppPokemonAttacks
        if(oppPokemonMoveName.lmt == 0):
          print("The Opposing Pokemon tried to use a move but it failed!")
          continue
        oppPokemonMoveName.lmt -= 1 
        #CheckLmtForOpp
        ownerPokemonhealth = getHealth(oppPokemonMoveName, ownerPokemonhealth)

        if(ownerPokemonhealth <= 0):
          ownerPokemonhealth = 0
        print("")
        print((ownerPokemon.pokemon) + " HP is now " + str(ownerPokemonhealth))
      oppPokemonMovelmt = True

if(ownerPokemonhealth == 0):
  print(ownerPokemon.pokemon + " fainted!")
else:
  print("The opposing " + oppPokemon.pokemon + " fainted!")

if(ownerPokemonhealth == 0):
  print("Gabe won the Match!")
else:
  print("You won the match!")
print("")
print("Gabe heals your pokemon")
print("")
print("Your " + (ownerPokemon.pokemon) + " restored " + " from " + str(ownerPokemonhealth) + " to " + str(ownerPokemon.health) + " HP")

print("Now your parents let you adventure on your own!")
print("Gabe gives you 10 Pokeballs")
print("Choose a Route!")
print("")

route = getRoute()