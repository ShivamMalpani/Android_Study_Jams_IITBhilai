About NSO: 
National Sports Organisation is intended by the Government of India to promote the development of athletics and sporting activities of the nation's youth.
It is present in many important institutions of India such as the IITs and IIMs.
(Source: Wikipedia)

Every NSO student is required to finish 8 credits in four years. Each credit is equivalent to 15 hours of physical activity. We must register for credits that we plan to accomplish in that semester prior to the start of the semester (usually 1-3).
Sports coordinators keep track of which students registered for how many credits and played how many hours each day, and then add that number of hours to their account.

Problem statement: We are not allowed to register for multiple nso sports in the same semester. This is due to the fact that different coordinators supervise different sports, and keeping track of all students' hours is difficult if anyone is allowed to play any game on any day.

Solution: Our app would track the hours finished by each individual, and the coordinators would update the hours of each individual who played their game that day. As a result, more kids would be able to explore and participate in a wider range of sports if they so desired.


Functionality and Concepts used:
The App has a very simple and interactive interface which helps the students select their route bus and track its location. Following are few android concepts used to achieve the functionalities in app :
Constraint Layout : Most of the activities in the app uses a flexible constraint layout, which is easy to handle for different screen sizes.
Simple & Easy Views Design : Use of familiar audience EditText with hints and interactive buttons made it easier for cordinators to use. Apps also uses App Navigation to switch between different screens.
RecyclerView : To present the list of students, # of hours completed and # of credits registered we used the efficient recyclerview.
LiveData & Room Database : We are also using LiveData to update & observe any changes in the number of hours completed by students and update it to local databases using Room. 


Further development:
The app has so far been built by novice Android developers. As a result, the code is not totally optimised. So the next step is to involve senior developer in this project for guidance. Also we have push the application to Firebase and give writing access to only coordinators and reading access to all the students.
The app is currently in the Alpha testing phase with IIT Bhilai with a limited no. of users (mostly coordinators), You can access the app : https://github.com/ShivamMalpani/Android_Study_Jams_IITBhilai

Once the app is fully tested and functional in IIT Bhilai institute, we intend to approach other IITs and IIMs where NSO activities take place and present this app idea. 

Screenshots of application:
On first screen we can create new user and update data regarding number of hours of all users. On second screen we have to input the number of credits registered for given semester.

![Screen_1](https://user-images.githubusercontent.com/86108827/148745054-80154c92-ba49-41d8-8b63-2a9cee3b0213.jpg)![Screen1_update](https://user-images.githubusercontent.com/86108827/148745062-2e32d577-625e-47a3-8d23-6a16305dbc4b.jpg)![Screen_2](https://user-images.githubusercontent.com/86108827/148745144-15574869-9678-43a5-bf6a-f83303322d0c.jpg)![Screen_2_update](https://user-images.githubusercontent.com/86108827/148745148-fabee188-b116-44a3-a9a6-2f044f58ef39.jpg)



