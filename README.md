# SNI Internship - Week 4: Basic Servlet App

## Star Wars API

This basic application does not have a database.
Application consumes [SWAPI](https://swapi.dev/) (Star Wars API) to retrieve the data which this application presents.
Due to limitations of the API user can only make GET request.
Although API had *six* endpoints; this application consumes *two* of them for the simplicity purposes.

## Allowed HTTP request(s):
- **GET**: Get a resource or list of resources

## References:
- ### Person:
    > Person is a character in Star Wars universe.
    - **Endpoints**:
      - <mark>/people/</mark> -- get all the people resources
      - <mark>/people/:id</mark> -- finds a specific persons resources
    - **Attributes**:
      - <mark>name</mark> string -- The name of this person.
      - <mark>birth_year</mark> string -- The birth year of the person, using the in-universe standard of BBY or ABY - Before the Battle of Yavin or After the Battle of Yavin. The Battle of Yavin is a battle that occurs at the end of Star Wars episode IV: A New Hope.
      - <mark>eye_color</mark> string -- The eye color of this person. Will be "unknown" if not known or "n/a" if the person does not have an eye.
      - <mark>gender</mark> string -- The gender of this person. Either "Male", "Female" or "unknown", "n/a" if the person does not have a gender.
      - <mark>hair_color</mark> string -- The hair color of this person. Will be "unknown" if not known or "n/a" if the person does not have hair.
      - <mark>height</mark> string -- The height of the person in centimeters.
      - <mark>mass</mark> string -- The mass of the person in kilograms.
      - <mark>skin_color</mark> string -- The skin color of this person.
      - <mark>homeworld</mark> string -- The URL of a planet resource, a planet that this person was born on or inhabits.
      - <mark>url</mark> string -- the hypermedia URL of this resource.
      - <mark>created</mark> string -- the ISO 8601 date format of the time that this resource was created.
      - <mark>edited</mark> string -- the ISO 8601 date format of the time that this resource was edited.
- ### Planet:
  > A Planet resource is a large mass, planet or planetoid in the Star Wars Universe, at the time of 0 ABY.
    - **Endpoints**:
        - <mark>/planets/</mark> -- get all the planets resources
        - <mark>/planets/:id</mark> -- finds a specific planets resources
    - **Attributes**:
      - <mark>name</mark> string -- The name of this planet.
      - <mark>diameter</mark> string -- The diameter of this planet in kilometers.
      - <mark>rotation_period</mark> string -- The number of standard hours it takes for this planet to complete a single rotation on its axis.
      - <mark>orbital_period</mark> string -- The number of standard days it takes for this planet to complete a single orbit of its local star.
      - <mark>gravity</mark> string -- A number denoting the gravity of this planet, where "1" is normal or 1 standard G. "2" is twice or 2 standard Gs. "0.5" is half or 0.5 standard Gs.
      - <mark>population</mark> string -- The average population of sentient beings inhabiting this planet.
      - <mark>climate</mark> string -- The climate of this planet. Comma separated if diverse.
      - <mark>terrain</mark> string -- The terrain of this planet. Comma separated if diverse.
      - <mark>surface_water</mark> string -- The percentage of the planet surface that is naturally occurring water or bodies of water.
      - <mark>url</mark> string -- the hypermedia URL of this resource.
      - <mark>created</mark> string -- the ISO 8601 date format of the time that this resource was created.
      - <mark>edited</mark> string -- the ISO 8601 date format of the time that this resource was edited.

## Packages:
| Package                         | Description                               |
|---------------------------------|-------------------------------------------|
| net.sni.servletbasic.context    | Provides context classes                  |
| net.sni.servletbasic.controller | Provides servlets                         |
| net.sni.servletbasic.dto        | Defines DTOs                              |
| net.sni.servletbasic.entity     | Defines Entities                          |
| net.sni.servletbasic.service    | Provides services                         |
| net.sni.servletbasic.util       | Provides custom deserializers for Jackson |
