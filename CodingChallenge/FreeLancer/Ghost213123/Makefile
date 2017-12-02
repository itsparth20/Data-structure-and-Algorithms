# A simple Makefil
Bard: Bard.class
	echo Main-class: Bard > Manifest
	jar cvfm Bard.jar Manifest Bard.class
	rm Manifest
Bard.class: Bard.java
	javac -Xlint Bard.java
clean:
	rm -f Bard.jar Bard.class
