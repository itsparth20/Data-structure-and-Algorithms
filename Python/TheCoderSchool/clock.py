from turtle import Turtle
x = Turtle()
x.penup()
x.speed(0)
time = 12;
for i in range(360):
	x.forward(2)
	x.right(1)
	if(i%30 == 0):
		x.write (str(time), font = ("Anton", 10))
		time = time%12 + 1