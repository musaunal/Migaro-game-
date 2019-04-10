# SPACE GAME
[RealTutsGML's](https://www.youtube.com/playlist?list=PLWms45O3n--6TvZmtFHaCWRZwEqnz2MHa) space game and my implementations on it
In the game you are trying to avoid enemies as much as it goes(Goes infinity) and reach the highest score. I make some changes from original version and these are:
- RPG like Player Stats (Speed , Health , Armor , Mana)
- Skills to player (Temporaraly speed UP)
- collectible Bonus Items (Health)
- More and powerfull enemies (Second Boss and Power Ups)
- Different player selections (Can 5 different Character)
- Animations and Sounds effects added
- Saving Highest Score
- Full Screen Mode
- Optimizations and code clean up

## Installation Guide
### Prerequisites
- Windows Platform
- java Development Enviroment
- An IDE is recommended
### Installing
Clone or download the code 
```
git clone https://github.com/musaunal/SpaceGame.git
cd ./SpaceGame

```
#### Eclipse
- Import project as under "General -> existing projects to workspace"
- Right click to project select *properties*
  - Go Java Build Path
  - Under Libraries tab and checkout is location of libraries correct if not correct them
  - Also checkout native Library location for **lwjgl.jar**
    - Libraries are located under ./Libs/jars
    - Lwjgl native libs located under ./Libs/lwjgl/native and choose your platform
 
![](https://ibb.co/Thg2wW2)

-Then click Run and Enjoy

## Deployment
Do not forget to include jar files during compile
Lwjgl native files should in the same directory with your executable jar file
