# Angular Module #

## Objectives ##

It's a simple front-end application for communicate with email module

## Setting Up Environment ##

### Development ###

#### Download and install docker-ce ####

* Linux: https://www.digitalocean.com/community/tutorials/como-instalar-e-usar-o-docker-no-ubuntu-16-04-pt

#### Download and install docker-compose ####

https://docs.docker.com/compose/install/#install-compose

#### Set up environment variables! ####

Access the file "src/environments/environment.ts" and add the variables with the ips of the Authentication and Core modules.

Example:

```typescript
export const environment = {
  production: false,
  my_url: 'http://localhost:8080'
};
```

#### Composing up! ####

In your application directory, run:

```bash
docker-compose up -d
```

#### Composing down :( ####

To shut down the application, enter your application directory and run:

```bash
docker-compose down
```
