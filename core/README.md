# Email Module Core #

## Objectives ##

It's a simple service for send emails

## Setting Up Environment ##

### Development ###

#### Download and install docker-ce ####

* Linux: https://www.digitalocean.com/community/tutorials/como-instalar-e-usar-o-docker-no-ubuntu-16-04-pt

#### Download and install docker-compose ####

https://docs.docker.com/compose/install/#install-compose

#### Setting Up Database Connection ####

If needed, open `src/main/resources/application.properties` and change environment variables.

#### Composing up! ####

In your application directory, run:

```bash
docker-compose up -d
```

Unfortunatelly, you'll need to run this command every time you make a change, so Java can compile and docker can recreate Tomcat's service :(

So, don't forget to compose down, compose up every time you make changes!

#### Composing down :( ####

To shut down the application, enter your application directory and run:

```bash
docker-compose down
```
