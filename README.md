
# Library example of book management with CRUD

This REST API uses a list to manage CRUD operations, so feel free to test the endpoints as you like.
It already comes with two items, so IDS 1 and 2 are already taken, so if you are going to add a book, start from number three.

## Authors

- [Diego Muñoz @dbonomelli](https://github.com/dbonomelli)


## API Reference

#### Get all books

##### Gets all books from list

```http
  GET /api/books
```

#### Get book

```http
  GET /api/books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of book to fetch |

#### Save book

```http
  POST /api/books
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Id of book to save |
| `name`      | `string` | Name of the book to save |
| `author`      | `string` | Author of the book to save |
| `year`      | `string` | Year of the book to save |
| `edition`      | `string` | Edition of the book to save |
| `isbn`      | `string` | Isbn of the book to save |
| `genre`      | `string` | Genre of the book to save |
| `isLent`      | `boolean` | Is the book lent or not |

#### Update book
```http
  PUT /api/books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| path variable |
| `id`      | `string` | Id of book to save |
|body|
| `id`      | `string` | Id of book to edit |
| `name`      | `string` | Name of the book to edit |
| `author`      | `string` | Author of the book to edit |
| `year`      | `string` | Year of the book to edit |
| `edition`      | `string` | Edition of the book to edit |
| `isbn`      | `string` | Isbn of the book to edit |
| `genre`      | `string` | Genre of the book to edit |
| `isLent`      | `boolean` | Is the book lent or not |

#### Lend book

```http
  POST /api/books/lendBook/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of book to lend |

#### Delete book

```http
  DELETE /api/books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of book to delete |

## Run Locally

Clone the project

```bash
  git clone https://github.com/dbonomelli/citi-tech-project
```

Run the project

```bash
  Configure your application to run the main SpringBoot Application
```

This project runs on port 8080, so the route is:
http://localhost:8080.

This project also comes with SwaggerUI built into it, for testing on a browser, please visit: http://localhost:8080/swagger-ui/index.html.

Also provided in the repository, in the resources folder, is a Postman Collection for you to import and try it out.