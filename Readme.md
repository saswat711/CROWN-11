#Intent:You are expected to build a mobile application which is inspired by Dream 11.
#Links for reference -
https://play.google.com/store/apps/details?id=com.dreamsportsteam.fantasyprediction&hl=en_IN&g
l=US
#Your application is expected to have certain features which are listed down below:

● Login and signup via
- Username - password
- Facebook
- Phone number(OTP)
● Random Dummy match selection (from the JSON’s provided)

● Fantasy team creation based on selected match (players available should be based on the
players belonging to the dummy match JSON, in case the number of players extracted from the
dummy JSON are less than 22 then pick random players from the player list provided)

● Selection of team captain and vice-captain

● Live match display based on selected match -
(as noticed in the dummy JSON, a ball by ball event log has been provided for both innings. Using
these logs you are expected to replicate the live match. Here each ball will have a 5 second gap
to replicate the real nature of the match with each ball thrown, the dashboard has to be updated
automatically without refreshing the page)

● Scoreboard
#Note -

● Team cannot be selected before choosing a dummy match

● Once the match is over, the team should get reset automatically and the next random dummy
match should be selected from the provided JSON.

● Team has to be built using a maximum of 100 credits

● Selecting every player for the team will cost you some credits details regarding which are
provided in the Player list provided

● Each run scored by a player will add 1 point to your teams score

● Bowlers will gain points based on the type of wicket taken. Points for each category are
provided in the events list sheet.

● Points scored by captain will be 2x and points scored by Vice-captain will be 1.5x of the points
scored by them.

● Scoreboard will show the sum of total points scored in all previous matches played by this user
along with a history showing how much scores were gained in which match.