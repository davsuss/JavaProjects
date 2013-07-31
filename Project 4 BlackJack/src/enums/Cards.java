package enums;
public enum Cards {

AceofHearts(11),
AceofDiamonds(11),
AceofSpades(11),
AceofClovers(11),
	
TwoofHearts(2),
TwoofDiamonds(2),
TwoofSpades(2),
TwoofClovers(2),

ThreeofHearts(3),
ThreeofDiamonds(3),
ThreeofSpades(3),
ThreeofClovers(3),

FourofHearts(4),
FourofDiamonds(4),
FourofSpades(4),
FourofClovers(4),

FiveofHearts(5),
FiveofDiamonds(5),
FiveofSpades(5),
FiveofClovers(5),

SixofHearts(6),
SixofDiamonds(6),
SixofSpades(6),
SixofClovers(6),

SevenofHearts(7),
SevenofDiamonds(7),
SevenofSpades(7),
SevenofClovers(7),

EightofHearts(8),
EightofDiamonds(8),
EightofSpades(8),
EightofClovers(8),

NineofHearts(9),
NineofDiamonds(9),
NineofSpades(9),
NineofClovers(9),

TenofHearts(10),
TenofDiamonds(10),
TenofSpades(10),
TenofClovers(10),

JackofHearts(10),
JackofDiamonds(10),
JackofSpades(10),
JackofClovers(10),

QueenofHearts(10),
QueenofDiamonds(10),
QueenofSpades(10),
QueenofClovers(10),

KingofHearts(10),
KingofDiamonds(10),
KingofSpades(10),
KingofClovers(10);

private int numVal;
Cards(int numVal)
{
this.numVal = numVal;
}
public int getValue()
{
return numVal;
}
}
