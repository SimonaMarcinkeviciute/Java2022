CREATE TABLE PRODUCTS (
    id VARCHAR(36) NOT NULL primary key,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(450) NOT NULL,
    category VARCHAR(50) NOT NULL,
    quantity INTEGER NOT NULL,
    price DECIMAL(20,2) NOT NULL
);