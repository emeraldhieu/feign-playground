# Feign Playground

A playground where OpenFeign-related features are experienced.

+ OpenFeign
  + `feign.Headers` 
  + `feign.RequestLine`
  + `feign.RequestInterceptor`
+ Spring Cloud OpenFeign
  + `org.springframework.cloud.openfeign.FeignClient`
  + `org.springframework.cloud.openfeign.FallbackFactory`
+ Spring Retry
  + `org.springframework.retry.annotation.Retryable`
  + `org.springframework.retry.annotation.Backoff` 
  + `org.springframework.retry.annotation.Recover`
+ Spring Cloud Circuit Breaker
  + `org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory`
+ Resilience4j
  + `io.github.resilience4j.retry.annotation.Retry`
  + `io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker`

## User

### 1) List users

```
GET /users
```

#### Example

##### List users

```sh
curl --location --request GET 'http://localhost:8080/users' \
```

##### Response

```json
[
  {
    "id": "1",
    "firstName": "Terry",
    "lastName": "Medhurst",
    "age": 50,
    "username": "atuny0",
    "password": "9uQFF1Lh"
  },
  {
    "id": "2",
    "firstName": "Sheldon",
    "lastName": "Quigley",
    "age": 28,
    "username": "hbingley1",
    "password": "CQutx25i8r"
  }
]
```

## Auth

### 1) Login

```
GET /auth/login
```

#### Request body (required)

| Parameter  | Description                              | Type   |
|------------|------------------------------------------|--------|
| `username` | Username received from the `/auth/login` | String |
| `password` | Password received from the `/auth/login` | String |

## Post

### 1) List posts

```
GET /posts
```

#### Example

##### List posts

```sh
curl --location --request GET 'http://localhost:8080/posts' \
```

##### Response

```json
[
  {
    "id": 1,
    "title": "His mother had always taught him",
    "body": "His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.",
    "userId": 9,
    "tags": [
      "history",
      "american",
      "crime"
    ],
    "reactions": 2
  },
  {
    "id": 2,
    "title": "He was an expert but not in a discipline",
    "body": "He was an expert but not in a discipline that anyone could fully appreciate. He knew how to hold the cone just right so that the soft server ice-cream fell into it at the precise angle to form a perfect cone each and every time. It had taken years to perfect and he could now do it without even putting any thought behind it.",
    "userId": 13,
    "tags": [
      "french",
      "fiction",
      "english"
    ],
    "reactions": 2
  }
]
```

### 2) Create a post

```
POST /posts
```

#### Header (required)

| HTTP Header     | Description                       |
|-----------------|-----------------------------------|
| `Authorization` | Token received from `/auth/login` |

#### Request body (required)

| Parameter | Description | Type   |
|-----------|-------------|--------|
| `title`   | Title       | String |
| `userId`  | User ID     | String |
| `body`    | Body        | String |

#### Example

##### Create a post

```sh
curl --location --request POST 'http://localhost:8080/posts' \
--header 'Authorization: <token>' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Hello world!",
    "userId": "1",
    "body": "Hello world, I'\''m a software engineer!"
}'
```

##### Response

```json
{
  "id": 151,
  "title": "Hello world!",
  "body": "Hello world, I'm a software engineer!",
  "userId": 1,
  "tags": null,
  "reactions": 0
}
```

##### List posts

```sh
curl --location --request GET 'http://localhost:8080/posts' \
```

##### Response

```json
{
  "id": 151,
  "title": "Hello world!",
  "body": "Hello world, I'm a software engineer!",
  "userId": 1,
  "tags": null,
  "reactions": 0
}
```