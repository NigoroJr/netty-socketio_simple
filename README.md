# Simple program using netty-socketio
## Description
This repository contains a very simple program that makes use of
[netty-socketio](https://github.com/mrniko/netty-socketio). When a client
accesses the web page, three buttons are shown. Each button sends its own id
(of the element) and a randomly generated ID number to the server.

## Prerequisites
The version in parentheses was used for testing.

* Apache Maven (3.0.4)
* JDK (1.7.0_79)
* netty-socketio (1.7.7)
* A web server to host the `index.html`
    - Apache 2.2.29 was used for testing
    - `file://` can be used without a web server

## How?
1. Clone this repository with:
    ```
    git clone https://github.com/NigoroJr/netty-socketio_simple
    ```
2. Go into the cloned repository.
3. Copy or symlink `index.html` in the `client` directory to where it can be
   accessed from a browser.
4. Go into the `server` directory.
5. Run `mvn clean install`
6. Run `mvn exec:java`
7. Open `index.html` from your browser.
    - If you're not using a web server, you can do
      `file:///path/to/your/index.html`

## Modifying
See also: [License](#license)

### General notes
It's good to know the basics of Apache Maven. The official tutorial is
[here](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

The API for netty-socketio 1.6.1 can be found at:
http://javadox.com/com.corundumstudio.socketio/netty-socketio/1.6.1/allclasses-noframe.html

Also, netty-socketio has a good demo project at
https://github.com/mrniko/netty-socketio-demo

### Some gotchas
Here are some tips that might help.

#### `No 'Access-Control-Allow-Origin' header is present on the requested resource`
Pay *extra* attention to which version of `netty-socketio` you're using. You
can check the version being used in `server/pom.xml` in `dependencies ->
dependency -> version`. This error is fixed after
[1.7.6](https://github.com/mrniko/netty-socketio#17-jan-2015---version-176-released),
so specify a release after that.

#### Packages
Make sure that when you change the source code location, you also need to
update the package names.

#### Recompile before `exec:java`
You need to `mvn compile` before doing `mvn exec:java` if you update the
source code.

#### No constructors are allowed!!
Do **NOT** implement constructors in the container classes. You can see that
no data will be received in the server if you include the commented-out
constructors in the Player and/or Coordinates class.

## Author
Naoki Mizuno

## License
Same as netty-socketio (Apache License 2.0).
