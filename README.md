# SPACE GAME
[RealTutsGML's](https://www.youtube.com/playlist?list=PLWms45O3n--6TvZmtFHaCWRZwEqnz2MHa) space game and my implementations on it.

In the game you are trying to avoid enemies as much as it goes(Goes infinity) and reach the highest score. I make some changes from original version and these are:
- RPG like Player Stats (Speed , Health , Armor , Mana)
- Skills to player (Temporaraly speed UP)
- collectible Bonus Items (Health)
- More and powerfull enemies (Second Boss and Power Ups)
- Different player selections (Can select 5 different Character)
- Animations and new sounds effects added
- Saving Highest Score
- Full Screen Mode
- Optimizations and code clean up

## Installation Guide
### Prerequisites
- java Development Enviroment
- Libraries (Lwjgl ,jinput, jogg, jorbis)
- An IDE is recommended
### Installing
Clone or download the code 
```
git clone https://github.com/musaunal/SpaceGame.git

```
#### Eclipse
- Import project as under "General -> existing projects to workspace"
- Right click to project select *properties*
  - Go Java Build Path
  - Under Libraries tab and checkout is location of libraries correct if not correct them
  - Also checkout native Library location for **lwjgl.jar**
    - Libraries are located under ./Libs/jars
    - Lwjgl native libs located under ./Libs/lwjgl/native and choose your platform
 
![](https://i.ibb.co/R0Vjh8G/Libarires-of-Space-Game.png)     ![](https://i.ibb.co/dD4bZhV/Libarires-of-Space-Game0.png)

-Then click Run and Enjoy

#### Build and run From scratch
```
cd ./SpaceGame
javac -cp bin:lib/parserlib.jar:lib/physics.jar:/Libs/jars/*.jar src/com/tutorial/main/*.java
java -cp bin:lib/parserlib.jar:lib/physics.jar:/Libs/jars/*.jar bin/com/tutorial/main/TheGamee 
```

## Deployment
- A ready to run version is located under *CompiledVersion* folder (For Windows)
- Do not forget to include jar files during compile
- Lwjgl native files should in the same directory with your executable jar file

# Screenshots
![](https://i.ibb.co/Lk3M0cY/Space-Game-menu1.png)
![](https://i.ibb.co/M1rgTYZ/Space-Game-menu2.png)
![](https://i.ibb.co/M9Z85KT/Space-Game-menu3.png)
![](https://i.ibb.co/1QHQHch/Space-Game-ingame1.png)
![](https://i.ibb.co/K2Yv0gW/Space-Game-ingame2.png)
![](https://i.ibb.co/WFsD1TX/Space-Game-ingame3.png)
