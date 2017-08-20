from turtle import *


digit = ""
screen = Screen()
math_turtle = Turtle()
math_turtle.penup()
math_turtle.goto(20,90)
answer=0
number=0
index = 0
signIndex = 0
number2 = 0
def on_click_digit(x,y):
  global digit
  global number
  global index
  global signIndex
  global number2
  index += 1
  if (x>0 and x<70 and y>25 and y<80):
    digit = digit + "1"
    
  if (x>70 and x<140 and y>25 and y<80):
    digit = digit + "2"
  if (x<210 and x>140 and y>25 and y<80):
    digit = digit + "3"
 
  if (x<210 and x>140 and y>-35 and y<25):
    digit = digit + "6"

  if (x<140 and x>70 and y>-35 and y<25):
    digit = digit + "5"
 
  if (x>0 and x<70 and y>-35 and y<25):
    digit = digit + "4"

  if (x>0 and x<70 and y>-90 and y<-30):
    digit = digit + "7"

  if (x>70 and x<140 and y>-90 and y<-30):
    digit = digit + "8"
 
  if (x>140 and x<210 and y>-90 and y<-30):
    digit = digit + "9"
    
  if (x>70 and x<140 and y>-117.5 and y<-90):
    digit = digit + "0"
    
  if (x>140 and x<210 and y>-117.5 and y<-90):
    number = int(digit) 
    digit = digit + "x"
    signIndex =  index

  if (x>140 and x<210 and y>-150 and y<-124.5):
    number2 = int(digit[signIndex:])
    digit = digit + "="
    ch = digit[signIndex-1:signIndex]
    calculator(ch,number,number2)
    
    
    
  if (x>0 and x<70 and y>-117.5 and y<-90):
    number = int(digit)
    digit = digit + "+"
    signIndex =  index

  if (x>70 and x<140 and y>-150 and y<-124.5):
    number = int(digit)
    digit = digit + "/"
    signIndex =  index
    
  if (x>0 and x<70 and y>-150 and y<-124.5):
    number = int(digit) 
    digit = digit + "-"
    signIndex =  index
    
  math_turtle.goto(10 , 130)
  math_turtle.write(digit)

def calculator(ch,digit1,digit2):
  if(ch=="+"):
    math_turtle.goto(100 , 130)
    math_turtle.write(str(digit1+digit2))
  if(ch=="-"):
    math_turtle.goto(100 , 130)
    math_turtle.write(str(digit1-digit2))
  if(ch=="x"):
    math_turtle.goto(100 , 130)
    math_turtle.write(str(digit1*digit2))
  if(ch=="/"):
    math_turtle.goto(100 , 130)
    math_turtle.write(str(digit1/digit2))
    
screen.onclick(on_click_digit)
for x in range(0,1000):
  speed(0)
  penup()
  goto(0,-150)
  pendown()
  forward (200)
  left(90)
  forward (300)
  left(90)
  forward (200)
  left(90)
  forward (300)
  left(90)
  
  penup()
  goto(0,80)
  pendown()
  
  forward(200)
  
  penup()
  goto(66.67,80)
  pendown()
  
  right(90)
  forward(230)
  
  penup()
  goto(133.34,80)
  pendown()
  
  forward(230)
  
  penup()
  goto(0,24)
  pendown()
  
  left(90)
  forward(200)
  
  penup()
  goto(0,-30)
  pendown()
  
  forward(200)
  
  penup()
  goto(0,-90)
  pendown()
  
  forward(200)
  
  penup()
  goto(20,-20)
  pendown()
  
  write ("4", font = ("Arial", 35))
  
  penup()
  goto(90,-20)
  pendown()
  write ("5", font = ("Arial", 35))
  
  
  penup()
  goto(150,-20)
  pendown()
  write ("6", font = ("Arial", 35))
  
  penup()
  goto(150,-80)
  pendown()
  write ("9", font = ("Arial", 35))
  
  penup()
  goto(20,30)
  pendown()
  write ("1", font = ("Arial", 35))
  
  penup()
  goto(90,30)
  pendown()
  write ("2", font = ("Arial", 35))
  penup()
  goto(150,30)
  pendown()
  write ("3", font = ("Arial", 35))
  
  
  
  
  penup()
  goto(90,-80)
  pendown()
  write ("8", font = ("Arial", 35))
  penup()
  goto(20,-80)
  pendown()
  write ("7", font = ("Arial", 35))
  penup()
  goto(0,-120)
  pendown()
  forward(200)
  
  penup()
  goto(30,-120)
  pendown()
  write ("+", font = ("Arial", 30))
  
  penup()
  goto(90,-145)
  pendown()
  write ("/", font = ("Arial", 25))
  
  penup()
  goto(90,-115)
  pendown()
  write ("0", font = ("Arial", 25))
  
  penup()
  goto(160,-115)
  pendown()
  write ("x", font = ("Arial", 25))
  
  penup()
  goto(30,-145)
  pendown()
  write ("-", font = ("Arial", 25))
  penup()
  goto(160,-145)
  pendown()
  write ("=", font = ("Arial", 25))
  
  penup()
  goto(20,90)
  pendown()
  
  
  
  answer = int(input("Enter one number?")) 
  answer1= int(input("Enter second number?"))

  print("1. Addition")
  print("2. Subtraction")
  print("3. Multiplication")
  print("4. Division")
  print("Enter Your Choices?")
  Choice= input().lower()
  if(Choice == "addition" or Choice == "1" or Choice == "+"):
    write(answer + answer1, font = ("Arial", 20))
  if(Choice == "subtraction" or Choice == "2" or Choice == "-"):
    write(answer - answer1, font = ("Arial", 20))
  if(Choice == "division" or Choice == "4" or Choice == "/"):
    write(answer / answer1, font = ("Arial", 20))
  if(Choice == "multplication" or Choice == "3" or Choice == "*"):
    write(answer * answer1, font = ("Arial", 20))
  print("Would you like to continue? Yes/No")
  answer4 = input()
  if(answer4 == "Yes"):
    reset()
  
  if(answer4 == "No"):
    break
  
