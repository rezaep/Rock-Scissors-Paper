# Rock-Scissors-Paper [![Build Status](https://travis-ci.com/rezaep/Rock-Scissors-Paper.svg?branch=master)](https://travis-ci.com/rezaep/Rock-Scissors-Paper) [![Coverage Status](https://coveralls.io/repos/github/rezaep/Rock-Scissors-Paper/badge.svg?branch=master)](https://coveralls.io/github/rezaep/Rock-Scissors-Paper?branch=master)
A repository containing Rock-Scissor-Paper project.

>Rock-scissors-paper is a zero sum hand game usually played between two people, in which each player simultaneously forms one of three shapes with an outstretched hand. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to run the project 

```
Java Development Kit (JDK 8+)
Maven
Docker (if you want to run project using Docker image)
```

### Installing

```
Clone the repository
git clone https://github.com/rezaep/Rock-Scissors-Paper.git
```

```
Use Maven build tool to build the project. This command runs tests and build a Jar file.
mvn clean test package
```

```
Run jar file using Java command.
java -jar target/rock-scissors-paper-1.0-SNAPSHOT.jar
```
The example output will be:

```
Player A wins 36 of 100 games
Player B wins 32 of 100 games
Tie: 32 of 100 games
Winner is: Player A (36 to 32 wins)
```

## Running the tests

In order to run automated tests use below command.

```
mvn clean test
```

## Deployment

To package  the Jar file inside a Docker image use following commands.

```
mvn clean test package
docker build -t image:tag . (e.g. rezaep/rock-scissors-paper:latest)
```

## Authors

* **Reza Ebrahimpour** - [Github](https://github.com/rezaep)

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details

