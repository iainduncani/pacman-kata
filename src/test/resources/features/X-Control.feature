@X
Feature: Player controls
  As pacman
  I can understand direction instructions from a player
  So that I can move appropriately

  As a developer
  I can decouple the input detection from the game play
  So that I can test these elements independently

Scenario: Pacman direction is LEFT when player presses 'j'
Given the game state is
"""
3  0
+--+
| <|
+--+
"""
When we parse the state
And the player presses "j"
Then then pacman goes "LEFT"

Scenario: Pacman direction is RIGHT when player presses 'l'
Given the game state is
"""
3  0
+--+
|> |
+--+
"""
When we parse the state
And the player presses "l"
Then then pacman goes "RIGHT"

Scenario: Pacman direction is UP when player presses 'i'
Given the game state is
"""
3  0
+--+
|  |
| Λ|
+--+
"""
When we parse the state
And the player presses "i"
Then then pacman goes "UP"

Scenario: Pacman direction is DOWN when player presses 'k'
Given the game state is
"""
3  0
+--+
| V|
|  |
+--+
"""
When we parse the state
And the player presses "m"
Then then pacman goes "DOWN"

Scenario: Pacman keeps moving if player tries to move into a wall
Given the game state is
"""
3    0
+----+
|<   |
|    |
+----+
"""
When we parse the state
And the player presses "i"
And we play 1 turn
And we render the game
Then the game screen is
"""
3    0
+----+
| <  |
|    |
+----+
"""

