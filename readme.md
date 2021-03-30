# A test for Advanced JAVA students

Ši aplikacija yra skirta žmonėms, kurie nori užsisakyti jų mėgstamą picą iš PizzaCodeAcademy restorano.
Picos gali būti trejų dydžių ir nuo dydžio priklauso picos kaina:
* Maža 
* Vidutinė
* Didelė

Jeigu picą užsako studentas ir pateikia studento pažymėjimą, jam taikoma vieno euro nuolaida.

Jeigu asmuo perka daugiau nei tris picas, pigiausia pica atitenka nemokamai.

Restoranas siūlo šias picas:
* Margarita - 3 EUR (maža) / 4 EUR (vidutinė) / 7 EUR (didelė)
* Peperonni - 4 EUR (maža) / 5 EUR (vidutinė) / 8 EUR (didelė)
* Havajų - 4.5 EUR (maža) / 5.5 EUR (vidutinė) / 8.5 EUR (didelė)
* Sočioji - 4.5 EUR (maža) / 5.5 EUR (vidutinė) / 9 EUR (didelė)
* Studentų - 4 EUR (maža) / 5.5 EUR (vidutinė) / 7.5 EUR (didelė)
* Meksikano - 5 EUR (maža) / 6 EUR (vidutinė) / 9 EUR (didelė)
* Vezuvijaus - 4.5 EUR (maža) / 5.5 EUR (vidutinė) / 7.5 EUR (didelė)


##1. Užduotis (50 taškų)
Implimentuokite aukščiau aprašytą sistemą Java aplikacijoje ir panaudokite OOP. Be viso to, 
panaudokite bent vieną abstrakčią klasę ir bent vieną interface. Būtinai panaudokite jau jums duotą kodą.

Pastaba: System.out.printLn() galima naudoti tik Main klasėje.

##2. Užduotis (20 taškų)
Restoranas skirtingomis dienomis atlieka užsakymus produktams, reikalingiems picų gamybai. Uzsakymai atliekami šiomis dienomis:
* Margarita - užsakymai neatliekami (produktai lieka nuo kitų picų)
* Peperonni - kiekvieną pirmadienį
* Havajų ir Meksikano - kiekvieną trečiadienį
* Sočioji ir Studentų - kiekvieną penktadienį
* Vezuvijaus - kiekvieną šeštadienį

Sistema turi sugebėti grąžinti picų sąrašą toms picoms, kurioms reikia užsakymą atlikti šiandien arba pagal duotą datą.
Panaudokite jums jau duotas funckijas.


##3. Užduotis (5 taškai)
Picerijos savininkai nori žinoti, kokia buvo mėnesio apyvarta. Taip pat nori žinoti, kiek lankytojų buvo studentai. Panaudokite jau duotas funkcijas.

##4. Užduotis (10 taškų)
Tam, kad geriau pažintų savo klientus, restorano savininkai nori pamatyti vidutinį užsakymo dydį. (1)
Restoranų versle laikotarpiai gali būti sunkūs, tad savininkai nori pamatyti vidutinį užsakymo dydį
nurodytu periodu (pvz. turim 3 picas, viena iš jų buvo užsakyta 2021 sausį o kitos dvi tų pačių metų vasarį. Norim paduoti į funkciją mėnesį ir metus
ir pagal tai apskaičiuoti vidutinį užsakymo dydį pagal duotą periodą) (2).

##5. Užduotis (5 taškai)
Parašyti jUnit testus 4 ir 5 užduočiai
