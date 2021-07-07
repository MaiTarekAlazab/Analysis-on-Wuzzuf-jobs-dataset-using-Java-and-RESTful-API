# Analysis on Wuzzuf jobs dataset using Java and RESTful API
## Motivation
This project is an assessment in a Java course offered in the AI program by ITI (Information Technology Institute - Egypt). 

## Goals
The goal is to analyze Wuzzuf Jobs dataset in kaggle: https://www.kaggle.com/omarhanyy/wuzzuf-jobs and get some insights after cleaning the data. Then offering these insights to a client through a restful service client architecture. 

### About the dataset (Description in kaggle):
WUZZUF is the #1 Career Destination in Egypt serving more than 500,000 job seekers each month and more than 15,000 of Egypt's top companies actively posting jobs and searching for talent. This dataset includes 4380 Jobs with attributes such as Title, Company, Location, etc. 

### The insights include:
   1. Displaying structure and summary of the data.
   2. Counting the jobs for each company and display that in order (What are the most demanding companies for jobs?)
   3. Finding out What are it the most popular job titles? 
   4. Finding out the most popular areas?
   5. Printing skills one by one and how many each repeated and order the output to find out the most important skills required?
   6. Generating graphs (bar chart, pie chart, etc) that displays the above insights.
 
[Sample Output](Client/src/main/resources/images/pie.jpg)
There is two options for displaying the project information 

1. First run the service then through web page, try these links according to the data you want:
   - Structre of the Data 
     * http://localhost:8080/data/structure
   - Summary of the Data 
        * http://localhost:8080/data/summary
   
   - Job
        * http://localhost:8080/data/job
   - most popular titles
        * http://localhost:8080/data/titles
   - most popular Areas
        * http://localhost:8080/data/Areas
   - Pie Chart
        *  http://localhost:8080/data/pie
   - Bar Chart 1
        * http://localhost:8080/data/bar1
   - Bar Chart 2
        * http://localhost:8080/data/bar2
2. First run the service then through web page, then the client it will display all the information for you 


