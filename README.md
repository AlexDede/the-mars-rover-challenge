## The Mars Rover Challenge

####Assumptions:
<ol>
<li>The program will display an error when the rover's next step is impossible due to the fact this next step will result in rover going beyond the plateau. Also, the following rovers will not be processed</li>
<li>Assuming that an unlimited number of rovers can be on the plateau, the program will show an error when the next rover's step is impossible due to the fact that this next spot is already occupied by another rover. All following rovers will not be processed.</li> 
<li>Given that the second rover won't start to move until the first one has finished moving, then we assume that all rovers cannot start from the same position. 
<li>An error message will be displayed if NASA sends an unexpected string of letters to rovers (other from 'L', 'R' and 'M'. 'L')</li>
<li>I assume that each rover will always have two lines of input corresponding to it (under two lines I mean position and command)</li>
<li>The program will be printing the results right after each rover completes his movement.</li>
</ol>

####Requirements:
<ol>
<li>Java 1.8+</li>
<li>Maven 3.6+</li>
</ol>

####How to build and run application

1. ```mvn clean package```
2. ```java -jar ./target the-mars-rover-challenge.jar <full path to the file with input data>.txt```

File sample you can find in the root of the repository (sample-data.txt)

Example:
```bash
   mvn clean install
   java -jar ./target/the-mars-rover-challenge.jar ./sample-data.txt
```