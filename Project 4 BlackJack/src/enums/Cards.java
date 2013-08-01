package enums;
public enum Cards {

AceofHearts(11,"3.png"),
AceofDiamonds(11,"4.png"),
AceofSpades(11,"2.png"),
AceofClovers(11,"1.png"),
	
TwoofHearts(2,"51.png"),
TwoofDiamonds(2,"52.png"),
TwoofSpades(2,"50.png"),
TwoofClovers(2,"49.png"),

ThreeofHearts(3,"47.png"),
ThreeofDiamonds(3,"48.png"),
ThreeofSpades(3,"46.png"),
ThreeofClovers(3,"45.png"),

FourofHearts(4,"43.png"),
FourofDiamonds(4,"44.png"),
FourofSpades(4,"42.png"),
FourofClovers(4,"41.png"),

FiveofHearts(5,"39.png"),
FiveofDiamonds(5,"40.png"),
FiveofSpades(5,"38.png"),
FiveofClovers(5,"37.png"),

SixofHearts(6,"35.png"),
SixofDiamonds(6,"36.png"),
SixofSpades(6,"34.png"),
SixofClovers(6,"33.png"),

SevenofHearts(7,"31.png"),
SevenofDiamonds(7,"32.png"),
SevenofSpades(7,"30.png"),
SevenofClovers(7,"29.png"),

EightofHearts(8,"27.png"),
EightofDiamonds(8,"28.png"),
EightofSpades(8,"26.png"),
EightofClovers(8,"25.png"),

NineofHearts(9,"23.png"),
NineofDiamonds(9,"24.png"),
NineofSpades(9,"22.png"),
NineofClovers(9,"21.png"),

TenofHearts(10,"19.png"),
TenofDiamonds(10,"20.png"),
TenofSpades(10,"18.png"),
TenofClovers(10,"17.png"),

JackofHearts(10,"15.png"),
JackofDiamonds(10,"16.png"),
JackofSpades(10,"14.png"),
JackofClovers(10,"13.png"),

QueenofHearts(10,"11.png"),
QueenofDiamonds(10,"12.png"),
QueenofSpades(10,"10.png"),
QueenofClovers(10,"9.png"),

KingofHearts(10,"7.png"),
KingofDiamonds(10,"8.png"),
KingofSpades(10,"6.png"),
KingofClovers(10,"5.png");

private int numVal;
static String filePath = "C:/Users/David/Documents/GitHub/Development/Java/JavaProjects/Project 4 BlackJack/classic-cards"; 
private String imageName;
Cards(int numVal, String imageName)
{
this.numVal = numVal;
this.imageName = imageName;
}
public int getValue()
{
return numVal;
}
public String getPath()
{
	return filePath +"/" +imageName;
}

}
