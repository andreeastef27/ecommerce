CREATE TABLE users (
                        user_id INT GENERATED ALWAYS AS IDENTITY
                                                        PRIMARY KEY
                                                        NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        surname VARCHAR(100) NOT NULL,
                        birth_date DATE NOT NULL,
                        email VARCHAR(100) NOT NULL,
                        address VARCHAR(200) NOT NULL,
                        phone_number VARCHAR(20) NOT NULL,
                        username VARCHAR(100) NOT NULL,
                        password VARCHAR(100) NOT NULL
);

CREATE TABLE products (
        product_id INT GENERATED ALWAYS AS IDENTITY
                                           PRIMARY KEY
                                           NOT NULL,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(200) NOT NULL,
        base_price FLOAT NOT NULL
);

CREATE TABLE customization_options (
    option_id INT GENERATED ALWAYS AS IDENTITY
                                      PRIMARY KEY
                                      NOT NULL,
    name VARCHAR(100) NOT NULL,
    additional_price FLOAT NOT NULL
);

CREATE TABLE cart_items (
    cart_id INT GENERATED ALWAYS AS IDENTITY
                                    PRIMARY KEY
                                    NOT NULL,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);