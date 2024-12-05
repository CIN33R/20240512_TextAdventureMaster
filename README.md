# Text Adventure Master

## Overview
Text Adventure Master template is an interactive text-based game where players navigate a series of choices to explore a story and complete various challenges. Built with Java, this project is designed to help developers learn more about designing interactive stories, managing game states, and developing compelling narratives in a simple but engaging format.

This project serves as a template for students to start building their own text adventure games. Students will use this template to implement the core game features and fulfill the requirements outlined in the project assignment.

## Features
- Rich storytelling with branching paths based on player choices.
- A dynamic inventory system to manage items found throughout the game.
- Simple and modular code structure for easy understanding and modification.
- Saving and loading of game states to allow players to continue their adventures at any time.

## Assignment Requirements
### Requirement One: Basic Commands
All students must implement the following basic commands:
- **GO**: Move between locations in the game.
- **QUIT**: Exit the game.
- **HELP**: Display a list of available commands.
- **GRAB**: Pick up an item.
- **DROP**: Drop an item from the inventory.
- **LOOK**: Get a description of the current location or object.

### Custom Commands
Students are also required to add at least three unique commands specific to their game. Each command should:
- Perform an action beyond displaying text, such as invoking methods, running code, or changing variables.
- Interact with the game environment, such as unlocking areas, interacting with items, or affecting player status.
- Add depth to the gameplay, such as "USE KEY" to unlock a door or "CAST SPELL" to interact with magical objects.

### Requirement Two: Locations
Students must design five unique locations for their game. For each location, provide:
- **Location Name**: A unique and descriptive name.
- **Short Description**: A brief 1-2 sentence description that players see upon entering.
- **Long Description**: A detailed paragraph describing the appearance and atmosphere of the location, including clues about items or paths to explore.
- **Special Interactions or Hints**: Specific items, clues, or directional hints relevant to the location.

### Requirement Three: Room Map
Students should create a map showing how the rooms connect. The map should indicate each room's position, connections, and movement directions. Creative directions, such as "GO PORTAL" for a magical gateway or "GO STAIRS" for moving between levels, are encouraged. The map can be hand-drawn or created digitally, and should clearly show pathways and connections.

### Documentation Submission
Students must submit their completed game design documentation, which includes the map, commands, and location descriptions. This serves as the blueprint for their game.

## Getting Started
To get started with Text Adventure Master, you will need Java 8 or above installed on your machine.

## How to Play
- Upon starting the game, you will be prompted with a narrative and a series of options to choose from.
- Enter the number corresponding to your choice and press "Enter".
- Use choices to navigate through the game, solve puzzles, and make decisions that affect the storyline.
- You can save your progress by selecting the "Save Game" option whenever it appears.

## Project Structure
The project is organized as follows:
- **src/**: Contains all the source files for the game.
    - **com.textadventure**: Core package containing classes for game logic, player interactions, and the story flow.
      - **Game**: Manages the overall game flow, including initialization, the main game loop, and termination procedures.
      - **Player**: Represents the player character, handling attributes such as health, inventory, and actions the player can perform.
      - **Room**: Defines the various rooms or locations within the game world, including descriptions, items present, and connections to other rooms.
      - **Item**: Represents objects that the player can interact with or collect during the game, including their properties and potential uses.
      - **Parser**: Interprets and processes player input, translating textual commands into in-game actions.
      - **Command**: Encapsulates player commands, including the command word and any associated parameters.
      - **CommandWords**: Maintains a list of valid command words that the game recognizes and can process. 
      - **bin/**: Compiled Java files.

## A Light-Hearted Joke to Brighten Your Day
Why do Java developers wear glasses? Because they don't see sharp!

Enjoy your adventure!
