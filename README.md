![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/cover.png)

Overview
--------

A [Play application](http://www.playframework.com/) that provides an encyclopedia of surfers.

This system uses a login system for the administrator whose values are stored in the environmental variables.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/Login.png)

This web application uses a back end database using SQL to store a database of surfers. It holds bio information and pictures of the surfers.
It also allows the administrator to edit and delete surfers to maintain accuracy of the database.

There are currently 32 surfers in the database 11 female 11 males and 10 groms. 
The carousel seen in the top image will be comprised of three random surfers from the database.

It also has a random surfer feature where it takes you to a random surfers page if you want to find out about someone new.

This is the ER diagram of relationships within the database.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/ERD-surferpedia.png)


Installation
------------

Download the zip file, unzip, cd into the directory, invoke the Play console and execute run command to see the application at http://localhost:9000.
Or visit the cloudbees at http://surferpedia.jortal.cloudbees.net/ but if you use the local host you have to initialize the admin email and password
in the environmental variables.(see the application.conf files).

Usage
-----

Use the navbars search function to look for and get information regarding the different surfers. The way the search works is if there is no 
input in the fields it will assume all values otherwise it will find the conditions and sort the surfers in order.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/FrontPage.png)

Use the "New" link to add a new surfer to Surferpedia.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/new1.png)

On the individual surfer pages, use the edit link to edit the surfer's information or the delete link to remove the surfer from the database.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/Surfer-Page.png)

On the Update page for the administrator he/she can see the changes that have been made to the database along with a timestamp and action.
![screenshot](https://raw.github.com/jortal/Surferpedia/milestone-3/doc/Update.png)

Credits
-------

Thanks to ICS 314, Fall 2013