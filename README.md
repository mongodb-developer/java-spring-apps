# Notice: Repository Deprecation
This repository is deprecated and no longer actively maintained. It contains outdated code examples or practices that do not align with current MongoDB best practices. While the repository remains accessible for reference purposes, we strongly discourage its use in production environments.
Users should be aware that this repository will not receive any further updates, bug fixes, or security patches. This code may expose you to security vulnerabilities, compatibility issues with current MongoDB versions, and potential performance problems. Any implementation based on this repository is at the user's own risk.
For up-to-date resources, please refer to the [MongoDB Developer Center](https://mongodb.com/developer).


# java-spring-apps
Hello! Below is an example MongoDB Application using Java and Spring for beginners.
This simple application demonstrates basic CRUD operations in MongoDB via a book app - you can add a book, edit a book, delete a book. 

# Beginner Java/Spring/MongoDB Web App
## Requirements
1. MongoDB - recommend version 6.0
2. Java 11
3. Maven - https://maven.apache.org/install.html
4. IDE - Instructions are for IntelliJ specifically

## Installation Instructions
1. Open IntelliJ
2. File -> New Project from Existing Sources -> Choose the directory of this project
3. Once IntelliJ is done setting up the project, look for JavaSpringMongodbApplication. It should be under src/main/java. 
4. Right click that file, click "Run JavaSpring..."
5. Once up, go to http://localhost:8080/index
6. You need to have a mongod environment running locally on port 27017. If needed, host and port can be specified in application.properties

## How to use the web app?
1. The index page looks like this if there are no books yet
<img width="589" alt="image" src="https://user-images.githubusercontent.com/4265016/182075290-bdc5bdf4-e18e-43c0-9ef3-9657dc66b955.png">

2. Click the + button below to start adding a book. You will be redirected to the add book form
<img width="569" alt="image" src="https://user-images.githubusercontent.com/4265016/182075446-c017233b-9b24-4375-af45-f113fab1cee0.png">

3. Populate the form then click "Add Book". If successful, you will be redirected to the index page. You should be able to see the newly added book in the list.
<img width="568" alt="image" src="https://user-images.githubusercontent.com/4265016/182075542-8ec85b64-aeca-4778-9f29-a15f1a95f384.png">

4. To edit the book, click the pencil icon. To delete, click the trash icon.

5. To search for books, use the search form in the index page. This will search for the title of the book that starts with the keyword you enter or the author of the book. For the author, it will do an exact match.

    5.1. See below the form when there is no search
        <img width="566" alt="image" src="https://user-images.githubusercontent.com/4265016/182075969-83f4b361-5c70-4ec8-89e0-8b5e5433ba34.png">

    5.2. Once we do a search, the UI looks like so:
        
    <img width="556" alt="image" src="https://user-images.githubusercontent.com/4265016/182076036-63613faf-1ea0-43b5-8a43-72db0080b62f.png">
